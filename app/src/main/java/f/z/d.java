package f.z;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Continuation.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
public interface d<T> {
    @NotNull
    f getContext();

    void resumeWith(@NotNull Object obj);
}
