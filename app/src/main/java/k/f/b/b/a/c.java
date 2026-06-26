package k.f.b.b.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.os.EnvironmentCompat;
import com.qq.e.comm.pi.ACTD;
import com.umeng.commonsdk.statistics.SdkVersion;

/* JADX INFO: compiled from: IdentifierIdClient.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static Context a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8927b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f8928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object f8929d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static HandlerThread f8930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Handler f8931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f8932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f8933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile c f8934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile a f8935j;

    public static c a(Context context) {
        if (f8934i == null) {
            synchronized (c.class) {
                a = context.getApplicationContext();
                f8934i = new c();
            }
        }
        if (f8935j == null) {
            synchronized (c.class) {
                a = context.getApplicationContext();
                HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
                f8930e = handlerThread;
                handlerThread.start();
                f8931f = new b(f8930e.getLooper());
                f8935j = new a(a);
                c();
            }
        }
        return f8934i;
    }

    public static void c() {
        String str;
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "persist.sys.identifierid.supported", EnvironmentCompat.MEDIA_UNKNOWN);
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "0";
                f8927b = SdkVersion.MINI_VERSION.equals(str);
            }
        } catch (Throwable unused) {
            str = "0";
            f8927b = SdkVersion.MINI_VERSION.equals(str);
        }
        f8927b = SdkVersion.MINI_VERSION.equals(str);
    }

    public void b(int i2, String str) {
        synchronized (f8929d) {
            Message messageObtainMessage = f8931f.obtainMessage();
            messageObtainMessage.what = 11;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i2);
            if (i2 == 1 || i2 == 2) {
                bundle.putString(ACTD.APPID_KEY, str);
            }
            messageObtainMessage.setData(bundle);
            f8931f.sendMessage(messageObtainMessage);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                f8929d.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis < 2000) {
                if (i2 == 0) {
                    f8933h = f8932g;
                    f8932g = null;
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 4) {
                        }
                    } else if (f8932g != null) {
                        f8932g = null;
                    }
                    f8932g = null;
                } else if (f8932g != null) {
                    f8932g = null;
                }
            }
        }
    }
}
