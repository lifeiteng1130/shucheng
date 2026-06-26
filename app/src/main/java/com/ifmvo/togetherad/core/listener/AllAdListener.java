package com.ifmvo.togetherad.core.listener;

import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AllAdListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/ifmvo/togetherad/core/listener/AllAdListener;", "", "", "providerType", "alias", "Lf/v;", "onAdStartRequest", "(Ljava/lang/String;Ljava/lang/String;)V", "failedMsg", "onAdFailed", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onAdLoaded", "core_release"}, k = 1, mv = {1, 4, 0})
public interface AllAdListener {

    /* JADX INFO: compiled from: AllAdListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static void onAdFailed(AllAdListener allAdListener, @NotNull String str, @NotNull String str2, @Nullable String str3) {
            j.f(str, "providerType");
            j.f(str2, "alias");
        }

        public static void onAdLoaded(AllAdListener allAdListener, @NotNull String str, @NotNull String str2) {
            j.f(str, "providerType");
            j.f(str2, "alias");
        }

        public static void onAdStartRequest(AllAdListener allAdListener, @NotNull String str, @NotNull String str2) {
            j.f(str, "providerType");
            j.f(str2, "alias");
        }
    }

    void onAdFailed(@NotNull String providerType, @NotNull String alias, @Nullable String failedMsg);

    void onAdLoaded(@NotNull String providerType, @NotNull String alias);

    void onAdStartRequest(@NotNull String providerType, @NotNull String alias);
}
