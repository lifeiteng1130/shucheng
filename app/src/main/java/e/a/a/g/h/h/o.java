package e.a.a.g.h.h;

import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import io.legado.app.databinding.ViewLoadMoreBinding;
import io.legado.app.ui.main.explore.BookStoreFragment;
import io.legado.app.ui.widget.recycler.LoadMoreView;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookStoreFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends f.c0.c.k implements f.c0.b.l<ViewGroup, ViewBinding> {
    public final /* synthetic */ BookStoreFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(BookStoreFragment bookStoreFragment) {
        super(1);
        this.this$0 = bookStoreFragment;
    }

    @Override // f.c0.b.l
    @NotNull
    public final ViewBinding invoke(@NotNull ViewGroup viewGroup) {
        f.c0.c.j.e(viewGroup, "it");
        LoadMoreView loadMoreView = this.this$0.loadMoreView;
        if (loadMoreView == null) {
            f.c0.c.j.m("loadMoreView");
            throw null;
        }
        ViewLoadMoreBinding viewLoadMoreBindingA = ViewLoadMoreBinding.a(loadMoreView);
        f.c0.c.j.d(viewLoadMoreBindingA, "bind(loadMoreView)");
        return viewLoadMoreBindingA;
    }
}
