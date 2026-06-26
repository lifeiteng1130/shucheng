package k.b.a.a.j;

import com.ss.android.download.api.constant.BaseConstants;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.FieldPosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: FastDatePrinter.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    public static final ConcurrentMap<i, String> a = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient f[] f8595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f8596c;
    private final Locale mLocale;
    private final String mPattern;
    private final TimeZone mTimeZone;

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class a implements f {
        public final char a;

        public a(char c2) {
            this.a = c2;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return 1;
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.a);
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class b implements InterfaceC0228d {
        public final InterfaceC0228d a;

        public b(InterfaceC0228d interfaceC0228d) {
            this.a = interfaceC0228d;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return this.a.a();
        }

        @Override // k.b.a.a.j.d.InterfaceC0228d
        public void b(Appendable appendable, int i2) {
            this.a.b(appendable, i2);
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) {
            int i2 = calendar.get(7);
            this.a.b(appendable, i2 != 1 ? i2 - 1 : 7);
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class c implements f {
        public static final c a = new c(3);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f8597b = new c(5);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f8598c = new c(6);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f8599d;

        public c(int i2) {
            this.f8599d = i2;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return this.f8599d;
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = calendar.get(16) + calendar.get(15);
            if (i2 == 0) {
                appendable.append("Z");
                return;
            }
            if (i2 < 0) {
                appendable.append('-');
                i2 = -i2;
            } else {
                appendable.append('+');
            }
            int i3 = i2 / BaseConstants.Time.HOUR;
            d.access$000(appendable, i3);
            int i4 = this.f8599d;
            if (i4 < 5) {
                return;
            }
            if (i4 == 6) {
                appendable.append(':');
            }
            d.access$000(appendable, (i2 / BaseConstants.Time.MINUTE) - (i3 * 60));
        }
    }

    /* JADX INFO: renamed from: k.b.a.a.j.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FastDatePrinter.java */
    public interface InterfaceC0228d extends f {
        void b(Appendable appendable, int i2);
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class e implements InterfaceC0228d {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8600b;

        public e(int i2, int i3) {
            if (i3 < 3) {
                throw new IllegalArgumentException();
            }
            this.a = i2;
            this.f8600b = i3;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return this.f8600b;
        }

        @Override // k.b.a.a.j.d.InterfaceC0228d
        public final void b(Appendable appendable, int i2) throws IOException {
            d.access$100(appendable, i2, this.f8600b);
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            d.access$100(appendable, calendar.get(this.a), this.f8600b);
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public interface f {
        int a();

        void c(Appendable appendable, Calendar calendar);
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class g implements f {
        public final String a;

        public g(String str) {
            this.a = str;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return this.a.length();
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.a);
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class h implements f {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f8601b;

        public h(int i2, String[] strArr) {
            this.a = i2;
            this.f8601b = strArr;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            int length = this.f8601b.length;
            int i2 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i2;
                }
                int length2 = this.f8601b[length].length();
                if (length2 > i2) {
                    i2 = length2;
                }
            }
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.f8601b[calendar.get(this.a)]);
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class i {
        public final TimeZone a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Locale f8603c;

        public i(TimeZone timeZone, boolean z, int i2, Locale locale) {
            this.a = timeZone;
            if (z) {
                this.f8602b = Integer.MIN_VALUE | i2;
            } else {
                this.f8602b = i2;
            }
            this.f8603c = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return this.a.equals(iVar.a) && this.f8602b == iVar.f8602b && this.f8603c.equals(iVar.f8603c);
        }

        public int hashCode() {
            return this.a.hashCode() + ((this.f8603c.hashCode() + (this.f8602b * 31)) * 31);
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class j implements f {
        public final Locale a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f8605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f8606d;

        public j(TimeZone timeZone, Locale locale, int i2) {
            this.a = locale;
            this.f8604b = i2;
            this.f8605c = d.getTimeZoneDisplay(timeZone, false, i2, locale);
            this.f8606d = d.getTimeZoneDisplay(timeZone, true, i2, locale);
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return Math.max(this.f8605c.length(), this.f8606d.length());
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            TimeZone timeZone = calendar.getTimeZone();
            if (calendar.get(16) == 0) {
                appendable.append(d.getTimeZoneDisplay(timeZone, false, this.f8604b, this.a));
            } else {
                appendable.append(d.getTimeZoneDisplay(timeZone, true, this.f8604b, this.a));
            }
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class k implements f {
        public static final k a = new k(true);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final k f8607b = new k(false);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f8608c;

        public k(boolean z) {
            this.f8608c = z;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return 5;
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            int i2 = calendar.get(16) + calendar.get(15);
            if (i2 < 0) {
                appendable.append('-');
                i2 = -i2;
            } else {
                appendable.append('+');
            }
            int i3 = i2 / BaseConstants.Time.HOUR;
            d.access$000(appendable, i3);
            if (this.f8608c) {
                appendable.append(':');
            }
            d.access$000(appendable, (i2 / BaseConstants.Time.MINUTE) - (i3 * 60));
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class l implements InterfaceC0228d {
        public final InterfaceC0228d a;

        public l(InterfaceC0228d interfaceC0228d) {
            this.a = interfaceC0228d;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return this.a.a();
        }

        @Override // k.b.a.a.j.d.InterfaceC0228d
        public void b(Appendable appendable, int i2) {
            this.a.b(appendable, i2);
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) {
            int leastMaximum = calendar.get(10);
            if (leastMaximum == 0) {
                leastMaximum = calendar.getLeastMaximum(10) + 1;
            }
            this.a.b(appendable, leastMaximum);
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class m implements InterfaceC0228d {
        public final InterfaceC0228d a;

        public m(InterfaceC0228d interfaceC0228d) {
            this.a = interfaceC0228d;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return this.a.a();
        }

        @Override // k.b.a.a.j.d.InterfaceC0228d
        public void b(Appendable appendable, int i2) {
            this.a.b(appendable, i2);
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) {
            int maximum = calendar.get(11);
            if (maximum == 0) {
                maximum = calendar.getMaximum(11) + 1;
            }
            this.a.b(appendable, maximum);
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class n implements InterfaceC0228d {
        public static final n a = new n();

        @Override // k.b.a.a.j.d.f
        public int a() {
            return 2;
        }

        @Override // k.b.a.a.j.d.InterfaceC0228d
        public final void b(Appendable appendable, int i2) throws IOException {
            d.access$000(appendable, i2);
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            d.access$000(appendable, calendar.get(2) + 1);
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class o implements InterfaceC0228d {
        public final int a;

        public o(int i2) {
            this.a = i2;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return 2;
        }

        @Override // k.b.a.a.j.d.InterfaceC0228d
        public final void b(Appendable appendable, int i2) throws IOException {
            if (i2 < 100) {
                d.access$000(appendable, i2);
            } else {
                d.access$100(appendable, i2, 2);
            }
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            b(appendable, calendar.get(this.a));
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class p implements InterfaceC0228d {
        public static final p a = new p();

        @Override // k.b.a.a.j.d.f
        public int a() {
            return 2;
        }

        @Override // k.b.a.a.j.d.InterfaceC0228d
        public final void b(Appendable appendable, int i2) throws IOException {
            d.access$000(appendable, i2);
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            d.access$000(appendable, calendar.get(1) % 100);
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class q implements InterfaceC0228d {
        public static final q a = new q();

        @Override // k.b.a.a.j.d.f
        public int a() {
            return 2;
        }

        @Override // k.b.a.a.j.d.InterfaceC0228d
        public final void b(Appendable appendable, int i2) throws IOException {
            if (i2 < 10) {
                appendable.append((char) (i2 + 48));
            } else {
                d.access$000(appendable, i2);
            }
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            b(appendable, calendar.get(2) + 1);
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class r implements InterfaceC0228d {
        public final int a;

        public r(int i2) {
            this.a = i2;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return 4;
        }

        @Override // k.b.a.a.j.d.InterfaceC0228d
        public final void b(Appendable appendable, int i2) throws IOException {
            if (i2 < 10) {
                appendable.append((char) (i2 + 48));
            } else if (i2 < 100) {
                d.access$000(appendable, i2);
            } else {
                d.access$100(appendable, i2, 1);
            }
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) throws IOException {
            b(appendable, calendar.get(this.a));
        }
    }

    /* JADX INFO: compiled from: FastDatePrinter.java */
    public static class s implements InterfaceC0228d {
        public final InterfaceC0228d a;

        public s(InterfaceC0228d interfaceC0228d) {
            this.a = interfaceC0228d;
        }

        @Override // k.b.a.a.j.d.f
        public int a() {
            return this.a.a();
        }

        @Override // k.b.a.a.j.d.InterfaceC0228d
        public void b(Appendable appendable, int i2) {
            this.a.b(appendable, i2);
        }

        @Override // k.b.a.a.j.d.f
        public void c(Appendable appendable, Calendar calendar) {
            this.a.b(appendable, calendar.getWeekYear());
        }
    }

    public d(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        b();
    }

    public static void access$000(Appendable appendable, int i2) throws IOException {
        appendable.append((char) ((i2 / 10) + 48));
        appendable.append((char) ((i2 % 10) + 48));
    }

    public static void access$100(Appendable appendable, int i2, int i3) throws IOException {
        if (i2 < 10000) {
            int i4 = i2 < 1000 ? i2 < 100 ? i2 < 10 ? 1 : 2 : 3 : 4;
            for (int i5 = i3 - i4; i5 > 0; i5--) {
                appendable.append('0');
            }
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            return;
                        }
                        appendable.append((char) ((i2 / 1000) + 48));
                        i2 %= 1000;
                    }
                    if (i2 >= 100) {
                        appendable.append((char) ((i2 / 100) + 48));
                        i2 %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i2 >= 10) {
                    appendable.append((char) ((i2 / 10) + 48));
                    i2 %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i2 + 48));
            return;
        }
        char[] cArr = new char[10];
        int i6 = 0;
        while (i2 != 0) {
            cArr[i6] = (char) ((i2 % 10) + 48);
            i2 /= 10;
            i6++;
        }
        while (i6 < i3) {
            appendable.append('0');
            i3--;
        }
        while (true) {
            i6--;
            if (i6 < 0) {
                return;
            } else {
                appendable.append(cArr[i6]);
            }
        }
    }

    public static String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i2, Locale locale) {
        i iVar = new i(timeZone, z, i2, locale);
        ConcurrentMap<i, String> concurrentMap = a;
        String str = concurrentMap.get(iVar);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z, i2, locale);
        String strPutIfAbsent = concurrentMap.putIfAbsent(iVar, displayName);
        return strPutIfAbsent != null ? strPutIfAbsent : displayName;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        b();
    }

    public final <B extends Appendable> B a(Calendar calendar, B b2) throws IOException {
        try {
            for (f fVar : this.f8595b) {
                fVar.c(b2, calendar);
            }
            return b2;
        } catch (IOException e2) {
            throw e2;
        }
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) throws IOException {
        a(calendar, stringBuffer);
        return stringBuffer;
    }

    public final void b() {
        int iA = 0;
        f[] fVarArr = (f[]) parsePattern().toArray(new f[0]);
        this.f8595b = fVarArr;
        int length = fVarArr.length;
        while (true) {
            length--;
            if (length < 0) {
                this.f8596c = iA;
                return;
            }
            iA += this.f8595b[length].a();
        }
    }

    public final Calendar c() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.mPattern.equals(dVar.mPattern) && this.mTimeZone.equals(dVar.mTimeZone) && this.mLocale.equals(dVar.mLocale);
    }

    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sbR = c.a.a.a.a.r("Unknown class: ");
        sbR.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sbR.toString());
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.f8596c;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return (((this.mLocale.hashCode() * 13) + this.mTimeZone.hashCode()) * 13) + this.mPattern.hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<k.b.a.a.j.d.f> parsePattern() {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.b.a.a.j.d.parsePattern():java.util.List");
    }

    public String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = iArr[0];
        int length = str.length();
        char cCharAt = str.charAt(i2);
        if ((cCharAt < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z')) {
            sb.append('\'');
            boolean z = false;
            while (i2 < length) {
                char cCharAt2 = str.charAt(i2);
                if (cCharAt2 != '\'') {
                    if (!z && ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || (cCharAt2 >= 'a' && cCharAt2 <= 'z'))) {
                        i2--;
                        break;
                    }
                    sb.append(cCharAt2);
                } else {
                    int i3 = i2 + 1;
                    if (i3 >= length || str.charAt(i3) != '\'') {
                        z = !z;
                    } else {
                        sb.append(cCharAt2);
                        i2 = i3;
                    }
                }
                i2++;
            }
        } else {
            sb.append(cCharAt);
            while (true) {
                int i4 = i2 + 1;
                if (i4 >= length || str.charAt(i4) != cCharAt) {
                    break;
                }
                sb.append(cCharAt);
                i2 = i4;
            }
        }
        iArr[0] = i2;
        return sb.toString();
    }

    public InterfaceC0228d selectNumberRule(int i2, int i3) {
        return i3 != 1 ? i3 != 2 ? new e(i2, i3) : new o(i2) : new r(i2);
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("FastDatePrinter[");
        sbR.append(this.mPattern);
        sbR.append(",");
        sbR.append(this.mLocale);
        sbR.append(",");
        sbR.append(this.mTimeZone.getID());
        sbR.append("]");
        return sbR.toString();
    }

    public String format(Object obj) {
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        StringBuilder sbR = c.a.a.a.a.r("Unknown class: ");
        sbR.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sbR.toString());
    }

    public String format(long j2) throws IOException {
        Calendar calendarC = c();
        calendarC.setTimeInMillis(j2);
        StringBuilder sb = new StringBuilder(this.f8596c);
        a(calendarC, sb);
        return sb.toString();
    }

    public String format(Date date) throws IOException {
        Calendar calendarC = c();
        calendarC.setTime(date);
        StringBuilder sb = new StringBuilder(this.f8596c);
        a(calendarC, sb);
        return sb.toString();
    }

    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, new StringBuilder(this.f8596c))).toString();
    }

    public StringBuffer format(long j2, StringBuffer stringBuffer) throws IOException {
        Calendar calendarC = c();
        calendarC.setTimeInMillis(j2);
        a(calendarC, stringBuffer);
        return stringBuffer;
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) throws IOException {
        Calendar calendarC = c();
        calendarC.setTime(date);
        a(calendarC, stringBuffer);
        return stringBuffer;
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    public <B extends Appendable> B format(long j2, B b2) throws IOException {
        Calendar calendarC = c();
        calendarC.setTimeInMillis(j2);
        a(calendarC, b2);
        return b2;
    }

    public <B extends Appendable> B format(Date date, B b2) throws IOException {
        Calendar calendarC = c();
        calendarC.setTime(date);
        a(calendarC, b2);
        return b2;
    }

    public <B extends Appendable> B format(Calendar calendar, B b2) throws IOException {
        if (!calendar.getTimeZone().equals(this.mTimeZone)) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        a(calendar, b2);
        return b2;
    }
}
