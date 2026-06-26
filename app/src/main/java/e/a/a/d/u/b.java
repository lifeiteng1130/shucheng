package e.a.a.d.u;

import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.v;
import g.b.a0;
import g.b.f1;
import g.b.g2.m;
import g.b.k0;
import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Coroutine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> {

    @NotNull
    public static final C0148b a = new C0148b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a0 f5558b = c.b.a.m.f.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final a0 f5559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final f1 f5560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public b<T>.c f5561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public b<T>.a<T> f5562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public b<T>.a<Throwable> f5563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public b<T>.c f5564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Long f5565i;

    /* JADX INFO: compiled from: Coroutine.kt */
    public final class a<VALUE> {

        @Nullable
        public final f.z.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final q<a0, VALUE, f.z.d<? super v>, Object> f5566b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@Nullable b bVar, @NotNull f.z.f fVar, q<? super a0, ? super VALUE, ? super f.z.d<? super v>, ? extends Object> qVar) {
            j.e(bVar, "this$0");
            j.e(qVar, "block");
            this.a = fVar;
            this.f5566b = qVar;
        }
    }

    /* JADX INFO: renamed from: e.a.a.d.u.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Coroutine.kt */
    public static final class C0148b {
        public C0148b(f.c0.c.f fVar) {
        }

        public static b b(C0148b c0148b, a0 a0Var, f.z.f fVar, p pVar, int i2) {
            if ((i2 & 1) != 0) {
                a0Var = b.f5558b;
            }
            if ((i2 & 2) != 0) {
                k0 k0Var = k0.f6264c;
                fVar = k0.f6263b;
            }
            return c0148b.a(a0Var, fVar, pVar);
        }

        @NotNull
        public final <T> b<T> a(@NotNull a0 a0Var, @NotNull f.z.f fVar, @NotNull p<? super a0, ? super f.z.d<? super T>, ? extends Object> pVar) {
            j.e(a0Var, "scope");
            j.e(fVar, com.umeng.analytics.pro.c.R);
            j.e(pVar, "block");
            return new b<>(a0Var, fVar, pVar);
        }
    }

    /* JADX INFO: compiled from: Coroutine.kt */
    public final class c {

        @Nullable
        public final f.z.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final p<a0, f.z.d<? super v>, Object> f5567b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@Nullable b bVar, @NotNull f.z.f fVar, p<? super a0, ? super f.z.d<? super v>, ? extends Object> pVar) {
            j.e(bVar, "this$0");
            j.e(pVar, "block");
            this.a = fVar;
            this.f5567b = pVar;
        }
    }

    public b(@NotNull a0 a0Var, @NotNull f.z.f fVar, @NotNull p<? super a0, ? super f.z.d<? super T>, ? extends Object> pVar) {
        j.e(a0Var, "scope");
        j.e(fVar, com.umeng.analytics.pro.c.R);
        j.e(pVar, "block");
        this.f5559c = a0Var;
        k0 k0Var = k0.f6264c;
        this.f5560d = c.b.a.m.f.L3(new g.b.g2.e(a0Var.getCoroutineContext().plus(m.f6207b)), null, null, new f(this, fVar, pVar, null), 3, null);
    }

    public static void a(b bVar, CancellationException cancellationException, int i2) {
        int i3 = i2 & 1;
        bVar.f5560d.k(null);
    }

    public static b b(b bVar, f.z.f fVar, q qVar, int i2) {
        int i3 = i2 & 1;
        j.e(qVar, "block");
        bVar.f5563g = new a<>(bVar, null, qVar);
        return bVar;
    }

    public static b c(b bVar, f.z.f fVar, p pVar, int i2) {
        int i3 = i2 & 1;
        j.e(pVar, "block");
        bVar.f5564h = new c(bVar, null, pVar);
        return bVar;
    }

    public static /* synthetic */ b e(b bVar, f.z.f fVar, q qVar, int i2) {
        int i3 = i2 & 1;
        bVar.d(null, qVar);
        return bVar;
    }

    @NotNull
    public final b<T> d(@Nullable f.z.f fVar, @NotNull q<? super a0, ? super T, ? super f.z.d<? super v>, ? extends Object> qVar) {
        j.e(qVar, "block");
        this.f5562f = new a<>(this, fVar, qVar);
        return this;
    }

    @NotNull
    public final b<T> f(long j2) {
        this.f5565i = Long.valueOf(j2);
        return this;
    }
}
