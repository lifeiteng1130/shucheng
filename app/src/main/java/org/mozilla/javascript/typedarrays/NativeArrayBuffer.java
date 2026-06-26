package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes3.dex */
public class NativeArrayBuffer extends IdScriptableObject {
    public static final String CLASS_NAME = "ArrayBuffer";
    private static final int ConstructorId_isView = -1;
    private static final byte[] EMPTY_BUF = new byte[0];
    private static final int Id_byteLength = 1;
    private static final int Id_constructor = 1;
    private static final int Id_slice = 2;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PROTOTYPE_ID = 2;
    private static final long serialVersionUID = 3110411773054879549L;
    public final byte[] buffer;

    public NativeArrayBuffer() {
        this.buffer = EMPTY_BUF;
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeArrayBuffer().exportAsJSClass(2, scriptable, z);
    }

    private static boolean isArg(Object[] objArr, int i2) {
        return objArr.length > i2 && !Undefined.instance.equals(objArr[i2]);
    }

    private static NativeArrayBuffer realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeArrayBuffer) {
            return (NativeArrayBuffer) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(CLASS_NAME)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == -1) {
            return Boolean.valueOf(isArg(objArr, 0) && (objArr[0] instanceof NativeArrayBufferView));
        }
        if (iMethodId == 1) {
            return new NativeArrayBuffer(isArg(objArr, 0) ? ScriptRuntime.toNumber(objArr[0]) : 0.0d);
        }
        if (iMethodId != 2) {
            throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
        return realThis(scriptable2, idFunctionObject).slice(isArg(objArr, 0) ? ScriptRuntime.toNumber(objArr[0]) : 0.0d, isArg(objArr, 1) ? ScriptRuntime.toNumber(objArr[1]) : r5.buffer.length);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, CLASS_NAME, -1, "isView", 1);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        return "byteLength".equals(str) ? IdScriptableObject.instanceIdInfo(5, 1) : super.findInstanceIdInfo(str);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i2;
        int length = str.length();
        if (length == 5) {
            i2 = 2;
            str2 = "slice";
        } else if (length == 11) {
            i2 = 1;
            str2 = "constructor";
        } else {
            str2 = null;
            i2 = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i2;
        }
        return 0;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i2) {
        return i2 == 1 ? "byteLength" : super.getInstanceIdName(i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i2) {
        return i2 == 1 ? ScriptRuntime.wrapInt(this.buffer.length) : super.getInstanceIdValue(i2);
    }

    public int getLength() {
        return this.buffer.length;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 1;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        int i3 = 2;
        if (i2 == 1) {
            str = "constructor";
            i3 = 1;
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException(String.valueOf(i2));
            }
            str = "slice";
        }
        initPrototypeMethod(CLASS_NAME, i2, str, i3);
    }

    public NativeArrayBuffer slice(double d2, double d3) {
        byte[] bArr = this.buffer;
        double length = bArr.length;
        if (d3 < 0.0d) {
            d3 += (double) bArr.length;
        }
        int int32 = ScriptRuntime.toInt32(Math.max(0.0d, Math.min(length, d3)));
        double d4 = int32;
        if (d2 < 0.0d) {
            d2 += (double) this.buffer.length;
        }
        int int322 = ScriptRuntime.toInt32(Math.min(d4, Math.max(0.0d, d2)));
        int i2 = int32 - int322;
        NativeArrayBuffer nativeArrayBuffer = new NativeArrayBuffer(i2);
        System.arraycopy(this.buffer, int322, nativeArrayBuffer.buffer, 0, i2);
        return nativeArrayBuffer;
    }

    public NativeArrayBuffer(double d2) {
        if (d2 >= 2.147483647E9d) {
            throw ScriptRuntime.rangeError("length parameter (" + d2 + ") is too large ");
        }
        if (d2 == Double.NEGATIVE_INFINITY) {
            throw ScriptRuntime.rangeError("Negative array length " + d2);
        }
        if (d2 > -1.0d) {
            int int32 = ScriptRuntime.toInt32(d2);
            if (int32 < 0) {
                throw ScriptRuntime.rangeError("Negative array length " + d2);
            }
            if (int32 == 0) {
                this.buffer = EMPTY_BUF;
                return;
            } else {
                this.buffer = new byte[int32];
                return;
            }
        }
        throw ScriptRuntime.rangeError("Negative array length " + d2);
    }
}
