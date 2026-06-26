package com.qq.e.ads.nativ;

import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public interface NativeADEventListener {
    void onADClicked();

    void onADError(AdError adError);

    void onADExposed();

    void onADStatusChanged();
}
