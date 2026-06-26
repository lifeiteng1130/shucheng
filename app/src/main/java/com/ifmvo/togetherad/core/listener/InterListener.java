package com.ifmvo.togetherad.core.listener;

import com.ifmvo.togetherad.core.listener.BaseListener;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InterListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/ifmvo/togetherad/core/listener/InterListener;", "Lcom/ifmvo/togetherad/core/listener/BaseListener;", "", "providerType", "Lf/v;", "onAdLoaded", "(Ljava/lang/String;)V", "onAdClicked", "onAdExpose", "onAdClose", "core_release"}, k = 1, mv = {1, 4, 0})
public interface InterListener extends BaseListener {

    /* JADX INFO: compiled from: InterListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static void onAdClicked(InterListener interListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdClose(InterListener interListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdExpose(InterListener interListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdFailed(InterListener interListener, @NotNull String str, @Nullable String str2) {
            j.f(str, "providerType");
            BaseListener.DefaultImpls.onAdFailed(interListener, str, str2);
        }

        public static void onAdFailedAll(InterListener interListener, @Nullable String str) {
            BaseListener.DefaultImpls.onAdFailedAll(interListener, str);
        }

        public static void onAdLoaded(InterListener interListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdStartRequest(InterListener interListener, @NotNull String str) {
            j.f(str, "providerType");
            BaseListener.DefaultImpls.onAdStartRequest(interListener, str);
        }
    }

    void onAdClicked(@NotNull String providerType);

    void onAdClose(@NotNull String providerType);

    void onAdExpose(@NotNull String providerType);

    void onAdLoaded(@NotNull String providerType);
}
