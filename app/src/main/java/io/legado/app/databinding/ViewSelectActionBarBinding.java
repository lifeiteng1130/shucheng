package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.widget.text.AccentStrokeTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewSelectActionBarBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AccentStrokeTextView f6895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AccentStrokeTextView f6896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6898e;

    public ViewSelectActionBarBinding(@NonNull LinearLayout linearLayout, @NonNull AccentStrokeTextView accentStrokeTextView, @NonNull AccentStrokeTextView accentStrokeTextView2, @NonNull ATECheckBox aTECheckBox, @NonNull AppCompatImageView appCompatImageView) {
        this.a = linearLayout;
        this.f6895b = accentStrokeTextView;
        this.f6896c = accentStrokeTextView2;
        this.f6897d = aTECheckBox;
        this.f6898e = appCompatImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
