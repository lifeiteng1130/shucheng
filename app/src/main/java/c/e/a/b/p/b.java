package c.e.a.b.p;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: compiled from: BaseMotionStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements l {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ExtendedFloatingActionButton f1052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Animator.AnimatorListener> f1053c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.e.a.b.p.a f1054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public c.e.a.b.a.g f1055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public c.e.a.b.a.g f1056f;

    /* JADX INFO: compiled from: BaseMotionStrategy.java */
    public class a extends Property<ExtendedFloatingActionButton, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            ExtendedFloatingActionButton extendedFloatingActionButton2 = extendedFloatingActionButton;
            return Float.valueOf(c.e.a.b.a.a.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton2.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton2.I.getColorForState(extendedFloatingActionButton2.getDrawableState(), b.this.f1052b.I.getDefaultColor()))));
        }

        @Override // android.util.Property
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f2) {
            ExtendedFloatingActionButton extendedFloatingActionButton2 = extendedFloatingActionButton;
            Float f3 = f2;
            int colorForState = extendedFloatingActionButton2.I.getColorForState(extendedFloatingActionButton2.getDrawableState(), b.this.f1052b.I.getDefaultColor());
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (c.e.a.b.a.a.a(0.0f, Color.alpha(colorForState) / 255.0f, f3.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f3.floatValue() == 1.0f) {
                extendedFloatingActionButton2.l(extendedFloatingActionButton2.I);
            } else {
                extendedFloatingActionButton2.l(colorStateListValueOf);
            }
        }
    }

    public b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, c.e.a.b.p.a aVar) {
        this.f1052b = extendedFloatingActionButton;
        this.a = extendedFloatingActionButton.getContext();
        this.f1054d = aVar;
    }

    @Override // c.e.a.b.p.l
    @CallSuper
    public void a() {
        this.f1054d.a = null;
    }

    @Override // c.e.a.b.p.l
    @CallSuper
    public void e() {
        this.f1054d.a = null;
    }

    @Override // c.e.a.b.p.l
    public AnimatorSet f() {
        return h(i());
    }

    @NonNull
    public AnimatorSet h(@NonNull c.e.a.b.a.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar.g("opacity")) {
            arrayList.add(gVar.d("opacity", this.f1052b, View.ALPHA));
        }
        if (gVar.g("scale")) {
            arrayList.add(gVar.d("scale", this.f1052b, View.SCALE_Y));
            arrayList.add(gVar.d("scale", this.f1052b, View.SCALE_X));
        }
        if (gVar.g("width")) {
            arrayList.add(gVar.d("width", this.f1052b, ExtendedFloatingActionButton.r));
        }
        if (gVar.g("height")) {
            arrayList.add(gVar.d("height", this.f1052b, ExtendedFloatingActionButton.s));
        }
        if (gVar.g("paddingStart")) {
            arrayList.add(gVar.d("paddingStart", this.f1052b, ExtendedFloatingActionButton.t));
        }
        if (gVar.g("paddingEnd")) {
            arrayList.add(gVar.d("paddingEnd", this.f1052b, ExtendedFloatingActionButton.u));
        }
        if (gVar.g("labelOpacity")) {
            arrayList.add(gVar.d("labelOpacity", this.f1052b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        c.b.a.m.f.k4(animatorSet, arrayList);
        return animatorSet;
    }

    public final c.e.a.b.a.g i() {
        c.e.a.b.a.g gVar = this.f1056f;
        if (gVar != null) {
            return gVar;
        }
        if (this.f1055e == null) {
            this.f1055e = c.e.a.b.a.g.b(this.a, b());
        }
        return (c.e.a.b.a.g) Preconditions.checkNotNull(this.f1055e);
    }

    @Override // c.e.a.b.p.l
    @CallSuper
    public void onAnimationStart(Animator animator) {
        c.e.a.b.p.a aVar = this.f1054d;
        Animator animator2 = aVar.a;
        if (animator2 != null) {
            animator2.cancel();
        }
        aVar.a = animator;
    }
}
