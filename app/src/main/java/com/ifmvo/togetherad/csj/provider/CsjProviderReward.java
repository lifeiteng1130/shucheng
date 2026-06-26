package com.ifmvo.togetherad.csj.provider;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.ifmvo.togetherad.core.listener.RewardListener;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import com.ifmvo.togetherad.csj.provider.CsjProvider;
import com.ifmvo.togetherad.csj.provider.CsjProviderReward;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CsjProviderReward.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProviderReward;", "Lcom/ifmvo/togetherad/csj/provider/CsjProviderNativeExpress;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "Lcom/ifmvo/togetherad/core/listener/RewardListener;", "listener", "Lf/v;", "requestRewardAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/RewardListener;)V", "", "showRewardAd", "(Landroid/app/Activity;)Z", "requestAndShowRewardAd", "Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;", "mttRewardVideoAd", "Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
public abstract class CsjProviderReward extends CsjProviderNativeExpress {
    private TTRewardVideoAd mttRewardVideoAd;

    /* JADX INFO: renamed from: com.ifmvo.togetherad.csj.provider.CsjProviderReward$requestAndShowRewardAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: CsjProviderReward.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"com/ifmvo/togetherad/csj/provider/CsjProviderReward$requestAndShowRewardAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$RewardVideoAdListener;", "", "code", "", "message", "Lf/v;", "onError", "(ILjava/lang/String;)V", "onRewardVideoCached", "()V", "Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;", "videoAd", "(Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;)V", ai.au, "onRewardVideoAdLoad", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 implements TTAdNative.RewardVideoAdListener {
        public final /* synthetic */ Activity $activity;
        public final /* synthetic */ String $adProviderType;
        public final /* synthetic */ String $alias;
        public final /* synthetic */ RewardListener $listener;

        public AnonymousClass1(String str, String str2, RewardListener rewardListener, Activity activity) {
            this.$adProviderType = str;
            this.$alias = str2;
            this.$listener = rewardListener;
            this.$activity = activity;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int code, @Nullable String message) {
            CsjProviderReward.this.callbackRewardFailed(this.$adProviderType, this.$alias, this.$listener, Integer.valueOf(code), message);
            CsjProviderReward.this.mttRewardVideoAd = null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(@NotNull TTRewardVideoAd ad) {
            j.f(ad, ai.au);
            CsjProviderReward.this.mttRewardVideoAd = ad;
            TTRewardVideoAd tTRewardVideoAd = CsjProviderReward.this.mttRewardVideoAd;
            if (tTRewardVideoAd != null) {
                tTRewardVideoAd.setShowDownLoadBar(CsjProvider.Reward.INSTANCE.getShowDownLoadBar());
            }
            TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderReward$requestAndShowRewardAd$1$onRewardVideoAdLoad$rewardAdListener$1
                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdClose() {
                    CsjProviderReward.AnonymousClass1 anonymousClass1 = this.this$0;
                    CsjProviderReward.this.callbackRewardClosed(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    CsjProviderReward.this.mttRewardVideoAd = null;
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdShow() {
                    CsjProviderReward.AnonymousClass1 anonymousClass1 = this.this$0;
                    CsjProviderReward.this.callbackRewardShow(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    CsjProviderReward.AnonymousClass1 anonymousClass12 = this.this$0;
                    CsjProviderReward.this.callbackRewardExpose(anonymousClass12.$adProviderType, anonymousClass12.$listener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdVideoBarClick() {
                    CsjProviderReward.AnonymousClass1 anonymousClass1 = this.this$0;
                    CsjProviderReward.this.callbackRewardClicked(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify(boolean rewardVerify, int rewardAmount, @Nullable String rewardName, int errorCode, @Nullable String errorMsg) {
                    CsjProvider.Reward reward = CsjProvider.Reward.INSTANCE;
                    reward.setRewardVerify$csj_release(rewardVerify);
                    reward.setRewardAmount(rewardAmount);
                    reward.setRewardName(rewardName);
                    reward.setErrorCode$csj_release(errorCode);
                    reward.setErrorMsg$csj_release(errorMsg);
                    CsjProviderReward.AnonymousClass1 anonymousClass1 = this.this$0;
                    CsjProviderReward.this.callbackRewardVerify(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onSkippedVideo() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onVideoComplete() {
                    CsjProviderReward.AnonymousClass1 anonymousClass1 = this.this$0;
                    CsjProviderReward.this.callbackRewardVideoComplete(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onVideoError() {
                }
            };
            TTRewardVideoAd tTRewardVideoAd2 = CsjProviderReward.this.mttRewardVideoAd;
            if (tTRewardVideoAd2 != null) {
                tTRewardVideoAd2.setRewardAdInteractionListener(rewardAdInteractionListener);
            }
            TTRewardVideoAd tTRewardVideoAd3 = CsjProviderReward.this.mttRewardVideoAd;
            if (tTRewardVideoAd3 != null) {
                tTRewardVideoAd3.setRewardPlayAgainInteractionListener(rewardAdInteractionListener);
            }
            TTRewardVideoAd tTRewardVideoAd4 = CsjProviderReward.this.mttRewardVideoAd;
            if (tTRewardVideoAd4 != null) {
                tTRewardVideoAd4.setDownloadListener(new TTAppDownloadListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderReward$requestAndShowRewardAd$1$onRewardVideoAdLoad$1
                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadActive(long totalBytes, long currBytes, @Nullable String fileName, @Nullable String appName) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFailed(long totalBytes, long currBytes, @Nullable String fileName, @Nullable String appName) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFinished(long totalBytes, @Nullable String fileName, @Nullable String appName) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadPaused(long totalBytes, long currBytes, @Nullable String fileName, @Nullable String appName) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onIdle() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onInstalled(@Nullable String fileName, @Nullable String appName) {
                    }
                });
            }
            CsjProviderReward.this.callbackRewardLoaded(this.$adProviderType, this.$alias, this.$listener);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(@Nullable TTRewardVideoAd videoAd) {
            CsjProviderReward.this.callbackRewardVideoCached(this.$adProviderType, this.$listener);
            CsjProviderReward.this.showRewardAd(this.$activity);
        }
    }

    /* JADX INFO: renamed from: com.ifmvo.togetherad.csj.provider.CsjProviderReward$requestRewardAd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CsjProviderReward.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"com/ifmvo/togetherad/csj/provider/CsjProviderReward$requestRewardAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$RewardVideoAdListener;", "", "code", "", "message", "Lf/v;", "onError", "(ILjava/lang/String;)V", "onRewardVideoCached", "()V", "Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;", "videoAd", "(Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;)V", ai.au, "onRewardVideoAdLoad", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class C03041 implements TTAdNative.RewardVideoAdListener {
        public final /* synthetic */ String $adProviderType;
        public final /* synthetic */ String $alias;
        public final /* synthetic */ RewardListener $listener;

        public C03041(String str, String str2, RewardListener rewardListener) {
            this.$adProviderType = str;
            this.$alias = str2;
            this.$listener = rewardListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int code, @Nullable String message) {
            CsjProviderReward.this.callbackRewardFailed(this.$adProviderType, this.$alias, this.$listener, Integer.valueOf(code), message);
            CsjProviderReward.this.mttRewardVideoAd = null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(@NotNull TTRewardVideoAd ad) {
            j.f(ad, ai.au);
            CsjProviderReward.this.mttRewardVideoAd = ad;
            TTRewardVideoAd tTRewardVideoAd = CsjProviderReward.this.mttRewardVideoAd;
            if (tTRewardVideoAd != null) {
                tTRewardVideoAd.setShowDownLoadBar(CsjProvider.Reward.INSTANCE.getShowDownLoadBar());
            }
            TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderReward$requestRewardAd$1$onRewardVideoAdLoad$rewardAdListener$1
                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdClose() {
                    CsjProviderReward.C03041 c03041 = this.this$0;
                    CsjProviderReward.this.callbackRewardClosed(c03041.$adProviderType, c03041.$listener);
                    CsjProviderReward.this.mttRewardVideoAd = null;
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdShow() {
                    CsjProviderReward.C03041 c03041 = this.this$0;
                    CsjProviderReward.this.callbackRewardShow(c03041.$adProviderType, c03041.$listener);
                    CsjProviderReward.C03041 c030412 = this.this$0;
                    CsjProviderReward.this.callbackRewardExpose(c030412.$adProviderType, c030412.$listener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onAdVideoBarClick() {
                    CsjProviderReward.C03041 c03041 = this.this$0;
                    CsjProviderReward.this.callbackRewardClicked(c03041.$adProviderType, c03041.$listener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify(boolean rewardVerify, int rewardAmount, @Nullable String rewardName, int errorCode, @Nullable String errorMsg) {
                    CsjProvider.Reward reward = CsjProvider.Reward.INSTANCE;
                    reward.setRewardVerify$csj_release(rewardVerify);
                    reward.setRewardAmount(rewardAmount);
                    reward.setRewardName(rewardName);
                    reward.setErrorCode$csj_release(errorCode);
                    reward.setErrorMsg$csj_release(errorMsg);
                    CsjProviderReward.C03041 c03041 = this.this$0;
                    CsjProviderReward.this.callbackRewardVerify(c03041.$adProviderType, c03041.$listener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onSkippedVideo() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onVideoComplete() {
                    CsjProviderReward.C03041 c03041 = this.this$0;
                    CsjProviderReward.this.callbackRewardVideoComplete(c03041.$adProviderType, c03041.$listener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                public void onVideoError() {
                }
            };
            TTRewardVideoAd tTRewardVideoAd2 = CsjProviderReward.this.mttRewardVideoAd;
            if (tTRewardVideoAd2 != null) {
                tTRewardVideoAd2.setRewardAdInteractionListener(rewardAdInteractionListener);
            }
            TTRewardVideoAd tTRewardVideoAd3 = CsjProviderReward.this.mttRewardVideoAd;
            if (tTRewardVideoAd3 != null) {
                tTRewardVideoAd3.setRewardPlayAgainInteractionListener(rewardAdInteractionListener);
            }
            TTRewardVideoAd tTRewardVideoAd4 = CsjProviderReward.this.mttRewardVideoAd;
            if (tTRewardVideoAd4 != null) {
                tTRewardVideoAd4.setDownloadListener(new TTAppDownloadListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderReward$requestRewardAd$1$onRewardVideoAdLoad$1
                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadActive(long totalBytes, long currBytes, @Nullable String fileName, @Nullable String appName) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFailed(long totalBytes, long currBytes, @Nullable String fileName, @Nullable String appName) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFinished(long totalBytes, @Nullable String fileName, @Nullable String appName) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadPaused(long totalBytes, long currBytes, @Nullable String fileName, @Nullable String appName) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onIdle() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onInstalled(@Nullable String fileName, @Nullable String appName) {
                    }
                });
            }
            CsjProviderReward.this.callbackRewardLoaded(this.$adProviderType, this.$alias, this.$listener);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(@Nullable TTRewardVideoAd videoAd) {
            CsjProviderReward.this.callbackRewardVideoCached(this.$adProviderType, this.$listener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void requestAndShowRewardAd(@org.jetbrains.annotations.NotNull android.app.Activity r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull com.ifmvo.togetherad.core.listener.RewardListener r13) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ifmvo.togetherad.csj.provider.CsjProviderReward.requestAndShowRewardAd(android.app.Activity, java.lang.String, java.lang.String, com.ifmvo.togetherad.core.listener.RewardListener):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void requestRewardAd(@org.jetbrains.annotations.NotNull android.app.Activity r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull com.ifmvo.togetherad.core.listener.RewardListener r11) {
        /*
            r7 = this;
            java.lang.String r0 = "activity"
            f.c0.c.j.f(r8, r0)
            java.lang.String r0 = "adProviderType"
            f.c0.c.j.f(r9, r0)
            java.lang.String r0 = "alias"
            f.c0.c.j.f(r10, r0)
            java.lang.String r0 = "listener"
            f.c0.c.j.f(r11, r0)
            r7.callbackRewardStartRequest(r9, r10, r11)
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = new com.bytedance.sdk.openadsdk.AdSlot$Builder
            r0.<init>()
            com.ifmvo.togetherad.csj.TogetherAdCsj r1 = com.ifmvo.togetherad.csj.TogetherAdCsj.INSTANCE
            int r2 = r1.getDownloadType()
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = r0.setDownloadType(r2)
            java.util.Map r2 = r1.getIdMapCsj()
            java.lang.Object r2 = r2.get(r10)
            java.lang.String r2 = (java.lang.String) r2
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = r0.setCodeId(r2)
            com.ifmvo.togetherad.csj.provider.CsjProvider$Reward r2 = com.ifmvo.togetherad.csj.provider.CsjProvider.Reward.INSTANCE
            boolean r3 = r2.getSupportDeepLink()
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = r0.setSupportDeepLink(r3)
            int r3 = r2.getRewardAmount()
            r4 = -1
            if (r3 == r4) goto L49
            int r4 = r2.getRewardAmount()
        L49:
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = r0.setRewardAmount(r4)
            java.lang.String r3 = r2.getRewardName()
            java.lang.String r4 = ""
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L67
            int r3 = r3.length()
            if (r3 <= 0) goto L5f
            r3 = 1
            goto L60
        L5f:
            r3 = 0
        L60:
            if (r3 != r6) goto L67
            java.lang.String r3 = r2.getRewardName()
            goto L68
        L67:
            r3 = r4
        L68:
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = r0.setRewardName(r3)
            java.lang.String r3 = r2.getUserID()
            if (r3 == 0) goto L81
            int r3 = r3.length()
            if (r3 <= 0) goto L7a
            r3 = 1
            goto L7b
        L7a:
            r3 = 0
        L7b:
            if (r3 != r6) goto L81
            java.lang.String r4 = r2.getUserID()
        L81:
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = r0.setUserID(r4)
            int r3 = r2.getOrientation()
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = r0.setOrientation(r3)
            java.lang.String r3 = r2.getMediaExtra()
            if (r3 == 0) goto La3
            int r3 = r3.length()
            if (r3 <= 0) goto L9a
            r5 = 1
        L9a:
            if (r5 != r6) goto La3
            java.lang.String r3 = r2.getMediaExtra()
            r0.setMediaExtra(r3)
        La3:
            boolean r2 = r2.isExpress()
            if (r2 == 0) goto Lae
            r2 = 1140457472(0x43fa0000, float:500.0)
            r0.setExpressViewAcceptedSize(r2, r2)
        Lae:
            com.bytedance.sdk.openadsdk.TTAdManager r1 = r1.getMTTAdManager()
            com.bytedance.sdk.openadsdk.TTAdNative r8 = r1.createAdNative(r8)
            com.bytedance.sdk.openadsdk.AdSlot r0 = r0.build()
            com.ifmvo.togetherad.csj.provider.CsjProviderReward$requestRewardAd$1 r1 = new com.ifmvo.togetherad.csj.provider.CsjProviderReward$requestRewardAd$1
            r1.<init>(r9, r10, r11)
            r8.loadRewardVideoAd(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ifmvo.togetherad.csj.provider.CsjProviderReward.requestRewardAd(android.app.Activity, java.lang.String, java.lang.String, com.ifmvo.togetherad.core.listener.RewardListener):void");
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public boolean showRewardAd(@NotNull Activity activity) {
        j.f(activity, "activity");
        StringBuilder sb = new StringBuilder();
        sb.append("过期时间：");
        TTRewardVideoAd tTRewardVideoAd = this.mttRewardVideoAd;
        sb.append(tTRewardVideoAd != null ? Long.valueOf(tTRewardVideoAd.getExpirationTimestamp()) : null);
        LogExtKt.logd(sb.toString(), getTag());
        TTRewardVideoAd tTRewardVideoAd2 = this.mttRewardVideoAd;
        if ((tTRewardVideoAd2 != null ? tTRewardVideoAd2.getExpirationTimestamp() : 0L) <= System.currentTimeMillis()) {
            return false;
        }
        TTRewardVideoAd tTRewardVideoAd3 = this.mttRewardVideoAd;
        if (tTRewardVideoAd3 == null) {
            return true;
        }
        tTRewardVideoAd3.showRewardVideoAd(activity, TTAdConstant.RitScenes.CUSTOMIZE_SCENES, "scenes_test");
        return true;
    }
}
