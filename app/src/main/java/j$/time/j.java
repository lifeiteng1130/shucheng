package j$.time;

import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends ZoneId implements j$.time.temporal.k, Comparable<j>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap f7878b = new ConcurrentHashMap(16, 0.75f, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentMap f7879c = new ConcurrentHashMap(16, 0.75f, 4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f7880d = B(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f7881e = B(-64800);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f7882f = B(64800);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f7883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient String f7884h;

    private j(int i2) {
        String string;
        this.f7883g = i2;
        if (i2 == 0) {
            string = "Z";
        } else {
            int iAbs = Math.abs(i2);
            StringBuilder sb = new StringBuilder();
            int i3 = iAbs / 3600;
            int i4 = (iAbs / 60) % 60;
            sb.append(i2 < 0 ? "-" : Marker.ANY_NON_NULL_MARKER);
            sb.append(i3 < 10 ? "0" : "");
            sb.append(i3);
            sb.append(i4 < 10 ? ":0" : ":");
            sb.append(i4);
            int i5 = iAbs % 60;
            if (i5 != 0) {
                sb.append(i5 >= 10 ? ":" : ":0");
                sb.append(i5);
            }
            string = sb.toString();
        }
        this.f7884h = string;
    }

    public static j A(int i2, int i3, int i4) {
        if (i2 < -18 || i2 > 18) {
            throw new c("Zone offset hours not in valid range: value " + i2 + " is not in the range -18 to 18");
        }
        if (i2 > 0) {
            if (i3 < 0 || i4 < 0) {
                throw new c("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i2 < 0) {
            if (i3 > 0 || i4 > 0) {
                throw new c("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i3 > 0 && i4 < 0) || (i3 < 0 && i4 > 0)) {
            throw new c("Zone offset minutes and seconds must have the same sign");
        }
        if (i3 < -59 || i3 > 59) {
            throw new c("Zone offset minutes not in valid range: value " + i3 + " is not in the range -59 to 59");
        }
        if (i4 < -59 || i4 > 59) {
            throw new c("Zone offset seconds not in valid range: value " + i4 + " is not in the range -59 to 59");
        }
        if (Math.abs(i2) == 18 && (i3 | i4) != 0) {
            throw new c("Zone offset not in valid range: -18:00 to +18:00");
        }
        return B((i3 * 60) + (i2 * 3600) + i4);
    }

    public static j B(int i2) {
        if (i2 < -64800 || i2 > 64800) {
            throw new c("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i2 % 900 != 0) {
            return new j(i2);
        }
        Integer numValueOf = Integer.valueOf(i2);
        ConcurrentMap concurrentMap = f7878b;
        j jVar = (j) concurrentMap.get(numValueOf);
        if (jVar != null) {
            return jVar;
        }
        concurrentMap.putIfAbsent(numValueOf, new j(i2));
        j jVar2 = (j) concurrentMap.get(numValueOf);
        f7879c.putIfAbsent(jVar2.f7884h, jVar2);
        return jVar2;
    }

    private static int C(CharSequence charSequence, int i2, boolean z) {
        if (z && charSequence.charAt(i2 - 1) != ':') {
            throw new c("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
        }
        char cCharAt = charSequence.charAt(i2);
        char cCharAt2 = charSequence.charAt(i2 + 1);
        if (cCharAt >= '0' && cCharAt <= '9' && cCharAt2 >= '0' && cCharAt2 <= '9') {
            return (cCharAt2 - '0') + ((cCharAt - '0') * 10);
        }
        throw new c("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.j z(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap r0 = j$.time.j.f7879c
            java.lang.Object r0 = r0.get(r7)
            j$.time.j r0 = (j$.time.j) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L6d
            r1 = 3
            if (r0 == r1) goto L89
            r4 = 5
            if (r0 == r4) goto L64
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L5b
            r5 = 7
            if (r0 == r5) goto L4e
            r1 = 9
            if (r0 != r1) goto L37
            int r0 = C(r7, r2, r3)
            int r1 = C(r7, r6, r2)
            int r2 = C(r7, r5, r2)
            goto L8f
        L37:
            j$.time.c r0 = new j$.time.c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, invalid format: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L4e:
            int r0 = C(r7, r2, r3)
            int r1 = C(r7, r1, r3)
            int r2 = C(r7, r4, r3)
            goto L8f
        L5b:
            int r0 = C(r7, r2, r3)
            int r1 = C(r7, r6, r2)
            goto L8e
        L64:
            int r0 = C(r7, r2, r3)
            int r1 = C(r7, r1, r3)
            goto L8e
        L6d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r1 = r7.charAt(r3)
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            char r7 = r7.charAt(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L89:
            int r0 = C(r7, r2, r3)
            r1 = 0
        L8e:
            r2 = 0
        L8f:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto Lb3
            if (r3 != r5) goto L9c
            goto Lb3
        L9c:
            j$.time.c r0 = new j$.time.c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        Lb3:
            if (r3 != r5) goto Lbd
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.j r7 = A(r7, r0, r1)
            return r7
        Lbd:
            j$.time.j r7 = A(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.j.z(java.lang.String):j$.time.j");
    }

    @Override // java.lang.Comparable
    public int compareTo(j jVar) {
        return jVar.f7883g - this.f7883g;
    }

    @Override // j$.time.temporal.k
    public boolean d(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar == j$.time.temporal.h.OFFSET_SECONDS : lVar != null && lVar.n(this);
    }

    @Override // j$.time.ZoneId
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.f7883g == ((j) obj).f7883g;
    }

    @Override // j$.time.ZoneId
    public String g() {
        return this.f7884h;
    }

    @Override // j$.time.temporal.k
    public int h(j$.time.temporal.l lVar) {
        if (lVar == j$.time.temporal.h.OFFSET_SECONDS) {
            return this.f7883g;
        }
        if (!(lVar instanceof j$.time.temporal.h)) {
            return a.k(this, lVar).a(l(lVar), lVar);
        }
        throw new p("Unsupported field: " + lVar);
    }

    @Override // j$.time.ZoneId
    public int hashCode() {
        return this.f7883g;
    }

    @Override // j$.time.temporal.k
    public q j(j$.time.temporal.l lVar) {
        return a.k(this, lVar);
    }

    @Override // j$.time.temporal.k
    public long l(j$.time.temporal.l lVar) {
        if (lVar == j$.time.temporal.h.OFFSET_SECONDS) {
            return this.f7883g;
        }
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        throw new p("Unsupported field: " + lVar);
    }

    @Override // j$.time.temporal.k
    public Object n(n nVar) {
        int i2 = m.a;
        return (nVar == j$.time.temporal.c.a || nVar == j$.time.temporal.g.a) ? this : a.j(this, nVar);
    }

    @Override // j$.time.ZoneId
    public j$.time.zone.c t() {
        return j$.time.zone.c.e(this);
    }

    @Override // j$.time.ZoneId
    public String toString() {
        return this.f7884h;
    }

    public int y() {
        return this.f7883g;
    }
}
