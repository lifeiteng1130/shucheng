package j$.time;

import androidx.core.app.NotificationManagerCompat;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import java.io.Serializable;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* JADX INFO: loaded from: classes2.dex */
public final class Instant implements Comparable<Instant>, Serializable, Serializable {
    public static final Instant a = new Instant(0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f7822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7823c;

    static {
        z(-31557014167219200L, 0L);
        z(31556889864403199L, 999999999L);
    }

    private Instant(long j2, int i2) {
        this.f7822b = j2;
        this.f7823c = i2;
    }

    private static Instant v(long j2, int i2) {
        if ((((long) i2) | j2) == 0) {
            return a;
        }
        if (j2 < -31557014167219200L || j2 > 31556889864403199L) {
            throw new c("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j2, i2);
    }

    public static Instant y(long j2) {
        return v(a.y(j2, 1000L), ((int) a.x(j2, 1000L)) * FastDtoa.kTen6);
    }

    public static Instant z(long j2, long j3) {
        return v(a.w(j2, a.y(j3, 1000000000L)), (int) a.x(j3, 1000000000L));
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant instant) {
        Instant instant2 = instant;
        int iCompare = Long.compare(this.f7822b, instant2.f7822b);
        return iCompare != 0 ? iCompare : this.f7823c - instant2.f7823c;
    }

    public boolean d(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar == j$.time.temporal.h.INSTANT_SECONDS || lVar == j$.time.temporal.h.NANO_OF_SECOND || lVar == j$.time.temporal.h.MICRO_OF_SECOND || lVar == j$.time.temporal.h.MILLI_OF_SECOND : lVar != null && lVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.f7822b == instant.f7822b && this.f7823c == instant.f7823c;
    }

    public int h(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return a.k(this, lVar).a(lVar.l(this), lVar);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        if (iOrdinal == 0) {
            return this.f7823c;
        }
        if (iOrdinal == 2) {
            return this.f7823c / 1000;
        }
        if (iOrdinal == 4) {
            return this.f7823c / FastDtoa.kTen6;
        }
        if (iOrdinal == 28) {
            j$.time.temporal.h.INSTANT_SECONDS.w(this.f7822b);
        }
        throw new p("Unsupported field: " + lVar);
    }

    public int hashCode() {
        long j2 = this.f7822b;
        return (this.f7823c * 51) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public q j(j$.time.temporal.l lVar) {
        return a.k(this, lVar);
    }

    public long l(j$.time.temporal.l lVar) {
        int i2;
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        if (iOrdinal == 0) {
            i2 = this.f7823c;
        } else if (iOrdinal == 2) {
            i2 = this.f7823c / 1000;
        } else {
            if (iOrdinal != 4) {
                if (iOrdinal == 28) {
                    return this.f7822b;
                }
                throw new p("Unsupported field: " + lVar);
            }
            i2 = this.f7823c / FastDtoa.kTen6;
        }
        return i2;
    }

    public Object n(n nVar) {
        int i2 = m.a;
        if (nVar == j$.time.temporal.e.a) {
            return j$.time.temporal.i.NANOS;
        }
        if (nVar == j$.time.temporal.b.a || nVar == j$.time.temporal.d.a || nVar == j$.time.temporal.g.a || nVar == j$.time.temporal.c.a || nVar == j$.time.temporal.a.a || nVar == j$.time.temporal.f.a) {
            return null;
        }
        return nVar.a(this);
    }

    public int t(Instant instant) {
        int iCompare = Long.compare(this.f7822b, instant.f7822b);
        return iCompare != 0 ? iCompare : this.f7823c - instant.f7823c;
    }

    public long toEpochMilli() {
        long jZ;
        int i2;
        long j2 = this.f7822b;
        if (j2 >= 0 || this.f7823c <= 0) {
            jZ = a.z(j2, 1000L);
            i2 = this.f7823c / FastDtoa.kTen6;
        } else {
            jZ = a.z(j2 + 1, 1000L);
            i2 = (this.f7823c / FastDtoa.kTen6) + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        }
        return a.w(jZ, i2);
    }

    public String toString() {
        return j$.time.format.b.a.a(this);
    }

    public long w() {
        return this.f7822b;
    }

    public int x() {
        return this.f7823c;
    }
}
