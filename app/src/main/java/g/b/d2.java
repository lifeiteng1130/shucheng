package g.b;

import f.z.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d2 implements f.a, f.b<d2> {

    @NotNull
    public static final d2 a = new d2();

    @Override // f.z.f
    public <R> R fold(R r, @NotNull f.c0.b.p<? super R, ? super f.a, ? extends R> pVar) {
        return (R) f.a.C0182a.a(this, r, pVar);
    }

    @Override // f.z.f.a, f.z.f
    @Nullable
    public <E extends f.a> E get(@NotNull f.b<E> bVar) {
        return (E) f.a.C0182a.b(this, bVar);
    }

    @Override // f.z.f.a
    @NotNull
    public f.b<?> getKey() {
        return this;
    }

    @Override // f.z.f
    @NotNull
    public f.z.f minusKey(@NotNull f.b<?> bVar) {
        return f.a.C0182a.c(this, bVar);
    }

    @Override // f.z.f
    @NotNull
    public f.z.f plus(@NotNull f.z.f fVar) {
        return f.a.C0182a.d(this, fVar);
    }
}
