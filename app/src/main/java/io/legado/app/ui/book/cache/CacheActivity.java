package io.legado.app.ui.book.cache;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.snackbar.Snackbar;
import com.ifmvo.togetherad.core.helper.AdHelperInter;
import com.ifmvo.togetherad.core.listener.InterListener;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.ai;
import e.a.a.h.f;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.s;
import f.v;
import g.b.k0;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookGroup;
import io.legado.app.databinding.ActivityCacheBookBinding;
import io.legado.app.model.AdsConfig;
import io.legado.app.service.CacheBookService;
import io.legado.app.ui.book.cache.CacheActivity;
import io.legado.app.ui.book.cache.CacheAdapter;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dialog.TextListDialog;
import io.legado.app.utils.EventBusExtensionsKt$observeEvent$o$1;
import io.wenyuange.app.release.R;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: CacheActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\bX\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0007J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b$\u0010#J\r\u0010%\u001a\u00020\u0005¢\u0006\u0004\b%\u0010\u0007J\u000f\u0010&\u001a\u00020\u0005H\u0014¢\u0006\u0004\b&\u0010\u0007R$\u0010,\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001d\u00104\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u0010<\u001a\u0002058\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R&\u0010B\u001a\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010J\u001a\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010F0F0E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR$\u0010L\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0(\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010+R\u0016\u0010O\u001a\u00020\n8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Y"}, d2 = {"Lio/legado/app/ui/book/cache/CacheActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityCacheBookBinding;", "Lio/legado/app/ui/book/cache/CacheViewModel;", "Lio/legado/app/ui/book/cache/CacheAdapter$a;", "Lf/v;", "a1", "()V", "W0", "X0", "", "path", "Z0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "onPrepareOptionsMenu", "", "featureId", "onMenuOpened", "(ILandroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "N0", "position", "r0", "(I)V", "F", "Y0", "onDestroy", "Landroidx/lifecycle/LiveData;", "", "Lio/legado/app/data/entities/Book;", Constants.LANDSCAPE, "Landroidx/lifecycle/LiveData;", "booksLiveData", "n", OptRuntime.GeneratorState.resumptionPoint_TYPE, "exportPosition", "q", "Lf/e;", "V0", "()Lio/legado/app/ui/book/cache/CacheViewModel;", "viewModel", "Lio/legado/app/ui/book/cache/CacheAdapter;", "j", "Lio/legado/app/ui/book/cache/CacheAdapter;", "U0", "()Lio/legado/app/ui/book/cache/CacheAdapter;", "setAdapter", "(Lio/legado/app/ui/book/cache/CacheAdapter;)V", "adapter", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/BookGroup;", "Lkotlin/collections/ArrayList;", "o", "Ljava/util/ArrayList;", "groupList", "m", "Landroid/view/Menu;", "Landroidx/activity/result/ActivityResultLauncher;", "Le/a/a/g/f/d;", "kotlin.jvm.PlatformType", "h", "Landroidx/activity/result/ActivityResultLauncher;", "exportDir", "k", "groupLiveData", ai.aA, "Ljava/lang/String;", "exportBookPathKey", "", "p", "J", "groupId", "Lcom/ifmvo/togetherad/core/helper/AdHelperInter;", "r", "Lcom/ifmvo/togetherad/core/helper/AdHelperInter;", "adHelperInter", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class CacheActivity extends VMBaseActivity<ActivityCacheBookBinding, CacheViewModel> implements CacheAdapter.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7033g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<e.a.a.g.f.d> exportDir;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String exportBookPathKey;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public CacheAdapter adapter;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<BookGroup>> groupLiveData;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<Book>> booksLiveData;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public Menu menu;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int exportPosition;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final ArrayList<BookGroup> groupList;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public long groupId;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @Nullable
    public AdHelperInter adHelperInter;

    /* JADX INFO: compiled from: CacheActivity.kt */
    public static final class a extends k implements l<ConcurrentHashMap<String, CopyOnWriteArraySet<BookChapter>>, v> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(ConcurrentHashMap<String, CopyOnWriteArraySet<BookChapter>> concurrentHashMap) {
            invoke2(concurrentHashMap);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull ConcurrentHashMap<String, CopyOnWriteArraySet<BookChapter>> concurrentHashMap) {
            MenuItem menuItemFindItem;
            MenuItem menuItemFindItem2;
            j.e(concurrentHashMap, "it");
            if (concurrentHashMap.isEmpty()) {
                Menu menu = CacheActivity.this.menu;
                if (menu != null && (menuItemFindItem2 = menu.findItem(R.id.menu_download)) != null) {
                    menuItemFindItem2.setIcon(R.drawable.ic_play_24dp);
                }
                CacheActivity cacheActivity = CacheActivity.this;
                Menu menu2 = cacheActivity.menu;
                if (menu2 != null) {
                    m.b(menu2, cacheActivity, null, 2);
                }
            } else {
                Menu menu3 = CacheActivity.this.menu;
                if (menu3 != null && (menuItemFindItem = menu3.findItem(R.id.menu_download)) != null) {
                    menuItemFindItem.setIcon(R.drawable.ic_stop_black_24dp);
                }
                CacheActivity cacheActivity2 = CacheActivity.this;
                Menu menu4 = cacheActivity2.menu;
                if (menu4 != null) {
                    m.b(menu4, cacheActivity2, null, 2);
                }
            }
            CacheActivity.this.U0().downloadMap = concurrentHashMap;
            CacheActivity.this.U0().notifyItemRangeChanged(0, CacheActivity.this.U0().getItemCount(), Boolean.TRUE);
        }
    }

    /* JADX INFO: compiled from: CacheActivity.kt */
    public static final class b extends k implements l<BookChapter, v> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(BookChapter bookChapter) {
            invoke2(bookChapter);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BookChapter bookChapter) {
            j.e(bookChapter, "it");
            HashSet<String> hashSet = CacheActivity.this.U0().cacheChapters.get(bookChapter.getBookUrl());
            if (hashSet == null) {
                return;
            }
            hashSet.add(bookChapter.getUrl());
        }
    }

    /* JADX INFO: compiled from: CacheActivity.kt */
    public static final class c implements InterListener {
        public c() {
        }

        @Override // com.ifmvo.togetherad.core.listener.InterListener
        public void onAdClicked(@NotNull String str) {
            j.e(str, "providerType");
            // AD REMOVED: MobclickAgent.onEvent(CacheActivity.this, "cacheAdsClick");
        }

        @Override // com.ifmvo.togetherad.core.listener.InterListener
        public void onAdClose(@NotNull String str) {
            j.e(str, "providerType");
        }

        @Override // com.ifmvo.togetherad.core.listener.InterListener
        public void onAdExpose(@NotNull String str) {
            j.e(str, "providerType");
            // AD REMOVED: MobclickAgent.onEvent(CacheActivity.this, "cacheAdsExpose");
        }

        @Override // com.ifmvo.togetherad.core.listener.BaseListener
        public void onAdFailed(@NotNull String str, @Nullable String str2) {
            j.e(str, "providerType");
            // AD REMOVED: MobclickAgent.onEvent(CacheActivity.this, "cacheAdsFaild");
            // AD REMOVED: MobclickAgent.onEvent(CacheActivity.this, "cacheAdsFaildMsg", str + Attributes.InternalPrefix + ((Object) str2));
        }

        @Override // com.ifmvo.togetherad.core.listener.BaseListener
        public void onAdFailedAll(@Nullable String str) {
            // AD REMOVED: MobclickAgent.onEvent(CacheActivity.this, "cacheAdsFaildAll");
            // AD REMOVED: MobclickAgent.onEvent(CacheActivity.this, "cacheAdsFaildMsg", String.valueOf(str));
        }

        @Override // com.ifmvo.togetherad.core.listener.InterListener
        public void onAdLoaded(@NotNull String str) {
            j.e(str, "providerType");
            AdHelperInter adHelperInter = CacheActivity.this.adHelperInter;
            if (adHelperInter == null) {
                return;
            }
            adHelperInter.show();
        }

        @Override // com.ifmvo.togetherad.core.listener.BaseListener
        public void onAdStartRequest(@NotNull String str) {
            j.e(str, "providerType");
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

    /* JADX INFO: compiled from: CacheActivity.kt */
    public static final class f extends k implements l<String, v> {
        public final /* synthetic */ s $exportSize;
        public final /* synthetic */ CacheActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(s sVar, CacheActivity cacheActivity) {
            super(1);
            this.$exportSize = sVar;
            this.this$0 = cacheActivity;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            j.e(str, "it");
            s sVar = this.$exportSize;
            sVar.element--;
            c.b.a.m.f.R5(this.this$0, str);
            if (this.$exportSize.element <= 0) {
                TitleBar titleBar = CacheActivity.T0(this.this$0).f6506c;
                j.d(titleBar, "binding.titleBar");
                c.b.a.m.f.j5(titleBar, R.string.complete);
            }
        }
    }

    /* JADX INFO: compiled from: CacheActivity.kt */
    public static final class g extends k implements l<String, v> {
        public final /* synthetic */ s $exportSize;
        public final /* synthetic */ CacheActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(s sVar, CacheActivity cacheActivity) {
            super(1);
            this.$exportSize = sVar;
            this.this$0 = cacheActivity;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            j.e(str, "it");
            s sVar = this.$exportSize;
            sVar.element--;
            c.b.a.m.f.R5(this.this$0, str);
            if (this.$exportSize.element <= 0) {
                TitleBar titleBar = CacheActivity.T0(this.this$0).f6506c;
                j.d(titleBar, "binding.titleBar");
                c.b.a.m.f.j5(titleBar, R.string.complete);
            }
        }
    }

    /* JADX INFO: compiled from: CacheActivity.kt */
    public static final class h extends k implements l<String, v> {
        public h() {
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
            TitleBar titleBar = CacheActivity.T0(CacheActivity.this).f6506c;
            j.d(titleBar, "binding.titleBar");
            c.b.a.m.f.k5(titleBar, str);
        }
    }

    /* JADX INFO: compiled from: CacheActivity.kt */
    public static final class i extends k implements l<String, v> {
        public i() {
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
            TitleBar titleBar = CacheActivity.T0(CacheActivity.this).f6506c;
            j.d(titleBar, "binding.titleBar");
            c.b.a.m.f.k5(titleBar, str);
        }
    }

    public CacheActivity() {
        super(false, null, null, false, false, 31);
        ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.d.b.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CacheActivity cacheActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = CacheActivity.f7033g;
                f.c0.c.j.e(cacheActivity, "this$0");
                if (uri == null) {
                    return;
                }
                if (!c.b.a.m.f.s3(uri)) {
                    String path = uri.getPath();
                    if (path == null) {
                        return;
                    }
                    f.b.a(e.a.a.h.f.a, cacheActivity, null, 0L, 0, false, 30).b(cacheActivity.exportBookPathKey, path);
                    cacheActivity.Z0(path);
                    return;
                }
                e.a.a.h.f fVarA = f.b.a(e.a.a.h.f.a, cacheActivity, null, 0L, 0, false, 30);
                String str = cacheActivity.exportBookPathKey;
                String string = uri.toString();
                f.c0.c.j.d(string, "uri.toString()");
                fVarA.b(str, string);
                String string2 = uri.toString();
                f.c0.c.j.d(string2, "uri.toString()");
                cacheActivity.Z0(string2);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(FilePicker()) { uri ->\n        uri ?: return@registerForActivityResult\n        if (uri.isContentScheme()) {\n            ACache.get(this@CacheActivity).put(exportBookPathKey, uri.toString())\n            startExport(uri.toString())\n        } else {\n            uri.path?.let { path ->\n                ACache.get(this@CacheActivity).put(exportBookPathKey, path)\n                startExport(path)\n            }\n        }\n    }");
        this.exportDir = activityResultLauncherRegisterForActivityResult;
        this.exportBookPathKey = "exportBookPath";
        this.exportPosition = -1;
        this.groupList = new ArrayList<>();
        this.groupId = -1L;
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(CacheViewModel.class), new e(this), new d(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityCacheBookBinding T0(CacheActivity cacheActivity) {
        return (ActivityCacheBookBinding) cacheActivity.K0();
    }

    @Override // io.legado.app.ui.book.cache.CacheAdapter.a
    public void F(int position) {
        Y0();
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_cache_book, (ViewGroup) null, false);
        int i2 = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
        if (recyclerView != null) {
            i2 = R.id.title_bar;
            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
            if (titleBar != null) {
                ActivityCacheBookBinding activityCacheBookBinding = new ActivityCacheBookBinding((LinearLayout) viewInflate, recyclerView, titleBar);
                j.d(activityCacheBookBinding, "inflate(layoutInflater)");
                return activityCacheBookBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void N0() {
        String[] strArr = {"upDownload"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$1 = new EventBusExtensionsKt$observeEvent$o$1(new a());
        for (int i2 = 0; i2 < 1; i2++) {
            Observable observable = LiveEventBus.get(strArr[i2], ConcurrentHashMap.class);
            j.d(observable, "get(tag, EVENT::class.java)");
            observable.observe(this, eventBusExtensionsKt$observeEvent$o$1);
        }
        String[] strArr2 = {"saveContent"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$12 = new EventBusExtensionsKt$observeEvent$o$1(new b());
        for (int i3 = 0; i3 < 1; i3++) {
            Observable observable2 = LiveEventBus.get(strArr2[i3], BookChapter.class);
            j.d(observable2, "get(tag, EVENT::class.java)");
            observable2.observe(this, eventBusExtensionsKt$observeEvent$o$12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        this.groupId = getIntent().getLongExtra("groupId", -1L);
        TitleBar titleBar = ((ActivityCacheBookBinding) K0()).f6506c;
        String stringExtra = getIntent().getStringExtra("groupName");
        if (stringExtra == null) {
            stringExtra = getString(R.string.all);
        }
        titleBar.setSubtitle(stringExtra);
        ((ActivityCacheBookBinding) K0()).f6505b.setLayoutManager(new LinearLayoutManager(this));
        CacheAdapter cacheAdapter = new CacheAdapter(this, this);
        j.e(cacheAdapter, "<set-?>");
        this.adapter = cacheAdapter;
        ((ActivityCacheBookBinding) K0()).f6505b.setAdapter(U0());
        LiveData<List<BookGroup>> liveData = this.groupLiveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        LiveData<List<BookGroup>> liveDataLiveDataAll = AppDatabaseKt.getAppDb().getBookGroupDao().liveDataAll();
        this.groupLiveData = liveDataLiveDataAll;
        if (liveDataLiveDataAll != null) {
            liveDataLiveDataAll.observe(this, new Observer() { // from class: e.a.a.g.d.b.d
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    CacheActivity cacheActivity = this.a;
                    int i2 = CacheActivity.f7033g;
                    f.c0.c.j.e(cacheActivity, "this$0");
                    cacheActivity.groupList.clear();
                    cacheActivity.groupList.addAll((List) obj);
                    cacheActivity.U0().notifyDataSetChanged();
                    cacheActivity.a1();
                }
            });
        }
        W0();
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.book_cache, menu);
        return super.P0(menu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        boolean z = true;
        switch (item.getItemId()) {
            case R.id.menu_download /* 2131296817 */:
                ConcurrentHashMap<String, CopyOnWriteArraySet<BookChapter>> concurrentHashMap = U0().downloadMap;
                if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                    z = false;
                }
                if (z) {
                    Y0();
                    for (Book book : U0().items) {
                        e.a.a.f.s.h.a.c(this, book.getBookUrl(), book.getDurChapterIndex(), book.getTotalChapterNum());
                    }
                } else {
                    e.a.a.f.s.h hVar = e.a.a.f.s.h.a;
                    j.e(this, com.umeng.analytics.pro.c.R);
                    Intent intent = new Intent(this, (Class<?>) CacheBookService.class);
                    intent.setAction("stop");
                    startService(intent);
                }
                break;
            case R.id.menu_enable_replace /* 2131296821 */:
                e.a.a.d.e eVar = e.a.a.d.e.a;
                c.b.a.m.f.o4(k.d.a.h.g(), "exportUseReplace", !item.isChecked());
                break;
            case R.id.menu_export_all /* 2131296825 */:
                Y0();
                this.exportPosition = -10;
                String strA = f.b.a(e.a.a.h.f.a, this, null, 0L, 0, false, 30).a(this.exportBookPathKey);
                if (strA != null && strA.length() != 0) {
                    z = false;
                }
                if (z) {
                    X0();
                } else {
                    Z0(strA);
                }
                break;
            case R.id.menu_export_charset /* 2131296827 */:
                ((e.a.a.e.a.i) c.b.a.m.f.j0(this, Integer.valueOf(R.string.set_charset), null, new e.a.a.g.d.b.k(this), 2)).p();
                break;
            case R.id.menu_export_folder /* 2131296828 */:
                this.exportPosition = -1;
                X0();
                break;
            case R.id.menu_export_type /* 2131296830 */:
                c.b.a.m.f.a5(this, Integer.valueOf(R.string.export_type), f.x.e.a("txt", "epub"), e.a.a.g.d.b.l.INSTANCE);
                break;
            case R.id.menu_export_web_dav /* 2131296831 */:
                e.a.a.d.e eVar2 = e.a.a.d.e.a;
                c.b.a.m.f.o4(k.d.a.h.g(), "webDavCacheBackup", !item.isChecked());
                break;
            case R.id.menu_log /* 2131296851 */:
                TextListDialog.Companion companion = TextListDialog.INSTANCE;
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                j.d(supportFragmentManager, "supportFragmentManager");
                String string = getString(R.string.log);
                j.d(string, "getString(R.string.log)");
                e.a.a.f.s.h hVar2 = e.a.a.f.s.h.a;
                ArrayList<String> arrayList = e.a.a.f.s.h.f5672b;
                Objects.requireNonNull(companion);
                j.e(supportFragmentManager, "fragmentManager");
                j.e(string, "title");
                j.e(arrayList, "values");
                TextListDialog textListDialog = new TextListDialog();
                Bundle bundle = new Bundle();
                bundle.putString("title", string);
                bundle.putStringArrayList("values", arrayList);
                textListDialog.setArguments(bundle);
                textListDialog.show(supportFragmentManager, "textListDialog");
                break;
            default:
                if (item.getGroupId() == R.id.menu_group) {
                    ((ActivityCacheBookBinding) K0()).f6506c.setSubtitle(item.getTitle());
                    BookGroup byName = AppDatabaseKt.getAppDb().getBookGroupDao().getByName(item.getTitle().toString());
                    this.groupId = byName == null ? 0L : byName.getGroupId();
                    W0();
                }
                break;
        }
        return super.Q0(item);
    }

    @NotNull
    public final CacheAdapter U0() {
        CacheAdapter cacheAdapter = this.adapter;
        if (cacheAdapter != null) {
            return cacheAdapter;
        }
        j.m("adapter");
        throw null;
    }

    @NotNull
    public CacheViewModel V0() {
        return (CacheViewModel) this.viewModel.getValue();
    }

    public final void W0() {
        LiveData<List<Book>> liveData = this.booksLiveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        long j2 = this.groupId;
        LiveData<List<Book>> liveDataObserveAll = j2 == -1 ? AppDatabaseKt.getAppDb().getBookDao().observeAll() : j2 == -2 ? AppDatabaseKt.getAppDb().getBookDao().observeLocal() : j2 == -3 ? AppDatabaseKt.getAppDb().getBookDao().observeAudio() : j2 == -4 ? AppDatabaseKt.getAppDb().getBookDao().observeNoGroup() : AppDatabaseKt.getAppDb().getBookDao().observeByGroup(this.groupId);
        this.booksLiveData = liveDataObserveAll;
        if (liveDataObserveAll == null) {
            return;
        }
        liveDataObserveAll.observe(this, new Observer() { // from class: e.a.a.g.d.b.b
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                CacheActivity cacheActivity = this.a;
                List list = (List) obj;
                int i2 = CacheActivity.f7033g;
                f.c0.c.j.e(cacheActivity, "this$0");
                f.c0.c.j.d(list, "list");
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (((Book) obj2).isOnLineTxt()) {
                        arrayList.add(obj2);
                    }
                }
                int iM2 = c.b.a.m.f.M2(cacheActivity, "bookshelfSort", 0, 2);
                List listB = iM2 != 1 ? iM2 != 2 ? iM2 != 3 ? f.x.e.B(arrayList, new i()) : f.x.e.B(arrayList, new g()) : f.x.e.B(arrayList, a.a) : f.x.e.B(arrayList, new h());
                cacheActivity.U0().x(listB);
                k0 k0Var = k0.f6264c;
                c.b.a.m.f.L3(cacheActivity, k0.f6263b, null, new j(listB, cacheActivity, null), 2, null);
            }
        });
    }

    public final void X0() {
        ArrayList arrayList = new ArrayList();
        String strA = f.b.a(e.a.a.h.f.a, this, null, 0L, 0, false, 30).a(this.exportBookPathKey);
        if (!(strA == null || strA.length() == 0)) {
            arrayList.add(strA);
        }
        ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncher = this.exportDir;
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        activityResultLauncher.launch(new e.a.a.g.f.d(0, null, null, (String[]) array, 7));
    }

    public final void Y0() {
        AdsConfig adsConfigC = e.a.a.d.w.c.c(this);
        if (adsConfigC.getEnableAds() && adsConfigC.getEnableCache() && e.a.a.d.w.c.a(adsConfigC)) {
            if (this.adHelperInter == null) {
                this.adHelperInter = new AdHelperInter(this, "ad_inter", adsConfigC.getCacheWeight(), new c());
            }
            AdHelperInter adHelperInter = this.adHelperInter;
            if (adHelperInter == null) {
                return;
            }
            adHelperInter.load();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0(String path) {
        Book item;
        int i2 = this.exportPosition;
        if (i2 != -10) {
            if (i2 < 0 || (item = U0().getItem(this.exportPosition)) == null) {
                return;
            }
            Snackbar.k(((ActivityCacheBookBinding) K0()).f6506c, R.string.exporting, -2).o();
            e.a.a.d.e eVar = e.a.a.d.e.a;
            if (c.b.a.m.f.M2(k.d.a.h.g(), "exportType", 0, 2) == 1) {
                V0().h(path, item, new h());
                return;
            } else {
                V0().g(path, item, new i());
                return;
            }
        }
        if (!(!U0().items.isEmpty())) {
            c.b.a.m.f.Q5(this, R.string.no_book);
            return;
        }
        Snackbar.k(((ActivityCacheBookBinding) K0()).f6506c, R.string.exporting, -2).o();
        s sVar = new s();
        sVar.element = U0().items.size();
        for (Book book : U0().items) {
            e.a.a.d.e eVar2 = e.a.a.d.e.a;
            if (c.b.a.m.f.M2(k.d.a.h.g(), "exportType", 0, 2) == 1) {
                V0().h(path, book, new f(sVar, this));
            } else {
                V0().g(path, book, new g(sVar, this));
            }
        }
    }

    public final void a1() {
        SubMenu subMenu;
        Menu menu = this.menu;
        MenuItem menuItemFindItem = menu == null ? null : menu.findItem(R.id.menu_book_group);
        if (menuItemFindItem == null || (subMenu = menuItemFindItem.getSubMenu()) == null) {
            return;
        }
        subMenu.removeGroup(R.id.menu_group);
        for (BookGroup bookGroup : this.groupList) {
            subMenu.add(R.id.menu_group, bookGroup.getOrder(), 0, bookGroup.getGroupName());
        }
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AdHelperInter adHelperInter = this.adHelperInter;
        if (adHelperInter != null) {
            adHelperInter.destroy();
        }
        this.adHelperInter = null;
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int featureId, @NotNull Menu menu) {
        j.e(menu, "menu");
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_enable_replace);
        if (menuItemFindItem != null) {
            menuItemFindItem.setChecked(e.a.a.d.e.a.f());
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_export_web_dav);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setChecked(e.a.a.d.e.a.e());
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        this.menu = menu;
        a1();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // io.legado.app.ui.book.cache.CacheAdapter.a
    public void r0(int position) {
        this.exportPosition = position;
        String strA = f.b.a(e.a.a.h.f.a, this, null, 0L, 0, false, 30).a(this.exportBookPathKey);
        if (strA == null || strA.length() == 0) {
            X0();
        } else {
            Z0(strA);
        }
    }
}
