package c.c.a.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static volatile b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f690b = new ArrayList();

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                a = new b();
            }
        }
        return a;
    }

    public final void b(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.f690b) {
            Iterator<a> it = this.f690b.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
