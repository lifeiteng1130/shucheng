package com.ifmvo.togetherad.core.listener;
public interface InterListener extends BaseListener {
    void onAdClicked(String providerType);
    void onAdClose(String providerType);
    void onAdExpose(String providerType);
    void onAdLoaded(String providerType);
}
