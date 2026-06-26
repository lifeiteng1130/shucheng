package f.c0.c;

import f.f0.j;
import java.util.Objects;
import kotlin.SinceKotlin;

/* JADX INFO: compiled from: PropertyReference1.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p extends r implements f.f0.j {
    public p() {
    }

    @Override // f.c0.c.b
    public f.f0.b computeReflected() {
        Objects.requireNonNull(v.a);
        return this;
    }

    public abstract /* synthetic */ V get(T t);

    @Override // f.f0.j
    @SinceKotlin(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((f.f0.j) getReflected()).getDelegate(obj);
    }

    @Override // f.c0.b.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @SinceKotlin(version = "1.1")
    public p(Object obj) {
        super(obj);
    }

    @Override // f.c0.c.r
    public j.a getGetter() {
        return ((f.f0.j) getReflected()).getGetter();
    }

    @SinceKotlin(version = "1.4")
    public p(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
