package e.a.a.g.f.g;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c.b.a.m.f;
import f.c0.c.j;
import f.h;
import f.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ConvertUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    @NotNull
    public static final a a = new a();

    @Nullable
    public final Drawable a(@NotNull byte[] bArr) {
        Throwable th;
        Bitmap bitmapDecodeByteArray;
        j.e(bArr, "bytes");
        j.e(bArr, "bytes");
        if (!(bArr.length == 0)) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = null;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            } catch (Throwable th2) {
                th = th2;
                bitmapDecodeByteArray = null;
            }
            try {
                j.c(bitmapDecodeByteArray);
                bitmapDecodeByteArray.setDensity(96);
                h.m11constructorimpl(v.a);
            } catch (Throwable th3) {
                th = th3;
                h.m11constructorimpl(f.m1(th));
            }
        } else {
            bitmapDecodeByteArray = null;
        }
        if (bitmapDecodeByteArray == null) {
            return null;
        }
        return new BitmapDrawable(Resources.getSystem(), bitmapDecodeByteArray);
    }
}
