package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATESwitch;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogBookshelfConfigBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RadioGroup f6589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RadioGroup f6590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ATESwitch f6591d;

    public DialogBookshelfConfigBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull RadioGroup radioGroup, @NonNull RadioGroup radioGroup2, @NonNull ATESwitch aTESwitch) {
        this.a = constraintLayout;
        this.f6589b = radioGroup;
        this.f6590c = radioGroup2;
        this.f6591d = aTESwitch;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
