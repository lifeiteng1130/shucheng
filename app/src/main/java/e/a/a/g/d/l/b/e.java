package e.a.a.g.d.l.b;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentManager;
import f.c0.b.p;
import f.v;
import io.legado.app.ui.book.source.edit.BookSourceEditActivity;
import io.legado.app.ui.widget.dialog.TextDialog;
import java.io.IOException;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookSourceEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends f.c0.c.k implements p<DialogInterface, Integer, v> {
    public final /* synthetic */ BookSourceEditActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(BookSourceEditActivity bookSourceEditActivity) {
        super(2);
        this.this$0 = bookSourceEditActivity;
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) throws IOException {
        invoke(dialogInterface, num.intValue());
        return v.a;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface, int i2) throws IOException {
        f.c0.c.j.e(dialogInterface, "$noName_0");
        if (i2 == 0) {
            BookSourceEditActivity bookSourceEditActivity = this.this$0;
            e.a.a.c.c cVar = e.a.a.c.c.a;
            String str = (String) e.a.a.c.c.f5501g.getValue();
            int i3 = BookSourceEditActivity.f7298g;
            bookSourceEditActivity.X0(str);
            return;
        }
        if (i2 == 1) {
            BookSourceEditActivity bookSourceEditActivity2 = this.this$0;
            int i4 = BookSourceEditActivity.f7298g;
            bookSourceEditActivity2.Z0();
        } else {
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.this$0.selectDoc.launch(new e.a.a.g.f.d(1, null, null, null, 14));
                return;
            }
            BookSourceEditActivity bookSourceEditActivity3 = this.this$0;
            int i5 = BookSourceEditActivity.f7298g;
            InputStream inputStreamOpen = bookSourceEditActivity3.getAssets().open("help/regexHelp.md");
            f.c0.c.j.d(inputStreamOpen, "assets.open(\"help/regexHelp.md\")");
            String str2 = new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a);
            TextDialog.Companion companion = TextDialog.INSTANCE;
            FragmentManager supportFragmentManager = bookSourceEditActivity3.getSupportFragmentManager();
            f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
            TextDialog.Companion.a(companion, supportFragmentManager, str2, 1, 0L, false, 24);
        }
    }
}
