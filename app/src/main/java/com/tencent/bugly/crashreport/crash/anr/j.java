package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.X;
import java.util.HashMap;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class j implements TraceFileHelper.b {
    public final /* synthetic */ TraceFileHelper.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4165b;

    public j(TraceFileHelper.a aVar, boolean z) {
        this.a = aVar;
        this.f4165b = z;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(String str, int i2, String str2, String str3, boolean z) {
        X.a("new thread %s", str);
        TraceFileHelper.a aVar = this.a;
        if (aVar.f4144d == null) {
            aVar.f4144d = new HashMap();
        }
        this.a.f4144d.put(str, new String[]{str2, str3, c.a.a.a.a.G("", i2)});
        return true;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(String str, long j2, long j3) {
        return true;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(long j2, long j3, String str) {
        X.a("new process %s", str);
        TraceFileHelper.a aVar = this.a;
        aVar.a = j2;
        aVar.f4142b = str;
        aVar.f4143c = j3;
        return this.f4165b;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(long j2) {
        X.a("process end %d", Long.valueOf(j2));
        return false;
    }
}
