package j$.time.temporal;

import androidx.recyclerview.widget.RecyclerView;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NANO_OF_SECOND' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements l {
    public static final h ALIGNED_DAY_OF_WEEK_IN_MONTH;
    public static final h ALIGNED_DAY_OF_WEEK_IN_YEAR;
    public static final h ALIGNED_WEEK_OF_MONTH;
    public static final h ALIGNED_WEEK_OF_YEAR;
    public static final h AMPM_OF_DAY;
    public static final h CLOCK_HOUR_OF_AMPM;
    public static final h CLOCK_HOUR_OF_DAY;
    public static final h DAY_OF_MONTH;
    public static final h DAY_OF_WEEK;
    public static final h DAY_OF_YEAR;
    public static final h EPOCH_DAY;
    public static final h ERA;
    public static final h HOUR_OF_AMPM;
    public static final h HOUR_OF_DAY;
    public static final h INSTANT_SECONDS;
    public static final h MICRO_OF_DAY;
    public static final h MICRO_OF_SECOND;
    public static final h MILLI_OF_DAY;
    public static final h MILLI_OF_SECOND;
    public static final h MINUTE_OF_DAY;
    public static final h MINUTE_OF_HOUR;
    public static final h MONTH_OF_YEAR;
    public static final h NANO_OF_DAY;
    public static final h NANO_OF_SECOND;
    public static final h OFFSET_SECONDS;
    public static final h PROLEPTIC_MONTH;
    public static final h SECOND_OF_DAY;
    public static final h SECOND_OF_MINUTE;
    public static final h YEAR;
    public static final h YEAR_OF_ERA;
    private static final /* synthetic */ h[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f7890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final o f7891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f7892e;

    static {
        i iVar = i.NANOS;
        i iVar2 = i.SECONDS;
        h hVar = new h("NANO_OF_SECOND", 0, "NanoOfSecond", iVar, iVar2, q.i(0L, 999999999L));
        NANO_OF_SECOND = hVar;
        i iVar3 = i.DAYS;
        h hVar2 = new h("NANO_OF_DAY", 1, "NanoOfDay", iVar, iVar3, q.i(0L, 86399999999999L));
        NANO_OF_DAY = hVar2;
        i iVar4 = i.MICROS;
        h hVar3 = new h("MICRO_OF_SECOND", 2, "MicroOfSecond", iVar4, iVar2, q.i(0L, 999999L));
        MICRO_OF_SECOND = hVar3;
        h hVar4 = new h("MICRO_OF_DAY", 3, "MicroOfDay", iVar4, iVar3, q.i(0L, 86399999999L));
        MICRO_OF_DAY = hVar4;
        i iVar5 = i.MILLIS;
        h hVar5 = new h("MILLI_OF_SECOND", 4, "MilliOfSecond", iVar5, iVar2, q.i(0L, 999L));
        MILLI_OF_SECOND = hVar5;
        h hVar6 = new h("MILLI_OF_DAY", 5, "MilliOfDay", iVar5, iVar3, q.i(0L, 86399999L));
        MILLI_OF_DAY = hVar6;
        i iVar6 = i.MINUTES;
        h hVar7 = new h("SECOND_OF_MINUTE", 6, "SecondOfMinute", iVar2, iVar6, q.i(0L, 59L), "second");
        SECOND_OF_MINUTE = hVar7;
        h hVar8 = new h("SECOND_OF_DAY", 7, "SecondOfDay", iVar2, iVar3, q.i(0L, 86399L));
        SECOND_OF_DAY = hVar8;
        i iVar7 = i.HOURS;
        h hVar9 = new h("MINUTE_OF_HOUR", 8, "MinuteOfHour", iVar6, iVar7, q.i(0L, 59L), "minute");
        MINUTE_OF_HOUR = hVar9;
        h hVar10 = new h("MINUTE_OF_DAY", 9, "MinuteOfDay", iVar6, iVar3, q.i(0L, 1439L));
        MINUTE_OF_DAY = hVar10;
        i iVar8 = i.HALF_DAYS;
        h hVar11 = new h("HOUR_OF_AMPM", 10, "HourOfAmPm", iVar7, iVar8, q.i(0L, 11L));
        HOUR_OF_AMPM = hVar11;
        h hVar12 = new h("CLOCK_HOUR_OF_AMPM", 11, "ClockHourOfAmPm", iVar7, iVar8, q.i(1L, 12L));
        CLOCK_HOUR_OF_AMPM = hVar12;
        h hVar13 = new h("HOUR_OF_DAY", 12, "HourOfDay", iVar7, iVar3, q.i(0L, 23L), "hour");
        HOUR_OF_DAY = hVar13;
        h hVar14 = new h("CLOCK_HOUR_OF_DAY", 13, "ClockHourOfDay", iVar7, iVar3, q.i(1L, 24L));
        CLOCK_HOUR_OF_DAY = hVar14;
        h hVar15 = new h("AMPM_OF_DAY", 14, "AmPmOfDay", iVar8, iVar3, q.i(0L, 1L), "dayperiod");
        AMPM_OF_DAY = hVar15;
        i iVar9 = i.WEEKS;
        h hVar16 = new h("DAY_OF_WEEK", 15, "DayOfWeek", iVar3, iVar9, q.i(1L, 7L), "weekday");
        DAY_OF_WEEK = hVar16;
        h hVar17 = new h("ALIGNED_DAY_OF_WEEK_IN_MONTH", 16, "AlignedDayOfWeekInMonth", iVar3, iVar9, q.i(1L, 7L));
        ALIGNED_DAY_OF_WEEK_IN_MONTH = hVar17;
        h hVar18 = new h("ALIGNED_DAY_OF_WEEK_IN_YEAR", 17, "AlignedDayOfWeekInYear", iVar3, iVar9, q.i(1L, 7L));
        ALIGNED_DAY_OF_WEEK_IN_YEAR = hVar18;
        i iVar10 = i.MONTHS;
        h hVar19 = new h("DAY_OF_MONTH", 18, "DayOfMonth", iVar3, iVar10, q.j(1L, 28L, 31L), "day");
        DAY_OF_MONTH = hVar19;
        i iVar11 = i.YEARS;
        h hVar20 = new h("DAY_OF_YEAR", 19, "DayOfYear", iVar3, iVar11, q.j(1L, 365L, 366L));
        DAY_OF_YEAR = hVar20;
        i iVar12 = i.FOREVER;
        h hVar21 = new h("EPOCH_DAY", 20, "EpochDay", iVar3, iVar12, q.i(-365249999634L, 365249999634L));
        EPOCH_DAY = hVar21;
        h hVar22 = new h("ALIGNED_WEEK_OF_MONTH", 21, "AlignedWeekOfMonth", iVar9, iVar10, q.j(1L, 4L, 5L));
        ALIGNED_WEEK_OF_MONTH = hVar22;
        h hVar23 = new h("ALIGNED_WEEK_OF_YEAR", 22, "AlignedWeekOfYear", iVar9, iVar11, q.i(1L, 53L));
        ALIGNED_WEEK_OF_YEAR = hVar23;
        h hVar24 = new h("MONTH_OF_YEAR", 23, "MonthOfYear", iVar10, iVar11, q.i(1L, 12L), "month");
        MONTH_OF_YEAR = hVar24;
        h hVar25 = new h("PROLEPTIC_MONTH", 24, "ProlepticMonth", iVar10, iVar12, q.i(-11999999988L, 11999999999L));
        PROLEPTIC_MONTH = hVar25;
        h hVar26 = new h("YEAR_OF_ERA", 25, "YearOfEra", iVar11, iVar12, q.j(1L, 999999999L, 1000000000L));
        YEAR_OF_ERA = hVar26;
        h hVar27 = new h("YEAR", 26, "Year", iVar11, iVar12, q.i(-999999999L, 999999999L), "year");
        YEAR = hVar27;
        h hVar28 = new h("ERA", 27, "Era", i.ERAS, iVar12, q.i(0L, 1L), "era");
        ERA = hVar28;
        h hVar29 = new h("INSTANT_SECONDS", 28, "InstantSeconds", iVar2, iVar12, q.i(Long.MIN_VALUE, RecyclerView.FOREVER_NS));
        INSTANT_SECONDS = hVar29;
        h hVar30 = new h("OFFSET_SECONDS", 29, "OffsetSeconds", iVar2, iVar12, q.i(-64800L, 64800L));
        OFFSET_SECONDS = hVar30;
        a = new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11, hVar12, hVar13, hVar14, hVar15, hVar16, hVar17, hVar18, hVar19, hVar20, hVar21, hVar22, hVar23, hVar24, hVar25, hVar26, hVar27, hVar28, hVar29, hVar30};
    }

    private h(String str, int i2, String str2, o oVar, o oVar2, q qVar) {
        this.f7889b = str2;
        this.f7890c = oVar;
        this.f7891d = oVar2;
        this.f7892e = qVar;
    }

    private h(String str, int i2, String str2, o oVar, o oVar2, q qVar, String str3) {
        this.f7889b = str2;
        this.f7890c = oVar;
        this.f7891d = oVar2;
        this.f7892e = qVar;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) a.clone();
    }

    @Override // j$.time.temporal.l
    public q h() {
        return this.f7892e;
    }

    @Override // j$.time.temporal.l
    public boolean j() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    @Override // j$.time.temporal.l
    public long l(k kVar) {
        return kVar.l(this);
    }

    @Override // j$.time.temporal.l
    public boolean n(k kVar) {
        return kVar.d(this);
    }

    @Override // j$.time.temporal.l
    public q t(k kVar) {
        return kVar.j(this);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f7889b;
    }

    @Override // j$.time.temporal.l
    public boolean v() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    public int w(long j2) {
        return this.f7892e.a(j2, this);
    }

    public long x(long j2) {
        this.f7892e.b(j2, this);
        return j2;
    }
}
