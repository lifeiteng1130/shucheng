package e.a.a.d.v;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.app.NotificationCompat;
import e.a.a.d.v.e;
import e.a.a.h.x;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Cookie;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AjaxWebView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    @Nullable
    public c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public a f5569b = new a(this);

    /* JADX INFO: compiled from: AjaxWebView.kt */
    public static final class a extends Handler {

        @NotNull
        public final e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public WebView f5570b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull e eVar) {
            super(Looper.getMainLooper());
            f.c0.c.j.e(eVar, "ajaxWebView");
            this.a = eVar;
        }

        @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
        @NotNull
        public final WebView a(@NotNull b bVar, @NotNull Handler handler) {
            byte[] bArr;
            f.c0.c.j.e(bVar, "params");
            f.c0.c.j.e(handler, "handler");
            WebView webView = new WebView(k.d.a.h.g());
            WebSettings settings = webView.getSettings();
            f.c0.c.j.d(settings, "webView.settings");
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setBlockNetworkImage(true);
            Map<String, String> map = bVar.f5574e;
            settings.setUserAgentString(map == null ? null : map.get("User-Agent"));
            settings.setMixedContentMode(0);
            if (!TextUtils.isEmpty(bVar.f5575f)) {
                webView.setWebViewClient(new g(bVar, handler));
            } else {
                webView.setWebViewClient(new C0149e(bVar, handler));
            }
            int iOrdinal = bVar.f5572c.ordinal();
            if (iOrdinal == 0) {
                Map<String, String> map2 = bVar.f5574e;
                if (map2 != null) {
                    webView.loadUrl(bVar.a, map2);
                }
            } else if (iOrdinal == 1 && (bArr = bVar.f5573d) != null) {
                webView.postUrl(bVar.a, bArr);
            }
            return webView;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message message) {
            f.c0.c.j.e(message, NotificationCompat.CATEGORY_MESSAGE);
            int i2 = message.what;
            if (i2 == 0) {
                Object obj = message.obj;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type io.legado.app.help.http.AjaxWebView.AjaxParams");
                this.f5570b = a((b) obj, this);
                return;
            }
            if (i2 == 1) {
                Object obj2 = message.obj;
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type io.legado.app.help.http.AjaxWebView.AjaxParams");
                this.f5570b = a((b) obj2, this);
                return;
            }
            if (i2 == 2) {
                c cVar = this.a.a;
                if (cVar != null) {
                    Object obj3 = message.obj;
                    Objects.requireNonNull(obj3, "null cannot be cast to non-null type io.legado.app.help.http.StrResponse");
                    cVar.b((l) obj3);
                }
                WebView webView = this.f5570b;
                if (webView != null) {
                    webView.destroy();
                }
                this.f5570b = null;
                return;
            }
            if (i2 != 3) {
                return;
            }
            c cVar2 = this.a.a;
            if (cVar2 != null) {
                Object obj4 = message.obj;
                Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Throwable");
                cVar2.a((Throwable) obj4);
            }
            WebView webView2 = this.f5570b;
            if (webView2 != null) {
                webView2.destroy();
            }
            this.f5570b = null;
        }
    }

    /* JADX INFO: compiled from: AjaxWebView.kt */
    public static final class b {

        @NotNull
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String f5571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public j f5572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public byte[] f5573d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public Map<String, String> f5574e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public String f5575f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public String f5576g;

        public b(@NotNull String str) {
            f.c0.c.j.e(str, "url");
            this.a = str;
            this.f5572c = j.GET;
        }

        public final void a(@NotNull String str) {
            f.c0.c.j.e(str, "url");
            String str2 = this.f5571b;
            if (str2 == null) {
                return;
            }
            String cookie = CookieManager.getInstance().getCookie(str);
            f.c0.c.j.e(str2, "url");
            x xVar = x.a;
            String strD = x.d(str2);
            if (cookie == null) {
                cookie = "";
            }
            AppDatabaseKt.getAppDb().getCookieDao().insert(new Cookie(strD, cookie));
        }
    }

    /* JADX INFO: compiled from: AjaxWebView.kt */
    public static abstract class c {
        public abstract void a(@NotNull Throwable th);

        public abstract void b(@NotNull l lVar);
    }

    /* JADX INFO: compiled from: AjaxWebView.kt */
    public static final class d implements Runnable {

        @NotNull
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final String f5577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final Handler f5578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5579d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public final WeakReference<WebView> f5580e;

        public d(@NotNull WebView webView, @NotNull String str, @NotNull String str2, @NotNull Handler handler) {
            f.c0.c.j.e(webView, "webView");
            f.c0.c.j.e(str, "url");
            f.c0.c.j.e(str2, "mJavaScript");
            f.c0.c.j.e(handler, "handler");
            this.a = str;
            this.f5577b = str2;
            this.f5578c = handler;
            this.f5580e = new WeakReference<>(webView);
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = this.f5580e.get();
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(this.f5577b, new ValueCallback() { // from class: e.a.a.d.v.a
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    e.d dVar = this.a;
                    String str = (String) obj;
                    f.c0.c.j.e(dVar, "this$0");
                    f.c0.c.j.d(str, "it");
                    if ((str.length() > 0) && !f.c0.c.j.a(str, "null")) {
                        String strA = k.b.a.b.a.a(str);
                        f.c0.c.j.d(strA, "unescapeJson(it)");
                        try {
                            dVar.f5578c.obtainMessage(2, new l(dVar.a, new f.h0.g("^\"|\"$").replace(strA, ""))).sendToTarget();
                        } catch (Exception e2) {
                            dVar.f5578c.obtainMessage(3, e2).sendToTarget();
                        }
                        dVar.f5578c.removeCallbacks(dVar);
                        return;
                    }
                    int i2 = dVar.f5579d;
                    if (i2 > 30) {
                        dVar.f5578c.obtainMessage(3, new Exception("js执行超时")).sendToTarget();
                        dVar.f5578c.removeCallbacks(dVar);
                    } else {
                        dVar.f5579d = i2 + 1;
                        dVar.f5578c.removeCallbacks(dVar);
                        dVar.f5578c.postDelayed(dVar, 1000L);
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: e.a.a.d.v.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AjaxWebView.kt */
    public static final class C0149e extends WebViewClient {

        @NotNull
        public final b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final Handler f5581b;

        public C0149e(@NotNull b bVar, @NotNull Handler handler) {
            f.c0.c.j.e(bVar, "params");
            f.c0.c.j.e(handler, "handler");
            this.a = bVar;
            this.f5581b = handler;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onPageFinished(@org.jetbrains.annotations.NotNull android.webkit.WebView r4, @org.jetbrains.annotations.NotNull java.lang.String r5) {
            /*
                r3 = this;
                java.lang.String r0 = "view"
                f.c0.c.j.e(r4, r0)
                java.lang.String r0 = "url"
                f.c0.c.j.e(r5, r0)
                e.a.a.d.v.e$b r0 = r3.a
                r0.a(r5)
                e.a.a.d.v.e$d r0 = new e.a.a.d.v.e$d
                e.a.a.d.v.e$b r1 = r3.a
                java.lang.String r1 = r1.f5576g
                if (r1 != 0) goto L18
                goto L24
            L18:
                int r2 = r1.length()
                if (r2 <= 0) goto L20
                r2 = 1
                goto L21
            L20:
                r2 = 0
            L21:
                if (r2 == 0) goto L24
                goto L26
            L24:
                java.lang.String r1 = "document.documentElement.outerHTML"
            L26:
                android.os.Handler r2 = r3.f5581b
                r0.<init>(r4, r5, r1, r2)
                android.os.Handler r4 = r3.f5581b
                r1 = 1000(0x3e8, double:4.94E-321)
                r4.postDelayed(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.v.e.C0149e.onPageFinished(android.webkit.WebView, java.lang.String):void");
        }
    }

    /* JADX INFO: compiled from: AjaxWebView.kt */
    public static final class f implements Runnable {

        @Nullable
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final WeakReference<WebView> f5582b;

        public f(@NotNull WebView webView, @Nullable String str) {
            f.c0.c.j.e(webView, "webView");
            this.a = str;
            this.f5582b = new WeakReference<>(webView);
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = this.f5582b.get();
            if (webView == null) {
                return;
            }
            String str = this.a;
            if (str == null) {
                str = "";
            }
            webView.loadUrl(f.c0.c.j.k("javascript:", str));
        }
    }

    /* JADX INFO: compiled from: AjaxWebView.kt */
    public static final class g extends WebViewClient {

        @NotNull
        public final b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final Handler f5583b;

        public g(@NotNull b bVar, @NotNull Handler handler) {
            f.c0.c.j.e(bVar, "params");
            f.c0.c.j.e(handler, "handler");
            this.a = bVar;
            this.f5583b = handler;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(@NotNull WebView webView, @NotNull String str) {
            f.c0.c.j.e(webView, "view");
            f.c0.c.j.e(str, "url");
            String str2 = this.a.f5575f;
            if (str2 != null && new f.h0.g(str2).matches(str)) {
                try {
                    this.f5583b.obtainMessage(2, new l(this.a.a, str)).sendToTarget();
                } catch (Exception e2) {
                    this.f5583b.obtainMessage(3, e2).sendToTarget();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
            f.c0.c.j.e(webView, "view");
            f.c0.c.j.e(str, "url");
            this.a.a(str);
            if (!TextUtils.isEmpty(this.a.f5576g)) {
                this.f5583b.postDelayed(new f(webView, this.a.f5576g), 1000L);
                this.a.f5576g = null;
            }
        }
    }
}
