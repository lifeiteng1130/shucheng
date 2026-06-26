package j$;

import java.util.function.DoubleFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class B implements j$.util.function.t {
    final /* synthetic */ DoubleFunction a;

    private /* synthetic */ B(DoubleFunction doubleFunction) {
        this.a = doubleFunction;
    }

    public static /* synthetic */ j$.util.function.t a(DoubleFunction doubleFunction) {
        if (doubleFunction == null) {
            return null;
        }
        return doubleFunction instanceof C ? ((C) doubleFunction).a : new B(doubleFunction);
    }

    @Override // j$.util.function.t
    public /* synthetic */ Object apply(double d2) {
        return this.a.apply(d2);
    }
}
