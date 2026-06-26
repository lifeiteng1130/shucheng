package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: M1UnknownSourcePlan.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    public f(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(BasicMeasure.EXACTLY);
        intent.addFlags(8388608);
        return intent;
    }
}
