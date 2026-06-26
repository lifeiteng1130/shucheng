package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: V2DevicePlan.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends a {
    public k(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent("com.android.filemanager.OPEN_FOLDER");
        intent.putExtra("com.android.filemanager.OPEN_FOLDER", this.f3299c);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(BasicMeasure.EXACTLY);
        return intent;
    }
}
