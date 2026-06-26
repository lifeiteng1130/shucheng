package e.a.a.g.d.i.r1;

import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.widget.checkbox.SmoothCheckBox;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PaddingConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x2 extends f.c0.c.k implements f.c0.b.p<SmoothCheckBox, Boolean, f.v> {
    public final /* synthetic */ ReadBookConfig $this_with;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x2(ReadBookConfig readBookConfig) {
        super(2);
        this.$this_with = readBookConfig;
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ f.v invoke(SmoothCheckBox smoothCheckBox, Boolean bool) {
        invoke(smoothCheckBox, bool.booleanValue());
        return f.v.a;
    }

    public final void invoke(@NotNull SmoothCheckBox smoothCheckBox, boolean z) {
        f.c0.c.j.e(smoothCheckBox, "$noName_0");
        this.$this_with.setShowHeaderLine(z);
        LiveEventBus.get("upConfig").post(Boolean.TRUE);
    }
}
