package e.a.a.c;

import f.c0.c.j;
import f.h0.g;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AppPattern.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    @NotNull
    public static final d a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Pattern f5508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Pattern f5509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Pattern f5510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final g f5511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final g f5512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final g f5513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final g f5514h;

    static {
        Pattern patternCompile = Pattern.compile("(<js>[\\w\\W]*?</js>|@js:[\\w\\W]*$)", 2);
        j.d(patternCompile, "compile(\"(<js>[\\\\w\\\\W]*?</js>|@js:[\\\\w\\\\W]*$)\", Pattern.CASE_INSENSITIVE)");
        f5508b = patternCompile;
        Pattern patternCompile2 = Pattern.compile("\\{\\{([\\w\\W]*?)\\}\\}");
        j.d(patternCompile2, "compile(\"\\\\{\\\\{([\\\\w\\\\W]*?)\\\\}\\\\}\")");
        f5509c = patternCompile2;
        Pattern patternCompile3 = Pattern.compile("<img .*?src.*?=.*?\"(.*?(?:,\\{.*\\})?)\".*?>", 2);
        j.d(patternCompile3, "compile(\"<img .*?src.*?=.*?\\\"(.*?(?:,\\\\{.*\\\\})?)\\\".*?>\", Pattern.CASE_INSENSITIVE)");
        f5510d = patternCompile3;
        f5511e = new g("\\s+作\\s*者.*");
        f5512f = new g(".*?作\\s*?者[:：]");
        f5513g = new g("[\\\\/:*?\"<>|.]");
        f5514h = new g("[,;，；]");
    }
}
