package c.b.a.s.j;

import androidx.annotation.NonNull;
import c.b.a.s.j.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: FactoryPools.java */
/* JADX INFO: loaded from: classes.dex */
public class b<T> implements a.b<List<T>> {
    @Override // c.b.a.s.j.a.b
    @NonNull
    public Object a() {
        return new ArrayList();
    }
}
