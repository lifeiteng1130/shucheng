package c.b.a.q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.c;
import c.b.a.m.q.l;
import c.b.a.m.q.r;
import c.b.a.m.q.w;
import c.b.a.s.j.d;
import com.bumptech.glide.load.model.Model;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SingleRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class h<R> implements c, c.b.a.q.j.g, g {
    public static final boolean a = Log.isLoggable("Request", 2);

    @GuardedBy("requestLock")
    public int A;

    @GuardedBy("requestLock")
    public int B;

    @GuardedBy("requestLock")
    public boolean C;

    @Nullable
    public RuntimeException D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b.a.s.j.d f639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final e<R> f641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c.b.a.d f644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final Object f645i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Class<R> f646j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c.b.a.q.a<?> f647k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f648l;
    public final int m;
    public final c.b.a.f n;
    public final c.b.a.q.j.h<R> o;

    @Nullable
    public final List<e<R>> p;
    public final c.b.a.q.k.e<? super R> q;
    public final Executor r;

    @GuardedBy("requestLock")
    public w<R> s;

    @GuardedBy("requestLock")
    public l.d t;

    @GuardedBy("requestLock")
    public long u;
    public volatile l v;

    @GuardedBy("requestLock")
    public a w;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable x;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable y;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable z;

    /* JADX INFO: compiled from: SingleRequest.java */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public h(Context context, c.b.a.d dVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, c.b.a.q.a<?> aVar, int i2, int i3, c.b.a.f fVar, c.b.a.q.j.h<R> hVar, @Nullable e<R> eVar, @Nullable List<e<R>> list, d dVar2, l lVar, c.b.a.q.k.e<? super R> eVar2, Executor executor) {
        this.f638b = a ? String.valueOf(hashCode()) : null;
        this.f639c = new d.b();
        this.f640d = obj;
        this.f643g = context;
        this.f644h = dVar;
        this.f645i = obj2;
        this.f646j = cls;
        this.f647k = aVar;
        this.f648l = i2;
        this.m = i3;
        this.n = fVar;
        this.o = hVar;
        this.f641e = eVar;
        this.p = list;
        this.f642f = dVar2;
        this.v = lVar;
        this.q = eVar2;
        this.r = executor;
        this.w = a.PENDING;
        if (this.D == null && dVar.f222i.a.containsKey(c.C0011c.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // c.b.a.q.c
    public boolean a() {
        boolean z;
        synchronized (this.f640d) {
            z = this.w == a.COMPLETE;
        }
        return z;
    }

    @Override // c.b.a.q.j.g
    public void b(int i2, int i3) {
        Object obj;
        int iRound = i2;
        this.f639c.a();
        Object obj2 = this.f640d;
        synchronized (obj2) {
            try {
                boolean z = a;
                if (z) {
                    c.b.a.s.e.a(this.u);
                }
                if (this.w == a.WAITING_FOR_SIZE) {
                    a aVar = a.RUNNING;
                    this.w = aVar;
                    float f2 = this.f647k.f622b;
                    if (iRound != Integer.MIN_VALUE) {
                        iRound = Math.round(iRound * f2);
                    }
                    this.A = iRound;
                    this.B = i3 == Integer.MIN_VALUE ? i3 : Math.round(f2 * i3);
                    if (z) {
                        c.b.a.s.e.a(this.u);
                    }
                    l lVar = this.v;
                    c.b.a.d dVar = this.f644h;
                    Object obj3 = this.f645i;
                    c.b.a.q.a<?> aVar2 = this.f647k;
                    try {
                        obj = obj2;
                        try {
                            try {
                                this.t = lVar.b(dVar, obj3, aVar2.f632l, this.A, this.B, aVar2.s, this.f646j, this.n, aVar2.f623c, aVar2.r, aVar2.m, aVar2.y, aVar2.q, aVar2.f629i, aVar2.w, aVar2.z, aVar2.x, this, this.r);
                                if (this.w != aVar) {
                                    this.t = null;
                                }
                                if (z) {
                                    c.b.a.s.e.a(this.u);
                                }
                            } catch (Throwable th) {
                                th = th;
                                while (true) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj = obj2;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                obj = obj2;
            }
        }
    }

    @Override // c.b.a.q.c
    public boolean c(c cVar) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        c.b.a.q.a<?> aVar;
        c.b.a.f fVar;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        c.b.a.q.a<?> aVar2;
        c.b.a.f fVar2;
        int size2;
        if (!(cVar instanceof h)) {
            return false;
        }
        synchronized (this.f640d) {
            i2 = this.f648l;
            i3 = this.m;
            obj = this.f645i;
            cls = this.f646j;
            aVar = this.f647k;
            fVar = this.n;
            List<e<R>> list = this.p;
            size = list != null ? list.size() : 0;
        }
        h hVar = (h) cVar;
        synchronized (hVar.f640d) {
            i4 = hVar.f648l;
            i5 = hVar.m;
            obj2 = hVar.f645i;
            cls2 = hVar.f646j;
            aVar2 = hVar.f647k;
            fVar2 = hVar.n;
            List<e<R>> list2 = hVar.p;
            size2 = list2 != null ? list2.size() : 0;
        }
        if (i2 == i4 && i3 == i5) {
            char[] cArr = c.b.a.s.i.a;
            if ((obj == null ? obj2 == null : obj instanceof Model ? ((Model) obj).isEquivalentTo(obj2) : obj.equals(obj2)) && cls.equals(cls2) && aVar.equals(aVar2) && fVar == fVar2 && size == size2) {
                return true;
            }
        }
        return false;
    }

    @Override // c.b.a.q.c
    public void clear() {
        synchronized (this.f640d) {
            e();
            this.f639c.a();
            a aVar = this.w;
            a aVar2 = a.CLEARED;
            if (aVar == aVar2) {
                return;
            }
            f();
            w<R> wVar = this.s;
            if (wVar != null) {
                this.s = null;
            } else {
                wVar = null;
            }
            d dVar = this.f642f;
            if (dVar == null || dVar.j(this)) {
                this.o.g(j());
            }
            this.w = aVar2;
            if (wVar != null) {
                this.v.f(wVar);
            }
        }
    }

    @Override // c.b.a.q.c
    public boolean d() {
        boolean z;
        synchronized (this.f640d) {
            z = this.w == a.CLEARED;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final void e() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    public final void f() {
        e();
        this.f639c.a();
        this.o.a(this);
        l.d dVar = this.t;
        if (dVar != null) {
            synchronized (l.this) {
                dVar.a.h(dVar.f439b);
            }
            this.t = null;
        }
    }

    @Override // c.b.a.q.c
    public void g() {
        synchronized (this.f640d) {
            e();
            this.f639c.a();
            int i2 = c.b.a.s.e.f675b;
            this.u = SystemClock.elapsedRealtimeNanos();
            if (this.f645i == null) {
                if (c.b.a.s.i.j(this.f648l, this.m)) {
                    this.A = this.f648l;
                    this.B = this.m;
                }
                m(new r("Received null model"), h() == null ? 5 : 3);
                return;
            }
            a aVar = this.w;
            a aVar2 = a.RUNNING;
            if (aVar == aVar2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (aVar == a.COMPLETE) {
                n(this.s, c.b.a.m.a.MEMORY_CACHE, false);
                return;
            }
            a aVar3 = a.WAITING_FOR_SIZE;
            this.w = aVar3;
            if (c.b.a.s.i.j(this.f648l, this.m)) {
                b(this.f648l, this.m);
            } else {
                this.o.h(this);
            }
            a aVar4 = this.w;
            if (aVar4 == aVar2 || aVar4 == aVar3) {
                d dVar = this.f642f;
                if (dVar == null || dVar.e(this)) {
                    this.o.e(j());
                }
            }
            if (a) {
                c.b.a.s.e.a(this.u);
            }
        }
    }

    @GuardedBy("requestLock")
    public final Drawable h() {
        int i2;
        if (this.z == null) {
            c.b.a.q.a<?> aVar = this.f647k;
            Drawable drawable = aVar.o;
            this.z = drawable;
            if (drawable == null && (i2 = aVar.p) > 0) {
                this.z = l(i2);
            }
        }
        return this.z;
    }

    @Override // c.b.a.q.c
    public boolean i() {
        boolean z;
        synchronized (this.f640d) {
            z = this.w == a.COMPLETE;
        }
        return z;
    }

    @Override // c.b.a.q.c
    public boolean isRunning() {
        boolean z;
        synchronized (this.f640d) {
            a aVar = this.w;
            z = aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final Drawable j() {
        int i2;
        if (this.y == null) {
            c.b.a.q.a<?> aVar = this.f647k;
            Drawable drawable = aVar.f627g;
            this.y = drawable;
            if (drawable == null && (i2 = aVar.f628h) > 0) {
                this.y = l(i2);
            }
        }
        return this.y;
    }

    @GuardedBy("requestLock")
    public final boolean k() {
        d dVar = this.f642f;
        return dVar == null || !dVar.getRoot().a();
    }

    @GuardedBy("requestLock")
    public final Drawable l(@DrawableRes int i2) {
        Resources.Theme theme = this.f647k.u;
        if (theme == null) {
            theme = this.f643g.getTheme();
        }
        c.b.a.d dVar = this.f644h;
        return c.b.a.m.r.e.a.a(dVar, dVar, i2, theme);
    }

    public final void m(r rVar, int i2) {
        boolean zA;
        this.f639c.a();
        synchronized (this.f640d) {
            rVar.setOrigin(this.D);
            int i3 = this.f644h.f223j;
            if (i3 <= i2) {
                String str = "Load failed for " + this.f645i + " with size [" + this.A + "x" + this.B + "]";
                if (i3 <= 4) {
                    rVar.logRootCauses("Glide");
                }
            }
            this.t = null;
            this.w = a.FAILED;
            boolean z = true;
            this.C = true;
            try {
                List<e<R>> list = this.p;
                if (list != null) {
                    Iterator<e<R>> it = list.iterator();
                    zA = false;
                    while (it.hasNext()) {
                        zA |= it.next().a(rVar, this.f645i, this.o, k());
                    }
                } else {
                    zA = false;
                }
                e<R> eVar = this.f641e;
                if (eVar == null || !eVar.a(rVar, this.f645i, this.o, k())) {
                    z = false;
                }
                if (!(zA | z)) {
                    p();
                }
                this.C = false;
                d dVar = this.f642f;
                if (dVar != null) {
                    dVar.b(this);
                }
            } catch (Throwable th) {
                this.C = false;
                throw th;
            }
        }
    }

    public void n(w<?> wVar, c.b.a.m.a aVar, boolean z) {
        this.f639c.a();
        w<?> wVar2 = null;
        try {
            synchronized (this.f640d) {
                try {
                    this.t = null;
                    if (wVar == null) {
                        m(new r("Expected to receive a Resource<R> with an object of " + this.f646j + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = wVar.get();
                    try {
                        if (obj != null && this.f646j.isAssignableFrom(obj.getClass())) {
                            d dVar = this.f642f;
                            if (dVar == null || dVar.f(this)) {
                                o(wVar, obj, aVar);
                                return;
                            }
                            this.s = null;
                            this.w = a.COMPLETE;
                            this.v.f(wVar);
                            return;
                        }
                        this.s = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.f646j);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(wVar);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        m(new r(sb.toString()), 5);
                        this.v.f(wVar);
                    } catch (Throwable th) {
                        wVar2 = wVar;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (wVar2 != null) {
                this.v.f(wVar2);
            }
            throw th3;
        }
    }

    @GuardedBy("requestLock")
    public final void o(w wVar, Object obj, c.b.a.m.a aVar) {
        boolean zB;
        boolean zK = k();
        this.w = a.COMPLETE;
        this.s = wVar;
        if (this.f644h.f223j <= 3) {
            StringBuilder sbR = c.a.a.a.a.r("Finished loading ");
            sbR.append(obj.getClass().getSimpleName());
            sbR.append(" from ");
            sbR.append(aVar);
            sbR.append(" for ");
            sbR.append(this.f645i);
            sbR.append(" with size [");
            sbR.append(this.A);
            sbR.append("x");
            sbR.append(this.B);
            sbR.append("] in ");
            sbR.append(c.b.a.s.e.a(this.u));
            sbR.append(" ms");
            sbR.toString();
        }
        boolean z = true;
        this.C = true;
        try {
            List<e<R>> list = this.p;
            if (list != null) {
                Iterator<e<R>> it = list.iterator();
                zB = false;
                while (it.hasNext()) {
                    zB |= it.next().b(obj, this.f645i, this.o, aVar, zK);
                }
            } else {
                zB = false;
            }
            e<R> eVar = this.f641e;
            if (eVar == null || !eVar.b(obj, this.f645i, this.o, aVar, zK)) {
                z = false;
            }
            if (!(z | zB)) {
                this.o.b(obj, this.q.a(aVar, zK));
            }
            this.C = false;
            d dVar = this.f642f;
            if (dVar != null) {
                dVar.h(this);
            }
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    @GuardedBy("requestLock")
    public final void p() {
        int i2;
        d dVar = this.f642f;
        if (dVar == null || dVar.e(this)) {
            Drawable drawableH = this.f645i == null ? h() : null;
            if (drawableH == null) {
                if (this.x == null) {
                    c.b.a.q.a<?> aVar = this.f647k;
                    Drawable drawable = aVar.f625e;
                    this.x = drawable;
                    if (drawable == null && (i2 = aVar.f626f) > 0) {
                        this.x = l(i2);
                    }
                }
                drawableH = this.x;
            }
            if (drawableH == null) {
                drawableH = j();
            }
            this.o.d(drawableH);
        }
    }

    @Override // c.b.a.q.c
    public void pause() {
        synchronized (this.f640d) {
            if (isRunning()) {
                clear();
            }
        }
    }
}
