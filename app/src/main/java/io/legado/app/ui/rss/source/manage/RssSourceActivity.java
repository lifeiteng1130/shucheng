package io.legado.app.ui.rss.source.manage;

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
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SearchView;
import androidx.core.os.BundleKt;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.e.a.i;
import e.a.a.g.f.d;
import e.a.a.g.k.d.c.d0;
import e.a.a.g.k.d.c.e0;
import e.a.a.g.k.d.c.f0;
import e.a.a.g.k.d.c.g0;
import e.a.a.g.k.d.c.i0;
import e.a.a.g.k.d.c.j0;
import e.a.a.g.k.d.c.r;
import e.a.a.g.k.d.c.s;
import e.a.a.g.k.d.c.w;
import e.a.a.h.f;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.g;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.RssSourceDao;
import io.legado.app.data.entities.RssSource;
import io.legado.app.databinding.ActivityRssSourceBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.association.ImportRssSourceActivity;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.qrcode.QrCodeResult;
import io.legado.app.ui.rss.source.edit.RssSourceEditActivity;
import io.legado.app.ui.rss.source.manage.RssSourceActivity;
import io.legado.app.ui.rss.source.manage.RssSourceAdapter;
import io.legado.app.ui.rss.source.manage.RssSourceViewModel;
import io.legado.app.ui.widget.SelectActionBar;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.recycler.DragSelectTouchHelper;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;
import io.wenyuange.app.release.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\bR\u0010#J\u001f\u0010\n\u001a\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\u000eH\u0016¢\u0006\u0004\b%\u0010#J\u0017\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b*\u0010)J#\u0010,\u001a\u00020\u000e2\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0+\"\u00020&H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b.\u0010)J\u0017\u0010/\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b/\u0010)J\u000f\u00100\u001a\u00020\u000eH\u0016¢\u0006\u0004\b0\u0010#R$\u00104\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000e0\u000e018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R$\u0010;\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010909018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00103R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\f8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b@\u0010AR\u001d\u0010F\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b*\u0010C\u001a\u0004\bD\u0010ER$\u0010J\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u0007\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR$\u0010L\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010909018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u00103R&\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\f0Mj\b\u0012\u0004\u0012\u00020\f`N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lio/legado/app/ui/rss/source/manage/RssSourceActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityRssSourceBinding;", "Lio/legado/app/ui/rss/source/manage/RssSourceViewModel;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "Lio/legado/app/ui/widget/SelectActionBar$a;", "Lio/legado/app/ui/rss/source/manage/RssSourceAdapter$a;", "", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "V0", "()Ljava/util/List;", "", "searchKey", "Lf/v;", "U0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "onPrepareOptionsMenu", "item", "Q0", "(Landroid/view/MenuItem;)Z", "onMenuItemClick", "selectAll", "E0", "(Z)V", "f0", "()V", "I0", "b", "Lio/legado/app/data/entities/RssSource;", "source", "d", "(Lio/legado/app/data/entities/RssSource;)V", "h", "", "update", "([Lio/legado/app/data/entities/RssSource;)V", "g", "e0", ai.at, "Landroidx/activity/result/ActivityResultLauncher;", "n", "Landroidx/activity/result/ActivityResultLauncher;", "qrCodeResult", "Landroid/view/SubMenu;", "m", "Landroid/view/SubMenu;", "groupMenu", "Le/a/a/g/f/d;", "o", "importDoc", "Lio/legado/app/ui/rss/source/manage/RssSourceAdapter;", "j", "Lio/legado/app/ui/rss/source/manage/RssSourceAdapter;", "adapter", ai.aA, "Ljava/lang/String;", "importRecordKey", "Lf/e;", "T0", "()Lio/legado/app/ui/rss/source/manage/RssSourceViewModel;", "viewModel", "Landroidx/lifecycle/LiveData;", "k", "Landroidx/lifecycle/LiveData;", "sourceLiveData", "p", "exportDir", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", Constants.LANDSCAPE, "Ljava/util/HashSet;", "groups", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssSourceActivity extends VMBaseActivity<ActivityRssSourceBinding, RssSourceViewModel> implements PopupMenu.OnMenuItemClickListener, SelectActionBar.a, RssSourceAdapter.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7553g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String importRecordKey;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public RssSourceAdapter adapter;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<RssSource>> sourceLiveData;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public HashSet<String> groups;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public SubMenu groupMenu;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<v> qrCodeResult;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<d> importDoc;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<d> exportDir;

    /* JADX INFO: compiled from: RssSourceActivity.kt */
    public static final class a extends k implements l<Intent, v> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Intent intent) {
            invoke2(intent);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Intent intent) {
            j.e(intent, "it");
            RssSourceActivity rssSourceActivity = RssSourceActivity.this;
            rssSourceActivity.startActivity(Intent.createChooser(intent, rssSourceActivity.getString(R.string.share_selected_source)));
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

    public RssSourceActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(RssSourceViewModel.class), new c(this), new b(this));
        this.importRecordKey = "rssSourceRecordKey";
        this.groups = new HashSet<>();
        ActivityResultLauncher<v> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new QrCodeResult(), new ActivityResultCallback() { // from class: e.a.a.g.k.d.c.h
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                RssSourceActivity rssSourceActivity = this.a;
                String str = (String) obj;
                int i2 = RssSourceActivity.f7553g;
                f.c0.c.j.e(rssSourceActivity, "this$0");
                if (str == null) {
                    return;
                }
                Intent intent = new Intent(rssSourceActivity, (Class<?>) ImportRssSourceActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("source", str);
                rssSourceActivity.startActivity(intent);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(QrCodeResult()) {\n        it ?: return@registerForActivityResult\n        startActivity<ImportRssSourceActivity> {\n            putExtra(\"source\", it)\n        }\n    }");
        this.qrCodeResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<d> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.k.d.c.g
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Object objM11constructorimpl;
                RssSourceActivity rssSourceActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = RssSourceActivity.f7553g;
                f.c0.c.j.e(rssSourceActivity, "this$0");
                f.v vVar = null;
                if (uri != null) {
                    try {
                        String strB4 = c.b.a.m.f.B4(uri, rssSourceActivity);
                        if (strB4 != null) {
                            String strB = e.a.a.d.o.b(e.a.a.d.o.a, strB4, null, 2);
                            Intent intent = new Intent(rssSourceActivity, (Class<?>) ImportRssSourceActivity.class);
                            intent.addFlags(268435456);
                            intent.putExtra("dataKey", strB);
                            rssSourceActivity.startActivity(intent);
                            vVar = f.v.a;
                        }
                    } catch (Throwable th) {
                        objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
                    }
                }
                objM11constructorimpl = f.h.m11constructorimpl(vVar);
                Throwable thM14exceptionOrNullimpl = f.h.m14exceptionOrNullimpl(objM11constructorimpl);
                if (thM14exceptionOrNullimpl != null) {
                    c.b.a.m.f.R5(rssSourceActivity, f.c0.c.j.k("readTextError:", thM14exceptionOrNullimpl.getLocalizedMessage()));
                }
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(FilePicker()) { uri ->\n        kotlin.runCatching {\n            uri?.readText(this)?.let {\n                val dataKey = IntentDataHelp.putData(it)\n                startActivity<ImportRssSourceActivity> {\n                    putExtra(\"dataKey\", dataKey)\n                }\n            }\n        }.onFailure {\n            toastOnUi(\"readTextError:${it.localizedMessage}\")\n        }\n    }");
        this.importDoc = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<d> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.k.d.c.e
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                RssSourceActivity rssSourceActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = RssSourceActivity.f7553g;
                f.c0.c.j.e(rssSourceActivity, "this$0");
                if (uri == null) {
                    return;
                }
                if (c.b.a.m.f.s3(uri)) {
                    DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(rssSourceActivity, uri);
                    if (documentFileFromTreeUri == null) {
                        return;
                    }
                    RssSourceViewModel rssSourceViewModelT0 = rssSourceActivity.T0();
                    RssSourceAdapter rssSourceAdapter = rssSourceActivity.adapter;
                    if (rssSourceAdapter == null) {
                        f.c0.c.j.m("adapter");
                        throw null;
                    }
                    List<RssSource> listA = rssSourceAdapter.A();
                    Objects.requireNonNull(rssSourceViewModelT0);
                    f.c0.c.j.e(listA, "sources");
                    f.c0.c.j.e(documentFileFromTreeUri, "doc");
                    e.a.a.d.u.b bVarA = BaseViewModel.a(rssSourceViewModelT0, null, null, new a0(listA, documentFileFromTreeUri, rssSourceViewModelT0, null), 3, null);
                    bVarA.d(null, new b0(rssSourceViewModelT0, documentFileFromTreeUri, null));
                    e.a.a.d.u.b.b(bVarA, null, new c0(rssSourceViewModelT0, null), 1);
                    return;
                }
                String path = uri.getPath();
                if (path == null) {
                    return;
                }
                RssSourceViewModel rssSourceViewModelT02 = rssSourceActivity.T0();
                RssSourceAdapter rssSourceAdapter2 = rssSourceActivity.adapter;
                if (rssSourceAdapter2 == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                List<RssSource> listA2 = rssSourceAdapter2.A();
                File file = new File(path);
                Objects.requireNonNull(rssSourceViewModelT02);
                f.c0.c.j.e(listA2, "sources");
                f.c0.c.j.e(file, "file");
                e.a.a.d.u.b bVarA2 = BaseViewModel.a(rssSourceViewModelT02, null, null, new x(listA2, file, null), 3, null);
                bVarA2.d(null, new y(rssSourceViewModelT02, file, null));
                e.a.a.d.u.b.b(bVarA2, null, new z(rssSourceViewModelT02, null), 1);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(FilePicker()) { uri ->\n        uri ?: return@registerForActivityResult\n        if (uri.isContentScheme()) {\n            DocumentFile.fromTreeUri(this, uri)?.let {\n                viewModel.exportSelection(adapter.getSelection(), it)\n            }\n        } else {\n            uri.path?.let {\n                viewModel.exportSelection(adapter.getSelection(), File(it))\n            }\n        }\n    }");
        this.exportDir = activityResultLauncherRegisterForActivityResult3;
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void E0(boolean selectAll) {
        if (!selectAll) {
            RssSourceAdapter rssSourceAdapter = this.adapter;
            if (rssSourceAdapter != null) {
                rssSourceAdapter.B();
                return;
            } else {
                j.m("adapter");
                throw null;
            }
        }
        RssSourceAdapter rssSourceAdapter2 = this.adapter;
        if (rssSourceAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        Iterator it = rssSourceAdapter2.items.iterator();
        while (it.hasNext()) {
            rssSourceAdapter2.selected.add((RssSource) it.next());
        }
        rssSourceAdapter2.notifyItemRangeChanged(0, rssSourceAdapter2.getItemCount(), BundleKt.bundleOf(new g("selected", null)));
        rssSourceAdapter2.callBack.b();
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void I0() {
        ((i) f.h0(this, Integer.valueOf(R.string.draw), Integer.valueOf(R.string.sure_del), new r(this))).p();
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_rss_source, (ViewGroup) null, false);
        int i2 = R.id.recycler_view;
        FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView) viewInflate.findViewById(R.id.recycler_view);
        if (fastScrollRecyclerView != null) {
            i2 = R.id.select_action_bar;
            SelectActionBar selectActionBar = (SelectActionBar) viewInflate.findViewById(R.id.select_action_bar);
            if (selectActionBar != null) {
                i2 = R.id.title_bar;
                TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    ActivityRssSourceBinding activityRssSourceBinding = new ActivityRssSourceBinding((LinearLayout) viewInflate, fastScrollRecyclerView, selectActionBar, titleBar);
                    j.d(activityRssSourceBinding, "inflate(layoutInflater)");
                    return activityRssSourceBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        ATH ath = ATH.a;
        ath.b(((ActivityRssSourceBinding) K0()).f6546b);
        ((ActivityRssSourceBinding) K0()).f6546b.addItemDecoration(new VerticalDivider(this));
        this.adapter = new RssSourceAdapter(this, this);
        FastScrollRecyclerView fastScrollRecyclerView = ((ActivityRssSourceBinding) K0()).f6546b;
        RssSourceAdapter rssSourceAdapter = this.adapter;
        if (rssSourceAdapter == null) {
            j.m("adapter");
            throw null;
        }
        fastScrollRecyclerView.setAdapter(rssSourceAdapter);
        RssSourceAdapter rssSourceAdapter2 = this.adapter;
        if (rssSourceAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        DragSelectTouchHelper dragSelectTouchHelper = new DragSelectTouchHelper(rssSourceAdapter2.dragSelectCallback);
        dragSelectTouchHelper.j(16, 50);
        dragSelectTouchHelper.b(((ActivityRssSourceBinding) K0()).f6546b);
        dragSelectTouchHelper.a();
        RssSourceAdapter rssSourceAdapter3 = this.adapter;
        if (rssSourceAdapter3 == null) {
            j.m("adapter");
            throw null;
        }
        ItemTouchCallback itemTouchCallback = new ItemTouchCallback(rssSourceAdapter3);
        itemTouchCallback.isCanDrag = true;
        new ItemTouchHelper(itemTouchCallback).attachToRecyclerView(((ActivityRssSourceBinding) K0()).f6546b);
        SearchView searchView = (SearchView) ((ActivityRssSourceBinding) K0()).f6548d.findViewById(R.id.search_view);
        j.d(searchView, "it");
        ATH.h(ath, searchView, f.R2(this), false, 4);
        searchView.onActionViewExpanded();
        searchView.setQueryHint(getString(R.string.search_rss_source));
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: io.legado.app.ui.rss.source.manage.RssSourceActivity$initSearchView$1$1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(@Nullable String newText) {
                RssSourceActivity rssSourceActivity = this.a;
                int i2 = RssSourceActivity.f7553g;
                rssSourceActivity.U0(newText);
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(@Nullable String query) {
                return false;
            }
        });
        AppDatabaseKt.getAppDb().getRssSourceDao().liveGroup().observe(this, new Observer() { // from class: e.a.a.g.k.d.c.f
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                RssSourceActivity rssSourceActivity = this.a;
                List<String> list = (List) obj;
                int i2 = RssSourceActivity.f7553g;
                f.c0.c.j.e(rssSourceActivity, "this$0");
                rssSourceActivity.groups.clear();
                f.c0.c.j.d(list, "it");
                ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(list, 10));
                for (String str : list) {
                    HashSet<String> hashSet = rssSourceActivity.groups;
                    e.a.a.c.d dVar = e.a.a.c.d.a;
                    arrayList.add(Boolean.valueOf(c.b.a.m.f.T(hashSet, c.b.a.m.f.o5(str, e.a.a.c.d.f5514h, 0, 2))));
                }
                rssSourceActivity.V0();
            }
        });
        U0(null);
        ((ActivityRssSourceBinding) K0()).f6547c.setMainActionText(R.string.delete);
        ((ActivityRssSourceBinding) K0()).f6547c.a(R.menu.rss_source_sel);
        ((ActivityRssSourceBinding) K0()).f6547c.setOnMenuItemClickListener(this);
        ((ActivityRssSourceBinding) K0()).f6547c.setCallBack(this);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.rss_source, menu);
        return super.P0(menu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.menu_add) {
            Intent intent = new Intent(this, (Class<?>) RssSourceEditActivity.class);
            intent.addFlags(268435456);
            startActivity(intent);
        } else if (itemId == R.id.menu_group_manage) {
            GroupManageDialog groupManageDialog = new GroupManageDialog();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            j.d(supportFragmentManager, "supportFragmentManager");
            groupManageDialog.show(supportFragmentManager, "rssGroupManage");
        } else if (itemId != R.id.menu_share_source) {
            switch (itemId) {
                case R.id.menu_import_default /* 2131296844 */:
                    RssSourceViewModel rssSourceViewModelT0 = T0();
                    Objects.requireNonNull(rssSourceViewModelT0);
                    BaseViewModel.a(rssSourceViewModelT0, null, null, new d0(null), 3, null);
                    break;
                case R.id.menu_import_local /* 2131296845 */:
                    this.importDoc.launch(new d(1, null, new String[]{"txt", "json"}, null, 10));
                    break;
                case R.id.menu_import_onLine /* 2131296846 */:
                    e.a.a.h.f fVarA = f.b.a(e.a.a.h.f.a, this, null, 0L, 0, false, 14);
                    String strA = fVarA.a(this.importRecordKey);
                    List listL5 = strA == null ? null : c.b.a.m.f.L5(c.b.a.m.f.n5(strA, ","));
                    if (listL5 == null) {
                        listL5 = new ArrayList();
                    }
                    ((i) c.b.a.m.f.j0(this, Integer.valueOf(R.string.import_on_line), null, new s(this, listL5, fVarA), 2)).p();
                    break;
                case R.id.menu_import_qr /* 2131296847 */:
                    this.qrCodeResult.launch(null);
                    break;
                default:
                    if (item.getGroupId() == R.id.source_group) {
                        ((SearchView) ((ActivityRssSourceBinding) K0()).f6548d.findViewById(R.id.search_view)).setQuery(j.k("group:", item.getTitle()), true);
                    }
                    break;
            }
        } else {
            RssSourceViewModel rssSourceViewModelT02 = T0();
            RssSourceAdapter rssSourceAdapter = this.adapter;
            if (rssSourceAdapter == null) {
                j.m("adapter");
                throw null;
            }
            List<RssSource> listA = rssSourceAdapter.A();
            a aVar = new a();
            Objects.requireNonNull(rssSourceViewModelT02);
            j.e(listA, "sources");
            j.e(aVar, "success");
            e.a.a.d.u.b bVarA = BaseViewModel.a(rssSourceViewModelT02, null, null, new e0(rssSourceViewModelT02, listA, null), 3, null);
            bVarA.d(null, new f0(aVar, null));
            e.a.a.d.u.b.b(bVarA, null, new g0(rssSourceViewModelT02, null), 1);
        }
        return super.Q0(item);
    }

    @NotNull
    public RssSourceViewModel T0() {
        return (RssSourceViewModel) this.viewModel.getValue();
    }

    public final void U0(String searchKey) {
        LiveData<List<RssSource>> liveDataLiveSearch;
        LiveData<List<RssSource>> liveData = this.sourceLiveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        if (searchKey == null || f.h0.k.s(searchKey)) {
            liveDataLiveSearch = AppDatabaseKt.getAppDb().getRssSourceDao().liveAll();
        } else if (f.h0.k.K(searchKey, "group:", false, 2)) {
            String strM = f.h0.k.M(searchKey, "group:", null, 2);
            liveDataLiveSearch = AppDatabaseKt.getAppDb().getRssSourceDao().liveGroupSearch('%' + strM + '%');
        } else {
            RssSourceDao rssSourceDao = AppDatabaseKt.getAppDb().getRssSourceDao();
            StringBuilder sb = new StringBuilder();
            sb.append('%');
            sb.append((Object) searchKey);
            sb.append('%');
            liveDataLiveSearch = rssSourceDao.liveSearch(sb.toString());
        }
        liveDataLiveSearch.observe(this, new Observer() { // from class: e.a.a.g.k.d.c.i
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                RssSourceActivity rssSourceActivity = this.a;
                List list = (List) obj;
                int i2 = RssSourceActivity.f7553g;
                f.c0.c.j.e(rssSourceActivity, "this$0");
                RssSourceAdapter rssSourceAdapter = rssSourceActivity.adapter;
                if (rssSourceAdapter != null) {
                    rssSourceAdapter.y(list, new DiffUtil.ItemCallback<RssSource>() { // from class: io.legado.app.ui.rss.source.manage.RssSourceAdapter$diffItemCallback$1
                        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                        public boolean areContentsTheSame(RssSource rssSource, RssSource rssSource2) {
                            RssSource rssSource3 = rssSource;
                            RssSource rssSource4 = rssSource2;
                            j.e(rssSource3, "oldItem");
                            j.e(rssSource4, "newItem");
                            return j.a(rssSource3.getSourceName(), rssSource4.getSourceName()) && j.a(rssSource3.getSourceGroup(), rssSource4.getSourceGroup()) && rssSource3.getEnabled() == rssSource4.getEnabled();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                        public boolean areItemsTheSame(RssSource rssSource, RssSource rssSource2) {
                            RssSource rssSource3 = rssSource;
                            RssSource rssSource4 = rssSource2;
                            j.e(rssSource3, "oldItem");
                            j.e(rssSource4, "newItem");
                            return j.a(rssSource3.getSourceUrl(), rssSource4.getSourceUrl());
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                        public Object getChangePayload(RssSource rssSource, RssSource rssSource2) {
                            RssSource rssSource3 = rssSource;
                            RssSource rssSource4 = rssSource2;
                            j.e(rssSource3, "oldItem");
                            j.e(rssSource4, "newItem");
                            Bundle bundle = new Bundle();
                            if (!j.a(rssSource3.getSourceName(), rssSource4.getSourceName())) {
                                bundle.putString("name", rssSource4.getSourceName());
                            }
                            if (!j.a(rssSource3.getSourceGroup(), rssSource4.getSourceGroup())) {
                                bundle.putString("group", rssSource4.getSourceGroup());
                            }
                            if (rssSource3.getEnabled() != rssSource4.getEnabled()) {
                                bundle.putBoolean("enabled", rssSource4.getEnabled());
                            }
                            if (bundle.isEmpty()) {
                                return null;
                            }
                            return bundle;
                        }
                    });
                } else {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
            }
        });
        this.sourceLiveData = liveDataLiveSearch;
    }

    public final List<MenuItem> V0() {
        SubMenu subMenu = this.groupMenu;
        if (subMenu == null) {
            return null;
        }
        subMenu.removeGroup(R.id.source_group);
        List listB = f.x.e.B(this.groups, e.a.a.g.k.d.c.j.a);
        ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(listB, 10));
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(subMenu.add(R.id.source_group, 0, 0, (String) it.next()));
        }
        return arrayList;
    }

    @Override // io.legado.app.ui.rss.source.manage.RssSourceAdapter.a
    public void a() {
        RssSourceViewModel rssSourceViewModelT0 = T0();
        Objects.requireNonNull(rssSourceViewModelT0);
        BaseViewModel.a(rssSourceViewModelT0, null, null, new i0(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.rss.source.manage.RssSourceAdapter.a
    public void b() {
        SelectActionBar selectActionBar = ((ActivityRssSourceBinding) K0()).f6547c;
        RssSourceAdapter rssSourceAdapter = this.adapter;
        if (rssSourceAdapter == null) {
            j.m("adapter");
            throw null;
        }
        int size = rssSourceAdapter.A().size();
        RssSourceAdapter rssSourceAdapter2 = this.adapter;
        if (rssSourceAdapter2 != null) {
            selectActionBar.b(size, rssSourceAdapter2.getItemCount());
        } else {
            j.m("adapter");
            throw null;
        }
    }

    @Override // io.legado.app.ui.rss.source.manage.RssSourceAdapter.a
    public void d(@NotNull RssSource source) {
        j.e(source, "source");
        T0().f(source);
    }

    @Override // io.legado.app.ui.rss.source.manage.RssSourceAdapter.a
    public void e0(@NotNull RssSource source) {
        j.e(source, "source");
        T0().e(source);
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void f0() {
        RssSourceAdapter rssSourceAdapter = this.adapter;
        if (rssSourceAdapter != null) {
            rssSourceAdapter.B();
        } else {
            j.m("adapter");
            throw null;
        }
    }

    @Override // io.legado.app.ui.rss.source.manage.RssSourceAdapter.a
    public void g(@NotNull RssSource source) {
        j.e(source, "source");
        T0().h(source);
    }

    @Override // io.legado.app.ui.rss.source.manage.RssSourceAdapter.a
    public void h(@NotNull RssSource source) {
        j.e(source, "source");
        Intent intent = new Intent(this, (Class<?>) RssSourceEditActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("data", source.getSourceUrl());
        startActivity(intent);
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_enable_selection) {
            RssSourceViewModel rssSourceViewModelT0 = T0();
            RssSourceAdapter rssSourceAdapter = this.adapter;
            if (rssSourceAdapter == null) {
                j.m("adapter");
                throw null;
            }
            List<RssSource> listA = rssSourceAdapter.A();
            Objects.requireNonNull(rssSourceViewModelT0);
            j.e(listA, "sources");
            BaseViewModel.a(rssSourceViewModelT0, null, null, new w(listA, null), 3, null);
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_disable_selection) {
            RssSourceViewModel rssSourceViewModelT02 = T0();
            RssSourceAdapter rssSourceAdapter2 = this.adapter;
            if (rssSourceAdapter2 == null) {
                j.m("adapter");
                throw null;
            }
            List<RssSource> listA2 = rssSourceAdapter2.A();
            Objects.requireNonNull(rssSourceViewModelT02);
            j.e(listA2, "sources");
            BaseViewModel.a(rssSourceViewModelT02, null, null, new e.a.a.g.k.d.c.v(listA2, null), 3, null);
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_del_selection) {
            RssSourceViewModel rssSourceViewModelT03 = T0();
            RssSourceAdapter rssSourceAdapter3 = this.adapter;
            if (rssSourceAdapter3 != null) {
                rssSourceViewModelT03.g(rssSourceAdapter3.A());
                return true;
            }
            j.m("adapter");
            throw null;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_export_selection) {
            this.exportDir.launch(null);
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_top_sel) {
            RssSourceViewModel rssSourceViewModelT04 = T0();
            RssSourceAdapter rssSourceAdapter4 = this.adapter;
            if (rssSourceAdapter4 == null) {
                j.m("adapter");
                throw null;
            }
            Object[] array = rssSourceAdapter4.A().toArray(new RssSource[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            RssSource[] rssSourceArr = (RssSource[]) array;
            rssSourceViewModelT04.h((RssSource[]) Arrays.copyOf(rssSourceArr, rssSourceArr.length));
            return true;
        }
        if (numValueOf == null || numValueOf.intValue() != R.id.menu_bottom_sel) {
            return true;
        }
        RssSourceViewModel rssSourceViewModelT05 = T0();
        RssSourceAdapter rssSourceAdapter5 = this.adapter;
        if (rssSourceAdapter5 == null) {
            j.m("adapter");
            throw null;
        }
        Object[] array2 = rssSourceAdapter5.A().toArray(new RssSource[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        RssSource[] rssSourceArr2 = (RssSource[]) array2;
        rssSourceViewModelT05.e((RssSource[]) Arrays.copyOf(rssSourceArr2, rssSourceArr2.length));
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        MenuItem menuItemFindItem;
        SubMenu subMenu = null;
        if (menu != null && (menuItemFindItem = menu.findItem(R.id.menu_group)) != null) {
            subMenu = menuItemFindItem.getSubMenu();
        }
        this.groupMenu = subMenu;
        V0();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // io.legado.app.ui.rss.source.manage.RssSourceAdapter.a
    public void update(@NotNull RssSource... source) {
        j.e(source, "source");
        RssSourceViewModel rssSourceViewModelT0 = T0();
        RssSource[] rssSourceArr = (RssSource[]) Arrays.copyOf(source, source.length);
        Objects.requireNonNull(rssSourceViewModelT0);
        j.e(rssSourceArr, "rssSource");
        BaseViewModel.a(rssSourceViewModelT0, null, null, new j0(rssSourceArr, null), 3, null);
    }
}
