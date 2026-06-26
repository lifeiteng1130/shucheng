package e.a.a.d;

import e.a.a.h.f;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Cache;
import io.legado.app.model.analyzeRule.QueryTTF;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: CacheManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    @NotNull
    public static final i a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final HashMap<String, f.g<Long, QueryTTF>> f5537b = new HashMap<>();

    public static void a(i iVar, String str, Object obj, int i2, int i3) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        f.c0.c.j.e(str, "key");
        f.c0.c.j.e(obj, ES6Iterator.VALUE_PROPERTY);
        long jCurrentTimeMillis = i2 == 0 ? 0L : System.currentTimeMillis() + ((long) (i2 * 1000));
        if (obj instanceof QueryTTF) {
            f5537b.put(str, new f.g<>(Long.valueOf(jCurrentTimeMillis), obj));
        } else if (obj instanceof byte[]) {
            f.b.a(e.a.a.h.f.a, k.d.a.h.g(), null, 0L, 0, false, 30).d(str, (byte[]) obj, i2);
        } else {
            AppDatabaseKt.getAppDb().getCacheDao().insert(new Cache(str, obj.toString(), jCurrentTimeMillis));
        }
    }
}
