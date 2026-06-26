package f.c0.c;

import f.f0.h;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PropertyReference.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends b implements f.f0.h {
    public r() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            return getOwner().equals(rVar.getOwner()) && getName().equals(rVar.getName()) && getSignature().equals(rVar.getSignature()) && j.a(getBoundReceiver(), rVar.getBoundReceiver());
        }
        if (obj instanceof f.f0.h) {
            return obj.equals(compute());
        }
        return false;
    }

    @NotNull
    public abstract /* synthetic */ h.a<V> getGetter();

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // f.f0.h
    @SinceKotlin(version = "1.1")
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // f.f0.h
    @SinceKotlin(version = "1.1")
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        f.f0.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        StringBuilder sbR = c.a.a.a.a.r("property ");
        sbR.append(getName());
        sbR.append(" (Kotlin reflection is not available)");
        return sbR.toString();
    }

    @SinceKotlin(version = "1.1")
    public r(Object obj) {
        super(obj);
    }

    @Override // f.c0.c.b
    @SinceKotlin(version = "1.1")
    public f.f0.h getReflected() {
        return (f.f0.h) super.getReflected();
    }

    @SinceKotlin(version = "1.4")
    public r(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
    }
}
