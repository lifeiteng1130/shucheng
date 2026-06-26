package com.efs.sdk.base.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.a.h.a.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsHttpListener implements b<HttpResponse> {
    public abstract void onError(@Nullable HttpResponse httpResponse);

    public abstract void onSuccess(@NonNull HttpResponse httpResponse);

    @Override // com.efs.sdk.base.a.h.a.b
    public void result(@Nullable HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ) {
            onError(httpResponse);
        } else {
            onSuccess(httpResponse);
        }
    }
}
