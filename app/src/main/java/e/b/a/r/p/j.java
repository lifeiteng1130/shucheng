package e.b.a.r.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.n;
import java.util.Arrays;
import java.util.Collection;
import k.c.d.w;

/* JADX INFO: compiled from: StrongEmphasisHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends h {
    @Override // e.b.a.r.l
    @NonNull
    public Collection<String> b() {
        return Arrays.asList("b", "strong");
    }

    @Override // e.b.a.r.p.h
    @Nullable
    public Object d(@NonNull e.b.a.e eVar, @NonNull e.b.a.m mVar, @NonNull e.b.a.r.e eVar2) {
        n nVar = ((e.b.a.h) eVar.f5974g).a.get(w.class);
        if (nVar == null) {
            return null;
        }
        return nVar.a(eVar, mVar);
    }
}
