package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import c.e.a.b.l.q;
import c.e.a.b.l.r;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S> extends r<S> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @StyleRes
    public int f2208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public DateSelector<S> f2209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public CalendarConstraints f2210d;

    public class a extends q<S> {
        public a() {
        }

        @Override // c.e.a.b.l.q
        public void a() {
            Iterator<q<S>> it = MaterialTextInputPicker.this.a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // c.e.a.b.l.q
        public void b(S s) {
            Iterator<q<S>> it = MaterialTextInputPicker.this.a.iterator();
            while (it.hasNext()) {
                it.next().b(s);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f2208b = bundle.getInt("THEME_RES_ID_KEY");
        this.f2209c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f2210d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.f2209c.z(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f2208b)), viewGroup, bundle, this.f2210d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f2208b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f2209c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f2210d);
    }
}
