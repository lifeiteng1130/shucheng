package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: RetryScheduler.java */
/* JADX INFO: loaded from: classes.dex */
public class r implements Handler.Callback, a.InterfaceC0092a {
    private static volatile r a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static b f3803i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f3807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3808f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ConnectivityManager f3810h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f3805c = new Handler(Looper.getMainLooper(), this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray<a> f3806d = new SparseArray<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3809g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f3804b = com.ss.android.socialbase.downloader.downloader.c.N();

    /* JADX INFO: compiled from: RetryScheduler.java */
    public static class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f3816d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f3817e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f3818f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int[] f3819g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f3820h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f3821i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f3822j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f3823k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f3824l;

        public a(int i2, int i3, int i4, int i5, int i6, boolean z, int[] iArr) {
            i5 = i5 < 3000 ? 3000 : i5;
            i6 = i6 < 5000 ? 5000 : i6;
            this.a = i2;
            this.f3814b = i3;
            this.f3815c = i4;
            this.f3816d = i5;
            this.f3817e = i6;
            this.f3818f = z;
            this.f3819g = iArr;
            this.f3820h = i5;
        }

        public void c() {
            this.f3820h = this.f3816d;
        }

        public int d() {
            return this.f3820h;
        }

        public boolean a(long j2, int i2, int i3, boolean z) {
            if (!this.f3824l) {
                com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.f3814b < i2 || this.f3821i >= this.f3815c) {
                return false;
            }
            if (!this.f3822j || i3 == 2) {
                return z || j2 - this.f3823k >= ((long) this.f3816d);
            }
            return false;
        }

        public synchronized void b() {
            this.f3821i++;
        }

        public synchronized void a() {
            this.f3820h += this.f3817e;
        }

        public synchronized void a(long j2) {
            this.f3823k = j2;
        }
    }

    /* JADX INFO: compiled from: RetryScheduler.java */
    public interface b {
        void a(DownloadInfo downloadInfo, long j2, boolean z, int i2);
    }

    private r() {
        f();
        this.f3807e = com.ss.android.socialbase.downloader.i.f.c();
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    private void f() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("use_network_callback", 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (r.this.f3804b != null) {
                        r rVar = r.this;
                        rVar.f3810h = (ConnectivityManager) rVar.f3804b.getApplicationContext().getSystemService("connectivity");
                        r.this.f3810h.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.r.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                com.ss.android.socialbase.downloader.c.a.b("RetryScheduler", "network onAvailable: ");
                                r.this.a(1, true);
                            }
                        });
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        try {
            if (this.f3810h == null) {
                this.f3810h = (ConnectivityManager) this.f3804b.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.f3810h.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b(message.arg1, message.arg2 == 1);
        } else {
            StringBuilder sbR = c.a.a.a.a.r("handleMessage, doSchedulerRetry, id = ");
            sbR.append(message.what);
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", sbR.toString());
            a(message.what);
        }
        return true;
    }

    private void b(final int i2, final boolean z) {
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.2
            @Override // java.lang.Runnable
            public void run() {
                int iG;
                try {
                    if (r.this.f3809g > 0 && (iG = r.this.g()) != 0) {
                        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + r.this.f3809g);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (r.this.f3806d) {
                            for (int i3 = 0; i3 < r.this.f3806d.size(); i3++) {
                                a aVar = (a) r.this.f3806d.valueAt(i3);
                                if (aVar != null && aVar.a(jCurrentTimeMillis, i2, iG, z)) {
                                    if (z) {
                                        aVar.c();
                                    }
                                    arrayList.add(aVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                r.this.a(((a) it.next()).a, iG, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private void c(int i2) {
        synchronized (this.f3806d) {
            this.f3806d.remove(i2);
        }
    }

    private a d(int i2) {
        int[] iArrA;
        int i3;
        int i4;
        boolean z;
        com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(i2);
        boolean z2 = false;
        int iA = aVarA.a("retry_schedule", 0);
        JSONObject jSONObjectD = aVarA.d("retry_schedule_config");
        int i5 = 60;
        if (jSONObjectD != null) {
            int iOptInt = jSONObjectD.optInt("max_count", 60);
            int iOptInt2 = jSONObjectD.optInt("interval_sec", 60);
            int iOptInt3 = jSONObjectD.optInt("interval_sec_acceleration", 60);
            if (f3803i != null && jSONObjectD.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArrA = a(jSONObjectD.optString("allow_error_code"));
            i3 = iOptInt3;
            z = z2;
            i4 = iOptInt;
            i5 = iOptInt2;
        } else {
            iArrA = null;
            i3 = 60;
            i4 = 60;
            z = false;
        }
        return new a(i2, iA, i4, i5 * 1000, i3 * 1000, z, iArrA);
    }

    public void e() {
        a(5, false);
    }

    private a b(int i2) {
        a aVarD = this.f3806d.get(i2);
        if (aVarD == null) {
            synchronized (this.f3806d) {
                aVarD = this.f3806d.get(i2);
                if (aVarD == null) {
                    aVarD = d(i2);
                }
                this.f3806d.put(i2, aVarD);
            }
        }
        return aVarD;
    }

    public static r a() {
        if (a == null) {
            synchronized (r.class) {
                if (a == null) {
                    a = new r();
                }
            }
        }
        return a;
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
    public void c() {
        a(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
    public void b() {
        a(4, false);
    }

    public static void a(b bVar) {
        f3803i = bVar;
    }

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.a) || !com.ss.android.socialbase.downloader.constants.e.a.equals(downloadInfo.getMimeType())) {
            return;
        }
        a(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), g());
    }

    public void d() {
        a(2, true);
    }

    private void a(DownloadInfo downloadInfo, boolean z, int i2) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        a aVarB = b(downloadInfo.getId());
        if (aVarB.f3821i > aVarB.f3815c) {
            StringBuilder sbR = c.a.a.a.a.r("tryStartScheduleRetry, id = ");
            sbR.append(aVarB.a);
            sbR.append(", mRetryCount = ");
            sbR.append(aVarB.f3821i);
            sbR.append(", maxCount = ");
            sbR.append(aVarB.f3815c);
            com.ss.android.socialbase.downloader.c.a.d("RetryScheduler", sbR.toString());
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.ss.android.socialbase.downloader.i.f.h(failedException) && !com.ss.android.socialbase.downloader.i.f.i(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!a(aVarB, errorCode)) {
                return;
            }
            StringBuilder sbR2 = c.a.a.a.a.r("allow error code, id = ");
            sbR2.append(aVarB.a);
            sbR2.append(", error code = ");
            sbR2.append(errorCode);
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", sbR2.toString());
        }
        aVarB.f3822j = z;
        synchronized (this.f3806d) {
            if (!aVarB.f3824l) {
                aVarB.f3824l = true;
                this.f3809g++;
            }
        }
        int iD = aVarB.d();
        StringBuilder sbR3 = c.a.a.a.a.r("tryStartScheduleRetry: id = ");
        sbR3.append(aVarB.a);
        sbR3.append(", delayTimeMills = ");
        sbR3.append(iD);
        sbR3.append(", mWaitingRetryTasks = ");
        sbR3.append(this.f3809g);
        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", sbR3.toString());
        if (!aVarB.f3818f) {
            if (z) {
                return;
            }
            this.f3805c.removeMessages(downloadInfo.getId());
            this.f3805c.sendEmptyMessageDelayed(downloadInfo.getId(), iD);
            return;
        }
        if (i2 == 0) {
            aVarB.c();
        }
        b bVar = f3803i;
        if (bVar != null) {
            bVar.a(downloadInfo, iD, z, i2);
        }
        if (this.f3807e) {
            aVarB.a(System.currentTimeMillis());
            aVarB.b();
            aVarB.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z) {
        if (this.f3809g <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (jCurrentTimeMillis - this.f3808f < 10000) {
                    return;
                }
            }
            this.f3808f = jCurrentTimeMillis;
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "scheduleAllTaskRetry, level = [" + i2 + "], force = [" + z + "]");
            if (z) {
                this.f3805c.removeMessages(0);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.arg1 = i2;
            messageObtain.arg2 = z ? 1 : 0;
            this.f3805c.sendMessageDelayed(messageObtain, 2000L);
        }
    }

    public void a(final int i2) {
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.r.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    r rVar = r.this;
                    rVar.a(i2, rVar.g(), true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, boolean z) {
        com.ss.android.socialbase.downloader.downloader.r reserveWifiStatusListener;
        boolean zA;
        Context context = this.f3804b;
        if (context == null) {
            return;
        }
        synchronized (this.f3806d) {
            a aVar = this.f3806d.get(i2);
            if (aVar == null) {
                return;
            }
            boolean z2 = true;
            if (aVar.f3824l) {
                aVar.f3824l = false;
                int i4 = this.f3809g - 1;
                this.f3809g = i4;
                if (i4 < 0) {
                    this.f3809g = 0;
                }
            }
            StringBuilder sbS = c.a.a.a.a.s("doSchedulerRetryInSubThread: downloadId = ", i2, ", retryCount = ");
            sbS.append(aVar.f3821i);
            sbS.append(", mWaitingRetryTasksCount = ");
            sbS.append(this.f3809g);
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", sbS.toString());
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            if (downloadInfo == null) {
                c(i2);
                return;
            }
            com.ss.android.socialbase.downloader.c.a.e("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i2);
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus != -3 && realStatus != -4) {
                if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                    if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener()) != null) {
                        reserveWifiStatusListener.a(downloadInfo, 4, 3);
                    }
                    com.ss.android.socialbase.downloader.downloader.l lVarW = com.ss.android.socialbase.downloader.downloader.c.w();
                    if (lVarW != null) {
                        lVarW.a(Collections.singletonList(downloadInfo), 3);
                    }
                    c(i2);
                    return;
                }
                if (realStatus != -1) {
                    return;
                }
                if (i3 != 0) {
                    zA = true;
                } else if (!aVar.f3818f) {
                    return;
                } else {
                    zA = false;
                }
                BaseException failedException = downloadInfo.getFailedException();
                if (zA && com.ss.android.socialbase.downloader.i.f.h(failedException)) {
                    zA = a(downloadInfo, failedException);
                }
                aVar.b();
                if (zA) {
                    StringBuilder sbR = c.a.a.a.a.r("doSchedulerRetry: restart task, ****** id = ");
                    sbR.append(aVar.a);
                    com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", sbR.toString());
                    aVar.a(System.currentTimeMillis());
                    if (z) {
                        aVar.a();
                    }
                    downloadInfo.setRetryScheduleCount(aVar.f3821i);
                    if (downloadInfo.getStatus() == -1) {
                        Downloader.getInstance(context).restart(downloadInfo.getId());
                        return;
                    }
                    return;
                }
                if (z) {
                    aVar.a();
                }
                if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                    z2 = false;
                }
                a(downloadInfo, z2, i3);
                return;
            }
            c(i2);
        }
    }

    private boolean a(a aVar, int i2) {
        int[] iArr = aVar.f3819g;
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length <= 0) {
                return null;
            }
            int[] iArr = new int[strArrSplit.length];
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                iArr[i2] = Integer.parseInt(strArrSplit[i2]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean a(DownloadInfo downloadInfo, BaseException baseException) {
        long jD;
        long totalBytes;
        try {
            jD = com.ss.android.socialbase.downloader.i.f.d(downloadInfo.getTempPath());
        } catch (BaseException e2) {
            e2.printStackTrace();
            jD = 0;
        }
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
            totalBytes = ((com.ss.android.socialbase.downloader.exception.d) baseException).b();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (jD < totalBytes) {
            com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            if (aVarA.a("space_fill_part_download", 0) == 1) {
                if (jD > 0) {
                    int iA = aVarA.a("space_fill_min_keep_mb", 100);
                    if (iA > 0) {
                        long j2 = jD - (((long) iA) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                        StringBuilder sbR = c.a.a.a.a.r("retry schedule: available = ");
                        sbR.append(com.ss.android.socialbase.downloader.i.f.a(jD));
                        sbR.append("MB, minKeep = ");
                        sbR.append(iA);
                        sbR.append("MB, canDownload = ");
                        sbR.append(com.ss.android.socialbase.downloader.i.f.a(j2));
                        sbR.append("MB");
                        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", sbR.toString());
                        if (j2 <= 0) {
                            com.ss.android.socialbase.downloader.c.a.d("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (aVarA.a("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }
}
