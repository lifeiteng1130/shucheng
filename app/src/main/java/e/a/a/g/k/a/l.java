package e.a.a.g.k.a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import io.legado.app.databinding.ItemRssArticle1Binding;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssArticlesAdapter1.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements c.b.a.q.e<Drawable> {
    public final /* synthetic */ ItemRssArticle1Binding a;

    public l(ItemRssArticle1Binding itemRssArticle1Binding) {
        this.a = itemRssArticle1Binding;
    }

    @Override // c.b.a.q.e
    public boolean a(@Nullable c.b.a.m.q.r rVar, @Nullable Object obj, @Nullable c.b.a.q.j.h<Drawable> hVar, boolean z) {
        ImageView imageView = this.a.f6820b;
        f.c0.c.j.d(imageView, "imageView");
        c.b.a.m.f.e3(imageView);
        return false;
    }

    @Override // c.b.a.q.e
    public boolean b(Drawable drawable, Object obj, c.b.a.q.j.h<Drawable> hVar, c.b.a.m.a aVar, boolean z) {
        ImageView imageView = this.a.f6820b;
        f.c0.c.j.d(imageView, "imageView");
        c.b.a.m.f.c6(imageView);
        return false;
    }
}
