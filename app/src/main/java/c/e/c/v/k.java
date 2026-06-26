package c.e.c.v;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f1403b;

    static {
        String strName = Charset.defaultCharset().name();
        a = strName;
        f1403b = "SJIS".equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }
}
