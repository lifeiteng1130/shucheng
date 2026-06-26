package f;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UninitializedPropertyAccessException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends RuntimeException {
    public u() {
    }

    public u(@Nullable String str) {
        super(str);
    }

    public u(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public u(@Nullable Throwable th) {
        super(th);
    }
}
