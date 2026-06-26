package com.qq.e.ads.interstitial3;

import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ExpressInterstitialAdListener {
    void onAdLoaded();

    void onClick();

    void onClose();

    void onError(AdError adError);

    void onExpose();

    void onRenderFail();

    void onRenderSuccess();

    void onShow();

    void onVideoCached();

    void onVideoComplete();
}
