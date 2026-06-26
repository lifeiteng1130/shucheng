package c.b.a.m.r.c;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ResourceBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class x implements c.b.a.m.n<Uri, Bitmap> {
    public final c.b.a.m.r.e.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b.a.m.q.c0.d f558b;

    public x(c.b.a.m.r.e.e eVar, c.b.a.m.q.c0.d dVar) {
        this.a = eVar;
        this.f558b = dVar;
    }

    @Override // c.b.a.m.n
    public boolean a(@NonNull Uri uri, @NonNull c.b.a.m.l lVar) {
        return "android.resource".equals(uri.getScheme());
    }

    @Override // c.b.a.m.n
    @Nullable
    public c.b.a.m.q.w<Bitmap> b(@NonNull Uri uri, int i2, int i3, @NonNull c.b.a.m.l lVar) {
        c.b.a.m.q.w wVarC = this.a.c(uri);
        if (wVarC == null) {
            return null;
        }
        return n.a(this.f558b, (Drawable) ((c.b.a.m.r.e.b) wVarC).get(), i2, i3);
    }
}
