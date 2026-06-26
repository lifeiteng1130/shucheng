package com.efs.sdk.base.a.i;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.efs.sdk.base.a.d.a f1857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f1858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f1859d;

    public static class a {
        private static final f a = new f(0);
    }

    public /* synthetic */ f(byte b2) {
        this();
    }

    public final void a(String str, String str2, String str3) {
        this.f1859d.a(str, str2, str3);
    }

    private f() {
        this.a = new c();
        this.f1858c = new d();
        this.f1859d = new g();
    }

    public final void a(int i2) {
        com.efs.sdk.base.a.d.a aVar = this.f1857b;
        if (aVar != null) {
            aVar.a(a("flow_limit", i2));
        }
    }

    public final void a(int i2, String str) {
        if (this.f1857b != null || com.efs.sdk.base.a.d.a.a().f1777d) {
            b bVarA = a("flow_limit_type", i2);
            bVarA.put("code", str);
            this.f1857b.a(bVarA);
        }
    }

    public final b a(String str, int i2) {
        b bVar = new b("efs_core", str, this.a.f1851c);
        bVar.put("cver", Integer.valueOf(i2));
        return bVar;
    }
}
