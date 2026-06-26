package com.uc.crashsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static final /* synthetic */ boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile HandlerThread f4517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile HandlerThread f4518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile HandlerThread f4519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Handler f4520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Handler f4521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Handler f4522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Handler f4523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HashMap<Object, Object[]> f4524i = new HashMap<>();

    public static Handler a(int i2) {
        if (i2 == 0) {
            if (f4517b == null) {
                a();
            }
            return f4520e;
        }
        if (i2 == 1) {
            if (f4518c == null) {
                b();
            }
            return f4521f;
        }
        if (i2 == 2) {
            if (f4522g == null) {
                f4522g = new Handler(Looper.getMainLooper());
            }
            return f4522g;
        }
        if (i2 == 3) {
            if (f4523h == null) {
                c();
            }
            return f4523h;
        }
        throw new RuntimeException("unknown thread type: " + i2);
    }

    public static boolean b(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return false;
        }
        HashMap<Object, Object[]> map = f4524i;
        synchronized (map) {
            objArr = map.get(runnable);
        }
        return objArr != null;
    }

    private static synchronized void c() {
        if (f4519d == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKAnrHandler", 0);
            f4519d = handlerThread;
            handlerThread.start();
            f4523h = new Handler(f4519d.getLooper());
        }
    }

    private static synchronized void b() {
        if (f4518c == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKNormalHandler", 0);
            f4518c = handlerThread;
            handlerThread.start();
            f4521f = new Handler(f4518c.getLooper());
        }
    }

    public static boolean a(int i2, Runnable runnable, long j2) {
        Handler handlerA;
        if (runnable == null || (handlerA = a(i2)) == null) {
            return false;
        }
        e eVar = new e(10, new Object[]{runnable});
        HashMap<Object, Object[]> map = f4524i;
        synchronized (map) {
            map.put(runnable, new Object[]{eVar, Integer.valueOf(i2)});
        }
        return handlerA.postDelayed(eVar, j2);
    }

    public static void a(int i2, Object[] objArr) {
        if (i2 != 10) {
            if (!a) {
                throw new AssertionError();
            }
        } else {
            if (!a && objArr == null) {
                throw new AssertionError();
            }
            Runnable runnable = (Runnable) objArr[0];
            HashMap<Object, Object[]> map = f4524i;
            synchronized (map) {
                if (map.get(runnable) != null) {
                    map.remove(runnable);
                }
            }
            runnable.run();
        }
    }

    public static boolean a(int i2, Runnable runnable) {
        return a(i2, runnable, 0L);
    }

    public static void a(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return;
        }
        HashMap<Object, Object[]> map = f4524i;
        synchronized (map) {
            objArr = map.get(runnable);
        }
        if (objArr == null) {
            return;
        }
        int iIntValue = ((Integer) objArr[1]).intValue();
        Handler handler = null;
        if (iIntValue == 0) {
            handler = f4520e;
        } else if (iIntValue == 1) {
            handler = f4521f;
        } else if (iIntValue == 2) {
            handler = f4522g;
        }
        if (handler != null) {
            handler.removeCallbacks((Runnable) objArr[0]);
        }
        synchronized (map) {
            if (map.get(runnable) != null) {
                map.remove(runnable);
            }
        }
    }

    private static synchronized void a() {
        if (f4517b == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKBkgdHandler", 10);
            f4517b = handlerThread;
            handlerThread.start();
            f4520e = new Handler(f4517b.getLooper());
        }
    }
}
