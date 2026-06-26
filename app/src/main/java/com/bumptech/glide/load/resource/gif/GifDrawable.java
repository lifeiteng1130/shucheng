package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import c.b.a.b;
import c.b.a.m.p;
import c.b.a.m.r.g.f;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawable extends Drawable implements f.b, Animatable, Animatable2Compat {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f1606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Rect f1607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<Animatable2Compat.AnimationCallback> f1608k;

    public static final class a extends Drawable.ConstantState {

        @VisibleForTesting
        public final f a;

        public a(f fVar) {
            this.a = fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new GifDrawable(this);
        }
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, p<Bitmap> pVar, int i2, int i3, Bitmap bitmap) {
        a aVar = new a(new f(b.b(context), gifDecoder, i2, i3, pVar, bitmap));
        this.f1602e = true;
        this.f1604g = -1;
        this.a = aVar;
    }

    @Override // c.b.a.m.r.g.f.b
    public void a() {
        Object callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        f.a aVar = this.a.a.f579i;
        if ((aVar != null ? aVar.f584e : -1) == r0.a.c() - 1) {
            this.f1603f++;
        }
        int i2 = this.f1604g;
        if (i2 == -1 || this.f1603f < i2) {
            return;
        }
        List<Animatable2Compat.AnimationCallback> list = this.f1608k;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f1608k.get(i3).onAnimationEnd(this);
            }
        }
        stop();
    }

    public Bitmap b() {
        return this.a.a.f582l;
    }

    public final Paint c() {
        if (this.f1606i == null) {
            this.f1606i = new Paint(2);
        }
        return this.f1606i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f1608k;
        if (list != null) {
            list.clear();
        }
    }

    public final void d() {
        c.b.a.m.f.L0(!this.f1601d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.a.a.a.c() == 1) {
            invalidateSelf();
            return;
        }
        if (this.f1599b) {
            return;
        }
        this.f1599b = true;
        f fVar = this.a.a;
        if (fVar.f580j) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (fVar.f573c.contains(this)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = fVar.f573c.isEmpty();
        fVar.f573c.add(this);
        if (zIsEmpty && !fVar.f576f) {
            fVar.f576f = true;
            fVar.f580j = false;
            fVar.a();
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f1601d) {
            return;
        }
        if (this.f1605h) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f1607j == null) {
                this.f1607j = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f1607j);
            this.f1605h = false;
        }
        f fVar = this.a.a;
        f.a aVar = fVar.f579i;
        Bitmap bitmap = aVar != null ? aVar.f586g : fVar.f582l;
        if (this.f1607j == null) {
            this.f1607j = new Rect();
        }
        canvas.drawBitmap(bitmap, (Rect) null, this.f1607j, c());
    }

    public final void e() {
        this.f1599b = false;
        f fVar = this.a.a;
        fVar.f573c.remove(this);
        if (fVar.f573c.isEmpty()) {
            fVar.f576f = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.a.a.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.a.a.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f1599b;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1605h = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f1608k == null) {
            this.f1608k = new ArrayList();
        }
        this.f1608k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        c().setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        c.b.a.m.f.L0(!this.f1601d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f1602e = z;
        if (!z) {
            e();
        } else if (this.f1600c) {
            d();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f1600c = true;
        this.f1603f = 0;
        if (this.f1602e) {
            d();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f1600c = false;
        e();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f1608k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public GifDrawable(a aVar) {
        this.f1602e = true;
        this.f1604g = -1;
        this.a = aVar;
    }
}
