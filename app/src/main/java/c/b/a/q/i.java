package c.b.a.q;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import c.b.a.q.d;

/* JADX INFO: compiled from: ThumbnailRequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements d, c {

    @Nullable
    public final d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c f650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    public d.a f652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    public d.a f653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("requestLock")
    public boolean f654g;

    public i(Object obj, @Nullable d dVar) {
        d.a aVar = d.a.CLEARED;
        this.f652e = aVar;
        this.f653f = aVar;
        this.f649b = obj;
        this.a = dVar;
    }

    @Override // c.b.a.q.d, c.b.a.q.c
    public boolean a() {
        boolean z;
        synchronized (this.f649b) {
            z = this.f651d.a() || this.f650c.a();
        }
        return z;
    }

    @Override // c.b.a.q.d
    public void b(c cVar) {
        synchronized (this.f649b) {
            if (!cVar.equals(this.f650c)) {
                this.f653f = d.a.FAILED;
                return;
            }
            this.f652e = d.a.FAILED;
            d dVar = this.a;
            if (dVar != null) {
                dVar.b(this);
            }
        }
    }

    @Override // c.b.a.q.c
    public boolean c(c cVar) {
        if (!(cVar instanceof i)) {
            return false;
        }
        i iVar = (i) cVar;
        if (this.f650c == null) {
            if (iVar.f650c != null) {
                return false;
            }
        } else if (!this.f650c.c(iVar.f650c)) {
            return false;
        }
        if (this.f651d == null) {
            if (iVar.f651d != null) {
                return false;
            }
        } else if (!this.f651d.c(iVar.f651d)) {
            return false;
        }
        return true;
    }

    @Override // c.b.a.q.c
    public void clear() {
        synchronized (this.f649b) {
            this.f654g = false;
            d.a aVar = d.a.CLEARED;
            this.f652e = aVar;
            this.f653f = aVar;
            this.f651d.clear();
            this.f650c.clear();
        }
    }

    @Override // c.b.a.q.c
    public boolean d() {
        boolean z;
        synchronized (this.f649b) {
            z = this.f652e == d.a.CLEARED;
        }
        return z;
    }

    @Override // c.b.a.q.d
    public boolean e(c cVar) {
        boolean z;
        synchronized (this.f649b) {
            d dVar = this.a;
            z = true;
            if (!(dVar == null || dVar.e(this)) || !cVar.equals(this.f650c) || a()) {
                z = false;
            }
        }
        return z;
    }

    @Override // c.b.a.q.d
    public boolean f(c cVar) {
        boolean z;
        synchronized (this.f649b) {
            d dVar = this.a;
            z = true;
            if (!(dVar == null || dVar.f(this)) || (!cVar.equals(this.f650c) && this.f652e == d.a.SUCCESS)) {
                z = false;
            }
        }
        return z;
    }

    @Override // c.b.a.q.c
    public void g() {
        synchronized (this.f649b) {
            this.f654g = true;
            try {
                if (this.f652e != d.a.SUCCESS) {
                    d.a aVar = this.f653f;
                    d.a aVar2 = d.a.RUNNING;
                    if (aVar != aVar2) {
                        this.f653f = aVar2;
                        this.f651d.g();
                    }
                }
                if (this.f654g) {
                    d.a aVar3 = this.f652e;
                    d.a aVar4 = d.a.RUNNING;
                    if (aVar3 != aVar4) {
                        this.f652e = aVar4;
                        this.f650c.g();
                    }
                }
            } finally {
                this.f654g = false;
            }
        }
    }

    @Override // c.b.a.q.d
    public d getRoot() {
        d root;
        synchronized (this.f649b) {
            d dVar = this.a;
            root = dVar != null ? dVar.getRoot() : this;
        }
        return root;
    }

    @Override // c.b.a.q.d
    public void h(c cVar) {
        synchronized (this.f649b) {
            if (cVar.equals(this.f651d)) {
                this.f653f = d.a.SUCCESS;
                return;
            }
            this.f652e = d.a.SUCCESS;
            d dVar = this.a;
            if (dVar != null) {
                dVar.h(this);
            }
            if (!this.f653f.isComplete()) {
                this.f651d.clear();
            }
        }
    }

    @Override // c.b.a.q.c
    public boolean i() {
        boolean z;
        synchronized (this.f649b) {
            z = this.f652e == d.a.SUCCESS;
        }
        return z;
    }

    @Override // c.b.a.q.c
    public boolean isRunning() {
        boolean z;
        synchronized (this.f649b) {
            z = this.f652e == d.a.RUNNING;
        }
        return z;
    }

    @Override // c.b.a.q.d
    public boolean j(c cVar) {
        boolean z;
        synchronized (this.f649b) {
            d dVar = this.a;
            z = true;
            if (!(dVar == null || dVar.j(this)) || !cVar.equals(this.f650c) || this.f652e == d.a.PAUSED) {
                z = false;
            }
        }
        return z;
    }

    @Override // c.b.a.q.c
    public void pause() {
        synchronized (this.f649b) {
            if (!this.f653f.isComplete()) {
                this.f653f = d.a.PAUSED;
                this.f651d.pause();
            }
            if (!this.f652e.isComplete()) {
                this.f652e = d.a.PAUSED;
                this.f650c.pause();
            }
        }
    }
}
