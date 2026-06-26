package com.google.android.material.tooltip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import c.e.a.b.q.e;
import c.e.a.b.w.f;
import c.e.a.b.w.g;
import c.e.a.b.w.i;
import c.e.a.b.w.l;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TooltipDrawable extends MaterialShapeDrawable implements e.b {
    public static final /* synthetic */ int y = 0;

    @NonNull
    public final Context A;

    @Nullable
    public final Paint.FontMetrics B;

    @NonNull
    public final e C;

    @NonNull
    public final View.OnLayoutChangeListener D;

    @NonNull
    public final Rect E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public float O;
    public float P;
    public float Q;
    public float R;

    @Nullable
    public CharSequence z;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            TooltipDrawable tooltipDrawable = TooltipDrawable.this;
            int i10 = TooltipDrawable.y;
            Objects.requireNonNull(tooltipDrawable);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            tooltipDrawable.K = iArr[0];
            view.getWindowVisibleDisplayFrame(tooltipDrawable.E);
        }
    }

    public TooltipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        this.B = new Paint.FontMetrics();
        e eVar = new e(this);
        this.C = eVar;
        this.D = new a();
        this.E = new Rect();
        this.O = 1.0f;
        this.P = 1.0f;
        this.Q = 0.5f;
        this.R = 1.0f;
        this.A = context;
        eVar.a.density = context.getResources().getDisplayMetrics().density;
        eVar.a.setTextAlign(Paint.Align.CENTER);
    }

    public final float D() {
        int i2;
        if (((this.E.right - getBounds().right) - this.K) - this.I < 0) {
            i2 = ((this.E.right - getBounds().right) - this.K) - this.I;
        } else {
            if (((this.E.left - getBounds().left) - this.K) + this.I <= 0) {
                return 0.0f;
            }
            i2 = ((this.E.left - getBounds().left) - this.K) + this.I;
        }
        return i2;
    }

    public final f E() {
        float f2 = -D();
        float fWidth = ((float) (((double) getBounds().width()) - (Math.sqrt(2.0d) * ((double) this.J)))) / 2.0f;
        return new i(new g(this.J), Math.min(Math.max(f2, -fWidth), fWidth));
    }

    @Override // c.e.a.b.q.e.b
    public void a() {
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        float fD = D();
        float f2 = (float) (-((Math.sqrt(2.0d) * ((double) this.J)) - ((double) this.J)));
        canvas.scale(this.O, this.P, (getBounds().width() * 0.5f) + getBounds().left, (getBounds().height() * this.Q) + getBounds().top);
        canvas.translate(fD, f2);
        super.draw(canvas);
        if (this.z != null) {
            float fCenterY = getBounds().centerY();
            this.C.a.getFontMetrics(this.B);
            Paint.FontMetrics fontMetrics = this.B;
            int i2 = (int) (fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            e eVar = this.C;
            if (eVar.f1124f != null) {
                eVar.a.drawableState = getState();
                e eVar2 = this.C;
                eVar2.f1124f.c(this.A, eVar2.a, eVar2.f1120b);
                this.C.a.setAlpha((int) (this.R * 255.0f));
            }
            CharSequence charSequence = this.z;
            canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), i2, this.C.a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.C.a.getTextSize(), this.H);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        float f2 = this.F * 2;
        CharSequence charSequence = this.z;
        return (int) Math.max(f2 + (charSequence == null ? 0.0f : this.C.a(charSequence.toString())), this.G);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        l lVar = this.f2333c.a;
        Objects.requireNonNull(lVar);
        l.b bVar = new l.b(lVar);
        bVar.f1247k = E();
        this.f2333c.a = bVar.a();
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, c.e.a.b.q.e.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }
}
