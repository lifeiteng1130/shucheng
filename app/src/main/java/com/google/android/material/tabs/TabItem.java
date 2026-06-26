package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class TabItem extends View {
    public final CharSequence a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f2402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2403c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R$styleable.TabItem);
        this.a = tintTypedArrayObtainStyledAttributes.getText(R$styleable.TabItem_android_text);
        this.f2402b = tintTypedArrayObtainStyledAttributes.getDrawable(R$styleable.TabItem_android_icon);
        this.f2403c = tintTypedArrayObtainStyledAttributes.getResourceId(R$styleable.TabItem_android_layout, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }
}
