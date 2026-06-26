package j$.time.format;

import j$.time.ZoneId;
import j$.time.format.f;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.q;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import okhttp3.internal.connection.RealConnection;
import org.mozilla.javascript.v8dtoa.FastDtoa;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f7839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f7840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f7841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f7842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7843f;

    class a extends j$.time.format.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f.b f7844c;

        a(c cVar, f.b bVar) {
            this.f7844c = bVar;
        }
    }

    static final class b implements d {
        private final char a;

        b(char c2) {
            this.a = c2;
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            sb.append(this.a);
            return true;
        }

        public String toString() {
            if (this.a == '\'') {
                return "''";
            }
            StringBuilder sbA = j$.com.android.tools.r8.a.a("'");
            sbA.append(this.a);
            sbA.append("'");
            return sbA.toString();
        }
    }

    /* JADX INFO: renamed from: j$.time.format.c$c, reason: collision with other inner class name */
    static final class C0217c implements d {
        private final d[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f7845b;

        C0217c(List list, boolean z) {
            this.a = (d[]) list.toArray(new d[list.size()]);
            this.f7845b = z;
        }

        C0217c(d[] dVarArr, boolean z) {
            this.a = dVarArr;
            this.f7845b = z;
        }

        public C0217c a(boolean z) {
            return z == this.f7845b ? this : new C0217c(this.a, z);
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            int length = sb.length();
            if (this.f7845b) {
                eVar.g();
            }
            try {
                for (d dVar : this.a) {
                    if (!dVar.h(eVar, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.f7845b) {
                    eVar.a();
                }
                return true;
            } finally {
                if (this.f7845b) {
                    eVar.a();
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.a != null) {
                sb.append(this.f7845b ? "[" : "(");
                for (d dVar : this.a) {
                    sb.append(dVar);
                }
                sb.append(this.f7845b ? "]" : ")");
            }
            return sb.toString();
        }
    }

    interface d {
        boolean h(j$.time.format.e eVar, StringBuilder sb);
    }

    static final class e implements d {
        private final j$.time.temporal.l a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f7846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f7847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f7848d;

        e(j$.time.temporal.l lVar, int i2, int i3, boolean z) {
            Objects.requireNonNull(lVar, "field");
            if (!lVar.h().f()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + lVar);
            }
            if (i2 < 0 || i2 > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i2);
            }
            if (i3 < 1 || i3 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i3);
            }
            if (i3 >= i2) {
                this.a = lVar;
                this.f7846b = i2;
                this.f7847c = i3;
                this.f7848d = z;
                return;
            }
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            Long lE = eVar.e(this.a);
            if (lE == null) {
                return false;
            }
            j$.time.format.g gVarB = eVar.b();
            long jLongValue = lE.longValue();
            q qVarH = this.a.h();
            qVarH.b(jLongValue, this.a);
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(qVarH.e());
            BigDecimal bigDecimalDivide = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf).divide(BigDecimal.valueOf(qVarH.d()).subtract(bigDecimalValueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal bigDecimalStripTrailingZeros = bigDecimalDivide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : bigDecimalDivide.stripTrailingZeros();
            if (bigDecimalStripTrailingZeros.scale() != 0) {
                String strA = gVarB.a(bigDecimalStripTrailingZeros.setScale(Math.min(Math.max(bigDecimalStripTrailingZeros.scale(), this.f7846b), this.f7847c), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.f7848d) {
                    sb.append(gVarB.b());
                }
                sb.append(strA);
                return true;
            }
            if (this.f7846b <= 0) {
                return true;
            }
            if (this.f7848d) {
                sb.append(gVarB.b());
            }
            for (int i2 = 0; i2 < this.f7846b; i2++) {
                sb.append(gVarB.e());
            }
            return true;
        }

        public String toString() {
            String str = this.f7848d ? ",DecimalPoint" : "";
            StringBuilder sbA = j$.com.android.tools.r8.a.a("Fraction(");
            sbA.append(this.a);
            sbA.append(",");
            sbA.append(this.f7846b);
            sbA.append(",");
            sbA.append(this.f7847c);
            sbA.append(str);
            sbA.append(")");
            return sbA.toString();
        }
    }

    static final class f implements d {
        f(int i2) {
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            Long lE = eVar.e(j$.time.temporal.h.INSTANT_SECONDS);
            j$.time.temporal.k kVarD = eVar.d();
            j$.time.temporal.h hVar = j$.time.temporal.h.NANO_OF_SECOND;
            Long lValueOf = kVarD.d(hVar) ? Long.valueOf(eVar.d().l(hVar)) : null;
            int i2 = 0;
            if (lE == null) {
                return false;
            }
            long jLongValue = lE.longValue();
            int iW = hVar.w(lValueOf != null ? lValueOf.longValue() : 0L);
            if (jLongValue >= -62167219200L) {
                long j2 = (jLongValue - 315569520000L) + 62167219200L;
                long jY = j$.time.a.y(j2, 315569520000L) + 1;
                j$.time.f fVarA = j$.time.f.A(j$.time.a.x(j2, 315569520000L) - 62167219200L, 0, j$.time.j.f7880d);
                if (jY > 0) {
                    sb.append('+');
                    sb.append(jY);
                }
                sb.append(fVarA);
                if (fVarA.w() == 0) {
                    sb.append(":00");
                }
            } else {
                long j3 = jLongValue + 62167219200L;
                long j4 = j3 / 315569520000L;
                long j5 = j3 % 315569520000L;
                j$.time.f fVarA2 = j$.time.f.A(j5 - 62167219200L, 0, j$.time.j.f7880d);
                int length = sb.length();
                sb.append(fVarA2);
                if (fVarA2.w() == 0) {
                    sb.append(":00");
                }
                if (j4 < 0) {
                    if (fVarA2.x() == -10000) {
                        sb.replace(length, length + 2, Long.toString(j4 - 1));
                    } else if (j5 == 0) {
                        sb.insert(length, j4);
                    } else {
                        sb.insert(length + 1, Math.abs(j4));
                    }
                }
            }
            if (iW > 0) {
                sb.append('.');
                int i3 = FastDtoa.kTen8;
                while (true) {
                    if (iW <= 0 && i2 % 3 == 0 && i2 >= -2) {
                        break;
                    }
                    int i4 = iW / i3;
                    sb.append((char) (i4 + 48));
                    iW -= i4 * i3;
                    i3 /= 10;
                    i2++;
                }
            }
            sb.append('Z');
            return true;
        }

        public String toString() {
            return "Instant()";
        }
    }

    static class g implements d {
        static final long[] a = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j$.time.temporal.l f7849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f7850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f7851d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final j$.time.format.i f7852e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f7853f;

        g(j$.time.temporal.l lVar, int i2, int i3, j$.time.format.i iVar) {
            this.f7849b = lVar;
            this.f7850c = i2;
            this.f7851d = i3;
            this.f7852e = iVar;
            this.f7853f = 0;
        }

        protected g(j$.time.temporal.l lVar, int i2, int i3, j$.time.format.i iVar, int i4) {
            this.f7849b = lVar;
            this.f7850c = i2;
            this.f7851d = i3;
            this.f7852e = iVar;
            this.f7853f = i4;
        }

        g b() {
            return this.f7853f == -1 ? this : new g(this.f7849b, this.f7850c, this.f7851d, this.f7852e, -1);
        }

        g c(int i2) {
            return new g(this.f7849b, this.f7850c, this.f7851d, this.f7852e, this.f7853f + i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
        
            if (r4 != 4) goto L39;
         */
        @Override // j$.time.format.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean h(j$.time.format.e r12, java.lang.StringBuilder r13) {
            /*
                r11 = this;
                j$.time.temporal.l r0 = r11.f7849b
                java.lang.Long r0 = r12.e(r0)
                r1 = 0
                if (r0 != 0) goto La
                return r1
            La:
                long r2 = r0.longValue()
                j$.time.format.g r12 = r12.b()
                r4 = -9223372036854775808
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 != 0) goto L1b
                java.lang.String r0 = "9223372036854775808"
                goto L23
            L1b:
                long r4 = java.lang.Math.abs(r2)
                java.lang.String r0 = java.lang.Long.toString(r4)
            L23:
                int r4 = r0.length()
                int r5 = r11.f7851d
                java.lang.String r6 = " cannot be printed as the value "
                java.lang.String r7 = "Field "
                if (r4 > r5) goto L9f
                java.lang.String r0 = r12.a(r0)
                r4 = 0
                r8 = 4
                r9 = 1
                int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                j$.time.format.i r4 = r11.f7852e
                int r4 = r4.ordinal()
                if (r10 < 0) goto L59
                if (r4 == r9) goto L54
                if (r4 == r8) goto L46
                goto L88
            L46:
                int r4 = r11.f7850c
                r5 = 19
                if (r4 >= r5) goto L88
                long[] r5 = j$.time.format.c.g.a
                r4 = r5[r4]
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 < 0) goto L88
            L54:
                char r2 = r12.d()
                goto L85
            L59:
                if (r4 == 0) goto L81
                if (r4 == r9) goto L81
                r5 = 3
                if (r4 == r5) goto L63
                if (r4 == r8) goto L81
                goto L88
            L63:
                j$.time.c r12 = new j$.time.c
                java.lang.StringBuilder r13 = j$.com.android.tools.r8.a.a(r7)
                j$.time.temporal.l r0 = r11.f7849b
                r13.append(r0)
                r13.append(r6)
                r13.append(r2)
                java.lang.String r0 = " cannot be negative according to the SignStyle"
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                r12.<init>(r13)
                throw r12
            L81:
                char r2 = r12.c()
            L85:
                r13.append(r2)
            L88:
                int r2 = r11.f7850c
                int r3 = r0.length()
                int r2 = r2 - r3
                if (r1 >= r2) goto L9b
                char r2 = r12.e()
                r13.append(r2)
                int r1 = r1 + 1
                goto L88
            L9b:
                r13.append(r0)
                return r9
            L9f:
                j$.time.c r12 = new j$.time.c
                java.lang.StringBuilder r13 = j$.com.android.tools.r8.a.a(r7)
                j$.time.temporal.l r0 = r11.f7849b
                r13.append(r0)
                r13.append(r6)
                r13.append(r2)
                java.lang.String r0 = " exceeds the maximum print width of "
                r13.append(r0)
                int r0 = r11.f7851d
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.c.g.h(j$.time.format.e, java.lang.StringBuilder):boolean");
        }

        public String toString() {
            StringBuilder sbA;
            Object obj;
            int i2 = this.f7850c;
            if (i2 == 1 && this.f7851d == 19 && this.f7852e == j$.time.format.i.NORMAL) {
                sbA = j$.com.android.tools.r8.a.a("Value(");
                obj = this.f7849b;
            } else {
                if (i2 == this.f7851d && this.f7852e == j$.time.format.i.NOT_NEGATIVE) {
                    sbA = j$.com.android.tools.r8.a.a("Value(");
                    sbA.append(this.f7849b);
                    sbA.append(",");
                    sbA.append(this.f7850c);
                    sbA.append(")");
                    return sbA.toString();
                }
                sbA = j$.com.android.tools.r8.a.a("Value(");
                sbA.append(this.f7849b);
                sbA.append(",");
                sbA.append(this.f7850c);
                sbA.append(",");
                sbA.append(this.f7851d);
                sbA.append(",");
                obj = this.f7852e;
            }
            sbA.append(obj);
            sbA.append(")");
            return sbA.toString();
        }
    }

    static final class h implements d {
        static final String[] a = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final h f7854b = new h("+HH:MM:ss", "Z");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f7855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f7856d;

        static {
            new h("+HH:MM:ss", "0");
        }

        h(String str, String str2) {
            Objects.requireNonNull(str, "pattern");
            Objects.requireNonNull(str2, "noOffsetText");
            int i2 = 0;
            while (true) {
                String[] strArr = a;
                if (i2 >= strArr.length) {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
                }
                if (strArr[i2].equals(str)) {
                    this.f7856d = i2;
                    this.f7855c = str2;
                    return;
                }
                i2++;
            }
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            Long lE = eVar.e(j$.time.temporal.h.OFFSET_SECONDS);
            if (lE == null) {
                return false;
            }
            long jLongValue = lE.longValue();
            int i2 = (int) jLongValue;
            if (jLongValue != i2) {
                throw new ArithmeticException();
            }
            if (i2 == 0) {
                sb.append(this.f7855c);
            } else {
                int iAbs = Math.abs((i2 / 3600) % 100);
                int iAbs2 = Math.abs((i2 / 60) % 60);
                int iAbs3 = Math.abs(i2 % 60);
                int length = sb.length();
                sb.append(i2 < 0 ? "-" : Marker.ANY_NON_NULL_MARKER);
                sb.append((char) ((iAbs / 10) + 48));
                sb.append((char) ((iAbs % 10) + 48));
                int i3 = this.f7856d;
                if (i3 >= 3 || (i3 >= 1 && iAbs2 > 0)) {
                    sb.append(i3 % 2 == 0 ? ":" : "");
                    sb.append((char) ((iAbs2 / 10) + 48));
                    sb.append((char) ((iAbs2 % 10) + 48));
                    iAbs += iAbs2;
                    int i4 = this.f7856d;
                    if (i4 >= 7 || (i4 >= 5 && iAbs3 > 0)) {
                        sb.append(i4 % 2 != 0 ? "" : ":");
                        sb.append((char) ((iAbs3 / 10) + 48));
                        sb.append((char) ((iAbs3 % 10) + 48));
                        iAbs += iAbs3;
                    }
                }
                if (iAbs == 0) {
                    sb.setLength(length);
                    sb.append(this.f7855c);
                }
            }
            return true;
        }

        public String toString() {
            String strReplace = this.f7855c.replace("'", "''");
            StringBuilder sbA = j$.com.android.tools.r8.a.a("Offset(");
            sbA.append(a[this.f7856d]);
            sbA.append(",'");
            sbA.append(strReplace);
            sbA.append("')");
            return sbA.toString();
        }
    }

    enum i implements d {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            return true;
        }

        @Override // java.lang.Enum
        public String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (iOrdinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (iOrdinal == 2) {
                return "ParseStrict(true)";
            }
            if (iOrdinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    static final class j implements d {
        private final String a;

        j(String str) {
            this.a = str;
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            sb.append(this.a);
            return true;
        }

        public String toString() {
            return "'" + this.a.replace("'", "''") + "'";
        }
    }

    static final class k implements d {
        private final j$.time.temporal.l a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final j$.time.format.j f7857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final j$.time.format.f f7858c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile g f7859d;

        k(j$.time.temporal.l lVar, j$.time.format.j jVar, j$.time.format.f fVar) {
            this.a = lVar;
            this.f7857b = jVar;
            this.f7858c = fVar;
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            String strA;
            j$.time.chrono.i iVar;
            Long lE = eVar.e(this.a);
            if (lE == null) {
                return false;
            }
            j$.time.temporal.k kVarD = eVar.d();
            int i2 = m.a;
            j$.time.chrono.h hVar = (j$.time.chrono.h) kVarD.n(j$.time.temporal.b.a);
            if (hVar == null || hVar == (iVar = j$.time.chrono.i.a)) {
                j$.time.format.f fVar = this.f7858c;
                long jLongValue = lE.longValue();
                j$.time.format.j jVar = this.f7857b;
                eVar.c();
                strA = ((a) fVar).f7844c.a(jLongValue, jVar);
            } else {
                j$.time.format.f fVar2 = this.f7858c;
                j$.time.temporal.l lVar = this.a;
                long jLongValue2 = lE.longValue();
                j$.time.format.j jVar2 = this.f7857b;
                eVar.c();
                Objects.requireNonNull(fVar2);
                strA = (hVar == iVar || !(lVar instanceof j$.time.temporal.h)) ? ((a) fVar2).f7844c.a(jLongValue2, jVar2) : null;
            }
            if (strA != null) {
                sb.append(strA);
                return true;
            }
            if (this.f7859d == null) {
                this.f7859d = new g(this.a, 1, 19, j$.time.format.i.NORMAL);
            }
            return this.f7859d.h(eVar, sb);
        }

        public String toString() {
            StringBuilder sbA;
            Object obj;
            if (this.f7857b == j$.time.format.j.FULL) {
                sbA = j$.com.android.tools.r8.a.a("Text(");
                obj = this.a;
            } else {
                sbA = j$.com.android.tools.r8.a.a("Text(");
                sbA.append(this.a);
                sbA.append(",");
                obj = this.f7857b;
            }
            sbA.append(obj);
            sbA.append(")");
            return sbA.toString();
        }
    }

    static class l implements d {
        l(n nVar, String str) {
        }

        @Override // j$.time.format.c.d
        public boolean h(j$.time.format.e eVar, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) eVar.f(j$.time.format.a.a);
            if (zoneId == null) {
                return false;
            }
            sb.append(zoneId.g());
            return true;
        }

        public String toString() {
            return "ZoneRegionId()";
        }
    }

    static {
        HashMap map = new HashMap();
        map.put('G', j$.time.temporal.h.ERA);
        map.put('y', j$.time.temporal.h.YEAR_OF_ERA);
        map.put('u', j$.time.temporal.h.YEAR);
        j$.time.temporal.l lVar = j$.time.temporal.j.a;
        map.put('Q', lVar);
        map.put('q', lVar);
        j$.time.temporal.h hVar = j$.time.temporal.h.MONTH_OF_YEAR;
        map.put('M', hVar);
        map.put('L', hVar);
        map.put('D', j$.time.temporal.h.DAY_OF_YEAR);
        map.put('d', j$.time.temporal.h.DAY_OF_MONTH);
        map.put('F', j$.time.temporal.h.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.h hVar2 = j$.time.temporal.h.DAY_OF_WEEK;
        map.put('E', hVar2);
        map.put('c', hVar2);
        map.put('e', hVar2);
        map.put('a', j$.time.temporal.h.AMPM_OF_DAY);
        map.put('H', j$.time.temporal.h.HOUR_OF_DAY);
        map.put('k', j$.time.temporal.h.CLOCK_HOUR_OF_DAY);
        map.put('K', j$.time.temporal.h.HOUR_OF_AMPM);
        map.put('h', j$.time.temporal.h.CLOCK_HOUR_OF_AMPM);
        map.put('m', j$.time.temporal.h.MINUTE_OF_HOUR);
        map.put('s', j$.time.temporal.h.SECOND_OF_MINUTE);
        j$.time.temporal.h hVar3 = j$.time.temporal.h.NANO_OF_SECOND;
        map.put('S', hVar3);
        map.put('A', j$.time.temporal.h.MILLI_OF_DAY);
        map.put('n', hVar3);
        map.put('N', j$.time.temporal.h.NANO_OF_DAY);
    }

    public c() {
        this.f7839b = this;
        this.f7841d = new ArrayList();
        this.f7843f = -1;
        this.f7840c = null;
        this.f7842e = false;
    }

    private c(c cVar, boolean z) {
        this.f7839b = this;
        this.f7841d = new ArrayList();
        this.f7843f = -1;
        this.f7840c = cVar;
        this.f7842e = z;
    }

    private int d(d dVar) {
        Objects.requireNonNull(dVar, "pp");
        c cVar = this.f7839b;
        Objects.requireNonNull(cVar);
        cVar.f7841d.add(dVar);
        this.f7839b.f7843f = -1;
        return r2.f7841d.size() - 1;
    }

    private c j(g gVar) {
        g gVarB;
        c cVar = this.f7839b;
        int i2 = cVar.f7843f;
        if (i2 >= 0) {
            g gVar2 = (g) cVar.f7841d.get(i2);
            if (gVar.f7850c == gVar.f7851d && gVar.f7852e == j$.time.format.i.NOT_NEGATIVE) {
                gVarB = gVar2.c(gVar.f7851d);
                d(gVar.b());
                this.f7839b.f7843f = i2;
            } else {
                gVarB = gVar2.b();
                this.f7839b.f7843f = d(gVar);
            }
            this.f7839b.f7841d.set(i2, gVarB);
        } else {
            cVar.f7843f = d(gVar);
        }
        return this;
    }

    public c a(j$.time.format.b bVar) {
        d(bVar.f(false));
        return this;
    }

    public c b(j$.time.temporal.l lVar, int i2, int i3, boolean z) {
        d(new e(lVar, i2, i3, z));
        return this;
    }

    public c c() {
        d(new f(-2));
        return this;
    }

    public c e(char c2) {
        d(new b(c2));
        return this;
    }

    public c f(String str) {
        if (str.length() > 0) {
            d(str.length() == 1 ? new b(str.charAt(0)) : new j(str));
        }
        return this;
    }

    public c g(String str, String str2) {
        d(new h(str, str2));
        return this;
    }

    public c h() {
        d(h.f7854b);
        return this;
    }

    public c i(j$.time.temporal.l lVar, Map map) {
        Objects.requireNonNull(lVar, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        j$.time.format.j jVar = j$.time.format.j.FULL;
        d(new k(lVar, jVar, new a(this, new f.b(Collections.singletonMap(jVar, linkedHashMap)))));
        return this;
    }

    public c k(j$.time.temporal.l lVar, int i2) {
        Objects.requireNonNull(lVar, "field");
        if (i2 >= 1 && i2 <= 19) {
            j(new g(lVar, i2, i2, j$.time.format.i.NOT_NEGATIVE));
            return this;
        }
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i2);
    }

    public c l(j$.time.temporal.l lVar, int i2, int i3, j$.time.format.i iVar) {
        if (i2 == i3 && iVar == j$.time.format.i.NOT_NEGATIVE) {
            k(lVar, i3);
            return this;
        }
        Objects.requireNonNull(lVar, "field");
        Objects.requireNonNull(iVar, "signStyle");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i2);
        }
        if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i3);
        }
        if (i3 >= i2) {
            j(new g(lVar, i2, i3, iVar));
            return this;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
    }

    public c m() {
        d(new l(j$.time.format.a.a, "ZoneRegionId()"));
        return this;
    }

    public c n() {
        c cVar = this.f7839b;
        if (cVar.f7840c == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (cVar.f7841d.size() > 0) {
            c cVar2 = this.f7839b;
            C0217c c0217c = new C0217c(cVar2.f7841d, cVar2.f7842e);
            this.f7839b = this.f7839b.f7840c;
            d(c0217c);
        } else {
            this.f7839b = this.f7839b.f7840c;
        }
        return this;
    }

    public c o() {
        c cVar = this.f7839b;
        cVar.f7843f = -1;
        this.f7839b = new c(cVar, true);
        return this;
    }

    public c p() {
        d(i.INSENSITIVE);
        return this;
    }

    public c q() {
        d(i.SENSITIVE);
        return this;
    }

    public c r() {
        d(i.LENIENT);
        return this;
    }

    j$.time.format.b s(j$.time.format.h hVar, j$.time.chrono.h hVar2) {
        Locale locale = Locale.getDefault();
        Objects.requireNonNull(locale, "locale");
        while (this.f7839b.f7840c != null) {
            n();
        }
        return new j$.time.format.b(new C0217c(this.f7841d, false), locale, j$.time.format.g.a, hVar, null, hVar2, null);
    }
}
