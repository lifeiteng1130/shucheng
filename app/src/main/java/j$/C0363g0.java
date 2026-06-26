package j$;

import java.util.function.LongFunction;

/* JADX INFO: renamed from: j$.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0363g0 implements j$.util.function.F {
    final /* synthetic */ LongFunction a;

    private /* synthetic */ C0363g0(LongFunction longFunction) {
        this.a = longFunction;
    }

    public static /* synthetic */ j$.util.function.F a(LongFunction longFunction) {
        if (longFunction == null) {
            return null;
        }
        return longFunction instanceof C0365h0 ? ((C0365h0) longFunction).a : new C0363g0(longFunction);
    }

    @Override // j$.util.function.F
    public /* synthetic */ Object apply(long j2) {
        return this.a.apply(j2);
    }
}
