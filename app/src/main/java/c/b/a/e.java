package c.b.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: GlideExperiments.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public final Map<Class<?>, ?> a;

    /* JADX INFO: compiled from: GlideExperiments.java */
    public static final class a {
        public final Map<Class<?>, ?> a = new HashMap();
    }

    public e(a aVar) {
        this.a = Collections.unmodifiableMap(new HashMap(aVar.a));
    }
}
