package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.e.a.b.q.f;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {
    public final Chip a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextInputLayout f2461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f2462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextWatcher f2463d;

    public class b extends f {
        public b(a aVar) {
        }

        @Override // c.e.a.b.q.f, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
                chipTextInputComboView.a.setText(TimeModel.b(chipTextInputComboView.getResources(), "00", "%02d"));
            } else {
                ChipTextInputComboView chipTextInputComboView2 = ChipTextInputComboView.this;
                chipTextInputComboView2.a.setText(TimeModel.b(chipTextInputComboView2.getResources(), editable, "%02d"));
            }
        }
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R$layout.material_time_chip, (ViewGroup) this, false);
        this.a = chip;
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R$layout.material_time_input, (ViewGroup) this, false);
        this.f2461b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f2462c = editText;
        editText.setVisibility(4);
        b bVar = new b(null);
        this.f2463d = bVar;
        editText.addTextChangedListener(bVar);
        c();
        addView(chip);
        addView(textInputLayout);
        editText.setSaveEnabled(false);
    }

    public void a(InputFilter inputFilter) {
        InputFilter[] filters = this.f2462c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f2462c.setFilters(inputFilterArr);
    }

    public void b(CharSequence charSequence) {
        this.a.setText(TimeModel.b(getResources(), charSequence, "%02d"));
        if (TextUtils.isEmpty(this.f2462c.getText())) {
            return;
        }
        this.f2462c.removeTextChangedListener(this.f2463d);
        this.f2462c.setText((CharSequence) null);
        this.f2462c.addTextChangedListener(this.f2463d);
    }

    public final void c() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2462c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.a.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.a.setChecked(z);
        this.f2462c.setVisibility(z ? 0 : 4);
        this.a.setVisibility(z ? 8 : 0);
        if (isChecked()) {
            this.f2462c.requestFocus();
            if (TextUtils.isEmpty(this.f2462c.getText())) {
                return;
            }
            EditText editText = this.f2462c;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i2, Object obj) {
        this.a.setTag(i2, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.a.toggle();
    }
}
