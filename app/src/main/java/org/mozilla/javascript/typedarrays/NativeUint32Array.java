package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes3.dex */
public class NativeUint32Array extends NativeTypedArrayView<Long> {
    private static final int BYTES_PER_ELEMENT = 4;
    private static final String CLASS_NAME = "Uint32Array";
    private static final long serialVersionUID = -7987831421954144244L;

    public NativeUint32Array() {
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeUint32Array().exportAsJSClass(6, scriptable, z);
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
        return checkIndex(i2) ? Undefined.instance : ByteIo.readUint32(this.arrayBuffer.buffer, (i2 * 4) + this.offset, NativeArrayBufferView.useLittleEndian());
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_set(int i2, Object obj) {
        if (checkIndex(i2)) {
            return Undefined.instance;
        }
        ByteIo.writeUint32(this.arrayBuffer.buffer, (i2 * 4) + this.offset, Conversions.toUint32(obj), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    public NativeUint32Array(NativeArrayBuffer nativeArrayBuffer, int i2, int i3) {
        super(nativeArrayBuffer, i2, i3, i3 * 4);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: construct, reason: avoid collision after fix types in other method */
    public NativeTypedArrayView<Long> construct2(NativeArrayBuffer nativeArrayBuffer, int i2, int i3) {
        return new NativeUint32Array(nativeArrayBuffer, i2, i3);
    }

    @Override // java.util.List, j$.util.List
    public Long get(int i2) {
        if (checkIndex(i2)) {
            throw new IndexOutOfBoundsException();
        }
        return (Long) js_get(i2);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: realThis, reason: avoid collision after fix types in other method */
    public NativeTypedArrayView<Long> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeUint32Array) {
            return (NativeUint32Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // java.util.List, j$.util.List
    public Long set(int i2, Long l2) {
        if (checkIndex(i2)) {
            throw new IndexOutOfBoundsException();
        }
        return (Long) js_set(i2, l2);
    }

    public NativeUint32Array(int i2) {
        this(new NativeArrayBuffer(((double) i2) * 4.0d), 0, i2);
    }
}
