package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.InterfaceC0480u2;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.w2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC0488w2<T, R, S extends InterfaceC0480u2<T, R, S>> implements g3<T, R> {
    private final U2 a;

    AbstractC0488w2(U2 u2) {
        this.a = u2;
    }

    public abstract InterfaceC0480u2 a();

    @Override // j$.util.stream.g3
    public /* synthetic */ int b() {
        return 0;
    }

    @Override // j$.util.stream.g3
    public Object c(T1 t1, Spliterator spliterator) {
        return ((InterfaceC0480u2) new C0492x2(this, t1, spliterator).invoke()).get();
    }

    @Override // j$.util.stream.g3
    public Object d(T1 t1, Spliterator spliterator) {
        InterfaceC0480u2 interfaceC0480u2A = a();
        AbstractC0428h1 abstractC0428h1 = (AbstractC0428h1) t1;
        Objects.requireNonNull(interfaceC0480u2A);
        abstractC0428h1.m0(abstractC0428h1.u0(interfaceC0480u2A), spliterator);
        return interfaceC0480u2A.get();
    }
}
