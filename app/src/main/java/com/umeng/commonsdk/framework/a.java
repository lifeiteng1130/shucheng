package com.umeng.commonsdk.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: UMNetWorkSender.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements UMImprintChangeCallback {
    private static HandlerThread a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f5129b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f5130c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f5131d = 200;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f5132e = 273;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f5133f = 274;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f5134g = 512;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f5135h = 769;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static FileObserverC0131a f5136i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ConnectivityManager f5137j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static NetworkInfo f5138k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static IntentFilter f5139l = null;
    private static boolean m = false;
    private static ArrayList<UMSenderStateNotify> n = null;
    private static final String q = "report_policy";
    private static final String r = "report_interval";
    private static final int t = 15;
    private static final int u = 3;
    private static final int v = 90;
    private static Object o = new Object();
    private static ReentrantLock p = new ReentrantLock();
    private static boolean s = false;
    private static int w = 15;
    private static Object x = new Object();
    private static BroadcastReceiver y = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int size;
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                Context appContext = UMModuleRegister.getAppContext();
                try {
                    if (a.f5137j != null) {
                        NetworkInfo unused = a.f5138k = a.f5137j.getActiveNetworkInfo();
                        if (a.f5138k == null || !a.f5138k.isAvailable()) {
                            ULog.i("--->>> network disconnected.");
                            boolean unused2 = a.m = false;
                            return;
                        }
                        ULog.i("--->>> network isAvailable, check if there are any files to send.");
                        boolean unused3 = a.m = true;
                        synchronized (a.o) {
                            if (a.n != null && (size = a.n.size()) > 0) {
                                for (int i2 = 0; i2 < size; i2++) {
                                    ((UMSenderStateNotify) a.n.get(i2)).onConnectionAvailable();
                                }
                            }
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
                        a.d();
                        if (a.f5138k.getType() != 1 || context == null) {
                            return;
                        }
                        try {
                            if (UMWorkDispatch.eventHasExist(com.umeng.commonsdk.internal.a.f5149k)) {
                                return;
                            }
                            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f5149k, b.a(context).a(), null);
                        } catch (Throwable unused4) {
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(appContext, th);
                }
            }
        }
    };

    /* JADX INFO: renamed from: com.umeng.commonsdk.framework.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UMNetWorkSender.java */
    public static class FileObserverC0131a extends FileObserver {
        public FileObserverC0131a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if ((i2 & 8) != 8) {
                return;
            }
            ULog.d("--->>> envelope file created >>> " + str);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            a.c(273);
        }
    }

    public a(Context context, Handler handler) {
        Context appContext = UMModuleRegister.getAppContext();
        f5137j = (ConnectivityManager) appContext.getSystemService("connectivity");
        f5130c = handler;
        try {
            if (a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                a = handlerThread;
                handlerThread.start();
                if (f5136i == null) {
                    FileObserverC0131a fileObserverC0131a = new FileObserverC0131a(UMFrUtils.getEnvelopeDirPath(context));
                    f5136i = fileObserverC0131a;
                    fileObserverC0131a.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                if (DeviceConfig.checkPermission(appContext, "android.permission.ACCESS_NETWORK_STATE") && f5137j != null && f5139l == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    f5139l = intentFilter;
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    BroadcastReceiver broadcastReceiver = y;
                    if (broadcastReceiver != null) {
                        appContext.registerReceiver(broadcastReceiver, f5139l);
                    }
                }
                n();
                if (f5129b == null) {
                    f5129b = new Handler(a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.2
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i2 = message.what;
                            if (i2 == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.p.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        a.r();
                                    } catch (Throwable unused) {
                                    }
                                    a.p.unlock();
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            if (i2 == a.f5133f) {
                                a.p();
                            } else {
                                if (i2 != 512) {
                                    return;
                                }
                                a.q();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(q, this);
                ImprintHandler.getImprintService(context).registImprintCallback(r, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static int b() {
        int i2;
        synchronized (x) {
            i2 = w;
        }
        return i2;
    }

    public static void c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i2) {
        Handler handler;
        if (!m || (handler = f5129b) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        f5129b.sendMessage(messageObtainMessage);
    }

    public static void d() {
        if (p.tryLock()) {
            try {
                b(273);
            } finally {
                p.unlock();
            }
        }
    }

    public static void e() {
        a(f5133f, 3000);
    }

    private void n() {
        synchronized (x) {
            if ("11".equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), q, ""))) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                s = true;
                w = 15;
                int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), r, "15")).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + iIntValue);
                if (iIntValue < 3 || iIntValue > 90) {
                    w = 15;
                } else {
                    w = iIntValue * 1000;
                }
            } else {
                s = false;
            }
        }
    }

    private static void o() {
        if (a != null) {
            a = null;
        }
        if (f5129b != null) {
            f5129b = null;
        }
        if (f5130c != null) {
            f5130c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        int size;
        synchronized (o) {
            ArrayList<UMSenderStateNotify> arrayList = n;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    n.get(i2).onSenderIdle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (m) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (!new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.d("--->>> Send envelope file success, delete it.");
                        if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                            ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                            UMFrUtils.removeEnvelopeFile(envelopeFile);
                        }
                        c(273);
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (x) {
            if (q.equals(str)) {
                if ("11".equals(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    s = true;
                } else {
                    s = false;
                }
            }
            if (r.equals(str)) {
                int iIntValue = Integer.valueOf(str2).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + iIntValue);
                if (iIntValue < 3 || iIntValue > 90) {
                    w = 15000;
                } else {
                    w = iIntValue * 1000;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + w);
            }
        }
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (o) {
            try {
                if (n == null) {
                    n = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i2 = 0; i2 < n.size(); i2++) {
                        if (uMSenderStateNotify == n.get(i2)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    n.add(uMSenderStateNotify);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    private static void b(int i2) {
        Handler handler;
        if (!m || (handler = f5129b) == null || handler.hasMessages(i2)) {
            return;
        }
        Message messageObtainMessage = f5129b.obtainMessage();
        messageObtainMessage.what = i2;
        f5129b.sendMessage(messageObtainMessage);
    }

    public static boolean a() {
        boolean z;
        synchronized (x) {
            z = s;
        }
        return z;
    }

    private static void a(int i2, long j2) {
        Handler handler;
        if (!m || (handler = f5129b) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j2);
        f5129b.sendMessageDelayed(messageObtainMessage, j2);
    }

    private static void a(int i2, int i3) {
        Handler handler;
        if (!m || (handler = f5129b) == null) {
            return;
        }
        handler.removeMessages(i2);
        Message messageObtainMessage = f5129b.obtainMessage();
        messageObtainMessage.what = i2;
        f5129b.sendMessageDelayed(messageObtainMessage, i3);
    }
}
