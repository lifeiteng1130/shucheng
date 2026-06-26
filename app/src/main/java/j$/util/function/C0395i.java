package j$.util.function;

import java.util.Objects;

/* JADX INFO: renamed from: j$.util.function.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0395i implements y {
    public final /* synthetic */ y a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f7991b;

    public /* synthetic */ C0395i(y yVar, y yVar2) {
        this.a = yVar;
        this.f7991b = yVar2;
    }

    @Override // j$.util.function.y
    public final void accept(int i2) {
        y yVar = this.a;
        y yVar2 = this.f7991b;
        yVar.accept(i2);
        yVar2.accept(i2);
    }

    @Override // j$.util.function.y
    public y k(y yVar) {
        Objects.requireNonNull(yVar);
        return new C0395i(this, yVar);
    }
}
