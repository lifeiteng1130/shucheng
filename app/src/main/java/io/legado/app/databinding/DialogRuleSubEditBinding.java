package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.text.EditText;
import io.legado.app.ui.widget.text.TextInputLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogRuleSubEditBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f6676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditText f6677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatSpinner f6678d;

    public DialogRuleSubEditBinding(@NonNull LinearLayout linearLayout, @NonNull EditText editText, @NonNull EditText editText2, @NonNull AppCompatSpinner appCompatSpinner, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        this.a = linearLayout;
        this.f6676b = editText;
        this.f6677c = editText2;
        this.f6678d = appCompatSpinner;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
