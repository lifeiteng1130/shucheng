package io.legado.app.ui.login;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.ai;
import e.a.a.g.g.a;
import f.c0.c.j;
import io.legado.app.base.BaseActivity;
import io.legado.app.databinding.ActivitySourceLoginBinding;
import io.legado.app.ui.widget.TitleBar;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SourceLoginActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010\u0012J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\"\u0010)\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lio/legado/app/ui/login/SourceLoginActivity;", "Lio/legado/app/base/BaseActivity;", "Lio/legado/app/databinding/ActivitySourceLoginBinding;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "onDestroy", "()V", "", "g", "Ljava/lang/String;", "getSourceUrl", "()Ljava/lang/String;", "setSourceUrl", "(Ljava/lang/String;)V", "sourceUrl", ai.aA, "getUserAgent", "setUserAgent", TTDownloadField.TT_USERAGENT, "h", "getLoginUrl", "setLoginUrl", "loginUrl", "j", "Z", "getChecking", "()Z", "setChecking", "(Z)V", "checking", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SourceLoginActivity extends BaseActivity<ActivitySourceLoginBinding> {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String sourceUrl;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String loginUrl;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String userAgent;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean checking;

    public SourceLoginActivity() {
        super(false, null, null, false, false, 31);
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_source_login, (ViewGroup) null, false);
        int i2 = R.id.title_bar;
        TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
        if (titleBar != null) {
            i2 = R.id.web_view;
            WebView webView = (WebView) viewInflate.findViewById(R.id.web_view);
            if (webView != null) {
                ActivitySourceLoginBinding activitySourceLoginBinding = new ActivitySourceLoginBinding((LinearLayout) viewInflate, titleBar, webView);
                j.d(activitySourceLoginBinding, "inflate(layoutInflater)");
                return activitySourceLoginBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        this.sourceUrl = getIntent().getStringExtra("sourceUrl");
        this.loginUrl = getIntent().getStringExtra("loginUrl");
        this.userAgent = getIntent().getStringExtra(TTDownloadField.TT_USERAGENT);
        setTitle(getString(R.string.login_source, new Object[]{this.sourceUrl}));
        WebSettings settings = K0().f6567c.getSettings();
        j.d(settings, "binding.webView.settings");
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        String str = this.userAgent;
        if (str != null) {
            settings.setUserAgentString(str);
        }
        K0().f6567c.setWebViewClient(new a(CookieManager.getInstance(), this));
        String str2 = this.loginUrl;
        if (str2 == null) {
            return;
        }
        K0().f6567c.loadUrl(str2);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.source_login, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() == R.id.menu_success && !this.checking) {
            this.checking = true;
            TitleBar titleBar = K0().f6566b;
            j.d(titleBar, "binding.titleBar");
            f.j5(titleBar, R.string.check_host_cookie);
            String str = this.loginUrl;
            if (str != null) {
                K0().f6567c.loadUrl(str);
            }
        }
        return super.Q0(item);
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        K0().f6567c.destroy();
    }
}
