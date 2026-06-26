package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.legado.app.lib.theme.view.ATERadioNoButton;
import io.legado.app.ui.book.read.config.ChineseConverter;
import io.legado.app.ui.book.read.config.TextFontWeightConverter;
import io.legado.app.ui.widget.DetailSeekBar;
import io.legado.app.ui.widget.checkbox.SmoothCheckBox;
import io.legado.app.ui.widget.text.StrokeTextView;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogReadBookStyleBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SmoothCheckBox f6649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ChineseConverter f6650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final DetailSeekBar f6651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final DetailSeekBar f6652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final DetailSeekBar f6653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final DetailSeekBar f6654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final RadioGroup f6655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f6656i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final RecyclerView f6657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextFontWeightConverter f6658k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f6659l;

    @NonNull
    public final StrokeTextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final StrokeTextView p;

    @NonNull
    public final StrokeTextView q;

    @NonNull
    public final StrokeTextView r;

    public DialogReadBookStyleBinding(@NonNull LinearLayout linearLayout, @NonNull SmoothCheckBox smoothCheckBox, @NonNull ChineseConverter chineseConverter, @NonNull DetailSeekBar detailSeekBar, @NonNull DetailSeekBar detailSeekBar2, @NonNull DetailSeekBar detailSeekBar3, @NonNull DetailSeekBar detailSeekBar4, @NonNull ATERadioNoButton aTERadioNoButton, @NonNull ATERadioNoButton aTERadioNoButton2, @NonNull ATERadioNoButton aTERadioNoButton3, @NonNull ATERadioNoButton aTERadioNoButton4, @NonNull ATERadioNoButton aTERadioNoButton5, @NonNull RadioGroup radioGroup, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView, @NonNull TextFontWeightConverter textFontWeightConverter, @NonNull TextView textView, @NonNull StrokeTextView strokeTextView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull StrokeTextView strokeTextView2, @NonNull StrokeTextView strokeTextView3, @NonNull StrokeTextView strokeTextView4, @NonNull View view, @NonNull View view2) {
        this.a = linearLayout;
        this.f6649b = smoothCheckBox;
        this.f6650c = chineseConverter;
        this.f6651d = detailSeekBar;
        this.f6652e = detailSeekBar2;
        this.f6653f = detailSeekBar3;
        this.f6654g = detailSeekBar4;
        this.f6655h = radioGroup;
        this.f6656i = linearLayout2;
        this.f6657j = recyclerView;
        this.f6658k = textFontWeightConverter;
        this.f6659l = textView;
        this.m = strokeTextView;
        this.n = textView2;
        this.o = textView3;
        this.p = strokeTextView2;
        this.q = strokeTextView3;
        this.r = strokeTextView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
