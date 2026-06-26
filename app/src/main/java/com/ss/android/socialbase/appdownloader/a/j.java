package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: V1DevicePlan.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends a {
    public j(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent("com.android.filemanager.FILE_OPEN");
        intent.putExtra("FilePathToBeOpenAfterScan", this.f3299c);
        intent.putExtra("com.iqoo.secure", true);
        intent.putExtra("OpenParentAndLocationDestFile", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(BasicMeasure.EXACTLY);
        return intent;
    }
}
