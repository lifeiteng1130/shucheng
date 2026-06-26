package e.a.a.g.d.i.r1;

import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.help.ReadBookConfig;

/* JADX INFO: compiled from: TipConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p4 extends f.c0.c.k implements f.c0.b.l<Integer, f.v> {
    public static final p4 INSTANCE = new p4();

    public p4() {
        super(1);
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(Integer num) {
        invoke(num.intValue());
        return f.v.a;
    }

    public final void invoke(int i2) {
        ReadBookConfig.INSTANCE.setTitleBottomSpacing(i2);
        LiveEventBus.get("upConfig").post(Boolean.TRUE);
    }
}
