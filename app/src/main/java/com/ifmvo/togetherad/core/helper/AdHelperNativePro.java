package com.ifmvo.togetherad.core.helper;

import android.app.Activity;
import android.view.ViewGroup;
import com.ifmvo.togetherad.core.R;
import com.ifmvo.togetherad.core.TogetherAd;
import com.ifmvo.togetherad.core.config.AdProviderLoader;
import com.ifmvo.togetherad.core.custom.native_.BaseNativeTemplate;
import com.ifmvo.togetherad.core.custom.native_.BaseNativeView;
import com.ifmvo.togetherad.core.helper.BaseHelper;
import com.ifmvo.togetherad.core.listener.NativeListener;
import com.ifmvo.togetherad.core.listener.NativeViewListener;
import com.ifmvo.togetherad.core.provider.BaseAdProvider;
import com.ifmvo.togetherad.core.utils.DispatchUtil;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import f.c0.c.f;
import f.c0.c.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: AdHelperNativePro.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0001*BM\u0012\b\b\u0001\u0010#\u001a\u00020\u0015\u0012\b\b\u0001\u0010$\u001a\u00020\u0003\u0012(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u0006\u0010%\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'B%\b\u0016\u0012\b\b\u0001\u0010#\u001a\u00020\u0015\u0012\b\b\u0001\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0004¢\u0006\u0004\b&\u0010(B\u001d\b\u0016\u0012\b\b\u0001\u0010#\u001a\u00020\u0015\u0012\b\b\u0001\u0010$\u001a\u00020\u0003¢\u0006\u0004\b&\u0010)JA\u0010\n\u001a\u00020\t2$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R6\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/ifmvo/togetherad/core/helper/AdHelperNativePro;", "Lcom/ifmvo/togetherad/core/helper/BaseHelper;", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "ratioMap", "Lcom/ifmvo/togetherad/core/listener/NativeListener;", "listener", "Lf/v;", "getListForMap", "(Ljava/util/LinkedHashMap;Lcom/ifmvo/togetherad/core/listener/NativeListener;)V", "getList", "(Lcom/ifmvo/togetherad/core/listener/NativeListener;)V", "resumeAllAd", "()V", "pauseAllAd", "destroyAllAd", "mMaxCount", OptRuntime.GeneratorState.resumptionPoint_TYPE, "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mActivity", "Ljava/lang/ref/WeakReference;", "mRatioMap", "Ljava/util/LinkedHashMap;", "mAlias", "Ljava/lang/String;", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "adProvider", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "", "", "mAdList", "Ljava/util/List;", "activity", "alias", "maxCount", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/LinkedHashMap;I)V", "(Landroid/app/Activity;Ljava/lang/String;I)V", "(Landroid/app/Activity;Ljava/lang/String;)V", "Companion", "core_release"}, k = 1, mv = {1, 4, 0})
public final class AdHelperNativePro extends BaseHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int defaultMaxCount = 1;
    private BaseAdProvider adProvider;
    private WeakReference<Activity> mActivity;
    private List<Object> mAdList;
    private String mAlias;
    private int mMaxCount;
    private LinkedHashMap<String, Integer> mRatioMap;

    /* JADX INFO: compiled from: AdHelperNativePro.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J;\u0010\n\u001a\u00020\t2\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\f\u001a\u00020\t2\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\t2\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0011\u0010\rJ\u001f\u0010\u0011\u001a\u00020\t2\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0012\u0010\rJ\u001f\u0010\u0012\u001a\u00020\t2\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/ifmvo/togetherad/core/helper/AdHelperNativePro$Companion;", "", "adObject", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/custom/native_/BaseNativeTemplate;", "nativeTemplate", "Lcom/ifmvo/togetherad/core/listener/NativeViewListener;", "listener", "Lf/v;", "show", "(Ljava/lang/Object;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/custom/native_/BaseNativeTemplate;Lcom/ifmvo/togetherad/core/listener/NativeViewListener;)V", "pauseAd", "(Ljava/lang/Object;)V", "", "adObjectList", "(Ljava/util/List;)V", "resumeAd", "destroyAd", "", "defaultMaxCount", OptRuntime.GeneratorState.resumptionPoint_TYPE, "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Object obj, ViewGroup viewGroup, BaseNativeTemplate baseNativeTemplate, NativeViewListener nativeViewListener, int i2, Object obj2) {
            if ((i2 & 8) != 0) {
                nativeViewListener = null;
            }
            companion.show(obj, viewGroup, baseNativeTemplate, nativeViewListener);
        }

        public final void destroyAd(@Nullable Object adObject) {
            if (adObject == null) {
                return;
            }
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.destroyNativeAd(adObject);
                }
            }
        }

        public final void pauseAd(@Nullable Object adObject) {
            if (adObject == null) {
                return;
            }
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.pauseNativeAd(adObject);
                }
            }
        }

        public final void resumeAd(@Nullable Object adObject) {
            if (adObject == null) {
                return;
            }
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.resumeNativeAd(adObject);
                }
            }
        }

        public final void show(@Nullable Object adObject, @Nullable ViewGroup container, @NotNull BaseNativeTemplate nativeTemplate, @Nullable NativeViewListener listener) {
            BaseNativeView nativeView;
            j.f(nativeTemplate, "nativeTemplate");
            if (adObject == null || container == null) {
                return;
            }
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) entry.getKey());
                if (baseAdProviderLoadAdProvider != null && baseAdProviderLoadAdProvider.nativeAdIsBelongTheProvider(adObject) && (nativeView = nativeTemplate.getNativeView((String) entry.getKey())) != null) {
                    nativeView.showNative((String) entry.getKey(), adObject, container, listener);
                }
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void destroyAd(@Nullable List<? extends Object> adObjectList) {
            if (adObjectList == null || adObjectList.isEmpty()) {
                return;
            }
            Iterator<T> it = adObjectList.iterator();
            while (it.hasNext()) {
                AdHelperNativePro.INSTANCE.destroyAd(it.next());
            }
        }

        public final void pauseAd(@Nullable List<? extends Object> adObjectList) {
            if (adObjectList == null || adObjectList.isEmpty()) {
                return;
            }
            Iterator<T> it = adObjectList.iterator();
            while (it.hasNext()) {
                AdHelperNativePro.INSTANCE.pauseAd(it.next());
            }
        }

        public final void resumeAd(@Nullable List<? extends Object> adObjectList) {
            if (adObjectList == null || adObjectList.isEmpty()) {
                return;
            }
            Iterator<T> it = adObjectList.iterator();
            while (it.hasNext()) {
                AdHelperNativePro.INSTANCE.resumeAd(it.next());
            }
        }
    }

    public /* synthetic */ AdHelperNativePro(Activity activity, String str, LinkedHashMap linkedHashMap, int i2, int i3, f fVar) {
        this(activity, str, (i3 & 4) != 0 ? null : linkedHashMap, i2);
    }

    public static /* synthetic */ void getList$default(AdHelperNativePro adHelperNativePro, NativeListener nativeListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            nativeListener = null;
        }
        adHelperNativePro.getList(nativeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getListForMap(@NotNull final LinkedHashMap<String, Integer> ratioMap, final NativeListener listener) {
        int i2 = this.mMaxCount;
        int i3 = i2 <= 0 ? 1 : i2;
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
                    getListForMap(filterType(ratioMap, adProvider), listener);
                    return;
                }
                if (baseAdProviderLoadAdProvider != null) {
                    Activity activity2 = this.mActivity.get();
                    if (activity2 == null) {
                        j.l();
                        throw null;
                    }
                    j.b(activity2, "mActivity.get()!!");
                    baseAdProviderLoadAdProvider.getNativeAdList(activity2, adProvider, this.mAlias, i3, new NativeListener() { // from class: com.ifmvo.togetherad.core.helper.AdHelperNativePro.getListForMap.1
                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdFailed(@NotNull String providerType, @Nullable String failedMsg) {
                            j.f(providerType, "providerType");
                            if (AdHelperNativePro.this.getIsFetchOverTime()) {
                                return;
                            }
                            AdHelperNativePro adHelperNativePro = AdHelperNativePro.this;
                            adHelperNativePro.getListForMap(adHelperNativePro.filterType(ratioMap, adProvider), listener);
                            NativeListener nativeListener = listener;
                            if (nativeListener != null) {
                                nativeListener.onAdFailed(providerType, failedMsg);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdFailedAll(@Nullable String str) {
                            NativeListener.DefaultImpls.onAdFailedAll(this, str);
                        }

                        @Override // com.ifmvo.togetherad.core.listener.NativeListener
                        public void onAdLoaded(@NotNull String providerType, @NotNull List<? extends Object> adList) {
                            j.f(providerType, "providerType");
                            j.f(adList, "adList");
                            if (AdHelperNativePro.this.getIsFetchOverTime()) {
                                return;
                            }
                            AdHelperNativePro.this.cancelTimer();
                            AdHelperNativePro.this.mAdList.addAll(adList);
                            NativeListener nativeListener = listener;
                            if (nativeListener != null) {
                                nativeListener.onAdLoaded(providerType, adList);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdStartRequest(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            NativeListener nativeListener = listener;
                            if (nativeListener != null) {
                                nativeListener.onAdStartRequest(providerType);
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

    public static /* synthetic */ void getListForMap$default(AdHelperNativePro adHelperNativePro, LinkedHashMap linkedHashMap, NativeListener nativeListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            nativeListener = null;
        }
        adHelperNativePro.getListForMap(linkedHashMap, nativeListener);
    }

    public final void destroyAllAd() {
        INSTANCE.destroyAd(this.mAdList);
        this.mAdList.clear();
    }

    public final void getList(@Nullable NativeListener listener) {
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
        getListForMap(publicProviderRatio, listener);
    }

    public final void pauseAllAd() {
        INSTANCE.pauseAd(this.mAdList);
    }

    public final void resumeAllAd() {
        INSTANCE.resumeAd(this.mAdList);
    }

    public AdHelperNativePro(@NotNull Activity activity, @NotNull String str, @Nullable LinkedHashMap<String, Integer> linkedHashMap, int i2) {
        j.f(activity, "activity");
        j.f(str, "alias");
        this.mActivity = new WeakReference<>(activity);
        this.mAlias = str;
        this.mRatioMap = linkedHashMap;
        this.mMaxCount = i2;
        this.mAdList = new ArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdHelperNativePro(@NotNull Activity activity, @NotNull String str, int i2) {
        this(activity, str, null, i2);
        j.f(activity, "activity");
        j.f(str, "alias");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdHelperNativePro(@NotNull Activity activity, @NotNull String str) {
        this(activity, str, null, 1);
        j.f(activity, "activity");
        j.f(str, "alias");
    }
}
