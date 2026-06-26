package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import c.b.a.m.f;
import c.e.a.b.l.m;
import c.e.a.b.l.n;
import c.e.a.b.l.o;
import c.e.a.b.l.q;
import c.e.a.b.l.r;
import c.e.a.b.l.u;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<n<? super S>> f2197b = new LinkedHashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<View.OnClickListener> f2198c = new LinkedHashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnCancelListener> f2199d = new LinkedHashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnDismissListener> f2200e = new LinkedHashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @StyleRes
    public int f2201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public DateSelector<S> f2202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r<S> f2203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public CalendarConstraints f2204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MaterialCalendar<S> f2205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @StringRes
    public int f2206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f2207l;
    public boolean m;
    public int n;
    public TextView o;
    public CheckableImageButton p;

    @Nullable
    public MaterialShapeDrawable q;
    public Button r;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface InputMode {
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<n<? super S>> it = MaterialDatePicker.this.f2197b.iterator();
            while (it.hasNext()) {
                it.next().a(MaterialDatePicker.this.f2202g.H());
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<View.OnClickListener> it = MaterialDatePicker.this.f2198c.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    public class c extends q<S> {
        public c() {
        }

        @Override // c.e.a.b.l.q
        public void a() {
            MaterialDatePicker.this.r.setEnabled(false);
        }

        @Override // c.e.a.b.l.q
        public void b(S s) {
            MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
            int i2 = MaterialDatePicker.a;
            materialDatePicker.R();
            MaterialDatePicker materialDatePicker2 = MaterialDatePicker.this;
            materialDatePicker2.r.setEnabled(materialDatePicker2.f2202g.E());
        }
    }

    public static int N(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i2 = new Month(u.h()).f2213d;
        return ((i2 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding)) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i2) + (dimensionPixelOffset * 2);
    }

    public static boolean O(@NonNull Context context) {
        return P(context, R.attr.windowFullscreen);
    }

    public static boolean P(@NonNull Context context, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f.N4(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i2});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    public final void Q() {
        r<S> materialTextInputPicker;
        Context contextRequireContext = requireContext();
        int iC = this.f2201f;
        if (iC == 0) {
            iC = this.f2202g.C(contextRequireContext);
        }
        DateSelector<S> dateSelector = this.f2202g;
        CalendarConstraints calendarConstraints = this.f2204i;
        MaterialCalendar<S> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", iC);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.f2172d);
        materialCalendar.setArguments(bundle);
        this.f2205j = materialCalendar;
        if (this.p.isChecked()) {
            DateSelector<S> dateSelector2 = this.f2202g;
            CalendarConstraints calendarConstraints2 = this.f2204i;
            materialTextInputPicker = new MaterialTextInputPicker<>();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", iC);
            bundle2.putParcelable("DATE_SELECTOR_KEY", dateSelector2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
            materialTextInputPicker.setArguments(bundle2);
        } else {
            materialTextInputPicker = this.f2205j;
        }
        this.f2203h = materialTextInputPicker;
        R();
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R$id.mtrl_calendar_frame, this.f2203h);
        fragmentTransactionBeginTransaction.commitNow();
        this.f2203h.N(new c());
    }

    public final void R() {
        String strA = this.f2202g.a(getContext());
        this.o.setContentDescription(String.format(getString(R$string.mtrl_picker_announce_current_selection), strA));
        this.o.setText(strA);
    }

    public final void S(@NonNull CheckableImageButton checkableImageButton) {
        this.p.setContentDescription(this.p.isChecked() ? checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f2199d.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f2201f = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f2202g = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f2204i = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f2206k = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f2207l = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.n = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context contextRequireContext = requireContext();
        Context contextRequireContext2 = requireContext();
        int iC = this.f2201f;
        if (iC == 0) {
            iC = this.f2202g.C(contextRequireContext2);
        }
        Dialog dialog = new Dialog(contextRequireContext, iC);
        Context context = dialog.getContext();
        this.m = O(context);
        int iN4 = f.N4(context, R$attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        this.q = materialShapeDrawable;
        materialShapeDrawable.n(context);
        this.q.q(ColorStateList.valueOf(iN4));
        this.q.p(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.m ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.m) {
            viewInflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(N(context), -2));
        } else {
            View viewFindViewById = viewInflate.findViewById(R$id.mtrl_calendar_main_pane);
            View viewFindViewById2 = viewInflate.findViewById(R$id.mtrl_calendar_frame);
            viewFindViewById.setLayoutParams(new LinearLayout.LayoutParams(N(context), -1));
            Resources resources = requireContext().getResources();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height);
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height);
            int i2 = o.a;
            viewFindViewById2.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding) * (i2 - 1)) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * i2) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding));
        }
        TextView textView = (TextView) viewInflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.o = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.p = (CheckableImageButton) viewInflate.findViewById(R$id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.mtrl_picker_title_text);
        CharSequence charSequence = this.f2207l;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f2206k);
        }
        this.p.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.p;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, AppCompatResources.getDrawable(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R$drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.p.setChecked(this.n != 0);
        ViewCompat.setAccessibilityDelegate(this.p, null);
        S(this.p);
        this.p.setOnClickListener(new m(this));
        this.r = (Button) viewInflate.findViewById(R$id.confirm_button);
        if (this.f2202g.E()) {
            this.r.setEnabled(true);
        } else {
            this.r.setEnabled(false);
        }
        this.r.setTag("CONFIRM_BUTTON_TAG");
        this.r.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(R$id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        button.setOnClickListener(new b());
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f2200e.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f2201f);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f2202g);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f2204i);
        Month month = this.f2205j.f2187f;
        if (month != null) {
            bVar.f2178e = Long.valueOf(month.f2215f);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", bVar.f2179f);
        Month monthE = Month.e(bVar.f2176c);
        Month monthE2 = Month.e(bVar.f2177d);
        CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l2 = bVar.f2178e;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(monthE, monthE2, dateValidator, l2 == null ? null : Month.e(l2.longValue()), null));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f2206k);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f2207l);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.m) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.q);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.q, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new c.e.a.b.m.a(requireDialog(), rect));
        }
        Q();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f2203h.a.clear();
        super.onStop();
    }
}
