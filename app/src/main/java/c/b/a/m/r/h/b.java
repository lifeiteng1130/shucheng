package c.b.a.m.r.h;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.l;
import c.b.a.m.q.w;
import c.b.a.m.r.c.u;

/* JADX INFO: compiled from: BitmapDrawableTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {
    public final Resources a;

    public b(@NonNull Resources resources) {
        this.a = resources;
    }

    @Override // c.b.a.m.r.h.e
    @Nullable
    public w<BitmapDrawable> a(@NonNull w<Bitmap> wVar, @NonNull l lVar) {
        return u.b(this.a, wVar);
    }
}
