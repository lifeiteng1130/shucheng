package com.ifmvo.togetherad.core.listener;

import com.ifmvo.togetherad.core.listener.BaseListener;
import f.c0.c.j;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ifmvo/togetherad/core/listener/NativeListener;", "Lcom/ifmvo/togetherad/core/listener/BaseListener;", "", "providerType", "", "", "adList", "Lf/v;", "onAdLoaded", "(Ljava/lang/String;Ljava/util/List;)V", "core_release"}, k = 1, mv = {1, 4, 0})
public interface NativeListener extends BaseListener {

    /* JADX INFO: compiled from: NativeListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static void onAdFailed(NativeListener nativeListener, @NotNull String str, @Nullable String str2) {
            j.f(str, "providerType");
            BaseListener.DefaultImpls.onAdFailed(nativeListener, str, str2);
        }

        public static void onAdFailedAll(NativeListener nativeListener, @Nullable String str) {
            BaseListener.DefaultImpls.onAdFailedAll(nativeListener, str);
        }

        public static void onAdLoaded(NativeListener nativeListener, @NotNull String str, @NotNull List<? extends Object> list) {
            j.f(str, "providerType");
            j.f(list, "adList");
        }

        public static void onAdStartRequest(NativeListener nativeListener, @NotNull String str) {
            j.f(str, "providerType");
            BaseListener.DefaultImpls.onAdStartRequest(nativeListener, str);
        }
    }

    void onAdLoaded(@NotNull String providerType, @NotNull List<? extends Object> adList);
}
