package c.c.a.x;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile ExecutorService f811c;

    public static ExecutorService a() {
        if (f811c == null) {
            synchronized (d.class) {
                if (f811c == null) {
                    int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        ZeusLogger.e(ZeusLogger.TAG, "allowCoreThreadTimeOut failed ", th);
                    }
                    f811c = threadPoolExecutor;
                }
            }
        }
        return f811c;
    }

    public static Handler b() {
        Handler handler;
        synchronized (a) {
            if (f810b == null) {
                f810b = new Handler(Looper.getMainLooper());
            }
            handler = f810b;
        }
        return handler;
    }
}
