package f.z;

import f.c0.b.p;
import f.c0.c.j;
import f.z.f;
import java.io.Serializable;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
public final class h implements f, Serializable {

    @NotNull
    public static final h INSTANCE = new h();
    private static final long serialVersionUID = 0;

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // f.z.f
    public <R> R fold(R r, @NotNull p<? super R, ? super f.a, ? extends R> pVar) {
        j.e(pVar, "operation");
        return r;
    }

    @Override // f.z.f
    @Nullable
    public <E extends f.a> E get(@NotNull f.b<E> bVar) {
        j.e(bVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // f.z.f
    @NotNull
    public f minusKey(@NotNull f.b<?> bVar) {
        j.e(bVar, "key");
        return this;
    }

    @Override // f.z.f
    @NotNull
    public f plus(@NotNull f fVar) {
        j.e(fVar, com.umeng.analytics.pro.c.R);
        return fVar;
    }

    @NotNull
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
