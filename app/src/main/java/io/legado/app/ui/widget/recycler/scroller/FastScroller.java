package io.legado.app.ui.widget.recycler.scroller;

import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.g.m.p.b.d;
import f.c0.c.j;
import io.legado.app.R$styleable;
import io.legado.app.ui.widget.recycler.scroller.FastScroller;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: FastScroller.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001m\u0018\u00002\u00020\u0001:\u0002\u0084\u0001B\u0013\b\u0016\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001B(\b\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u0010¢\u0006\u0006\b\u0080\u0001\u0010\u0083\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0015\u0010(\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b(\u0010,J\u0017\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\b¢\u0006\u0004\b2\u0010\u000bJ\u0015\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\b¢\u0006\u0004\b4\u0010\u000bJ\u0015\u00105\u001a\u00020\u00042\u0006\u00103\u001a\u00020\b¢\u0006\u0004\b5\u0010\u000bJ\u0017\u00107\u001a\u00020\u00042\b\b\u0001\u00106\u001a\u00020\u0010¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00042\b\b\u0001\u00106\u001a\u00020\u0010¢\u0006\u0004\b9\u00108J\u0017\u0010:\u001a\u00020\u00042\b\b\u0001\u00106\u001a\u00020\u0010¢\u0006\u0004\b:\u00108J\u0017\u0010;\u001a\u00020\u00042\b\b\u0001\u00106\u001a\u00020\u0010¢\u0006\u0004\b;\u00108J\u0015\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\bH\u0016¢\u0006\u0004\bA\u0010\u000bJ\u0017\u0010D\u001a\u00020\b2\u0006\u0010C\u001a\u00020BH\u0017¢\u0006\u0004\bD\u0010EJ/\u0010I\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0010H\u0014¢\u0006\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010NR\u0016\u0010V\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010NR\u0016\u0010X\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010WR\u0016\u0010Y\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010NR\u0016\u0010Z\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010LR\u0016\u0010_\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010a\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010RR\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010u\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010NR\u0018\u0010x\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010z\u001a\u00020b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\by\u0010dR\u0018\u0010|\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010RR\u0018\u0010\u007f\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~¨\u0006\u0085\u0001"}, d2 = {"Lio/legado/app/ui/widget/recycler/scroller/FastScroller;", "Landroid/widget/LinearLayout;", "", "y", "Lf/v;", "setRecyclerViewPosition", "(F)V", "setViewPositions", "", "selected", "setHandleSelected", "(Z)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", ai.aD, "(Landroidx/recyclerview/widget/RecyclerView;)F", "", "min", "max", ES6Iterator.VALUE_PROPERTY, "d", "(III)I", "Landroid/view/View;", "view", "e", "(Landroid/view/View;)Z", "Landroid/view/ViewPropertyAnimator;", "animator", "b", "(Landroid/view/ViewPropertyAnimator;)V", "h", "()V", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "g", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup;", "viewGroup", "(Landroid/view/ViewGroup;)V", "Lio/legado/app/ui/widget/recycler/scroller/FastScroller$a;", "sectionIndexer", "setSectionIndexer", "(Lio/legado/app/ui/widget/recycler/scroller/FastScroller$a;)V", "fadeScrollbar", "setFadeScrollbar", "visible", "setBubbleVisible", "setTrackVisible", "color", "setTrackColor", "(I)V", "setHandleColor", "setBubbleColor", "setBubbleTextColor", "Le/a/a/g/m/p/b/c;", "fastScrollStateChangeListener", "setFastScrollStateChangeListener", "(Le/a/a/g/m/p/b/c;)V", "enabled", "setEnabled", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "w", "oldw", "oldh", "onSizeChanged", "(IIII)V", "k", "Landroid/view/ViewPropertyAnimator;", "mBubbleAnimator", OptRuntime.GeneratorState.resumptionPoint_TYPE, "mBubbleHeight", "Landroid/graphics/drawable/Drawable;", ai.az, "Landroid/graphics/drawable/Drawable;", "mTrackImage", "f", "mViewHeight", "mHandleHeight", "Z", "mFadeScrollbar", "mBubbleColor", "mShowBubble", "j", "mScrollbarAnimator", "p", "Landroid/view/View;", "mScrollbar", "r", "mHandleImage", "Landroid/widget/ImageView;", "o", "Landroid/widget/ImageView;", "mTrackView", ai.aA, "Lio/legado/app/ui/widget/recycler/scroller/FastScroller$a;", "mSectionIndexer", "Ljava/lang/Runnable;", ai.aE, "Ljava/lang/Runnable;", "mScrollbarHider", "io/legado/app/ui/widget/recycler/scroller/FastScroller$mScrollListener$1", ai.aC, "Lio/legado/app/ui/widget/recycler/scroller/FastScroller$mScrollListener$1;", "mScrollListener", "Landroid/widget/TextView;", "m", "Landroid/widget/TextView;", "mBubbleView", "mHandleColor", Constants.LANDSCAPE, "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "n", "mHandleView", "q", "mBubbleImage", ai.aF, "Le/a/a/g/m/p/b/c;", "mFastScrollStateChangeListener", "<init>", "(Landroid/content/Context;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FastScroller extends LinearLayout {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @ColorInt
    public int mBubbleColor;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @ColorInt
    public int mHandleColor;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int mBubbleHeight;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int mHandleHeight;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int mViewHeight;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean mFadeScrollbar;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean mShowBubble;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a mSectionIndexer;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public ViewPropertyAnimator mScrollbarAnimator;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public ViewPropertyAnimator mBubbleAnimator;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public RecyclerView mRecyclerView;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public TextView mBubbleView;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public ImageView mHandleView;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public ImageView mTrackView;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public View mScrollbar;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @Nullable
    public Drawable mBubbleImage;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @Nullable
    public Drawable mHandleImage;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @Nullable
    public Drawable mTrackImage;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @Nullable
    public e.a.a.g.m.p.b.c mFastScrollStateChangeListener;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    @NotNull
    public final Runnable mScrollbarHider;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    @NotNull
    public final FastScroller$mScrollListener$1 mScrollListener;

    /* JADX INFO: compiled from: FastScroller.kt */
    public interface a {
        @NotNull
        String a(int i2);
    }

    /* JADX INFO: compiled from: FastScroller.kt */
    public static final class b extends AnimatorListenerAdapter {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v2, types: [io.legado.app.ui.widget.recycler.scroller.FastScroller$mScrollListener$1] */
    public FastScroller(@NotNull Context context) {
        super(context);
        j.e(context, c.R);
        this.mScrollbarHider = new Runnable() { // from class: e.a.a.g.m.p.b.a
            @Override // java.lang.Runnable
            public final void run() {
                FastScroller fastScroller = this.a;
                int i2 = FastScroller.a;
                j.e(fastScroller, "this$0");
                float dimensionPixelSize = fastScroller.getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_padding_end);
                View view = fastScroller.mScrollbar;
                if (view != null) {
                    fastScroller.mScrollbarAnimator = view.animate().translationX(dimensionPixelSize).alpha(0.0f).setDuration(300L).setListener(new e(fastScroller));
                } else {
                    j.m("mScrollbar");
                    throw null;
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: io.legado.app.ui.widget.recycler.scroller.FastScroller$mScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                j.e(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (this.a.isEnabled()) {
                    if (newState == 0) {
                        FastScroller fastScroller = this.a;
                        if (fastScroller.mFadeScrollbar) {
                            ImageView imageView = fastScroller.mHandleView;
                            if (imageView == null) {
                                j.m("mHandleView");
                                throw null;
                            }
                            if (imageView.isSelected()) {
                                return;
                            }
                            this.a.getHandler().postDelayed(this.a.mScrollbarHider, 1000L);
                            return;
                        }
                        return;
                    }
                    if (newState != 1) {
                        return;
                    }
                    this.a.getHandler().removeCallbacks(this.a.mScrollbarHider);
                    FastScroller fastScroller2 = this.a;
                    fastScroller2.b(fastScroller2.mScrollbarAnimator);
                    FastScroller fastScroller3 = this.a;
                    View view = fastScroller3.mScrollbar;
                    if (view == null) {
                        j.m("mScrollbar");
                        throw null;
                    }
                    if (fastScroller3.e(view)) {
                        return;
                    }
                    this.a.h();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                j.e(recyclerView, "recyclerView");
                ImageView imageView = this.a.mHandleView;
                if (imageView == null) {
                    j.m("mHandleView");
                    throw null;
                }
                if (imageView.isSelected() || !this.a.isEnabled()) {
                    return;
                }
                FastScroller fastScroller = this.a;
                fastScroller.setViewPositions(fastScroller.c(recyclerView));
            }
        };
        g(context, null);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    public static void f(FastScroller fastScroller) {
        j.e(fastScroller, "this$0");
        fastScroller.setViewPositions(fastScroller.c(fastScroller.mRecyclerView));
    }

    private final void setHandleSelected(boolean selected) {
        ImageView imageView = this.mHandleView;
        if (imageView == null) {
            j.m("mHandleView");
            throw null;
        }
        imageView.setSelected(selected);
        Drawable drawable = this.mHandleImage;
        j.c(drawable);
        DrawableCompat.setTint(drawable, selected ? this.mBubbleColor : this.mHandleColor);
    }

    private final void setRecyclerViewPosition(float y) {
        a aVar;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            j.c(recyclerView);
            if (recyclerView.getAdapter() != null) {
                RecyclerView recyclerView2 = this.mRecyclerView;
                j.c(recyclerView2);
                RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                j.c(adapter);
                int itemCount = adapter.getItemCount();
                ImageView imageView = this.mHandleView;
                if (imageView == null) {
                    j.m("mHandleView");
                    throw null;
                }
                float f2 = 0.0f;
                if (!(imageView.getY() == 0.0f)) {
                    ImageView imageView2 = this.mHandleView;
                    if (imageView2 == null) {
                        j.m("mHandleView");
                        throw null;
                    }
                    float y2 = imageView2.getY() + this.mHandleHeight;
                    int i2 = this.mViewHeight;
                    f2 = y2 >= ((float) (i2 + (-5))) ? 1.0f : y / i2;
                }
                int iS4 = f.S4(f2 * itemCount);
                RecyclerView recyclerView3 = this.mRecyclerView;
                j.c(recyclerView3);
                RecyclerView.LayoutManager layoutManager = recyclerView3.getLayoutManager();
                j.c(layoutManager);
                if (layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).getReverseLayout() : layoutManager instanceof StaggeredGridLayoutManager ? ((StaggeredGridLayoutManager) layoutManager).getReverseLayout() : false) {
                    iS4 = itemCount - iS4;
                }
                int iD = d(0, itemCount - 1, iS4);
                RecyclerView recyclerView4 = this.mRecyclerView;
                j.c(recyclerView4);
                RecyclerView.LayoutManager layoutManager2 = recyclerView4.getLayoutManager();
                j.c(layoutManager2);
                layoutManager2.scrollToPosition(iD);
                if (!this.mShowBubble || (aVar = this.mSectionIndexer) == null) {
                    return;
                }
                TextView textView = this.mBubbleView;
                if (textView == null) {
                    j.m("mBubbleView");
                    throw null;
                }
                j.c(aVar);
                textView.setText(aVar.a(iD));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setViewPositions(float y) {
        TextView textView = this.mBubbleView;
        if (textView == null) {
            j.m("mBubbleView");
            throw null;
        }
        this.mBubbleHeight = textView.getHeight();
        ImageView imageView = this.mHandleView;
        if (imageView == null) {
            j.m("mHandleView");
            throw null;
        }
        int height = imageView.getHeight();
        this.mHandleHeight = height;
        int i2 = this.mViewHeight;
        int i3 = this.mBubbleHeight;
        int iD = d(0, (i2 - i3) - (height / 2), (int) (y - i3));
        int iD2 = d(0, this.mViewHeight - this.mHandleHeight, (int) (y - (r6 / 2)));
        if (this.mShowBubble) {
            TextView textView2 = this.mBubbleView;
            if (textView2 == null) {
                j.m("mBubbleView");
                throw null;
            }
            textView2.setY(iD);
        }
        ImageView imageView2 = this.mHandleView;
        if (imageView2 != null) {
            imageView2.setY(iD2);
        } else {
            j.m("mHandleView");
            throw null;
        }
    }

    public final void b(ViewPropertyAnimator animator) {
        if (animator == null) {
            return;
        }
        animator.cancel();
    }

    public final float c(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return 0.0f;
        }
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        int iComputeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
        int i2 = this.mViewHeight;
        float f2 = iComputeVerticalScrollRange - i2;
        float f3 = iComputeVerticalScrollOffset;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return i2 * (f3 / f2);
    }

    public final int d(int min, int max, int value) {
        return Math.min(Math.max(min, value), max);
    }

    public final boolean e(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public final void g(Context context, AttributeSet attrs) {
        boolean z;
        View.inflate(context, R.layout.view_fastscroller, this);
        boolean z2 = false;
        setClipChildren(false);
        setOrientation(0);
        View viewFindViewById = findViewById(R.id.fastscroll_bubble);
        j.d(viewFindViewById, "findViewById(R.id.fastscroll_bubble)");
        this.mBubbleView = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.fastscroll_handle);
        j.d(viewFindViewById2, "findViewById(R.id.fastscroll_handle)");
        this.mHandleView = (ImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.fastscroll_track);
        j.d(viewFindViewById3, "findViewById(R.id.fastscroll_track)");
        this.mTrackView = (ImageView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.fastscroll_scrollbar);
        j.d(viewFindViewById4, "findViewById(R.id.fastscroll_scrollbar)");
        this.mScrollbar = viewFindViewById4;
        int iM1 = f.M1(context);
        int iArgb = Color.argb(f.S4(Color.alpha(iM1) * 0.8f), Color.red(iM1), Color.green(iM1), Color.blue(iM1));
        int iM12 = f.M1(context);
        int iC2 = f.c2(context, R.color.transparent30);
        boolean z3 = true;
        int color = ((((double) 1) - (((((double) Color.blue(iArgb)) * 0.114d) + ((((double) Color.green(iArgb)) * 0.587d) + (((double) Color.red(iArgb)) * 0.299d))) / ((double) 255))) > 0.4d ? 1 : ((((double) 1) - (((((double) Color.blue(iArgb)) * 0.114d) + ((((double) Color.green(iArgb)) * 0.587d) + (((double) Color.red(iArgb)) * 0.299d))) / ((double) 255))) == 0.4d ? 0 : -1)) < 0 ? ViewCompat.MEASURED_STATE_MASK : -1;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.FastScroller, 0, 0);
            j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.FastScroller, 0, 0)");
            try {
                iArgb = typedArrayObtainStyledAttributes.getColor(0, iArgb);
                iM12 = typedArrayObtainStyledAttributes.getColor(3, iM12);
                iC2 = typedArrayObtainStyledAttributes.getColor(6, iC2);
                color = typedArrayObtainStyledAttributes.getColor(1, color);
                boolean z4 = typedArrayObtainStyledAttributes.getBoolean(2, true);
                z2 = typedArrayObtainStyledAttributes.getBoolean(4, false);
                boolean z5 = typedArrayObtainStyledAttributes.getBoolean(5, true);
                typedArrayObtainStyledAttributes.recycle();
                z = z5;
                z3 = z4;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z = true;
        }
        setTrackColor(iC2);
        setHandleColor(iM12);
        setBubbleColor(iArgb);
        setBubbleTextColor(color);
        setFadeScrollbar(z3);
        setBubbleVisible(z2);
        setTrackVisible(z);
    }

    public final void h() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && recyclerView.computeVerticalScrollRange() - this.mViewHeight > 0) {
            float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_padding_end);
            View view = this.mScrollbar;
            if (view == null) {
                j.m("mScrollbar");
                throw null;
            }
            view.setTranslationX(dimensionPixelSize);
            View view2 = this.mScrollbar;
            if (view2 == null) {
                j.m("mScrollbar");
                throw null;
            }
            view2.setVisibility(0);
            View view3 = this.mScrollbar;
            if (view3 != null) {
                this.mScrollbarAnimator = view3.animate().translationX(0.0f).alpha(1.0f).setDuration(300L).setListener(new b());
            } else {
                j.m("mScrollbar");
                throw null;
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        this.mViewHeight = h2;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        j.e(event, NotificationCompat.CATEGORY_EVENT);
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y = event.getY();
                    setViewPositions(y);
                    setRecyclerViewPosition(y);
                    return true;
                }
                if (action != 3) {
                    return super.onTouchEvent(event);
                }
            }
            requestDisallowInterceptTouchEvent(false);
            setHandleSelected(false);
            if (this.mFadeScrollbar) {
                getHandler().postDelayed(this.mScrollbarHider, 1000L);
            }
            TextView textView = this.mBubbleView;
            if (textView == null) {
                j.m("mBubbleView");
                throw null;
            }
            if (e(textView)) {
                TextView textView2 = this.mBubbleView;
                if (textView2 == null) {
                    j.m("mBubbleView");
                    throw null;
                }
                this.mBubbleAnimator = textView2.animate().alpha(0.0f).setDuration(100L).setListener(new d(this));
            }
            e.a.a.g.m.p.b.c cVar = this.mFastScrollStateChangeListener;
            if (cVar != null) {
                j.c(cVar);
                cVar.b(this);
            }
            return true;
        }
        float x = event.getX();
        ImageView imageView = this.mHandleView;
        if (imageView == null) {
            j.m("mHandleView");
            throw null;
        }
        float x2 = imageView.getX();
        if (this.mHandleView == null) {
            j.m("mHandleView");
            throw null;
        }
        if (x < x2 - ViewCompat.getPaddingStart(r9)) {
            return false;
        }
        requestDisallowInterceptTouchEvent(true);
        setHandleSelected(true);
        getHandler().removeCallbacks(this.mScrollbarHider);
        b(this.mScrollbarAnimator);
        b(this.mBubbleAnimator);
        View view = this.mScrollbar;
        if (view == null) {
            j.m("mScrollbar");
            throw null;
        }
        if (!e(view)) {
            h();
        }
        if (this.mShowBubble && this.mSectionIndexer != null) {
            TextView textView3 = this.mBubbleView;
            if (textView3 == null) {
                j.m("mBubbleView");
                throw null;
            }
            if (!e(textView3)) {
                TextView textView4 = this.mBubbleView;
                if (textView4 == null) {
                    j.m("mBubbleView");
                    throw null;
                }
                textView4.setVisibility(0);
                TextView textView5 = this.mBubbleView;
                if (textView5 == null) {
                    j.m("mBubbleView");
                    throw null;
                }
                this.mBubbleAnimator = textView5.animate().alpha(1.0f).setDuration(100L).setListener(new e.a.a.g.m.p.b.f());
            }
        }
        e.a.a.g.m.p.b.c cVar2 = this.mFastScrollStateChangeListener;
        if (cVar2 != null) {
            j.c(cVar2);
            cVar2.a(this);
        }
        float y2 = event.getY();
        setViewPositions(y2);
        setRecyclerViewPosition(y2);
        return true;
    }

    public final void setBubbleColor(@ColorInt int color) {
        Drawable drawable;
        this.mBubbleColor = color;
        if (this.mBubbleImage == null && (drawable = ContextCompat.getDrawable(getContext(), R.drawable.fastscroll_bubble)) != null) {
            this.mBubbleImage = DrawableCompat.wrap(drawable);
        }
        Drawable drawable2 = this.mBubbleImage;
        j.c(drawable2);
        DrawableCompat.setTint(drawable2, this.mBubbleColor);
        TextView textView = this.mBubbleView;
        if (textView != null) {
            textView.setBackground(this.mBubbleImage);
        } else {
            j.m("mBubbleView");
            throw null;
        }
    }

    public final void setBubbleTextColor(@ColorInt int color) {
        TextView textView = this.mBubbleView;
        if (textView != null) {
            textView.setTextColor(color);
        } else {
            j.m("mBubbleView");
            throw null;
        }
    }

    public final void setBubbleVisible(boolean visible) {
        this.mShowBubble = visible;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setVisibility(enabled ? 0 : 4);
    }

    public final void setFadeScrollbar(boolean fadeScrollbar) {
        this.mFadeScrollbar = fadeScrollbar;
        View view = this.mScrollbar;
        if (view != null) {
            view.setVisibility(fadeScrollbar ? 4 : 0);
        } else {
            j.m("mScrollbar");
            throw null;
        }
    }

    public final void setFastScrollStateChangeListener(@NotNull e.a.a.g.m.p.b.c fastScrollStateChangeListener) {
        j.e(fastScrollStateChangeListener, "fastScrollStateChangeListener");
        this.mFastScrollStateChangeListener = fastScrollStateChangeListener;
    }

    public final void setHandleColor(@ColorInt int color) {
        Drawable drawable;
        this.mHandleColor = color;
        if (this.mHandleImage == null && (drawable = ContextCompat.getDrawable(getContext(), R.drawable.fastscroll_handle)) != null) {
            this.mHandleImage = DrawableCompat.wrap(drawable);
        }
        Drawable drawable2 = this.mHandleImage;
        j.c(drawable2);
        DrawableCompat.setTint(drawable2, this.mHandleColor);
        ImageView imageView = this.mHandleView;
        if (imageView != null) {
            imageView.setImageDrawable(this.mHandleImage);
        } else {
            j.m("mHandleView");
            throw null;
        }
    }

    @Override // android.view.View
    public void setLayoutParams(@NotNull ViewGroup.LayoutParams params) {
        j.e(params, "params");
        params.width = -2;
        super.setLayoutParams(params);
    }

    public final void setSectionIndexer(@Nullable a sectionIndexer) {
        this.mSectionIndexer = sectionIndexer;
    }

    public final void setTrackColor(@ColorInt int color) {
        Drawable drawable;
        if (this.mTrackImage == null && (drawable = ContextCompat.getDrawable(getContext(), R.drawable.fastscroll_track)) != null) {
            this.mTrackImage = DrawableCompat.wrap(drawable);
        }
        Drawable drawable2 = this.mTrackImage;
        j.c(drawable2);
        DrawableCompat.setTint(drawable2, color);
        ImageView imageView = this.mTrackView;
        if (imageView != null) {
            imageView.setImageDrawable(this.mTrackImage);
        } else {
            j.m("mTrackView");
            throw null;
        }
    }

    public final void setTrackVisible(boolean visible) {
        ImageView imageView = this.mTrackView;
        if (imageView != null) {
            imageView.setVisibility(visible ? 0 : 4);
        } else {
            j.m("mTrackView");
            throw null;
        }
    }

    public final void setLayoutParams(@NotNull ViewGroup viewGroup) {
        j.e(viewGroup, "viewGroup");
        RecyclerView recyclerView = this.mRecyclerView;
        int id = recyclerView == null ? -1 : recyclerView.getId();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_margin_top);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_margin_bottom);
        if (id != -1) {
            if (viewGroup instanceof ConstraintLayout) {
                ConstraintSet constraintSet = new ConstraintSet();
                int id2 = getId();
                ConstraintLayout constraintLayout = (ConstraintLayout) viewGroup;
                constraintSet.clone(constraintLayout);
                constraintSet.connect(id2, 3, id, 3);
                constraintSet.connect(id2, 4, id, 4);
                constraintSet.connect(id2, 7, id, 7);
                constraintSet.applyTo(constraintLayout);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams2);
            } else if (viewGroup instanceof CoordinatorLayout) {
                ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
                Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                CoordinatorLayout.LayoutParams layoutParams4 = (CoordinatorLayout.LayoutParams) layoutParams3;
                layoutParams4.setAnchorId(id);
                layoutParams4.anchorGravity = GravityCompat.END;
                layoutParams4.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams4);
            } else if (viewGroup instanceof FrameLayout) {
                ViewGroup.LayoutParams layoutParams5 = getLayoutParams();
                Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) layoutParams5;
                layoutParams6.gravity = GravityCompat.END;
                layoutParams6.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams6);
            } else if (viewGroup instanceof RelativeLayout) {
                ViewGroup.LayoutParams layoutParams7 = getLayoutParams();
                Objects.requireNonNull(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
                layoutParams8.addRule(6, id);
                layoutParams8.addRule(8, id);
                layoutParams8.addRule(19, id);
                layoutParams8.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize2);
                setLayoutParams(layoutParams8);
            } else {
                throw new IllegalArgumentException("Parent ViewGroup must be a ConstraintLayout, CoordinatorLayout, FrameLayout, or RelativeLayout");
            }
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            TextView textView = this.mBubbleView;
            if (textView != null) {
                textView.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                TextView textView2 = this.mBubbleView;
                if (textView2 != null) {
                    this.mBubbleHeight = textView2.getMeasuredHeight();
                    ImageView imageView = this.mHandleView;
                    if (imageView != null) {
                        imageView.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        ImageView imageView2 = this.mHandleView;
                        if (imageView2 != null) {
                            this.mHandleHeight = imageView2.getMeasuredHeight();
                            return;
                        } else {
                            j.m("mHandleView");
                            throw null;
                        }
                    }
                    j.m("mHandleView");
                    throw null;
                }
                j.m("mBubbleView");
                throw null;
            }
            j.m("mBubbleView");
            throw null;
        }
        throw new IllegalArgumentException("RecyclerView must have a view ID".toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastScroller(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        j.e(context, c.R);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v2, types: [io.legado.app.ui.widget.recycler.scroller.FastScroller$mScrollListener$1] */
    @JvmOverloads
    public FastScroller(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        j.e(context, c.R);
        this.mScrollbarHider = new Runnable() { // from class: e.a.a.g.m.p.b.a
            @Override // java.lang.Runnable
            public final void run() {
                FastScroller fastScroller = this.a;
                int i22 = FastScroller.a;
                j.e(fastScroller, "this$0");
                float dimensionPixelSize = fastScroller.getResources().getDimensionPixelSize(R.dimen.fastscroll_scrollbar_padding_end);
                View view = fastScroller.mScrollbar;
                if (view != null) {
                    fastScroller.mScrollbarAnimator = view.animate().translationX(dimensionPixelSize).alpha(0.0f).setDuration(300L).setListener(new e(fastScroller));
                } else {
                    j.m("mScrollbar");
                    throw null;
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: io.legado.app.ui.widget.recycler.scroller.FastScroller$mScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                j.e(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (this.a.isEnabled()) {
                    if (newState == 0) {
                        FastScroller fastScroller = this.a;
                        if (fastScroller.mFadeScrollbar) {
                            ImageView imageView = fastScroller.mHandleView;
                            if (imageView == null) {
                                j.m("mHandleView");
                                throw null;
                            }
                            if (imageView.isSelected()) {
                                return;
                            }
                            this.a.getHandler().postDelayed(this.a.mScrollbarHider, 1000L);
                            return;
                        }
                        return;
                    }
                    if (newState != 1) {
                        return;
                    }
                    this.a.getHandler().removeCallbacks(this.a.mScrollbarHider);
                    FastScroller fastScroller2 = this.a;
                    fastScroller2.b(fastScroller2.mScrollbarAnimator);
                    FastScroller fastScroller3 = this.a;
                    View view = fastScroller3.mScrollbar;
                    if (view == null) {
                        j.m("mScrollbar");
                        throw null;
                    }
                    if (fastScroller3.e(view)) {
                        return;
                    }
                    this.a.h();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                j.e(recyclerView, "recyclerView");
                ImageView imageView = this.a.mHandleView;
                if (imageView == null) {
                    j.m("mHandleView");
                    throw null;
                }
                if (imageView.isSelected() || !this.a.isEnabled()) {
                    return;
                }
                FastScroller fastScroller = this.a;
                fastScroller.setViewPositions(fastScroller.c(recyclerView));
            }
        };
        g(context, attributeSet);
        LinearLayout.LayoutParams layoutParamsGenerateLayoutParams = generateLayoutParams(attributeSet);
        j.d(layoutParamsGenerateLayoutParams, "generateLayoutParams(attrs)");
        setLayoutParams(layoutParamsGenerateLayoutParams);
    }
}
