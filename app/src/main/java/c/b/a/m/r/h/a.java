package c.b.a.m.r.h;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.l;
import c.b.a.m.q.w;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: BitmapBytesTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {
    public final Bitmap.CompressFormat a = Bitmap.CompressFormat.JPEG;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f590b = 100;

    @Override // c.b.a.m.r.h.e
    @Nullable
    public w<byte[]> a(@NonNull w<Bitmap> wVar, @NonNull l lVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        wVar.get().compress(this.a, this.f590b, byteArrayOutputStream);
        wVar.recycle();
        return new c.b.a.m.r.d.b(byteArrayOutputStream.toByteArray());
    }
}
