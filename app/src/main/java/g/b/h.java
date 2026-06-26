package g.b;

import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface h<T> extends f.z.d<T> {
    void a(@NotNull f.c0.b.l<? super Throwable, f.v> lVar);

    @ExperimentalCoroutinesApi
    void b(@NotNull y yVar, T t);

    boolean g(@Nullable Throwable th);

    boolean h();
}
