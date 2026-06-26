package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.text.EditText;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogPageKeyBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditText f6623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditText f6624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f6625e;

    public DialogPageKeyBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull EditText editText, @NonNull EditText editText2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f6622b = linearLayout2;
        this.f6623c = editText;
        this.f6624d = editText2;
        this.f6625e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
