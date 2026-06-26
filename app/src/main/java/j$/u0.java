package j$;

import java.util.function.ObjLongConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class u0 implements j$.util.function.K {
    final /* synthetic */ ObjLongConsumer a;

    private /* synthetic */ u0(ObjLongConsumer objLongConsumer) {
        this.a = objLongConsumer;
    }

    public static /* synthetic */ j$.util.function.K a(ObjLongConsumer objLongConsumer) {
        if (objLongConsumer == null) {
            return null;
        }
        return objLongConsumer instanceof v0 ? ((v0) objLongConsumer).a : new u0(objLongConsumer);
    }

    @Override // j$.util.function.K
    public /* synthetic */ void accept(Object obj, long j2) {
        this.a.accept(obj, j2);
    }
}
