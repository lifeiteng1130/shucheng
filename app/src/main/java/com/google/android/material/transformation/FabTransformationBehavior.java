package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;
import c.e.a.b.a.d;
import c.e.a.b.a.g;
import c.e.a.b.a.h;
import c.e.a.b.a.i;
import c.e.a.b.d0.c;
import c.e.a.b.k.b;
import com.google.android.material.R$id;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f2513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f2514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f2515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f2516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f2518h;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f2520c;

        public a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.a = z;
            this.f2519b = view;
            this.f2520c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            this.f2519b.setVisibility(4);
            this.f2520c.setAlpha(1.0f);
            this.f2520c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.f2519b.setVisibility(0);
                this.f2520c.setAlpha(0.0f);
                this.f2520c.setVisibility(4);
            }
        }
    }

    public static class b {

        @Nullable
        public g a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i f2521b;
    }

    public FabTransformationBehavior() {
        this.f2513c = new Rect();
        this.f2514d = new RectF();
        this.f2515e = new RectF();
        this.f2516f = new int[2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet c(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        ArrayList arrayList;
        b bVar;
        c.e.a.b.k.b bVar2;
        Animator animatorI1;
        h hVar;
        ArrayList arrayList2;
        ObjectAnimator objectAnimatorOfInt;
        b bVarM = m(view2.getContext(), z);
        if (z) {
            this.f2517g = view.getTranslationX();
            this.f2518h = view.getTranslationY();
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        k(view, view2, z, z2, bVarM, arrayList3);
        RectF rectF = this.f2514d;
        l(view, view2, z, z2, bVarM, arrayList3, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float fE = e(view, view2, bVarM.f2521b);
        float f2 = f(view, view2, bVarM.f2521b);
        Pair<h, h> pairD = d(fE, f2, z, bVarM);
        h hVar2 = (h) pairD.first;
        h hVar3 = (h) pairD.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            fE = this.f2517g;
        }
        fArr[0] = fE;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            f2 = this.f2518h;
        }
        fArr2[0] = f2;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        hVar2.a(objectAnimatorOfFloat);
        hVar3.a(objectAnimatorOfFloat2);
        arrayList3.add(objectAnimatorOfFloat);
        arrayList3.add(objectAnimatorOfFloat2);
        boolean z3 = view2 instanceof c.e.a.b.k.b;
        if (z3 && (view instanceof ImageView)) {
            c.e.a.b.k.b bVar3 = (c.e.a.b.k.b) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, d.a, 0);
                } else {
                    objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, d.a, 255);
                }
                objectAnimatorOfInt.addUpdateListener(new c.e.a.b.d0.a(this, view2));
                bVarM.a.f("iconFade").a(objectAnimatorOfInt);
                arrayList3.add(objectAnimatorOfInt);
                arrayList4.add(new c.e.a.b.d0.b(this, bVar3, drawable));
            }
        }
        if (z3) {
            c.e.a.b.k.b bVar4 = (c.e.a.b.k.b) view2;
            i iVar = bVarM.f2521b;
            RectF rectF2 = this.f2514d;
            RectF rectF3 = this.f2515e;
            h(view, rectF2);
            rectF2.offset(this.f2517g, this.f2518h);
            h(view2, rectF3);
            rectF3.offset(-e(view, view2, iVar), 0.0f);
            float fCenterX = rectF2.centerX() - rectF3.left;
            i iVar2 = bVarM.f2521b;
            RectF rectF4 = this.f2514d;
            RectF rectF5 = this.f2515e;
            h(view, rectF4);
            rectF4.offset(this.f2517g, this.f2518h);
            h(view2, rectF5);
            rectF5.offset(0.0f, -f(view, view2, iVar2));
            float fCenterY = rectF4.centerY() - rectF5.top;
            ((FloatingActionButton) view).g(this.f2513c);
            float fWidth2 = this.f2513c.width() / 2.0f;
            h hVarF = bVarM.a.f("expansion");
            if (z) {
                if (!z2) {
                    bVar4.setRevealInfo(new b.e(fCenterX, fCenterY, fWidth2));
                }
                if (z2) {
                    fWidth2 = bVar4.getRevealInfo().f1006c;
                }
                float f3 = fWidth2;
                animatorI1 = f.i1(bVar4, fCenterX, fCenterY, f.t1(fCenterX, fCenterY, 0.0f, 0.0f, fWidth, fHeight));
                animatorI1.addListener(new c(this, bVar4));
                hVar = hVarF;
                long j2 = hVar.a;
                int i2 = (int) fCenterX;
                int i3 = (int) fCenterY;
                if (j2 > 0) {
                    Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i2, i3, f3, f3);
                    animatorCreateCircularReveal.setStartDelay(0L);
                    animatorCreateCircularReveal.setDuration(j2);
                    arrayList3.add(animatorCreateCircularReveal);
                }
                bVar2 = bVar4;
                arrayList = arrayList4;
                bVar = bVarM;
            } else {
                h hVar4 = hVarF;
                float f4 = bVar4.getRevealInfo().f1006c;
                Animator animatorI12 = f.i1(bVar4, fCenterX, fCenterY, fWidth2);
                long j3 = hVar4.a;
                int i4 = (int) fCenterX;
                int i5 = (int) fCenterY;
                if (j3 > 0) {
                    Animator animatorCreateCircularReveal2 = ViewAnimationUtils.createCircularReveal(view2, i4, i5, f4, f4);
                    animatorCreateCircularReveal2.setStartDelay(0L);
                    animatorCreateCircularReveal2.setDuration(j3);
                    arrayList3.add(animatorCreateCircularReveal2);
                }
                long j4 = hVar4.a;
                long j5 = hVar4.f847b;
                g gVar = bVarM.a;
                int size = gVar.a.size();
                arrayList = arrayList4;
                bVar = bVarM;
                int i6 = 0;
                long jMax = 0;
                while (i6 < size) {
                    int i7 = size;
                    h hVarValueAt = gVar.a.valueAt(i6);
                    jMax = Math.max(jMax, hVarValueAt.a + hVarValueAt.f847b);
                    i6++;
                    size = i7;
                    gVar = gVar;
                    bVar4 = bVar4;
                    hVar4 = hVar4;
                    i4 = i4;
                }
                h hVar5 = hVar4;
                bVar2 = bVar4;
                int i8 = i4;
                long j6 = j4 + j5;
                if (j6 < jMax) {
                    Animator animatorCreateCircularReveal3 = ViewAnimationUtils.createCircularReveal(view2, i8, i5, fWidth2, fWidth2);
                    animatorCreateCircularReveal3.setStartDelay(j6);
                    animatorCreateCircularReveal3.setDuration(jMax - j6);
                    arrayList3.add(animatorCreateCircularReveal3);
                }
                animatorI1 = animatorI12;
                hVar = hVar5;
            }
            hVar.a(animatorI1);
            arrayList3.add(animatorI1);
            arrayList2 = arrayList;
            arrayList2.add(new c.e.a.b.k.a(bVar2));
        } else {
            bVar = bVarM;
            arrayList2 = arrayList4;
        }
        j(view, view2, z, z2, bVar, arrayList3);
        i(view2, z, z2, bVar, arrayList3);
        AnimatorSet animatorSet = new AnimatorSet();
        f.k4(animatorSet, arrayList3);
        animatorSet.addListener(new a(this, z, view2, view));
        int size2 = arrayList2.size();
        for (int i9 = 0; i9 < size2; i9++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i9));
        }
        return animatorSet;
    }

    @NonNull
    public final Pair<h, h> d(float f2, float f3, boolean z, @NonNull b bVar) {
        h hVarF;
        h hVarF2;
        if (f2 == 0.0f || f3 == 0.0f) {
            hVarF = bVar.a.f("translationXLinear");
            hVarF2 = bVar.a.f("translationYLinear");
        } else if ((!z || f3 >= 0.0f) && (z || f3 <= 0.0f)) {
            hVarF = bVar.a.f("translationXCurveDownwards");
            hVarF2 = bVar.a.f("translationYCurveDownwards");
        } else {
            hVarF = bVar.a.f("translationXCurveUpwards");
            hVarF2 = bVar.a.f("translationYCurveUpwards");
        }
        return new Pair<>(hVarF, hVarF2);
    }

    public final float e(@NonNull View view, @NonNull View view2, @NonNull i iVar) {
        RectF rectF = this.f2514d;
        RectF rectF2 = this.f2515e;
        h(view, rectF);
        rectF.offset(this.f2517g, this.f2518h);
        h(view2, rectF2);
        Objects.requireNonNull(iVar);
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float f(@NonNull View view, @NonNull View view2, @NonNull i iVar) {
        RectF rectF = this.f2514d;
        RectF rectF2 = this.f2515e;
        h(view, rectF);
        rectF.offset(this.f2517g, this.f2518h);
        h(view2, rectF2);
        Objects.requireNonNull(iVar);
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final float g(@NonNull b bVar, @NonNull h hVar, float f2, float f3) {
        long j2 = hVar.a;
        long j3 = hVar.f847b;
        h hVarF = bVar.a.f("expansion");
        return c.e.a.b.a.a.a(f2, f3, hVar.b().getInterpolation((((hVarF.a + hVarF.f847b) + 17) - j2) / j3));
    }

    public final void h(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f2516f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final void i(View view, boolean z, boolean z2, @NonNull b bVar, @NonNull List list) {
        ObjectAnimator objectAnimatorOfFloat;
        if (view instanceof ViewGroup) {
            boolean z3 = view instanceof c.e.a.b.k.b;
            View viewFindViewById = view.findViewById(R$id.mtrl_child_content_container);
            ViewGroup viewGroupN = viewFindViewById != null ? n(viewFindViewById) : ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) ? n(((ViewGroup) view).getChildAt(0)) : n(view);
            if (viewGroupN == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    c.e.a.b.a.c.a.set(viewGroupN, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupN, c.e.a.b.a.c.a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupN, c.e.a.b.a.c.a, 0.0f);
            }
            bVar.a.f("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(@NonNull View view, View view2, boolean z, boolean z2, @NonNull b bVar, @NonNull List list) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof c.e.a.b.k.b) {
            c.e.a.b.k.b bVar2 = (c.e.a.b.k.b) view2;
            ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
            int colorForState = backgroundTintList != null ? backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor()) : 0;
            int i2 = 16777215 & colorForState;
            if (z) {
                if (!z2) {
                    bVar2.setCircularRevealScrimColor(colorForState);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(bVar2, b.d.a, i2);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(bVar2, b.d.a, colorForState);
            }
            objectAnimatorOfInt.setEvaluator(c.e.a.b.a.b.a);
            bVar.a.f("color").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    @TargetApi(21)
    public final void k(View view, @NonNull View view2, boolean z, boolean z2, @NonNull b bVar, @NonNull List list) {
        ObjectAnimator objectAnimatorOfFloat;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        bVar.a.f(Key.ELEVATION).a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    public final void l(@NonNull View view, @NonNull View view2, boolean z, boolean z2, @NonNull b bVar, @NonNull List list, @NonNull RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fE = e(view, view2, bVar.f2521b);
        float f2 = f(view, view2, bVar.f2521b);
        Pair<h, h> pairD = d(fE, f2, z, bVar);
        h hVar = (h) pairD.first;
        h hVar2 = (h) pairD.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-fE);
                view2.setTranslationY(-f2);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            float fG = g(bVar, hVar, -fE, 0.0f);
            float fG2 = g(bVar, hVar2, -f2, 0.0f);
            Rect rect = this.f2513c;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.f2514d;
            rectF2.set(rect);
            RectF rectF3 = this.f2515e;
            h(view2, rectF3);
            rectF3.offset(fG, fG2);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fE);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -f2);
        }
        hVar.a(objectAnimatorOfFloat);
        hVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    public abstract b m(Context context, boolean z);

    @Nullable
    public final ViewGroup n(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2513c = new Rect();
        this.f2514d = new RectF();
        this.f2515e = new RectF();
        this.f2516f = new int[2];
    }
}
