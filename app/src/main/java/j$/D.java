package j$;

import java.util.function.DoublePredicate;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class D implements j$.util.function.u {
    final /* synthetic */ DoublePredicate a;

    private /* synthetic */ D(DoublePredicate doublePredicate) {
        this.a = doublePredicate;
    }

    public static /* synthetic */ j$.util.function.u a(DoublePredicate doublePredicate) {
        if (doublePredicate == null) {
            return null;
        }
        return doublePredicate instanceof E ? ((E) doublePredicate).a : new D(doublePredicate);
    }

    public /* synthetic */ boolean b(double d2) {
        return this.a.test(d2);
    }
}
