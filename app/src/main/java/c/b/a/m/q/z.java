package c.b.a.m.q;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: ResourceRecycler.java */
/* JADX INFO: loaded from: classes.dex */
public class z {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f496b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: compiled from: ResourceRecycler.java */
    public static final class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((w) message.obj).recycle();
            return true;
        }
    }

    public synchronized void a(w<?> wVar, boolean z) {
        if (this.a || z) {
            this.f496b.obtainMessage(1, wVar).sendToTarget();
        } else {
            this.a = true;
            wVar.recycle();
            this.a = false;
        }
    }
}
