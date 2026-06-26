package io.legado.app.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.d.m;
import e.a.a.d.q;
import e.a.a.d.u.b;
import e.a.a.d.w.i;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import g.b.x0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.databinding.ActivityMainBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.service.BaseReadAloudService;
import io.legado.app.ui.main.MainActivity;
import io.legado.app.ui.main.MainViewModel;
import io.legado.app.ui.main.bookshelf.BookshelfFragment;
import io.legado.app.ui.main.bookshelf.books.BooksFragment;
import io.legado.app.ui.main.explore.BookStoreFragment;
import io.legado.app.ui.main.explore.ExploreAdapter;
import io.legado.app.ui.main.explore.ExploreFragment;
import io.legado.app.ui.main.my.MeFragment;
import io.legado.app.ui.main.rss.RssFragment;
import io.legado.app.utils.EventBusExtensionsKt$observeEvent$o$1;
import io.wenyuange.app.release.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0002EFB\u0007¢\u0006\u0004\bD\u0010\u0010J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\"\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\bH\u0014¢\u0006\u0004\b$\u0010\u0010J\u000f\u0010%\u001a\u00020\bH\u0014¢\u0006\u0004\b%\u0010\u0010J\u000f\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u0010J\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u0010R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001d\u0010/\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R2\u00109\u001a\u001e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020504j\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000205`68\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00102R\u0016\u0010=\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00102R\u0016\u0010?\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010)R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00170@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006G"}, d2 = {"Lio/legado/app/ui/main/MainActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityMainBinding;", "Lio/legado/app/ui/main/MainViewModel;", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$c;", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$b;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "()V", "onPostCreate", "Landroid/view/MenuItem;", "item", "", "e", "(Landroid/view/MenuItem;)Z", "", "featureId", "Landroid/view/Menu;", "menu", "onMenuOpened", "(ILandroid/view/Menu;)Z", "t0", "(Landroid/view/MenuItem;)V", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKeyUp", "(ILandroid/view/KeyEvent;)Z", "onPause", "onDestroy", "N0", "U0", "n", OptRuntime.GeneratorState.resumptionPoint_TYPE, "bottomMenuCount", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/main/MainViewModel;", "viewModel", "", ai.aA, "J", "exitTime", "Ljava/util/HashMap;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/HashMap;", "m", "Ljava/util/HashMap;", "fragmentMap", "k", "exploreReselected", "j", "bookshelfReselected", Constants.LANDSCAPE, "pagePosition", "", "o", "[Ljava/lang/Integer;", "realPositions", "<init>", ai.at, "b", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class MainActivity extends VMBaseActivity<ActivityMainBinding, MainViewModel> implements BottomNavigationView.c, BottomNavigationView.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7392g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public long exitTime;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public long bookshelfReselected;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public long exploreReselected;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public int pagePosition;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final HashMap<Long, Fragment> fragmentMap;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int bottomMenuCount;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final Integer[] realPositions;

    /* JADX INFO: compiled from: MainActivity.kt */
    public final class a extends ViewPager2.OnPageChangeCallback {
        public final /* synthetic */ MainActivity a;

        public a(MainActivity mainActivity) {
            j.e(mainActivity, "this$0");
            this.a = mainActivity;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            MainActivity mainActivity = this.a;
            mainActivity.pagePosition = i2;
            ((ActivityMainBinding) mainActivity.K0()).f6522b.getMenu().getItem(this.a.realPositions[i2].intValue()).setChecked(true);
        }
    }

    /* JADX INFO: compiled from: MainActivity.kt */
    public final class b extends FragmentStateAdapter {
        public final /* synthetic */ MainActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MainActivity mainActivity) {
            super(mainActivity);
            j.e(mainActivity, "this$0");
            this.a = mainActivity;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public boolean containsItem(long j2) {
            return this.a.fragmentMap.containsKey(Long.valueOf(j2));
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int i2) {
            long jIntValue = this.a.realPositions[i2].intValue();
            Fragment bookshelfFragment = jIntValue == 0 ? new BookshelfFragment() : jIntValue == 1 ? new BookStoreFragment() : jIntValue == 2 ? new RssFragment() : new MeFragment();
            this.a.fragmentMap.put(Long.valueOf(jIntValue), bookshelfFragment);
            return bookshelfFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.bottomMenuCount;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i2) {
            return this.a.realPositions[i2].intValue();
        }
    }

    /* JADX INFO: compiled from: MainActivity.kt */
    public static final class c extends k implements l<String, v> {
        public c() {
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
            MainActivity.this.recreate();
        }
    }

    /* JADX INFO: compiled from: MainActivity.kt */
    public static final class d extends k implements l<String, v> {
        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            j.e(str, "it");
            MainActivity mainActivity = MainActivity.this;
            int i2 = MainActivity.f7392g;
            ActivityMainBinding activityMainBinding = (ActivityMainBinding) mainActivity.K0();
            MainActivity.this.U0();
            RecyclerView.Adapter adapter = activityMainBinding.f6523c.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            activityMainBinding.f6523c.setCurrentItem(r0.bottomMenuCount - 1, false);
        }
    }

    /* JADX INFO: compiled from: MainActivity.kt */
    public static final class e extends k implements l<String, v> {
        public e() {
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
            MainViewModel mainViewModelT0 = MainActivity.this.T0();
            Objects.requireNonNull(mainViewModelT0);
            mainViewModelT0.threadCount = e.a.a.d.e.a.k();
            mainViewModelT0.upTocPool.close();
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(mainViewModelT0.threadCount);
            j.d(executorServiceNewFixedThreadPool, "newFixedThreadPool(threadCount)");
            mainViewModelT0.upTocPool = new x0(executorServiceNewFixedThreadPool);
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class f extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
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
    public static final class g extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
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

    public MainActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(MainViewModel.class), new g(this), new f(this));
        this.fragmentMap = new HashMap<>();
        this.bottomMenuCount = 2;
        this.realPositions = new Integer[]{0, 1, 2, 3};
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_main, (ViewGroup) null, false);
        int i2 = R.id.bottom_navigation_view;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) viewInflate.findViewById(R.id.bottom_navigation_view);
        if (bottomNavigationView != null) {
            i2 = R.id.view_pager_main;
            ViewPager2 viewPager2 = (ViewPager2) viewInflate.findViewById(R.id.view_pager_main);
            if (viewPager2 != null) {
                ActivityMainBinding activityMainBinding = new ActivityMainBinding((LinearLayout) viewInflate, bottomNavigationView, viewPager2);
                j.d(activityMainBinding, "inflate(layoutInflater)");
                return activityMainBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void N0() {
        String[] strArr = {"RECREATE"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$1 = new EventBusExtensionsKt$observeEvent$o$1(new c());
        for (int i2 = 0; i2 < 1; i2++) {
            Observable observable = LiveEventBus.get(strArr[i2], String.class);
            j.d(observable, "get(tag, EVENT::class.java)");
            observable.observe(this, eventBusExtensionsKt$observeEvent$o$1);
        }
        String[] strArr2 = {"notifyMain"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$12 = new EventBusExtensionsKt$observeEvent$o$1(new d());
        for (int i3 = 0; i3 < 1; i3++) {
            Observable observable2 = LiveEventBus.get(strArr2[i3], String.class);
            j.d(observable2, "get(tag, EVENT::class.java)");
            observable2.observe(this, eventBusExtensionsKt$observeEvent$o$12);
        }
        String[] strArr3 = {"threadCount"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$13 = new EventBusExtensionsKt$observeEvent$o$1(new e());
        for (int i4 = 0; i4 < 1; i4++) {
            Observable observable3 = LiveEventBus.get(strArr3[i4], String.class);
            j.d(observable3, "get(tag, EVENT::class.java)");
            observable3.observe(this, eventBusExtensionsKt$observeEvent$o$13);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        U0();
        ActivityMainBinding activityMainBinding = (ActivityMainBinding) K0();
        ATH.a.b(activityMainBinding.f6523c);
        BottomNavigationView bottomNavigationView = activityMainBinding.f6522b;
        j.d(bottomNavigationView, "bottomNavigationView");
        j.e(bottomNavigationView, "bottomBar");
        Context context = bottomNavigationView.getContext();
        j.d(context, com.umeng.analytics.pro.c.R);
        int iT1 = c.b.a.m.f.T1(context);
        bottomNavigationView.setBackgroundColor(iT1);
        boolean z = ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d;
        Context context2 = bottomNavigationView.getContext();
        j.d(context2, com.umeng.analytics.pro.c.R);
        int iU2 = c.b.a.m.f.U2(context2, z);
        e.a.a.e.d.a aVar = new e.a.a.e.d.a();
        aVar.b(iU2);
        Context context3 = bottomNavigationView.getContext();
        j.d(context3, com.umeng.analytics.pro.c.R);
        j.e(context3, com.umeng.analytics.pro.c.R);
        j.e(context3, com.umeng.analytics.pro.c.R);
        SharedPreferences sharedPreferences = context3.getSharedPreferences("app_themes", 0);
        j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        int color = Color.parseColor("#263238");
        j.e(context3, com.umeng.analytics.pro.c.R);
        TypedArray typedArrayObtainStyledAttributes = context3.getTheme().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, color);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        aVar.e(sharedPreferences.getInt("accent_color", color));
        ColorStateList colorStateListA = aVar.a();
        bottomNavigationView.setItemIconTintList(colorStateListA);
        bottomNavigationView.setItemTextColor(colorStateListA);
        activityMainBinding.f6523c.setOffscreenPageLimit(3);
        activityMainBinding.f6523c.setAdapter(new b(this));
        activityMainBinding.f6523c.setUserInputEnabled(false);
        activityMainBinding.f6523c.registerOnPageChangeCallback(new a(this));
        activityMainBinding.f6522b.setElevation(e.a.a.d.e.a.c() < 0 ? c.b.a.m.f.q2(this) : r1.c());
        activityMainBinding.f6522b.setOnNavigationItemSelectedListener(this);
        activityMainBinding.f6522b.setOnNavigationItemReselectedListener(this);
    }

    @NotNull
    public MainViewModel T0() {
        return (MainViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U0() {
        e.a.a.d.e eVar = e.a.a.d.e.a;
        boolean zJ2 = c.b.a.m.f.J2(h.g(), "showDiscovery", true);
        Menu menu = ((ActivityMainBinding) K0()).f6522b.getMenu();
        menu.findItem(R.id.menu_discovery).setVisible(zJ2);
        menu.findItem(R.id.menu_rss).setVisible(false);
        this.bottomMenuCount = 2;
        this.realPositions[1] = 1;
        this.realPositions[2] = 2;
        if (zJ2) {
            this.bottomMenuCount++;
        } else {
            this.realPositions[1] = 3;
            this.realPositions[2] = 3;
        }
        this.realPositions[2] = 3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.material.bottomnavigation.BottomNavigationView.c
    public boolean e(@NotNull MenuItem item) {
        j.e(item, "item");
        ActivityMainBinding activityMainBinding = (ActivityMainBinding) K0();
        switch (item.getItemId()) {
            case R.id.menu_bookshelf /* 2131296792 */:
                activityMainBinding.f6523c.setCurrentItem(0, false);
                return false;
            case R.id.menu_discovery /* 2131296816 */:
                activityMainBinding.f6523c.setCurrentItem(1, false);
                return false;
            case R.id.menu_my_config /* 2131296853 */:
                activityMainBinding.f6523c.setCurrentItem(this.bottomMenuCount - 1, false);
                return false;
            case R.id.menu_rss /* 2131296867 */:
                e.a.a.d.e eVar = e.a.a.d.e.a;
                if (c.b.a.m.f.J2(h.g(), "showDiscovery", true)) {
                    activityMainBinding.f6523c.setCurrentItem(2, false);
                } else {
                    activityMainBinding.f6523c.setCurrentItem(1, false);
                }
                return false;
            default:
                return false;
        }
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.a.a.d.g gVar = e.a.a.d.g.a;
        b.C0148b.b(e.a.a.d.u.b.a, null, null, new e.a.a.d.h(null), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, @Nullable KeyEvent event) {
        if (event == null || keyCode != 4 || !event.isTracking() || event.isCanceled()) {
            return super.onKeyUp(keyCode, event);
        }
        if (this.pagePosition != 0) {
            ((ActivityMainBinding) K0()).f6523c.setCurrentItem(0);
            return true;
        }
        if (System.currentTimeMillis() - this.exitTime > 2000) {
            c.b.a.m.f.Q5(this, R.string.double_click_exit);
            this.exitTime = System.currentTimeMillis();
        } else if (BaseReadAloudService.f6929d) {
            finish();
        } else {
            moveTaskToBack(true);
        }
        return true;
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int featureId, @NotNull Menu menu) {
        j.e(menu, "menu");
        if (f.h0.k.i(menu.getClass().getSimpleName(), "MenuBuilder", true)) {
            try {
                Method declaredMethod = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                j.d(declaredMethod, "menu.javaClass.getDeclaredMethod(\n                        \"setOptionalIconsVisible\",\n                        java.lang.Boolean.TYPE\n                    )");
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(menu, Boolean.TRUE);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        j.e(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // io.legado.app.base.VMBaseActivity, io.legado.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i.a.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        q.a.a();
        SharedPreferences sharedPreferences = q.f5554b;
        long j2 = sharedPreferences.getLong("appVersionCode", 0L);
        e.a.a.c.c cVar = e.a.a.c.c.a;
        if (j2 != e.a.a.c.c.a().a) {
            long j3 = e.a.a.c.c.a().a;
            j.d(sharedPreferences, "localConfig");
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            j.b(editorEdit, "editor");
            editorEdit.putLong("appVersionCode", j3);
            editorEdit.apply();
            boolean z = sharedPreferences.getBoolean("firstOpen", true);
            if (z) {
                j.d(sharedPreferences, "localConfig");
                SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                j.b(editorEdit2, "editor");
                editorEdit2.putBoolean("firstOpen", false);
                editorEdit2.apply();
            }
            if (!z) {
                m mVar = m.a;
                m.d();
            }
            MainViewModel mainViewModelT0 = T0();
            Objects.requireNonNull(mainViewModelT0);
            BaseViewModel.a(mainViewModelT0, null, null, new e.a.a.g.h.f(null), 3, null);
        }
        e.a.a.d.e eVar = e.a.a.d.e.a;
        if (c.b.a.m.f.K2(h.g(), "auto_refresh", false, 2)) {
            ((ActivityMainBinding) K0()).f6523c.postDelayed(new Runnable() { // from class: e.a.a.g.h.a
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity mainActivity = this.a;
                    int i2 = MainActivity.f7392g;
                    j.e(mainActivity, "this$0");
                    MainViewModel mainViewModelT02 = mainActivity.T0();
                    Objects.requireNonNull(mainViewModelT02);
                    BaseViewModel.a(mainViewModelT02, null, null, new e(mainViewModelT02, null), 3, null);
                }
            }, 1000L);
        }
        ((ActivityMainBinding) K0()).f6523c.postDelayed(new Runnable() { // from class: e.a.a.g.h.b
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity mainActivity = this.a;
                int i2 = MainActivity.f7392g;
                j.e(mainActivity, "this$0");
                MainViewModel mainViewModelT02 = mainActivity.T0();
                Objects.requireNonNull(mainViewModelT02);
                BaseViewModel.a(mainViewModelT02, null, null, new d(mainViewModelT02, null), 3, null);
            }
        }, 3000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.VMBaseActivity, io.legado.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        int intExtra;
        super.onResume();
        Intent intent = getIntent();
        if (intent == null || (intExtra = intent.getIntExtra("action", -1)) == -1) {
            return;
        }
        BottomNavigationView bottomNavigationView = ((ActivityMainBinding) K0()).f6522b;
        int i2 = R.id.menu_bookshelf;
        if (intExtra != 0) {
            if (intExtra == 1) {
                i2 = R.id.menu_discovery;
            } else if (intExtra == 2) {
                i2 = R.id.menu_my_config;
            }
        }
        bottomNavigationView.setSelectedItemId(i2);
        if (intExtra == 0) {
            ((ActivityMainBinding) K0()).f6523c.setCurrentItem(0, false);
        } else if (intExtra == 1) {
            ((ActivityMainBinding) K0()).f6523c.setCurrentItem(1, false);
        } else {
            if (intExtra != 2) {
                return;
            }
            ((ActivityMainBinding) K0()).f6523c.setCurrentItem(this.bottomMenuCount - 1, false);
        }
    }

    @Override // com.google.android.material.bottomnavigation.BottomNavigationView.b
    public void t0(@NotNull MenuItem item) {
        BooksFragment booksFragment;
        boolean z;
        j.e(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.menu_bookshelf) {
            if (System.currentTimeMillis() - this.bookshelfReselected > 300) {
                this.bookshelfReselected = System.currentTimeMillis();
                return;
            }
            Fragment fragment = this.fragmentMap.get(0L);
            BookshelfFragment bookshelfFragment = fragment instanceof BookshelfFragment ? (BookshelfFragment) fragment : null;
            if (bookshelfFragment == null || (booksFragment = bookshelfFragment.fragmentMap.get(Long.valueOf(bookshelfFragment.V().getGroupId()))) == null) {
                return;
            }
            e.a.a.d.e eVar = e.a.a.d.e.a;
            if (e.a.a.d.e.f5519d) {
                booksFragment.U().f6708c.scrollToPosition(0);
                return;
            } else {
                booksFragment.U().f6708c.smoothScrollToPosition(0);
                return;
            }
        }
        if (itemId != R.id.menu_discovery) {
            return;
        }
        if (System.currentTimeMillis() - this.exploreReselected > 300) {
            this.exploreReselected = System.currentTimeMillis();
            return;
        }
        Fragment fragment2 = this.fragmentMap.get(1L);
        ExploreFragment exploreFragment = fragment2 instanceof ExploreFragment ? (ExploreFragment) fragment2 : null;
        if (exploreFragment == null) {
            return;
        }
        ExploreAdapter exploreAdapter = exploreFragment.adapter;
        if (exploreAdapter == null) {
            j.m("adapter");
            throw null;
        }
        int i2 = exploreAdapter.exIndex;
        if (i2 < 0) {
            z = false;
        } else {
            exploreAdapter.exIndex = -1;
            exploreAdapter.notifyItemChanged(i2);
            z = true;
        }
        if (z) {
            return;
        }
        e.a.a.d.e eVar2 = e.a.a.d.e.a;
        if (e.a.a.d.e.f5519d) {
            exploreFragment.U().f6717b.scrollToPosition(0);
        } else {
            exploreFragment.U().f6717b.smoothScrollToPosition(0);
        }
    }
}
