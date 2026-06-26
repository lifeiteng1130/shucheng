package e.b.a.r.n.b;

import com.umeng.analytics.pro.ai;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: CommonMarkEntities.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final Map<String, String> a;

    static {
        Map<String, String> map;
        try {
            Field declaredField = k.c.c.v.b.class.getDeclaredField(ai.at);
            declaredField.setAccessible(true);
            map = (Map) declaredField.get(null);
        } catch (Throwable th) {
            Map<String, String> mapEmptyMap = Collections.emptyMap();
            th.printStackTrace();
            map = mapEmptyMap;
        }
        a = map;
    }
}
