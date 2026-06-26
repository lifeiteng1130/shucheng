package c.b.a.m.q;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: DataCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements c.b.a.m.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b.a.m.j f380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b.a.m.j f381c;

    public e(c.b.a.m.j jVar, c.b.a.m.j jVar2) {
        this.f380b = jVar;
        this.f381c = jVar2;
    }

    @Override // c.b.a.m.j
    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f380b.equals(eVar.f380b) && this.f381c.equals(eVar.f381c);
    }

    @Override // c.b.a.m.j
    public int hashCode() {
        return this.f381c.hashCode() + (this.f380b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("DataCacheKey{sourceKey=");
        sbR.append(this.f380b);
        sbR.append(", signature=");
        sbR.append(this.f381c);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }

    @Override // c.b.a.m.j
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f380b.updateDiskCacheKey(messageDigest);
        this.f381c.updateDiskCacheKey(messageDigest);
    }
}
