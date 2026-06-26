package e.a.a.g.d.l.b;

import f.v;
import io.legado.app.data.entities.BookSource;
import io.legado.app.ui.book.source.edit.BookSourceEditActivity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookSourceEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends f.c0.c.k implements f.c0.b.l<BookSource, v> {
    public final /* synthetic */ BookSourceEditActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BookSourceEditActivity bookSourceEditActivity) {
        super(1);
        this.this$0 = bookSourceEditActivity;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ v invoke(BookSource bookSource) {
        invoke2(bookSource);
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull BookSource bookSource) {
        f.c0.c.j.e(bookSource, "source");
        BookSourceEditActivity bookSourceEditActivity = this.this$0;
        int i2 = BookSourceEditActivity.f7298g;
        bookSourceEditActivity.a1(bookSource);
    }
}
