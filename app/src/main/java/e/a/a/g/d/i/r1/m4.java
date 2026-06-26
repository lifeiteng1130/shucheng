package e.a.a.g.d.i.r1;

import android.content.DialogInterface;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.config.TipConfigDialog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TipConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m4 extends f.c0.c.k implements f.c0.b.p<DialogInterface, Integer, f.v> {
    public final /* synthetic */ TipConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m4(TipConfigDialog tipConfigDialog) {
        super(2);
        this.this$0 = tipConfigDialog;
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface, Integer num) {
        invoke(dialogInterface, num.intValue());
        return f.v.a;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
        f.c0.c.j.e(dialogInterface, "$noName_0");
        if (i2 == 0) {
            e.a.a.d.r rVar = e.a.a.d.r.a;
            ReadBookConfig.INSTANCE.getConfig().setTipColor(0);
            TipConfigDialog tipConfigDialog = this.this$0;
            f.f0.h<Object>[] hVarArr = TipConfigDialog.f7209b;
            tipConfigDialog.S();
            LiveEventBus.get("upConfig").post(Boolean.TRUE);
            return;
        }
        if (i2 != 1) {
            return;
        }
        int[] iArr = ColorPickerDialog.a;
        ColorPickerDialog.j jVar = new ColorPickerDialog.j();
        jVar.f2587i = false;
        jVar.f2583e = 0;
        jVar.f2586h = 7897;
        jVar.b(this.this$0.requireActivity());
    }
}
