package e.b.a.s;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: AsyncDrawableScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements Drawable.Callback {
    public final TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f6108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f6109c;

    /* JADX INFO: compiled from: AsyncDrawableScheduler.java */
    public class a implements Runnable {
        public final /* synthetic */ Drawable a;

        public a(Drawable drawable) {
            this.a = drawable;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.invalidateDrawable(this.a);
        }
    }

    /* JADX INFO: compiled from: AsyncDrawableScheduler.java */
    public interface b {
    }

    public e(@NonNull TextView textView, @NonNull b bVar, Rect rect) {
        this.a = textView;
        this.f6108b = bVar;
        this.f6109c = new Rect(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.a.post(new a(drawable));
            return;
        }
        Rect bounds = drawable.getBounds();
        if (this.f6109c.equals(bounds)) {
            this.a.postInvalidate();
            return;
        }
        f fVar = (f) this.f6108b;
        fVar.a.removeCallbacks(fVar);
        fVar.a.post(fVar);
        this.f6109c = new Rect(bounds);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        this.a.postDelayed(runnable, j2 - SystemClock.uptimeMillis());
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        this.a.removeCallbacks(runnable);
    }
}
