package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogTocRegexBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Toolbar f6697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f6698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f6699e;

    public DialogTocRegexBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull Toolbar toolbar, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f6696b = recyclerView;
        this.f6697c = toolbar;
        this.f6698d = textView;
        this.f6699e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
