package c.b.a.m.r.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.l;
import c.b.a.m.q.w;
import c.b.a.s.a;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: GifDrawableBytesTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements e<GifDrawable, byte[]> {
    @Override // c.b.a.m.r.h.e
    @Nullable
    public w<byte[]> a(@NonNull w<GifDrawable> wVar, @NonNull l lVar) {
        byte[] bArrArray;
        ByteBuffer byteBufferAsReadOnlyBuffer = wVar.get().a.a.a.getData().asReadOnlyBuffer();
        AtomicReference<byte[]> atomicReference = c.b.a.s.a.a;
        a.b bVar = (byteBufferAsReadOnlyBuffer.isReadOnly() || !byteBufferAsReadOnlyBuffer.hasArray()) ? null : new a.b(byteBufferAsReadOnlyBuffer.array(), byteBufferAsReadOnlyBuffer.arrayOffset(), byteBufferAsReadOnlyBuffer.limit());
        if (bVar != null && bVar.a == 0 && bVar.f669b == bVar.f670c.length) {
            bArrArray = byteBufferAsReadOnlyBuffer.array();
        } else {
            ByteBuffer byteBufferAsReadOnlyBuffer2 = byteBufferAsReadOnlyBuffer.asReadOnlyBuffer();
            byte[] bArr = new byte[byteBufferAsReadOnlyBuffer2.limit()];
            byteBufferAsReadOnlyBuffer2.position(0);
            byteBufferAsReadOnlyBuffer2.get(bArr);
            bArrArray = bArr;
        }
        return new c.b.a.m.r.d.b(bArrArray);
    }
}
