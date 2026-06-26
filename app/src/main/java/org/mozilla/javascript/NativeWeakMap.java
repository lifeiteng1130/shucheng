package org.mozilla.javascript;

import c.a.a.a.a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class NativeWeakMap extends IdScriptableObject {
    private static final int Id_constructor = 1;
    private static final int Id_delete = 2;
    private static final int Id_get = 3;
    private static final int Id_has = 4;
    private static final int Id_set = 5;
    private static final int MAX_PROTOTYPE_ID = 6;
    private static final int SymbolId_toStringTag = 6;
    private static final long serialVersionUID = 8670434366883930453L;
    private boolean instanceOfWeakMap = false;
    private transient WeakHashMap<Scriptable, Object> map = new WeakHashMap<>();
    private static final Object MAP_TAG = "WeakMap";
    private static final Object NULL_VALUE = new Object();

    public static void init(Scriptable scriptable, boolean z) {
        new NativeWeakMap().exportAsJSClass(6, scriptable, z);
    }

    private Object js_delete(Object obj) {
        if (ScriptRuntime.isObject(obj)) {
            return Boolean.valueOf(this.map.remove(obj) != null);
        }
        return Boolean.FALSE;
    }

    private Object js_get(Object obj) {
        if (!ScriptRuntime.isObject(obj)) {
            return Undefined.instance;
        }
        Object obj2 = this.map.get(obj);
        if (obj2 == null) {
            return Undefined.instance;
        }
        if (obj2 == NULL_VALUE) {
            return null;
        }
        return obj2;
    }

    private Object js_has(Object obj) {
        return !ScriptRuntime.isObject(obj) ? Boolean.FALSE : Boolean.valueOf(this.map.containsKey(obj));
    }

    private Object js_set(Object obj, Object obj2) {
        if (!ScriptRuntime.isObject(obj)) {
            throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(obj));
        }
        if (obj2 == null) {
            obj2 = NULL_VALUE;
        }
        this.map.put((Scriptable) obj, obj2);
        return this;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = new WeakHashMap<>();
    }

    private static NativeWeakMap realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable == null) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        try {
            NativeWeakMap nativeWeakMap = (NativeWeakMap) scriptable;
            if (nativeWeakMap.instanceOfWeakMap) {
                return nativeWeakMap;
            }
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        } catch (ClassCastException unused) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(MAP_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            if (scriptable2 != null) {
                throw ScriptRuntime.typeError1("msg.no.new", "WeakMap");
            }
            NativeWeakMap nativeWeakMap = new NativeWeakMap();
            nativeWeakMap.instanceOfWeakMap = true;
            if (objArr.length > 0) {
                NativeMap.loadFromIterable(context, scriptable, nativeWeakMap, objArr[0]);
            }
            return nativeWeakMap;
        }
        if (iMethodId == 2) {
            return realThis(scriptable2, idFunctionObject).js_delete(objArr.length > 0 ? objArr[0] : Undefined.instance);
        }
        if (iMethodId == 3) {
            return realThis(scriptable2, idFunctionObject).js_get(objArr.length > 0 ? objArr[0] : Undefined.instance);
        }
        if (iMethodId == 4) {
            return realThis(scriptable2, idFunctionObject).js_has(objArr.length > 0 ? objArr[0] : Undefined.instance);
        }
        if (iMethodId == 5) {
            return realThis(scriptable2, idFunctionObject).js_set(objArr.length > 0 ? objArr[0] : Undefined.instance, objArr.length > 1 ? objArr[1] : Undefined.instance);
        }
        StringBuilder sbR = a.r("WeakMap.prototype has no method: ");
        sbR.append(idFunctionObject.getFunctionName());
        throw new IllegalArgumentException(sbR.toString());
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 6 : 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "WeakMap";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        int i3;
        String str2;
        if (i2 == 6) {
            initPrototypeValue(6, SymbolKey.TO_STRING_TAG, getClassName(), 3);
            return;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                str2 = "delete";
            } else if (i2 == 3) {
                str2 = "get";
            } else if (i2 == 4) {
                str2 = "has";
            } else {
                if (i2 != 5) {
                    throw new IllegalArgumentException(String.valueOf(i2));
                }
                str = "set";
                i3 = 2;
            }
            str = str2;
            i3 = 1;
        } else {
            str = "constructor";
            i3 = 0;
        }
        initPrototypeMethod(MAP_TAG, i2, str, (String) null, i3);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i2;
        int length = str.length();
        if (length != 3) {
            if (length == 6) {
                str2 = "delete";
                i2 = 2;
            } else if (length == 11) {
                str2 = "constructor";
                i2 = 1;
            }
            if (str2 != null || str2 == str || str2.equals(str)) {
                return i2;
            }
            return 0;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'g') {
            if (str.charAt(2) == 't' && str.charAt(1) == 'e') {
                return 3;
            }
        } else if (cCharAt == 'h') {
            if (str.charAt(2) == 's' && str.charAt(1) == 'a') {
                return 4;
            }
        } else if (cCharAt == 's' && str.charAt(2) == 't' && str.charAt(1) == 'e') {
            return 5;
        }
        str2 = null;
        i2 = 0;
        return str2 != null ? i2 : i2;
    }
}
