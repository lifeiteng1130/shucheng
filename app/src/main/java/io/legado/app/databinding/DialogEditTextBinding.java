package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.text.AutoCompleteTextView;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogEditTextBinding implements ViewBinding {

    @NonNull
    public final ScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AutoCompleteTextView f6613b;

    public DialogEditTextBinding(@NonNull ScrollView scrollView, @NonNull AutoCompleteTextView autoCompleteTextView) {
        this.a = scrollView;
        this.f6613b = autoCompleteTextView;
    }

    @NonNull
    public static DialogEditTextBinding a(@NonNull LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_edit_text, (ViewGroup) null, false);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.edit_view);
        if (autoCompleteTextView != null) {
            return new DialogEditTextBinding((ScrollView) viewInflate, autoCompleteTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.edit_view)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
