package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;

/* JADX INFO: compiled from: AbsDevicePlan.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements e {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.g.a f3298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3299c;

    public a(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        this.a = context;
        this.f3298b = aVar;
        this.f3299c = str;
    }

    public boolean a() {
        if (this.a == null) {
            return false;
        }
        try {
        } catch (Throwable unused) {
            com.ss.android.socialbase.downloader.c.a.a();
        }
        return b().resolveActivity(this.a.getPackageManager()) != null;
    }
}
