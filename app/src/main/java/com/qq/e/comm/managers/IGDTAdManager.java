package com.qq.e.comm.managers;

import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.devtool.DevTools;

/* JADX INFO: loaded from: classes.dex */
public interface IGDTAdManager {
    String getBuyerId();

    DevTools getDevTools();

    int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);
}
