package io.legado.app.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATESwitch;
import io.legado.app.ui.widget.text.StrokeTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogReadBgTextBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f6638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f6639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f6640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f6641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ATESwitch f6644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final StrokeTextView f6645i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f6646j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f6647k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f6648l;

    @NonNull
    public final TextView m;

    @NonNull
    public final StrokeTextView n;

    public DialogReadBgTextBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout2, @NonNull ATESwitch aTESwitch, @NonNull StrokeTextView strokeTextView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull StrokeTextView strokeTextView2) {
        this.a = linearLayout;
        this.f6638b = imageView;
        this.f6639c = imageView2;
        this.f6640d = imageView3;
        this.f6641e = imageView4;
        this.f6642f = recyclerView;
        this.f6643g = linearLayout2;
        this.f6644h = aTESwitch;
        this.f6645i = strokeTextView;
        this.f6646j = textView;
        this.f6647k = textView2;
        this.f6648l = textView3;
        this.m = textView4;
        this.n = strokeTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
