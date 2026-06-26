package io.legado.app.service;

import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.core.os.BundleKt;
import c.b.a.m.f;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.h.a0;
import f.c0.c.j;
import f.g;
import f.h0.k;
import io.legado.app.base.BaseService;
import io.legado.app.service.DownloadService;
import io.wenyuange.app.release.R;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DownloadService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J)\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R&\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00110#j\b\u0012\u0004\u0012\u00020\u0011`$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R2\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150+j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015`,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010-¨\u00060"}, d2 = {"Lio/legado/app/service/DownloadService;", "Lio/legado/app/base/BaseService;", "Lf/v;", "onCreate", "()V", "Landroid/content/Intent;", "rootIntent", "onTaskRemoved", "(Landroid/content/Intent;)V", "onDestroy", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", ai.aD, "", "downloadId", "b", "(J)V", "", "content", "max", "progress", "d", "(JLjava/lang/String;II)V", "io/legado/app/service/DownloadService$downloadReceiver$1", "g", "Lio/legado/app/service/DownloadService$downloadReceiver$1;", "downloadReceiver", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "handler", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "completeDownloads", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "runnable", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "downloads", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class DownloadService extends BaseService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f6958b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashMap<Long, String> downloads = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashSet<Long> completeDownloads = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Runnable runnable = new Runnable() { // from class: e.a.a.f.e
        @Override // java.lang.Runnable
        public final void run() throws IOException {
            DownloadService downloadService = this.a;
            int i2 = DownloadService.f6958b;
            f.c0.c.j.e(downloadService, "this$0");
            downloadService.handler.removeCallbacks(downloadService.runnable);
            downloadService.c();
            downloadService.handler.postDelayed(downloadService.runnable, 1000L);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final DownloadService$downloadReceiver$1 downloadReceiver = new BroadcastReceiver() { // from class: io.legado.app.service.DownloadService$downloadReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) throws IOException {
            j.e(context, c.R);
            j.e(intent, "intent");
            DownloadService downloadService = this.a;
            int i2 = DownloadService.f6958b;
            downloadService.c();
        }
    };

    public final void b(long downloadId) {
        String strB;
        j.f("download", "name");
        Uri uriForDownloadedFile = ((DownloadManager) h.g().getSystemService("download")).getUriForDownloadedFile(downloadId);
        if (uriForDownloadedFile == null || (strB = a0.b(this, uriForDownloadedFile)) == null) {
            return;
        }
        File file = new File(strB);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uriForFile = FileProvider.getUriForFile(this, "io.wenyuange.app.release.fileProvider", file);
            intent.addFlags(1);
            intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
        } else {
            Uri uriFromFile = Uri.fromFile(file);
            j.d(uriFromFile, "fromFile(file)");
            intent.setDataAndType(uriFromFile, AdBaseConstants.MIME_APK);
        }
        try {
            startActivity(intent);
        } catch (Exception e2) {
            f.R5(this, f.C2(e2));
        }
    }

    public final void c() throws IOException {
        String str;
        Set<Long> setKeySet = this.downloads.keySet();
        j.d(setKeySet, "downloads.keys");
        DownloadManager.Query query = new DownloadManager.Query();
        j.e(setKeySet, "$this$toLongArray");
        int size = setKeySet.size();
        long[] jArr = new long[size];
        Iterator<Long> it = setKeySet.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            jArr[i2] = it.next().longValue();
            i2++;
        }
        query.setFilterById(Arrays.copyOf(jArr, size));
        j.f("download", "name");
        Cursor cursorQuery = ((DownloadManager) h.g().getSystemService("download")).query(query);
        try {
            if (!cursorQuery.moveToFirst()) {
                f.P0(cursorQuery, null);
                return;
            }
            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
            int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("bytes_so_far"));
            int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("total_size"));
            int i5 = cursorQuery.getInt(cursorQuery.getColumnIndex(NotificationCompat.CATEGORY_STATUS));
            if (i5 == 1) {
                str = "待下载";
            } else if (i5 == 2) {
                str = "下载中";
            } else if (i5 == 4) {
                str = "暂停";
            } else if (i5 != 8) {
                str = i5 != 16 ? "未知状态" : "下载失败";
            } else {
                if (!this.completeDownloads.contains(Long.valueOf(j2))) {
                    this.completeDownloads.add(Long.valueOf(j2));
                    String str2 = this.downloads.get(Long.valueOf(j2));
                    if (j.a(str2 == null ? null : Boolean.valueOf(k.h(str2, ".apk", false, 2)), Boolean.TRUE)) {
                        b(j2);
                    }
                }
                str = "下载完成";
            }
            d(j2, ((Object) this.downloads.get(Long.valueOf(j2))) + ' ' + str, i4, i3);
            f.P0(cursorQuery, null);
        } finally {
        }
    }

    public final void d(long downloadId, String content, int max, int progress) {
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this, "channel_download").setSmallIcon(R.drawable.ic_download).setOngoing(true).setContentTitle(getString(R.string.action_download));
        Bundle bundleBundleOf = BundleKt.bundleOf(new g("downloadId", Long.valueOf(downloadId)));
        Intent intent = new Intent(this, (Class<?>) DownloadService.class);
        intent.setAction("play");
        if (bundleBundleOf != null) {
            intent.putExtras(bundleBundleOf);
        }
        contentTitle.setContentIntent(PendingIntent.getService(this, 0, intent, 134217728));
        String string = getString(R.string.cancel);
        Bundle bundleBundleOf2 = BundleKt.bundleOf(new g("downloadId", Long.valueOf(downloadId)));
        Intent intent2 = new Intent(this, (Class<?>) DownloadService.class);
        intent2.setAction("stop");
        if (bundleBundleOf2 != null) {
            intent2.putExtras(bundleBundleOf2);
        }
        contentTitle.addAction(R.drawable.ic_stop_black_24dp, string, PendingIntent.getService(this, 0, intent2, 134217728));
        Bundle bundleBundleOf3 = BundleKt.bundleOf(new g("downloadId", Long.valueOf(downloadId)));
        Intent intent3 = new Intent(this, (Class<?>) DownloadService.class);
        intent3.setAction("stop");
        if (bundleBundleOf3 != null) {
            intent3.putExtras(bundleBundleOf3);
        }
        contentTitle.setDeleteIntent(PendingIntent.getService(this, 0, intent3, 134217728));
        contentTitle.setVisibility(1);
        contentTitle.setContentText(content);
        contentTitle.setProgress(max, progress, false);
        contentTitle.setAutoCancel(true);
        startForeground((int) downloadId, contentTitle.build());
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        registerReceiver(this.downloadReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    }

    @Override // io.legado.app.base.BaseService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.downloadReceiver);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) throws IOException {
        String action = intent == null ? null : intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != 3443508) {
                if (iHashCode != 3540994) {
                    if (iHashCode == 109757538 && action.equals("start")) {
                        long longExtra = intent.getLongExtra("downloadId", 0L);
                        String stringExtra = intent.getStringExtra("fileName");
                        if (stringExtra == null) {
                            stringExtra = "未知文件";
                        }
                        if (longExtra > 0) {
                            this.downloads.put(Long.valueOf(longExtra), stringExtra);
                            c();
                            this.handler.removeCallbacks(this.runnable);
                            c();
                            this.handler.postDelayed(this.runnable, 1000L);
                        }
                    }
                } else if (action.equals("stop")) {
                    this.downloads.remove(Long.valueOf(intent.getLongExtra("downloadId", 0L)));
                    stopSelf();
                }
            } else if (action.equals("play")) {
                long longExtra2 = intent.getLongExtra("downloadId", 0L);
                String str = this.downloads.get(Long.valueOf(longExtra2));
                if (j.a(str != null ? Boolean.valueOf(k.h(str, ".apk", false, 2)) : null, Boolean.TRUE)) {
                    b(longExtra2);
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        stopSelf();
    }
}
