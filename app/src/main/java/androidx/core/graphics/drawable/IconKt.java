package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0005H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0006\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0007H\u0087\b¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Icon;", "toAdaptiveIcon", "(Landroid/graphics/Bitmap;)Landroid/graphics/drawable/Icon;", "toIcon", "Landroid/net/Uri;", "(Landroid/net/Uri;)Landroid/graphics/drawable/Icon;", "", "([B)Landroid/graphics/drawable/Icon;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class IconKt {
    @RequiresApi(26)
    @NotNull
    public static final Icon toAdaptiveIcon(@NotNull Bitmap bitmap) {
        j.f(bitmap, "$this$toAdaptiveIcon");
        Icon iconCreateWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        j.b(iconCreateWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull Bitmap bitmap) {
        j.f(bitmap, "$this$toIcon");
        Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmap);
        j.b(iconCreateWithBitmap, "Icon.createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull Uri uri) {
        j.f(uri, "$this$toIcon");
        Icon iconCreateWithContentUri = Icon.createWithContentUri(uri);
        j.b(iconCreateWithContentUri, "Icon.createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull byte[] bArr) {
        j.f(bArr, "$this$toIcon");
        Icon iconCreateWithData = Icon.createWithData(bArr, 0, bArr.length);
        j.b(iconCreateWithData, "Icon.createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
