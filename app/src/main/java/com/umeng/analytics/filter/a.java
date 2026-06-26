package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* JADX INFO: compiled from: EventBlackList.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends EventList {
    private d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f4630b;

    public a(String str, String str2) {
        super(str, str2);
        this.f4630b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    public void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f4630b) {
            this.a = null;
            this.a = new d(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean zA;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f4630b) {
            if (this.a == null) {
                this.a = new d(false, this.mEventList);
            }
            zA = this.a.a(str);
        }
        return zA;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_BL = z;
    }
}
