package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes3.dex */
public class NativeDataView extends NativeArrayBufferView {
    public static final String CLASS_NAME = "DataView";
    private static final int Id_constructor = 1;
    private static final int Id_getFloat32 = 8;
    private static final int Id_getFloat64 = 9;
    private static final int Id_getInt16 = 4;
    private static final int Id_getInt32 = 6;
    private static final int Id_getInt8 = 2;
    private static final int Id_getUint16 = 5;
    private static final int Id_getUint32 = 7;
    private static final int Id_getUint8 = 3;
    private static final int Id_setFloat32 = 16;
    private static final int Id_setFloat64 = 17;
    private static final int Id_setInt16 = 12;
    private static final int Id_setInt32 = 14;
    private static final int Id_setInt8 = 10;
    private static final int Id_setUint16 = 13;
    private static final int Id_setUint32 = 15;
    private static final int Id_setUint8 = 11;
    private static final int MAX_PROTOTYPE_ID = 17;
    private static final long serialVersionUID = 1427967607557438968L;

    public NativeDataView() {
    }

    private static int determinePos(Object[] objArr) {
        if (!NativeArrayBufferView.isArg(objArr, 0)) {
            return 0;
        }
        double number = ScriptRuntime.toNumber(objArr[0]);
        if (Double.isInfinite(number)) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        return ScriptRuntime.toInt32(number);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeDataView().exportAsJSClass(17, scriptable, z);
    }

    private static NativeDataView js_constructor(Object[] objArr) {
        int length;
        int int32 = 0;
        if (!NativeArrayBufferView.isArg(objArr, 0) || !(objArr[0] instanceof NativeArrayBuffer)) {
            throw ScriptRuntime.constructError("TypeError", "Missing parameters");
        }
        NativeArrayBuffer nativeArrayBuffer = (NativeArrayBuffer) objArr[0];
        if (NativeArrayBufferView.isArg(objArr, 1)) {
            double number = ScriptRuntime.toNumber(objArr[1]);
            if (Double.isInfinite(number)) {
                throw ScriptRuntime.rangeError("offset out of range");
            }
            int32 = ScriptRuntime.toInt32(number);
        }
        if (NativeArrayBufferView.isArg(objArr, 2)) {
            double number2 = ScriptRuntime.toNumber(objArr[2]);
            if (Double.isInfinite(number2)) {
                throw ScriptRuntime.rangeError("offset out of range");
            }
            length = ScriptRuntime.toInt32(number2);
        } else {
            length = nativeArrayBuffer.getLength() - int32;
        }
        if (length < 0) {
            throw ScriptRuntime.rangeError("length out of range");
        }
        if (int32 < 0 || int32 + length > nativeArrayBuffer.getLength()) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        return new NativeDataView(nativeArrayBuffer, int32, length);
    }

    private Object js_getFloat(int i2, Object[] objArr) {
        int iDeterminePos = determinePos(objArr);
        rangeCheck(iDeterminePos, i2);
        boolean z = NativeArrayBufferView.isArg(objArr, 1) && i2 > 1 && ScriptRuntime.toBoolean(objArr[1]);
        if (i2 == 4) {
            return ByteIo.readFloat32(this.arrayBuffer.buffer, this.offset + iDeterminePos, z);
        }
        if (i2 == 8) {
            return ByteIo.readFloat64(this.arrayBuffer.buffer, this.offset + iDeterminePos, z);
        }
        throw new AssertionError();
    }

    private Object js_getInt(int i2, boolean z, Object[] objArr) {
        int iDeterminePos = determinePos(objArr);
        rangeCheck(iDeterminePos, i2);
        boolean z2 = NativeArrayBufferView.isArg(objArr, 1) && i2 > 1 && ScriptRuntime.toBoolean(objArr[1]);
        if (i2 == 1) {
            return z ? ByteIo.readInt8(this.arrayBuffer.buffer, this.offset + iDeterminePos) : ByteIo.readUint8(this.arrayBuffer.buffer, this.offset + iDeterminePos);
        }
        if (i2 == 2) {
            return z ? ByteIo.readInt16(this.arrayBuffer.buffer, this.offset + iDeterminePos, z2) : ByteIo.readUint16(this.arrayBuffer.buffer, this.offset + iDeterminePos, z2);
        }
        if (i2 != 4) {
            throw new AssertionError();
        }
        byte[] bArr = this.arrayBuffer.buffer;
        return z ? ByteIo.readInt32(bArr, this.offset + iDeterminePos, z2) : ByteIo.readUint32(bArr, this.offset + iDeterminePos, z2);
    }

    private void js_setFloat(int i2, Object[] objArr) {
        int iDeterminePos = determinePos(objArr);
        if (iDeterminePos < 0) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        boolean z = NativeArrayBufferView.isArg(objArr, 2) && i2 > 1 && ScriptRuntime.toBoolean(objArr[2]);
        double number = objArr.length > 1 ? ScriptRuntime.toNumber(objArr[1]) : Double.NaN;
        if (iDeterminePos + i2 > this.byteLength) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        if (i2 == 4) {
            ByteIo.writeFloat32(this.arrayBuffer.buffer, this.offset + iDeterminePos, number, z);
        } else {
            if (i2 != 8) {
                throw new AssertionError();
            }
            ByteIo.writeFloat64(this.arrayBuffer.buffer, this.offset + iDeterminePos, number, z);
        }
    }

    private void js_setInt(int i2, boolean z, Object[] objArr) {
        int iDeterminePos = determinePos(objArr);
        if (iDeterminePos < 0) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        boolean z2 = NativeArrayBufferView.isArg(objArr, 2) && i2 > 1 && ScriptRuntime.toBoolean(objArr[2]);
        Object obj = ScriptRuntime.zeroObj;
        if (objArr.length > 1) {
            obj = objArr[1];
        }
        if (i2 == 1) {
            if (z) {
                int int8 = Conversions.toInt8(obj);
                if (i2 + iDeterminePos > this.byteLength) {
                    throw ScriptRuntime.rangeError("offset out of range");
                }
                ByteIo.writeInt8(this.arrayBuffer.buffer, this.offset + iDeterminePos, int8);
                return;
            }
            int uint8 = Conversions.toUint8(obj);
            if (i2 + iDeterminePos > this.byteLength) {
                throw ScriptRuntime.rangeError("offset out of range");
            }
            ByteIo.writeUint8(this.arrayBuffer.buffer, this.offset + iDeterminePos, uint8);
            return;
        }
        if (i2 == 2) {
            if (z) {
                int int16 = Conversions.toInt16(obj);
                if (i2 + iDeterminePos > this.byteLength) {
                    throw ScriptRuntime.rangeError("offset out of range");
                }
                ByteIo.writeInt16(this.arrayBuffer.buffer, this.offset + iDeterminePos, int16, z2);
                return;
            }
            int uint16 = Conversions.toUint16(obj);
            if (i2 + iDeterminePos > this.byteLength) {
                throw ScriptRuntime.rangeError("offset out of range");
            }
            ByteIo.writeUint16(this.arrayBuffer.buffer, this.offset + iDeterminePos, uint16, z2);
            return;
        }
        if (i2 != 4) {
            throw new AssertionError();
        }
        if (z) {
            int int32 = Conversions.toInt32(obj);
            if (i2 + iDeterminePos > this.byteLength) {
                throw ScriptRuntime.rangeError("offset out of range");
            }
            ByteIo.writeInt32(this.arrayBuffer.buffer, this.offset + iDeterminePos, int32, z2);
            return;
        }
        long uint32 = Conversions.toUint32(obj);
        if (i2 + iDeterminePos > this.byteLength) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        ByteIo.writeUint32(this.arrayBuffer.buffer, this.offset + iDeterminePos, uint32, z2);
    }

    private void rangeCheck(int i2, int i3) {
        if (i2 < 0 || i2 + i3 > this.byteLength) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
    }

    private static NativeDataView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeDataView) {
            return (NativeDataView) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getClassName())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        switch (iMethodId) {
            case 1:
                return js_constructor(objArr);
            case 2:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, true, objArr);
            case 3:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, false, objArr);
            case 4:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, true, objArr);
            case 5:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, false, objArr);
            case 6:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, true, objArr);
            case 7:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, false, objArr);
            case 8:
                return realThis(scriptable2, idFunctionObject).js_getFloat(4, objArr);
            case 9:
                return realThis(scriptable2, idFunctionObject).js_getFloat(8, objArr);
            case 10:
                realThis(scriptable2, idFunctionObject).js_setInt(1, true, objArr);
                return Undefined.instance;
            case 11:
                realThis(scriptable2, idFunctionObject).js_setInt(1, false, objArr);
                return Undefined.instance;
            case 12:
                realThis(scriptable2, idFunctionObject).js_setInt(2, true, objArr);
                return Undefined.instance;
            case 13:
                realThis(scriptable2, idFunctionObject).js_setInt(2, false, objArr);
                return Undefined.instance;
            case 14:
                realThis(scriptable2, idFunctionObject).js_setInt(4, true, objArr);
                return Undefined.instance;
            case 15:
                realThis(scriptable2, idFunctionObject).js_setInt(4, false, objArr);
                return Undefined.instance;
            case 16:
                realThis(scriptable2, idFunctionObject).js_setFloat(4, objArr);
                return Undefined.instance;
            case 17:
                realThis(scriptable2, idFunctionObject).js_setFloat(8, objArr);
                return Undefined.instance;
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cd  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.typedarrays.NativeDataView.findPrototypeId(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        String str2;
        int i3 = 2;
        switch (i2) {
            case 1:
                i3 = 3;
                str = "constructor";
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 2:
                str2 = "getInt8";
                str = str2;
                i3 = 1;
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 3:
                str2 = "getUint8";
                str = str2;
                i3 = 1;
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 4:
                str2 = "getInt16";
                str = str2;
                i3 = 1;
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 5:
                str2 = "getUint16";
                str = str2;
                i3 = 1;
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 6:
                str2 = "getInt32";
                str = str2;
                i3 = 1;
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 7:
                str2 = "getUint32";
                str = str2;
                i3 = 1;
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 8:
                str2 = "getFloat32";
                str = str2;
                i3 = 1;
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 9:
                str2 = "getFloat64";
                str = str2;
                i3 = 1;
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 10:
                str = "setInt8";
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 11:
                str = "setUint8";
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 12:
                str = "setInt16";
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 13:
                str = "setUint16";
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 14:
                str = "setInt32";
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 15:
                str = "setUint32";
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 16:
                str = "setFloat32";
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            case 17:
                str = "setFloat64";
                initPrototypeMethod(getClassName(), i2, str, i3);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i2));
        }
    }

    public NativeDataView(NativeArrayBuffer nativeArrayBuffer, int i2, int i3) {
        super(nativeArrayBuffer, i2, i3);
    }
}
