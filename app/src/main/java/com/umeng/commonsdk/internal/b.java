package com.umeng.commonsdk.internal;

import android.content.Context;

/* JADX INFO: compiled from: UMInternalData.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f5151b;
    private Context a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f5152c;

    private b(Context context) {
        this.a = context;
        this.f5152c = new c(context);
    }

    public static synchronized b a(Context context) {
        if (f5151b == null) {
            f5151b = new b(context.getApplicationContext());
        }
        return f5151b;
    }

    public c a() {
        return this.f5152c;
    }
}
