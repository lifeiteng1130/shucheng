package io.legado.app.ui.widget.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.e.d.a;
import e.a.a.e.d.b;
import f.c0.c.j;
import io.legado.app.R$styleable;
import io.legado.app.lib.theme.Selector$ShapeSelector;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: StrokeTextView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lio/legado/app/ui/widget/text/StrokeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "radius", "Lf/v;", "setRadius", "(I)V", ai.at, "()V", OptRuntime.GeneratorState.resumptionPoint_TYPE, "", "b", "Z", "isBottomBackground", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public class StrokeTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int radius;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isBottomBackground;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrokeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.radius = f.m2(1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StrokeTextView);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.StrokeTextView)");
        this.radius = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, this.radius);
        this.isBottomBackground = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    public final void a() {
        if (isInEditMode()) {
            Selector$ShapeSelector selector$ShapeSelector = new Selector$ShapeSelector();
            selector$ShapeSelector.n = this.radius;
            selector$ShapeSelector.f6910g = f.m2(1);
            Context context = getContext();
            j.d(context, c.R);
            selector$ShapeSelector.d(f.c2(context, R.color.md_grey_500));
            Context context2 = getContext();
            j.d(context2, c.R);
            selector$ShapeSelector.c(f.c2(context2, R.color.secondaryText));
            Context context3 = getContext();
            j.d(context3, c.R);
            selector$ShapeSelector.f(f.c2(context3, R.color.accent));
            Context context4 = getContext();
            j.d(context4, c.R);
            selector$ShapeSelector.e(f.c2(context4, R.color.transparent30));
            setBackground(selector$ShapeSelector.a());
            a aVar = new a();
            Context context5 = getContext();
            j.d(context5, c.R);
            aVar.b(f.c2(context5, R.color.secondaryText));
            Context context6 = getContext();
            j.d(context6, c.R);
            aVar.e(f.c2(context6, R.color.accent));
            Context context7 = getContext();
            j.d(context7, c.R);
            aVar.c(f.c2(context7, R.color.md_grey_500));
            setTextColor(aVar.a());
            return;
        }
        if (!this.isBottomBackground) {
            Selector$ShapeSelector selector$ShapeSelector2 = new Selector$ShapeSelector();
            selector$ShapeSelector2.n = this.radius;
            selector$ShapeSelector2.f6910g = f.m2(1);
            Context context8 = getContext();
            j.d(context8, c.R);
            selector$ShapeSelector2.d(f.c2(context8, R.color.md_grey_500));
            b.a aVar2 = b.a;
            Context context9 = getContext();
            j.d(context9, c.R);
            selector$ShapeSelector2.c(aVar2.g(context9));
            Context context10 = getContext();
            j.d(context10, c.R);
            selector$ShapeSelector2.f(aVar2.a(context10));
            Context context11 = getContext();
            j.d(context11, c.R);
            selector$ShapeSelector2.e(f.c2(context11, R.color.transparent30));
            setBackground(selector$ShapeSelector2.a());
            a aVar3 = new a();
            Context context12 = getContext();
            j.d(context12, c.R);
            aVar3.b(aVar2.g(context12));
            Context context13 = getContext();
            j.d(context13, c.R);
            aVar3.e(aVar2.a(context13));
            Context context14 = getContext();
            j.d(context14, c.R);
            aVar3.c(f.c2(context14, R.color.md_grey_500));
            setTextColor(aVar3.a());
            return;
        }
        Context context15 = getContext();
        j.d(context15, c.R);
        int iT1 = f.T1(context15);
        boolean z = ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d;
        Selector$ShapeSelector selector$ShapeSelector3 = new Selector$ShapeSelector();
        selector$ShapeSelector3.n = this.radius;
        selector$ShapeSelector3.f6910g = f.m2(1);
        Context context16 = getContext();
        j.d(context16, c.R);
        selector$ShapeSelector3.d(f.c2(context16, R.color.md_grey_500));
        Context context17 = getContext();
        j.d(context17, c.R);
        selector$ShapeSelector3.c(f.S2(context17, z));
        Context context18 = getContext();
        j.d(context18, c.R);
        selector$ShapeSelector3.f(f.M1(context18));
        Context context19 = getContext();
        j.d(context19, c.R);
        selector$ShapeSelector3.e(f.c2(context19, R.color.transparent30));
        setBackground(selector$ShapeSelector3.a());
        a aVar4 = new a();
        Context context20 = getContext();
        j.d(context20, c.R);
        aVar4.b(f.S2(context20, z));
        Context context21 = getContext();
        j.d(context21, c.R);
        aVar4.e(f.M1(context21));
        Context context22 = getContext();
        j.d(context22, c.R);
        aVar4.c(f.c2(context22, R.color.md_grey_500));
        setTextColor(aVar4.a());
    }

    public final void setRadius(int radius) {
        this.radius = f.m2(radius);
        a();
    }
}
