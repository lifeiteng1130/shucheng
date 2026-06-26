package io.legado.app.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.text.EditText;
import io.legado.app.ui.widget.text.TextInputLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityReplaceEditBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ATECheckBox f6526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditText f6527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditText f6528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final EditText f6529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final EditText f6530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final EditText f6531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f6532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6534j;

    public ActivityReplaceEditBinding(@NonNull LinearLayout linearLayout, @NonNull ATECheckBox aTECheckBox, @NonNull EditText editText, @NonNull EditText editText2, @NonNull EditText editText3, @NonNull EditText editText4, @NonNull EditText editText5, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull TextInputLayout textInputLayout3, @NonNull TextInputLayout textInputLayout4, @NonNull TextInputLayout textInputLayout5, @NonNull TitleBar titleBar) {
        this.a = linearLayout;
        this.f6526b = aTECheckBox;
        this.f6527c = editText;
        this.f6528d = editText2;
        this.f6529e = editText3;
        this.f6530f = editText4;
        this.f6531g = editText5;
        this.f6532h = imageView;
        this.f6533i = linearLayout2;
        this.f6534j = linearLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
