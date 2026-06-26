package c.b.a.m.q;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import c.b.a.s.j.a;
import c.b.a.s.j.d;
import java.util.Objects;

/* JADX INFO: compiled from: LockedResource.java */
/* JADX INFO: loaded from: classes.dex */
public final class v<Z> implements w<Z>, a.d {
    public static final Pools.Pool<v<?>> a = c.b.a.s.j.a.a(20, new a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b.a.s.j.d f474b = new d.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w<Z> f475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f477e;

    /* JADX INFO: compiled from: LockedResource.java */
    public class a implements a.b<v<?>> {
        @Override // c.b.a.s.j.a.b
        public v<?> a() {
            return new v<>();
        }
    }

    @NonNull
    public static <Z> v<Z> a(w<Z> wVar) {
        v<Z> vVar = (v) a.acquire();
        Objects.requireNonNull(vVar, "Argument must not be null");
        vVar.f477e = false;
        vVar.f476d = true;
        vVar.f475c = wVar;
        return vVar;
    }

    @Override // c.b.a.s.j.a.d
    @NonNull
    public c.b.a.s.j.d b() {
        return this.f474b;
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public Class<Z> c() {
        return this.f475c.c();
    }

    public synchronized void d() {
        this.f474b.a();
        if (!this.f476d) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f476d = false;
        if (this.f477e) {
            recycle();
        }
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public Z get() {
        return this.f475c.get();
    }

    @Override // c.b.a.m.q.w
    public int getSize() {
        return this.f475c.getSize();
    }

    @Override // c.b.a.m.q.w
    public synchronized void recycle() {
        this.f474b.a();
        this.f477e = true;
        if (!this.f476d) {
            this.f475c.recycle();
            this.f475c = null;
            a.release(this);
        }
    }
}
