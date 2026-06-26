package io.legado.app.ui.widget.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ScrollTextView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0014\u0010\u0013J/\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010 ¨\u0006("}, d2 = {"Lio/legado/app/ui/widget/text/ScrollTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "widthMeasureSpec", "heightMeasureSpec", "Lf/v;", "onMeasure", "(II)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "start", "lengthBefore", "lengthAfter", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "horiz", "vert", "oldHoriz", "oldVert", "onScrollChanged", "(IIII)V", ai.at, "()V", "b", "Z", "mBottomFlag", OptRuntime.GeneratorState.resumptionPoint_TYPE, "mOffsetHeight", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ScrollTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int mOffsetHeight;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean mBottomFlag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
    }

    public final void a() {
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        int height = layout.getHeight();
        int totalPaddingTop = getTotalPaddingTop();
        int totalPaddingBottom = ((height + totalPaddingTop) + getTotalPaddingBottom()) - getMeasuredHeight();
        this.mOffsetHeight = totalPaddingBottom;
        if (totalPaddingBottom <= 0) {
            scrollTo(0, 0);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        j.e(event, NotificationCompat.CATEGORY_EVENT);
        if (event.getAction() == 0) {
            this.mBottomFlag = this.mOffsetHeight <= 0;
        }
        if (this.mBottomFlag) {
            event.setAction(3);
        }
        return super.dispatchTouchEvent(event);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        if (vert == this.mOffsetHeight || vert == 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.mBottomFlag = true;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void onTextChanged(@NotNull CharSequence text, int start, int lengthBefore, int lengthAfter) {
        j.e(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        a();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        j.e(event, NotificationCompat.CATEGORY_EVENT);
        boolean zOnTouchEvent = super.onTouchEvent(event);
        if (!this.mBottomFlag) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return zOnTouchEvent;
    }
}
