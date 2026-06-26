package k.c.c.v;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Escaping.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final Pattern a = Pattern.compile("[\\\\&]");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f8708b = Pattern.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f8709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f8710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f8711e;

    /* JADX INFO: renamed from: k.c.c.v.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Escaping.java */
    public static class C0230a implements b {
        @Override // k.c.c.v.a.b
        public void a(String str, StringBuilder sb) {
            if (str.charAt(0) == '\\') {
                sb.append((CharSequence) str, 1, str.length());
            } else {
                sb.append(k.c.c.v.b.a(str));
            }
        }
    }

    /* JADX INFO: compiled from: Escaping.java */
    public interface b {
        void a(String str, StringBuilder sb);
    }

    static {
        Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
        f8709c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        f8710d = Pattern.compile("[ \t\r\n]+");
        f8711e = new C0230a();
    }

    public static String a(String str) {
        return f8710d.matcher(str.trim().toLowerCase(Locale.ROOT)).replaceAll(" ");
    }

    public static String b(String str) {
        if (!a.matcher(str).find()) {
            return str;
        }
        Pattern pattern = f8708b;
        b bVar = f8711e;
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 16);
        int iEnd = 0;
        do {
            sb.append((CharSequence) str, iEnd, matcher.start());
            bVar.a(matcher.group(), sb);
            iEnd = matcher.end();
        } while (matcher.find());
        if (iEnd != str.length()) {
            sb.append((CharSequence) str, iEnd, str.length());
        }
        return sb.toString();
    }
}
