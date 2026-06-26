package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.a.c;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements c.e.a.a.a, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final Rect a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1931d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1934g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView.Recycler f1937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView.State f1938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f1939l;
    public OrientationHelper n;
    public OrientationHelper o;
    public SavedState p;
    public final Context v;
    public View w;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1932e = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<c.e.a.a.b> f1935h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c.e.a.a.c f1936i = new c.e.a.a.c(this);
    public b m = new b(null);
    public int q = -1;
    public int r = Integer.MIN_VALUE;
    public int s = Integer.MIN_VALUE;
    public int t = Integer.MIN_VALUE;
    public SparseArray<View> u = new SparseArray<>();
    public int x = -1;
    public c.b y = new c.b();

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1948b;

        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (a) null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("SavedState{mAnchorPosition=");
            sbR.append(this.a);
            sbR.append(", mAnchorOffset=");
            return c.a.a.a.a.n(sbR, this.f1948b, MessageFormatter.DELIM_STOP);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.f1948b);
        }

        public SavedState(Parcel parcel, a aVar) {
            this.a = parcel.readInt();
            this.f1948b = parcel.readInt();
        }

        public SavedState(SavedState savedState, a aVar) {
            this.a = savedState.a;
            this.f1948b = savedState.f1948b;
        }
    }

    public class b {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1951d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1952e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1953f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f1954g;

        public b(a aVar) {
        }

        public static void a(b bVar) {
            if (!FlexboxLayoutManager.this.i()) {
                FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
                if (flexboxLayoutManager.f1933f) {
                    bVar.f1950c = bVar.f1952e ? flexboxLayoutManager.n.getEndAfterPadding() : flexboxLayoutManager.getWidth() - FlexboxLayoutManager.this.n.getStartAfterPadding();
                    return;
                }
            }
            bVar.f1950c = bVar.f1952e ? FlexboxLayoutManager.this.n.getEndAfterPadding() : FlexboxLayoutManager.this.n.getStartAfterPadding();
        }

        public static void b(b bVar) {
            bVar.a = -1;
            bVar.f1949b = -1;
            bVar.f1950c = Integer.MIN_VALUE;
            bVar.f1953f = false;
            bVar.f1954g = false;
            if (FlexboxLayoutManager.this.i()) {
                FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
                int i2 = flexboxLayoutManager.f1930c;
                if (i2 == 0) {
                    bVar.f1952e = flexboxLayoutManager.f1929b == 1;
                    return;
                } else {
                    bVar.f1952e = i2 == 2;
                    return;
                }
            }
            FlexboxLayoutManager flexboxLayoutManager2 = FlexboxLayoutManager.this;
            int i3 = flexboxLayoutManager2.f1930c;
            if (i3 == 0) {
                bVar.f1952e = flexboxLayoutManager2.f1929b == 3;
            } else {
                bVar.f1952e = i3 == 2;
            }
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("AnchorInfo{mPosition=");
            sbR.append(this.a);
            sbR.append(", mFlexLinePosition=");
            sbR.append(this.f1949b);
            sbR.append(", mCoordinate=");
            sbR.append(this.f1950c);
            sbR.append(", mPerpendicularCoordinate=");
            sbR.append(this.f1951d);
            sbR.append(", mLayoutFromEnd=");
            sbR.append(this.f1952e);
            sbR.append(", mValid=");
            sbR.append(this.f1953f);
            sbR.append(", mAssignedFromSavedState=");
            sbR.append(this.f1954g);
            sbR.append(MessageFormatter.DELIM_STOP);
            return sbR.toString();
        }
    }

    public static class c {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1959e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1960f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1961g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1962h = 1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1963i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f1964j;

        public c(a aVar) {
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("LayoutState{mAvailable=");
            sbR.append(this.a);
            sbR.append(", mFlexLinePosition=");
            sbR.append(this.f1957c);
            sbR.append(", mPosition=");
            sbR.append(this.f1958d);
            sbR.append(", mOffset=");
            sbR.append(this.f1959e);
            sbR.append(", mScrollingOffset=");
            sbR.append(this.f1960f);
            sbR.append(", mLastScrollDelta=");
            sbR.append(this.f1961g);
            sbR.append(", mItemDirection=");
            sbR.append(this.f1962h);
            sbR.append(", mLayoutDirection=");
            return c.a.a.a.a.n(sbR, this.f1963i, MessageFormatter.DELIM_STOP);
        }
    }

    public FlexboxLayoutManager(Context context) {
        x(0);
        y(1);
        if (this.f1931d != 4) {
            removeAllViews();
            k();
            this.f1931d = 4;
            requestLayout();
        }
        setAutoMeasureEnabled(true);
        this.v = context;
    }

    public static boolean isMeasurementUpToDate(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (i4 > 0 && i2 != i4) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i2;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i2;
        }
        return true;
    }

    private boolean shouldMeasureChild(View view, int i2, int i3, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    public final void A(b bVar, boolean z, boolean z2) {
        int i2;
        if (z2) {
            w();
        } else {
            this.f1939l.f1956b = false;
        }
        if (i() || !this.f1933f) {
            this.f1939l.a = this.n.getEndAfterPadding() - bVar.f1950c;
        } else {
            this.f1939l.a = bVar.f1950c - getPaddingRight();
        }
        c cVar = this.f1939l;
        cVar.f1958d = bVar.a;
        cVar.f1962h = 1;
        cVar.f1963i = 1;
        cVar.f1959e = bVar.f1950c;
        cVar.f1960f = Integer.MIN_VALUE;
        cVar.f1957c = bVar.f1949b;
        if (!z || this.f1935h.size() <= 1 || (i2 = bVar.f1949b) < 0 || i2 >= this.f1935h.size() - 1) {
            return;
        }
        c.e.a.a.b bVar2 = this.f1935h.get(bVar.f1949b);
        c cVar2 = this.f1939l;
        cVar2.f1957c++;
        cVar2.f1958d += bVar2.f828h;
    }

    public final void B(b bVar, boolean z, boolean z2) {
        if (z2) {
            w();
        } else {
            this.f1939l.f1956b = false;
        }
        if (i() || !this.f1933f) {
            this.f1939l.a = bVar.f1950c - this.n.getStartAfterPadding();
        } else {
            this.f1939l.a = (this.w.getWidth() - bVar.f1950c) - this.n.getStartAfterPadding();
        }
        c cVar = this.f1939l;
        cVar.f1958d = bVar.a;
        cVar.f1962h = 1;
        cVar.f1963i = -1;
        cVar.f1959e = bVar.f1950c;
        cVar.f1960f = Integer.MIN_VALUE;
        int i2 = bVar.f1949b;
        cVar.f1957c = i2;
        if (!z || i2 <= 0) {
            return;
        }
        int size = this.f1935h.size();
        int i3 = bVar.f1949b;
        if (size > i3) {
            c.e.a.a.b bVar2 = this.f1935h.get(i3);
            r4.f1957c--;
            this.f1939l.f1958d -= bVar2.f828h;
        }
    }

    @Override // c.e.a.a.a
    public void a(View view, int i2, int i3, c.e.a.a.b bVar) {
        calculateItemDecorationsForChild(view, a);
        if (i()) {
            int rightDecorationWidth = getRightDecorationWidth(view) + getLeftDecorationWidth(view);
            bVar.f825e += rightDecorationWidth;
            bVar.f826f += rightDecorationWidth;
            return;
        }
        int bottomDecorationHeight = getBottomDecorationHeight(view) + getTopDecorationHeight(view);
        bVar.f825e += bottomDecorationHeight;
        bVar.f826f += bottomDecorationHeight;
    }

    @Override // c.e.a.a.a
    public void b(c.e.a.a.b bVar) {
    }

    @Override // c.e.a.a.a
    public View c(int i2) {
        return f(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return !i() || getWidth() > this.w.getWidth();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return i() || getHeight() > this.w.getHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        l();
        View viewN = n(itemCount);
        View viewP = p(itemCount);
        if (state.getItemCount() == 0 || viewN == null || viewP == null) {
            return 0;
        }
        return Math.min(this.n.getTotalSpace(), this.n.getDecoratedEnd(viewP) - this.n.getDecoratedStart(viewN));
    }

    public final int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewN = n(itemCount);
        View viewP = p(itemCount);
        if (state.getItemCount() != 0 && viewN != null && viewP != null) {
            int position = getPosition(viewN);
            int position2 = getPosition(viewP);
            int iAbs = Math.abs(this.n.getDecoratedEnd(viewP) - this.n.getDecoratedStart(viewN));
            int i2 = this.f1936i.f834c[position];
            if (i2 != 0 && i2 != -1) {
                return Math.round((i2 * (iAbs / ((r4[position2] - i2) + 1))) + (this.n.getStartAfterPadding() - this.n.getDecoratedStart(viewN)));
            }
        }
        return 0;
    }

    public final int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewN = n(itemCount);
        View viewP = p(itemCount);
        if (state.getItemCount() == 0 || viewN == null || viewP == null) {
            return 0;
        }
        return (int) ((Math.abs(this.n.getDecoratedEnd(viewP) - this.n.getDecoratedStart(viewN)) / ((findLastVisibleItemPosition() - (r(0, getChildCount(), false) == null ? -1 : getPosition(r1))) + 1)) * state.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i2) {
        if (getChildCount() == 0) {
            return null;
        }
        int i3 = i2 < getPosition(getChildAt(0)) ? -1 : 1;
        return i() ? new PointF(0.0f, i3) : new PointF(i3, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // c.e.a.a.a
    public int d(int i2, int i3, int i4) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i3, i4, canScrollHorizontally());
    }

    @Override // c.e.a.a.a
    public void e(int i2, View view) {
        this.u.put(i2, view);
    }

    @Override // c.e.a.a.a
    public View f(int i2) {
        View view = this.u.get(i2);
        return view != null ? view : this.f1937j.getViewForPosition(i2);
    }

    public int findLastVisibleItemPosition() {
        View viewR = r(getChildCount() - 1, -1, false);
        if (viewR == null) {
            return -1;
        }
        return getPosition(viewR);
    }

    public final int fixLayoutEndGap(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iT;
        int endAfterPadding;
        if (!i() && this.f1933f) {
            int startAfterPadding = i2 - this.n.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            iT = t(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.n.getEndAfterPadding() - i2;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            iT = -t(-endAfterPadding2, recycler, state);
        }
        int i3 = i2 + iT;
        if (!z || (endAfterPadding = this.n.getEndAfterPadding() - i3) <= 0) {
            return iT;
        }
        this.n.offsetChildren(endAfterPadding);
        return endAfterPadding + iT;
    }

    public final int fixLayoutStartGap(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iT;
        int startAfterPadding;
        if (i() || !this.f1933f) {
            int startAfterPadding2 = i2 - this.n.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            iT = -t(startAfterPadding2, recycler, state);
        } else {
            int endAfterPadding = this.n.getEndAfterPadding() - i2;
            if (endAfterPadding <= 0) {
                return 0;
            }
            iT = t(-endAfterPadding, recycler, state);
        }
        int i3 = i2 + iT;
        if (!z || (startAfterPadding = i3 - this.n.getStartAfterPadding()) <= 0) {
            return iT;
        }
        this.n.offsetChildren(-startAfterPadding);
        return iT - startAfterPadding;
    }

    @Override // c.e.a.a.a
    public int g(View view, int i2, int i3) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (i()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return bottomDecorationHeight + topDecorationHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // c.e.a.a.a
    public int getAlignContent() {
        return 5;
    }

    @Override // c.e.a.a.a
    public int getAlignItems() {
        return this.f1931d;
    }

    @Override // c.e.a.a.a
    public int getFlexDirection() {
        return this.f1929b;
    }

    @Override // c.e.a.a.a
    public int getFlexItemCount() {
        return this.f1938k.getItemCount();
    }

    @Override // c.e.a.a.a
    public List<c.e.a.a.b> getFlexLinesInternal() {
        return this.f1935h;
    }

    @Override // c.e.a.a.a
    public int getFlexWrap() {
        return this.f1930c;
    }

    @Override // c.e.a.a.a
    public int getLargestMainSize() {
        if (this.f1935h.size() == 0) {
            return 0;
        }
        int iMax = Integer.MIN_VALUE;
        int size = this.f1935h.size();
        for (int i2 = 0; i2 < size; i2++) {
            iMax = Math.max(iMax, this.f1935h.get(i2).f825e);
        }
        return iMax;
    }

    @Override // c.e.a.a.a
    public int getMaxLine() {
        return this.f1932e;
    }

    @Override // c.e.a.a.a
    public int getSumOfCrossSize() {
        int size = this.f1935h.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.f1935h.get(i3).f827g;
        }
        return i2;
    }

    @Override // c.e.a.a.a
    public int h(int i2, int i3, int i4) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i3, i4, canScrollVertically());
    }

    @Override // c.e.a.a.a
    public boolean i() {
        int i2 = this.f1929b;
        return i2 == 0 || i2 == 1;
    }

    @Override // c.e.a.a.a
    public int j(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (i()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return rightDecorationWidth + leftDecorationWidth;
    }

    public final void k() {
        this.f1935h.clear();
        b.b(this.m);
        this.m.f1951d = 0;
    }

    public final void l() {
        if (this.n != null) {
            return;
        }
        if (i()) {
            if (this.f1930c == 0) {
                this.n = OrientationHelper.createHorizontalHelper(this);
                this.o = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.n = OrientationHelper.createVerticalHelper(this);
                this.o = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.f1930c == 0) {
            this.n = OrientationHelper.createVerticalHelper(this);
            this.o = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.n = OrientationHelper.createHorizontalHelper(this);
            this.o = OrientationHelper.createVerticalHelper(this);
        }
    }

    public final int m(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = cVar.f1960f;
        if (i17 != Integer.MIN_VALUE) {
            int i18 = cVar.a;
            if (i18 < 0) {
                cVar.f1960f = i17 + i18;
            }
            v(recycler, cVar);
        }
        int i19 = cVar.a;
        boolean zI = i();
        int i20 = i19;
        int i21 = 0;
        while (true) {
            if (i20 <= 0 && !this.f1939l.f1956b) {
                break;
            }
            List<c.e.a.a.b> list = this.f1935h;
            int i22 = cVar.f1958d;
            if (!(i22 >= 0 && i22 < state.getItemCount() && (i16 = cVar.f1957c) >= 0 && i16 < list.size())) {
                break;
            }
            c.e.a.a.b bVar = this.f1935h.get(cVar.f1957c);
            cVar.f1958d = bVar.o;
            if (i()) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int width = getWidth();
                int i23 = cVar.f1959e;
                if (cVar.f1963i == -1) {
                    i23 -= bVar.f827g;
                }
                int i24 = cVar.f1958d;
                float f2 = width - paddingRight;
                float f3 = this.m.f1951d;
                float rightDecorationWidth = paddingLeft - f3;
                float leftDecorationWidth = f2 - f3;
                float fMax = Math.max(0.0f, 0.0f);
                int i25 = bVar.f828h;
                int i26 = i24;
                int i27 = 0;
                while (i26 < i24 + i25) {
                    View viewF = f(i26);
                    if (viewF == null) {
                        i13 = i19;
                        i12 = i24;
                        i14 = i26;
                        i15 = i25;
                    } else {
                        i12 = i24;
                        int i28 = i25;
                        if (cVar.f1963i == 1) {
                            calculateItemDecorationsForChild(viewF, a);
                            addView(viewF);
                        } else {
                            calculateItemDecorationsForChild(viewF, a);
                            addView(viewF, i27);
                            i27++;
                        }
                        int i29 = i27;
                        c.e.a.a.c cVar2 = this.f1936i;
                        i13 = i19;
                        long j2 = cVar2.f835d[i26];
                        int i30 = (int) j2;
                        int iM = cVar2.m(j2);
                        if (shouldMeasureChild(viewF, i30, iM, (LayoutParams) viewF.getLayoutParams())) {
                            viewF.measure(i30, iM);
                        }
                        float leftDecorationWidth2 = rightDecorationWidth + getLeftDecorationWidth(viewF) + ((ViewGroup.MarginLayoutParams) r4).leftMargin;
                        float rightDecorationWidth2 = leftDecorationWidth - (getRightDecorationWidth(viewF) + ((ViewGroup.MarginLayoutParams) r4).rightMargin);
                        int topDecorationHeight = getTopDecorationHeight(viewF) + i23;
                        if (this.f1933f) {
                            i14 = i26;
                            i15 = i28;
                            this.f1936i.u(viewF, bVar, Math.round(rightDecorationWidth2) - viewF.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth2), viewF.getMeasuredHeight() + topDecorationHeight);
                        } else {
                            i14 = i26;
                            i15 = i28;
                            this.f1936i.u(viewF, bVar, Math.round(leftDecorationWidth2), topDecorationHeight, viewF.getMeasuredWidth() + Math.round(leftDecorationWidth2), viewF.getMeasuredHeight() + topDecorationHeight);
                        }
                        leftDecorationWidth = rightDecorationWidth2 - ((getLeftDecorationWidth(viewF) + (viewF.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r4).leftMargin)) + fMax);
                        rightDecorationWidth = getRightDecorationWidth(viewF) + viewF.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r4).rightMargin + fMax + leftDecorationWidth2;
                        i27 = i29;
                    }
                    i26 = i14 + 1;
                    i24 = i12;
                    i19 = i13;
                    i25 = i15;
                }
                i2 = i19;
                cVar.f1957c += this.f1939l.f1963i;
                i6 = bVar.f827g;
                i4 = i20;
                i5 = i21;
            } else {
                i2 = i19;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i31 = cVar.f1959e;
                if (cVar.f1963i == -1) {
                    int i32 = bVar.f827g;
                    int i33 = i31 - i32;
                    i3 = i31 + i32;
                    i31 = i33;
                } else {
                    i3 = i31;
                }
                int i34 = cVar.f1958d;
                float f4 = height - paddingBottom;
                float f5 = this.m.f1951d;
                float bottomDecorationHeight = paddingTop - f5;
                float topDecorationHeight2 = f4 - f5;
                float fMax2 = Math.max(0.0f, 0.0f);
                int i35 = bVar.f828h;
                int i36 = i34;
                int i37 = 0;
                while (i36 < i34 + i35) {
                    View viewF2 = f(i36);
                    if (viewF2 == null) {
                        i7 = i20;
                        i8 = i21;
                        i9 = i36;
                        i10 = i35;
                        i11 = i34;
                    } else {
                        int i38 = i35;
                        c.e.a.a.c cVar3 = this.f1936i;
                        int i39 = i34;
                        i7 = i20;
                        i8 = i21;
                        long j3 = cVar3.f835d[i36];
                        int i40 = (int) j3;
                        int iM2 = cVar3.m(j3);
                        if (shouldMeasureChild(viewF2, i40, iM2, (LayoutParams) viewF2.getLayoutParams())) {
                            viewF2.measure(i40, iM2);
                        }
                        float topDecorationHeight3 = bottomDecorationHeight + getTopDecorationHeight(viewF2) + ((ViewGroup.MarginLayoutParams) r8).topMargin;
                        float bottomDecorationHeight2 = topDecorationHeight2 - (getBottomDecorationHeight(viewF2) + ((ViewGroup.MarginLayoutParams) r8).rightMargin);
                        if (cVar.f1963i == 1) {
                            calculateItemDecorationsForChild(viewF2, a);
                            addView(viewF2);
                        } else {
                            calculateItemDecorationsForChild(viewF2, a);
                            addView(viewF2, i37);
                            i37++;
                        }
                        int i41 = i37;
                        int leftDecorationWidth3 = getLeftDecorationWidth(viewF2) + i31;
                        int rightDecorationWidth3 = i3 - getRightDecorationWidth(viewF2);
                        boolean z = this.f1933f;
                        if (!z) {
                            i9 = i36;
                            i10 = i38;
                            i11 = i39;
                            if (this.f1934g) {
                                this.f1936i.v(viewF2, bVar, z, leftDecorationWidth3, Math.round(bottomDecorationHeight2) - viewF2.getMeasuredHeight(), viewF2.getMeasuredWidth() + leftDecorationWidth3, Math.round(bottomDecorationHeight2));
                            } else {
                                this.f1936i.v(viewF2, bVar, z, leftDecorationWidth3, Math.round(topDecorationHeight3), viewF2.getMeasuredWidth() + leftDecorationWidth3, viewF2.getMeasuredHeight() + Math.round(topDecorationHeight3));
                            }
                        } else if (this.f1934g) {
                            i9 = i36;
                            i10 = i38;
                            i11 = i39;
                            this.f1936i.v(viewF2, bVar, z, rightDecorationWidth3 - viewF2.getMeasuredWidth(), Math.round(bottomDecorationHeight2) - viewF2.getMeasuredHeight(), rightDecorationWidth3, Math.round(bottomDecorationHeight2));
                        } else {
                            i9 = i36;
                            i10 = i38;
                            i11 = i39;
                            this.f1936i.v(viewF2, bVar, z, rightDecorationWidth3 - viewF2.getMeasuredWidth(), Math.round(topDecorationHeight3), rightDecorationWidth3, viewF2.getMeasuredHeight() + Math.round(topDecorationHeight3));
                        }
                        topDecorationHeight2 = bottomDecorationHeight2 - ((getTopDecorationHeight(viewF2) + (viewF2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r8).bottomMargin)) + fMax2);
                        bottomDecorationHeight = getBottomDecorationHeight(viewF2) + viewF2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r8).topMargin + fMax2 + topDecorationHeight3;
                        i37 = i41;
                    }
                    i36 = i9 + 1;
                    i20 = i7;
                    i21 = i8;
                    i35 = i10;
                    i34 = i11;
                }
                i4 = i20;
                i5 = i21;
                cVar.f1957c += this.f1939l.f1963i;
                i6 = bVar.f827g;
            }
            i21 = i5 + i6;
            if (zI || !this.f1933f) {
                cVar.f1959e = (bVar.f827g * cVar.f1963i) + cVar.f1959e;
            } else {
                cVar.f1959e -= bVar.f827g * cVar.f1963i;
            }
            i20 = i4 - bVar.f827g;
            i19 = i2;
        }
        int i42 = i19;
        int i43 = i21;
        int i44 = cVar.a - i43;
        cVar.a = i44;
        int i45 = cVar.f1960f;
        if (i45 != Integer.MIN_VALUE) {
            int i46 = i45 + i43;
            cVar.f1960f = i46;
            if (i44 < 0) {
                cVar.f1960f = i46 + i44;
            }
            v(recycler, cVar);
        }
        return i42 - cVar.a;
    }

    public final View n(int i2) {
        View viewS = s(0, getChildCount(), i2);
        if (viewS == null) {
            return null;
        }
        int i3 = this.f1936i.f834c[getPosition(viewS)];
        if (i3 == -1) {
            return null;
        }
        return o(viewS, this.f1935h.get(i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View o(android.view.View r6, c.e.a.a.b r7) {
        /*
            r5 = this;
            boolean r0 = r5.i()
            int r7 = r7.f828h
            r1 = 1
        L7:
            if (r1 >= r7) goto L3f
            android.view.View r2 = r5.getChildAt(r1)
            if (r2 == 0) goto L3c
            int r3 = r2.getVisibility()
            r4 = 8
            if (r3 != r4) goto L18
            goto L3c
        L18:
            boolean r3 = r5.f1933f
            if (r3 == 0) goto L2d
            if (r0 != 0) goto L2d
            androidx.recyclerview.widget.OrientationHelper r3 = r5.n
            int r3 = r3.getDecoratedEnd(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.n
            int r4 = r4.getDecoratedEnd(r2)
            if (r3 >= r4) goto L3c
            goto L3b
        L2d:
            androidx.recyclerview.widget.OrientationHelper r3 = r5.n
            int r3 = r3.getDecoratedStart(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.n
            int r4 = r4.getDecoratedStart(r2)
            if (r3 <= r4) goto L3c
        L3b:
            r6 = r2
        L3c:
            int r1 = r1 + 1
            goto L7
        L3f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.o(android.view.View, c.e.a.a.b):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.w = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.onItemsAdded(recyclerView, i2, i3);
        z(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i2, int i3, int i4) {
        super.onItemsMoved(recyclerView, i2, i3, i4);
        z(Math.min(i2, i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.onItemsRemoved(recyclerView, i2, i3);
        z(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i2, int i3, Object obj) {
        super.onItemsUpdated(recyclerView, i2, i3, obj);
        z(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0100  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r20, androidx.recyclerview.widget.RecyclerView.State r21) {
        /*
            Method dump skipped, instruction units count: 1157
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.p = null;
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.x = -1;
        b.b(this.m);
        this.u.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.p = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.p;
        if (savedState != null) {
            return new SavedState(savedState, (a) null);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            savedState2.a = getPosition(childAt);
            savedState2.f1948b = this.n.getDecoratedStart(childAt) - this.n.getStartAfterPadding();
        } else {
            savedState2.a = -1;
        }
        return savedState2;
    }

    public final View p(int i2) {
        View viewS = s(getChildCount() - 1, -1, i2);
        if (viewS == null) {
            return null;
        }
        return q(viewS, this.f1935h.get(this.f1936i.f834c[getPosition(viewS)]));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View q(android.view.View r6, c.e.a.a.b r7) {
        /*
            r5 = this;
            boolean r0 = r5.i()
            int r1 = r5.getChildCount()
            int r1 = r1 + (-2)
            int r2 = r5.getChildCount()
            int r7 = r7.f828h
            int r2 = r2 - r7
            int r2 = r2 + (-1)
        L13:
            if (r1 <= r2) goto L4b
            android.view.View r7 = r5.getChildAt(r1)
            if (r7 == 0) goto L48
            int r3 = r7.getVisibility()
            r4 = 8
            if (r3 != r4) goto L24
            goto L48
        L24:
            boolean r3 = r5.f1933f
            if (r3 == 0) goto L39
            if (r0 != 0) goto L39
            androidx.recyclerview.widget.OrientationHelper r3 = r5.n
            int r3 = r3.getDecoratedStart(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.n
            int r4 = r4.getDecoratedStart(r7)
            if (r3 <= r4) goto L48
            goto L47
        L39:
            androidx.recyclerview.widget.OrientationHelper r3 = r5.n
            int r3 = r3.getDecoratedEnd(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.n
            int r4 = r4.getDecoratedEnd(r7)
            if (r3 >= r4) goto L48
        L47:
            r6 = r7
        L48:
            int r1 = r1 + (-1)
            goto L13
        L4b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.q(android.view.View, c.e.a.a.b):android.view.View");
    }

    public final View r(int i2, int i3, boolean z) {
        int i4 = i2;
        int i5 = i3 > i4 ? 1 : -1;
        while (i4 != i3) {
            View childAt = getChildAt(i4);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int decoratedLeft = getDecoratedLeft(childAt) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).leftMargin;
            int decoratedTop = getDecoratedTop(childAt) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).topMargin;
            int decoratedRight = getDecoratedRight(childAt) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
            int decoratedBottom = getDecoratedBottom(childAt) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            boolean z2 = false;
            boolean z3 = paddingLeft <= decoratedLeft && width >= decoratedRight;
            boolean z4 = decoratedLeft >= width || decoratedRight >= paddingLeft;
            boolean z5 = paddingTop <= decoratedTop && height >= decoratedBottom;
            boolean z6 = decoratedTop >= height || decoratedBottom >= paddingTop;
            if (!z ? !(!z4 || !z6) : !(!z3 || !z5)) {
                z2 = true;
            }
            if (z2) {
                return childAt;
            }
            i4 += i5;
        }
        return null;
    }

    public final View s(int i2, int i3, int i4) {
        l();
        View view = null;
        if (this.f1939l == null) {
            this.f1939l = new c(null);
        }
        int startAfterPadding = this.n.getStartAfterPadding();
        int endAfterPadding = this.n.getEndAfterPadding();
        int i5 = i3 > i2 ? 1 : -1;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.n.getDecoratedStart(childAt) >= startAfterPadding && this.n.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!i()) {
            int iT = t(i2, recycler, state);
            this.u.clear();
            return iT;
        }
        int iU = u(i2);
        this.m.f1951d += iU;
        this.o.offsetChildren(-iU);
        return iU;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i2) {
        this.q = i2;
        this.r = Integer.MIN_VALUE;
        SavedState savedState = this.p;
        if (savedState != null) {
            savedState.a = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (i()) {
            int iT = t(i2, recycler, state);
            this.u.clear();
            return iT;
        }
        int iU = u(i2);
        this.m.f1951d += iU;
        this.o.offsetChildren(-iU);
        return iU;
    }

    @Override // c.e.a.a.a
    public void setFlexLines(List<c.e.a.a.b> list) {
        this.f1935h = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i2);
        startSmoothScroll(linearSmoothScroller);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int t(int r19, androidx.recyclerview.widget.RecyclerView.Recycler r20, androidx.recyclerview.widget.RecyclerView.State r21) {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.t(int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):int");
    }

    public final int u(int i2) {
        int i3;
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        l();
        boolean zI = i();
        View view = this.w;
        int width = zI ? view.getWidth() : view.getHeight();
        int width2 = zI ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(i2);
            if (i2 < 0) {
                return -Math.min((width2 + this.m.f1951d) - width, iAbs);
            }
            i3 = this.m.f1951d;
            if (i3 + i2 <= 0) {
                return i2;
            }
        } else {
            if (i2 > 0) {
                return Math.min((width2 - this.m.f1951d) - width, i2);
            }
            i3 = this.m.f1951d;
            if (i3 + i2 >= 0) {
                return i2;
            }
        }
        return -i3;
    }

    public final void v(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        if (cVar.f1964j) {
            int i2 = -1;
            if (cVar.f1963i != -1) {
                if (cVar.f1960f >= 0 && (childCount = getChildCount()) != 0) {
                    int i3 = this.f1936i.f834c[getPosition(getChildAt(0))];
                    if (i3 == -1) {
                        return;
                    }
                    c.e.a.a.b bVar = this.f1935h.get(i3);
                    int i4 = 0;
                    while (true) {
                        if (i4 >= childCount) {
                            break;
                        }
                        View childAt = getChildAt(i4);
                        int i5 = cVar.f1960f;
                        if (!(i() || !this.f1933f ? this.n.getDecoratedEnd(childAt) <= i5 : this.n.getEnd() - this.n.getDecoratedStart(childAt) <= i5)) {
                            break;
                        }
                        if (bVar.p == getPosition(childAt)) {
                            if (i3 >= this.f1935h.size() - 1) {
                                i2 = i4;
                                break;
                            } else {
                                i3 += cVar.f1963i;
                                bVar = this.f1935h.get(i3);
                                i2 = i4;
                            }
                        }
                        i4++;
                    }
                    while (i2 >= 0) {
                        removeAndRecycleViewAt(i2, recycler);
                        i2--;
                    }
                    return;
                }
                return;
            }
            if (cVar.f1960f < 0) {
                return;
            }
            this.n.getEnd();
            int childCount2 = getChildCount();
            if (childCount2 == 0) {
                return;
            }
            int i6 = childCount2 - 1;
            int i7 = this.f1936i.f834c[getPosition(getChildAt(i6))];
            if (i7 == -1) {
                return;
            }
            c.e.a.a.b bVar2 = this.f1935h.get(i7);
            int i8 = i6;
            while (true) {
                if (i8 < 0) {
                    break;
                }
                View childAt2 = getChildAt(i8);
                int i9 = cVar.f1960f;
                if (!(i() || !this.f1933f ? this.n.getDecoratedStart(childAt2) >= this.n.getEnd() - i9 : this.n.getDecoratedEnd(childAt2) <= i9)) {
                    break;
                }
                if (bVar2.o == getPosition(childAt2)) {
                    if (i7 <= 0) {
                        childCount2 = i8;
                        break;
                    } else {
                        i7 += cVar.f1963i;
                        bVar2 = this.f1935h.get(i7);
                        childCount2 = i8;
                    }
                }
                i8--;
            }
            while (i6 >= childCount2) {
                removeAndRecycleViewAt(i6, recycler);
                i6--;
            }
        }
    }

    public final void w() {
        int heightMode = i() ? getHeightMode() : getWidthMode();
        this.f1939l.f1956b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    public void x(int i2) {
        if (this.f1929b != i2) {
            removeAllViews();
            this.f1929b = i2;
            this.n = null;
            this.o = null;
            k();
            requestLayout();
        }
    }

    public void y(int i2) {
        if (i2 == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i3 = this.f1930c;
        if (i3 != i2) {
            if (i3 == 0 || i2 == 0) {
                removeAllViews();
                k();
            }
            this.f1930c = i2;
            this.n = null;
            this.o = null;
            requestLayout();
        }
    }

    public final void z(int i2) {
        if (i2 >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.f1936i.j(childCount);
        this.f1936i.k(childCount);
        this.f1936i.i(childCount);
        if (i2 >= this.f1936i.f834c.length) {
            return;
        }
        this.x = i2;
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        this.q = getPosition(childAt);
        if (i() || !this.f1933f) {
            this.r = this.n.getDecoratedStart(childAt) - this.n.getStartAfterPadding();
        } else {
            this.r = this.n.getEndPadding() + this.n.getDecoratedEnd(childAt);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.onItemsUpdated(recyclerView, i2, i3);
        z(i2);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        public float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1942d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1943e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1944f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1945g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1946h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f1947i;

        public static class a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int i2) {
                return new LayoutParams[i2];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0.0f;
            this.f1940b = 1.0f;
            this.f1941c = -1;
            this.f1942d = -1.0f;
            this.f1945g = ViewCompat.MEASURED_SIZE_MASK;
            this.f1946h = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int A() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float B() {
            return this.a;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float D() {
            return this.f1942d;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int G() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int I() {
            return this.f1944f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean J() {
            return this.f1947i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int K() {
            return this.f1946h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int M() {
            return this.f1945g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int u() {
            return this.f1941c;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float v() {
            return this.f1940b;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int w() {
            return this.f1943e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.f1940b);
            parcel.writeInt(this.f1941c);
            parcel.writeFloat(this.f1942d);
            parcel.writeInt(this.f1943e);
            parcel.writeInt(this.f1944f);
            parcel.writeInt(this.f1945g);
            parcel.writeInt(this.f1946h);
            parcel.writeByte(this.f1947i ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        public int x() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int y() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.a = 0.0f;
            this.f1940b = 1.0f;
            this.f1941c = -1;
            this.f1942d = -1.0f;
            this.f1945g = ViewCompat.MEASURED_SIZE_MASK;
            this.f1946h = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.a = 0.0f;
            this.f1940b = 1.0f;
            this.f1941c = -1;
            this.f1942d = -1.0f;
            this.f1945g = ViewCompat.MEASURED_SIZE_MASK;
            this.f1946h = ViewCompat.MEASURED_SIZE_MASK;
            this.a = parcel.readFloat();
            this.f1940b = parcel.readFloat();
            this.f1941c = parcel.readInt();
            this.f1942d = parcel.readFloat();
            this.f1943e = parcel.readInt();
            this.f1944f = parcel.readInt();
            this.f1945g = parcel.readInt();
            this.f1946h = parcel.readInt();
            this.f1947i = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i2, i3);
        int i4 = properties.orientation;
        if (i4 != 0) {
            if (i4 == 1) {
                if (properties.reverseLayout) {
                    x(3);
                } else {
                    x(2);
                }
            }
        } else if (properties.reverseLayout) {
            x(1);
        } else {
            x(0);
        }
        y(1);
        if (this.f1931d != 4) {
            removeAllViews();
            k();
            this.f1931d = 4;
            requestLayout();
        }
        setAutoMeasureEnabled(true);
        this.v = context;
    }
}
