package com.ifmvo.togetherad.core.custom.express;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseNativeExpressTemplate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/ifmvo/togetherad/core/custom/express/BaseNativeExpressTemplate;", "", "", "adProviderType", "Lcom/ifmvo/togetherad/core/custom/express/BaseNativeExpressView;", "getNativeExpressView", "(Ljava/lang/String;)Lcom/ifmvo/togetherad/core/custom/express/BaseNativeExpressView;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public abstract class BaseNativeExpressTemplate {
    @Nullable
    public abstract BaseNativeExpressView getNativeExpressView(@NotNull String adProviderType);
}
