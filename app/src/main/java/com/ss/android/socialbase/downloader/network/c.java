package com.ss.android.socialbase.downloader.network;

import android.net.Uri;
import android.os.Handler;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: compiled from: DownloadDnsManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private final com.ss.android.socialbase.downloader.i.h<String, b> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f3891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f3892c;

    /* JADX INFO: compiled from: DownloadDnsManager.java */
    public interface a {
        void a(String str, List<InetAddress> list);
    }

    /* JADX INFO: compiled from: DownloadDnsManager.java */
    public static class b {
        public List<InetAddress> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f3899b;

        private b() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadDnsManager.java */
    public static class C0119c {
        private static final c a = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final a aVar, long j2) {
        final b bVar;
        f fVarU;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.a) {
                bVar = this.a.get(host);
            }
            if (bVar != null) {
                if (System.currentTimeMillis() - bVar.f3899b < com.ss.android.socialbase.downloader.g.a.c().a("dns_expire_min", 10) * 60 * 1000) {
                    if (aVar != null) {
                        aVar.a(str, bVar.a);
                        return;
                    }
                    return;
                }
            }
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.network.c.2
                @Override // java.lang.Runnable
                public void run() {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        String str2 = str;
                        b bVar2 = bVar;
                        aVar2.a(str2, bVar2 == null ? null : bVar2.a);
                    }
                }
            };
            this.f3892c.postDelayed(runnable, j2);
            List<InetAddress> listA = null;
            if (com.ss.android.socialbase.downloader.g.a.c().a("use_host_dns", 1) == 1 && (fVarU = com.ss.android.socialbase.downloader.downloader.c.u()) != null) {
                try {
                    listA = fVarU.a(host);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (listA == null || listA.isEmpty()) {
                try {
                    listA = com.ss.android.socialbase.downloader.downloader.c.v().a(host);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (listA != null && !listA.isEmpty()) {
                a(host, listA);
            } else if (bVar != null) {
                listA = bVar.a;
            }
            this.f3892c.removeCallbacks(runnable);
            if (aVar != null) {
                aVar.a(str, listA);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    private c() {
        this.a = new com.ss.android.socialbase.downloader.i.h<>(4, 16, false);
        this.f3891b = new Handler(com.ss.android.socialbase.downloader.network.a.b.a());
        this.f3892c = new Handler(com.ss.android.socialbase.downloader.h.e.a());
    }

    public static c a() {
        return C0119c.a;
    }

    public void a(final String str, final a aVar, final long j2) {
        this.f3891b.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(str, aVar, j2);
            }
        });
    }

    private void a(String str, List<InetAddress> list) {
        synchronized (this.a) {
            b bVar = this.a.get(str);
            if (bVar == null) {
                bVar = new b();
                this.a.put(str, bVar);
            }
            bVar.a = list;
            bVar.f3899b = System.currentTimeMillis();
        }
    }
}
