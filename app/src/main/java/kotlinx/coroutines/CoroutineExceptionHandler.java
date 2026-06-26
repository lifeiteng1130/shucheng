package kotlinx.coroutines;

import f.z.f;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CoroutineExceptionHandler extends f.a {
    public static final /* synthetic */ int M = 0;

    /* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
    public static final class a implements f.b<CoroutineExceptionHandler> {
        public static final /* synthetic */ a a = new a();
    }

    void handleException(@NotNull f fVar, @NotNull Throwable th);
}
