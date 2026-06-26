package com.ifmvo.togetherad.csj.provider;

import androidx.media2.session.SessionCommand;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ifmvo.togetherad.core.custom.splashSkip.BaseSplashSkipView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: CsjProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000b"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProvider;", "Lcom/ifmvo/togetherad/csj/provider/CsjProviderSplash;", "<init>", "()V", "Banner", "FullVideo", "Inter", "Native", "NativeExpress", "Reward", "Splash", "csj_release"}, k = 1, mv = {1, 4, 0})
public class CsjProvider extends CsjProviderSplash {

    /* JADX INFO: compiled from: CsjProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006!"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProvider$Banner;", "", "", "widthDp", "heightDp", "Lf/v;", "setExpressViewAcceptedSize", "(FF)V", "", "supportDeepLink", "Z", "getSupportDeepLink", "()Z", "setSupportDeepLink", "(Z)V", "", "slideIntervalTime", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getSlideIntervalTime", "()I", "setSlideIntervalTime", "(I)V", "expressViewAcceptedSizeWidth", "F", "getExpressViewAcceptedSizeWidth$csj_release", "()F", "setExpressViewAcceptedSizeWidth$csj_release", "(F)V", "expressViewAcceptedSizeHeight", "getExpressViewAcceptedSizeHeight$csj_release", "setExpressViewAcceptedSizeHeight$csj_release", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class Banner {
        public static final Banner INSTANCE = new Banner();
        private static boolean supportDeepLink = true;
        private static float expressViewAcceptedSizeWidth = -1.0f;
        private static float expressViewAcceptedSizeHeight = -1.0f;
        private static int slideIntervalTime = SessionCommand.COMMAND_CODE_VOLUME_SET_VOLUME;

        private Banner() {
        }

        public final float getExpressViewAcceptedSizeHeight$csj_release() {
            return expressViewAcceptedSizeHeight;
        }

        public final float getExpressViewAcceptedSizeWidth$csj_release() {
            return expressViewAcceptedSizeWidth;
        }

        public final int getSlideIntervalTime() {
            return slideIntervalTime;
        }

        public final boolean getSupportDeepLink() {
            return supportDeepLink;
        }

        public final void setExpressViewAcceptedSize(float widthDp, float heightDp) {
            expressViewAcceptedSizeWidth = widthDp;
            expressViewAcceptedSizeHeight = heightDp;
        }

        public final void setExpressViewAcceptedSizeHeight$csj_release(float f2) {
            expressViewAcceptedSizeHeight = f2;
        }

        public final void setExpressViewAcceptedSizeWidth$csj_release(float f2) {
            expressViewAcceptedSizeWidth = f2;
        }

        public final void setSlideIntervalTime(int i2) {
            slideIntervalTime = i2;
        }

        public final void setSupportDeepLink(boolean z) {
            supportDeepLink = z;
        }
    }

    /* JADX INFO: compiled from: CsjProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProvider$FullVideo;", "", "Lcom/bytedance/sdk/openadsdk/TTAdConstant$RitScenes;", "ritScenes", "Lcom/bytedance/sdk/openadsdk/TTAdConstant$RitScenes;", "getRitScenes", "()Lcom/bytedance/sdk/openadsdk/TTAdConstant$RitScenes;", "setRitScenes", "(Lcom/bytedance/sdk/openadsdk/TTAdConstant$RitScenes;)V", "", "isExpress", "Z", "()Z", "setExpress", "(Z)V", "", "orientation", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getOrientation", "()I", "setOrientation", "(I)V", "supportDeepLink", "getSupportDeepLink", "setSupportDeepLink", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class FullVideo {

        @Nullable
        private static TTAdConstant.RitScenes ritScenes;
        public static final FullVideo INSTANCE = new FullVideo();
        private static boolean isExpress = true;
        private static boolean supportDeepLink = true;
        private static int orientation = 1;

        private FullVideo() {
        }

        public final int getOrientation() {
            return orientation;
        }

        @Nullable
        public final TTAdConstant.RitScenes getRitScenes() {
            return ritScenes;
        }

        public final boolean getSupportDeepLink() {
            return supportDeepLink;
        }

        public final boolean isExpress() {
            return isExpress;
        }

        public final void setExpress(boolean z) {
            isExpress = z;
        }

        public final void setOrientation(int i2) {
            orientation = i2;
        }

        public final void setRitScenes(@Nullable TTAdConstant.RitScenes ritScenes2) {
            ritScenes = ritScenes2;
        }

        public final void setSupportDeepLink(boolean z) {
            supportDeepLink = z;
        }
    }

    /* JADX INFO: compiled from: CsjProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProvider$Inter;", "", "", "width", "height", "Lf/v;", "setExpressViewAcceptedSize", "(FF)V", "expressViewAcceptedSizeWidth", "F", "getExpressViewAcceptedSizeWidth$csj_release", "()F", "setExpressViewAcceptedSizeWidth$csj_release", "(F)V", "", "supportDeepLink", "Z", "getSupportDeepLink", "()Z", "setSupportDeepLink", "(Z)V", "expressViewAcceptedSizeHeight", "getExpressViewAcceptedSizeHeight$csj_release", "setExpressViewAcceptedSizeHeight$csj_release", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class Inter {
        public static final Inter INSTANCE = new Inter();
        private static boolean supportDeepLink = true;
        private static float expressViewAcceptedSizeWidth = -1.0f;
        private static float expressViewAcceptedSizeHeight = -1.0f;

        private Inter() {
        }

        public final float getExpressViewAcceptedSizeHeight$csj_release() {
            return expressViewAcceptedSizeHeight;
        }

        public final float getExpressViewAcceptedSizeWidth$csj_release() {
            return expressViewAcceptedSizeWidth;
        }

        public final boolean getSupportDeepLink() {
            return supportDeepLink;
        }

        public final void setExpressViewAcceptedSize(float width, float height) {
            expressViewAcceptedSizeWidth = width;
            expressViewAcceptedSizeHeight = height;
        }

        public final void setExpressViewAcceptedSizeHeight$csj_release(float f2) {
            expressViewAcceptedSizeHeight = f2;
        }

        public final void setExpressViewAcceptedSizeWidth$csj_release(float f2) {
            expressViewAcceptedSizeWidth = f2;
        }

        public final void setSupportDeepLink(boolean z) {
            supportDeepLink = z;
        }
    }

    /* JADX INFO: compiled from: CsjProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\"\u0010\u0018\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProvider$Native;", "", "", "width", "height", "Lf/v;", "setImageAcceptedSize", "(II)V", "nativeAdType", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getNativeAdType", "()I", "setNativeAdType", "(I)V", "", "supportDeepLink", "Z", "getSupportDeepLink", "()Z", "setSupportDeepLink", "(Z)V", "imageAcceptedSizeHeight", "getImageAcceptedSizeHeight$csj_release", "setImageAcceptedSizeHeight$csj_release", "imageAcceptedSizeWidth", "getImageAcceptedSizeWidth$csj_release", "setImageAcceptedSizeWidth$csj_release", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class Native {
        public static final Native INSTANCE = new Native();
        private static int nativeAdType = -1;
        private static boolean supportDeepLink = true;
        private static int imageAcceptedSizeWidth = 1080;
        private static int imageAcceptedSizeHeight = 607;

        private Native() {
        }

        public final int getImageAcceptedSizeHeight$csj_release() {
            return imageAcceptedSizeHeight;
        }

        public final int getImageAcceptedSizeWidth$csj_release() {
            return imageAcceptedSizeWidth;
        }

        public final int getNativeAdType() {
            return nativeAdType;
        }

        public final boolean getSupportDeepLink() {
            return supportDeepLink;
        }

        public final void setImageAcceptedSize(int width, int height) {
            imageAcceptedSizeWidth = width;
            imageAcceptedSizeHeight = height;
        }

        public final void setImageAcceptedSizeHeight$csj_release(int i2) {
            imageAcceptedSizeHeight = i2;
        }

        public final void setImageAcceptedSizeWidth$csj_release(int i2) {
            imageAcceptedSizeWidth = i2;
        }

        public final void setNativeAdType(int i2) {
            nativeAdType = i2;
        }

        public final void setSupportDeepLink(boolean z) {
            supportDeepLink = z;
        }
    }

    /* JADX INFO: compiled from: CsjProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProvider$NativeExpress;", "", "", "widthDp", "heightDp", "Lf/v;", "setExpressViewAcceptedSize", "(FF)V", "", "supportDeepLink", "Z", "getSupportDeepLink", "()Z", "setSupportDeepLink", "(Z)V", "expressViewAcceptedSizeHeight", "F", "getExpressViewAcceptedSizeHeight$csj_release", "()F", "setExpressViewAcceptedSizeHeight$csj_release", "(F)V", "expressViewAcceptedSizeWidth", "getExpressViewAcceptedSizeWidth$csj_release", "setExpressViewAcceptedSizeWidth$csj_release", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class NativeExpress {
        private static float expressViewAcceptedSizeHeight;
        private static float expressViewAcceptedSizeWidth;
        public static final NativeExpress INSTANCE = new NativeExpress();
        private static boolean supportDeepLink = true;

        private NativeExpress() {
        }

        public final float getExpressViewAcceptedSizeHeight$csj_release() {
            return expressViewAcceptedSizeHeight;
        }

        public final float getExpressViewAcceptedSizeWidth$csj_release() {
            return expressViewAcceptedSizeWidth;
        }

        public final boolean getSupportDeepLink() {
            return supportDeepLink;
        }

        public final void setExpressViewAcceptedSize(float widthDp, float heightDp) {
            expressViewAcceptedSizeWidth = widthDp;
            expressViewAcceptedSizeHeight = heightDp;
        }

        public final void setExpressViewAcceptedSizeHeight$csj_release(float f2) {
            expressViewAcceptedSizeHeight = f2;
        }

        public final void setExpressViewAcceptedSizeWidth$csj_release(float f2) {
            expressViewAcceptedSizeWidth = f2;
        }

        public final void setSupportDeepLink(boolean z) {
            supportDeepLink = z;
        }
    }

    /* JADX INFO: compiled from: CsjProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b/\u00100R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR*\u0010!\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00148\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\"\u0010'\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\f\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010\u0010R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0016\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001a¨\u00061"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProvider$Reward;", "", "", "userID", "Ljava/lang/String;", "getUserID", "()Ljava/lang/String;", "setUserID", "(Ljava/lang/String;)V", "", "<set-?>", "errorCode", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getErrorCode", "()I", "setErrorCode$csj_release", "(I)V", "errorMsg", "getErrorMsg", "setErrorMsg$csj_release", "", "supportDeepLink", "Z", "getSupportDeepLink", "()Z", "setSupportDeepLink", "(Z)V", "showDownLoadBar", "getShowDownLoadBar", "setShowDownLoadBar", "rewardName", "getRewardName", "setRewardName", "rewardVerify", "getRewardVerify", "setRewardVerify$csj_release", "orientation", "getOrientation", "setOrientation", "rewardAmount", "getRewardAmount", "setRewardAmount", "mediaExtra", "getMediaExtra", "setMediaExtra", "isExpress", "setExpress", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class Reward {
        private static int errorCode;

        @Nullable
        private static String errorMsg;

        @Nullable
        private static String mediaExtra;

        @Nullable
        private static String rewardName;
        private static boolean rewardVerify;

        @Nullable
        private static String userID;
        public static final Reward INSTANCE = new Reward();
        private static boolean isExpress = true;
        private static boolean supportDeepLink = true;
        private static int rewardAmount = -1;
        private static int orientation = 1;
        private static boolean showDownLoadBar = true;

        private Reward() {
        }

        public final int getErrorCode() {
            return errorCode;
        }

        @Nullable
        public final String getErrorMsg() {
            return errorMsg;
        }

        @Nullable
        public final String getMediaExtra() {
            return mediaExtra;
        }

        public final int getOrientation() {
            return orientation;
        }

        public final int getRewardAmount() {
            return rewardAmount;
        }

        @Nullable
        public final String getRewardName() {
            return rewardName;
        }

        public final boolean getRewardVerify() {
            return rewardVerify;
        }

        public final boolean getShowDownLoadBar() {
            return showDownLoadBar;
        }

        public final boolean getSupportDeepLink() {
            return supportDeepLink;
        }

        @Nullable
        public final String getUserID() {
            return userID;
        }

        public final boolean isExpress() {
            return isExpress;
        }

        public final void setErrorCode$csj_release(int i2) {
            errorCode = i2;
        }

        public final void setErrorMsg$csj_release(@Nullable String str) {
            errorMsg = str;
        }

        public final void setExpress(boolean z) {
            isExpress = z;
        }

        public final void setMediaExtra(@Nullable String str) {
            mediaExtra = str;
        }

        public final void setOrientation(int i2) {
            orientation = i2;
        }

        public final void setRewardAmount(int i2) {
            rewardAmount = i2;
        }

        public final void setRewardName(@Nullable String str) {
            rewardName = str;
        }

        public final void setRewardVerify$csj_release(boolean z) {
            rewardVerify = z;
        }

        public final void setShowDownLoadBar(boolean z) {
            showDownLoadBar = z;
        }

        public final void setSupportDeepLink(boolean z) {
            supportDeepLink = z;
        }

        public final void setUserID(@Nullable String str) {
            userID = str;
        }
    }

    /* JADX INFO: compiled from: CsjProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\"\u0010\u0014\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/ifmvo/togetherad/csj/provider/CsjProvider$Splash;", "", "", "width", "height", "Lf/v;", "setImageAcceptedSize", "(II)V", "imageAcceptedSizeHeight", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getImageAcceptedSizeHeight$csj_release", "()I", "setImageAcceptedSizeHeight$csj_release", "(I)V", "splashButtonType", "getSplashButtonType", "setSplashButtonType", "maxFetchDelay", "getMaxFetchDelay", "setMaxFetchDelay", "imageAcceptedSizeWidth", "getImageAcceptedSizeWidth$csj_release", "setImageAcceptedSizeWidth$csj_release", "Lcom/ifmvo/togetherad/core/custom/splashSkip/BaseSplashSkipView;", "customSkipView", "Lcom/ifmvo/togetherad/core/custom/splashSkip/BaseSplashSkipView;", "getCustomSkipView", "()Lcom/ifmvo/togetherad/core/custom/splashSkip/BaseSplashSkipView;", "setCustomSkipView", "(Lcom/ifmvo/togetherad/core/custom/splashSkip/BaseSplashSkipView;)V", "", "isExpress", "Z", "()Z", "setExpress", "(Z)V", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
    public static final class Splash {

        @Nullable
        private static BaseSplashSkipView customSkipView;
        private static boolean isExpress;
        public static final Splash INSTANCE = new Splash();
        private static int maxFetchDelay = 4000;
        private static int imageAcceptedSizeWidth = 1080;
        private static int imageAcceptedSizeHeight = 1920;
        private static int splashButtonType = 1;

        private Splash() {
        }

        @Nullable
        public final BaseSplashSkipView getCustomSkipView() {
            return customSkipView;
        }

        public final int getImageAcceptedSizeHeight$csj_release() {
            return imageAcceptedSizeHeight;
        }

        public final int getImageAcceptedSizeWidth$csj_release() {
            return imageAcceptedSizeWidth;
        }

        public final int getMaxFetchDelay() {
            return maxFetchDelay;
        }

        public final int getSplashButtonType() {
            return splashButtonType;
        }

        public final boolean isExpress() {
            return isExpress;
        }

        public final void setCustomSkipView(@Nullable BaseSplashSkipView baseSplashSkipView) {
            customSkipView = baseSplashSkipView;
        }

        public final void setExpress(boolean z) {
            isExpress = z;
        }

        public final void setImageAcceptedSize(int width, int height) {
            imageAcceptedSizeWidth = width;
            imageAcceptedSizeHeight = height;
        }

        public final void setImageAcceptedSizeHeight$csj_release(int i2) {
            imageAcceptedSizeHeight = i2;
        }

        public final void setImageAcceptedSizeWidth$csj_release(int i2) {
            imageAcceptedSizeWidth = i2;
        }

        public final void setMaxFetchDelay(int i2) {
            maxFetchDelay = i2;
        }

        public final void setSplashButtonType(int i2) {
            splashButtonType = i2;
        }
    }
}
