package f.a0.d;

import f.c0.c.j;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a extends f.a0.a {
    @Override // f.a0.a
    public void a(@NotNull Throwable th, @NotNull Throwable th2) {
        j.e(th, "cause");
        j.e(th2, "exception");
        th.addSuppressed(th2);
    }
}
