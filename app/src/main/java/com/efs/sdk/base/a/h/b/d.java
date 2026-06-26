package com.efs.sdk.base.a.h.b;

import androidx.annotation.NonNull;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<com.efs.sdk.base.a.h.a.b<HttpResponse>> f1844b;

    public d(@NonNull String str) {
        b bVar = new b();
        this.a = bVar;
        bVar.a = str;
    }

    public final d a(@NonNull Map<String, String> map) {
        this.a.f1838b = map;
        return this;
    }

    public final d a(String str, String str2) {
        b bVar = this.a;
        if (bVar.f1842f == null) {
            bVar.f1842f = new HashMap(5);
        }
        this.a.f1842f.put(str, str2);
        return this;
    }

    public final d a(@NonNull AbsHttpListener absHttpListener) {
        if (this.f1844b == null) {
            this.f1844b = new ArrayList(5);
        }
        this.f1844b.add(absHttpListener);
        return this;
    }

    public final c a() {
        c cVar = new c(this.a);
        List<com.efs.sdk.base.a.h.a.b<HttpResponse>> list = this.f1844b;
        if (list != null && list.size() > 0) {
            cVar.a(this.f1844b);
        }
        List<com.efs.sdk.base.a.h.a.b<HttpResponse>> httpListenerList = HttpEnv.getInstance().getHttpListenerList();
        if (httpListenerList != null && httpListenerList.size() > 0) {
            cVar.a(httpListenerList);
        }
        return cVar;
    }
}
