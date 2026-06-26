package c.e.a.b.c0;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimeModel;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements TimePickerView.d, g {
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeModel f930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextWatcher f931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextWatcher f932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ChipTextInputComboView f933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ChipTextInputComboView f934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final EditText f936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final EditText f937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MaterialButtonToggleGroup f938j;

    /* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
    public class a extends c.e.a.b.q.f {
        public a() {
        }

        @Override // c.e.a.b.q.f, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimeModel timeModel = i.this.f930b;
                    Objects.requireNonNull(timeModel);
                    timeModel.f2498e = 0;
                } else {
                    int i2 = Integer.parseInt(editable.toString());
                    TimeModel timeModel2 = i.this.f930b;
                    Objects.requireNonNull(timeModel2);
                    timeModel2.f2498e = i2 % 60;
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
    public class b extends c.e.a.b.q.f {
        public b() {
        }

        @Override // c.e.a.b.q.f, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    i.this.f930b.e(0);
                } else {
                    i.this.f930b.e(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.c(((Integer) view.getTag(R$id.selection_type)).intValue());
        }
    }

    public i(LinearLayout linearLayout, TimeModel timeModel) {
        a aVar = new a();
        this.f931c = aVar;
        b bVar = new b();
        this.f932d = bVar;
        this.a = linearLayout;
        this.f930b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R$id.material_minute_text_input);
        this.f933e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R$id.material_hour_text_input);
        this.f934f = chipTextInputComboView2;
        int i2 = R$id.material_label;
        TextView textView = (TextView) chipTextInputComboView.findViewById(i2);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(i2);
        textView.setText(resources.getString(R$string.material_timepicker_minute));
        textView2.setText(resources.getString(R$string.material_timepicker_hour));
        int i3 = R$id.selection_type;
        chipTextInputComboView.setTag(i3, 12);
        chipTextInputComboView2.setTag(i3, 10);
        if (timeModel.f2496c == 0) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) linearLayout.findViewById(R$id.material_clock_period_toggle);
            this.f938j = materialButtonToggleGroup;
            materialButtonToggleGroup.addOnButtonCheckedListener(new j(this));
            this.f938j.setVisibility(0);
            e();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.a(timeModel.f2495b);
        chipTextInputComboView.a(timeModel.a);
        EditText editText = chipTextInputComboView2.f2461b.getEditText();
        this.f936h = editText;
        EditText editText2 = chipTextInputComboView.f2461b.getEditText();
        this.f937i = editText2;
        h hVar = new h(chipTextInputComboView2, chipTextInputComboView, timeModel);
        this.f935g = hVar;
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView2.a, new c.e.a.b.c0.a(linearLayout.getContext(), R$string.material_hour_selection));
        ViewCompat.setAccessibilityDelegate(chipTextInputComboView.a, new c.e.a.b.c0.a(linearLayout.getContext(), R$string.material_minute_selection));
        editText.addTextChangedListener(bVar);
        editText2.addTextChangedListener(aVar);
        a(timeModel);
        TextInputLayout textInputLayout = chipTextInputComboView2.f2461b;
        TextInputLayout textInputLayout2 = chipTextInputComboView.f2461b;
        EditText editText3 = textInputLayout.getEditText();
        EditText editText4 = textInputLayout2.getEditText();
        editText3.setImeOptions(268435461);
        editText4.setImeOptions(268435462);
        editText3.setOnEditorActionListener(hVar);
        editText3.setOnKeyListener(hVar);
        editText4.setOnKeyListener(hVar);
    }

    public final void a(TimeModel timeModel) {
        this.f936h.removeTextChangedListener(this.f932d);
        this.f937i.removeTextChangedListener(this.f931c);
        Locale locale = this.a.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(timeModel.f2498e));
        String str2 = String.format(locale, "%02d", Integer.valueOf(timeModel.d()));
        this.f933e.b(str);
        this.f934f.b(str2);
        this.f936h.addTextChangedListener(this.f932d);
        this.f937i.addTextChangedListener(this.f931c);
        e();
    }

    @Override // c.e.a.b.c0.g
    public void b() {
        a(this.f930b);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.d
    public void c(int i2) {
        this.f930b.f2499f = i2;
        this.f933e.setChecked(i2 == 12);
        this.f934f.setChecked(i2 == 10);
        e();
    }

    @Override // c.e.a.b.c0.g
    public void d() {
        View focusedChild = this.a.getFocusedChild();
        if (focusedChild == null) {
            this.a.setVisibility(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this.a.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.a.setVisibility(8);
    }

    public final void e() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f938j;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.b(this.f930b.f2500g == 0 ? R$id.material_clock_period_am_button : R$id.material_clock_period_pm_button);
    }

    @Override // c.e.a.b.c0.g
    public void show() {
        this.a.setVisibility(0);
    }
}
