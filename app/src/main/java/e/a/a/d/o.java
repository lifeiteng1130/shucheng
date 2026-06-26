package e.a.a.d;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IntentDataHelp.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    @NotNull
    public static final o a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Map<String, Object> f5551b = new LinkedHashMap();

    public static String b(o oVar, Object obj, String str, int i2) {
        String str2 = (i2 & 2) != 0 ? "" : null;
        f.c0.c.j.e(obj, "data");
        f.c0.c.j.e(str2, "tag");
        String strK = f.c0.c.j.k(str2, Long.valueOf(System.currentTimeMillis()));
        f5551b.put(strK, obj);
        return strK;
    }

    @Nullable
    public final <T> T a(@Nullable String str) {
        Map<String, Object> map = f5551b;
        T t = (T) map.get(str);
        map.remove(str);
        return t;
    }
}
