package io.legado.app.ui.replace;

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
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SearchView;
import androidx.core.os.BundleKt;
import androidx.documentfile.provider.DocumentFile;
import androidx.media2.session.MediaConstants;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.d.u.b;
import e.a.a.e.a.i;
import e.a.a.f.s.k;
import e.a.a.g.f.d;
import e.a.a.g.j.d0;
import e.a.a.g.j.e0;
import e.a.a.g.j.g0;
import e.a.a.g.j.h0;
import e.a.a.g.j.q;
import e.a.a.g.j.r;
import e.a.a.g.j.u;
import e.a.a.g.j.w;
import e.a.a.h.f;
import f.c0.b.p;
import f.c0.c.j;
import f.e;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.ReplaceRuleDao;
import io.legado.app.data.entities.ReplaceRule;
import io.legado.app.databinding.ActivityReplaceRuleBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.association.ImportReplaceRuleActivity;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.qrcode.QrCodeResult;
import io.legado.app.ui.replace.ReplaceRuleActivity;
import io.legado.app.ui.replace.ReplaceRuleAdapter;
import io.legado.app.ui.replace.ReplaceRuleViewModel;
import io.legado.app.ui.replace.edit.ReplaceEditActivity;
import io.legado.app.ui.widget.SelectActionBar;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.recycler.DragSelectTouchHelper;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.wenyuange.app.release.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ReplaceRuleActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0007¢\u0006\u0004\bc\u0010\u000eJ\u001b\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u000eJ\u000f\u0010\u001d\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u000eJ\u0017\u0010 \u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b\"\u0010!J\u0019\u0010$\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b'\u0010%J\u000f\u0010(\u001a\u00020\nH\u0014¢\u0006\u0004\b(\u0010\u000eJ\u000f\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010\u000eJ#\u0010-\u001a\u00020\n2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0*\"\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\n2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\n2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b1\u00100J\u0017\u00102\u001a\u00020\n2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b2\u00100J\u0017\u00103\u001a\u00020\n2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b3\u00100J\u000f\u00104\u001a\u00020\nH\u0016¢\u0006\u0004\b4\u0010\u000eR\u0016\u00107\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bD\u0010ER$\u0010L\u001a\u0010\u0012\f\u0012\n I*\u0004\u0018\u00010H0H0G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010N\u001a\u0010\u0012\f\u0012\n I*\u0004\u0018\u00010\n0\n0G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010KR$\u0010P\u001a\u0010\u0012\f\u0012\n I*\u0004\u0018\u00010H0H0G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010KR$\u0010S\u001a\u0010\u0012\f\u0012\n I*\u0004\u0018\u00010Q0Q0G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010KR$\u0010X\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0U\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u001d\u0010]\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R&\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\b0^j\b\u0012\u0004\u0012\u00020\b`_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010a¨\u0006d"}, d2 = {"Lio/legado/app/ui/replace/ReplaceRuleActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityReplaceRuleBinding;", "Lio/legado/app/ui/replace/ReplaceRuleViewModel;", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "Lio/legado/app/ui/widget/SelectActionBar$a;", "Lio/legado/app/ui/replace/ReplaceRuleAdapter$a;", "", "searchKey", "Lf/v;", "U0", "(Ljava/lang/String;)V", "V0", "()V", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "onPrepareOptionsMenu", "selectAll", "E0", "(Z)V", "f0", "I0", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "onMenuItemClick", "newText", "onQueryTextChange", "(Ljava/lang/String;)Z", MediaConstants.MEDIA_URI_QUERY_QUERY, "onQueryTextSubmit", "onDestroy", "b", "", "Lio/legado/app/data/entities/ReplaceRule;", "rule", "update", "([Lio/legado/app/data/entities/ReplaceRule;)V", "g0", "(Lio/legado/app/data/entities/ReplaceRule;)V", OptRuntime.GeneratorState.resumptionPoint_TYPE, "q0", "J0", ai.at, "o", "Z", "dataInit", "Lio/legado/app/ui/replace/ReplaceRuleAdapter;", "j", "Lio/legado/app/ui/replace/ReplaceRuleAdapter;", "adapter", ai.aA, "Ljava/lang/String;", "importRecordKey", "Landroid/view/SubMenu;", "m", "Landroid/view/SubMenu;", "groupMenu", "Landroidx/appcompat/widget/SearchView;", "k", "Landroidx/appcompat/widget/SearchView;", "searchView", "Landroidx/activity/result/ActivityResultLauncher;", "Le/a/a/g/f/d;", "kotlin.jvm.PlatformType", ai.az, "Landroidx/activity/result/ActivityResultLauncher;", "exportDir", "p", "qrCodeResult", "r", "importDoc", "Landroid/content/Intent;", "q", "editActivity", "Landroidx/lifecycle/LiveData;", "", "n", "Landroidx/lifecycle/LiveData;", "replaceRuleLiveData", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/replace/ReplaceRuleViewModel;", "viewModel", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", Constants.LANDSCAPE, "Ljava/util/HashSet;", "groups", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReplaceRuleActivity extends VMBaseActivity<ActivityReplaceRuleBinding, ReplaceRuleViewModel> implements SearchView.OnQueryTextListener, PopupMenu.OnMenuItemClickListener, SelectActionBar.a, ReplaceRuleAdapter.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7472g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String importRecordKey;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public ReplaceRuleAdapter adapter;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public SearchView searchView;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public HashSet<String> groups;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public SubMenu groupMenu;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @Nullable
    public LiveData<List<ReplaceRule>> replaceRuleLiveData;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public boolean dataInit;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<v> qrCodeResult;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Intent> editActivity;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<d> importDoc;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<d> exportDir;

    /* JADX INFO: compiled from: ReplaceRuleActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.replace.ReplaceRuleActivity$onDestroy$1", f = "ReplaceRuleActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, f.z.d<? super v>, Object> {
        public int label;

        public a(f.z.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            k kVar = k.a;
            e.a.a.d.k kVar2 = k.f5678d;
            if (kVar2 == null) {
                return null;
            }
            kVar2.c();
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.a<ViewModelProvider.Factory> {
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
    public static final class c extends f.c0.c.k implements f.c0.b.a<ViewModelStore> {
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

    public ReplaceRuleActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(ReplaceRuleViewModel.class), new c(this), new b(this));
        this.importRecordKey = "replaceRuleRecordKey";
        this.groups = new HashSet<>();
        ActivityResultLauncher<v> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new QrCodeResult(), new ActivityResultCallback() { // from class: e.a.a.g.j.d
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ReplaceRuleActivity replaceRuleActivity = this.a;
                String str = (String) obj;
                int i2 = ReplaceRuleActivity.f7472g;
                f.c0.c.j.e(replaceRuleActivity, "this$0");
                if (str == null) {
                    return;
                }
                Intent intent = new Intent(replaceRuleActivity, (Class<?>) ImportReplaceRuleActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("source", str);
                replaceRuleActivity.startActivity(intent);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(QrCodeResult()) {\n        it ?: return@registerForActivityResult\n        startActivity<ImportReplaceRuleActivity> {\n            putExtra(\"source\", it)\n        }\n    }");
        this.qrCodeResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.a.a.g.j.g
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ReplaceRuleActivity replaceRuleActivity = this.a;
                int i2 = ReplaceRuleActivity.f7472g;
                f.c0.c.j.e(replaceRuleActivity, "this$0");
                if (((ActivityResult) obj).getResultCode() == -1) {
                    replaceRuleActivity.setResult(-1);
                }
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {\n            if (it.resultCode == RESULT_OK) {\n                setResult(RESULT_OK)\n            }\n        }");
        this.editActivity = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<d> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.j.f
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Object objM11constructorimpl;
                ReplaceRuleActivity replaceRuleActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = ReplaceRuleActivity.f7472g;
                f.c0.c.j.e(replaceRuleActivity, "this$0");
                f.v vVar = null;
                if (uri != null) {
                    try {
                        String strB4 = c.b.a.m.f.B4(uri, replaceRuleActivity);
                        if (strB4 != null) {
                            String strB = e.a.a.d.o.b(e.a.a.d.o.a, strB4, null, 2);
                            Intent intent = new Intent(replaceRuleActivity, (Class<?>) ImportReplaceRuleActivity.class);
                            intent.addFlags(268435456);
                            intent.putExtra("dataKey", strB);
                            replaceRuleActivity.startActivity(intent);
                            vVar = f.v.a;
                        }
                    } catch (Throwable th) {
                        objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
                    }
                }
                objM11constructorimpl = f.h.m11constructorimpl(vVar);
                Throwable thM14exceptionOrNullimpl = f.h.m14exceptionOrNullimpl(objM11constructorimpl);
                if (thM14exceptionOrNullimpl != null) {
                    c.b.a.m.f.R5(replaceRuleActivity, f.c0.c.j.k("readTextError:", thM14exceptionOrNullimpl.getLocalizedMessage()));
                }
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(FilePicker()) { uri ->\n        kotlin.runCatching {\n            uri?.readText(this)?.let {\n                val dataKey = IntentDataHelp.putData(it)\n                startActivity<ImportReplaceRuleActivity> {\n                    putExtra(\"dataKey\", dataKey)\n                }\n            }\n        }.onFailure {\n            toastOnUi(\"readTextError:${it.localizedMessage}\")\n        }\n    }");
        this.importDoc = activityResultLauncherRegisterForActivityResult3;
        ActivityResultLauncher<d> activityResultLauncherRegisterForActivityResult4 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.j.i
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ReplaceRuleActivity replaceRuleActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = ReplaceRuleActivity.f7472g;
                f.c0.c.j.e(replaceRuleActivity, "this$0");
                if (uri == null) {
                    return;
                }
                if (c.b.a.m.f.s3(uri)) {
                    DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(replaceRuleActivity, uri);
                    if (documentFileFromTreeUri == null) {
                        return;
                    }
                    ReplaceRuleViewModel replaceRuleViewModelT0 = replaceRuleActivity.T0();
                    ReplaceRuleAdapter replaceRuleAdapter = replaceRuleActivity.adapter;
                    if (replaceRuleAdapter == null) {
                        f.c0.c.j.m("adapter");
                        throw null;
                    }
                    LinkedHashSet<ReplaceRule> linkedHashSetA = replaceRuleAdapter.A();
                    Objects.requireNonNull(replaceRuleViewModelT0);
                    f.c0.c.j.e(linkedHashSetA, "sources");
                    f.c0.c.j.e(documentFileFromTreeUri, "doc");
                    e.a.a.d.u.b bVarA = BaseViewModel.a(replaceRuleViewModelT0, null, null, new a0(linkedHashSetA, documentFileFromTreeUri, replaceRuleViewModelT0, null), 3, null);
                    bVarA.d(null, new b0(replaceRuleViewModelT0, documentFileFromTreeUri, null));
                    e.a.a.d.u.b.b(bVarA, null, new c0(replaceRuleViewModelT0, null), 1);
                    return;
                }
                String path = uri.getPath();
                if (path == null) {
                    return;
                }
                ReplaceRuleViewModel replaceRuleViewModelT02 = replaceRuleActivity.T0();
                ReplaceRuleAdapter replaceRuleAdapter2 = replaceRuleActivity.adapter;
                if (replaceRuleAdapter2 == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                LinkedHashSet<ReplaceRule> linkedHashSetA2 = replaceRuleAdapter2.A();
                File file = new File(path);
                Objects.requireNonNull(replaceRuleViewModelT02);
                f.c0.c.j.e(linkedHashSetA2, "sources");
                f.c0.c.j.e(file, "file");
                e.a.a.d.u.b bVarA2 = BaseViewModel.a(replaceRuleViewModelT02, null, null, new x(linkedHashSetA2, file, null), 3, null);
                bVarA2.d(null, new y(replaceRuleViewModelT02, file, null));
                e.a.a.d.u.b.b(bVarA2, null, new z(replaceRuleViewModelT02, null), 1);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult4, "registerForActivityResult(FilePicker()) { uri ->\n        uri ?: return@registerForActivityResult\n        if (uri.isContentScheme()) {\n            DocumentFile.fromTreeUri(this, uri)?.let {\n                viewModel.exportSelection(adapter.getSelection(), it)\n            }\n        } else {\n            uri.path?.let {\n                viewModel.exportSelection(adapter.getSelection(), File(it))\n            }\n        }\n    }");
        this.exportDir = activityResultLauncherRegisterForActivityResult4;
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void E0(boolean selectAll) {
        if (!selectAll) {
            ReplaceRuleAdapter replaceRuleAdapter = this.adapter;
            if (replaceRuleAdapter != null) {
                replaceRuleAdapter.B();
                return;
            } else {
                j.m("adapter");
                throw null;
            }
        }
        ReplaceRuleAdapter replaceRuleAdapter2 = this.adapter;
        if (replaceRuleAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        Iterator it = replaceRuleAdapter2.items.iterator();
        while (it.hasNext()) {
            replaceRuleAdapter2.selected.add((ReplaceRule) it.next());
        }
        replaceRuleAdapter2.notifyItemRangeChanged(0, replaceRuleAdapter2.getItemCount(), BundleKt.bundleOf(new f.g("selected", null)));
        replaceRuleAdapter2.callBack.b();
    }

    @Override // io.legado.app.ui.replace.ReplaceRuleAdapter.a
    public void I(@NotNull ReplaceRule rule) {
        j.e(rule, "rule");
        setResult(-1);
        ActivityResultLauncher<Intent> activityResultLauncher = this.editActivity;
        long id = rule.getId();
        j.e(this, com.umeng.analytics.pro.c.R);
        Intent intent = new Intent(this, (Class<?>) ReplaceEditActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("pattern", (String) null);
        intent.putExtra("isRegex", false);
        intent.putExtra("scope", (String) null);
        activityResultLauncher.launch(intent);
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void I0() {
        ((i) f.h0(this, Integer.valueOf(R.string.draw), Integer.valueOf(R.string.sure_del), new q(this))).p();
    }

    @Override // io.legado.app.ui.replace.ReplaceRuleAdapter.a
    public void J0(@NotNull ReplaceRule rule) {
        j.e(rule, "rule");
        setResult(-1);
        ReplaceRuleViewModel replaceRuleViewModelT0 = T0();
        Objects.requireNonNull(replaceRuleViewModelT0);
        j.e(rule, "rule");
        BaseViewModel.a(replaceRuleViewModelT0, null, null, new d0(rule, null), 3, null);
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_replace_rule, (ViewGroup) null, false);
        int i2 = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
        if (recyclerView != null) {
            i2 = R.id.select_action_bar;
            SelectActionBar selectActionBar = (SelectActionBar) viewInflate.findViewById(R.id.select_action_bar);
            if (selectActionBar != null) {
                i2 = R.id.title_bar;
                TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    ActivityReplaceRuleBinding activityReplaceRuleBinding = new ActivityReplaceRuleBinding((LinearLayout) viewInflate, recyclerView, selectActionBar, titleBar);
                    j.d(activityReplaceRuleBinding, "inflate(layoutInflater)");
                    return activityReplaceRuleBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        View viewFindViewById = ((ActivityReplaceRuleBinding) K0()).f6537d.findViewById(R.id.search_view);
        j.d(viewFindViewById, "binding.titleBar.findViewById(R.id.search_view)");
        this.searchView = (SearchView) viewFindViewById;
        ATH ath = ATH.a;
        ath.b(((ActivityReplaceRuleBinding) K0()).f6535b);
        ((ActivityReplaceRuleBinding) K0()).f6535b.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new ReplaceRuleAdapter(this, this);
        RecyclerView recyclerView = ((ActivityReplaceRuleBinding) K0()).f6535b;
        ReplaceRuleAdapter replaceRuleAdapter = this.adapter;
        if (replaceRuleAdapter == null) {
            j.m("adapter");
            throw null;
        }
        recyclerView.setAdapter(replaceRuleAdapter);
        ((ActivityReplaceRuleBinding) K0()).f6535b.addItemDecoration(new VerticalDivider(this));
        ReplaceRuleAdapter replaceRuleAdapter2 = this.adapter;
        if (replaceRuleAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        ItemTouchCallback itemTouchCallback = new ItemTouchCallback(replaceRuleAdapter2);
        itemTouchCallback.isCanDrag = true;
        ReplaceRuleAdapter replaceRuleAdapter3 = this.adapter;
        if (replaceRuleAdapter3 == null) {
            j.m("adapter");
            throw null;
        }
        DragSelectTouchHelper dragSelectTouchHelper = new DragSelectTouchHelper(replaceRuleAdapter3.dragSelectCallback);
        dragSelectTouchHelper.j(16, 50);
        dragSelectTouchHelper.b(((ActivityReplaceRuleBinding) K0()).f6535b);
        dragSelectTouchHelper.a();
        new ItemTouchHelper(itemTouchCallback).attachToRecyclerView(((ActivityReplaceRuleBinding) K0()).f6535b);
        SearchView searchView = this.searchView;
        if (searchView == null) {
            j.m("searchView");
            throw null;
        }
        ATH.h(ath, searchView, f.R2(this), false, 4);
        SearchView searchView2 = this.searchView;
        if (searchView2 == null) {
            j.m("searchView");
            throw null;
        }
        searchView2.onActionViewExpanded();
        SearchView searchView3 = this.searchView;
        if (searchView3 == null) {
            j.m("searchView");
            throw null;
        }
        searchView3.setQueryHint(getString(R.string.replace_purify_search));
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
        searchView5.setOnQueryTextListener(this);
        ((ActivityReplaceRuleBinding) K0()).f6536c.setMainActionText(R.string.delete);
        ((ActivityReplaceRuleBinding) K0()).f6536c.a(R.menu.replace_rule_sel);
        ((ActivityReplaceRuleBinding) K0()).f6536c.setOnMenuItemClickListener(this);
        ((ActivityReplaceRuleBinding) K0()).f6536c.setCallBack(this);
        U0(null);
        AppDatabaseKt.getAppDb().getReplaceRuleDao().liveGroup().observe(this, new Observer() { // from class: e.a.a.g.j.e
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ReplaceRuleActivity replaceRuleActivity = this.a;
                List<String> list = (List) obj;
                int i2 = ReplaceRuleActivity.f7472g;
                f.c0.c.j.e(replaceRuleActivity, "this$0");
                replaceRuleActivity.groups.clear();
                f.c0.c.j.d(list, "it");
                ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(list, 10));
                for (String str : list) {
                    HashSet<String> hashSet = replaceRuleActivity.groups;
                    e.a.a.c.d dVar = e.a.a.c.d.a;
                    arrayList.add(Boolean.valueOf(c.b.a.m.f.T(hashSet, c.b.a.m.f.o5(str, e.a.a.c.d.f5514h, 0, 2))));
                }
                replaceRuleActivity.V0();
            }
        });
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.replace_rule, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        switch (item.getItemId()) {
            case R.id.menu_add_replace_rule /* 2131296783 */:
                ActivityResultLauncher<Intent> activityResultLauncher = this.editActivity;
                long j2 = (2 & 30) != 0 ? -1L : 0L;
                int i2 = 30 & 4;
                int i3 = 30 & 8;
                int i4 = 30 & 16;
                j.e(this, com.umeng.analytics.pro.c.R);
                Intent intent = new Intent(this, (Class<?>) ReplaceEditActivity.class);
                intent.putExtra("id", j2);
                intent.putExtra("pattern", (String) null);
                intent.putExtra("isRegex", false);
                intent.putExtra("scope", (String) null);
                activityResultLauncher.launch(intent);
                break;
            case R.id.menu_del_selection /* 2131296811 */:
                ReplaceRuleViewModel replaceRuleViewModelT0 = T0();
                ReplaceRuleAdapter replaceRuleAdapter = this.adapter;
                if (replaceRuleAdapter == null) {
                    j.m("adapter");
                    throw null;
                }
                replaceRuleViewModelT0.e(replaceRuleAdapter.A());
                break;
                break;
            case R.id.menu_group_manage /* 2131296835 */:
                new GroupManageDialog().show(getSupportFragmentManager(), "groupManage");
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
                ((i) c.b.a.m.f.j0(this, Integer.valueOf(R.string.import_replace_rule_on_line), null, new r(this, listL5, fVarA), 2)).p();
                break;
            case R.id.menu_import_qr /* 2131296847 */:
                this.qrCodeResult.launch(null);
                break;
            default:
                if (item.getGroupId() == R.id.replace_group) {
                    SearchView searchView = this.searchView;
                    if (searchView == null) {
                        j.m("searchView");
                        throw null;
                    }
                    searchView.setQuery(j.k("group:", item.getTitle()), true);
                }
                break;
        }
        return super.Q0(item);
    }

    @NotNull
    public ReplaceRuleViewModel T0() {
        return (ReplaceRuleViewModel) this.viewModel.getValue();
    }

    public final void U0(String searchKey) {
        LiveData<List<ReplaceRule>> liveDataLiveDataSearch;
        this.dataInit = false;
        LiveData<List<ReplaceRule>> liveData = this.replaceRuleLiveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        if (searchKey == null || searchKey.length() == 0) {
            liveDataLiveDataSearch = AppDatabaseKt.getAppDb().getReplaceRuleDao().liveDataAll();
        } else if (f.h0.k.K(searchKey, "group:", false, 2)) {
            String strM = f.h0.k.M(searchKey, "group:", null, 2);
            liveDataLiveDataSearch = AppDatabaseKt.getAppDb().getReplaceRuleDao().liveDataGroupSearch('%' + strM + '%');
        } else {
            ReplaceRuleDao replaceRuleDao = AppDatabaseKt.getAppDb().getReplaceRuleDao();
            StringBuilder sb = new StringBuilder();
            sb.append('%');
            sb.append((Object) searchKey);
            sb.append('%');
            liveDataLiveDataSearch = replaceRuleDao.liveDataSearch(sb.toString());
        }
        liveDataLiveDataSearch.observe(this, new Observer() { // from class: e.a.a.g.j.h
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ReplaceRuleActivity replaceRuleActivity = this.a;
                List list = (List) obj;
                int i2 = ReplaceRuleActivity.f7472g;
                f.c0.c.j.e(replaceRuleActivity, "this$0");
                if (replaceRuleActivity.dataInit) {
                    replaceRuleActivity.setResult(-1);
                }
                ReplaceRuleAdapter replaceRuleAdapter = replaceRuleActivity.adapter;
                if (replaceRuleAdapter == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                replaceRuleAdapter.y(list, replaceRuleAdapter.diffItemCallBack);
                replaceRuleActivity.dataInit = true;
            }
        });
        this.replaceRuleLiveData = liveDataLiveDataSearch;
    }

    public final void V0() {
        SubMenu subMenu = this.groupMenu;
        if (subMenu != null) {
            subMenu.removeGroup(R.id.replace_group);
        }
        HashSet<String> hashSet = this.groups;
        ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(hashSet, 10));
        for (String str : hashSet) {
            SubMenu subMenu2 = this.groupMenu;
            arrayList.add(subMenu2 == null ? null : subMenu2.add(R.id.replace_group, 0, 0, str));
        }
    }

    @Override // io.legado.app.ui.replace.ReplaceRuleAdapter.a
    public void a() {
        setResult(-1);
        ReplaceRuleViewModel replaceRuleViewModelT0 = T0();
        Objects.requireNonNull(replaceRuleViewModelT0);
        BaseViewModel.a(replaceRuleViewModelT0, null, null, new g0(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.replace.ReplaceRuleAdapter.a
    public void b() {
        SelectActionBar selectActionBar = ((ActivityReplaceRuleBinding) K0()).f6536c;
        ReplaceRuleAdapter replaceRuleAdapter = this.adapter;
        if (replaceRuleAdapter == null) {
            j.m("adapter");
            throw null;
        }
        int size = replaceRuleAdapter.A().size();
        ReplaceRuleAdapter replaceRuleAdapter2 = this.adapter;
        if (replaceRuleAdapter2 != null) {
            selectActionBar.b(size, replaceRuleAdapter2.getItemCount());
        } else {
            j.m("adapter");
            throw null;
        }
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void f0() {
        ReplaceRuleAdapter replaceRuleAdapter = this.adapter;
        if (replaceRuleAdapter != null) {
            replaceRuleAdapter.B();
        } else {
            j.m("adapter");
            throw null;
        }
    }

    @Override // io.legado.app.ui.replace.ReplaceRuleAdapter.a
    public void g0(@NotNull ReplaceRule rule) {
        j.e(rule, "rule");
        setResult(-1);
        ReplaceRuleViewModel replaceRuleViewModelT0 = T0();
        Objects.requireNonNull(replaceRuleViewModelT0);
        j.e(rule, "rule");
        BaseViewModel.a(replaceRuleViewModelT0, null, null, new u(rule, null), 3, null);
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b.C0148b.b(e.a.a.d.u.b.a, null, null, new a(null), 3);
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_enable_selection) {
            ReplaceRuleViewModel replaceRuleViewModelT0 = T0();
            ReplaceRuleAdapter replaceRuleAdapter = this.adapter;
            if (replaceRuleAdapter == null) {
                j.m("adapter");
                throw null;
            }
            LinkedHashSet<ReplaceRule> linkedHashSetA = replaceRuleAdapter.A();
            Objects.requireNonNull(replaceRuleViewModelT0);
            j.e(linkedHashSetA, "rules");
            BaseViewModel.a(replaceRuleViewModelT0, null, null, new w(linkedHashSetA, null), 3, null);
            return false;
        }
        if (numValueOf == null || numValueOf.intValue() != R.id.menu_disable_selection) {
            if (numValueOf == null || numValueOf.intValue() != R.id.menu_export_selection) {
                return false;
            }
            this.exportDir.launch(null);
            return false;
        }
        ReplaceRuleViewModel replaceRuleViewModelT02 = T0();
        ReplaceRuleAdapter replaceRuleAdapter2 = this.adapter;
        if (replaceRuleAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        LinkedHashSet<ReplaceRule> linkedHashSetA2 = replaceRuleAdapter2.A();
        Objects.requireNonNull(replaceRuleViewModelT02);
        j.e(linkedHashSetA2, "rules");
        BaseViewModel.a(replaceRuleViewModelT02, null, null, new e.a.a.g.j.v(linkedHashSetA2, null), 3, null);
        return false;
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

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(@Nullable String newText) {
        U0(newText);
        return false;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(@Nullable String query) {
        return false;
    }

    @Override // io.legado.app.ui.replace.ReplaceRuleAdapter.a
    public void q0(@NotNull ReplaceRule rule) {
        j.e(rule, "rule");
        setResult(-1);
        ReplaceRuleViewModel replaceRuleViewModelT0 = T0();
        Objects.requireNonNull(replaceRuleViewModelT0);
        j.e(rule, "rule");
        BaseViewModel.a(replaceRuleViewModelT0, null, null, new e0(rule, null), 3, null);
    }

    @Override // io.legado.app.ui.replace.ReplaceRuleAdapter.a
    public void update(@NotNull ReplaceRule... rule) {
        j.e(rule, "rule");
        setResult(-1);
        ReplaceRuleViewModel replaceRuleViewModelT0 = T0();
        ReplaceRule[] replaceRuleArr = (ReplaceRule[]) Arrays.copyOf(rule, rule.length);
        Objects.requireNonNull(replaceRuleViewModelT0);
        j.e(replaceRuleArr, "rule");
        BaseViewModel.a(replaceRuleViewModelT0, null, null, new h0(replaceRuleArr, null), 3, null);
    }
}
