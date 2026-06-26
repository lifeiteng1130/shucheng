package e.a.a.g.k.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import c.b.a.m.f;
import c.b.a.m.q.r;
import c.b.a.q.e;
import c.b.a.q.j.h;
import f.c0.c.j;
import io.legado.app.databinding.ItemRssArticleBinding;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssFavoritesAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements e<Drawable> {
    public final /* synthetic */ ItemRssArticleBinding a;

    public c(ItemRssArticleBinding itemRssArticleBinding) {
        this.a = itemRssArticleBinding;
    }

    @Override // c.b.a.q.e
    public boolean a(@Nullable r rVar, @Nullable Object obj, @Nullable h<Drawable> hVar, boolean z) {
        ImageView imageView = this.a.f6826b;
        j.d(imageView, "imageView");
        f.e3(imageView);
        return false;
    }

    @Override // c.b.a.q.e
    public boolean b(Drawable drawable, Object obj, h<Drawable> hVar, c.b.a.m.a aVar, boolean z) {
        ImageView imageView = this.a.f6826b;
        j.d(imageView, "imageView");
        f.c6(imageView);
        return false;
    }
}
