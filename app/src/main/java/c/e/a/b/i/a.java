package c.e.a.b.i;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import c.e.a.b.w.d;
import c.e.a.b.w.e;
import c.e.a.b.w.k;
import c.e.a.b.w.l;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Objects;

/* JADX INFO: compiled from: MaterialCardViewHelper.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public static final int[] a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final double f993b = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final MaterialCardView f994c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final MaterialShapeDrawable f996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final MaterialShapeDrawable f997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Dimension
    public int f998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Dimension
    public int f999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Dimension
    public int f1000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Drawable f1001j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public Drawable f1002k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public ColorStateList f1003l;

    @Nullable
    public ColorStateList m;

    @Nullable
    public l n;

    @Nullable
    public ColorStateList o;

    @Nullable
    public Drawable p;

    @Nullable
    public LayerDrawable q;

    @Nullable
    public MaterialShapeDrawable r;

    @Nullable
    public MaterialShapeDrawable s;
    public boolean u;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Rect f995d = new Rect();
    public boolean t = false;

    /* JADX INFO: renamed from: c.e.a.b.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MaterialCardViewHelper.java */
    public class C0043a extends InsetDrawable {
        public C0043a(a aVar, Drawable drawable, int i2, int i3, int i4, int i5) {
            super(drawable, i2, i3, i4, i5);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public a(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i2, @StyleRes int i3) {
        this.f994c = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i2, i3);
        this.f996e = materialShapeDrawable;
        materialShapeDrawable.n(materialCardView.getContext());
        materialShapeDrawable.t(-12303292);
        l lVar = materialShapeDrawable.f2333c.a;
        Objects.requireNonNull(lVar);
        l.b bVar = new l.b(lVar);
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, i2, R$style.CardView);
        int i4 = R$styleable.CardView_cardCornerRadius;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            bVar.c(typedArrayObtainStyledAttributes.getDimension(i4, 0.0f));
        }
        this.f997f = new MaterialShapeDrawable();
        h(bVar.a());
        typedArrayObtainStyledAttributes.recycle();
    }

    public final float a() {
        float fB = b(this.n.f1227b, this.f996e.l());
        d dVar = this.n.f1228c;
        MaterialShapeDrawable materialShapeDrawable = this.f996e;
        float fMax = Math.max(fB, b(dVar, materialShapeDrawable.f2333c.a.f1232g.a(materialShapeDrawable.h())));
        d dVar2 = this.n.f1229d;
        MaterialShapeDrawable materialShapeDrawable2 = this.f996e;
        float fB2 = b(dVar2, materialShapeDrawable2.f2333c.a.f1233h.a(materialShapeDrawable2.h()));
        d dVar3 = this.n.f1230e;
        MaterialShapeDrawable materialShapeDrawable3 = this.f996e;
        return Math.max(fMax, Math.max(fB2, b(dVar3, materialShapeDrawable3.f2333c.a.f1234i.a(materialShapeDrawable3.h()))));
    }

    public final float b(d dVar, float f2) {
        if (dVar instanceof k) {
            return (float) ((1.0d - f993b) * ((double) f2));
        }
        if (dVar instanceof e) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    public final float c() {
        return this.f994c.getMaxCardElevation() + (j() ? a() : 0.0f);
    }

    public final float d() {
        return (this.f994c.getMaxCardElevation() * 1.5f) + (j() ? a() : 0.0f);
    }

    @NonNull
    public final Drawable e() {
        if (this.p == null) {
            int[] iArr = c.e.a.b.u.a.a;
            this.s = new MaterialShapeDrawable(this.n);
            this.p = new RippleDrawable(this.f1003l, null, this.s);
        }
        if (this.q == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.f1002k;
            if (drawable != null) {
                stateListDrawable.addState(a, drawable);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.p, this.f997f, stateListDrawable});
            this.q = layerDrawable;
            layerDrawable.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.q;
    }

    @NonNull
    public final Drawable f(Drawable drawable) {
        int iCeil;
        int i2;
        if (this.f994c.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil(d());
            iCeil = (int) Math.ceil(c());
            i2 = iCeil2;
        } else {
            iCeil = 0;
            i2 = 0;
        }
        return new C0043a(this, drawable, iCeil, i2, iCeil, i2);
    }

    public void g(@Nullable Drawable drawable) {
        this.f1002k = drawable;
        if (drawable != null) {
            Drawable drawableWrap = DrawableCompat.wrap(drawable.mutate());
            this.f1002k = drawableWrap;
            DrawableCompat.setTintList(drawableWrap, this.m);
        }
        if (this.q != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = this.f1002k;
            if (drawable2 != null) {
                stateListDrawable.addState(a, drawable2);
            }
            this.q.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, stateListDrawable);
        }
    }

    public void h(@NonNull l lVar) {
        this.n = lVar;
        MaterialShapeDrawable materialShapeDrawable = this.f996e;
        materialShapeDrawable.f2333c.a = lVar;
        materialShapeDrawable.invalidateSelf();
        this.f996e.x = !r0.o();
        MaterialShapeDrawable materialShapeDrawable2 = this.f997f;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.f2333c.a = lVar;
            materialShapeDrawable2.invalidateSelf();
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.s;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.f2333c.a = lVar;
            materialShapeDrawable3.invalidateSelf();
        }
        MaterialShapeDrawable materialShapeDrawable4 = this.r;
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.f2333c.a = lVar;
            materialShapeDrawable4.invalidateSelf();
        }
    }

    public final boolean i() {
        return this.f994c.getPreventCornerOverlap() && !this.f996e.o();
    }

    public final boolean j() {
        return this.f994c.getPreventCornerOverlap() && this.f996e.o() && this.f994c.getUseCompatPadding();
    }

    public void k() {
        float cardViewRadius = 0.0f;
        float fA = i() || j() ? a() : 0.0f;
        if (this.f994c.getPreventCornerOverlap() && this.f994c.getUseCompatPadding()) {
            cardViewRadius = (float) ((1.0d - f993b) * ((double) this.f994c.getCardViewRadius()));
        }
        int i2 = (int) (fA - cardViewRadius);
        MaterialCardView materialCardView = this.f994c;
        Rect rect = this.f995d;
        materialCardView.g(rect.left + i2, rect.top + i2, rect.right + i2, rect.bottom + i2);
    }

    public void l() {
        if (!this.t) {
            this.f994c.setBackgroundInternal(f(this.f996e));
        }
        this.f994c.setForeground(f(this.f1001j));
    }

    public final void m() {
        int[] iArr = c.e.a.b.u.a.a;
        Drawable drawable = this.p;
        if (drawable != null) {
            ((RippleDrawable) drawable).setColor(this.f1003l);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.r;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.q(this.f1003l);
        }
    }

    public void n() {
        this.f997f.x(this.f1000i, this.o);
    }
}
