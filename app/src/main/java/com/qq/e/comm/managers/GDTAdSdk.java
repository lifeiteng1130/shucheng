package com.qq.e.comm.managers;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class GDTAdSdk {
    public static IGDTAdManager getGDTAdManger() {
        return GDTADManager.getInstance();
    }

    public static void init(Context context, String str) {
        GDTADManager.getInstance().initWith(context, str);
    }
}
