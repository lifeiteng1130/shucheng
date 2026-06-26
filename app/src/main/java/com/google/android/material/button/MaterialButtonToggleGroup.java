package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import c.e.a.b.q.g;
import c.e.a.b.w.l;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    public static final String a = MaterialButtonToggleGroup.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2117b = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f2118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f2119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f2120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashSet<e> f2121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Comparator<MaterialButton> f2122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer[] f2123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2125j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2126k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @IdRes
    public int f2127l;

    public class a implements Comparator<MaterialButton>, j$.util.Comparator {
        public a() {
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Object obj, Object obj2) {
            MaterialButton materialButton = (MaterialButton) obj;
            MaterialButton materialButton2 = (MaterialButton) obj2;
            int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public class b extends AccessibilityDelegateCompat {
        public b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i2;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            String str = MaterialButtonToggleGroup.a;
            Objects.requireNonNull(materialButtonToggleGroup);
            if (view instanceof MaterialButton) {
                int i3 = 0;
                for (int i4 = 0; i4 < materialButtonToggleGroup.getChildCount(); i4++) {
                    if (materialButtonToggleGroup.getChildAt(i4) == view) {
                        i2 = i3;
                        break;
                    }
                    if ((materialButtonToggleGroup.getChildAt(i4) instanceof MaterialButton) && materialButtonToggleGroup.e(i4)) {
                        i3++;
                    }
                }
                i2 = -1;
            } else {
                i2 = -1;
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, i2, 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    public class c implements MaterialButton.a {
        public c(a aVar) {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(@NonNull MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            if (materialButtonToggleGroup.f2124i) {
                return;
            }
            if (materialButtonToggleGroup.f2125j) {
                materialButtonToggleGroup.f2127l = z ? materialButton.getId() : -1;
            }
            if (MaterialButtonToggleGroup.this.g(materialButton.getId(), z)) {
                MaterialButtonToggleGroup.this.c(materialButton.getId(), materialButton.isChecked());
            }
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public static class d {
        public static final c.e.a.b.w.c a = new c.e.a.b.w.a(0.0f);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c.e.a.b.w.c f2128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c.e.a.b.w.c f2129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c.e.a.b.w.c f2130d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c.e.a.b.w.c f2131e;

        public d(c.e.a.b.w.c cVar, c.e.a.b.w.c cVar2, c.e.a.b.w.c cVar3, c.e.a.b.w.c cVar4) {
            this.f2128b = cVar;
            this.f2129c = cVar3;
            this.f2130d = cVar4;
            this.f2131e = cVar2;
        }
    }

    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i2, boolean z);
    }

    public class f implements MaterialButton.b {
        public f(a aVar) {
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (e(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (e(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && e(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void setCheckedId(int i2) {
        this.f2127l = i2;
        c(i2, true);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.addOnCheckedChangeListener(this.f2119d);
        materialButton.setOnPressedChangeListenerInternal(this.f2120e);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
            MaterialButton materialButtonD = d(i2);
            int iMin = Math.min(materialButtonD.getStrokeWidth(), d(i2 - 1).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = materialButtonD.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(layoutParams2, 0);
                MarginLayoutParamsCompat.setMarginStart(layoutParams2, -iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -iMin;
                MarginLayoutParamsCompat.setMarginStart(layoutParams2, 0);
            }
            materialButtonD.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            MarginLayoutParamsCompat.setMarginEnd(layoutParams3, 0);
            MarginLayoutParamsCompat.setMarginStart(layoutParams3, 0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    public void addOnButtonCheckedListener(@NonNull e eVar) {
        this.f2121f.add(eVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i2, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            if (materialButton.isChecked()) {
                g(materialButton.getId(), true);
                setCheckedId(materialButton.getId());
            }
            l shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.f2118c.add(new d(shapeAppearanceModel.f1231f, shapeAppearanceModel.f1234i, shapeAppearanceModel.f1232g, shapeAppearanceModel.f1233h));
            ViewCompat.setAccessibilityDelegate(materialButton, new b());
        }
    }

    public void b(@IdRes int i2) {
        if (i2 == this.f2127l) {
            return;
        }
        f(i2, true);
        g(i2, true);
        setCheckedId(i2);
    }

    public final void c(@IdRes int i2, boolean z) {
        Iterator<e> it = this.f2121f.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2, z);
        }
    }

    public final MaterialButton d(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f2122g);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(d(i2), Integer.valueOf(i2));
        }
        this.f2123h = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final boolean e(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    public final void f(@IdRes int i2, boolean z) {
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById instanceof MaterialButton) {
            this.f2124i = true;
            ((MaterialButton) viewFindViewById).setChecked(z);
            this.f2124i = false;
        }
    }

    public final boolean g(int i2, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.f2126k && checkedButtonIds.isEmpty()) {
            f(i2, true);
            this.f2127l = i2;
            return false;
        }
        if (z && this.f2125j) {
            checkedButtonIds.remove(Integer.valueOf(i2));
            Iterator<Integer> it = checkedButtonIds.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                f(iIntValue, false);
                c(iIntValue, false);
            }
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.f2125j) {
            return this.f2127l;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton materialButtonD = d(i2);
            if (materialButtonD.isChecked()) {
                arrayList.add(Integer.valueOf(materialButtonD.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f2123h;
        return (numArr == null || i3 >= numArr.length) ? i3 : numArr[i3].intValue();
    }

    @VisibleForTesting
    public void h() {
        d dVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton materialButtonD = d(i2);
            if (materialButtonD.getVisibility() != 8) {
                l shapeAppearanceModel = materialButtonD.getShapeAppearanceModel();
                Objects.requireNonNull(shapeAppearanceModel);
                l.b bVar = new l.b(shapeAppearanceModel);
                d dVar2 = this.f2118c.get(i2);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z = getOrientation() == 0;
                    if (i2 == firstVisibleChildIndex) {
                        if (!z) {
                            c.e.a.b.w.c cVar = dVar2.f2128b;
                            c.e.a.b.w.c cVar2 = d.a;
                            dVar = new d(cVar, cVar2, dVar2.f2129c, cVar2);
                        } else if (c.b.a.m.f.C3(this)) {
                            c.e.a.b.w.c cVar3 = d.a;
                            dVar = new d(cVar3, cVar3, dVar2.f2129c, dVar2.f2130d);
                        } else {
                            c.e.a.b.w.c cVar4 = dVar2.f2128b;
                            c.e.a.b.w.c cVar5 = dVar2.f2131e;
                            c.e.a.b.w.c cVar6 = d.a;
                            dVar = new d(cVar4, cVar5, cVar6, cVar6);
                        }
                    } else if (i2 != lastVisibleChildIndex) {
                        dVar2 = null;
                    } else if (!z) {
                        c.e.a.b.w.c cVar7 = d.a;
                        dVar = new d(cVar7, dVar2.f2131e, cVar7, dVar2.f2130d);
                    } else if (c.b.a.m.f.C3(this)) {
                        c.e.a.b.w.c cVar8 = dVar2.f2128b;
                        c.e.a.b.w.c cVar9 = dVar2.f2131e;
                        c.e.a.b.w.c cVar10 = d.a;
                        dVar = new d(cVar8, cVar9, cVar10, cVar10);
                    } else {
                        c.e.a.b.w.c cVar11 = d.a;
                        dVar = new d(cVar11, cVar11, dVar2.f2129c, dVar2.f2130d);
                    }
                    dVar2 = dVar;
                }
                if (dVar2 == null) {
                    bVar.c(0.0f);
                } else {
                    bVar.f1241e = dVar2.f2128b;
                    bVar.f1244h = dVar2.f2131e;
                    bVar.f1242f = dVar2.f2129c;
                    bVar.f1243g = dVar2.f2130d;
                }
                materialButtonD.setShapeAppearanceModel(bVar.a());
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f2127l;
        if (i2 != -1) {
            f(i2, true);
            g(i2, true);
            setCheckedId(i2);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, this.f2125j ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        h();
        a();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.removeOnCheckedChangeListener(this.f2119d);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f2118c.remove(iIndexOfChild);
        }
        h();
        a();
    }

    public void removeOnButtonCheckedListener(@NonNull e eVar) {
        this.f2121f.remove(eVar);
    }

    public void setSelectionRequired(boolean z) {
        this.f2126k = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.f2125j != z) {
            this.f2125j = z;
            this.f2124i = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                MaterialButton materialButtonD = d(i2);
                materialButtonD.setChecked(false);
                c(materialButtonD.getId(), false);
            }
            this.f2124i = false;
            setCheckedId(-1);
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = f2117b;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f2118c = new ArrayList();
        this.f2119d = new c(null);
        this.f2120e = new f(null);
        this.f2121f = new LinkedHashSet<>();
        this.f2122g = new a();
        this.f2124i = false;
        TypedArray typedArrayD = g.d(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, i2, i3, new int[0]);
        setSingleSelection(typedArrayD.getBoolean(R$styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.f2127l = typedArrayD.getResourceId(R$styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.f2126k = typedArrayD.getBoolean(R$styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayD.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
