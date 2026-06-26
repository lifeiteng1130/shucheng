package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.text.EditText;
import io.legado.app.ui.widget.text.TextInputLayout;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemSourceEditBinding implements ViewBinding {

    @NonNull
    public final TextInputLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f6848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextInputLayout f6849c;

    public ItemSourceEditBinding(@NonNull TextInputLayout textInputLayout, @NonNull EditText editText, @NonNull TextInputLayout textInputLayout2) {
        this.a = textInputLayout;
        this.f6848b = editText;
        this.f6849c = textInputLayout2;
    }

    @NonNull
    public static ItemSourceEditBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_source_edit, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        EditText editText = (EditText) viewInflate.findViewById(R.id.editText);
        if (editText == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.editText)));
        }
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate;
        return new ItemSourceEditBinding(textInputLayout, editText, textInputLayout);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
