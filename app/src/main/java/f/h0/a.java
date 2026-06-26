package f.h0;

import java.nio.charset.Charset;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    @JvmField
    @NotNull
    public static final Charset a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Charset f6142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Charset f6143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f6144d = null;

    static {
        Charset charsetForName = Charset.forName(DataUtil.defaultCharset);
        f.c0.c.j.d(charsetForName, "Charset.forName(\"UTF-8\")");
        a = charsetForName;
        f.c0.c.j.d(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        f.c0.c.j.d(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        f.c0.c.j.d(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        f.c0.c.j.d(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        f.c0.c.j.d(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }
}
