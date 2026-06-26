package com.ifmvo.togetherad.core.helper;

import android.app.Activity;
import android.view.ViewGroup;
import com.ifmvo.togetherad.core.R;
import com.ifmvo.togetherad.core.TogetherAd;
import com.ifmvo.togetherad.core.config.AdProviderLoader;
import com.ifmvo.togetherad.core.helper.BaseHelper;
import com.ifmvo.togetherad.core.listener.SplashListener;
import com.ifmvo.togetherad.core.provider.BaseAdProvider;
import com.ifmvo.togetherad.core.utils.DispatchUtil;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import f.c0.c.j;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdHelperSplash.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014Jc\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\b\u0001\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012Ja\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\b\u0001\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/ifmvo/togetherad/core/helper/AdHelperSplash;", "Lcom/ifmvo/togetherad/core/helper/BaseHelper;", "Landroid/app/Activity;", "activity", "", "alias", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "ratioMap", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/listener/SplashListener;", "listener", "Lf/v;", "realShow", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/LinkedHashMap;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "show", "(Landroid/app/Activity;Ljava/lang/String;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public final class AdHelperSplash extends BaseHelper {
    public static final AdHelperSplash INSTANCE = new AdHelperSplash();

    private AdHelperSplash() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void realShow(@NotNull final Activity activity, @NotNull final String alias, LinkedHashMap<String, Integer> ratioMap, @NotNull final ViewGroup container, final SplashListener listener) {
        if (ratioMap == null || ratioMap.isEmpty()) {
            ratioMap = TogetherAd.INSTANCE.getPublicProviderRatio();
        }
        final LinkedHashMap<String, Integer> linkedHashMap = ratioMap;
        final String adProvider = DispatchUtil.INSTANCE.getAdProvider(alias, linkedHashMap);
        if (adProvider != null) {
            if (!(adProvider.length() == 0)) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider(adProvider);
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.loadAndShowSplashAd(activity, adProvider, alias, container, new SplashListener() { // from class: com.ifmvo.togetherad.core.helper.AdHelperSplash.realShow.1
                        @Override // com.ifmvo.togetherad.core.listener.SplashListener
                        public void onAdClicked(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            SplashListener splashListener = listener;
                            if (splashListener != null) {
                                splashListener.onAdClicked(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.SplashListener
                        public void onAdDismissed(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            SplashListener splashListener = listener;
                            if (splashListener != null) {
                                splashListener.onAdDismissed(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.SplashListener
                        public void onAdExposure(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            SplashListener splashListener = listener;
                            if (splashListener != null) {
                                splashListener.onAdExposure(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdFailed(@NotNull String providerType, @Nullable String failedMsg) {
                            j.f(providerType, "providerType");
                            AdHelperSplash adHelperSplash = AdHelperSplash.INSTANCE;
                            if (adHelperSplash.getIsFetchOverTime()) {
                                return;
                            }
                            adHelperSplash.realShow(activity, alias, adHelperSplash.filterType(linkedHashMap, adProvider), container, listener);
                            SplashListener splashListener = listener;
                            if (splashListener != null) {
                                splashListener.onAdFailed(providerType, failedMsg);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdFailedAll(@Nullable String str) {
                            SplashListener.DefaultImpls.onAdFailedAll(this, str);
                        }

                        @Override // com.ifmvo.togetherad.core.listener.SplashListener
                        public void onAdLoaded(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            AdHelperSplash adHelperSplash = AdHelperSplash.INSTANCE;
                            if (adHelperSplash.getIsFetchOverTime()) {
                                return;
                            }
                            adHelperSplash.cancelTimer();
                            SplashListener splashListener = listener;
                            if (splashListener != null) {
                                splashListener.onAdLoaded(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdStartRequest(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            SplashListener splashListener = listener;
                            if (splashListener != null) {
                                splashListener.onAdStartRequest(providerType);
                            }
                        }
                    });
                    return;
                }
                LogExtKt.loge$default(adProvider + ' ' + activity.getString(R.string.no_init), null, 1, null);
                realShow(activity, alias, filterType(linkedHashMap, adProvider), container, listener);
                return;
            }
        }
        cancelTimer();
        if (listener != null) {
            listener.onAdFailedAll(BaseHelper.FailedAllMsg.failedAll_noDispatch);
        }
    }

    public static /* synthetic */ void show$default(AdHelperSplash adHelperSplash, Activity activity, String str, ViewGroup viewGroup, SplashListener splashListener, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            splashListener = null;
        }
        adHelperSplash.show(activity, str, viewGroup, splashListener);
    }

    public final void show(@NotNull Activity activity, @NotNull String alias, @NotNull ViewGroup container, @Nullable SplashListener listener) {
        j.f(activity, "activity");
        j.f(alias, "alias");
        j.f(container, "container");
        show(activity, alias, null, container, listener);
    }

    public final void show(@NotNull Activity activity, @NotNull String alias, @Nullable LinkedHashMap<String, Integer> ratioMap, @NotNull ViewGroup container, @Nullable SplashListener listener) {
        j.f(activity, "activity");
        j.f(alias, "alias");
        j.f(container, "container");
        startTimer(listener);
        realShow(activity, alias, ratioMap, container, listener);
    }
}
