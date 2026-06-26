package e.a.a.g.k.a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import io.legado.app.databinding.ItemRssArticle2Binding;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssArticlesAdapter2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements c.b.a.q.e<Drawable> {
    public final /* synthetic */ ItemRssArticle2Binding a;

    public m(ItemRssArticle2Binding itemRssArticle2Binding) {
        this.a = itemRssArticle2Binding;
    }

    @Override // c.b.a.q.e
    public boolean a(@Nullable c.b.a.m.q.r rVar, @Nullable Object obj, @Nullable c.b.a.q.j.h<Drawable> hVar, boolean z) {
        ImageView imageView = this.a.f6823b;
        f.c0.c.j.d(imageView, "imageView");
        c.b.a.m.f.e3(imageView);
        return false;
    }

    @Override // c.b.a.q.e
    public boolean b(Drawable drawable, Object obj, c.b.a.q.j.h<Drawable> hVar, c.b.a.m.a aVar, boolean z) {
        ImageView imageView = this.a.f6823b;
        f.c0.c.j.d(imageView, "imageView");
        c.b.a.m.f.c6(imageView);
        return false;
    }
}
