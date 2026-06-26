package c.b.a.q.j;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: DrawableImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends e<Drawable> {
    public d(ImageView imageView) {
        super(imageView);
    }

    @Override // c.b.a.q.j.e
    public void i(@Nullable Drawable drawable) {
        ((ImageView) this.f658b).setImageDrawable(drawable);
    }
}
