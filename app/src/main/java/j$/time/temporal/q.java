package j$.time.temporal;

import java.io.Serializable;
import org.jsoup.nodes.Attributes;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements Serializable {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f7898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f7899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f7900d;

    private q(long j2, long j3, long j4, long j5) {
        this.a = j2;
        this.f7898b = j3;
        this.f7899c = j4;
        this.f7900d = j5;
    }

    private String c(l lVar, long j2) {
        if (lVar == null) {
            return "Invalid value (valid values " + this + "): " + j2;
        }
        return "Invalid value for " + lVar + " (valid values " + this + "): " + j2;
    }

    public static q i(long j2, long j3) {
        if (j2 <= j3) {
            return new q(j2, j2, j3, j3);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static q j(long j2, long j3, long j4) {
        if (j2 > j2) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        }
        if (j3 > j4) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (j2 <= j4) {
            return new q(j2, j2, j3, j4);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public int a(long j2, l lVar) {
        if (g() && h(j2)) {
            return (int) j2;
        }
        throw new j$.time.c(c(lVar, j2));
    }

    public long b(long j2, l lVar) {
        if (h(j2)) {
            return j2;
        }
        throw new j$.time.c(c(lVar, j2));
    }

    public long d() {
        return this.f7900d;
    }

    public long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a == qVar.a && this.f7898b == qVar.f7898b && this.f7899c == qVar.f7899c && this.f7900d == qVar.f7900d;
    }

    public boolean f() {
        return this.a == this.f7898b && this.f7899c == this.f7900d;
    }

    public boolean g() {
        return this.a >= -2147483648L && this.f7900d <= 2147483647L;
    }

    public boolean h(long j2) {
        return j2 >= this.a && j2 <= this.f7900d;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.f7898b;
        long j4 = j2 + (j3 << 16) + (j3 >> 48);
        long j5 = this.f7899c;
        long j6 = j4 + (j5 << 32) + (j5 >> 32);
        long j7 = this.f7900d;
        long j8 = j6 + (j7 << 48) + (j7 >> 16);
        return (int) (j8 ^ (j8 >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        if (this.a != this.f7898b) {
            sb.append(Attributes.InternalPrefix);
            sb.append(this.f7898b);
        }
        sb.append(" - ");
        sb.append(this.f7899c);
        if (this.f7899c != this.f7900d) {
            sb.append(Attributes.InternalPrefix);
            sb.append(this.f7900d);
        }
        return sb.toString();
    }
}
