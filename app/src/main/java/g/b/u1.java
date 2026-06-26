package g.b;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u1 implements Runnable {
    public final y a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<f.v> f6302b;

    /* JADX WARN: Multi-variable type inference failed */
    public u1(@NotNull y yVar, @NotNull h<? super f.v> hVar) {
        this.a = yVar;
        this.f6302b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6302b.b(this.a, f.v.a);
    }
}
