package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes3.dex */
public class NativeUint16Array extends NativeTypedArrayView<Integer> {
    private static final int BYTES_PER_ELEMENT = 2;
    private static final String CLASS_NAME = "Uint16Array";
    private static final long serialVersionUID = 7700018949434240321L;

    public NativeUint16Array() {
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeUint16Array().exportAsJSClass(6, scriptable, z);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public int getBytesPerElement() {
        return 2;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_get(int i2) {
        return checkIndex(i2) ? Undefined.instance : ByteIo.readUint16(this.arrayBuffer.buffer, (i2 * 2) + this.offset, NativeArrayBufferView.useLittleEndian());
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public Object js_set(int i2, Object obj) {
        if (checkIndex(i2)) {
            return Undefined.instance;
        }
        ByteIo.writeUint16(this.arrayBuffer.buffer, (i2 * 2) + this.offset, Conversions.toUint16(obj), NativeArrayBufferView.useLittleEndian());
        return null;
    }

    public NativeUint16Array(NativeArrayBuffer nativeArrayBuffer, int i2, int i3) {
        super(nativeArrayBuffer, i2, i3, i3 * 2);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: construct, reason: avoid collision after fix types in other method */
    public NativeTypedArrayView<Integer> construct2(NativeArrayBuffer nativeArrayBuffer, int i2, int i3) {
        return new NativeUint16Array(nativeArrayBuffer, i2, i3);
    }

    @Override // java.util.List, j$.util.List
    public Integer get(int i2) {
        if (checkIndex(i2)) {
            throw new IndexOutOfBoundsException();
        }
        return (Integer) js_get(i2);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    /* JADX INFO: renamed from: realThis, reason: avoid collision after fix types in other method */
    public NativeTypedArrayView<Integer> realThis2(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeUint16Array) {
            return (NativeUint16Array) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // java.util.List, j$.util.List
    public Integer set(int i2, Integer num) {
        if (checkIndex(i2)) {
            throw new IndexOutOfBoundsException();
        }
        return (Integer) js_set(i2, num);
    }

    public NativeUint16Array(int i2) {
        this(new NativeArrayBuffer(((double) i2) * 2.0d), 0, i2);
    }
}
