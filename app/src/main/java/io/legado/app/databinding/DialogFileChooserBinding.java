package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogFileChooserBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Toolbar f6616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f6617e;

    public DialogFileChooserBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull Toolbar toolbar, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f6614b = recyclerView;
        this.f6615c = recyclerView2;
        this.f6616d = toolbar;
        this.f6617e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
