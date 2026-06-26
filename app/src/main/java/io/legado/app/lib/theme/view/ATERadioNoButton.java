package io.legado.app.lib.theme.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.e.d.a;
import e.a.a.h.g;
import f.c0.c.j;
import io.legado.app.R$styleable;
import io.legado.app.lib.theme.Selector$ShapeSelector;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ATERadioNoButton.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"Lio/legado/app/lib/theme/view/ATERadioNoButton;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "", ai.at, "Z", "isBottomBackground", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ATERadioNoButton extends AppCompatRadioButton {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final boolean isBottomBackground;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ATERadioNoButton(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ATERadioNoButton);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.ATERadioNoButton)");
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.isBottomBackground = z;
        typedArrayObtainStyledAttributes.recycle();
        if (isInEditMode()) {
            return;
        }
        if (!z) {
            Context context2 = getContext();
            j.d(context2, c.R);
            int iC2 = f.c2(context2, R.color.primaryText);
            Selector$ShapeSelector selector$ShapeSelector = new Selector$ShapeSelector();
            selector$ShapeSelector.n = f.m2(2);
            selector$ShapeSelector.f6910g = f.m2(2);
            Context context3 = getContext();
            j.d(context3, c.R);
            selector$ShapeSelector.f6909f = f.M1(context3);
            selector$ShapeSelector.p = true;
            Context context4 = getContext();
            j.d(context4, c.R);
            selector$ShapeSelector.m = f.M1(context4);
            selector$ShapeSelector.s = true;
            selector$ShapeSelector.c(iC2);
            setBackground(selector$ShapeSelector.a());
            a aVar = new a();
            aVar.b(iC2);
            Context context5 = getContext();
            j.d(context5, c.R);
            Context context6 = getContext();
            j.d(context6, c.R);
            int iM1 = f.M1(context6);
            aVar.f5651f = f.S2(context5, ((double) 1) - (((((double) Color.blue(iM1)) * 0.114d) + ((((double) Color.green(iM1)) * 0.587d) + (((double) Color.red(iM1)) * 0.299d))) / ((double) 255)) < 0.4d);
            aVar.f5655j = true;
            setTextColor(aVar.a());
            return;
        }
        Context context7 = getContext();
        j.d(context7, c.R);
        boolean zB = g.b(f.T1(context7));
        Context context8 = getContext();
        j.d(context8, c.R);
        int iS2 = f.S2(context8, zB);
        Selector$ShapeSelector selector$ShapeSelector2 = new Selector$ShapeSelector();
        selector$ShapeSelector2.n = f.m2(2);
        selector$ShapeSelector2.f6910g = f.m2(2);
        Context context9 = getContext();
        j.d(context9, c.R);
        selector$ShapeSelector2.f6909f = f.M1(context9);
        selector$ShapeSelector2.p = true;
        Context context10 = getContext();
        j.d(context10, c.R);
        selector$ShapeSelector2.m = f.M1(context10);
        selector$ShapeSelector2.s = true;
        selector$ShapeSelector2.c(iS2);
        setBackground(selector$ShapeSelector2.a());
        a aVar2 = new a();
        aVar2.b(iS2);
        Context context11 = getContext();
        j.d(context11, c.R);
        Context context12 = getContext();
        j.d(context12, c.R);
        aVar2.f5651f = f.S2(context11, g.b(f.M1(context12)));
        aVar2.f5655j = true;
        setTextColor(aVar2.a());
    }
}
