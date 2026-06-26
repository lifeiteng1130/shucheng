package e.a.a.g.j.i0;

import android.content.DialogInterface;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.ui.replace.edit.ReplaceEditActivity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReplaceEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends k implements p<DialogInterface, Integer, v> {
    public final /* synthetic */ ReplaceEditActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ReplaceEditActivity replaceEditActivity) {
        super(2);
        this.this$0 = replaceEditActivity;
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
        invoke(dialogInterface, num.intValue());
        return v.a;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
        j.e(dialogInterface, "$noName_0");
        if (i2 == 0) {
            ReplaceEditActivity replaceEditActivity = this.this$0;
            ReplaceEditActivity.Companion aVar = ReplaceEditActivity.INSTANCE;
            replaceEditActivity.U0();
        }
    }
}
