package k.c.c.v;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: Html5Entities.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final Map<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f8712b;

    static {
        HashMap map = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(b.class.getResourceAsStream("/org/commonmark/internal/util/entities.properties"), Charset.forName(DataUtil.defaultCharset)));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        map.put("NewLine", "\n");
                        a = map;
                        f8712b = Pattern.compile("^&#[Xx]?");
                        return;
                    }
                    if (line.length() != 0) {
                        int iIndexOf = line.indexOf("=");
                        map.put(line.substring(0, iIndexOf), line.substring(iIndexOf + 1));
                    }
                } finally {
                }
            }
        } catch (IOException e2) {
            throw new IllegalStateException("Failed reading data for HTML named character references", e2);
        }
    }

    public static String a(String str) {
        Matcher matcher = f8712b.matcher(str);
        if (!matcher.find()) {
            String str2 = a.get(c.a.a.a.a.c(str, 1, 1));
            return str2 != null ? str2 : str;
        }
        try {
            int i2 = Integer.parseInt(str.substring(matcher.end(), str.length() - 1), matcher.end() == 2 ? 10 : 16);
            return i2 == 0 ? "�" : new String(Character.toChars(i2));
        } catch (IllegalArgumentException unused) {
            return "�";
        }
    }
}
