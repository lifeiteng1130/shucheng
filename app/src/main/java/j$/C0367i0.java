package j$;

import java.util.function.LongPredicate;

/* JADX INFO: renamed from: j$.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0367i0 implements j$.util.function.G {
    final /* synthetic */ LongPredicate a;

    private /* synthetic */ C0367i0(LongPredicate longPredicate) {
        this.a = longPredicate;
    }

    public static /* synthetic */ j$.util.function.G a(LongPredicate longPredicate) {
        if (longPredicate == null) {
            return null;
        }
        return longPredicate instanceof C0369j0 ? ((C0369j0) longPredicate).a : new C0367i0(longPredicate);
    }

    public /* synthetic */ boolean b(long j2) {
        return this.a.test(j2);
    }
}
