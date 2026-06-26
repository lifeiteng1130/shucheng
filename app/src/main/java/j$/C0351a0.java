package j$;

import java.util.function.IntUnaryOperator;

/* JADX INFO: renamed from: j$.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0351a0 implements j$.util.function.C {
    final /* synthetic */ IntUnaryOperator a;

    private /* synthetic */ C0351a0(IntUnaryOperator intUnaryOperator) {
        this.a = intUnaryOperator;
    }

    public static /* synthetic */ j$.util.function.C b(IntUnaryOperator intUnaryOperator) {
        if (intUnaryOperator == null) {
            return null;
        }
        return intUnaryOperator instanceof C0353b0 ? ((C0353b0) intUnaryOperator).a : new C0351a0(intUnaryOperator);
    }

    public /* synthetic */ int a(int i2) {
        return this.a.applyAsInt(i2);
    }
}
