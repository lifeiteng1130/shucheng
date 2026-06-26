package j$;

import java.util.function.ObjDoubleConsumer;

/* JADX INFO: renamed from: j$.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0383q0 implements j$.util.function.I {
    final /* synthetic */ ObjDoubleConsumer a;

    private /* synthetic */ C0383q0(ObjDoubleConsumer objDoubleConsumer) {
        this.a = objDoubleConsumer;
    }

    public static /* synthetic */ j$.util.function.I a(ObjDoubleConsumer objDoubleConsumer) {
        if (objDoubleConsumer == null) {
            return null;
        }
        return objDoubleConsumer instanceof r0 ? ((r0) objDoubleConsumer).a : new C0383q0(objDoubleConsumer);
    }

    @Override // j$.util.function.I
    public /* synthetic */ void accept(Object obj, double d2) {
        this.a.accept(obj, d2);
    }
}
