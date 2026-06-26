package j$;

import java.util.function.IntPredicate;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class U implements j$.util.function.A {
    final /* synthetic */ IntPredicate a;

    private /* synthetic */ U(IntPredicate intPredicate) {
        this.a = intPredicate;
    }

    public static /* synthetic */ j$.util.function.A a(IntPredicate intPredicate) {
        if (intPredicate == null) {
            return null;
        }
        return intPredicate instanceof V ? ((V) intPredicate).a : new U(intPredicate);
    }

    public /* synthetic */ boolean b(int i2) {
        return this.a.test(i2);
    }
}
