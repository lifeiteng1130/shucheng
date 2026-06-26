package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;

/* JADX INFO: compiled from: SelectOperationDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends Dialog {
    private TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f3007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f3008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f3009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Activity f3011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f3012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f3013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f3014i;

    /* JADX INFO: compiled from: SelectOperationDialog.java */
    public static class a {
        private Activity a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f3016c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f3017d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f3018e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c f3019f;

        public a(Activity activity) {
            this.a = activity;
        }

        public a a(String str) {
            this.f3015b = str;
            return this;
        }

        public a b(String str) {
            this.f3016c = str;
            return this;
        }

        public a c(String str) {
            this.f3017d = str;
            return this;
        }

        public a a(boolean z) {
            this.f3018e = z;
            return this;
        }

        public a a(c cVar) {
            this.f3019f = cVar;
            return this;
        }

        public d a() {
            return new d(this.a, this.f3015b, this.f3016c, this.f3017d, this.f3018e, this.f3019f);
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull c cVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f3011f = activity;
        this.f3009d = cVar;
        this.f3012g = str;
        this.f3013h = str2;
        this.f3014i = str3;
        setCanceledOnTouchOutside(z);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f3011f.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.a = (TextView) findViewById(b());
        this.f3007b = (TextView) findViewById(c());
        this.f3008c = (TextView) findViewById(R.id.message_tv);
        if (!TextUtils.isEmpty(this.f3013h)) {
            this.a.setText(this.f3013h);
        }
        if (!TextUtils.isEmpty(this.f3014i)) {
            this.f3007b.setText(this.f3014i);
        }
        if (!TextUtils.isEmpty(this.f3012g)) {
            this.f3008c.setText(this.f3012g);
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.e();
            }
        });
        this.f3007b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f3010e = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        dismiss();
    }

    public int c() {
        return R.id.cancel_tv;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f3011f.isFinishing()) {
            this.f3011f.finish();
        }
        if (this.f3010e) {
            this.f3009d.a();
        } else {
            this.f3009d.b();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int a() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int b() {
        return R.id.confirm_tv;
    }
}
