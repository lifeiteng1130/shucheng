package io.legado.app.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.book.read.ReadMenu;
import io.legado.app.ui.book.read.page.ReadView;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityBookReadBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f6483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f6484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ReadMenu f6485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final ReadView f6486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f6487f;

    public ActivityBookReadBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ReadMenu readMenu, @NonNull ReadView readView, @NonNull View view) {
        this.a = frameLayout;
        this.f6483b = imageView;
        this.f6484c = imageView2;
        this.f6485d = readMenu;
        this.f6486e = readView;
        this.f6487f = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
