package com.ifmvo.togetherad.core.listener;
public interface SplashListener extends BaseListener {
    void onAdClicked(String providerType);
    void onAdClose(String providerType);
    void onAdExpose(String providerType);
    void onAdLoaded(String providerType);
    void onAdShow(String providerType);
    void onAdSkip(String providerType);
    void onAdTick(long millisUntilFinished);
}
