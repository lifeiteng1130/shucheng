package c.c.a.h;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {
    public final g a;

    public c(g gVar) {
        this.a = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void run() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L9c
            c.c.a.h.g r2 = r6.a     // Catch: java.lang.Throwable -> L9c
            long r2 = r2.f731c     // Catch: java.lang.Throwable -> L9c
            long r0 = r0 - r2
            r2 = 300000(0x493e0, double:1.482197E-318)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L13
            monitor-exit(r6)
            return
        L13:
            android.app.Application r0 = com.bytedance.pangle.Zeus.getAppApplication()     // Catch: java.lang.Throwable -> L9c
            r1 = 0
            java.lang.String r2 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L9c
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L9c
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L9c
            if (r0 == 0) goto L2e
            boolean r0 = r0.isConnected()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L9c
            if (r0 == 0) goto L2e
            r0 = 1
            goto L2f
        L2e:
            r0 = 0
        L2f:
            if (r0 != 0) goto L33
            monitor-exit(r6)
            return
        L33:
            r0 = 0
        L34:
            r2 = 2
            if (r0 >= r2) goto L9a
            int r2 = c.c.a.b.a     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            java.lang.String r2 = "Zeus/download"
            java.lang.String r3 = "Skip! useInternalNetworkImpl = false!"
            com.bytedance.pangle.log.ZeusLogger.d(r2, r3)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            c.c.a.q r2 = c.c.a.q.a()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            com.bytedance.pangle.ZeusParam r2 = r2.f779c     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            com.bytedance.pangle.plugin.PluginProvider r2 = r2.getPluginProvider()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            if (r2 == 0) goto L8d
            java.util.List r2 = r2.providePluginConfig()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            if (r2 == 0) goto L8d
            c.c.a.h.g r3 = r6.a     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            r3.f731c = r4     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            java.lang.String r3 = "Zeus/download"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            java.lang.String r5 = "handlePlugins, pluginSize = "
            r4.<init>(r5)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            int r5 = r2.size()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            r4.append(r5)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            com.bytedance.pangle.log.ZeusLogger.i(r3, r4)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            r3 = 0
        L72:
            int r4 = r2.size()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            if (r3 >= r4) goto L8a
            java.lang.Object r4 = r2.get(r3)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            com.bytedance.pangle.download.PluginDownloadBean r4 = (com.bytedance.pangle.download.PluginDownloadBean) r4     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            boolean r5 = c.c.a.h.g.e(r4)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
            if (r5 != 0) goto L87
            r2.remove(r4)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
        L87:
            int r3 = r3 + 1
            goto L72
        L8a:
            c.c.a.h.g.d(r2)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> L9c
        L8d:
            monitor-exit(r6)
            return
        L8f:
            r2 = move-exception
            java.lang.String r3 = "Zeus/download"
            java.lang.String r4 = "Request plugin config failed!!!"
            com.bytedance.pangle.log.ZeusLogger.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L9c
            int r0 = r0 + 1
            goto L34
        L9a:
            monitor-exit(r6)
            return
        L9c:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.h.c.run():void");
    }
}
