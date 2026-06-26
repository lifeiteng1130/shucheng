package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.X;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class f extends FileObserver {
    public final /* synthetic */ h a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, String str, int i2) {
        super(str, i2);
        this.a = hVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        if (str == null) {
            return;
        }
        X.e("startWatchingPrivateAnrDir %s", str);
        if (!this.a.b(str)) {
            X.a("trace file not caused by sigquit , ignore ", new Object[0]);
        } else if (this.a.f4162l != null) {
            this.a.f4162l.a(true);
        }
    }
}
