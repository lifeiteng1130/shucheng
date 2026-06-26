package com.umeng.commonsdk.vchannel;

/* JADX INFO: compiled from: Constant.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static String a = "https://pslog.umeng.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f5429b = "https://pslog.umeng.com/";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f5430c = "explog";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5431d = "analytics";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5432e = "ekv";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5433f = "id";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5434g = "ts";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5435h = "ds";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f5436i = "pn";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f5437j = "";

    static {
        String strF = c.a.a.a.a.f("SUB", System.currentTimeMillis());
        StringBuilder sbR = c.a.a.a.a.r(strF);
        StringBuilder sbR2 = c.a.a.a.a.r("%0");
        sbR2.append(32 - strF.length());
        sbR2.append("d");
        sbR.append(String.format(sbR2.toString(), 0));
        f5437j = sbR.toString();
    }
}
