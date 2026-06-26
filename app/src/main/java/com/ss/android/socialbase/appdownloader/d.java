package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppDownloader.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f3325b = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f3326f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f3327g = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DownloadReceiver f3330e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3331h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.c.c f3332i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.c.d f3333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.c.h f3334k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.c.g f3335l;
    private m m;
    private com.ss.android.socialbase.appdownloader.c.f n;
    private j o;
    private ad p;
    private ag q;

    private d() {
    }

    public static d j() {
        if (f3325b == null) {
            synchronized (d.class) {
                if (f3325b == null) {
                    f3325b = new d();
                }
            }
        }
        return f3325b;
    }

    private void q() {
        if (f3327g) {
            return;
        }
        if (this.f3330e == null) {
            this.f3330e = new DownloadReceiver();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
            intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addDataScheme(AbsServerManager.PACKAGE_QUERY_BINDER);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter3.addDataScheme("file");
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.f3330e, intentFilter);
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.f3330e, intentFilter2);
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.f3330e, intentFilter3);
            f3327g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void r() {
        r.a(new r.b() { // from class: com.ss.android.socialbase.appdownloader.d.1
            @Override // com.ss.android.socialbase.downloader.impls.r.b
            public void a(DownloadInfo downloadInfo, long j2, boolean z, int i2) {
                RetryJobSchedulerService.a(downloadInfo, j2, z, i2);
            }
        });
    }

    public com.ss.android.socialbase.appdownloader.c.d b() {
        return this.f3333j;
    }

    public com.ss.android.socialbase.appdownloader.c.h c() {
        return this.f3334k;
    }

    public String d() {
        return this.f3329d;
    }

    public com.ss.android.socialbase.appdownloader.c.f e() {
        return this.n;
    }

    public boolean f() {
        return com.ss.android.socialbase.downloader.g.a.b().optInt("package_flag_config", 1) == 1;
    }

    public j g() {
        return this.o;
    }

    public File h() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getGlobalSaveDir();
    }

    public String i() {
        return this.f3328c;
    }

    public m k() {
        return this.m;
    }

    public com.ss.android.socialbase.appdownloader.c.g l() {
        return this.f3335l;
    }

    public com.ss.android.socialbase.downloader.downloader.r m() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener();
    }

    public ad n() {
        return this.p;
    }

    public ag o() {
        return this.q;
    }

    private void c(Context context) {
        if (context == null || f3326f) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.e.a(AdBaseConstants.MIME_APK);
        com.ss.android.socialbase.downloader.downloader.c.a(context);
        com.ss.android.socialbase.downloader.downloader.c.a(new com.ss.android.socialbase.appdownloader.d.b());
        q();
        r();
        f3326f = true;
    }

    public void b(String str) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).setDefaultSavePath(str);
    }

    private DownloadInfo b(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public com.ss.android.socialbase.appdownloader.c.c a() {
        return this.f3332i;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3329d = str;
    }

    public void a(j jVar) {
        this.o = jVar;
    }

    public List<DownloadInfo> b(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    @Deprecated
    public void a(Context context, String str, com.ss.android.socialbase.appdownloader.c.c cVar, com.ss.android.socialbase.appdownloader.c.d dVar, com.ss.android.socialbase.appdownloader.c.h hVar) {
        if (cVar != null) {
            this.f3332i = cVar;
        }
        if (dVar != null) {
            this.f3333j = dVar;
        }
        if (hVar != null) {
            this.f3334k = hVar;
        }
        c(context);
    }

    public static boolean a(Context context, int i2) {
        return c.a(context, i2, true) == 1;
    }

    public void a(Context context, int i2, int i3) {
        try {
            switch (i3) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i2);
                    break;
                case -3:
                    c.a(context, i2, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i2);
                    break;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i2);
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int a(f fVar) {
        int i2;
        String str;
        int i3;
        JSONObject jSONObject;
        DownloadInfo downloadInfo;
        if (fVar == null || fVar.getContext() == null) {
            return 0;
        }
        try {
            List<com.ss.android.socialbase.downloader.model.c> listA = a(fVar.d());
            String strA = fVar.a();
            if (TextUtils.isEmpty(strA)) {
                return 0;
            }
            final int iS = fVar.s();
            final boolean z = iS == 0;
            String strL = fVar.L();
            final String strB = fVar.b();
            if (TextUtils.isEmpty(strL)) {
                strL = c.a(strA, strB, fVar.l(), z);
            }
            if (strL.length() > 255) {
                strL = strL.substring(strL.length() - 255);
            }
            if (TextUtils.isEmpty(strB)) {
                strB = strL;
            }
            String strL2 = fVar.l();
            if (strL.endsWith(".apk") && !c.c(fVar.l())) {
                strL2 = AdBaseConstants.MIME_APK;
            }
            String strC = fVar.c();
            if (TextUtils.isEmpty(fVar.c())) {
                strC = c.b();
            }
            String str2 = strC;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strL)) {
                int iA = com.ss.android.socialbase.downloader.downloader.c.a(strA, str2);
                if (com.ss.android.socialbase.downloader.g.a.a(fVar.ad()).a("resume_task_override_settings") && (downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getDownloadInfo(iA)) != null) {
                    try {
                        fVar.a(new JSONObject(downloadInfo.getDownloadSettingString()));
                    } catch (Throwable unused) {
                    }
                }
                com.ss.android.socialbase.downloader.g.a.a(iA, fVar.ad());
                boolean zK = fVar.K();
                boolean z2 = (com.ss.android.socialbase.downloader.g.a.a(iA).a("modify_force", 1) == 1 && !zK && com.ss.android.socialbase.downloader.i.f.d(str2, strL) && Downloader.getInstance(fVar.getContext()).getDownloadInfo(iA) == null) ? true : zK;
                IDownloadListener iDownloadListenerJ = fVar.j();
                if (iDownloadListenerJ != null || (!fVar.e() && !fVar.f())) {
                    i2 = iA;
                    str = str2;
                } else if (fVar.n() != null) {
                    iDownloadListenerJ = new com.ss.android.socialbase.appdownloader.e.b(fVar.n());
                    i2 = iA;
                    str = str2;
                } else {
                    i2 = iA;
                    str = str2;
                    iDownloadListenerJ = new com.ss.android.socialbase.appdownloader.e.b(fVar.getContext(), iA, strB, str, strL, fVar.k());
                }
                n nVarN = fVar.N();
                if (nVarN == null) {
                    nVarN = new n() { // from class: com.ss.android.socialbase.appdownloader.d.2
                        @Override // com.ss.android.socialbase.downloader.depend.n
                        public void a(DownloadInfo downloadInfo2, BaseException baseException, int i4) {
                            if (d.this.f3334k != null) {
                                d.this.f3334k.a(downloadInfo2, baseException, i4);
                            }
                        }
                    };
                }
                List<com.ss.android.socialbase.downloader.depend.m> listA2 = com.ss.android.socialbase.downloader.downloader.c.A();
                if (!listA2.isEmpty()) {
                    Iterator<com.ss.android.socialbase.downloader.depend.m> it = listA2.iterator();
                    while (it.hasNext()) {
                        fVar.a(it.next());
                    }
                }
                String strK = fVar.k();
                try {
                    if (!TextUtils.isEmpty(strK)) {
                        jSONObject = new JSONObject(strK);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("auto_install_with_notification", fVar.g());
                    jSONObject.put("auto_install_without_notification", fVar.f());
                    strK = jSONObject.toString();
                } catch (Throwable unused2) {
                }
                boolean z3 = fVar.e() || fVar.f();
                if (!z3 || com.ss.android.socialbase.downloader.g.a.a(i2).b("enable_notification_ui") < 1) {
                    i3 = i2;
                } else {
                    i3 = i2;
                    com.ss.android.socialbase.appdownloader.e.c.a().a(i3, fVar.aa());
                }
                final DownloadTask autoInstall = com.ss.android.socialbase.downloader.downloader.b.with(fVar.getContext()).url(strA).backUpUrls(fVar.ab()).name(strL).title(strB).savePath(str).onlyWifi(fVar.h()).extraHeaders(listA).depend(nVarN).retryCount(fVar.w()).backUpUrlRetryCount(fVar.x()).showNotification(z3).extra(strK).mimeType(strL2).minProgressTimeMsInterval(fVar.D()).maxProgressCount(fVar.E()).mainThreadListener(fVar.i()).notificationListener(iDownloadListenerJ).notificationEventListener(a(fVar.O())).force(z2).autoResumed(fVar.q()).showNotificationForAutoResumed(fVar.r()).chunkStategy(fVar.o()).chunkAdjustCalculator(fVar.p()).needHttpsToHttpRetry(fVar.m()).packageName(fVar.t()).md5(fVar.u()).expectFileLength(fVar.v()).needRetryDelay(fVar.y()).retryDelayTimeArray(fVar.z()).needDefaultHttpServiceBackUp(fVar.A()).needReuseFirstConnection(fVar.B()).needReuseChunkRunnable(fVar.F()).needIndependentProcess(fVar.G()).enqueueType(fVar.J()).monitorDepend(fVar.M()).retryDelayTimeCalculator(fVar.C()).headConnectionAvailable(fVar.H()).fileUriProvider(fVar.P()).diskSpaceHandler(fVar.ac()).needChunkDowngradeRetry(fVar.I()).notificationClickCallback(fVar.Q()).downloadSetting(fVar.ad()).iconUrl(fVar.aa()).needSDKMonitor(fVar.V()).monitorScene(fVar.W()).extraMonitorStatus(fVar.X()).executorGroup(fVar.T()).throttleNetSpeed(fVar.U()).distinctDirectory(fVar.Y()).setAutoInstall(fVar.Z());
                if (autoInstall != null && !fVar.R().isEmpty()) {
                    autoInstall.setDownloadCompleteHandlers(fVar.R());
                }
                if (autoInstall != null) {
                    if (z3 && fVar.S() && fVar.getActivity() != null && !fVar.getActivity().isFinishing() && !com.ss.android.socialbase.appdownloader.e.d.a()) {
                        com.ss.android.socialbase.appdownloader.e.d.a(fVar.getActivity(), new com.ss.android.socialbase.appdownloader.c.n() { // from class: com.ss.android.socialbase.appdownloader.d.3
                            @Override // com.ss.android.socialbase.appdownloader.c.n
                            public void a() {
                                String str3 = d.a;
                                StringBuilder sbR = c.a.a.a.a.r("notification permission granted, start download :");
                                sbR.append(strB);
                                com.ss.android.socialbase.downloader.c.a.b(str3, sbR.toString());
                                d.this.a(autoInstall, iS, z);
                            }

                            @Override // com.ss.android.socialbase.appdownloader.c.n
                            public void b() {
                                String str3 = d.a;
                                StringBuilder sbR = c.a.a.a.a.r("notification permission denied, start download :");
                                sbR.append(strB);
                                com.ss.android.socialbase.downloader.c.a.b(str3, sbR.toString());
                                d.this.a(autoInstall, iS, z);
                            }
                        });
                    } else {
                        com.ss.android.socialbase.downloader.c.a.b(a, "notification permission need not request, start download :" + strB);
                        a(autoInstall, iS, z);
                        autoInstall.getDownloadInfo();
                    }
                }
                return i3;
            }
            return 0;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.d.a.a(fVar.M(), (DownloadInfo) null, new BaseException(PointerIconCompat.TYPE_HELP, com.ss.android.socialbase.downloader.i.f.b(th, "addDownloadTask")), 0);
            com.ss.android.socialbase.downloader.c.a.e(a, String.format("add download task error:%s", th));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadTask downloadTask, int i2, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i2);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a()) && !TextUtils.isEmpty(cVar.b())) {
                    if (cVar.a().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.c(cVar.a(), cVar.b()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("User-Agent", com.ss.android.socialbase.appdownloader.b.a.a));
        }
        return arrayList;
    }

    public String a(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || c.c(str2)) ? str2 : AdBaseConstants.MIME_APK;
    }

    private z a(final com.ss.android.socialbase.appdownloader.c.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new z() { // from class: com.ss.android.socialbase.appdownloader.d.4
            @Override // com.ss.android.socialbase.downloader.depend.z
            public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
                if (i2 != 1 && i2 != 3) {
                    switch (i2) {
                        case 8:
                            eVar.a(i2, downloadInfo.getPackageName(), str, str2);
                            break;
                        case 9:
                            eVar.a(com.ss.android.socialbase.downloader.downloader.c.N(), str);
                            break;
                        case 10:
                            eVar.a(downloadInfo);
                            break;
                    }
                }
                eVar.a(i2, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean a(boolean z) {
                return eVar.a(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public String a() {
                return eVar.a();
            }
        };
    }

    public DownloadInfo a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo downloadInfoA = a(context, str, h());
                if (downloadInfoA == null) {
                    downloadInfoA = a(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoA == null) {
                    downloadInfoA = a(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoA == null) {
                    downloadInfoA = a(context, str, context.getFilesDir());
                }
                return (downloadInfoA == null && com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list")) ? b(context, str) : downloadInfoA;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.c.a.b(a, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo a(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> a(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public void a(com.ss.android.socialbase.appdownloader.c.g gVar) {
        this.f3335l = gVar;
    }

    public void a(com.ss.android.socialbase.downloader.downloader.r rVar) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).setReserveWifiStatusListener(rVar);
    }

    public void a(ad adVar) {
        this.p = adVar;
    }

    public void a(ag agVar) {
        this.q = agVar;
    }
}
