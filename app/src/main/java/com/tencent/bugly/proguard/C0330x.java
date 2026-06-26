package com.tencent.bugly.proguard;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class C0330x extends AbstractC0320m implements Cloneable {
    public static final /* synthetic */ boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4471f;

    public C0330x() {
        this.f4467b = "";
        this.f4468c = "";
        this.f4469d = "";
        this.f4470e = 0L;
        this.f4471f = "";
    }

    public String a() {
        return this.f4468c;
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
        C0330x c0330x = (C0330x) obj;
        return C0321n.a(this.f4467b, c0330x.f4467b) && C0321n.a(this.f4468c, c0330x.f4468c) && C0321n.a(this.f4469d, c0330x.f4469d) && C0321n.a(this.f4470e, c0330x.f4470e) && C0321n.a(this.f4471f, c0330x.f4471f);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4467b, 0);
        c0319l.a(this.f4468c, 1);
        String str = this.f4469d;
        if (str != null) {
            c0319l.a(str, 2);
        }
        c0319l.a(this.f4470e, 3);
        String str2 = this.f4471f;
        if (str2 != null) {
            c0319l.a(str2, 4);
        }
    }

    public C0330x(String str, String str2, String str3, long j2, String str4) {
        this.f4467b = "";
        this.f4468c = "";
        this.f4469d = "";
        this.f4470e = 0L;
        this.f4471f = "";
        this.f4467b = str;
        this.f4468c = str2;
        this.f4469d = str3;
        this.f4470e = j2;
        this.f4471f = str4;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4467b = c0318k.a(0, true);
        this.f4468c = c0318k.a(1, true);
        this.f4469d = c0318k.a(2, false);
        this.f4470e = c0318k.a(this.f4470e, 3, true);
        this.f4471f = c0318k.a(4, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
        C0316i c0316i = new C0316i(sb, i2);
        c0316i.a(this.f4467b, "apkMd5");
        c0316i.a(this.f4468c, "apkUrl");
        c0316i.a(this.f4469d, "manifestMd5");
        c0316i.a(this.f4470e, "fileSize");
        c0316i.a(this.f4471f, "signatureMd5");
    }
}
