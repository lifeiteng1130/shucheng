package j$;

import java.util.function.ObjLongConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v0 implements ObjLongConsumer {
    final /* synthetic */ j$.util.function.K a;

    private /* synthetic */ v0(j$.util.function.K k2) {
        this.a = k2;
    }

    public static /* synthetic */ ObjLongConsumer a(j$.util.function.K k2) {
        if (k2 == null) {
            return null;
        }
        return k2 instanceof u0 ? ((u0) k2).a : new v0(k2);
    }

    @Override // java.util.function.ObjLongConsumer
    public /* synthetic */ void accept(Object obj, long j2) {
        this.a.accept(obj, j2);
    }
}
