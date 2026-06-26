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
import f.c0.c.f;
import f.c0.c.j;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdHelperSplashPro.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BE\u0012\b\b\u0001\u0010\u001e\u001a\u00020\u0016\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u0003\u0012(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b \u0010!B\u001d\b\u0016\u0012\b\b\u0001\u0010\u001e\u001a\u00020\u0016\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b \u0010\"JA\u0010\n\u001a\u00020\t2$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012R6\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/ifmvo/togetherad/core/helper/AdHelperSplashPro;", "Lcom/ifmvo/togetherad/core/helper/BaseHelper;", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "ratioMap", "Lcom/ifmvo/togetherad/core/listener/SplashListener;", "listener", "Lf/v;", "realLoadOnly", "(Ljava/util/LinkedHashMap;Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "loadOnly", "(Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "Landroid/view/ViewGroup;", "container", "", "showAd", "(Landroid/view/ViewGroup;)Z", "mRatioMap", "Ljava/util/LinkedHashMap;", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mActivity", "Ljava/lang/ref/WeakReference;", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "adProvider", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "mAlias", "Ljava/lang/String;", "activity", "alias", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/LinkedHashMap;)V", "(Landroid/app/Activity;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 0})
public final class AdHelperSplashPro extends BaseHelper {
    private BaseAdProvider adProvider;
    private WeakReference<Activity> mActivity;
    private String mAlias;
    private LinkedHashMap<String, Integer> mRatioMap;

    public /* synthetic */ AdHelperSplashPro(Activity activity, String str, LinkedHashMap linkedHashMap, int i2, f fVar) {
        this(activity, str, (i2 & 4) != 0 ? null : linkedHashMap);
    }

    public static /* synthetic */ void loadOnly$default(AdHelperSplashPro adHelperSplashPro, SplashListener splashListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            splashListener = null;
        }
        adHelperSplashPro.loadOnly(splashListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void realLoadOnly(@NotNull final LinkedHashMap<String, Integer> ratioMap, final SplashListener listener) {
        final String adProvider = DispatchUtil.INSTANCE.getAdProvider(this.mAlias, ratioMap);
        if (adProvider != null) {
            if (!(adProvider.length() == 0) && this.mActivity.get() != null) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider(adProvider);
                this.adProvider = baseAdProviderLoadAdProvider;
                if (baseAdProviderLoadAdProvider == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(adProvider);
                    sb.append(' ');
                    Activity activity = this.mActivity.get();
                    sb.append(activity != null ? activity.getString(R.string.no_init) : null);
                    LogExtKt.loge$default(sb.toString(), null, 1, null);
                    realLoadOnly$default(this, filterType(ratioMap, adProvider), null, 2, null);
                    return;
                }
                if (baseAdProviderLoadAdProvider != null) {
                    Activity activity2 = this.mActivity.get();
                    if (activity2 == null) {
                        j.l();
                        throw null;
                    }
                    j.b(activity2, "mActivity.get()!!");
                    baseAdProviderLoadAdProvider.loadOnlySplashAd(activity2, adProvider, this.mAlias, new SplashListener() { // from class: com.ifmvo.togetherad.core.helper.AdHelperSplashPro.realLoadOnly.1
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
                            if (AdHelperSplashPro.this.getIsFetchOverTime()) {
                                return;
                            }
                            AdHelperSplashPro adHelperSplashPro = AdHelperSplashPro.this;
                            adHelperSplashPro.realLoadOnly(adHelperSplashPro.filterType(ratioMap, adProvider), listener);
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
                            if (AdHelperSplashPro.this.getIsFetchOverTime()) {
                                return;
                            }
                            AdHelperSplashPro.this.cancelTimer();
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
                return;
            }
        }
        cancelTimer();
        if (listener != null) {
            listener.onAdFailedAll(BaseHelper.FailedAllMsg.failedAll_noDispatch);
        }
    }

    public static /* synthetic */ void realLoadOnly$default(AdHelperSplashPro adHelperSplashPro, LinkedHashMap linkedHashMap, SplashListener splashListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            splashListener = null;
        }
        adHelperSplashPro.realLoadOnly(linkedHashMap, splashListener);
    }

    public final void loadOnly(@Nullable SplashListener listener) {
        LinkedHashMap<String, Integer> publicProviderRatio;
        LinkedHashMap<String, Integer> linkedHashMap = this.mRatioMap;
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            publicProviderRatio = TogetherAd.INSTANCE.getPublicProviderRatio();
        } else {
            publicProviderRatio = this.mRatioMap;
            if (publicProviderRatio == null) {
                j.l();
                throw null;
            }
        }
        startTimer(listener);
        realLoadOnly(publicProviderRatio, listener);
    }

    public final boolean showAd(@NotNull ViewGroup container) {
        j.f(container, "container");
        BaseAdProvider baseAdProvider = this.adProvider;
        if (baseAdProvider != null) {
            return baseAdProvider.showSplashAd(container);
        }
        return false;
    }

    public AdHelperSplashPro(@NotNull Activity activity, @NotNull String str, @Nullable LinkedHashMap<String, Integer> linkedHashMap) {
        j.f(activity, "activity");
        j.f(str, "alias");
        this.mActivity = new WeakReference<>(activity);
        this.mAlias = str;
        this.mRatioMap = linkedHashMap;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdHelperSplashPro(@NotNull Activity activity, @NotNull String str) {
        this(activity, str, null);
        j.f(activity, "activity");
        j.f(str, "alias");
    }
}
