package com.efs.sdk.base.a.h.b;

import androidx.annotation.Nullable;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b implements com.efs.sdk.base.a.h.a.c<HttpResponse> {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f1838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f1839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f1840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f1842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1843g = false;

    @Override // com.efs.sdk.base.a.h.a.c
    @Nullable
    public final /* synthetic */ HttpResponse a() {
        String str = this.f1841e;
        str.hashCode();
        if (str.equals("get")) {
            return HttpEnv.getInstance().getHttpUtil().get(this.a, this.f1838b);
        }
        if (str.equals("post")) {
            byte[] bArr = this.f1839c;
            return (bArr == null || bArr.length <= 0) ? HttpEnv.getInstance().getHttpUtil().post(this.a, this.f1838b, this.f1840d) : this.f1843g ? HttpEnv.getInstance().getHttpUtil().postAsFile(this.a, this.f1838b, this.f1839c) : HttpEnv.getInstance().getHttpUtil().post(this.a, this.f1838b, this.f1839c);
        }
        com.efs.sdk.base.a.h.d.b("efs.util.http", "request not support method '" + this.f1841e + "'", null);
        return null;
    }
}
