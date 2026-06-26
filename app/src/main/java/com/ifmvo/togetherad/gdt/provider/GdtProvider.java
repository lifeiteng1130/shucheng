package com.ifmvo.togetherad.gdt.provider;

import androidx.media2.session.SessionCommand;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.express2.VideoOption2;
import f.c0.c.j;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: GdtProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProvider;", "Lcom/ifmvo/togetherad/gdt/provider/GdtProviderSplash;", "<init>", "()V", "Banner", "FullVideo", "Native", "NativeExpress", "Reward", "Splash", "gdt_release"}, k = 1, mv = {1, 4, 0})
public class GdtProvider extends GdtProviderSplash {

    /* JADX INFO: compiled from: GdtProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProvider$Banner;", "", "", "slideIntervalTime", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getSlideIntervalTime", "()I", "setSlideIntervalTime", "(I)V", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
    public static final class Banner {
        public static final Banner INSTANCE = new Banner();
        private static int slideIntervalTime = SessionCommand.COMMAND_CODE_VOLUME_SET_VOLUME;

        private Banner() {
        }

        public final int getSlideIntervalTime() {
            return slideIntervalTime;
        }

        public final void setSlideIntervalTime(int i2) {
            slideIntervalTime = i2;
        }
    }

    /* JADX INFO: compiled from: GdtProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProvider$FullVideo;", "", "", "autoPlayPolicy", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getAutoPlayPolicy", "()I", "setAutoPlayPolicy", "(I)V", "maxVideoDuration", "getMaxVideoDuration", "setMaxVideoDuration", "videoPlayPolicy", "getVideoPlayPolicy", "setVideoPlayPolicy", "", "autoPlayMuted", "Z", "getAutoPlayMuted", "()Z", "setAutoPlayMuted", "(Z)V", "minVideoDuration", "getMinVideoDuration", "setMinVideoDuration", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
    public static final class FullVideo {
        private static int maxVideoDuration;
        private static int minVideoDuration;
        public static final FullVideo INSTANCE = new FullVideo();
        private static boolean autoPlayMuted = true;
        private static int autoPlayPolicy = 1;
        private static int videoPlayPolicy = 1;

        private FullVideo() {
        }

        public final boolean getAutoPlayMuted() {
            return autoPlayMuted;
        }

        public final int getAutoPlayPolicy() {
            return autoPlayPolicy;
        }

        public final int getMaxVideoDuration() {
            return maxVideoDuration;
        }

        public final int getMinVideoDuration() {
            return minVideoDuration;
        }

        public final int getVideoPlayPolicy() {
            return videoPlayPolicy;
        }

        public final void setAutoPlayMuted(boolean z) {
            autoPlayMuted = z;
        }

        public final void setAutoPlayPolicy(int i2) {
            autoPlayPolicy = i2;
        }

        public final void setMaxVideoDuration(int i2) {
            maxVideoDuration = i2;
        }

        public final void setMinVideoDuration(int i2) {
            minVideoDuration = i2;
        }

        public final void setVideoPlayPolicy(int i2) {
            videoPlayPolicy = i2;
        }
    }

    /* JADX INFO: compiled from: GdtProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProvider$Native;", "", "", "minVideoDuration", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getMinVideoDuration", "()I", "setMinVideoDuration", "(I)V", "Lcom/qq/e/ads/cfg/DownAPPConfirmPolicy;", "downAPPConfirmPolicy", "Lcom/qq/e/ads/cfg/DownAPPConfirmPolicy;", "getDownAPPConfirmPolicy", "()Lcom/qq/e/ads/cfg/DownAPPConfirmPolicy;", "setDownAPPConfirmPolicy", "(Lcom/qq/e/ads/cfg/DownAPPConfirmPolicy;)V", "videoPlayPolicy", "getVideoPlayPolicy", "setVideoPlayPolicy", "maxVideoDuration", "getMaxVideoDuration", "setMaxVideoDuration", "", "", "categories", "Ljava/util/List;", "getCategories", "()Ljava/util/List;", "setCategories", "(Ljava/util/List;)V", "Lcom/qq/e/ads/cfg/BrowserType;", "browserType", "Lcom/qq/e/ads/cfg/BrowserType;", "getBrowserType", "()Lcom/qq/e/ads/cfg/BrowserType;", "setBrowserType", "(Lcom/qq/e/ads/cfg/BrowserType;)V", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
    public static final class Native {

        @Nullable
        private static List<String> categories;
        public static final Native INSTANCE = new Native();
        private static int maxVideoDuration = 60;
        private static int minVideoDuration = 5;

        @NotNull
        private static BrowserType browserType = BrowserType.Default;

        @NotNull
        private static DownAPPConfirmPolicy downAPPConfirmPolicy = DownAPPConfirmPolicy.Default;
        private static int videoPlayPolicy = 1;

        private Native() {
        }

        @NotNull
        public final BrowserType getBrowserType() {
            return browserType;
        }

        @Nullable
        public final List<String> getCategories() {
            return categories;
        }

        @NotNull
        public final DownAPPConfirmPolicy getDownAPPConfirmPolicy() {
            return downAPPConfirmPolicy;
        }

        public final int getMaxVideoDuration() {
            return maxVideoDuration;
        }

        public final int getMinVideoDuration() {
            return minVideoDuration;
        }

        public final int getVideoPlayPolicy() {
            return videoPlayPolicy;
        }

        public final void setBrowserType(@NotNull BrowserType browserType2) {
            j.f(browserType2, "<set-?>");
            browserType = browserType2;
        }

        public final void setCategories(@Nullable List<String> list) {
            categories = list;
        }

        public final void setDownAPPConfirmPolicy(@NotNull DownAPPConfirmPolicy downAPPConfirmPolicy2) {
            j.f(downAPPConfirmPolicy2, "<set-?>");
            downAPPConfirmPolicy = downAPPConfirmPolicy2;
        }

        public final void setMaxVideoDuration(int i2) {
            maxVideoDuration = i2;
        }

        public final void setMinVideoDuration(int i2) {
            minVideoDuration = i2;
        }

        public final void setVideoPlayPolicy(int i2) {
            videoPlayPolicy = i2;
        }
    }

    /* JADX INFO: compiled from: GdtProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b<\u0010=J!\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\"\u0010,\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010\t\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\t\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\rR\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\rR\"\u00106\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProvider$NativeExpress;", "", "", "widthDp", "heightDp", "Lf/v;", "setAdSize", "(II)V", "minVideoDuration", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getMinVideoDuration", "()I", "setMinVideoDuration", "(I)V", "maxVideoDuration", "getMaxVideoDuration", "setMaxVideoDuration", "", "detailPageMuted", "Z", "getDetailPageMuted", "()Z", "setDetailPageMuted", "(Z)V", "Lcom/qq/e/ads/nativ/express2/VideoOption2$AutoPlayPolicy;", "autoPlayPolicyVideoOption2", "Lcom/qq/e/ads/nativ/express2/VideoOption2$AutoPlayPolicy;", "getAutoPlayPolicyVideoOption2", "()Lcom/qq/e/ads/nativ/express2/VideoOption2$AutoPlayPolicy;", "setAutoPlayPolicyVideoOption2", "(Lcom/qq/e/ads/nativ/express2/VideoOption2$AutoPlayPolicy;)V", "adWidth", "getAdWidth$gdt_release", "setAdWidth$gdt_release", "Lcom/qq/e/ads/cfg/DownAPPConfirmPolicy;", "downAPPConfirmPolicy", "Lcom/qq/e/ads/cfg/DownAPPConfirmPolicy;", "getDownAPPConfirmPolicy", "()Lcom/qq/e/ads/cfg/DownAPPConfirmPolicy;", "setDownAPPConfirmPolicy", "(Lcom/qq/e/ads/cfg/DownAPPConfirmPolicy;)V", "autoPlayMuted", "getAutoPlayMuted", "setAutoPlayMuted", "adHeight", "getAdHeight$gdt_release", "setAdHeight$gdt_release", "autoPlayPolicy", "getAutoPlayPolicy", "setAutoPlayPolicy", "videoPlayPolicy", "getVideoPlayPolicy", "setVideoPlayPolicy", "Lcom/qq/e/ads/cfg/BrowserType;", "browserType", "Lcom/qq/e/ads/cfg/BrowserType;", "getBrowserType", "()Lcom/qq/e/ads/cfg/BrowserType;", "setBrowserType", "(Lcom/qq/e/ads/cfg/BrowserType;)V", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
    public static final class NativeExpress {
        private static boolean detailPageMuted;
        private static int maxVideoDuration;
        private static int minVideoDuration;
        public static final NativeExpress INSTANCE = new NativeExpress();
        private static boolean autoPlayMuted = true;

        @NotNull
        private static VideoOption2.AutoPlayPolicy autoPlayPolicyVideoOption2 = VideoOption2.AutoPlayPolicy.ALWAYS;
        private static int autoPlayPolicy = 1;
        private static int videoPlayPolicy = 1;

        @NotNull
        private static DownAPPConfirmPolicy downAPPConfirmPolicy = DownAPPConfirmPolicy.Default;

        @NotNull
        private static BrowserType browserType = BrowserType.Default;
        private static int adWidth = -1;
        private static int adHeight = -2;

        private NativeExpress() {
        }

        public static /* synthetic */ void setAdSize$default(NativeExpress nativeExpress, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = -1;
            }
            if ((i4 & 2) != 0) {
                i3 = -2;
            }
            nativeExpress.setAdSize(i2, i3);
        }

        public final int getAdHeight$gdt_release() {
            return adHeight;
        }

        public final int getAdWidth$gdt_release() {
            return adWidth;
        }

        public final boolean getAutoPlayMuted() {
            return autoPlayMuted;
        }

        public final int getAutoPlayPolicy() {
            return autoPlayPolicy;
        }

        @NotNull
        public final VideoOption2.AutoPlayPolicy getAutoPlayPolicyVideoOption2() {
            return autoPlayPolicyVideoOption2;
        }

        @NotNull
        public final BrowserType getBrowserType() {
            return browserType;
        }

        public final boolean getDetailPageMuted() {
            return detailPageMuted;
        }

        @NotNull
        public final DownAPPConfirmPolicy getDownAPPConfirmPolicy() {
            return downAPPConfirmPolicy;
        }

        public final int getMaxVideoDuration() {
            return maxVideoDuration;
        }

        public final int getMinVideoDuration() {
            return minVideoDuration;
        }

        public final int getVideoPlayPolicy() {
            return videoPlayPolicy;
        }

        public final void setAdHeight$gdt_release(int i2) {
            adHeight = i2;
        }

        public final void setAdSize(int widthDp, int heightDp) {
            adWidth = widthDp;
            adHeight = heightDp;
        }

        public final void setAdWidth$gdt_release(int i2) {
            adWidth = i2;
        }

        public final void setAutoPlayMuted(boolean z) {
            autoPlayMuted = z;
        }

        public final void setAutoPlayPolicy(int i2) {
            autoPlayPolicy = i2;
        }

        public final void setAutoPlayPolicyVideoOption2(@NotNull VideoOption2.AutoPlayPolicy autoPlayPolicy2) {
            j.f(autoPlayPolicy2, "<set-?>");
            autoPlayPolicyVideoOption2 = autoPlayPolicy2;
        }

        public final void setBrowserType(@NotNull BrowserType browserType2) {
            j.f(browserType2, "<set-?>");
            browserType = browserType2;
        }

        public final void setDetailPageMuted(boolean z) {
            detailPageMuted = z;
        }

        public final void setDownAPPConfirmPolicy(@NotNull DownAPPConfirmPolicy downAPPConfirmPolicy2) {
            j.f(downAPPConfirmPolicy2, "<set-?>");
            downAPPConfirmPolicy = downAPPConfirmPolicy2;
        }

        public final void setMaxVideoDuration(int i2) {
            maxVideoDuration = i2;
        }

        public final void setMinVideoDuration(int i2) {
            minVideoDuration = i2;
        }

        public final void setVideoPlayPolicy(int i2) {
            videoPlayPolicy = i2;
        }
    }

    /* JADX INFO: compiled from: GdtProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProvider$Reward;", "", "verificationOption", "Ljava/lang/Object;", "getVerificationOption", "()Ljava/lang/Object;", "setVerificationOption", "(Ljava/lang/Object;)V", "", "volumeOn", "Z", "getVolumeOn", "()Z", "setVolumeOn", "(Z)V", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
    public static final class Reward {

        @Nullable
        private static Object verificationOption;
        public static final Reward INSTANCE = new Reward();
        private static boolean volumeOn = true;

        private Reward() {
        }

        @Nullable
        public final Object getVerificationOption() {
            return verificationOption;
        }

        public final boolean getVolumeOn() {
            return volumeOn;
        }

        public final void setVerificationOption(@Nullable Object obj) {
            verificationOption = obj;
        }

        public final void setVolumeOn(boolean z) {
            volumeOn = z;
        }
    }

    /* JADX INFO: compiled from: GdtProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ifmvo/togetherad/gdt/provider/GdtProvider$Splash;", "", "", "maxFetchDelay", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getMaxFetchDelay", "()I", "setMaxFetchDelay", "(I)V", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
    public static final class Splash {
        public static final Splash INSTANCE = new Splash();
        private static int maxFetchDelay = 4000;

        private Splash() {
        }

        public final int getMaxFetchDelay() {
            return maxFetchDelay;
        }

        public final void setMaxFetchDelay(int i2) {
            maxFetchDelay = i2;
        }
    }
}
