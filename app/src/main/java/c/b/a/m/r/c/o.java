package c.b.a.m.r.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DrawableTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements c.b.a.m.p<Drawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b.a.m.p<Bitmap> f535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f536c;

    public o(c.b.a.m.p<Bitmap> pVar, boolean z) {
        this.f535b = pVar;
        this.f536c = z;
    }

    @Override // c.b.a.m.p
    @NonNull
    public c.b.a.m.q.w<Drawable> a(@NonNull Context context, @NonNull c.b.a.m.q.w<Drawable> wVar, int i2, int i3) {
        c.b.a.m.q.c0.d dVar = c.b.a.b.b(context).f196c;
        Drawable drawable = wVar.get();
        c.b.a.m.q.w<Bitmap> wVarA = n.a(dVar, drawable, i2, i3);
        if (wVarA != null) {
            c.b.a.m.q.w<Bitmap> wVarA2 = this.f535b.a(context, wVarA, i2, i3);
            if (!wVarA2.equals(wVarA)) {
                return u.b(context.getResources(), wVarA2);
            }
            wVarA2.recycle();
            return wVar;
        }
        if (!this.f536c) {
            return wVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // c.b.a.m.j
    public boolean equals(Object obj) {
        if (obj instanceof o) {
            return this.f535b.equals(((o) obj).f535b);
        }
        return false;
    }

    @Override // c.b.a.m.j
    public int hashCode() {
        return this.f535b.hashCode();
    }

    @Override // c.b.a.m.j
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f535b.updateDiskCacheKey(messageDigest);
    }
}
