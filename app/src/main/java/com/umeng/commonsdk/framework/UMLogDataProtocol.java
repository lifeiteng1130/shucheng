package com.umeng.commonsdk.framework;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface UMLogDataProtocol {

    public enum UMBusinessType {
        U_APP,
        U_INTERNAL,
        U_ZeroEnv
    }

    void removeCacheData(Object obj);

    JSONObject setupReportData(long j2);

    void workEvent(Object obj, int i2);
}
