package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.config.FieldManager;

/* JADX INFO: compiled from: IDFATracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends a {
    private static final String a = "idfa";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5289b;

    public c(Context context) {
        super(a);
        this.f5289b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        String strA = FieldManager.allow(com.umeng.commonsdk.utils.b.w) ? com.umeng.commonsdk.statistics.common.a.a(this.f5289b) : null;
        return strA == null ? "" : strA;
    }
}
