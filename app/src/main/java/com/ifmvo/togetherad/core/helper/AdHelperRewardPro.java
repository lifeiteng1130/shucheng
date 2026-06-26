package com.ifmvo.togetherad.core.helper;

import android.app.Activity;
import com.ifmvo.togetherad.core.R;
import com.ifmvo.togetherad.core.TogetherAd;
import com.ifmvo.togetherad.core.config.AdProviderLoader;
import com.ifmvo.togetherad.core.helper.BaseHelper;
import com.ifmvo.togetherad.core.listener.RewardListener;
import com.ifmvo.togetherad.core.provider.BaseAdProvider;
import com.ifmvo.togetherad.core.utils.DispatchUtil;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import f.c0.c.j;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdHelperRewardPro.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JY\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u000f\u001a\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010JW\u0010\u000f\u001a\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/ifmvo/togetherad/core/helper/AdHelperRewardPro;", "Lcom/ifmvo/togetherad/core/helper/BaseHelper;", "Landroid/app/Activity;", "activity", "", "alias", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "ratioMap", "Lcom/ifmvo/togetherad/core/listener/RewardListener;", "listener", "Lf/v;", "realShow", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/LinkedHashMap;Lcom/ifmvo/togetherad/core/listener/RewardListener;)V", "show", "(Landroid/app/Activity;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/RewardListener;)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public final class AdHelperRewardPro extends BaseHelper {
    public static final AdHelperRewardPro INSTANCE = new AdHelperRewardPro();

    private AdHelperRewardPro() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void realShow(@NotNull final Activity activity, @NotNull final String alias, final LinkedHashMap<String, Integer> ratioMap, final RewardListener listener) {
        LinkedHashMap<String, Integer> publicProviderRatio = (ratioMap == null || ratioMap.isEmpty()) ? TogetherAd.INSTANCE.getPublicProviderRatio() : ratioMap;
        String adProvider = DispatchUtil.INSTANCE.getAdProvider(alias, publicProviderRatio);
        if (adProvider != null) {
            if (!(adProvider.length() == 0)) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider(adProvider);
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.requestAndShowRewardAd(activity, adProvider, alias, new RewardListener() { // from class: com.ifmvo.togetherad.core.helper.AdHelperRewardPro.realShow.1
                        @Override // com.ifmvo.togetherad.core.listener.RewardListener
                        public void onAdClicked(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            RewardListener rewardListener = listener;
                            if (rewardListener != null) {
                                rewardListener.onAdClicked(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.RewardListener
                        public void onAdClose(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            RewardListener rewardListener = listener;
                            if (rewardListener != null) {
                                rewardListener.onAdClose(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.RewardListener
                        public void onAdExpose(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            RewardListener rewardListener = listener;
                            if (rewardListener != null) {
                                rewardListener.onAdExpose(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdFailed(@NotNull String providerType, @Nullable String failedMsg) {
                            j.f(providerType, "providerType");
                            AdHelperRewardPro adHelperRewardPro = AdHelperRewardPro.INSTANCE;
                            if (adHelperRewardPro.getIsFetchOverTime()) {
                                return;
                            }
                            adHelperRewardPro.realShow(activity, alias, ratioMap, listener);
                            RewardListener rewardListener = listener;
                            if (rewardListener != null) {
                                rewardListener.onAdFailed(providerType, failedMsg);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdFailedAll(@Nullable String str) {
                            RewardListener.DefaultImpls.onAdFailedAll(this, str);
                        }

                        @Override // com.ifmvo.togetherad.core.listener.RewardListener
                        public void onAdLoaded(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            AdHelperRewardPro adHelperRewardPro = AdHelperRewardPro.INSTANCE;
                            if (adHelperRewardPro.getIsFetchOverTime()) {
                                return;
                            }
                            adHelperRewardPro.cancelTimer();
                            RewardListener rewardListener = listener;
                            if (rewardListener != null) {
                                rewardListener.onAdLoaded(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.RewardListener
                        public void onAdRewardVerify(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            RewardListener rewardListener = listener;
                            if (rewardListener != null) {
                                rewardListener.onAdRewardVerify(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.RewardListener
                        public void onAdShow(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            RewardListener rewardListener = listener;
                            if (rewardListener != null) {
                                rewardListener.onAdShow(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdStartRequest(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            RewardListener rewardListener = listener;
                            if (rewardListener != null) {
                                rewardListener.onAdStartRequest(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.RewardListener
                        public void onAdVideoCached(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            RewardListener rewardListener = listener;
                            if (rewardListener != null) {
                                rewardListener.onAdVideoCached(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.RewardListener
                        public void onAdVideoComplete(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            RewardListener rewardListener = listener;
                            if (rewardListener != null) {
                                rewardListener.onAdVideoComplete(providerType);
                            }
                        }
                    });
                    return;
                }
                LogExtKt.loge$default(adProvider + ' ' + activity.getString(R.string.no_init), null, 1, null);
                realShow(activity, alias, filterType(publicProviderRatio, adProvider), listener);
                return;
            }
        }
        cancelTimer();
        if (listener != null) {
            listener.onAdFailedAll(BaseHelper.FailedAllMsg.failedAll_noDispatch);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void realShow$default(AdHelperRewardPro adHelperRewardPro, Activity activity, String str, LinkedHashMap linkedHashMap, RewardListener rewardListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            linkedHashMap = null;
        }
        if ((i2 & 8) != 0) {
            rewardListener = null;
        }
        adHelperRewardPro.realShow(activity, str, linkedHashMap, rewardListener);
    }

    public static /* synthetic */ void show$default(AdHelperRewardPro adHelperRewardPro, Activity activity, String str, RewardListener rewardListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            rewardListener = null;
        }
        adHelperRewardPro.show(activity, str, rewardListener);
    }

    public final void show(@NotNull Activity activity, @NotNull String alias, @Nullable RewardListener listener) {
        j.f(activity, "activity");
        j.f(alias, "alias");
        show(activity, alias, null, listener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void show$default(AdHelperRewardPro adHelperRewardPro, Activity activity, String str, LinkedHashMap linkedHashMap, RewardListener rewardListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            linkedHashMap = null;
        }
        if ((i2 & 8) != 0) {
            rewardListener = null;
        }
        adHelperRewardPro.show(activity, str, linkedHashMap, rewardListener);
    }

    public final void show(@NotNull Activity activity, @NotNull String alias, @Nullable LinkedHashMap<String, Integer> ratioMap, @Nullable RewardListener listener) {
        j.f(activity, "activity");
        j.f(alias, "alias");
        startTimer(listener);
        realShow(activity, alias, ratioMap, listener);
    }
}
