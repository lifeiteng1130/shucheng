package e.a.a.g.d.g.l0;

import f.c0.c.k;
import f.v;
import io.legado.app.ui.book.info.edit.BookInfoEditActivity;

/* JADX INFO: compiled from: BookInfoEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends k implements f.c0.b.a<v> {
    public final /* synthetic */ BookInfoEditActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(BookInfoEditActivity bookInfoEditActivity) {
        super(0);
        this.this$0 = bookInfoEditActivity;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ v invoke() {
        invoke2();
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.setResult(-1);
        this.this$0.finish();
    }
}
