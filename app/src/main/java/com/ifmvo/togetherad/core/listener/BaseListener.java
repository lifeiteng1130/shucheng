package com.ifmvo.togetherad.core.listener;

import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J#\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ifmvo/togetherad/core/listener/BaseListener;", "", "", "providerType", "Lf/v;", "onAdStartRequest", "(Ljava/lang/String;)V", "failedMsg", "onAdFailedAll", "onAdFailed", "(Ljava/lang/String;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 0})
public interface BaseListener {

    /* JADX INFO: compiled from: BaseListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static void onAdFailed(BaseListener baseListener, @NotNull String str, @Nullable String str2) {
            j.f(str, "providerType");
        }

        public static void onAdFailedAll(BaseListener baseListener, @Nullable String str) {
        }

        public static void onAdStartRequest(BaseListener baseListener, @NotNull String str) {
            j.f(str, "providerType");
        }
    }

    void onAdFailed(@NotNull String providerType, @Nullable String failedMsg);

    void onAdFailedAll(@Nullable String failedMsg);

    void onAdStartRequest(@NotNull String providerType);
}
