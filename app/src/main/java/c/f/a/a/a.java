package c.f.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: AlphaPatternDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f1555b = new Paint();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f1556c = new Paint();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f1557d = new Paint();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f1560g;

    public a(int i2) {
        this.a = 10;
        this.a = i2;
        this.f1556c.setColor(-1);
        this.f1557d.setColor(-3421237);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f1560g;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f1560g, (Rect) null, getBounds(), this.f1555b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        this.f1558e = (int) Math.ceil(rect.width() / this.a);
        this.f1559f = (int) Math.ceil(iHeight / this.a);
        if (getBounds().width() <= 0 || getBounds().height() <= 0) {
            return;
        }
        this.f1560g = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f1560g);
        Rect rect2 = new Rect();
        boolean z = true;
        for (int i2 = 0; i2 <= this.f1559f; i2++) {
            boolean z2 = z;
            for (int i3 = 0; i3 <= this.f1558e; i3++) {
                int i4 = this.a;
                int i5 = i2 * i4;
                rect2.top = i5;
                int i6 = i3 * i4;
                rect2.left = i6;
                rect2.bottom = i5 + i4;
                rect2.right = i6 + i4;
                canvas.drawRect(rect2, z2 ? this.f1556c : this.f1557d);
                z2 = !z2;
            }
            z = !z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        throw new UnsupportedOperationException("Alpha is not supported by this drawable.");
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException("ColorFilter is not supported by this drawable.");
    }
}
