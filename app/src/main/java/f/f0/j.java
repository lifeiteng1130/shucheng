package f.f0;

import f.f0.h;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface j<T, V> extends h<V>, f.c0.b.l<T, V> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface a<T, V> extends h.a<V>, f.c0.b.l<T, V> {
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    Object getDelegate(T t);

    @NotNull
    a<T, V> getGetter();
}
