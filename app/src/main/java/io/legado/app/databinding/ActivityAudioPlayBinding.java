package io.legado.app.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import io.legado.app.lib.theme.view.ATESeekBar;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.image.CircleImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityAudioPlayBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FloatingActionButton f6448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f6449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f6450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final CircleImageView f6451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f6452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f6453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f6454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f6455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f6456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final ATESeekBar f6457k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final TitleBar f6458l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final TextView p;

    public ActivityAudioPlayBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull CircleImageView circleImageView, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull ImageView imageView7, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ATESeekBar aTESeekBar, @NonNull TitleBar titleBar, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull View view) {
        this.a = constraintLayout;
        this.f6448b = floatingActionButton;
        this.f6449c = imageView;
        this.f6450d = imageView2;
        this.f6451e = circleImageView;
        this.f6452f = imageView3;
        this.f6453g = imageView4;
        this.f6454h = imageView5;
        this.f6455i = imageView6;
        this.f6456j = imageView7;
        this.f6457k = aTESeekBar;
        this.f6458l = titleBar;
        this.m = textView;
        this.n = textView2;
        this.o = textView3;
        this.p = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
