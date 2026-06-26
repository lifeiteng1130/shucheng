package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeArrayBufferView extends IdScriptableObject {
    private static final int Id_buffer = 1;
    private static final int Id_byteLength = 3;
    private static final int Id_byteOffset = 2;
    public static final int MAX_INSTANCE_ID = 3;
    private static final long serialVersionUID = 6884475582973958419L;
    private static Boolean useLittleEndian;
    public final NativeArrayBuffer arrayBuffer;
    public final int byteLength;
    public final int offset;

    public NativeArrayBufferView() {
        this.arrayBuffer = new NativeArrayBuffer();
        this.offset = 0;
        this.byteLength = 0;
    }

    public static boolean isArg(Object[] objArr, int i2) {
        return objArr.length > i2 && !Undefined.instance.equals(objArr[i2]);
    }

    public static boolean useLittleEndian() {
        if (useLittleEndian == null) {
            Context currentContext = Context.getCurrentContext();
            if (currentContext == null) {
                return false;
            }
            useLittleEndian = Boolean.valueOf(currentContext.hasFeature(19));
        }
        return useLittleEndian.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findInstanceIdInfo(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.length()
            r1 = 0
            r2 = 6
            if (r0 != r2) goto Lc
            r0 = 1
            java.lang.String r2 = "buffer"
            goto L27
        Lc:
            r2 = 10
            if (r0 != r2) goto L25
            r0 = 4
            char r0 = r4.charAt(r0)
            r2 = 76
            if (r0 != r2) goto L1d
            r0 = 3
            java.lang.String r2 = "byteLength"
            goto L27
        L1d:
            r2 = 79
            if (r0 != r2) goto L25
            r0 = 2
            java.lang.String r2 = "byteOffset"
            goto L27
        L25:
            r2 = 0
            r0 = 0
        L27:
            if (r2 == 0) goto L32
            if (r2 == r4) goto L32
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L32
            goto L33
        L32:
            r1 = r0
        L33:
            if (r1 != 0) goto L3a
            int r4 = super.findInstanceIdInfo(r4)
            return r4
        L3a:
            r4 = 5
            int r4 = org.mozilla.javascript.IdScriptableObject.instanceIdInfo(r4, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.typedarrays.NativeArrayBufferView.findInstanceIdInfo(java.lang.String):int");
    }

    public NativeArrayBuffer getBuffer() {
        return this.arrayBuffer;
    }

    public int getByteLength() {
        return this.byteLength;
    }

    public int getByteOffset() {
        return this.offset;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? super.getInstanceIdName(i2) : "byteLength" : "byteOffset" : "buffer";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? super.getInstanceIdValue(i2) : ScriptRuntime.wrapInt(this.byteLength) : ScriptRuntime.wrapInt(this.offset) : this.arrayBuffer;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 3;
    }

    public NativeArrayBufferView(NativeArrayBuffer nativeArrayBuffer, int i2, int i3) {
        this.offset = i2;
        this.byteLength = i3;
        this.arrayBuffer = nativeArrayBuffer;
    }
}
