package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.P;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.qa;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class a implements P {
    public final /* synthetic */ List a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f4070b;

    public a(c cVar, List list) {
        this.f4070b = cVar;
        this.a = list;
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i2) {
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i2, qa qaVar, long j2, long j3, boolean z, String str) {
        if (z) {
            X.a("[UserInfo] Successfully uploaded user info.", new Object[0]);
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : this.a) {
                userInfoBean.f4063f = jCurrentTimeMillis;
                this.f4070b.a(userInfoBean, true);
            }
        }
    }
}
