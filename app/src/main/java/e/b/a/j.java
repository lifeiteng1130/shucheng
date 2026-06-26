package e.b.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.i;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import k.c.d.s;

/* JADX INFO: compiled from: MarkwonVisitorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements i {
    public final e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f5981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f5982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<? extends s>, i.c<? extends s>> f5983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i.a f5984e;

    /* JADX INFO: compiled from: MarkwonVisitorImpl.java */
    public static class a implements i.b {
        public final Map<Class<? extends s>, i.c<? extends s>> a = new HashMap();
    }

    public j(@NonNull e eVar, @NonNull m mVar, @NonNull o oVar, @NonNull Map<Class<? extends s>, i.c<? extends s>> map, @NonNull i.a aVar) {
        this.a = eVar;
        this.f5981b = mVar;
        this.f5982c = oVar;
        this.f5983d = map;
        this.f5984e = aVar;
    }

    public void a(@NonNull s sVar) {
        Objects.requireNonNull((b) this.f5984e);
        if (sVar.f8735e != null) {
            b();
            this.f5982c.a.append('\n');
        }
    }

    public void b() {
        if (this.f5982c.length() > 0) {
            if ('\n' != this.f5982c.a.charAt(r0.length() - 1)) {
                this.f5982c.a.append('\n');
            }
        }
    }

    public int c() {
        return this.f5982c.length();
    }

    public void d(int i2, @Nullable Object obj) {
        o oVar = this.f5982c;
        o.c(oVar, obj, i2, oVar.length());
    }

    public <N extends s> void e(@NonNull N n, int i2) {
        n nVar = ((h) this.a.f5974g).a.get(n.getClass());
        if (nVar != null) {
            Object objA = nVar.a(this.a, this.f5981b);
            o oVar = this.f5982c;
            o.c(oVar, objA, i2, oVar.length());
        }
    }

    public final void f(@NonNull s sVar) {
        i.c<? extends s> cVar = this.f5983d.get(sVar.getClass());
        if (cVar != null) {
            cVar.a(this, sVar);
        } else {
            g(sVar);
        }
    }

    public void g(@NonNull s sVar) {
        s sVar2 = sVar.f8732b;
        while (sVar2 != null) {
            s sVar3 = sVar2.f8735e;
            sVar2.a(this);
            sVar2 = sVar3;
        }
    }
}
