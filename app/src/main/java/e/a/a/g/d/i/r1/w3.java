package e.a.a.g.d.i.r1;

import android.content.DialogInterface;
import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.help.ReadBookConfig;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadStyleDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w3 extends f.c0.c.k implements f.c0.b.p<DialogInterface, Integer, f.v> {
    public static final w3 INSTANCE = new w3();

    public w3() {
        super(2);
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface, Integer num) {
        invoke(dialogInterface, num.intValue());
        return f.v.a;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
        f.c0.c.j.e(dialogInterface, "$noName_0");
        ReadBookConfig.INSTANCE.setParagraphIndent(f.h0.k.B("\u3000", i2));
        LiveEventBus.get("upConfig").post(Boolean.TRUE);
    }
}
