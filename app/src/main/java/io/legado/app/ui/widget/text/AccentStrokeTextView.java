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
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: AccentStrokeTextView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lio/legado/app/ui/widget/text/AccentStrokeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", ai.at, OptRuntime.GeneratorState.resumptionPoint_TYPE, "radius", "", "b", "Z", "isBottomBackground", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AccentStrokeTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int radius;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isBottomBackground;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccentStrokeTextView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        int iC2;
        super(context, attributeSet);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
        this.radius = f.m2(3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AccentStrokeTextView);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.AccentStrokeTextView)");
        this.radius = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, this.radius);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.isBottomBackground = z;
        typedArrayObtainStyledAttributes.recycle();
        Context context2 = getContext();
        j.d(context2, c.R);
        int iT1 = f.T1(context2);
        boolean z2 = ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d;
        if (!z) {
            Context context3 = getContext();
            j.d(context3, c.R);
            iC2 = f.c2(context3, R.color.disabled);
        } else if (z2) {
            Context context4 = getContext();
            j.d(context4, c.R);
            iC2 = f.c2(context4, R.color.md_light_disabled);
        } else {
            Context context5 = getContext();
            j.d(context5, c.R);
            iC2 = f.c2(context5, R.color.md_dark_disabled);
        }
        Selector$ShapeSelector selector$ShapeSelector = new Selector$ShapeSelector();
        selector$ShapeSelector.n = this.radius;
        selector$ShapeSelector.f6910g = f.m2(1);
        selector$ShapeSelector.d(iC2);
        b.a aVar = b.a;
        Context context6 = getContext();
        j.d(context6, c.R);
        selector$ShapeSelector.c(aVar.a(context6));
        Context context7 = getContext();
        j.d(context7, c.R);
        selector$ShapeSelector.e(f.c2(context7, R.color.transparent30));
        setBackground(selector$ShapeSelector.a());
        a aVar2 = new a();
        Context context8 = getContext();
        j.d(context8, c.R);
        aVar2.b(aVar.a(context8));
        aVar2.c(iC2);
        setTextColor(aVar2.a());
    }
}
