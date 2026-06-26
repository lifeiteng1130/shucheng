package c.e.a.b.w;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* JADX INFO: compiled from: AdjustedCornerSize.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class b implements c {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1225b;

    public b(float f2, @NonNull c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).a;
            f2 += ((b) cVar).f1225b;
        }
        this.a = cVar;
        this.f1225b = f2;
    }

    @Override // c.e.a.b.w.c
    public float a(@NonNull RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.f1225b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.f1225b == bVar.f1225b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.f1225b)});
    }
}
