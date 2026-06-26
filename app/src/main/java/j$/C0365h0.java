package j$;

import java.util.function.LongFunction;

/* JADX INFO: renamed from: j$.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0365h0 implements LongFunction {
    final /* synthetic */ j$.util.function.F a;

    private /* synthetic */ C0365h0(j$.util.function.F f2) {
        this.a = f2;
    }

    public static /* synthetic */ LongFunction a(j$.util.function.F f2) {
        if (f2 == null) {
            return null;
        }
        return f2 instanceof C0363g0 ? ((C0363g0) f2).a : new C0365h0(f2);
    }

    @Override // java.util.function.LongFunction
    public /* synthetic */ Object apply(long j2) {
        return this.a.apply(j2);
    }
}
