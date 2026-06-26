package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.compliance.d;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.downloadlib.guide.install.ClipImageView;

/* JADX INFO: compiled from: AdLpAppInfoDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Dialog {
    private TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f3083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f3084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f3085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f3086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f3087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ClipImageView f3088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LinearLayout f3089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Activity f3090i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f3091j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f3092k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.ss.android.downloadlib.addownload.b.b f3093l;

    public a(@NonNull Activity activity, long j2) {
        super(activity);
        this.f3090i = activity;
        this.f3091j = j2;
        this.f3093l = c.a().get(Long.valueOf(j2));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.c.a(this.f3090i);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f3093l == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.f3092k = this.f3093l.f3029b;
        a();
        e.b("lp_app_dialog_show", this.f3092k);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                e.a("lp_app_dialog_cancel", a.this.f3092k);
            }
        });
    }

    private void a() {
        this.a = (TextView) findViewById(R.id.tv_app_name);
        this.f3083b = (TextView) findViewById(R.id.tv_app_version);
        this.f3084c = (TextView) findViewById(R.id.tv_app_developer);
        this.f3085d = (TextView) findViewById(R.id.tv_app_detail);
        this.f3086e = (TextView) findViewById(R.id.tv_app_privacy);
        this.f3087f = (TextView) findViewById(R.id.tv_give_up);
        this.f3088g = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.f3089h = (LinearLayout) findViewById(R.id.ll_download);
        this.a.setText(l.a(this.f3093l.f3032e, "--"));
        TextView textView = this.f3083b;
        StringBuilder sbR = c.a.a.a.a.r("版本号：");
        sbR.append(l.a(this.f3093l.f3033f, "--"));
        textView.setText(sbR.toString());
        TextView textView2 = this.f3084c;
        StringBuilder sbR2 = c.a.a.a.a.r("开发者：");
        sbR2.append(l.a(this.f3093l.f3034g, "应用信息正在完善中"));
        textView2.setText(sbR2.toString());
        this.f3088g.setRoundRadius(l.a(j.getContext(), 8.0f));
        this.f3088g.setBackgroundColor(Color.parseColor("#EBEBEB"));
        d.a().a(this.f3091j, new d.a() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2
            @Override // com.ss.android.downloadlib.addownload.compliance.d.a
            public void a(Bitmap bitmap) {
                if (bitmap != null) {
                    a.this.f3088g.setImageBitmap(bitmap);
                } else {
                    e.a(8, a.this.f3092k);
                }
            }
        });
        this.f3085d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.f3090i);
                AppDetailInfoActivity.a(a.this.f3090i, a.this.f3091j);
                e.a("lp_app_dialog_click_detail", a.this.f3092k);
            }
        });
        this.f3086e.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.f3090i);
                AppPrivacyPolicyActivity.a(a.this.f3090i, a.this.f3091j);
                e.a("lp_app_dialog_click_privacy", a.this.f3092k);
            }
        });
        this.f3087f.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                e.a("lp_app_dialog_click_giveup", a.this.f3092k);
            }
        });
        this.f3089h.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_dialog_click_download", a.this.f3092k);
                b.a().b(a.this.f3092k);
                a.this.dismiss();
            }
        });
    }
}
