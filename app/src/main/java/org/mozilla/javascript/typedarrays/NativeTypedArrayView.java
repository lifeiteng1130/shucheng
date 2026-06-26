package org.mozilla.javascript.typedarrays;

import j$.lang.Iterable;
import j$.time.a;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ExternalArrayData;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeArrayIterator;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Symbol;
import org.mozilla.javascript.SymbolKey;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.Wrapper;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeTypedArrayView<T> extends NativeArrayBufferView implements List<T>, RandomAccess, ExternalArrayData, j$.util.List {
    private static final int Id_BYTES_PER_ELEMENT = 5;
    private static final int Id_constructor = 1;
    private static final int Id_get = 3;
    private static final int Id_length = 4;
    private static final int Id_set = 4;
    private static final int Id_subarray = 5;
    private static final int Id_toString = 2;
    private static final int MAX_INSTANCE_ID = 5;
    public static final int MAX_PROTOTYPE_ID = 6;
    private static final int SymbolId_iterator = 6;
    private static final long serialVersionUID = -4963053773152251274L;
    public final int length;

    public NativeTypedArrayView() {
        this.length = 0;
    }

    private NativeTypedArrayView<T> js_constructor(Context context, Scriptable scriptable, Object[] objArr) {
        if (!NativeArrayBufferView.isArg(objArr, 0)) {
            return construct(new NativeArrayBuffer(), 0, 0);
        }
        Object obj = objArr[0];
        if (obj == null) {
            return construct(new NativeArrayBuffer(), 0, 0);
        }
        if ((obj instanceof Number) || (obj instanceof String)) {
            int int32 = ScriptRuntime.toInt32(obj);
            return construct(makeArrayBuffer(context, scriptable, int32), 0, int32);
        }
        if (obj instanceof NativeTypedArrayView) {
            NativeTypedArrayView nativeTypedArrayView = (NativeTypedArrayView) obj;
            NativeTypedArrayView<T> nativeTypedArrayViewConstruct = construct(makeArrayBuffer(context, scriptable, nativeTypedArrayView.length), 0, nativeTypedArrayView.length);
            while (int32 < nativeTypedArrayView.length) {
                nativeTypedArrayViewConstruct.js_set(int32, nativeTypedArrayView.js_get(int32));
                int32++;
            }
            return nativeTypedArrayViewConstruct;
        }
        if (obj instanceof NativeArrayBuffer) {
            NativeArrayBuffer nativeArrayBuffer = (NativeArrayBuffer) obj;
            int32 = NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0;
            int bytesPerElement = NativeArrayBufferView.isArg(objArr, 2) ? getBytesPerElement() * ScriptRuntime.toInt32(objArr[2]) : nativeArrayBuffer.getLength() - int32;
            if (int32 >= 0) {
                byte[] bArr = nativeArrayBuffer.buffer;
                if (int32 <= bArr.length) {
                    if (bytesPerElement < 0 || int32 + bytesPerElement > bArr.length) {
                        throw ScriptRuntime.rangeError("length out of range");
                    }
                    if (int32 % getBytesPerElement() != 0) {
                        throw ScriptRuntime.rangeError("offset must be a multiple of the byte size");
                    }
                    if (bytesPerElement % getBytesPerElement() == 0) {
                        return construct(nativeArrayBuffer, int32, bytesPerElement / getBytesPerElement());
                    }
                    throw ScriptRuntime.rangeError("offset and buffer must be a multiple of the byte size");
                }
            }
            throw ScriptRuntime.rangeError("offset out of range");
        }
        if (!(obj instanceof NativeArray)) {
            if (!ScriptRuntime.isArrayObject(obj)) {
                throw ScriptRuntime.constructError("Error", "invalid argument");
            }
            Object[] arrayElements = ScriptRuntime.getArrayElements((Scriptable) obj);
            NativeTypedArrayView<T> nativeTypedArrayViewConstruct2 = construct(makeArrayBuffer(context, scriptable, arrayElements.length), 0, arrayElements.length);
            while (int32 < arrayElements.length) {
                nativeTypedArrayViewConstruct2.js_set(int32, arrayElements[int32]);
                int32++;
            }
            return nativeTypedArrayViewConstruct2;
        }
        NativeArray nativeArray = (NativeArray) obj;
        NativeTypedArrayView<T> nativeTypedArrayViewConstruct3 = construct(makeArrayBuffer(context, scriptable, nativeArray.size()), 0, nativeArray.size());
        while (int32 < nativeArray.size()) {
            Object obj2 = nativeArray.get(int32, nativeArray);
            if (obj2 == Scriptable.NOT_FOUND || obj2 == Undefined.instance) {
                nativeTypedArrayViewConstruct3.js_set(int32, ScriptRuntime.NaNobj);
            } else if (obj2 instanceof Wrapper) {
                nativeTypedArrayViewConstruct3.js_set(int32, ((Wrapper) obj2).unwrap());
            } else {
                nativeTypedArrayViewConstruct3.js_set(int32, obj2);
            }
            int32++;
        }
        return nativeTypedArrayViewConstruct3;
    }

    private Object js_subarray(Context context, Scriptable scriptable, int i2, int i3) {
        if (i2 < 0) {
            i2 += this.length;
        }
        if (i3 < 0) {
            i3 += this.length;
        }
        int iMax = Math.max(0, i2);
        int iMax2 = Math.max(0, Math.min(this.length, i3) - iMax);
        return context.newObject(scriptable, getClassName(), new Object[]{this.arrayBuffer, Integer.valueOf(Math.min(getBytesPerElement() * iMax, this.arrayBuffer.getLength())), Integer.valueOf(iMax2)});
    }

    private NativeArrayBuffer makeArrayBuffer(Context context, Scriptable scriptable, int i2) {
        return (NativeArrayBuffer) context.newObject(scriptable, NativeArrayBuffer.CLASS_NAME, new Object[]{Double.valueOf(((double) i2) * ((double) getBytesPerElement()))});
    }

    private void setRange(NativeTypedArrayView<T> nativeTypedArrayView, int i2) {
        int i3 = this.length;
        if (i2 >= i3) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        int i4 = nativeTypedArrayView.length;
        if (i4 > i3 - i2) {
            throw ScriptRuntime.rangeError("source array too long");
        }
        int i5 = 0;
        if (nativeTypedArrayView.arrayBuffer != this.arrayBuffer) {
            while (i5 < nativeTypedArrayView.length) {
                js_set(i5 + i2, nativeTypedArrayView.js_get(i5));
                i5++;
            }
            return;
        }
        Object[] objArr = new Object[i4];
        for (int i6 = 0; i6 < nativeTypedArrayView.length; i6++) {
            objArr[i6] = nativeTypedArrayView.js_get(i6);
        }
        while (i5 < nativeTypedArrayView.length) {
            js_set(i5 + i2, objArr[i5]);
            i5++;
        }
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean checkIndex(int i2) {
        return i2 < 0 || i2 >= this.length;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract NativeTypedArrayView<T> construct(NativeArrayBuffer nativeArrayBuffer, int i2, int i3);

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i2) {
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            NativeTypedArrayView nativeTypedArrayView = (NativeTypedArrayView) obj;
            if (this.length != nativeTypedArrayView.length) {
                return false;
            }
            for (int i2 = 0; i2 < this.length; i2++) {
                if (!js_get(i2).equals(nativeTypedArrayView.js_get(i2))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getClassName())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        switch (iMethodId) {
            case 1:
                if (scriptable2 == null || context.getLanguageVersion() < 200) {
                    return js_constructor(context, scriptable, objArr);
                }
                throw ScriptRuntime.typeError1("msg.only.from.new", getClassName());
            case 2:
                NativeTypedArrayView<T> nativeTypedArrayViewRealThis = realThis(scriptable2, idFunctionObject);
                int arrayLength = nativeTypedArrayViewRealThis.getArrayLength();
                StringBuilder sb = new StringBuilder();
                if (arrayLength > 0) {
                    sb.append(ScriptRuntime.toString(nativeTypedArrayViewRealThis.js_get(0)));
                }
                for (int i2 = 1; i2 < arrayLength; i2++) {
                    sb.append(',');
                    sb.append(ScriptRuntime.toString(nativeTypedArrayViewRealThis.js_get(i2)));
                }
                return sb.toString();
            case 3:
                if (objArr.length > 0) {
                    return realThis(scriptable2, idFunctionObject).js_get(ScriptRuntime.toInt32(objArr[0]));
                }
                throw ScriptRuntime.constructError("Error", "invalid arguments");
            case 4:
                if (objArr.length > 0) {
                    NativeTypedArrayView<T> nativeTypedArrayViewRealThis2 = realThis(scriptable2, idFunctionObject);
                    if (objArr[0] instanceof NativeTypedArrayView) {
                        nativeTypedArrayViewRealThis2.setRange((NativeTypedArrayView) objArr[0], NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                        return Undefined.instance;
                    }
                    if (objArr[0] instanceof NativeArray) {
                        nativeTypedArrayViewRealThis2.setRange((NativeArray) objArr[0], NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                        return Undefined.instance;
                    }
                    if (objArr[0] instanceof Scriptable) {
                        return Undefined.instance;
                    }
                    if (NativeArrayBufferView.isArg(objArr, 2)) {
                        return nativeTypedArrayViewRealThis2.js_set(ScriptRuntime.toInt32(objArr[0]), objArr[1]);
                    }
                }
                throw ScriptRuntime.constructError("Error", "invalid arguments");
            case 5:
                if (objArr.length <= 0) {
                    throw ScriptRuntime.constructError("Error", "invalid arguments");
                }
                NativeTypedArrayView<T> nativeTypedArrayViewRealThis3 = realThis(scriptable2, idFunctionObject);
                return nativeTypedArrayViewRealThis3.js_subarray(context, scriptable, ScriptRuntime.toInt32(objArr[0]), NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : nativeTypedArrayViewRealThis3.length);
            case 6:
                return new NativeArrayIterator(scriptable, scriptable2, NativeArrayIterator.ARRAY_ITERATOR_TYPE.VALUES);
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.defineProperty("BYTES_PER_ELEMENT", ScriptRuntime.wrapInt(getBytesPerElement()), 7);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeArrayBufferView, org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        String str2;
        int i2;
        int length = str.length();
        if (length == 6) {
            i2 = 4;
            str2 = "length";
        } else if (length == 17) {
            str2 = "BYTES_PER_ELEMENT";
            i2 = 5;
        } else {
            str2 = null;
            i2 = 0;
        }
        int i3 = (str2 == null || str2 == str || str2.equals(str)) ? i2 : 0;
        return i3 == 0 ? super.findInstanceIdInfo(str) : i3 == 5 ? IdScriptableObject.instanceIdInfo(7, i3) : IdScriptableObject.instanceIdInfo(5, i3);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 6 : 0;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i2, Scriptable scriptable) {
        return js_get(i2);
    }

    @Override // org.mozilla.javascript.ExternalArrayData
    public Object getArrayElement(int i2) {
        return js_get(i2);
    }

    @Override // org.mozilla.javascript.ExternalArrayData
    public int getArrayLength() {
        return this.length;
    }

    public abstract int getBytesPerElement();

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        Object[] objArr = new Object[this.length];
        for (int i2 = 0; i2 < this.length; i2++) {
            objArr[i2] = Integer.valueOf(i2);
        }
        return objArr;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeArrayBufferView, org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i2) {
        return i2 != 4 ? i2 != 5 ? super.getInstanceIdName(i2) : "BYTES_PER_ELEMENT" : "length";
    }

    @Override // org.mozilla.javascript.typedarrays.NativeArrayBufferView, org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i2) {
        return i2 != 4 ? i2 != 5 ? super.getInstanceIdValue(i2) : ScriptRuntime.wrapInt(getBytesPerElement()) : ScriptRuntime.wrapInt(this.length);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeArrayBufferView, org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 5;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i2, Scriptable scriptable) {
        return !checkIndex(i2);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public int hashCode() {
        int iHashCode = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            iHashCode += js_get(i2).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List, j$.util.List
    public int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (obj.equals(js_get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        int i3;
        String str2;
        if (i2 == 6) {
            initPrototypeMethod(getClassName(), i2, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        if (i2 == 1) {
            str = "constructor";
            i3 = 3;
        } else if (i2 == 2) {
            str = "toString";
            i3 = 0;
        } else if (i2 != 3) {
            if (i2 == 4) {
                str2 = "set";
            } else {
                if (i2 != 5) {
                    throw new IllegalArgumentException(String.valueOf(i2));
                }
                str2 = "subarray";
            }
            str = str2;
            i3 = 2;
        } else {
            str = "get";
            i3 = 1;
        }
        initPrototypeMethod(getClassName(), i2, str, (String) null, i3);
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public Iterator<T> iterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    public abstract Object js_get(int i2);

    public abstract Object js_set(int i2, Object obj);

    @Override // java.util.List, j$.util.List
    public int lastIndexOf(Object obj) {
        for (int i2 = this.length - 1; i2 >= 0; i2--) {
            if (obj.equals(js_get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.List, j$.util.List
    public ListIterator<T> listIterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Q1.v(a.A(this), true);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i2, Scriptable scriptable, Object obj) {
        js_set(i2, obj);
    }

    public abstract NativeTypedArrayView<T> realThis(Scriptable scriptable, IdFunctionObject idFunctionObject);

    @Override // java.util.List, j$.util.List
    public T remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean retainAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.ExternalArrayData
    public void setArrayElement(int i2, Object obj) {
        js_set(i2, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public int size() {
        return this.length;
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        List.CC.$default$sort(this, comparator);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return Q1.v(a.A(this), false);
    }

    @Override // java.util.List, j$.util.List
    public java.util.List<T> subList(int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public Object[] toArray() {
        Object[] objArr = new Object[this.length];
        for (int i2 = 0; i2 < this.length; i2++) {
            objArr[i2] = js_get(i2);
        }
        return objArr;
    }

    @Override // java.util.List, j$.util.List
    public void add(int i2, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, j$.util.List
    public boolean addAll(int i2, java.util.Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i2;
        int length = str.length();
        if (length != 3) {
            if (length == 8) {
                char cCharAt = str.charAt(0);
                if (cCharAt == 's') {
                    str2 = "subarray";
                    i2 = 5;
                } else if (cCharAt == 't') {
                    str2 = "toString";
                    i2 = 2;
                }
            } else if (length == 11) {
                str2 = "constructor";
                i2 = 1;
            }
            if (str2 != null || str2 == str || str2.equals(str)) {
                return i2;
            }
            return 0;
        }
        char cCharAt2 = str.charAt(0);
        if (cCharAt2 == 'g') {
            if (str.charAt(2) == 't' && str.charAt(1) == 'e') {
                return 3;
            }
        } else if (cCharAt2 == 's' && str.charAt(2) == 't' && str.charAt(1) == 'e') {
            return 4;
        }
        str2 = null;
        i2 = 0;
        return str2 != null ? i2 : i2;
    }

    @Override // java.util.List, j$.util.List
    public ListIterator<T> listIterator(int i2) {
        if (checkIndex(i2)) {
            throw new IndexOutOfBoundsException();
        }
        return new NativeTypedArrayIterator(this, i2);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public NativeTypedArrayView(NativeArrayBuffer nativeArrayBuffer, int i2, int i3, int i4) {
        super(nativeArrayBuffer, i2, i4);
        this.length = i3;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public <U> U[] toArray(U[] uArr) {
        if (uArr.length < this.length) {
            uArr = (U[]) ((Object[]) Array.newInstance(uArr.getClass().getComponentType(), this.length));
        }
        for (int i2 = 0; i2 < this.length; i2++) {
            try {
                uArr[i2] = js_get(i2);
            } catch (ClassCastException unused) {
                throw new ArrayStoreException();
            }
        }
        return uArr;
    }

    private void setRange(NativeArray nativeArray, int i2) {
        if (i2 <= this.length) {
            if (nativeArray.size() + i2 <= this.length) {
                Iterator it = nativeArray.iterator();
                while (it.hasNext()) {
                    js_set(i2, it.next());
                    i2++;
                }
                return;
            }
            throw ScriptRuntime.rangeError("offset + length out of range");
        }
        throw ScriptRuntime.rangeError("offset out of range");
    }
}
