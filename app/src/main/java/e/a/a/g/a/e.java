package e.a.a.g.a;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentManager;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.ui.about.AboutFragment;
import io.legado.app.ui.widget.dialog.TextDialog;
import java.io.File;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AboutFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends k implements p<DialogInterface, Integer, v> {
    public final /* synthetic */ File[] $crashLogs;
    public final /* synthetic */ AboutFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(File[] fileArr, AboutFragment aboutFragment) {
        super(2);
        this.$crashLogs = fileArr;
        this.this$0 = aboutFragment;
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
        invoke(dialogInterface, num.intValue());
        return v.a;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
        j.e(dialogInterface, "$noName_0");
        File[] fileArr = this.$crashLogs;
        if (fileArr == null) {
            return;
        }
        j.e(fileArr, "$this$getOrNull");
        File file = (i2 < 0 || i2 > c.b.a.m.f.z2(fileArr)) ? null : fileArr[i2];
        if (file == null) {
            return;
        }
        AboutFragment aboutFragment = this.this$0;
        TextDialog.Companion companion = TextDialog.INSTANCE;
        FragmentManager childFragmentManager = aboutFragment.getChildFragmentManager();
        j.d(childFragmentManager, "childFragmentManager");
        TextDialog.Companion.a(companion, childFragmentManager, f.b0.d.d(file, null, 1), 0, 0L, false, 28);
    }
}
