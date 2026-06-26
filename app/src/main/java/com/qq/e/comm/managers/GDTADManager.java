package com.qq.e.comm.managers;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SystemUtil;
import com.umeng.analytics.pro.ai;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GDTADManager implements IGDTAdManager {
    public static final ExecutorService INIT_EXECUTOR = Executors.newSingleThreadExecutor();
    private volatile Boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Context f2779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile SM f2780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile PM f2781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile DevTools f2782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile APPStatus f2783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile DeviceStatus f2784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f2785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private e f2786i;

    public class a extends Thread {
        public final /* synthetic */ long a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, long j2) {
            super(str);
            this.a = j2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            GDTADManager.a(GDTADManager.this, this.a);
        }
    }

    public static final class b {
        private static GDTADManager a = new GDTADManager(null);
    }

    private GDTADManager() {
        this.a = Boolean.FALSE;
    }

    public /* synthetic */ GDTADManager(a aVar) {
        this();
    }

    private void a(Context context, String str) {
        long jNanoTime = System.nanoTime();
        this.f2785h = SystemUtil.getProcessName(context);
        this.f2779b = context.getApplicationContext();
        this.f2780c = new SM(this.f2779b);
        this.f2781d = new PM(this.f2779b, this.f2786i);
        this.f2783f = new APPStatus(str, this.f2779b);
        this.f2784g = new DeviceStatus(this.f2779b);
        new a("GDT_ACTIVATE_LAUNCH", jNanoTime).start();
    }

    public static void a(GDTADManager gDTADManager, long j2) {
        Objects.requireNonNull(gDTADManager);
        com.qq.e.comm.b.a.a().a(gDTADManager.f2779b, gDTADManager.f2780c, gDTADManager.f2781d, gDTADManager.f2784g, gDTADManager.f2783f, j2);
    }

    public static GDTADManager getInstance() {
        return b.a;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (!isInitialized()) {
            return null;
        }
        SM sm = this.f2780c;
        JSONObject jSONObject = new JSONObject();
        if (sm != null) {
            jSONObject.putOpt("suid", sm.getSuid());
            jSONObject.putOpt("sid", sm.getSid());
        }
        jSONObject.put("app", com.qq.e.comm.net.a.a(this.f2783f));
        jSONObject.put(ai.aD, com.qq.e.comm.net.a.a(this.f2784g));
        jSONObject.put("sdk", com.qq.e.comm.net.a.a(this.f2781d));
        return jSONObject;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f2779b;
    }

    public APPStatus getAppStatus() {
        return this.f2783f;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId() {
        if (!isInitialized()) {
            return "";
        }
        try {
            return this.f2781d.getPOFactory().getBuyerId();
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.f2782e == null) {
            this.f2782e = new DevTools();
        }
        return this.f2782e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f2784g;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public PM getPM() {
        return this.f2781d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public String getProcessName() {
        return this.f2785h;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
    }

    public String getRewardvideoPortraitADActivityClazz() {
        return CustomPkgConstants.getRewardvideoPortraitADActivityName();
    }

    public SM getSM() {
        return this.f2780c;
    }

    public synchronized boolean initWith(Context context, String str) {
        if (this.a.booleanValue()) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
            return false;
        }
        try {
            a(context, str);
            this.a = Boolean.TRUE;
            return true;
        } catch (Throwable th) {
            GDTLogger.e("GDTADManager初始化错误", th);
            return false;
        }
    }

    public boolean isInitialized() {
        if (this.a != null && this.a.booleanValue()) {
            return true;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.init() 初始化");
        return false;
    }

    public void setPluginLoadListener(e eVar) {
        this.f2786i = eVar;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (!isInitialized()) {
            return 0;
        }
        try {
            return this.f2781d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return 0;
        }
    }
}
