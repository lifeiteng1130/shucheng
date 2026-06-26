package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: ImeiTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends a {
    private static final String a = "imei";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5301b;

    public f(Context context) {
        super(a);
        this.f5301b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getImeiNew(this.f5301b);
    }
}
