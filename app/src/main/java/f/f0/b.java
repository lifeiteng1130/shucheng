package f.f0;

import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KCallable.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b<R> extends a {
    R call(@NotNull Object... objArr);

    R callBy(@NotNull Map<?, ? extends Object> map);

    @NotNull
    List<?> getParameters();

    @NotNull
    k getReturnType();

    @NotNull
    List<?> getTypeParameters();

    @Nullable
    l getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
