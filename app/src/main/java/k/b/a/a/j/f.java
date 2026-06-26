package k.b.a.a.j;

import j$.util.concurrent.ConcurrentHashMap;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: FormatCache.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f<F extends Format> {
    public static final ConcurrentMap<a, String> a = new ConcurrentHashMap(7);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<a, F> f8610b = new ConcurrentHashMap(7);

    /* JADX INFO: compiled from: FormatCache.java */
    public static class a {
        public final Object[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8611b;

        public a(Object... objArr) {
            this.a = objArr;
        }

        public boolean equals(Object obj) {
            return Arrays.equals(this.a, ((a) obj).a);
        }

        public int hashCode() {
            if (this.f8611b == 0) {
                int iHashCode = 0;
                for (Object obj : this.a) {
                    if (obj != null) {
                        iHashCode = obj.hashCode() + (iHashCode * 7);
                    }
                }
                this.f8611b = iHashCode;
            }
            return this.f8611b;
        }
    }

    public F a(int i2, int i3, TimeZone timeZone, Locale locale) {
        return (F) b(Integer.valueOf(i2), Integer.valueOf(i3), timeZone, locale);
    }

    public final F b(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        a aVar = new a(num, num2, locale);
        ConcurrentMap<a, String> concurrentMap = a;
        String pattern = concurrentMap.get(aVar);
        if (pattern == null) {
            try {
                pattern = ((SimpleDateFormat) (num == null ? DateFormat.getTimeInstance(num2.intValue(), locale) : num2 == null ? DateFormat.getDateInstance(num.intValue(), locale) : DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale))).toPattern();
                String strPutIfAbsent = concurrentMap.putIfAbsent(aVar, pattern);
                if (strPutIfAbsent != null) {
                    pattern = strPutIfAbsent;
                }
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("No date time pattern for locale: " + locale);
            }
        }
        return (F) c(pattern, timeZone, locale);
    }

    public F c(String str, TimeZone timeZone, Locale locale) {
        c.b.a.m.f.e4(str, "pattern must not be null", new Object[0]);
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        a aVar = new a(str, timeZone, locale);
        F f2 = this.f8610b.get(aVar);
        if (f2 != null) {
            return f2;
        }
        b bVar = new b(str, timeZone, locale);
        F fPutIfAbsent = this.f8610b.putIfAbsent(aVar, bVar);
        return fPutIfAbsent != null ? fPutIfAbsent : bVar;
    }
}
