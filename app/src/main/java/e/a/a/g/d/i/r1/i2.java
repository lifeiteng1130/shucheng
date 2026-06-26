package e.a.a.g.d.i.r1;

import android.content.DialogInterface;
import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.config.BgTextConfigDialog;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BgTextConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i2 extends f.c0.c.k implements f.c0.b.p<DialogInterface, Integer, f.v> {
    public final /* synthetic */ List<ReadBookConfig.Config> $defaultConfigs;
    public final /* synthetic */ BgTextConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i2(List<ReadBookConfig.Config> list, BgTextConfigDialog bgTextConfigDialog) {
        super(2);
        this.$defaultConfigs = list;
        this.this$0 = bgTextConfigDialog;
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface, Integer num) {
        invoke(dialogInterface, num.intValue());
        return f.v.a;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
        f.c0.c.j.e(dialogInterface, "$noName_0");
        if (i2 >= 0) {
            ReadBookConfig.INSTANCE.setDurConfig(this.$defaultConfigs.get(i2));
            BgTextConfigDialog bgTextConfigDialog = this.this$0;
            f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
            bgTextConfigDialog.S();
            LiveEventBus.get("upConfig").post(Boolean.TRUE);
        }
    }
}
