package c.b.a.q;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.j;
import c.b.a.m.l;
import c.b.a.m.p;
import c.b.a.m.q.k;
import c.b.a.m.r.c.o;
import c.b.a.q.a;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: BaseRequestOptions.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    public int a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public Drawable f625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Drawable f627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f628h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public j f632l;
    public boolean m;
    public boolean n;

    @Nullable
    public Drawable o;
    public int p;

    @NonNull
    public l q;

    @NonNull
    public Map<Class<?>, p<?>> r;

    @NonNull
    public Class<?> s;
    public boolean t;

    @Nullable
    public Resources.Theme u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f622b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public k f623c = k.f421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public c.b.a.f f624d = c.b.a.f.NORMAL;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f629i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f630j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f631k = -1;

    public a() {
        c.b.a.r.a aVar = c.b.a.r.a.f666b;
        this.f632l = c.b.a.r.a.f666b;
        this.n = true;
        this.q = new l();
        this.r = new CachedHashCodeArrayMap();
        this.s = Object.class;
        this.y = true;
    }

    public static boolean j(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    @NonNull
    @CheckResult
    public T a(@NonNull a<?> aVar) {
        if (this.v) {
            return (T) d().a(aVar);
        }
        if (j(aVar.a, 2)) {
            this.f622b = aVar.f622b;
        }
        if (j(aVar.a, 262144)) {
            this.w = aVar.w;
        }
        if (j(aVar.a, 1048576)) {
            this.z = aVar.z;
        }
        if (j(aVar.a, 4)) {
            this.f623c = aVar.f623c;
        }
        if (j(aVar.a, 8)) {
            this.f624d = aVar.f624d;
        }
        if (j(aVar.a, 16)) {
            this.f625e = aVar.f625e;
            this.f626f = 0;
            this.a &= -33;
        }
        if (j(aVar.a, 32)) {
            this.f626f = aVar.f626f;
            this.f625e = null;
            this.a &= -17;
        }
        if (j(aVar.a, 64)) {
            this.f627g = aVar.f627g;
            this.f628h = 0;
            this.a &= -129;
        }
        if (j(aVar.a, 128)) {
            this.f628h = aVar.f628h;
            this.f627g = null;
            this.a &= -65;
        }
        if (j(aVar.a, 256)) {
            this.f629i = aVar.f629i;
        }
        if (j(aVar.a, 512)) {
            this.f631k = aVar.f631k;
            this.f630j = aVar.f630j;
        }
        if (j(aVar.a, 1024)) {
            this.f632l = aVar.f632l;
        }
        if (j(aVar.a, 4096)) {
            this.s = aVar.s;
        }
        if (j(aVar.a, 8192)) {
            this.o = aVar.o;
            this.p = 0;
            this.a &= -16385;
        }
        if (j(aVar.a, 16384)) {
            this.p = aVar.p;
            this.o = null;
            this.a &= -8193;
        }
        if (j(aVar.a, 32768)) {
            this.u = aVar.u;
        }
        if (j(aVar.a, 65536)) {
            this.n = aVar.n;
        }
        if (j(aVar.a, 131072)) {
            this.m = aVar.m;
        }
        if (j(aVar.a, 2048)) {
            this.r.putAll(aVar.r);
            this.y = aVar.y;
        }
        if (j(aVar.a, 524288)) {
            this.x = aVar.x;
        }
        if (!this.n) {
            this.r.clear();
            int i2 = this.a & (-2049);
            this.a = i2;
            this.m = false;
            this.a = i2 & (-131073);
            this.y = true;
        }
        this.a |= aVar.a;
        this.q.c(aVar.q);
        p();
        return this;
    }

    @NonNull
    public T b() {
        if (this.t && !this.v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.v = true;
        this.t = true;
        return this;
    }

    @NonNull
    @CheckResult
    public T c() {
        return (T) u(c.b.a.m.r.c.l.f519c, new c.b.a.m.r.c.i());
    }

    @Override // 
    @CheckResult
    public T d() {
        try {
            T t = (T) super.clone();
            l lVar = new l();
            t.q = lVar;
            lVar.c(this.q);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.r);
            t.t = false;
            t.v = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    @CheckResult
    public T e(@NonNull Class<?> cls) {
        if (this.v) {
            return (T) d().e(cls);
        }
        Objects.requireNonNull(cls, "Argument must not be null");
        this.s = cls;
        this.a |= 4096;
        p();
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.f622b, this.f622b) == 0 && this.f626f == aVar.f626f && c.b.a.s.i.b(this.f625e, aVar.f625e) && this.f628h == aVar.f628h && c.b.a.s.i.b(this.f627g, aVar.f627g) && this.p == aVar.p && c.b.a.s.i.b(this.o, aVar.o) && this.f629i == aVar.f629i && this.f630j == aVar.f630j && this.f631k == aVar.f631k && this.m == aVar.m && this.n == aVar.n && this.w == aVar.w && this.x == aVar.x && this.f623c.equals(aVar.f623c) && this.f624d == aVar.f624d && this.q.equals(aVar.q) && this.r.equals(aVar.r) && this.s.equals(aVar.s) && c.b.a.s.i.b(this.f632l, aVar.f632l) && c.b.a.s.i.b(this.u, aVar.u);
    }

    @NonNull
    @CheckResult
    public T f(@NonNull k kVar) {
        if (this.v) {
            return (T) d().f(kVar);
        }
        Objects.requireNonNull(kVar, "Argument must not be null");
        this.f623c = kVar;
        this.a |= 4;
        p();
        return this;
    }

    @NonNull
    @CheckResult
    public T g(@DrawableRes int i2) {
        if (this.v) {
            return (T) d().g(i2);
        }
        this.f626f = i2;
        int i3 = this.a | 32;
        this.a = i3;
        this.f625e = null;
        this.a = i3 & (-17);
        p();
        return this;
    }

    @NonNull
    @CheckResult
    public T h(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) d().h(drawable);
        }
        this.f625e = drawable;
        int i2 = this.a | 16;
        this.a = i2;
        this.f626f = 0;
        this.a = i2 & (-33);
        p();
        return this;
    }

    public int hashCode() {
        float f2 = this.f622b;
        char[] cArr = c.b.a.s.i.a;
        return c.b.a.s.i.g(this.u, c.b.a.s.i.g(this.f632l, c.b.a.s.i.g(this.s, c.b.a.s.i.g(this.r, c.b.a.s.i.g(this.q, c.b.a.s.i.g(this.f624d, c.b.a.s.i.g(this.f623c, (((((((((((((c.b.a.s.i.g(this.o, (c.b.a.s.i.g(this.f627g, (c.b.a.s.i.g(this.f625e, ((Float.floatToIntBits(f2) + 527) * 31) + this.f626f) * 31) + this.f628h) * 31) + this.p) * 31) + (this.f629i ? 1 : 0)) * 31) + this.f630j) * 31) + this.f631k) * 31) + (this.m ? 1 : 0)) * 31) + (this.n ? 1 : 0)) * 31) + (this.w ? 1 : 0)) * 31) + (this.x ? 1 : 0))))))));
    }

    public final boolean i(int i2) {
        return j(this.a, i2);
    }

    @NonNull
    public final T k(@NonNull c.b.a.m.r.c.l lVar, @NonNull p<Bitmap> pVar) {
        if (this.v) {
            return (T) d().k(lVar, pVar);
        }
        c.b.a.m.k kVar = c.b.a.m.r.c.l.f522f;
        Objects.requireNonNull(lVar, "Argument must not be null");
        q(kVar, lVar);
        return (T) t(pVar, false);
    }

    @NonNull
    @CheckResult
    public T l(int i2, int i3) {
        if (this.v) {
            return (T) d().l(i2, i3);
        }
        this.f631k = i2;
        this.f630j = i3;
        this.a |= 512;
        p();
        return this;
    }

    @NonNull
    @CheckResult
    public T m(@DrawableRes int i2) {
        if (this.v) {
            return (T) d().m(i2);
        }
        this.f628h = i2;
        int i3 = this.a | 128;
        this.a = i3;
        this.f627g = null;
        this.a = i3 & (-65);
        p();
        return this;
    }

    @NonNull
    @CheckResult
    public T n(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) d().n(drawable);
        }
        this.f627g = drawable;
        int i2 = this.a | 64;
        this.a = i2;
        this.f628h = 0;
        this.a = i2 & (-129);
        p();
        return this;
    }

    @NonNull
    @CheckResult
    public T o(@NonNull c.b.a.f fVar) {
        if (this.v) {
            return (T) d().o(fVar);
        }
        Objects.requireNonNull(fVar, "Argument must not be null");
        this.f624d = fVar;
        this.a |= 8;
        p();
        return this;
    }

    @NonNull
    public final T p() {
        if (this.t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    @NonNull
    @CheckResult
    public <Y> T q(@NonNull c.b.a.m.k<Y> kVar, @NonNull Y y) {
        if (this.v) {
            return (T) d().q(kVar, y);
        }
        Objects.requireNonNull(kVar, "Argument must not be null");
        Objects.requireNonNull(y, "Argument must not be null");
        this.q.f313b.put(kVar, y);
        p();
        return this;
    }

    @NonNull
    @CheckResult
    public T r(@NonNull j jVar) {
        if (this.v) {
            return (T) d().r(jVar);
        }
        Objects.requireNonNull(jVar, "Argument must not be null");
        this.f632l = jVar;
        this.a |= 1024;
        p();
        return this;
    }

    @NonNull
    @CheckResult
    public T s(boolean z) {
        if (this.v) {
            return (T) d().s(true);
        }
        this.f629i = !z;
        this.a |= 256;
        p();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T t(@NonNull p<Bitmap> pVar, boolean z) {
        if (this.v) {
            return (T) d().t(pVar, z);
        }
        o oVar = new o(pVar, z);
        v(Bitmap.class, pVar, z);
        v(Drawable.class, oVar, z);
        v(BitmapDrawable.class, oVar, z);
        v(GifDrawable.class, new c.b.a.m.r.g.e(pVar), z);
        p();
        return this;
    }

    @NonNull
    @CheckResult
    public final T u(@NonNull c.b.a.m.r.c.l lVar, @NonNull p<Bitmap> pVar) {
        if (this.v) {
            return (T) d().u(lVar, pVar);
        }
        c.b.a.m.k kVar = c.b.a.m.r.c.l.f522f;
        Objects.requireNonNull(lVar, "Argument must not be null");
        q(kVar, lVar);
        return (T) t(pVar, true);
    }

    @NonNull
    public <Y> T v(@NonNull Class<Y> cls, @NonNull p<Y> pVar, boolean z) {
        if (this.v) {
            return (T) d().v(cls, pVar, z);
        }
        Objects.requireNonNull(cls, "Argument must not be null");
        Objects.requireNonNull(pVar, "Argument must not be null");
        this.r.put(cls, pVar);
        int i2 = this.a | 2048;
        this.a = i2;
        this.n = true;
        int i3 = i2 | 65536;
        this.a = i3;
        this.y = false;
        if (z) {
            this.a = i3 | 131072;
            this.m = true;
        }
        p();
        return this;
    }

    @NonNull
    @CheckResult
    public T w(boolean z) {
        if (this.v) {
            return (T) d().w(z);
        }
        this.z = z;
        this.a |= 1048576;
        p();
        return this;
    }
}
