package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: AndroidIdTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends a {
    private static final String a = "android_id";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5288b;

    public b(Context context) {
        super(a);
        this.f5288b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getAndroidId(this.f5288b);
    }
}
