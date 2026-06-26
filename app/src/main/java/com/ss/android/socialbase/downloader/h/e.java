package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: DownloadWatchDog.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Handler.Callback {
    private volatile Handler a = new Handler(a.a, this);

    /* JADX INFO: compiled from: DownloadWatchDog.java */
    public static class a {
        private static final Looper a;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            a = handlerThread.getLooper();
        }
    }

    /* JADX INFO: compiled from: DownloadWatchDog.java */
    public interface b {
        long a();
    }

    public static Looper a() {
        return a.a;
    }

    public void b() {
        Handler handler = this.a;
        if (handler == null) {
            return;
        }
        this.a = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            b bVar = (b) message.obj;
            long jA = bVar.a();
            if (jA <= 0) {
                return true;
            }
            a(bVar, jA);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public void a(b bVar, long j2) {
        Handler handler = this.a;
        if (handler == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = bVar;
        handler.sendMessageDelayed(messageObtain, j2);
    }
}
