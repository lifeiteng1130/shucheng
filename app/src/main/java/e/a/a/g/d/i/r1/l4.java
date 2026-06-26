package e.a.a.g.d.i.r1;

import android.content.DialogInterface;
import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.databinding.DialogTipConfigBinding;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.config.TipConfigDialog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TipConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l4 extends f.c0.c.k implements f.c0.b.p<DialogInterface, Integer, f.v> {
    public final /* synthetic */ DialogTipConfigBinding $this_with;
    public final /* synthetic */ TipConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l4(TipConfigDialog tipConfigDialog, DialogTipConfigBinding dialogTipConfigBinding) {
        super(2);
        this.this$0 = tipConfigDialog;
        this.$this_with = dialogTipConfigBinding;
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface, Integer num) {
        invoke(dialogInterface, num.intValue());
        return f.v.a;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
        f.c0.c.j.e(dialogInterface, "$noName_0");
        TipConfigDialog.Q(this.this$0, i2);
        e.a.a.d.r rVar = e.a.a.d.r.a;
        ReadBookConfig.INSTANCE.getConfig().setTipFooterRight(i2);
        this.$this_with.q.setText(rVar.l().get(i2));
        LiveEventBus.get("upConfig").post(Boolean.TRUE);
    }
}
