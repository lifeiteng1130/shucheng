package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: O2DevicePlan.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends a {
    public h(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent(c.a.a.a.a.p(new StringBuilder(), com.ss.android.socialbase.downloader.constants.e.f3504c, ".intent.action.OPEN_FILEMANAGER"));
        intent.putExtra("CurrentDir", this.f3299c);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(BasicMeasure.EXACTLY);
        return intent;
    }
}
