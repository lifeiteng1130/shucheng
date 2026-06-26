package io.legado.app.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogDownloadChoiceBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f6611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditText f6612c;

    public DialogDownloadChoiceBinding(@NonNull LinearLayout linearLayout, @NonNull EditText editText, @NonNull EditText editText2, @NonNull LinearLayout linearLayout2) {
        this.a = linearLayout;
        this.f6611b = editText;
        this.f6612c = editText2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
