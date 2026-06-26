package j$;

import java.util.function.LongToIntFunction;

/* JADX INFO: renamed from: j$.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0375m0 {
    final /* synthetic */ LongToIntFunction a;

    private /* synthetic */ C0375m0(LongToIntFunction longToIntFunction) {
        this.a = longToIntFunction;
    }

    public static /* synthetic */ C0375m0 b(LongToIntFunction longToIntFunction) {
        if (longToIntFunction == null) {
            return null;
        }
        return longToIntFunction instanceof C0377n0 ? ((C0377n0) longToIntFunction).a : new C0375m0(longToIntFunction);
    }

    public int a(long j2) {
        return this.a.applyAsInt(j2);
    }
}
