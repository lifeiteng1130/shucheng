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
public final class ItemFilletTextBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f6784b;

    public ItemFilletTextBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
        this.f6784b = textView2;
    }

    @NonNull
    public static ItemFilletTextBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_fillet_text, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        Objects.requireNonNull(viewInflate, "rootView");
        TextView textView = (TextView) viewInflate;
        return new ItemFilletTextBinding(textView, textView);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
