package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.image.CoverImageView;
import io.legado.app.ui.widget.text.EditText;
import io.legado.app.ui.widget.text.StrokeTextView;
import io.legado.app.ui.widget.text.TextInputLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityBookInfoEditBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CoverImageView f6475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditText f6476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditText f6477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final EditText f6478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final EditText f6479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final StrokeTextView f6480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final StrokeTextView f6481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final StrokeTextView f6482i;

    public ActivityBookInfoEditBinding(@NonNull LinearLayout linearLayout, @NonNull CoverImageView coverImageView, @NonNull EditText editText, @NonNull EditText editText2, @NonNull EditText editText3, @NonNull EditText editText4, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull TextInputLayout textInputLayout3, @NonNull TextInputLayout textInputLayout4, @NonNull TitleBar titleBar, @NonNull StrokeTextView strokeTextView, @NonNull StrokeTextView strokeTextView2, @NonNull StrokeTextView strokeTextView3) {
        this.a = linearLayout;
        this.f6475b = coverImageView;
        this.f6476c = editText;
        this.f6477d = editText2;
        this.f6478e = editText3;
        this.f6479f = editText4;
        this.f6480g = strokeTextView;
        this.f6481h = strokeTextView2;
        this.f6482i = strokeTextView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
