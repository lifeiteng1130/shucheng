package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
public class RetryJobSchedulerService extends JobService {
    public static void a(DownloadInfo downloadInfo, long j2, boolean z, int i2) {
        Context contextN;
        long j3;
        r reserveWifiStatusListener;
        r reserveWifiStatusListener2;
        if (downloadInfo == null || j2 <= 0 || (contextN = com.ss.android.socialbase.downloader.downloader.c.N()) == null) {
            return;
        }
        int i3 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.a(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) contextN.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            try {
                jobScheduler.cancel(downloadInfo.getId());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (i2 == 0 || (z && i2 != 2)) {
                j2 = 1000;
                j3 = 0;
            } else {
                j3 = 60000 + j2;
            }
            JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(contextN.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j2);
            if (!z) {
                i3 = 1;
            }
            JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i3).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j3 > 0) {
                requiresDeviceIdle.setOverrideDeadline(j3);
            }
            int iSchedule = jobScheduler.schedule(requiresDeviceIdle.build());
            if (iSchedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener()) != null) {
                reserveWifiStatusListener.a(downloadInfo, 3, 3);
            }
            if (iSchedule <= 0) {
                com.ss.android.socialbase.downloader.c.a.d("RetrySchedulerService", "schedule err errCode = " + iSchedule);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.c.a(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        int iOnStartCommand = super.onStartCommand(intent, i2, i3);
        if (com.ss.android.socialbase.downloader.downloader.c.j()) {
            return 2;
        }
        return iOnStartCommand;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        com.ss.android.socialbase.downloader.c.a.c("RetrySchedulerService", "onStartJob, id = " + jobId);
        com.ss.android.socialbase.downloader.impls.r.a().a(jobId);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
