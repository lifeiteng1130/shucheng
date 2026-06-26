package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.d;
import com.umeng.commonsdk.internal.utils.b;
import com.umeng.commonsdk.internal.utils.c;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.common.ULog;

/* JADX INFO: loaded from: classes3.dex */
public class UMInnerImpl {
    private static boolean isInternal = false;

    public static synchronized void initAndSendInternal(final Context context) {
        if (context != null) {
            try {
                if (!isInternal) {
                    new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.2
                        @Override // java.lang.Runnable
                        public void run() {
                            String currentProcessName;
                            String packageName;
                            try {
                                currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                packageName = context.getPackageName();
                            } catch (Throwable th) {
                                UMCrashManager.reportCrash(context, th);
                            }
                            if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                                return;
                            }
                            try {
                                if (!c.a(context).a()) {
                                    c.a(context).b();
                                }
                            } catch (Throwable th2) {
                                ULog.e(UMModuleRegister.INNER, "e is " + th2);
                            }
                            try {
                                k.b(context);
                            } catch (Throwable th3) {
                                ULog.e(UMModuleRegister.INNER, "e is " + th3);
                            }
                            try {
                                com.umeng.commonsdk.internal.utils.a.c(context);
                            } catch (Throwable th4) {
                                ULog.e(UMModuleRegister.INNER, "e is " + th4);
                            }
                            try {
                                if (b.a(context).a()) {
                                    return;
                                }
                                b.a(context).b();
                                return;
                            } catch (Throwable unused) {
                                ULog.e(UMModuleRegister.INNER, "get station is null ");
                                return;
                            }
                            UMCrashManager.reportCrash(context, th);
                        }
                    }).start();
                    isInternal = true;
                    sendInternal(context);
                }
            } finally {
            }
        }
    }

    private static synchronized void sendInternal(final Context context) {
        if (context != null) {
            try {
                new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                            String packageName = context.getPackageName();
                            if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                                try {
                                    d.b(context);
                                } catch (Throwable th) {
                                    ULog.e(UMModuleRegister.INNER, "e is " + th);
                                }
                            }
                        } catch (Throwable th2) {
                            UMCrashManager.reportCrash(context, th2);
                        }
                    }
                }).start();
                isInternal = true;
            } finally {
            }
        }
    }
}
