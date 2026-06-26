package e.a.a.g.d.i;

import android.content.DialogInterface;
import io.legado.app.data.entities.Book;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadBookBaseActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends f.c0.c.k implements f.c0.b.p<DialogInterface, Integer, f.v> {
    public final /* synthetic */ f.c0.b.a<f.v> $success;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(f.c0.b.a<f.v> aVar) {
        super(2);
        this.$success = aVar;
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface, Integer num) {
        invoke(dialogInterface, num.intValue());
        return f.v.a;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
        f.c0.c.j.e(dialogInterface, "$noName_0");
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        Book book = e.a.a.f.s.k.f5677c;
        if (book != null) {
            book.setPageAnim(i2 - 1);
        }
        this.$success.invoke();
    }
}
