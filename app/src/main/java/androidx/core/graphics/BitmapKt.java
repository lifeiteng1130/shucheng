package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Bitmap.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a$\u0010\u000b\u001a\u00020\b*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0086\n¢\u0006\u0004\b\u000b\u0010\f\u001a.\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\bH\u0086\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a.\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a*\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a>\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0087\b¢\u0006\u0004\b\u0018\u0010\u001d\u001a\u001c\u0010 \u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eH\u0086\n¢\u0006\u0004\b \u0010!\u001a\u001c\u0010 \u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\"H\u0086\n¢\u0006\u0004\b \u0010#¨\u0006$"}, d2 = {"Landroid/graphics/Bitmap;", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "Lf/v;", "Lkotlin/ExtensionFunctionType;", "block", "applyCanvas", "(Landroid/graphics/Bitmap;Lf/c0/b/l;)Landroid/graphics/Bitmap;", "", "x", "y", "get", "(Landroid/graphics/Bitmap;II)I", "color", "set", "(Landroid/graphics/Bitmap;III)V", "width", "height", "", "filter", "scale", "(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap$Config;", "config", "createBitmap", "(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "hasAlpha", "Landroid/graphics/ColorSpace;", "colorSpace", "(IILandroid/graphics/Bitmap$Config;ZLandroid/graphics/ColorSpace;)Landroid/graphics/Bitmap;", "Landroid/graphics/Point;", "p", "contains", "(Landroid/graphics/Bitmap;Landroid/graphics/Point;)Z", "Landroid/graphics/PointF;", "(Landroid/graphics/Bitmap;Landroid/graphics/PointF;)Z", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class BitmapKt {
    @NotNull
    public static final Bitmap applyCanvas(@NotNull Bitmap bitmap, @NotNull l<? super Canvas, v> lVar) {
        j.f(bitmap, "$this$applyCanvas");
        j.f(lVar, "block");
        lVar.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(@NotNull Bitmap bitmap, @NotNull Point point) {
        int i2;
        j.f(bitmap, "$this$contains");
        j.f(point, "p");
        int i3 = point.x;
        return i3 >= 0 && i3 < bitmap.getWidth() && (i2 = point.y) >= 0 && i2 < bitmap.getHeight();
    }

    @NotNull
    public static final Bitmap createBitmap(int i2, int i3, @NotNull Bitmap.Config config) {
        j.f(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
        j.b(bitmapCreateBitmap, "Bitmap.createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        j.f(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
        j.b(bitmapCreateBitmap, "Bitmap.createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static final int get(@NotNull Bitmap bitmap, int i2, int i3) {
        j.f(bitmap, "$this$get");
        return bitmap.getPixel(i2, i3);
    }

    @NotNull
    public static final Bitmap scale(@NotNull Bitmap bitmap, int i2, int i3, boolean z) {
        j.f(bitmap, "$this$scale");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
        j.b(bitmapCreateScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = true;
        }
        j.f(bitmap, "$this$scale");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
        j.b(bitmapCreateScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static final void set(@NotNull Bitmap bitmap, int i2, int i3, @ColorInt int i4) {
        j.f(bitmap, "$this$set");
        bitmap.setPixel(i2, i3, i4);
    }

    public static final boolean contains(@NotNull Bitmap bitmap, @NotNull PointF pointF) {
        j.f(bitmap, "$this$contains");
        j.f(pointF, "p");
        float f2 = pointF.x;
        float f3 = 0;
        if (f2 < f3 || f2 >= bitmap.getWidth()) {
            return false;
        }
        float f4 = pointF.y;
        return f4 >= f3 && f4 < ((float) bitmap.getHeight());
    }

    @RequiresApi(26)
    @NotNull
    public static final Bitmap createBitmap(int i2, int i3, @NotNull Bitmap.Config config, boolean z, @NotNull ColorSpace colorSpace) {
        j.f(config, "config");
        j.f(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
        j.b(bitmapCreateBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        if ((i4 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            j.b(colorSpace, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        j.f(config, "config");
        j.f(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
        j.b(bitmapCreateBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }
}
