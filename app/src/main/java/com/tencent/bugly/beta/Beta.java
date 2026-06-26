package com.tencent.bugly.beta;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.tinker.TinkerApplicationLike;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import com.tencent.bugly.beta.ui.UpgradeDialog;
import com.tencent.bugly.beta.upgrade.ActiveListener;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.UpgradeListener;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.beta.upgrade.d;
import com.tencent.bugly.beta.utils.e;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.C0323p;
import com.tencent.bugly.proguard.C0330x;
import com.tencent.bugly.proguard.C0331y;
import com.tencent.bugly.proguard.C0332z;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.r;
import com.umeng.analytics.pro.am;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class Beta extends a {
    public static final String TAG_CANCEL_BUTTON = "beta_cancel_button";
    public static final String TAG_CONFIRM_BUTTON = "beta_confirm_button";
    public static final String TAG_IMG_BANNER = "beta_upgrade_banner";
    public static final String TAG_TIP_MESSAGE = "beta_tip_message";
    public static final String TAG_TITLE = "beta_title";
    public static final String TAG_UPGRADE_FEATURE = "beta_upgrade_feature";
    public static final String TAG_UPGRADE_INFO = "beta_upgrade_info";
    public static ActiveListener activeListener = null;
    public static boolean autoCheckAppUpgrade = false;
    public static boolean autoCheckHotfix = false;
    public static boolean autoCheckUpgrade = true;
    public static boolean autoInit = true;
    public static BetaPatchListener betaPatchListener = null;
    public static int defaultBannerId = 0;
    public static DownloadListener downloadListener = null;
    public static long initDelay = 3000;
    public static String initProcessName = null;
    public static int largeIconId = 0;
    public static boolean showInterruptedStrategy = true;
    public static int smallIconId = 0;
    public static File storageDir = null;
    public static String strNetworkTipsCancelBtn = "取消";
    public static String strNetworkTipsConfirmBtn = "继续下载";
    public static String strNetworkTipsMessage = "你已切换到移动网络，是否继续当前下载？";
    public static String strNetworkTipsTitle = "网络提示";
    public static String strNotificationClickToContinue = "继续下载";
    public static String strNotificationClickToInstall = "点击安装";
    public static String strNotificationClickToRetry = "点击重试";
    public static String strNotificationClickToView = "点击查看";
    public static String strNotificationDownloadError = "下载失败";
    public static String strNotificationDownloadSucc = "下载完成";
    public static String strNotificationDownloading = "正在下载";
    public static String strNotificationHaveNewVersion = "有新版本";
    public static String strToastCheckUpgradeError = "检查新版本失败，请稍后重试";
    public static String strToastCheckingUpgrade = "正在检查，请稍候...";
    public static String strToastYourAreTheLatestVersion = "你已经是最新版了";
    public static String strUpgradeDialogCancelBtn = "下次再说";
    public static String strUpgradeDialogContinueBtn = "继续";
    public static String strUpgradeDialogFeatureLabel = "更新说明";
    public static String strUpgradeDialogFileSizeLabel = "包大小";
    public static String strUpgradeDialogInstallBtn = "安装";
    public static String strUpgradeDialogRetryBtn = "重试";
    public static String strUpgradeDialogUpdateTimeLabel = "更新时间";
    public static String strUpgradeDialogUpgradeBtn = "立即更新";
    public static String strUpgradeDialogVersionLabel = "版本";
    public static int tipsDialogLayoutId;
    public static long upgradeCheckPeriod;
    public static int upgradeDialogLayoutId;
    public static UILifecycleListener<UpgradeInfo> upgradeDialogLifecycleListener;
    public static UpgradeListener upgradeListener;
    public static UpgradeStateListener upgradeStateListener;
    public static List<Class<? extends Activity>> canShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static List<Class<? extends Activity>> canNotShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static boolean enableHotfix = false;
    public static boolean enableNotification = true;
    public static boolean autoDownloadOnWifi = false;
    public static boolean canShowApkInfo = true;
    public static boolean canAutoDownloadPatch = true;
    public static boolean canAutoPatch = true;
    public static String appVersionName = null;
    public static int appVersionCode = Integer.MIN_VALUE;
    public static String appChannel = null;
    public static boolean canNotifyUserRestart = false;
    public static List<String> soBlackList = Collections.synchronizedList(new ArrayList());
    public static boolean dialogFullScreen = false;
    public static boolean autoInstallApk = true;
    public static boolean autoDownloadOn4g = false;
    public static boolean setPatchRestartOnScreenOff = true;
    public static boolean enableActiveH5Alert = true;
    public static Beta instance = new Beta();
    private static DownloadTask a = null;

    private static void a(boolean z, boolean z2, int i2) {
        try {
            if (z) {
                d.a.a(z, z2, i2);
                UpgradeStateListener upgradeStateListener2 = upgradeStateListener;
                if (upgradeStateListener2 != null) {
                    e.a(new com.tencent.bugly.beta.global.d(18, upgradeStateListener2, 2, Boolean.valueOf(z)));
                } else {
                    e.a(new com.tencent.bugly.beta.global.d(5, strToastCheckingUpgrade));
                }
            } else if (i2 == 0 || i2 == 1) {
                BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                if (betaGrayStrategy == null || betaGrayStrategy.a == null || System.currentTimeMillis() - betaGrayStrategy.f4000e > com.tencent.bugly.beta.global.e.f3983b.f3985d) {
                    d.a.a(z, z2, i2);
                } else {
                    d.a.a(z, z2, 0, null, "");
                }
            } else if (i2 != 3) {
            } else {
                r.a.a(z, z2, 3);
            }
        } catch (Exception e2) {
            if (X.a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    public static void applyDownloadedPatch() throws Throwable {
        if (new File(com.tencent.bugly.beta.global.e.f3983b.J.getAbsolutePath()).exists()) {
            TinkerManager.getInstance().applyPatch(com.tencent.bugly.beta.global.e.f3983b.J.getAbsolutePath(), true);
        } else {
            X.b(Beta.class, "[applyDownloadedPatch] patch file not exist", new Object[0]);
        }
    }

    public static void applyTinkerPatch(Context context, String str) {
        TinkerManager.getInstance().applyPatch(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void cancelDownload() {
        /*
            com.tencent.bugly.beta.upgrade.d r0 = com.tencent.bugly.beta.upgrade.d.a
            com.tencent.bugly.beta.global.d r1 = r0.f4014j
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L25
            java.lang.Object[] r1 = r1.f3982b
            r5 = r1[r4]
            com.tencent.bugly.beta.download.DownloadTask r6 = r0.f4007c
            if (r5 != r6) goto L25
            r5 = r1[r3]
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r0 = r0.f4006b
            if (r5 != r0) goto L25
            r0 = r1[r2]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.tencent.bugly.beta.upgrade.d r1 = com.tencent.bugly.beta.upgrade.d.a
            boolean r1 = r1.f4011g
            if (r0 == r1) goto L43
        L25:
            com.tencent.bugly.beta.upgrade.d r0 = com.tencent.bugly.beta.upgrade.d.a
            com.tencent.bugly.beta.global.d r1 = new com.tencent.bugly.beta.global.d
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.tencent.bugly.beta.download.DownloadTask r6 = r0.f4007c
            r5[r4] = r6
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r4 = r0.f4006b
            r5[r3] = r4
            boolean r3 = r0.f4011g
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r5[r2] = r3
            r2 = 14
            r1.<init>(r2, r5)
            r0.f4014j = r1
        L43:
            com.tencent.bugly.beta.upgrade.d r0 = com.tencent.bugly.beta.upgrade.d.a
            com.tencent.bugly.beta.global.d r0 = r0.f4014j
            r0.run()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.cancelDownload():void");
    }

    public static void checkAppUpgrade() {
        a(true, false, 1);
    }

    public static void checkHotFix() {
        a(false, false, 3);
    }

    public static void checkUpgrade() {
        checkUpgrade(true, false);
    }

    public static void cleanTinkerPatch(boolean z) {
        com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false);
        TinkerManager.getInstance().cleanPatch(z);
    }

    public static void downloadPatch() {
        r rVar = r.a;
        rVar.f4429b = rVar.a((B) null);
        try {
            r rVar2 = r.a;
            BetaGrayStrategy betaGrayStrategy = rVar2.f4429b;
            if (betaGrayStrategy != null) {
                rVar2.a(0, betaGrayStrategy.a, true);
            }
        } catch (Exception unused) {
        }
    }

    public static UpgradeInfo getAppUpgradeInfo() {
        try {
            d.a.f4006b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            BetaGrayStrategy betaGrayStrategy = d.a.f4006b;
            if (betaGrayStrategy != null) {
                return new UpgradeInfo(betaGrayStrategy.a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static UpgradeInfo getHotfixUpgradeInfo() {
        try {
            r.a.f4429b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            BetaGrayStrategy betaGrayStrategy = r.a.f4429b;
            if (betaGrayStrategy != null) {
                return new UpgradeInfo(betaGrayStrategy.a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Beta getInstance() {
        Beta beta = instance;
        beta.id = PointerIconCompat.TYPE_HAND;
        beta.version = "1.5.23";
        beta.versionKey = "G10";
        return beta;
    }

    public static DownloadTask getStrategyTask() {
        if (a == null) {
            d.a.f4006b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (d.a.f4006b != null) {
                DownloadTask downloadTaskA = com.tencent.bugly.beta.global.e.f3983b.s.a(d.a.f4006b.a.f4253k.f4468c, com.tencent.bugly.beta.global.e.f3983b.w.getAbsolutePath(), null, d.a.f4006b.a.f4253k.f4467b);
                a = downloadTaskA;
                downloadTaskA.setDownloadType(1);
                d.a.f4007c = a;
            }
        }
        return d.a.f4007c;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003b A[Catch: Exception -> 0x0043, TRY_LEAVE, TryCatch #0 {Exception -> 0x0043, blocks: (B:3:0x0003, B:5:0x000d, B:7:0x0015, B:10:0x001b, B:12:0x001f, B:26:0x003b, B:16:0x002a, B:20:0x0031), top: B:30:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.tencent.bugly.beta.UpgradeInfo getUpgradeInfo() {
        /*
            java.lang.String r0 = "hotfix.strategy.bch"
            r1 = 0
            android.os.Parcelable$Creator<com.tencent.bugly.beta.upgrade.BetaGrayStrategy> r2 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR     // Catch: java.lang.Exception -> L43
            android.os.Parcelable r0 = com.tencent.bugly.beta.global.a.a(r0, r2)     // Catch: java.lang.Exception -> L43
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r0 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r0     // Catch: java.lang.Exception -> L43
            java.lang.String r3 = "app.upgrade.strategy.bch"
            android.os.Parcelable r2 = com.tencent.bugly.beta.global.a.a(r3, r2)     // Catch: java.lang.Exception -> L43
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2     // Catch: java.lang.Exception -> L43
            if (r0 == 0) goto L28
            com.tencent.bugly.proguard.B r3 = r0.a     // Catch: java.lang.Exception -> L43
            if (r3 == 0) goto L28
            if (r2 == 0) goto L28
            com.tencent.bugly.proguard.B r3 = r2.a     // Catch: java.lang.Exception -> L43
            if (r3 == 0) goto L28
            long r3 = r0.f4000e     // Catch: java.lang.Exception -> L43
            long r5 = r2.f4000e     // Catch: java.lang.Exception -> L43
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L38
            goto L39
        L28:
            if (r0 == 0) goto L38
            com.tencent.bugly.proguard.B r3 = r0.a     // Catch: java.lang.Exception -> L43
            if (r3 != 0) goto L2f
            goto L38
        L2f:
            if (r2 == 0) goto L39
            com.tencent.bugly.proguard.B r2 = r2.a     // Catch: java.lang.Exception -> L43
            if (r2 != 0) goto L36
            goto L39
        L36:
            r0 = r1
            goto L39
        L38:
            r0 = r2
        L39:
            if (r0 == 0) goto L43
            com.tencent.bugly.beta.UpgradeInfo r2 = new com.tencent.bugly.beta.UpgradeInfo     // Catch: java.lang.Exception -> L43
            com.tencent.bugly.proguard.B r0 = r0.a     // Catch: java.lang.Exception -> L43
            r2.<init>(r0)     // Catch: java.lang.Exception -> L43
            return r2
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.getUpgradeInfo():com.tencent.bugly.beta.UpgradeInfo");
    }

    public static synchronized B getUpgradeStrategy() {
        d.a.f4006b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
        try {
            BetaGrayStrategy betaGrayStrategy = d.a.f4006b;
            if (betaGrayStrategy != null) {
                return (B) betaGrayStrategy.a.clone();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0212 A[Catch: all -> 0x05f4, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02bd A[Catch: all -> 0x05f4, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02f0 A[Catch: all -> 0x05f4, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02fc A[Catch: all -> 0x05f4, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0408 A[Catch: all -> 0x05f4, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0425 A[Catch: all -> 0x05f4, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0441 A[Catch: all -> 0x05f4, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x046f A[Catch: all -> 0x05f4, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04a8 A[Catch: all -> 0x05f4, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x01a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00da A[Catch: all -> 0x05f4, TRY_LEAVE, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010a A[Catch: all -> 0x05f4, TRY_LEAVE, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a A[Catch: all -> 0x05f4, TRY_LEAVE, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016d A[Catch: all -> 0x05f4, TRY_LEAVE, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a0 A[Catch: all -> 0x05f4, TRY_LEAVE, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e3 A[Catch: all -> 0x05f4, TryCatch #5 {, blocks: (B:5:0x0004, B:7:0x0024, B:8:0x002a, B:12:0x004e, B:14:0x0058, B:17:0x0065, B:19:0x0076, B:21:0x008d, B:23:0x0093, B:25:0x00aa, B:27:0x00ae, B:29:0x00ba, B:31:0x00c0, B:35:0x00da, B:37:0x00de, B:39:0x00ea, B:41:0x00f0, B:45:0x010a, B:47:0x010e, B:49:0x011a, B:51:0x0120, B:55:0x013a, B:57:0x013e, B:59:0x014a, B:61:0x0150, B:65:0x016d, B:67:0x0171, B:69:0x017d, B:71:0x0183, B:75:0x01a0, B:77:0x01a4, B:79:0x01ad, B:83:0x01cd, B:85:0x01d1, B:87:0x01d7, B:88:0x01dd, B:90:0x01e3, B:92:0x01eb, B:93:0x01f1, B:94:0x01fc, B:96:0x0200, B:98:0x0206, B:99:0x020c, B:101:0x0212, B:103:0x021a, B:104:0x0220, B:105:0x022b, B:109:0x0242, B:113:0x0254, B:117:0x0266, B:121:0x027a, B:125:0x028e, B:129:0x02a2, B:133:0x02b4, B:135:0x02bd, B:137:0x02c3, B:139:0x02cb, B:140:0x02db, B:141:0x02ec, B:143:0x02f0, B:144:0x02f4, B:146:0x02fc, B:147:0x0306, B:149:0x03f6, B:151:0x03fc, B:152:0x0402, B:154:0x0408, B:156:0x0410, B:157:0x0416, B:158:0x0421, B:160:0x0425, B:161:0x0430, B:163:0x0441, B:164:0x0448, B:166:0x045c, B:168:0x0460, B:169:0x046b, B:171:0x046f, B:172:0x0484, B:174:0x049e, B:177:0x05c8, B:176:0x04a8, B:82:0x01c0, B:74:0x0193, B:64:0x0160, B:54:0x012d, B:44:0x00fd, B:34:0x00cd, B:24:0x009b, B:20:0x007e), top: B:193:0x0004, inners: #0, #1, #2, #3, #4, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void init(android.content.Context r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 1527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.init(android.content.Context, boolean):void");
    }

    public static synchronized void installApk(File file) {
        B upgradeStrategy;
        try {
            upgradeStrategy = getUpgradeStrategy();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (upgradeStrategy != null && com.tencent.bugly.beta.global.a.a(com.tencent.bugly.beta.global.e.f3983b.v, file, upgradeStrategy.f4253k.f4467b)) {
            C0323p.a.a(new C0332z("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f4252j, upgradeStrategy.r, upgradeStrategy.u, null));
        }
    }

    public static void installTinker() {
        enableHotfix = true;
        installTinker(TinkerApplicationLike.getTinkerPatchApplicationLike());
    }

    public static void loadArmLibrary(Context context, String str) {
        TinkerManager.loadArmLibrary(context, str);
    }

    public static void loadArmV7Library(Context context, String str) {
        TinkerManager.loadArmV7Library(context, str);
    }

    public static void loadLibrary(String str) {
        boolean zLoadLibraryFromTinker;
        com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f3983b;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    if (!com.tencent.bugly.beta.global.a.a("LoadSoFileResult", true)) {
                        System.loadLibrary(str);
                        com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", true);
                        cleanTinkerPatch(true);
                        return;
                    }
                    com.tencent.bugly.beta.global.a.b("LoadSoFileResult", false);
                    String strA = com.tencent.bugly.beta.global.a.a(str, "");
                    boolean zA = com.tencent.bugly.beta.global.a.a("PatchResult", false);
                    if (TextUtils.isEmpty(strA) || !zA) {
                        zLoadLibraryFromTinker = false;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("lib/");
                        sb.append(strA);
                        zLoadLibraryFromTinker = TinkerManager.loadLibraryFromTinker(eVar.v, sb.toString(), str);
                    }
                    if (!zLoadLibraryFromTinker) {
                        System.loadLibrary(str);
                    }
                    com.tencent.bugly.beta.global.a.b("LoadSoFileResult", true);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                com.tencent.bugly.beta.global.a.b("LoadSoFileResult", false);
                return;
            }
        }
        X.b("libName is invalid", new Object[0]);
    }

    public static void loadLibraryFromTinker(Context context, String str, String str2) {
        TinkerManager.loadLibraryFromTinker(context, str, str2);
    }

    public static synchronized void onUpgradeReceived(String str, int i2, String str2, long j2, int i3, int i4, String str3, String str4, long j3, String str5, String str6, int i5, int i6, long j4, String str7, boolean z, boolean z2, int i7, String str8, long j5) {
        HashMap map = new HashMap();
        map.put("IMG_title", str6);
        map.put("VAL_style", String.valueOf(i5));
        d.a.a(z, z2, i7, new B(str, str2, j2, 0, new C0331y(com.tencent.bugly.beta.global.e.f3983b.x, (byte) 1, i4, str3, i3, "", 1L, "", str5, "", ""), new C0330x(str5, str4, "", j3, ""), (byte) i2, i6, j4, null, "", map, str7, 1, j5, 1), str8 == null ? "" : str8);
    }

    public static void registerDownloadListener(DownloadListener downloadListener2) {
        DownloadTask downloadTask;
        com.tencent.bugly.beta.global.e.f3983b.t = downloadListener2;
        if (downloadListener2 == null || (downloadTask = d.a.f4007c) == null) {
            return;
        }
        downloadTask.addListener(downloadListener2);
    }

    public static synchronized void saveInstallEvent(boolean z) {
        try {
            B upgradeStrategy = getUpgradeStrategy();
            if (upgradeStrategy != null && z) {
                C0323p.a.a(new C0332z("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f4252j, upgradeStrategy.r, upgradeStrategy.u, null));
                X.c("安装事件保存成功", new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized void showUpgradeDialog(String str, int i2, String str2, long j2, int i3, int i4, String str3, String str4, long j3, String str5, String str6, int i5, DownloadListener downloadListener2, Runnable runnable, Runnable runnable2, boolean z) {
        B b2;
        HashMap map = new HashMap();
        map.put("IMG_title", str6);
        map.put("VAL_style", String.valueOf(i5));
        B b3 = new B(str, str2, j2, 0, new C0331y(com.tencent.bugly.beta.global.e.f3983b.x, (byte) 1, i4, str3, i3, "", 1L, "", str5, "1.5.23", ""), new C0330x(str5, str4, "", j3, ""), (byte) i2, 0, 0L, null, "", map, null, 1, System.currentTimeMillis(), 1);
        DownloadTask downloadTask = a;
        if (downloadTask != null && !downloadTask.getDownloadUrl().equals(str4)) {
            a.delete(true);
            a = null;
        }
        if (a == null) {
            com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f3983b;
            b2 = b3;
            DownloadTask downloadTaskA = eVar.s.a(b2.f4253k.f4468c, eVar.w.getAbsolutePath(), null, b2.f4253k.f4467b);
            a = downloadTaskA;
            downloadTaskA.setDownloadType(1);
        } else {
            b2 = b3;
        }
        a.addListener(downloadListener2);
        UpgradeDialog.instance.setUpgradeInfo(b2, a);
        UpgradeDialog upgradeDialog = UpgradeDialog.instance;
        upgradeDialog.upgradeRunnable = runnable;
        upgradeDialog.cancelRunnable = runnable2;
        f.a.a(com.tencent.bugly.beta.global.e.f3983b.s, b2.q);
        if (z) {
            f fVar = f.a;
            Object[] objArr = new Object[2];
            objArr[0] = UpgradeDialog.instance;
            objArr[1] = Boolean.valueOf(b2.f4254l == 2);
            fVar.a(new com.tencent.bugly.beta.global.d(2, objArr), 3000);
        } else {
            f fVar2 = f.a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = UpgradeDialog.instance;
            objArr2[1] = Boolean.valueOf(b2.f4254l == 2);
            fVar2.a(new com.tencent.bugly.beta.global.d(2, objArr2));
        }
    }

    public static DownloadTask startDownload() {
        d dVar = d.a;
        com.tencent.bugly.beta.global.d dVar2 = dVar.f4013i;
        if (dVar2 == null || dVar2.f3982b[0] != dVar.f4007c) {
            dVar.f4013i = new com.tencent.bugly.beta.global.d(13, dVar.f4007c, dVar.f4006b);
        }
        d.a.f4013i.run();
        return d.a.f4007c;
    }

    public static void unInit() {
        if (com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false)) {
            com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false);
            TinkerManager.getInstance().cleanPatch(true);
        }
    }

    public static void unregisterDownloadListener() {
        DownloadTask downloadTask = d.a.f4007c;
        if (downloadTask != null) {
            downloadTask.removeListener(com.tencent.bugly.beta.global.e.f3983b.t);
        }
        com.tencent.bugly.beta.global.e.f3983b.t = null;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"dl_1002", "ge_1002", "st_1002"};
    }

    @Override // com.tencent.bugly.a
    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    @Override // com.tencent.bugly.a
    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        int i4;
        String str;
        String str2;
        Cursor cursorQuery;
        String str3 = " , ";
        String str4 = "_id";
        int i5 = i2;
        int i6 = i3;
        while (i5 < i6) {
            if (i5 != 10) {
                i4 = i5;
                str = str3;
                str2 = str4;
            } else {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.setLength(0);
                    sb.append(" CREATE TABLE  IF NOT EXISTS ");
                    sb.append("st_1002");
                    sb.append(" ( ");
                    sb.append(str4);
                    sb.append(" ");
                    sb.append("integer");
                    sb.append(str3);
                    sb.append(am.f4694e);
                    sb.append(" ");
                    sb.append(NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                    sb.append(str3);
                    sb.append("_tm");
                    sb.append(" ");
                    sb.append("int");
                    sb.append(str3);
                    sb.append("_dt");
                    sb.append(" ");
                    sb.append("blob");
                    sb.append(",primary key(");
                    sb.append(str4);
                    sb.append(",");
                    sb.append(am.f4694e);
                    sb.append(" )) ");
                    X.a("create %s", sb.toString());
                    sQLiteDatabase.execSQL(sb.toString());
                } catch (Throwable th) {
                    if (!X.a(th)) {
                        th.printStackTrace();
                    }
                }
                i4 = i5;
                str = str3;
                str2 = str4;
                try {
                    cursorQuery = sQLiteDatabase.query("t_pf", null, "_id = 1002", null, null, null, null);
                    if (cursorQuery == null) {
                        if (cursorQuery != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    while (cursorQuery.moveToNext()) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            if (cursorQuery.getLong(cursorQuery.getColumnIndex(str2)) > 0) {
                                contentValues.put(str2, Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex(str2))));
                            }
                            contentValues.put("_tm", Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("_tm"))));
                            contentValues.put(am.f4694e, cursorQuery.getString(cursorQuery.getColumnIndex(am.f4694e)));
                            contentValues.put("_dt", cursorQuery.getBlob(cursorQuery.getColumnIndex("_dt")));
                            sQLiteDatabase.replace("st_1002", null, contentValues);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                if (!X.a(th)) {
                                    th.printStackTrace();
                                }
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                            } finally {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                            }
                        }
                    }
                    cursorQuery.close();
                } catch (Throwable th3) {
                    th = th3;
                    cursorQuery = null;
                }
            }
            i5 = i4 + 1;
            i6 = i3;
            str4 = str2;
            str3 = str;
        }
    }

    public static void checkAppUpgrade(boolean z, boolean z2) {
        a(z, z2, 1);
    }

    public static void checkUpgrade(boolean z, boolean z2) {
        a(z, z2, 0);
    }

    public static void installTinker(Object obj) {
        enableHotfix = true;
        TinkerManager.setPatchRestartOnScreenOff(setPatchRestartOnScreenOff);
        X.c("setPatchRestartOnScreenOff %s", setPatchRestartOnScreenOff + "");
        TinkerManager.installTinker(obj);
    }

    public static void installTinker(Object obj, Object obj2, Object obj3, Object obj4, TinkerManager.TinkerPatchResultListener tinkerPatchResultListener, Object obj5) {
        enableHotfix = true;
        TinkerManager.installTinker(obj, obj2, obj3, obj4, tinkerPatchResultListener, obj5);
    }

    @Override // com.tencent.bugly.a
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        com.tencent.bugly.crashreport.common.info.a.m().a("G10", "1.5.23");
        if (autoInit) {
            init(context, z);
        }
    }
}
