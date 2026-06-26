package io.legado.app.ui.widget.seekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VerticalSeekBarWrapper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lio/legado/app/ui/widget/seekbar/VerticalSeekBarWrapper;", "Landroid/widget/FrameLayout;", "", "w", "h", "oldw", "oldh", "Lf/v;", "onSizeChanged", "(IIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", ai.at, "Lio/legado/app/ui/widget/seekbar/VerticalSeekBar;", "getChildSeekBar", "()Lio/legado/app/ui/widget/seekbar/VerticalSeekBar;", "childSeekBar", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class VerticalSeekBarWrapper extends FrameLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalSeekBarWrapper(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    private final VerticalSeekBar getChildSeekBar() {
        View childAt = getChildCount() > 0 ? getChildAt(0) : null;
        if (childAt instanceof VerticalSeekBar) {
            return (VerticalSeekBar) childAt;
        }
        return null;
    }

    public final void a(int w, int h2) {
        VerticalSeekBar childSeekBar = getChildSeekBar();
        if (childSeekBar != null) {
            boolean z = ViewCompat.getLayoutDirection(this) == 0;
            int mRotationAngle = childSeekBar.getMRotationAngle();
            int measuredWidth = childSeekBar.getMeasuredWidth();
            int measuredHeight = childSeekBar.getMeasuredHeight();
            int paddingRight = getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            float fMax = (Math.max(0, w - paddingRight) - measuredHeight) * 0.5f;
            ViewGroup.LayoutParams layoutParams = childSeekBar.getLayoutParams();
            layoutParams.width = Math.max(0, h2 - paddingBottom);
            layoutParams.height = -2;
            childSeekBar.setLayoutParams(layoutParams);
            childSeekBar.setPivotX(z ? 0 : Math.max(0, r11));
            childSeekBar.setPivotY(0.0f);
            if (mRotationAngle == 90) {
                childSeekBar.setRotation(90.0f);
                if (z) {
                    childSeekBar.setTranslationX(measuredHeight + fMax);
                    childSeekBar.setTranslationY(0.0f);
                    return;
                } else {
                    childSeekBar.setTranslationX(-fMax);
                    childSeekBar.setTranslationY(measuredWidth);
                    return;
                }
            }
            if (mRotationAngle != 270) {
                return;
            }
            childSeekBar.setRotation(270.0f);
            if (z) {
                childSeekBar.setTranslationX(fMax);
                childSeekBar.setTranslationY(measuredWidth);
            } else {
                childSeekBar.setTranslationX(-(measuredHeight + fMax));
                childSeekBar.setTranslationY(0.0f);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth;
        int measuredHeight;
        VerticalSeekBar childSeekBar = getChildSeekBar();
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (childSeekBar == null || mode == 1073741824) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingRight), mode);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, size2 - paddingBottom), mode2);
        VerticalSeekBar childSeekBar2 = getChildSeekBar();
        if (childSeekBar2 == null ? false : childSeekBar2.d()) {
            childSeekBar.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
            measuredWidth = childSeekBar.getMeasuredHeight();
            measuredHeight = childSeekBar.getMeasuredWidth();
        } else {
            childSeekBar.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            measuredWidth = childSeekBar.getMeasuredWidth();
            measuredHeight = childSeekBar.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth + paddingRight, widthMeasureSpec, 0), View.resolveSizeAndState(measuredHeight + paddingBottom, heightMeasureSpec, 0));
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        VerticalSeekBar childSeekBar = getChildSeekBar();
        if (childSeekBar == null ? false : childSeekBar.d()) {
            VerticalSeekBar childSeekBar2 = getChildSeekBar();
            if (childSeekBar2 != null) {
                childSeekBar2.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, h2 - (getPaddingBottom() + getPaddingTop())), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(Math.max(0, w - (getPaddingRight() + getPaddingLeft())), Integer.MIN_VALUE));
            }
            a(w, h2);
            super.onSizeChanged(w, h2, oldw, oldh);
            return;
        }
        VerticalSeekBar childSeekBar3 = getChildSeekBar();
        if (childSeekBar3 != null) {
            int paddingRight = getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            ViewGroup.LayoutParams layoutParams = childSeekBar3.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = -2;
            int i2 = h2 - paddingBottom;
            layoutParams2.height = Math.max(0, i2);
            childSeekBar3.setLayoutParams(layoutParams2);
            childSeekBar3.measure(0, 0);
            int measuredWidth = childSeekBar3.getMeasuredWidth();
            int i3 = w - paddingRight;
            childSeekBar3.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, i3), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(Math.max(0, i2), BasicMeasure.EXACTLY));
            layoutParams2.gravity = 51;
            layoutParams2.leftMargin = (Math.max(0, i3) - measuredWidth) / 2;
            childSeekBar3.setLayoutParams(layoutParams2);
        }
        super.onSizeChanged(w, h2, oldw, oldh);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalSeekBarWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
    }
}
