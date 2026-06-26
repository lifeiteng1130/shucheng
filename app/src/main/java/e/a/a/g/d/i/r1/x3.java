package e.a.a.g.d.i.r1;

import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.config.ReadStyleDialog;
import io.legado.app.ui.widget.checkbox.SmoothCheckBox;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadStyleDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x3 extends f.c0.c.k implements f.c0.b.p<SmoothCheckBox, Boolean, f.v> {
    public final /* synthetic */ ReadStyleDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x3(ReadStyleDialog readStyleDialog) {
        super(2);
        this.this$0 = readStyleDialog;
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ f.v invoke(SmoothCheckBox smoothCheckBox, Boolean bool) {
        invoke(smoothCheckBox, bool.booleanValue());
        return f.v.a;
    }

    public final void invoke(@NotNull SmoothCheckBox smoothCheckBox, boolean z) {
        f.c0.c.j.e(smoothCheckBox, "$noName_0");
        ReadBookConfig.INSTANCE.setShareLayout(z);
        ReadStyleDialog readStyleDialog = this.this$0;
        f.f0.h<Object>[] hVarArr = ReadStyleDialog.f7191b;
        readStyleDialog.U();
        LiveEventBus.get("upConfig").post(Boolean.TRUE);
    }
}
