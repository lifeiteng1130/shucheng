package com.ss.android.socialbase.downloader.network;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: NetTrafficManager.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private static final String a = "k";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f3903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f3904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference<l> f3905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicReference<l> f3906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList<b> f3907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3908g;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.k$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetTrafficManager.java */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            l.values();
            int[] iArr = new int[5];
            a = iArr;
            try {
                iArr[l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: NetTrafficManager.java */
    public static class a {
        public static final k a = new k(null);
    }

    /* JADX INFO: compiled from: NetTrafficManager.java */
    public interface b {
        void a(l lVar);
    }

    public /* synthetic */ k(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static k a() {
        return a.a;
    }

    private boolean c() {
        if (this.f3903b == null) {
            return false;
        }
        try {
            int i2 = AnonymousClass1.a[this.f3905d.get().ordinal()];
            double d2 = 2000.0d;
            double d3 = 550.0d;
            if (i2 == 1) {
                d3 = 0.0d;
                d2 = 150.0d;
            } else if (i2 == 2) {
                d2 = 550.0d;
                d3 = 150.0d;
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d3 = 2000.0d;
            }
            double dA = this.f3903b.a();
            if (dA > d2) {
                if (dA > d2 * 1.25d) {
                    return true;
                }
            } else if (dA < d3 * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private void d() {
        try {
            int size = this.f3907f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f3907f.get(i2).a(this.f3905d.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized l b() {
        d dVar = this.f3903b;
        if (dVar == null) {
            return l.UNKNOWN;
        }
        try {
            return a(dVar.a());
        } catch (Throwable th) {
            th.printStackTrace();
            return l.UNKNOWN;
        }
    }

    private k() {
        this.f3903b = new d(0.05d);
        this.f3904c = false;
        this.f3905d = new AtomicReference<>(l.UNKNOWN);
        this.f3907f = new ArrayList<>();
    }

    public synchronized void a(long j2, long j3) {
        l lVarB;
        double d2 = ((j2 * 1.0d) / j3) * 8.0d;
        if (j3 == 0 || d2 < 3.0d) {
            return;
        }
        try {
            this.f3903b.a(d2);
            lVarB = b();
        } catch (Throwable unused) {
        }
        if (!this.f3904c) {
            if (this.f3905d.get() != lVarB) {
                this.f3904c = true;
                this.f3906e = new AtomicReference<>(lVarB);
            }
            return;
        }
        this.f3908g++;
        if (lVarB != this.f3906e.get()) {
            this.f3904c = false;
            this.f3908g = 1;
        }
        if (this.f3908g >= 5.0d && c()) {
            this.f3904c = false;
            this.f3908g = 1;
            this.f3905d.set(this.f3906e.get());
            d();
        }
    }

    private l a(double d2) {
        if (d2 < 0.0d) {
            return l.UNKNOWN;
        }
        if (d2 < 150.0d) {
            return l.POOR;
        }
        if (d2 < 550.0d) {
            return l.MODERATE;
        }
        if (d2 < 2000.0d) {
            return l.GOOD;
        }
        return l.EXCELLENT;
    }
}
