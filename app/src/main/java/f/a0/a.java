package f.a0;

import f.c0.c.j;
import java.lang.reflect.Method;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: f.a0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PlatformImplementations.kt */
    public static final class C0176a {

        @JvmField
        @Nullable
        public static final Method a;

        /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
        static {
            /*
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                f.c0.c.j.d(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            Le:
                java.lang.String r5 = "it"
                r6 = 0
                if (r4 >= r2) goto L47
                r7 = r1[r4]
                f.c0.c.j.d(r7, r5)
                java.lang.String r8 = r7.getName()
                java.lang.String r9 = "addSuppressed"
                boolean r8 = f.c0.c.j.a(r8, r9)
                r9 = 1
                if (r8 == 0) goto L3f
                java.lang.Class[] r8 = r7.getParameterTypes()
                java.lang.String r10 = "it.parameterTypes"
                f.c0.c.j.d(r8, r10)
                java.lang.String r10 = "$this$singleOrNull"
                f.c0.c.j.e(r8, r10)
                int r10 = r8.length
                if (r10 != r9) goto L38
                r6 = r8[r3]
            L38:
                boolean r6 = f.c0.c.j.a(r6, r0)
                if (r6 == 0) goto L3f
                goto L40
            L3f:
                r9 = 0
            L40:
                if (r9 == 0) goto L44
                r6 = r7
                goto L47
            L44:
                int r4 = r4 + 1
                goto Le
            L47:
                f.a0.a.C0176a.a = r6
                int r0 = r1.length
            L4a:
                if (r3 >= r0) goto L61
                r2 = r1[r3]
                f.c0.c.j.d(r2, r5)
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = f.c0.c.j.a(r2, r4)
                if (r2 == 0) goto L5e
                goto L61
            L5e:
                int r3 = r3 + 1
                goto L4a
            L61:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f.a0.a.C0176a.<clinit>():void");
        }
    }

    public void a(@NotNull Throwable th, @NotNull Throwable th2) {
        j.e(th, "cause");
        j.e(th2, "exception");
        Method method = C0176a.a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    @NotNull
    public f.d0.c b() {
        return new f.d0.b();
    }
}
