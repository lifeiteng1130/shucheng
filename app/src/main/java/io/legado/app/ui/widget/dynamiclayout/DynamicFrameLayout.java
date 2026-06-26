package io.legado.app.ui.widget.dynamiclayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.R$styleable;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DynamicFrameLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0010\u0019B\u001d\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lio/legado/app/ui/widget/dynamiclayout/DynamicFrameLayout;", "Landroid/widget/FrameLayout;", "", "Lf/v;", "onFinishInflate", "()V", "Lio/legado/app/ui/widget/dynamiclayout/DynamicFrameLayout$b;", "listener", "setOnVisibilityChangeListener", "(Lio/legado/app/ui/widget/dynamiclayout/DynamicFrameLayout$b;)V", "Lio/legado/app/ui/widget/dynamiclayout/DynamicFrameLayout$a;", "action", "setErrorAction", "(Lio/legado/app/ui/widget/dynamiclayout/DynamicFrameLayout$a;)V", "setEmptyAction", "", ai.at, "Ljava/lang/CharSequence;", "errorActionDescription", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @Nullable
    public CharSequence errorActionDescription;

    /* JADX INFO: compiled from: DynamicFrameLayout.kt */
    public interface a {
    }

    /* JADX INFO: compiled from: DynamicFrameLayout.kt */
    public interface b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DynamicFrameLayout(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 2) {
            getChildAt(2);
        }
    }

    public final void setEmptyAction(@NotNull a action) {
        j.e(action, "action");
    }

    public final void setErrorAction(@NotNull a action) {
        j.e(action, "action");
    }

    public final void setOnVisibilityChangeListener(@NotNull b listener) {
        j.e(listener, "listener");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DynamicFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        View.inflate(context, R.layout.view_dynamic, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DynamicFrameLayout);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.DynamicFrameLayout)");
        typedArrayObtainStyledAttributes.getDrawable(4);
        typedArrayObtainStyledAttributes.getDrawable(2);
        typedArrayObtainStyledAttributes.getText(0);
        typedArrayObtainStyledAttributes.getText(1);
        CharSequence text = typedArrayObtainStyledAttributes.getText(3);
        this.errorActionDescription = text;
        if (text == null) {
            this.errorActionDescription = context.getString(R.string.dynamic_click_retry);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
