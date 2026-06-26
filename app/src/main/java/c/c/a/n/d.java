package c.c.a.n;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.umeng.analytics.pro.ai;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static SDKMonitor a;

    public static class a implements SDKMonitor.IGetExtendParams {
    }

    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            for (int i2 = 0; i2 < 5; i2++) {
                SystemClock.sleep(2000L);
                d.a().flushBuffer(new c.c.a.r.b("flush buffer result : "));
            }
            d.a().flushReport(new c.c.a.r.b("flush report result : "));
        }
    }

    @NonNull
    public static SDKMonitor a() {
        if (a == null) {
            a = SDKMonitorUtils.getInstance("7520");
        }
        return a;
    }

    public static synchronized void b(Context context, String str, String str2, String str3) {
        c.c.a.x.d.a().execute(new b());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("device_id", str3);
            jSONObject.putOpt("host_aid", str);
            jSONObject.putOpt("channel", str2);
            jSONObject.putOpt("sdk_version", "0.0.1-beta.53-bugfix.13-pangle");
            jSONObject.putOpt(ai.o, context.getPackageName());
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            jSONObject.putOpt("app_version", sb.toString());
        } catch (JSONException | Exception unused) {
        }
        ZeusLogger.d("SDKMonitorHelper", "initSDKMonitor :" + jSONObject.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.add("https://mon.snssdk.com/monitor/appmonitor/v2/settings");
        SDKMonitorUtils.setConfigUrl("7520", arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("https://mon.snssdk.com/monitor/collect/");
        SDKMonitorUtils.setDefaultReportUrl("7520", arrayList2);
        SDKMonitorUtils.initMonitor(context, "7520", jSONObject, new a());
    }
}
