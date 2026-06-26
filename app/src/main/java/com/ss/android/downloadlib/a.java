package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.constants.ErrorCode;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.b.d;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.c.h;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.k;
import com.umeng.commonsdk.statistics.SdkVersion;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdDownloadCompletedEventHandlerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.ss.android.downloadad.api.a, b.c, a.InterfaceC0092a, ag {
    private static String a = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f2957d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f2959c;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdDownloadCompletedEventHandlerImpl.java */
    @WorkerThread
    public class RunnableC0075a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2967b;

        public RunnableC0075a(int i2) {
            this.f2967b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.b.f.a().b();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> concurrentHashMapC = com.ss.android.downloadlib.addownload.b.f.a().c();
                if (concurrentHashMapC == null || concurrentHashMapC.isEmpty()) {
                    return;
                }
                a.this.a(concurrentHashMapC, this.f2967b);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: AdDownloadCompletedEventHandlerImpl.java */
    public static class b implements Runnable {
        private long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f2969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2970d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f2971e;

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f2971e = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a()) {
                    a.a().a(this.a, this.f2968b);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private b(long j2, int i2, long j3, int i3) {
            this.a = j2;
            this.f2968b = i2;
            this.f2969c = j3;
            this.f2970d = i3;
        }

        public boolean a() {
            DownloadInfo downloadInfo;
            JSONObject jSONObject;
            com.ss.android.downloadad.api.a.b bVarD = com.ss.android.downloadlib.addownload.b.f.a().d(this.a);
            if (bVarD == null || l.b(bVarD) || bVarD.f2947c.get() || (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVarD.s())) == null) {
                return false;
            }
            long jM = bVarD.M();
            long jA = l.a(Environment.getDataDirectory());
            long jMin = Math.min(524288000L, jA / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = totalBytes;
            boolean z = jM <= -1 || totalBytes <= -1 || ((double) jM) >= (2.5d * d2) + ((double) jMin);
            boolean zA = com.ss.android.socialbase.appdownloader.b.a(j.getContext());
            JSONObject jSONObject2 = new JSONObject();
            int iA = a(z, bVarD, downloadInfo, zA, jSONObject2);
            this.f2970d = iA;
            try {
                jSONObject = jSONObject2;
                try {
                    jSONObject.putOpt("fail_status", Integer.valueOf(iA));
                    jSONObject.putOpt("available_space", Long.valueOf(jM / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED));
                    jSONObject.putOpt("total_space", Long.valueOf(jA / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED));
                    if (totalBytes > 0) {
                        jSONObject.putOpt("package_size", Long.valueOf(totalBytes / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED));
                    }
                    jSONObject.putOpt("space_enough", Integer.valueOf(z ? 1 : 2));
                    if (jM > 0 && totalBytes > 0) {
                        jSONObject.put("available_space_ratio", jM / d2);
                    }
                    jSONObject.putOpt("permission_unknown_source_install", Integer.valueOf(zA ? 1 : 2));
                    jSONObject.put("is_update_download", bVarD.V() ? 1 : 2);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                jSONObject = jSONObject2;
            }
            com.ss.android.downloadlib.d.a.a().b("install_failed", jSONObject, bVarD);
            return true;
        }

        private int a(boolean z, com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            int i2 = 1;
            if (aVarA.a("install_failed_check_ttmd5", 1) == 1) {
                int iCheckMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", iCheckMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.i.f.a(iCheckMd5Status)) {
                    return 2005;
                }
            }
            int i3 = this.f2970d;
            if (i3 != 2000) {
                return i3;
            }
            if (aVarA.a("install_failed_check_signature", 1) == 1 && l.d(j.getContext(), bVar.e())) {
                if (!l.a(l.h(j.getContext(), downloadInfo.getTargetFilePath()), l.g(j.getContext(), bVar.e()))) {
                    return 2006;
                }
            }
            if (!z) {
                return ErrorCode.INNER_ERROR;
            }
            long j2 = this.f2971e;
            long j3 = this.f2969c;
            if (j2 <= j3) {
                return RecyclerView.MAX_SCROLL_DURATION;
            }
            try {
                jSONObject.put("install_time", j2 - j3);
                if (bVar.C() <= this.f2969c) {
                    i2 = 0;
                }
                jSONObject.put("install_again", i2);
            } catch (Throwable unused2) {
            }
            if (z2) {
                return 2004;
            }
            return ErrorCode.NOT_INIT;
        }
    }

    /* JADX INFO: compiled from: AdDownloadCompletedEventHandlerImpl.java */
    public class c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.ss.android.downloadad.api.a.b f2972b;

        public c(com.ss.android.downloadad.api.a.b bVar) {
            this.f2972b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.f2972b.j(true);
                    a.this.c(this.f2972b);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.f2972b.j(false);
            }
        }
    }

    private a() {
        com.ss.android.socialbase.appdownloader.b.a(this);
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static JSONObject b(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long jA = l.a(0L);
            double d2 = jA;
            jSONObject.put("available_space", d2 / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d3 = totalBytes;
            jSONObject.put("apk_size", d3 / 1048576.0d);
            if (jA > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d2 / d3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void c(com.ss.android.downloadad.api.a.b bVar) {
        SystemClock.sleep(20000L);
        int i2 = 15;
        while (i2 > 0) {
            if (l.b(bVar)) {
                a(bVar.e());
                return;
            }
            i2--;
            if (i2 == 0) {
                return;
            } else {
                SystemClock.sleep(20000L);
            }
        }
    }

    public synchronized void d() {
        b bVar = this.f2959c;
        if (bVar != null) {
            bVar.b();
            this.f2959c = null;
        }
    }

    public static a a() {
        if (f2957d == null) {
            synchronized (a.class) {
                if (f2957d == null) {
                    f2957d = new a();
                }
            }
        }
        return f2957d;
    }

    public static String c(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = j.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.c.a());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.getPackageName());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "package_name_error", jSONObject, bVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    private int d(com.ss.android.downloadad.api.a.b bVar) {
        int realStatus;
        double dA = com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("download_failed_finally_hours", 48.0d);
        if (dA <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - bVar.H() < dA * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (bVar.f2948d.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && bVar.f2948d.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                a(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(bVar.E()));
                jSONObject.putOpt("fail_msg", bVar.F());
                jSONObject.put("download_failed_times", bVar.x());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", bVar.V() ? 1 : 2);
                com.ss.android.downloadlib.d.a.a().a(bVar.j(), "download_failed_finally", jSONObject, bVar);
                i.a().a(bVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    @WorkerThread
    public static synchronized void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.e.c.a().a("onDownloadFinish info null");
            return;
        }
        if (bVar == null) {
            com.ss.android.downloadlib.e.c.a().a("onDownloadFinish nativeModel null");
            return;
        }
        if (bVar.G() != 1) {
            return;
        }
        h.a().d(bVar);
        String strC = c(downloadInfo, bVar);
        com.ss.android.downloadlib.addownload.b.f.a().b(downloadInfo.getUrl(), strC);
        Map<Long, com.ss.android.downloadad.api.a.b> mapA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo.getUrl(), strC);
        bVar.f(System.currentTimeMillis());
        bVar.e(2);
        bVar.b(strC);
        mapA.put(Long.valueOf(bVar.b()), bVar);
        i.a().a(mapA.values());
        b(bVar);
        f.a().a(downloadInfo, strC);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
            a().a(bVar);
            a().b(downloadInfo, bVar);
            if (bVar.L()) {
                com.ss.android.downloadlib.addownload.a.a.a().a(downloadInfo.getId(), bVar.b(), bVar.l(), strC, downloadInfo.getTitle(), bVar.d(), downloadInfo.getTargetFilePath());
            }
            com.ss.android.downloadlib.addownload.e.a.a(downloadInfo, bVar.b(), bVar.d(), strC);
        }
    }

    public void b(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.a.b bVar) {
        if (downloadInfo == null || bVar == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        d.a().b(new Runnable() { // from class: com.ss.android.downloadlib.a.3
            @Override // java.lang.Runnable
            public void run() {
                String strA = com.ss.android.downloadlib.g.a.a(targetFilePath);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                j.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(bVar.b()), strA).apply();
            }
        });
    }

    private static void b(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        String strP = TextUtils.isEmpty(bVar.P()) ? "" : bVar.P();
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s());
        bVar.l("");
        i.a().a(bVar);
        JSONObject jSONObjectA = a(new JSONObject(), downloadInfo);
        int i2 = 1;
        try {
            jSONObjectA.putOpt("finish_reason", strP);
            jSONObjectA.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadad.api.a.b bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        com.ss.android.downloadlib.g.f.a(jSONObjectA, downloadInfo.getId());
        try {
            jSONObjectA.put("download_failed_times", bVarA.x());
            jSONObjectA.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                jSONObjectA.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            jSONObjectA.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            jSONObjectA.put("has_send_download_failed_finally", bVarA.f2948d.get() ? 1 : 2);
            if (!bVarA.V()) {
                i2 = 2;
            }
            jSONObjectA.put("is_update_download", i2);
            com.ss.android.downloadlib.g.f.a(bVarA, jSONObjectA);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("download_finish", jSONObjectA, bVar);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
    public void c() {
        com.ss.android.socialbase.downloader.c.a.b(a, "onAppBackground()");
        a(6);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
    public void b() {
        com.ss.android.socialbase.downloader.c.a.b(a, "onAppForeground()");
        d();
        a(5);
    }

    @WorkerThread
    public synchronized void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!l.a()) {
            final com.ss.android.downloadad.api.a.b bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(str);
            if (bVarA == null) {
                com.ss.android.downloadlib.addownload.b.d.a().a(str);
                return;
            }
            com.ss.android.downloadlib.addownload.e eVarA = f.a().a(bVarA.a());
            if (eVarA != null) {
                eVarA.f();
            }
            if (bVarA.f2947c.get()) {
                return;
            }
            if (com.ss.android.socialbase.downloader.g.a.a(bVarA.s()).b("notification_opt_2") == 1) {
                com.ss.android.socialbase.downloader.notification.b.a().f(bVarA.s());
            }
            new com.ss.android.downloadlib.b.b().a(bVarA, new com.ss.android.downloadlib.b.g() { // from class: com.ss.android.downloadlib.a.1
                @Override // com.ss.android.downloadlib.b.g
                public void a(boolean z) {
                    com.ss.android.socialbase.downloader.c.a.b(a.a, "appBackForeground->" + z);
                    if (!z) {
                        if (com.ss.android.downloadlib.b.a.a(str, bVarA) || bVarA.K() != 4) {
                            return;
                        }
                        com.ss.android.downloadlib.addownload.a.a.a().a(bVarA);
                        return;
                    }
                    if (!(com.ss.android.downloadlib.b.f.c(bVarA) ? com.ss.android.downloadlib.b.a.a(str, bVarA) : false) && com.ss.android.downloadlib.b.f.d(bVarA) && bVarA.K() == 4) {
                        com.ss.android.downloadlib.addownload.a.a.a().a(bVarA);
                    }
                }
            }, com.ss.android.downloadlib.g.e.a(bVarA).a("try_applink_delay_after_installed", 0));
            h.a().f(bVarA);
            a(str, bVarA);
            com.ss.android.downloadlib.addownload.a.a.a().b(str);
            DownloadInfo downloadInfoA = a((List<DownloadInfo>) Downloader.getInstance(j.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK), str);
            if (downloadInfoA != null) {
                if (com.ss.android.socialbase.downloader.g.a.a(downloadInfoA.getId()).b("no_hide_notification") != 1) {
                    com.ss.android.socialbase.downloader.notification.b.a().a(downloadInfoA.getId());
                }
                f.a().b(downloadInfoA, str);
                com.ss.android.downloadlib.addownload.c.d.a(downloadInfoA);
            } else {
                f.a().b(null, str);
            }
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    private JSONObject b(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        com.ss.android.downloadad.api.a.b bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (bVarA == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        aVar.a(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.g.f.a(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, bVarA);
        return jSONObject;
    }

    public void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar, int i2) {
        long jMax;
        if (downloadInfo == null || bVar == null) {
            return;
        }
        d();
        long jCurrentTimeMillis = System.currentTimeMillis();
        bVar.b(jCurrentTimeMillis);
        bVar.g(l.a(Environment.getDataDirectory(), -1L));
        if (i2 != 2000) {
            jMax = 2000;
        } else {
            long jA = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("check_install_failed_delay_time", 120000L);
            if (jA < 0) {
                return;
            } else {
                jMax = Math.max(jA, 30000L);
            }
        }
        long j2 = jMax;
        b bVar2 = new b(bVar.b(), downloadInfo.getId(), jCurrentTimeMillis, i2);
        d.a().a(bVar2, j2);
        this.f2959c = bVar2;
        i.a().a(bVar);
    }

    public void a(final long j2, int i2) {
        long jA = com.ss.android.socialbase.downloader.g.a.a(i2).a("check_install_finish_hijack_delay_time", 900000L);
        if (jA < 0) {
            return;
        }
        d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.a().a(j2);
            }
        }, Math.max(jA, 300000L));
    }

    public void a(long j2) {
        d.a aVarA;
        int iIntValue;
        try {
            com.ss.android.downloadad.api.a.b bVarD = com.ss.android.downloadlib.addownload.b.f.a().d(j2);
            if (bVarD != null && !l.b(bVarD) && !bVarD.f2947c.get()) {
                Pair<d.a, Integer> pairB = com.ss.android.downloadlib.addownload.b.d.a().b(bVarD);
                if (pairB != null) {
                    aVarA = (d.a) pairB.first;
                    iIntValue = ((Integer) pairB.second).intValue();
                } else {
                    aVarA = com.ss.android.downloadlib.addownload.b.d.a().a(bVarD);
                    iIntValue = -1;
                }
                if (aVarA == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.b.d.a().b(aVarA.a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", aVarA.f3050d);
                jSONObject.put("installed_pkg_name", aVarA.a);
                if (iIntValue != -1) {
                    jSONObject.put("error_code", iIntValue);
                    com.ss.android.downloadlib.g.f.a(jSONObject, bVarD.s());
                    com.ss.android.downloadlib.d.a.a().b("install_finish_hijack", jSONObject, bVarD);
                    return;
                }
                com.ss.android.downloadlib.d.a.a().b("install_finish_may_hijack", jSONObject, bVarD);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.e.c.a().a(th, "trySendInstallFinishHijack");
        }
    }

    public void a(String str, com.ss.android.downloadad.api.a.b bVar) {
        if (bVar != null && l.b(bVar) && bVar.f2947c.compareAndSet(false, true)) {
            com.ss.android.downloadlib.d.a.a().a(bVar.j(), "install_finish", a(bVar, str, bVar.K() != 4 ? 3 : 4), bVar);
            i.a().a(bVar);
        }
    }

    private static DownloadInfo a(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (l.a(j.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject a(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i2 = 1;
            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", k.a().b().name());
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put("chunk_downgrade_retry_used", downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                jSONObject.put("md5", downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                    double d2 = curBytes / realDownloadTime;
                    try {
                        jSONObject.put("download_speed", d2);
                    } catch (Exception unused) {
                    }
                    com.ss.android.socialbase.downloader.c.a.b(a, "download speed : " + d2 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(j.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.c.d.a().b(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!com.ss.android.socialbase.downloader.i.f.c(j.getContext())) {
                    i2 = 2;
                }
                jSONObject.put("network_available", i2);
                jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                b(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    private int a(com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int iB = com.ss.android.socialbase.appdownloader.c.b(j.getContext(), downloadInfo);
        int iB2 = l.b(j.getContext(), str);
        if (iB > 0 && iB2 > 0 && iB != iB2) {
            return iB2 > iB ? 3011 : 3010;
        }
        if (com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("install_finish_check_ttmd5", 1) != 1) {
            return ErrorCode.NETWORK_ERROR;
        }
        String string = j.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(bVar.b()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.g.a.a(downloadInfo.getTargetFilePath());
        }
        int iA = com.ss.android.downloadlib.g.a.a(string, com.ss.android.downloadlib.g.a.b(str));
        try {
            jSONObject.put("ttmd5_status", iA);
        } catch (Throwable unused) {
        }
        if (iA == 0) {
            return 3000;
        }
        return iA == 1 ? ErrorCode.NETWORK_TIMEOUT : ErrorCode.NETWORK_ERROR;
    }

    @Override // com.ss.android.downloadad.api.a
    public void a(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f2958b < 120000) {
            return;
        }
        d.a().a(new RunnableC0075a(i2), this.f2958b > 0 ? 2000L : 8000L);
        this.f2958b = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void a(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> concurrentHashMap, int i2) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.a.b bVar : concurrentHashMap.values()) {
            if (bVar.f2947c.get()) {
                if (jCurrentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.G() == 1) {
                if (d(bVar) <= 0 && jCurrentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.G() == 2) {
                if (!bVar.Y()) {
                    if (l.b(bVar)) {
                        if (bVar.K() == 4) {
                            i2 = bVar.K();
                        }
                        com.ss.android.downloadlib.d.a.a().a(a(bVar, bVar.e(), i2), bVar);
                        arrayList.add(Long.valueOf(bVar.b()));
                        com.ss.android.downloadlib.addownload.c.d.a(bVar);
                    } else if (jCurrentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    } else if (TextUtils.isEmpty(bVar.e())) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(bVar.b()));
            }
        }
        com.ss.android.downloadlib.addownload.b.f.a().a(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.c
    public void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        JSONObject jSONObjectB;
        if (downloadInfo == null || aVar == null) {
            return;
        }
        JSONArray jSONArrayE = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).e("ah_report_config");
        if (aVar.f3294b != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (jSONArrayE == null || (jSONObjectB = b(downloadInfo, aVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", jSONObjectB);
    }

    @Override // com.ss.android.socialbase.downloader.depend.ag
    public void a(@Nullable final DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.e.c.a().a("info is null");
        } else if ((com.ss.android.socialbase.downloader.g.a.a(downloadInfo).b("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.b.e.a().b(new com.ss.android.downloadlib.b.d() { // from class: com.ss.android.downloadlib.a.4
                @Override // com.ss.android.downloadlib.b.d
                public void a(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.c.a(j.getContext(), intent);
                            l.a(jSONObject, "backup", (Object) 1);
                        } else {
                            l.a(jSONObject, "backup", (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.a.b bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                    if (bVarA != null) {
                        com.ss.android.downloadlib.d.a.a().a(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, bVarA);
                    } else {
                        com.ss.android.downloadlib.e.c.a().b("ah nativeModel=null");
                    }
                    if (z) {
                        j.t().a(j.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        d.a().a(new c(bVar));
    }

    private JSONObject a(com.ss.android.downloadad.api.a.b bVar, String str, int i2) {
        com.ss.android.socialbase.appdownloader.a aVarA;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s());
            jSONObject.putOpt("scene", Integer.valueOf(i2));
            com.ss.android.downloadlib.g.f.a(jSONObject, bVar.s());
            com.ss.android.downloadlib.g.f.a(bVar, jSONObject);
            jSONObject.put("is_update_download", bVar.V() ? 1 : 2);
            jSONObject.put("install_after_back_app", bVar.ab() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", bVar.R() ? SdkVersion.MINI_VERSION : ExifInterface.GPS_MEASUREMENT_2D);
            if (downloadInfo != null) {
                a(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (bVar.C() > 0) {
                        jSONObject.put("install_time", System.currentTimeMillis() - bVar.C());
                    }
                } catch (Throwable unused) {
                }
                String strA = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(strA) && (aVarA = com.ss.android.socialbase.appdownloader.a.a(strA)) != null) {
                    aVarA.a(jSONObject);
                }
            }
            int iA = a(bVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", iA);
            if (iA == 3000) {
                jSONObject.put("hijack", 2);
            } else if (iA == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void a(DownloadInfo downloadInfo, long j2, long j3, long j4, long j5, long j6, boolean z) {
        com.ss.android.downloadad.api.a.b bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (bVarA == null) {
            com.ss.android.downloadlib.e.c.a().a("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j2 / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j5));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j4));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j4 - j3) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j6));
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            com.ss.android.downloadlib.d.a.a().a("cleanup", jSONObject, bVarA);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
