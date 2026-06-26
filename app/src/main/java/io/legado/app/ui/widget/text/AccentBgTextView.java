package io.legado.app.ui.widget.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.e.d.b;
import f.c0.c.j;
import io.legado.app.R$styleable;
import io.legado.app.lib.theme.Selector$ShapeSelector;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: AccentBgTextView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\u0010"}, d2 = {"Lio/legado/app/ui/widget/text/AccentBgTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "radius", "Lf/v;", "setRadius", "(I)V", ai.at, "()V", OptRuntime.GeneratorState.resumptionPoint_TYPE, "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AccentBgTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int radius;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AccentBgTextView(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    public final void a() {
        StateListDrawable stateListDrawableA;
        if (isInEditMode()) {
            Selector$ShapeSelector selector$ShapeSelector = new Selector$ShapeSelector();
            selector$ShapeSelector.n = this.radius;
            Context context = getContext();
            j.d(context, c.R);
            int iC2 = f.c2(context, R.color.accent);
            selector$ShapeSelector.a = iC2;
            selector$ShapeSelector.f6905b = iC2;
            if (!selector$ShapeSelector.o) {
                selector$ShapeSelector.f6906c = iC2;
            }
            selector$ShapeSelector.f6907d = iC2;
            selector$ShapeSelector.f6908e = iC2;
            Context context2 = getContext();
            j.d(context2, c.R);
            int iC22 = f.c2(context2, R.color.accent);
            int iAlpha = Color.alpha(iC22);
            float[] fArr = new float[3];
            Color.colorToHSV(iC22, fArr);
            fArr[2] = fArr[2] * 0.9f;
            selector$ShapeSelector.e((iAlpha << 24) + (16777215 & Color.HSVToColor(fArr)));
            stateListDrawableA = selector$ShapeSelector.a();
        } else {
            Selector$ShapeSelector selector$ShapeSelector2 = new Selector$ShapeSelector();
            selector$ShapeSelector2.n = this.radius;
            b.a aVar = b.a;
            Context context3 = getContext();
            j.d(context3, c.R);
            int iA = aVar.a(context3);
            selector$ShapeSelector2.a = iA;
            selector$ShapeSelector2.f6905b = iA;
            if (!selector$ShapeSelector2.o) {
                selector$ShapeSelector2.f6906c = iA;
            }
            selector$ShapeSelector2.f6907d = iA;
            selector$ShapeSelector2.f6908e = iA;
            Context context4 = getContext();
            j.d(context4, c.R);
            int iA2 = aVar.a(context4);
            int iAlpha2 = Color.alpha(iA2);
            float[] fArr2 = new float[3];
            Color.colorToHSV(iA2, fArr2);
            fArr2[2] = fArr2[2] * 0.9f;
            selector$ShapeSelector2.e((iAlpha2 << 24) + (16777215 & Color.HSVToColor(fArr2)));
            stateListDrawableA = selector$ShapeSelector2.a();
        }
        setBackground(stateListDrawableA);
    }

    public final void setRadius(int radius) {
        this.radius = f.m2(radius);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AccentBgTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AccentBgTextView);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.AccentBgTextView)");
        this.radius = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, this.radius);
        typedArrayObtainStyledAttributes.recycle();
        a();
        setTextColor(-1);
    }
}
