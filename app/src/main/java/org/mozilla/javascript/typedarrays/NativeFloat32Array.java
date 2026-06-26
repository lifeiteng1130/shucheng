package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes3.dex */
public class NativeFloat32Array extends NativeTypedArrayView<Float> {
    private static final int BYTES_PER_ELEMENT = 4;
    private static final String CLASS_NAME = "Float32Array";
    private static final long serialVersionUID = -8963461831950499340L;

    public NativeFloat32Array() {
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeFloat32Array().exportAsJSClass(6, scriptable, z);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public int getBytesPerElement() {
        return 4;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_get(int i2) {
        return checkIndex(i2) ? Undefined.instance : ByteIo.readFloat32(this.arrayBuffer.buffer, (i2 * 4) + this.offset, NativeArrayBufferView.useLittleEndian());
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_set(int i2, Object obj) {
        if (checkIndex(i2)) {
            return Undefined.instance;
        }
        ByteIo.writeFloat32(this.arrayBuffer.buffer, (i2 * 4) + this.offset, ScriptRuntime.toNumber(obj), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    public NativeFloat32Array(NativeArrayBuffer nativeArrayBuffer, int i2, int i3) {
        super(nativeArrayBuffer, i2, i3, i3 * 4);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: construct */
    public NativeTypedArrayView<Float> construct2(NativeArrayBuffer nativeArrayBuffer, int i2, int i3) {
        return new NativeFloat32Array(nativeArrayBuffer, i2, i3);
    }

    @Override // java.util.List, j$.util.List
    public Float get(int i2) {
        if (checkIndex(i2)) {
            throw new IndexOutOfBoundsException();
        }
        return (Float) js_get(i2);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: realThis */
    public NativeTypedArrayView<Float> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeFloat32Array) {
            return (NativeFloat32Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // java.util.List, j$.util.List
    public Float set(int i2, Float f2) {
        if (checkIndex(i2)) {
            throw new IndexOutOfBoundsException();
        }
        return (Float) js_set(i2, f2);
    }

    public NativeFloat32Array(int i2) {
        this(new NativeArrayBuffer(((double) i2) * 4.0d), 0, i2);
    }
}
