package com.ifmvo.togetherad.csj.provider;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.ifmvo.togetherad.core.listener.FullVideoListener;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import com.ifmvo.togetherad.csj.TogetherAdCsj;
import com.ifmvo.togetherad.csj.provider.CsjProvider;
import com.ifmvo.togetherad.csj.provider.CsjProviderFullVideo;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CsjProviderFullVideo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProviderFullVideo;", "Lcom/ifmvo/togetherad/csj/provider/CsjProviderBanner;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "Lcom/ifmvo/togetherad/core/listener/FullVideoListener;", "listener", "Lf/v;", "requestFullVideoAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/FullVideoListener;)V", "", "showFullVideoAd", "(Landroid/app/Activity;)Z", "Lcom/bytedance/sdk/openadsdk/TTFullScreenVideoAd;", "mFllScreenVideoAd", "Lcom/bytedance/sdk/openadsdk/TTFullScreenVideoAd;", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
public abstract class CsjProviderFullVideo extends CsjProviderBanner {
    private TTFullScreenVideoAd mFllScreenVideoAd;

    /* JADX INFO: renamed from: com.ifmvo.togetherad.csj.provider.CsjProviderFullVideo$requestFullVideoAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: CsjProviderFullVideo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/ifmvo/togetherad/csj/provider/CsjProviderFullVideo$requestFullVideoAd$1", "Lcom/bytedance/sdk/openadsdk/TTAdNative$FullScreenVideoAdListener;", "Lcom/bytedance/sdk/openadsdk/TTFullScreenVideoAd;", "fullScreenVideoAd", "Lf/v;", "onFullScreenVideoAdLoad", "(Lcom/bytedance/sdk/openadsdk/TTFullScreenVideoAd;)V", "onFullScreenVideoCached", "()V", "videoAd", "", "errorCode", "", "errorMsg", "onError", "(ILjava/lang/String;)V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 implements TTAdNative.FullScreenVideoAdListener {
        public final /* synthetic */ String $adProviderType;
        public final /* synthetic */ String $alias;
        public final /* synthetic */ FullVideoListener $listener;

        public AnonymousClass1(String str, FullVideoListener fullVideoListener, String str2) {
            this.$adProviderType = str;
            this.$listener = fullVideoListener;
            this.$alias = str2;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int errorCode, @Nullable String errorMsg) {
            CsjProviderFullVideo.this.callbackFullVideoFailed(this.$adProviderType, this.$alias, this.$listener, Integer.valueOf(errorCode), errorMsg);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(@Nullable TTFullScreenVideoAd fullScreenVideoAd) {
            CsjProviderFullVideo.this.mFllScreenVideoAd = fullScreenVideoAd;
            TTFullScreenVideoAd tTFullScreenVideoAd = CsjProviderFullVideo.this.mFllScreenVideoAd;
            if (tTFullScreenVideoAd != null) {
                tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.ifmvo.togetherad.csj.provider.CsjProviderFullVideo$requestFullVideoAd$1$onFullScreenVideoAdLoad$1
                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdClose() {
                        CsjProviderFullVideo.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderFullVideo.this.callbackFullVideoClosed(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdShow() {
                        CsjProviderFullVideo.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderFullVideo.this.callbackFullVideoShow(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdVideoBarClick() {
                        CsjProviderFullVideo.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderFullVideo.this.callbackFullVideoClicked(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onSkippedVideo() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onVideoComplete() {
                        CsjProviderFullVideo.AnonymousClass1 anonymousClass1 = this.this$0;
                        CsjProviderFullVideo.this.callbackFullVideoComplete(anonymousClass1.$adProviderType, anonymousClass1.$listener);
                    }
                });
            }
            CsjProviderFullVideo.this.callbackFullVideoLoaded(this.$adProviderType, this.$alias, this.$listener);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached(@Nullable TTFullScreenVideoAd videoAd) {
            CsjProviderFullVideo.this.callbackFullVideoCached(this.$adProviderType, this.$listener);
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void requestFullVideoAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull FullVideoListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        callbackFullVideoStartRequest(adProviderType, alias, listener);
        AdSlot.Builder builder = new AdSlot.Builder();
        TogetherAdCsj togetherAdCsj = TogetherAdCsj.INSTANCE;
        builder.setCodeId(togetherAdCsj.getIdMapCsj().get(alias));
        builder.setDownloadType(togetherAdCsj.getDownloadType());
        CsjProvider.FullVideo fullVideo = CsjProvider.FullVideo.INSTANCE;
        if (fullVideo.isExpress()) {
            builder.setExpressViewAcceptedSize(500.0f, 500.0f);
        }
        builder.setSupportDeepLink(fullVideo.getSupportDeepLink());
        builder.setOrientation(fullVideo.getOrientation());
        togetherAdCsj.getMTTAdManager().createAdNative(activity).loadFullScreenVideoAd(builder.build(), new AnonymousClass1(adProviderType, listener, alias));
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public boolean showFullVideoAd(@NotNull Activity activity) {
        j.f(activity, "activity");
        StringBuilder sb = new StringBuilder();
        sb.append("过期时间：");
        TTFullScreenVideoAd tTFullScreenVideoAd = this.mFllScreenVideoAd;
        sb.append(tTFullScreenVideoAd != null ? Long.valueOf(tTFullScreenVideoAd.getExpirationTimestamp()) : null);
        LogExtKt.logd(sb.toString(), getTag());
        TTFullScreenVideoAd tTFullScreenVideoAd2 = this.mFllScreenVideoAd;
        if ((tTFullScreenVideoAd2 != null ? tTFullScreenVideoAd2.getExpirationTimestamp() : 0L) <= System.currentTimeMillis()) {
            return false;
        }
        TTAdConstant.RitScenes ritScenes = CsjProvider.FullVideo.INSTANCE.getRitScenes();
        if (ritScenes != null) {
            TTFullScreenVideoAd tTFullScreenVideoAd3 = this.mFllScreenVideoAd;
            if (tTFullScreenVideoAd3 != null) {
                tTFullScreenVideoAd3.showFullScreenVideoAd(activity, ritScenes, null);
            }
        } else {
            TTFullScreenVideoAd tTFullScreenVideoAd4 = this.mFllScreenVideoAd;
            if (tTFullScreenVideoAd4 != null) {
                tTFullScreenVideoAd4.showFullScreenVideoAd(activity);
            }
        }
        this.mFllScreenVideoAd = null;
        return true;
    }
}
