package c.e.a.b.p;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import c.e.a.b.w.p;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public static final TimeInterpolator a = c.e.a.b.a.a.f840c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1075b = {R.attr.state_pressed, R.attr.state_enabled};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1076c = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1077d = {R.attr.state_focused, R.attr.state_enabled};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f1078e = {R.attr.state_hovered, R.attr.state_enabled};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f1079f = {R.attr.state_enabled};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f1080g = new int[0];
    public int A;
    public ArrayList<Animator.AnimatorListener> C;
    public ArrayList<Animator.AnimatorListener> D;
    public ArrayList<e> E;
    public final FloatingActionButton F;
    public final c.e.a.b.v.b G;

    @Nullable
    public ViewTreeObserver.OnPreDrawListener L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public c.e.a.b.w.l f1081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public MaterialShapeDrawable f1082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Drawable f1083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public c.e.a.b.p.c f1084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public Drawable f1085l;
    public boolean m;
    public float o;
    public float p;
    public float q;
    public int r;

    @NonNull
    public final c.e.a.b.q.c s;

    @Nullable
    public c.e.a.b.a.g t;

    @Nullable
    public c.e.a.b.a.g u;

    @Nullable
    public Animator v;

    @Nullable
    public c.e.a.b.a.g w;

    @Nullable
    public c.e.a.b.a.g x;
    public float y;
    public boolean n = true;
    public float z = 1.0f;
    public int B = 0;
    public final Rect H = new Rect();
    public final RectF I = new RectF();
    public final RectF J = new RectF();
    public final Matrix K = new Matrix();

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public class a extends c.e.a.b.a.f {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            h.this.z = f2;
            matrix.getValues(this.a);
            matrix2.getValues(this.f844b);
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.f844b;
                float f3 = fArr[i2];
                float[] fArr2 = this.a;
                fArr[i2] = ((f3 - fArr2[i2]) * f2) + fArr2[i2];
            }
            this.f845c.setValues(this.f844b);
            return this.f845c;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public class b extends AbstractC0045h {
        public b(h hVar) {
            super(null);
        }

        @Override // c.e.a.b.p.h.AbstractC0045h
        public float a() {
            return 0.0f;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public class c extends AbstractC0045h {
        public c() {
            super(null);
        }

        @Override // c.e.a.b.p.h.AbstractC0045h
        public float a() {
            h hVar = h.this;
            return hVar.o + hVar.p;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public class d extends AbstractC0045h {
        public d() {
            super(null);
        }

        @Override // c.e.a.b.p.h.AbstractC0045h
        public float a() {
            h hVar = h.this;
            return hVar.o + hVar.q;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public interface e {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public interface f {
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public class g extends AbstractC0045h {
        public g() {
            super(null);
        }

        @Override // c.e.a.b.p.h.AbstractC0045h
        public float a() {
            return h.this.o;
        }
    }

    /* JADX INFO: renamed from: c.e.a.b.p.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public abstract class AbstractC0045h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1091c;

        public AbstractC0045h(c.e.a.b.p.f fVar) {
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h.this.w((int) this.f1091c);
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (!this.a) {
                MaterialShapeDrawable materialShapeDrawable = h.this.f1082i;
                this.f1090b = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.f2333c.o;
                this.f1091c = a();
                this.a = true;
            }
            h hVar = h.this;
            float f2 = this.f1090b;
            hVar.w((int) ((valueAnimator.getAnimatedFraction() * (this.f1091c - f2)) + f2));
        }
    }

    public h(FloatingActionButton floatingActionButton, c.e.a.b.v.b bVar) {
        this.F = floatingActionButton;
        this.G = bVar;
        c.e.a.b.q.c cVar = new c.e.a.b.q.c();
        this.s = cVar;
        cVar.a(f1075b, c(new d()));
        cVar.a(f1076c, c(new c()));
        cVar.a(f1077d, c(new c()));
        cVar.a(f1078e, c(new c()));
        cVar.a(f1079f, c(new g()));
        cVar.a(f1080g, c(new b(this)));
        this.y = floatingActionButton.getRotation();
    }

    public final void a(float f2, @NonNull Matrix matrix) {
        matrix.reset();
        if (this.F.getDrawable() == null || this.A == 0) {
            return;
        }
        RectF rectF = this.I;
        RectF rectF2 = this.J;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i2 = this.A;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.A;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    @NonNull
    public final AnimatorSet b(@NonNull c.e.a.b.a.g gVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        gVar.f("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        gVar.f("scale").a(objectAnimatorOfFloat2);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 26) {
            objectAnimatorOfFloat2.setEvaluator(new i(this));
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        gVar.f("scale").a(objectAnimatorOfFloat3);
        if (i2 == 26) {
            objectAnimatorOfFloat3.setEvaluator(new i(this));
        }
        arrayList.add(objectAnimatorOfFloat3);
        a(f4, this.K);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.F, new c.e.a.b.a.e(), new a(), new Matrix(this.K));
        gVar.f("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        c.b.a.m.f.k4(animatorSet, arrayList);
        return animatorSet;
    }

    @NonNull
    public final ValueAnimator c(@NonNull AbstractC0045h abstractC0045h) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(abstractC0045h);
        valueAnimator.addUpdateListener(abstractC0045h);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public float d() {
        throw null;
    }

    public void e(@NonNull Rect rect) {
        int sizeDimension = this.m ? (this.r - this.F.getSizeDimension()) / 2 : 0;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(this.n ? d() + this.q : 0.0f));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    public void f(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        throw null;
    }

    public boolean g() {
        return this.F.getVisibility() == 0 ? this.B == 1 : this.B != 2;
    }

    public boolean h() {
        return this.F.getVisibility() != 0 ? this.B == 2 : this.B != 1;
    }

    public void i() {
        throw null;
    }

    public void j() {
        throw null;
    }

    public void k(int[] iArr) {
        throw null;
    }

    public void l(float f2, float f3, float f4) {
        throw null;
    }

    public void m() {
        ArrayList<e> arrayList = this.E;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public void n() {
        ArrayList<e> arrayList = this.E;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public final void o(float f2) {
        this.z = f2;
        Matrix matrix = this.K;
        a(f2, matrix);
        this.F.setImageMatrix(matrix);
    }

    public void p(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public final void q(@NonNull c.e.a.b.w.l lVar) {
        this.f1081h = lVar;
        MaterialShapeDrawable materialShapeDrawable = this.f1082i;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.f2333c.a = lVar;
            materialShapeDrawable.invalidateSelf();
        }
        Object obj = this.f1083j;
        if (obj instanceof p) {
            ((p) obj).setShapeAppearanceModel(lVar);
        }
        c.e.a.b.p.c cVar = this.f1084k;
        if (cVar != null) {
            cVar.o = lVar;
            cVar.invalidateSelf();
        }
    }

    public boolean r() {
        throw null;
    }

    public final boolean s() {
        return ViewCompat.isLaidOut(this.F) && !this.F.isInEditMode();
    }

    public final boolean t() {
        return !this.m || this.F.getSizeDimension() >= this.r;
    }

    public void u() {
        throw null;
    }

    public final void v() {
        Rect rect = this.H;
        e(rect);
        Preconditions.checkNotNull(this.f1085l, "Didn't initialize content background");
        if (r()) {
            InsetDrawable insetDrawable = new InsetDrawable(this.f1085l, rect.left, rect.top, rect.right, rect.bottom);
            FloatingActionButton.b bVar = (FloatingActionButton.b) this.G;
            Objects.requireNonNull(bVar);
            super/*android.widget.ImageButton*/.setBackgroundDrawable(insetDrawable);
        } else {
            c.e.a.b.v.b bVar2 = this.G;
            Drawable drawable = this.f1085l;
            FloatingActionButton.b bVar3 = (FloatingActionButton.b) bVar2;
            Objects.requireNonNull(bVar3);
            if (drawable != null) {
                super/*android.widget.ImageButton*/.setBackgroundDrawable(drawable);
            }
        }
        c.e.a.b.v.b bVar4 = this.G;
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        FloatingActionButton.b bVar5 = (FloatingActionButton.b) bVar4;
        FloatingActionButton.this.n.set(i2, i3, i4, i5);
        FloatingActionButton floatingActionButton = FloatingActionButton.this;
        int i6 = floatingActionButton.f2253k;
        floatingActionButton.setPadding(i2 + i6, i3 + i6, i4 + i6, i5 + i6);
    }

    public void w(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.f1082i;
        if (materialShapeDrawable != null) {
            MaterialShapeDrawable.b bVar = materialShapeDrawable.f2333c;
            if (bVar.o != f2) {
                bVar.o = f2;
                materialShapeDrawable.C();
            }
        }
    }
}
