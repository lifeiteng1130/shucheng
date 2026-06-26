package e.a.a.g.e;

import android.content.Context;
import android.net.Uri;
import io.legado.app.ui.config.OtherConfigFragment;
import io.legado.app.ui.widget.image.CoverImageView;
import io.legado.app.utils.FileUtils;
import java.io.File;

/* JADX INFO: compiled from: OtherConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends f.c0.c.k implements f.c0.b.a<f.v> {
    public final /* synthetic */ Uri $uri;
    public final /* synthetic */ OtherConfigFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(OtherConfigFragment otherConfigFragment, Uri uri) {
        super(0);
        this.this$0 = otherConfigFragment;
        this.$uri = uri;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ f.v invoke() {
        invoke2();
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Context contextRequireContext = this.this$0.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        String strB = e.a.a.h.a0.b(contextRequireContext, this.$uri);
        if (strB == null) {
            return;
        }
        OtherConfigFragment otherConfigFragment = this.this$0;
        File file = new File(strB);
        if (file.exists()) {
            Context contextRequireContext2 = otherConfigFragment.requireContext();
            f.c0.c.j.d(contextRequireContext2, "requireContext()");
            File fileR2 = c.b.a.m.f.r2(contextRequireContext2);
            FileUtils fileUtils = FileUtils.a;
            String name = file.getName();
            f.c0.c.j.d(name, "imgFile.name");
            File fileA = fileUtils.a(fileR2, "covers", name);
            f.b0.d.e(fileA, f.b0.d.c(file));
            String absolutePath = fileA.getAbsolutePath();
            f.c0.c.j.d(absolutePath, "file.absolutePath");
            e.a.a.h.m.j(otherConfigFragment, "defaultCover", absolutePath);
            CoverImageView coverImageView = CoverImageView.a;
            CoverImageView.c();
        }
    }
}
