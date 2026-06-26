package j$;

import java.util.function.DoubleBinaryOperator;

/* JADX INFO: renamed from: j$.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0504y implements DoubleBinaryOperator {
    final /* synthetic */ j$.util.function.r a;

    private /* synthetic */ C0504y(j$.util.function.r rVar) {
        this.a = rVar;
    }

    public static /* synthetic */ DoubleBinaryOperator a(j$.util.function.r rVar) {
        if (rVar == null) {
            return null;
        }
        return rVar instanceof C0503x ? ((C0503x) rVar).a : new C0504y(rVar);
    }

    @Override // java.util.function.DoubleBinaryOperator
    public /* synthetic */ double applyAsDouble(double d2, double d3) {
        return this.a.applyAsDouble(d2, d3);
    }
}
