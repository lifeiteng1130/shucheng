package com.ss.android.socialbase.downloader.network.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DownloadPreconnecter.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f3865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HandlerThread f3866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Handler f3867d;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        f3866c = handlerThread;
        b();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        f3867d = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static void b() {
        a = com.ss.android.socialbase.downloader.g.a.c().a("preconnect_connection_outdate_time", 300000L);
        f3865b = com.ss.android.socialbase.downloader.g.a.c().a("preconnect_head_info_outdate_time", 300000L);
        a.a().a(com.ss.android.socialbase.downloader.g.a.c().a("preconnect_max_cache_size", 3));
    }

    public static Looper a() {
        return f3866c.getLooper();
    }

    public static void a(final String str, final j jVar) {
        f3867d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.a.b.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (TextUtils.isEmpty(str)) {
                    j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.a(null);
                        return;
                    }
                    return;
                }
                try {
                    try {
                        List<com.ss.android.socialbase.downloader.model.c> listB = b.b(0L, null, null);
                        cVarA = a.a().a(str) ? a.a().a(str, listB) : null;
                        if (cVarA == null) {
                            c cVar = new c(str, listB, 0L);
                            try {
                                cVar.a();
                                if (cVar.e()) {
                                    a.a().a(str, cVar);
                                }
                                cVarA = cVar;
                            } catch (Exception e2) {
                                e = e2;
                                cVarA = cVar;
                                e.printStackTrace();
                            } catch (Throwable th) {
                                th = th;
                                cVarA = cVar;
                                try {
                                    cVarA.c();
                                } catch (Throwable unused) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> mapI = cVarA.i();
                        j jVar3 = jVar;
                        if (jVar3 != null) {
                            jVar3.a(mapI);
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                    try {
                        cVarA.c();
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.ss.android.socialbase.downloader.model.c> b(long j2, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.c> list) {
        return f.a(list, downloadInfo == null ? null : downloadInfo.geteTag(), j2, 0L);
    }
}
