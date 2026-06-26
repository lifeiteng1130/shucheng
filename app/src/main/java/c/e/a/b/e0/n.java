package c.e.a.b.e0;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: TransitionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class n {
    public static final RectF a = new RectF();

    /* JADX INFO: compiled from: TransitionUtils.java */
    public interface a {
        void a(Canvas canvas);
    }

    @NonNull
    public static <T> T a(@Nullable T t, @NonNull T t2) {
        return t2;
    }

    public static View b(View view, @IdRes int i2) {
        String resourceName = view.getResources().getResourceName(i2);
        while (view != null) {
            if (view.getId() != i2) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(c.a.a.a.a.i(resourceName, " is not a valid ancestor"));
    }

    public static RectF c(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    public static float d(float f2, float f3, float f4) {
        return c.a.a.a.a.a(f3, f2, f4, f2);
    }

    public static float e(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return f(f2, f3, f4, f5, f6, false);
    }

    public static float f(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d) float f6, boolean z) {
        return (!z || (f6 >= 0.0f && f6 <= 1.0f)) ? f6 < f4 ? f2 : f6 > f5 ? f3 : d(f2, f3, (f6 - f4) / (f5 - f4)) : d(f2, f3, f6);
    }

    public static int g(int i2, int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f4 < f2 ? i2 : f4 > f3 ? i3 : (int) d(i2, i3, (f4 - f2) / (f3 - f2));
    }

    public static void h(Canvas canvas, Rect rect, float f2, float f3, float f4, int i2, a aVar) {
        if (i2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f2, f3);
        canvas.scale(f4, f4);
        if (i2 < 255) {
            RectF rectF = a;
            rectF.set(rect);
            canvas.saveLayerAlpha(rectF, i2);
        }
        aVar.a(canvas);
        canvas.restoreToCount(iSave);
    }
}
