package org.mozilla.javascript;

import c.a.a.a.a;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDate extends IdScriptableObject {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ConstructorId_UTC = -1;
    private static final int ConstructorId_now = -3;
    private static final int ConstructorId_parse = -2;
    private static final double HalfTimeDomain = 8.64E15d;
    private static final double HoursPerDay = 24.0d;
    private static final int Id_constructor = 1;
    private static final int Id_getDate = 17;
    private static final int Id_getDay = 19;
    private static final int Id_getFullYear = 13;
    private static final int Id_getHours = 21;
    private static final int Id_getMilliseconds = 27;
    private static final int Id_getMinutes = 23;
    private static final int Id_getMonth = 15;
    private static final int Id_getSeconds = 25;
    private static final int Id_getTime = 11;
    private static final int Id_getTimezoneOffset = 29;
    private static final int Id_getUTCDate = 18;
    private static final int Id_getUTCDay = 20;
    private static final int Id_getUTCFullYear = 14;
    private static final int Id_getUTCHours = 22;
    private static final int Id_getUTCMilliseconds = 28;
    private static final int Id_getUTCMinutes = 24;
    private static final int Id_getUTCMonth = 16;
    private static final int Id_getUTCSeconds = 26;
    private static final int Id_getYear = 12;
    private static final int Id_setDate = 39;
    private static final int Id_setFullYear = 43;
    private static final int Id_setHours = 37;
    private static final int Id_setMilliseconds = 31;
    private static final int Id_setMinutes = 35;
    private static final int Id_setMonth = 41;
    private static final int Id_setSeconds = 33;
    private static final int Id_setTime = 30;
    private static final int Id_setUTCDate = 40;
    private static final int Id_setUTCFullYear = 44;
    private static final int Id_setUTCHours = 38;
    private static final int Id_setUTCMilliseconds = 32;
    private static final int Id_setUTCMinutes = 36;
    private static final int Id_setUTCMonth = 42;
    private static final int Id_setUTCSeconds = 34;
    private static final int Id_setYear = 45;
    private static final int Id_toDateString = 4;
    private static final int Id_toGMTString = 8;
    private static final int Id_toISOString = 46;
    private static final int Id_toJSON = 47;
    private static final int Id_toLocaleDateString = 7;
    private static final int Id_toLocaleString = 5;
    private static final int Id_toLocaleTimeString = 6;
    private static final int Id_toSource = 9;
    private static final int Id_toString = 2;
    private static final int Id_toTimeString = 3;
    private static final int Id_toUTCString = 8;
    private static final int Id_valueOf = 10;
    private static final double LocalTZA;
    private static final int MAXARGS = 7;
    private static final int MAX_PROTOTYPE_ID = 47;
    private static final double MinutesPerDay = 1440.0d;
    private static final double MinutesPerHour = 60.0d;
    private static final double SecondsPerDay = 86400.0d;
    private static final double SecondsPerHour = 3600.0d;
    private static final double SecondsPerMinute = 60.0d;
    private static final String js_NaN_date_str = "Invalid Date";
    private static final double msPerDay = 8.64E7d;
    private static final double msPerHour = 3600000.0d;
    private static final double msPerMinute = 60000.0d;
    private static final double msPerSecond = 1000.0d;
    private static final long serialVersionUID = -8307438915861678966L;
    private double date;
    private static final Object DATE_TAG = "Date";
    private static final TimeZone thisTimeZone = TimeZone.getDefault();
    private static final DateFormat timeZoneFormatter = new SimpleDateFormat("zzz");
    private static final DateFormat localeDateTimeFormatter = new SimpleDateFormat("MMMM d, yyyy h:mm:ss a z");
    private static final DateFormat localeDateFormatter = new SimpleDateFormat("MMMM d, yyyy");
    private static final DateFormat localeTimeFormatter = new SimpleDateFormat("h:mm:ss a z");

    static {
        LocalTZA = r0.getRawOffset();
    }

    private NativeDate() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int DateFromTime(double r3) {
        /*
            int r0 = YearFromTime(r3)
            double r3 = Day(r3)
            double r1 = (double) r0
            double r1 = DayFromYear(r1)
            double r3 = r3 - r1
            int r3 = (int) r3
            int r3 = r3 + (-59)
            r4 = 31
            if (r3 >= 0) goto L1f
            r0 = -28
            if (r3 >= r0) goto L1a
            int r3 = r3 + r4
        L1a:
            int r3 = r3 + 28
            int r3 = r3 + 1
            return r3
        L1f:
            boolean r0 = IsLeapYear(r0)
            if (r0 == 0) goto L2c
            if (r3 != 0) goto L2a
            r3 = 29
            return r3
        L2a:
            int r3 = r3 + (-1)
        L2c:
            int r0 = r3 / 30
            r1 = 275(0x113, float:3.85E-43)
            r2 = 30
            switch(r0) {
                case 0: goto L67;
                case 1: goto L5e;
                case 2: goto L5b;
                case 3: goto L56;
                case 4: goto L53;
                case 5: goto L4e;
                case 6: goto L49;
                case 7: goto L46;
                case 8: goto L41;
                case 9: goto L3e;
                case 10: goto L3a;
                default: goto L35;
            }
        L35:
            java.lang.RuntimeException r3 = org.mozilla.javascript.Kit.codeBug()
            throw r3
        L3a:
            int r3 = r3 - r1
            int r3 = r3 + 1
            return r3
        L3e:
            r4 = 275(0x113, float:3.85E-43)
            goto L60
        L41:
            r0 = 245(0xf5, float:3.43E-43)
            r4 = 245(0xf5, float:3.43E-43)
            goto L5e
        L46:
            r4 = 214(0xd6, float:3.0E-43)
            goto L60
        L49:
            r0 = 184(0xb8, float:2.58E-43)
            r4 = 184(0xb8, float:2.58E-43)
            goto L5e
        L4e:
            r0 = 153(0x99, float:2.14E-43)
            r4 = 153(0x99, float:2.14E-43)
            goto L5e
        L53:
            r4 = 122(0x7a, float:1.71E-43)
            goto L60
        L56:
            r0 = 92
            r4 = 92
            goto L5e
        L5b:
            r4 = 61
            goto L60
        L5e:
            r2 = 31
        L60:
            int r3 = r3 - r4
            if (r3 >= 0) goto L64
            int r3 = r3 + r2
        L64:
            int r3 = r3 + 1
            return r3
        L67:
            int r3 = r3 + 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.DateFromTime(double):int");
    }

    private static double Day(double d2) {
        return Math.floor(d2 / msPerDay);
    }

    private static double DayFromMonth(int i2, int i3) {
        int i4;
        int i5;
        int i6 = i2 * 30;
        if (i2 >= 7) {
            i5 = i2 / 2;
        } else {
            if (i2 < 2) {
                i4 = i6 + i2;
                if (i2 >= 2 && IsLeapYear(i3)) {
                    i4++;
                }
                return i4;
            }
            i5 = (i2 - 1) / 2;
        }
        i4 = (i5 - 1) + i6;
        if (i2 >= 2) {
            i4++;
        }
        return i4;
    }

    private static double DayFromYear(double d2) {
        return Math.floor((d2 - 1601.0d) / 400.0d) + ((Math.floor((d2 - 1969.0d) / 4.0d) + ((d2 - 1970.0d) * 365.0d)) - Math.floor((d2 - 1901.0d) / 100.0d));
    }

    private static double DaylightSavingTA(double d2) {
        if (d2 < 0.0d) {
            d2 = MakeDate(MakeDay(EquivalentYear(YearFromTime(d2)), MonthFromTime(d2), DateFromTime(d2)), TimeWithinDay(d2));
        }
        if (thisTimeZone.inDaylightTime(new Date((long) d2))) {
            return msPerHour;
        }
        return 0.0d;
    }

    private static int DaysInMonth(int i2, int i3) {
        return i3 == 2 ? IsLeapYear(i2) ? 29 : 28 : i3 >= 8 ? 31 - (i3 & 1) : (i3 & 1) + 30;
    }

    private static double DaysInYear(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            return Double.NaN;
        }
        return IsLeapYear((int) d2) ? 366.0d : 365.0d;
    }

    private static int EquivalentYear(int i2) {
        int iDayFromYear = (((int) DayFromYear(i2)) + 4) % 7;
        if (iDayFromYear < 0) {
            iDayFromYear += 7;
        }
        if (IsLeapYear(i2)) {
            switch (iDayFromYear) {
                case 0:
                    return 1984;
                case 1:
                    return 1996;
                case 2:
                    return 1980;
                case 3:
                    return 1992;
                case 4:
                    return 1976;
                case 5:
                    return 1988;
                case 6:
                    return 1972;
            }
        }
        switch (iDayFromYear) {
            case 0:
                return 1978;
            case 1:
                return 1973;
            case 2:
                return 1985;
            case 3:
                return 1986;
            case 4:
                return 1981;
            case 5:
                return 1971;
            case 6:
                return 1977;
        }
        throw Kit.codeBug();
    }

    private static int HourFromTime(double d2) {
        double dFloor = Math.floor(d2 / msPerHour) % HoursPerDay;
        if (dFloor < 0.0d) {
            dFloor += HoursPerDay;
        }
        return (int) dFloor;
    }

    private static boolean IsLeapYear(int i2) {
        return i2 % 4 == 0 && (i2 % 100 != 0 || i2 % TinkerReport.KEY_LOADED_SUCC_COST_500_LESS == 0);
    }

    private static double LocalTime(double d2) {
        return LocalTZA + d2 + DaylightSavingTA(d2);
    }

    private static double MakeDate(double d2, double d3) {
        return (d2 * msPerDay) + d3;
    }

    private static double MakeDay(double d2, double d3, double d4) {
        double dFloor = Math.floor(d3 / 12.0d) + d2;
        double d5 = d3 % 12.0d;
        if (d5 < 0.0d) {
            d5 += 12.0d;
        }
        return ((Math.floor(TimeFromYear(dFloor) / msPerDay) + DayFromMonth((int) d5, (int) dFloor)) + d4) - 1.0d;
    }

    private static double MakeTime(double d2, double d3, double d4, double d5) {
        return (((((d2 * 60.0d) + d3) * 60.0d) + d4) * msPerSecond) + d5;
    }

    private static int MinFromTime(double d2) {
        double dFloor = Math.floor(d2 / msPerMinute) % 60.0d;
        if (dFloor < 0.0d) {
            dFloor += 60.0d;
        }
        return (int) dFloor;
    }

    private static int MonthFromTime(double d2) {
        int i2;
        int iYearFromTime = YearFromTime(d2);
        int iDay = ((int) (Day(d2) - DayFromYear(iYearFromTime))) - 59;
        if (iDay < 0) {
            return iDay < -28 ? 0 : 1;
        }
        if (IsLeapYear(iYearFromTime)) {
            if (iDay == 0) {
                return 1;
            }
            iDay--;
        }
        int i3 = iDay / 30;
        switch (i3) {
            case 0:
                return 2;
            case 1:
                i2 = 31;
                break;
            case 2:
                i2 = 61;
                break;
            case 3:
                i2 = 92;
                break;
            case 4:
                i2 = 122;
                break;
            case 5:
                i2 = 153;
                break;
            case 6:
                i2 = TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT;
                break;
            case 7:
                i2 = 214;
                break;
            case 8:
                i2 = 245;
                break;
            case 9:
                i2 = 275;
                break;
            case 10:
                return 11;
            default:
                throw Kit.codeBug();
        }
        return iDay >= i2 ? i3 + 2 : i3 + 1;
    }

    private static int SecFromTime(double d2) {
        double dFloor = Math.floor(d2 / msPerSecond) % 60.0d;
        if (dFloor < 0.0d) {
            dFloor += 60.0d;
        }
        return (int) dFloor;
    }

    private static double TimeClip(double d2) {
        if (Double.isNaN(d2) || d2 == Double.POSITIVE_INFINITY || d2 == Double.NEGATIVE_INFINITY || Math.abs(d2) > HalfTimeDomain) {
            return Double.NaN;
        }
        return d2 > 0.0d ? Math.floor(d2 + 0.0d) : Math.ceil(d2 + 0.0d);
    }

    private static double TimeFromYear(double d2) {
        return DayFromYear(d2) * msPerDay;
    }

    private static double TimeWithinDay(double d2) {
        double d3 = d2 % msPerDay;
        return d3 < 0.0d ? d3 + msPerDay : d3;
    }

    private static int WeekDay(double d2) {
        double dDay = (Day(d2) + 4.0d) % 7.0d;
        if (dDay < 0.0d) {
            dDay += 7.0d;
        }
        return (int) dDay;
    }

    private static int YearFromTime(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            return 0;
        }
        double dFloor = Math.floor(d2 / 3.1556952E10d) + 1970.0d;
        double dTimeFromYear = TimeFromYear(dFloor);
        if (dTimeFromYear > d2) {
            dFloor -= 1.0d;
        } else if ((DaysInYear(dFloor) * msPerDay) + dTimeFromYear <= d2) {
            dFloor += 1.0d;
        }
        return (int) dFloor;
    }

    private static void append0PaddedUint(StringBuilder sb, int i2, int i3) {
        if (i2 < 0) {
            Kit.codeBug();
        }
        int i4 = i3 - 1;
        int i5 = 1000000000;
        if (i2 < 10) {
            i5 = 1;
        } else if (i2 < 1000000000) {
            i5 = 1;
            while (true) {
                int i6 = i5 * 10;
                if (i2 < i6) {
                    break;
                }
                i4--;
                i5 = i6;
            }
        } else {
            i4 -= 9;
        }
        while (i4 > 0) {
            sb.append('0');
            i4--;
        }
        while (i5 != 1) {
            sb.append((char) ((i2 / i5) + 48));
            i2 %= i5;
            i5 /= 10;
        }
        sb.append((char) (i2 + 48));
    }

    private static void appendMonthName(StringBuilder sb, int i2) {
        int i3 = i2 * 3;
        for (int i4 = 0; i4 != 3; i4++) {
            sb.append("JanFebMarAprMayJunJulAugSepOctNovDec".charAt(i3 + i4));
        }
    }

    private static void appendWeekDayName(StringBuilder sb, int i2) {
        int i3 = i2 * 3;
        for (int i4 = 0; i4 != 3; i4++) {
            sb.append("SunMonTueWedThuFriSat".charAt(i3 + i4));
        }
    }

    private static String date_format(double d2, int i2) {
        StringBuilder sb = new StringBuilder(60);
        double dLocalTime = LocalTime(d2);
        if (i2 != 3) {
            appendWeekDayName(sb, WeekDay(dLocalTime));
            sb.append(' ');
            appendMonthName(sb, MonthFromTime(dLocalTime));
            sb.append(' ');
            append0PaddedUint(sb, DateFromTime(dLocalTime), 2);
            sb.append(' ');
            int iYearFromTime = YearFromTime(dLocalTime);
            if (iYearFromTime < 0) {
                sb.append('-');
                iYearFromTime = -iYearFromTime;
            }
            append0PaddedUint(sb, iYearFromTime, 4);
            if (i2 != 4) {
                sb.append(' ');
            }
        }
        if (i2 != 4) {
            append0PaddedUint(sb, HourFromTime(dLocalTime), 2);
            sb.append(':');
            append0PaddedUint(sb, MinFromTime(dLocalTime), 2);
            sb.append(':');
            append0PaddedUint(sb, SecFromTime(dLocalTime), 2);
            int iFloor = (int) Math.floor((LocalTZA + DaylightSavingTA(d2)) / msPerMinute);
            int i3 = (iFloor % 60) + ((iFloor / 60) * 100);
            if (i3 > 0) {
                sb.append(" GMT+");
            } else {
                sb.append(" GMT-");
                i3 = -i3;
            }
            append0PaddedUint(sb, i3, 4);
            if (d2 < 0.0d) {
                d2 = MakeDate(MakeDay(EquivalentYear(YearFromTime(dLocalTime)), MonthFromTime(d2), DateFromTime(d2)), TimeWithinDay(d2));
            }
            sb.append(" (");
            Date date = new Date((long) d2);
            DateFormat dateFormat = timeZoneFormatter;
            synchronized (dateFormat) {
                sb.append(dateFormat.format(date));
            }
            sb.append(')');
        }
        return sb.toString();
    }

    private static double date_msecFromArgs(Object[] objArr) {
        double[] dArr = new double[7];
        for (int i2 = 0; i2 < 7; i2++) {
            if (i2 < objArr.length) {
                double number = ScriptRuntime.toNumber(objArr[i2]);
                if (Double.isNaN(number) || Double.isInfinite(number)) {
                    return Double.NaN;
                }
                dArr[i2] = ScriptRuntime.toInteger(objArr[i2]);
            } else if (i2 == 2) {
                dArr[i2] = 1.0d;
            } else {
                dArr[i2] = 0.0d;
            }
        }
        if (dArr[0] >= 0.0d && dArr[0] <= 99.0d) {
            dArr[0] = dArr[0] + 1900.0d;
        }
        return date_msecFromDate(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], dArr[6]);
    }

    private static double date_msecFromDate(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return MakeDate(MakeDay(d2, d3, d4), MakeTime(d5, d6, d7, d8));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01ba A[PHI: r12 r16
  0x01ba: PHI (r12v4 int) = (r12v1 int), (r12v1 int), (r12v1 int), (r12v1 int), (r12v3 int), (r12v1 int), (r12v1 int) binds: [B:150:0x018f, B:164:0x01b3, B:163:0x01b0, B:159:0x01a0, B:155:0x0198, B:146:0x0186, B:144:0x0182] A[DONT_GENERATE, DONT_INLINE]
  0x01ba: PHI (r16v9 double) = (r16v1 double), (r16v6 double), (r16v7 double), (r16v1 double), (r16v1 double), (r16v1 double), (r16v1 double) binds: [B:150:0x018f, B:164:0x01b3, B:163:0x01b0, B:159:0x01a0, B:155:0x0198, B:146:0x0186, B:144:0x0182] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static double date_parseString(java.lang.String r35) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.date_parseString(java.lang.String):double");
    }

    public static void init(Scriptable scriptable, boolean z) {
        NativeDate nativeDate = new NativeDate();
        nativeDate.date = Double.NaN;
        nativeDate.exportAsJSClass(47, scriptable, z);
    }

    private static double internalUTC(double d2) {
        double d3 = LocalTZA;
        return (d2 - d3) - DaylightSavingTA(d2 - d3);
    }

    private static Object jsConstructor(Object[] objArr) {
        NativeDate nativeDate = new NativeDate();
        if (objArr.length == 0) {
            nativeDate.date = now();
            return nativeDate;
        }
        if (objArr.length != 1) {
            double dDate_msecFromArgs = date_msecFromArgs(objArr);
            if (!Double.isNaN(dDate_msecFromArgs) && !Double.isInfinite(dDate_msecFromArgs)) {
                dDate_msecFromArgs = TimeClip(internalUTC(dDate_msecFromArgs));
            }
            nativeDate.date = dDate_msecFromArgs;
            return nativeDate;
        }
        Object defaultValue = objArr[0];
        if (defaultValue instanceof NativeDate) {
            nativeDate.date = ((NativeDate) defaultValue).date;
            return nativeDate;
        }
        if (defaultValue instanceof Scriptable) {
            defaultValue = ((Scriptable) defaultValue).getDefaultValue(null);
        }
        nativeDate.date = TimeClip(defaultValue instanceof CharSequence ? date_parseString(defaultValue.toString()) : ScriptRuntime.toNumber(defaultValue));
        return nativeDate;
    }

    private static double jsStaticFunction_UTC(Object[] objArr) {
        if (objArr.length == 0) {
            return Double.NaN;
        }
        return TimeClip(date_msecFromArgs(objArr));
    }

    private static String js_toISOString(double d2) {
        StringBuilder sb = new StringBuilder(27);
        int iYearFromTime = YearFromTime(d2);
        if (iYearFromTime < 0) {
            sb.append('-');
            append0PaddedUint(sb, -iYearFromTime, 6);
        } else if (iYearFromTime > 9999) {
            append0PaddedUint(sb, iYearFromTime, 6);
        } else {
            append0PaddedUint(sb, iYearFromTime, 4);
        }
        sb.append('-');
        append0PaddedUint(sb, MonthFromTime(d2) + 1, 2);
        sb.append('-');
        append0PaddedUint(sb, DateFromTime(d2), 2);
        sb.append('T');
        append0PaddedUint(sb, HourFromTime(d2), 2);
        sb.append(':');
        append0PaddedUint(sb, MinFromTime(d2), 2);
        sb.append(':');
        append0PaddedUint(sb, SecFromTime(d2), 2);
        sb.append('.');
        append0PaddedUint(sb, msFromTime(d2), 3);
        sb.append('Z');
        return sb.toString();
    }

    private static String js_toUTCString(double d2) {
        StringBuilder sb = new StringBuilder(60);
        appendWeekDayName(sb, WeekDay(d2));
        sb.append(", ");
        append0PaddedUint(sb, DateFromTime(d2), 2);
        sb.append(' ');
        appendMonthName(sb, MonthFromTime(d2));
        sb.append(' ');
        int iYearFromTime = YearFromTime(d2);
        if (iYearFromTime < 0) {
            sb.append('-');
            iYearFromTime = -iYearFromTime;
        }
        append0PaddedUint(sb, iYearFromTime, 4);
        sb.append(' ');
        append0PaddedUint(sb, HourFromTime(d2), 2);
        sb.append(':');
        append0PaddedUint(sb, MinFromTime(d2), 2);
        sb.append(':');
        append0PaddedUint(sb, SecFromTime(d2), 2);
        sb.append(" GMT");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static double makeDate(double r19, java.lang.Object[] r21, int r22) {
        /*
            r0 = r21
            int r1 = r0.length
            r2 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            if (r1 != 0) goto L8
            return r2
        L8:
            r1 = 2
            r4 = 3
            r5 = 0
            r6 = 1
            switch(r22) {
                case 39: goto L20;
                case 40: goto L1e;
                case 41: goto L1b;
                case 42: goto L19;
                case 43: goto L16;
                case 44: goto L14;
                default: goto Lf;
            }
        Lf:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.codeBug()
            throw r0
        L14:
            r7 = 0
            goto L17
        L16:
            r7 = 1
        L17:
            r8 = 3
            goto L22
        L19:
            r7 = 0
            goto L1c
        L1b:
            r7 = 1
        L1c:
            r8 = 2
            goto L22
        L1e:
            r7 = 0
            goto L21
        L20:
            r7 = 1
        L21:
            r8 = 1
        L22:
            int r9 = r0.length
            if (r9 >= r8) goto L27
            int r9 = r0.length
            goto L28
        L27:
            r9 = r8
        L28:
            double[] r10 = new double[r4]
            r11 = 0
            r12 = 0
        L2c:
            if (r11 >= r9) goto L4c
            r13 = r0[r11]
            double r13 = org.mozilla.javascript.ScriptRuntime.toNumber(r13)
            boolean r15 = java.lang.Double.isNaN(r13)
            if (r15 != 0) goto L48
            boolean r15 = java.lang.Double.isInfinite(r13)
            if (r15 == 0) goto L41
            goto L48
        L41:
            double r13 = org.mozilla.javascript.ScriptRuntime.toInteger(r13)
            r10[r11] = r13
            goto L49
        L48:
            r12 = 1
        L49:
            int r11 = r11 + 1
            goto L2c
        L4c:
            if (r12 == 0) goto L4f
            return r2
        L4f:
            boolean r0 = java.lang.Double.isNaN(r19)
            if (r0 == 0) goto L5b
            if (r8 >= r4) goto L58
            return r2
        L58:
            r2 = 0
            goto L64
        L5b:
            if (r7 == 0) goto L62
            double r2 = LocalTime(r19)
            goto L64
        L62:
            r2 = r19
        L64:
            if (r8 < r4) goto L6d
            if (r9 <= 0) goto L6d
            r4 = r10[r5]
            r13 = r4
            r5 = 1
            goto L73
        L6d:
            int r0 = YearFromTime(r2)
            double r11 = (double) r0
            r13 = r11
        L73:
            if (r8 < r1) goto L7e
            if (r5 >= r9) goto L7e
            int r0 = r5 + 1
            r4 = r10[r5]
            r15 = r4
            r5 = r0
            goto L84
        L7e:
            int r0 = MonthFromTime(r2)
            double r0 = (double) r0
            r15 = r0
        L84:
            if (r8 < r6) goto L8b
            if (r5 >= r9) goto L8b
            r0 = r10[r5]
            goto L90
        L8b:
            int r0 = DateFromTime(r2)
            double r0 = (double) r0
        L90:
            r17 = r0
            double r0 = MakeDay(r13, r15, r17)
            double r2 = TimeWithinDay(r2)
            double r0 = MakeDate(r0, r2)
            if (r7 == 0) goto La4
            double r0 = internalUTC(r0)
        La4:
            double r0 = TimeClip(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.makeDate(double, java.lang.Object[], int):double");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static double makeTime(double r22, java.lang.Object[] r24, int r25) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.makeTime(double, java.lang.Object[], int):double");
    }

    private static int msFromTime(double d2) {
        double d3 = d2 % msPerSecond;
        if (d3 < 0.0d) {
            d3 += msPerSecond;
        }
        return (int) d3;
    }

    private static double now() {
        return System.currentTimeMillis();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        r0 = -1;
        r13 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static double parseISOString(java.lang.String r34) {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.parseISOString(java.lang.String):double");
    }

    private static String toLocale_helper(double d2, int i2) {
        DateFormat dateFormat;
        String str;
        if (i2 == 5) {
            dateFormat = localeDateTimeFormatter;
        } else if (i2 == 6) {
            dateFormat = localeTimeFormatter;
        } else {
            if (i2 != 7) {
                throw new AssertionError();
            }
            dateFormat = localeDateFormatter;
        }
        synchronized (dateFormat) {
            str = dateFormat.format(new Date((long) d2));
        }
        return str;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double dTimeClip;
        if (!idFunctionObject.hasTag(DATE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == -3) {
            return ScriptRuntime.wrapNumber(now());
        }
        if (iMethodId == -2) {
            return ScriptRuntime.wrapNumber(date_parseString(ScriptRuntime.toString(objArr, 0)));
        }
        if (iMethodId == -1) {
            return ScriptRuntime.wrapNumber(jsStaticFunction_UTC(objArr));
        }
        if (iMethodId == 1) {
            return scriptable2 != null ? date_format(now(), 2) : jsConstructor(objArr);
        }
        if (iMethodId == 47) {
            Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
            Object primitive = ScriptRuntime.toPrimitive(object, ScriptRuntime.NumberClass);
            if (primitive instanceof Number) {
                double dDoubleValue = ((Number) primitive).doubleValue();
                if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                    return null;
                }
            }
            Object property = ScriptableObject.getProperty(object, "toISOString");
            if (property == Scriptable.NOT_FOUND) {
                throw ScriptRuntime.typeError2("msg.function.not.found.in", "toISOString", ScriptRuntime.toString(object));
            }
            if (!(property instanceof Callable)) {
                throw ScriptRuntime.typeError3("msg.isnt.function.in", "toISOString", ScriptRuntime.toString(object), ScriptRuntime.toString(property));
            }
            Object objCall = ((Callable) property).call(context, scriptable, object, ScriptRuntime.emptyArgs);
            if (ScriptRuntime.isPrimitive(objCall)) {
                return objCall;
            }
            throw ScriptRuntime.typeError1("msg.toisostring.must.return.primitive", ScriptRuntime.toString(objCall));
        }
        if (!(scriptable2 instanceof NativeDate)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        NativeDate nativeDate = (NativeDate) scriptable2;
        double dYearFromTime = nativeDate.date;
        switch (iMethodId) {
            case 2:
            case 3:
            case 4:
                return !Double.isNaN(dYearFromTime) ? date_format(dYearFromTime, iMethodId) : js_NaN_date_str;
            case 5:
            case 6:
            case 7:
                return !Double.isNaN(dYearFromTime) ? toLocale_helper(dYearFromTime, iMethodId) : js_NaN_date_str;
            case 8:
                return !Double.isNaN(dYearFromTime) ? js_toUTCString(dYearFromTime) : js_NaN_date_str;
            case 9:
                StringBuilder sbR = a.r("(new Date(");
                sbR.append(ScriptRuntime.toString(dYearFromTime));
                sbR.append("))");
                return sbR.toString();
            case 10:
            case 11:
                return ScriptRuntime.wrapNumber(dYearFromTime);
            case 12:
            case 13:
            case 14:
                if (!Double.isNaN(dYearFromTime)) {
                    if (iMethodId != 14) {
                        dYearFromTime = LocalTime(dYearFromTime);
                    }
                    dYearFromTime = YearFromTime(dYearFromTime);
                    if (iMethodId == 12 && (!context.hasFeature(1) || (1900.0d <= dYearFromTime && dYearFromTime < 2000.0d))) {
                        dYearFromTime -= 1900.0d;
                    }
                }
                return ScriptRuntime.wrapNumber(dYearFromTime);
            case 15:
            case 16:
                if (!Double.isNaN(dYearFromTime)) {
                    if (iMethodId == 15) {
                        dYearFromTime = LocalTime(dYearFromTime);
                    }
                    dYearFromTime = MonthFromTime(dYearFromTime);
                }
                return ScriptRuntime.wrapNumber(dYearFromTime);
            case 17:
            case 18:
                if (!Double.isNaN(dYearFromTime)) {
                    if (iMethodId == 17) {
                        dYearFromTime = LocalTime(dYearFromTime);
                    }
                    dYearFromTime = DateFromTime(dYearFromTime);
                }
                return ScriptRuntime.wrapNumber(dYearFromTime);
            case 19:
            case 20:
                if (!Double.isNaN(dYearFromTime)) {
                    if (iMethodId == 19) {
                        dYearFromTime = LocalTime(dYearFromTime);
                    }
                    dYearFromTime = WeekDay(dYearFromTime);
                }
                return ScriptRuntime.wrapNumber(dYearFromTime);
            case 21:
            case 22:
                if (!Double.isNaN(dYearFromTime)) {
                    if (iMethodId == 21) {
                        dYearFromTime = LocalTime(dYearFromTime);
                    }
                    dYearFromTime = HourFromTime(dYearFromTime);
                }
                return ScriptRuntime.wrapNumber(dYearFromTime);
            case 23:
            case 24:
                if (!Double.isNaN(dYearFromTime)) {
                    if (iMethodId == 23) {
                        dYearFromTime = LocalTime(dYearFromTime);
                    }
                    dYearFromTime = MinFromTime(dYearFromTime);
                }
                return ScriptRuntime.wrapNumber(dYearFromTime);
            case 25:
            case 26:
                if (!Double.isNaN(dYearFromTime)) {
                    if (iMethodId == 25) {
                        dYearFromTime = LocalTime(dYearFromTime);
                    }
                    dYearFromTime = SecFromTime(dYearFromTime);
                }
                return ScriptRuntime.wrapNumber(dYearFromTime);
            case 27:
            case 28:
                if (!Double.isNaN(dYearFromTime)) {
                    if (iMethodId == 27) {
                        dYearFromTime = LocalTime(dYearFromTime);
                    }
                    dYearFromTime = msFromTime(dYearFromTime);
                }
                return ScriptRuntime.wrapNumber(dYearFromTime);
            case 29:
                if (!Double.isNaN(dYearFromTime)) {
                    dYearFromTime = (dYearFromTime - LocalTime(dYearFromTime)) / msPerMinute;
                }
                return ScriptRuntime.wrapNumber(dYearFromTime);
            case 30:
                double dTimeClip2 = TimeClip(ScriptRuntime.toNumber(objArr, 0));
                nativeDate.date = dTimeClip2;
                return ScriptRuntime.wrapNumber(dTimeClip2);
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
                double dMakeTime = makeTime(dYearFromTime, objArr, iMethodId);
                nativeDate.date = dMakeTime;
                return ScriptRuntime.wrapNumber(dMakeTime);
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                double dMakeDate = makeDate(dYearFromTime, objArr, iMethodId);
                nativeDate.date = dMakeDate;
                return ScriptRuntime.wrapNumber(dMakeDate);
            case 45:
                double number = ScriptRuntime.toNumber(objArr, 0);
                if (Double.isNaN(number) || Double.isInfinite(number)) {
                    dTimeClip = Double.NaN;
                } else {
                    double dLocalTime = Double.isNaN(dYearFromTime) ? 0.0d : LocalTime(dYearFromTime);
                    if (number >= 0.0d && number <= 99.0d) {
                        number += 1900.0d;
                    }
                    dTimeClip = TimeClip(internalUTC(MakeDate(MakeDay(number, MonthFromTime(dLocalTime), DateFromTime(dLocalTime)), TimeWithinDay(dLocalTime))));
                }
                nativeDate.date = dTimeClip;
                return ScriptRuntime.wrapNumber(dTimeClip);
            case 46:
                if (Double.isNaN(dYearFromTime)) {
                    throw ScriptRuntime.rangeError(ScriptRuntime.getMessage0("msg.invalid.date"));
                }
                return js_toISOString(dYearFromTime);
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = DATE_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -3, "now", 0);
        addIdFunctionProperty(idFunctionObject, obj, -2, "parse", 1);
        addIdFunctionProperty(idFunctionObject, obj, -1, "UTC", 7);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0219 A[FALL_THROUGH] */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.findPrototypeId(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Date";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        if (cls == null) {
            cls = ScriptRuntime.StringClass;
        }
        return super.getDefaultValue(cls);
    }

    public double getJSTimeValue() {
        return this.date;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        String str2;
        int i3 = 0;
        switch (i2) {
            case 1:
                str = "constructor";
                i3 = 7;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 2:
                str = "toString";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 3:
                str = "toTimeString";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 4:
                str = "toDateString";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 5:
                str = "toLocaleString";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 6:
                str = "toLocaleTimeString";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 7:
                str = "toLocaleDateString";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 8:
                str = "toUTCString";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 9:
                str = "toSource";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 10:
                str = "valueOf";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 11:
                str = "getTime";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 12:
                str = "getYear";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 13:
                str = "getFullYear";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 14:
                str = "getUTCFullYear";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 15:
                str = "getMonth";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 16:
                str = "getUTCMonth";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 17:
                str = "getDate";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 18:
                str = "getUTCDate";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 19:
                str = "getDay";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 20:
                str = "getUTCDay";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 21:
                str = "getHours";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 22:
                str = "getUTCHours";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 23:
                str = "getMinutes";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 24:
                str = "getUTCMinutes";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 25:
                str = "getSeconds";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 26:
                str = "getUTCSeconds";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 27:
                str = "getMilliseconds";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 28:
                str = "getUTCMilliseconds";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 29:
                str = "getTimezoneOffset";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 30:
                str = "setTime";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 31:
                str = "setMilliseconds";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 32:
                str = "setUTCMilliseconds";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 33:
                str = "setSeconds";
                i3 = 2;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 34:
                str = "setUTCSeconds";
                i3 = 2;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 35:
                str = "setMinutes";
                i3 = 3;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 36:
                str = "setUTCMinutes";
                i3 = 3;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 37:
                str2 = "setHours";
                str = str2;
                i3 = 4;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 38:
                str2 = "setUTCHours";
                str = str2;
                i3 = 4;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 39:
                str = "setDate";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 40:
                str = "setUTCDate";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 41:
                str = "setMonth";
                i3 = 2;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 42:
                str = "setUTCMonth";
                i3 = 2;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 43:
                str = "setFullYear";
                i3 = 3;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 44:
                str = "setUTCFullYear";
                i3 = 3;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 45:
                str = "setYear";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 46:
                str = "toISOString";
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            case 47:
                str = "toJSON";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i2, str, i3);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i2));
        }
    }
}
