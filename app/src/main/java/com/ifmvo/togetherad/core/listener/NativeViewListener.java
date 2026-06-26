package com.ifmvo.togetherad.core.listener;

import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NativeViewListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ifmvo/togetherad/core/listener/NativeViewListener;", "", "", "providerType", "Lf/v;", "onAdExposed", "(Ljava/lang/String;)V", "onAdClicked", "core_release"}, k = 1, mv = {1, 4, 0})
public interface NativeViewListener {

    /* JADX INFO: compiled from: NativeViewListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static void onAdClicked(NativeViewListener nativeViewListener, @NotNull String str) {
            j.f(str, "providerType");
        }

        public static void onAdExposed(NativeViewListener nativeViewListener, @NotNull String str) {
            j.f(str, "providerType");
        }
    }

    void onAdClicked(@NotNull String providerType);

    void onAdExposed(@NotNull String providerType);
}
