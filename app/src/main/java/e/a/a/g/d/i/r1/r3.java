package e.a.a.g.d.i.r1;

import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.help.ReadBookConfig;

/* JADX INFO: compiled from: ReadStyleDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r3 extends f.c0.c.k implements f.c0.b.l<Integer, f.v> {
    public static final r3 INSTANCE = new r3();

    public r3() {
        super(1);
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(Integer num) {
        invoke(num.intValue());
        return f.v.a;
    }

    public final void invoke(int i2) {
        ReadBookConfig.INSTANCE.setLetterSpacing((i2 - 50) / 100.0f);
        LiveEventBus.get("upConfig").post(Boolean.TRUE);
    }
}
