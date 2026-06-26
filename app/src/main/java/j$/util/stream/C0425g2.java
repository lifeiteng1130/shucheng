package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Supplier;
import j$.util.stream.InterfaceC0448m1;

/* JADX INFO: Add missing generic type declarations: [T, I] */
/* JADX INFO: renamed from: j$.util.stream.g2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0425g2<I, T> extends AbstractC0488w2<T, I, C0429h2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BiConsumer f8197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Supplier f8198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ InterfaceC0448m1 f8199e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0425g2(U2 u2, j$.util.function.p pVar, BiConsumer biConsumer, Supplier supplier, InterfaceC0448m1 interfaceC0448m1) {
        super(u2);
        this.f8196b = pVar;
        this.f8197c = biConsumer;
        this.f8198d = supplier;
        this.f8199e = interfaceC0448m1;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new C0429h2(this.f8198d, this.f8197c, this.f8196b);
    }

    @Override // j$.util.stream.AbstractC0488w2, j$.util.stream.g3
    public int b() {
        if (this.f8199e.characteristics().contains(InterfaceC0448m1.a.UNORDERED)) {
            return T2.m;
        }
        return 0;
    }
}
