package i.a.a;

import androidx.recyclerview.widget.RecyclerView;
import com.umeng.analytics.pro.ai;
import j$.util.Comparator;
import j$.util.DesugarTimeZone;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;

/* JADX INFO: compiled from: ConvertDate.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static TreeMap<String, Integer> a = new TreeMap<>(new a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static TreeMap<String, Integer> f6348b = new TreeMap<>(new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static HashSet<String> f6349c = new HashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static TreeMap<String, TimeZone> f6350d = new TreeMap<>();

    /* JADX INFO: compiled from: ConvertDate.java */
    public static class a implements Comparator<String>, j$.util.Comparator {
        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((String) obj).compareToIgnoreCase((String) obj2);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    static {
        f6349c.add("MEZ");
        f6349c.add("Uhr");
        f6349c.add("h");
        f6349c.add("pm");
        f6349c.add("PM");
        f6349c.add("AM");
        f6349c.add("o'clock");
        for (String str : TimeZone.getAvailableIDs()) {
            f6350d.put(str, DesugarTimeZone.getTimeZone(str));
        }
        for (Locale locale : DateFormatSymbols.getAvailableLocales()) {
            if (!"ja".equals(locale.getLanguage()) && !"ko".equals(locale.getLanguage()) && !"zh".equals(locale.getLanguage())) {
                DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
                String[] months = dateFormatSymbols.getMonths();
                for (int i2 = 0; i2 < months.length; i2++) {
                    if (months[i2].length() != 0) {
                        c(a, months[i2], Integer.valueOf(i2));
                    }
                }
                String[] shortMonths = dateFormatSymbols.getShortMonths();
                for (int i3 = 0; i3 < shortMonths.length; i3++) {
                    String str2 = shortMonths[i3];
                    if (str2.length() != 0 && !Character.isDigit(str2.charAt(str2.length() - 1))) {
                        c(a, shortMonths[i3], Integer.valueOf(i3));
                        c(a, shortMonths[i3].replace(".", ""), Integer.valueOf(i3));
                    }
                }
                String[] weekdays = dateFormatSymbols.getWeekdays();
                for (int i4 = 0; i4 < weekdays.length; i4++) {
                    String str3 = weekdays[i4];
                    if (str3.length() != 0) {
                        c(f6348b, str3, Integer.valueOf(i4));
                        c(f6348b, str3.replace(".", ""), Integer.valueOf(i4));
                    }
                }
                String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
                for (int i5 = 0; i5 < shortWeekdays.length; i5++) {
                    String str4 = shortWeekdays[i5];
                    if (str4.length() != 0) {
                        c(f6348b, str4, Integer.valueOf(i5));
                        c(f6348b, str4.replace(".", ""), Integer.valueOf(i5));
                    }
                }
            }
        }
    }

    public static Date a(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        if (str == null) {
            if (!stringTokenizer.hasMoreTokens()) {
                return calendar.getTime();
            }
            str = stringTokenizer.nextToken();
        }
        return b(stringTokenizer, calendar, str);
    }

    public static Date b(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        calendar.set(11, Integer.parseInt(str));
        if (!stringTokenizer.hasMoreTokens()) {
            return calendar.getTime();
        }
        String strF = f(stringTokenizer, stringTokenizer.nextToken(), calendar);
        if (strF == null) {
            return calendar.getTime();
        }
        calendar.set(12, Integer.parseInt(strF));
        if (!stringTokenizer.hasMoreTokens()) {
            return calendar.getTime();
        }
        String strF2 = f(stringTokenizer, stringTokenizer.nextToken(), calendar);
        if (strF2 == null) {
            return calendar.getTime();
        }
        calendar.set(13, Integer.parseInt(strF2));
        if (!stringTokenizer.hasMoreTokens()) {
            return calendar.getTime();
        }
        String strF3 = f(stringTokenizer, stringTokenizer.nextToken(), calendar);
        if (strF3 == null) {
            return calendar.getTime();
        }
        String strF4 = f(stringTokenizer, strF3, calendar);
        if (strF4.length() == 4 && Character.isDigit(strF4.charAt(0))) {
            calendar.set(1, d(strF4));
        }
        return calendar.getTime();
    }

    public static void c(TreeMap<String, Integer> treeMap, String str, Integer num) {
        treeMap.put(str, num);
        treeMap.put(str.replace("é", "e").replace("û", ai.aE), num);
    }

    public static int d(String str) {
        int i2 = Integer.parseInt(str);
        return i2 < 100 ? i2 > 23 ? i2 + RecyclerView.MAX_SCROLL_DURATION : i2 + 1900 : i2;
    }

    public static Integer e(String str) {
        if (Character.isDigit(str.charAt(0))) {
            return Integer.valueOf(Integer.parseInt(str) - 1);
        }
        Integer num = a.get(str);
        if (num != null) {
            return Integer.valueOf(num.intValue());
        }
        throw new NullPointerException("can not parse " + str + " as month");
    }

    public static String f(StringTokenizer stringTokenizer, String str, Calendar calendar) {
        while (true) {
            TimeZone timeZone = f6350d.get(str);
            if (timeZone != null) {
                calendar.setTimeZone(timeZone);
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                str = stringTokenizer.nextToken();
            } else {
                if (!f6349c.contains(str)) {
                    return str;
                }
                if (str.equalsIgnoreCase("pm")) {
                    calendar.add(9, 1);
                }
                if (str.equalsIgnoreCase("am")) {
                    calendar.add(9, 0);
                }
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                str = stringTokenizer.nextToken();
            }
        }
    }
}
