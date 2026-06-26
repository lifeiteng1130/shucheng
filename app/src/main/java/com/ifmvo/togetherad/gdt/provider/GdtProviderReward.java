package com.ifmvo.togetherad.gdt.provider;

import android.app.Activity;
import com.ifmvo.togetherad.core.listener.RewardListener;
import com.ifmvo.togetherad.gdt.TogetherAdGdt;
import com.ifmvo.togetherad.gdt.provider.GdtProvider;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.VideoAdValidity;
import f.c0.c.j;
import f.f;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GdtProviderReward.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProviderReward;", "Lcom/ifmvo/togetherad/gdt/provider/GdtProviderNativeExpress;", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "Lcom/ifmvo/togetherad/core/listener/RewardListener;", "listener", "Lf/v;", "requestRewardAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/RewardListener;)V", "", "showRewardAd", "(Landroid/app/Activity;)Z", "requestAndShowRewardAd", "Lcom/qq/e/ads/rewardvideo/RewardVideoAD;", "rewardVideoAD", "Lcom/qq/e/ads/rewardvideo/RewardVideoAD;", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
public abstract class GdtProviderReward extends GdtProviderNativeExpress {
    private RewardVideoAD rewardVideoAD;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VideoAdValidity.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[VideoAdValidity.SHOWED.ordinal()] = 1;
            iArr[VideoAdValidity.OVERDUE.ordinal()] = 2;
            iArr[VideoAdValidity.VALID.ordinal()] = 3;
            iArr[VideoAdValidity.NONE_CACHE.ordinal()] = 4;
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void requestAndShowRewardAd(@NotNull final Activity activity, @NotNull final String adProviderType, @NotNull final String alias, @NotNull final RewardListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        callbackRewardStartRequest(adProviderType, alias, listener);
        RewardVideoAD rewardVideoAD = new RewardVideoAD(activity, TogetherAdGdt.INSTANCE.getIdMapGDT().get(alias), new RewardVideoADListener() { // from class: com.ifmvo.togetherad.gdt.provider.GdtProviderReward.requestAndShowRewardAd.1
            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClick() {
                GdtProviderReward.this.callbackRewardClicked(adProviderType, listener);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClose() {
                GdtProviderReward.this.callbackRewardClosed(adProviderType, listener);
                GdtProviderReward.this.rewardVideoAD = null;
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADExpose() {
                GdtProviderReward.this.callbackRewardExpose(adProviderType, listener);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADLoad() {
                RewardVideoAD rewardVideoAD2;
                DownloadConfirmListener downloadConfirmListener = TogetherAdGdt.INSTANCE.getDownloadConfirmListener();
                if (downloadConfirmListener != null && (rewardVideoAD2 = GdtProviderReward.this.rewardVideoAD) != null) {
                    rewardVideoAD2.setDownloadConfirmListener(downloadConfirmListener);
                }
                GdtProviderReward.this.callbackRewardLoaded(adProviderType, alias, listener);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADShow() {
                GdtProviderReward.this.callbackRewardShow(adProviderType, listener);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onError(@Nullable AdError adError) {
                GdtProviderReward.this.callbackRewardFailed(adProviderType, alias, listener, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
                GdtProviderReward.this.rewardVideoAD = null;
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onReward(@Nullable Map<String, Object> map) {
                if (map != null) {
                    GdtProvider.Reward.INSTANCE.setVerificationOption(map.get(ServerSideVerificationOptions.TRANS_ID));
                }
                GdtProviderReward.this.callbackRewardVerify(adProviderType, listener);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoCached() {
                GdtProviderReward.this.callbackRewardVideoCached(adProviderType, listener);
                GdtProviderReward.this.showRewardAd(activity);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoComplete() {
                GdtProviderReward.this.callbackRewardVideoComplete(adProviderType, listener);
            }
        }, GdtProvider.Reward.INSTANCE.getVolumeOn());
        this.rewardVideoAD = rewardVideoAD;
        if (rewardVideoAD != null) {
            rewardVideoAD.loadAD();
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public void requestRewardAd(@NotNull Activity activity, @NotNull final String adProviderType, @NotNull final String alias, @NotNull final RewardListener listener) {
        j.f(activity, "activity");
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        callbackRewardStartRequest(adProviderType, alias, listener);
        RewardVideoAD rewardVideoAD = new RewardVideoAD(activity, TogetherAdGdt.INSTANCE.getIdMapGDT().get(alias), new RewardVideoADListener() { // from class: com.ifmvo.togetherad.gdt.provider.GdtProviderReward.requestRewardAd.1
            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClick() {
                GdtProviderReward.this.callbackRewardClicked(adProviderType, listener);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClose() {
                GdtProviderReward.this.callbackRewardClosed(adProviderType, listener);
                GdtProviderReward.this.rewardVideoAD = null;
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADExpose() {
                GdtProviderReward.this.callbackRewardExpose(adProviderType, listener);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADLoad() {
                RewardVideoAD rewardVideoAD2;
                DownloadConfirmListener downloadConfirmListener = TogetherAdGdt.INSTANCE.getDownloadConfirmListener();
                if (downloadConfirmListener != null && (rewardVideoAD2 = GdtProviderReward.this.rewardVideoAD) != null) {
                    rewardVideoAD2.setDownloadConfirmListener(downloadConfirmListener);
                }
                GdtProviderReward.this.callbackRewardLoaded(adProviderType, alias, listener);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADShow() {
                GdtProviderReward.this.callbackRewardShow(adProviderType, listener);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onError(@Nullable AdError adError) {
                GdtProviderReward.this.callbackRewardFailed(adProviderType, alias, listener, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
                GdtProviderReward.this.rewardVideoAD = null;
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onReward(@Nullable Map<String, Object> map) {
                if (map != null) {
                    GdtProvider.Reward.INSTANCE.setVerificationOption(map.get(ServerSideVerificationOptions.TRANS_ID));
                }
                GdtProviderReward.this.callbackRewardVerify(adProviderType, listener);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoCached() {
                GdtProviderReward.this.callbackRewardVideoCached(adProviderType, listener);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoComplete() {
                GdtProviderReward.this.callbackRewardVideoComplete(adProviderType, listener);
            }
        }, GdtProvider.Reward.INSTANCE.getVolumeOn());
        this.rewardVideoAD = rewardVideoAD;
        if (rewardVideoAD != null) {
            rewardVideoAD.loadAD();
        }
    }

    @Override // com.ifmvo.togetherad.core.provider.IAdProvider
    public boolean showRewardAd(@NotNull Activity activity) {
        j.f(activity, "activity");
        RewardVideoAD rewardVideoAD = this.rewardVideoAD;
        if (rewardVideoAD == null) {
            return false;
        }
        if (rewardVideoAD == null) {
            j.l();
            throw null;
        }
        VideoAdValidity videoAdValidityCheckValidity = rewardVideoAD.checkValidity();
        if (videoAdValidityCheckValidity == null) {
            j.l();
            throw null;
        }
        int iOrdinal = videoAdValidityCheckValidity.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1 || iOrdinal == 2) {
                return false;
            }
            if (iOrdinal != 3) {
                throw new f();
            }
        }
        RewardVideoAD rewardVideoAD2 = this.rewardVideoAD;
        if (rewardVideoAD2 != null) {
            rewardVideoAD2.showAD();
        }
        return true;
    }
}
