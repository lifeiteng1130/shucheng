package j$;

import java.util.function.LongToDoubleFunction;

/* JADX INFO: renamed from: j$.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0371k0 {
    final /* synthetic */ LongToDoubleFunction a;

    private /* synthetic */ C0371k0(LongToDoubleFunction longToDoubleFunction) {
        this.a = longToDoubleFunction;
    }

    public static /* synthetic */ C0371k0 b(LongToDoubleFunction longToDoubleFunction) {
        if (longToDoubleFunction == null) {
            return null;
        }
        return longToDoubleFunction instanceof C0373l0 ? ((C0373l0) longToDoubleFunction).a : new C0371k0(longToDoubleFunction);
    }

    public double a(long j2) {
        return this.a.applyAsDouble(j2);
    }
}
