package k.b.a.a.j;

import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: FastTimeZone.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final Pattern a = Pattern.compile("^(?:(?i)GMT)?([+-])?(\\d\\d?)?(:?(\\d\\d?))?$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeZone f8609b = new g(false, 0, 0);

    public static TimeZone a(String str) {
        if ("Z".equals(str) || "UTC".equals(str)) {
            return f8609b;
        }
        Matcher matcher = a.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(2);
        boolean z = false;
        int i2 = strGroup != null ? Integer.parseInt(strGroup) : 0;
        String strGroup2 = matcher.group(4);
        int i3 = strGroup2 != null ? Integer.parseInt(strGroup2) : 0;
        if (i2 == 0 && i3 == 0) {
            return f8609b;
        }
        String strGroup3 = matcher.group(1);
        if (strGroup3 != null && strGroup3.charAt(0) == '-') {
            z = true;
        }
        return new g(z, i2, i3);
    }
}
