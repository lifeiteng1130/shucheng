package g.b;

import f.z.f;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface f1 extends f.a {

    @NotNull
    public static final a N = a.a;

    /* JADX INFO: compiled from: Job.kt */
    public static final class a implements f.b<f1> {
        public static final /* synthetic */ a a = new a();

        static {
            int i2 = CoroutineExceptionHandler.M;
        }
    }

    @InternalCoroutinesApi
    @NotNull
    m0 c(boolean z, boolean z2, @NotNull f.c0.b.l<? super Throwable, f.v> lVar);

    @InternalCoroutinesApi
    @NotNull
    CancellationException d();

    boolean isActive();

    void k(@Nullable CancellationException cancellationException);

    @InternalCoroutinesApi
    @NotNull
    l m(@NotNull n nVar);

    boolean start();
}
