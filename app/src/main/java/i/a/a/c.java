package i.a.a;

import com.tencent.bugly.beta.tinker.TinkerReport;
import java.lang.reflect.Method;
import java.util.HashMap;
import k.e.a.n;
import k.e.a.o;
import k.e.a.r;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: BeansAccessBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static String a = b.class.getName().replace('.', Attributes.InternalPrefix);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a[] f6339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f6340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f6342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f6343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f6344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<Class<?>, Method> f6345h = new HashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Class<? extends Exception> f6346i = NoSuchFieldException.class;

    public c(Class<?> cls, a[] aVarArr, g gVar) {
        this.f6339b = aVarArr;
        this.f6340c = gVar;
        String name = cls.getName();
        this.f6341d = name;
        if (name.startsWith("java.")) {
            this.f6342e = "net.minidev.asm." + name + "AccAccess";
        } else {
            this.f6342e = name.concat("AccAccess");
        }
        this.f6343f = this.f6342e.replace('.', Attributes.InternalPrefix);
        this.f6344g = name.replace('.', Attributes.InternalPrefix);
    }

    public final void a(o oVar, int i2, int i3, n nVar) {
        oVar.u(21, i2);
        if (i3 == 0) {
            oVar.h(154, nVar);
            return;
        }
        if (i3 == 1) {
            oVar.e(4);
            oVar.h(160, nVar);
            return;
        }
        if (i3 == 2) {
            oVar.e(5);
            oVar.h(160, nVar);
            return;
        }
        if (i3 == 3) {
            oVar.e(6);
            oVar.h(160, nVar);
            return;
        }
        if (i3 == 4) {
            oVar.e(7);
            oVar.h(160, nVar);
        } else if (i3 == 5) {
            oVar.e(8);
            oVar.h(160, nVar);
        } else {
            if (i3 < 6) {
                throw new RuntimeException("non supported negative values");
            }
            oVar.g(16, i3);
            oVar.h(160, nVar);
        }
    }

    public final void b(o oVar, a aVar) {
        oVar.u(25, 1);
        oVar.t(192, this.f6344g);
        oVar.u(25, 3);
        r rVarH = r.h(aVar.f6334e);
        Class<?> cls = aVar.f6334e;
        String strF = r.f(cls);
        Method method = this.f6345h.get(cls);
        if (method != null) {
            oVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, r.f(method.getDeclaringClass()), method.getName(), r.g(method));
        } else if (aVar.f6334e.isEnum()) {
            n nVar = new n();
            oVar.h(198, nVar);
            oVar.u(25, 3);
            oVar.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/Object", "toString", "()Ljava/lang/String;");
            oVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, strF, "valueOf", "(Ljava/lang/String;)L" + strF + ";");
            oVar.u(58, 3);
            oVar.i(nVar);
            oVar.c(3, 0, null, 0, null);
            oVar.u(25, 1);
            oVar.t(192, this.f6344g);
            oVar.u(25, 3);
            oVar.t(192, strF);
        } else if (cls.equals(String.class)) {
            n nVar2 = new n();
            oVar.h(198, nVar2);
            oVar.u(25, 3);
            oVar.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/Object", "toString", "()Ljava/lang/String;");
            oVar.u(58, 3);
            oVar.i(nVar2);
            oVar.c(3, 0, null, 0, null);
            oVar.u(25, 1);
            oVar.t(192, this.f6344g);
            oVar.u(25, 3);
            oVar.t(192, strF);
        } else {
            oVar.t(192, strF);
        }
        if (aVar.a()) {
            oVar.b(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, this.f6344g, aVar.f6336g, rVarH.e());
        } else {
            oVar.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, this.f6344g, aVar.f6331b.getName(), r.g(aVar.f6331b));
        }
        oVar.e(177);
    }

    public final void c(o oVar, Class<?> cls) {
        String strReplace = cls.getName().replace('.', Attributes.InternalPrefix);
        oVar.t(187, strReplace);
        oVar.e(89);
        oVar.j("mapping " + this.f6341d + " failed to map field:");
        oVar.u(21, 2);
        oVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", "toString", "(I)Ljava/lang/String;");
        oVar.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        oVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, strReplace, "<init>", "(Ljava/lang/String;)V");
        oVar.e(191);
    }

    public final void d(o oVar, Class<?> cls) {
        String strReplace = cls.getName().replace('.', Attributes.InternalPrefix);
        oVar.t(187, strReplace);
        oVar.e(89);
        oVar.j("mapping " + this.f6341d + " failed to map field:");
        oVar.u(25, 2);
        oVar.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        oVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, strReplace, "<init>", "(Ljava/lang/String;)V");
        oVar.e(191);
    }
}
