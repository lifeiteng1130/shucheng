package e.a.a.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import io.legado.app.model.analyzeRule.AnalyzeUrl;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImageLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    @NotNull
    public static final c.b.a.h<Drawable> a(@NotNull Context context, @Nullable String str) {
        Object objM11constructorimpl;
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (str == null || str.length() == 0) {
            c.b.a.h<Drawable> hVarG = c.b.a.b.d(context).i().G(str);
            f.c0.c.j.d(hVarG, "with(context).load(path)");
            return hVarG;
        }
        if (c.b.a.m.f.o3(str)) {
            c.b.a.h<Drawable> hVarG2 = c.b.a.b.d(context).i().G(new AnalyzeUrl(str, null, null, null, null, null, false, null, null, null, null, 2046, null).getGlideUrl());
            f.c0.c.j.d(hVarG2, "with(context).load(AnalyzeUrl(path).getGlideUrl())");
            return hVarG2;
        }
        if (c.b.a.m.f.t3(str)) {
            c.b.a.h<Drawable> hVarG3 = c.b.a.b.d(context).i().G(Uri.parse(str));
            f.c0.c.j.d(hVarG3, "with(context).load(Uri.parse(path))");
            return hVarG3;
        }
        try {
            objM11constructorimpl = f.h.m11constructorimpl(c.b.a.b.d(context).i().G(new File(str)));
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
        }
        if (f.h.m14exceptionOrNullimpl(objM11constructorimpl) != null) {
            objM11constructorimpl = c.b.a.b.d(context).i().G(str);
        }
        f.c0.c.j.d(objM11constructorimpl, "runCatching {\n                Glide.with(context).load(File(path))\n            }.getOrElse {\n                Glide.with(context).load(path)\n            }");
        return (c.b.a.h) objM11constructorimpl;
    }
}
