package io.legado.app.ui.widget.recycler;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: RecyclerViewAtPager2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000f\u0010\u0013B#\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lio/legado/app/ui/widget/recycler/RecyclerViewAtPager2;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "b", OptRuntime.GeneratorState.resumptionPoint_TYPE, "startY", ai.at, "startX", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RecyclerViewAtPager2 extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int startX;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int startY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewAtPager2(@NotNull Context context) {
        super(context);
        j.e(context, c.R);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.NotNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "ev"
            f.c0.c.j.e(r6, r0)
            int r0 = r6.getAction()
            r1 = 1
            if (r0 == 0) goto L4c
            r2 = 0
            if (r0 == r1) goto L44
            r3 = 2
            if (r0 == r3) goto L16
            r1 = 3
            if (r0 == r1) goto L44
            goto L61
        L16:
            float r0 = r6.getX()
            int r0 = (int) r0
            float r3 = r6.getY()
            int r3 = (int) r3
            int r4 = r5.startX
            int r0 = r0 - r4
            int r0 = java.lang.Math.abs(r0)
            int r4 = r5.startY
            int r3 = r3 - r4
            int r3 = java.lang.Math.abs(r3)
            if (r0 <= r3) goto L3c
            r1 = 50
            if (r0 <= r1) goto L61
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L61
        L3c:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L61
        L44:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L61
        L4c:
            float r0 = r6.getX()
            int r0 = (int) r0
            r5.startX = r0
            float r0 = r6.getY()
            int r0 = (int) r0
            r5.startY = r0
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L61:
            boolean r6 = super.dispatchTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.widget.recycler.RecyclerViewAtPager2.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewAtPager2(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewAtPager2(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        j.e(context, c.R);
    }
}
