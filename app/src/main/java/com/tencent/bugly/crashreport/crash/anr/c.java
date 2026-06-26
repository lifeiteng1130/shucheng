package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.X;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class c extends FileObserver {
    public final /* synthetic */ h a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(h hVar, String str, int i2) {
        super(str, i2);
        this.a = hVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        if (str == null) {
            return;
        }
        String strI = c.a.a.a.a.i("/data/anr/", str);
        X.e("watching file %s", strI);
        if (strI.contains("trace")) {
            this.a.f4156f.a(new b(this, strI));
        } else {
            X.e("not anr file %s", strI);
        }
    }
}
