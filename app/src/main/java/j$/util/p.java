package j$.util;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    private static final p a = new p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f8000c;

    private p() {
        this.f7999b = false;
        this.f8000c = Double.NaN;
    }

    private p(double d2) {
        this.f7999b = true;
        this.f8000c = d2;
    }

    public static p a() {
        return a;
    }

    public static p d(double d2) {
        return new p(d2);
    }

    public double b() {
        if (this.f7999b) {
            return this.f8000c;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.f7999b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        boolean z = this.f7999b;
        if (z && pVar.f7999b) {
            if (Double.compare(this.f8000c, pVar.f8000c) == 0) {
                return true;
            }
        } else if (z == pVar.f7999b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (!this.f7999b) {
            return 0;
        }
        long jDoubleToLongBits = Double.doubleToLongBits(this.f8000c);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public String toString() {
        return this.f7999b ? String.format("OptionalDouble[%s]", Double.valueOf(this.f8000c)) : "OptionalDouble.empty";
    }
}
