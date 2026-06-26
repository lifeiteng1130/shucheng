package c.e.a.b.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;
import c.e.a.b.w.l;
import c.e.a.b.w.p;
import com.google.android.material.R$attr;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: compiled from: MaterialButtonHelper.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public final MaterialButton a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public l f982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public PorterDuff.Mode f989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public ColorStateList f990j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public ColorStateList f991k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public ColorStateList f992l;

    @Nullable
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;
    public int s;

    public a(MaterialButton materialButton, @NonNull l lVar) {
        this.a = materialButton;
        this.f982b = lVar;
    }

    @Nullable
    public p a() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.r.getNumberOfLayers() > 2 ? (p) this.r.getDrawable(2) : (p) this.r.getDrawable(1);
    }

    @Nullable
    public MaterialShapeDrawable b() {
        return c(false);
    }

    @Nullable
    public final MaterialShapeDrawable c(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    @Nullable
    public final MaterialShapeDrawable d() {
        return c(true);
    }

    public void e(@NonNull l lVar) {
        this.f982b = lVar;
        if (b() != null) {
            MaterialShapeDrawable materialShapeDrawableB = b();
            materialShapeDrawableB.f2333c.a = lVar;
            materialShapeDrawableB.invalidateSelf();
        }
        if (d() != null) {
            MaterialShapeDrawable materialShapeDrawableD = d();
            materialShapeDrawableD.f2333c.a = lVar;
            materialShapeDrawableD.invalidateSelf();
        }
        if (a() != null) {
            a().setShapeAppearanceModel(lVar);
        }
    }

    public final void f(@Dimension int i2, @Dimension int i3) {
        int paddingStart = ViewCompat.getPaddingStart(this.a);
        int paddingTop = this.a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        int i4 = this.f985e;
        int i5 = this.f986f;
        this.f986f = i3;
        this.f985e = i2;
        if (!this.o) {
            g();
        }
        ViewCompat.setPaddingRelative(this.a, paddingStart, (paddingTop + i2) - i4, paddingEnd, (paddingBottom + i3) - i5);
    }

    public final void g() {
        MaterialButton materialButton = this.a;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f982b);
        materialShapeDrawable.n(this.a.getContext());
        DrawableCompat.setTintList(materialShapeDrawable, this.f990j);
        PorterDuff.Mode mode = this.f989i;
        if (mode != null) {
            DrawableCompat.setTintMode(materialShapeDrawable, mode);
        }
        materialShapeDrawable.x(this.f988h, this.f991k);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.f982b);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.w(this.f988h, this.n ? f.Z1(this.a, R$attr.colorSurface) : 0);
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.f982b);
        this.m = materialShapeDrawable3;
        DrawableCompat.setTint(materialShapeDrawable3, -1);
        RippleDrawable rippleDrawable = new RippleDrawable(c.e.a.b.u.a.c(this.f992l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable}), this.f983c, this.f985e, this.f984d, this.f986f), this.m);
        this.r = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        MaterialShapeDrawable materialShapeDrawableB = b();
        if (materialShapeDrawableB != null) {
            materialShapeDrawableB.p(this.s);
        }
    }

    public final void h() {
        MaterialShapeDrawable materialShapeDrawableB = b();
        MaterialShapeDrawable materialShapeDrawableD = d();
        if (materialShapeDrawableB != null) {
            materialShapeDrawableB.x(this.f988h, this.f991k);
            if (materialShapeDrawableD != null) {
                materialShapeDrawableD.w(this.f988h, this.n ? f.Z1(this.a, R$attr.colorSurface) : 0);
            }
        }
    }
}
