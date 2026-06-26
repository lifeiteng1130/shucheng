package j$;

import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t0 implements ObjIntConsumer {
    final /* synthetic */ j$.util.function.J a;

    private /* synthetic */ t0(j$.util.function.J j2) {
        this.a = j2;
    }

    public static /* synthetic */ ObjIntConsumer a(j$.util.function.J j2) {
        if (j2 == null) {
            return null;
        }
        return j2 instanceof s0 ? ((s0) j2).a : new t0(j2);
    }

    @Override // java.util.function.ObjIntConsumer
    public /* synthetic */ void accept(Object obj, int i2) {
        this.a.accept(obj, i2);
    }
}
