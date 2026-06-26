package c.c.a.v;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.c.a.g;
import c.c.a.i;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f791b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Boolean> f792c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, i> f793d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static g f794e;

    /* JADX INFO: renamed from: c.c.a.v.a$a, reason: collision with other inner class name */
    public static class C0036a implements IBinder.DeathRecipient {
        public final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBinder f795b;

        public C0036a(String str, IBinder iBinder) {
            this.a = str;
            this.f795b = iBinder;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            a.f792c.put(this.a, Boolean.FALSE);
            ZeusLogger.e(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
            HashMap<ServiceConnection, HashSet<ComponentName>> map = ServiceManagerNative.getInstance().process2ConnAndService.get(this.f795b);
            for (ServiceConnection serviceConnection : map.keySet()) {
                Iterator<ComponentName> it = map.get(serviceConnection).iterator();
                while (it.hasNext()) {
                    serviceConnection.onServiceDisconnected(it.next());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0 A[Catch: RemoteException -> 0x00b7, TryCatch #0 {RemoteException -> 0x00b7, blocks: (B:13:0x0050, B:28:0x0089, B:30:0x0093, B:32:0x0097, B:33:0x009a, B:35:0x00a0, B:37:0x00aa, B:39:0x00ae, B:40:0x00b1, B:18:0x0070, B:21:0x007a), top: B:47:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.os.IInterface a(java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.v.a.a(java.lang.String, java.lang.String):android.os.IInterface");
    }

    public static g b() {
        Boolean bool = f792c.get("main");
        if (bool == null || !bool.booleanValue()) {
            f794e = null;
        }
        if (f794e == null) {
            synchronized (f791b) {
                g gVar = (g) a(AbsServerManager.PACKAGE_QUERY_BINDER, "main");
                if (gVar == null) {
                    ZeusLogger.e(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                f794e = gVar;
            }
        }
        return f794e;
    }

    public static i c(String str) {
        Boolean bool = f792c.get(str);
        if (bool == null || !bool.booleanValue()) {
            f793d.remove(str);
        }
        Map<String, i> map = f793d;
        if (map.get(str) == null) {
            synchronized (a) {
                i iVar = (i) a("service", str);
                if (iVar == null) {
                    ZeusLogger.e(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                map.put(str, iVar);
            }
        }
        return map.get(str);
    }
}
