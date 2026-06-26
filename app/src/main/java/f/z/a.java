package f.z;

import f.c0.b.p;
import f.c0.c.j;
import f.z.f;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
public abstract class a implements f.a {

    @NotNull
    private final f.b<?> key;

    public a(@NotNull f.b<?> bVar) {
        j.e(bVar, "key");
        this.key = bVar;
    }

    @Override // f.z.f
    public <R> R fold(R r, @NotNull p<? super R, ? super f.a, ? extends R> pVar) {
        j.e(pVar, "operation");
        return (R) f.a.C0182a.a(this, r, pVar);
    }

    @Override // f.z.f.a, f.z.f
    @Nullable
    public <E extends f.a> E get(@NotNull f.b<E> bVar) {
        j.e(bVar, "key");
        return (E) f.a.C0182a.b(this, bVar);
    }

    @Override // f.z.f.a
    @NotNull
    public f.b<?> getKey() {
        return this.key;
    }

    @Override // f.z.f
    @NotNull
    public f minusKey(@NotNull f.b<?> bVar) {
        j.e(bVar, "key");
        return f.a.C0182a.c(this, bVar);
    }

    @Override // f.z.f
    @NotNull
    public f plus(@NotNull f fVar) {
        j.e(fVar, com.umeng.analytics.pro.c.R);
        return f.a.C0182a.d(this, fVar);
    }
}
