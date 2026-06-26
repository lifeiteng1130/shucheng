package e.a.a.g.m.i.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import c.b.a.m.f;
import f.c0.c.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    @NotNull
    public static final e a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f5921b = Resources.getSystem().getDisplayMetrics().density;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Canvas f5922c = new Canvas();

    @Nullable
    public static final Bitmap a(@NotNull View view) {
        Drawable drawable;
        j.e(view, "view");
        if ((view instanceof ImageView) && (drawable = ((ImageView) view).getDrawable()) != null && (drawable instanceof BitmapDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        view.clearFocus();
        Bitmap bitmapB = b(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888, 1);
        if (bitmapB != null) {
            Canvas canvas = f5922c;
            synchronized (canvas) {
                canvas.setBitmap(bitmapB);
                view.draw(canvas);
                canvas.setBitmap(null);
            }
        }
        return bitmapB;
    }

    public static final Bitmap b(int i2, int i3, Bitmap.Config config, int i4) {
        try {
            return Bitmap.createBitmap(i2, i3, config);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            if (i4 <= 0) {
                return null;
            }
            System.gc();
            return b(i2, i3, config, i4 - 1);
        }
    }

    public static final int c(int i2) {
        return f.S4(i2 * f5921b);
    }
}
