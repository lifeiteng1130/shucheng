package com.ifmvo.togetherad.core.listener;

import com.ifmvo.togetherad.core.listener.BaseListener;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SplashListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/ifmvo/togetherad/core/listener/SplashListener;", "Lcom/ifmvo/togetherad/core/listener/BaseListener;", "", "providerType", "Lf/v;", "onAdLoaded", "(Ljava/lang/String;)V", "onAdClicked", "onAdExposure", "onAdDismissed", "core_release"}, k = 1, mv = {1, 4, 0})
public interface SplashListener extends BaseListener {

    /* JADX INFO: compiled from: SplashListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static void onAdClicked(SplashListener splashListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdDismissed(SplashListener splashListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdExposure(SplashListener splashListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdFailed(SplashListener splashListener, @NotNull String str, @Nullable String str2) {
            j.f(str, "providerType");
            BaseListener.DefaultImpls.onAdFailed(splashListener, str, str2);
        }

        public static void onAdFailedAll(SplashListener splashListener, @Nullable String str) {
            BaseListener.DefaultImpls.onAdFailedAll(splashListener, str);
        }

        public static void onAdLoaded(SplashListener splashListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdStartRequest(SplashListener splashListener, @NotNull String str) {
            j.f(str, "providerType");
            BaseListener.DefaultImpls.onAdStartRequest(splashListener, str);
        }
    }

    void onAdClicked(@NotNull String providerType);

    void onAdDismissed(@NotNull String providerType);

    void onAdExposure(@NotNull String providerType);

    void onAdLoaded(@NotNull String providerType);
}
