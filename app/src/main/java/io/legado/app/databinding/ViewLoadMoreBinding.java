package io.legado.app.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.anima.RotateLoading;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewLoadMoreBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RotateLoading f6882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6883c;

    public ViewLoadMoreBinding(@NonNull View view, @NonNull RotateLoading rotateLoading, @NonNull TextView textView) {
        this.a = view;
        this.f6882b = rotateLoading;
        this.f6883c = textView;
    }

    @NonNull
    public static ViewLoadMoreBinding a(@NonNull View view) {
        int i2 = R.id.rotate_loading;
        RotateLoading rotateLoading = (RotateLoading) view.findViewById(R.id.rotate_loading);
        if (rotateLoading != null) {
            i2 = R.id.tv_text;
            TextView textView = (TextView) view.findViewById(R.id.tv_text);
            if (textView != null) {
                return new ViewLoadMoreBinding(view, rotateLoading, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
