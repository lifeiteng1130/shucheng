package e.a.a.g.d.i.r1;

import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.help.ReadBookConfig;

/* JADX INFO: compiled from: PaddingConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a3 extends f.c0.c.k implements f.c0.b.l<Integer, f.v> {
    public final /* synthetic */ ReadBookConfig $this_with;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a3(ReadBookConfig readBookConfig) {
        super(1);
        this.$this_with = readBookConfig;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(Integer num) {
        invoke(num.intValue());
        return f.v.a;
    }

    public final void invoke(int i2) {
        this.$this_with.setPaddingBottom(i2);
        LiveEventBus.get("upConfig").post(Boolean.TRUE);
    }
}
