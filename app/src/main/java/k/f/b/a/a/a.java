package k.f.b.a.a;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: IdentifierManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f8925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f8926c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f8925b = cls;
            a = cls.newInstance();
            f8925b.getMethod("getUDID", Context.class);
            f8926c = f8925b.getMethod("getOAID", Context.class);
            f8925b.getMethod("getVAID", Context.class);
            f8925b.getMethod("getAAID", Context.class);
        } catch (Exception unused) {
        }
    }
}
