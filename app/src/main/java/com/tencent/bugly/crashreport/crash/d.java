package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.P;
import com.tencent.bugly.proguard.qa;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class d implements P {
    public final /* synthetic */ List a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f4171b;

    public d(e eVar, List list) {
        this.f4171b = eVar;
        this.a = list;
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i2) {
    }

    @Override // com.tencent.bugly.proguard.P
    public void a(int i2, qa qaVar, long j2, long j3, boolean z, String str) {
        this.f4171b.a(z, this.a);
    }
}
