package com.ifmvo.togetherad.csj.provider;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.core.FocusMeteringAction;
import c.b.a.m.f;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.ifmvo.togetherad.core.custom.splashSkip.BaseSplashSkipView;
import com.ifmvo.togetherad.core.listener.SplashListener;
import com.ifmvo.togetherad.csj.TogetherAdCsj;
import com.ifmvo.togetherad.csj.provider.CsjProvider;
import com.ifmvo.togetherad.csj.provider.CsjProviderSplash;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CsjProviderSplash.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProviderSplash;", "Lcom/ifmvo/togetherad/csj/provider/CsjProviderReward;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "Lcom/ifmvo/togetherad/core/listener/SplashListener;", "listener", "Lf/v;", "loadOnlySplashAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "Landroid/view/ViewGroup;", "container", "", "showSplashAd", "(Landroid/view/ViewGroup;)Z", "loadAndShowSplashAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "mListener", "Lcom/ifmvo/togetherad/core/listener/SplashListener;", "mAdProviderType", "Ljava/lang/String;", "Landroid/os/CountDownTimer;", "mTimer", "Landroid/os/CountDownTimer;", "Lcom/bytedance/sdk/openadsdk/TTSplashAd;", "mSplashAd", "Lcom/bytedance/sdk/openadsdk/TTSplashAd;", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
public abstract class CsjProviderSplash extends CsjProviderReward {
    private String mAdProviderType;
    private SplashListener mListener;
    private TTSplashAd mSplashAd;
    private CountDownTimer mTimer;

    /* JADX INFO: renamed from: com.ifmvo.togetherad.csj.provider.CsjProviderSplash$loadAndShowSplashAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: CsjProviderSplash.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/ifmvo/togetherad/csj/provider/CsjProviderSplash$loadAndShowSplashAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener;", "Lcom/bytedance/sdk/openadsdk/TTSplashAd;", "splashAd", "Lf/v;", "onSplashAdLoad", "(Lcom/bytedance/sdk/openadsdk/TTSplashAd;)V", "onTimeout", "()V", "", "errorCode", "", "errorMsg", "onError", "(ILjava/lang/String;)V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 implements TTAdNative.SplashAdListener {
        public final /* synthetic */ String $adProviderType;
        public final /* synthetic */ String $alias;
        public final /* synthetic */ ViewGroup $container;
        public final /* synthetic */ BaseSplashSkipView $customSkipView;
        public final /* synthetic */ SplashListener $listener;
        public final /* synthetic */ View $skipView;

        public AnonymousClass1(String str, String str2, SplashListener splashListener, ViewGroup viewGroup, BaseSplashSkipView baseSplashSkipView, View view) {
            this.$adProviderType = str;
            this.$alias = str2;
            this.$listener = splashListener;
            this.$container = viewGroup;
            this.$customSkipView = baseSplashSkipView;
            this.$skipView = view;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int errorCode, @Nullable String errorMsg) {
            CsjProviderSplash.this.callbackSplashFailed(this.$adProviderType, this.$alias, this.$listener, Integer.valueOf(errorCode), errorMsg);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        public void onSplashAdLoad(@Nullable TTSplashAd splashAd) {
            if (splashAd == null) {
                CsjProviderSplash.this.callbackSplashFailed(this.$adProviderType, this.$alias, this.$listener, null, "请求成功，但是返回的广告为null");
                return;
            }
            CsjProviderSplash.this.callbackSplashLoaded(this.$adProviderType, this.$alias, this.$listener);
            this.$container.removeAllViews();
            this.$container.addView(splashAd.getSplashView());
            splashAd.setSplashInteractionListener(new TTSplashAd.AdInteractionListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderSplash$loadAndShowSplashAd$1$onSplashAdLoad$1
                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdClicked(@Nullable View view, int p1) {
                    CsjProviderSplash.AnonymousClass1 anonymousClass1 = this.this$0;
                    CsjProviderSplash.this.callbackSplashClicked(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdShow(@Nullable View p0, int p1) {
                    CsjProviderSplash.AnonymousClass1 anonymousClass1 = this.this$0;
                    CsjProviderSplash.this.callbackSplashExposure(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdSkip() {
                    CsjProvider.Splash.INSTANCE.setCustomSkipView(null);
                    CsjProviderSplash.AnonymousClass1 anonymousClass1 = this.this$0;
                    CsjProviderSplash.this.callbackSplashDismiss(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdTimeOver() {
                    CsjProvider.Splash.INSTANCE.setCustomSkipView(null);
                    CsjProviderSplash.AnonymousClass1 anonymousClass1 = this.this$0;
                    CsjProviderSplash.this.callbackSplashDismiss(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                }
            });
            if (this.$customSkipView != null) {
                splashAd.setNotAllowSdkCountdown();
                View view = this.$skipView;
                if (view != null) {
                    this.$container.addView(view, this.$customSkipView.getLayoutParams());
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderSplash$loadAndShowSplashAd$1$onSplashAdLoad$$inlined$run$lambda$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            CountDownTimer countDownTimer = CsjProviderSplash.this.mTimer;
                            if (countDownTimer != null) {
                                countDownTimer.cancel();
                            }
                            CsjProvider.Splash.INSTANCE.setCustomSkipView(null);
                            CsjProviderSplash.AnonymousClass1 anonymousClass1 = this.this$0;
                            CsjProviderSplash.this.callbackSplashDismiss(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                        }
                    });
                }
                CountDownTimer countDownTimer = CsjProviderSplash.this.mTimer;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                CsjProviderSplash csjProviderSplash = CsjProviderSplash.this;
                final long j2 = FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION;
                final long j3 = 1000;
                csjProviderSplash.mTimer = new CountDownTimer(j2, j3) { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderSplash$loadAndShowSplashAd$1$onSplashAdLoad$3
                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        CsjProvider.Splash.INSTANCE.setCustomSkipView(null);
                        CsjProviderSplash.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderSplash.this.callbackSplashDismiss(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long millisUntilFinished) {
                        this.this$0.$customSkipView.handleTime(f.S4(millisUntilFinished / 1000.0f));
                    }
                };
                CountDownTimer countDownTimer2 = CsjProviderSplash.this.mTimer;
                if (countDownTimer2 != null) {
                    countDownTimer2.start();
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        public void onTimeout() {
            CsjProviderSplash.this.callbackSplashFailed(this.$adProviderType, this.$alias, this.$listener, null, "请求超时了");
        }
    }

    /* JADX INFO: renamed from: com.ifmvo.togetherad.csj.provider.CsjProviderSplash$loadOnlySplashAd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CsjProviderSplash.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/ifmvo/togetherad/csj/provider/CsjProviderSplash$loadOnlySplashAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener;", "Lcom/bytedance/sdk/openadsdk/TTSplashAd;", "splashAd", "Lf/v;", "onSplashAdLoad", "(Lcom/bytedance/sdk/openadsdk/TTSplashAd;)V", "onTimeout", "()V", "", "errorCode", "", "errorMsg", "onError", "(ILjava/lang/String;)V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class C03051 implements TTAdNative.SplashAdListener {
        public final /* synthetic */ String $adProviderType;
        public final /* synthetic */ String $alias;
        public final /* synthetic */ SplashListener $listener;

        public C03051(String str, String str2, SplashListener splashListener) {
            this.$adProviderType = str;
            this.$alias = str2;
            this.$listener = splashListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int errorCode, @Nullable String errorMsg) {
            CsjProviderSplash.this.callbackSplashFailed(this.$adProviderType, this.$alias, this.$listener, Integer.valueOf(errorCode), errorMsg);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        public void onSplashAdLoad(@Nullable TTSplashAd splashAd) {
            if (splashAd == null) {
                CsjProviderSplash.this.callbackSplashFailed(this.$adProviderType, this.$alias, this.$listener, null, "请求成功，但是返回的广告为null");
                return;
            }
            CsjProviderSplash.this.callbackSplashLoaded(this.$adProviderType, this.$alias, this.$listener);
            CsjProviderSplash.this.mSplashAd = splashAd;
            TTSplashAd tTSplashAd = CsjProviderSplash.this.mSplashAd;
            if (tTSplashAd != null) {
                tTSplashAd.setSplashInteractionListener(new TTSplashAd.AdInteractionListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderSplash$loadOnlySplashAd$1$onSplashAdLoad$1
                    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                    public void onAdClicked(@Nullable View view, int p1) {
                        CsjProviderSplash.C03051 c03051 = this.this$0;
                        CsjProviderSplash.this.callbackSplashClicked(c03051.$adProviderType, c03051.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                    public void onAdShow(@Nullable View p0, int p1) {
                        CsjProviderSplash.C03051 c03051 = this.this$0;
                        CsjProviderSplash.this.callbackSplashExposure(c03051.$adProviderType, c03051.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                    public void onAdSkip() {
                        CsjProvider.Splash.INSTANCE.setCustomSkipView(null);
                        CsjProviderSplash.C03051 c03051 = this.this$0;
                        CsjProviderSplash.this.callbackSplashDismiss(c03051.$adProviderType, c03051.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                    public void onAdTimeOver() {
                        CsjProvider.Splash.INSTANCE.setCustomSkipView(null);
                        CsjProviderSplash.C03051 c03051 = this.this$0;
                        CsjProviderSplash.this.callbackSplashDismiss(c03051.$adProviderType, c03051.$listener);
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        public void onTimeout() {
            CsjProviderSplash.this.callbackSplashFailed(this.$adProviderType, this.$alias, this.$listener, null, "请求超时了");
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void loadAndShowSplashAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull ViewGroup container, @NotNull SplashListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(container, "container");
        j.f(listener, "listener");
        callbackSplashStartRequest(adProviderType, alias, listener);
        CsjProvider.Splash splash = CsjProvider.Splash.INSTANCE;
        BaseSplashSkipView customSkipView = splash.getCustomSkipView();
        View viewOnCreateSkipView = customSkipView != null ? customSkipView.onCreateSkipView(activity) : null;
        AdSlot.Builder builder = new AdSlot.Builder();
        TogetherAdCsj togetherAdCsj = TogetherAdCsj.INSTANCE;
        builder.setDownloadType(togetherAdCsj.getDownloadType());
        builder.setCodeId(togetherAdCsj.getIdMapCsj().get(alias));
        if (splash.isExpress()) {
            builder.setExpressViewAcceptedSize(splash.getImageAcceptedSizeWidth$csj_release(), splash.getImageAcceptedSizeHeight$csj_release());
        } else {
            builder.setImageAcceptedSize(splash.getImageAcceptedSizeWidth$csj_release(), splash.getImageAcceptedSizeHeight$csj_release());
        }
        togetherAdCsj.getMTTAdManager().createAdNative(activity).loadSplashAd(builder.build(), new AnonymousClass1(adProviderType, alias, listener, container, customSkipView, viewOnCreateSkipView), splash.getMaxFetchDelay());
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void loadOnlySplashAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull SplashListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        this.mListener = listener;
        this.mAdProviderType = adProviderType;
        callbackSplashStartRequest(adProviderType, alias, listener);
        AdSlot.Builder builder = new AdSlot.Builder();
        TogetherAdCsj togetherAdCsj = TogetherAdCsj.INSTANCE;
        builder.setCodeId(togetherAdCsj.getIdMapCsj().get(alias));
        CsjProvider.Splash splash = CsjProvider.Splash.INSTANCE;
        builder.setSplashButtonType(splash.getSplashButtonType());
        builder.setDownloadType(togetherAdCsj.getDownloadType());
        if (splash.isExpress()) {
            builder.setExpressViewAcceptedSize(splash.getImageAcceptedSizeWidth$csj_release(), splash.getImageAcceptedSizeHeight$csj_release());
        } else {
            builder.setImageAcceptedSize(splash.getImageAcceptedSizeWidth$csj_release(), splash.getImageAcceptedSizeHeight$csj_release());
        }
        togetherAdCsj.getMTTAdManager().createAdNative(activity).loadSplashAd(builder.build(), new C03051(adProviderType, alias, listener), splash.getMaxFetchDelay());
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public boolean showSplashAd(@NotNull final ViewGroup container) {
        j.f(container, "container");
        TTSplashAd tTSplashAd = this.mSplashAd;
        View viewOnCreateSkipView = null;
        if ((tTSplashAd != null ? tTSplashAd.getSplashView() : null) == null) {
            return false;
        }
        container.removeAllViews();
        TTSplashAd tTSplashAd2 = this.mSplashAd;
        if (tTSplashAd2 == null) {
            j.l();
            throw null;
        }
        container.addView(tTSplashAd2.getSplashView());
        final BaseSplashSkipView customSkipView = CsjProvider.Splash.INSTANCE.getCustomSkipView();
        if (customSkipView != null) {
            Context context = container.getContext();
            j.b(context, "container.context");
            viewOnCreateSkipView = customSkipView.onCreateSkipView(context);
        }
        if (customSkipView == null) {
            return true;
        }
        TTSplashAd tTSplashAd3 = this.mSplashAd;
        if (tTSplashAd3 != null) {
            tTSplashAd3.setNotAllowSdkCountdown();
        }
        if (viewOnCreateSkipView != null) {
            container.addView(viewOnCreateSkipView, customSkipView.getLayoutParams());
            viewOnCreateSkipView.setOnClickListener(new View.OnClickListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderSplash$showSplashAd$$inlined$run$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CountDownTimer countDownTimer = this.this$0.mTimer;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    if (this.this$0.mAdProviderType == null || this.this$0.mListener == null) {
                        return;
                    }
                    CsjProvider.Splash.INSTANCE.setCustomSkipView(null);
                    CsjProviderSplash csjProviderSplash = this.this$0;
                    String str = csjProviderSplash.mAdProviderType;
                    if (str == null) {
                        j.l();
                        throw null;
                    }
                    SplashListener splashListener = this.this$0.mListener;
                    if (splashListener != null) {
                        csjProviderSplash.callbackSplashDismiss(str, splashListener);
                    } else {
                        j.l();
                        throw null;
                    }
                }
            });
        }
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION, 1000L) { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderSplash.showSplashAd.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (CsjProviderSplash.this.mAdProviderType == null || CsjProviderSplash.this.mListener == null) {
                    return;
                }
                CsjProvider.Splash.INSTANCE.setCustomSkipView(null);
                CsjProviderSplash csjProviderSplash = CsjProviderSplash.this;
                String str = csjProviderSplash.mAdProviderType;
                if (str == null) {
                    j.l();
                    throw null;
                }
                SplashListener splashListener = CsjProviderSplash.this.mListener;
                if (splashListener != null) {
                    csjProviderSplash.callbackSplashDismiss(str, splashListener);
                } else {
                    j.l();
                    throw null;
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                customSkipView.handleTime(f.S4(millisUntilFinished / 1000.0f));
            }
        };
        this.mTimer = countDownTimer2;
        if (countDownTimer2 == null) {
            return true;
        }
        countDownTimer2.start();
        return true;
    }
}
