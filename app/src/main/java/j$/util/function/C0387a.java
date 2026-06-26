package j$.util.function;

import java.util.Objects;

/* JADX INFO: renamed from: j$.util.function.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0387a implements BiConsumer {
    public final /* synthetic */ BiConsumer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BiConsumer f7985b;

    public /* synthetic */ C0387a(BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.a = biConsumer;
        this.f7985b = biConsumer2;
    }

    @Override // j$.util.function.BiConsumer
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        return new C0387a(this, biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        BiConsumer biConsumer = this.a;
        BiConsumer biConsumer2 = this.f7985b;
        biConsumer.accept(obj, obj2);
        biConsumer2.accept(obj, obj2);
    }
}
