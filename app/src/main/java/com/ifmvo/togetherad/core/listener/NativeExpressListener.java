package com.ifmvo.togetherad.core.listener;
public interface NativeExpressListener extends BaseListener {
    void onAdClicked(String providerType);
    void onAdClose(String providerType);
    void onAdExpose(String providerType);
    void onAdLoaded(String providerType);
    void onAdRenderSuccess(String providerType);
    void onAdRenderFail(String providerType);
}
