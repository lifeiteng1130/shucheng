package c.c.a.n;

import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.FocusMeteringAction;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static Class a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f775b;

    /* JADX INFO: renamed from: c.c.a.n.a$a, reason: collision with other inner class name */
    public static class RunnableC0034a implements Runnable {
        public final /* synthetic */ Object a;

        public RunnableC0034a(Object obj) {
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                try {
                    a.f775b = MethodUtils.invokeStaticMethod(a.a, "currentActivityThread", new Object[0]);
                    synchronized (this.a) {
                        this.a.notify();
                    }
                } catch (Exception e2) {
                    ZeusLogger.e(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e2);
                    synchronized (this.a) {
                        this.a.notify();
                    }
                }
            } catch (Throwable th) {
                synchronized (this.a) {
                    this.a.notify();
                    throw th;
                }
            }
        }
    }

    public static final Object a() {
        if (f775b == null) {
            try {
                synchronized (a.class) {
                    if (f775b == null) {
                        if (a == null) {
                            a = Class.forName("android.app.ActivityThread");
                        }
                        f775b = MethodUtils.invokeStaticMethod(a, "currentActivityThread", new Object[0]);
                    }
                    if (f775b == null && Looper.myLooper() != Looper.getMainLooper()) {
                        Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new RunnableC0034a(obj));
                        if (f775b == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION);
                                } catch (InterruptedException e2) {
                                    ZeusLogger.e(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e2);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                ZeusLogger.e(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e3);
            }
        }
        return f775b;
    }
}
