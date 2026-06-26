package com.tencent.bugly.beta.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.bugly.beta.R;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class BetaActiveAlertActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_beta_active_alert);
        try {
            String stringExtra = getIntent().getStringExtra("h5");
            H5WebView h5WebView = new H5WebView(this);
            addContentView(h5WebView, new ViewGroup.LayoutParams(-1, -1));
            h5WebView.loadUrl(stringExtra);
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }
}
