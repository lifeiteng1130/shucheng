package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TApplicationException.java */
/* JADX INFO: loaded from: classes.dex */
public class ap extends aw {
    public static final int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4703b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4704c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4705d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4706e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4707f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4708g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f4709h = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final bu f4710j = new bu("TApplicationException");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final bk f4711k = new bk("message", (byte) 11, 1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final bk f4712l = new bk("type", (byte) 8, 2);
    private static final long m = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4713i;

    public ap() {
        this.f4713i = 0;
    }

    public int a() {
        return this.f4713i;
    }

    public void b(bp bpVar) {
        bpVar.a(f4710j);
        if (getMessage() != null) {
            bpVar.a(f4711k);
            bpVar.a(getMessage());
            bpVar.c();
        }
        bpVar.a(f4712l);
        bpVar.a(this.f4713i);
        bpVar.c();
        bpVar.d();
        bpVar.b();
    }

    public static ap a(bp bpVar) {
        bpVar.j();
        String strZ = null;
        int iW = 0;
        while (true) {
            bk bkVarL = bpVar.l();
            byte b2 = bkVarL.f4761b;
            if (b2 == 0) {
                bpVar.k();
                return new ap(iW, strZ);
            }
            short s = bkVarL.f4762c;
            if (s != 1) {
                if (s != 2) {
                    bs.a(bpVar, b2);
                } else if (b2 == 8) {
                    iW = bpVar.w();
                } else {
                    bs.a(bpVar, b2);
                }
            } else if (b2 == 11) {
                strZ = bpVar.z();
            } else {
                bs.a(bpVar, b2);
            }
            bpVar.m();
        }
    }

    public ap(int i2) {
        this.f4713i = 0;
        this.f4713i = i2;
    }

    public ap(int i2, String str) {
        super(str);
        this.f4713i = 0;
        this.f4713i = i2;
    }

    public ap(String str) {
        super(str);
        this.f4713i = 0;
    }
}
