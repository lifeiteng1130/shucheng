package f.c0.c;

import f.f0.h;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MutablePropertyReference.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n extends r implements f.f0.h {
    public n() {
    }

    @Override // f.c0.c.r
    @NotNull
    public abstract /* synthetic */ h.a<V> getGetter();

    @NotNull
    public abstract /* synthetic */ f.f0.f<V> getSetter();

    @SinceKotlin(version = "1.1")
    public n(Object obj) {
        super(obj);
    }

    @SinceKotlin(version = "1.4")
    public n(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
