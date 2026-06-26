package e.a.a.g.d.i.r1;

import android.content.DialogInterface;
import com.jeremyliao.liveeventbus.LiveEventBus;
import io.legado.app.databinding.DialogTipConfigBinding;
import io.legado.app.help.ReadBookConfig;
import java.util.LinkedHashMap;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TipConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r4 extends f.c0.c.k implements f.c0.b.p<DialogInterface, Integer, f.v> {
    public final /* synthetic */ LinkedHashMap<Integer, String> $footerModes;
    public final /* synthetic */ DialogTipConfigBinding $this_with;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r4(LinkedHashMap<Integer, String> linkedHashMap, DialogTipConfigBinding dialogTipConfigBinding) {
        super(2);
        this.$footerModes = linkedHashMap;
        this.$this_with = dialogTipConfigBinding;
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface, Integer num) {
        invoke(dialogInterface, num.intValue());
        return f.v.a;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
        f.c0.c.j.e(dialogInterface, "$noName_0");
        e.a.a.d.r rVar = e.a.a.d.r.a;
        Set<Integer> setKeySet = this.$footerModes.keySet();
        f.c0.c.j.d(setKeySet, "footerModes.keys");
        Object obj = f.x.e.F(setKeySet).get(i2);
        f.c0.c.j.d(obj, "footerModes.keys.toList()[i]");
        ReadBookConfig.INSTANCE.getConfig().setFooterMode(((Number) obj).intValue());
        this.$this_with.r.setText(this.$footerModes.get(Integer.valueOf(rVar.a())));
        LiveEventBus.get("upConfig").post(Boolean.TRUE);
    }
}
