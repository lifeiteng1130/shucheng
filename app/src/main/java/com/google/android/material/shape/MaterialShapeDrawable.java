package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import c.e.a.b.w.l;
import c.e.a.b.w.m;
import c.e.a.b.w.o;
import c.e.a.b.w.p;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, p {
    public static final String a = MaterialShapeDrawable.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Paint f2332b = new Paint(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f2333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o.f[] f2334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o.f[] f2335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BitSet f2336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Matrix f2338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f2339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f2340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f2341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f2342l;
    public final Region m;
    public final Region n;
    public l o;
    public final Paint p;
    public final Paint q;
    public final c.e.a.b.v.a r;

    @NonNull
    public final m.b s;
    public final m t;

    @Nullable
    public PorterDuffColorFilter u;

    @Nullable
    public PorterDuffColorFilter v;

    @NonNull
    public final RectF w;
    public boolean x;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    public class a implements m.b {
        public a() {
        }
    }

    public MaterialShapeDrawable() {
        this(new l());
    }

    public final boolean A(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f2333c.f2345d == null || color2 == (colorForState2 = this.f2333c.f2345d.getColorForState(iArr, (color2 = this.p.getColor())))) {
            z = false;
        } else {
            this.p.setColor(colorForState2);
            z = true;
        }
        if (this.f2333c.f2346e == null || color == (colorForState = this.f2333c.f2346e.getColorForState(iArr, (color = this.q.getColor())))) {
            return z;
        }
        this.q.setColor(colorForState);
        return true;
    }

    public final boolean B() {
        PorterDuffColorFilter porterDuffColorFilter = this.u;
        PorterDuffColorFilter porterDuffColorFilter2 = this.v;
        b bVar = this.f2333c;
        this.u = d(bVar.f2348g, bVar.f2349h, this.p, true);
        b bVar2 = this.f2333c;
        this.v = d(bVar2.f2347f, bVar2.f2349h, this.q, false);
        b bVar3 = this.f2333c;
        if (bVar3.u) {
            this.r.a(bVar3.f2348g.getColorForState(getState(), 0));
        }
        return (ObjectsCompat.equals(porterDuffColorFilter, this.u) && ObjectsCompat.equals(porterDuffColorFilter2, this.v)) ? false : true;
    }

    public final void C() {
        b bVar = this.f2333c;
        float f2 = bVar.o + bVar.p;
        bVar.r = (int) Math.ceil(0.75f * f2);
        this.f2333c.s = (int) Math.ceil(f2 * 0.25f);
        B();
        super.invalidateSelf();
    }

    public final void b(@NonNull RectF rectF, @NonNull Path path) {
        c(rectF, path);
        if (this.f2333c.f2351j != 1.0f) {
            this.f2338h.reset();
            Matrix matrix = this.f2338h;
            float f2 = this.f2333c.f2351j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f2338h);
        }
        path.computeBounds(this.w, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void c(@NonNull RectF rectF, @NonNull Path path) {
        m mVar = this.t;
        b bVar = this.f2333c;
        mVar.b(bVar.a, bVar.f2352k, rectF, this.s, path);
    }

    @NonNull
    public final PorterDuffColorFilter d(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z) {
        int color;
        int iE;
        if (colorStateList == null || mode == null) {
            return (!z || (iE = e((color = paint.getColor()))) == color) ? null : new PorterDuffColorFilter(iE, PorterDuff.Mode.SRC_IN);
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = e(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas r11) {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.MaterialShapeDrawable.draw(android.graphics.Canvas):void");
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int e(@ColorInt int i2) {
        b bVar = this.f2333c;
        float f2 = bVar.o + bVar.p + bVar.n;
        c.e.a.b.n.a aVar = bVar.f2343b;
        return aVar != null ? aVar.a(i2, f2) : i2;
    }

    public final void f(@NonNull Canvas canvas) {
        this.f2336f.cardinality();
        if (this.f2333c.s != 0) {
            canvas.drawPath(this.f2339i, this.r.f1217e);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            o.f fVar = this.f2334d[i2];
            c.e.a.b.v.a aVar = this.r;
            int i3 = this.f2333c.r;
            Matrix matrix = o.f.a;
            fVar.a(matrix, aVar, i3, canvas);
            this.f2335e[i2].a(matrix, this.r, this.f2333c.r, canvas);
        }
        if (this.x) {
            int i4 = i();
            int iJ = j();
            canvas.translate(-i4, -iJ);
            canvas.drawPath(this.f2339i, f2332b);
            canvas.translate(i4, iJ);
        }
    }

    public final void g(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull l lVar, @NonNull RectF rectF) {
        if (!lVar.e(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = lVar.f1232g.a(rectF) * this.f2333c.f2352k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f2333c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f2333c.q == 2) {
            return;
        }
        if (o()) {
            outline.setRoundRect(getBounds(), l() * this.f2333c.f2352k);
            return;
        }
        b(h(), this.f2339i);
        if (this.f2339i.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f2339i);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.f2333c.f2350i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // c.e.a.b.w.p
    @NonNull
    public l getShapeAppearanceModel() {
        return this.f2333c.a;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.m.set(getBounds());
        b(h(), this.f2339i);
        this.n.setPath(this.f2339i, this.m);
        this.m.op(this.n, Region.Op.DIFFERENCE);
        return this.m;
    }

    @NonNull
    public RectF h() {
        this.f2341k.set(getBounds());
        return this.f2341k;
    }

    public int i() {
        return (int) (Math.sin(Math.toRadians(r0.t)) * ((double) this.f2333c.s));
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f2337g = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f2333c.f2348g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f2333c.f2347f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f2333c.f2346e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f2333c.f2345d) != null && colorStateList4.isStateful())));
    }

    public int j() {
        return (int) (Math.cos(Math.toRadians(r0.t)) * ((double) this.f2333c.s));
    }

    public final float k() {
        if (m()) {
            return this.q.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float l() {
        return this.f2333c.a.f1231f.a(h());
    }

    public final boolean m() {
        Paint.Style style = this.f2333c.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.q.getStrokeWidth() > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.f2333c = new b(this.f2333c);
        return this;
    }

    public void n(Context context) {
        this.f2333c.f2343b = new c.e.a.b.n.a(context);
        C();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean o() {
        return this.f2333c.a.e(h());
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f2337g = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, c.e.a.b.q.e.b
    public boolean onStateChange(int[] iArr) {
        boolean z = A(iArr) || B();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public void p(float f2) {
        b bVar = this.f2333c;
        if (bVar.o != f2) {
            bVar.o = f2;
            C();
        }
    }

    public void q(@Nullable ColorStateList colorStateList) {
        b bVar = this.f2333c;
        if (bVar.f2345d != colorStateList) {
            bVar.f2345d = colorStateList;
            onStateChange(getState());
        }
    }

    public void r(float f2) {
        b bVar = this.f2333c;
        if (bVar.f2352k != f2) {
            bVar.f2352k = f2;
            this.f2337g = true;
            invalidateSelf();
        }
    }

    public void s(Paint.Style style) {
        this.f2333c.v = style;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        b bVar = this.f2333c;
        if (bVar.m != i2) {
            bVar.m = i2;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f2333c.f2344c = colorFilter;
        super.invalidateSelf();
    }

    @Override // c.e.a.b.w.p
    public void setShapeAppearanceModel(@NonNull l lVar) {
        this.f2333c.a = lVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f2333c.f2348g = colorStateList;
        B();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        b bVar = this.f2333c;
        if (bVar.f2349h != mode) {
            bVar.f2349h = mode;
            B();
            super.invalidateSelf();
        }
    }

    public void t(int i2) {
        this.r.a(i2);
        this.f2333c.u = false;
        super.invalidateSelf();
    }

    public void u(int i2) {
        b bVar = this.f2333c;
        if (bVar.q != i2) {
            bVar.q = i2;
            super.invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void v(int i2) {
        b bVar = this.f2333c;
        if (bVar.s != i2) {
            bVar.s = i2;
            super.invalidateSelf();
        }
    }

    public void w(float f2, @ColorInt int i2) {
        this.f2333c.f2353l = f2;
        invalidateSelf();
        y(ColorStateList.valueOf(i2));
    }

    public void x(float f2, @Nullable ColorStateList colorStateList) {
        this.f2333c.f2353l = f2;
        invalidateSelf();
        y(colorStateList);
    }

    public void y(@Nullable ColorStateList colorStateList) {
        b bVar = this.f2333c;
        if (bVar.f2346e != colorStateList) {
            bVar.f2346e = colorStateList;
            onStateChange(getState());
        }
    }

    public void z(float f2) {
        this.f2333c.f2353l = f2;
        invalidateSelf();
    }

    public MaterialShapeDrawable(@NonNull l lVar) {
        this(new b(lVar, null));
    }

    public MaterialShapeDrawable(@NonNull b bVar) {
        m mVar;
        this.f2334d = new o.f[4];
        this.f2335e = new o.f[4];
        this.f2336f = new BitSet(8);
        this.f2338h = new Matrix();
        this.f2339i = new Path();
        this.f2340j = new Path();
        this.f2341k = new RectF();
        this.f2342l = new RectF();
        this.m = new Region();
        this.n = new Region();
        Paint paint = new Paint(1);
        this.p = paint;
        Paint paint2 = new Paint(1);
        this.q = paint2;
        this.r = new c.e.a.b.v.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            mVar = m.a.a;
        } else {
            mVar = new m();
        }
        this.t = mVar;
        this.w = new RectF();
        this.x = true;
        this.f2333c = bVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = f2332b;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        B();
        A(getState());
        this.s = new a();
    }

    public static final class b extends Drawable.ConstantState {

        @NonNull
        public l a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public c.e.a.b.n.a f2343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public ColorFilter f2344c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public ColorStateList f2345d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public ColorStateList f2346e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public ColorStateList f2347f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public ColorStateList f2348g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public PorterDuff.Mode f2349h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public Rect f2350i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f2351j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f2352k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f2353l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public b(l lVar, c.e.a.b.n.a aVar) {
            this.f2345d = null;
            this.f2346e = null;
            this.f2347f = null;
            this.f2348g = null;
            this.f2349h = PorterDuff.Mode.SRC_IN;
            this.f2350i = null;
            this.f2351j = 1.0f;
            this.f2352k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = lVar;
            this.f2343b = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            materialShapeDrawable.f2337g = true;
            return materialShapeDrawable;
        }

        public b(@NonNull b bVar) {
            this.f2345d = null;
            this.f2346e = null;
            this.f2347f = null;
            this.f2348g = null;
            this.f2349h = PorterDuff.Mode.SRC_IN;
            this.f2350i = null;
            this.f2351j = 1.0f;
            this.f2352k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = bVar.a;
            this.f2343b = bVar.f2343b;
            this.f2353l = bVar.f2353l;
            this.f2344c = bVar.f2344c;
            this.f2345d = bVar.f2345d;
            this.f2346e = bVar.f2346e;
            this.f2349h = bVar.f2349h;
            this.f2348g = bVar.f2348g;
            this.m = bVar.m;
            this.f2351j = bVar.f2351j;
            this.s = bVar.s;
            this.q = bVar.q;
            this.u = bVar.u;
            this.f2352k = bVar.f2352k;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.r = bVar.r;
            this.t = bVar.t;
            this.f2347f = bVar.f2347f;
            this.v = bVar.v;
            if (bVar.f2350i != null) {
                this.f2350i = new Rect(bVar.f2350i);
            }
        }
    }

    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        this(l.c(context, attributeSet, i2, i3, new c.e.a.b.w.a(0)).a());
    }
}
