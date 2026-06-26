package io.legado.app.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.text.AccentBgTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityFeedbackBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AccentBgTextView f6512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditText f6513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditText f6514d;

    public ActivityFeedbackBinding(@NonNull LinearLayout linearLayout, @NonNull AccentBgTextView accentBgTextView, @NonNull EditText editText, @NonNull EditText editText2, @NonNull TitleBar titleBar) {
        this.a = linearLayout;
        this.f6512b = accentBgTextView;
        this.f6513c = editText;
        this.f6514d = editText2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
