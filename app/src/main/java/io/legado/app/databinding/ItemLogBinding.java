package io.legado.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import io.wenyuange.app.release.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemLogBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f6809b;

    public ItemLogBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
        this.f6809b = textView2;
    }

    @NonNull
    public static ItemLogBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_log, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        Objects.requireNonNull(viewInflate, "rootView");
        TextView textView = (TextView) viewInflate;
        return new ItemLogBinding(textView, textView);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
