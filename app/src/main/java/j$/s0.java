package j$;

import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s0 implements j$.util.function.J {
    final /* synthetic */ ObjIntConsumer a;

    private /* synthetic */ s0(ObjIntConsumer objIntConsumer) {
        this.a = objIntConsumer;
    }

    public static /* synthetic */ j$.util.function.J a(ObjIntConsumer objIntConsumer) {
        if (objIntConsumer == null) {
            return null;
        }
        return objIntConsumer instanceof t0 ? ((t0) objIntConsumer).a : new s0(objIntConsumer);
    }

    @Override // j$.util.function.J
    public /* synthetic */ void accept(Object obj, int i2) {
        this.a.accept(obj, i2);
    }
}
