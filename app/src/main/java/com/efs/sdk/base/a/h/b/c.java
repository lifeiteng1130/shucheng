package com.efs.sdk.base.a.h.b;

import androidx.annotation.NonNull;
import com.efs.sdk.base.a.h.a.e;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e<HttpResponse> {
    public b a;

    public c(@NonNull b bVar) {
        super(bVar);
        this.a = bVar;
    }

    @NonNull
    public final HttpResponse b() {
        this.a.f1841e = "post";
        return a();
    }
}
