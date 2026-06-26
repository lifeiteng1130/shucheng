package c.c.a.r;

import c.c.a.n.d;
import c.c.a.q;
import com.bytedance.pangle.log.ZeusLogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static volatile a a;

    public static void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (q.a().f779c.isCloseDefaultReport()) {
            ZeusLogger.d("Zeus/DefaultReporterImpl", "skip default report");
            return;
        }
        ZeusLogger.d("Zeus/DefaultReporterImpl", "report by defaultImpl");
        d.a().monitorStatusAndEvent(str, 0, jSONObject, jSONObject2, jSONObject3);
        d.a().flushBuffer(new b("report result : "));
    }
}
