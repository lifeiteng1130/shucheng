package j$.util.function;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l implements H {
    public final /* synthetic */ H a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ H f7994b;

    public /* synthetic */ l(H h2, H h3) {
        this.a = h2;
        this.f7994b = h3;
    }

    @Override // j$.util.function.H
    public H a(H h2) {
        Objects.requireNonNull(h2);
        return new C0397k(this, h2);
    }

    @Override // j$.util.function.H
    public final long applyAsLong(long j2) {
        return this.a.applyAsLong(this.f7994b.applyAsLong(j2));
    }

    @Override // j$.util.function.H
    public H b(H h2) {
        Objects.requireNonNull(h2);
        return new l(this, h2);
    }
}
