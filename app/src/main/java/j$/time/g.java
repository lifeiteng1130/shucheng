package j$.time;

import com.umeng.analytics.pro.bw;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import java.io.Serializable;
import java.util.Objects;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Comparable<g>, Serializable, Serializable {
    public static final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f7870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final g[] f7871c = new g[24];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte f7872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte f7873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte f7874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f7875g;

    static {
        int i2 = 0;
        while (true) {
            g[] gVarArr = f7871c;
            if (i2 >= gVarArr.length) {
                g gVar = gVarArr[0];
                g gVar2 = gVarArr[12];
                a = gVarArr[0];
                f7870b = new g(23, 59, 59, 999999999);
                return;
            }
            gVarArr[i2] = new g(i2, 0, 0, 0);
            i2++;
        }
    }

    private g(int i2, int i3, int i4, int i5) {
        this.f7872d = (byte) i2;
        this.f7873e = (byte) i3;
        this.f7874f = (byte) i4;
        this.f7875g = i5;
    }

    public static g A(long j2) {
        j$.time.temporal.h.NANO_OF_DAY.x(j2);
        int i2 = (int) (j2 / 3600000000000L);
        long j3 = j2 - (((long) i2) * 3600000000000L);
        int i3 = (int) (j3 / 60000000000L);
        long j4 = j3 - (((long) i3) * 60000000000L);
        int i4 = (int) (j4 / 1000000000);
        int i5 = (int) (j4 - (((long) i4) * 1000000000));
        return ((i3 | i4) | i5) == 0 ? f7871c[i2] : new g(i2, i3, i4, i5);
    }

    public static g v(j$.time.temporal.k kVar) {
        Objects.requireNonNull(kVar, "temporal");
        int i2 = m.a;
        g gVar = (g) kVar.n(j$.time.temporal.f.a);
        if (gVar != null) {
            return gVar;
        }
        throw new c("Unable to obtain LocalTime from TemporalAccessor: " + kVar + " of type " + kVar.getClass().getName());
    }

    private int w(j$.time.temporal.l lVar) {
        switch (((j$.time.temporal.h) lVar).ordinal()) {
            case 0:
                return this.f7875g;
            case 1:
                throw new p("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 2:
                return this.f7875g / 1000;
            case 3:
                throw new p("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 4:
                return this.f7875g / FastDtoa.kTen6;
            case 5:
                return (int) (B() / 1000000);
            case 6:
                return this.f7874f;
            case 7:
                return C();
            case 8:
                return this.f7873e;
            case 9:
                return (this.f7872d * 60) + this.f7873e;
            case 10:
                return this.f7872d % 12;
            case 11:
                int i2 = this.f7872d % 12;
                if (i2 % 12 == 0) {
                    return 12;
                }
                return i2;
            case 12:
                return this.f7872d;
            case 13:
                byte b2 = this.f7872d;
                if (b2 == 0) {
                    return 24;
                }
                return b2;
            case 14:
                return this.f7872d / 12;
            default:
                throw new p("Unsupported field: " + lVar);
        }
    }

    public static g z(int i2, int i3) {
        j$.time.temporal.h.HOUR_OF_DAY.x(i2);
        if (i3 == 0) {
            return f7871c[i2];
        }
        j$.time.temporal.h.MINUTE_OF_HOUR.x(i3);
        return new g(i2, i3, 0, 0);
    }

    public long B() {
        return (((long) this.f7874f) * 1000000000) + (((long) this.f7873e) * 60000000000L) + (((long) this.f7872d) * 3600000000000L) + ((long) this.f7875g);
    }

    public int C() {
        return (this.f7873e * 60) + (this.f7872d * bw.n) + this.f7874f;
    }

    public boolean d(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar.j() : lVar != null && lVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f7872d == gVar.f7872d && this.f7873e == gVar.f7873e && this.f7874f == gVar.f7874f && this.f7875g == gVar.f7875g;
    }

    public int h(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? w(lVar) : a.f(this, lVar);
    }

    public int hashCode() {
        long jB = B();
        return (int) (jB ^ (jB >>> 32));
    }

    public q j(j$.time.temporal.l lVar) {
        return a.k(this, lVar);
    }

    public long l(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar == j$.time.temporal.h.NANO_OF_DAY ? B() : lVar == j$.time.temporal.h.MICRO_OF_DAY ? B() / 1000 : w(lVar) : lVar.l(this);
    }

    public Object n(n nVar) {
        int i2 = m.a;
        if (nVar == j$.time.temporal.b.a || nVar == j$.time.temporal.d.a || nVar == j$.time.temporal.g.a || nVar == j$.time.temporal.c.a) {
            return null;
        }
        if (nVar == j$.time.temporal.f.a) {
            return this;
        }
        if (nVar == j$.time.temporal.a.a) {
            return null;
        }
        return nVar == j$.time.temporal.e.a ? j$.time.temporal.i.NANOS : nVar.a(this);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        int iCompare = Integer.compare(this.f7872d, gVar.f7872d);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Integer.compare(this.f7873e, gVar.f7873e);
        if (iCompare2 != 0) {
            return iCompare2;
        }
        int iCompare3 = Integer.compare(this.f7874f, gVar.f7874f);
        return iCompare3 == 0 ? Integer.compare(this.f7875g, gVar.f7875g) : iCompare3;
    }

    public String toString() {
        int i2;
        StringBuilder sb = new StringBuilder(18);
        byte b2 = this.f7872d;
        byte b3 = this.f7873e;
        byte b4 = this.f7874f;
        int i3 = this.f7875g;
        sb.append(b2 < 10 ? "0" : "");
        sb.append((int) b2);
        sb.append(b3 < 10 ? ":0" : ":");
        sb.append((int) b3);
        if (b4 > 0 || i3 > 0) {
            sb.append(b4 >= 10 ? ":" : ":0");
            sb.append((int) b4);
            if (i3 > 0) {
                sb.append('.');
                int i4 = FastDtoa.kTen6;
                if (i3 % FastDtoa.kTen6 == 0) {
                    i2 = (i3 / FastDtoa.kTen6) + 1000;
                } else {
                    if (i3 % 1000 == 0) {
                        i3 /= 1000;
                    } else {
                        i4 = 1000000000;
                    }
                    i2 = i3 + i4;
                }
                sb.append(Integer.toString(i2).substring(1));
            }
        }
        return sb.toString();
    }

    public int x() {
        return this.f7875g;
    }

    public int y() {
        return this.f7874f;
    }
}
