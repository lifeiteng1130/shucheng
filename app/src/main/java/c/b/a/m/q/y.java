package c.b.a.m.q;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: ResourceCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
public final class y implements c.b.a.m.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c.b.a.s.f<Class<?>, byte[]> f487b = new c.b.a.s.f<>(50);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b.a.m.q.c0.b f488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.b.a.m.j f489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c.b.a.m.j f490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class<?> f493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c.b.a.m.l f494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c.b.a.m.p<?> f495j;

    public y(c.b.a.m.q.c0.b bVar, c.b.a.m.j jVar, c.b.a.m.j jVar2, int i2, int i3, c.b.a.m.p<?> pVar, Class<?> cls, c.b.a.m.l lVar) {
        this.f488c = bVar;
        this.f489d = jVar;
        this.f490e = jVar2;
        this.f491f = i2;
        this.f492g = i3;
        this.f495j = pVar;
        this.f493h = cls;
        this.f494i = lVar;
    }

    @Override // c.b.a.m.j
    public boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f492g == yVar.f492g && this.f491f == yVar.f491f && c.b.a.s.i.b(this.f495j, yVar.f495j) && this.f493h.equals(yVar.f493h) && this.f489d.equals(yVar.f489d) && this.f490e.equals(yVar.f490e) && this.f494i.equals(yVar.f494i);
    }

    @Override // c.b.a.m.j
    public int hashCode() {
        int iHashCode = ((((this.f490e.hashCode() + (this.f489d.hashCode() * 31)) * 31) + this.f491f) * 31) + this.f492g;
        c.b.a.m.p<?> pVar = this.f495j;
        if (pVar != null) {
            iHashCode = (iHashCode * 31) + pVar.hashCode();
        }
        return this.f494i.hashCode() + ((this.f493h.hashCode() + (iHashCode * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("ResourceCacheKey{sourceKey=");
        sbR.append(this.f489d);
        sbR.append(", signature=");
        sbR.append(this.f490e);
        sbR.append(", width=");
        sbR.append(this.f491f);
        sbR.append(", height=");
        sbR.append(this.f492g);
        sbR.append(", decodedResourceClass=");
        sbR.append(this.f493h);
        sbR.append(", transformation='");
        sbR.append(this.f495j);
        sbR.append('\'');
        sbR.append(", options=");
        sbR.append(this.f494i);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }

    @Override // c.b.a.m.j
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f488c.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f491f).putInt(this.f492g).array();
        this.f490e.updateDiskCacheKey(messageDigest);
        this.f489d.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        c.b.a.m.p<?> pVar = this.f495j;
        if (pVar != null) {
            pVar.updateDiskCacheKey(messageDigest);
        }
        this.f494i.updateDiskCacheKey(messageDigest);
        c.b.a.s.f<Class<?>, byte[]> fVar = f487b;
        byte[] bytes = fVar.get(this.f493h);
        if (bytes == null) {
            bytes = this.f493h.getName().getBytes(c.b.a.m.j.a);
            fVar.put(this.f493h, bytes);
        }
        messageDigest.update(bytes);
        this.f488c.d(bArr);
    }
}
