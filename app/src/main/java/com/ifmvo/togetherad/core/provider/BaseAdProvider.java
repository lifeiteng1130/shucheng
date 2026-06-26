package com.ifmvo.togetherad.core.provider;

import android.os.Handler;
import android.os.Looper;
import c.a.a.a.a;
import com.ifmvo.togetherad.core.TogetherAd;
import com.ifmvo.togetherad.core.listener.AllAdListener;
import com.ifmvo.togetherad.core.listener.BannerListener;
import com.ifmvo.togetherad.core.listener.FullVideoListener;
import com.ifmvo.togetherad.core.listener.InterListener;
import com.ifmvo.togetherad.core.listener.NativeExpressListener;
import com.ifmvo.togetherad.core.listener.NativeListener;
import com.ifmvo.togetherad.core.listener.RewardListener;
import com.ifmvo.togetherad.core.listener.SplashListener;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import f.c0.c.j;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseAdProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b^\u0010_J-\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\b\u0010\tJ-\u0010\n\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\n\u0010\tJ#\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\r\u0010\fJA\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0013\u0010\fJ-\u0010\u0015\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0014H\u0004¢\u0006\u0004\b\u0015\u0010\u0016J=\u0010\u001a\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00142\u000e\b\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0004¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u001c\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001f\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u001eH\u0004¢\u0006\u0004\b\u001f\u0010 J=\u0010!\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u001e2\u000e\b\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0004¢\u0006\u0004\b!\u0010\"JA\u0010#\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\b#\u0010$J/\u0010&\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00182\b\b\u0001\u0010\u0006\u001a\u00020\u001eH\u0004¢\u0006\u0004\b&\u0010'J/\u0010(\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00182\b\b\u0001\u0010\u0006\u001a\u00020\u001eH\u0004¢\u0006\u0004\b(\u0010'J/\u0010)\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00182\b\b\u0001\u0010\u0006\u001a\u00020\u001eH\u0004¢\u0006\u0004\b)\u0010'J/\u0010*\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00182\b\b\u0001\u0010\u0006\u001a\u00020\u001eH\u0004¢\u0006\u0004\b*\u0010'J/\u0010+\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00182\b\b\u0001\u0010\u0006\u001a\u00020\u001eH\u0004¢\u0006\u0004\b+\u0010'J-\u0010-\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020,H\u0004¢\u0006\u0004\b-\u0010.J-\u0010/\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020,H\u0004¢\u0006\u0004\b/\u0010.JA\u00100\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020,2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\b0\u00101J#\u00102\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020,H\u0004¢\u0006\u0004\b2\u00103J#\u00104\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020,H\u0004¢\u0006\u0004\b4\u00103J#\u00105\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020,H\u0004¢\u0006\u0004\b5\u00103J#\u00106\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020,H\u0004¢\u0006\u0004\b6\u00103J#\u00107\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020,H\u0004¢\u0006\u0004\b7\u00103J#\u00108\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020,H\u0004¢\u0006\u0004\b8\u00103J#\u00109\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020,H\u0004¢\u0006\u0004\b9\u00103J-\u0010;\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020:H\u0004¢\u0006\u0004\b;\u0010<J-\u0010=\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020:H\u0004¢\u0006\u0004\b=\u0010<JA\u0010>\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020:2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\b>\u0010?J#\u0010@\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020:H\u0004¢\u0006\u0004\b@\u0010AJ#\u0010B\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020:H\u0004¢\u0006\u0004\bB\u0010AJ#\u0010C\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020:H\u0004¢\u0006\u0004\bC\u0010AJ#\u0010D\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020:H\u0004¢\u0006\u0004\bD\u0010AJ#\u0010E\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020:H\u0004¢\u0006\u0004\bE\u0010AJ-\u0010G\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020FH\u0004¢\u0006\u0004\bG\u0010HJ-\u0010I\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020FH\u0004¢\u0006\u0004\bI\u0010HJA\u0010J\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020F2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\bJ\u0010KJ#\u0010L\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020FH\u0004¢\u0006\u0004\bL\u0010MJ#\u0010N\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020FH\u0004¢\u0006\u0004\bN\u0010MJ#\u0010O\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020FH\u0004¢\u0006\u0004\bO\u0010MJ-\u0010Q\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020PH\u0004¢\u0006\u0004\bQ\u0010RJ-\u0010S\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020PH\u0004¢\u0006\u0004\bS\u0010RJA\u0010T\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020P2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\bT\u0010UJ#\u0010V\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020PH\u0004¢\u0006\u0004\bV\u0010WJ#\u0010X\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020PH\u0004¢\u0006\u0004\bX\u0010WJ#\u0010Y\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020PH\u0004¢\u0006\u0004\bY\u0010WR\u001e\u0010Z\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]¨\u0006`"}, d2 = {"Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "Lcom/ifmvo/togetherad/core/provider/IAdProvider;", "", "adProviderType", "alias", "Lcom/ifmvo/togetherad/core/listener/SplashListener;", "listener", "Lf/v;", "callbackSplashStartRequest", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "callbackSplashLoaded", "callbackSplashClicked", "(Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/SplashListener;)V", "callbackSplashExposure", "", "errorCode", "errorMsg", "callbackSplashFailed", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/SplashListener;Ljava/lang/Integer;Ljava/lang/String;)V", "callbackSplashDismiss", "Lcom/ifmvo/togetherad/core/listener/NativeListener;", "callbackNativeStartRequest", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/NativeListener;)V", "", "", "adList", "callbackNativeLoaded", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/NativeListener;Ljava/util/List;)V", "callbackNativeFailed", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/NativeListener;Ljava/lang/Integer;Ljava/lang/String;)V", "Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;", "callbackNativeExpressStartRequest", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;)V", "callbackNativeExpressLoaded", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;Ljava/util/List;)V", "callbackNativeExpressFailed", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;Ljava/lang/Integer;Ljava/lang/String;)V", "adObject", "callbackNativeExpressClicked", "(Ljava/lang/String;Ljava/lang/Object;Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;)V", "callbackNativeExpressShow", "callbackNativeExpressRenderSuccess", "callbackNativeExpressRenderFail", "callbackNativeExpressClosed", "Lcom/ifmvo/togetherad/core/listener/RewardListener;", "callbackRewardStartRequest", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/RewardListener;)V", "callbackRewardLoaded", "callbackRewardFailed", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/RewardListener;Ljava/lang/Integer;Ljava/lang/String;)V", "callbackRewardClicked", "(Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/RewardListener;)V", "callbackRewardShow", "callbackRewardExpose", "callbackRewardVideoComplete", "callbackRewardVideoCached", "callbackRewardVerify", "callbackRewardClosed", "Lcom/ifmvo/togetherad/core/listener/FullVideoListener;", "callbackFullVideoStartRequest", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/FullVideoListener;)V", "callbackFullVideoLoaded", "callbackFullVideoFailed", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/FullVideoListener;Ljava/lang/Integer;Ljava/lang/String;)V", "callbackFullVideoClicked", "(Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/FullVideoListener;)V", "callbackFullVideoShow", "callbackFullVideoCached", "callbackFullVideoClosed", "callbackFullVideoComplete", "Lcom/ifmvo/togetherad/core/listener/BannerListener;", "callbackBannerStartRequest", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/BannerListener;)V", "callbackBannerLoaded", "callbackBannerFailed", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/BannerListener;Ljava/lang/Integer;Ljava/lang/String;)V", "callbackBannerClosed", "(Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/BannerListener;)V", "callbackBannerExpose", "callbackBannerClicked", "Lcom/ifmvo/togetherad/core/listener/InterListener;", "callbackInterStartRequest", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/InterListener;)V", "callbackInterLoaded", "callbackInterFailed", "(Ljava/lang/String;Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/InterListener;Ljava/lang/Integer;Ljava/lang/String;)V", "callbackInterClosed", "(Ljava/lang/String;Lcom/ifmvo/togetherad/core/listener/InterListener;)V", "callbackInterExpose", "callbackInterClicked", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public abstract class BaseAdProvider implements IAdProvider {

    @Nullable
    private final String tag = getClass().getSimpleName();

    public final void callbackBannerClicked(@NotNull final String adProviderType, @NotNull final BannerListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackBannerClicked.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 点击了"), null, 1, null);
                listener.onAdClicked(adProviderType);
            }
        });
    }

    public final void callbackBannerClosed(@NotNull final String adProviderType, @NotNull final BannerListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackBannerClosed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 关闭了"), null, 1, null);
                listener.onAdClose(adProviderType);
            }
        });
    }

    public final void callbackBannerExpose(@NotNull final String adProviderType, @NotNull final BannerListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackBannerExpose.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 曝光了"), null, 1, null);
                listener.onAdExpose(adProviderType);
            }
        });
    }

    public final void callbackBannerFailed(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final BannerListener listener, @Nullable final Integer errorCode, @Nullable final String errorMsg) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackBannerFailed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(adProviderType + ": 请求失败了：" + errorCode + ' ' + errorMsg, null, 1, null);
                listener.onAdFailed(adProviderType, errorMsg);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdFailed(adProviderType, alias, errorMsg);
                }
            }
        });
    }

    public final void callbackBannerLoaded(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final BannerListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackBannerLoaded.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 请求成功了"), null, 1, null);
                listener.onAdLoaded(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdLoaded(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackBannerStartRequest(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final BannerListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackBannerStartRequest.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 开始请求"), null, 1, null);
                listener.onAdStartRequest(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdStartRequest(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackFullVideoCached(@NotNull final String adProviderType, @NotNull final FullVideoListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackFullVideoCached.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 视频已缓存"), null, 1, null);
                listener.onAdVideoCached(adProviderType);
            }
        });
    }

    public final void callbackFullVideoClicked(@NotNull final String adProviderType, @NotNull final FullVideoListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackFullVideoClicked.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 点击了"), null, 1, null);
                listener.onAdClicked(adProviderType);
            }
        });
    }

    public final void callbackFullVideoClosed(@NotNull final String adProviderType, @NotNull final FullVideoListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackFullVideoClosed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 关闭了"), null, 1, null);
                listener.onAdClose(adProviderType);
            }
        });
    }

    public final void callbackFullVideoComplete(@NotNull final String adProviderType, @NotNull final FullVideoListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackFullVideoComplete.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 视频播放完成了"), null, 1, null);
                listener.onAdVideoComplete(adProviderType);
            }
        });
    }

    public final void callbackFullVideoFailed(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final FullVideoListener listener, @Nullable final Integer errorCode, @Nullable final String errorMsg) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackFullVideoFailed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(adProviderType + ": 请求失败了：" + errorCode + ' ' + errorMsg, null, 1, null);
                listener.onAdFailed(adProviderType, errorMsg);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdFailed(adProviderType, alias, errorMsg);
                }
            }
        });
    }

    public final void callbackFullVideoLoaded(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final FullVideoListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackFullVideoLoaded.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 请求成功了"), null, 1, null);
                listener.onAdLoaded(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdLoaded(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackFullVideoShow(@NotNull final String adProviderType, @NotNull final FullVideoListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackFullVideoShow.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 展示了"), null, 1, null);
                listener.onAdShow(adProviderType);
            }
        });
    }

    public final void callbackFullVideoStartRequest(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final FullVideoListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackFullVideoStartRequest.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 开始请求"), null, 1, null);
                listener.onAdStartRequest(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdStartRequest(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackInterClicked(@NotNull final String adProviderType, @NotNull final InterListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackInterClicked.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 点击了"), null, 1, null);
                listener.onAdClicked(adProviderType);
            }
        });
    }

    public final void callbackInterClosed(@NotNull final String adProviderType, @NotNull final InterListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackInterClosed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 关闭了"), null, 1, null);
                listener.onAdClose(adProviderType);
            }
        });
    }

    public final void callbackInterExpose(@NotNull final String adProviderType, @NotNull final InterListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackInterExpose.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 曝光了"), null, 1, null);
                listener.onAdExpose(adProviderType);
            }
        });
    }

    public final void callbackInterFailed(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final InterListener listener, @Nullable final Integer errorCode, @Nullable final String errorMsg) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackInterFailed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(adProviderType + ": 请求失败了：" + errorCode + ' ' + errorMsg, null, 1, null);
                listener.onAdFailed(adProviderType, errorMsg);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdFailed(adProviderType, alias, errorMsg);
                }
            }
        });
    }

    public final void callbackInterLoaded(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final InterListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackInterLoaded.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 请求成功了"), null, 1, null);
                listener.onAdLoaded(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdLoaded(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackInterStartRequest(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final InterListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackInterStartRequest.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 开始请求"), null, 1, null);
                listener.onAdStartRequest(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdStartRequest(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackNativeExpressClicked(@NotNull final String adProviderType, @Nullable final Object adObject, @NotNull final NativeExpressListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackNativeExpressClicked.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 点击了"), null, 1, null);
                listener.onAdClicked(adProviderType, adObject);
            }
        });
    }

    public final void callbackNativeExpressClosed(@NotNull final String adProviderType, @Nullable final Object adObject, @NotNull final NativeExpressListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackNativeExpressClosed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 关闭了"), null, 1, null);
                listener.onAdClosed(adProviderType, adObject);
            }
        });
    }

    public final void callbackNativeExpressFailed(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final NativeExpressListener listener, @Nullable final Integer errorCode, @Nullable final String errorMsg) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackNativeExpressFailed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(adProviderType + ": 请求失败了：" + errorCode + ' ' + errorMsg, null, 1, null);
                listener.onAdFailed(adProviderType, errorMsg);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdFailed(adProviderType, alias, errorMsg);
                }
            }
        });
    }

    public final void callbackNativeExpressLoaded(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final NativeExpressListener listener, @NotNull final List<? extends Object> adList) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        j.f(adList, "adList");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackNativeExpressLoaded.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 请求成功了, 请求到" + adList.size() + "个广告", null, 1, null);
                listener.onAdLoaded(adProviderType, adList);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdLoaded(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackNativeExpressRenderFail(@NotNull final String adProviderType, @Nullable final Object adObject, @NotNull final NativeExpressListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackNativeExpressRenderFail.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(a.p(new StringBuilder(), adProviderType, ": 渲染失败了"), null, 1, null);
                listener.onAdRenderFail(adProviderType, adObject);
            }
        });
    }

    public final void callbackNativeExpressRenderSuccess(@NotNull final String adProviderType, @Nullable final Object adObject, @NotNull final NativeExpressListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackNativeExpressRenderSuccess.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 渲染成功"), null, 1, null);
                listener.onAdRenderSuccess(adProviderType, adObject);
            }
        });
    }

    public final void callbackNativeExpressShow(@NotNull final String adProviderType, @Nullable final Object adObject, @NotNull final NativeExpressListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackNativeExpressShow.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 展示了"), null, 1, null);
                listener.onAdShow(adProviderType, adObject);
            }
        });
    }

    public final void callbackNativeExpressStartRequest(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final NativeExpressListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackNativeExpressStartRequest.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 开始请求"), null, 1, null);
                listener.onAdStartRequest(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdStartRequest(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackNativeFailed(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final NativeListener listener, @Nullable final Integer errorCode, @Nullable final String errorMsg) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackNativeFailed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(adProviderType + ": 请求失败了：" + errorCode + ' ' + errorMsg, null, 1, null);
                listener.onAdFailed(adProviderType, errorMsg);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdFailed(adProviderType, alias, errorMsg);
                }
            }
        });
    }

    public final void callbackNativeLoaded(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final NativeListener listener, @NotNull final List<? extends Object> adList) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        j.f(adList, "adList");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackNativeLoaded.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(adProviderType + ": 请求成功了, 请求到" + adList.size() + "个广告", null, 1, null);
                listener.onAdLoaded(adProviderType, adList);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdLoaded(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackNativeStartRequest(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final NativeListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackNativeStartRequest.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 开始请求"), null, 1, null);
                listener.onAdStartRequest(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdStartRequest(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackRewardClicked(@NotNull final String adProviderType, @NotNull final RewardListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackRewardClicked.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 点击了"), null, 1, null);
                listener.onAdClicked(adProviderType);
            }
        });
    }

    public final void callbackRewardClosed(@NotNull final String adProviderType, @NotNull final RewardListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackRewardClosed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 关闭了"), null, 1, null);
                listener.onAdClose(adProviderType);
            }
        });
    }

    public final void callbackRewardExpose(@NotNull final String adProviderType, @NotNull final RewardListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackRewardExpose.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 曝光了"), null, 1, null);
                listener.onAdExpose(adProviderType);
            }
        });
    }

    public final void callbackRewardFailed(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final RewardListener listener, @Nullable final Integer errorCode, @Nullable final String errorMsg) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackRewardFailed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(adProviderType + ": 请求失败了：" + errorCode + ' ' + errorMsg, null, 1, null);
                listener.onAdFailed(adProviderType, errorMsg);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdFailed(adProviderType, alias, errorMsg);
                }
            }
        });
    }

    public final void callbackRewardLoaded(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final RewardListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackRewardLoaded.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 请求成功了"), null, 1, null);
                listener.onAdLoaded(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdLoaded(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackRewardShow(@NotNull final String adProviderType, @NotNull final RewardListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackRewardShow.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 展示了"), null, 1, null);
                listener.onAdShow(adProviderType);
            }
        });
    }

    public final void callbackRewardStartRequest(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final RewardListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackRewardStartRequest.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 开始请求"), null, 1, null);
                listener.onAdStartRequest(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdStartRequest(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackRewardVerify(@NotNull final String adProviderType, @NotNull final RewardListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackRewardVerify.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 激励验证"), null, 1, null);
                listener.onAdRewardVerify(adProviderType);
            }
        });
    }

    public final void callbackRewardVideoCached(@NotNull final String adProviderType, @NotNull final RewardListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackRewardVideoCached.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 视频已缓存"), null, 1, null);
                listener.onAdVideoCached(adProviderType);
            }
        });
    }

    public final void callbackRewardVideoComplete(@NotNull final String adProviderType, @NotNull final RewardListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackRewardVideoComplete.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 播放完成"), null, 1, null);
                listener.onAdVideoComplete(adProviderType);
            }
        });
    }

    public final void callbackSplashClicked(@NotNull final String adProviderType, @NotNull final SplashListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackSplashClicked.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 点击了"), null, 1, null);
                listener.onAdClicked(adProviderType);
            }
        });
    }

    public final void callbackSplashDismiss(@NotNull final String adProviderType, @NotNull final SplashListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackSplashDismiss.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 消失了"), null, 1, null);
                listener.onAdDismissed(adProviderType);
            }
        });
    }

    public final void callbackSplashExposure(@NotNull final String adProviderType, @NotNull final SplashListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackSplashExposure.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 曝光了"), null, 1, null);
                listener.onAdExposure(adProviderType);
            }
        });
    }

    public final void callbackSplashFailed(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final SplashListener listener, @Nullable final Integer errorCode, @Nullable final String errorMsg) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackSplashFailed.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.loge$default(adProviderType + ": 请求失败了：" + errorCode + ' ' + errorMsg, null, 1, null);
                listener.onAdFailed(adProviderType, errorMsg);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdFailed(adProviderType, alias, errorMsg);
                }
            }
        });
    }

    public final void callbackSplashLoaded(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final SplashListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackSplashLoaded.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 请求成功了"), null, 1, null);
                listener.onAdLoaded(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdLoaded(adProviderType, alias);
                }
            }
        });
    }

    public final void callbackSplashStartRequest(@NotNull final String adProviderType, @NotNull final String alias, @NotNull final SplashListener listener) {
        j.f(adProviderType, "adProviderType");
        j.f(alias, "alias");
        j.f(listener, "listener");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ifmvo.togetherad.core.provider.BaseAdProvider.callbackSplashStartRequest.1
            @Override // java.lang.Runnable
            public final void run() {
                LogExtKt.logi$default(a.p(new StringBuilder(), adProviderType, ": 开始请求"), null, 1, null);
                listener.onAdStartRequest(adProviderType);
                AllAdListener allAdListener = TogetherAd.INSTANCE.getAllAdListener();
                if (allAdListener != null) {
                    allAdListener.onAdStartRequest(adProviderType, alias);
                }
            }
        });
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }
}
