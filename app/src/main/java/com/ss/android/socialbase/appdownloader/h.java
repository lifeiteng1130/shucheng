package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: InstallQueue.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private final Queue<Integer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SoftReference<JumpUnknownSourceActivity> f3410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f3411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f3412g;

    /* JADX INFO: compiled from: InstallQueue.java */
    public static class a {
        private static final h a = new h();
    }

    private h() {
        this.a = new ArrayDeque();
        this.f3407b = false;
        this.f3411f = new Handler(Looper.getMainLooper());
        this.f3412g = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
            }
        };
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC0092a() { // from class: com.ss.android.socialbase.appdownloader.h.2
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
            public void b() {
                if (h.this.a.isEmpty()) {
                    return;
                }
                long jA = com.ss.android.socialbase.downloader.g.a.c().a("install_on_resume_install_interval", 120000L);
                long jCurrentTimeMillis = System.currentTimeMillis() - h.this.f3409d;
                if (jCurrentTimeMillis < jA) {
                    if (h.this.f3411f.hasCallbacks(h.this.f3412g)) {
                        return;
                    }
                    h.this.f3411f.postDelayed(h.this.f3412g, jA - jCurrentTimeMillis);
                } else {
                    h.this.f3409d = System.currentTimeMillis();
                    h.this.c();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
            public void c() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Context context, int i2, boolean z) {
        int iB = c.b(context, i2, z);
        if (iB == 1) {
            this.f3407b = true;
        }
        this.f3408c = System.currentTimeMillis();
        return iB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        final Integer numPoll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.a.a.a().b()) {
            synchronized (this.a) {
                numPoll = this.a.poll();
            }
            this.f3411f.removeCallbacks(this.f3412g);
            if (numPoll == null) {
                this.f3407b = false;
                return;
            }
            final Context contextN = com.ss.android.socialbase.downloader.downloader.c.N();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f3411f.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.b(contextN, numPoll.intValue(), false);
                    }
                });
            } else {
                b(contextN, numPoll.intValue(), false);
            }
            this.f3411f.postDelayed(this.f3412g, 20000L);
        }
    }

    private boolean d() {
        return System.currentTimeMillis() - this.f3408c < 1000;
    }

    public void a(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        c();
    }

    public JumpUnknownSourceActivity b() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f3410e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f3410e = null;
        return jumpUnknownSourceActivity;
    }

    public static h a() {
        return a.a;
    }

    public int a(final Context context, final int i2, final boolean z) {
        if (z) {
            return b(context, i2, z);
        }
        if (d()) {
            this.f3411f.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.4
                @Override // java.lang.Runnable
                public void run() {
                    h.this.a(context, i2, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.ss.android.socialbase.downloader.a.a.a().b()) {
            com.ss.android.socialbase.downloader.c.a.c("leaves", "on Foreground");
            return b(context, i2, z);
        }
        if (b.a()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.a.isEmpty() && !this.f3407b && z2) {
            return b(context, i2, z);
        }
        int iA = com.ss.android.socialbase.downloader.g.a.c().a("install_queue_size", 3);
        synchronized (this.a) {
            while (this.a.size() > iA) {
                this.a.poll();
            }
        }
        if (z2) {
            this.f3411f.removeCallbacks(this.f3412g);
            this.f3411f.postDelayed(this.f3412g, com.ss.android.socialbase.downloader.g.a.a(i2).a("install_queue_timeout", 20000L));
        }
        synchronized (this.a) {
            if (!this.a.contains(Integer.valueOf(i2))) {
                this.a.offer(Integer.valueOf(i2));
            }
        }
        return 1;
    }

    public void a(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f3410e = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
