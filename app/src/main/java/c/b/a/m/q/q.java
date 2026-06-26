package c.b.a.m.q;

import androidx.annotation.NonNull;
import java.util.Objects;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: EngineResource.java */
/* JADX INFO: loaded from: classes.dex */
public class q<Z> implements w<Z> {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w<Z> f465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c.b.a.m.j f467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f469g;

    /* JADX INFO: compiled from: EngineResource.java */
    public interface a {
        void a(c.b.a.m.j jVar, q<?> qVar);
    }

    public q(w<Z> wVar, boolean z, boolean z2, c.b.a.m.j jVar, a aVar) {
        Objects.requireNonNull(wVar, "Argument must not be null");
        this.f465c = wVar;
        this.a = z;
        this.f464b = z2;
        this.f467e = jVar;
        Objects.requireNonNull(aVar, "Argument must not be null");
        this.f466d = aVar;
    }

    public synchronized void a() {
        if (this.f469g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f468f++;
    }

    public void b() {
        boolean z;
        synchronized (this) {
            int i2 = this.f468f;
            if (i2 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i3 = i2 - 1;
            this.f468f = i3;
            if (i3 != 0) {
                z = false;
            }
        }
        if (z) {
            this.f466d.a(this.f467e, this);
        }
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public Class<Z> c() {
        return this.f465c.c();
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public Z get() {
        return this.f465c.get();
    }

    @Override // c.b.a.m.q.w
    public int getSize() {
        return this.f465c.getSize();
    }

    @Override // c.b.a.m.q.w
    public synchronized void recycle() {
        if (this.f468f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f469g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f469g = true;
        if (this.f464b) {
            this.f465c.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.a + ", listener=" + this.f466d + ", key=" + this.f467e + ", acquired=" + this.f468f + ", isRecycled=" + this.f469g + ", resource=" + this.f465c + MessageFormatter.DELIM_STOP;
    }
}
