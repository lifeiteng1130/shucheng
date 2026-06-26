package com.ifmvo.togetherad.core.listener;

import com.ifmvo.togetherad.core.listener.BaseListener;
import f.c0.c.j;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeExpressListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ%\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\fJ%\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\fJ%\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/ifmvo/togetherad/core/listener/NativeExpressListener;", "Lcom/ifmvo/togetherad/core/listener/BaseListener;", "", "providerType", "", "", "adList", "Lf/v;", "onAdLoaded", "(Ljava/lang/String;Ljava/util/List;)V", "adObject", "onAdClicked", "(Ljava/lang/String;Ljava/lang/Object;)V", "onAdShow", "onAdRenderSuccess", "onAdRenderFail", "onAdClosed", "core_release"}, k = 1, mv = {1, 4, 0})
public interface NativeExpressListener extends BaseListener {

    /* JADX INFO: compiled from: NativeExpressListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static void onAdClicked(NativeExpressListener nativeExpressListener, @NotNull String str, @Nullable Object obj) {
            j.f(str, "providerType");
        }

        public static void onAdClosed(NativeExpressListener nativeExpressListener, @NotNull String str, @Nullable Object obj) {
            j.f(str, "providerType");
        }

        public static void onAdFailed(NativeExpressListener nativeExpressListener, @NotNull String str, @Nullable String str2) {
            j.f(str, "providerType");
            BaseListener.DefaultImpls.onAdFailed(nativeExpressListener, str, str2);
        }

        public static void onAdFailedAll(NativeExpressListener nativeExpressListener, @Nullable String str) {
            BaseListener.DefaultImpls.onAdFailedAll(nativeExpressListener, str);
        }

        public static void onAdLoaded(NativeExpressListener nativeExpressListener, @NotNull String str, @NotNull List<? extends Object> list) {
            j.f(str, "providerType");
            j.f(list, "adList");
        }

        public static void onAdRenderFail(NativeExpressListener nativeExpressListener, @NotNull String str, @Nullable Object obj) {
            j.f(str, "providerType");
        }

        public static void onAdRenderSuccess(NativeExpressListener nativeExpressListener, @NotNull String str, @Nullable Object obj) {
            j.f(str, "providerType");
        }

        public static void onAdShow(NativeExpressListener nativeExpressListener, @NotNull String str, @Nullable Object obj) {
            j.f(str, "providerType");
        }

        public static void onAdStartRequest(NativeExpressListener nativeExpressListener, @NotNull String str) {
            j.f(str, "providerType");
            BaseListener.DefaultImpls.onAdStartRequest(nativeExpressListener, str);
        }
    }

    void onAdClicked(@NotNull String providerType, @Nullable Object adObject);

    void onAdClosed(@NotNull String providerType, @Nullable Object adObject);

    void onAdLoaded(@NotNull String providerType, @NotNull List<? extends Object> adList);

    void onAdRenderFail(@NotNull String providerType, @Nullable Object adObject);

    void onAdRenderSuccess(@NotNull String providerType, @Nullable Object adObject);

    void onAdShow(@NotNull String providerType, @Nullable Object adObject);
}
