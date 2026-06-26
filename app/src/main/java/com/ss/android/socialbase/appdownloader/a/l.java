package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.umeng.analytics.pro.ai;

/* JADX INFO: compiled from: V3DevicePlan.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends a {
    public l(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String strC = this.f3298b.c(ai.az);
        String strA = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("ag"), strC);
        String strA2 = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("ah"), strC);
        String strA3 = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("ai"), strC);
        String strA4 = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("aj"), strC);
        Intent intent = new Intent();
        intent.putExtra(strA, this.f3299c);
        intent.putExtra(strA2, "*/*");
        intent.putExtra(strA3, true);
        intent.setAction(strA4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
