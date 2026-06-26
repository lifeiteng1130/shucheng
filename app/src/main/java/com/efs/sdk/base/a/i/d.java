package com.efs.sdk.base.a.i;

import com.efs.sdk.base.a.i.f;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicInteger f1853c = new AtomicInteger(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicInteger f1854d = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicInteger f1852b = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicInteger f1855e = new AtomicInteger(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicInteger f1856f = new AtomicInteger(0);

    @Override // com.efs.sdk.base.a.i.a
    public final void a() {
        if ((this.f1853c.get() == 0 && this.f1854d.get() == 0 && this.f1852b.get() == 0 && this.f1856f.get() == 0 && this.f1855e.get() == 0) || this.a == null || !com.efs.sdk.base.a.d.a.a().f1777d) {
            return;
        }
        com.efs.sdk.base.a.d.a aVar = this.a;
        int i2 = this.f1853c.get();
        int i3 = this.f1854d.get();
        int i4 = this.f1852b.get();
        int i5 = this.f1856f.get();
        int i6 = this.f1855e.get();
        b bVar = new b("efs_core", "lf_st", f.a.a.a.f1851c);
        bVar.put("create_cnt", Integer.valueOf(i2));
        bVar.put("cache_cnt", Integer.valueOf(i3));
        bVar.put("req_cnt", Integer.valueOf(i4));
        bVar.put("err_cnt", Integer.valueOf(i5));
        bVar.put("expire_cnt", Integer.valueOf(i6));
        this.f1853c.addAndGet(i2 * (-1));
        this.f1854d.addAndGet(i3 * (-1));
        this.f1852b.addAndGet(i4 * (-1));
        this.f1856f.addAndGet(i5 * (-1));
        this.f1855e.addAndGet(i6 * (-1));
        aVar.a(bVar);
    }

    public final void b() {
        this.f1853c.incrementAndGet();
    }

    public final void c() {
        this.f1854d.incrementAndGet();
    }

    public final void d() {
        this.f1855e.incrementAndGet();
    }

    public final void e() {
        this.f1856f.incrementAndGet();
    }
}
