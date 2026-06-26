package f.f0;

import f.f0.h;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface i<V> extends h<V>, f.c0.b.a<V> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface a<V> extends h.a<V>, f.c0.b.a<V> {
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    Object getDelegate();

    @NotNull
    a<V> getGetter();
}
