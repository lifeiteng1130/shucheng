package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: SessionIdGenerateServiceImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class w implements v {
    private long a = AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.v
    public void a(long j2) {
        this.a = j2;
    }

    @Override // com.umeng.analytics.pro.v
    public long a() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.v
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(jCurrentTimeMillis + appkey + "02:00:00:00:00:00");
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.v
    public boolean a(long j2, long j3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return (j2 == 0 || jCurrentTimeMillis - j2 >= this.a) && j3 > 0 && jCurrentTimeMillis - j3 > this.a;
    }

    @Override // com.umeng.analytics.pro.v
    public void a(Context context, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString("session_id", str);
            editorEdit.putLong(t.f4956b, 0L);
            editorEdit.putLong(t.f4959e, jCurrentTimeMillis);
            editorEdit.putLong(t.f4960f, 0L);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }
}
