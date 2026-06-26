package com.efs.sdk.base.a.b;

import com.efs.sdk.base.a.i.f;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class d implements e {
    @Override // com.efs.sdk.base.a.b.e
    public final void a(File file) throws Throwable {
        com.efs.sdk.base.a.h.b.a(file, com.efs.sdk.base.a.h.a.f(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.d.a.a().a));
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(String str) {
    }

    @Override // com.efs.sdk.base.a.b.e
    public final boolean a(File file, com.efs.sdk.base.a.f.b bVar) {
        if (!file.exists()) {
            return false;
        }
        bVar.f1831d = file;
        bVar.d();
        bVar.b(1);
        return true;
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(com.efs.sdk.base.a.f.b bVar) {
        if (bVar.f1830c == null) {
            return;
        }
        com.efs.sdk.base.a.h.b.a(new File(com.efs.sdk.base.a.h.a.f(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.d.a.a().a), com.efs.sdk.base.a.h.b.a(bVar)), bVar.f1830c);
        f.a.a.f1858c.b();
        f.a.a.f1858c.c();
    }
}
