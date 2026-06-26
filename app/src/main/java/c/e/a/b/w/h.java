package c.e.a.b.w;

import androidx.annotation.NonNull;
import c.e.a.b.w.l;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: compiled from: MaterialShapeDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements l.c {
    public final /* synthetic */ float a;

    public h(MaterialShapeDrawable materialShapeDrawable, float f2) {
        this.a = f2;
    }

    @Override // c.e.a.b.w.l.c
    @NonNull
    public c a(@NonNull c cVar) {
        return cVar instanceof j ? cVar : new b(this.a, cVar);
    }
}
