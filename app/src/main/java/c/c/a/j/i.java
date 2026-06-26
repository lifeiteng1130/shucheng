package c.c.a.j;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class i implements l {
    public final ByteBuffer a;

    public i(ByteBuffer byteBuffer) {
        this.a = byteBuffer.slice();
    }

    @Override // c.c.a.j.l
    public final long a() {
        return this.a.capacity();
    }

    @Override // c.c.a.j.l
    public final void a(k kVar, long j2, int i2) {
        ByteBuffer byteBufferSlice;
        synchronized (this.a) {
            this.a.position(0);
            int i3 = (int) j2;
            this.a.limit(i2 + i3);
            this.a.position(i3);
            byteBufferSlice = this.a.slice();
        }
        kVar.a(byteBufferSlice);
    }
}
