package c.b.a.q;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import c.b.a.q.d;

/* JADX INFO: compiled from: ErrorRequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d, c {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final d f633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c f634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    public d.a f636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    public d.a f637f;

    public b(Object obj, @Nullable d dVar) {
        d.a aVar = d.a.CLEARED;
        this.f636e = aVar;
        this.f637f = aVar;
        this.a = obj;
        this.f633b = dVar;
    }

    @Override // c.b.a.q.d, c.b.a.q.c
    public boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.f634c.a() || this.f635d.a();
        }
        return z;
    }

    @Override // c.b.a.q.d
    public void b(c cVar) {
        synchronized (this.a) {
            if (cVar.equals(this.f635d)) {
                this.f637f = d.a.FAILED;
                d dVar = this.f633b;
                if (dVar != null) {
                    dVar.b(this);
                }
                return;
            }
            this.f636e = d.a.FAILED;
            d.a aVar = this.f637f;
            d.a aVar2 = d.a.RUNNING;
            if (aVar != aVar2) {
                this.f637f = aVar2;
                this.f635d.g();
            }
        }
    }

    @Override // c.b.a.q.c
    public boolean c(c cVar) {
        if (!(cVar instanceof b)) {
            return false;
        }
        b bVar = (b) cVar;
        return this.f634c.c(bVar.f634c) && this.f635d.c(bVar.f635d);
    }

    @Override // c.b.a.q.c
    public void clear() {
        synchronized (this.a) {
            d.a aVar = d.a.CLEARED;
            this.f636e = aVar;
            this.f634c.clear();
            if (this.f637f != aVar) {
                this.f637f = aVar;
                this.f635d.clear();
            }
        }
    }

    @Override // c.b.a.q.c
    public boolean d() {
        boolean z;
        synchronized (this.a) {
            d.a aVar = this.f636e;
            d.a aVar2 = d.a.CLEARED;
            z = aVar == aVar2 && this.f637f == aVar2;
        }
        return z;
    }

    @Override // c.b.a.q.d
    public boolean e(c cVar) {
        boolean z;
        synchronized (this.a) {
            d dVar = this.f633b;
            z = true;
            if (!(dVar == null || dVar.e(this)) || !k(cVar)) {
                z = false;
            }
        }
        return z;
    }

    @Override // c.b.a.q.d
    public boolean f(c cVar) {
        boolean z;
        synchronized (this.a) {
            d dVar = this.f633b;
            z = true;
            if (!(dVar == null || dVar.f(this)) || !k(cVar)) {
                z = false;
            }
        }
        return z;
    }

    @Override // c.b.a.q.c
    public void g() {
        synchronized (this.a) {
            d.a aVar = this.f636e;
            d.a aVar2 = d.a.RUNNING;
            if (aVar != aVar2) {
                this.f636e = aVar2;
                this.f634c.g();
            }
        }
    }

    @Override // c.b.a.q.d
    public d getRoot() {
        d root;
        synchronized (this.a) {
            d dVar = this.f633b;
            root = dVar != null ? dVar.getRoot() : this;
        }
        return root;
    }

    @Override // c.b.a.q.d
    public void h(c cVar) {
        synchronized (this.a) {
            if (cVar.equals(this.f634c)) {
                this.f636e = d.a.SUCCESS;
            } else if (cVar.equals(this.f635d)) {
                this.f637f = d.a.SUCCESS;
            }
            d dVar = this.f633b;
            if (dVar != null) {
                dVar.h(this);
            }
        }
    }

    @Override // c.b.a.q.c
    public boolean i() {
        boolean z;
        synchronized (this.a) {
            d.a aVar = this.f636e;
            d.a aVar2 = d.a.SUCCESS;
            z = aVar == aVar2 || this.f637f == aVar2;
        }
        return z;
    }

    @Override // c.b.a.q.c
    public boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            d.a aVar = this.f636e;
            d.a aVar2 = d.a.RUNNING;
            z = aVar == aVar2 || this.f637f == aVar2;
        }
        return z;
    }

    @Override // c.b.a.q.d
    public boolean j(c cVar) {
        boolean z;
        synchronized (this.a) {
            d dVar = this.f633b;
            z = true;
            if (!(dVar == null || dVar.j(this)) || !k(cVar)) {
                z = false;
            }
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final boolean k(c cVar) {
        return cVar.equals(this.f634c) || (this.f636e == d.a.FAILED && cVar.equals(this.f635d));
    }

    @Override // c.b.a.q.c
    public void pause() {
        synchronized (this.a) {
            d.a aVar = this.f636e;
            d.a aVar2 = d.a.RUNNING;
            if (aVar == aVar2) {
                this.f636e = d.a.PAUSED;
                this.f634c.pause();
            }
            if (this.f637f == aVar2) {
                this.f637f = d.a.PAUSED;
                this.f635d.pause();
            }
        }
    }
}
