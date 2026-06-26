package f.z;

import f.c0.b.l;
import f.c0.c.j;
import f.z.f;
import f.z.f.a;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
@ExperimentalStdlibApi
public abstract class b<B extends f.a, E extends B> implements f.b<E> {
    public final f.b<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<f.a, E> f6165b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [f.z.f$b<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [f.c0.b.l<? super f.z.f$a, ? extends E extends B>, f.c0.b.l<f.z.f$a, E extends B>, java.lang.Object] */
    public b(@NotNull f.b<B> bVar, @NotNull l<? super f.a, ? extends E> lVar) {
        j.e(bVar, "baseKey");
        j.e(lVar, "safeCast");
        this.f6165b = lVar;
        this.a = bVar instanceof b ? (f.b<B>) ((b) bVar).a : bVar;
    }
}
