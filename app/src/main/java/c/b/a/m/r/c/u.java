package c.b.a.m.r.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: LazyBitmapDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public final class u implements c.b.a.m.q.w<BitmapDrawable>, c.b.a.m.q.s {
    public final Resources a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b.a.m.q.w<Bitmap> f552b;

    public u(@NonNull Resources resources, @NonNull c.b.a.m.q.w<Bitmap> wVar) {
        Objects.requireNonNull(resources, "Argument must not be null");
        this.a = resources;
        this.f552b = wVar;
    }

    @Nullable
    public static c.b.a.m.q.w<BitmapDrawable> b(@NonNull Resources resources, @Nullable c.b.a.m.q.w<Bitmap> wVar) {
        if (wVar == null) {
            return null;
        }
        return new u(resources, wVar);
    }

    @Override // c.b.a.m.q.s
    public void a() {
        c.b.a.m.q.w<Bitmap> wVar = this.f552b;
        if (wVar instanceof c.b.a.m.q.s) {
            ((c.b.a.m.q.s) wVar).a();
        }
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public BitmapDrawable get() {
        return new BitmapDrawable(this.a, this.f552b.get());
    }

    @Override // c.b.a.m.q.w
    public int getSize() {
        return this.f552b.getSize();
    }

    @Override // c.b.a.m.q.w
    public void recycle() {
        this.f552b.recycle();
    }
}
