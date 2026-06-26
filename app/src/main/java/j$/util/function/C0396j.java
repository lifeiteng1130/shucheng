package j$.util.function;

import java.util.Objects;

/* JADX INFO: renamed from: j$.util.function.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0396j implements E {
    public final /* synthetic */ E a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E f7992b;

    public /* synthetic */ C0396j(E e2, E e3) {
        this.a = e2;
        this.f7992b = e3;
    }

    @Override // j$.util.function.E
    public final void accept(long j2) {
        E e2 = this.a;
        E e3 = this.f7992b;
        e2.accept(j2);
        e3.accept(j2);
    }

    @Override // j$.util.function.E
    public E f(E e2) {
        Objects.requireNonNull(e2);
        return new C0396j(this, e2);
    }
}
