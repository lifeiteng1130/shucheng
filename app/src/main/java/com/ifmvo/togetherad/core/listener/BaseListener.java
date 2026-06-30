package com.ifmvo.togetherad.core.listener;
public interface BaseListener {
    void onAdFailed(String providerType, String error);
    void onAdFailedAll(String error);
    void onAdStartRequest(String providerType);
}
