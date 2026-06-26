package e.b.a.s;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: AsyncDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends Drawable {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f6097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f6098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f6099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Drawable f6100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f6101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable.Callback f6102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f6104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6106k = false;

    /* JADX INFO: renamed from: e.b.a.s.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncDrawable.java */
    public class C0172a implements Drawable.Callback {
        public final Drawable.Callback a;

        public C0172a(@NonNull Drawable.Callback callback) {
            this.a = callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            this.a.invalidateDrawable(a.this);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
            this.a.scheduleDrawable(a.this, runnable, j2);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            this.a.unscheduleDrawable(a.this, runnable);
        }
    }

    public a(@NonNull String str, @NonNull b bVar, @NonNull j jVar, @Nullable i iVar) {
        this.a = str;
        this.f6097b = bVar;
        this.f6099d = jVar;
        this.f6098c = iVar;
        Drawable drawableC = bVar.c(this);
        this.f6100e = drawableC;
        if (drawableC != null) {
            Drawable drawable = this.f6101f;
            if (drawable != null) {
                drawable.setCallback(null);
            }
            Rect bounds = drawableC.getBounds();
            if (!bounds.isEmpty()) {
                this.f6101f = drawableC;
                drawableC.setCallback(this.f6102g);
                setBounds(bounds);
                this.f6105j = false;
                return;
            }
            Rect rectK3 = c.b.a.m.f.k3(drawableC);
            if (rectK3.isEmpty()) {
                drawableC.setBounds(0, 0, 1, 1);
            } else {
                drawableC.setBounds(rectK3);
            }
            setBounds(drawableC.getBounds());
            e(drawableC);
        }
    }

    public boolean a() {
        return this.f6101f != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.s.a.b():void");
    }

    public boolean c() {
        return getCallback() != null;
    }

    public void d(@Nullable Drawable.Callback callback) {
        this.f6102g = callback == null ? null : new C0172a(callback);
        setCallback(callback);
        if (this.f6102g == null) {
            Drawable drawable = this.f6101f;
            if (drawable != null) {
                drawable.setCallback(null);
                Object obj = this.f6101f;
                if (obj instanceof Animatable) {
                    Animatable animatable = (Animatable) obj;
                    boolean zIsRunning = animatable.isRunning();
                    this.f6106k = zIsRunning;
                    if (zIsRunning) {
                        animatable.stop();
                    }
                }
            }
            this.f6097b.a(this);
            return;
        }
        Drawable drawable2 = this.f6101f;
        if (drawable2 != null && drawable2.getCallback() == null) {
            this.f6101f.setCallback(this.f6102g);
        }
        Drawable drawable3 = this.f6101f;
        boolean z = drawable3 == null || drawable3 == this.f6100e;
        if (drawable3 != null) {
            drawable3.setCallback(this.f6102g);
            Object obj2 = this.f6101f;
            if ((obj2 instanceof Animatable) && this.f6106k) {
                ((Animatable) obj2).start();
            }
        }
        if (z) {
            this.f6097b.b(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (a()) {
            this.f6101f.draw(canvas);
        }
    }

    public void e(@NonNull Drawable drawable) {
        this.f6106k = false;
        Drawable drawable2 = this.f6101f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f6101f = drawable;
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (a()) {
            return this.f6101f.getIntrinsicHeight();
        }
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (a()) {
            return this.f6101f.getIntrinsicWidth();
        }
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (a()) {
            return this.f6101f.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    @NonNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("AsyncDrawable{destination='");
        c.a.a.a.a.y(sbR, this.a, '\'', ", imageSize=");
        sbR.append(this.f6098c);
        sbR.append(", result=");
        sbR.append(this.f6101f);
        sbR.append(", canvasWidth=");
        sbR.append(this.f6103h);
        sbR.append(", textSize=");
        sbR.append(this.f6104i);
        sbR.append(", waitingForDimensions=");
        sbR.append(this.f6105j);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }
}
