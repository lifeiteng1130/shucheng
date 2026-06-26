package com.ifmvo.togetherad.core.custom.native_;

import android.view.ViewGroup;
import com.ifmvo.togetherad.core.listener.NativeViewListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseNativeView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ9\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00012\b\b\u0001\u0010\u0006\u001a\u00020\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/ifmvo/togetherad/core/custom/native_/BaseNativeView;", "", "", "adProviderType", "adObject", "Landroid/view/ViewGroup;", "container", "Lcom/ifmvo/togetherad/core/listener/NativeViewListener;", "listener", "Lf/v;", "showNative", "(Ljava/lang/String;Ljava/lang/Object;Landroid/view/ViewGroup;Lcom/ifmvo/togetherad/core/listener/NativeViewListener;)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public abstract class BaseNativeView {
    public static /* synthetic */ void showNative$default(BaseNativeView baseNativeView, String str, Object obj, ViewGroup viewGroup, NativeViewListener nativeViewListener, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNative");
        }
        if ((i2 & 8) != 0) {
            nativeViewListener = null;
        }
        baseNativeView.showNative(str, obj, viewGroup, nativeViewListener);
    }

    public abstract void showNative(@NotNull String adProviderType, @NotNull Object adObject, @NotNull ViewGroup container, @Nullable NativeViewListener listener);
}
