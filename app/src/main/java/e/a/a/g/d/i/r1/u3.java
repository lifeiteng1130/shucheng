package e.a.a.g.d.i.r1;

import com.jeremyliao.liveeventbus.LiveEventBus;

/* JADX INFO: compiled from: ReadStyleDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u3 extends f.c0.c.k implements f.c0.b.a<f.v> {
    public static final u3 INSTANCE = new u3();

    public u3() {
        super(0);
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ f.v invoke() {
        invoke2();
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LiveEventBus.get("upConfig").post(Boolean.TRUE);
    }
}
