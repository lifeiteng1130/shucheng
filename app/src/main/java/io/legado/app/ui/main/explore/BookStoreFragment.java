package io.legado.app.ui.main.explore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import com.google.gson.Gson;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.d.u.b;
import e.a.a.g.h.h.o;
import e.a.a.h.n;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.c0.c.k;
import f.f0.h;
import f.v;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseFragment;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookSourceDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.SwitchConfig;
import io.legado.app.databinding.FragmentBookStoreBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.book.explore.ExploreShowAdapter;
import io.legado.app.ui.book.explore.ExploreShowViewModel;
import io.legado.app.ui.book.info.BookInfoActivity;
import io.legado.app.ui.book.search.SearchActivity;
import io.legado.app.ui.main.explore.BookKindAdapter;
import io.legado.app.ui.main.explore.BookStoreAdapter;
import io.legado.app.ui.main.explore.BookStoreFragment;
import io.legado.app.ui.main.explore.ExploreDiffCallBack;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dynamiclayout.DynamicFrameLayout;
import io.legado.app.ui.widget.recycler.LoadMoreView;
import io.legado.app.ui.widget.recycler.RecyclerViewAtPager2;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BookStoreFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\bc\u0010\u000fJ\u001b\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u000fJ\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b&\u0010%J\u0017\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*R$\u00100\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010=\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070,\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010/R\u001d\u0010C\u001a\u00020>8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001d\u0010I\u001a\u00020D8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR&\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\u00070Jj\b\u0012\u0004\u0012\u00020\u0007`K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u001d\u0010]\u001a\u00020\u00028T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010@\u001a\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010X¨\u0006d"}, d2 = {"Lio/legado/app/ui/main/explore/BookStoreFragment;", "Lio/legado/app/base/VMBaseFragment;", "Lio/legado/app/ui/main/explore/ExploreViewModel;", "Lio/legado/app/ui/main/explore/BookStoreAdapter$a;", "Landroid/view/MenuItem$OnMenuItemClickListener;", "Lio/legado/app/ui/main/explore/BookKindAdapter$a;", "Lio/legado/app/ui/book/explore/ExploreShowAdapter$a;", "", "searchKey", "Lf/v;", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;)V", "Y", "()Lf/v;", "X", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "R", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "P", "(Landroid/view/Menu;)V", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "onPause", "Q", "(Landroid/view/MenuItem;)V", "", "pos", ai.at, "(I)V", "H", "Lio/legado/app/data/entities/Book;", "book", "k", "(Lio/legado/app/data/entities/Book;)V", "Landroidx/lifecycle/LiveData;", "", "Lio/legado/app/data/entities/BookSource;", "q", "Landroidx/lifecycle/LiveData;", "liveExplore", "Lio/legado/app/ui/book/explore/ExploreShowAdapter;", "j", "Lio/legado/app/ui/book/explore/ExploreShowAdapter;", "exploreAdapter", "Lio/legado/app/ui/widget/recycler/LoadMoreView;", "Lio/legado/app/ui/widget/recycler/LoadMoreView;", "loadMoreView", "Landroid/view/SubMenu;", "r", "Landroid/view/SubMenu;", "groupsMenu", Constants.LANDSCAPE, "liveGroup", "Lio/legado/app/ui/book/explore/ExploreShowViewModel;", "f", "Lf/e;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Lio/legado/app/ui/book/explore/ExploreShowViewModel;", "bookViewModel", "Lio/legado/app/databinding/FragmentBookStoreBinding;", "g", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "U", "()Lio/legado/app/databinding/FragmentBookStoreBinding;", "binding", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "m", "Ljava/util/LinkedHashSet;", "groups", "Lio/legado/app/ui/main/explore/BookKindAdapter;", ai.aA, "Lio/legado/app/ui/main/explore/BookKindAdapter;", "kindAdapter", "Lio/legado/app/ui/main/explore/BookStoreAdapter;", "h", "Lio/legado/app/ui/main/explore/BookStoreAdapter;", "adapter", "p", OptRuntime.GeneratorState.resumptionPoint_TYPE, "currentkind", "e", "getViewModel", "()Lio/legado/app/ui/main/explore/ExploreViewModel;", "viewModel", "n", "Z", "isLoading", "o", "currentBookSource", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookStoreFragment extends VMBaseFragment<ExploreViewModel> implements BookStoreAdapter.a, MenuItem.OnMenuItemClickListener, BookKindAdapter.a, ExploreShowAdapter.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e bookViewModel;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public BookStoreAdapter adapter;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public BookKindAdapter kindAdapter;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public ExploreShowAdapter exploreAdapter;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public LoadMoreView loadMoreView;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<String>> liveGroup;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final LinkedHashSet<String> groups;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public boolean isLoading;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int currentBookSource;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public int currentkind;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @Nullable
    public LiveData<List<BookSource>> liveExplore;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @Nullable
    public SubMenu groupsMenu;

    /* JADX INFO: compiled from: BookStoreFragment.kt */
    @DebugMetadata(c = "io.legado.app.ui.main.explore.BookStoreFragment$scrollTo$1", f = "BookStoreFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements p<a0, f.z.d<? super ArrayList<BookSource.ExploreKind>>, Object> {
        public final /* synthetic */ BookSource $myBookSource;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BookSource bookSource, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$myBookSource = bookSource;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$myBookSource, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super ArrayList<BookSource.ExploreKind>> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            return this.$myBookSource.getExploreKinds();
        }
    }

    /* JADX INFO: compiled from: BookStoreFragment.kt */
    @DebugMetadata(c = "io.legado.app.ui.main.explore.BookStoreFragment$scrollTo$2", f = "BookStoreFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends f.z.j.a.g implements q<a0, ArrayList<BookSource.ExploreKind>, f.z.d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public b(f.z.d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull ArrayList<BookSource.ExploreKind> arrayList, @Nullable f.z.d<? super v> dVar) {
            b bVar = BookStoreFragment.this.new b(dVar);
            bVar.L$0 = arrayList;
            return bVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            ArrayList<BookSource.ExploreKind> arrayList = (ArrayList) this.L$0;
            if (!(arrayList == null || arrayList.isEmpty())) {
                BookKindAdapter bookKindAdapter = BookStoreFragment.this.kindAdapter;
                if (bookKindAdapter == null) {
                    j.m("kindAdapter");
                    throw null;
                }
                j.e(arrayList, "kinds");
                ArrayList arrayList2 = new ArrayList();
                for (BookSource.ExploreKind exploreKind : arrayList) {
                    if ((exploreKind == null ? null : exploreKind.getUrl()) != null) {
                        String url = exploreKind.getUrl();
                        if (!(url == null || url.length() == 0)) {
                            arrayList2.add(exploreKind);
                        }
                    }
                }
                bookKindAdapter.x(arrayList2);
                BookKindAdapter bookKindAdapter2 = BookStoreFragment.this.kindAdapter;
                if (bookKindAdapter2 == null) {
                    j.m("kindAdapter");
                    throw null;
                }
                bookKindAdapter2.notifyDataSetChanged();
                BookStoreFragment.this.H(0);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class c extends k implements l<BookStoreFragment, FragmentBookStoreBinding> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final FragmentBookStoreBinding invoke(@NotNull BookStoreFragment bookStoreFragment) {
            j.e(bookStoreFragment, "fragment");
            View viewRequireView = bookStoreFragment.requireView();
            int i2 = R.id.bookList;
            RecyclerView recyclerView = (RecyclerView) viewRequireView.findViewById(R.id.bookList);
            if (recyclerView != null) {
                i2 = R.id.content_view;
                DynamicFrameLayout dynamicFrameLayout = (DynamicFrameLayout) viewRequireView.findViewById(R.id.content_view);
                if (dynamicFrameLayout != null) {
                    i2 = R.id.rv_kinds;
                    RecyclerViewAtPager2 recyclerViewAtPager2 = (RecyclerViewAtPager2) viewRequireView.findViewById(R.id.rv_kinds);
                    if (recyclerViewAtPager2 != null) {
                        i2 = R.id.rv_source;
                        RecyclerViewAtPager2 recyclerViewAtPager22 = (RecyclerViewAtPager2) viewRequireView.findViewById(R.id.rv_source);
                        if (recyclerViewAtPager22 != null) {
                            i2 = R.id.title_bar;
                            TitleBar titleBar = (TitleBar) viewRequireView.findViewById(R.id.title_bar);
                            if (titleBar != null) {
                                return new FragmentBookStoreBinding((LinearLayout) viewRequireView, recyclerView, dynamicFrameLayout, recyclerViewAtPager2, recyclerViewAtPager22, titleBar);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class d extends k implements f.c0.b.a<Fragment> {
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class e extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ f.c0.b.a $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(f.c0.b.a aVar) {
            super(0);
            this.$ownerProducer = aVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
            j.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class f extends k implements f.c0.b.a<Fragment> {
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class g extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ f.c0.b.a $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(f.c0.b.a aVar) {
            super(0);
            this.$ownerProducer = aVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
            j.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    static {
        h<Object>[] hVarArr = new h[3];
        f.c0.c.q qVar = new f.c0.c.q(f.c0.c.v.a(BookStoreFragment.class), "binding", "getBinding()Lio/legado/app/databinding/FragmentBookStoreBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        hVarArr[2] = qVar;
        f7429d = hVarArr;
    }

    public BookStoreFragment() {
        super(R.layout.fragment_book_store);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, f.c0.c.v.a(ExploreViewModel.class), new e(new d(this)), null);
        this.bookViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, f.c0.c.v.a(ExploreShowViewModel.class), new g(new f(this)), null);
        this.binding = c.b.a.m.f.b6(this, new c());
        this.groups = new LinkedHashSet<>();
        this.isLoading = true;
    }

    @Override // io.legado.app.ui.main.explore.BookKindAdapter.a
    public void H(int pos) {
        if (pos < 0) {
            return;
        }
        this.currentkind = pos;
        BookKindAdapter bookKindAdapter = this.kindAdapter;
        if (bookKindAdapter == null) {
            j.m("kindAdapter");
            throw null;
        }
        bookKindAdapter.currentPosition = pos;
        bookKindAdapter.notifyDataSetChanged();
        ExploreShowAdapter exploreShowAdapter = this.exploreAdapter;
        if (exploreShowAdapter == null) {
            j.m("exploreAdapter");
            throw null;
        }
        exploreShowAdapter.h();
        ExploreShowAdapter exploreShowAdapter2 = this.exploreAdapter;
        if (exploreShowAdapter2 == null) {
            j.m("exploreAdapter");
            throw null;
        }
        exploreShowAdapter2.notifyDataSetChanged();
        this.currentkind = pos;
        BookStoreAdapter bookStoreAdapter = this.adapter;
        if (bookStoreAdapter == null) {
            j.m("adapter");
            throw null;
        }
        List<ITEM> list = bookStoreAdapter.items;
        if (list == 0 || list.isEmpty()) {
            return;
        }
        BookSource bookSource = (BookSource) list.get(this.currentBookSource);
        BookKindAdapter bookKindAdapter2 = this.kindAdapter;
        if (bookKindAdapter2 == null) {
            j.m("kindAdapter");
            throw null;
        }
        List<ITEM> list2 = bookKindAdapter2.items;
        if (list2 == 0 || list2.isEmpty()) {
            return;
        }
        BookSource.ExploreKind exploreKind = (BookSource.ExploreKind) list2.get(pos);
        this.isLoading = true;
        LoadMoreView loadMoreView = this.loadMoreView;
        if (loadMoreView == null) {
            j.m("loadMoreView");
            throw null;
        }
        loadMoreView.d();
        ExploreShowViewModel exploreShowViewModelV = V();
        String bookSourceUrl = bookSource.getBookSourceUrl();
        String url = exploreKind.getUrl();
        Objects.requireNonNull(exploreShowViewModelV);
        BaseViewModel.a(exploreShowViewModelV, null, null, new e.a.a.g.d.e.g(exploreShowViewModelV, url, bookSourceUrl, null), 3, null);
    }

    @Override // io.legado.app.base.BaseFragment
    public void P(@NotNull Menu menu) {
        SwitchConfig switchConfig;
        boolean zBooleanValue;
        Object objM11constructorimpl;
        j.e(menu, "menu");
        j.e(menu, "menu");
        Context context = getContext();
        if (context == null) {
            zBooleanValue = false;
        } else {
            j.e(context, com.umeng.analytics.pro.c.R);
            try {
                String strO2 = c.b.a.m.f.O2(context, "switchConfig", null, 2);
                if (strO2 == null) {
                    switchConfig = new SwitchConfig();
                } else {
                    Gson gsonA = n.a();
                    try {
                        Type type = new e.a.a.d.w.e().getType();
                        j.d(type, "object : TypeToken<T>() {}.type");
                        Object objFromJson = gsonA.fromJson(strO2, type);
                        if (!(objFromJson instanceof SwitchConfig)) {
                            objFromJson = null;
                        }
                        objM11constructorimpl = f.h.m11constructorimpl((SwitchConfig) objFromJson);
                    } catch (Throwable th) {
                        objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
                    }
                    if (f.h.m16isFailureimpl(objM11constructorimpl)) {
                        objM11constructorimpl = null;
                    }
                    switchConfig = (SwitchConfig) objM11constructorimpl;
                    if (switchConfig == null) {
                        switchConfig = new SwitchConfig();
                    }
                }
            } catch (Exception unused) {
                switchConfig = new SwitchConfig();
            }
            zBooleanValue = Boolean.valueOf(switchConfig.getSourceGroup()).booleanValue();
        }
        if (zBooleanValue) {
            N().inflate(R.menu.main_explore, menu);
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_group);
            this.groupsMenu = menuItemFindItem != null ? menuItemFindItem.getSubMenu() : null;
            Y();
            menu.findItem(R.id.menu_search).setOnMenuItemClickListener(this);
        }
    }

    @Override // io.legado.app.base.BaseFragment
    public void Q(@NotNull MenuItem item) {
        j.e(item, "item");
        j.e(item, "item");
        if (item.getGroupId() == R.id.menu_group_text) {
            if (item.getTitle().equals("全部")) {
                W(null);
            } else {
                W(j.k("group:", item.getTitle()));
            }
        }
    }

    @Override // io.legado.app.base.BaseFragment
    public void R(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        T(U().f6705e.getToolbar());
        ATH ath = ATH.a;
        ath.b(U().f6704d);
        ath.b(U().f6703c);
        ath.b(U().f6702b);
        U().f6704d.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        this.adapter = new BookStoreAdapter(contextRequireContext, this, this);
        RecyclerViewAtPager2 recyclerViewAtPager2 = U().f6704d;
        BookStoreAdapter bookStoreAdapter = this.adapter;
        if (bookStoreAdapter == null) {
            j.m("adapter");
            throw null;
        }
        recyclerViewAtPager2.setAdapter(bookStoreAdapter);
        Context context = getContext();
        if (context != null) {
            U().f6704d.addItemDecoration(new VerticalDivider(context));
        }
        BookStoreAdapter bookStoreAdapter2 = this.adapter;
        if (bookStoreAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        bookStoreAdapter2.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: io.legado.app.ui.main.explore.BookStoreFragment$initRecyclerView$2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                if (positionStart == 0) {
                    BookStoreFragment bookStoreFragment = this.a;
                    h<Object>[] hVarArr = BookStoreFragment.f7429d;
                    bookStoreFragment.U().f6704d.scrollToPosition(0);
                }
            }
        });
        ath.b(U().f6703c);
        U().f6703c.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        this.kindAdapter = new BookKindAdapter(contextRequireContext2, this, this);
        RecyclerViewAtPager2 recyclerViewAtPager22 = U().f6703c;
        BookKindAdapter bookKindAdapter = this.kindAdapter;
        if (bookKindAdapter == null) {
            j.m("kindAdapter");
            throw null;
        }
        recyclerViewAtPager22.setAdapter(bookKindAdapter);
        BookKindAdapter bookKindAdapter2 = this.kindAdapter;
        if (bookKindAdapter2 == null) {
            j.m("kindAdapter");
            throw null;
        }
        bookKindAdapter2.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: io.legado.app.ui.main.explore.BookStoreFragment$initRecyclerView$3
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                if (positionStart == 0) {
                    BookStoreFragment bookStoreFragment = this.a;
                    h<Object>[] hVarArr = BookStoreFragment.f7429d;
                    bookStoreFragment.U().f6704d.scrollToPosition(0);
                }
            }
        });
        U().f6702b.setLayoutManager(new LinearLayoutManager(getContext()));
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        this.exploreAdapter = new ExploreShowAdapter(contextRequireContext3, this);
        RecyclerView recyclerView = U().f6702b;
        ExploreShowAdapter exploreShowAdapter = this.exploreAdapter;
        if (exploreShowAdapter == null) {
            j.m("exploreAdapter");
            throw null;
        }
        recyclerView.setAdapter(exploreShowAdapter);
        Context contextRequireContext4 = requireContext();
        j.d(contextRequireContext4, "requireContext()");
        this.loadMoreView = new LoadMoreView(contextRequireContext4, null);
        ExploreShowAdapter exploreShowAdapter2 = this.exploreAdapter;
        if (exploreShowAdapter2 == null) {
            j.m("exploreAdapter");
            throw null;
        }
        exploreShowAdapter2.d(new o(this));
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
        loadMoreView2.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.h.h.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BookStoreFragment bookStoreFragment = this.a;
                f.f0.h<Object>[] hVarArr = BookStoreFragment.f7429d;
                f.c0.c.j.e(bookStoreFragment, "this$0");
                if (bookStoreFragment.isLoading) {
                    return;
                }
                LoadMoreView loadMoreView3 = bookStoreFragment.loadMoreView;
                if (loadMoreView3 == null) {
                    f.c0.c.j.m("loadMoreView");
                    throw null;
                }
                loadMoreView3.b();
                bookStoreFragment.X();
                bookStoreFragment.isLoading = true;
            }
        });
        U().f6702b.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: io.legado.app.ui.main.explore.BookStoreFragment$initRecyclerView$6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int dx, int dy) {
                j.e(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, dx, dy);
                if (recyclerView2.canScrollVertically(1)) {
                    return;
                }
                BookStoreFragment bookStoreFragment = this.a;
                h<Object>[] hVarArr = BookStoreFragment.f7429d;
                bookStoreFragment.X();
            }
        });
        V().booksData.observe(this, new Observer() { // from class: e.a.a.g.h.h.f
            /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
            @Override // androidx.view.Observer
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void onChanged(java.lang.Object r7) {
                /*
                    r6 = this;
                    io.legado.app.ui.main.explore.BookStoreFragment r0 = r6.a
                    java.util.List r7 = (java.util.List) r7
                    f.f0.h<java.lang.Object>[] r1 = io.legado.app.ui.main.explore.BookStoreFragment.f7429d
                    java.lang.String r1 = "this$0"
                    f.c0.c.j.e(r0, r1)
                    java.lang.String r1 = "it"
                    f.c0.c.j.d(r7, r1)
                    r1 = 0
                    r0.isLoading = r1
                    boolean r1 = r7.isEmpty()
                    java.lang.String r2 = "loadMoreView"
                    java.lang.String r3 = "exploreAdapter"
                    r4 = 0
                    if (r1 == 0) goto L41
                    io.legado.app.ui.book.explore.ExploreShowAdapter r1 = r0.exploreAdapter
                    if (r1 == 0) goto L3d
                    java.util.List<ITEM> r1 = r1.items
                    boolean r1 = r1.isEmpty()
                    if (r1 == 0) goto L41
                    io.legado.app.ui.widget.recycler.LoadMoreView r7 = r0.loadMoreView
                    if (r7 == 0) goto L39
                    r1 = 2131820837(0x7f110125, float:1.92744E38)
                    java.lang.String r1 = r0.getString(r1)
                    r7.c(r1)
                    goto L95
                L39:
                    f.c0.c.j.m(r2)
                    throw r4
                L3d:
                    f.c0.c.j.m(r3)
                    throw r4
                L41:
                    boolean r1 = r7.isEmpty()
                    if (r1 == 0) goto L55
                    io.legado.app.ui.widget.recycler.LoadMoreView r7 = r0.loadMoreView
                    if (r7 == 0) goto L51
                    int r1 = io.legado.app.ui.widget.recycler.LoadMoreView.a
                    r7.c(r4)
                    goto L95
                L51:
                    f.c0.c.j.m(r2)
                    throw r4
                L55:
                    io.legado.app.ui.book.explore.ExploreShowAdapter r1 = r0.exploreAdapter
                    if (r1 == 0) goto La9
                    java.util.List<ITEM> r1 = r1.items
                    java.lang.Object r5 = f.x.e.k(r7)
                    boolean r1 = r1.contains(r5)
                    if (r1 == 0) goto L87
                    io.legado.app.ui.book.explore.ExploreShowAdapter r1 = r0.exploreAdapter
                    if (r1 == 0) goto L83
                    java.util.List<ITEM> r1 = r1.items
                    java.lang.Object r5 = f.x.e.r(r7)
                    boolean r1 = r1.contains(r5)
                    if (r1 == 0) goto L87
                    io.legado.app.ui.widget.recycler.LoadMoreView r7 = r0.loadMoreView
                    if (r7 == 0) goto L7f
                    int r1 = io.legado.app.ui.widget.recycler.LoadMoreView.a
                    r7.c(r4)
                    goto L95
                L7f:
                    f.c0.c.j.m(r2)
                    throw r4
                L83:
                    f.c0.c.j.m(r3)
                    throw r4
                L87:
                    io.legado.app.ui.book.explore.ExploreShowAdapter r1 = r0.exploreAdapter
                    if (r1 == 0) goto La5
                    r1.g(r7)
                    io.legado.app.ui.widget.recycler.LoadMoreView r7 = r0.loadMoreView
                    if (r7 == 0) goto La1
                    r7.b()
                L95:
                    io.legado.app.ui.book.explore.ExploreShowAdapter r7 = r0.exploreAdapter
                    if (r7 == 0) goto L9d
                    r7.notifyDataSetChanged()
                    return
                L9d:
                    f.c0.c.j.m(r3)
                    throw r4
                La1:
                    f.c0.c.j.m(r2)
                    throw r4
                La5:
                    f.c0.c.j.m(r3)
                    throw r4
                La9:
                    f.c0.c.j.m(r3)
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: e.a.a.g.h.h.f.onChanged(java.lang.Object):void");
            }
        });
        V().errorLiveData.observe(this, new Observer() { // from class: e.a.a.g.h.h.d
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                final BookStoreFragment bookStoreFragment = this.a;
                f.f0.h<Object>[] hVarArr = BookStoreFragment.f7429d;
                f.c0.c.j.e(bookStoreFragment, "this$0");
                LoadMoreView loadMoreView3 = bookStoreFragment.loadMoreView;
                if (loadMoreView3 != null) {
                    loadMoreView3.a("网络连接异常,请点击重新加载", new View.OnClickListener() { // from class: e.a.a.g.h.h.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            BookStoreFragment bookStoreFragment2 = bookStoreFragment;
                            f.f0.h<Object>[] hVarArr2 = BookStoreFragment.f7429d;
                            f.c0.c.j.e(bookStoreFragment2, "this$0");
                            BookKindAdapter bookKindAdapter3 = bookStoreFragment2.kindAdapter;
                            if (bookKindAdapter3 == null) {
                                f.c0.c.j.m("kindAdapter");
                                throw null;
                            }
                            BookSource.ExploreKind exploreKind = (BookSource.ExploreKind) bookKindAdapter3.items.get(bookStoreFragment2.currentkind);
                            BookStoreAdapter bookStoreAdapter3 = bookStoreFragment2.adapter;
                            if (bookStoreAdapter3 == null) {
                                f.c0.c.j.m("adapter");
                                throw null;
                            }
                            BookSource bookSource = (BookSource) bookStoreAdapter3.items.get(bookStoreFragment2.currentBookSource);
                            bookStoreFragment2.isLoading = true;
                            ExploreShowViewModel exploreShowViewModelV = bookStoreFragment2.V();
                            String bookSourceUrl = bookSource.getBookSourceUrl();
                            String url = exploreKind.getUrl();
                            Objects.requireNonNull(exploreShowViewModelV);
                            BaseViewModel.a(exploreShowViewModelV, null, null, new e.a.a.g.d.e.g(exploreShowViewModelV, url, bookSourceUrl, null), 3, null);
                            LoadMoreView loadMoreView4 = bookStoreFragment2.loadMoreView;
                            if (loadMoreView4 != null) {
                                loadMoreView4.d();
                            } else {
                                f.c0.c.j.m("loadMoreView");
                                throw null;
                            }
                        }
                    });
                } else {
                    f.c0.c.j.m("loadMoreView");
                    throw null;
                }
            }
        });
        LiveData<List<String>> liveData = this.liveGroup;
        if (liveData != null) {
            liveData.removeObservers(getViewLifecycleOwner());
        }
        LiveData<List<String>> liveDataLiveExploreGroup = AppDatabaseKt.getAppDb().getBookSourceDao().liveExploreGroup();
        this.liveGroup = liveDataLiveExploreGroup;
        if (liveDataLiveExploreGroup != null) {
            liveDataLiveExploreGroup.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.h.h.e
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    BookStoreFragment bookStoreFragment = this.a;
                    List<String> list = (List) obj;
                    f.f0.h<Object>[] hVarArr = BookStoreFragment.f7429d;
                    f.c0.c.j.e(bookStoreFragment, "this$0");
                    bookStoreFragment.groups.clear();
                    f.c0.c.j.d(list, "it");
                    ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(list, 10));
                    for (String str : list) {
                        LinkedHashSet<String> linkedHashSet = bookStoreFragment.groups;
                        e.a.a.c.d dVar = e.a.a.c.d.a;
                        arrayList.add(Boolean.valueOf(c.b.a.m.f.T(linkedHashSet, c.b.a.m.f.o5(str, e.a.a.c.d.f5514h, 0, 2))));
                    }
                    bookStoreFragment.Y();
                }
            });
        }
        W(null);
    }

    public final FragmentBookStoreBinding U() {
        return (FragmentBookStoreBinding) this.binding.b(this, f7429d[2]);
    }

    @NotNull
    public final ExploreShowViewModel V() {
        return (ExploreShowViewModel) this.bookViewModel.getValue();
    }

    public final void W(String searchKey) {
        LiveData<List<BookSource>> liveDataLiveExplore;
        LiveData<List<BookSource>> liveData = this.liveExplore;
        if (liveData != null) {
            liveData.removeObservers(getViewLifecycleOwner());
        }
        if (searchKey == null || f.h0.k.s(searchKey)) {
            liveDataLiveExplore = AppDatabaseKt.getAppDb().getBookSourceDao().liveExplore();
        } else if (f.h0.k.K(searchKey, "group:", false, 2)) {
            String strM = f.h0.k.M(searchKey, "group:", null, 2);
            liveDataLiveExplore = AppDatabaseKt.getAppDb().getBookSourceDao().liveGroupExplore('%' + strM + '%');
        } else {
            BookSourceDao bookSourceDao = AppDatabaseKt.getAppDb().getBookSourceDao();
            StringBuilder sb = new StringBuilder();
            sb.append('%');
            sb.append((Object) searchKey);
            sb.append('%');
            liveDataLiveExplore = bookSourceDao.liveExplore(sb.toString());
        }
        this.liveExplore = liveDataLiveExplore;
        if (liveDataLiveExplore == null) {
            return;
        }
        liveDataLiveExplore.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.h.h.i
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookStoreFragment bookStoreFragment = this.a;
                List list = (List) obj;
                f.f0.h<Object>[] hVarArr = BookStoreFragment.f7429d;
                f.c0.c.j.e(bookStoreFragment, "this$0");
                BookStoreAdapter bookStoreAdapter = bookStoreFragment.adapter;
                if (bookStoreAdapter == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                ArrayList arrayList = new ArrayList(bookStoreAdapter.items);
                f.c0.c.j.d(list, "it");
                DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new ExploreDiffCallBack(arrayList, list));
                f.c0.c.j.d(diffResultCalculateDiff, "calculateDiff(ExploreDiffCallBack(ArrayList(adapter.getItems()), it))");
                BookStoreAdapter bookStoreAdapter2 = bookStoreFragment.adapter;
                if (bookStoreAdapter2 == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                bookStoreAdapter2.x(list);
                BookStoreAdapter bookStoreAdapter3 = bookStoreFragment.adapter;
                if (bookStoreAdapter3 == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                bookStoreAdapter3.notifyDataSetChanged();
                BookStoreAdapter bookStoreAdapter4 = bookStoreFragment.adapter;
                if (bookStoreAdapter4 == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                diffResultCalculateDiff.dispatchUpdatesTo(bookStoreAdapter4);
                if (!list.isEmpty()) {
                    bookStoreFragment.a(0);
                }
            }
        });
    }

    public final void X() {
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
        V().e();
    }

    public final v Y() {
        SubMenu subMenu = this.groupsMenu;
        if (subMenu == null) {
            return null;
        }
        subMenu.removeGroup(R.id.menu_group_text);
        subMenu.add(R.id.menu_group_text, 0, 0, "全部");
        Iterator it = f.x.e.B(this.groups, e.a.a.g.h.h.h.a).iterator();
        while (it.hasNext()) {
            subMenu.add(R.id.menu_group_text, 0, 0, (String) it.next());
        }
        return v.a;
    }

    @Override // io.legado.app.ui.main.explore.BookStoreAdapter.a
    public void a(int pos) {
        if (pos < 0) {
            return;
        }
        this.currentBookSource = pos;
        BookStoreAdapter bookStoreAdapter = this.adapter;
        if (bookStoreAdapter == null) {
            j.m("adapter");
            throw null;
        }
        bookStoreAdapter.currentPosition = pos;
        bookStoreAdapter.notifyDataSetChanged();
        BookStoreAdapter bookStoreAdapter2 = this.adapter;
        if (bookStoreAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        List<ITEM> list = bookStoreAdapter2.items;
        if (list == 0 || list.isEmpty()) {
            return;
        }
        b.C0148b.b(e.a.a.d.u.b.a, this, null, new a((BookSource) list.get(pos), null), 2).d(null, new b(null));
        RecyclerView.LayoutManager layoutManager = U().f6703c.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(0, 0);
    }

    @Override // io.legado.app.ui.book.explore.ExploreShowAdapter.a
    public void k(@NotNull Book book) {
        j.e(book, "book");
        Intent intent = new Intent(requireContext(), (Class<?>) BookInfoActivity.class);
        intent.putExtra("name", book.getName());
        intent.putExtra("author", book.getAuthor());
        startActivity(intent);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf == null || numValueOf.intValue() != R.id.menu_search) {
            return true;
        }
        startActivity(new Intent(requireContext(), (Class<?>) SearchActivity.class));
        return true;
    }

    @Override // io.legado.app.base.VMBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }
}
