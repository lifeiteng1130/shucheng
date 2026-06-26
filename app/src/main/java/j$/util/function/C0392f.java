package j$.util.function;

import java.util.Objects;

/* JADX INFO: renamed from: j$.util.function.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0392f implements s {
    public final /* synthetic */ s a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f7988b;

    public /* synthetic */ C0392f(s sVar, s sVar2) {
        this.a = sVar;
        this.f7988b = sVar2;
    }

    @Override // j$.util.function.s
    public final void accept(double d2) {
        s sVar = this.a;
        s sVar2 = this.f7988b;
        sVar.accept(d2);
        sVar2.accept(d2);
    }

    @Override // j$.util.function.s
    public s j(s sVar) {
        Objects.requireNonNull(sVar);
        return new C0392f(this, sVar);
    }
}
