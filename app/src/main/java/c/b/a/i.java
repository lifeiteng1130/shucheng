package c.b.a;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import c.b.a.c;
import c.b.a.m.q.k;
import c.b.a.n.c;
import c.b.a.n.l;
import c.b.a.n.m;
import c.b.a.n.n;
import c.b.a.n.q;
import c.b.a.n.r;
import c.b.a.n.s;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: RequestManager.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements ComponentCallbacks2, m {
    public static final c.b.a.q.f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b.a.b f235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    public final r f238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    public final q f239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("this")
    public final s f240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c.b.a.n.c f242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList<c.b.a.q.e<Object>> f243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("this")
    public c.b.a.q.f f244k;

    /* JADX INFO: compiled from: RequestManager.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            iVar.f237d.a(iVar);
        }
    }

    /* JADX INFO: compiled from: RequestManager.java */
    public class b implements c.a {

        @GuardedBy("RequestManager.this")
        public final r a;

        public b(@NonNull r rVar) {
            this.a = rVar;
        }
    }

    static {
        c.b.a.q.f fVarE = new c.b.a.q.f().e(Bitmap.class);
        fVarE.t = true;
        a = fVarE;
        new c.b.a.q.f().e(GifDrawable.class).t = true;
        c.b.a.q.f.y(k.f420b).o(f.LOW).s(true);
    }

    public i(@NonNull c.b.a.b bVar, @NonNull l lVar, @NonNull q qVar, @NonNull Context context) {
        c.b.a.q.f fVar;
        r rVar = new r();
        c.b.a.n.d dVar = bVar.f202i;
        this.f240g = new s();
        a aVar = new a();
        this.f241h = aVar;
        this.f235b = bVar;
        this.f237d = lVar;
        this.f239f = qVar;
        this.f238e = rVar;
        this.f236c = context;
        Context applicationContext = context.getApplicationContext();
        b bVar2 = new b(rVar);
        Objects.requireNonNull((c.b.a.n.f) dVar);
        boolean z = ContextCompat.checkSelfPermission(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
        Log.isLoggable("ConnectivityMonitor", 3);
        c.b.a.n.c eVar = z ? new c.b.a.n.e(applicationContext, bVar2) : new n();
        this.f242i = eVar;
        if (c.b.a.s.i.h()) {
            c.b.a.s.i.f().post(aVar);
        } else {
            lVar.a(this);
        }
        lVar.a(eVar);
        this.f243j = new CopyOnWriteArrayList<>(bVar.f198e.f219f);
        d dVar2 = bVar.f198e;
        synchronized (dVar2) {
            if (dVar2.f224k == null) {
                Objects.requireNonNull((c.a) dVar2.f218e);
                c.b.a.q.f fVar2 = new c.b.a.q.f();
                fVar2.t = true;
                dVar2.f224k = fVar2;
            }
            fVar = dVar2.f224k;
        }
        synchronized (this) {
            c.b.a.q.f fVarD = fVar.d();
            fVarD.b();
            this.f244k = fVarD;
        }
        synchronized (bVar.f203j) {
            if (bVar.f203j.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            bVar.f203j.add(this);
        }
    }

    @NonNull
    @CheckResult
    public h<Drawable> i() {
        return new h<>(this.f235b, this, Drawable.class, this.f236c);
    }

    public void j(@Nullable c.b.a.q.j.h<?> hVar) {
        boolean z;
        if (hVar == null) {
            return;
        }
        boolean zN = n(hVar);
        c.b.a.q.c cVarF = hVar.f();
        if (zN) {
            return;
        }
        c.b.a.b bVar = this.f235b;
        synchronized (bVar.f203j) {
            Iterator<i> it = bVar.f203j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().n(hVar)) {
                    z = true;
                    break;
                }
            }
        }
        if (z || cVarF == null) {
            return;
        }
        hVar.c(null);
        cVarF.clear();
    }

    @NonNull
    @CheckResult
    public h<Drawable> k(@Nullable String str) {
        return i().G(str);
    }

    public synchronized void l() {
        r rVar = this.f238e;
        rVar.f613c = true;
        for (c.b.a.q.c cVar : (ArrayList) c.b.a.s.i.e(rVar.a)) {
            if (cVar.isRunning()) {
                cVar.pause();
                rVar.f612b.add(cVar);
            }
        }
    }

    public synchronized void m() {
        r rVar = this.f238e;
        rVar.f613c = false;
        for (c.b.a.q.c cVar : (ArrayList) c.b.a.s.i.e(rVar.a)) {
            if (!cVar.i() && !cVar.isRunning()) {
                cVar.g();
            }
        }
        rVar.f612b.clear();
    }

    public synchronized boolean n(@NonNull c.b.a.q.j.h<?> hVar) {
        c.b.a.q.c cVarF = hVar.f();
        if (cVarF == null) {
            return true;
        }
        if (!this.f238e.a(cVarF)) {
            return false;
        }
        this.f240g.a.remove(hVar);
        hVar.c(null);
        return true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // c.b.a.n.m
    public synchronized void onDestroy() {
        this.f240g.onDestroy();
        Iterator it = c.b.a.s.i.e(this.f240g.a).iterator();
        while (it.hasNext()) {
            j((c.b.a.q.j.h) it.next());
        }
        this.f240g.a.clear();
        r rVar = this.f238e;
        Iterator it2 = ((ArrayList) c.b.a.s.i.e(rVar.a)).iterator();
        while (it2.hasNext()) {
            rVar.a((c.b.a.q.c) it2.next());
        }
        rVar.f612b.clear();
        this.f237d.b(this);
        this.f237d.b(this.f242i);
        c.b.a.s.i.f().removeCallbacks(this.f241h);
        c.b.a.b bVar = this.f235b;
        synchronized (bVar.f203j) {
            if (!bVar.f203j.contains(this)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            bVar.f203j.remove(this);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // c.b.a.n.m
    public synchronized void onStart() {
        m();
        this.f240g.onStart();
    }

    @Override // c.b.a.n.m
    public synchronized void onStop() {
        l();
        this.f240g.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f238e + ", treeNode=" + this.f239f + "}";
    }
}
