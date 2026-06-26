package c.e.a.b.a;

import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: DrawableAlphaProperty.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<Drawable, Integer> f843b;

    public d() {
        super(Integer.class, "drawableAlphaCompat");
        this.f843b = new WeakHashMap<>();
    }

    @Override // android.util.Property
    @Nullable
    public Integer get(@NonNull Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    public void set(@NonNull Drawable drawable, @NonNull Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
