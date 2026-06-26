package c.b.a.m.r.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: DrawableToBitmapConverter.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static final c.b.a.m.q.c0.d a = new a();

    /* JADX INFO: compiled from: DrawableToBitmapConverter.java */
    public class a extends c.b.a.m.q.c0.e {
        @Override // c.b.a.m.q.c0.e, c.b.a.m.q.c0.d
        public void d(Bitmap bitmap) {
        }
    }

    @Nullable
    public static c.b.a.m.q.w<Bitmap> a(c.b.a.m.q.c0.d dVar, Drawable drawable, int i2, int i3) {
        Drawable current = drawable.getCurrent();
        boolean z = false;
        Bitmap bitmap = null;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            if (i2 != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i3 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i2 = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i3 = current.getIntrinsicHeight();
                    }
                    Lock lock = z.f563d;
                    lock.lock();
                    Bitmap bitmapE = dVar.e(i2, i3, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(bitmapE);
                        current.setBounds(0, 0, i2, i3);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = bitmapE;
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                    String str = "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height";
                }
            } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                String str2 = "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width";
            }
            z = true;
        }
        if (!z) {
            dVar = a;
        }
        return e.b(bitmap, dVar);
    }
}
