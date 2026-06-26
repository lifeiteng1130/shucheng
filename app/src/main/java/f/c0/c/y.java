package f.c0.c;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TypeIntrinsics.java */
/* JADX INFO: loaded from: classes3.dex */
public class y {
    public static Collection a(Object obj) {
        if (obj instanceof f.c0.c.z.a) {
            e(obj, "kotlin.collections.MutableCollection");
            throw null;
        }
        try {
            return (Collection) obj;
        } catch (ClassCastException e2) {
            j.j(e2, y.class.getName());
            throw e2;
        }
    }

    public static List b(Object obj) {
        if (obj instanceof f.c0.c.z.a) {
            e(obj, "kotlin.collections.MutableList");
            throw null;
        }
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            j.j(e2, y.class.getName());
            throw e2;
        }
    }

    public static Map c(Object obj) {
        if (obj instanceof f.c0.c.z.a) {
            e(obj, "kotlin.collections.MutableMap");
            throw null;
        }
        try {
            return (Map) obj;
        } catch (ClassCastException e2) {
            j.j(e2, y.class.getName());
            throw e2;
        }
    }

    public static Object d(Object obj, int i2) {
        if ((obj instanceof g ? ((g) obj).getArity() : obj instanceof f.c0.b.a ? 0 : obj instanceof f.c0.b.l ? 1 : obj instanceof f.c0.b.p ? 2 : obj instanceof f.c0.b.q ? 3 : obj instanceof f.c0.b.r ? 4 : obj instanceof f.c0.b.s ? 5 : obj instanceof f.c0.b.t ? 6 : obj instanceof f.c0.b.u ? 7 : obj instanceof f.c0.b.v ? 8 : obj instanceof f.c0.b.w ? 9 : obj instanceof f.c0.b.b ? 10 : obj instanceof f.c0.b.c ? 11 : obj instanceof f.c0.b.d ? 12 : obj instanceof f.c0.b.e ? 13 : obj instanceof f.c0.b.f ? 14 : obj instanceof f.c0.b.g ? 15 : obj instanceof f.c0.b.h ? 16 : obj instanceof f.c0.b.i ? 17 : obj instanceof f.c0.b.j ? 18 : obj instanceof f.c0.b.k ? 19 : obj instanceof f.c0.b.m ? 20 : obj instanceof f.c0.b.n ? 21 : obj instanceof f.c0.b.o ? 22 : -1) == i2) {
            return obj;
        }
        e(obj, "kotlin.jvm.functions.Function" + i2);
        throw null;
    }

    public static void e(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(c.a.a.a.a.k(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        j.j(classCastException, y.class.getName());
        throw classCastException;
    }
}
