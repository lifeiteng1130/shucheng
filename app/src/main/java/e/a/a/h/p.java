package e.a.a.h;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HandlerUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    @JvmField
    @NotNull
    public static final Looper a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final Thread f5959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final Handler f5960c;

    static {
        Handler handler;
        String str;
        Looper mainLooper = Looper.getMainLooper();
        f.c0.c.j.c(mainLooper);
        a = mainLooper;
        Thread thread = mainLooper.getThread();
        f.c0.c.j.d(thread, "mainLooper.thread");
        f5959b = thread;
        if (Build.VERSION.SDK_INT >= 28) {
            handler = Handler.createAsync(mainLooper);
            str = "createAsync(mainLooper)";
        } else {
            try {
                handler = (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(mainLooper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                handler = new Handler(a);
            }
            str = "try {\n    Handler::class.java.getDeclaredConstructor(\n        Looper::class.java,\n        Handler.Callback::class.java,\n        Boolean::class.javaPrimitiveType // async\n    ).newInstance(mainLooper, null, true)\n} catch (ignored: NoSuchMethodException) {\n    Handler(mainLooper) // Hidden constructor absent. Fall back to non-async constructor.\n}";
        }
        f.c0.c.j.d(handler, str);
        f5960c = handler;
    }

    public static final void a(@NotNull final f.c0.b.a<f.v> aVar) {
        f.c0.c.j.e(aVar, "function");
        if (f5959b == Thread.currentThread()) {
            aVar.invoke();
        } else {
            f5960c.post(new Runnable() { // from class: e.a.a.h.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.c0.b.a aVar2 = aVar;
                    f.c0.c.j.e(aVar2, "$tmp0");
                    aVar2.invoke();
                }
            });
        }
    }
}
