package j$.time.zone;

import androidx.recyclerview.widget.RecyclerView;
import j$.time.Instant;
import j$.time.f;
import j$.time.j;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Serializable {
    private static final long[] a = new long[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b[] f7903b = new b[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f[] f7904c = new f[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a[] f7905d = new a[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long[] f7906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j[] f7907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long[] f7908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final j[] f7909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final b[] f7910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TimeZone f7911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final transient ConcurrentMap f7912k = new ConcurrentHashMap();

    private c(j jVar) {
        j[] jVarArr = {jVar};
        this.f7907f = jVarArr;
        long[] jArr = a;
        this.f7906e = jArr;
        this.f7908g = jArr;
        this.f7909h = jVarArr;
        this.f7910i = f7903b;
        this.f7911j = null;
    }

    c(TimeZone timeZone) {
        j[] jVarArr = {f(timeZone.getRawOffset())};
        this.f7907f = jVarArr;
        long[] jArr = a;
        this.f7906e = jArr;
        this.f7908g = jArr;
        this.f7909h = jVarArr;
        this.f7910i = f7903b;
        this.f7911j = timeZone;
    }

    private a[] a(int i2) {
        long j2;
        long j3;
        Integer numValueOf = Integer.valueOf(i2);
        a[] aVarArr = (a[]) this.f7912k.get(numValueOf);
        if (aVarArr != null) {
            return aVarArr;
        }
        if (this.f7911j == null) {
            b[] bVarArr = this.f7910i;
            a[] aVarArr2 = new a[bVarArr.length];
            if (bVarArr.length > 0) {
                Objects.requireNonNull(bVarArr[0]);
                throw null;
            }
            if (i2 < 2100) {
                this.f7912k.putIfAbsent(numValueOf, aVarArr2);
            }
            return aVarArr2;
        }
        if (i2 < 1800) {
            return f7905d;
        }
        long jL = j$.time.a.l(f.y(i2 - 1, 12, 31, 0, 0), this.f7907f[0]);
        long j4 = 1000;
        int offset = this.f7911j.getOffset(jL * 1000);
        long j5 = 31968000 + jL;
        a[] aVarArr3 = f7905d;
        while (jL < j5) {
            long j6 = 7776000 + jL;
            long j7 = jL;
            if (offset != this.f7911j.getOffset(j6 * j4)) {
                jL = j7;
                while (j6 - jL > 1) {
                    long j8 = j5;
                    long jY = j$.time.a.y(j6 + jL, 2L);
                    long j9 = j6;
                    if (this.f7911j.getOffset(jY * 1000) == offset) {
                        jL = jY;
                        j6 = j9;
                    } else {
                        j6 = jY;
                    }
                    j4 = 1000;
                    j5 = j8;
                }
                j2 = j5;
                long j10 = j6;
                j3 = j4;
                if (this.f7911j.getOffset(jL * j3) == offset) {
                    jL = j10;
                }
                j jVarF = f(offset);
                int offset2 = this.f7911j.getOffset(jL * j3);
                j jVarF2 = f(offset2);
                if (b(jL, jVarF2) == i2) {
                    a[] aVarArr4 = (a[]) Arrays.copyOf(aVarArr3, aVarArr3.length + 1);
                    aVarArr4[aVarArr4.length - 1] = new a(jL, jVarF, jVarF2);
                    offset = offset2;
                    aVarArr3 = aVarArr4;
                } else {
                    offset = offset2;
                }
            } else {
                j2 = j5;
                j3 = j4;
                jL = j6;
            }
            j4 = j3;
            j5 = j2;
        }
        if (1916 <= i2 && i2 < 2100) {
            this.f7912k.putIfAbsent(numValueOf, aVarArr3);
        }
        return aVarArr3;
    }

    private int b(long j2, j jVar) {
        return j$.time.e.C(j$.time.a.y(j2 + ((long) jVar.y()), 86400L)).z();
    }

    public static c e(j jVar) {
        return new c(jVar);
    }

    private static j f(int i2) {
        return j.B(i2 / 1000);
    }

    public j c(Instant instant) {
        TimeZone timeZone = this.f7911j;
        if (timeZone != null) {
            return f(timeZone.getOffset(instant.toEpochMilli()));
        }
        if (this.f7908g.length == 0) {
            return this.f7907f[0];
        }
        long jW = instant.w();
        if (this.f7910i.length > 0) {
            if (jW > this.f7908g[r8.length - 1]) {
                a[] aVarArrA = a(b(jW, this.f7909h[r8.length - 1]));
                a aVar = null;
                for (int i2 = 0; i2 < aVarArrA.length; i2++) {
                    aVar = aVarArrA[i2];
                    if (jW < aVar.u()) {
                        return aVar.l();
                    }
                }
                return aVar.j();
            }
        }
        int iBinarySearch = Arrays.binarySearch(this.f7908g, jW);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return this.f7909h[iBinarySearch + 1];
    }

    public boolean d() {
        TimeZone timeZone = this.f7911j;
        if (timeZone == null) {
            return this.f7908g.length == 0;
        }
        if (timeZone.useDaylightTime() || this.f7911j.getDSTSavings() != 0) {
            return false;
        }
        Instant instant = Instant.a;
        j jVar = j.f7880d;
        Instant instantY = Instant.y(System.currentTimeMillis());
        a aVar = null;
        if (this.f7911j != null) {
            long jW = instantY.w();
            if (instantY.x() > 0 && jW < RecyclerView.FOREVER_NS) {
                jW++;
            }
            int iB = b(jW, c(instantY));
            a[] aVarArrA = a(iB);
            int length = aVarArrA.length - 1;
            while (true) {
                if (length >= 0) {
                    if (jW > aVarArrA[length].u()) {
                        aVar = aVarArrA[length];
                        break;
                    }
                    length--;
                } else if (iB > 1800) {
                    a[] aVarArrA2 = a(iB - 1);
                    int length2 = aVarArrA2.length - 1;
                    while (true) {
                        if (length2 < 0) {
                            long jMin = Math.min(jW - 31104000, (j$.time.b.b().a() / 1000) + 31968000);
                            int offset = this.f7911j.getOffset((jW - 1) * 1000);
                            long jM = j$.time.e.B(1800, 1, 1).m() * 86400;
                            while (true) {
                                if (jM > jMin) {
                                    break;
                                }
                                int offset2 = this.f7911j.getOffset(jMin * 1000);
                                if (offset != offset2) {
                                    int iB2 = b(jMin, f(offset2));
                                    a[] aVarArrA3 = a(iB2 + 1);
                                    int length3 = aVarArrA3.length - 1;
                                    while (true) {
                                        if (length3 < 0) {
                                            a[] aVarArrA4 = a(iB2);
                                            aVar = aVarArrA4[aVarArrA4.length - 1];
                                            break;
                                        }
                                        if (jW > aVarArrA3[length3].u()) {
                                            aVar = aVarArrA3[length3];
                                            break;
                                        }
                                        length3--;
                                    }
                                } else {
                                    jMin -= 7776000;
                                }
                            }
                        } else {
                            if (jW > aVarArrA2[length2].u()) {
                                aVar = aVarArrA2[length2];
                                break;
                            }
                            length2--;
                        }
                    }
                }
            }
        } else if (this.f7908g.length != 0) {
            long jW2 = instantY.w();
            if (instantY.x() > 0 && jW2 < RecyclerView.FOREVER_NS) {
                jW2++;
            }
            long[] jArr = this.f7908g;
            long j2 = jArr[jArr.length - 1];
            if (this.f7910i.length <= 0 || jW2 <= j2) {
                int iBinarySearch = Arrays.binarySearch(this.f7908g, jW2);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                if (iBinarySearch > 0) {
                    int i2 = iBinarySearch - 1;
                    long j3 = this.f7908g[i2];
                    j[] jVarArr = this.f7909h;
                    aVar = new a(j3, jVarArr[i2], jVarArr[iBinarySearch]);
                }
            } else {
                j[] jVarArr2 = this.f7909h;
                j jVar2 = jVarArr2[jVarArr2.length - 1];
                int iB3 = b(jW2, jVar2);
                a[] aVarArrA5 = a(iB3);
                int length4 = aVarArrA5.length - 1;
                while (true) {
                    if (length4 < 0) {
                        int i3 = iB3 - 1;
                        if (i3 > b(j2, jVar2)) {
                            a[] aVarArrA6 = a(i3);
                            aVar = aVarArrA6[aVarArrA6.length - 1];
                        }
                    } else {
                        if (jW2 > aVarArrA5[length4].u()) {
                            aVar = aVarArrA5[length4];
                            break;
                        }
                        length4--;
                    }
                }
            }
        }
        return aVar == null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return j$.time.a.u(this.f7911j, cVar.f7911j) && Arrays.equals(this.f7906e, cVar.f7906e) && Arrays.equals(this.f7907f, cVar.f7907f) && Arrays.equals(this.f7908g, cVar.f7908g) && Arrays.equals(this.f7909h, cVar.f7909h) && Arrays.equals(this.f7910i, cVar.f7910i);
    }

    public int hashCode() {
        TimeZone timeZone = this.f7911j;
        return (((((timeZone != null ? timeZone.hashCode() : 0) ^ Arrays.hashCode(this.f7906e)) ^ Arrays.hashCode(this.f7907f)) ^ Arrays.hashCode(this.f7908g)) ^ Arrays.hashCode(this.f7909h)) ^ Arrays.hashCode(this.f7910i);
    }

    public String toString() {
        StringBuilder sbA;
        if (this.f7911j != null) {
            sbA = j$.com.android.tools.r8.a.a("ZoneRules[timeZone=");
            sbA.append(this.f7911j.getID());
        } else {
            sbA = j$.com.android.tools.r8.a.a("ZoneRules[currentStandardOffset=");
            sbA.append(this.f7907f[r2.length - 1]);
        }
        sbA.append("]");
        return sbA.toString();
    }
}
