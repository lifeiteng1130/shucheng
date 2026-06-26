package io.legado.app.ui.widget.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.h;
import io.legado.app.R$styleable;
import io.wenyuange.app.release.R;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BadgeView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b9\u0010:J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\nJ\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0013\u0010&\u001a\u00020#8F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010%R*\u0010(\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010!\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0016R$\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\nR\u0015\u00102\u001a\u0004\u0018\u00010\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u00103¨\u0006;"}, d2 = {"Lio/legado/app/ui/widget/text/BadgeView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "dipRadius", "", "badgeColor", "Lf/v;", "b", "(FI)V", "setBackground", "(I)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "Landroid/widget/TextView$BufferType;", "type", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "count", "setBadgeCount", "", "highlight", "setHighlight", "(Z)V", "dipMargin", "setBadgeMargin", "Landroid/view/View;", "target", "setTargetView", "(Landroid/view/View;)V", "dip", ai.at, "(F)I", ai.aD, "Z", "flatangle", "", "getBadgeMargin", "()[I", "badgeMargin", "hideOnNull", "isHideOnNull", "()Z", "setHideOnNull", "gravity", "getBadgeGravity", "()I", "setBadgeGravity", "badgeGravity", "getBadgeCount", "()Ljava/lang/Integer;", "badgeCount", "F", "radius", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BadgeView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public boolean isHideOnNull;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public float radius;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean flatangle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BadgeView(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    public final int a(float dip) {
        return (int) ((dip * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void b(float dipRadius, int badgeColor) {
        float fA = a(dipRadius);
        float[] fArr = {fA, fA, fA, fA, fA, fA, fA, fA};
        if (this.flatangle) {
            j.e(fArr, "$this$fill");
            Arrays.fill(fArr, 0, 3, 0.0f);
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(badgeColor);
        setBackground(shapeDrawable);
    }

    @Nullable
    public final Integer getBadgeCount() {
        Object objM11constructorimpl;
        if (getText() == null) {
            return null;
        }
        try {
            objM11constructorimpl = h.m11constructorimpl(Integer.valueOf(Integer.parseInt(getText().toString())));
        } catch (Throwable th) {
            objM11constructorimpl = h.m11constructorimpl(f.m1(th));
        }
        return (Integer) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
    }

    public final int getBadgeGravity() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        return ((FrameLayout.LayoutParams) layoutParams).gravity;
    }

    @NotNull
    public final int[] getBadgeMargin() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        return new int[]{layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin};
    }

    public final void setBackground(int badgeColor) {
        b(this.radius, badgeColor);
    }

    public final void setBadgeCount(int count) {
        setText(String.valueOf(count));
        if (count == 0) {
            f.e3(this);
        } else {
            f.c6(this);
        }
    }

    public final void setBadgeGravity(int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = i2;
        setLayoutParams(layoutParams2);
    }

    public final void setBadgeMargin(int dipMargin) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        float f2 = dipMargin;
        layoutParams2.leftMargin = a(f2);
        layoutParams2.topMargin = a(f2);
        layoutParams2.rightMargin = a(f2);
        layoutParams2.bottomMargin = a(f2);
        setLayoutParams(layoutParams2);
    }

    public final void setHideOnNull(boolean z) {
        this.isHideOnNull = z;
        setText(getText());
    }

    public final void setHighlight(boolean highlight) {
        if (highlight) {
            Context context = getContext();
            j.d(context, c.R);
            setBackground(f.M1(context));
        } else {
            Context context2 = getContext();
            j.d(context2, c.R);
            setBackground(f.c2(context2, R.color.darker_gray));
        }
    }

    public final void setTargetView(@Nullable View target) {
        if (getParent() != null) {
            ViewParent parent = getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
        if (target == null) {
            return;
        }
        if (target.getParent() instanceof FrameLayout) {
            ViewParent parent2 = target.getParent();
            Objects.requireNonNull(parent2, "null cannot be cast to non-null type android.widget.FrameLayout");
            ((FrameLayout) parent2).addView(this);
        } else if (target.getParent() instanceof ViewGroup) {
            ViewParent parent3 = target.getParent();
            Objects.requireNonNull(parent3, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent3;
            int iIndexOfChild = viewGroup.indexOfChild(target);
            viewGroup.removeView(target);
            FrameLayout frameLayout = new FrameLayout(getContext());
            ViewGroup.LayoutParams layoutParams = target.getLayoutParams();
            frameLayout.setLayoutParams(layoutParams);
            target.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(frameLayout, iIndexOfChild, layoutParams);
            frameLayout.addView(target);
            frameLayout.addView(this);
        }
    }

    @Override // android.widget.TextView
    public void setText(@NotNull CharSequence text, @NotNull TextView.BufferType type) {
        j.e(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        j.e(type, "type");
        if (this.isHideOnNull && TextUtils.isEmpty(text)) {
            f.e3(this);
        } else {
            f.c6(this);
        }
        super.setText(text, type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BadgeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.isHideOnNull = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BadgeView);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.BadgeView)");
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 8);
        this.flatangle = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        if (!(getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        }
        setTextColor(-1);
        setTextSize(2, 11.0f);
        setPadding(a(5.0f), a(1.0f), a(5.0f), a(1.0f));
        float f2 = dimensionPixelOffset;
        this.radius = f2;
        b(f2, f.M1(context));
        setGravity(17);
        setHideOnNull(true);
        setBadgeCount(0);
        setMinWidth(a(16.0f));
        setMinHeight(a(16.0f));
    }
}
