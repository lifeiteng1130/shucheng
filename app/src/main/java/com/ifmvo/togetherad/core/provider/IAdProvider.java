package com.ifmvo.togetherad.core.provider;

import android.app.Activity;
import android.view.ViewGroup;
import com.ifmvo.togetherad.core.listener.BannerListener;
import com.ifmvo.togetherad.core.listener.FullVideoListener;
import com.ifmvo.togetherad.core.listener.InterListener;
import com.ifmvo.togetherad.core.listener.NativeExpressListener;
import com.ifmvo.togetherad.core.listener.NativeListener;
import com.ifmvo.togetherad.core.listener.RewardListener;
import com.ifmvo.togetherad.core.listener.SplashListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IAdProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JA\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ7\u0010\u000e\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u0012JA\u0010\u0014\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH&¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH&¢\u0006\u0004\b\u001d\u0010\u0017J?\u0010!\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0001\u0010\n\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u00102\b\b\u0001\u0010#\u001a\u00020\u0001H&¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u00020\u000b2\b\b\u0001\u0010#\u001a\u00020\u0001H&¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\u000b2\b\b\u0001\u0010#\u001a\u00020\u0001H&¢\u0006\u0004\b(\u0010'J\u0019\u0010)\u001a\u00020\u000b2\b\b\u0001\u0010#\u001a\u00020\u0001H&¢\u0006\u0004\b)\u0010'J?\u0010,\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u001e2\b\b\u0001\u0010\n\u001a\u00020+H&¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0001H&¢\u0006\u0004\b.\u0010'J\u0017\u0010/\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0001H&¢\u0006\u0004\b/\u0010%J7\u00101\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u000200H&¢\u0006\u0004\b1\u00102J7\u00103\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u000200H&¢\u0006\u0004\b3\u00102J\u0019\u00104\u001a\u00020\u00102\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b4\u00105J7\u00107\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u000206H&¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\u00102\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b9\u00105¨\u0006:"}, d2 = {"Lcom/ifmvo/togetherad/core/provider/IAdProvider;", "", "Landroid/app/Activity;", "activity", "", "adProviderType", "alias", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/listener/SplashListener;", "listener", "Lf/v;", "loadAndShowSplashAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "loadOnlySplashAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "", "showSplashAd", "(Landroid/view/ViewGroup;)Z", "Lcom/ifmvo/togetherad/core/listener/BannerListener;", "showBannerAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/BannerListener;)V", "destroyBannerAd", "()V", "Lcom/ifmvo/togetherad/core/listener/InterListener;", "requestInterAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/InterListener;)V", "showInterAd", "(Landroid/app/Activity;)V", "destroyInterAd", "", "maxCount", "Lcom/ifmvo/togetherad/core/listener/NativeListener;", "getNativeAdList", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;ILcom/ifmvo/togetherad/core/listener/NativeListener;)V", "adObject", "nativeAdIsBelongTheProvider", "(Ljava/lang/Object;)Z", "resumeNativeAd", "(Ljava/lang/Object;)V", "pauseNativeAd", "destroyNativeAd", "adCount", "Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;", "getNativeExpressAdList", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;ILcom/ifmvo/togetherad/core/listener/NativeExpressListener;)V", "destroyNativeExpressAd", "nativeExpressAdIsBelongTheProvider", "Lcom/ifmvo/togetherad/core/listener/RewardListener;", "requestAndShowRewardAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/RewardListener;)V", "requestRewardAd", "showRewardAd", "(Landroid/app/Activity;)Z", "Lcom/ifmvo/togetherad/core/listener/FullVideoListener;", "requestFullVideoAd", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/FullVideoListener;)V", "showFullVideoAd", "core_release"}, k = 1, mv = {1, 4, 0})
public interface IAdProvider {
    void destroyBannerAd();

    void destroyInterAd();

    void destroyNativeAd(@NotNull Object adObject);

    void destroyNativeExpressAd(@NotNull Object adObject);

    void getNativeAdList(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, int maxCount, @NotNull NativeListener listener);

    void getNativeExpressAdList(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, int adCount, @NotNull NativeExpressListener listener);

    void loadAndShowSplashAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull ViewGroup container, @NotNull SplashListener listener);

    void loadOnlySplashAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull SplashListener listener);

    boolean nativeAdIsBelongTheProvider(@NotNull Object adObject);

    boolean nativeExpressAdIsBelongTheProvider(@NotNull Object adObject);

    void pauseNativeAd(@NotNull Object adObject);

    void requestAndShowRewardAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull RewardListener listener);

    void requestFullVideoAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull FullVideoListener listener);

    void requestInterAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull InterListener listener);

    void requestRewardAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull RewardListener listener);

    void resumeNativeAd(@NotNull Object adObject);

    void showBannerAd(@NotNull Activity activity, @NotNull String adProviderType, @NotNull String alias, @NotNull ViewGroup container, @NotNull BannerListener listener);

    boolean showFullVideoAd(@NotNull Activity activity);

    void showInterAd(@NotNull Activity activity);

    boolean showRewardAd(@NotNull Activity activity);

    boolean showSplashAd(@NotNull ViewGroup container);
}
