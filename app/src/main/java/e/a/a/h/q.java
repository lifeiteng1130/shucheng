package e.a.a.h;

import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HtmlFormatter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    @NotNull
    public static final q a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f.h0.g f5961b = new f.h0.g("</?(?:div|p|br|hr|h\\d|article|dd|dl)[^>]*>");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final f.h0.g f5962c = new f.h0.g("</?(?!img)[a-zA-Z]+(?=[ >])[^<>]*>");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final f.h0.g f5963d = new f.h0.g("</?[a-zA-Z]+(?=[ >])[^<>]*>");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f5964e = Pattern.compile("<img [^>]*src=.*?\"(.*?(?:,\\{.*\\})?)\".*?>");

    @NotNull
    public static final String a(@Nullable String str) {
        if (str == null) {
            return "";
        }
        return c.a.a.a.a.j("[\\n\\s]+$", c.a.a.a.a.j("^[\\n\\s]+", c.a.a.a.a.j("\\s*\\n+\\s*", f5963d.replace(f5961b.replace(str, "\n"), ""), "\n\u3000\u3000"), "\u3000\u3000"), "");
    }

    @NotNull
    public static final String b(@Nullable String str) {
        if (str == null) {
            return "";
        }
        return c.a.a.a.a.j("[\\n\\s]+$", c.a.a.a.a.j("^[\\n\\s]+", c.a.a.a.a.j("\\s*\\n+\\s*", f5962c.replace(f5961b.replace(str, "\n"), ""), "\n\u3000\u3000"), "\u3000\u3000"), "");
    }
}
