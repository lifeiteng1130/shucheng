package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdDownloadDialogManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f2998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> f2999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3000d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f3002f;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdDownloadDialogManager.java */
    public interface InterfaceC0079a {
        void a();
    }

    private a() {
        b bVar = new b();
        this.f3002f = bVar;
        this.f2999c = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        if (f2998b == null) {
            f2998b = new a();
        }
        return f2998b;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f3001e = "";
        } else if (TextUtils.equals(this.f3001e, str)) {
            this.f3001e = "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051 A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:21:0x0051, B:22:0x005e, B:23:0x0068, B:25:0x006e, B:28:0x0077, B:30:0x0083, B:33:0x008c, B:35:0x009b, B:38:0x00c1, B:36:0x009f), top: B:42:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:21:0x0051, B:22:0x005e, B:23:0x0068, B:25:0x006e, B:28:0x0077, B:30:0x0083, B:33:0x008c, B:35:0x009b, B:38:0x00c1, B:36:0x009f), top: B:42:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(android.app.Activity r22, com.ss.android.socialbase.downloader.model.DownloadInfo r23, boolean r24, com.ss.android.downloadlib.addownload.a.a.InterfaceC0079a r25) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.a.a.a(android.app.Activity, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, com.ss.android.downloadlib.addownload.a.a$a):boolean");
    }

    @MainThread
    public boolean a(Activity activity, boolean z, InterfaceC0079a interfaceC0079a) {
        if (j.i().optInt("disable_install_app_dialog") == 1 || this.f3000d) {
            return false;
        }
        return a(activity, a(activity), z, interfaceC0079a);
    }

    public void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, boolean z, InterfaceC0079a interfaceC0079a) {
        this.f2999c.clear();
        a(context, aVar, interfaceC0079a, z);
        this.f3000d = true;
        g.a(context).c();
        this.f3002f.b("sp_ad_install_back_dialog", "key_uninstalled_list");
        k.a(a, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo a(Context context) {
        long jB;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            jB = g.a(context).b();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (j.i().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK)) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j2 = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !l.d(context, downloadInfo2.getPackageName()) && l.a(downloadInfo2.getTargetFilePath())) {
                    long jLastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (jLastModified >= jB && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j2 == 0 || jLastModified > j2)) {
                                downloadInfo = downloadInfo2;
                                j2 = jLastModified;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        for (int i2 = 0; i2 < this.f2999c.size(); i2++) {
            com.ss.android.downloadlib.addownload.b.a aVar = this.f2999c.get(i2);
            if (aVar != null && aVar.f3022b == j3) {
                this.f2999c.set(i2, new com.ss.android.downloadlib.addownload.b.a(j2, j3, j4, str, str2, str3, str4));
                this.f3002f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f2999c);
                return;
            }
        }
        this.f2999c.add(new com.ss.android.downloadlib.addownload.b.a(j2, j3, j4, str, str2, str3, str4));
        this.f3002f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f2999c);
    }

    private void a(final Context context, final com.ss.android.downloadlib.addownload.b.a aVar, final InterfaceC0079a interfaceC0079a, boolean z) {
        final com.ss.android.downloadad.api.a.b bVarD = f.a().d(aVar.f3022b);
        if (bVarD == null) {
            com.ss.android.downloadlib.e.c.a().a("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.download.api.config.k kVarC = j.c();
        b.a aVarA = new b.a(context).a(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(aVar.f3025e) ? "刚刚下载的应用" : aVar.f3025e;
        kVarC.b(aVarA.b(String.format("%1$s下载完成，是否立即安装？", objArr)).c("立即安装").d(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).a(false).a(l.a(context, aVar.f3027g)).a(new b.InterfaceC0074b() { // from class: com.ss.android.downloadlib.addownload.a.a.1
            @Override // com.ss.android.download.api.model.b.InterfaceC0074b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_install", bVarD);
                com.ss.android.socialbase.appdownloader.d.a(context, (int) aVar.a);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0074b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_exit", bVarD);
                InterfaceC0079a interfaceC0079a2 = interfaceC0079a;
                if (interfaceC0079a2 != null) {
                    interfaceC0079a2.a();
                }
                a.this.b("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0074b
            public void c(DialogInterface dialogInterface) {
                a.this.b("");
            }
        }).a(1).a());
        com.ss.android.downloadlib.d.a.a().b("backdialog_show", bVarD);
        this.f3001e = aVar.f3024d;
    }

    public boolean a(String str) {
        return TextUtils.equals(this.f3001e, str);
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        if (j.i().optInt("enable_open_app_dialog", 0) == 1 && !bVar.Z() && bVar.q()) {
            bVar.k(true);
            TTDelegateActivity.a(bVar);
        }
    }
}
