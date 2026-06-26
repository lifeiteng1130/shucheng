package j$.time.format;

import j$.time.ZoneId;
import j$.time.format.c;
import j$.time.temporal.k;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.C0217c f7834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Locale f7835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f7836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j$.time.chrono.h f7837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ZoneId f7838f;

    static {
        c cVar = new c();
        j$.time.temporal.h hVar = j$.time.temporal.h.YEAR;
        i iVar = i.EXCEEDS_PAD;
        c cVarL = cVar.l(hVar, 4, 10, iVar);
        cVarL.e('-');
        j$.time.temporal.h hVar2 = j$.time.temporal.h.MONTH_OF_YEAR;
        cVarL.k(hVar2, 2);
        cVarL.e('-');
        j$.time.temporal.h hVar3 = j$.time.temporal.h.DAY_OF_MONTH;
        cVarL.k(hVar3, 2);
        h hVar4 = h.STRICT;
        j$.time.chrono.i iVar2 = j$.time.chrono.i.a;
        b bVarS = cVarL.s(hVar4, iVar2);
        c cVar2 = new c();
        cVar2.p();
        cVar2.a(bVarS);
        cVar2.h();
        cVar2.s(hVar4, iVar2);
        c cVar3 = new c();
        cVar3.p();
        cVar3.a(bVarS);
        cVar3.o();
        cVar3.h();
        cVar3.s(hVar4, iVar2);
        c cVar4 = new c();
        j$.time.temporal.h hVar5 = j$.time.temporal.h.HOUR_OF_DAY;
        cVar4.k(hVar5, 2);
        cVar4.e(':');
        j$.time.temporal.h hVar6 = j$.time.temporal.h.MINUTE_OF_HOUR;
        cVar4.k(hVar6, 2);
        cVar4.o();
        cVar4.e(':');
        j$.time.temporal.h hVar7 = j$.time.temporal.h.SECOND_OF_MINUTE;
        cVar4.k(hVar7, 2);
        cVar4.o();
        cVar4.b(j$.time.temporal.h.NANO_OF_SECOND, 0, 9, true);
        b bVarS2 = cVar4.s(hVar4, null);
        c cVar5 = new c();
        cVar5.p();
        cVar5.a(bVarS2);
        cVar5.h();
        cVar5.s(hVar4, null);
        c cVar6 = new c();
        cVar6.p();
        cVar6.a(bVarS2);
        cVar6.o();
        cVar6.h();
        cVar6.s(hVar4, null);
        c cVar7 = new c();
        cVar7.p();
        cVar7.a(bVarS);
        cVar7.e('T');
        cVar7.a(bVarS2);
        b bVarS3 = cVar7.s(hVar4, iVar2);
        c cVar8 = new c();
        cVar8.p();
        cVar8.a(bVarS3);
        cVar8.h();
        b bVarS4 = cVar8.s(hVar4, iVar2);
        c cVar9 = new c();
        cVar9.a(bVarS4);
        cVar9.o();
        cVar9.e('[');
        cVar9.q();
        cVar9.m();
        cVar9.e(']');
        cVar9.s(hVar4, iVar2);
        c cVar10 = new c();
        cVar10.a(bVarS3);
        cVar10.o();
        cVar10.h();
        cVar10.o();
        cVar10.e('[');
        cVar10.q();
        cVar10.m();
        cVar10.e(']');
        cVar10.s(hVar4, iVar2);
        c cVar11 = new c();
        cVar11.p();
        c cVarL2 = cVar11.l(hVar, 4, 10, iVar);
        cVarL2.e('-');
        cVarL2.k(j$.time.temporal.h.DAY_OF_YEAR, 3);
        cVarL2.o();
        cVarL2.h();
        cVarL2.s(hVar4, iVar2);
        c cVar12 = new c();
        cVar12.p();
        c cVarL3 = cVar12.l(j$.time.temporal.j.f7895c, 4, 10, iVar);
        cVarL3.f("-W");
        cVarL3.k(j$.time.temporal.j.f7894b, 2);
        cVarL3.e('-');
        j$.time.temporal.h hVar8 = j$.time.temporal.h.DAY_OF_WEEK;
        cVarL3.k(hVar8, 1);
        cVarL3.o();
        cVarL3.h();
        cVarL3.s(hVar4, iVar2);
        c cVar13 = new c();
        cVar13.p();
        cVar13.c();
        a = cVar13.s(hVar4, null);
        c cVar14 = new c();
        cVar14.p();
        cVar14.k(hVar, 4);
        cVar14.k(hVar2, 2);
        cVar14.k(hVar3, 2);
        cVar14.o();
        cVar14.g("+HHMMss", "Z");
        cVar14.s(hVar4, iVar2);
        HashMap map = new HashMap();
        map.put(1L, "Mon");
        map.put(2L, "Tue");
        map.put(3L, "Wed");
        map.put(4L, "Thu");
        map.put(5L, "Fri");
        map.put(6L, "Sat");
        map.put(7L, "Sun");
        HashMap map2 = new HashMap();
        map2.put(1L, "Jan");
        map2.put(2L, "Feb");
        map2.put(3L, "Mar");
        map2.put(4L, "Apr");
        map2.put(5L, "May");
        map2.put(6L, "Jun");
        map2.put(7L, "Jul");
        map2.put(8L, "Aug");
        map2.put(9L, "Sep");
        map2.put(10L, "Oct");
        map2.put(11L, "Nov");
        map2.put(12L, "Dec");
        c cVar15 = new c();
        cVar15.p();
        cVar15.r();
        cVar15.o();
        cVar15.i(hVar8, map);
        cVar15.f(", ");
        cVar15.n();
        c cVarL4 = cVar15.l(hVar3, 1, 2, i.NOT_NEGATIVE);
        cVarL4.e(' ');
        cVarL4.i(hVar2, map2);
        cVarL4.e(' ');
        cVarL4.k(hVar, 4);
        cVarL4.e(' ');
        cVarL4.k(hVar5, 2);
        cVarL4.e(':');
        cVarL4.k(hVar6, 2);
        cVarL4.o();
        cVarL4.e(':');
        cVarL4.k(hVar7, 2);
        cVarL4.n();
        cVarL4.e(' ');
        cVarL4.g("+HHMM", "GMT");
        cVarL4.s(h.SMART, iVar2);
    }

    b(c.C0217c c0217c, Locale locale, g gVar, h hVar, Set set, j$.time.chrono.h hVar2, ZoneId zoneId) {
        this.f7834b = c0217c;
        this.f7835c = locale;
        this.f7836d = gVar;
        Objects.requireNonNull(hVar, "resolverStyle");
        this.f7837e = hVar2;
        this.f7838f = null;
    }

    public String a(k kVar) {
        StringBuilder sb = new StringBuilder(32);
        try {
            this.f7834b.h(new e(kVar, this), sb);
            return sb.toString();
        } catch (IOException e2) {
            throw new j$.time.c(e2.getMessage(), e2);
        }
    }

    public j$.time.chrono.h b() {
        return this.f7837e;
    }

    public g c() {
        return this.f7836d;
    }

    public Locale d() {
        return this.f7835c;
    }

    public ZoneId e() {
        return this.f7838f;
    }

    c.C0217c f(boolean z) {
        return this.f7834b.a(z);
    }

    public String toString() {
        String string = this.f7834b.toString();
        return string.startsWith("[") ? string : string.substring(1, string.length() - 1);
    }
}
