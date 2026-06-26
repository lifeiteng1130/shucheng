package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class D extends AbstractC0320m implements Cloneable {
    public static sa a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static B f4260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f4261c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public sa f4262d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public B f4263e = null;

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        sa saVar = this.f4262d;
        if (saVar != null) {
            c0319l.a((AbstractC0320m) saVar, 0);
        }
        B b2 = this.f4263e;
        if (b2 != null) {
            c0319l.a((AbstractC0320m) b2, 1);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f4261c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        D d2 = (D) obj;
        return C0321n.a(this.f4262d, d2.f4262d) && C0321n.a(this.f4263e, d2.f4263e);
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
    public void a(C0318k c0318k) {
        if (a == null) {
            a = new sa();
        }
        this.f4262d = (sa) c0318k.a((AbstractC0320m) a, 0, false);
        if (f4260b == null) {
            f4260b = new B();
        }
        this.f4263e = (B) c0318k.a((AbstractC0320m) f4260b, 1, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
        C0316i c0316i = new C0316i(sb, i2);
        c0316i.a((AbstractC0320m) this.f4262d, "baseStrategy");
        c0316i.a((AbstractC0320m) this.f4263e, "grayStrategy");
    }
}
