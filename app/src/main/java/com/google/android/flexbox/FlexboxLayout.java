package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import c.e.a.a.a;
import c.e.a.a.b;
import c.e.a.a.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FlexboxLayout extends ViewGroup implements a {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Drawable f1914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public Drawable f1915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1917j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1918k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1919l;
    public int[] m;
    public SparseIntArray n;
    public c o;
    public List<b> p;
    public c.b q;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    @Override // c.e.a.a.a
    public void a(View view, int i2, int i3, b bVar) {
        if (p(i2, i3)) {
            if (i()) {
                int i4 = bVar.f825e;
                int i5 = this.f1919l;
                bVar.f825e = i4 + i5;
                bVar.f826f += i5;
                return;
            }
            int i6 = bVar.f825e;
            int i7 = this.f1918k;
            bVar.f825e = i6 + i7;
            bVar.f826f += i7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.n == null) {
            this.n = new SparseIntArray(getChildCount());
        }
        c cVar = this.o;
        SparseIntArray sparseIntArray = this.n;
        int flexItemCount = cVar.a.getFlexItemCount();
        List<c.C0038c> listF = cVar.f(flexItemCount);
        c.C0038c c0038c = new c.C0038c(null);
        if (view == null || !(layoutParams instanceof FlexItem)) {
            c0038c.f838b = 1;
        } else {
            c0038c.f838b = ((FlexItem) layoutParams).getOrder();
        }
        if (i2 == -1 || i2 == flexItemCount || i2 >= cVar.a.getFlexItemCount()) {
            c0038c.a = flexItemCount;
        } else {
            c0038c.a = i2;
            for (int i3 = i2; i3 < flexItemCount; i3++) {
                ((c.C0038c) ((ArrayList) listF).get(i3)).a++;
            }
        }
        ((ArrayList) listF).add(c0038c);
        this.m = cVar.x(flexItemCount + 1, listF, sparseIntArray);
        super.addView(view, i2, layoutParams);
    }

    @Override // c.e.a.a.a
    public void b(b bVar) {
        if (i()) {
            if ((this.f1917j & 4) > 0) {
                int i2 = bVar.f825e;
                int i3 = this.f1919l;
                bVar.f825e = i2 + i3;
                bVar.f826f += i3;
                return;
            }
            return;
        }
        if ((this.f1916i & 4) > 0) {
            int i4 = bVar.f825e;
            int i5 = this.f1918k;
            bVar.f825e = i4 + i5;
            bVar.f826f += i5;
        }
    }

    @Override // c.e.a.a.a
    public View c(int i2) {
        return o(i2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // c.e.a.a.a
    public int d(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // c.e.a.a.a
    public void e(int i2, View view) {
    }

    @Override // c.e.a.a.a
    public View f(int i2) {
        return getChildAt(i2);
    }

    @Override // c.e.a.a.a
    public int g(View view, int i2, int i3) {
        int i4;
        int i5;
        if (i()) {
            i4 = p(i2, i3) ? 0 + this.f1919l : 0;
            if ((this.f1917j & 4) <= 0) {
                return i4;
            }
            i5 = this.f1919l;
        } else {
            i4 = p(i2, i3) ? 0 + this.f1918k : 0;
            if ((this.f1916i & 4) <= 0) {
                return i4;
            }
            i5 = this.f1918k;
        }
        return i4 + i5;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // c.e.a.a.a
    public int getAlignContent() {
        return this.f1912e;
    }

    @Override // c.e.a.a.a
    public int getAlignItems() {
        return this.f1911d;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.f1914g;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.f1915h;
    }

    @Override // c.e.a.a.a
    public int getFlexDirection() {
        return this.a;
    }

    @Override // c.e.a.a.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.p.size());
        for (b bVar : this.p) {
            if (bVar.a() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // c.e.a.a.a
    public List<b> getFlexLinesInternal() {
        return this.p;
    }

    @Override // c.e.a.a.a
    public int getFlexWrap() {
        return this.f1909b;
    }

    public int getJustifyContent() {
        return this.f1910c;
    }

    @Override // c.e.a.a.a
    public int getLargestMainSize() {
        Iterator<b> it = this.p.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f825e);
        }
        return iMax;
    }

    @Override // c.e.a.a.a
    public int getMaxLine() {
        return this.f1913f;
    }

    public int getShowDividerHorizontal() {
        return this.f1916i;
    }

    public int getShowDividerVertical() {
        return this.f1917j;
    }

    @Override // c.e.a.a.a
    public int getSumOfCrossSize() {
        int size = this.p.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.p.get(i3);
            if (q(i3)) {
                i2 += i() ? this.f1918k : this.f1919l;
            }
            if (r(i3)) {
                i2 += i() ? this.f1918k : this.f1919l;
            }
            i2 += bVar.f827g;
        }
        return i2;
    }

    @Override // c.e.a.a.a
    public int h(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // c.e.a.a.a
    public boolean i() {
        int i2 = this.a;
        return i2 == 0 || i2 == 1;
    }

    @Override // c.e.a.a.a
    public int j(View view) {
        return 0;
    }

    public final void k(Canvas canvas, boolean z, boolean z2) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.p.get(i2);
            for (int i3 = 0; i3 < bVar.f828h; i3++) {
                int i4 = bVar.o + i3;
                View viewO = o(i4);
                if (viewO != null && viewO.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewO.getLayoutParams();
                    if (p(i4, i3)) {
                        n(canvas, z ? viewO.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (viewO.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f1919l, bVar.f822b, bVar.f827g);
                    }
                    if (i3 == bVar.f828h - 1 && (this.f1917j & 4) > 0) {
                        n(canvas, z ? (viewO.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f1919l : viewO.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, bVar.f822b, bVar.f827g);
                    }
                }
            }
            if (q(i2)) {
                m(canvas, paddingLeft, z2 ? bVar.f824d : bVar.f822b - this.f1918k, iMax);
            }
            if (r(i2) && (this.f1916i & 4) > 0) {
                m(canvas, paddingLeft, z2 ? bVar.f822b - this.f1918k : bVar.f824d, iMax);
            }
        }
    }

    public final void l(Canvas canvas, boolean z, boolean z2) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.p.get(i2);
            for (int i3 = 0; i3 < bVar.f828h; i3++) {
                int i4 = bVar.o + i3;
                View viewO = o(i4);
                if (viewO != null && viewO.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewO.getLayoutParams();
                    if (p(i4, i3)) {
                        m(canvas, bVar.a, z2 ? viewO.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (viewO.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f1918k, bVar.f827g);
                    }
                    if (i3 == bVar.f828h - 1 && (this.f1916i & 4) > 0) {
                        m(canvas, bVar.a, z2 ? (viewO.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f1918k : viewO.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, bVar.f827g);
                    }
                }
            }
            if (q(i2)) {
                n(canvas, z ? bVar.f823c : bVar.a - this.f1919l, paddingTop, iMax);
            }
            if (r(i2) && (this.f1917j & 4) > 0) {
                n(canvas, z ? bVar.a - this.f1919l : bVar.f823c, paddingTop, iMax);
            }
        }
    }

    public final void m(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f1914g;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i2, i3, i4 + i2, this.f1918k + i3);
        this.f1914g.draw(canvas);
    }

    public final void n(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f1915h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i2, i3, this.f1919l + i2, i4 + i3);
        this.f1915h.draw(canvas);
    }

    public View o(int i2) {
        if (i2 < 0) {
            return null;
        }
        int[] iArr = this.m;
        if (i2 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i2]);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f1915h == null && this.f1914g == null) {
            return;
        }
        if (this.f1916i == 0 && this.f1917j == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i2 = this.a;
        if (i2 == 0) {
            k(canvas, layoutDirection == 1, this.f1909b == 2);
            return;
        }
        if (i2 == 1) {
            k(canvas, layoutDirection != 1, this.f1909b == 2);
            return;
        }
        if (i2 == 2) {
            boolean z = layoutDirection == 1;
            if (this.f1909b == 2) {
                z = !z;
            }
            l(canvas, z, false);
            return;
        }
        if (i2 != 3) {
            return;
        }
        boolean z2 = layoutDirection == 1;
        if (this.f1909b == 2) {
            z2 = !z2;
        }
        l(canvas, z2, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i6 = this.a;
        if (i6 == 0) {
            s(layoutDirection == 1, i2, i3, i4, i5);
            return;
        }
        if (i6 == 1) {
            s(layoutDirection != 1, i2, i3, i4, i5);
            return;
        }
        if (i6 == 2) {
            z2 = layoutDirection == 1;
            if (this.f1909b == 2) {
                z2 = !z2;
            }
            t(z2, false, i2, i3, i4, i5);
            return;
        }
        if (i6 != 3) {
            StringBuilder sbR = c.a.a.a.a.r("Invalid flex direction is set: ");
            sbR.append(this.a);
            throw new IllegalStateException(sbR.toString());
        }
        z2 = layoutDirection == 1;
        if (this.f1909b == 2) {
            z2 = !z2;
        }
        t(z2, true, i2, i3, i4, i5);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        boolean z;
        if (this.n == null) {
            this.n = new SparseIntArray(getChildCount());
        }
        c cVar = this.o;
        SparseIntArray sparseIntArray = this.n;
        int flexItemCount = cVar.a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            z = true;
            break;
        }
        for (int i4 = 0; i4 < flexItemCount; i4++) {
            View viewF = cVar.a.f(i4);
            if (viewF != null && ((FlexItem) viewF.getLayoutParams()).getOrder() != sparseIntArray.get(i4)) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            c cVar2 = this.o;
            SparseIntArray sparseIntArray2 = this.n;
            int flexItemCount2 = cVar2.a.getFlexItemCount();
            this.m = cVar2.x(flexItemCount2, cVar2.f(flexItemCount2), sparseIntArray2);
        }
        int i5 = this.a;
        if (i5 != 0 && i5 != 1) {
            if (i5 != 2 && i5 != 3) {
                StringBuilder sbR = c.a.a.a.a.r("Invalid value for the flex direction is set: ");
                sbR.append(this.a);
                throw new IllegalStateException(sbR.toString());
            }
            this.p.clear();
            this.q.a();
            this.o.b(this.q, i3, i2, Integer.MAX_VALUE, 0, -1, null);
            this.p = this.q.a;
            this.o.h(i2, i3, 0);
            this.o.g(i2, i3, getPaddingRight() + getPaddingLeft());
            this.o.A(0);
            u(this.a, i2, i3, this.q.f837b);
            return;
        }
        this.p.clear();
        this.q.a();
        this.o.b(this.q, i2, i3, Integer.MAX_VALUE, 0, -1, null);
        this.p = this.q.a;
        this.o.h(i2, i3, 0);
        if (this.f1911d == 3) {
            for (b bVar : this.p) {
                int iMax = Integer.MIN_VALUE;
                for (int i6 = 0; i6 < bVar.f828h; i6++) {
                    View viewO = o(bVar.o + i6);
                    if (viewO != null && viewO.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) viewO.getLayoutParams();
                        iMax = this.f1909b != 2 ? Math.max(iMax, viewO.getMeasuredHeight() + Math.max(bVar.f832l - viewO.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, viewO.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max(viewO.getBaseline() + (bVar.f832l - viewO.getMeasuredHeight()), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                bVar.f827g = iMax;
            }
        }
        this.o.g(i2, i3, getPaddingBottom() + getPaddingTop());
        this.o.A(0);
        u(this.a, i2, i3, this.q.f837b);
    }

    public final boolean p(int i2, int i3) {
        boolean z;
        int i4 = 1;
        while (true) {
            if (i4 > i3) {
                z = true;
                break;
            }
            View viewO = o(i2 - i4);
            if (viewO != null && viewO.getVisibility() != 8) {
                z = false;
                break;
            }
            i4++;
        }
        return z ? i() ? (this.f1917j & 1) != 0 : (this.f1916i & 1) != 0 : i() ? (this.f1917j & 2) != 0 : (this.f1916i & 2) != 0;
    }

    public final boolean q(int i2) {
        boolean z;
        if (i2 < 0 || i2 >= this.p.size()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                z = true;
                break;
            }
            if (this.p.get(i3).a() > 0) {
                z = false;
                break;
            }
            i3++;
        }
        return z ? i() ? (this.f1916i & 1) != 0 : (this.f1917j & 1) != 0 : i() ? (this.f1916i & 2) != 0 : (this.f1917j & 2) != 0;
    }

    public final boolean r(int i2) {
        if (i2 < 0 || i2 >= this.p.size()) {
            return false;
        }
        for (int i3 = i2 + 1; i3 < this.p.size(); i3++) {
            if (this.p.get(i3).a() > 0) {
                return false;
            }
        }
        return i() ? (this.f1916i & 4) != 0 : (this.f1917j & 4) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(boolean r26, int r27, int r28, int r29, int r30) {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.s(boolean, int, int, int, int):void");
    }

    public void setAlignContent(int i2) {
        if (this.f1912e != i2) {
            this.f1912e = i2;
            requestLayout();
        }
    }

    public void setAlignItems(int i2) {
        if (this.f1911d != i2) {
            this.f1911d = i2;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.f1914g) {
            return;
        }
        this.f1914g = drawable;
        if (drawable != null) {
            this.f1918k = drawable.getIntrinsicHeight();
        } else {
            this.f1918k = 0;
        }
        if (this.f1914g == null && this.f1915h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.f1915h) {
            return;
        }
        this.f1915h = drawable;
        if (drawable != null) {
            this.f1919l = drawable.getIntrinsicWidth();
        } else {
            this.f1919l = 0;
        }
        if (this.f1914g == null && this.f1915h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
        requestLayout();
    }

    public void setFlexDirection(int i2) {
        if (this.a != i2) {
            this.a = i2;
            requestLayout();
        }
    }

    @Override // c.e.a.a.a
    public void setFlexLines(List<b> list) {
        this.p = list;
    }

    public void setFlexWrap(int i2) {
        if (this.f1909b != i2) {
            this.f1909b = i2;
            requestLayout();
        }
    }

    public void setJustifyContent(int i2) {
        if (this.f1910c != i2) {
            this.f1910c = i2;
            requestLayout();
        }
    }

    public void setMaxLine(int i2) {
        if (this.f1913f != i2) {
            this.f1913f = i2;
            requestLayout();
        }
    }

    public void setShowDivider(int i2) {
        setShowDividerVertical(i2);
        setShowDividerHorizontal(i2);
    }

    public void setShowDividerHorizontal(int i2) {
        if (i2 != this.f1916i) {
            this.f1916i = i2;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i2) {
        if (i2 != this.f1917j) {
            this.f1917j = i2;
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(boolean r28, boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.t(boolean, boolean, int, int, int, int):void");
    }

    public final void u(int i2, int i3, int i4, int i5) {
        int paddingBottom;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (i2 == 0 || i2 == 1) {
            paddingBottom = getPaddingBottom() + getPaddingTop() + getSumOfCrossSize();
            largestMainSize = getLargestMainSize();
        } else {
            if (i2 != 2 && i2 != 3) {
                throw new IllegalArgumentException(c.a.a.a.a.G("Invalid flex direction: ", i2));
            }
            paddingBottom = getLargestMainSize();
            largestMainSize = getPaddingRight() + getPaddingLeft() + getSumOfCrossSize();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i3, i5);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i3, i5);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException(c.a.a.a.a.G("Unknown width mode is set: ", mode));
            }
            if (size < largestMainSize) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i3, i5);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < paddingBottom) {
                i5 = View.combineMeasuredStates(i5, 256);
            } else {
                size2 = paddingBottom;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i4, i5);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(paddingBottom, i4, i5);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException(c.a.a.a.a.G("Unknown height mode is set: ", mode2));
            }
            if (size2 < paddingBottom) {
                i5 = View.combineMeasuredStates(i5, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i4, i5);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1913f = -1;
        this.o = new c(this);
        this.p = new ArrayList();
        this.q = new c.b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout, i2, 0);
        this.a = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexDirection, 0);
        this.f1909b = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexWrap, 0);
        this.f1910c = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_justifyContent, 0);
        this.f1911d = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignItems, 4);
        this.f1912e = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignContent, 5);
        this.f1913f = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDivider, 0);
        if (i3 != 0) {
            this.f1917j = i3;
            this.f1916i = i3;
        }
        int i4 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerVertical, 0);
        if (i4 != 0) {
            this.f1917j = i4;
        }
        int i5 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i5 != 0) {
            this.f1916i = i5;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1922d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f1923e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1924f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1925g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1926h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1927i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f1928j;

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
            this.a = 1;
            this.f1920b = 0.0f;
            this.f1921c = 1.0f;
            this.f1922d = -1;
            this.f1923e = -1.0f;
            this.f1926h = ViewCompat.MEASURED_SIZE_MASK;
            this.f1927i = ViewCompat.MEASURED_SIZE_MASK;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout_Layout);
            this.a = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_order, 1);
            this.f1920b = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.f1921c = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f1922d = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.f1923e = typedArrayObtainStyledAttributes.getFraction(R$styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f1924f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minWidth, 0);
            this.f1925g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minHeight, 0);
            this.f1926h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxWidth, ViewCompat.MEASURED_SIZE_MASK);
            this.f1927i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxHeight, ViewCompat.MEASURED_SIZE_MASK);
            this.f1928j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.flexbox.FlexItem
        public int A() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float B() {
            return this.f1920b;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float D() {
            return this.f1923e;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int G() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int I() {
            return this.f1925g;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean J() {
            return this.f1928j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int K() {
            return this.f1927i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int M() {
            return this.f1926h;
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
            return this.a;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int u() {
            return this.f1922d;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float v() {
            return this.f1921c;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int w() {
            return this.f1924f;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeFloat(this.f1920b);
            parcel.writeFloat(this.f1921c);
            parcel.writeInt(this.f1922d);
            parcel.writeFloat(this.f1923e);
            parcel.writeInt(this.f1924f);
            parcel.writeInt(this.f1925g);
            parcel.writeInt(this.f1926h);
            parcel.writeInt(this.f1927i);
            parcel.writeByte(this.f1928j ? (byte) 1 : (byte) 0);
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

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.a = 1;
            this.f1920b = 0.0f;
            this.f1921c = 1.0f;
            this.f1922d = -1;
            this.f1923e = -1.0f;
            this.f1926h = ViewCompat.MEASURED_SIZE_MASK;
            this.f1927i = ViewCompat.MEASURED_SIZE_MASK;
            this.a = layoutParams.a;
            this.f1920b = layoutParams.f1920b;
            this.f1921c = layoutParams.f1921c;
            this.f1922d = layoutParams.f1922d;
            this.f1923e = layoutParams.f1923e;
            this.f1924f = layoutParams.f1924f;
            this.f1925g = layoutParams.f1925g;
            this.f1926h = layoutParams.f1926h;
            this.f1927i = layoutParams.f1927i;
            this.f1928j = layoutParams.f1928j;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
            this.f1920b = 0.0f;
            this.f1921c = 1.0f;
            this.f1922d = -1;
            this.f1923e = -1.0f;
            this.f1926h = ViewCompat.MEASURED_SIZE_MASK;
            this.f1927i = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
            this.f1920b = 0.0f;
            this.f1921c = 1.0f;
            this.f1922d = -1;
            this.f1923e = -1.0f;
            this.f1926h = ViewCompat.MEASURED_SIZE_MASK;
            this.f1927i = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(Parcel parcel) {
            super(0, 0);
            this.a = 1;
            this.f1920b = 0.0f;
            this.f1921c = 1.0f;
            this.f1922d = -1;
            this.f1923e = -1.0f;
            this.f1926h = ViewCompat.MEASURED_SIZE_MASK;
            this.f1927i = ViewCompat.MEASURED_SIZE_MASK;
            this.a = parcel.readInt();
            this.f1920b = parcel.readFloat();
            this.f1921c = parcel.readFloat();
            this.f1922d = parcel.readInt();
            this.f1923e = parcel.readFloat();
            this.f1924f = parcel.readInt();
            this.f1925g = parcel.readInt();
            this.f1926h = parcel.readInt();
            this.f1927i = parcel.readInt();
            this.f1928j = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
