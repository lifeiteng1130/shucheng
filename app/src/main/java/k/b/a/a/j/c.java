package k.b.a.a.j;

import j$.util.Comparator;
import j$.util.DesugarTimeZone;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: FastDateParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements Serializable {
    public static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    public static final Comparator<String> a = Comparator.CC.reverseOrder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentMap<Locale, k>[] f8574b = new ConcurrentMap[17];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f8575c = new a(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f8576d = new b(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f8577e = new i(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f8578f = new i(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f8579g = new i(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f8580h = new i(6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f8581i = new i(5);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k f8582j = new C0227c(7);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final k f8583k = new i(8);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final k f8584l = new i(11);
    public static final k m = new d(11);
    public static final k n = new e(10);
    public static final k o = new i(10);
    public static final k p = new i(12);
    public static final k q = new i(13);
    public static final k r = new i(14);
    private static final long serialVersionUID = 3;
    private final int century;
    private final Locale locale;
    private final String pattern;
    public transient List<l> s;
    private final int startYear;
    private final TimeZone timeZone;

    /* JADX INFO: compiled from: FastDateParser.java */
    public static class a extends i {
        public a(int i2) {
            super(i2);
        }

        @Override // k.b.a.a.j.c.i
        public int c(c cVar, int i2) {
            return i2 < 100 ? c.access$700(cVar, i2) : i2;
        }
    }

    /* JADX INFO: compiled from: FastDateParser.java */
    public static class b extends i {
        public b(int i2) {
            super(i2);
        }

        @Override // k.b.a.a.j.c.i
        public int c(c cVar, int i2) {
            return i2 - 1;
        }
    }

    /* JADX INFO: renamed from: k.b.a.a.j.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FastDateParser.java */
    public static class C0227c extends i {
        public C0227c(int i2) {
            super(i2);
        }

        @Override // k.b.a.a.j.c.i
        public int c(c cVar, int i2) {
            if (i2 == 7) {
                return 1;
            }
            return 1 + i2;
        }
    }

    /* JADX INFO: compiled from: FastDateParser.java */
    public static class d extends i {
        public d(int i2) {
            super(i2);
        }

        @Override // k.b.a.a.j.c.i
        public int c(c cVar, int i2) {
            if (i2 == 24) {
                return 0;
            }
            return i2;
        }
    }

    /* JADX INFO: compiled from: FastDateParser.java */
    public static class e extends i {
        public e(int i2) {
            super(i2);
        }

        @Override // k.b.a.a.j.c.i
        public int c(c cVar, int i2) {
            if (i2 == 12) {
                return 0;
            }
            return i2;
        }
    }

    /* JADX INFO: compiled from: FastDateParser.java */
    public static class f extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Locale f8586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Integer> f8587d;

        public f(int i2, Calendar calendar, Locale locale) {
            super(null);
            this.f8585b = i2;
            this.f8586c = locale;
            StringBuilder sbR = c.a.a.a.a.r("((?iu)");
            this.f8587d = c.access$600(calendar, locale, i2, sbR);
            sbR.setLength(sbR.length() - 1);
            sbR.append(")");
            this.a = Pattern.compile(sbR.toString());
        }

        @Override // k.b.a.a.j.c.j
        public void c(c cVar, Calendar calendar, String str) {
            String lowerCase = str.toLowerCase(this.f8586c);
            Integer num = this.f8587d.get(lowerCase);
            if (num == null) {
                num = this.f8587d.get(lowerCase + '.');
            }
            calendar.set(this.f8585b, num.intValue());
        }
    }

    /* JADX INFO: compiled from: FastDateParser.java */
    public static class g extends k {
        public final String a;

        public g(String str) {
            super(null);
            this.a = str;
        }

        @Override // k.b.a.a.j.c.k
        public boolean b(c cVar, Calendar calendar, String str, ParsePosition parsePosition, int i2) {
            for (int i3 = 0; i3 < this.a.length(); i3++) {
                int index = parsePosition.getIndex() + i3;
                if (index == str.length()) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
                if (this.a.charAt(i3) != str.charAt(index)) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
            }
            parsePosition.setIndex(parsePosition.getIndex() + this.a.length());
            return true;
        }
    }

    /* JADX INFO: compiled from: FastDateParser.java */
    public static class h extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final k f8588b = new h("(Z|(?:[+-]\\d{2}))");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final k f8589c = new h("(Z|(?:[+-]\\d{2}\\d{2}))");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final k f8590d = new h("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");

        public h(String str) {
            super(null);
            this.a = Pattern.compile(str);
        }

        @Override // k.b.a.a.j.c.j
        public void c(c cVar, Calendar calendar, String str) {
            calendar.setTimeZone(k.b.a.a.j.e.a(str));
        }
    }

    /* JADX INFO: compiled from: FastDateParser.java */
    public static class i extends k {
        public final int a;

        public i(int i2) {
            super(null);
            this.a = i2;
        }

        @Override // k.b.a.a.j.c.k
        public boolean a() {
            return true;
        }

        @Override // k.b.a.a.j.c.k
        public boolean b(c cVar, Calendar calendar, String str, ParsePosition parsePosition, int i2) {
            int index = parsePosition.getIndex();
            int length = str.length();
            if (i2 == 0) {
                while (index < length && Character.isWhitespace(str.charAt(index))) {
                    index++;
                }
                parsePosition.setIndex(index);
            } else {
                int i3 = i2 + index;
                if (length > i3) {
                    length = i3;
                }
            }
            while (index < length && Character.isDigit(str.charAt(index))) {
                index++;
            }
            if (parsePosition.getIndex() == index) {
                parsePosition.setErrorIndex(index);
                return false;
            }
            int i4 = Integer.parseInt(str.substring(parsePosition.getIndex(), index));
            parsePosition.setIndex(index);
            calendar.set(this.a, c(cVar, i4));
            return true;
        }

        public int c(c cVar, int i2) {
            return i2;
        }
    }

    /* JADX INFO: compiled from: FastDateParser.java */
    public static abstract class j extends k {
        public Pattern a;

        public j(a aVar) {
            super(null);
        }

        @Override // k.b.a.a.j.c.k
        public boolean a() {
            return false;
        }

        @Override // k.b.a.a.j.c.k
        public boolean b(c cVar, Calendar calendar, String str, ParsePosition parsePosition, int i2) {
            Matcher matcher = this.a.matcher(str.substring(parsePosition.getIndex()));
            if (!matcher.lookingAt()) {
                parsePosition.setErrorIndex(parsePosition.getIndex());
                return false;
            }
            parsePosition.setIndex(matcher.end(1) + parsePosition.getIndex());
            c(cVar, calendar, matcher.group(1));
            return true;
        }

        public abstract void c(c cVar, Calendar calendar, String str);
    }

    /* JADX INFO: compiled from: FastDateParser.java */
    public static abstract class k {
        public k() {
        }

        public boolean a() {
            return false;
        }

        public abstract boolean b(c cVar, Calendar calendar, String str, ParsePosition parsePosition, int i2);

        public k(a aVar) {
        }
    }

    /* JADX INFO: compiled from: FastDateParser.java */
    public static class l {
        public final k a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8591b;

        public l(k kVar, int i2) {
            this.a = kVar;
            this.f8591b = i2;
        }
    }

    /* JADX INFO: compiled from: FastDateParser.java */
    public static class m extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Locale f8592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, a> f8593c;

        /* JADX INFO: compiled from: FastDateParser.java */
        public static class a {
            public TimeZone a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8594b;

            public a(TimeZone timeZone, boolean z) {
                this.a = timeZone;
                this.f8594b = z ? timeZone.getDSTSavings() : 0;
            }
        }

        public m(Locale locale) {
            super(null);
            this.f8593c = new HashMap();
            this.f8592b = locale;
            StringBuilder sbR = c.a.a.a.a.r("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet<String> treeSet = new TreeSet(c.a);
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                String str = strArr[0];
                if (!str.equalsIgnoreCase("GMT")) {
                    TimeZone timeZone = DesugarTimeZone.getTimeZone(str);
                    a aVar = new a(timeZone, false);
                    a aVar2 = aVar;
                    for (int i2 = 1; i2 < strArr.length; i2++) {
                        if (i2 == 3) {
                            aVar2 = new a(timeZone, true);
                        } else if (i2 == 5) {
                            aVar2 = aVar;
                        }
                        if (strArr[i2] != null) {
                            String lowerCase = strArr[i2].toLowerCase(locale);
                            if (treeSet.add(lowerCase)) {
                                this.f8593c.put(lowerCase, aVar2);
                            }
                        }
                    }
                }
            }
            for (String str2 : treeSet) {
                sbR.append('|');
                c.access$900(sbR, str2);
            }
            sbR.append(")");
            this.a = Pattern.compile(sbR.toString());
        }

        @Override // k.b.a.a.j.c.j
        public void c(c cVar, Calendar calendar, String str) {
            TimeZone timeZoneA = k.b.a.a.j.e.a(str);
            if (timeZoneA != null) {
                calendar.setTimeZone(timeZoneA);
                return;
            }
            String lowerCase = str.toLowerCase(this.f8592b);
            a aVar = this.f8593c.get(lowerCase);
            if (aVar == null) {
                aVar = this.f8593c.get(lowerCase + '.');
            }
            calendar.set(16, aVar.f8594b);
            calendar.set(15, aVar.a.getRawOffset());
        }
    }

    public c(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    public static boolean access$100(char c2) {
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z');
    }

    public static k access$200(c cVar, char c2, int i2, Calendar calendar) {
        Objects.requireNonNull(cVar);
        if (c2 != 'y') {
            if (c2 != 'z') {
                switch (c2) {
                    case 'D':
                        return f8580h;
                    case 'E':
                        return cVar.a(7, calendar);
                    case 'F':
                        return f8583k;
                    case 'G':
                        return cVar.a(0, calendar);
                    case 'H':
                        return f8584l;
                    default:
                        switch (c2) {
                            case 'K':
                                return o;
                            case 'M':
                                return i2 >= 3 ? cVar.a(2, calendar) : f8576d;
                            case 'S':
                                return r;
                            case 'a':
                                return cVar.a(9, calendar);
                            case 'd':
                                return f8581i;
                            case 'h':
                                return n;
                            case 'k':
                                return m;
                            case 'm':
                                return p;
                            case 's':
                                return q;
                            case 'u':
                                return f8582j;
                            case 'w':
                                return f8578f;
                            default:
                                switch (c2) {
                                    case 'W':
                                        return f8579g;
                                    case 'X':
                                        k kVar = h.f8588b;
                                        if (i2 == 1) {
                                            return h.f8588b;
                                        }
                                        if (i2 == 2) {
                                            return h.f8589c;
                                        }
                                        if (i2 == 3) {
                                            return h.f8590d;
                                        }
                                        throw new IllegalArgumentException("invalid number of X");
                                    case 'Y':
                                        break;
                                    case 'Z':
                                        if (i2 == 2) {
                                            return h.f8590d;
                                        }
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Format '" + c2 + "' not supported");
                                }
                                break;
                        }
                        break;
                }
            }
            return cVar.a(15, calendar);
        }
        return i2 > 2 ? f8577e : f8575c;
    }

    public static Map access$600(Calendar calendar, Locale locale, int i2, StringBuilder sb) {
        HashMap map = new HashMap();
        Map<String, Integer> displayNames = calendar.getDisplayNames(i2, 0, locale);
        TreeSet treeSet = new TreeSet(a);
        for (Map.Entry<String, Integer> entry : displayNames.entrySet()) {
            String lowerCase = entry.getKey().toLowerCase(locale);
            if (treeSet.add(lowerCase)) {
                map.put(lowerCase, entry.getValue());
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            c(sb, (String) it.next());
            sb.append('|');
        }
        return map;
    }

    public static int access$700(c cVar, int i2) {
        int i3 = cVar.century + i2;
        return i2 >= cVar.startYear ? i3 : i3 + 100;
    }

    public static /* synthetic */ StringBuilder access$900(StringBuilder sb, String str) {
        c(sb, str);
        return sb;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.StringBuilder c(java.lang.StringBuilder r6, java.lang.String r7) {
        /*
            r0 = 0
        L1:
            int r1 = r7.length()
            r2 = 63
            r3 = 46
            if (r0 >= r1) goto L38
            char r1 = r7.charAt(r0)
            r4 = 36
            r5 = 92
            if (r1 == r4) goto L2f
            if (r1 == r3) goto L2f
            if (r1 == r2) goto L2f
            r2 = 94
            if (r1 == r2) goto L2f
            r2 = 91
            if (r1 == r2) goto L2f
            if (r1 == r5) goto L2f
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L2f
            r2 = 124(0x7c, float:1.74E-43)
            if (r1 == r2) goto L2f
            switch(r1) {
                case 40: goto L2f;
                case 41: goto L2f;
                case 42: goto L2f;
                case 43: goto L2f;
                default: goto L2e;
            }
        L2e:
            goto L32
        L2f:
            r6.append(r5)
        L32:
            r6.append(r1)
            int r0 = r0 + 1
            goto L1
        L38:
            int r7 = r6.length()
            int r7 = r7 + (-1)
            char r7 = r6.charAt(r7)
            if (r7 != r3) goto L47
            r6.append(r2)
        L47:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: k.b.a.a.j.c.c(java.lang.StringBuilder, java.lang.String):java.lang.StringBuilder");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        b(Calendar.getInstance(this.timeZone, this.locale));
    }

    public final k a(int i2, Calendar calendar) {
        ConcurrentMap<Locale, k> concurrentMap;
        ConcurrentMap<Locale, k>[] concurrentMapArr = f8574b;
        synchronized (concurrentMapArr) {
            if (concurrentMapArr[i2] == null) {
                concurrentMapArr[i2] = new ConcurrentHashMap(3);
            }
            concurrentMap = concurrentMapArr[i2];
        }
        k mVar = concurrentMap.get(this.locale);
        if (mVar == null) {
            mVar = i2 == 15 ? new m(this.locale) : new f(i2, calendar, this.locale);
            k kVarPutIfAbsent = concurrentMap.putIfAbsent(this.locale, mVar);
            if (kVarPutIfAbsent != null) {
                return kVarPutIfAbsent;
            }
        }
        return mVar;
    }

    public final void b(Calendar calendar) {
        l lVar;
        this.s = new ArrayList();
        int i2 = 0;
        while (true) {
            if (i2 >= this.pattern.length()) {
                lVar = null;
            } else {
                char cCharAt = this.pattern.charAt(i2);
                if (access$100(cCharAt)) {
                    int i3 = i2;
                    do {
                        i3++;
                        if (i3 >= this.pattern.length()) {
                            break;
                        }
                    } while (this.pattern.charAt(i3) == cCharAt);
                    int i4 = i3 - i2;
                    l lVar2 = new l(access$200(this, cCharAt, i4, calendar), i4);
                    i2 = i3;
                    lVar = lVar2;
                } else {
                    StringBuilder sb = new StringBuilder();
                    boolean z = false;
                    while (i2 < this.pattern.length()) {
                        char cCharAt2 = this.pattern.charAt(i2);
                        if (!z && access$100(cCharAt2)) {
                            break;
                        }
                        if (cCharAt2 != '\'' || ((i2 = i2 + 1) != this.pattern.length() && this.pattern.charAt(i2) == '\'')) {
                            i2++;
                            sb.append(cCharAt2);
                        } else {
                            z = !z;
                        }
                    }
                    if (z) {
                        throw new IllegalArgumentException("Unterminated quote");
                    }
                    String string = sb.toString();
                    lVar = new l(new g(string), string.length());
                }
            }
            if (lVar == null) {
                return;
            } else {
                this.s.add(lVar);
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.pattern.equals(cVar.pattern) && this.timeZone.equals(cVar.timeZone) && this.locale.equals(cVar.locale);
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getPattern() {
        return this.pattern;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return (((this.locale.hashCode() * 13) + this.timeZone.hashCode()) * 13) + this.pattern.hashCode();
    }

    public Date parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = parse(str, parsePosition);
        if (date != null) {
            return date;
        }
        if (!this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException(c.a.a.a.a.i("Unparseable date: ", str), parsePosition.getErrorIndex());
        }
        StringBuilder sbR = c.a.a.a.a.r("(The ");
        sbR.append(this.locale);
        sbR.append(" locale does not support dates before 1868 AD)\nUnparseable date: \"");
        sbR.append(str);
        throw new ParseException(sbR.toString(), parsePosition.getErrorIndex());
    }

    public Object parseObject(String str) {
        return parse(str);
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("FastDateParser[");
        sbR.append(this.pattern);
        sbR.append(",");
        sbR.append(this.locale);
        sbR.append(",");
        sbR.append(this.timeZone.getID());
        sbR.append("]");
        return sbR.toString();
    }

    public c(String str, TimeZone timeZone, Locale locale, Date date) {
        int i2;
        this.pattern = str;
        this.timeZone = timeZone;
        this.locale = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (date != null) {
            calendar.setTime(date);
            i2 = calendar.get(1);
        } else if (locale.equals(JAPANESE_IMPERIAL)) {
            i2 = 0;
        } else {
            calendar.setTime(new Date());
            i2 = calendar.get(1) - 80;
        }
        int i3 = (i2 / 100) * 100;
        this.century = i3;
        this.startYear = i2 - i3;
        b(calendar);
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    public Date parse(String str, ParsePosition parsePosition) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        calendar.clear();
        if (parse(str, parsePosition, calendar)) {
            return calendar.getTime();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean parse(java.lang.String r11, java.text.ParsePosition r12, java.util.Calendar r13) {
        /*
            r10 = this;
            java.util.List<k.b.a.a.j.c$l> r0 = r10.s
            java.util.ListIterator r0 = r0.listIterator()
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L45
            java.lang.Object r1 = r0.next()
            k.b.a.a.j.c$l r1 = (k.b.a.a.j.c.l) r1
            k.b.a.a.j.c$k r2 = r1.a
            boolean r2 = r2.a()
            r3 = 0
            if (r2 == 0) goto L37
            boolean r2 = r0.hasNext()
            if (r2 != 0) goto L22
            goto L37
        L22:
            java.lang.Object r2 = r0.next()
            k.b.a.a.j.c$l r2 = (k.b.a.a.j.c.l) r2
            k.b.a.a.j.c$k r2 = r2.a
            r0.previous()
            boolean r2 = r2.a()
            if (r2 == 0) goto L37
            int r2 = r1.f8591b
            r9 = r2
            goto L38
        L37:
            r9 = 0
        L38:
            k.b.a.a.j.c$k r4 = r1.a
            r5 = r10
            r6 = r13
            r7 = r11
            r8 = r12
            boolean r1 = r4.b(r5, r6, r7, r8, r9)
            if (r1 != 0) goto L6
            return r3
        L45:
            r11 = 1
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: k.b.a.a.j.c.parse(java.lang.String, java.text.ParsePosition, java.util.Calendar):boolean");
    }
}
