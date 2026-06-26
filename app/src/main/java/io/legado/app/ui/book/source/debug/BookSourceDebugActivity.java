package io.legado.app.ui.book.source.debug;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.d.q;
import e.a.a.d.u.b;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.databinding.ActivitySourceDebugBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.book.source.debug.BookSourceDebugActivity;
import io.legado.app.ui.qrcode.QrCodeResult;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.wenyuange.app.release.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceDebugActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b)\u0010*J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\u00060\u00060 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lio/legado/app/ui/book/source/debug/BookSourceDebugActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivitySourceDebugBinding;", "Lio/legado/app/ui/book/source/debug/BookSourceDebugModel;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "onPostCreate", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "", "key", "U0", "(Ljava/lang/String;)V", "Lio/legado/app/ui/book/source/debug/BookSourceDebugAdapter;", ai.aA, "Lio/legado/app/ui/book/source/debug/BookSourceDebugAdapter;", "adapter", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/book/source/debug/BookSourceDebugModel;", "viewModel", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "k", "Landroidx/activity/result/ActivityResultLauncher;", "qrCodeResult", "Landroidx/appcompat/widget/SearchView;", "j", "Landroidx/appcompat/widget/SearchView;", "searchView", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookSourceDebugActivity extends VMBaseActivity<ActivitySourceDebugBinding, BookSourceDebugModel> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7287g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public BookSourceDebugAdapter adapter;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public SearchView searchView;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<v> qrCodeResult;

    /* JADX INFO: compiled from: BookSourceDebugActivity.kt */
    public static final class a extends k implements p<Integer, String, v> {

        /* JADX INFO: renamed from: io.legado.app.ui.book.source.debug.BookSourceDebugActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BookSourceDebugActivity.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.source.debug.BookSourceDebugActivity$onActivityCreated$1$1", f = "BookSourceDebugActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0205a extends g implements p<a0, f.z.d<? super v>, Object> {
            public final /* synthetic */ String $msg;
            public final /* synthetic */ int $state;
            public int label;
            public final /* synthetic */ BookSourceDebugActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0205a(BookSourceDebugActivity bookSourceDebugActivity, String str, int i2, f.z.d<? super C0205a> dVar) {
                super(2, dVar);
                this.this$0 = bookSourceDebugActivity;
                this.$msg = str;
                this.$state = i2;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return new C0205a(this.this$0, this.$msg, this.$state, dVar);
            }

            @Override // f.c0.b.p
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
                return ((C0205a) create(a0Var, dVar)).invokeSuspend(v.a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
                BookSourceDebugAdapter bookSourceDebugAdapter = this.this$0.adapter;
                if (bookSourceDebugAdapter == null) {
                    j.m("adapter");
                    throw null;
                }
                bookSourceDebugAdapter.f(this.$msg);
                int i2 = this.$state;
                if (i2 == -1 || i2 == 1000) {
                    ((ActivitySourceDebugBinding) this.this$0.K0()).f6564c.a();
                }
                return v.a;
            }
        }

        public a() {
            super(2);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ v invoke(Integer num, String str) {
            invoke(num.intValue(), str);
            return v.a;
        }

        public final void invoke(int i2, @NotNull String str) {
            j.e(str, NotificationCompat.CATEGORY_MESSAGE);
            BookSourceDebugActivity bookSourceDebugActivity = BookSourceDebugActivity.this;
            f.L3(bookSourceDebugActivity, null, null, new C0205a(bookSourceDebugActivity, str, i2, null), 3, null);
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

    /* JADX INFO: compiled from: BookSourceDebugActivity.kt */
    public static final class d extends k implements f.c0.b.a<v> {
        public d() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            BookSourceDebugActivity bookSourceDebugActivity = BookSourceDebugActivity.this;
            int i2 = BookSourceDebugActivity.f7287g;
            ((ActivitySourceDebugBinding) bookSourceDebugActivity.K0()).f6564c.b();
        }
    }

    /* JADX INFO: compiled from: BookSourceDebugActivity.kt */
    public static final class e extends k implements f.c0.b.a<v> {
        public e() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            f.R5(BookSourceDebugActivity.this, "未获取到书源");
        }
    }

    public BookSourceDebugActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(BookSourceDebugModel.class), new c(this), new b(this));
        ActivityResultLauncher<v> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new QrCodeResult(), new ActivityResultCallback() { // from class: e.a.a.g.d.l.a.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BookSourceDebugActivity bookSourceDebugActivity = this.a;
                String str = (String) obj;
                int i2 = BookSourceDebugActivity.f7287g;
                j.e(bookSourceDebugActivity, "this$0");
                if (str == null) {
                    return;
                }
                bookSourceDebugActivity.U0(str);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(QrCodeResult()) {\n        it?.let {\n            startSearch(it)\n        }\n    }");
        this.qrCodeResult = activityResultLauncherRegisterForActivityResult;
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        ActivitySourceDebugBinding activitySourceDebugBindingA = ActivitySourceDebugBinding.a(getLayoutInflater());
        j.d(activitySourceDebugBindingA, "inflate(layoutInflater)");
        return activitySourceDebugBindingA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        View viewFindViewById = ((ActivitySourceDebugBinding) K0()).f6565d.findViewById(R.id.search_view);
        j.d(viewFindViewById, "binding.titleBar.findViewById(R.id.search_view)");
        this.searchView = (SearchView) viewFindViewById;
        BookSourceDebugModel bookSourceDebugModelT0 = T0();
        String stringExtra = getIntent().getStringExtra("key");
        Objects.requireNonNull(bookSourceDebugModelT0);
        if (stringExtra != null) {
            BaseViewModel.a(bookSourceDebugModelT0, null, null, new e.a.a.g.d.l.a.c(stringExtra, bookSourceDebugModelT0, null), 3, null);
        }
        ATH.a.b(((ActivitySourceDebugBinding) K0()).f6563b);
        this.adapter = new BookSourceDebugAdapter(this);
        RecyclerView recyclerView = ((ActivitySourceDebugBinding) K0()).f6563b;
        BookSourceDebugAdapter bookSourceDebugAdapter = this.adapter;
        if (bookSourceDebugAdapter == null) {
            j.m("adapter");
            throw null;
        }
        recyclerView.setAdapter(bookSourceDebugAdapter);
        ((ActivitySourceDebugBinding) K0()).f6564c.setLoadingColor(f.M1(this));
        SearchView searchView = this.searchView;
        if (searchView == null) {
            j.m("searchView");
            throw null;
        }
        searchView.onActionViewExpanded();
        SearchView searchView2 = this.searchView;
        if (searchView2 == null) {
            j.m("searchView");
            throw null;
        }
        searchView2.setSubmitButtonEnabled(true);
        SearchView searchView3 = this.searchView;
        if (searchView3 == null) {
            j.m("searchView");
            throw null;
        }
        searchView3.setQueryHint(getString(R.string.search_book_key));
        SearchView searchView4 = this.searchView;
        if (searchView4 == null) {
            j.m("searchView");
            throw null;
        }
        searchView4.clearFocus();
        SearchView searchView5 = this.searchView;
        if (searchView5 == null) {
            j.m("searchView");
            throw null;
        }
        searchView5.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: io.legado.app.ui.book.source.debug.BookSourceDebugActivity$initSearchView$1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(@Nullable String newText) {
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(@Nullable String query) {
                SearchView searchView6 = this.a.searchView;
                if (searchView6 == null) {
                    j.m("searchView");
                    throw null;
                }
                searchView6.clearFocus();
                BookSourceDebugActivity bookSourceDebugActivity = this.a;
                if (query == null) {
                    query = "我的";
                }
                bookSourceDebugActivity.U0(query);
                return true;
            }
        });
        BookSourceDebugModel bookSourceDebugModelT02 = T0();
        a aVar = new a();
        Objects.requireNonNull(bookSourceDebugModelT02);
        j.e(aVar, "callback");
        bookSourceDebugModelT02.callback = aVar;
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.book_source_debug, menu);
        return super.P0(menu);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        switch (item.getItemId()) {
            case R.id.menu_book_src /* 2131296790 */:
                TextDialog.Companion companion = TextDialog.INSTANCE;
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                j.d(supportFragmentManager, "supportFragmentManager");
                TextDialog.Companion.a(companion, supportFragmentManager, T0().bookSrc, 0, 0L, false, 28);
                break;
            case R.id.menu_content_src /* 2131296802 */:
                TextDialog.Companion companion2 = TextDialog.INSTANCE;
                FragmentManager supportFragmentManager2 = getSupportFragmentManager();
                j.d(supportFragmentManager2, "supportFragmentManager");
                TextDialog.Companion.a(companion2, supportFragmentManager2, T0().contentSrc, 0, 0L, false, 28);
                break;
            case R.id.menu_scan /* 2131296871 */:
                this.qrCodeResult.launch(null);
                break;
            case R.id.menu_search_src /* 2131296876 */:
                TextDialog.Companion companion3 = TextDialog.INSTANCE;
                FragmentManager supportFragmentManager3 = getSupportFragmentManager();
                j.d(supportFragmentManager3, "supportFragmentManager");
                TextDialog.Companion.a(companion3, supportFragmentManager3, T0().searchSrc, 0, 0L, false, 28);
                break;
            case R.id.menu_toc_src /* 2131296895 */:
                TextDialog.Companion companion4 = TextDialog.INSTANCE;
                FragmentManager supportFragmentManager4 = getSupportFragmentManager();
                j.d(supportFragmentManager4, "supportFragmentManager");
                TextDialog.Companion.a(companion4, supportFragmentManager4, T0().tocSrc, 0, 0L, false, 28);
                break;
        }
        return super.Q0(item);
    }

    @NotNull
    public BookSourceDebugModel T0() {
        return (BookSourceDebugModel) this.viewModel.getValue();
    }

    public final void U0(String key) {
        BookSourceDebugAdapter bookSourceDebugAdapter = this.adapter;
        if (bookSourceDebugAdapter == null) {
            j.m("adapter");
            throw null;
        }
        bookSourceDebugAdapter.h();
        BookSourceDebugModel bookSourceDebugModelT0 = T0();
        d dVar = new d();
        e eVar = new e();
        Objects.requireNonNull(bookSourceDebugModelT0);
        j.e(key, "key");
        e.a.a.d.u.b bVarA = BaseViewModel.a(bookSourceDebugModelT0, null, null, new e.a.a.g.d.l.a.d(bookSourceDebugModelT0, key, null), 3, null);
        e.a.a.g.d.l.a.e eVar2 = new e.a.a.g.d.l.a.e(dVar, null);
        j.e(eVar2, "block");
        bVarA.f5561e = new b.c(bVarA, null, eVar2);
        e.a.a.d.u.b.b(bVarA, null, new e.a.a.g.d.l.a.f(eVar, null), 1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(@Nullable Bundle savedInstanceState) throws IOException {
        super.onPostCreate(savedInstanceState);
        if (q.a.b(1, "debugHelpVersion", null)) {
            return;
        }
        InputStream inputStreamOpen = getAssets().open("help/debugHelp.md");
        j.d(inputStreamOpen, "assets.open(\"help/debugHelp.md\")");
        String str = new String(f.w4(inputStreamOpen), f.h0.a.a);
        TextDialog.Companion companion = TextDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        TextDialog.Companion.a(companion, supportFragmentManager, str, 1, 0L, false, 24);
    }
}
