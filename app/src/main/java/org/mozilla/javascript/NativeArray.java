package org.mozilla.javascript;

import android.support.v4.media.session.PlaybackStateCompat;
import j$.lang.Iterable;
import j$.time.a;
import j$.util.Collection;
import j$.util.Comparator;
import j$.util.Iterator;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.function.UnaryOperator;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.mozilla.javascript.IteratorLikeIterable;
import org.mozilla.javascript.TopLevel;

/* JADX INFO: loaded from: classes3.dex */
public class NativeArray extends IdScriptableObject implements List, j$.util.List {
    private static final int ConstructorId_concat = -13;
    private static final int ConstructorId_every = -17;
    private static final int ConstructorId_filter = -18;
    private static final int ConstructorId_find = -22;
    private static final int ConstructorId_findIndex = -23;
    private static final int ConstructorId_forEach = -19;
    private static final int ConstructorId_from = -28;
    private static final int ConstructorId_indexOf = -15;
    private static final int ConstructorId_isArray = -26;
    private static final int ConstructorId_join = -5;
    private static final int ConstructorId_lastIndexOf = -16;
    private static final int ConstructorId_map = -20;
    private static final int ConstructorId_of = -27;
    private static final int ConstructorId_pop = -9;
    private static final int ConstructorId_push = -8;
    private static final int ConstructorId_reduce = -24;
    private static final int ConstructorId_reduceRight = -25;
    private static final int ConstructorId_reverse = -6;
    private static final int ConstructorId_shift = -10;
    private static final int ConstructorId_slice = -14;
    private static final int ConstructorId_some = -21;
    private static final int ConstructorId_sort = -7;
    private static final int ConstructorId_splice = -12;
    private static final int ConstructorId_unshift = -11;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double GROW_FACTOR = 1.5d;
    private static final int Id_concat = 13;
    private static final int Id_constructor = 1;
    private static final int Id_copyWithin = 31;
    private static final int Id_entries = 29;
    private static final int Id_every = 17;
    private static final int Id_fill = 26;
    private static final int Id_filter = 18;
    private static final int Id_find = 22;
    private static final int Id_findIndex = 23;
    private static final int Id_forEach = 19;
    private static final int Id_includes = 30;
    private static final int Id_indexOf = 15;
    private static final int Id_join = 5;
    private static final int Id_keys = 27;
    private static final int Id_lastIndexOf = 16;
    private static final int Id_length = 1;
    private static final int Id_map = 20;
    private static final int Id_pop = 9;
    private static final int Id_push = 8;
    private static final int Id_reduce = 24;
    private static final int Id_reduceRight = 25;
    private static final int Id_reverse = 6;
    private static final int Id_shift = 10;
    private static final int Id_slice = 14;
    private static final int Id_some = 21;
    private static final int Id_sort = 7;
    private static final int Id_splice = 12;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toSource = 4;
    private static final int Id_toString = 2;
    private static final int Id_unshift = 11;
    private static final int Id_values = 28;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PRE_GROW_SIZE = 1431655764;
    private static final int MAX_PROTOTYPE_ID = 32;
    private static final int SymbolId_iterator = 32;
    private static final long serialVersionUID = 7331366857676127338L;
    private Object[] dense;
    private boolean denseOnly;
    private long length;
    private int lengthAttr;
    private static final Object ARRAY_TAG = "Array";
    private static final Long NEGATIVE_ONE = -1L;
    private static final Comparator<Object> STRING_COMPARATOR = new StringLikeComparator();
    private static final Comparator<Object> DEFAULT_COMPARATOR = new ElementComparator();
    private static int maximumInitialCapacity = 10000;

    /* JADX INFO: renamed from: org.mozilla.javascript.NativeArray$1, reason: invalid class name */
    public static class AnonymousClass1 implements Comparator<Object>, j$.util.Comparator {
        public final /* synthetic */ Object[] val$cmpBuf;
        public final /* synthetic */ Context val$cx;
        public final /* synthetic */ Scriptable val$funThis;
        public final /* synthetic */ Callable val$jsCompareFunction;
        public final /* synthetic */ Scriptable val$scope;

        public AnonymousClass1(Object[] objArr, Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2) {
            this.val$cmpBuf = objArr;
            this.val$jsCompareFunction = callable;
            this.val$cx = context;
            this.val$scope = scriptable;
            this.val$funThis = scriptable2;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Object obj, Object obj2) {
            Object[] objArr = this.val$cmpBuf;
            objArr[0] = obj;
            objArr[1] = obj2;
            int iCompare = Double.compare(ScriptRuntime.toNumber(this.val$jsCompareFunction.call(this.val$cx, this.val$scope, this.val$funThis, objArr)), 0.0d);
            if (iCompare < 0) {
                return -1;
            }
            return iCompare > 0 ? 1 : 0;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(j$.util.function.Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(j$.util.function.Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* JADX INFO: renamed from: org.mozilla.javascript.NativeArray$2, reason: invalid class name */
    public class AnonymousClass2 implements ListIterator, Iterator {
        public int cursor;
        public final /* synthetic */ int val$len;
        public final /* synthetic */ int val$start;

        public AnonymousClass2(int i2, int i3) {
            this.val$start = i2;
            this.val$len = i3;
            this.cursor = i2;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.cursor < this.val$len;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.cursor > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public Object next() {
            int i2 = this.cursor;
            if (i2 == this.val$len) {
                throw new NoSuchElementException();
            }
            NativeArray nativeArray = NativeArray.this;
            this.cursor = i2 + 1;
            return nativeArray.get(i2);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.cursor;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            int i2 = this.cursor;
            if (i2 == 0) {
                throw new NoSuchElementException();
            }
            NativeArray nativeArray = NativeArray.this;
            int i3 = i2 - 1;
            this.cursor = i3;
            return nativeArray.get(i3);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.cursor - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class StringLikeComparator implements java.util.Comparator<Object>, Serializable, j$.util.Comparator {
        private static final long serialVersionUID = 5299017659728190979L;

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ScriptRuntime.toString(obj).compareTo(ScriptRuntime.toString(obj2));
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(j$.util.function.Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(j$.util.function.Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public NativeArray(long j2) {
        this.lengthAttr = 6;
        boolean z = j2 <= ((long) maximumInitialCapacity);
        this.denseOnly = z;
        if (z) {
            int i2 = (int) j2;
            Object[] objArr = new Object[i2 < 10 ? 10 : i2];
            this.dense = objArr;
            Arrays.fill(objArr, Scriptable.NOT_FOUND);
        }
        this.length = j2;
    }

    private static Scriptable callConstructorOrCreateArray(Context context, Scriptable scriptable, Scriptable scriptable2, long j2, boolean z) {
        Scriptable scriptableConstruct;
        if (scriptable2 instanceof Function) {
            try {
                scriptableConstruct = ((Function) scriptable2).construct(context, scriptable, (z || j2 > 0) ? new Object[]{Long.valueOf(j2)} : ScriptRuntime.emptyArgs);
            } catch (EcmaError e2) {
                if (!"TypeError".equals(e2.getName())) {
                    throw e2;
                }
                scriptableConstruct = null;
            }
        } else {
            scriptableConstruct = null;
        }
        if (scriptableConstruct == null) {
            return context.newArray(scriptable, j2 <= 2147483647L ? (int) j2 : 0);
        }
        return scriptableConstruct;
    }

    private static long concatSpreadArg(Context context, Scriptable scriptable, Scriptable scriptable2, long j2) {
        long lengthProperty = getLengthProperty(context, scriptable2, false);
        long j3 = lengthProperty + j2;
        if (j3 <= 2147483647L && (scriptable instanceof NativeArray)) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && (scriptable2 instanceof NativeArray)) {
                NativeArray nativeArray2 = (NativeArray) scriptable2;
                if (nativeArray2.denseOnly) {
                    nativeArray.ensureCapacity((int) j3);
                    System.arraycopy(nativeArray2.dense, 0, nativeArray.dense, (int) j2, (int) lengthProperty);
                    return j3;
                }
            }
        }
        long j4 = 0;
        while (j4 < lengthProperty) {
            Object rawElem = getRawElem(scriptable2, j4);
            if (rawElem != Scriptable.NOT_FOUND) {
                defineElem(context, scriptable, j2, rawElem);
            }
            j4++;
            j2++;
        }
        return j3;
    }

    private ScriptableObject defaultIndexPropertyDescriptor(Object obj) {
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, parentScope, TopLevel.Builtins.Object);
        nativeObject.defineProperty(ES6Iterator.VALUE_PROPERTY, obj, 0);
        Boolean bool = Boolean.TRUE;
        nativeObject.defineProperty("writable", bool, 0);
        nativeObject.defineProperty("enumerable", bool, 0);
        nativeObject.defineProperty("configurable", bool, 0);
        return nativeObject;
    }

    private static void defineElem(Context context, Scriptable scriptable, long j2, Object obj) {
        if (j2 > 2147483647L) {
            scriptable.put(Long.toString(j2), scriptable, obj);
        } else {
            scriptable.put((int) j2, scriptable, obj);
        }
    }

    private static void deleteElem(Scriptable scriptable, long j2) {
        int i2 = (int) j2;
        if (i2 == j2) {
            scriptable.delete(i2);
        } else {
            scriptable.delete(Long.toString(j2));
        }
    }

    private static long doConcat(Context context, Scriptable scriptable, Scriptable scriptable2, Object obj, long j2) {
        if (isConcatSpreadable(context, scriptable, obj)) {
            return concatSpreadArg(context, scriptable2, (Scriptable) obj, j2);
        }
        defineElem(context, scriptable2, j2, obj);
        return j2 + 1;
    }

    private boolean ensureCapacity(int i2) {
        Object[] objArr = this.dense;
        if (i2 <= objArr.length) {
            return true;
        }
        if (i2 > MAX_PRE_GROW_SIZE) {
            this.denseOnly = false;
            return false;
        }
        int iMax = Math.max(i2, (int) (((double) objArr.length) * GROW_FACTOR));
        Object[] objArr2 = new Object[iMax];
        Object[] objArr3 = this.dense;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        Arrays.fill(objArr2, this.dense.length, iMax, Scriptable.NOT_FOUND);
        this.dense = objArr2;
        return true;
    }

    private static Object getElem(Context context, Scriptable scriptable, long j2) {
        Object rawElem = getRawElem(scriptable, j2);
        return rawElem != Scriptable.NOT_FOUND ? rawElem : Undefined.instance;
    }

    public static long getLengthProperty(Context context, Scriptable scriptable, boolean z) {
        if (scriptable instanceof NativeString) {
            return ((NativeString) scriptable).getLength();
        }
        if (scriptable instanceof NativeArray) {
            return ((NativeArray) scriptable).getLength();
        }
        Object property = ScriptableObject.getProperty(scriptable, "length");
        if (property == Scriptable.NOT_FOUND) {
            return 0L;
        }
        double number = ScriptRuntime.toNumber(property);
        if (number > 9.007199254740991E15d) {
            if (z) {
                throw ScriptRuntime.rangeError(ScriptRuntime.getMessage0("msg.arraylength.bad"));
            }
            return 2147483647L;
        }
        if (number < 0.0d) {
            return 0L;
        }
        return ScriptRuntime.toUint32(property);
    }

    public static int getMaximumInitialCapacity() {
        return maximumInitialCapacity;
    }

    private static Object getRawElem(Scriptable scriptable, long j2) {
        return j2 > 2147483647L ? ScriptableObject.getProperty(scriptable, Long.toString(j2)) : ScriptableObject.getProperty(scriptable, (int) j2);
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeArray(0L).exportAsJSClass(32, scriptable, z);
    }

    private static boolean isConcatSpreadable(Context context, Scriptable scriptable, Object obj) {
        Object property;
        if ((obj instanceof Scriptable) && (property = ScriptableObject.getProperty((Scriptable) obj, SymbolKey.IS_CONCAT_SPREADABLE)) != Scriptable.NOT_FOUND && !Undefined.isUndefined(property)) {
            return ScriptRuntime.toBoolean(property);
        }
        if (context.getLanguageVersion() >= 200 || !ScriptRuntime.instanceOf(obj, ScriptRuntime.getExistingCtor(context, scriptable, "Array"), context)) {
            return js_isArray(obj);
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object iterativeMethod(org.mozilla.javascript.Context r23, org.mozilla.javascript.IdFunctionObject r24, org.mozilla.javascript.Scriptable r25, org.mozilla.javascript.Scriptable r26, java.lang.Object[] r27) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.iterativeMethod(org.mozilla.javascript.Context, org.mozilla.javascript.IdFunctionObject, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    private static Object jsConstructor(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length == 0) {
            return new NativeArray(0L);
        }
        if (context.getLanguageVersion() == 120) {
            return new NativeArray(objArr);
        }
        Object obj = objArr[0];
        if (objArr.length > 1 || !(obj instanceof Number)) {
            return new NativeArray(objArr);
        }
        long uint32 = ScriptRuntime.toUint32(obj);
        if (uint32 == ((Number) obj).doubleValue()) {
            return new NativeArray(uint32);
        }
        throw ScriptRuntime.rangeError(ScriptRuntime.getMessage0("msg.arraylength.bad"));
    }

    private static Scriptable js_concat(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Scriptable scriptableNewArray = context.newArray(topLevelScope, 0);
        long jDoConcat = doConcat(context, topLevelScope, scriptableNewArray, object, 0L);
        for (Object obj : objArr) {
            jDoConcat = doConcat(context, topLevelScope, scriptableNewArray, obj, jDoConcat);
        }
        setLengthProperty(context, scriptableNewArray, jDoConcat);
        return scriptableNewArray;
    }

    private static Object js_copyWithin(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        int i2 = 1;
        long integer = (long) ScriptRuntime.toInteger(objArr.length >= 1 ? objArr[0] : Undefined.instance);
        long jMax = integer < 0 ? Math.max(integer + lengthProperty, 0L) : Math.min(integer, lengthProperty);
        long integer2 = (long) ScriptRuntime.toInteger(objArr.length >= 2 ? objArr[1] : Undefined.instance);
        long jMax2 = integer2 < 0 ? Math.max(integer2 + lengthProperty, 0L) : Math.min(integer2, lengthProperty);
        long integer3 = (objArr.length < 3 || Undefined.isUndefined(objArr[2])) ? lengthProperty : (long) ScriptRuntime.toInteger(objArr[2]);
        long jMin = Math.min((integer3 < 0 ? Math.max(integer3 + lengthProperty, 0L) : Math.min(integer3, lengthProperty)) - jMax2, lengthProperty - jMax);
        if (jMax2 < jMax) {
            long j2 = jMax2 + jMin;
            if (jMax < j2) {
                i2 = -1;
                jMax2 = j2 - 1;
                jMax = (jMax + jMin) - 1;
            }
        }
        if ((object instanceof NativeArray) && jMin <= 2147483647L) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                while (jMin > 0) {
                    Object[] objArr2 = nativeArray.dense;
                    objArr2[(int) jMax] = objArr2[(int) jMax2];
                    long j3 = i2;
                    jMax2 += j3;
                    jMax += j3;
                    jMin--;
                }
                return scriptable2;
            }
        }
        while (jMin > 0) {
            Object rawElem = getRawElem(object, jMax2);
            if (rawElem == Scriptable.NOT_FOUND || Undefined.isUndefined(rawElem)) {
                deleteElem(object, jMax);
            } else {
                setElem(context, object, jMax, rawElem);
            }
            long j4 = i2;
            jMax2 += j4;
            jMax += j4;
            jMin--;
        }
        return scriptable2;
    }

    private static Object js_fill(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long lengthProperty = getLengthProperty(context, ScriptRuntime.toObject(context, scriptable, scriptable2), false);
        long integer = objArr.length >= 2 ? (long) ScriptRuntime.toInteger(objArr[1]) : 0L;
        long integer2 = (objArr.length < 3 || Undefined.isUndefined(objArr[2])) ? lengthProperty : (long) ScriptRuntime.toInteger(objArr[2]);
        long jMax = integer2 < 0 ? Math.max(lengthProperty + integer2, 0L) : Math.min(integer2, lengthProperty);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        for (long jMax2 = integer < 0 ? Math.max(integer + lengthProperty, 0L) : Math.min(integer, lengthProperty); jMax2 < jMax; jMax2++) {
            setRawElem(context, scriptable2, jMax2, obj);
        }
        return scriptable2;
    }

    private static Object js_from(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(scriptable, objArr.length >= 1 ? objArr[0] : Undefined.instance);
        Object obj = objArr.length >= 2 ? objArr[1] : Undefined.instance;
        Scriptable scriptableEnsureScriptable = Undefined.SCRIPTABLE_UNDEFINED;
        boolean z = !Undefined.isUndefined(obj);
        Function function = null;
        if (z) {
            if (!(obj instanceof Function)) {
                throw ScriptRuntime.typeError0("msg.map.function.not");
            }
            function = (Function) obj;
            if (objArr.length >= 3) {
                scriptableEnsureScriptable = ScriptableObject.ensureScriptable(objArr[2]);
            }
        }
        Scriptable scriptable3 = scriptableEnsureScriptable;
        Function function2 = function;
        Object property = ScriptableObject.getProperty(object, SymbolKey.ITERATOR);
        if (!(object instanceof NativeArray) && property != Scriptable.NOT_FOUND && !Undefined.isUndefined(property)) {
            Object objCallIterator = ScriptRuntime.callIterator(object, context, scriptable);
            if (!Undefined.isUndefined(objCallIterator)) {
                Scriptable scriptableCallConstructorOrCreateArray = callConstructorOrCreateArray(context, scriptable, scriptable2, 0L, false);
                IteratorLikeIterable iteratorLikeIterable = new IteratorLikeIterable(context, scriptable, objCallIterator);
                try {
                    IteratorLikeIterable.Itr it = iteratorLikeIterable.iterator();
                    long j2 = 0;
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (z) {
                            next = function2.call(context, scriptable, scriptable3, new Object[]{next, Long.valueOf(j2)});
                        }
                        defineElem(context, scriptableCallConstructorOrCreateArray, j2, next);
                        j2++;
                    }
                    iteratorLikeIterable.close();
                    setLengthProperty(context, scriptableCallConstructorOrCreateArray, j2);
                    return scriptableCallConstructorOrCreateArray;
                } finally {
                }
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        Scriptable scriptableCallConstructorOrCreateArray2 = callConstructorOrCreateArray(context, scriptable, scriptable2, lengthProperty, true);
        for (long j3 = 0; j3 < lengthProperty; j3++) {
            Object rawElem = getRawElem(object, j3);
            if (rawElem != Scriptable.NOT_FOUND) {
                if (z) {
                    rawElem = function2.call(context, scriptable, scriptable3, new Object[]{rawElem, Long.valueOf(j3)});
                }
                defineElem(context, scriptableCallConstructorOrCreateArray2, j3, rawElem);
            }
        }
        setLengthProperty(context, scriptableCallConstructorOrCreateArray2, lengthProperty);
        return scriptableCallConstructorOrCreateArray2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d A[PHI: r9
  0x003d: PHI (r9v13 long) = (r9v12 long), (r9v15 long) binds: [B:14:0x0035, B:16:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Boolean js_includes(org.mozilla.javascript.Context r8, org.mozilla.javascript.Scriptable r9, org.mozilla.javascript.Scriptable r10, java.lang.Object[] r11) {
        /*
            int r0 = r11.length
            r1 = 0
            if (r0 <= 0) goto L7
            r0 = r11[r1]
            goto L9
        L7:
            java.lang.Object r0 = org.mozilla.javascript.Undefined.instance
        L9:
            org.mozilla.javascript.Scriptable r8 = org.mozilla.javascript.ScriptRuntime.toObject(r8, r9, r10)
            r9 = 1
            java.lang.Object[] r2 = new java.lang.Object[r9]
            java.lang.String r3 = "length"
            java.lang.Object r10 = org.mozilla.javascript.ScriptableObject.getProperty(r10, r3)
            r2[r1] = r10
            long r1 = org.mozilla.javascript.ScriptRuntime.toLength(r2, r1)
            r3 = 0
            int r10 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r10 != 0) goto L25
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            return r8
        L25:
            int r10 = r11.length
            r5 = 2
            r6 = 1
            if (r10 >= r5) goto L2c
            goto L47
        L2c:
            r9 = r11[r9]
            double r9 = org.mozilla.javascript.ScriptRuntime.toInteger(r9)
            long r9 = (long) r9
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 >= 0) goto L3d
            long r9 = r9 + r1
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 >= 0) goto L3d
            goto L3e
        L3d:
            r3 = r9
        L3e:
            long r9 = r1 - r6
            int r11 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r11 <= 0) goto L47
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            return r8
        L47:
            boolean r9 = r8 instanceof org.mozilla.javascript.NativeArray
            if (r9 == 0) goto L7d
            r9 = r8
            org.mozilla.javascript.NativeArray r9 = (org.mozilla.javascript.NativeArray) r9
            boolean r10 = r9.denseOnly
            if (r10 == 0) goto L7d
            org.mozilla.javascript.Scriptable r8 = r9.getPrototype()
            int r10 = (int) r3
        L57:
            long r3 = (long) r10
            int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r11 >= 0) goto L7a
            java.lang.Object[] r11 = r9.dense
            r11 = r11[r10]
            java.lang.Object r3 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r11 != r3) goto L6a
            if (r8 == 0) goto L6a
            java.lang.Object r11 = org.mozilla.javascript.ScriptableObject.getProperty(r8, r10)
        L6a:
            if (r11 != r3) goto L6e
            java.lang.Object r11 = org.mozilla.javascript.Undefined.instance
        L6e:
            boolean r11 = org.mozilla.javascript.ScriptRuntime.sameZero(r11, r0)
            if (r11 == 0) goto L77
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            return r8
        L77:
            int r10 = r10 + 1
            goto L57
        L7a:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            return r8
        L7d:
            int r9 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r9 >= 0) goto L96
            java.lang.Object r9 = getRawElem(r8, r3)
            java.lang.Object r10 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r9 != r10) goto L8b
            java.lang.Object r9 = org.mozilla.javascript.Undefined.instance
        L8b:
            boolean r9 = org.mozilla.javascript.ScriptRuntime.sameZero(r9, r0)
            if (r9 == 0) goto L94
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            return r8
        L94:
            long r3 = r3 + r6
            goto L7d
        L96:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.js_includes(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[PHI: r9
  0x002c: PHI (r9v9 long) = (r9v8 long), (r9v11 long) binds: [B:10:0x0024, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object js_indexOf(org.mozilla.javascript.Context r7, org.mozilla.javascript.Scriptable r8, org.mozilla.javascript.Scriptable r9, java.lang.Object[] r10) {
        /*
            int r0 = r10.length
            r1 = 0
            if (r0 <= 0) goto L7
            r0 = r10[r1]
            goto L9
        L7:
            java.lang.Object r0 = org.mozilla.javascript.Undefined.instance
        L9:
            org.mozilla.javascript.Scriptable r8 = org.mozilla.javascript.ScriptRuntime.toObject(r7, r8, r9)
            long r1 = getLengthProperty(r7, r8, r1)
            int r7 = r10.length
            r9 = 2
            r3 = 1
            r5 = 0
            if (r7 >= r9) goto L1a
            goto L36
        L1a:
            r7 = 1
            r7 = r10[r7]
            double r9 = org.mozilla.javascript.ScriptRuntime.toInteger(r7)
            long r9 = (long) r9
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 >= 0) goto L2c
            long r9 = r9 + r1
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 >= 0) goto L2c
            goto L2d
        L2c:
            r5 = r9
        L2d:
            long r9 = r1 - r3
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 <= 0) goto L36
            java.lang.Long r7 = org.mozilla.javascript.NativeArray.NEGATIVE_ONE
            return r7
        L36:
            boolean r7 = r8 instanceof org.mozilla.javascript.NativeArray
            if (r7 == 0) goto L6c
            r7 = r8
            org.mozilla.javascript.NativeArray r7 = (org.mozilla.javascript.NativeArray) r7
            boolean r9 = r7.denseOnly
            if (r9 == 0) goto L6c
            org.mozilla.javascript.Scriptable r8 = r7.getPrototype()
            int r9 = (int) r5
        L46:
            long r3 = (long) r9
            int r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r10 >= 0) goto L69
            java.lang.Object[] r10 = r7.dense
            r10 = r10[r9]
            java.lang.Object r5 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r10 != r5) goto L59
            if (r8 == 0) goto L59
            java.lang.Object r10 = org.mozilla.javascript.ScriptableObject.getProperty(r8, r9)
        L59:
            if (r10 == r5) goto L66
            boolean r10 = org.mozilla.javascript.ScriptRuntime.shallowEq(r10, r0)
            if (r10 == 0) goto L66
            java.lang.Long r7 = java.lang.Long.valueOf(r3)
            return r7
        L66:
            int r9 = r9 + 1
            goto L46
        L69:
            java.lang.Long r7 = org.mozilla.javascript.NativeArray.NEGATIVE_ONE
            return r7
        L6c:
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 >= 0) goto L85
            java.lang.Object r7 = getRawElem(r8, r5)
            java.lang.Object r9 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r7 == r9) goto L83
            boolean r7 = org.mozilla.javascript.ScriptRuntime.shallowEq(r7, r0)
            if (r7 == 0) goto L83
            java.lang.Long r7 = java.lang.Long.valueOf(r5)
            return r7
        L83:
            long r5 = r5 + r3
            goto L6c
        L85:
            java.lang.Long r7 = org.mozilla.javascript.NativeArray.NEGATIVE_ONE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.js_indexOf(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    private static boolean js_isArray(Object obj) {
        if (obj instanceof Scriptable) {
            return "Array".equals(((Scriptable) obj).getClassName());
        }
        return false;
    }

    private static String js_join(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i2 = 0;
        long lengthProperty = getLengthProperty(context, object, false);
        int i3 = (int) lengthProperty;
        if (lengthProperty != i3) {
            throw Context.reportRuntimeError1("msg.arraylength.too.big", String.valueOf(lengthProperty));
        }
        String string = (objArr.length < 1 || objArr[0] == Undefined.instance) ? "," : ScriptRuntime.toString(objArr[0]);
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                StringBuilder sb = new StringBuilder();
                while (i2 < i3) {
                    if (i2 != 0) {
                        sb.append(string);
                    }
                    Object[] objArr2 = nativeArray.dense;
                    if (i2 < objArr2.length && (obj = objArr2[i2]) != null && obj != Undefined.instance && obj != Scriptable.NOT_FOUND) {
                        sb.append(ScriptRuntime.toString(obj));
                    }
                    i2++;
                }
                return sb.toString();
            }
        }
        if (i3 == 0) {
            return "";
        }
        String[] strArr = new String[i3];
        int length = 0;
        for (int i4 = 0; i4 != i3; i4++) {
            Object elem = getElem(context, object, i4);
            if (elem != null && elem != Undefined.instance) {
                String string2 = ScriptRuntime.toString(elem);
                length += string2.length();
                strArr[i4] = string2;
            }
        }
        StringBuilder sb2 = new StringBuilder((string.length() * (i3 - 1)) + length);
        while (i2 != i3) {
            if (i2 != 0) {
                sb2.append(string);
            }
            String str = strArr[i2];
            if (str != null) {
                sb2.append(str);
            }
            i2++;
        }
        return sb2.toString();
    }

    private static Object js_lastIndexOf(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long j2;
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        if (objArr.length < 2) {
            j2 = lengthProperty - 1;
        } else {
            long integer = (long) ScriptRuntime.toInteger(objArr[1]);
            if (integer >= lengthProperty) {
                j2 = lengthProperty - 1;
            } else {
                if (integer < 0) {
                    integer += lengthProperty;
                }
                j2 = integer;
            }
            if (j2 < 0) {
                return NEGATIVE_ONE;
            }
        }
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                Scriptable prototype = nativeArray.getPrototype();
                for (int i2 = (int) j2; i2 >= 0; i2--) {
                    Object property = nativeArray.dense[i2];
                    Object obj2 = Scriptable.NOT_FOUND;
                    if (property == obj2 && prototype != null) {
                        property = ScriptableObject.getProperty(prototype, i2);
                    }
                    if (property != obj2 && ScriptRuntime.shallowEq(property, obj)) {
                        return Long.valueOf(i2);
                    }
                }
                return NEGATIVE_ONE;
            }
        }
        while (j2 >= 0) {
            Object rawElem = getRawElem(object, j2);
            if (rawElem != Scriptable.NOT_FOUND && ScriptRuntime.shallowEq(rawElem, obj)) {
                return Long.valueOf(j2);
            }
            j2--;
        }
        return NEGATIVE_ONE;
    }

    private static Object js_of(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable scriptableCallConstructorOrCreateArray = callConstructorOrCreateArray(context, scriptable, scriptable2, objArr.length, true);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            defineElem(context, scriptableCallConstructorOrCreateArray, i2, objArr[i2]);
        }
        setLengthProperty(context, scriptableCallConstructorOrCreateArray, objArr.length);
        return scriptableCallConstructorOrCreateArray;
    }

    private static Object js_pop(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object elem;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                long j2 = nativeArray.length;
                if (j2 > 0) {
                    long j3 = j2 - 1;
                    nativeArray.length = j3;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj = objArr2[(int) j3];
                    objArr2[(int) j3] = Scriptable.NOT_FOUND;
                    return obj;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        if (lengthProperty > 0) {
            lengthProperty--;
            elem = getElem(context, object, lengthProperty);
            deleteElem(object, lengthProperty);
        } else {
            elem = Undefined.instance;
        }
        setLengthProperty(context, object, lengthProperty);
        return elem;
    }

    private static Object js_push(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i2 = 0;
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                while (i2 < objArr.length) {
                    Object[] objArr2 = nativeArray.dense;
                    long j2 = nativeArray.length;
                    nativeArray.length = 1 + j2;
                    objArr2[(int) j2] = objArr[i2];
                    i2++;
                }
                return ScriptRuntime.wrapNumber(nativeArray.length);
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        while (i2 < objArr.length) {
            setElem(context, object, ((long) i2) + lengthProperty, objArr[i2]);
            i2++;
        }
        return context.getLanguageVersion() == 120 ? objArr.length == 0 ? Undefined.instance : objArr[objArr.length - 1] : setLengthProperty(context, object, lengthProperty + ((long) objArr.length));
    }

    private static Scriptable js_reverse(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i2 = 0;
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                for (int i3 = ((int) nativeArray.length) - 1; i2 < i3; i3--) {
                    Object[] objArr2 = nativeArray.dense;
                    Object obj = objArr2[i2];
                    objArr2[i2] = objArr2[i3];
                    objArr2[i3] = obj;
                    i2++;
                }
                return object;
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        long j2 = lengthProperty / 2;
        for (long j3 = 0; j3 < j2; j3++) {
            long j4 = (lengthProperty - j3) - 1;
            Object rawElem = getRawElem(object, j3);
            setRawElem(context, object, j3, getRawElem(object, j4));
            setRawElem(context, object, j4, rawElem);
        }
        return object;
    }

    private static Object js_shift(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object elem;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                long j2 = nativeArray.length;
                if (j2 > 0) {
                    long j3 = j2 - 1;
                    nativeArray.length = j3;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj = objArr2[0];
                    System.arraycopy(objArr2, 1, objArr2, 0, (int) j3);
                    Object[] objArr3 = nativeArray.dense;
                    int i2 = (int) nativeArray.length;
                    Object obj2 = Scriptable.NOT_FOUND;
                    objArr3[i2] = obj2;
                    return obj == obj2 ? Undefined.instance : obj;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        if (lengthProperty > 0) {
            lengthProperty--;
            elem = getElem(context, object, 0L);
            if (lengthProperty > 0) {
                for (long j4 = 1; j4 <= lengthProperty; j4++) {
                    setRawElem(context, object, j4 - 1, getRawElem(object, j4));
                }
            }
            deleteElem(object, lengthProperty);
        } else {
            elem = Undefined.instance;
        }
        setLengthProperty(context, object, lengthProperty);
        return elem;
    }

    private static Scriptable js_slice(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long sliceIndex;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        Scriptable scriptableNewArray = context.newArray(scriptable, 0);
        long lengthProperty = getLengthProperty(context, object, false);
        if (objArr.length == 0) {
            sliceIndex = 0;
        } else {
            sliceIndex = toSliceIndex(ScriptRuntime.toInteger(objArr[0]), lengthProperty);
            if (objArr.length != 1 && objArr[1] != Undefined.instance) {
                lengthProperty = toSliceIndex(ScriptRuntime.toInteger(objArr[1]), lengthProperty);
            }
        }
        for (long j2 = sliceIndex; j2 < lengthProperty; j2++) {
            Object rawElem = getRawElem(object, j2);
            if (rawElem != Scriptable.NOT_FOUND) {
                defineElem(context, scriptableNewArray, j2 - sliceIndex, rawElem);
            }
        }
        setLengthProperty(context, scriptableNewArray, Math.max(0L, lengthProperty - sliceIndex));
        return scriptableNewArray;
    }

    private static Scriptable js_sort(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        java.util.Comparator<Object> elementComparator = (objArr.length <= 0 || Undefined.instance == objArr[0]) ? DEFAULT_COMPARATOR : new ElementComparator(new AnonymousClass1(new Object[2], ScriptRuntime.getValueFunctionAndThis(objArr[0], context), context, scriptable, ScriptRuntime.lastStoredScriptable(context)));
        long lengthProperty = getLengthProperty(context, object, false);
        int i2 = (int) lengthProperty;
        if (lengthProperty != i2) {
            throw Context.reportRuntimeError1("msg.arraylength.too.big", String.valueOf(lengthProperty));
        }
        Object[] objArr2 = new Object[i2];
        for (int i3 = 0; i3 != i2; i3++) {
            objArr2[i3] = getRawElem(object, i3);
        }
        Sorting.get().hybridSort(objArr2, elementComparator);
        for (int i4 = 0; i4 < i2; i4++) {
            setRawElem(context, object, i4, objArr2[i4]);
        }
        return object;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0155 A[LOOP:1: B:75:0x0153->B:76:0x0155, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object js_splice(org.mozilla.javascript.Context r26, org.mozilla.javascript.Scriptable r27, org.mozilla.javascript.Scriptable r28, java.lang.Object[] r29) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.js_splice(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    private static Object js_unshift(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i2 = 0;
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                Object[] objArr2 = nativeArray.dense;
                System.arraycopy(objArr2, 0, objArr2, objArr.length, (int) nativeArray.length);
                while (i2 < objArr.length) {
                    nativeArray.dense[i2] = objArr[i2];
                    i2++;
                }
                long length = nativeArray.length + ((long) objArr.length);
                nativeArray.length = length;
                return ScriptRuntime.wrapNumber(length);
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        int length2 = objArr.length;
        if (objArr.length > 0) {
            if (lengthProperty > 0) {
                for (long j2 = lengthProperty - 1; j2 >= 0; j2--) {
                    setRawElem(context, object, ((long) length2) + j2, getRawElem(object, j2));
                }
            }
            while (i2 < objArr.length) {
                setElem(context, object, i2, objArr[i2]);
                i2++;
            }
        }
        return setLengthProperty(context, object, lengthProperty + ((long) objArr.length));
    }

    private static Object reduceMethod(Context context, int i2, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj == null || !(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Function function = (Function) obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        boolean z = i2 == 24;
        Object objCall = objArr.length > 1 ? objArr[1] : Scriptable.NOT_FOUND;
        for (long j2 = 0; j2 < lengthProperty; j2++) {
            long j3 = z ? j2 : (lengthProperty - 1) - j2;
            Object rawElem = getRawElem(object, j3);
            Object obj2 = Scriptable.NOT_FOUND;
            if (rawElem != obj2) {
                objCall = objCall == obj2 ? rawElem : function.call(context, topLevelScope, topLevelScope, new Object[]{objCall, rawElem, Long.valueOf(j3), object});
            }
        }
        if (objCall != Scriptable.NOT_FOUND) {
            return objCall;
        }
        throw ScriptRuntime.typeError0("msg.empty.array.reduce");
    }

    private static void setElem(Context context, Scriptable scriptable, long j2, Object obj) {
        if (j2 > 2147483647L) {
            ScriptableObject.putProperty(scriptable, Long.toString(j2), obj);
        } else {
            ScriptableObject.putProperty(scriptable, (int) j2, obj);
        }
    }

    private void setLength(Object obj) {
        if ((this.lengthAttr & 1) != 0) {
            return;
        }
        double number = ScriptRuntime.toNumber(obj);
        long uint32 = ScriptRuntime.toUint32(number);
        double d2 = uint32;
        if (d2 != number) {
            throw ScriptRuntime.rangeError(ScriptRuntime.getMessage0("msg.arraylength.bad"));
        }
        if (this.denseOnly) {
            long j2 = this.length;
            if (uint32 < j2) {
                Object[] objArr = this.dense;
                Arrays.fill(objArr, (int) uint32, objArr.length, Scriptable.NOT_FOUND);
                this.length = uint32;
                return;
            } else {
                if (uint32 < 1431655764 && d2 < j2 * GROW_FACTOR && ensureCapacity((int) uint32)) {
                    this.length = uint32;
                    return;
                }
                this.denseOnly = false;
            }
        }
        long j3 = this.length;
        if (uint32 < j3) {
            if (j3 - uint32 > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                for (Object obj2 : getIds()) {
                    if (obj2 instanceof String) {
                        String str = (String) obj2;
                        if (toArrayIndex(str) >= uint32) {
                            delete(str);
                        }
                    } else {
                        int iIntValue = ((Integer) obj2).intValue();
                        if (iIntValue >= uint32) {
                            delete(iIntValue);
                        }
                    }
                }
            } else {
                for (long j4 = uint32; j4 < this.length; j4++) {
                    deleteElem(this, j4);
                }
            }
        }
        this.length = uint32;
    }

    private static Object setLengthProperty(Context context, Scriptable scriptable, long j2) {
        Number numberWrapNumber = ScriptRuntime.wrapNumber(j2);
        ScriptableObject.putProperty(scriptable, "length", numberWrapNumber);
        return numberWrapNumber;
    }

    public static void setMaximumInitialCapacity(int i2) {
        maximumInitialCapacity = i2;
    }

    private static void setRawElem(Context context, Scriptable scriptable, long j2, Object obj) {
        if (obj == Scriptable.NOT_FOUND) {
            deleteElem(scriptable, j2);
        } else {
            setElem(context, scriptable, j2, obj);
        }
    }

    private static long toArrayIndex(Object obj) {
        if (obj instanceof String) {
            return toArrayIndex((String) obj);
        }
        if (obj instanceof Number) {
            return toArrayIndex(((Number) obj).doubleValue());
        }
        return -1L;
    }

    private static int toDenseIndex(Object obj) {
        long arrayIndex = toArrayIndex(obj);
        if (0 > arrayIndex || arrayIndex >= 2147483647L) {
            return -1;
        }
        return (int) arrayIndex;
    }

    private static long toSliceIndex(double d2, long j2) {
        if (d2 < 0.0d) {
            d2 += j2;
            if (d2 < 0.0d) {
                return 0L;
            }
        } else if (d2 > j2) {
            return j2;
        }
        return (long) d2;
    }

    private static String toStringHelper(Context context, Scriptable scriptable, Scriptable scriptable2, boolean z, boolean z2) {
        String str;
        boolean zHas;
        boolean z3;
        long j2;
        boolean z4;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        StringBuilder sb = new StringBuilder(256);
        if (z) {
            sb.append('[');
            str = ", ";
        } else {
            str = ",";
        }
        ObjToIntMap objToIntMap = context.iterating;
        if (objToIntMap == null) {
            context.iterating = new ObjToIntMap(31);
            zHas = false;
            z3 = true;
        } else {
            zHas = objToIntMap.has(object);
            z3 = false;
        }
        long j3 = 0;
        if (zHas) {
            z4 = false;
            j2 = 0;
        } else {
            try {
                context.iterating.put(object, 0);
                boolean z5 = !z || context.getLanguageVersion() < 150;
                j2 = 0;
                boolean z6 = false;
                while (j2 < lengthProperty) {
                    if (j2 > j3) {
                        sb.append(str);
                    }
                    Object rawElem = getRawElem(object, j2);
                    if (rawElem == Scriptable.NOT_FOUND || (z5 && (rawElem == null || rawElem == Undefined.instance))) {
                        z6 = false;
                    } else {
                        if (z) {
                            sb.append(ScriptRuntime.uneval(context, scriptable, rawElem));
                        } else if (rawElem instanceof String) {
                            sb.append((String) rawElem);
                        } else {
                            if (z2) {
                                rawElem = ScriptRuntime.getPropFunctionAndThis(rawElem, "toLocaleString", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), ScriptRuntime.emptyArgs);
                            }
                            sb.append(ScriptRuntime.toString(rawElem));
                        }
                        z6 = true;
                    }
                    j2++;
                    j3 = 0;
                }
                context.iterating.remove(object);
                z4 = z6;
            } finally {
                if (z3) {
                    context.iterating = null;
                }
            }
        }
        if (z) {
            if (z4 || j2 <= 0) {
                sb.append(']');
            } else {
                sb.append(", ]");
            }
        }
        return sb.toString();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) > -1;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean containsAll(Collection collection) {
        java.util.Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        Object[] objArr = this.dense;
        if (objArr != null) {
            this.dense = null;
            this.denseOnly = false;
            for (int i2 = 0; i2 < objArr.length; i2++) {
                if (objArr[i2] != Scriptable.NOT_FOUND) {
                    put(i2, this, objArr[i2]);
                }
            }
        }
        long arrayIndex = toArrayIndex(obj);
        if (arrayIndex >= this.length) {
            this.length = arrayIndex + 1;
        }
        super.defineOwnProperty(context, obj, scriptableObject, z);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i2) {
        Object[] objArr = this.dense;
        if (objArr == null || i2 < 0 || i2 >= objArr.length || isSealed() || (!this.denseOnly && isGetterOrSetter(null, i2, true))) {
            super.delete(i2);
        } else {
            this.dense[i2] = Scriptable.NOT_FOUND;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public java.lang.Object execIdCall(org.mozilla.javascript.IdFunctionObject r7, org.mozilla.javascript.Context r8, org.mozilla.javascript.Scriptable r9, org.mozilla.javascript.Scriptable r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.execIdCall(org.mozilla.javascript.IdFunctionObject, org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = ARRAY_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -5, "join", 1);
        addIdFunctionProperty(idFunctionObject, obj, -6, "reverse", 0);
        addIdFunctionProperty(idFunctionObject, obj, -7, "sort", 1);
        addIdFunctionProperty(idFunctionObject, obj, -8, "push", 1);
        addIdFunctionProperty(idFunctionObject, obj, -9, "pop", 0);
        addIdFunctionProperty(idFunctionObject, obj, -10, "shift", 0);
        addIdFunctionProperty(idFunctionObject, obj, -11, "unshift", 1);
        addIdFunctionProperty(idFunctionObject, obj, -12, "splice", 2);
        addIdFunctionProperty(idFunctionObject, obj, -13, "concat", 1);
        addIdFunctionProperty(idFunctionObject, obj, -14, "slice", 2);
        addIdFunctionProperty(idFunctionObject, obj, -15, "indexOf", 1);
        addIdFunctionProperty(idFunctionObject, obj, -16, "lastIndexOf", 1);
        addIdFunctionProperty(idFunctionObject, obj, -17, "every", 1);
        addIdFunctionProperty(idFunctionObject, obj, -18, "filter", 1);
        addIdFunctionProperty(idFunctionObject, obj, -19, "forEach", 1);
        addIdFunctionProperty(idFunctionObject, obj, -20, "map", 1);
        addIdFunctionProperty(idFunctionObject, obj, -21, "some", 1);
        addIdFunctionProperty(idFunctionObject, obj, -22, "find", 1);
        addIdFunctionProperty(idFunctionObject, obj, -23, "findIndex", 1);
        addIdFunctionProperty(idFunctionObject, obj, -24, "reduce", 1);
        addIdFunctionProperty(idFunctionObject, obj, -25, "reduceRight", 1);
        addIdFunctionProperty(idFunctionObject, obj, -26, "isArray", 1);
        addIdFunctionProperty(idFunctionObject, obj, -27, "of", 0);
        addIdFunctionProperty(idFunctionObject, obj, -28, "from", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        return str.equals("length") ? IdScriptableObject.instanceIdInfo(this.lengthAttr, 1) : super.findInstanceIdInfo(str);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 32 : 0;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i2, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter(null, i2, false)) {
            return super.get(i2, scriptable);
        }
        Object[] objArr = this.dense;
        return (objArr == null || i2 < 0 || i2 >= objArr.length) ? super.get(i2, scriptable) : objArr[i2];
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public int getAttributes(int i2) {
        Object[] objArr = this.dense;
        if (objArr == null || i2 < 0 || i2 >= objArr.length || objArr[i2] == Scriptable.NOT_FOUND) {
            return super.getAttributes(i2);
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Array";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return (cls == ScriptRuntime.NumberClass && Context.getContext().getLanguageVersion() == 120) ? Long.valueOf(this.length) : super.getDefaultValue(cls);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z, boolean z2) {
        Object[] ids = super.getIds(z, z2);
        Object[] objArr = this.dense;
        if (objArr == null) {
            return ids;
        }
        int length = objArr.length;
        long j2 = this.length;
        if (length > j2) {
            length = (int) j2;
        }
        if (length == 0) {
            return ids;
        }
        int length2 = ids.length;
        Object[] objArr2 = new Object[length + length2];
        int i2 = 0;
        for (int i3 = 0; i3 != length; i3++) {
            if (this.dense[i3] != Scriptable.NOT_FOUND) {
                objArr2[i2] = Integer.valueOf(i3);
                i2++;
            }
        }
        if (i2 != length) {
            Object[] objArr3 = new Object[i2 + length2];
            System.arraycopy(objArr2, 0, objArr3, 0, i2);
            objArr2 = objArr3;
        }
        System.arraycopy(ids, 0, objArr2, i2, length2);
        return objArr2;
    }

    public List<Integer> getIndexIds() {
        Object[] ids = getIds();
        ArrayList arrayList = new ArrayList(ids.length);
        for (Object obj : ids) {
            int int32 = ScriptRuntime.toInt32(obj);
            if (int32 >= 0 && ScriptRuntime.toString(int32).equals(ScriptRuntime.toString(obj))) {
                arrayList.add(Integer.valueOf(int32));
            }
        }
        return arrayList;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i2) {
        return i2 == 1 ? "length" : super.getInstanceIdName(i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i2) {
        return i2 == 1 ? ScriptRuntime.wrapNumber(this.length) : super.getInstanceIdValue(i2);
    }

    public long getLength() {
        return this.length;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 1;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        int denseIndex;
        if (this.dense != null && (denseIndex = toDenseIndex(obj)) >= 0) {
            Object[] objArr = this.dense;
            if (denseIndex < objArr.length && objArr[denseIndex] != Scriptable.NOT_FOUND) {
                return defaultIndexPropertyDescriptor(objArr[denseIndex]);
            }
        }
        return super.getOwnPropertyDescriptor(context, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i2, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter(null, i2, false)) {
            return super.has(i2, scriptable);
        }
        Object[] objArr = this.dense;
        return (objArr == null || i2 < 0 || i2 >= objArr.length) ? super.has(i2, scriptable) : objArr[i2] != Scriptable.NOT_FOUND;
    }

    @Override // java.util.List, j$.util.List
    public int indexOf(Object obj) {
        long j2 = this.length;
        if (j2 > 2147483647L) {
            throw new IllegalStateException();
        }
        int i2 = (int) j2;
        int i3 = 0;
        if (obj == null) {
            while (i3 < i2) {
                if (get(i3) == null) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        while (i3 < i2) {
            if (obj.equals(get(i3))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        if (i2 == 32) {
            initPrototypeMethod(ARRAY_TAG, i2, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        switch (i2) {
            case 1:
                str = "constructor";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 2:
                str2 = "toString";
                str4 = str2;
                i3 = 0;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 3:
                str2 = "toLocaleString";
                str4 = str2;
                i3 = 0;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 4:
                str2 = "toSource";
                str4 = str2;
                i3 = 0;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 5:
                str = "join";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 6:
                str2 = "reverse";
                str4 = str2;
                i3 = 0;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 7:
                str = "sort";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 8:
                str = "push";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 9:
                str2 = "pop";
                str4 = str2;
                i3 = 0;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 10:
                str2 = "shift";
                str4 = str2;
                i3 = 0;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 11:
                str = "unshift";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 12:
                str3 = "splice";
                str4 = str3;
                i3 = 2;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 13:
                str = "concat";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 14:
                str3 = "slice";
                str4 = str3;
                i3 = 2;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 15:
                str = "indexOf";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 16:
                str = "lastIndexOf";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 17:
                str = "every";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 18:
                str = "filter";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 19:
                str = "forEach";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 20:
                str = "map";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 21:
                str = "some";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 22:
                str = "find";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 23:
                str = "findIndex";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 24:
                str = "reduce";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 25:
                str = "reduceRight";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 26:
                str = "fill";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 27:
                str2 = "keys";
                str4 = str2;
                i3 = 0;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 28:
                str2 = "values";
                str4 = str2;
                i3 = 0;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 29:
                str2 = "entries";
                str4 = str2;
                i3 = 0;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 30:
                str = "includes";
                str4 = str;
                i3 = 1;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            case 31:
                str3 = "copyWithin";
                str4 = str3;
                i3 = 2;
                initPrototypeMethod(ARRAY_TAG, i2, str4, (String) null, i3);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i2));
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public java.util.Iterator iterator() {
        return listIterator(0);
    }

    @Deprecated
    public long jsGet_length() {
        return getLength();
    }

    @Override // java.util.List, j$.util.List
    public int lastIndexOf(Object obj) {
        long j2 = this.length;
        if (j2 > 2147483647L) {
            throw new IllegalStateException();
        }
        int i2 = (int) j2;
        if (obj == null) {
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                if (get(i3) == null) {
                    return i3;
                }
            }
            return -1;
        }
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            if (obj.equals(get(i4))) {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.List, j$.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Q1.v(a.A(this), true);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        super.put(str, scriptable, obj);
        if (scriptable == this) {
            long arrayIndex = toArrayIndex(str);
            if (arrayIndex >= this.length) {
                this.length = arrayIndex + 1;
                this.denseOnly = false;
            }
        }
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean removeAll(Collection collection) {
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
    public boolean retainAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, j$.util.List
    public Object set(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    public void setDenseOnly(boolean z) {
        if (z && !this.denseOnly) {
            throw new IllegalArgumentException();
        }
        this.denseOnly = z;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdAttributes(int i2, int i3) {
        if (i2 == 1) {
            this.lengthAttr = i3;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i2, Object obj) {
        if (i2 == 1) {
            setLength(obj);
        } else {
            super.setInstanceIdValue(i2, obj);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public int size() {
        long j2 = this.length;
        if (j2 <= 2147483647L) {
            return (int) j2;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void sort(java.util.Comparator comparator) {
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
    public java.util.List subList(int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public Object[] toArray() {
        return toArray(ScriptRuntime.emptyArgs);
    }

    public static final class ElementComparator implements java.util.Comparator<Object>, Serializable, j$.util.Comparator {
        private static final long serialVersionUID = -1189948017688708858L;
        private final java.util.Comparator<Object> child;

        public ElementComparator() {
            this.child = NativeArray.STRING_COMPARATOR;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Object obj, Object obj2) {
            Object obj3 = Undefined.instance;
            if (obj == obj3) {
                if (obj2 == obj3) {
                    return 0;
                }
                return obj2 == Scriptable.NOT_FOUND ? -1 : 1;
            }
            Object obj4 = Scriptable.NOT_FOUND;
            if (obj == obj4) {
                return obj2 == obj4 ? 0 : 1;
            }
            if (obj2 == obj4 || obj2 == obj3) {
                return -1;
            }
            return this.child.compare(obj, obj2);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(j$.util.function.Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(j$.util.function.Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        public ElementComparator(java.util.Comparator<Object> comparator) {
            this.child = comparator;
        }
    }

    @Override // java.util.List, j$.util.List
    public void add(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, j$.util.List
    public boolean addAll(int i2, java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0140  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.findPrototypeId(java.lang.String):int");
    }

    @Override // java.util.List, j$.util.List
    public ListIterator listIterator(int i2) {
        long j2 = this.length;
        if (j2 > 2147483647L) {
            throw new IllegalStateException();
        }
        int i3 = (int) j2;
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(c.a.a.a.a.G("Index: ", i2));
        }
        return new AnonymousClass2(i2, i3);
    }

    @Override // java.util.List, j$.util.List
    public Object remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public Object[] toArray(Object[] objArr) {
        long j2 = this.length;
        if (j2 > 2147483647L) {
            throw new IllegalStateException();
        }
        int i2 = (int) j2;
        if (objArr.length < i2) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = get(i3);
        }
        return objArr;
    }

    private static long toArrayIndex(String str) {
        long arrayIndex = toArrayIndex(ScriptRuntime.toNumber(str));
        if (Long.toString(arrayIndex).equals(str)) {
            return arrayIndex;
        }
        return -1L;
    }

    public Object get(long j2) {
        if (j2 >= 0 && j2 < this.length) {
            Object rawElem = getRawElem(this, j2);
            if (rawElem == Scriptable.NOT_FOUND || rawElem == Undefined.instance) {
                return null;
            }
            return rawElem instanceof Wrapper ? ((Wrapper) rawElem).unwrap() : rawElem;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i2, Scriptable scriptable, Object obj) {
        if (scriptable == this && !isSealed() && this.dense != null && i2 >= 0 && (this.denseOnly || !isGetterOrSetter(null, i2, true))) {
            if (!isExtensible() && this.length <= i2) {
                return;
            }
            Object[] objArr = this.dense;
            if (i2 < objArr.length) {
                objArr[i2] = obj;
                long j2 = i2;
                if (this.length <= j2) {
                    this.length = j2 + 1;
                    return;
                }
                return;
            }
            if (this.denseOnly && i2 < ((double) objArr.length) * GROW_FACTOR && ensureCapacity(i2 + 1)) {
                this.dense[i2] = obj;
                this.length = ((long) i2) + 1;
                return;
            }
            this.denseOnly = false;
        }
        super.put(i2, scriptable, obj);
        if (scriptable == this && (this.lengthAttr & 1) == 0) {
            long j3 = i2;
            if (this.length <= j3) {
                this.length = j3 + 1;
            }
        }
    }

    public NativeArray(Object[] objArr) {
        this.lengthAttr = 6;
        this.denseOnly = true;
        this.dense = objArr;
        this.length = objArr.length;
    }

    private static long toArrayIndex(double d2) {
        if (Double.isNaN(d2)) {
            return -1L;
        }
        long uint32 = ScriptRuntime.toUint32(d2);
        if (uint32 != d2 || uint32 == 4294967295L) {
            return -1L;
        }
        return uint32;
    }

    @Override // java.util.List, j$.util.List
    public Object get(int i2) {
        return get(i2);
    }
}
