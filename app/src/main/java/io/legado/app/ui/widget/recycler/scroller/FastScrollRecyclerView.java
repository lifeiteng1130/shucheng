package io.legado.app.ui.widget.recycler.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.ui.widget.recycler.scroller.FastScroller;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FastScrollRecyclerView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b-\u0010.B#\b\u0017\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010/\u001a\u00020\u0007¢\u0006\u0004\b-\u00100J\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\nJ\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u0012J\u0017\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\nJ\u0017\u0010\u001c\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\nJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0014¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0014¢\u0006\u0004\b#\u0010\"J!\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010+¨\u00061"}, d2 = {"Lio/legado/app/ui/widget/recycler/scroller/FastScrollRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lf/v;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "", "visibility", "setVisibility", "(I)V", "Lio/legado/app/ui/widget/recycler/scroller/FastScroller$a;", "sectionIndexer", "setSectionIndexer", "(Lio/legado/app/ui/widget/recycler/scroller/FastScroller$a;)V", "", "enabled", "setFastScrollEnabled", "(Z)V", "hideScrollbar", "setHideScrollbar", "visible", "setTrackVisible", "color", "setTrackColor", "setHandleColor", "setBubbleVisible", "setBubbleColor", "setBubbleTextColor", "Le/a/a/g/m/p/b/c;", "fastScrollStateChangeListener", "setFastScrollStateChangeListener", "(Le/a/a/g/m/p/b/c;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", ai.at, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lio/legado/app/ui/widget/recycler/scroller/FastScroller;", "Lio/legado/app/ui/widget/recycler/scroller/FastScroller;", "mFastScroller", "<init>", "(Landroid/content/Context;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FastScrollRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public FastScroller mFastScroller;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastScrollRecyclerView(@NotNull Context context) {
        super(context);
        j.e(context, c.R);
        a(context, null);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public final void a(Context context, AttributeSet attrs) {
        FastScroller fastScroller = new FastScroller(context, attrs, 0);
        this.mFastScroller = fastScroller;
        fastScroller.setId(R.id.fast_scroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        final FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            j.m("mFastScroller");
            throw null;
        }
        j.e(this, "recyclerView");
        fastScroller.mRecyclerView = this;
        j.c(this);
        addOnScrollListener(fastScroller.mScrollListener);
        fastScroller.post(new Runnable() { // from class: e.a.a.g.m.p.b.b
            @Override // java.lang.Runnable
            public final void run() {
                FastScroller.f(fastScroller);
            }
        });
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            FastScroller fastScroller2 = this.mFastScroller;
            if (fastScroller2 == null) {
                j.m("mFastScroller");
                throw null;
            }
            if (viewGroup.indexOfChild(fastScroller2) == -1) {
                FastScroller fastScroller3 = this.mFastScroller;
                if (fastScroller3 == null) {
                    j.m("mFastScroller");
                    throw null;
                }
                viewGroup.addView(fastScroller3);
                FastScroller fastScroller4 = this.mFastScroller;
                if (fastScroller4 != null) {
                    fastScroller4.setLayoutParams(viewGroup);
                } else {
                    j.m("mFastScroller");
                    throw null;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller == null) {
            j.m("mFastScroller");
            throw null;
        }
        RecyclerView recyclerView = fastScroller.mRecyclerView;
        if (recyclerView != null) {
            j.c(recyclerView);
            recyclerView.removeOnScrollListener(fastScroller.mScrollListener);
            fastScroller.mRecyclerView = null;
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        super.setAdapter(adapter);
        if (adapter instanceof FastScroller.a) {
            setSectionIndexer((FastScroller.a) adapter);
        } else if (adapter == 0) {
            setSectionIndexer(null);
        }
    }

    public final void setBubbleColor(@ColorInt int color) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setBubbleColor(color);
        } else {
            j.m("mFastScroller");
            throw null;
        }
    }

    public final void setBubbleTextColor(@ColorInt int color) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setBubbleTextColor(color);
        } else {
            j.m("mFastScroller");
            throw null;
        }
    }

    public final void setBubbleVisible(boolean visible) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setBubbleVisible(visible);
        } else {
            j.m("mFastScroller");
            throw null;
        }
    }

    public final void setFastScrollEnabled(boolean enabled) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setEnabled(enabled);
        } else {
            j.m("mFastScroller");
            throw null;
        }
    }

    public final void setFastScrollStateChangeListener(@NotNull e.a.a.g.m.p.b.c fastScrollStateChangeListener) {
        j.e(fastScrollStateChangeListener, "fastScrollStateChangeListener");
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setFastScrollStateChangeListener(fastScrollStateChangeListener);
        } else {
            j.m("mFastScroller");
            throw null;
        }
    }

    public final void setHandleColor(@ColorInt int color) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setHandleColor(color);
        } else {
            j.m("mFastScroller");
            throw null;
        }
    }

    public final void setHideScrollbar(boolean hideScrollbar) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setFadeScrollbar(hideScrollbar);
        } else {
            j.m("mFastScroller");
            throw null;
        }
    }

    public final void setSectionIndexer(@Nullable FastScroller.a sectionIndexer) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setSectionIndexer(sectionIndexer);
        } else {
            j.m("mFastScroller");
            throw null;
        }
    }

    public final void setTrackColor(@ColorInt int color) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setTrackColor(color);
        } else {
            j.m("mFastScroller");
            throw null;
        }
    }

    public final void setTrackVisible(boolean visible) {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setTrackVisible(visible);
        } else {
            j.m("mFastScroller");
            throw null;
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setVisibility(visibility);
        } else {
            j.m("mFastScroller");
            throw null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastScrollRecyclerView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastScrollRecyclerView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
        a(context, attributeSet);
    }
}
