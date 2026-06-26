package f;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExceptionsH.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.4")
@PublishedApi
public final class c extends RuntimeException {
    public c() {
    }

    public c(@Nullable String str) {
        super(str);
    }

    public c(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public c(@Nullable Throwable th) {
        super(th);
    }
}
