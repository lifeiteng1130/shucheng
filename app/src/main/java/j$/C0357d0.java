package j$;

import java.util.function.LongBinaryOperator;

/* JADX INFO: renamed from: j$.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0357d0 implements LongBinaryOperator {
    final /* synthetic */ j$.util.function.D a;

    private /* synthetic */ C0357d0(j$.util.function.D d2) {
        this.a = d2;
    }

    public static /* synthetic */ LongBinaryOperator a(j$.util.function.D d2) {
        if (d2 == null) {
            return null;
        }
        return d2 instanceof C0355c0 ? ((C0355c0) d2).a : new C0357d0(d2);
    }

    @Override // java.util.function.LongBinaryOperator
    public /* synthetic */ long applyAsLong(long j2, long j3) {
        return this.a.applyAsLong(j2, j3);
    }
}
