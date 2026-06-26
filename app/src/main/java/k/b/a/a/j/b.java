package k.b.a.a.j;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: compiled from: FastDateFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends Format {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    public static final f<b> a = new a();
    private static final long serialVersionUID = 2;
    private final c parser;
    private final d printer;

    /* JADX INFO: compiled from: FastDateFormat.java */
    public static class a extends f<b> {
    }

    public b(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    public static b getDateInstance(int i2) {
        return (b) a.b(Integer.valueOf(i2), null, null, null);
    }

    public static b getDateTimeInstance(int i2, int i3) {
        return (b) a.b(Integer.valueOf(i2), Integer.valueOf(i3), null, null);
    }

    public static b getInstance() {
        f<b> fVar = a;
        Objects.requireNonNull(fVar);
        return (b) fVar.a(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public static b getTimeInstance(int i2) {
        return (b) a.b(null, Integer.valueOf(i2), null, null);
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.applyRules(calendar, stringBuffer);
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.printer.equals(((b) obj).printer);
        }
        return false;
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer.append(this.printer.format(obj));
        return stringBuffer;
    }

    public Locale getLocale() {
        return this.printer.getLocale();
    }

    public int getMaxLengthEstimate() {
        return this.printer.getMaxLengthEstimate();
    }

    public String getPattern() {
        return this.printer.getPattern();
    }

    public TimeZone getTimeZone() {
        return this.printer.getTimeZone();
    }

    public int hashCode() {
        return this.printer.hashCode();
    }

    public Date parse(String str) {
        return this.parser.parse(str);
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.parser.parseObject(str, parsePosition);
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("FastDateFormat[");
        sbR.append(this.printer.getPattern());
        sbR.append(",");
        sbR.append(this.printer.getLocale());
        sbR.append(",");
        sbR.append(this.printer.getTimeZone().getID());
        sbR.append("]");
        return sbR.toString();
    }

    public b(String str, TimeZone timeZone, Locale locale, Date date) {
        this.printer = new d(str, timeZone, locale);
        this.parser = new c(str, timeZone, locale, date);
    }

    public String format(long j2) {
        return this.printer.format(j2);
    }

    public Date parse(String str, ParsePosition parsePosition) {
        return this.parser.parse(str, parsePosition);
    }

    public String format(Date date) {
        return this.printer.format(date);
    }

    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        return this.parser.parse(str, parsePosition, calendar);
    }

    public static b getDateInstance(int i2, Locale locale) {
        return (b) a.b(Integer.valueOf(i2), null, null, locale);
    }

    public static b getDateTimeInstance(int i2, int i3, Locale locale) {
        return (b) a.b(Integer.valueOf(i2), Integer.valueOf(i3), null, locale);
    }

    public static b getTimeInstance(int i2, Locale locale) {
        return (b) a.b(null, Integer.valueOf(i2), null, locale);
    }

    public String format(Calendar calendar) {
        return this.printer.format(calendar);
    }

    public static b getInstance(String str) {
        return (b) a.c(str, null, null);
    }

    @Deprecated
    public StringBuffer format(long j2, StringBuffer stringBuffer) {
        return this.printer.format(j2, stringBuffer);
    }

    public static b getInstance(String str, TimeZone timeZone) {
        return (b) a.c(str, timeZone, null);
    }

    @Deprecated
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        return this.printer.format(date, stringBuffer);
    }

    public static b getDateInstance(int i2, TimeZone timeZone) {
        return (b) a.b(Integer.valueOf(i2), null, timeZone, null);
    }

    public static b getDateTimeInstance(int i2, int i3, TimeZone timeZone) {
        return getDateTimeInstance(i2, i3, timeZone, null);
    }

    public static b getInstance(String str, Locale locale) {
        return (b) a.c(str, null, locale);
    }

    public static b getTimeInstance(int i2, TimeZone timeZone) {
        return (b) a.b(null, Integer.valueOf(i2), timeZone, null);
    }

    @Deprecated
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.format(calendar, stringBuffer);
    }

    public static b getDateTimeInstance(int i2, int i3, TimeZone timeZone, Locale locale) {
        return (b) a.b(Integer.valueOf(i2), Integer.valueOf(i3), timeZone, locale);
    }

    public static b getInstance(String str, TimeZone timeZone, Locale locale) {
        return (b) a.c(str, timeZone, locale);
    }

    public <B extends Appendable> B format(long j2, B b2) {
        return (B) this.printer.format(j2, b2);
    }

    public <B extends Appendable> B format(Date date, B b2) {
        return (B) this.printer.format(date, b2);
    }

    public static b getDateInstance(int i2, TimeZone timeZone, Locale locale) {
        return (b) a.b(Integer.valueOf(i2), null, timeZone, locale);
    }

    public static b getTimeInstance(int i2, TimeZone timeZone, Locale locale) {
        return (b) a.b(null, Integer.valueOf(i2), timeZone, locale);
    }

    public <B extends Appendable> B format(Calendar calendar, B b2) {
        return (B) this.printer.format(calendar, b2);
    }
}
