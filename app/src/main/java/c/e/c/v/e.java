package c.e.c.v;

import java.util.List;

/* JADX INFO: compiled from: DecoderResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<byte[]> f1385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f1387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1389h;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.a = bArr;
        this.f1383b = bArr == null ? 0 : bArr.length * 8;
        this.f1384c = str;
        this.f1385d = list;
        this.f1386e = str2;
        this.f1388g = i3;
        this.f1389h = i2;
    }
}
