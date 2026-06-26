package f.c0.c;

import java.util.Objects;
import kotlin.SinceKotlin;

/* JADX INFO: compiled from: FunctionReference.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends b implements g, f.f0.e {
    private final int arity;

    @SinceKotlin(version = "1.4")
    private final int flags;

    public h(int i2) {
        this(i2, b.NO_RECEIVER, null, null, null, 0);
    }

    @Override // f.c0.c.b
    @SinceKotlin(version = "1.1")
    public f.f0.b computeReflected() {
        Objects.requireNonNull(v.a);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return j.a(getOwner(), hVar.getOwner()) && getName().equals(hVar.getName()) && getSignature().equals(hVar.getSignature()) && this.flags == hVar.flags && this.arity == hVar.arity && j.a(getBoundReceiver(), hVar.getBoundReceiver());
        }
        if (obj instanceof f.f0.e) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // f.c0.c.g
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // f.f0.e
    @SinceKotlin(version = "1.1")
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // f.f0.e
    @SinceKotlin(version = "1.1")
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // f.f0.e
    @SinceKotlin(version = "1.1")
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // f.f0.e
    @SinceKotlin(version = "1.1")
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // f.c0.c.b, f.f0.b
    @SinceKotlin(version = "1.1")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        f.f0.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        StringBuilder sbR = c.a.a.a.a.r("function ");
        sbR.append(getName());
        sbR.append(" (Kotlin reflection is not available)");
        return sbR.toString();
    }

    @SinceKotlin(version = "1.1")
    public h(int i2, Object obj) {
        this(i2, obj, null, null, null, 0);
    }

    @Override // f.c0.c.b
    @SinceKotlin(version = "1.1")
    public f.f0.e getReflected() {
        return (f.f0.e) super.getReflected();
    }

    @SinceKotlin(version = "1.4")
    public h(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.arity = i2;
        this.flags = i3 >> 1;
    }
}
