package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes.dex */
public class DownloadTaskDeleteActivity extends Activity {
    private k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Intent f3418b;

    private void b() {
        Intent intent;
        if (this.a != null || (intent = this.f3418b) == null) {
            return;
        }
        try {
            final boolean z = false;
            final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            final DownloadInfo downloadInfo = Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                return;
            }
            String string = String.format(getString(i.a(this, "tt_appdownloader_notification_download_delete")), title);
            c cVarA = d.j().a();
            l lVarA = cVarA != null ? cVarA.a(this) : null;
            if (lVarA == null) {
                lVarA = new com.ss.android.socialbase.appdownloader.d.a(this);
            }
            int iA = i.a(this, "tt_appdownloader_tip");
            int iA2 = i.a(this, "tt_appdownloader_label_ok");
            int iA3 = i.a(this, "tt_appdownloader_label_cancel");
            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("cancel_with_net_opt", 0) == 1 && f.h() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                z = true;
            }
            if (z) {
                iA2 = i.a(this, "tt_appdownloader_label_reserve_wifi");
                iA3 = i.a(this, "tt_appdownloader_label_cancel_directly");
                string = getResources().getString(i.a(this, "tt_appdownloader_resume_in_wifi"));
            }
            lVarA.a(iA).a(string).a(iA2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (z) {
                        downloadInfo.setOnlyWifi(true);
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                            }
                        }, 100L);
                    } else {
                        DownloadTaskDeleteActivity.this.a(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).b(iA3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (z) {
                        DownloadTaskDeleteActivity.this.a(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).a(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    DownloadTaskDeleteActivity.this.finish();
                }
            });
            this.a = lVarA.a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f3418b = getIntent();
        b();
        k kVar = this.a;
        if (kVar != null && !kVar.b()) {
            this.a.a();
        } else if (this.a == null) {
            finish();
        }
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, int i2) {
        com.ss.android.socialbase.appdownloader.c.d dVarB = d.j().b();
        if (dVarB != null) {
            dVarB.a(downloadInfo);
        }
        z downloadNotificationEventListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getDownloadNotificationEventListener(i2);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.a(10, downloadInfo, "", "");
        }
        if (com.ss.android.socialbase.downloader.downloader.c.N() != null) {
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(i2);
        }
    }
}
