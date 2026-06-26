package e.a.a.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import java.security.MessageDigest;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BlurTransformation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends c.b.a.m.r.c.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final RenderScript f5529d;

    public f(@NotNull Context context, int i2) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        this.f5528c = i2;
        RenderScript renderScriptCreate = RenderScript.create(context);
        f.c0.c.j.d(renderScriptCreate, "create(context)");
        this.f5529d = renderScriptCreate;
    }

    @Override // c.b.a.m.r.c.i, c.b.a.m.r.c.f
    @TargetApi(17)
    @NotNull
    public Bitmap b(@NotNull c.b.a.m.q.c0.d dVar, @NotNull Bitmap bitmap, int i2, int i3) {
        f.c0.c.j.e(dVar, "pool");
        f.c0.c.j.e(bitmap, "toTransform");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(super.b(dVar, bitmap, i2, i3), c.b.a.m.f.S4(Math.min(i2, r2.getWidth()) / 2.0f), c.b.a.m.f.S4(Math.min(i3, r2.getHeight()) / 2.0f), false);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.f5529d, bitmapCreateScaledBitmap, Allocation.MipmapControl.MIPMAP_FULL, 128);
        Allocation allocationCreateTyped = Allocation.createTyped(this.f5529d, allocationCreateFromBitmap.getType());
        RenderScript renderScript = this.f5529d;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.setRadius(this.f5528c);
        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
        allocationCreateTyped.copyTo(bitmapCreateScaledBitmap);
        f.c0.c.j.d(bitmapCreateScaledBitmap, "blurredBitmap");
        return bitmapCreateScaledBitmap;
    }

    @Override // c.b.a.m.r.c.i, c.b.a.m.j
    public void updateDiskCacheKey(@NotNull MessageDigest messageDigest) {
        f.c0.c.j.e(messageDigest, "messageDigest");
        byte[] bytes = "blur transformation".getBytes(f.h0.a.a);
        f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
    }
}
