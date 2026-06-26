package g.b;

import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes3.dex */
@InternalCoroutinesApi
public final class q1 implements m0, l {

    @NotNull
    public static final q1 a = new q1();

    @Override // g.b.l
    public boolean b(@NotNull Throwable th) {
        return false;
    }

    @Override // g.b.m0
    public void e() {
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }
}
