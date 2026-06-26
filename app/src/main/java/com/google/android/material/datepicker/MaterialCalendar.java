package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.b.l.g;
import c.e.a.b.l.h;
import c.e.a.b.l.i;
import c.e.a.b.l.j;
import c.e.a.b.l.k;
import c.e.a.b.l.q;
import c.e.a.b.l.r;
import c.e.a.b.l.s;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S> extends r<S> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2183b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @StyleRes
    public int f2184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public DateSelector<S> f2185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public CalendarConstraints f2186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Month f2187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f2188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c.e.a.b.l.b f2189h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView f2190i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f2191j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f2192k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f2193l;

    public class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.f2191j.smoothScrollToPosition(this.a);
        }
    }

    public class b extends AccessibilityDelegateCompat {
        public b(MaterialCalendar materialCalendar) {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    public class c extends s {
        public final /* synthetic */ int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i2, boolean z, int i3) {
            super(context, i2, z);
            this.a = i3;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            if (this.a == 0) {
                iArr[0] = MaterialCalendar.this.f2191j.getWidth();
                iArr[1] = MaterialCalendar.this.f2191j.getWidth();
            } else {
                iArr[0] = MaterialCalendar.this.f2191j.getHeight();
                iArr[1] = MaterialCalendar.this.f2191j.getHeight();
            }
        }
    }

    public class d implements f {
        public d() {
        }
    }

    public enum e {
        DAY,
        YEAR
    }

    public interface f {
    }

    @Override // c.e.a.b.l.r
    public boolean N(@NonNull q<S> qVar) {
        return this.a.add(qVar);
    }

    @NonNull
    public LinearLayoutManager O() {
        return (LinearLayoutManager) this.f2191j.getLayoutManager();
    }

    public final void P(int i2) {
        this.f2191j.post(new a(i2));
    }

    public void Q(Month month) {
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.f2191j.getAdapter();
        int iJ = monthsPagerAdapter.f2217b.a.j(month);
        int iE = iJ - monthsPagerAdapter.e(this.f2187f);
        boolean z = Math.abs(iE) > 3;
        boolean z2 = iE > 0;
        this.f2187f = month;
        if (z && z2) {
            this.f2191j.scrollToPosition(iJ - 3);
            P(iJ);
        } else if (!z) {
            P(iJ);
        } else {
            this.f2191j.scrollToPosition(iJ + 3);
            P(iJ);
        }
    }

    public void R(e eVar) {
        this.f2188g = eVar;
        if (eVar == e.YEAR) {
            this.f2190i.getLayoutManager().scrollToPosition(((YearGridAdapter) this.f2190i.getAdapter()).d(this.f2187f.f2212c));
            this.f2192k.setVisibility(0);
            this.f2193l.setVisibility(8);
        } else if (eVar == e.DAY) {
            this.f2192k.setVisibility(8);
            this.f2193l.setVisibility(0);
            Q(this.f2187f);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f2184c = bundle.getInt("THEME_RES_ID_KEY");
        this.f2185d = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f2186e = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f2187f = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f2184c);
        this.f2189h = new c.e.a.b.l.b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.f2186e.a;
        if (MaterialDatePicker.O(contextThemeWrapper)) {
            i2 = R$layout.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = R$layout.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) viewInflate.findViewById(R$id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new c.e.a.b.l.e());
        gridView.setNumColumns(month.f2213d);
        gridView.setEnabled(false);
        this.f2191j = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_months);
        this.f2191j.setLayoutManager(new c(getContext(), i3, false, i3));
        this.f2191j.setTag("MONTHS_VIEW_GROUP_TAG");
        MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.f2185d, this.f2186e, new d());
        this.f2191j.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        int i4 = R$id.mtrl_calendar_year_selector_frame;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(i4);
        this.f2190i = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f2190i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f2190i.setAdapter(new YearGridAdapter(this));
            this.f2190i.addItemDecoration(new c.e.a.b.l.f(this));
        }
        int i5 = R$id.month_navigation_fragment_toggle;
        if (viewInflate.findViewById(i5) != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(i5);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            ViewCompat.setAccessibilityDelegate(materialButton, new g(this));
            MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R$id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R$id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.f2192k = viewInflate.findViewById(i4);
            this.f2193l = viewInflate.findViewById(R$id.mtrl_calendar_day_selector_frame);
            R(e.DAY);
            materialButton.setText(this.f2187f.h(viewInflate.getContext()));
            this.f2191j.addOnScrollListener(new h(this, monthsPagerAdapter, materialButton));
            materialButton.setOnClickListener(new i(this));
            materialButton3.setOnClickListener(new j(this, monthsPagerAdapter));
            materialButton2.setOnClickListener(new k(this, monthsPagerAdapter));
        }
        if (!MaterialDatePicker.O(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.f2191j);
        }
        this.f2191j.scrollToPosition(monthsPagerAdapter.e(this.f2187f));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f2184c);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f2185d);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f2186e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f2187f);
    }
}
