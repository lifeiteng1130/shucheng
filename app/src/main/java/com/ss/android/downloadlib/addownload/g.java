package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.g.j;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DownloadHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements m.a {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.android.downloadlib.addownload.b.e f3141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3142c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f3143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f3144e;

    /* JADX INFO: compiled from: DownloadHelper.java */
    public static class a extends com.ss.android.socialbase.downloader.depend.a {
        private m a;

        public a(m mVar) {
            this.a = mVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.a, com.ss.android.socialbase.downloader.depend.s
        public void a(DownloadInfo downloadInfo) {
            a(downloadInfo, 11);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            a(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            a(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            a(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            a(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            a(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            a(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            a(downloadInfo, -3);
        }

        private void a(DownloadInfo downloadInfo, int i2) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.obj = downloadInfo;
            messageObtain.arg1 = i2;
            this.a.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: compiled from: DownloadHelper.java */
    public interface b {
        void a(DownloadInfo downloadInfo);
    }

    public g(e eVar) {
        this.f3143d = eVar;
    }

    private boolean c() {
        return d() && e();
    }

    private boolean d() {
        DownloadModel downloadModel = this.f3141b.f3052b;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.f3141b.f3052b.getDownloadUrl())) ? false : true;
    }

    private boolean e() {
        return this.f3141b.f3054d.isAddToDownloadManage();
    }

    private boolean f() {
        return com.ss.android.downloadlib.g.l.a(this.f3141b.f3052b) && h.a(this.f3141b.f3054d.getLinkMode());
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
    }

    private boolean e(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.g.l.a(this.f3141b.f3052b) && f(downloadInfo);
    }

    private boolean f(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.i.f.d(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    public void a(long j2) {
        this.a = j2;
        com.ss.android.downloadlib.addownload.b.e eVarE = com.ss.android.downloadlib.addownload.b.f.a().e(j2);
        this.f3141b = eVarE;
        if (eVarE.x()) {
            com.ss.android.downloadlib.e.c.a().a("setAdId ModelBox notValid");
        }
    }

    public void b(@Nullable DownloadInfo downloadInfo) {
        b bVar = this.f3144e;
        if (bVar != null) {
            bVar.a(downloadInfo);
            this.f3144e = null;
        }
    }

    public void c(DownloadInfo downloadInfo) {
        if (!h.a(this.f3141b.f3052b) || this.f3142c) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a("file_status", (downloadInfo == null || !com.ss.android.downloadlib.g.l.b(downloadInfo.getTargetFilePath())) ? 2 : 1, this.f3141b);
        this.f3142c = true;
    }

    public boolean d(DownloadInfo downloadInfo) {
        return f() || e(downloadInfo);
    }

    private void b(final s sVar) {
        if (!com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE")) {
            com.ss.android.downloadlib.g.j.a(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new j.a() { // from class: com.ss.android.downloadlib.addownload.g.2
                @Override // com.ss.android.downloadlib.g.j.a
                public void a() {
                    s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.a();
                    }
                }

                @Override // com.ss.android.downloadlib.g.j.a
                public void a(String str) {
                    s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.a(str);
                    }
                }
            });
        } else if (sVar != null) {
            sVar.a();
        }
    }

    public void a(DownloadInfo downloadInfo) {
        this.f3142c = false;
        b(downloadInfo);
    }

    public boolean a(Context context, int i2, boolean z) {
        if (com.ss.android.downloadlib.g.l.a(this.f3141b.f3052b)) {
            com.ss.android.downloadad.api.a.b bVarD = com.ss.android.downloadlib.addownload.b.f.a().d(this.f3141b.a);
            if (bVarD != null) {
                com.ss.android.socialbase.downloader.notification.b.a().f(bVarD.s());
            }
            return com.ss.android.downloadlib.b.a.a(this.f3141b);
        }
        if (a(i2) && !TextUtils.isEmpty(this.f3141b.f3052b.getPackageName()) && j.i().optInt("disable_market") != 1) {
            return com.ss.android.downloadlib.b.a.a(this.f3141b, i2);
        }
        if (!z || this.f3141b.f3054d.getDownloadMode() != 4 || this.f3143d.e()) {
            return false;
        }
        this.f3143d.c(true);
        return true;
    }

    @Nullable
    public String b() {
        File externalFilesDir = j.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    @NonNull
    public static List<com.ss.android.download.api.download.a> b(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.a) {
                    arrayList.add((com.ss.android.download.api.download.a) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof com.ss.android.download.api.download.a) {
                        arrayList.add((com.ss.android.download.api.download.a) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean a(int i2) {
        if (this.f3141b.f3054d.getDownloadMode() == 2 && i2 == 2) {
            return true;
        }
        return this.f3141b.f3054d.getDownloadMode() == 2 && i2 == 1 && j.i().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean a(boolean z) {
        return !z && this.f3141b.f3054d.getDownloadMode() == 1;
    }

    public void a(@NonNull final s sVar) {
        if (!TextUtils.isEmpty(this.f3141b.f3052b.getFilePath())) {
            String filePath = this.f3141b.f3052b.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                sVar.a();
                return;
            } else {
                try {
                    if (filePath.startsWith(j.getContext().getExternalCacheDir().getParent())) {
                        sVar.a();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
        }
        b(new s() { // from class: com.ss.android.downloadlib.addownload.g.1
            @Override // com.ss.android.download.api.config.s
            public void a() {
                sVar.a();
            }

            @Override // com.ss.android.download.api.config.s
            public void a(String str) {
                j.c().a(1, j.getContext(), g.this.f3141b.f3052b, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.d.a.a().b(g.this.a, 1);
                sVar.a(str);
            }
        });
    }

    public void a(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        b bVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i2 = message.arg1;
        if (i2 != 1 && i2 != 6 && i2 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.f fVarA = com.ss.android.downloadlib.f.a();
                com.ss.android.downloadlib.addownload.b.e eVar = this.f3141b;
                fVarA.a(eVar.f3052b, eVar.f3054d, eVar.f3053c);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.d.a.a().a(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        i.a(downloadShortInfo);
        int iA = com.ss.android.socialbase.appdownloader.c.a(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) && (bVar = this.f3144e) != null) {
            bVar.a(downloadInfo);
            this.f3144e = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : a(map)) {
            if (iA != 1) {
                if (iA == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, i.a(downloadInfo.getId(), curBytes));
                } else if (iA == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.g.l.a(this.f3141b.f3052b)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, i.a(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.ss.android.download.api.download.a> it = b(map).iterator();
                while (it.hasNext()) {
                    it.next().a(downloadInfo);
                }
            }
        }
    }

    public void a() {
        if (this.f3144e == null) {
            this.f3144e = new b() { // from class: com.ss.android.downloadlib.addownload.g.3
                @Override // com.ss.android.downloadlib.addownload.g.b
                public void a(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.d.a.a().a(g.this.a, 2, downloadInfo);
                }
            };
        }
    }

    public int a(Context context, IDownloadListener iDownloadListener) {
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.f3141b.f3052b.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.c(entry.getKey(), entry.getValue()));
                }
            }
        }
        String strA = com.ss.android.downloadlib.g.d.a(String.valueOf(this.f3141b.f3052b.getId()), this.f3141b.f3052b.getNotificationJumpUrl(), this.f3141b.f3052b.isShowToast(), String.valueOf(this.f3141b.f3052b.getModelType()));
        com.ss.android.socialbase.downloader.g.a aVarB = com.ss.android.downloadlib.g.e.b(this.f3141b.f3052b);
        JSONObject jSONObjectA = com.ss.android.downloadlib.g.e.a(this.f3141b.f3052b);
        if (!this.f3141b.f3054d.enableAH()) {
            jSONObjectA = com.ss.android.downloadlib.g.l.a(jSONObjectA);
            com.ss.android.downloadlib.g.l.a(jSONObjectA, "ah_plans", new JSONArray());
        }
        int executorGroup = this.f3141b.f3052b.getExecutorGroup();
        if (this.f3141b.f3052b.isAd() || h.b(this.f3141b.f3052b)) {
            executorGroup = 4;
        }
        String strA2 = a(aVarB);
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.c.a(this.f3141b.f3052b.getDownloadUrl(), strA2));
        if (downloadInfo != null && 3 == this.f3141b.f3052b.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.f fVarO = new com.ss.android.socialbase.appdownloader.f(context, this.f3141b.f3052b.getDownloadUrl()).b(this.f3141b.f3052b.getBackupUrls()).a(this.f3141b.f3052b.getName()).d(strA).a(arrayList).a(this.f3141b.f3052b.isShowNotification()).c(this.f3141b.f3052b.isNeedWifi()).b(this.f3141b.f3052b.getFileName()).c(strA2).j(this.f3141b.f3052b.getAppIcon()).g(this.f3141b.f3052b.getMd5()).i(this.f3141b.f3052b.getSdkMonitorScene()).a(this.f3141b.f3052b.getExpectFileLength()).a(iDownloadListener).l(this.f3141b.f3052b.needIndependentProcess() || aVarB.a("need_independent_process", 0) == 1).a(this.f3141b.f3052b.getDownloadFileUriProvider()).b(this.f3141b.f3052b.autoInstallWithoutNotification()).f(this.f3141b.f3052b.getPackageName()).d(1000).e(100).a(jSONObjectA).i(true).j(true).b(aVarB.a("retry_count", 5)).c(aVarB.a("backup_url_retry_count", 0)).j(true).m(aVarB.a("need_head_connection", 0) == 1).d(aVarB.a("need_https_to_http_retry", 0) == 1).h(aVarB.a("need_chunk_downgrade_retry", 1) == 1).g(aVarB.a("need_retry_delay", 0) == 1).h(aVarB.c("retry_delay_time_array")).k(aVarB.a("need_reuse_runnable", 0) == 1).f(executorGroup).p(this.f3141b.f3052b.isAutoInstall()).o(this.f3141b.f3052b.distinctDir());
        if (!TextUtils.isEmpty(this.f3141b.f3052b.getMimeType())) {
            fVarO.e(this.f3141b.f3052b.getMimeType());
        } else {
            fVarO.e(AdBaseConstants.MIME_APK);
        }
        if (aVarB.a("notification_opt_2", 0) == 1) {
            fVarO.a(false);
            fVarO.b(true);
        }
        com.ss.android.downloadlib.addownload.c.a aVar = null;
        if (aVarB.a("clear_space_use_disk_handler", 0) == 1) {
            aVar = new com.ss.android.downloadlib.addownload.c.a();
            fVarO.a(aVar);
        }
        int iA = h.a(this.f3141b, c(), fVarO);
        if (aVar != null) {
            aVar.a(iA);
        }
        return iA;
    }

    private String a(com.ss.android.socialbase.downloader.g.a aVar) {
        if (!TextUtils.isEmpty(this.f3141b.f3052b.getFilePath())) {
            return this.f3141b.f3052b.getFilePath();
        }
        DownloadInfo downloadInfoA = com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), this.f3141b.f3052b.getDownloadUrl());
        boolean zB = com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE");
        String strB = b();
        if (downloadInfoA != null && !TextUtils.isEmpty(downloadInfoA.getSavePath())) {
            String savePath = downloadInfoA.getSavePath();
            if (zB || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(strB)) {
                    if (savePath.startsWith(strB)) {
                        return savePath;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(downloadInfoA.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(zB ? 1 : 2));
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("label_external_permission", jSONObject, this.f3141b);
        String strB2 = null;
        try {
            strB2 = com.ss.android.socialbase.appdownloader.c.b();
        } catch (Exception unused) {
        }
        int iA = com.ss.android.downloadlib.g.e.a(aVar);
        if (iA != 0) {
            if (iA != 4 && (zB || iA != 2)) {
                if ((iA == 3 || (!zB && iA == 1)) && !TextUtils.isEmpty(strB)) {
                    return strB;
                }
            } else {
                File filesDir = j.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            }
        }
        return strB2;
    }

    public void a(DownloadInfo downloadInfo, boolean z) {
        if (this.f3141b.f3052b == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status == -1 || status == -4 || h.a(this.f3141b.f3052b)) {
            com.ss.android.downloadlib.d.a.a().a(this.a, 2);
        } else if (z && com.ss.android.downloadlib.d.c.a().c() && (status == -2 || status == -3)) {
            com.ss.android.downloadlib.d.a.a().a(this.a, 2);
        }
        switch (status) {
            case -4:
            case -1:
                a();
                com.ss.android.downloadlib.addownload.b.f fVarA = com.ss.android.downloadlib.addownload.b.f.a();
                com.ss.android.downloadlib.addownload.b.e eVar = this.f3141b;
                fVarA.a(new com.ss.android.downloadad.api.a.b(eVar.f3052b, eVar.f3053c, eVar.f3054d, downloadInfo.getId()));
                break;
            case -3:
                if (com.ss.android.downloadlib.g.l.a(this.f3141b.f3052b)) {
                    com.ss.android.downloadlib.e.c.a().b("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.ss.android.downloadlib.d.a.a().a(this.a, 5, downloadInfo);
                    if (z && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.a, this.f3141b.f3052b.getLogExtra())) {
                        com.ss.android.downloadlib.d.a.a().a(this.a, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.ss.android.downloadlib.d.a.a().a(this.a, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.a, this.f3141b.f3052b.getLogExtra())) {
                    com.ss.android.downloadlib.d.a.a().a(this.a, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.d.a.a().a(this.a, 3, downloadInfo);
                break;
        }
    }

    public void a(DownloadInfo downloadInfo, DownloadShortInfo downloadShortInfo, List<DownloadStatusChangeListener> list) {
        if (list.isEmpty()) {
            return;
        }
        if (downloadInfo != null && downloadShortInfo != null) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            int curBytes = downloadInfo.getTotalBytes() > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes()) : 0;
            int i2 = curBytes >= 0 ? curBytes : 0;
            downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
            i.a(downloadShortInfo);
            for (DownloadStatusChangeListener downloadStatusChangeListener : list) {
                switch (downloadInfo.getStatus()) {
                    case -4:
                    case 0:
                        if (com.ss.android.downloadlib.g.l.a(this.f3141b.f3052b)) {
                            downloadShortInfo.status = -3;
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onIdle();
                        }
                        break;
                    case -3:
                        if (com.ss.android.downloadlib.g.l.a(this.f3141b.f3052b)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                        break;
                    case -2:
                        downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, i.a(downloadInfo.getId(), i2));
                        break;
                    case -1:
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                        downloadStatusChangeListener.onDownloadActive(downloadShortInfo, i.a(downloadInfo.getId(), i2));
                        break;
                    case 11:
                        if (downloadStatusChangeListener instanceof com.ss.android.download.api.download.a) {
                            ((com.ss.android.download.api.download.a) downloadStatusChangeListener).a(downloadInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadActive(downloadShortInfo, i.a(downloadInfo.getId(), i2));
                        }
                        break;
                }
            }
            return;
        }
        Iterator<DownloadStatusChangeListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
    }

    @NonNull
    public static List<DownloadStatusChangeListener> a(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof DownloadStatusChangeListener) {
                        arrayList.add((DownloadStatusChangeListener) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }
}
