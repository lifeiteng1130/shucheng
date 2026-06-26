package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.text.EditText;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogHttpTtsEditBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f6620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditText f6621c;

    public DialogHttpTtsEditBinding(@NonNull LinearLayout linearLayout, @NonNull EditText editText, @NonNull EditText editText2) {
        this.a = linearLayout;
        this.f6620b = editText;
        this.f6621c = editText2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
