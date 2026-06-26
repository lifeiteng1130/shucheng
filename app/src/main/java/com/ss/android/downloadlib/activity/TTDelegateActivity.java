package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.a.b;
import com.ss.android.downloadlib.addownload.a.d;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.e.c;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.g.h;
import com.ss.android.downloadlib.guide.install.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.umeng.analytics.pro.ai;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f2989d;
    public Intent a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f2991c;

    public static void a(String str, String[] strArr) {
        Intent intent = new Intent(j.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (j.getContext() != null) {
            j.getContext().startActivity(intent);
        }
    }

    public static void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent intentC = c(aVar);
        intentC.addFlags(268435456);
        intentC.putExtra("type", 11);
        intentC.putExtra(ai.o, str);
        if (j.getContext() != null) {
            j.getContext().startActivity(intentC);
        }
    }

    private static Intent c(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        return new Intent(j.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    private void d(long j2) {
        new com.ss.android.downloadlib.addownload.compliance.a(this, j2).show();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        b();
        this.a = getIntent();
        j.b(this);
        a();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.a = intent;
        j.b(this);
        a();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        j.e().a(this, i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onStop() {
        DownloadInfo downloadInfoA;
        super.onStop();
        if (!this.f2990b || this.f2991c == null || (downloadInfoA = g.a((Context) null).a(this.f2991c.a())) == null || downloadInfoA.getCurBytes() < downloadInfoA.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    private void c() {
        String str;
        long longExtra = this.a.getLongExtra("model_id", 0L);
        String stringExtra = this.a.getStringExtra("message_text");
        String stringExtra2 = this.a.getStringExtra("positive_button_text");
        String stringExtra3 = this.a.getStringExtra("negative_button_text");
        int intExtra = this.a.getIntExtra("type", 0);
        b bVarD = f.a().d(longExtra);
        d.a aVarC = new d.a(this).a(false).a(stringExtra).b(stringExtra2).c(stringExtra3);
        if (intExtra == 7) {
            if (com.ss.android.downloadlib.addownload.d.b.a() == null) {
                return;
            }
            aVarC.a(com.ss.android.downloadlib.addownload.d.b.a());
            aVarC.a().show();
            str = "download_percent";
        } else if (intExtra != 8) {
            str = "";
        } else {
            if (com.ss.android.downloadlib.addownload.d.a.a() == null) {
                return;
            }
            aVarC.a(com.ss.android.downloadlib.addownload.d.a.a());
            aVarC.a().show();
            str = "apk_size";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f2990b = true;
        this.f2991c = bVarD;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", "show_dialog");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVarD);
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        a(aVar, 5, "", "", "");
    }

    public static void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent intentC = c(aVar);
        intentC.addFlags(268435456);
        intentC.putExtra("type", 2);
        intentC.putExtra("open_url", str);
        if (j.getContext() != null) {
            j.getContext().startActivity(intentC);
        }
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        a(aVar, 7, str, str2, str3);
    }

    private void b() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void b(long j2) {
        if (l.a() == null) {
            return;
        }
        b bVarD = f.a().d(j2);
        if (bVarD != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVarD.s());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - bVarD.T()));
                jSONObject.putOpt("click_download_size", Long.valueOf(bVarD.U()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_dialog_show", jSONObject, bVarD);
        }
        new d.a(this).a(false).a(l.a()).a().show();
        this.f2990b = true;
        this.f2991c = bVarD;
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar) {
        Intent intentC = c(aVar);
        intentC.addFlags(268435456);
        intentC.putExtra("type", 4);
        intentC.putExtra("model_id", aVar.b());
        if (j.getContext() != null) {
            j.getContext().startActivity(intentC);
        }
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar, a aVar2) {
        Intent intentC = c(aVar);
        intentC.addFlags(268435456);
        intentC.putExtra("type", 9);
        f2989d = aVar2;
        if (j.getContext() != null) {
            j.getContext().startActivity(intentC);
        }
    }

    public static void a(long j2) {
        Intent intent = new Intent(j.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j2);
        if (j.getContext() != null) {
            j.getContext().startActivity(intent);
        }
    }

    private void c(long j2) {
        final b bVarD = f.a().d(j2);
        if (bVarD == null) {
            c.a().a("showOpenAppDialogInner nativeModel null");
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            return;
        }
        k kVarC = j.c();
        b.a aVarA = new b.a(this).a("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(bVarD.N()) ? "刚刚下载的应用" : bVarD.N();
        kVarC.b(aVarA.b(String.format("%1$s已安装完成，是否立即打开？", objArr)).c("打开").d("取消").a(false).a(com.ss.android.downloadlib.g.l.c(this, bVarD.e())).a(new b.InterfaceC0074b() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.download.api.model.b.InterfaceC0074b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.b.a.b(bVarD);
                dialogInterface.dismiss();
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0074b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("market_openapp_cancel", bVarD);
                dialogInterface.dismiss();
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0074b
            public void c(DialogInterface dialogInterface) {
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }
        }).a(2).a());
        com.ss.android.downloadlib.d.a.a().b("market_openapp_window_show", bVarD);
    }

    private void b(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            s sVar = new s() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private WeakReference<Activity> f2993c;

                {
                    this.f2993c = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.config.s
                public void a() {
                    com.ss.android.downloadlib.g.j.a(str);
                    com.ss.android.socialbase.appdownloader.c.a(this.f2993c.get());
                }

                @Override // com.ss.android.download.api.config.s
                public void a(String str2) {
                    com.ss.android.downloadlib.g.j.a(str, str2);
                    com.ss.android.socialbase.appdownloader.c.a(this.f2993c.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    j.e().a(this, strArr, sVar);
                    return;
                } catch (Exception e2) {
                    j.s().a(e2, "requestPermission");
                    sVar.a();
                    return;
                }
            }
            sVar.a();
            return;
        }
        com.ss.android.socialbase.appdownloader.c.a((Activity) this);
    }

    public static void a(String str, long j2, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(j.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra(ai.o, str);
        intent.putExtra("model_id", j2);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (j.getContext() != null) {
            j.getContext().startActivity(intent);
        }
    }

    private void b(String str) {
        Intent intentF = com.ss.android.downloadlib.g.l.f(this, str);
        if (intentF == null) {
            return;
        }
        try {
            try {
                intentF.addFlags(268435456);
                intentF.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                startActivity(intentF);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        a(aVar, 8, str, str2, str3);
    }

    private static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, int i2, String str, String str2, String str3) {
        Intent intentC = c(aVar);
        intentC.addFlags(268435456);
        intentC.putExtra("type", i2);
        if (!TextUtils.isEmpty(str2)) {
            intentC.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intentC.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str)) {
            intentC.putExtra("message_text", str);
        }
        intentC.putExtra("model_id", aVar.b());
        if (j.getContext() != null) {
            j.getContext().startActivity(intentC);
        }
    }

    public void a() {
        Intent intent = this.a;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                b(this.a.getStringExtra("permission_id_key"), this.a.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                a(this.a.getStringExtra("open_url"));
                break;
            case 3:
            case 6:
            default:
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                break;
            case 4:
                c(this.a.getLongExtra("model_id", 0L));
                break;
            case 5:
                b(this.a.getLongExtra("model_id", 0L));
                break;
            case 7:
            case 8:
                c();
                break;
            case 9:
                a aVar = f2989d;
                if (aVar != null) {
                    aVar.a();
                }
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                break;
            case 10:
                d(this.a.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                b(this.a.getStringExtra(ai.o));
                break;
            case 12:
                h.a(this, this.a.getStringExtra(ai.o), this.a.getLongExtra("model_id", 0L), this.a.getStringExtra("param"), this.a.getStringExtra("ext_json"));
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                break;
        }
        this.a = null;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                Uri uri = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                intent.putExtra("open_url", str);
                intent.addFlags(268435456);
                if (com.ss.android.socialbase.downloader.g.a.c().a("fix_app_link_flag")) {
                    intent.addFlags(67108864);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }
}
