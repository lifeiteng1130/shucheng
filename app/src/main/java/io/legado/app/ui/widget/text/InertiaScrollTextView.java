package io.legado.app.ui.widget.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import io.legado.app.ui.widget.text.InertiaScrollTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: InertiaScrollTextView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001aB\u001d\b\u0007\u0012\u0006\u0010>\u001a\u00020=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001dR\u001c\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010)R!\u00100\u001a\u00060+R\u00020\u00008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010\u001dR\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010\u001d¨\u0006C"}, d2 = {"Lio/legado/app/ui/widget/text/InertiaScrollTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "state", "Lf/v;", "setScrollState", "(I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "start", "lengthBefore", "lengthAfter", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "x", "y", "scrollTo", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", ai.at, "()V", "f", OptRuntime.GeneratorState.resumptionPoint_TYPE, "mScrollState", "k", "mOffsetHeight", "b", "scrollStateDragging", ai.aA, "mMinFlingVelocity", "h", "mTouchSlop", ai.aD, "getScrollStateSettling", "()I", "scrollStateSettling", "Lio/legado/app/ui/widget/text/InertiaScrollTextView$a;", "d", "Lf/e;", "getMViewFling", "()Lio/legado/app/ui/widget/text/InertiaScrollTextView$a;", "mViewFling", "Landroid/view/VelocityTracker;", "e", "Landroid/view/VelocityTracker;", "velocityTracker", "g", "mLastTouchY", "Landroid/view/animation/Interpolator;", Constants.LANDSCAPE, "Landroid/view/animation/Interpolator;", "sQuinticInterpolator", "j", "mMaxFlingVelocity", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public class InertiaScrollTextView extends AppCompatTextView {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int scrollStateDragging;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int scrollStateSettling;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e mViewFling;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public VelocityTracker velocityTracker;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int mScrollState;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int mLastTouchY;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int mTouchSlop;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int mMinFlingVelocity;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int mMaxFlingVelocity;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public int mOffsetHeight;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Interpolator sQuinticInterpolator;

    /* JADX INFO: compiled from: InertiaScrollTextView.kt */
    public final class a implements Runnable {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final OverScroller f7794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ InertiaScrollTextView f7797e;

        public a(InertiaScrollTextView inertiaScrollTextView) {
            j.e(inertiaScrollTextView, "this$0");
            this.f7797e = inertiaScrollTextView;
            this.f7794b = new OverScroller(inertiaScrollTextView.getContext(), inertiaScrollTextView.sQuinticInterpolator);
        }

        public final void a() {
            if (this.f7795c) {
                this.f7796d = true;
            } else {
                this.f7797e.removeCallbacks(this);
                ViewCompat.postOnAnimation(this.f7797e, this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7796d = false;
            this.f7795c = true;
            OverScroller overScroller = this.f7794b;
            if (overScroller.computeScrollOffset()) {
                int currY = overScroller.getCurrY();
                int i2 = currY - this.a;
                this.a = currY;
                if (i2 < 0 && this.f7797e.getScrollY() > 0) {
                    InertiaScrollTextView inertiaScrollTextView = this.f7797e;
                    inertiaScrollTextView.scrollBy(0, Math.max(i2, -inertiaScrollTextView.getScrollY()));
                } else if (i2 > 0) {
                    int scrollY = this.f7797e.getScrollY();
                    InertiaScrollTextView inertiaScrollTextView2 = this.f7797e;
                    int i3 = inertiaScrollTextView2.mOffsetHeight;
                    if (scrollY < i3) {
                        inertiaScrollTextView2.scrollBy(0, Math.min(i2, i3 - inertiaScrollTextView2.getScrollY()));
                    }
                }
                a();
            }
            this.f7795c = false;
            if (this.f7796d) {
                a();
            }
        }
    }

    /* JADX INFO: compiled from: InertiaScrollTextView.kt */
    public static final class b extends k implements f.c0.b.a<a> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final a invoke() {
            return new a(InertiaScrollTextView.this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InertiaScrollTextView(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    private final a getMViewFling() {
        return (a) this.mViewFling.getValue();
    }

    private final void setScrollState(int state) {
        if (state == this.mScrollState) {
            return;
        }
        this.mScrollState = state;
        if (state != this.scrollStateSettling) {
            a mViewFling = getMViewFling();
            mViewFling.f7797e.removeCallbacks(mViewFling);
            mViewFling.f7794b.abortAnimation();
        }
    }

    public final void a() {
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        this.mOffsetHeight = (getTotalPaddingBottom() + (getTotalPaddingTop() + layout.getHeight())) - getMeasuredHeight();
    }

    public final int getScrollStateSettling() {
        return this.scrollStateSettling;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void onTextChanged(@Nullable CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        a();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        VelocityTracker velocityTracker;
        if (event != null) {
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(event);
            }
            int action = event.getAction();
            if (action == 0) {
                setScrollState(0);
                this.mLastTouchY = (int) (event.getY() + 0.5f);
            } else if (action == 1) {
                VelocityTracker velocityTracker3 = this.velocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                }
                VelocityTracker velocityTracker4 = this.velocityTracker;
                float yVelocity = velocityTracker4 == null ? 0.0f : velocityTracker4.getYVelocity();
                if (Math.abs(yVelocity) > this.mMinFlingVelocity) {
                    a mViewFling = getMViewFling();
                    int i2 = -((int) yVelocity);
                    mViewFling.a = 0;
                    InertiaScrollTextView inertiaScrollTextView = mViewFling.f7797e;
                    inertiaScrollTextView.setScrollState(inertiaScrollTextView.getScrollStateSettling());
                    mViewFling.f7794b.fling(0, 0, 0, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    mViewFling.a();
                } else {
                    setScrollState(0);
                }
                VelocityTracker velocityTracker5 = this.velocityTracker;
                if (velocityTracker5 != null) {
                    velocityTracker5.clear();
                }
            } else if (action == 2) {
                int y = (int) (event.getY() + 0.5f);
                int i3 = this.mLastTouchY - y;
                if (this.mScrollState != this.scrollStateDragging) {
                    if (Math.abs(i3) > this.mTouchSlop) {
                        setScrollState(this.scrollStateDragging);
                    }
                }
                if (this.mScrollState == this.scrollStateDragging) {
                    this.mLastTouchY = y;
                }
            } else if (action == 3 && (velocityTracker = this.velocityTracker) != null) {
                velocityTracker.clear();
            }
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    public void scrollTo(int x, int y) {
        super.scrollTo(x, Math.min(y, this.mOffsetHeight));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InertiaScrollTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.scrollStateDragging = 1;
        this.scrollStateSettling = 2;
        this.mViewFling = f.N3(new b());
        this.mScrollState = 0;
        this.sQuinticInterpolator = new Interpolator() { // from class: e.a.a.g.m.r.b
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f2) {
                int i2 = InertiaScrollTextView.a;
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setMovementMethod(LinkMovementMethod.getInstance());
    }
}
