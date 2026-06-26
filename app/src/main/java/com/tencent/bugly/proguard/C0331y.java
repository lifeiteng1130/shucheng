package com.tencent.bugly.proguard;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class C0331y extends AbstractC0320m implements Cloneable {
    public static final /* synthetic */ boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f4473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4480j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f4481k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4482l;

    public C0331y() {
        this.f4472b = "";
        this.f4473c = (byte) 0;
        this.f4474d = 0;
        this.f4475e = "";
        this.f4476f = 0;
        this.f4477g = "";
        this.f4478h = 0L;
        this.f4479i = "";
        this.f4480j = "";
        this.f4481k = "";
        this.f4482l = "";
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4472b, 0);
        c0319l.a(this.f4473c, 1);
        c0319l.a(this.f4474d, 2);
        String str = this.f4475e;
        if (str != null) {
            c0319l.a(str, 3);
        }
        c0319l.a(this.f4476f, 4);
        String str2 = this.f4477g;
        if (str2 != null) {
            c0319l.a(str2, 5);
        }
        c0319l.a(this.f4478h, 6);
        String str3 = this.f4479i;
        if (str3 != null) {
            c0319l.a(str3, 7);
        }
        String str4 = this.f4480j;
        if (str4 != null) {
            c0319l.a(str4, 8);
        }
        String str5 = this.f4481k;
        if (str5 != null) {
            c0319l.a(str5, 9);
        }
        String str6 = this.f4482l;
        if (str6 != null) {
            c0319l.a(str6, 10);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (a) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0331y c0331y = (C0331y) obj;
        return C0321n.a(this.f4472b, c0331y.f4472b) && C0321n.a(this.f4473c, c0331y.f4473c) && C0321n.a(this.f4474d, c0331y.f4474d) && C0321n.a(this.f4475e, c0331y.f4475e) && C0321n.a(this.f4476f, c0331y.f4476f) && C0321n.a(this.f4477g, c0331y.f4477g) && C0321n.a(this.f4478h, c0331y.f4478h) && C0321n.a(this.f4479i, c0331y.f4479i) && C0321n.a(this.f4480j, c0331y.f4480j) && C0321n.a(this.f4481k, c0331y.f4481k) && C0321n.a(this.f4482l, c0331y.f4482l);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public C0331y(String str, byte b2, int i2, String str2, int i3, String str3, long j2, String str4, String str5, String str6, String str7) {
        this.f4472b = "";
        this.f4473c = (byte) 0;
        this.f4474d = 0;
        this.f4475e = "";
        this.f4476f = 0;
        this.f4477g = "";
        this.f4478h = 0L;
        this.f4479i = "";
        this.f4480j = "";
        this.f4481k = "";
        this.f4482l = "";
        this.f4472b = str;
        this.f4473c = b2;
        this.f4474d = i2;
        this.f4475e = str2;
        this.f4476f = i3;
        this.f4477g = str3;
        this.f4478h = j2;
        this.f4479i = str4;
        this.f4480j = str5;
        this.f4481k = str6;
        this.f4482l = str7;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4472b = c0318k.a(0, true);
        this.f4473c = c0318k.a(this.f4473c, 1, true);
        this.f4474d = c0318k.a(this.f4474d, 2, true);
        this.f4475e = c0318k.a(3, false);
        this.f4476f = c0318k.a(this.f4476f, 4, false);
        this.f4477g = c0318k.a(5, false);
        this.f4478h = c0318k.a(this.f4478h, 6, false);
        this.f4479i = c0318k.a(7, false);
        this.f4480j = c0318k.a(8, false);
        this.f4481k = c0318k.a(9, false);
        this.f4482l = c0318k.a(10, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
        C0316i c0316i = new C0316i(sb, i2);
        c0316i.a(this.f4472b, "appId");
        c0316i.a(this.f4473c, "platformId");
        c0316i.a(this.f4474d, "versionCode");
        c0316i.a(this.f4475e, "versionName");
        c0316i.a(this.f4476f, "buildNo");
        c0316i.a(this.f4477g, "iconUrl");
        c0316i.a(this.f4478h, "apkId");
        c0316i.a(this.f4479i, "channelId");
        c0316i.a(this.f4480j, "md5");
        c0316i.a(this.f4481k, "sdkVer");
        c0316i.a(this.f4482l, "bundleId");
    }
}
