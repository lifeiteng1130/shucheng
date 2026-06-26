package io.legado.app.ui.main.bookshelf.books;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.umeng.analytics.pro.ai;
import e.a.a.h.m;
import f.c0.b.a;
import f.c0.b.l;
import f.c0.c.f;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.f0.h;
import f.g;
import f.v;
import io.legado.app.base.BaseFragment;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.FragmentBooksBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.audio.AudioPlayActivity;
import io.legado.app.ui.book.info.BookInfoActivity;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.main.MainViewModel;
import io.legado.app.ui.main.bookshelf.books.BaseBooksAdapter;
import io.legado.app.ui.main.bookshelf.books.BooksFragment;
import io.legado.app.utils.EventBusExtensionsKt$observeEvent$o$2;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BooksFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b/\u0010\u0015J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001b\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010(\u001a\u0006\u0012\u0002\b\u00030%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010.\u001a\u00020)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00062"}, d2 = {"Lio/legado/app/ui/main/bookshelf/books/BooksFragment;", "Lio/legado/app/base/BaseFragment;", "Lio/legado/app/ui/main/bookshelf/books/BaseBooksAdapter$a;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "R", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lio/legado/app/data/entities/Book;", "book", ai.aF, "(Lio/legado/app/data/entities/Book;)V", ai.aC, "", "bookUrl", "", "r", "(Ljava/lang/String;)Z", "O", "()V", "", "j", "J", "groupId", "Landroidx/lifecycle/LiveData;", "", ai.aA, "Landroidx/lifecycle/LiveData;", "bookshelfLiveData", "Lio/legado/app/ui/main/MainViewModel;", "g", "Lf/e;", "getActivityViewModel", "()Lio/legado/app/ui/main/MainViewModel;", "activityViewModel", "Lio/legado/app/ui/main/bookshelf/books/BaseBooksAdapter;", "h", "Lio/legado/app/ui/main/bookshelf/books/BaseBooksAdapter;", "booksAdapter", "Lio/legado/app/databinding/FragmentBooksBinding;", "f", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "U", "()Lio/legado/app/databinding/FragmentBooksBinding;", "binding", "<init>", "d", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BooksFragment extends BaseFragment implements BaseBooksAdapter.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e activityViewModel;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public BaseBooksAdapter<?> booksAdapter;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<Book>> bookshelfLiveData;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public long groupId;

    /* JADX INFO: renamed from: io.legado.app.ui.main.bookshelf.books.BooksFragment$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: BooksFragment.kt */
    public static final class Companion {
        public Companion(f fVar) {
        }
    }

    /* JADX INFO: compiled from: BooksFragment.kt */
    public static final class b extends k implements l<String, v> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            j.e(str, "it");
            BaseBooksAdapter<?> baseBooksAdapter = BooksFragment.this.booksAdapter;
            if (baseBooksAdapter == null) {
                j.m("booksAdapter");
                throw null;
            }
            j.e(str, "bookUrl");
            int itemCount = baseBooksAdapter.getItemCount();
            if (itemCount <= 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                Book item = baseBooksAdapter.getItem(i2);
                if (item != null && j.a(item.getBookUrl(), str)) {
                    baseBooksAdapter.notifyItemChanged(i2, BundleKt.bundleOf(new g("refresh", null)));
                    return;
                } else if (i3 >= itemCount) {
                    return;
                } else {
                    i2 = i3;
                }
            }
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class c extends k implements a<ViewModelStore> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.$this_activityViewModels.requireActivity();
            j.d(fragmentActivityRequireActivity, "requireActivity()");
            ViewModelStore viewModelStore = fragmentActivityRequireActivity.getViewModelStore();
            j.d(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class d extends k implements a<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.$this_activityViewModels.requireActivity();
            j.d(fragmentActivityRequireActivity, "requireActivity()");
            return fragmentActivityRequireActivity.getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class e extends k implements l<BooksFragment, FragmentBooksBinding> {
        public e() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final FragmentBooksBinding invoke(@NotNull BooksFragment booksFragment) {
            j.e(booksFragment, "fragment");
            View viewRequireView = booksFragment.requireView();
            int i2 = R.id.refresh_layout;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewRequireView.findViewById(R.id.refresh_layout);
            if (swipeRefreshLayout != null) {
                i2 = R.id.rv_bookshelf;
                RecyclerView recyclerView = (RecyclerView) viewRequireView.findViewById(R.id.rv_bookshelf);
                if (recyclerView != null) {
                    i2 = R.id.tv_empty_msg;
                    TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_empty_msg);
                    if (textView != null) {
                        return new FragmentBooksBinding((FrameLayout) viewRequireView, swipeRefreshLayout, recyclerView, textView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        h<Object>[] hVarArr = new h[2];
        q qVar = new q(f.c0.c.v.a(BooksFragment.class), "binding", "getBinding()Lio/legado/app/databinding/FragmentBooksBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        hVarArr[0] = qVar;
        f7417e = hVarArr;
        INSTANCE = new Companion(null);
    }

    public BooksFragment() {
        super(R.layout.fragment_books);
        this.binding = c.b.a.m.f.b6(this, new e());
        this.activityViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, f.c0.c.v.a(MainViewModel.class), new c(this), new d(this));
        this.groupId = -1L;
    }

    @Override // io.legado.app.base.BaseFragment
    public void O() {
        String[] strArr = {"upBookToc"};
        EventBusExtensionsKt$observeEvent$o$2 eventBusExtensionsKt$observeEvent$o$2 = new EventBusExtensionsKt$observeEvent$o$2(new b());
        for (int i2 = 0; i2 < 1; i2++) {
            Observable observable = LiveEventBus.get(strArr[i2], String.class);
            j.d(observable, "get(tag, EVENT::class.java)");
            observable.observe(this, eventBusExtensionsKt$observeEvent$o$2);
        }
    }

    @Override // io.legado.app.base.BaseFragment
    public void R(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.getInt("position", 0);
            this.groupId = arguments.getLong("groupId", -1L);
        }
        ATH.a.b(U().f6708c);
        U().f6707b.setColorSchemeColors(c.b.a.m.f.N1(this));
        U().f6707b.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: e.a.a.g.h.g.n.d
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                BooksFragment booksFragment = this.a;
                BooksFragment.Companion companion = BooksFragment.INSTANCE;
                f.c0.c.j.e(booksFragment, "this$0");
                booksFragment.U().f6707b.setRefreshing(false);
                MainViewModel mainViewModel = (MainViewModel) booksFragment.activityViewModel.getValue();
                BaseBooksAdapter<?> baseBooksAdapter = booksFragment.booksAdapter;
                if (baseBooksAdapter != null) {
                    mainViewModel.f(baseBooksAdapter.g());
                } else {
                    f.c0.c.j.m("booksAdapter");
                    throw null;
                }
            }
        });
        int iE = m.e(this, "bookshelfLayout", 0, 2);
        if (iE == 0) {
            U().f6708c.setLayoutManager(new LinearLayoutManager(getContext()));
            Context contextRequireContext = requireContext();
            j.d(contextRequireContext, "requireContext()");
            this.booksAdapter = new BooksAdapterList(contextRequireContext, this);
        } else {
            U().f6708c.setLayoutManager(new GridLayoutManager(getContext(), iE + 2));
            Context contextRequireContext2 = requireContext();
            j.d(contextRequireContext2, "requireContext()");
            this.booksAdapter = new BooksAdapterGrid(contextRequireContext2, this);
        }
        RecyclerView recyclerView = U().f6708c;
        BaseBooksAdapter<?> baseBooksAdapter = this.booksAdapter;
        if (baseBooksAdapter == null) {
            j.m("booksAdapter");
            throw null;
        }
        recyclerView.setAdapter(baseBooksAdapter);
        BaseBooksAdapter<?> baseBooksAdapter2 = this.booksAdapter;
        if (baseBooksAdapter2 == null) {
            j.m("booksAdapter");
            throw null;
        }
        baseBooksAdapter2.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: io.legado.app.ui.main.bookshelf.books.BooksFragment$initRecyclerView$2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                BooksFragment booksFragment = this.a;
                BooksFragment.Companion companion = BooksFragment.INSTANCE;
                RecyclerView.LayoutManager layoutManager = booksFragment.U().f6708c.getLayoutManager();
                if (positionStart == 0 && (layoutManager instanceof LinearLayoutManager)) {
                    this.a.U().f6708c.scrollToPosition(Math.max(0, ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() - itemCount));
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                BooksFragment booksFragment = this.a;
                BooksFragment.Companion companion = BooksFragment.INSTANCE;
                RecyclerView.LayoutManager layoutManager = booksFragment.U().f6708c.getLayoutManager();
                if (toPosition == 0 && (layoutManager instanceof LinearLayoutManager)) {
                    this.a.U().f6708c.scrollToPosition(Math.max(0, ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() - itemCount));
                }
            }
        });
        LiveData<List<Book>> liveData = this.bookshelfLiveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        long j2 = this.groupId;
        LiveData<List<Book>> liveDataObserveAll = j2 == -1 ? AppDatabaseKt.getAppDb().getBookDao().observeAll() : j2 == -2 ? AppDatabaseKt.getAppDb().getBookDao().observeLocal() : j2 == -3 ? AppDatabaseKt.getAppDb().getBookDao().observeAudio() : j2 == -4 ? AppDatabaseKt.getAppDb().getBookDao().observeNoGroup() : AppDatabaseKt.getAppDb().getBookDao().observeByGroup(this.groupId);
        liveDataObserveAll.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.h.g.n.e
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BooksFragment booksFragment = this.a;
                List list = (List) obj;
                BooksFragment.Companion companion = BooksFragment.INSTANCE;
                f.c0.c.j.e(booksFragment, "this$0");
                TextView textView = booksFragment.U().f6709d;
                f.c0.c.j.d(textView, "binding.tvEmptyMsg");
                f.c0.c.j.d(list, "list");
                textView.setVisibility(list.isEmpty() ^ true ? 8 : 0);
                int iE2 = m.e(booksFragment, "bookshelfSort", 0, 2);
                List listB = iE2 != 1 ? iE2 != 2 ? iE2 != 3 ? f.x.e.B(list, new j()) : f.x.e.B(list, new h()) : f.x.e.B(list, c.a) : f.x.e.B(list, new i());
                if (listB == null || listB.isEmpty()) {
                    return;
                }
                BaseBooksAdapter<?> baseBooksAdapter3 = booksFragment.booksAdapter;
                if (baseBooksAdapter3 == null) {
                    f.c0.c.j.m("booksAdapter");
                    throw null;
                }
                baseBooksAdapter3.n(listB);
                BaseBooksAdapter<?> baseBooksAdapter4 = booksFragment.booksAdapter;
                if (baseBooksAdapter4 != null) {
                    baseBooksAdapter4.notifyDataSetChanged();
                } else {
                    f.c0.c.j.m("booksAdapter");
                    throw null;
                }
            }
        });
        this.bookshelfLiveData = liveDataObserveAll;
    }

    public final FragmentBooksBinding U() {
        return (FragmentBooksBinding) this.binding.b(this, f7417e[0]);
    }

    @Override // io.legado.app.ui.main.bookshelf.books.BaseBooksAdapter.a
    public boolean r(@NotNull String bookUrl) {
        j.e(bookUrl, "bookUrl");
        return ((MainViewModel) this.activityViewModel.getValue()).updateList.contains(bookUrl);
    }

    @Override // io.legado.app.ui.main.bookshelf.books.BaseBooksAdapter.a
    public void t(@NotNull Book book) {
        j.e(book, "book");
        if (book.getType() == 1) {
            Intent intent = new Intent(requireContext(), (Class<?>) AudioPlayActivity.class);
            intent.putExtra("bookUrl", book.getBookUrl());
            startActivity(intent);
        } else {
            Intent intent2 = new Intent(requireContext(), (Class<?>) ReadBookActivity.class);
            intent2.putExtra("bookUrl", book.getBookUrl());
            startActivity(intent2);
        }
    }

    @Override // io.legado.app.ui.main.bookshelf.books.BaseBooksAdapter.a
    public void v(@NotNull Book book) {
        j.e(book, "book");
        Intent intent = new Intent(requireContext(), (Class<?>) BookInfoActivity.class);
        intent.putExtra("name", book.getName());
        intent.putExtra("author", book.getAuthor());
        startActivity(intent);
    }
}
