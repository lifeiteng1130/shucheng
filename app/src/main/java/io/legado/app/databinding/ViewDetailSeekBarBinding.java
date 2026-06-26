package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATESeekBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewDetailSeekBarBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f6878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ATESeekBar f6879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f6880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f6881f;

    public ViewDetailSeekBarBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ATESeekBar aTESeekBar, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f6877b = appCompatImageView;
        this.f6878c = appCompatImageView2;
        this.f6879d = aTESeekBar;
        this.f6880e = textView;
        this.f6881f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
