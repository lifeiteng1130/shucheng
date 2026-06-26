package io.legado.app.ui.book.info;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.databinding.ActivityBookEndBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.audio.AudioPlayActivity;
import io.legado.app.ui.book.changesource.ChangeSourceDialog;
import io.legado.app.ui.book.info.BookEndActivity;
import io.legado.app.ui.book.info.BookEndAdapter;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.book.search.BookAdapter;
import io.legado.app.ui.book.search.SearchViewModel;
import io.legado.app.ui.main.MainActivity;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.anima.RefreshProgressBar;
import io.legado.app.ui.widget.dynamiclayout.DynamicFrameLayout;
import io.legado.app.ui.widget.recycler.LoadMoreView;
import io.legado.app.ui.widget.text.AccentBgTextView;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookEndActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\bN\u0010\u001cJ\u001b\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020\"H\u0016¢\u0006\u0004\b'\u0010%R$\u0010-\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010%R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001d\u0010:\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010<R$\u0010B\u001a\u0010\u0012\f\u0012\n ?*\u0004\u0018\u00010\u00070\u00070>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001d\u0010G\u001a\u00020C8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u00107\u001a\u0004\bE\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\"8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010+R&\u0010M\u001a\u0012\u0012\u0004\u0012\u00020\u001d0Jj\b\u0012\u0004\u0012\u00020\u001d`K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010L¨\u0006O"}, d2 = {"Lio/legado/app/ui/book/info/BookEndActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityBookEndBinding;", "Lio/legado/app/ui/book/search/SearchViewModel;", "Lio/legado/app/ui/book/search/BookAdapter$a;", "Lio/legado/app/ui/book/changesource/ChangeSourceDialog$a;", "Lio/legado/app/ui/book/info/BookEndAdapter$a;", "Landroid/content/Intent;", "intent", "Lf/v;", "W0", "(Landroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "data", "onNewIntent", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "finish", "()V", "", "name", "author", Constants.LANDSCAPE, "(Ljava/lang/String;Ljava/lang/String;)V", "Lio/legado/app/data/entities/Book;", "book", "k", "(Lio/legado/app/data/entities/Book;)V", "newBook", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "m", "Lio/legado/app/data/entities/Book;", "getOldbook", "()Lio/legado/app/data/entities/Book;", "setOldbook", "oldbook", "Lio/legado/app/ui/book/info/BookEndAdapter;", "j", "Lio/legado/app/ui/book/info/BookEndAdapter;", "T0", "()Lio/legado/app/ui/book/info/BookEndAdapter;", "setAdapter", "(Lio/legado/app/ui/book/info/BookEndAdapter;)V", "adapter", "h", "Lf/e;", "V0", "()Lio/legado/app/ui/book/search/SearchViewModel;", "viewModel", "Lio/legado/app/ui/widget/recycler/LoadMoreView;", "Lio/legado/app/ui/widget/recycler/LoadMoreView;", "loadMoreView", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "n", "Landroidx/activity/result/ActivityResultLauncher;", "readBookResult", "Lio/legado/app/ui/book/info/BookInfoViewModel;", ai.aA, "U0", "()Lio/legado/app/ui/book/info/BookInfoViewModel;", "infoModel", "c0", "oldBook", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "Ljava/util/LinkedHashSet;", "groups", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookEndActivity extends VMBaseActivity<ActivityBookEndBinding, SearchViewModel> implements BookAdapter.a, ChangeSourceDialog.a, BookEndAdapter.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7105g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e infoModel;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public BookEndAdapter adapter;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public LoadMoreView loadMoreView;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public LinkedHashSet<String> groups;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public Book oldbook;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Intent> readBookResult;

    /* JADX INFO: compiled from: BookEndActivity.kt */
    public static final class a extends k implements l<SearchBook, v> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(SearchBook searchBook) {
            invoke2(searchBook);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable SearchBook searchBook) {
            if (searchBook == null) {
                return;
            }
            BookEndActivity bookEndActivity = BookEndActivity.this;
            Intent intent = new Intent(bookEndActivity, (Class<?>) BookInfoActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("name", searchBook.getName());
            intent.putExtra("author", searchBook.getAuthor());
            bookEndActivity.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class b extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
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
    public static final class c extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
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

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class d extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
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
    public static final class e extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
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

    public BookEndActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(SearchViewModel.class), new c(this), new b(this));
        this.infoModel = new ViewModelLazy(f.c0.c.v.a(BookInfoViewModel.class), new e(this), new d(this));
        this.groups = new LinkedHashSet<>();
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.a.a.g.d.g.d
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BookEndActivity bookEndActivity = this.a;
                int i2 = BookEndActivity.f7105g;
                f.c0.c.j.e(bookEndActivity, "this$0");
                if (((ActivityResult) obj).getResultCode() == -1) {
                    bookEndActivity.U0().inBookshelf = true;
                }
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(\n        ActivityResultContracts.StartActivityForResult()\n    ) {\n        if (it.resultCode == RESULT_OK) {\n            infoModel.inBookshelf = true\n        }\n    }");
        this.readBookResult = activityResultLauncherRegisterForActivityResult;
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_book_end, (ViewGroup) null, false);
        int i2 = R.id.bookStore;
        AccentBgTextView accentBgTextView = (AccentBgTextView) viewInflate.findViewById(R.id.bookStore);
        if (accentBgTextView != null) {
            i2 = R.id.changeSource;
            TextView textView = (TextView) viewInflate.findViewById(R.id.changeSource);
            if (textView != null) {
                i2 = R.id.content_view;
                DynamicFrameLayout dynamicFrameLayout = (DynamicFrameLayout) viewInflate.findViewById(R.id.content_view);
                if (dynamicFrameLayout != null) {
                    i2 = R.id.fb_stop;
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewInflate.findViewById(R.id.fb_stop);
                    if (floatingActionButton != null) {
                        i2 = R.id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
                        if (recyclerView != null) {
                            i2 = R.id.refresh_progress_bar;
                            RefreshProgressBar refreshProgressBar = (RefreshProgressBar) viewInflate.findViewById(R.id.refresh_progress_bar);
                            if (refreshProgressBar != null) {
                                i2 = R.id.title_bar;
                                TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                                if (titleBar != null) {
                                    ActivityBookEndBinding activityBookEndBinding = new ActivityBookEndBinding((LinearLayout) viewInflate, accentBgTextView, textView, dynamicFrameLayout, floatingActionButton, recyclerView, refreshProgressBar, titleBar);
                                    j.d(activityBookEndBinding, "inflate(layoutInflater)");
                                    return activityBookEndBinding;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags &= -1025;
        getWindow().setAttributes(attributes);
        getWindow().clearFlags(512);
        ATH.a.b(((ActivityBookEndBinding) K0()).f6462e);
        BookEndAdapter bookEndAdapter = new BookEndAdapter(this, this);
        j.e(bookEndAdapter, "<set-?>");
        this.adapter = bookEndAdapter;
        ((ActivityBookEndBinding) K0()).f6462e.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
        ((ActivityBookEndBinding) K0()).f6462e.setAdapter(T0());
        T0().registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: io.legado.app.ui.book.info.BookEndActivity$initRecyclerView$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                if (positionStart == 0) {
                    BookEndActivity bookEndActivity = this.a;
                    int i2 = BookEndActivity.f7105g;
                    ((ActivityBookEndBinding) bookEndActivity.K0()).f6462e.scrollToPosition(0);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                super.onItemRangeMoved(fromPosition, toPosition, itemCount);
                if (toPosition == 0) {
                    BookEndActivity bookEndActivity = this.a;
                    int i2 = BookEndActivity.f7105g;
                    ((ActivityBookEndBinding) bookEndActivity.K0()).f6462e.scrollToPosition(0);
                }
            }
        });
        this.loadMoreView = new LoadMoreView(this, null);
        ((ActivityBookEndBinding) K0()).f6462e.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: io.legado.app.ui.book.info.BookEndActivity$initRecyclerView$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                j.e(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.canScrollVertically(1)) {
                    return;
                }
                BookEndActivity bookEndActivity = this.a;
                int i2 = BookEndActivity.f7105g;
                if (bookEndActivity.V0().isLoading) {
                    return;
                }
                if (bookEndActivity.V0().searchKey.length() > 0) {
                    LoadMoreView loadMoreView = bookEndActivity.loadMoreView;
                    if (loadMoreView == null) {
                        j.m("loadMoreView");
                        throw null;
                    }
                    if (loadMoreView.getHasMore()) {
                        bookEndActivity.V0().f("");
                    }
                }
            }
        });
        FloatingActionButton floatingActionButton = ((ActivityBookEndBinding) K0()).f6461d;
        e.a.a.e.d.a aVar = new e.a.a.e.d.a();
        aVar.b(f.M1(this));
        int iM1 = f.M1(this);
        int iAlpha = Color.alpha(iM1);
        float[] fArr = new float[3];
        Color.colorToHSV(iM1, fArr);
        fArr[2] = fArr[2] * 0.9f;
        aVar.d((iAlpha << 24) + (Color.HSVToColor(fArr) & ViewCompat.MEASURED_SIZE_MASK));
        floatingActionButton.setBackgroundTintList(aVar.a());
        ((ActivityBookEndBinding) K0()).f6461d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.g
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookEndActivity bookEndActivity = this.a;
                int i2 = BookEndActivity.f7105g;
                f.c0.c.j.e(bookEndActivity, "this$0");
                bookEndActivity.V0().searchBookModel.cancelSearch();
                ((ActivityBookEndBinding) bookEndActivity.K0()).f6463f.setAutoLoading(false);
            }
        });
        AppDatabaseKt.getAppDb().getBookSourceDao().liveGroupEnabled().observe(this, new Observer() { // from class: e.a.a.g.d.g.b
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookEndActivity bookEndActivity = this.a;
                List<String> list = (List) obj;
                int i2 = BookEndActivity.f7105g;
                f.c0.c.j.e(bookEndActivity, "this$0");
                bookEndActivity.groups.clear();
                f.c0.c.j.d(list, "it");
                ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(list, 10));
                for (String str : list) {
                    LinkedHashSet<String> linkedHashSet = bookEndActivity.groups;
                    e.a.a.c.d dVar = e.a.a.c.d.a;
                    arrayList.add(Boolean.valueOf(c.b.a.m.f.T(linkedHashSet, c.b.a.m.f.o5(str, e.a.a.c.d.f5514h, 0, 2))));
                }
            }
        });
        V0().searchBookLiveData.observe(this, new Observer() { // from class: e.a.a.g.d.g.a
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookEndActivity bookEndActivity = this.a;
                List list = (List) obj;
                int i2 = BookEndActivity.f7105g;
                f.c0.c.j.e(bookEndActivity, "this$0");
                if (list == null || list.isEmpty()) {
                    return;
                }
                bookEndActivity.T0().n(list);
                bookEndActivity.T0().notifyDataSetChanged();
            }
        });
        V0().isSearchLiveData.observe(this, new Observer() { // from class: e.a.a.g.d.g.c
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookEndActivity bookEndActivity = this.a;
                Boolean bool = (Boolean) obj;
                int i2 = BookEndActivity.f7105g;
                f.c0.c.j.e(bookEndActivity, "this$0");
                f.c0.c.j.d(bool, "it");
                if (bool.booleanValue()) {
                    ((ActivityBookEndBinding) bookEndActivity.K0()).f6463f.setAutoLoading(true);
                    FloatingActionButton floatingActionButton2 = ((ActivityBookEndBinding) bookEndActivity.K0()).f6461d;
                    f.c0.c.j.d(floatingActionButton2, "binding.fbStop");
                    c.b.a.m.f.c6(floatingActionButton2);
                    return;
                }
                ((ActivityBookEndBinding) bookEndActivity.K0()).f6463f.setAutoLoading(false);
                LoadMoreView loadMoreView = bookEndActivity.loadMoreView;
                if (loadMoreView == null) {
                    f.c0.c.j.m("loadMoreView");
                    throw null;
                }
                loadMoreView.d();
                FloatingActionButton floatingActionButton3 = ((ActivityBookEndBinding) bookEndActivity.K0()).f6461d;
                f.c0.c.j.d(floatingActionButton3, "binding.fbStop");
                c.b.a.m.f.l3(floatingActionButton3);
            }
        });
        W0(getIntent());
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        return super.Q0(item);
    }

    @NotNull
    public final BookEndAdapter T0() {
        BookEndAdapter bookEndAdapter = this.adapter;
        if (bookEndAdapter != null) {
            return bookEndAdapter;
        }
        j.m("adapter");
        throw null;
    }

    @NotNull
    public final BookInfoViewModel U0() {
        return (BookInfoViewModel) this.infoModel.getValue();
    }

    @Override // io.legado.app.ui.book.changesource.ChangeSourceDialog.a
    public void V(@NotNull Book newBook) {
        j.e(newBook, "newBook");
        if (newBook.getType() == 1) {
            this.readBookResult.launch(new Intent(this, (Class<?>) AudioPlayActivity.class).putExtra("bookUrl", newBook.getBookUrl()).putExtra("inBookshelf", U0().inBookshelf).putExtra("newBook", new Gson().toJson(newBook)));
        } else {
            this.readBookResult.launch(new Intent(this, (Class<?>) ReadBookActivity.class).putExtra("bookUrl", newBook.getBookUrl()).putExtra("inBookshelf", U0().inBookshelf).putExtra("newBook", new Gson().toJson(newBook)));
        }
        finish();
    }

    @NotNull
    public SearchViewModel V0() {
        return (SearchViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W0(Intent intent) {
        String stringExtra;
        SearchBook firstByNameAuthor;
        v vVar = null;
        final String stringExtra2 = intent == null ? null : intent.getStringExtra("name");
        final String stringExtra3 = intent == null ? null : intent.getStringExtra("author");
        if (TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3)) {
            finish();
            return;
        }
        BookDao bookDao = AppDatabaseKt.getAppDb().getBookDao();
        j.c(stringExtra2);
        j.c(stringExtra3);
        Book book = bookDao.getBook(stringExtra2, stringExtra3);
        if (book != null) {
            this.oldbook = book;
            vVar = v.a;
        }
        if (vVar == null && (firstByNameAuthor = AppDatabaseKt.getAppDb().getSearchBookDao().getFirstByNameAuthor(stringExtra2, stringExtra3)) != null) {
            firstByNameAuthor.toBook();
        }
        if (intent != null && (stringExtra = intent.getStringExtra("key")) != null) {
            V0().f(stringExtra);
        }
        ((ActivityBookEndBinding) K0()).f6460c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str = stringExtra2;
                String str2 = stringExtra3;
                BookEndActivity bookEndActivity = this;
                int i2 = BookEndActivity.f7105g;
                f.c0.c.j.e(bookEndActivity, "this$0");
                if (str == null || str2 == null) {
                    return;
                }
                ChangeSourceDialog.Companion companion = ChangeSourceDialog.INSTANCE;
                FragmentManager supportFragmentManager = bookEndActivity.getSupportFragmentManager();
                f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
                companion.a(supportFragmentManager, str, str2);
            }
        });
        ((ActivityBookEndBinding) K0()).f6459b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookEndActivity bookEndActivity = this.a;
                int i2 = BookEndActivity.f7105g;
                f.c0.c.j.e(bookEndActivity, "this$0");
                Intent intent2 = new Intent(bookEndActivity, (Class<?>) MainActivity.class);
                intent2.addFlags(268435456);
                intent2.putExtra("action", 1);
                bookEndActivity.startActivity(intent2);
            }
        });
    }

    @Override // io.legado.app.ui.book.changesource.ChangeSourceDialog.a
    @Nullable
    /* JADX INFO: renamed from: c0, reason: from getter */
    public Book getOldbook() {
        return this.oldbook;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity, android.app.Activity
    public void finish() {
        V0().searchBookModel.cancelSearch();
        ((ActivityBookEndBinding) K0()).f6463f.setAutoLoading(false);
        overridePendingTransition(R.anim.anim_readbook_right_in, R.anim.anim_readbook_right_out);
        super.finish();
    }

    @Override // io.legado.app.ui.book.search.BookAdapter.a
    public void k(@NotNull Book book) {
        j.e(book, "book");
        Intent intent = new Intent(this, (Class<?>) BookInfoActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("name", book.getName());
        intent.putExtra("author", book.getAuthor());
        startActivity(intent);
    }

    @Override // io.legado.app.ui.book.info.BookEndAdapter.a
    public void l(@NotNull String name, @NotNull String author) {
        j.e(name, "name");
        j.e(author, "author");
        V0().e(name, author, new a());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent data) {
        super.onNewIntent(data);
        W0(data);
    }
}
