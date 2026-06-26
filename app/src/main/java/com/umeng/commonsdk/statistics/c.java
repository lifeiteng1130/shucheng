package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.bi;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* JADX INFO: compiled from: NetWorkManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f5252b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f5253c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f5254d = 3;
    private static final String o = "thtstart";
    private static final String p = "gkvc";
    private static final String q = "ekvc";
    public String a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.c f5256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImprintHandler f5257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f5258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImprintHandler.a f5259i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Defcon f5261k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f5262l;
    private int m;
    private int n;
    private Context r;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f5255e = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ABTest f5260j = null;

    public c(Context context) {
        this.f5258h = null;
        this.f5259i = null;
        this.f5261k = null;
        this.f5262l = 0L;
        this.m = 0;
        this.n = 0;
        this.a = null;
        this.r = context;
        this.f5259i = ImprintHandler.getImprintService(context).c();
        this.f5261k = Defcon.getService(this.r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.r);
        this.f5262l = sharedPreferences.getLong(o, 0L);
        this.m = sharedPreferences.getInt(p, 0);
        this.n = sharedPreferences.getInt(q, 0);
        this.a = UMEnvelopeBuild.imprintProperty(this.r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.r);
        this.f5257g = imprintService;
        imprintService.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.f5261k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.a = UMEnvelopeBuild.imprintProperty(cVar.r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.r)) {
            this.f5258h = e.a(this.r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.r);
        this.f5256f = cVar;
        cVar.a(StatTracer.getInstance(this.r));
    }

    public boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a aVarA = com.umeng.commonsdk.statistics.internal.a.a(this.r);
            aVarA.d(name);
            boolean zA = aVarA.a(name);
            boolean zB = aVarA.b(name);
            boolean zC = aVarA.c(name);
            String strD = com.umeng.commonsdk.stateless.d.d(name);
            byte[] bArrA = this.f5256f.a(byteArray, zA, zC, !TextUtils.isEmpty(strD) ? com.umeng.commonsdk.stateless.d.c(strD) : zC ? UMServerURL.ZCFG_PATH : UMServerURL.PATH_ANALYTICS);
            int iA = bArrA == null ? 1 : a(bArrA);
            if (UMConfigure.isDebugLog()) {
                if (zC && iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (zB && iA == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (zA && iA == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (iA == 2) {
                e eVar = this.f5258h;
                if (eVar != null) {
                    eVar.e();
                }
                StatTracer.getInstance(this.r).saveSate();
            } else if (iA == 3) {
                StatTracer.getInstance(this.r).saveSate();
                if (zC) {
                    FieldManager.a().a(this.r);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    Context context = this.r;
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(context).a(), null);
                    return true;
                }
            }
            return iA == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new at(new bi.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.f5257g.b(response.getImprint());
                this.f5257g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
