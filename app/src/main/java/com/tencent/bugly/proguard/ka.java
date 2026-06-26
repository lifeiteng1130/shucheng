package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class ka extends AbstractC0320m implements Cloneable {
    public String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4385b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4386c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4387d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4388e = "";

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.a, 0);
        String str = this.f4385b;
        if (str != null) {
            c0319l.a(str, 1);
        }
        String str2 = this.f4386c;
        if (str2 != null) {
            c0319l.a(str2, 2);
        }
        String str3 = this.f4387d;
        if (str3 != null) {
            c0319l.a(str3, 3);
        }
        String str4 = this.f4388e;
        if (str4 != null) {
            c0319l.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.a = c0318k.a(0, true);
        this.f4385b = c0318k.a(1, false);
        this.f4386c = c0318k.a(2, false);
        this.f4387d = c0318k.a(3, false);
        this.f4388e = c0318k.a(4, false);
    }
}
