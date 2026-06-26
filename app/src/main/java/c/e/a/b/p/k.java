package c.e.a.b.p;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R$color;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;

/* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class k extends h {

    /* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
    public static class a extends MaterialShapeDrawable {
        public a(c.e.a.b.w.l lVar) {
            super(lVar);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public k(FloatingActionButton floatingActionButton, c.e.a.b.v.b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // c.e.a.b.p.h
    public float d() {
        return this.F.getElevation();
    }

    @Override // c.e.a.b.p.h
    public void e(@NonNull Rect rect) {
        if (FloatingActionButton.this.m) {
            super.e(rect);
        } else if (t()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.r - this.F.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // c.e.a.b.p.h
    public void f(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable layerDrawable;
        a aVar = new a((c.e.a.b.w.l) Preconditions.checkNotNull(this.f1081h));
        this.f1082i = aVar;
        aVar.setTintList(colorStateList);
        if (mode != null) {
            this.f1082i.setTintMode(mode);
        }
        this.f1082i.n(this.F.getContext());
        if (i2 > 0) {
            Context context = this.F.getContext();
            c cVar = new c((c.e.a.b.w.l) Preconditions.checkNotNull(this.f1081h));
            int color = ContextCompat.getColor(context, R$color.design_fab_stroke_top_outer_color);
            int color2 = ContextCompat.getColor(context, R$color.design_fab_stroke_top_inner_color);
            int color3 = ContextCompat.getColor(context, R$color.design_fab_stroke_end_inner_color);
            int color4 = ContextCompat.getColor(context, R$color.design_fab_stroke_end_outer_color);
            cVar.f1064i = color;
            cVar.f1065j = color2;
            cVar.f1066k = color3;
            cVar.f1067l = color4;
            float f2 = i2;
            if (cVar.f1063h != f2) {
                cVar.f1063h = f2;
                cVar.f1057b.setStrokeWidth(f2 * 1.3333f);
                cVar.n = true;
                cVar.invalidateSelf();
            }
            cVar.b(colorStateList);
            this.f1084k = cVar;
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f1084k), (Drawable) Preconditions.checkNotNull(this.f1082i)});
        } else {
            this.f1084k = null;
            layerDrawable = this.f1082i;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(c.e.a.b.u.a.c(colorStateList2), layerDrawable, null);
        this.f1083j = rippleDrawable;
        this.f1085l = rippleDrawable;
    }

    @Override // c.e.a.b.p.h
    public void i() {
    }

    @Override // c.e.a.b.p.h
    public void j() {
        v();
    }

    @Override // c.e.a.b.p.h
    public void k(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (!this.F.isEnabled()) {
                this.F.setElevation(0.0f);
                this.F.setTranslationZ(0.0f);
                return;
            }
            this.F.setElevation(this.o);
            if (this.F.isPressed()) {
                this.F.setTranslationZ(this.q);
            } else if (this.F.isFocused() || this.F.isHovered()) {
                this.F.setTranslationZ(this.p);
            } else {
                this.F.setTranslationZ(0.0f);
            }
        }
    }

    @Override // c.e.a.b.p.h
    public void l(float f2, float f3, float f4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21) {
            this.F.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(h.f1075b, x(f2, f4));
            stateListAnimator.addState(h.f1076c, x(f2, f3));
            stateListAnimator.addState(h.f1077d, x(f2, f3));
            stateListAnimator.addState(h.f1078e, x(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.F, Key.ELEVATION, f2).setDuration(0L));
            if (i2 >= 22 && i2 <= 24) {
                FloatingActionButton floatingActionButton = this.F;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(h.a);
            stateListAnimator.addState(h.f1079f, animatorSet);
            stateListAnimator.addState(h.f1080g, x(0.0f, 0.0f));
            this.F.setStateListAnimator(stateListAnimator);
        }
        if (r()) {
            v();
        }
    }

    @Override // c.e.a.b.p.h
    public void p(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f1083j;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(c.e.a.b.u.a.c(colorStateList));
        } else if (drawable != null) {
            DrawableCompat.setTintList(drawable, c.e.a.b.u.a.c(colorStateList));
        }
    }

    @Override // c.e.a.b.p.h
    public boolean r() {
        return FloatingActionButton.this.m || !t();
    }

    @Override // c.e.a.b.p.h
    public void u() {
    }

    @NonNull
    public final Animator x(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.F, Key.ELEVATION, f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(h.a);
        return animatorSet;
    }
}
