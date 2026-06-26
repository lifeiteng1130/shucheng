package com.ifmvo.togetherad.core.listener;

import com.ifmvo.togetherad.core.listener.BaseListener;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RewardListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0019\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0019\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/ifmvo/togetherad/core/listener/RewardListener;", "Lcom/ifmvo/togetherad/core/listener/BaseListener;", "", "providerType", "Lf/v;", "onAdLoaded", "(Ljava/lang/String;)V", "onAdClicked", "onAdShow", "onAdExpose", "onAdVideoComplete", "onAdVideoCached", "onAdRewardVerify", "onAdClose", "core_release"}, k = 1, mv = {1, 4, 0})
public interface RewardListener extends BaseListener {

    /* JADX INFO: compiled from: RewardListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static void onAdClicked(RewardListener rewardListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdClose(RewardListener rewardListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdExpose(RewardListener rewardListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdFailed(RewardListener rewardListener, @NotNull String str, @Nullable String str2) {
            j.f(str, "providerType");
            BaseListener.DefaultImpls.onAdFailed(rewardListener, str, str2);
        }

        public static void onAdFailedAll(RewardListener rewardListener, @Nullable String str) {
            BaseListener.DefaultImpls.onAdFailedAll(rewardListener, str);
        }

        public static void onAdLoaded(RewardListener rewardListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdRewardVerify(RewardListener rewardListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdShow(RewardListener rewardListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdStartRequest(RewardListener rewardListener, @NotNull String str) {
            j.f(str, "providerType");
            BaseListener.DefaultImpls.onAdStartRequest(rewardListener, str);
        }

        public static void onAdVideoCached(RewardListener rewardListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdVideoComplete(RewardListener rewardListener, @NotNull String str) {
            j.f(str, "providerType");
        }
    }

    void onAdClicked(@NotNull String providerType);

    void onAdClose(@NotNull String providerType);

    void onAdExpose(@NotNull String providerType);

    void onAdLoaded(@NotNull String providerType);

    void onAdRewardVerify(@NotNull String providerType);

    void onAdShow(@NotNull String providerType);

    void onAdVideoCached(@NotNull String providerType);

    void onAdVideoComplete(@NotNull String providerType);
}
