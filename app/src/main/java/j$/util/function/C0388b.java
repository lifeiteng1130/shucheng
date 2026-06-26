package j$.util.function;

import java.util.Objects;

/* JADX INFO: renamed from: j$.util.function.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0388b implements BiFunction {
    public final /* synthetic */ BiFunction a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function f7986b;

    public /* synthetic */ C0388b(BiFunction biFunction, Function function) {
        this.a = biFunction;
        this.f7986b = function;
    }

    @Override // j$.util.function.BiFunction
    public BiFunction andThen(Function function) {
        Objects.requireNonNull(function);
        return new C0388b(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return this.f7986b.apply(this.a.apply(obj, obj2));
    }
}
