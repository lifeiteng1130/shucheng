package com.ifmvo.togetherad.gdt.native_.view;

import android.widget.FrameLayout;
import f.c0.b.l;
import f.c0.c.f;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeViewGdtSimple5.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B.\u0012%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/ifmvo/togetherad/gdt/native_/view/NativeViewGdtSimple5;", "Lcom/ifmvo/togetherad/gdt/native_/view/BaseNativeViewGdt;", "Landroid/widget/FrameLayout$LayoutParams;", "getLogoLayoutParams", "()Landroid/widget/FrameLayout$LayoutParams;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "adProviderType", "Lf/v;", "onClose", "<init>", "(Lf/c0/b/l;)V", "gdt_release"}, k = 1, mv = {1, 4, 0})
public final class NativeViewGdtSimple5 extends BaseNativeViewGdt {
    /* JADX WARN: Multi-variable type inference failed */
    public NativeViewGdtSimple5() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public NativeViewGdtSimple5(@Nullable l<? super String, v> lVar) {
        super(lVar);
    }

    @Override // com.ifmvo.togetherad.gdt.native_.view.BaseNativeViewGdt
    @Nullable
    public FrameLayout.LayoutParams getLogoLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388693;
        layoutParams.bottomMargin = 100;
        return layoutParams;
    }

    public /* synthetic */ NativeViewGdtSimple5(l lVar, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : lVar);
    }
}
