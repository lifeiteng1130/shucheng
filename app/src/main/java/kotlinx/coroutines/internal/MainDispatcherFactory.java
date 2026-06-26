package kotlinx.coroutines.internal;

import g.b.o1;
import java.util.List;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MainDispatcherFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@InternalCoroutinesApi
public interface MainDispatcherFactory {
    @NotNull
    o1 createDispatcher(@NotNull List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    @Nullable
    String hintOnError();
}
