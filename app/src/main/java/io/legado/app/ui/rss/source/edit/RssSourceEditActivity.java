package io.legado.app.ui.rss.source.edit;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.d.q;
import e.a.a.e.a.h;
import e.a.a.g.k.d.b.i;
import e.a.a.h.n;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import g.b.g2.m;
import g.b.k0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.entities.RssSource;
import io.legado.app.databinding.ActivityRssSourceEditBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.qrcode.QrCodeResult;
import io.legado.app.ui.rss.source.debug.RssSourceDebugActivity;
import io.legado.app.ui.rss.source.edit.RssSourceEditActivity;
import io.legado.app.ui.rss.source.edit.RssSourceEditViewModel;
import io.legado.app.ui.widget.KeyboardToolPop;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.wenyuange.app.release.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: RssSourceEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\bC\u0010\u0016J\u001b\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001d\u0010\u0016J\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b&\u0010\u0014J\u000f\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\u0016R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001d\u00100\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R&\u00106\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`38\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R$\u0010>\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010\b0\b0:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lio/legado/app/ui/rss/source/edit/RssSourceEditActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityRssSourceEditBinding;", "Lio/legado/app/ui/rss/source/edit/RssSourceEditViewModel;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Lio/legado/app/ui/widget/KeyboardToolPop$a;", "Lio/legado/app/data/entities/RssSource;", "rssSource", "Lf/v;", "Z0", "(Lio/legado/app/data/entities/RssSource;)V", "V0", "()Lio/legado/app/data/entities/RssSource;", "source", "", "U0", "(Lio/legado/app/data/entities/RssSource;)Z", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "X0", "(Ljava/lang/String;)V", "Y0", "()V", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "onPostCreate", "finish", "onDestroy", "Landroid/view/Menu;", "menu", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "B", "onGlobalLayout", "Lio/legado/app/ui/rss/source/edit/RssSourceEditAdapter;", "j", "Lio/legado/app/ui/rss/source/edit/RssSourceEditAdapter;", "adapter", "m", "Lf/e;", "W0", "()Lio/legado/app/ui/rss/source/edit/RssSourceEditViewModel;", "viewModel", "Ljava/util/ArrayList;", "Le/a/a/g/k/d/b/b;", "Lkotlin/collections/ArrayList;", "k", "Ljava/util/ArrayList;", "sourceEntities", ai.aA, "Z", "mIsSoftKeyBoardShowing", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", Constants.LANDSCAPE, "Landroidx/activity/result/ActivityResultLauncher;", "qrCodeResult", "Landroid/widget/PopupWindow;", "h", "Landroid/widget/PopupWindow;", "mSoftKeyboardTool", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssSourceEditActivity extends VMBaseActivity<ActivityRssSourceEditBinding, RssSourceEditViewModel> implements ViewTreeObserver.OnGlobalLayoutListener, KeyboardToolPop.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7540g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public PopupWindow mSoftKeyboardTool;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean mIsSoftKeyBoardShowing;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final RssSourceEditAdapter adapter;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<e.a.a.g.k.d.b.b> sourceEntities;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<v> qrCodeResult;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: compiled from: RssSourceEditActivity.kt */
    public static final class a extends k implements l<h<? extends DialogInterface>, v> {

        /* JADX INFO: renamed from: io.legado.app.ui.rss.source.edit.RssSourceEditActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RssSourceEditActivity.kt */
        public static final class C0212a extends k implements l<DialogInterface, v> {
            public final /* synthetic */ RssSourceEditActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0212a(RssSourceEditActivity rssSourceEditActivity) {
                super(1);
                this.this$0 = rssSourceEditActivity;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                j.e(dialogInterface, "it");
                RssSourceEditActivity.super.finish();
            }
        }

        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull h<? extends DialogInterface> hVar) {
            j.e(hVar, "$this$alert");
            hVar.g(R.string.exit_no_save);
            hVar.c(R.string.yes, null);
            hVar.e(R.string.no, new C0212a(RssSourceEditActivity.this));
        }
    }

    /* JADX INFO: compiled from: RssSourceEditActivity.kt */
    public static final class b extends k implements f.c0.b.a<v> {
        public b() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            RssSourceEditActivity rssSourceEditActivity = RssSourceEditActivity.this;
            int i2 = RssSourceEditActivity.f7540g;
            rssSourceEditActivity.Z0(rssSourceEditActivity.W0().rssSource);
        }
    }

    /* JADX INFO: compiled from: RssSourceEditActivity.kt */
    public static final class c extends k implements f.c0.b.a<v> {
        public c() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            RssSourceEditActivity.this.setResult(-1);
            RssSourceEditActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: RssSourceEditActivity.kt */
    public static final class d extends k implements f.c0.b.a<v> {
        public final /* synthetic */ RssSource $source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(RssSource rssSource) {
            super(0);
            this.$source = rssSource;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            RssSourceEditActivity rssSourceEditActivity = RssSourceEditActivity.this;
            RssSource rssSource = this.$source;
            Intent intent = new Intent(rssSourceEditActivity, (Class<?>) RssSourceDebugActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("key", rssSource.getSourceUrl());
            rssSourceEditActivity.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: RssSourceEditActivity.kt */
    public static final class e extends k implements l<RssSource, v> {
        public e() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(RssSource rssSource) {
            invoke2(rssSource);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull RssSource rssSource) {
            j.e(rssSource, "it");
            RssSourceEditActivity rssSourceEditActivity = RssSourceEditActivity.this;
            int i2 = RssSourceEditActivity.f7540g;
            rssSourceEditActivity.Z0(rssSource);
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

    public RssSourceEditActivity() {
        super(false, null, null, false, false, 30);
        this.adapter = new RssSourceEditAdapter();
        this.sourceEntities = new ArrayList<>();
        ActivityResultLauncher<v> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new QrCodeResult(), new ActivityResultCallback() { // from class: e.a.a.g.k.d.b.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                RssSourceEditActivity rssSourceEditActivity = this.a;
                String str = (String) obj;
                int i2 = RssSourceEditActivity.f7540g;
                f.c0.c.j.e(rssSourceEditActivity, "this$0");
                if (str == null) {
                    return;
                }
                RssSourceEditViewModel rssSourceEditViewModelW0 = rssSourceEditActivity.W0();
                c cVar = new c(rssSourceEditActivity);
                Objects.requireNonNull(rssSourceEditViewModelW0);
                f.c0.c.j.e(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                f.c0.c.j.e(cVar, "finally");
                e.a.a.d.u.b.b(BaseViewModel.a(rssSourceEditViewModelW0, null, null, new g(str, cVar, null), 3, null), null, new h(rssSourceEditViewModelW0, null), 1);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(QrCodeResult()) {\n        it?.let {\n            viewModel.importSource(it) { source: RssSource ->\n                upRecyclerView(source)\n            }\n        }\n    }");
        this.qrCodeResult = activityResultLauncherRegisterForActivityResult;
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(RssSourceEditViewModel.class), new g(this), new f(this));
    }

    @Override // io.legado.app.ui.widget.KeyboardToolPop.a
    public void B(@NotNull String text) {
        j.e(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        e.a.a.c.c cVar = e.a.a.c.c.a;
        if (!j.a(text, e.a.a.c.c.b().get(0))) {
            X0(text);
        } else {
            c.b.a.m.f.Z4(this, getString(R.string.help), f.x.e.a("插入URL参数", "订阅源教程", "正则教程"), new e.a.a.g.k.d.b.d(this));
        }
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_rss_source_edit, (ViewGroup) null, false);
        int i2 = R.id.cb_enable_base_url;
        ATECheckBox aTECheckBox = (ATECheckBox) viewInflate.findViewById(R.id.cb_enable_base_url);
        if (aTECheckBox != null) {
            i2 = R.id.cb_enable_js;
            ATECheckBox aTECheckBox2 = (ATECheckBox) viewInflate.findViewById(R.id.cb_enable_js);
            if (aTECheckBox2 != null) {
                i2 = R.id.cb_is_enable;
                ATECheckBox aTECheckBox3 = (ATECheckBox) viewInflate.findViewById(R.id.cb_is_enable);
                if (aTECheckBox3 != null) {
                    i2 = R.id.cb_single_url;
                    ATECheckBox aTECheckBox4 = (ATECheckBox) viewInflate.findViewById(R.id.cb_single_url);
                    if (aTECheckBox4 != null) {
                        i2 = R.id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
                        if (recyclerView != null) {
                            i2 = R.id.title_bar;
                            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                            if (titleBar != null) {
                                ActivityRssSourceEditBinding activityRssSourceEditBinding = new ActivityRssSourceEditBinding((LinearLayout) viewInflate, aTECheckBox, aTECheckBox2, aTECheckBox3, aTECheckBox4, recyclerView, titleBar);
                                j.d(activityRssSourceEditBinding, "inflate(layoutInflater)");
                                return activityRssSourceEditBinding;
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
        ATH.a.b(((ActivityRssSourceEditBinding) K0()).f6553f);
        e.a.a.c.c cVar = e.a.a.c.c.a;
        this.mSoftKeyboardTool = new KeyboardToolPop(this, e.a.a.c.c.b(), this);
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        ((ActivityRssSourceEditBinding) K0()).f6553f.setAdapter(this.adapter);
        RssSourceEditViewModel rssSourceEditViewModelW0 = W0();
        Intent intent = getIntent();
        j.d(intent, "intent");
        b bVar = new b();
        Objects.requireNonNull(rssSourceEditViewModelW0);
        j.e(intent, "intent");
        j.e(bVar, "onFinally");
        e.a.a.d.u.b.c(BaseViewModel.a(rssSourceEditViewModelW0, null, null, new i(intent, rssSourceEditViewModelW0, null), 3, null), null, new e.a.a.g.k.d.b.j(bVar, null), 1);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.source_edit, menu);
        menu.findItem(R.id.menu_login).setVisible(false);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        switch (item.getItemId()) {
            case R.id.menu_copy_source /* 2131296805 */:
                String json = n.a().toJson(V0());
                j.d(json, "GSON.toJson(getRssSource())");
                c.b.a.m.f.c5(this, json);
                break;
            case R.id.menu_debug_source /* 2131296808 */:
                RssSource rssSourceV0 = V0();
                if (U0(rssSourceV0)) {
                    W0().e(rssSourceV0, new d(rssSourceV0));
                }
                break;
            case R.id.menu_paste_source /* 2131296858 */:
                RssSourceEditViewModel rssSourceEditViewModelW0 = W0();
                e eVar = new e();
                Objects.requireNonNull(rssSourceEditViewModelW0);
                j.e(eVar, "onSuccess");
                k0 k0Var = k0.f6264c;
                e.a.a.d.u.b bVarA = BaseViewModel.a(rssSourceEditViewModelW0, null, m.f6207b, new e.a.a.g.k.d.b.k(rssSourceEditViewModelW0, null), 1, null);
                e.a.a.d.u.b.b(bVarA, null, new e.a.a.g.k.d.b.l(rssSourceEditViewModelW0, null), 1);
                bVarA.d(null, new e.a.a.g.k.d.b.m(eVar, rssSourceEditViewModelW0, null));
                break;
            case R.id.menu_qr_code_camera /* 2131296860 */:
                this.qrCodeResult.launch(null);
                break;
            case R.id.menu_save /* 2131296870 */:
                RssSource rssSourceV02 = V0();
                if (U0(rssSourceV02)) {
                    W0().e(rssSourceV02, new c());
                }
                break;
            case R.id.menu_share_qr /* 2131296880 */:
                String json2 = n.a().toJson(V0());
                j.d(json2, "GSON.toJson(getRssSource())");
                String string = getString(R.string.share_rss_source);
                j.d(string, "getString(R.string.share_rss_source)");
                c.b.a.m.f.h5(this, json2, string);
                break;
            case R.id.menu_share_str /* 2131296882 */:
                String json3 = n.a().toJson(V0());
                j.d(json3, "GSON.toJson(getRssSource())");
                c.b.a.m.f.g5(this, json3, null, 2);
                break;
        }
        return super.Q0(item);
    }

    public final boolean U0(RssSource source) {
        if (!f.h0.k.s(source.getSourceName()) && !f.h0.k.s(source.getSourceName())) {
            return true;
        }
        c.b.a.m.f.R5(this, "名称或url不能为空");
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final RssSource V0() {
        RssSource rssSource = W0().rssSource;
        rssSource.setEnabled(((ActivityRssSourceEditBinding) K0()).f6551d.isChecked());
        rssSource.setSingleUrl(((ActivityRssSourceEditBinding) K0()).f6552e.isChecked());
        rssSource.setEnableJs(((ActivityRssSourceEditBinding) K0()).f6550c.isChecked());
        rssSource.setLoadWithBaseUrl(((ActivityRssSourceEditBinding) K0()).f6549b.isChecked());
        for (e.a.a.g.k.d.b.b bVar : this.sourceEntities) {
            String str = bVar.a;
            switch (str.hashCode()) {
                case -2112544833:
                    if (str.equals("ruleImage")) {
                        rssSource.setRuleImage(bVar.f5881b);
                    }
                    break;
                case -2102486852:
                    if (str.equals("ruleTitle")) {
                        rssSource.setRuleTitle(bVar.f5881b);
                    }
                    break;
                case -2024600847:
                    if (str.equals("sortUrl")) {
                        rssSource.setSortUrl(bVar.f5881b);
                    }
                    break;
                case -1698419884:
                    if (str.equals("sourceUrl")) {
                        String str2 = bVar.f5881b;
                        rssSource.setSourceUrl(str2 != null ? str2 : "");
                    }
                    break;
                case -1221270899:
                    if (str.equals("header")) {
                        rssSource.setHeader(bVar.f5881b);
                    }
                    break;
                case -1111780556:
                    if (str.equals("sourceIcon")) {
                        String str3 = bVar.f5881b;
                        rssSource.setSourceIcon(str3 != null ? str3 : "");
                    }
                    break;
                case -1111633594:
                    if (str.equals("sourceName")) {
                        String str4 = bVar.f5881b;
                        rssSource.setSourceName(str4 != null ? str4 : "");
                    }
                    break;
                case -1036512935:
                    if (str.equals("ruleArticles")) {
                        rssSource.setRuleArticles(bVar.f5881b);
                    }
                    break;
                case -784548433:
                    if (str.equals("rulePubDate")) {
                        rssSource.setRulePubDate(bVar.f5881b);
                    }
                    break;
                case -485580960:
                    if (str.equals("ruleDescription")) {
                        rssSource.setRuleDescription(bVar.f5881b);
                    }
                    break;
                case -106858716:
                    if (str.equals("sourceGroup")) {
                        rssSource.setSourceGroup(bVar.f5881b);
                    }
                    break;
                case 109780401:
                    if (str.equals("style")) {
                        rssSource.setStyle(bVar.f5881b);
                    }
                    break;
                case 403546589:
                    if (str.equals("ruleContent")) {
                        rssSource.setRuleContent(bVar.f5881b);
                    }
                    break;
                case 763223318:
                    if (str.equals("ruleLink")) {
                        rssSource.setRuleLink(bVar.f5881b);
                    }
                    break;
                case 1044961732:
                    if (str.equals("sourceComment")) {
                        rssSource.setSourceComment(bVar.f5881b);
                    }
                    break;
                case 1616637758:
                    if (str.equals("ruleNextPage")) {
                        rssSource.setRuleNextPage(bVar.f5881b);
                    }
                    break;
            }
        }
        return rssSource;
    }

    @NotNull
    public RssSourceEditViewModel W0() {
        return (RssSourceEditViewModel) this.viewModel.getValue();
    }

    public final void X0(String text) {
        if (f.h0.k.s(text)) {
            return;
        }
        View viewFindFocus = getWindow().getDecorView().findFocus();
        if (viewFindFocus instanceof EditText) {
            EditText editText = (EditText) viewFindFocus;
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            Editable editableText = editText.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) text);
            } else {
                editableText.replace(selectionStart, selectionEnd, text);
            }
        }
    }

    public final void Y0() throws IOException {
        InputStream inputStreamOpen = getAssets().open("help/ruleHelp.md");
        j.d(inputStreamOpen, "assets.open(\"help/ruleHelp.md\")");
        String str = new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a);
        TextDialog.Companion aVar = TextDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        TextDialog.Companion.a(aVar, supportFragmentManager, str, 1, 0L, false, 24);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0(RssSource rssSource) {
        if (rssSource != null) {
            ((ActivityRssSourceEditBinding) K0()).f6551d.setChecked(rssSource.getEnabled());
            ((ActivityRssSourceEditBinding) K0()).f6552e.setChecked(rssSource.getSingleUrl());
            ((ActivityRssSourceEditBinding) K0()).f6550c.setChecked(rssSource.getEnableJs());
            ((ActivityRssSourceEditBinding) K0()).f6549b.setChecked(rssSource.getLoadWithBaseUrl());
        }
        this.sourceEntities.clear();
        ArrayList<e.a.a.g.k.d.b.b> arrayList = this.sourceEntities;
        arrayList.add(new e.a.a.g.k.d.b.b("sourceName", rssSource == null ? null : rssSource.getSourceName(), R.string.source_name));
        arrayList.add(new e.a.a.g.k.d.b.b("sourceUrl", rssSource == null ? null : rssSource.getSourceUrl(), R.string.source_url));
        arrayList.add(new e.a.a.g.k.d.b.b("sourceIcon", rssSource == null ? null : rssSource.getSourceIcon(), R.string.source_icon));
        arrayList.add(new e.a.a.g.k.d.b.b("sourceGroup", rssSource == null ? null : rssSource.getSourceGroup(), R.string.source_group));
        arrayList.add(new e.a.a.g.k.d.b.b("sourceComment", rssSource == null ? null : rssSource.getSourceComment(), R.string.comment));
        arrayList.add(new e.a.a.g.k.d.b.b("sortUrl", rssSource == null ? null : rssSource.getSortUrl(), R.string.sort_url));
        arrayList.add(new e.a.a.g.k.d.b.b("ruleArticles", rssSource == null ? null : rssSource.getRuleArticles(), R.string.r_articles));
        arrayList.add(new e.a.a.g.k.d.b.b("ruleNextPage", rssSource == null ? null : rssSource.getRuleNextPage(), R.string.r_next));
        arrayList.add(new e.a.a.g.k.d.b.b("ruleTitle", rssSource == null ? null : rssSource.getRuleTitle(), R.string.r_title));
        arrayList.add(new e.a.a.g.k.d.b.b("rulePubDate", rssSource == null ? null : rssSource.getRulePubDate(), R.string.r_date));
        arrayList.add(new e.a.a.g.k.d.b.b("ruleDescription", rssSource == null ? null : rssSource.getRuleDescription(), R.string.r_description));
        arrayList.add(new e.a.a.g.k.d.b.b("ruleImage", rssSource == null ? null : rssSource.getRuleImage(), R.string.r_image));
        arrayList.add(new e.a.a.g.k.d.b.b("ruleLink", rssSource == null ? null : rssSource.getRuleLink(), R.string.r_link));
        arrayList.add(new e.a.a.g.k.d.b.b("ruleContent", rssSource == null ? null : rssSource.getRuleContent(), R.string.r_content));
        arrayList.add(new e.a.a.g.k.d.b.b("style", rssSource == null ? null : rssSource.getStyle(), R.string.r_style));
        arrayList.add(new e.a.a.g.k.d.b.b("header", rssSource != null ? rssSource.getHeader() : null, R.string.source_http_header));
        RssSourceEditAdapter rssSourceEditAdapter = this.adapter;
        ArrayList<e.a.a.g.k.d.b.b> arrayList2 = this.sourceEntities;
        Objects.requireNonNull(rssSourceEditAdapter);
        j.e(arrayList2, ES6Iterator.VALUE_PROPERTY);
        rssSourceEditAdapter.editEntities = arrayList2;
        rssSourceEditAdapter.notifyDataSetChanged();
    }

    @Override // io.legado.app.base.BaseActivity, android.app.Activity
    public void finish() {
        if (V0().equal(W0().rssSource)) {
            super.finish();
        } else {
            ((e.a.a.e.a.i) c.b.a.m.f.j0(this, Integer.valueOf(R.string.exit), null, new a(), 2)).p();
        }
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PopupWindow popupWindow = this.mSoftKeyboardTool;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        PopupWindow popupWindow;
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = c.b.a.m.f.V2(this).heightPixels;
        int i3 = i2 - rect.bottom;
        boolean z = this.mIsSoftKeyBoardShowing;
        if (Math.abs(i3) <= i2 / 5) {
            this.mIsSoftKeyBoardShowing = false;
            ((ActivityRssSourceEditBinding) K0()).f6553f.setPadding(0, 0, 0, 0);
            if (!z || (popupWindow = this.mSoftKeyboardTool) == null) {
                return;
            }
            popupWindow.dismiss();
            return;
        }
        this.mIsSoftKeyBoardShowing = true;
        ((ActivityRssSourceEditBinding) K0()).f6553f.setPadding(0, 0, 0, 100);
        PopupWindow popupWindow2 = this.mSoftKeyboardTool;
        if (popupWindow2 == null || popupWindow2.isShowing() || isFinishing()) {
            return;
        }
        popupWindow2.showAtLocation(((ActivityRssSourceEditBinding) K0()).a, 80, 0, 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(@Nullable Bundle savedInstanceState) throws IOException {
        super.onPostCreate(savedInstanceState);
        if (q.a.b(1, "ruleHelpVersion", null)) {
            return;
        }
        Y0();
    }
}
