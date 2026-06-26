package com.efs.sdk.base.a.e;

import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {
    private com.efs.sdk.base.a.f.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f1819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1820c;

    public e(com.efs.sdk.base.a.f.b bVar, c cVar, String str) {
        this.a = bVar;
        this.f1819b = cVar;
        this.f1820c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        com.efs.sdk.base.a.f.b bVar = this.a;
        HttpResponse httpResponse = (bVar == null || (cVar = this.f1819b) == null) ? new HttpResponse() : cVar.a(bVar, true);
        d.a().a(this.f1820c, httpResponse.succ ? 0 : httpResponse.getHttpCode());
        this.f1820c = null;
        this.f1819b = null;
    }
}
