package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: MacTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends a {
    private static final String a = "mac";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5302b;

    public g(Context context) {
        super(a);
        this.f5302b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            return DeviceConfig.getMac(this.f5302b);
        } catch (Exception e2) {
            if (AnalyticsConstants.UM_DEBUG) {
                e2.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f5302b, e2);
            return null;
        }
    }
}
