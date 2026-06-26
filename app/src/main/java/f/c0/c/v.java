package f.c0.c;

import java.util.Objects;

/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes3.dex */
public class v {
    public static final w a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f.f0.c[] f6126b;

    static {
        w wVar = null;
        try {
            wVar = (w) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (wVar == null) {
            wVar = new w();
        }
        a = wVar;
        f6126b = new f.f0.c[0];
    }

    public static f.f0.c a(Class cls) {
        Objects.requireNonNull(a);
        return new d(cls);
    }
}
