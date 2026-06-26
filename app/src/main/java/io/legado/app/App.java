package io.legado.app;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.res.Configuration;
import android.os.Build;
import androidx.multidex.MultiDexApplication;
import c.b.a.m.f;
import c.h.a.a.a;
import com.ifmvo.togetherad.core.TogetherAd;
import com.ifmvo.togetherad.csj.TogetherAdCsj;
import com.ifmvo.togetherad.gdt.TogetherAdGdt;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import e.a.a.d.d;
import e.a.a.d.l;
import e.a.a.h.t;
import f.c0.c.j;
import f.g;
import f.x.e;
import io.legado.app.help.ThemeConfig;
import io.wenyuange.app.release.R;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/legado/app/App;", "Landroidx/multidex/MultiDexApplication;", "Lf/v;", "onCreate", "()V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class App extends MultiDexApplication {
    public static int a;

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        j.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i2 = newConfig.uiMode & 48;
        if (i2 == 16 || i2 == 32) {
            ThemeConfig.a.b(this);
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        a.c cVar = a.a;
        try {
            a.a.a(getBaseContext());
        } catch (Throwable unused) {
        }
        Beta.autoInit = true;
        Beta.autoCheckUpgrade = true;
        Beta.initDelay = 1000L;
        Beta.autoDownloadOnWifi = true;
        Bugly.init(getApplicationContext(), "6494275b58", true);
        // AD REMOVED: skip Umeng analytics initialization
        // UMConfigure.init(getApplicationContext(), "60b0afaedd01c71b57c96877", "ads", 1, "");
        // MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
        new l(this);
        t.b(this);
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = getSystemService("notification");
            NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
            if (notificationManager != null) {
                NotificationChannel notificationChannel = new NotificationChannel("channel_download", getString(R.string.action_download), 3);
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                NotificationChannel notificationChannel2 = new NotificationChannel("channel_read_aloud", getString(R.string.read_aloud), 3);
                notificationChannel2.enableLights(false);
                notificationChannel2.enableVibration(false);
                notificationChannel2.setSound(null, null);
                NotificationChannel notificationChannel3 = new NotificationChannel("channel_web", getString(R.string.web_service), 3);
                notificationChannel3.enableLights(false);
                notificationChannel3.enableVibration(false);
                notificationChannel3.setSound(null, null);
                notificationManager.createNotificationChannels(e.u(notificationChannel, notificationChannel2, notificationChannel3));
            }
        }
        ThemeConfig.a.b(this);
        LiveEventBus.config().supportBroadcast(this).lifecycleObserverAlwaysActive(true).autoClear(false);
        registerActivityLifecycleCallbacks(d.a);
        f.i2(this).registerOnSharedPreferenceChangeListener(e.a.a.d.e.a);
        // AD REMOVED: skip ad SDK initialization (TogetherAd, CSJ, GDT)
        // TogetherAdCsj togetherAdCsj = TogetherAdCsj.INSTANCE;
        // e.a.a.c.a aVar = e.a.a.c.a.CSJ;
        // togetherAdCsj.init(this, aVar.getType(), "5183362", "心情助手");
        // TogetherAdGdt togetherAdGdt = TogetherAdGdt.INSTANCE;
        // e.a.a.c.a aVar2 = e.a.a.c.a.GDT;
        // togetherAdGdt.init(this, aVar2.getType(), "1111978776");
        // int iT3 = f.T3(7);
        // g[] gVarArr = {new g("ad_splash", "887495984"), new g("ad_splash_hot", "887534932"), new g("ad_native_express_simple", "946257842"), new g("ad_native_as_banner", "946258904"), new g("ad_banner", "946261512"), new g("ad_inter", "946518261"), new g("ad_reward", "946257851")};
        // j.e(gVarArr, "pairs");
        // LinkedHashMap linkedHashMap = new LinkedHashMap(iT3);
        // e.y(linkedHashMap, gVarArr);
        // togetherAdCsj.setIdMapCsj(linkedHashMap);
        // g[] gVarArr2 = {new g("ad_splash", "6082201080875562"), new g("ad_splash_hot", "3082716933551076"), new g("ad_native_express_simple", "2042600060077642"), new g("ad_native_as_banner", "3072423394434916"), new g("ad_banner", "2042903496059063"), new g("ad_inter", "8052314966221151"), new g("ad_reward", "5092702040175765")};
        // j.e(gVarArr2, "pairs");
        // LinkedHashMap linkedHashMap2 = new LinkedHashMap(iT3);
        // e.y(linkedHashMap2, gVarArr2);
        // togetherAdGdt.setIdMapGDT(linkedHashMap2);
        // TogetherAd togetherAd = TogetherAd.INSTANCE;
        // togetherAd.setPublicProviderRatio(e.t(new g(aVar2.getType(), 1), new g(aVar.getType(), 1), new g(e.a.a.c.a.BAIDU.getType(), 0)));
        // togetherAd.setFailedSwitchEnable(true);
    }
}
