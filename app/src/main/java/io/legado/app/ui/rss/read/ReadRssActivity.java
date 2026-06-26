package io.legado.app.ui.rss.read;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.g.k.c.h;
import e.a.a.g.k.c.i;
import e.a.a.h.f;
import e.a.a.h.s;
import e.a.a.h.x;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssSource;
import io.legado.app.databinding.ActivityRssReadBinding;
import io.legado.app.model.analyzeRule.AnalyzeUrl;
import io.legado.app.ui.association.ImportBookSourceActivity;
import io.legado.app.ui.association.ImportReplaceRuleActivity;
import io.legado.app.ui.association.ImportRssSourceActivity;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.rss.read.ReadRssActivity;
import io.legado.app.ui.rss.read.ReadRssViewModel;
import io.legado.app.ui.widget.TitleBar;
import io.wenyuange.app.release.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.NodeTraversor;

/* JADX INFO: compiled from: ReadRssActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002BCB\u0007¢\u0006\u0004\bA\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0007J\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010#\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\u0005H\u0014¢\u0006\u0004\b&\u0010\u0007R\u0018\u0010)\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R$\u00103\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u00010/0/0.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010(R\u001d\u0010:\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020*8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b?\u0010,¨\u0006D"}, d2 = {"Lio/legado/app/ui/rss/read/ReadRssActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityRssReadBinding;", "Lio/legado/app/ui/rss/read/ReadRssViewModel;", "Lio/legado/app/ui/rss/read/ReadRssViewModel$a;", "Lf/v;", "V0", "()V", "W0", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "onPrepareOptionsMenu", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "s0", "isPlaying", "R", "(Z)V", "", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKeyLongPress", "(ILandroid/view/KeyEvent;)Z", "onKeyUp", "onDestroy", "k", "Landroid/view/MenuItem;", "ttsMenuItem", "", "m", "Ljava/lang/String;", "webPic", "Landroidx/activity/result/ActivityResultLauncher;", "Le/a/a/g/f/d;", "kotlin.jvm.PlatformType", "n", "Landroidx/activity/result/ActivityResultLauncher;", "saveImage", "j", "starMenuItem", "h", "Lf/e;", "U0", "()Lio/legado/app/ui/rss/read/ReadRssViewModel;", "viewModel", "Landroid/webkit/WebChromeClient$CustomViewCallback;", Constants.LANDSCAPE, "Landroid/webkit/WebChromeClient$CustomViewCallback;", "customWebViewCallback", ai.aA, "imagePathKey", "<init>", ai.at, "b", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReadRssActivity extends VMBaseActivity<ActivityRssReadBinding, ReadRssViewModel> implements ReadRssViewModel.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7518g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String imagePathKey;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public MenuItem starMenuItem;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public MenuItem ttsMenuItem;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public WebChromeClient.CustomViewCallback customWebViewCallback;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public String webPic;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<e.a.a.g.f.d> saveImage;

    /* JADX INFO: compiled from: ReadRssActivity.kt */
    public final class a extends WebChromeClient {
        public final /* synthetic */ ReadRssActivity a;

        public a(ReadRssActivity readRssActivity) {
            j.e(readRssActivity, "this$0");
            this.a = readRssActivity;
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            ReadRssActivity.T0(this.a).f6542b.removeAllViews();
            LinearLayout linearLayout = ReadRssActivity.T0(this.a).f6543c;
            j.d(linearLayout, "binding.llView");
            f.c6(linearLayout);
            this.a.setRequestedOrientation(-1);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(@Nullable View view, @Nullable WebChromeClient.CustomViewCallback customViewCallback) {
            this.a.setRequestedOrientation(4);
            LinearLayout linearLayout = ReadRssActivity.T0(this.a).f6543c;
            j.d(linearLayout, "binding.llView");
            f.l3(linearLayout);
            ReadRssActivity.T0(this.a).f6542b.addView(view);
            this.a.customWebViewCallback = customViewCallback;
        }
    }

    /* JADX INFO: compiled from: ReadRssActivity.kt */
    public final class b extends WebViewClient {
        public final /* synthetic */ ReadRssActivity a;

        /* JADX INFO: compiled from: ReadRssActivity.kt */
        public static final class a extends k implements l<View, v> {
            public final /* synthetic */ Uri $url;
            public final /* synthetic */ ReadRssActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ReadRssActivity readRssActivity, Uri uri) {
                super(1);
                this.this$0 = readRssActivity;
                this.$url = uri;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(View view) {
                invoke2(view);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view) {
                j.e(view, "it");
                f.h4(this.this$0, this.$url);
            }
        }

        public b(ReadRssActivity readRssActivity) {
            j.e(readRssActivity, "this$0");
            this.a = readRssActivity;
        }

        public final boolean a(Uri uri) {
            if (j.a(uri.getScheme(), "http") || j.a(uri.getScheme(), "https")) {
                return false;
            }
            if (!j.a(uri.getScheme(), "yuedu")) {
                FrameLayout frameLayout = ReadRssActivity.T0(this.a).a;
                j.d(frameLayout, "binding.root");
                f.R3(frameLayout, "跳转其它应用", "确认", new a(this.a, uri));
                return true;
            }
            String host = uri.getHost();
            if (host != null) {
                int iHashCode = host.hashCode();
                if (iHashCode != -1086910396) {
                    if (iHashCode != 1050516717) {
                        if (iHashCode == 1094496948 && host.equals("replace")) {
                            Intent intent = new Intent(this.a, (Class<?>) ImportReplaceRuleActivity.class);
                            intent.setData(uri);
                            this.a.startActivity(intent);
                        }
                    } else if (host.equals("rsssource")) {
                        Intent intent2 = new Intent(this.a, (Class<?>) ImportRssSourceActivity.class);
                        intent2.setData(uri);
                        this.a.startActivity(intent2);
                    }
                } else if (host.equals("booksource")) {
                    Intent intent3 = new Intent(this.a, (Class<?>) ImportBookSourceActivity.class);
                    intent3.setData(uri);
                    this.a.startActivity(intent3);
                }
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
            super.onPageFinished(webView, str);
            ReadRssActivity readRssActivity = this.a;
            int i2 = ReadRssActivity.f7518g;
            readRssActivity.W0();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null) {
                return true;
            }
            Uri url = webResourceRequest.getUrl();
            j.d(url, "it.url");
            return a(url);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
            if (str == null) {
                return true;
            }
            Uri uri = Uri.parse(str);
            j.d(uri, "parse(it)");
            return a(uri);
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class c extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
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
    public static final class d extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
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

    /* JADX INFO: compiled from: ReadRssActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.read.ReadRssActivity$upTtsMenu$1", f = "ReadRssActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ boolean $isPlaying;
        public int label;
        public final /* synthetic */ ReadRssActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(boolean z, ReadRssActivity readRssActivity, f.z.d<? super e> dVar) {
            super(2, dVar);
            this.$isPlaying = z;
            this.this$0 = readRssActivity;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new e(this.$isPlaying, this.this$0, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((e) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            if (this.$isPlaying) {
                MenuItem menuItem = this.this$0.ttsMenuItem;
                if (menuItem != null) {
                    menuItem.setIcon(R.drawable.ic_stop_black_24dp);
                }
                MenuItem menuItem2 = this.this$0.ttsMenuItem;
                if (menuItem2 != null) {
                    menuItem2.setTitle(R.string.aloud_stop);
                }
            } else {
                MenuItem menuItem3 = this.this$0.ttsMenuItem;
                if (menuItem3 != null) {
                    menuItem3.setIcon(R.drawable.ic_volume_up);
                }
                MenuItem menuItem4 = this.this$0.ttsMenuItem;
                if (menuItem4 != null) {
                    menuItem4.setTitle(R.string.read_aloud);
                }
            }
            MenuItem menuItem5 = this.this$0.ttsMenuItem;
            Drawable icon = menuItem5 == null ? null : menuItem5.getIcon();
            int iR2 = f.R2(this.this$0);
            PorterDuff.Mode mode = (4 & 4) != 0 ? PorterDuff.Mode.SRC_ATOP : null;
            j.e(mode, "tintMode");
            if (icon != null) {
                Drawable drawableWrap = DrawableCompat.wrap(icon);
                drawableWrap.mutate();
                DrawableCompat.setTintMode(drawableWrap, mode);
                DrawableCompat.setTint(drawableWrap, iR2);
            }
            return v.a;
        }
    }

    public ReadRssActivity() {
        super(false, null, null, false, false, 30);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(ReadRssViewModel.class), new d(this), new c(this));
        this.imagePathKey = "";
        ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.k.c.d
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ReadRssActivity readRssActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = ReadRssActivity.f7518g;
                f.c0.c.j.e(readRssActivity, "this$0");
                f.b.a(e.a.a.h.f.a, readRssActivity, null, 0L, 0, false, 30).b(readRssActivity.imagePathKey, String.valueOf(uri));
                ReadRssViewModel readRssViewModelU0 = readRssActivity.U0();
                String str = readRssActivity.webPic;
                String strValueOf = String.valueOf(uri);
                Objects.requireNonNull(readRssViewModelU0);
                f.c0.c.j.e(strValueOf, "path");
                if (str == null) {
                    return;
                }
                e.a.a.d.u.b bVarA = BaseViewModel.a(readRssViewModelU0, null, null, new m(readRssViewModelU0, str, strValueOf, null), 3, null);
                e.a.a.d.u.b.b(bVarA, null, new n(readRssViewModelU0, null), 1);
                bVarA.d(null, new o(readRssViewModelU0, null));
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(FilePicker()) {\n        ACache.get(this).put(imagePathKey, it.toString())\n        viewModel.saveImage(webPic, it.toString())\n    }");
        this.saveImage = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityRssReadBinding T0(ReadRssActivity readRssActivity) {
        return (ActivityRssReadBinding) readRssActivity.K0();
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_rss_read, (ViewGroup) null, false);
        int i2 = R.id.custom_web_view;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.custom_web_view);
        if (frameLayout != null) {
            i2 = R.id.ll_view;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_view);
            if (linearLayout != null) {
                i2 = R.id.title_bar;
                TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    i2 = R.id.web_view;
                    VisibleWebView visibleWebView = (VisibleWebView) viewInflate.findViewById(R.id.web_view);
                    if (visibleWebView != null) {
                        ActivityRssReadBinding activityRssReadBinding = new ActivityRssReadBinding((FrameLayout) viewInflate, frameLayout, linearLayout, titleBar, visibleWebView);
                        j.d(activityRssReadBinding, "inflate(layoutInflater)");
                        return activityRssReadBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        U0().callBack = this;
        ((ActivityRssReadBinding) K0()).f6544d.setTitle(getIntent().getStringExtra("title"));
        ((ActivityRssReadBinding) K0()).f6545e.setWebChromeClient(new a(this));
        ((ActivityRssReadBinding) K0()).f6545e.setWebViewClient(new b(this));
        WebSettings settings = ((ActivityRssReadBinding) K0()).f6545e.getSettings();
        settings.setMixedContentMode(0);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(true);
        W0();
        ((ActivityRssReadBinding) K0()).f6545e.setOnLongClickListener(new View.OnLongClickListener() { // from class: e.a.a.g.k.c.e
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                String extra;
                ReadRssActivity readRssActivity = this.a;
                int i2 = ReadRssActivity.f7518g;
                f.c0.c.j.e(readRssActivity, "this$0");
                WebView.HitTestResult hitTestResult = ((ActivityRssReadBinding) readRssActivity.K0()).f6545e.getHitTestResult();
                f.c0.c.j.d(hitTestResult, "binding.webView.hitTestResult");
                if ((hitTestResult.getType() != 5 && hitTestResult.getType() != 8) || (extra = hitTestResult.getExtra()) == null) {
                    return false;
                }
                readRssActivity.webPic = extra;
                ArrayList arrayList = new ArrayList();
                String strA = f.b.a(e.a.a.h.f.a, readRssActivity, null, 0L, 0, false, 30).a(readRssActivity.imagePathKey);
                if (!(strA == null || strA.length() == 0)) {
                    arrayList.add(strA);
                }
                ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncher = readRssActivity.saveImage;
                Object[] array = arrayList.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                activityResultLauncher.launch(new e.a.a.g.f.d(0, null, null, (String[]) array, 7));
                return true;
            }
        });
        ((ActivityRssReadBinding) K0()).f6545e.setDownloadListener(new DownloadListener() { // from class: e.a.a.g.k.c.c
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                ReadRssActivity readRssActivity = this.a;
                int i2 = ReadRssActivity.f7518g;
                f.c0.c.j.e(readRssActivity, "this$0");
                String strGuessFileName = URLUtil.guessFileName(str, str3, null);
                LinearLayout linearLayout = ((ActivityRssReadBinding) readRssActivity.K0()).f6543c;
                f.c0.c.j.d(linearLayout, "binding.llView");
                f.c0.c.j.d(strGuessFileName, "fileName");
                String string = readRssActivity.getString(R.string.action_download);
                f.c0.c.j.d(string, "getString(R.string.action_download)");
                c.b.a.m.f.R3(linearLayout, strGuessFileName, string, new g(str, strGuessFileName, readRssActivity));
            }
        });
        U0().contentLiveData.observe(this, new Observer() { // from class: e.a.a.g.k.c.b
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) throws IOException {
                ReadRssActivity readRssActivity = this.a;
                String strS = (String) obj;
                int i2 = ReadRssActivity.f7518g;
                f.c0.c.j.e(readRssActivity, "this$0");
                RssArticle rssArticle = readRssActivity.U0().rssArticle;
                if (rssArticle == null) {
                    return;
                }
                readRssActivity.V0();
                x xVar = x.a;
                String strA = x.a(rssArticle.getOrigin(), rssArticle.getLink());
                ReadRssViewModel readRssViewModelU0 = readRssActivity.U0();
                f.c0.c.j.d(strS, "content");
                Objects.requireNonNull(readRssViewModelU0);
                f.c0.c.j.e(strS, "content");
                RssSource rssSource = readRssViewModelU0.rssSource;
                String style = rssSource == null ? null : rssSource.getStyle();
                if (!(style == null || style.length() == 0)) {
                    StringBuilder sbR = c.a.a.a.a.r("\n                    <style>\n                        ");
                    RssSource rssSource2 = readRssViewModelU0.rssSource;
                    sbR.append((Object) (rssSource2 == null ? null : rssSource2.getStyle()));
                    sbR.append("\n                    </style>\n                    ");
                    sbR.append(strS);
                    sbR.append("\n                ");
                    strS = f.h0.k.S(sbR.toString());
                } else if (!new f.h0.g("<style>").containsMatchIn(strS)) {
                    strS = f.h0.k.S("\n                    <style>\n                        img{max-width:100% !important; width:auto; height:auto;}\n                        video{object-fit:fill; max-width:100% !important; width:auto; height:auto;}\n                        body{word-wrap:break-word; height:auto;max-width: 100%; width:auto;}\n                    </style>\n                    " + strS + "\n                ");
                }
                String str = strS;
                RssSource rssSource3 = readRssActivity.U0().rssSource;
                if (f.c0.c.j.a(rssSource3 != null ? Boolean.valueOf(rssSource3.getLoadWithBaseUrl()) : null, Boolean.TRUE)) {
                    ((ActivityRssReadBinding) readRssActivity.K0()).f6545e.loadDataWithBaseURL(strA, str, d.a.a.a.MIME_HTML, "utf-8", strA);
                } else {
                    ((ActivityRssReadBinding) readRssActivity.K0()).f6545e.loadDataWithBaseURL(null, str, "text/html;charset=utf-8", "utf-8", strA);
                }
            }
        });
        U0().urlLiveData.observe(this, new Observer() { // from class: e.a.a.g.k.c.f
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ReadRssActivity readRssActivity = this.a;
                AnalyzeUrl analyzeUrl = (AnalyzeUrl) obj;
                int i2 = ReadRssActivity.f7518g;
                f.c0.c.j.e(readRssActivity, "this$0");
                readRssActivity.V0();
                ((ActivityRssReadBinding) readRssActivity.K0()).f6545e.loadUrl(analyzeUrl.getUrl(), analyzeUrl.getHeaderMap());
            }
        });
        ReadRssViewModel readRssViewModelU0 = U0();
        Intent intent = getIntent();
        j.d(intent, "intent");
        Objects.requireNonNull(readRssViewModelU0);
        j.e(intent, "intent");
        e.a.a.d.u.b.c(BaseViewModel.a(readRssViewModelU0, null, null, new e.a.a.g.k.c.j(intent, readRssViewModelU0, null), 3, null), null, new e.a.a.g.k.c.k(readRssViewModelU0, null), 1);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.rss_read, menu);
        return super.P0(menu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        RssArticle rssArticle;
        j.e(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.menu_aloud) {
            TextToSpeech textToSpeech = U0().textToSpeech;
            if (j.a(textToSpeech != null ? Boolean.valueOf(textToSpeech.isSpeaking()) : null, Boolean.TRUE)) {
                TextToSpeech textToSpeech2 = U0().textToSpeech;
                if (textToSpeech2 != null) {
                    textToSpeech2.stop();
                }
                R(false);
            } else {
                ((ActivityRssReadBinding) K0()).f6545e.getSettings().setJavaScriptEnabled(true);
                ((ActivityRssReadBinding) K0()).f6545e.evaluateJavascript("document.documentElement.outerHTML", new ValueCallback() { // from class: e.a.a.g.k.c.a
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        v vVar;
                        ReadRssActivity readRssActivity = this.a;
                        int i2 = ReadRssActivity.f7518g;
                        f.c0.c.j.e(readRssActivity, "this$0");
                        String strA = k.b.a.b.a.a((String) obj);
                        f.c0.c.j.d(strA, "unescapeJson(it)");
                        String strReplace = new f.h0.g("^\"|\"$").replace(strA, "");
                        Jsoup.parse(strReplace).text();
                        ReadRssViewModel readRssViewModelU0 = readRssActivity.U0();
                        Document document = Jsoup.parse(strReplace);
                        f.c0.c.j.d(document, "parse(html)");
                        f.c0.c.j.e(document, "<this>");
                        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
                        NodeTraversor.traverse(new s(sbBorrowBuilder), document);
                        String strReleaseBuilder = StringUtil.releaseBuilder(sbBorrowBuilder);
                        f.c0.c.j.d(strReleaseBuilder, "releaseBuilder(sb)");
                        int length = strReleaseBuilder.length() - 1;
                        int i3 = 0;
                        boolean z = false;
                        while (i3 <= length) {
                            boolean z2 = f.c0.c.j.g(strReleaseBuilder.charAt(!z ? i3 : length), 32) <= 0;
                            if (z) {
                                if (!z2) {
                                    break;
                                } else {
                                    length--;
                                }
                            } else if (z2) {
                                i3++;
                            } else {
                                z = true;
                            }
                        }
                        String[] strArrN5 = c.b.a.m.f.n5(strReleaseBuilder.subSequence(i3, length + 1).toString(), "\n");
                        Objects.requireNonNull(readRssViewModelU0);
                        f.c0.c.j.e(strArrN5, "textArray");
                        readRssViewModelU0.ttsTextList.clear();
                        c.b.a.m.f.T(readRssViewModelU0.ttsTextList, strArrN5);
                        if (readRssViewModelU0.textToSpeech == null) {
                            vVar = null;
                        } else {
                            readRssViewModelU0.h();
                            vVar = v.a;
                        }
                        if (vVar == null) {
                            readRssViewModelU0.textToSpeech = new TextToSpeech(readRssViewModelU0.b(), readRssViewModelU0);
                        }
                    }
                });
            }
        } else if (itemId == R.id.menu_rss_star) {
            ReadRssViewModel readRssViewModelU0 = U0();
            Objects.requireNonNull(readRssViewModelU0);
            BaseViewModel.a(readRssViewModelU0, null, null, new h(readRssViewModelU0, null), 3, null).d(null, new i(readRssViewModelU0, null));
        } else if (itemId == R.id.menu_share_it && (rssArticle = U0().rssArticle) != null) {
            c.b.a.m.f.g5(this, rssArticle.getLink(), null, 2);
        }
        return super.Q0(item);
    }

    @Override // io.legado.app.ui.rss.read.ReadRssViewModel.a
    public void R(boolean isPlaying) {
        c.b.a.m.f.L3(this, null, null, new e(isPlaying, this, null), 3, null);
    }

    @NotNull
    public ReadRssViewModel U0() {
        return (ReadRssViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled"})
    public final void V0() {
        RssSource rssSource = U0().rssSource;
        if (j.a(rssSource == null ? null : Boolean.valueOf(rssSource.getEnableJs()), Boolean.TRUE)) {
            ((ActivityRssReadBinding) K0()).f6545e.getSettings().setJavaScriptEnabled(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W0() {
        if (e.a.a.d.e.a.m()) {
            VisibleWebView visibleWebView = ((ActivityRssReadBinding) K0()).f6545e;
            e.a.a.c.c cVar = e.a.a.c.c.a;
            visibleWebView.evaluateJavascript((String) e.a.a.c.c.f5504j.getValue(), null);
        }
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    @SuppressLint({"SwitchIntDef"})
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        j.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i2 = newConfig.orientation;
        if (i2 == 1) {
            getWindow().clearFlags(1024);
            getWindow().addFlags(2048);
        } else {
            if (i2 != 2) {
                return;
            }
            getWindow().clearFlags(2048);
            getWindow().addFlags(1024);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((ActivityRssReadBinding) K0()).f6545e.destroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int keyCode, @Nullable KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyLongPress(keyCode, event);
        }
        finish();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, @Nullable KeyEvent event) {
        if (event != null && keyCode == 4 && event.isTracking() && !event.isCanceled() && ((ActivityRssReadBinding) K0()).f6545e.canGoBack()) {
            FrameLayout frameLayout = ((ActivityRssReadBinding) K0()).f6542b;
            j.d(frameLayout, "binding.customWebView");
            if (frameLayout.getChildCount() > 0) {
                WebChromeClient.CustomViewCallback customViewCallback = this.customWebViewCallback;
                if (customViewCallback != null) {
                    customViewCallback.onCustomViewHidden();
                }
                return true;
            }
            if (((ActivityRssReadBinding) K0()).f6545e.copyBackForwardList().getSize() > 1) {
                ((ActivityRssReadBinding) K0()).f6545e.goBack();
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        this.starMenuItem = menu == null ? null : menu.findItem(R.id.menu_rss_star);
        this.ttsMenuItem = menu != null ? menu.findItem(R.id.menu_aloud) : null;
        s0();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // io.legado.app.ui.rss.read.ReadRssViewModel.a
    public void s0() {
        if (U0().rssStar != null) {
            MenuItem menuItem = this.starMenuItem;
            if (menuItem != null) {
                menuItem.setIcon(R.drawable.ic_star);
            }
            MenuItem menuItem2 = this.starMenuItem;
            if (menuItem2 != null) {
                menuItem2.setTitle(R.string.in_favorites);
            }
        } else {
            MenuItem menuItem3 = this.starMenuItem;
            if (menuItem3 != null) {
                menuItem3.setIcon(R.drawable.ic_star_border);
            }
            MenuItem menuItem4 = this.starMenuItem;
            if (menuItem4 != null) {
                menuItem4.setTitle(R.string.out_favorites);
            }
        }
        MenuItem menuItem5 = this.starMenuItem;
        Drawable icon = menuItem5 == null ? null : menuItem5.getIcon();
        int iR2 = c.b.a.m.f.R2(this);
        PorterDuff.Mode mode = (4 & 4) != 0 ? PorterDuff.Mode.SRC_ATOP : null;
        j.e(mode, "tintMode");
        if (icon == null) {
            return;
        }
        Drawable drawableWrap = DrawableCompat.wrap(icon);
        drawableWrap.mutate();
        DrawableCompat.setTintMode(drawableWrap, mode);
        DrawableCompat.setTint(drawableWrap, iR2);
    }
}
