package j$;

import java.util.function.IntUnaryOperator;

/* JADX INFO: renamed from: j$.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0353b0 implements IntUnaryOperator {
    final /* synthetic */ j$.util.function.C a;

    private /* synthetic */ C0353b0(j$.util.function.C c2) {
        this.a = c2;
    }

    public static /* synthetic */ IntUnaryOperator a(j$.util.function.C c2) {
        if (c2 == null) {
            return null;
        }
        return c2 instanceof C0351a0 ? ((C0351a0) c2).a : new C0353b0(c2);
    }

    @Override // java.util.function.IntUnaryOperator
    public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
        return a(C0351a0.b(((C0351a0) this.a).a.andThen(a(C0351a0.b(intUnaryOperator)))));
    }

    @Override // java.util.function.IntUnaryOperator
    public /* synthetic */ int applyAsInt(int i2) {
        return ((C0351a0) this.a).a.applyAsInt(i2);
    }

    @Override // java.util.function.IntUnaryOperator
    public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
        return a(C0351a0.b(((C0351a0) this.a).a.compose(a(C0351a0.b(intUnaryOperator)))));
    }
}
