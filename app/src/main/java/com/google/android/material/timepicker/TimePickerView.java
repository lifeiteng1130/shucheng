package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import c.e.a.b.c0.k;
import c.e.a.b.c0.l;
import c.e.a.b.c0.m;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;

/* JADX INFO: loaded from: classes.dex */
public class TimePickerView extends ConstraintLayout {
    public final Chip a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Chip f2501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ClockHandView f2502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ClockFaceView f2503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MaterialButtonToggleGroup f2504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View.OnClickListener f2505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f2506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f2507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f2508i;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = TimePickerView.this.f2507h;
            if (dVar != null) {
                dVar.c(((Integer) view.getTag(R$id.selection_type)).intValue());
            }
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
        void c(int i2);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        this.f2505f = aVar;
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        this.f2503d = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.f2504e = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new k(this));
        Chip chip = (Chip) findViewById(R$id.material_minute_tv);
        this.a = chip;
        Chip chip2 = (Chip) findViewById(R$id.material_hour_tv);
        this.f2501b = chip2;
        this.f2502c = (ClockHandView) findViewById(R$id.material_clock_hand);
        m mVar = new m(this, new GestureDetector(getContext(), new l(this)));
        chip.setOnTouchListener(mVar);
        chip2.setOnTouchListener(mVar);
        int i2 = R$id.selection_type;
        chip.setTag(i2, 12);
        chip2.setTag(i2, 10);
        chip.setOnClickListener(aVar);
        chip2.setOnClickListener(aVar);
    }

    public void addOnRotateListener(ClockHandView.d dVar) {
        this.f2502c.addOnRotateListener(dVar);
    }

    public final void b() {
        if (this.f2504e.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            constraintSet.clear(R$id.material_clock_display, ViewCompat.getLayoutDirection(this) == 0 ? 2 : 1);
            constraintSet.applyTo(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && i2 == 0) {
            b();
        }
    }

    public void setOnActionUpListener(ClockHandView.c cVar) {
        this.f2502c.setOnActionUpListener(cVar);
    }

    public void setOnDoubleTapListener(@Nullable b bVar) {
        this.f2508i = bVar;
    }

    public void setOnPeriodChangeListener(c cVar) {
        this.f2506g = cVar;
    }
}
