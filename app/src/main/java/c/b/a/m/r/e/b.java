package c.b.a.m.r.e;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import c.b.a.m.q.s;
import c.b.a.m.q.w;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.util.Objects;

/* JADX INFO: compiled from: DrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends Drawable> implements w<T>, s {
    public final T a;

    public b(T t) {
        Objects.requireNonNull(t, "Argument must not be null");
        this.a = t;
    }

    @Override // c.b.a.m.q.s
    public void a() {
        T t = this.a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).b().prepareToDraw();
        }
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public Object get() {
        Drawable.ConstantState constantState = this.a.getConstantState();
        return constantState == null ? this.a : constantState.newDrawable();
    }
}
