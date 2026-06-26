package e.a.a.g.d.e;

import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import io.legado.app.databinding.ViewLoadMoreBinding;
import io.legado.app.ui.book.explore.ExploreShowActivity;
import io.legado.app.ui.widget.recycler.LoadMoreView;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExploreShowActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends k implements l<ViewGroup, ViewBinding> {
    public final /* synthetic */ ExploreShowActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ExploreShowActivity exploreShowActivity) {
        super(1);
        this.this$0 = exploreShowActivity;
    }

    @Override // f.c0.b.l
    @NotNull
    public final ViewBinding invoke(@NotNull ViewGroup viewGroup) {
        j.e(viewGroup, "it");
        LoadMoreView loadMoreView = this.this$0.loadMoreView;
        if (loadMoreView == null) {
            j.m("loadMoreView");
            throw null;
        }
        ViewLoadMoreBinding viewLoadMoreBindingA = ViewLoadMoreBinding.a(loadMoreView);
        j.d(viewLoadMoreBindingA, "bind(loadMoreView)");
        return viewLoadMoreBindingA;
    }
}
