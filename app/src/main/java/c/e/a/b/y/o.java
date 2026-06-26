package c.e.a.b.y;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes.dex */
public class o {
    public static o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Object f1287b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Handler f1288c = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public c f1289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public c f1290e;

    /* JADX INFO: compiled from: SnackbarManager.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            o oVar = o.this;
            c cVar = (c) message.obj;
            synchronized (oVar.f1287b) {
                if (oVar.f1289d == cVar || oVar.f1290e == cVar) {
                    oVar.a(cVar, 2);
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SnackbarManager.java */
    public interface b {
        void a(int i2);

        void show();
    }

    /* JADX INFO: compiled from: SnackbarManager.java */
    public static class c {

        @NonNull
        public final WeakReference<b> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1292c;

        public c(int i2, b bVar) {
            this.a = new WeakReference<>(bVar);
            this.f1291b = i2;
        }
    }

    public static o b() {
        if (a == null) {
            a = new o();
        }
        return a;
    }

    public final boolean a(@NonNull c cVar, int i2) {
        b bVar = cVar.a.get();
        if (bVar == null) {
            return false;
        }
        this.f1288c.removeCallbacksAndMessages(cVar);
        bVar.a(i2);
        return true;
    }

    public final boolean c(b bVar) {
        c cVar = this.f1289d;
        if (cVar != null) {
            return bVar != null && cVar.a.get() == bVar;
        }
        return false;
    }

    public final boolean d(b bVar) {
        c cVar = this.f1290e;
        if (cVar != null) {
            return bVar != null && cVar.a.get() == bVar;
        }
        return false;
    }

    public void e(b bVar) {
        synchronized (this.f1287b) {
            if (c(bVar)) {
                c cVar = this.f1289d;
                if (!cVar.f1292c) {
                    cVar.f1292c = true;
                    this.f1288c.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f1287b) {
            if (c(bVar)) {
                c cVar = this.f1289d;
                if (cVar.f1292c) {
                    cVar.f1292c = false;
                    g(cVar);
                }
            }
        }
    }

    public final void g(@NonNull c cVar) {
        int i2 = cVar.f1291b;
        if (i2 == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? TTAdConstant.STYLE_SIZE_RADIO_3_2 : 2750;
        }
        this.f1288c.removeCallbacksAndMessages(cVar);
        Handler handler = this.f1288c;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i2);
    }

    public final void h() {
        c cVar = this.f1290e;
        if (cVar != null) {
            this.f1289d = cVar;
            this.f1290e = null;
            b bVar = cVar.a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.f1289d = null;
            }
        }
    }
}
