package c.c.a.n;

import android.content.Context;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static String a;

    static {
        new CopyOnWriteArrayList();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:(2:40|6)|(16:9|(3:43|11|12)(1:44)|15|38|16|36|17|(6:18|(1:20)(1:45)|34|25|31|32)|21|(1:23)|24|34|25|31|32|7)|42|15|38|16|36|17|(7:18|(0)(0)|34|25|31|32|20)|21|(0)|24|34|25|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0098, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0099, code lost:
    
        if (r0 != null) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c A[Catch: all -> 0x0096, LOOP:1: B:18:0x0066->B:20:0x006c, LOOP_END, TryCatch #1 {all -> 0x0096, blocks: (B:17:0x0061, B:18:0x0066, B:20:0x006c, B:21:0x0071, B:23:0x0077, B:24:0x008e), top: B:36:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077 A[Catch: all -> 0x0096, TryCatch #1 {all -> 0x0096, blocks: (B:17:0x0061, B:18:0x0066, B:20:0x006c, B:21:0x0071, B:23:0x0077, B:24:0x008e), top: B:36:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0071 A[EDGE_INSN: B:45:0x0071->B:21:0x0071 BREAK  A[LOOP:1: B:18:0x0066->B:20:0x006c], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r5) {
        /*
            java.lang.String r0 = c.c.a.n.c.a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r5 = c.c.a.n.c.a
            return r5
        Lb:
            int r0 = android.os.Process.myPid()     // Catch: java.lang.Exception -> L34
            java.lang.String r1 = "activity"
            java.lang.Object r5 = r5.getSystemService(r1)     // Catch: java.lang.Exception -> L34
            android.app.ActivityManager r5 = (android.app.ActivityManager) r5     // Catch: java.lang.Exception -> L34
            java.util.List r5 = r5.getRunningAppProcesses()     // Catch: java.lang.Exception -> L34
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L34
        L1f:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Exception -> L34
            if (r1 == 0) goto L38
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Exception -> L34
            android.app.ActivityManager$RunningAppProcessInfo r1 = (android.app.ActivityManager.RunningAppProcessInfo) r1     // Catch: java.lang.Exception -> L34
            int r2 = r1.pid     // Catch: java.lang.Exception -> L34
            if (r2 != r0) goto L1f
            java.lang.String r5 = r1.processName     // Catch: java.lang.Exception -> L34
            c.c.a.n.c.a = r5     // Catch: java.lang.Exception -> L34
            return r5
        L34:
            r5 = move-exception
            r5.printStackTrace()
        L38:
            r5 = 0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L98
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L98
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L98
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98
            java.lang.String r4 = "/proc/"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L98
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L98
            r3.append(r4)     // Catch: java.lang.Throwable -> L98
            java.lang.String r4 = "/cmdline"
            r3.append(r4)     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L98
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "iso-8859-1"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L98
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L98
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r1.<init>()     // Catch: java.lang.Throwable -> L96
        L66:
            int r2 = r0.read()     // Catch: java.lang.Throwable -> L96
            if (r2 <= 0) goto L71
            char r2 = (char) r2     // Catch: java.lang.Throwable -> L96
            r1.append(r2)     // Catch: java.lang.Throwable -> L96
            goto L66
        L71:
            boolean r2 = com.bytedance.pangle.log.ZeusLogger.isDebug()     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L8e
            java.lang.String r2 = "Process"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            java.lang.String r4 = "get processName = "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L96
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L96
            r3.append(r4)     // Catch: java.lang.Throwable -> L96
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L96
            com.bytedance.pangle.log.ZeusLogger.d(r2, r3)     // Catch: java.lang.Throwable -> L96
        L8e:
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L96
        L92:
            r0.close()     // Catch: java.lang.Exception -> L9c
            goto L9c
        L96:
            goto L99
        L98:
            r0 = r5
        L99:
            if (r0 == 0) goto L9c
            goto L92
        L9c:
            c.c.a.n.c.a = r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.n.c.a(android.content.Context):java.lang.String");
    }

    public static boolean b(Context context) {
        String strA = a(context);
        return (strA == null || !strA.contains(":")) && strA != null && strA.equals(context.getPackageName());
    }
}
