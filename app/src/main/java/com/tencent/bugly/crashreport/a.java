package com.tencent.bugly.crashreport;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class a implements CrashReport.WebViewInterface {
    public final /* synthetic */ WebView a;

    public a(WebView webView) {
        this.a = webView;
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
        this.a.addJavascriptInterface(h5JavaScriptInterface, str);
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public CharSequence getContentDescription() {
        return this.a.getContentDescription();
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public String getUrl() {
        return this.a.getUrl();
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public void loadUrl(String str) {
        this.a.loadUrl(str);
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public void setJavaScriptEnabled(boolean z) {
        WebSettings settings = this.a.getSettings();
        if (settings.getJavaScriptEnabled()) {
            return;
        }
        settings.setJavaScriptEnabled(true);
    }
}
