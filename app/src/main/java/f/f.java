package f;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoWhenBranchMatchedException.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f extends RuntimeException {
    public f() {
    }

    public f(@Nullable String str) {
        super(str);
    }

    public f(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public f(@Nullable Throwable th) {
        super(th);
    }
}
