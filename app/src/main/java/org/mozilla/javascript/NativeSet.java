package org.mozilla.javascript;

import c.a.a.a.a;
import java.util.Iterator;
import org.mozilla.javascript.Hashtable;
import org.mozilla.javascript.IteratorLikeIterable;
import org.mozilla.javascript.NativeCollectionIterator;

/* JADX INFO: loaded from: classes3.dex */
public class NativeSet extends IdScriptableObject {
    public static final String ITERATOR_TAG = "Set Iterator";
    private static final int Id_add = 2;
    private static final int Id_clear = 5;
    private static final int Id_constructor = 1;
    private static final int Id_delete = 3;
    private static final int Id_entries = 7;
    private static final int Id_forEach = 8;
    private static final int Id_has = 4;
    private static final int Id_keys = 6;
    private static final int Id_values = 6;
    private static final int MAX_PROTOTYPE_ID = 10;
    private static final int SymbolId_getSize = 9;
    private static final int SymbolId_toStringTag = 10;
    private static final long serialVersionUID = -8442212766987072986L;
    private final Hashtable entries = new Hashtable();
    private boolean instanceOfSet = false;
    private static final Object SET_TAG = "Set";
    public static final SymbolKey GETSIZE = new SymbolKey("[Symbol.getSize]");

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeSet nativeSet = new NativeSet();
        nativeSet.exportAsJSClass(10, scriptable, false);
        ScriptableObject scriptableObject = (ScriptableObject) context.newObject(scriptable);
        scriptableObject.put("enumerable", scriptableObject, Boolean.FALSE);
        scriptableObject.put("configurable", scriptableObject, Boolean.TRUE);
        scriptableObject.put("get", scriptableObject, nativeSet.get(GETSIZE, nativeSet));
        nativeSet.defineOwnProperty(context, "size", scriptableObject);
        if (z) {
            nativeSet.sealObject();
        }
    }

    private Object js_add(Object obj) {
        if ((obj instanceof Number) && ((Number) obj).doubleValue() == ScriptRuntime.negativeZero) {
            obj = ScriptRuntime.zeroObj;
        }
        this.entries.put(obj, obj);
        return this;
    }

    private Object js_clear() {
        this.entries.clear();
        return Undefined.instance;
    }

    private Object js_delete(Object obj) {
        return Boolean.valueOf(this.entries.delete(obj) != null);
    }

    private Object js_forEach(Context context, Scriptable scriptable, Object obj, Object obj2) {
        if (!(obj instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Callable callable = (Callable) obj;
        boolean zIsStrictMode = context.isStrictMode();
        Iterator<Hashtable.Entry> it = this.entries.iterator();
        while (it.hasNext()) {
            Scriptable objectOrNull = ScriptRuntime.toObjectOrNull(context, obj2, scriptable);
            if (objectOrNull == null && !zIsStrictMode) {
                objectOrNull = scriptable;
            }
            if (objectOrNull == null) {
                objectOrNull = Undefined.SCRIPTABLE_UNDEFINED;
            }
            Object obj3 = it.next().value;
            callable.call(context, scriptable, objectOrNull, new Object[]{obj3, obj3, this});
        }
        return Undefined.instance;
    }

    private Object js_getSize() {
        return Integer.valueOf(this.entries.size());
    }

    private Object js_has(Object obj) {
        return Boolean.valueOf(this.entries.has(obj));
    }

    private Object js_iterator(Scriptable scriptable, NativeCollectionIterator.Type type) {
        return new NativeCollectionIterator(scriptable, ITERATOR_TAG, type, this.entries.iterator());
    }

    public static void loadFromIterable(Context context, Scriptable scriptable, ScriptableObject scriptableObject, Object obj) {
        if (obj != null) {
            Object obj2 = Undefined.instance;
            if (obj2.equals(obj)) {
                return;
            }
            Object objCallIterator = ScriptRuntime.callIterator(obj, context, scriptable);
            if (obj2.equals(objCallIterator)) {
                return;
            }
            Callable propFunctionAndThis = ScriptRuntime.getPropFunctionAndThis(ScriptableObject.ensureScriptableObject(context.newObject(scriptable, scriptableObject.getClassName())).getPrototype(), "add", context, scriptable);
            ScriptRuntime.lastStoredScriptable(context);
            IteratorLikeIterable iteratorLikeIterable = new IteratorLikeIterable(context, scriptable, objCallIterator);
            try {
                IteratorLikeIterable.Itr it = iteratorLikeIterable.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next == Scriptable.NOT_FOUND) {
                        next = Undefined.instance;
                    }
                    propFunctionAndThis.call(context, scriptable, scriptableObject, new Object[]{next});
                }
                iteratorLikeIterable.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        iteratorLikeIterable.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
    }

    private static NativeSet realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable == null) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        try {
            NativeSet nativeSet = (NativeSet) scriptable;
            if (nativeSet.instanceOfSet) {
                return nativeSet;
            }
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        } catch (ClassCastException unused) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(SET_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        switch (idFunctionObject.methodId()) {
            case 1:
                if (scriptable2 != null) {
                    throw ScriptRuntime.typeError1("msg.no.new", "Set");
                }
                NativeSet nativeSet = new NativeSet();
                nativeSet.instanceOfSet = true;
                if (objArr.length > 0) {
                    loadFromIterable(context, scriptable, nativeSet, objArr[0]);
                }
                return nativeSet;
            case 2:
                return realThis(scriptable2, idFunctionObject).js_add(objArr.length > 0 ? objArr[0] : Undefined.instance);
            case 3:
                return realThis(scriptable2, idFunctionObject).js_delete(objArr.length > 0 ? objArr[0] : Undefined.instance);
            case 4:
                return realThis(scriptable2, idFunctionObject).js_has(objArr.length > 0 ? objArr[0] : Undefined.instance);
            case 5:
                return realThis(scriptable2, idFunctionObject).js_clear();
            case 6:
                return realThis(scriptable2, idFunctionObject).js_iterator(scriptable, NativeCollectionIterator.Type.VALUES);
            case 7:
                return realThis(scriptable2, idFunctionObject).js_iterator(scriptable, NativeCollectionIterator.Type.BOTH);
            case 8:
                return realThis(scriptable2, idFunctionObject).js_forEach(context, scriptable, objArr.length > 0 ? objArr[0] : Undefined.instance, objArr.length > 1 ? objArr[1] : Undefined.instance);
            case 9:
                return realThis(scriptable2, idFunctionObject).js_getSize();
            default:
                StringBuilder sbR = a.r("Set.prototype has no method: ");
                sbR.append(idFunctionObject.getFunctionName());
                throw new IllegalArgumentException(sbR.toString());
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        if (GETSIZE.equals(symbol)) {
            return 9;
        }
        if (SymbolKey.ITERATOR.equals(symbol)) {
            return 6;
        }
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 10 : 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Set";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        String str2;
        String str3;
        int i3;
        if (i2 == 9) {
            initPrototypeMethod(SET_TAG, i2, GETSIZE, "get size", 0);
            return;
        }
        if (i2 == 10) {
            initPrototypeValue(10, SymbolKey.TO_STRING_TAG, getClassName(), 3);
            return;
        }
        switch (i2) {
            case 1:
                str = "constructor";
                str3 = str;
                i3 = 0;
                initPrototypeMethod(SET_TAG, i2, str3, (String) null, i3);
                return;
            case 2:
                str2 = "add";
                str3 = str2;
                i3 = 1;
                initPrototypeMethod(SET_TAG, i2, str3, (String) null, i3);
                return;
            case 3:
                str2 = "delete";
                str3 = str2;
                i3 = 1;
                initPrototypeMethod(SET_TAG, i2, str3, (String) null, i3);
                return;
            case 4:
                str2 = "has";
                str3 = str2;
                i3 = 1;
                initPrototypeMethod(SET_TAG, i2, str3, (String) null, i3);
                return;
            case 5:
                str = "clear";
                str3 = str;
                i3 = 0;
                initPrototypeMethod(SET_TAG, i2, str3, (String) null, i3);
                return;
            case 6:
                str = "values";
                str3 = str;
                i3 = 0;
                initPrototypeMethod(SET_TAG, i2, str3, (String) null, i3);
                return;
            case 7:
                str = "entries";
                str3 = str;
                i3 = 0;
                initPrototypeMethod(SET_TAG, i2, str3, (String) null, i3);
                return;
            case 8:
                str2 = "forEach";
                str3 = str2;
                i3 = 1;
                initPrototypeMethod(SET_TAG, i2, str3, (String) null, i3);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007b A[ADDED_TO_REGION] */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r11) {
        /*
            r10 = this;
            int r0 = r11.length()
            r1 = 7
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 100
            r8 = 6
            r9 = 0
            if (r0 == r4) goto L4e
            if (r0 == r3) goto L4a
            if (r0 == r2) goto L46
            if (r0 == r8) goto L35
            if (r0 == r1) goto L21
            r1 = 11
            if (r0 == r1) goto L1d
            goto L77
        L1d:
            java.lang.String r0 = "constructor"
            r1 = 1
            goto L79
        L21:
            char r0 = r11.charAt(r9)
            r2 = 101(0x65, float:1.42E-43)
            if (r0 != r2) goto L2c
            java.lang.String r0 = "entries"
            goto L79
        L2c:
            r1 = 102(0x66, float:1.43E-43)
            if (r0 != r1) goto L77
            r1 = 8
            java.lang.String r0 = "forEach"
            goto L79
        L35:
            char r0 = r11.charAt(r9)
            if (r0 != r7) goto L3f
            java.lang.String r0 = "delete"
            r1 = 3
            goto L79
        L3f:
            r1 = 118(0x76, float:1.65E-43)
            if (r0 != r1) goto L77
            java.lang.String r0 = "values"
            goto L4c
        L46:
            java.lang.String r0 = "clear"
            r1 = 5
            goto L79
        L4a:
            java.lang.String r0 = "keys"
        L4c:
            r1 = 6
            goto L79
        L4e:
            char r0 = r11.charAt(r9)
            r1 = 97
            if (r0 != r1) goto L64
            char r0 = r11.charAt(r5)
            if (r0 != r7) goto L77
            char r0 = r11.charAt(r6)
            if (r0 != r7) goto L77
            r3 = 2
            goto L86
        L64:
            r2 = 104(0x68, float:1.46E-43)
            if (r0 != r2) goto L77
            char r0 = r11.charAt(r5)
            r2 = 115(0x73, float:1.61E-43)
            if (r0 != r2) goto L77
            char r0 = r11.charAt(r6)
            if (r0 != r1) goto L77
            goto L86
        L77:
            r0 = 0
            r1 = 0
        L79:
            if (r0 == 0) goto L85
            if (r0 == r11) goto L85
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L85
            r3 = 0
            goto L86
        L85:
            r3 = r1
        L86:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeSet.findPrototypeId(java.lang.String):int");
    }
}
