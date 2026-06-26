package com.efs.sdk.base.a.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.a.i.f;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AbsHttpListener {

    public static class a {
        private static final b a = new b(0);
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    @Override // com.efs.sdk.base.a.h.a.b
    public final /* bridge */ /* synthetic */ void a(@NonNull com.efs.sdk.base.a.h.a.c<HttpResponse> cVar, @Nullable HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            com.efs.sdk.base.a.a.a.a();
            com.efs.sdk.base.a.a.a.a(httpResponse2);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(@Nullable HttpResponse httpResponse) {
        if (httpResponse == null) {
            return;
        }
        a(httpResponse);
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(@NonNull HttpResponse httpResponse) {
        a(httpResponse);
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i2 = Integer.parseInt(str);
            f fVar = f.a.a;
            if (fVar.f1857b == null || !com.efs.sdk.base.a.d.a.a().f1777d) {
                return;
            }
            com.efs.sdk.base.a.i.b bVar = new com.efs.sdk.base.a.i.b("efs_core", "config_coverage", fVar.a.f1851c);
            bVar.put("cver", Integer.valueOf(i2));
            fVar.f1857b.a(bVar);
        }
    }

    private b() {
    }

    public static b a() {
        return a.a;
    }

    private static void a(@NonNull HttpResponse httpResponse) {
        f.a.a.a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }
}
