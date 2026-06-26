package io.legado.app.ui.main.bookshelf;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.databinding.ActivityMainBinding;
import io.legado.app.ui.main.MainActivity;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: RootView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001e\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0010¨\u0006#"}, d2 = {"Lio/legado/app/ui/main/bookshelf/RootView;", "Landroid/widget/LinearLayout;", "Landroid/view/MotionEvent;", "e", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "orientation", "", "delta", ai.at, "(IF)Z", OptRuntime.GeneratorState.resumptionPoint_TYPE, "touchSlop", ai.aD, "F", "initialY", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager", "Landroid/view/View;", "getChildViewPager", "()Landroid/view/View;", "childViewPager", "b", "initialX", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RootView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final int touchSlop;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public float initialX;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public float initialY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RootView(@NotNull Context context) {
        super(context);
        j.e(context, c.R);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final View getChildViewPager() {
        return findViewById(R.id.view_pager_bookshelf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ViewPager2 getParentViewPager() {
        AppCompatActivity appCompatActivityO1 = f.O1(this);
        MainActivity mainActivity = appCompatActivityO1 instanceof MainActivity ? (MainActivity) appCompatActivityO1 : null;
        if (mainActivity == null) {
            return null;
        }
        ViewPager2 viewPager2 = ((ActivityMainBinding) mainActivity.K0()).f6523c;
        j.d(viewPager2, "binding.viewPagerMain");
        return viewPager2;
    }

    public final boolean a(int orientation, float delta) {
        int i2 = -((int) Math.signum(delta));
        if (orientation == 0) {
            View childViewPager = getChildViewPager();
            if (childViewPager == null) {
                return false;
            }
            return childViewPager.canScrollHorizontally(i2);
        }
        if (orientation != 1) {
            throw new IllegalArgumentException();
        }
        View childViewPager2 = getChildViewPager();
        if (childViewPager2 == null) {
            return false;
        }
        return childViewPager2.canScrollVertically(i2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent e2) {
        j.e(e2, "e");
        ViewPager2 parentViewPager = getParentViewPager();
        Integer numValueOf = parentViewPager == null ? null : Integer.valueOf(parentViewPager.getOrientation());
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            if (a(iIntValue, -1.0f) || a(iIntValue, 1.0f)) {
                if (e2.getAction() == 0) {
                    this.initialX = e2.getX();
                    this.initialY = e2.getY();
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else if (e2.getAction() == 2) {
                    float x = e2.getX() - this.initialX;
                    float y = e2.getY() - this.initialY;
                    boolean z = iIntValue == 0;
                    float fAbs = Math.abs(x) * (z ? 0.5f : 1.0f);
                    float fAbs2 = Math.abs(y) * (z ? 1.0f : 0.5f);
                    float f2 = this.touchSlop;
                    if (fAbs > f2 || fAbs2 > f2) {
                        if (z == (fAbs2 > fAbs)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        } else {
                            if (!z) {
                                x = y;
                            }
                            if (a(iIntValue, x)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            } else {
                                getParent().requestDisallowInterceptTouchEvent(false);
                            }
                        }
                    }
                }
            }
        }
        return super.onInterceptTouchEvent(e2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RootView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
