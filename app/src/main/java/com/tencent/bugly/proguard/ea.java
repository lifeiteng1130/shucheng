package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.camera.core.FocusMeteringAction;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class ea extends Thread {
    private boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4366b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<da> f4367c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<fa> f4368d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<da> f4369e = new ArrayList<>();

    private int e() {
        int iMax = 0;
        for (int i2 = 0; i2 < this.f4367c.size(); i2++) {
            try {
                iMax = Math.max(iMax, this.f4367c.get(i2).a());
            } catch (Exception e2) {
                X.a(e2);
            }
        }
        return iMax;
    }

    public void a() {
        a(new Handler(Looper.getMainLooper()));
    }

    public void b() {
        for (int i2 = 0; i2 < this.f4367c.size(); i2++) {
            try {
                if (this.f4367c.get(i2).c().equals(Looper.getMainLooper().getThread().getName())) {
                    X.a("remove handler::%s", this.f4367c.get(i2));
                    this.f4367c.remove(i2);
                }
            } catch (Exception e2) {
                X.a(e2);
                return;
            }
        }
    }

    public boolean c() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            X.a(e2);
            return false;
        }
    }

    public boolean d() {
        this.a = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e2) {
            X.a(e2);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.a) {
            for (int i2 = 0; i2 < this.f4367c.size(); i2++) {
                try {
                    this.f4367c.get(i2).f();
                } catch (Exception e2) {
                    X.a(e2);
                } catch (OutOfMemoryError e3) {
                    X.a(e3);
                }
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            for (long jUptimeMillis2 = 2000; jUptimeMillis2 > 0 && !isInterrupted(); jUptimeMillis2 = 2000 - (SystemClock.uptimeMillis() - jUptimeMillis)) {
                Thread.sleep(jUptimeMillis2);
            }
            int iE = e();
            if (iE != 0 && iE != 1) {
                this.f4369e.clear();
                for (int i3 = 0; i3 < this.f4367c.size(); i3++) {
                    da daVar = this.f4367c.get(i3);
                    if (daVar.d()) {
                        this.f4369e.add(daVar);
                        daVar.a(RecyclerView.FOREVER_NS);
                    }
                }
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler == null || !nativeCrashHandler.isEnableCatchAnrTrace()) {
                    X.a("do not enable jni mannual dump anr trace", new Object[0]);
                } else {
                    nativeCrashHandler.dumpAnrNativeStack();
                    X.a("jni mannual dump anr trace", new Object[0]);
                }
                int i4 = 0;
                while (true) {
                    if (this.f4366b) {
                        break;
                    }
                    X.a("do not enable anr continue check", new Object[0]);
                    Thread.sleep(2000L);
                    i4++;
                    if (i4 == 15) {
                        this.f4369e.clear();
                        break;
                    }
                }
                for (int i5 = 0; i5 < this.f4369e.size(); i5++) {
                    da daVar2 = this.f4369e.get(i5);
                    for (int i6 = 0; i6 < this.f4368d.size(); i6++) {
                        X.b("main thread blocked,now begin to upload anr stack", new Object[0]);
                        this.f4368d.get(i6).a(daVar2);
                        this.f4366b = false;
                    }
                }
            }
        }
    }

    public void a(Handler handler) {
        a(handler, FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION);
    }

    public void a(Handler handler, long j2) {
        if (handler == null) {
            X.b("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i2 = 0; i2 < this.f4367c.size(); i2++) {
            try {
                if (this.f4367c.get(i2).c().equals(handler.getLooper().getThread().getName())) {
                    X.b("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e2) {
                X.a(e2);
            }
            this.f4367c.add(new da(handler, name, j2));
        }
        this.f4367c.add(new da(handler, name, j2));
    }

    public void b(fa faVar) {
        this.f4368d.remove(faVar);
    }

    public void a(fa faVar) {
        if (this.f4368d.contains(faVar)) {
            X.a("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f4368d.add(faVar);
        }
    }

    public void a(boolean z) {
        this.f4366b = z;
    }
}
