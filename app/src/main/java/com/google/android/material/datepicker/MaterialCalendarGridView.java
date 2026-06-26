package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;
import c.e.a.b.l.b;
import c.e.a.b.l.l;
import c.e.a.b.l.o;
import c.e.a.b.l.u;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {
    public final Calendar a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2196b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.a = u.i();
        if (MaterialDatePicker.O(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.f2196b = MaterialDatePicker.P(getContext(), R$attr.nestedScrollable);
        ViewCompat.setAccessibilityDelegate(this, new l(this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public o getAdapter() {
        return (o) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(@NonNull Canvas canvas) {
        int iA;
        int width;
        int iA2;
        int width2;
        int width3;
        int i2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        o adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.f1036c;
        b bVar = adapter.f1038e;
        Long item = adapter.getItem(adapter.b());
        Long item2 = adapter.getItem(adapter.d());
        for (Pair<Long, Long> pair : dateSelector.t()) {
            Long l2 = pair.first;
            if (l2 != null) {
                if (pair.second != null) {
                    long jLongValue = l2.longValue();
                    long jLongValue2 = pair.second.longValue();
                    Long lValueOf = Long.valueOf(jLongValue);
                    Long lValueOf2 = Long.valueOf(jLongValue2);
                    if (!(item == null || item2 == null || lValueOf == null || lValueOf2 == null || lValueOf.longValue() > item2.longValue() || lValueOf2.longValue() < item.longValue())) {
                        boolean zC3 = f.C3(this);
                        if (jLongValue < item.longValue()) {
                            iA = adapter.b();
                            width = iA % adapter.f1035b.f2213d == 0 ? 0 : !zC3 ? materialCalendarGridView.getChildAt(iA - 1).getRight() : materialCalendarGridView.getChildAt(iA - 1).getLeft();
                        } else {
                            materialCalendarGridView.a.setTimeInMillis(jLongValue);
                            iA = adapter.a(materialCalendarGridView.a.get(5));
                            View childAt = materialCalendarGridView.getChildAt(iA);
                            width = (childAt.getWidth() / 2) + childAt.getLeft();
                        }
                        if (jLongValue2 > item2.longValue()) {
                            iA2 = Math.min(adapter.d(), getChildCount() - 1);
                            width2 = (iA2 + 1) % adapter.f1035b.f2213d == 0 ? getWidth() : !zC3 ? materialCalendarGridView.getChildAt(iA2).getRight() : materialCalendarGridView.getChildAt(iA2).getLeft();
                        } else {
                            materialCalendarGridView.a.setTimeInMillis(jLongValue2);
                            iA2 = adapter.a(materialCalendarGridView.a.get(5));
                            View childAt2 = materialCalendarGridView.getChildAt(iA2);
                            width2 = (childAt2.getWidth() / 2) + childAt2.getLeft();
                        }
                        int itemId = (int) adapter.getItemId(iA);
                        int itemId2 = (int) adapter.getItemId(iA2);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt3 = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt3.getTop() + bVar.a.a.top;
                            int bottom = childAt3.getBottom() - bVar.a.a.bottom;
                            if (zC3) {
                                int i3 = iA2 > numColumns2 ? 0 : width2;
                                width3 = numColumns > iA ? getWidth() : width;
                                i2 = i3;
                            } else {
                                i2 = numColumns > iA ? 0 : width;
                                width3 = iA2 > numColumns2 ? getWidth() : width2;
                            }
                            canvas.drawRect(i2, top, width3, bottom, bVar.f1018h);
                            itemId++;
                            materialCalendarGridView = this;
                            adapter = adapter;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
            adapter = adapter;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        if (!z) {
            super.onFocusChanged(false, i2, rect);
            return;
        }
        if (i2 == 33) {
            setSelection(getAdapter().d());
        } else if (i2 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i2, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!super.onKeyDown(i2, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i2) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (!this.f2196b) {
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i2) {
        if (i2 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i2);
        }
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof o)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), o.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
