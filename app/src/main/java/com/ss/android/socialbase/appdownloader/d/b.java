package com.ss.android.socialbase.appdownloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DefaultDownloadLaunchHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements l {
    private List<Integer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f3341b;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<DownloadInfo> list, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g gVarL = d.j().l();
        if (gVarL != null) {
            gVarL.a(list);
        }
        Context contextN = c.N();
        if (contextN == null) {
            return;
        }
        boolean zB = f.b(contextN);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            a(contextN, it.next(), zB, i2);
        }
        List<Integer> list2 = this.a;
        if (list2 == null || list2.isEmpty() || this.f3341b != null) {
            return;
        }
        this.f3341b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (f.b(applicationContext)) {
                    com.ss.android.socialbase.downloader.c.a.b("LaunchResume", "onReceive : wifi connected !!!");
                    c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (b.this.a != null && !b.this.a.isEmpty()) {
                                    int size = b.this.a.size();
                                    Integer[] numArr = new Integer[size];
                                    b.this.a.toArray(numArr);
                                    b.this.a.clear();
                                    for (int i3 = 0; i3 < size; i3++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i3].intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            b.this.a(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(b.this.f3341b);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    b.this.f3341b = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            contextN.registerReceiver(this.f3341b, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.f3341b = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<String> a() {
        return com.ss.android.socialbase.appdownloader.c.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(final List<DownloadInfo> list, final int i2) {
        if (f.d()) {
            c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.b(list, i2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else {
            b(list, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, DownloadInfo downloadInfo, boolean z, int i2) {
        int i3;
        boolean z2;
        if (downloadInfo == null || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        if (realStatus == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded())) {
            com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            int iA = aVarA.a("failed_resume_max_count", 0);
            double dA = aVarA.a("failed_resume_max_hours", 72.0d);
            double dA2 = aVarA.a("failed_resume_min_hours", 12.0d);
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z3 = downloadInfo.getFailedResumeCount() < iA && ((double) (jCurrentTimeMillis - downloadInfo.getLastDownloadTime())) < dA * 3600000.0d && ((double) (jCurrentTimeMillis - downloadInfo.getLastFailedResumeTime())) > dA2 * 3600000.0d;
            if (downloadInfo.isPauseReserveOnWifi() && z) {
                z3 = true;
            }
            if (z3) {
                boolean z4 = aVarA.a("failed_resume_need_wifi", 1) == 1;
                boolean z5 = aVarA.a("failed_resume_need_wait_wifi", 0) == 1;
                if (!z && z4 && z5) {
                    if (this.a == null) {
                        this.a = new ArrayList();
                    }
                    int id = downloadInfo.getId();
                    if (!this.a.contains(Integer.valueOf(id))) {
                        this.a.add(Integer.valueOf(id));
                    }
                    downloadInfo.setOnlyWifi(true);
                    r.a().a(downloadInfo);
                    z2 = false;
                } else {
                    z2 = true;
                    com.ss.android.socialbase.appdownloader.c.a(downloadInfo, true, z4);
                    downloadInfo.setLastFailedResumeTime(jCurrentTimeMillis);
                    downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                    downloadInfo.updateSpData();
                    if (downloadInfo.isPauseReserveOnWifi() && z) {
                        downloadInfo.setDownloadFromReserveWifi(true);
                        com.ss.android.socialbase.downloader.downloader.r rVarM = d.j().m();
                        if (rVarM != null) {
                            rVarM.a(downloadInfo, 5, i2);
                        }
                    }
                }
            } else {
                z2 = false;
            }
            StringBuilder sbR = c.a.a.a.a.r("launchResume, name = ");
            sbR.append(downloadInfo.getTitle());
            sbR.append(", canShowNotification = ");
            sbR.append(z3);
            sbR.append(", downloadResumed = ");
            sbR.append(z2);
            com.ss.android.socialbase.downloader.c.a.c("LaunchResume", sbR.toString());
            g gVarL = d.j().l();
            if (gVarL != null) {
                gVarL.a(downloadInfo, z2);
                return;
            }
            return;
        }
        if (realStatus != -3 || !a(downloadInfo)) {
            if (realStatus == -2) {
                if (!downloadInfo.isPauseReserveOnWifi()) {
                    a(downloadInfo, context);
                    return;
                }
                if (z) {
                    com.ss.android.socialbase.appdownloader.c.a(downloadInfo, true, true);
                    downloadInfo.updateSpData();
                    downloadInfo.setDownloadFromReserveWifi(true);
                    g gVarL2 = d.j().l();
                    if (gVarL2 != null) {
                        gVarL2.a(downloadInfo, true);
                    }
                    com.ss.android.socialbase.downloader.downloader.r rVarM2 = d.j().m();
                    if (rVarM2 != null) {
                        rVarM2.a(downloadInfo, 5, i2);
                        return;
                    }
                    return;
                }
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                int id2 = downloadInfo.getId();
                if (!this.a.contains(Integer.valueOf(id2))) {
                    this.a.add(Integer.valueOf(id2));
                }
                r.a().a(downloadInfo);
                a(downloadInfo, context);
                return;
            }
            return;
        }
        com.ss.android.socialbase.downloader.g.a aVarA2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        if (com.ss.android.socialbase.appdownloader.c.a(context, downloadInfo)) {
            return;
        }
        int iA2 = aVarA2.a("uninstall_resume_max_count", 0);
        double dA3 = aVarA2.a("uninstall_resume_max_hours", 72.0d);
        double dA4 = aVarA2.a("uninstall_resume_min_hours", 12.0d);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        boolean z6 = downloadInfo.getUninstallResumeCount() < iA2 && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastDownloadTime())) < dA3 * 3600000.0d && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastUninstallResumeTime())) > dA4 * 3600000.0d;
        StringBuilder sbR2 = c.a.a.a.a.r("uninstallResume, name = ");
        sbR2.append(downloadInfo.getTitle());
        sbR2.append(", canShowNotification = ");
        sbR2.append(z6);
        com.ss.android.socialbase.downloader.c.a.c("LaunchResume", sbR2.toString());
        if (z6) {
            com.ss.android.socialbase.downloader.notification.a aVarE = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
            if (aVarE == null) {
                i3 = 1;
                com.ss.android.socialbase.appdownloader.e.a aVar = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.b.a().a(aVar);
                aVarE = aVar;
            } else {
                i3 = 1;
                aVarE.a(downloadInfo);
            }
            aVarE.b(downloadInfo.getTotalBytes());
            aVarE.a(downloadInfo.getTotalBytes());
            aVarE.a(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setLastUninstallResumeTime(jCurrentTimeMillis2);
            downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + i3);
            downloadInfo.updateSpData();
        }
    }

    private void a(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        int iA = aVarA.a("paused_resume_max_count", 0);
        double dA = aVarA.a("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < iA && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < dA * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.a aVarE = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
            if (aVarE == null) {
                aVarE = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.b.a().a(aVarE);
            } else {
                aVarE.a(downloadInfo);
            }
            aVarE.b(downloadInfo.getTotalBytes());
            aVarE.a(downloadInfo.getCurBytes());
            aVarE.a(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean a(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("uninstall_can_not_resume_for_force_task", false)) {
            return f.a(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
