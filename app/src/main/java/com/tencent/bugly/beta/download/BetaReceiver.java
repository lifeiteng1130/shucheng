package com.tencent.bugly.beta.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.ui.NetNotifyDialog;
import com.tencent.bugly.proguard.W;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class BetaReceiver extends BroadcastReceiver {
    public static ConcurrentHashMap<String, d> netListeners = new ConcurrentHashMap<>(3);
    public static int netStatus = 0;
    public static String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";

    public static synchronized void addTask(DownloadTask downloadTask) {
        netStatus = com.tencent.bugly.beta.global.a.a(e.f3983b.v);
        NetNotifyDialog netNotifyDialog = new NetNotifyDialog();
        netNotifyDialog.task = downloadTask;
        netListeners.put(downloadTask.getDownloadUrl(), new d(2, downloadTask, Boolean.FALSE, netNotifyDialog));
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(Context context, Intent intent) {
        W.c().a(new b(this, intent, context));
    }
}
