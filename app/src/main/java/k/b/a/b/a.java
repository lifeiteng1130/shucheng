package k.b.a.b;

import h.a.a.a.w;
import java.io.IOException;
import java.io.StringWriter;
import java.security.InvalidParameterException;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import k.b.a.b.c.b;
import k.b.a.b.c.d;
import k.b.a.b.c.e;
import k.b.a.b.c.f;
import k.b.a.b.c.g;
import k.b.a.b.c.h;
import k.b.a.b.c.i;
import k.b.a.b.c.j;
import k.b.a.b.c.k;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: StringEscapeUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8612b;

    static {
        HashMap map = new HashMap();
        map.put("\"", "\\\"");
        map.put("\\", "\\\\");
        Map<CharSequence, CharSequence> map2 = d.f8621i;
        new k.b.a.b.c.a(new f(Collections.unmodifiableMap(map)), new f(map2), e.d(32, 127));
        HashMap map3 = new HashMap();
        map3.put("'", "\\'");
        map3.put("\"", "\\\"");
        map3.put("\\", "\\\\");
        map3.put(w.DEFAULT_PATH_SEPARATOR, "\\/");
        new k.b.a.b.c.a(new f(Collections.unmodifiableMap(map3)), new f(map2), e.d(32, 127));
        HashMap map4 = new HashMap();
        map4.put("\"", "\\\"");
        map4.put("\\", "\\\\");
        map4.put(w.DEFAULT_PATH_SEPARATOR, "\\/");
        new k.b.a.b.c.a(new f(Collections.unmodifiableMap(map4)), new f(map2), e.d(32, 126));
        HashMap map5 = new HashMap();
        map5.put("\u0000", "");
        map5.put("\u0001", "");
        map5.put("\u0002", "");
        map5.put("\u0003", "");
        map5.put("\u0004", "");
        map5.put("\u0005", "");
        map5.put("\u0006", "");
        map5.put("\u0007", "");
        map5.put("\b", "");
        map5.put("\u000b", "");
        map5.put("\f", "");
        map5.put("\u000e", "");
        map5.put("\u000f", "");
        map5.put("\u0010", "");
        map5.put("\u0011", "");
        map5.put("\u0012", "");
        map5.put("\u0013", "");
        map5.put("\u0014", "");
        map5.put("\u0015", "");
        map5.put("\u0016", "");
        map5.put("\u0017", "");
        map5.put("\u0018", "");
        map5.put("\u0019", "");
        map5.put("\u001a", "");
        map5.put("\u001b", "");
        map5.put("\u001c", "");
        map5.put("\u001d", "");
        map5.put("\u001e", "");
        map5.put("\u001f", "");
        map5.put("\ufffe", "");
        map5.put("\uffff", "");
        Map<CharSequence, CharSequence> map6 = d.f8617e;
        Map<CharSequence, CharSequence> map7 = d.f8619g;
        new k.b.a.b.c.a(new f(map6), new f(map7), new f(Collections.unmodifiableMap(map5)), g.d(127, Token.TARGET), g.d(Token.EXPR_VOID, Token.LETEXPR), new k());
        HashMap map8 = new HashMap();
        map8.put("\u0000", "");
        map8.put("\u000b", "&#11;");
        map8.put("\f", "&#12;");
        map8.put("\ufffe", "");
        map8.put("\uffff", "");
        new k.b.a.b.c.a(new f(map6), new f(map7), new f(Collections.unmodifiableMap(map8)), g.d(1, 8), g.d(14, 31), g.d(127, Token.TARGET), g.d(Token.EXPR_VOID, Token.LETEXPR), new k());
        Map<CharSequence, CharSequence> map9 = d.a;
        new k.b.a.b.c.a(new f(map6), new f(map9));
        new k.b.a.b.c.a(new f(map6), new f(map9), new f(d.f8615c));
        HashMap map10 = new HashMap();
        map10.put("|", "\\|");
        map10.put("&", "\\&");
        map10.put(";", "\\;");
        map10.put("<", "\\<");
        map10.put(">", "\\>");
        map10.put("(", "\\(");
        map10.put(")", "\\)");
        map10.put("$", "\\$");
        map10.put("`", "\\`");
        map10.put("\\", "\\\\");
        map10.put("\"", "\\\"");
        map10.put("'", "\\'");
        map10.put(" ", "\\ ");
        map10.put("\t", "\\\t");
        map10.put("\r\n", "");
        map10.put("\n", "");
        map10.put("*", "\\*");
        map10.put("?", "\\?");
        map10.put("[", "\\[");
        map10.put("#", "\\#");
        map10.put("~", "\\~");
        map10.put("=", "\\=");
        map10.put("%", "\\%");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map10);
        if (mapUnmodifiableMap == null) {
            throw new InvalidParameterException("lookupMap cannot be null");
        }
        HashMap map11 = new HashMap();
        BitSet bitSet = new BitSet();
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            map11.put(((CharSequence) entry.getKey()).toString(), ((CharSequence) entry.getValue()).toString());
            bitSet.set(((CharSequence) entry.getKey()).charAt(0));
            int length = ((CharSequence) entry.getKey()).length();
            if (length < i2) {
                i2 = length;
            }
            if (length > i3) {
                i3 = length;
            }
        }
        HashMap map12 = new HashMap();
        map12.put("\\\\", "\\");
        map12.put("\\\"", "\"");
        map12.put("\\'", "'");
        map12.put("\\", "");
        k.b.a.b.c.a aVar = new k.b.a.b.c.a(new i(), new j(), new f(d.f8622j), new f(Collections.unmodifiableMap(map12)));
        a = aVar;
        f8612b = aVar;
        Map<CharSequence, CharSequence> map13 = d.f8618f;
        Map<CharSequence, CharSequence> map14 = d.f8614b;
        new k.b.a.b.c.a(new f(map13), new f(map14), new h(new h.a[0]));
        new k.b.a.b.c.a(new f(map13), new f(map14), new f(d.f8616d), new h(new h.a[0]));
        new k.b.a.b.c.a(new f(map13), new f(d.f8620h), new h(new h.a[0]));
    }

    public static final String a(String str) {
        b bVar = f8612b;
        Objects.requireNonNull(bVar);
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(str.length() * 2);
            bVar.b(str, stringWriter);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
