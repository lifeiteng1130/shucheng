package k.a.a.a.k0;

import java.util.UUID;

/* JADX INFO: compiled from: ATNSimulator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static final k.a.a.a.l0.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f8423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a1 f8424c;

    static {
        UUID uuid = g.a;
        UUID uuid2 = g.f8419f;
        k.a.a.a.l0.d dVar = new k.a.a.a.l0.d(new c(true));
        a = dVar;
        dVar.a = Integer.MAX_VALUE;
    }

    public h(a aVar, a1 a1Var) {
        this.f8423b = aVar;
        this.f8424c = a1Var;
    }

    public abstract void a();
}
