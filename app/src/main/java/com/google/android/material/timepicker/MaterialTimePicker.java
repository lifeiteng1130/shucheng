package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import c.e.a.b.c0.f;
import c.e.a.b.c0.g;
import c.e.a.b.c0.i;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialTimePicker extends DialogFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TimePickerView f2487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f2488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewStub f2489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public f f2490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public i f2491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public g f2492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @DrawableRes
    public int f2493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @DrawableRes
    public int f2494l;
    public String n;
    public MaterialButton o;
    public TimeModel q;
    public final Set<View.OnClickListener> a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<View.OnClickListener> f2484b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<DialogInterface.OnCancelListener> f2485c = new LinkedHashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<DialogInterface.OnDismissListener> f2486d = new LinkedHashSet();
    public int m = 0;
    public int p = 0;

    public class a implements TimePickerView.b {
        public a() {
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<View.OnClickListener> it = MaterialTimePicker.this.a.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<View.OnClickListener> it = MaterialTimePicker.this.f2484b.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.p = materialTimePicker.p == 0 ? 1 : 0;
            materialTimePicker.N(materialTimePicker.o);
        }
    }

    public final void N(MaterialButton materialButton) {
        g gVar;
        Pair pair;
        g gVar2 = this.f2492j;
        if (gVar2 != null) {
            gVar2.d();
        }
        if (this.p == 0) {
            f fVar = this.f2490h;
            f fVar2 = fVar;
            if (fVar == null) {
                fVar2 = new f(this.f2487e, this.q);
            }
            this.f2490h = fVar2;
            gVar = fVar2;
        } else {
            if (this.f2491i == null) {
                LinearLayout linearLayout = (LinearLayout) this.f2489g.inflate();
                this.f2488f = linearLayout;
                this.f2491i = new i(linearLayout, this.q);
            }
            i iVar = this.f2491i;
            iVar.f933e.setChecked(false);
            iVar.f934f.setChecked(false);
            gVar = this.f2491i;
        }
        this.f2492j = gVar;
        gVar.show();
        this.f2492j.b();
        int i2 = this.p;
        if (i2 == 0) {
            pair = new Pair(Integer.valueOf(this.f2493k), Integer.valueOf(R$string.material_timepicker_text_input_mode_description));
        } else {
            if (i2 != 1) {
                throw new IllegalArgumentException(c.a.a.a.a.G("no icon for mode: ", i2));
            }
            pair = new Pair(Integer.valueOf(this.f2494l), Integer.valueOf(R$string.material_timepicker_clock_mode_description));
        }
        materialButton.setIconResource(((Integer) pair.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) pair.second).intValue()));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f2485c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.q = timeModel;
        if (timeModel == null) {
            this.q = new TimeModel(0, 0, 10, 0);
        }
        this.p = bundle.getInt("TIME_PICKER_INPUT_MODE", 0);
        this.m = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
        this.n = bundle.getString("TIME_PICKER_TITLE_TEXT");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        TypedValue typedValueL4 = c.b.a.m.f.L4(requireContext(), R$attr.materialTimePickerTheme);
        Dialog dialog = new Dialog(requireContext(), typedValueL4 == null ? 0 : typedValueL4.data);
        Context context = dialog.getContext();
        int iN4 = c.b.a.m.f.N4(context, R$attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int i2 = R$attr.materialTimePickerStyle;
        int i3 = R$style.Widget_MaterialComponents_TimePicker;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, i2, i3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.MaterialTimePicker, i2, i3);
        this.f2494l = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_clockIcon, 0);
        this.f2493k = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_keyboardIcon, 0);
        typedArrayObtainStyledAttributes.recycle();
        materialShapeDrawable.f2333c.f2343b = new c.e.a.b.n.a(context);
        materialShapeDrawable.C();
        materialShapeDrawable.q(ColorStateList.valueOf(iN4));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R$id.material_timepicker_view);
        this.f2487e = timePickerView;
        timePickerView.setOnDoubleTapListener(new a());
        this.f2489g = (ViewStub) viewGroup2.findViewById(R$id.material_textinput_timepicker);
        this.o = (MaterialButton) viewGroup2.findViewById(R$id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R$id.header_title);
        if (!TextUtils.isEmpty(this.n)) {
            textView.setText(this.n);
        }
        int i2 = this.m;
        if (i2 != 0) {
            textView.setText(i2);
        }
        N(this.o);
        ((Button) viewGroup2.findViewById(R$id.material_timepicker_ok_button)).setOnClickListener(new b());
        ((Button) viewGroup2.findViewById(R$id.material_timepicker_cancel_button)).setOnClickListener(new c());
        this.o.setOnClickListener(new d());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f2486d.iterator();
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
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.q);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.p);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.m);
        bundle.putString("TIME_PICKER_TITLE_TEXT", this.n);
    }
}
