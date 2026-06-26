package e.a.a.g.d.i.r1;

import android.content.Context;
import android.net.Uri;
import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.config.BgTextConfigDialog;

/* JADX INFO: compiled from: BgTextConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k2 extends f.c0.c.k implements f.c0.b.a<f.v> {
    public final /* synthetic */ Uri $uri;
    public final /* synthetic */ BgTextConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k2(BgTextConfigDialog bgTextConfigDialog, Uri uri) {
        super(0);
        this.this$0 = bgTextConfigDialog;
        this.$uri = uri;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ f.v invoke() {
        invoke2();
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Context contextRequireContext = this.this$0.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        String strB = e.a.a.h.a0.b(contextRequireContext, this.$uri);
        if (strB == null) {
            return;
        }
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        readBookConfig.getDurConfig().setCurBg(2, strB);
        readBookConfig.upBg();
        LiveEventBus.get("upConfig").post(Boolean.FALSE);
    }
}
