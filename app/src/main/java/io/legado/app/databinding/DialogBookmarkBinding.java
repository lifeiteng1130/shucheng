package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.text.EditText;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogBookmarkBinding implements ViewBinding {

    @NonNull
    public final ScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f6587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditText f6588c;

    public DialogBookmarkBinding(@NonNull ScrollView scrollView, @NonNull EditText editText, @NonNull EditText editText2) {
        this.a = scrollView;
        this.f6587b = editText;
        this.f6588c = editText2;
    }

    @NonNull
    public static DialogBookmarkBinding a(@NonNull LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_bookmark, (ViewGroup) null, false);
        int i2 = R.id.edit_book_text;
        EditText editText = (EditText) viewInflate.findViewById(R.id.edit_book_text);
        if (editText != null) {
            i2 = R.id.edit_view;
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.edit_view);
            if (editText2 != null) {
                return new DialogBookmarkBinding((ScrollView) viewInflate, editText, editText2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
