package f.z;

import f.z.f;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContinuationInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
public interface e extends f.a {
    public static final /* synthetic */ int L = 0;

    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    public static final class a implements f.b<e> {
        public static final /* synthetic */ a a = new a();
    }

    @NotNull
    <T> d<T> interceptContinuation(@NotNull d<? super T> dVar);

    void releaseInterceptedContinuation(@NotNull d<?> dVar);
}
