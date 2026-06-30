package com.ifmvo.togetherad.core.listener;
public interface RewardListener extends BaseListener {
    void onAdClicked(String providerType);
    void onAdClose(String providerType);
    void onAdExpose(String providerType);
    void onAdLoaded(String providerType);
    void onAdRewardVerify(String providerType);
    void onAdShow(String providerType);
    void onAdVideoCached(String providerType);
    void onAdVideoComplete(String providerType);
}
