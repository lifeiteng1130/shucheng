package c.b.a.m.q;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Objects;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: EngineKey.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements c.b.a.m.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Class<?> f458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<?> f459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c.b.a.m.j f460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Class<?>, c.b.a.m.p<?>> f461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c.b.a.m.l f462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f463j;

    public o(Object obj, c.b.a.m.j jVar, int i2, int i3, Map<Class<?>, c.b.a.m.p<?>> map, Class<?> cls, Class<?> cls2, c.b.a.m.l lVar) {
        Objects.requireNonNull(obj, "Argument must not be null");
        this.f455b = obj;
        Objects.requireNonNull(jVar, "Signature must not be null");
        this.f460g = jVar;
        this.f456c = i2;
        this.f457d = i3;
        Objects.requireNonNull(map, "Argument must not be null");
        this.f461h = map;
        Objects.requireNonNull(cls, "Resource class must not be null");
        this.f458e = cls;
        Objects.requireNonNull(cls2, "Transcode class must not be null");
        this.f459f = cls2;
        Objects.requireNonNull(lVar, "Argument must not be null");
        this.f462i = lVar;
    }

    @Override // c.b.a.m.j
    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f455b.equals(oVar.f455b) && this.f460g.equals(oVar.f460g) && this.f457d == oVar.f457d && this.f456c == oVar.f456c && this.f461h.equals(oVar.f461h) && this.f458e.equals(oVar.f458e) && this.f459f.equals(oVar.f459f) && this.f462i.equals(oVar.f462i);
    }

    @Override // c.b.a.m.j
    public int hashCode() {
        if (this.f463j == 0) {
            int iHashCode = this.f455b.hashCode();
            this.f463j = iHashCode;
            int iHashCode2 = this.f460g.hashCode() + (iHashCode * 31);
            this.f463j = iHashCode2;
            int i2 = (iHashCode2 * 31) + this.f456c;
            this.f463j = i2;
            int i3 = (i2 * 31) + this.f457d;
            this.f463j = i3;
            int iHashCode3 = this.f461h.hashCode() + (i3 * 31);
            this.f463j = iHashCode3;
            int iHashCode4 = this.f458e.hashCode() + (iHashCode3 * 31);
            this.f463j = iHashCode4;
            int iHashCode5 = this.f459f.hashCode() + (iHashCode4 * 31);
            this.f463j = iHashCode5;
            this.f463j = this.f462i.hashCode() + (iHashCode5 * 31);
        }
        return this.f463j;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("EngineKey{model=");
        sbR.append(this.f455b);
        sbR.append(", width=");
        sbR.append(this.f456c);
        sbR.append(", height=");
        sbR.append(this.f457d);
        sbR.append(", resourceClass=");
        sbR.append(this.f458e);
        sbR.append(", transcodeClass=");
        sbR.append(this.f459f);
        sbR.append(", signature=");
        sbR.append(this.f460g);
        sbR.append(", hashCode=");
        sbR.append(this.f463j);
        sbR.append(", transformations=");
        sbR.append(this.f461h);
        sbR.append(", options=");
        sbR.append(this.f462i);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }

    @Override // c.b.a.m.j
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
