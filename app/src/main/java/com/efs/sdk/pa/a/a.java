package com.efs.sdk.pa.a;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.efs.sdk.pa.PAANRListener;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public volatile boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f1873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Thread f1874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f1878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PAANRListener f1879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f1880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f1881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f1882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1883l;
    public final Runnable m;
    public final Runnable n;
    private HandlerThread o;
    private Application p;

    public a(Application application, long j2) {
        this(application, j2, true);
    }

    public static boolean a(StringBuilder sb) {
        Set<Map.Entry<Thread, StackTraceElement[]>> setEntrySet = Thread.getAllStackTraces().entrySet();
        if (setEntrySet.size() == 0) {
            return false;
        }
        boolean z = false;
        for (Map.Entry<Thread, StackTraceElement[]> entry : setEntrySet) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            if (key.getId() == Looper.getMainLooper().getThread().getId()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(key.getName());
                sb2.append(" ");
                sb2.append(key.getPriority());
                sb2.append(" ");
                sb2.append(key.getState());
                sb2.append("\n");
                for (StackTraceElement stackTraceElement : value) {
                    String string = stackTraceElement.toString();
                    sb2.append("  at  ");
                    sb2.append(string);
                    sb2.append('\n');
                }
                sb2.append("\n");
                sb.insert(0, (CharSequence) sb2);
                z = true;
            } else {
                sb.append(key.getName());
                sb.append(" ");
                sb.append(key.getPriority());
                sb.append(" ");
                sb.append(key.getState());
                sb.append("\n");
                for (StackTraceElement stackTraceElement2 : value) {
                    String string2 = stackTraceElement2.toString();
                    sb.append("  at  ");
                    sb.append(string2);
                    sb.append('\n');
                }
                sb.append("\n");
            }
        }
        if (!z) {
            sb.insert(0, a(Looper.getMainLooper().getThread()));
        }
        return true;
    }

    public a(Application application, long j2, boolean z) {
        this.a = true;
        this.f1876e = 4L;
        this.f1877f = true;
        this.f1880i = 0L;
        this.m = new Runnable() { // from class: com.efs.sdk.pa.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                PAANRListener pAANRListener;
                if (a.this.f1877f) {
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                a aVar = a.this;
                long j3 = jUptimeMillis - aVar.f1881j;
                if (j3 > aVar.f1882k && (pAANRListener = aVar.f1879h) != null) {
                    pAANRListener.unexcept(Long.valueOf(j3));
                }
                if (a.this.a) {
                    a aVar2 = a.this;
                    aVar2.f1880i = 0L;
                    aVar2.a = false;
                    a aVar3 = a.this;
                    aVar3.f1873b.postAtFrontOfQueue(aVar3.n);
                } else {
                    a aVar4 = a.this;
                    aVar4.f1880i++;
                    if (!aVar4.a) {
                        a aVar5 = a.this;
                        long j4 = aVar5.f1880i;
                        long j5 = aVar5.f1876e;
                        if (j4 >= j5 && j4 == j5) {
                            StringBuilder sb = new StringBuilder();
                            if (aVar5.f1883l) {
                                sb.append(a.a(aVar5.f1874c));
                            } else if (a.a(sb)) {
                            }
                            if (aVar5.f1879h != null && sb.length() > 0) {
                                aVar5.f1879h.anrStack(sb.toString());
                            }
                        }
                    }
                }
                a.this.f1881j = SystemClock.uptimeMillis();
                a aVar6 = a.this;
                aVar6.f1878g.postDelayed(aVar6.m, aVar6.f1875d);
            }
        };
        this.n = new Runnable() { // from class: com.efs.sdk.pa.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a = true;
            }
        };
        this.f1882k = j2;
        this.p = application;
        this.f1883l = z;
        long j3 = ((long) (j2 * 0.8f)) / this.f1876e;
        this.f1875d = j3;
        if (j3 < 100) {
            this.f1875d = 100L;
            this.f1876e = j2 / 100;
        }
        this.f1874c = Looper.getMainLooper().getThread();
        this.f1873b = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("ANR HANDLER THREAD");
        this.o = handlerThread;
        handlerThread.start();
        this.f1878g = new Handler(this.o.getLooper());
    }

    public static String a(Thread thread) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        sb.append(thread.getName());
        sb.append(" ");
        sb.append(thread.getPriority());
        sb.append(" ");
        sb.append(thread.getState());
        sb.append("\n");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String string = stackTraceElement.toString();
            sb.append("  at  ");
            sb.append(string);
            sb.append('\n');
        }
        sb.append("\n");
        return sb.toString();
    }
}
