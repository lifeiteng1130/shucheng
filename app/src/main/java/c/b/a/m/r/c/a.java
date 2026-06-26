package c.b.a.m.r.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: BitmapDrawableDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a<DataType> implements c.b.a.m.n<DataType, BitmapDrawable> {
    public final c.b.a.m.n<DataType, Bitmap> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f504b;

    public a(@NonNull Resources resources, @NonNull c.b.a.m.n<DataType, Bitmap> nVar) {
        this.f504b = resources;
        this.a = nVar;
    }

    @Override // c.b.a.m.n
    public boolean a(@NonNull DataType datatype, @NonNull c.b.a.m.l lVar) {
        return this.a.a(datatype, lVar);
    }

    @Override // c.b.a.m.n
    public c.b.a.m.q.w<BitmapDrawable> b(@NonNull DataType datatype, int i2, int i3, @NonNull c.b.a.m.l lVar) {
        return u.b(this.f504b, this.a.b(datatype, i2, i3, lVar));
    }
}
