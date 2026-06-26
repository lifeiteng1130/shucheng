package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: AndroidUnknownSourcePlan.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 26)
public class b extends a {
    public b(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        StringBuilder sbR = c.a.a.a.a.r("package:");
        sbR.append(this.a.getPackageName());
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse(sbR.toString()));
        intent.addFlags(BasicMeasure.EXACTLY);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        return intent;
    }
}
