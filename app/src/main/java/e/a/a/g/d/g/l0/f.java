package e.a.a.g.d.g.l0;

import android.net.Uri;
import e.a.a.h.a0;
import f.c0.c.k;
import f.v;
import io.legado.app.ui.book.info.edit.BookInfoEditActivity;
import io.legado.app.utils.FileUtils;
import java.io.File;

/* JADX INFO: compiled from: BookInfoEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends k implements f.c0.b.a<v> {
    public final /* synthetic */ Uri $uri;
    public final /* synthetic */ BookInfoEditActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(BookInfoEditActivity bookInfoEditActivity, Uri uri) {
        super(0);
        this.this$0 = bookInfoEditActivity;
        this.$uri = uri;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ v invoke() {
        invoke2();
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String strB = a0.b(this.this$0, this.$uri);
        if (strB == null) {
            return;
        }
        BookInfoEditActivity bookInfoEditActivity = this.this$0;
        File file = new File(strB);
        if (file.exists()) {
            File fileR2 = c.b.a.m.f.r2(bookInfoEditActivity);
            FileUtils fileUtils = FileUtils.a;
            String name = file.getName();
            f.c0.c.j.d(name, "imgFile.name");
            File fileA = fileUtils.a(fileR2, "covers", name);
            f.b0.d.e(fileA, f.b0.d.c(file));
            String absolutePath = fileA.getAbsolutePath();
            f.c0.c.j.d(absolutePath, "file.absolutePath");
            bookInfoEditActivity.o0(absolutePath);
        }
    }
}
