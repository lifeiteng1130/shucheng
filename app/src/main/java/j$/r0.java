package j$;

import java.util.function.ObjDoubleConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r0 implements ObjDoubleConsumer {
    final /* synthetic */ j$.util.function.I a;

    private /* synthetic */ r0(j$.util.function.I i2) {
        this.a = i2;
    }

    public static /* synthetic */ ObjDoubleConsumer a(j$.util.function.I i2) {
        if (i2 == null) {
            return null;
        }
        return i2 instanceof C0383q0 ? ((C0383q0) i2).a : new r0(i2);
    }

    @Override // java.util.function.ObjDoubleConsumer
    public /* synthetic */ void accept(Object obj, double d2) {
        this.a.accept(obj, d2);
    }
}
