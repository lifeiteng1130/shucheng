package io.legado.app.ui.book.explore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import e.a.a.g.d.e.f;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.v;
import f.e;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.ActivityExploreShowBinding;
import io.legado.app.ui.book.explore.ExploreShowActivity;
import io.legado.app.ui.book.explore.ExploreShowAdapter;
import io.legado.app.ui.book.info.BookInfoActivity;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dynamiclayout.DynamicFrameLayout;
import io.legado.app.ui.widget.recycler.LoadMoreView;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExploreShowActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b \u0010\u000fJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0014\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001e¨\u0006!"}, d2 = {"Lio/legado/app/ui/book/explore/ExploreShowActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityExploreShowBinding;", "Lio/legado/app/ui/book/explore/ExploreShowViewModel;", "Lio/legado/app/ui/book/explore/ExploreShowAdapter$a;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Lio/legado/app/data/entities/Book;", "book", "k", "(Lio/legado/app/data/entities/Book;)V", "U0", "()V", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/book/explore/ExploreShowViewModel;", "viewModel", "Lio/legado/app/ui/book/explore/ExploreShowAdapter;", ai.aA, "Lio/legado/app/ui/book/explore/ExploreShowAdapter;", "adapter", "Lio/legado/app/ui/widget/recycler/LoadMoreView;", "j", "Lio/legado/app/ui/widget/recycler/LoadMoreView;", "loadMoreView", "", "Z", "isLoading", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ExploreShowActivity extends VMBaseActivity<ActivityExploreShowBinding, ExploreShowViewModel> implements ExploreShowAdapter.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7078g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public ExploreShowAdapter adapter;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public LoadMoreView loadMoreView;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean isLoading;

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class a extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class b extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            j.d(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    public ExploreShowActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(v.a(ExploreShowViewModel.class), new b(this), new a(this));
        this.isLoading = true;
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_explore_show, (ViewGroup) null, false);
        int i2 = R.id.content_view;
        DynamicFrameLayout dynamicFrameLayout = (DynamicFrameLayout) viewInflate.findViewById(R.id.content_view);
        if (dynamicFrameLayout != null) {
            i2 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                i2 = R.id.title_bar;
                TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    ActivityExploreShowBinding activityExploreShowBinding = new ActivityExploreShowBinding((ConstraintLayout) viewInflate, dynamicFrameLayout, recyclerView, titleBar);
                    j.d(activityExploreShowBinding, "inflate(layoutInflater)");
                    return activityExploreShowBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        ((ActivityExploreShowBinding) K0()).f6511c.setTitle(getIntent().getStringExtra("exploreName"));
        this.adapter = new ExploreShowAdapter(this, this);
        ((ActivityExploreShowBinding) K0()).f6510b.addItemDecoration(new VerticalDivider(this));
        RecyclerView recyclerView = ((ActivityExploreShowBinding) K0()).f6510b;
        ExploreShowAdapter exploreShowAdapter = this.adapter;
        if (exploreShowAdapter == null) {
            j.m("adapter");
            throw null;
        }
        recyclerView.setAdapter(exploreShowAdapter);
        this.loadMoreView = new LoadMoreView(this, null);
        ExploreShowAdapter exploreShowAdapter2 = this.adapter;
        if (exploreShowAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        exploreShowAdapter2.d(new e.a.a.g.d.e.e(this));
        LoadMoreView loadMoreView = this.loadMoreView;
        if (loadMoreView == null) {
            j.m("loadMoreView");
            throw null;
        }
        loadMoreView.d();
        LoadMoreView loadMoreView2 = this.loadMoreView;
        if (loadMoreView2 == null) {
            j.m("loadMoreView");
            throw null;
        }
        loadMoreView2.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.e.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExploreShowActivity exploreShowActivity = this.a;
                int i2 = ExploreShowActivity.f7078g;
                j.e(exploreShowActivity, "this$0");
                if (exploreShowActivity.isLoading) {
                    return;
                }
                LoadMoreView loadMoreView3 = exploreShowActivity.loadMoreView;
                if (loadMoreView3 == null) {
                    j.m("loadMoreView");
                    throw null;
                }
                loadMoreView3.b();
                exploreShowActivity.U0();
                exploreShowActivity.isLoading = true;
            }
        });
        ((ActivityExploreShowBinding) K0()).f6510b.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: io.legado.app.ui.book.explore.ExploreShowActivity$initRecyclerView$3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int dx, int dy) {
                j.e(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, dx, dy);
                if (recyclerView2.canScrollVertically(1)) {
                    return;
                }
                ExploreShowActivity exploreShowActivity = this.a;
                int i2 = ExploreShowActivity.f7078g;
                exploreShowActivity.U0();
            }
        });
        T0().booksData.observe(this, new Observer() { // from class: e.a.a.g.d.e.c
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ExploreShowActivity exploreShowActivity = this.a;
                List list = (List) obj;
                int i2 = ExploreShowActivity.f7078g;
                j.e(exploreShowActivity, "this$0");
                j.d(list, "it");
                exploreShowActivity.isLoading = false;
                if (list.isEmpty()) {
                    ExploreShowAdapter exploreShowAdapter3 = exploreShowActivity.adapter;
                    if (exploreShowAdapter3 == null) {
                        j.m("adapter");
                        throw null;
                    }
                    if (exploreShowAdapter3.items.isEmpty()) {
                        LoadMoreView loadMoreView3 = exploreShowActivity.loadMoreView;
                        if (loadMoreView3 != null) {
                            loadMoreView3.c(exploreShowActivity.getString(R.string.empty));
                            return;
                        } else {
                            j.m("loadMoreView");
                            throw null;
                        }
                    }
                }
                if (list.isEmpty()) {
                    LoadMoreView loadMoreView4 = exploreShowActivity.loadMoreView;
                    if (loadMoreView4 == null) {
                        j.m("loadMoreView");
                        throw null;
                    }
                    int i3 = LoadMoreView.a;
                    loadMoreView4.c(null);
                    return;
                }
                ExploreShowAdapter exploreShowAdapter4 = exploreShowActivity.adapter;
                if (exploreShowAdapter4 == null) {
                    j.m("adapter");
                    throw null;
                }
                if (exploreShowAdapter4.items.contains(f.x.e.k(list))) {
                    ExploreShowAdapter exploreShowAdapter5 = exploreShowActivity.adapter;
                    if (exploreShowAdapter5 == null) {
                        j.m("adapter");
                        throw null;
                    }
                    if (exploreShowAdapter5.items.contains(f.x.e.r(list))) {
                        LoadMoreView loadMoreView5 = exploreShowActivity.loadMoreView;
                        if (loadMoreView5 == null) {
                            j.m("loadMoreView");
                            throw null;
                        }
                        int i4 = LoadMoreView.a;
                        loadMoreView5.c(null);
                        return;
                    }
                }
                ExploreShowAdapter exploreShowAdapter6 = exploreShowActivity.adapter;
                if (exploreShowAdapter6 != null) {
                    exploreShowAdapter6.g(list);
                } else {
                    j.m("adapter");
                    throw null;
                }
            }
        });
        ExploreShowViewModel exploreShowViewModelT0 = T0();
        Intent intent = getIntent();
        j.d(intent, "intent");
        Objects.requireNonNull(exploreShowViewModelT0);
        j.e(intent, "intent");
        BaseViewModel.a(exploreShowViewModelT0, null, null, new f(intent, exploreShowViewModelT0, null), 3, null);
        T0().errorLiveData.observe(this, new Observer() { // from class: e.a.a.g.d.e.a
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ExploreShowActivity exploreShowActivity = this.a;
                String str = (String) obj;
                int i2 = ExploreShowActivity.f7078g;
                j.e(exploreShowActivity, "this$0");
                LoadMoreView loadMoreView3 = exploreShowActivity.loadMoreView;
                if (loadMoreView3 == null) {
                    j.m("loadMoreView");
                    throw null;
                }
                j.d(str, "it");
                loadMoreView3.a(str, null);
            }
        });
    }

    @NotNull
    public ExploreShowViewModel T0() {
        return (ExploreShowViewModel) this.viewModel.getValue();
    }

    public final void U0() {
        if (this.adapter == null) {
            j.m("adapter");
            throw null;
        }
        LoadMoreView loadMoreView = this.loadMoreView;
        if (loadMoreView == null) {
            j.m("loadMoreView");
            throw null;
        }
        if (!loadMoreView.getHasMore() || this.isLoading) {
            return;
        }
        T0().e();
    }

    @Override // io.legado.app.ui.book.explore.ExploreShowAdapter.a
    public void k(@NotNull Book book) {
        j.e(book, "book");
        Intent intent = new Intent(this, (Class<?>) BookInfoActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("name", book.getName());
        intent.putExtra("author", book.getAuthor());
        startActivity(intent);
    }
}
