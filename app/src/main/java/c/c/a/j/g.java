package c.c.a.j;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class g implements k {
    public final MessageDigest[] a;

    public g(MessageDigest[] messageDigestArr) {
        this.a = messageDigestArr;
    }

    @Override // c.c.a.j.k
    public final void a(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        for (MessageDigest messageDigest : this.a) {
            byteBufferSlice.position(0);
            messageDigest.update(byteBufferSlice);
        }
    }
}
