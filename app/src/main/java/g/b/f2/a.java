package g.b.f2;

import android.os.Handler;
import android.os.Looper;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.e0.e;
import f.v;
import f.z.f;
import g.b.h;
import g.b.h0;
import g.b.i;
import g.b.m0;
import g.b.o1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends g.b.f2.b implements h0 {
    private volatile a _immediate;

    @NotNull
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f6183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6185d;

    /* JADX INFO: renamed from: g.b.f2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HandlerDispatcher.kt */
    public static final class C0184a implements m0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f6186b;

        public C0184a(Runnable runnable) {
            this.f6186b = runnable;
        }

        @Override // g.b.m0
        public void e() {
            a.this.f6183b.removeCallbacks(this.f6186b);
        }
    }

    /* JADX INFO: compiled from: Runnable.kt */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f6187b;

        public b(h hVar) {
            this.f6187b = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f6187b.b(a.this, v.a);
        }
    }

    /* JADX INFO: compiled from: HandlerDispatcher.kt */
    public static final class c extends k implements l<Throwable, v> {
        public final /* synthetic */ Runnable $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Runnable runnable) {
            super(1);
            this.$block = runnable;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Throwable th) {
            invoke2(th);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            a.this.f6183b.removeCallbacks(this.$block);
        }
    }

    public a(Handler handler, String str, boolean z) {
        super(null);
        this.f6183b = handler;
        this.f6184c = str;
        this.f6185d = z;
        this._immediate = z ? this : null;
        a aVar = this._immediate;
        if (aVar == null) {
            aVar = new a(handler, str, true);
            this._immediate = aVar;
        }
        this.a = aVar;
    }

    @Override // g.b.h0
    public void a(long j2, @NotNull h<? super v> hVar) {
        b bVar = new b(hVar);
        this.f6183b.postDelayed(bVar, e.a(j2, 4611686018427387903L));
        ((i) hVar).a(new c(bVar));
    }

    @Override // g.b.y
    public void dispatch(@NotNull f fVar, @NotNull Runnable runnable) {
        this.f6183b.post(runnable);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof a) && ((a) obj).f6183b == this.f6183b;
    }

    @Override // g.b.f2.b, g.b.h0
    @NotNull
    public m0 h(long j2, @NotNull Runnable runnable, @NotNull f fVar) {
        this.f6183b.postDelayed(runnable, e.a(j2, 4611686018427387903L));
        return new C0184a(runnable);
    }

    public int hashCode() {
        return System.identityHashCode(this.f6183b);
    }

    @Override // g.b.y
    public boolean isDispatchNeeded(@NotNull f fVar) {
        return !this.f6185d || (j.a(Looper.myLooper(), this.f6183b.getLooper()) ^ true);
    }

    @Override // g.b.o1
    public o1 n() {
        return this.a;
    }

    @Override // g.b.o1, g.b.y
    @NotNull
    public String toString() {
        String strO = o();
        if (strO != null) {
            return strO;
        }
        String string = this.f6184c;
        if (string == null) {
            string = this.f6183b.toString();
        }
        return this.f6185d ? c.a.a.a.a.i(string, ".immediate") : string;
    }
}
