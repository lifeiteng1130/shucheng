package com.ifmvo.togetherad.core.helper;

import android.app.Activity;
import android.view.ViewGroup;
import com.ifmvo.togetherad.core.R;
import com.ifmvo.togetherad.core.TogetherAd;
import com.ifmvo.togetherad.core.config.AdProviderLoader;
import com.ifmvo.togetherad.core.custom.express.BaseNativeExpressTemplate;
import com.ifmvo.togetherad.core.custom.express.BaseNativeExpressView;
import com.ifmvo.togetherad.core.helper.BaseHelper;
import com.ifmvo.togetherad.core.listener.NativeExpressListener;
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

/* JADX INFO: compiled from: AdHelperNativeExpress.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 (2\u00020\u0001:\u0001(BM\u0012\b\b\u0001\u0010!\u001a\u00020\u001c\u0012\b\b\u0001\u0010\"\u001a\u00020\u0003\u0012(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u0006\u0010#\u001a\u00020\u0004¢\u0006\u0004\b$\u0010%B%\b\u0016\u0012\b\b\u0001\u0010!\u001a\u00020\u001c\u0012\b\b\u0001\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0004¢\u0006\u0004\b$\u0010&B\u001d\b\u0016\u0012\b\b\u0001\u0010!\u001a\u00020\u001c\u0012\b\b\u0001\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b$\u0010'JA\u0010\n\u001a\u00020\t2$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR6\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Lcom/ifmvo/togetherad/core/helper/AdHelperNativeExpress;", "Lcom/ifmvo/togetherad/core/helper/BaseHelper;", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "ratioMap", "Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;", "listener", "Lf/v;", "getExpressListForMap", "(Ljava/util/LinkedHashMap;Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;)V", "getExpressList", "(Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;)V", "destroyAllExpressAd", "()V", "mAlias", "Ljava/lang/String;", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "adProvider", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "mAdCount", OptRuntime.GeneratorState.resumptionPoint_TYPE, "", "", "mAdList", "Ljava/util/List;", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mActivity", "Ljava/lang/ref/WeakReference;", "mRatioMap", "Ljava/util/LinkedHashMap;", "activity", "alias", "adCount", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/LinkedHashMap;I)V", "(Landroid/app/Activity;Ljava/lang/String;I)V", "(Landroid/app/Activity;Ljava/lang/String;)V", "Companion", "core_release"}, k = 1, mv = {1, 4, 0})
public final class AdHelperNativeExpress extends BaseHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int defaultAdCount = 1;
    private BaseAdProvider adProvider;
    private WeakReference<Activity> mActivity;
    private int mAdCount;
    private List<Object> mAdList;
    private String mAlias;
    private LinkedHashMap<String, Integer> mRatioMap;

    /* JADX INFO: compiled from: AdHelperNativeExpress.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\b\u001a\u00020\u00072\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00072\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\n\u001a\u00020\u00072\u0010\b\u0001\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0004\b\n\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/ifmvo/togetherad/core/helper/AdHelperNativeExpress$Companion;", "", "adObject", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/custom/express/BaseNativeExpressTemplate;", "nativeExpressTemplate", "Lf/v;", "show", "(Ljava/lang/Object;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/custom/express/BaseNativeExpressTemplate;)V", "destroyExpressAd", "(Ljava/lang/Object;)V", "", "adObjectList", "(Ljava/util/List;)V", "", "defaultAdCount", OptRuntime.GeneratorState.resumptionPoint_TYPE, "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final void destroyExpressAd(@Nullable Object adObject) {
            if (adObject == null) {
                return;
            }
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.destroyNativeExpressAd(adObject);
                }
            }
        }

        public final void show(@Nullable Object adObject, @Nullable ViewGroup container, @NotNull BaseNativeExpressTemplate nativeExpressTemplate) {
            BaseNativeExpressView nativeExpressView;
            j.f(nativeExpressTemplate, "nativeExpressTemplate");
            if (adObject == null || container == null) {
                return;
            }
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) entry.getKey());
                if (baseAdProviderLoadAdProvider != null && baseAdProviderLoadAdProvider.nativeExpressAdIsBelongTheProvider(adObject) && (nativeExpressView = nativeExpressTemplate.getNativeExpressView((String) entry.getKey())) != null) {
                    nativeExpressView.showNativeExpress((String) entry.getKey(), adObject, container);
                }
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void destroyExpressAd(@Nullable List<? extends Object> adObjectList) {
            if (adObjectList == null || adObjectList.isEmpty()) {
                return;
            }
            Iterator<T> it = adObjectList.iterator();
            while (it.hasNext()) {
                AdHelperNativeExpress.INSTANCE.destroyExpressAd(it.next());
            }
        }
    }

    public /* synthetic */ AdHelperNativeExpress(Activity activity, String str, LinkedHashMap linkedHashMap, int i2, int i3, f fVar) {
        this(activity, str, (i3 & 4) != 0 ? null : linkedHashMap, i2);
    }

    public static /* synthetic */ void getExpressList$default(AdHelperNativeExpress adHelperNativeExpress, NativeExpressListener nativeExpressListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            nativeExpressListener = null;
        }
        adHelperNativeExpress.getExpressList(nativeExpressListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getExpressListForMap(@NotNull final LinkedHashMap<String, Integer> ratioMap, final NativeExpressListener listener) {
        int i2 = this.mAdCount;
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
                    getExpressListForMap(filterType(ratioMap, adProvider), listener);
                    return;
                }
                if (baseAdProviderLoadAdProvider != null) {
                    Activity activity2 = this.mActivity.get();
                    if (activity2 == null) {
                        j.l();
                        throw null;
                    }
                    j.b(activity2, "mActivity.get()!!");
                    baseAdProviderLoadAdProvider.getNativeExpressAdList(activity2, adProvider, this.mAlias, i3, new NativeExpressListener() { // from class: com.ifmvo.togetherad.core.helper.AdHelperNativeExpress.getExpressListForMap.1
                        @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
                        public void onAdClicked(@NotNull String providerType, @Nullable Object adObject) {
                            j.f(providerType, "providerType");
                            NativeExpressListener nativeExpressListener = listener;
                            if (nativeExpressListener != null) {
                                nativeExpressListener.onAdClicked(providerType, adObject);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
                        public void onAdClosed(@NotNull String providerType, @Nullable Object adObject) {
                            j.f(providerType, "providerType");
                            NativeExpressListener nativeExpressListener = listener;
                            if (nativeExpressListener != null) {
                                nativeExpressListener.onAdClosed(providerType, adObject);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdFailed(@NotNull String providerType, @Nullable String failedMsg) {
                            j.f(providerType, "providerType");
                            if (AdHelperNativeExpress.this.getIsFetchOverTime()) {
                                return;
                            }
                            AdHelperNativeExpress adHelperNativeExpress = AdHelperNativeExpress.this;
                            adHelperNativeExpress.getExpressListForMap(adHelperNativeExpress.filterType(ratioMap, adProvider), listener);
                            NativeExpressListener nativeExpressListener = listener;
                            if (nativeExpressListener != null) {
                                nativeExpressListener.onAdFailed(providerType, failedMsg);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdFailedAll(@Nullable String str) {
                            NativeExpressListener.DefaultImpls.onAdFailedAll(this, str);
                        }

                        @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
                        public void onAdLoaded(@NotNull String providerType, @NotNull List<? extends Object> adList) {
                            j.f(providerType, "providerType");
                            j.f(adList, "adList");
                            if (AdHelperNativeExpress.this.getIsFetchOverTime()) {
                                return;
                            }
                            AdHelperNativeExpress.this.cancelTimer();
                            AdHelperNativeExpress.this.mAdList.addAll(adList);
                            NativeExpressListener nativeExpressListener = listener;
                            if (nativeExpressListener != null) {
                                nativeExpressListener.onAdLoaded(providerType, adList);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
                        public void onAdRenderFail(@NotNull String providerType, @Nullable Object adObject) {
                            j.f(providerType, "providerType");
                            NativeExpressListener nativeExpressListener = listener;
                            if (nativeExpressListener != null) {
                                nativeExpressListener.onAdRenderFail(providerType, adObject);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
                        public void onAdRenderSuccess(@NotNull String providerType, @Nullable Object adObject) {
                            j.f(providerType, "providerType");
                            NativeExpressListener nativeExpressListener = listener;
                            if (nativeExpressListener != null) {
                                nativeExpressListener.onAdRenderSuccess(providerType, adObject);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
                        public void onAdShow(@NotNull String providerType, @Nullable Object adObject) {
                            j.f(providerType, "providerType");
                            NativeExpressListener nativeExpressListener = listener;
                            if (nativeExpressListener != null) {
                                nativeExpressListener.onAdShow(providerType, adObject);
                            }
                        }

                        @Override // com.ifmvo.togetherad.core.listener.BaseListener
                        public void onAdStartRequest(@NotNull String providerType) {
                            j.f(providerType, "providerType");
                            NativeExpressListener nativeExpressListener = listener;
                            if (nativeExpressListener != null) {
                                nativeExpressListener.onAdStartRequest(providerType);
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

    public static /* synthetic */ void getExpressListForMap$default(AdHelperNativeExpress adHelperNativeExpress, LinkedHashMap linkedHashMap, NativeExpressListener nativeExpressListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            nativeExpressListener = null;
        }
        adHelperNativeExpress.getExpressListForMap(linkedHashMap, nativeExpressListener);
    }

    public final void destroyAllExpressAd() {
        INSTANCE.destroyExpressAd(this.mAdList);
        this.mAdList.clear();
    }

    public final void getExpressList(@Nullable NativeExpressListener listener) {
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
        getExpressListForMap(publicProviderRatio, listener);
    }

    public AdHelperNativeExpress(@NotNull Activity activity, @NotNull String str, @Nullable LinkedHashMap<String, Integer> linkedHashMap, int i2) {
        j.f(activity, "activity");
        j.f(str, "alias");
        this.mActivity = new WeakReference<>(activity);
        this.mAlias = str;
        this.mRatioMap = linkedHashMap;
        this.mAdCount = i2;
        this.mAdList = new ArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdHelperNativeExpress(@NotNull Activity activity, @NotNull String str, int i2) {
        this(activity, str, null, i2);
        j.f(activity, "activity");
        j.f(str, "alias");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdHelperNativeExpress(@NotNull Activity activity, @NotNull String str) {
        this(activity, str, null, 1);
        j.f(activity, "activity");
        j.f(str, "alias");
    }
}
