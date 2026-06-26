package j$;

import java.util.function.LongPredicate;

/* JADX INFO: renamed from: j$.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0369j0 implements LongPredicate {
    final /* synthetic */ j$.util.function.G a;

    private /* synthetic */ C0369j0(j$.util.function.G g2) {
        this.a = g2;
    }

    public static /* synthetic */ LongPredicate a(j$.util.function.G g2) {
        if (g2 == null) {
            return null;
        }
        return g2 instanceof C0367i0 ? ((C0367i0) g2).a : new C0369j0(g2);
    }

    @Override // java.util.function.LongPredicate
    public /* synthetic */ LongPredicate and(LongPredicate longPredicate) {
        return a(C0367i0.a(((C0367i0) this.a).a.and(a(C0367i0.a(longPredicate)))));
    }

    @Override // java.util.function.LongPredicate
    public /* synthetic */ LongPredicate negate() {
        return a(C0367i0.a(((C0367i0) this.a).a.negate()));
    }

    @Override // java.util.function.LongPredicate
    public /* synthetic */ LongPredicate or(LongPredicate longPredicate) {
        return a(C0367i0.a(((C0367i0) this.a).a.or(a(C0367i0.a(longPredicate)))));
    }

    @Override // java.util.function.LongPredicate
    public /* synthetic */ boolean test(long j2) {
        return ((C0367i0) this.a).a.test(j2);
    }
}
