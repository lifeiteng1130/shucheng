package g.b.h2;

import g.b.d0;
import g.b.v0;
import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@InternalCoroutinesApi
public class c extends v0 {
    public a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f6237e;

    public c(int i2, int i3, String str, int i4) {
        int i5 = (i4 & 1) != 0 ? l.f6245b : i2;
        int i6 = (i4 & 2) != 0 ? l.f6246c : i3;
        String str2 = (i4 & 4) != 0 ? "DefaultDispatcher" : null;
        long j2 = l.f6247d;
        this.f6234b = i5;
        this.f6235c = i6;
        this.f6236d = j2;
        this.f6237e = str2;
        this.a = new a(i5, i6, j2, str2);
    }

    @Override // g.b.y
    public void dispatch(@NotNull f.z.f fVar, @NotNull Runnable runnable) {
        try {
            a.e(this.a, runnable, null, false, 6);
        } catch (RejectedExecutionException unused) {
            d0.f6179h.v(runnable);
        }
    }

    @Override // g.b.y
    public void dispatchYield(@NotNull f.z.f fVar, @NotNull Runnable runnable) {
        try {
            a.e(this.a, runnable, null, true, 2);
        } catch (RejectedExecutionException unused) {
            d0.f6179h.dispatchYield(fVar, runnable);
        }
    }
}
