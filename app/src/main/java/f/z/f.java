package f.z;

import f.c0.b.p;
import f.c0.c.j;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
public interface f {

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface a extends f {

        /* JADX INFO: renamed from: f.z.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        public static final class C0182a {
            public static <R> R a(@NotNull a aVar, R r, @NotNull p<? super R, ? super a, ? extends R> pVar) {
                j.e(pVar, "operation");
                return pVar.invoke(r, aVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Nullable
            public static <E extends a> E b(@NotNull a aVar, @NotNull b<E> bVar) {
                j.e(bVar, "key");
                if (j.a(aVar.getKey(), bVar)) {
                    return aVar;
                }
                return null;
            }

            @NotNull
            public static f c(@NotNull a aVar, @NotNull b<?> bVar) {
                j.e(bVar, "key");
                return j.a(aVar.getKey(), bVar) ? h.INSTANCE : aVar;
            }

            @NotNull
            public static f d(@NotNull a aVar, @NotNull f fVar) {
                j.e(fVar, com.umeng.analytics.pro.c.R);
                j.e(fVar, com.umeng.analytics.pro.c.R);
                return fVar == h.INSTANCE ? aVar : (f) fVar.fold(aVar, g.INSTANCE);
            }
        }

        @Override // f.z.f
        @Nullable
        <E extends a> E get(@NotNull b<E> bVar);

        @NotNull
        b<?> getKey();
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface b<E extends a> {
    }

    <R> R fold(R r, @NotNull p<? super R, ? super a, ? extends R> pVar);

    @Nullable
    <E extends a> E get(@NotNull b<E> bVar);

    @NotNull
    f minusKey(@NotNull b<?> bVar);

    @NotNull
    f plus(@NotNull f fVar);
}
