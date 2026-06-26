package com.ifmvo.togetherad.core.helper;

import android.app.Activity;
import com.ifmvo.togetherad.core.R;
import com.ifmvo.togetherad.core.TogetherAd;
import com.ifmvo.togetherad.core.config.AdProviderLoader;
import com.ifmvo.togetherad.core.helper.BaseHelper;
import com.ifmvo.togetherad.core.listener.FullVideoListener;
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

/* JADX INFO: compiled from: AdHelperFullVideo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0003\u0012(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001e\u0010\u001fB)\b\u0016\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001e\u0010 J5\u0010\b\u001a\u00020\u00072$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R6\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/ifmvo/togetherad/core/helper/AdHelperFullVideo;", "Lcom/ifmvo/togetherad/core/helper/BaseHelper;", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "ratioMap", "Lf/v;", "reload", "(Ljava/util/LinkedHashMap;)V", "load", "()V", "show", "mAlias", "Ljava/lang/String;", "Lcom/ifmvo/togetherad/core/listener/FullVideoListener;", "mListener", "Lcom/ifmvo/togetherad/core/listener/FullVideoListener;", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "adProvider", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mActivity", "Ljava/lang/ref/WeakReference;", "mRatioMap", "Ljava/util/LinkedHashMap;", "activity", "alias", "listener", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/LinkedHashMap;Lcom/ifmvo/togetherad/core/listener/FullVideoListener;)V", "(Landroid/app/Activity;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/FullVideoListener;)V", "core_release"}, k = 1, mv = {1, 4, 0})
public final class AdHelperFullVideo extends BaseHelper {
    private BaseAdProvider adProvider;
    private WeakReference<Activity> mActivity;
    private String mAlias;
    private FullVideoListener mListener;
    private LinkedHashMap<String, Integer> mRatioMap;

    public /* synthetic */ AdHelperFullVideo(Activity activity, String str, LinkedHashMap linkedHashMap, FullVideoListener fullVideoListener, int i2, f fVar) {
        this(activity, str, (i2 & 4) != 0 ? null : linkedHashMap, (i2 & 8) != 0 ? null : fullVideoListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reload(@NotNull final LinkedHashMap<String, Integer> ratioMap) {
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
                    reload(filterType(ratioMap, adProvider));
                    return;
                }
                if (baseAdProviderLoadAdProvider != null) {
                    Activity activity2 = this.mActivity.get();
                    if (activity2 == null) {
                        j.l();
                        throw null;
                    }
                    j.b(activity2, "mActivity.get()!!");
                    baseAdProviderLoadAdProvider.requestFullVideoAd(activity2, adProvider, this.mAlias, new FullVideoListener() { // from class: com.ifmvo.togetherad.core.helper.AdHelperFullVideo.reload.1
                        @Override // com.ifmvo.togetherad.core.listener.FullVideoListener
                        public void onAdClicked(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            FullVideoListener fullVideoListener = AdHelperFullVideo.this.mListener;
                            if (fullVideoListener != null) {
                                fullVideoListener.onAdClicked(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.FullVideoListener
                        public void onAdClose(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            FullVideoListener fullVideoListener = AdHelperFullVideo.this.mListener;
                            if (fullVideoListener != null) {
                                fullVideoListener.onAdClose(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdFailed(@NotNull String providerType, @Nullable String failedMsg) {
                            j.f(providerType, "providerType");
                            if (AdHelperFullVideo.this.getIsFetchOverTime()) {
                                return;
                            }
                            AdHelperFullVideo adHelperFullVideo = AdHelperFullVideo.this;
                            adHelperFullVideo.reload(adHelperFullVideo.filterType(ratioMap, adProvider));
                            FullVideoListener fullVideoListener = AdHelperFullVideo.this.mListener;
                            if (fullVideoListener != null) {
                                fullVideoListener.onAdFailed(providerType, failedMsg);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdFailedAll(@Nullable String str) {
                            FullVideoListener.DefaultImpls.onAdFailedAll(this, str);
                        }

                        @Override // com.ifmvo.togetherad.core.listener.FullVideoListener
                        public void onAdLoaded(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            if (AdHelperFullVideo.this.getIsFetchOverTime()) {
                                return;
                            }
                            AdHelperFullVideo.this.cancelTimer();
                            FullVideoListener fullVideoListener = AdHelperFullVideo.this.mListener;
                            if (fullVideoListener != null) {
                                fullVideoListener.onAdLoaded(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.FullVideoListener
                        public void onAdShow(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            FullVideoListener fullVideoListener = AdHelperFullVideo.this.mListener;
                            if (fullVideoListener != null) {
                                fullVideoListener.onAdShow(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdStartRequest(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            FullVideoListener fullVideoListener = AdHelperFullVideo.this.mListener;
                            if (fullVideoListener != null) {
                                fullVideoListener.onAdStartRequest(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.FullVideoListener
                        public void onAdVideoCached(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            FullVideoListener fullVideoListener = AdHelperFullVideo.this.mListener;
                            if (fullVideoListener != null) {
                                fullVideoListener.onAdVideoCached(providerType);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.FullVideoListener
                        public void onAdVideoComplete(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            FullVideoListener fullVideoListener = AdHelperFullVideo.this.mListener;
                            if (fullVideoListener != null) {
                                fullVideoListener.onAdVideoComplete(providerType);
                            }
                        }
                    });
                    return;
                }
                return;
            }
        }
        cancelTimer();
        FullVideoListener fullVideoListener = this.mListener;
        if (fullVideoListener != null) {
            fullVideoListener.onAdFailedAll(BaseHelper.FailedAllMsg.failedAll_noDispatch);
        }
    }

    public final void load() {
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
        startTimer(this.mListener);
        reload(publicProviderRatio);
    }

    public final void show() {
        BaseAdProvider baseAdProvider;
        Activity activity = this.mActivity.get();
        if (activity == null || (baseAdProvider = this.adProvider) == null) {
            return;
        }
        j.b(activity, "it");
        baseAdProvider.showFullVideoAd(activity);
    }

    public AdHelperFullVideo(@NotNull Activity activity, @NotNull String str, @Nullable LinkedHashMap<String, Integer> linkedHashMap, @Nullable FullVideoListener fullVideoListener) {
        j.f(activity, "activity");
        j.f(str, "alias");
        this.mActivity = new WeakReference<>(activity);
        this.mAlias = str;
        this.mRatioMap = linkedHashMap;
        this.mListener = fullVideoListener;
    }

    public /* synthetic */ AdHelperFullVideo(Activity activity, String str, FullVideoListener fullVideoListener, int i2, f fVar) {
        this(activity, str, (i2 & 4) != 0 ? null : fullVideoListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdHelperFullVideo(@NotNull Activity activity, @NotNull String str, @Nullable FullVideoListener fullVideoListener) {
        this(activity, str, null, fullVideoListener);
        j.f(activity, "activity");
        j.f(str, "alias");
    }
}
