package com.ifmvo.togetherad.core.helper;

import android.app.Activity;
import android.view.ViewGroup;
import com.ifmvo.togetherad.core.R;
import com.ifmvo.togetherad.core.TogetherAd;
import com.ifmvo.togetherad.core.config.AdProviderLoader;
import com.ifmvo.togetherad.core.helper.BaseHelper;
import com.ifmvo.togetherad.core.listener.BannerListener;
import com.ifmvo.togetherad.core.provider.BaseAdProvider;
import com.ifmvo.togetherad.core.utils.DispatchUtil;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import f.c0.c.j;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdHelperBanner.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0014Jc\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\b\u0001\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012Ja\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\b\u0001\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/ifmvo/togetherad/core/helper/AdHelperBanner;", "Lcom/ifmvo/togetherad/core/helper/BaseHelper;", "Landroid/app/Activity;", "activity", "", "alias", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "ratioMap", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/listener/BannerListener;", "listener", "Lf/v;", "realShow", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/LinkedHashMap;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/BannerListener;)V", "show", "(Landroid/app/Activity;Ljava/lang/String;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/BannerListener;)V", "destroy", "()V", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "adProvider", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "<init>", "core_release"}, k = 1, mv = {1, 4, 0})
public final class AdHelperBanner extends BaseHelper {
    public static final AdHelperBanner INSTANCE = new AdHelperBanner();
    private static BaseAdProvider adProvider;

    private AdHelperBanner() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void realShow(@NotNull final Activity activity, @NotNull final String alias, LinkedHashMap<String, Integer> ratioMap, @NotNull final ViewGroup container, final BannerListener listener) {
        if (ratioMap == null || ratioMap.isEmpty()) {
            ratioMap = TogetherAd.INSTANCE.getPublicProviderRatio();
        }
        final LinkedHashMap<String, Integer> linkedHashMap = ratioMap;
        final String adProvider2 = DispatchUtil.INSTANCE.getAdProvider(alias, linkedHashMap);
        if (adProvider2 != null) {
            if (!(adProvider2.length() == 0)) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider(adProvider2);
                adProvider = baseAdProviderLoadAdProvider;
                if (baseAdProviderLoadAdProvider != null) {
                    if (baseAdProviderLoadAdProvider != null) {
                        baseAdProviderLoadAdProvider.showBannerAd(activity, adProvider2, alias, container, new BannerListener() { // from class: com.ifmvo.togetherad.core.helper.AdHelperBanner.realShow.1
                            @Override // com.ifmvo.togetherad.core.listener.BannerListener
                            public void onAdClicked(@NotNull String providerType) {
                                j.f(providerType, "providerType");
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdClicked(providerType);
                                }
                            }

                            @Override // com.ifmvo.togetherad.core.listener.BannerListener
                            public void onAdClose(@NotNull String providerType) {
                                j.f(providerType, "providerType");
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdClose(providerType);
                                }
                            }

                            @Override // com.ifmvo.togetherad.core.listener.BannerListener
                            public void onAdExpose(@NotNull String providerType) {
                                j.f(providerType, "providerType");
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdExpose(providerType);
                                }
                            }

                            @Override // com.ifmvo.togetherad.core.listener.BaseListener
                            public void onAdFailed(@NotNull String providerType, @Nullable String failedMsg) {
                                j.f(providerType, "providerType");
                                AdHelperBanner adHelperBanner = AdHelperBanner.INSTANCE;
                                if (adHelperBanner.getIsFetchOverTime()) {
                                    return;
                                }
                                adHelperBanner.realShow(activity, alias, adHelperBanner.filterType(linkedHashMap, adProvider2), container, listener);
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdFailed(providerType, failedMsg);
                                }
                            }

                            @Override // com.ifmvo.togetherad.core.listener.BaseListener
                            public void onAdFailedAll(@Nullable String str) {
                                BannerListener.DefaultImpls.onAdFailedAll(this, str);
                            }

                            @Override // com.ifmvo.togetherad.core.listener.BannerListener
                            public void onAdLoaded(@NotNull String providerType) {
                                j.f(providerType, "providerType");
                                AdHelperBanner adHelperBanner = AdHelperBanner.INSTANCE;
                                if (adHelperBanner.getIsFetchOverTime()) {
                                    return;
                                }
                                adHelperBanner.cancelTimer();
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdLoaded(providerType);
                                }
                            }

                            @Override // com.ifmvo.togetherad.core.listener.BaseListener
                            public void onAdStartRequest(@NotNull String providerType) {
                                j.f(providerType, "providerType");
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdStartRequest(adProvider2);
                                }
                            }
                        });
                        return;
                    }
                    return;
                } else {
                    LogExtKt.loge$default(adProvider2 + ' ' + activity.getString(R.string.no_init), null, 1, null);
                    realShow(activity, alias, filterType(linkedHashMap, adProvider2), container, listener);
                    return;
                }
            }
        }
        cancelTimer();
        if (listener != null) {
            listener.onAdFailedAll(BaseHelper.FailedAllMsg.failedAll_noDispatch);
        }
    }

    public static /* synthetic */ void show$default(AdHelperBanner adHelperBanner, Activity activity, String str, ViewGroup viewGroup, BannerListener bannerListener, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            bannerListener = null;
        }
        adHelperBanner.show(activity, str, viewGroup, bannerListener);
    }

    public final void destroy() {
        BaseAdProvider baseAdProvider = adProvider;
        if (baseAdProvider != null) {
            baseAdProvider.destroyBannerAd();
        }
        adProvider = null;
    }

    public final void show(@NotNull Activity activity, @NotNull String alias, @NotNull ViewGroup container, @Nullable BannerListener listener) {
        j.f(activity, "activity");
        j.f(alias, "alias");
        j.f(container, "container");
        show(activity, alias, null, container, listener);
    }

    public final void show(@NotNull Activity activity, @NotNull String alias, @Nullable LinkedHashMap<String, Integer> ratioMap, @NotNull ViewGroup container, @Nullable BannerListener listener) {
        j.f(activity, "activity");
        j.f(alias, "alias");
        j.f(container, "container");
        startTimer(listener);
        realShow(activity, alias, ratioMap, container, listener);
    }
}
