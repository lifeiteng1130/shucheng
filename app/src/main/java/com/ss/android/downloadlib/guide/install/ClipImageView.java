package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class ClipImageView extends ImageView {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Path f3282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RectF f3283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f3284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f3285e;

    public ClipImageView(Context context) {
        super(context);
        this.a = true;
        a(context);
    }

    public void a(Context context) {
        this.f3282b = new Path();
        this.f3283c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.a) {
            this.f3282b.reset();
            this.f3283c.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f3285e;
            if (fArr != null) {
                this.f3282b.addRoundRect(this.f3283c, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f3282b);
            Paint paint = this.f3284d;
            if (paint != null) {
                canvas.drawPath(this.f3282b, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Paint paint = new Paint(1);
        this.f3284d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f3284d.setColor(i2);
    }

    public void setClip(boolean z) {
        this.a = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f3285e = fArr;
    }

    public void setRoundRadius(int i2) {
        if (i2 > 0) {
            float f2 = i2;
            setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = true;
        a(context);
    }
}
