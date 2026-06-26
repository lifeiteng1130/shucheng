package com.ifmvo.togetherad.core.utils;

import com.ifmvo.togetherad.core.TogetherAd;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LogExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001d\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u001d\u0010\u0007\u001a\u00020\u0002*\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0007\u0010\u0004\u001a\u001d\u0010\b\u001a\u00020\u0002*\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\b\u0010\u0004¨\u0006\t"}, d2 = {"", "tag", "Lf/v;", "logv", "(Ljava/lang/String;Ljava/lang/String;)V", "logd", "logi", "logw", "loge", "core_release"}, k = 2, mv = {1, 4, 0})
public final class LogExtKt {
    public static final void logd(@NotNull String str, @Nullable String str2) {
        j.f(str, "$this$logd");
        TogetherAd.INSTANCE.getPrintLogEnable();
    }

    public static /* synthetic */ void logd$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "TogetherAd";
        }
        logd(str, str2);
    }

    public static final void loge(@NotNull String str, @Nullable String str2) {
        j.f(str, "$this$loge");
        TogetherAd.INSTANCE.getPrintLogEnable();
    }

    public static /* synthetic */ void loge$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "TogetherAd";
        }
        loge(str, str2);
    }

    public static final void logi(@NotNull String str, @Nullable String str2) {
        j.f(str, "$this$logi");
        TogetherAd.INSTANCE.getPrintLogEnable();
    }

    public static /* synthetic */ void logi$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "TogetherAd";
        }
        logi(str, str2);
    }

    public static final void logv(@NotNull String str, @Nullable String str2) {
        j.f(str, "$this$logv");
        TogetherAd.INSTANCE.getPrintLogEnable();
    }

    public static /* synthetic */ void logv$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "TogetherAd";
        }
        logv(str, str2);
    }

    public static final void logw(@NotNull String str, @Nullable String str2) {
        j.f(str, "$this$logw");
        TogetherAd.INSTANCE.getPrintLogEnable();
    }

    public static /* synthetic */ void logw$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "TogetherAd";
        }
        logw(str, str2);
    }
}
