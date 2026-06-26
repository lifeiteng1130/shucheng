package c.c.a;

import com.android.server.SystemConfig;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Runnable {
    public p(q qVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            SystemConfig.getInstance();
        } catch (Throwable unused) {
        }
    }
}
