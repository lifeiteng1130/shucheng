package e.a.a.g.g;

import android.graphics.Bitmap;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import e.a.a.h.x;
import f.c0.c.j;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Cookie;
import io.legado.app.ui.login.SourceLoginActivity;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SourceLoginActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends WebViewClient {
    public final /* synthetic */ CookieManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SourceLoginActivity f5847b;

    public a(CookieManager cookieManager, SourceLoginActivity sourceLoginActivity) {
        this.a = cookieManager;
        this.f5847b = sourceLoginActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        String cookie = this.a.getCookie(str);
        String str2 = this.f5847b.sourceUrl;
        if (str2 != null) {
            j.e(str2, "url");
            x xVar = x.a;
            String strD = x.d(str2);
            if (cookie == null) {
                cookie = "";
            }
            AppDatabaseKt.getAppDb().getCookieDao().insert(new Cookie(strD, cookie));
        }
        SourceLoginActivity sourceLoginActivity = this.f5847b;
        if (sourceLoginActivity.checking) {
            sourceLoginActivity.finish();
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        String cookie = this.a.getCookie(str);
        String str2 = this.f5847b.sourceUrl;
        if (str2 != null) {
            j.e(str2, "url");
            x xVar = x.a;
            String strD = x.d(str2);
            if (cookie == null) {
                cookie = "";
            }
            AppDatabaseKt.getAppDb().getCookieDao().insert(new Cookie(strD, cookie));
        }
        super.onPageStarted(webView, str, bitmap);
    }
}
