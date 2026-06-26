package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* JADX INFO: compiled from: DownloadComponentManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile com.ss.android.socialbase.downloader.d.b A;
    private static volatile aa B;
    private static volatile com.ss.android.socialbase.downloader.network.f F;
    private static volatile com.ss.android.socialbase.downloader.network.f G;
    private static volatile u H;
    private static int K;
    private static final int L;
    private static final int M;
    private static final int N;
    private static final int O;
    private static int P;
    private static boolean Q;
    private static final List<com.ss.android.socialbase.downloader.depend.k> R;
    private static final List<ab> S;
    private static int T;
    private static boolean U;
    private static boolean V;
    private static r W;
    private static com.ss.android.socialbase.downloader.d.c X;
    private static volatile boolean Y;
    private static volatile Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile j f3555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile k f3556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile h f3557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile af f3558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.impls.a f3559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile o f3560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile o f3561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile a f3562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile IDownloadHttpService f3563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.network.h f3564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile IDownloadHttpService f3565l;
    private static volatile com.ss.android.socialbase.downloader.network.h m;
    private static volatile l n;
    private static volatile ExecutorService o;
    private static volatile ExecutorService p;
    private static volatile ExecutorService q;
    private static volatile ExecutorService r;
    private static volatile ExecutorService s;
    private static volatile ExecutorService t;
    private static volatile ExecutorService u;
    private static volatile ExecutorService v;
    private static volatile g w;
    private static volatile DownloadReceiver x;
    private static volatile s y;
    private static volatile q z;
    private static volatile List<ak> C = new ArrayList();
    private static volatile boolean D = false;
    private static volatile OkHttpClient E = null;
    private static final List<com.ss.android.socialbase.downloader.depend.m> I = new ArrayList();
    private static boolean J = false;

    /* JADX INFO: compiled from: DownloadComponentManager.java */
    public interface a {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DownloadComponentManager.java */
        public interface InterfaceC0111a {
            void a();
        }

        o a();

        t a(InterfaceC0111a interfaceC0111a);

        m b();
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        L = iAvailableProcessors;
        M = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        N = iAvailableProcessors;
        O = iAvailableProcessors;
        P = 8192;
        R = new ArrayList();
        S = new ArrayList();
        U = true;
        V = false;
        Y = false;
    }

    private c() {
    }

    public static List<com.ss.android.socialbase.downloader.depend.m> A() {
        return I;
    }

    public static k B() {
        if (f3556c == null) {
            synchronized (c.class) {
                if (f3556c == null) {
                    f3556c = new com.ss.android.socialbase.downloader.impls.i();
                }
            }
        }
        return f3556c;
    }

    public static com.ss.android.socialbase.downloader.impls.a C() {
        if (f3559f == null) {
            synchronized (c.class) {
                if (f3559f == null) {
                    f3559f = new com.ss.android.socialbase.downloader.impls.e();
                }
            }
        }
        return f3559f;
    }

    public static int D() {
        return T;
    }

    @NonNull
    public static JSONObject E() {
        return (B == null || B.a() == null) ? com.ss.android.socialbase.downloader.constants.e.f3510i : B.a();
    }

    public static void F() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.f3504c)) {
            com.ss.android.socialbase.downloader.constants.e.f3504c = "oppo";
            com.ss.android.socialbase.downloader.constants.e.f3503b = com.ss.android.socialbase.downloader.constants.e.f3504c.toUpperCase();
        }
    }

    public static boolean G() {
        return U;
    }

    public static synchronized int H() {
        return P;
    }

    public static h I() {
        if (f3557d == null) {
            synchronized (c.class) {
                if (f3557d == null) {
                    f3557d = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return f3557d;
    }

    public static af J() {
        return f3558e;
    }

    public static g K() {
        if (w == null) {
            synchronized (c.class) {
                if (w == null) {
                    w = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return w;
    }

    public static s L() {
        if (y == null) {
            synchronized (c.class) {
                if (y == null) {
                    y = new com.ss.android.socialbase.downloader.impls.j();
                }
            }
        }
        return y;
    }

    public static u M() {
        if (H == null) {
            synchronized (c.class) {
                if (H == null) {
                    H = new u.a();
                }
            }
        }
        return H;
    }

    public static synchronized Context N() {
        return a;
    }

    public static synchronized boolean O() {
        return Q;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.d.c P() {
        if (X == null) {
            X = new com.ss.android.socialbase.downloader.d.c() { // from class: com.ss.android.socialbase.downloader.downloader.c.3
                @Override // com.ss.android.socialbase.downloader.d.c
                public void a(int i2, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.d.c
                public void b(int i2, String str, JSONObject jSONObject) {
                }
            };
        }
        return X;
    }

    public static r Q() {
        return W;
    }

    public static boolean R() {
        return Y;
    }

    public static boolean S() {
        StringBuilder sbR = c.a.a.a.a.r("supportMultiProc::=");
        sbR.append(f3562i != null);
        com.ss.android.socialbase.downloader.c.a.a("wjd", sbR.toString());
        return f3562i != null;
    }

    public static a T() {
        return f3562i;
    }

    private static void U() {
        if (x == null) {
            x = new DownloadReceiver();
        }
        if (J) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            a.registerReceiver(x, intentFilter);
            J = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized void a(DownloaderBuilder downloaderBuilder) {
        if (Y) {
            com.ss.android.socialbase.downloader.c.a.e("DownloadComponentManager", "component has init");
            return;
        }
        boolean z2 = D;
        c(downloaderBuilder);
        if (f3555b == null) {
            f3555b = new com.ss.android.socialbase.downloader.impls.d();
        }
        if (f3560g == null) {
            f3560g = new com.ss.android.socialbase.downloader.impls.h();
        }
        if (f3561h == null && f3562i != null) {
            f3561h = f3562i.a();
        }
        if (f3556c == null) {
            f3556c = new com.ss.android.socialbase.downloader.impls.i();
        }
        if (f3559f == null) {
            f3559f = new com.ss.android.socialbase.downloader.impls.e();
        }
        if (f3557d == null) {
            f3557d = new com.ss.android.socialbase.downloader.impls.c();
        }
        if (w == null) {
            w = new com.ss.android.socialbase.downloader.impls.b();
        }
        if (y == null) {
            y = new com.ss.android.socialbase.downloader.impls.j();
        }
        int i2 = K;
        if (i2 <= 0 || i2 > L) {
            K = L;
        }
        U();
        if (D && !z2 && !com.ss.android.socialbase.downloader.i.f.c()) {
            com.ss.android.socialbase.downloader.impls.l.a(true).startService();
        } else if (com.ss.android.socialbase.downloader.i.f.d()) {
            ExecutorService executorServiceM = m();
            if (executorServiceM != null) {
                executorServiceM.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context contextN = c.N();
                        if (contextN != null) {
                            com.ss.android.socialbase.downloader.i.f.d(contextN);
                        }
                    }
                });
            }
        } else {
            Context contextN = N();
            if (contextN != null) {
                com.ss.android.socialbase.downloader.i.f.d(contextN);
            }
        }
        F();
        Y = true;
    }

    public static void a(r rVar) {
    }

    public static synchronized void b(DownloaderBuilder downloaderBuilder) {
        c(downloaderBuilder);
    }

    private static void c(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                a(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                a(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                a(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                a(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                a(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                b(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                a(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                a(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                a(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                c(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                d(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                e(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                f(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                g(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                h(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                a(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                b(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                a(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                z = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                P = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                a(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                D = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                T = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                a(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                F = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                H = downloaderBuilder.getTTNetHandler();
                if (H.a()) {
                    a(H.b());
                    a(H.c());
                } else {
                    a(h());
                    a(i());
                }
            }
            b(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                a(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    public static IDownloadHttpService d() {
        return f3563j;
    }

    public static List<ak> e() {
        List<ak> list;
        synchronized (C) {
            list = C;
        }
        return list;
    }

    public static com.ss.android.socialbase.downloader.network.h f() {
        return f3564k;
    }

    public static com.ss.android.socialbase.downloader.d.b g() {
        return A;
    }

    public static IDownloadHttpService h() {
        if (f3565l == null) {
            synchronized (c.class) {
                if (f3565l == null) {
                    f3565l = new com.ss.android.socialbase.downloader.impls.g();
                }
            }
        }
        return f3565l;
    }

    public static com.ss.android.socialbase.downloader.network.h i() {
        if (m == null) {
            synchronized (c.class) {
                if (m == null) {
                    m = new com.ss.android.socialbase.downloader.impls.f();
                }
            }
        }
        return m;
    }

    public static boolean j() {
        return com.ss.android.socialbase.downloader.g.a.c().a("switch_not_auto_boot_service", V ? 1 : 0) > 0;
    }

    public static synchronized q k() {
        return z;
    }

    public static ExecutorService l() {
        if (o == null) {
            synchronized (c.class) {
                if (o == null) {
                    int i2 = L;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-cpu-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    o = threadPoolExecutor;
                }
            }
        }
        return o;
    }

    public static ExecutorService m() {
        return p != null ? p : l();
    }

    public static ExecutorService n() {
        return r != null ? r : p();
    }

    public static ExecutorService o() {
        return s != null ? s : p();
    }

    public static ExecutorService p() {
        if (q == null) {
            synchronized (c.class) {
                if (q == null) {
                    int i2 = N;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-mix-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    q = threadPoolExecutor;
                }
            }
        }
        return q;
    }

    public static ExecutorService q() {
        if (u == null) {
            synchronized (c.class) {
                if (u == null) {
                    int i2 = M;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-chunk-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    u = threadPoolExecutor;
                }
            }
        }
        return u;
    }

    public static ExecutorService r() {
        if (t == null) {
            synchronized (c.class) {
                if (t == null) {
                    int i2 = O;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-db-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    t = threadPoolExecutor;
                }
            }
        }
        return t;
    }

    public static OkHttpClient s() {
        if (E == null) {
            synchronized (c.class) {
                if (E == null) {
                    E = t().build();
                }
            }
        }
        return E;
    }

    public static OkHttpClient.Builder t() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(30000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (v != null) {
            builder.dispatcher(new Dispatcher(v));
        }
        return builder;
    }

    public static com.ss.android.socialbase.downloader.network.f u() {
        return F;
    }

    public static com.ss.android.socialbase.downloader.network.f v() {
        if (G == null) {
            synchronized (c.class) {
                if (G == null) {
                    G = new com.ss.android.socialbase.downloader.network.f() { // from class: com.ss.android.socialbase.downloader.downloader.c.2
                        @Override // com.ss.android.socialbase.downloader.network.f
                        public List<InetAddress> a(String str) {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return G;
    }

    public static synchronized l w() {
        return n;
    }

    public static j x() {
        if (f3555b == null) {
            synchronized (c.class) {
                if (f3555b == null) {
                    f3555b = new com.ss.android.socialbase.downloader.impls.d();
                }
            }
        }
        return f3555b;
    }

    public static o y() {
        if (f3560g == null) {
            synchronized (c.class) {
                if (f3560g == null) {
                    f3560g = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return f3560g;
    }

    public static o z() {
        if (f3561h == null) {
            synchronized (c.class) {
                if (f3561h == null) {
                    f3561h = f3562i.a();
                }
            }
        }
        return f3561h;
    }

    private static void d(ExecutorService executorService) {
        if (executorService != null) {
            p = executorService;
        }
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            r = executorService;
        }
    }

    private static void g(ExecutorService executorService) {
        if (executorService != null) {
            s = executorService;
        }
    }

    public static synchronized void b() {
        if (D) {
            return;
        }
        D = true;
        try {
            Intent intent = new Intent(N(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            N().startService(intent);
            if (!com.ss.android.socialbase.downloader.i.f.c()) {
                com.ss.android.socialbase.downloader.impls.l.a(true).startService();
            }
        } catch (Throwable th) {
            D = false;
            th.printStackTrace();
        }
    }

    private static void e(ExecutorService executorService) {
        if (executorService != null) {
            q = executorService;
        }
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            t = executorService;
        }
    }

    public static void b(com.ss.android.socialbase.downloader.depend.k kVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = R;
        synchronized (list) {
            if (kVar != null) {
                if (list.contains(kVar)) {
                    list.remove(kVar);
                }
            }
        }
    }

    public static void b(DownloadTask downloadTask, int i2) {
        List<ab> list = S;
        synchronized (list) {
            for (ab abVar : list) {
                if (abVar != null) {
                    abVar.b(downloadTask, i2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.ss.android.socialbase.downloader.network.g b(java.lang.String r11, java.util.List<com.ss.android.socialbase.downloader.model.c> r12, int r13, boolean r14, com.ss.android.socialbase.downloader.model.DownloadInfo r15) throws java.lang.Throwable {
        /*
            r0 = 1
            if (r13 != r0) goto L8
            com.ss.android.socialbase.downloader.network.h r0 = f()
            goto Lc
        L8:
            com.ss.android.socialbase.downloader.network.h r0 = i()
        Lc:
            if (r0 == 0) goto L49
            r1 = 0
            r9 = 0
            r2 = 0
            if (r14 == 0) goto L18
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
        L18:
            com.ss.android.socialbase.downloader.network.g r12 = r0.a(r11, r12)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
            if (r14 == 0) goto L2e
            r4 = 0
            long r0 = java.lang.System.currentTimeMillis()
            long r5 = r0 - r2
            java.lang.String r7 = "head"
            r2 = r12
            r3 = r11
            r8 = r13
            r10 = r15
            com.ss.android.socialbase.downloader.d.a.a(r2, r3, r4, r5, r7, r8, r9, r10)
        L2e:
            return r12
        L2f:
            r12 = move-exception
            r8 = r9
            goto L37
        L32:
            r12 = move-exception
            throw r12     // Catch: java.lang.Throwable -> L34
        L34:
            r0 = move-exception
            r8 = r12
            r12 = r0
        L37:
            if (r14 == 0) goto L48
            r14 = 0
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            java.lang.String r6 = "head"
            r2 = r11
            r3 = r14
            r7 = r13
            r9 = r15
            com.ss.android.socialbase.downloader.d.a.a(r1, r2, r3, r4, r6, r7, r8, r9)
        L48:
            throw r12
        L49:
            com.ss.android.socialbase.downloader.exception.BaseException r11 = new com.ss.android.socialbase.downloader.exception.BaseException
            r12 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r14 = new java.io.IOException
            java.lang.String r15 = "httpService not exist, netLib = "
            java.lang.String r13 = c.a.a.a.a.G(r15, r13)
            r14.<init>(r13)
            r11.<init>(r12, r14)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.c.b(java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.g");
    }

    public static void b(ExecutorService executorService) {
        if (executorService != null) {
            v = executorService;
        }
    }

    public static void b(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            m().execute(runnable);
        }
    }

    public static synchronized void a() {
        try {
            if (J && x != null && a != null) {
                a.unregisterReceiver(x);
                J = false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            r().execute(runnable);
        }
    }

    private static void b(int i2) {
        if (i2 > 0) {
            K = i2;
        }
    }

    public static void a(ak akVar) {
        if (akVar == null) {
            return;
        }
        synchronized (C) {
            C.add(akVar);
        }
    }

    private static void b(boolean z2) {
        U = z2;
    }

    public static void a(com.ss.android.socialbase.downloader.depend.k kVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = R;
        synchronized (list) {
            if (kVar != null) {
                if (!list.contains(kVar)) {
                    list.add(kVar);
                }
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.constants.d dVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = R;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.k kVar : list) {
                if (kVar != null) {
                    if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_START) {
                        kVar.a();
                    } else if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                        kVar.b();
                    }
                }
            }
            if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                R.clear();
            }
        }
    }

    public static void a(DownloadTask downloadTask, int i2) {
        List<ab> list = S;
        synchronized (list) {
            for (ab abVar : list) {
                if (abVar != null) {
                    abVar.a(downloadTask, i2);
                }
            }
        }
    }

    public static synchronized boolean c() {
        return D;
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            o = executorService;
        }
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        return a(z2, i2, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z3, DownloadInfo downloadInfo) throws Exception {
        List<com.ss.android.socialbase.downloader.model.c> list2;
        int i4;
        com.ss.android.socialbase.downloader.network.i iVarA;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.model.c> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i4 = 1;
        } else if (z2) {
            list2 = list;
            i4 = i3;
        } else {
            i4 = 2;
            list2 = list;
        }
        int[] iArrA = a(i4);
        Exception exc = null;
        for (int i5 : iArrA) {
            try {
                iVarA = a(i2, str, str2, list2, i5, z3, downloadInfo);
            } catch (Exception e2) {
                if (downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.i.f.g(e2) && com.ss.android.socialbase.downloader.i.f.c(list2)) {
                    com.ss.android.socialbase.downloader.c.a.a("dcach::http exception 304, throw excepiton, not retry " + e2);
                    throw e2;
                }
                exc = e2;
            }
            if (iVarA != null) {
                return iVarA;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.ss.android.socialbase.downloader.network.i a(int r11, java.lang.String r12, java.lang.String r13, java.util.List<com.ss.android.socialbase.downloader.model.c> r14, int r15, boolean r16, com.ss.android.socialbase.downloader.model.DownloadInfo r17) throws java.lang.Throwable {
        /*
            r7 = r15
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = d()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = h()
        Ld:
            if (r0 == 0) goto L56
            r1 = 0
            r8 = 0
            r2 = 0
            if (r16 == 0) goto L21
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1d
            goto L21
        L1a:
            r0 = move-exception
            r5 = r12
            goto L43
        L1d:
            r0 = move-exception
            r5 = r12
        L1f:
            r4 = r0
            goto L40
        L21:
            r4 = r11
            r5 = r12
            r6 = r14
            com.ss.android.socialbase.downloader.network.i r0 = r0.downloadWithConnection(r11, r12, r14)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            if (r16 == 0) goto L3b
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r2
            java.lang.String r6 = "get"
            r1 = r0
            r2 = r12
            r3 = r13
            r4 = r9
            r7 = r15
            r9 = r17
            com.ss.android.socialbase.downloader.d.a.a(r1, r2, r3, r4, r6, r7, r8, r9)
        L3b:
            return r0
        L3c:
            r0 = move-exception
            goto L43
        L3e:
            r0 = move-exception
            goto L1f
        L40:
            throw r4     // Catch: java.lang.Throwable -> L41
        L41:
            r0 = move-exception
            r8 = r4
        L43:
            if (r16 == 0) goto L55
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r2
            java.lang.String r6 = "get"
            r2 = r12
            r3 = r13
            r4 = r9
            r7 = r15
            r9 = r17
            com.ss.android.socialbase.downloader.d.a.a(r1, r2, r3, r4, r6, r7, r8, r9)
        L55:
            throw r0
        L56:
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "httpService not exist, netLib = "
            java.lang.String r3 = c.a.a.a.a.G(r3, r15)
            r2.<init>(r3)
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.c.a(int, java.lang.String, java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.i");
    }

    public static com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        return a(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        com.ss.android.socialbase.downloader.network.g gVarB;
        Exception e2 = null;
        for (int i3 : a(i2)) {
            try {
                gVarB = b(str, list, i3, z2, downloadInfo);
            } catch (Exception e3) {
                e2 = e3;
            }
            if (gVarB != null) {
                return gVarB;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    private static int[] a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    public static synchronized void a(l lVar) {
        if (lVar != null) {
            n = lVar;
            if (f3555b instanceof com.ss.android.socialbase.downloader.impls.d) {
                ((com.ss.android.socialbase.downloader.impls.d) f3555b).h();
            }
        }
    }

    public static void a(ExecutorService executorService) {
        if (executorService != null) {
            u = executorService;
        }
    }

    private static void a(List<com.ss.android.socialbase.downloader.depend.m> list) {
        List<com.ss.android.socialbase.downloader.depend.m> list2 = I;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void a(boolean z2) {
        V = z2;
    }

    public static void a(Runnable runnable) {
        b(runnable, false);
    }

    public static void a(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            l().execute(runnable);
        }
    }

    public static void a(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            f3563j = iDownloadHttpService;
        }
        Q = f3563j != null;
    }

    public static void a(com.ss.android.socialbase.downloader.network.h hVar) {
        if (hVar != null) {
            f3564k = hVar;
        }
    }

    private static void a(j jVar) {
        if (jVar != null) {
            f3555b = jVar;
        }
    }

    private static void a(k kVar) {
        if (kVar != null) {
            f3556c = kVar;
        }
    }

    private static void a(com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            A = bVar;
        }
    }

    public static void a(aa aaVar) {
        B = aaVar;
        com.ss.android.socialbase.downloader.g.a.a();
    }

    private static void a(h hVar) {
        if (hVar != null) {
            f3557d = hVar;
        }
    }

    public static void a(af afVar) {
        if (afVar != null) {
            f3558e = afVar;
        }
    }

    private static void a(g gVar) {
        if (gVar != null) {
            w = gVar;
        }
    }

    public static synchronized void a(Context context) {
        if (context != null) {
            if (a == null) {
                a = context.getApplicationContext();
                com.ss.android.socialbase.downloader.a.a.a().a(a);
            }
        }
    }

    public static int a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        return a(downloadInfo.getUrl(), downloadInfo.getSavePath());
    }

    public static int a(String str, String str2) {
        k kVarB = B();
        if (kVarB == null) {
            return 0;
        }
        return kVarB.a(str, str2);
    }

    public static void a(com.ss.android.socialbase.downloader.d.c cVar) {
        X = cVar;
    }

    public static void a(a aVar) {
        com.ss.android.socialbase.downloader.c.a.a("wjd", "setIndependentServiceCreator::creator=" + aVar);
        f3562i = aVar;
    }
}
