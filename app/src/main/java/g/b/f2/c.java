package g.b.f2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import c.b.a.m.f;
import f.h;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static volatile Choreographer choreographer;

    static {
        Object objM11constructorimpl;
        try {
            objM11constructorimpl = h.m11constructorimpl(new a(a(Looper.getMainLooper(), true), null, false));
        } catch (Throwable th) {
            objM11constructorimpl = h.m11constructorimpl(f.m1(th));
        }
    }

    @VisibleForTesting
    @NotNull
    public static final Handler a(@NotNull Looper looper, boolean z) throws IllegalAccessException, InvocationTargetException {
        if (!z) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}
