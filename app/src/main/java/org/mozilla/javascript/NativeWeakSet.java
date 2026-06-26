package org.mozilla.javascript;

import c.a.a.a.a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class NativeWeakSet extends IdScriptableObject {
    private static final int Id_add = 2;
    private static final int Id_constructor = 1;
    private static final int Id_delete = 3;
    private static final int Id_has = 4;
    private static final Object MAP_TAG = "WeakSet";
    private static final int MAX_PROTOTYPE_ID = 5;
    private static final int SymbolId_toStringTag = 5;
    private static final long serialVersionUID = 2065753364224029534L;
    private boolean instanceOfWeakSet = false;
    private transient WeakHashMap<Scriptable, Boolean> map = new WeakHashMap<>();

    public static void init(Scriptable scriptable, boolean z) {
        new NativeWeakSet().exportAsJSClass(5, scriptable, z);
    }

    private Object js_add(Object obj) {
        if (!ScriptRuntime.isObject(obj)) {
            throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(obj));
        }
        this.map.put((Scriptable) obj, Boolean.TRUE);
        return this;
    }

    private Object js_delete(Object obj) {
        if (ScriptRuntime.isObject(obj)) {
            return Boolean.valueOf(this.map.remove(obj) != null);
        }
        return Boolean.FALSE;
    }

    private Object js_has(Object obj) {
        return !ScriptRuntime.isObject(obj) ? Boolean.FALSE : Boolean.valueOf(this.map.containsKey(obj));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = new WeakHashMap<>();
    }

    private static NativeWeakSet realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable == null) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        try {
            NativeWeakSet nativeWeakSet = (NativeWeakSet) scriptable;
            if (nativeWeakSet.instanceOfWeakSet) {
                return nativeWeakSet;
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
                throw ScriptRuntime.typeError1("msg.no.new", "WeakSet");
            }
            NativeWeakSet nativeWeakSet = new NativeWeakSet();
            nativeWeakSet.instanceOfWeakSet = true;
            if (objArr.length > 0) {
                NativeSet.loadFromIterable(context, scriptable, nativeWeakSet, objArr[0]);
            }
            return nativeWeakSet;
        }
        if (iMethodId == 2) {
            return realThis(scriptable2, idFunctionObject).js_add(objArr.length > 0 ? objArr[0] : Undefined.instance);
        }
        if (iMethodId == 3) {
            return realThis(scriptable2, idFunctionObject).js_delete(objArr.length > 0 ? objArr[0] : Undefined.instance);
        }
        if (iMethodId == 4) {
            return realThis(scriptable2, idFunctionObject).js_has(objArr.length > 0 ? objArr[0] : Undefined.instance);
        }
        StringBuilder sbR = a.r("WeakMap.prototype has no method: ");
        sbR.append(idFunctionObject.getFunctionName());
        throw new IllegalArgumentException(sbR.toString());
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 5 : 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "WeakSet";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        int i3;
        String str2;
        if (i2 == 5) {
            initPrototypeValue(5, SymbolKey.TO_STRING_TAG, getClassName(), 3);
            return;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                str2 = "add";
            } else if (i2 == 3) {
                str2 = "delete";
            } else {
                if (i2 != 4) {
                    throw new IllegalArgumentException(String.valueOf(i2));
                }
                str2 = "has";
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
        int length = str.length();
        int i2 = 3;
        if (length != 3) {
            if (length == 6) {
                str2 = "delete";
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
        if (cCharAt == 'a') {
            if (str.charAt(2) == 'd' && str.charAt(1) == 'd') {
                return 2;
            }
        } else if (cCharAt == 'h' && str.charAt(2) == 's' && str.charAt(1) == 'a') {
            return 4;
        }
        str2 = null;
        i2 = 0;
        if (str2 != null) {
        }
        return i2;
    }
}
