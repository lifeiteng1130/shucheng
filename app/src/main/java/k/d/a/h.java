package k.d.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.app.backup.BackupAgent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import f.c0.c.j;
import f.k;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: TypeInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8792b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f8793c;

    public static final int a(int i2) {
        return ((i2 & 65535) << 8) | 7;
    }

    public static final int b(String str, d dVar) {
        return a(dVar.a(str));
    }

    public static String c(Context context) {
        k.f.b.b.a.c cVarA = k.f.b.b.a.c.a(context);
        Objects.requireNonNull(cVarA);
        if (!k.f.b.b.a.c.f8927b) {
            return null;
        }
        String str = k.f.b.b.a.c.f8933h;
        if (str != null) {
            return str;
        }
        cVarA.b(0, null);
        if (k.f.b.b.a.c.f8928c == null) {
            Context context2 = k.f.b.b.a.c.a;
            k.f.b.b.a.c.f8928c = new k.f.b.b.a.d(k.f.b.b.a.c.f8934i, 0, null);
            context2.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, k.f.b.b.a.c.f8928c);
        }
        return k.f.b.b.a.c.f8933h;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d(android.content.Context r6) {
        /*
            boolean r0 = k.d.a.h.a
            if (r0 == 0) goto L7e
            k.f.a.a.a.a$b r0 = k.f.a.a.a.a.b.C0234b.a
            android.content.Context r6 = r6.getApplicationContext()
            java.lang.String r1 = "OUID"
            monitor-enter(r0)
            android.os.Looper r2 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> L7b
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L7b
            if (r2 == r3) goto L73
            k.f.a.a.a.a r2 = r0.a     // Catch: java.lang.Throwable -> L7b
            if (r2 != 0) goto L65
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Throwable -> L7b
            r2.<init>()     // Catch: java.lang.Throwable -> L7b
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L7b
            java.lang.String r4 = "com.heytap.openid"
            java.lang.String r5 = "com.heytap.openid.IdentifyService"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L7b
            r2.setComponent(r3)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r3 = "action.com.heytap.openid.OPEN_ID_SERVICE"
            r2.setAction(r3)     // Catch: java.lang.Throwable -> L7b
            android.content.ServiceConnection r3 = r0.f8924e     // Catch: java.lang.Throwable -> L7b
            r4 = 1
            boolean r2 = r6.bindService(r2, r3, r4)     // Catch: java.lang.Throwable -> L7b
            if (r2 == 0) goto L4f
            java.lang.Object r2 = r0.f8923d     // Catch: java.lang.Throwable -> L7b
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r3 = r0.f8923d     // Catch: java.lang.Throwable -> L45 java.lang.InterruptedException -> L47
            r4 = 3000(0xbb8, double:1.482E-320)
            r3.wait(r4)     // Catch: java.lang.Throwable -> L45 java.lang.InterruptedException -> L47
            goto L4b
        L45:
            r6 = move-exception
            goto L4d
        L47:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L45
        L4b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L45
            goto L4f
        L4d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L45
            throw r6     // Catch: java.lang.Throwable -> L7b
        L4f:
            k.f.a.a.a.a r2 = r0.a     // Catch: java.lang.Throwable -> L7b
            if (r2 != 0) goto L57
            java.lang.String r6 = ""
            monitor-exit(r0)
            goto L72
        L57:
            java.lang.String r6 = r0.a(r6, r1)     // Catch: android.os.RemoteException -> L5d java.lang.Throwable -> L7b
            monitor-exit(r0)
            goto L72
        L5d:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r6 = ""
            monitor-exit(r0)
            goto L72
        L65:
            java.lang.String r6 = r0.a(r6, r1)     // Catch: android.os.RemoteException -> L6b java.lang.Throwable -> L7b
            monitor-exit(r0)
            goto L72
        L6b:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r6 = ""
            monitor-exit(r0)
        L72:
            return r6
        L73:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L7b
            java.lang.String r1 = "Cannot run on MainThread"
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L7b
            throw r6     // Catch: java.lang.Throwable -> L7b
        L7b:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        L7e:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r0 = "SDK Need Init First!"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: k.d.a.h.d(android.content.Context):java.lang.String");
    }

    public static final boolean e(@NotNull Context context) {
        j.f(context, "receiver$0");
        if (!(context instanceof Application)) {
            if (!(context instanceof Activity) && !(context instanceof Service) && !(context instanceof BackupAgent)) {
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext() != context) {
                        Context baseContext = contextWrapper.getBaseContext();
                        j.b(baseContext, "baseContext");
                        return e(baseContext);
                    }
                } else if (context.getApplicationContext() == null) {
                }
            }
            return true;
        }
        return false;
    }

    public static final int f(String str, d dVar) {
        if (str.length() != 1) {
            return a(dVar.a(str));
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            return 2;
        }
        if (cCharAt != 'S' && cCharAt != 'Z' && cCharAt != 'I') {
            if (cCharAt == 'J') {
                return 4;
            }
            switch (cCharAt) {
                case 'B':
                case 'C':
                    break;
                case 'D':
                    return 3;
                default:
                    throw new IllegalArgumentException("bad type");
            }
        }
        return 1;
    }

    @NotNull
    public static final Context g() throws IllegalAccessException, InvocationTargetException {
        Context context = f8793c;
        if (context != null) {
            return context;
        }
        Object objInvoke = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        if (objInvoke == null) {
            throw new k("null cannot be cast to non-null type android.content.Context");
        }
        Context context2 = (Context) objInvoke;
        f8793c = context2;
        return context2;
    }

    public static Class<?> h(String str) {
        try {
            return Class.forName(str.replace(Attributes.InternalPrefix, '.'));
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static final String i(int i2, d dVar) {
        if ((i2 & 255) == 7) {
            return (String) dVar.e(i2 >>> 8);
        }
        throw new IllegalArgumentException("expecting object type");
    }

    public static boolean j(int i2) {
        return i2 == 3 || i2 == 4;
    }

    public static String k(int i2, d dVar) {
        int i3 = i2 & 255;
        switch (i3) {
            case 0:
                return "top";
            case 1:
                return "int";
            case 2:
                return "float";
            case 3:
                return "double";
            case 4:
                return "long";
            case 5:
                return "null";
            case 6:
                return "uninitialized_this";
            default:
                if (i3 == 7) {
                    return i(i2, dVar);
                }
                if (i3 == 8) {
                    return "uninitialized";
                }
                throw new IllegalArgumentException("bad type");
        }
    }

    @NotNull
    public static Void l(String str, int i2) {
        int i3 = i2 & 1;
        throw new UnsupportedOperationException((String) null);
    }
}
