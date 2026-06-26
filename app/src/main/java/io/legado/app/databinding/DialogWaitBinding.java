package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogWaitBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    public DialogWaitBinding(@NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView) {
        this.a = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
