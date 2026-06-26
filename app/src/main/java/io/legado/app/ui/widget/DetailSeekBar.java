package io.legado.app.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.g.m.q.a;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import io.legado.app.R$styleable;
import io.legado.app.databinding.ViewDetailSeekBarBinding;
import io.legado.app.lib.theme.view.ATESeekBar;
import io.legado.app.ui.widget.DetailSeekBar;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: DetailSeekBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0004\b1\u00102J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R?\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R?\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020(\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#¨\u00063"}, d2 = {"Lio/legado/app/ui/widget/DetailSeekBar;", "Landroid/widget/FrameLayout;", "Le/a/a/g/m/q/a;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "Lf/v;", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "onStartTrackingTouch", "(Landroid/widget/SeekBar;)V", "onStopTrackingTouch", "Lio/legado/app/databinding/ViewDetailSeekBarBinding;", "b", "Lio/legado/app/databinding/ViewDetailSeekBarBinding;", "binding", ES6Iterator.VALUE_PROPERTY, "getProgress", "()I", "setProgress", "(I)V", ai.aD, "Z", "isBottomBackground", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "e", "Lf/c0/b/l;", "getOnChanged", "()Lf/c0/b/l;", "setOnChanged", "(Lf/c0/b/l;)V", "onChanged", "getMax", "setMax", "max", "", "d", "getValueFormat", "setValueFormat", "valueFormat", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class DetailSeekBar extends FrameLayout implements a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public ViewDetailSeekBarBinding binding;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean isBottomBackground;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public l<? super Integer, String> valueFormat;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public l<? super Integer, v> onChanged;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DetailSeekBar(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    public final int getMax() {
        return this.binding.f6879d.getMax();
    }

    @Nullable
    public final l<Integer, v> getOnChanged() {
        return this.onChanged;
    }

    public final int getProgress() {
        return this.binding.f6879d.getProgress();
    }

    @Nullable
    public final l<Integer, String> getValueFormat() {
        return this.valueFormat;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
        v vVar;
        j.e(seekBar, "seekBar");
        l<? super Integer, String> lVar = this.valueFormat;
        if (lVar == null) {
            vVar = null;
        } else {
            this.binding.f6881f.setText(lVar.invoke(Integer.valueOf(progress)));
            vVar = v.a;
        }
        if (vVar == null) {
            this.binding.f6881f.setText(String.valueOf(progress));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        j.e(seekBar, "seekBar");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        j.e(seekBar, "seekBar");
        l<? super Integer, v> lVar = this.onChanged;
        if (lVar == null) {
            return;
        }
        lVar.invoke(Integer.valueOf(this.binding.f6879d.getProgress()));
    }

    public final void setMax(int i2) {
        this.binding.f6879d.setMax(i2);
    }

    public final void setOnChanged(@Nullable l<? super Integer, v> lVar) {
        this.onChanged = lVar;
    }

    public final void setProgress(int i2) {
        this.binding.f6879d.setProgress(i2);
    }

    public final void setValueFormat(@Nullable l<? super Integer, String> lVar) {
        this.valueFormat = lVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DetailSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_detail_seek_bar, (ViewGroup) this, false);
        addView(viewInflate);
        int i2 = R.id.iv_seek_plus;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_seek_plus);
        if (appCompatImageView != null) {
            i2 = R.id.iv_seek_reduce;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewInflate.findViewById(R.id.iv_seek_reduce);
            if (appCompatImageView2 != null) {
                i2 = R.id.seek_bar;
                ATESeekBar aTESeekBar = (ATESeekBar) viewInflate.findViewById(R.id.seek_bar);
                if (aTESeekBar != null) {
                    i2 = R.id.tv_seek_title;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.tv_seek_title);
                    if (textView != null) {
                        i2 = R.id.tv_seek_value;
                        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_seek_value);
                        if (textView2 != null) {
                            ViewDetailSeekBarBinding viewDetailSeekBarBinding = new ViewDetailSeekBarBinding((LinearLayout) viewInflate, appCompatImageView, appCompatImageView2, aTESeekBar, textView, textView2);
                            j.d(viewDetailSeekBarBinding, "inflate(LayoutInflater.from(context), this, true)");
                            this.binding = viewDetailSeekBarBinding;
                            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DetailSeekBar);
                            j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.DetailSeekBar)");
                            boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
                            this.isBottomBackground = z;
                            this.binding.f6880e.setText(typedArrayObtainStyledAttributes.getText(2));
                            this.binding.f6879d.setMax(typedArrayObtainStyledAttributes.getInteger(1, 0));
                            typedArrayObtainStyledAttributes.recycle();
                            if (z && !isInEditMode()) {
                                int iT1 = f.T1(context);
                                int iS2 = f.S2(context, ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d);
                                this.binding.f6880e.setTextColor(iS2);
                                this.binding.f6877b.setColorFilter(iS2);
                                this.binding.f6878c.setColorFilter(iS2);
                                this.binding.f6881f.setTextColor(iS2);
                            }
                            this.binding.f6877b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.a
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    DetailSeekBar detailSeekBar = this.a;
                                    int i3 = DetailSeekBar.a;
                                    j.e(detailSeekBar, "this$0");
                                    ATESeekBar aTESeekBar2 = detailSeekBar.binding.f6879d;
                                    j.d(aTESeekBar2, "binding.seekBar");
                                    j.e(aTESeekBar2, "<this>");
                                    aTESeekBar2.setProgress(aTESeekBar2.getProgress() + 1);
                                    l<Integer, v> onChanged = detailSeekBar.getOnChanged();
                                    if (onChanged == null) {
                                        return;
                                    }
                                    onChanged.invoke(Integer.valueOf(detailSeekBar.binding.f6879d.getProgress()));
                                }
                            });
                            this.binding.f6878c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.b
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    DetailSeekBar detailSeekBar = this.a;
                                    int i3 = DetailSeekBar.a;
                                    j.e(detailSeekBar, "this$0");
                                    ATESeekBar aTESeekBar2 = detailSeekBar.binding.f6879d;
                                    j.d(aTESeekBar2, "binding.seekBar");
                                    j.e(aTESeekBar2, "<this>");
                                    aTESeekBar2.setProgress(aTESeekBar2.getProgress() - 1);
                                    l<Integer, v> onChanged = detailSeekBar.getOnChanged();
                                    if (onChanged == null) {
                                        return;
                                    }
                                    onChanged.invoke(Integer.valueOf(detailSeekBar.binding.f6879d.getProgress()));
                                }
                            });
                            this.binding.f6879d.setOnSeekBarChangeListener(this);
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }
}
