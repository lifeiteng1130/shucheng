package com.google.android.material.transition;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import c.b.a.m.f;
import c.e.a.b.e0.g;
import c.e.a.b.e0.l;
import c.e.a.b.e0.m;
import c.e.a.b.e0.n;
import c.e.a.b.q.h;
import c.e.a.b.q.i;
import c.e.a.b.w.l;
import c.e.a.b.w.p;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialContainerTransform extends Transition {
    public static final String a = MaterialContainerTransform.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f2526b = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f2527c = new d(new c(0.0f, 0.25f), new c(0.0f, 1.0f), new c(0.0f, 1.0f), new c(0.0f, 0.75f), null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f2528d = new d(new c(0.6f, 0.9f), new c(0.0f, 1.0f), new c(0.0f, 0.9f), new c(0.3f, 0.9f), null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f2529e = new d(new c(0.1f, 0.4f), new c(0.1f, 1.0f), new c(0.1f, 1.0f), new c(0.1f, 0.9f), null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f2530f = new d(new c(0.6f, 0.9f), new c(0.0f, 0.9f), new c(0.0f, 0.9f), new c(0.2f, 0.9f), null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @IdRes
    public int f2531g = R.id.content;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @IdRes
    public int f2532h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @IdRes
    public int f2533i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ColorInt
    public int f2534j = 1375731712;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f2536l;
    public float m;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FitMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TransitionDirection {
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ e a;

        public a(MaterialContainerTransform materialContainerTransform, e eVar) {
            this.a = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e eVar = this.a;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (eVar.L != animatedFraction) {
                eVar.e(animatedFraction);
            }
        }
    }

    public class b extends l {
        public final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f2537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f2538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f2539d;

        public b(View view, e eVar, View view2, View view3) {
            this.a = view;
            this.f2537b = eVar;
            this.f2538c = view2;
            this.f2539d = view3;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            MaterialContainerTransform.this.removeListener(this);
            MaterialContainerTransform materialContainerTransform = MaterialContainerTransform.this;
            String str = MaterialContainerTransform.a;
            Objects.requireNonNull(materialContainerTransform);
            this.f2538c.setAlpha(1.0f);
            this.f2539d.setAlpha(1.0f);
            i iVarH2 = f.H2(this.a);
            ((h) iVarH2).a.remove(this.f2537b);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            i iVarH2 = f.H2(this.a);
            ((h) iVarH2).a.add(this.f2537b);
            this.f2538c.setAlpha(0.0f);
            this.f2539d.setAlpha(0.0f);
        }
    }

    public static class c {

        @FloatRange(from = 0.0d, to = 1.0d)
        public final float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @FloatRange(from = 0.0d, to = 1.0d)
        public final float f2541b;

        public c(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
            this.a = f2;
            this.f2541b = f3;
        }
    }

    public static class d {

        @NonNull
        public final c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final c f2542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public final c f2543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        public final c f2544d;

        public d(c cVar, c cVar2, c cVar3, c cVar4, a aVar) {
            this.a = cVar;
            this.f2542b = cVar2;
            this.f2543c = cVar3;
            this.f2544d = cVar4;
        }
    }

    public static final class e extends Drawable {
        public final d A;
        public final c.e.a.b.e0.a B;
        public final c.e.a.b.e0.f C;
        public final boolean D;
        public final Paint E;
        public final Path F;
        public c.e.a.b.e0.c G;
        public c.e.a.b.e0.h H;
        public RectF I;
        public float J;
        public float K;
        public float L;
        public final View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RectF f2545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c.e.a.b.w.l f2546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f2547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f2548e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RectF f2549f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c.e.a.b.w.l f2550g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f2551h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Paint f2552i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Paint f2553j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Paint f2554k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Paint f2555l;
        public final Paint m;
        public final c.e.a.b.e0.i n;
        public final PathMeasure o;
        public final float p;
        public final float[] q;
        public final boolean r;
        public final float s;
        public final float t;
        public final boolean u;
        public final MaterialShapeDrawable v;
        public final RectF w;
        public final RectF x;
        public final RectF y;
        public final RectF z;

        public class a implements n.a {
            public a() {
            }

            @Override // c.e.a.b.e0.n.a
            public void a(Canvas canvas) {
                e.this.a.draw(canvas);
            }
        }

        public class b implements n.a {
            public b() {
            }

            @Override // c.e.a.b.e0.n.a
            public void a(Canvas canvas) {
                e.this.f2548e.draw(canvas);
            }
        }

        public e(PathMotion pathMotion, View view, RectF rectF, c.e.a.b.w.l lVar, float f2, View view2, RectF rectF2, c.e.a.b.w.l lVar2, float f3, int i2, int i3, int i4, int i5, boolean z, boolean z2, c.e.a.b.e0.a aVar, c.e.a.b.e0.f fVar, d dVar, boolean z3, a aVar2) {
            Paint paint = new Paint();
            this.f2552i = paint;
            Paint paint2 = new Paint();
            this.f2553j = paint2;
            Paint paint3 = new Paint();
            this.f2554k = paint3;
            this.f2555l = new Paint();
            Paint paint4 = new Paint();
            this.m = paint4;
            this.n = new c.e.a.b.e0.i();
            this.q = new float[]{rectF.centerX(), rectF.top};
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.v = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.a = view;
            this.f2545b = rectF;
            this.f2546c = lVar;
            this.f2547d = f2;
            this.f2548e = view2;
            this.f2549f = rectF2;
            this.f2550g = lVar2;
            this.f2551h = f3;
            this.r = z;
            this.u = z2;
            this.B = aVar;
            this.C = fVar;
            this.A = dVar;
            this.D = z3;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
            this.s = r12.widthPixels;
            this.t = r12.heightPixels;
            paint.setColor(i2);
            paint2.setColor(i3);
            paint3.setColor(i4);
            materialShapeDrawable.q(ColorStateList.valueOf(0));
            materialShapeDrawable.u(2);
            materialShapeDrawable.x = false;
            materialShapeDrawable.t(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.w = rectF3;
            this.x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.y = rectF4;
            this.z = new RectF(rectF4);
            PointF pointFC = c(rectF);
            PointF pointFC2 = c(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(pointFC.x, pointFC.y, pointFC2.x, pointFC2.y), false);
            this.o = pathMeasure;
            this.p = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            RectF rectF5 = n.a;
            paint4.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i5, i5, Shader.TileMode.CLAMP));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            e(0.0f);
        }

        public static PointF c(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        public final void a(Canvas canvas) {
            d(canvas, this.f2554k);
            Rect bounds = getBounds();
            RectF rectF = this.y;
            n.h(canvas, bounds, rectF.left, rectF.top, this.H.f967b, this.G.f954b, new b());
        }

        public final void b(Canvas canvas) {
            d(canvas, this.f2553j);
            Rect bounds = getBounds();
            RectF rectF = this.w;
            n.h(canvas, bounds, rectF.left, rectF.top, this.H.a, this.G.a, new a());
        }

        public final void d(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (this.m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.m);
            }
            int iSave = this.D ? canvas.save() : -1;
            if (this.u && this.J > 0.0f) {
                canvas.save();
                canvas.clipPath(this.n.a, Region.Op.DIFFERENCE);
                if (Build.VERSION.SDK_INT > 28) {
                    c.e.a.b.w.l lVar = this.n.f975e;
                    if (lVar.e(this.I)) {
                        float fA = lVar.f1231f.a(this.I);
                        canvas.drawRoundRect(this.I, fA, fA, this.f2555l);
                    } else {
                        canvas.drawPath(this.n.a, this.f2555l);
                    }
                } else {
                    MaterialShapeDrawable materialShapeDrawable = this.v;
                    RectF rectF = this.I;
                    materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    this.v.p(this.J);
                    this.v.v((int) this.K);
                    this.v.setShapeAppearanceModel(this.n.f975e);
                    this.v.draw(canvas);
                }
                canvas.restore();
            }
            c.e.a.b.e0.i iVar = this.n;
            if (Build.VERSION.SDK_INT >= 23) {
                canvas.clipPath(iVar.a);
            } else {
                canvas.clipPath(iVar.f972b);
                canvas.clipPath(iVar.f973c, Region.Op.UNION);
            }
            d(canvas, this.f2552i);
            if (this.G.f955c) {
                b(canvas);
                a(canvas);
            } else {
                a(canvas);
                b(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(iSave);
                RectF rectF2 = this.w;
                Path path = this.F;
                PointF pointFC = c(rectF2);
                if (this.L == 0.0f) {
                    path.reset();
                    path.moveTo(pointFC.x, pointFC.y);
                } else {
                    path.lineTo(pointFC.x, pointFC.y);
                    this.E.setColor(-65281);
                    canvas.drawPath(path, this.E);
                }
                RectF rectF3 = this.x;
                this.E.setColor(InputDeviceCompat.SOURCE_ANY);
                canvas.drawRect(rectF3, this.E);
                RectF rectF4 = this.w;
                this.E.setColor(-16711936);
                canvas.drawRect(rectF4, this.E);
                RectF rectF5 = this.z;
                this.E.setColor(-16711681);
                canvas.drawRect(rectF5, this.E);
                RectF rectF6 = this.y;
                this.E.setColor(-16776961);
                canvas.drawRect(rectF6, this.E);
            }
        }

        public final void e(float f2) {
            float f3;
            float f4;
            this.L = f2;
            this.m.setAlpha((int) (this.r ? n.d(0.0f, 255.0f, f2) : n.d(255.0f, 0.0f, f2)));
            this.o.getPosTan(this.p * f2, this.q, null);
            float[] fArr = this.q;
            float fA = fArr[0];
            float fA2 = fArr[1];
            if (f2 > 1.0f || f2 < 0.0f) {
                if (f2 > 1.0f) {
                    f3 = 0.99f;
                    f4 = (f2 - 1.0f) / 0.00999999f;
                } else {
                    f3 = 0.01f;
                    f4 = (f2 / 0.01f) * (-1.0f);
                }
                this.o.getPosTan(this.p * f3, fArr, null);
                float[] fArr2 = this.q;
                float f5 = fArr2[0];
                float f6 = fArr2[1];
                fA = c.a.a.a.a.a(fA, f5, f4, fA);
                fA2 = c.a.a.a.a.a(fA2, f6, f4, fA2);
            }
            float f7 = fA;
            float f8 = fA2;
            c.e.a.b.e0.h hVarC = this.C.c(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f2542b.a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f2542b.f2541b))).floatValue(), this.f2545b.width(), this.f2545b.height(), this.f2549f.width(), this.f2549f.height());
            this.H = hVarC;
            RectF rectF = this.w;
            float f9 = hVarC.f968c / 2.0f;
            rectF.set(f7 - f9, f8, f9 + f7, hVarC.f969d + f8);
            RectF rectF2 = this.y;
            c.e.a.b.e0.h hVar = this.H;
            float f10 = hVar.f970e / 2.0f;
            rectF2.set(f7 - f10, f8, f10 + f7, hVar.f971f + f8);
            this.x.set(this.w);
            this.z.set(this.y);
            float fFloatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f2543c.a))).floatValue();
            float fFloatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f2543c.f2541b))).floatValue();
            boolean zA = this.C.a(this.H);
            RectF rectF3 = zA ? this.x : this.z;
            float fE = n.e(0.0f, 1.0f, fFloatValue, fFloatValue2, f2);
            if (!zA) {
                fE = 1.0f - fE;
            }
            this.C.b(rectF3, fE, this.H);
            this.I = new RectF(Math.min(this.x.left, this.z.left), Math.min(this.x.top, this.z.top), Math.max(this.x.right, this.z.right), Math.max(this.x.bottom, this.z.bottom));
            c.e.a.b.e0.i iVar = this.n;
            c.e.a.b.w.l lVarA = this.f2546c;
            c.e.a.b.w.l lVar = this.f2550g;
            RectF rectF4 = this.w;
            RectF rectF5 = this.x;
            RectF rectF6 = this.z;
            c cVar = this.A.f2544d;
            Objects.requireNonNull(iVar);
            float f11 = cVar.a;
            float f12 = cVar.f2541b;
            RectF rectF7 = n.a;
            if (f2 >= f11) {
                if (f2 > f12) {
                    lVarA = lVar;
                } else {
                    c.e.a.b.w.l lVar2 = (lVarA.f1231f.a(rectF4) == 0.0f && lVarA.f1232g.a(rectF4) == 0.0f && lVarA.f1233h.a(rectF4) == 0.0f && lVarA.f1234i.a(rectF4) == 0.0f) ? false : true ? lVarA : lVar;
                    Objects.requireNonNull(lVar2);
                    l.b bVar = new l.b(lVar2);
                    bVar.f1241e = new c.e.a.b.w.a(n.e(lVarA.f1231f.a(rectF4), lVar.f1231f.a(rectF6), f11, f12, f2));
                    bVar.f1242f = new c.e.a.b.w.a(n.e(lVarA.f1232g.a(rectF4), lVar.f1232g.a(rectF6), f11, f12, f2));
                    bVar.f1244h = new c.e.a.b.w.a(n.e(lVarA.f1234i.a(rectF4), lVar.f1234i.a(rectF6), f11, f12, f2));
                    bVar.f1243g = new c.e.a.b.w.a(n.e(lVarA.f1233h.a(rectF4), lVar.f1233h.a(rectF6), f11, f12, f2));
                    lVarA = bVar.a();
                }
            }
            iVar.f975e = lVarA;
            iVar.f974d.a(lVarA, 1.0f, rectF5, iVar.f972b);
            iVar.f974d.a(iVar.f975e, 1.0f, rectF6, iVar.f973c);
            if (Build.VERSION.SDK_INT >= 23) {
                iVar.a.op(iVar.f972b, iVar.f973c, Path.Op.UNION);
            }
            this.J = n.d(this.f2547d, this.f2551h, f2);
            float fCenterX = ((this.I.centerX() / (this.s / 2.0f)) - 1.0f) * 0.3f;
            float fCenterY = (this.I.centerY() / this.t) * 1.5f;
            float f13 = this.J;
            float f14 = (int) (fCenterY * f13);
            this.K = f14;
            this.f2555l.setShadowLayer(f13, (int) (fCenterX * f13), f14, 754974720);
            this.G = this.B.a(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.a.a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.a.f2541b))).floatValue());
            if (this.f2553j.getColor() != 0) {
                this.f2553j.setAlpha(this.G.a);
            }
            if (this.f2554k.getColor() != 0) {
                this.f2554k.setAlpha(this.G.f954b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    public MaterialContainerTransform() {
        this.f2535k = Build.VERSION.SDK_INT >= 28;
        this.f2536l = -1.0f;
        this.m = -1.0f;
        setInterpolator(c.e.a.b.a.a.f839b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i2, @Nullable c.e.a.b.w.l lVar) {
        RectF rectFC;
        c.e.a.b.w.l lVarA;
        if (i2 != -1) {
            View view2 = transitionValues.view;
            RectF rectF = n.a;
            View viewFindViewById = view2.findViewById(i2);
            if (viewFindViewById == null) {
                viewFindViewById = n.b(view2, i2);
            }
            transitionValues.view = viewFindViewById;
        } else {
            View view3 = transitionValues.view;
            int i3 = R$id.mtrl_motion_snapshot_view;
            if (view3.getTag(i3) instanceof View) {
                View view4 = (View) transitionValues.view.getTag(i3);
                transitionValues.view.setTag(i3, null);
                transitionValues.view = view4;
            }
        }
        View view5 = transitionValues.view;
        if (!ViewCompat.isLaidOut(view5) && view5.getWidth() == 0 && view5.getHeight() == 0) {
            return;
        }
        if (view5.getParent() == null) {
            RectF rectF2 = n.a;
            rectFC = new RectF(view5.getLeft(), view5.getTop(), view5.getRight(), view5.getBottom());
        } else {
            rectFC = n.c(view5);
        }
        transitionValues.values.put("materialContainerTransition:bounds", rectFC);
        Map<String, Object> map = transitionValues.values;
        int i4 = R$id.mtrl_motion_snapshot_view;
        if (view5.getTag(i4) instanceof c.e.a.b.w.l) {
            lVarA = (c.e.a.b.w.l) view5.getTag(i4);
        } else {
            Context context = view5.getContext();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R$attr.transitionShapeAppearance});
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
            typedArrayObtainStyledAttributes.recycle();
            lVarA = resourceId != -1 ? c.e.a.b.w.l.a(context, resourceId, 0).a() : view5 instanceof p ? ((p) view5).getShapeAppearanceModel() : new l.b().a();
        }
        RectF rectF3 = n.a;
        map.put("materialContainerTransition:shapeAppearance", lVarA.g(new m(rectFC)));
    }

    public final d b(boolean z, d dVar, d dVar2) {
        if (!z) {
            dVar = dVar2;
        }
        return new d((c) n.a(null, dVar.a), (c) n.a(null, dVar.f2542b), (c) n.a(null, dVar.f2543c), (c) n.a(null, dVar.f2544d), null);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        a(transitionValues, null, this.f2533i, null);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        a(transitionValues, null, this.f2532h, null);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        View viewB;
        RectF rectF;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF2 = (RectF) transitionValues.values.get("materialContainerTransition:bounds");
            c.e.a.b.w.l lVar = (c.e.a.b.w.l) transitionValues.values.get("materialContainerTransition:shapeAppearance");
            if (rectF2 != null && lVar != null) {
                RectF rectF3 = (RectF) transitionValues2.values.get("materialContainerTransition:bounds");
                c.e.a.b.w.l lVar2 = (c.e.a.b.w.l) transitionValues2.values.get("materialContainerTransition:shapeAppearance");
                if (rectF3 != null && lVar2 != null) {
                    View view = transitionValues.view;
                    View view2 = transitionValues2.view;
                    View view3 = view2.getParent() != null ? view2 : view;
                    if (this.f2531g == view3.getId()) {
                        viewB = (View) view3.getParent();
                    } else {
                        viewB = n.b(view3, this.f2531g);
                        view3 = null;
                    }
                    RectF rectFC = n.c(viewB);
                    float f2 = -rectFC.left;
                    float f3 = -rectFC.top;
                    if (view3 != null) {
                        rectF = n.c(view3);
                        rectF.offset(f2, f3);
                    } else {
                        rectF = new RectF(0.0f, 0.0f, viewB.getWidth(), viewB.getHeight());
                    }
                    rectF2.offset(f2, f3);
                    rectF3.offset(f2, f3);
                    RectF rectF4 = n.a;
                    boolean z = false;
                    boolean z2 = rectF3.height() * rectF3.width() > rectF2.height() * rectF2.width();
                    PathMotion pathMotion = getPathMotion();
                    float elevation = this.f2536l;
                    if (elevation == -1.0f) {
                        elevation = ViewCompat.getElevation(view);
                    }
                    float f4 = elevation;
                    float elevation2 = this.m;
                    if (elevation2 == -1.0f) {
                        elevation2 = ViewCompat.getElevation(view2);
                    }
                    float f5 = elevation2;
                    int i2 = this.f2534j;
                    boolean z3 = this.f2535k;
                    c.e.a.b.e0.a aVar = z2 ? c.e.a.b.e0.b.a : c.e.a.b.e0.b.f951b;
                    float fWidth = rectF2.width();
                    float fHeight = rectF2.height();
                    float fWidth2 = rectF3.width();
                    float fHeight2 = rectF3.height();
                    float f6 = (fHeight2 * fWidth) / fWidth2;
                    float f7 = (fWidth2 * fHeight) / fWidth;
                    if (!z2 ? f7 >= fHeight2 : f6 >= fHeight) {
                        z = true;
                    }
                    c.e.a.b.e0.f fVar = z ? g.a : g.f966b;
                    PathMotion pathMotion2 = getPathMotion();
                    e eVar = new e(pathMotion, view, rectF2, lVar, f4, view2, rectF3, lVar2, f5, 0, 0, 0, i2, z2, z3, aVar, fVar, ((pathMotion2 instanceof ArcMotion) || (pathMotion2 instanceof MaterialArcMotion)) ? b(z2, f2529e, f2530f) : b(z2, f2527c, f2528d), false, null);
                    eVar.setBounds(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.addUpdateListener(new a(this, eVar));
                    addListener(new b(viewB, eVar, view, view2));
                    return valueAnimatorOfFloat;
                }
            }
        }
        return null;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return f2526b;
    }
}
