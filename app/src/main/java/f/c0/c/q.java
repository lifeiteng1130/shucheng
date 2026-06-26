package f.c0.c;

import kotlin.SinceKotlin;

/* JADX INFO: compiled from: PropertyReference1Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public class q extends p {
    public q(f.f0.d dVar, String str, String str2) {
        super(b.NO_RECEIVER, ((c) dVar).a(), str, str2, !(dVar instanceof f.f0.c) ? 1 : 0);
    }

    @Override // f.c0.c.p
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    @SinceKotlin(version = "1.4")
    public q(Class cls, String str, String str2, int i2) {
        super(b.NO_RECEIVER, cls, str, str2, i2);
    }

    @SinceKotlin(version = "1.4")
    public q(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
