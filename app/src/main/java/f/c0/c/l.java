package f.c0.c;

import f.f0.g;
import f.f0.i;
import java.util.Objects;
import kotlin.SinceKotlin;

/* JADX INFO: compiled from: MutablePropertyReference0.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends n implements f.f0.g {
    public l() {
    }

    @Override // f.c0.c.b
    public f.f0.b computeReflected() {
        Objects.requireNonNull(v.a);
        return this;
    }

    public abstract /* synthetic */ V get();

    @Override // f.f0.i
    @SinceKotlin(version = "1.1")
    public Object getDelegate() {
        return ((f.f0.g) getReflected()).getDelegate();
    }

    @Override // f.c0.b.a
    public Object invoke() {
        return get();
    }

    public abstract /* synthetic */ void set(V v);

    @SinceKotlin(version = "1.1")
    public l(Object obj) {
        super(obj);
    }

    @Override // f.c0.c.n, f.c0.c.r
    public i.a getGetter() {
        return ((f.f0.g) getReflected()).getGetter();
    }

    @Override // f.c0.c.n
    public g.a getSetter() {
        return ((f.f0.g) getReflected()).getSetter();
    }

    @SinceKotlin(version = "1.4")
    public l(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
