package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ColorDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"", "Landroid/graphics/drawable/ColorDrawable;", "toDrawable", "(I)Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/Color;", "(Landroid/graphics/Color;)Landroid/graphics/drawable/ColorDrawable;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class ColorDrawableKt {
    @NotNull
    public static final ColorDrawable toDrawable(@ColorInt int i2) {
        return new ColorDrawable(i2);
    }

    @RequiresApi(26)
    @NotNull
    public static final ColorDrawable toDrawable(@NotNull Color color) {
        j.f(color, "$this$toDrawable");
        return new ColorDrawable(color.toArgb());
    }
}
