package e.b.a.r.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.n;
import e.b.a.p.q;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: HeadingHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends h {
    @Override // e.b.a.r.l
    @NonNull
    public Collection<String> b() {
        return Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6");
    }

    @Override // e.b.a.r.p.h
    @Nullable
    public Object d(@NonNull e.b.a.e eVar, @NonNull e.b.a.m mVar, @NonNull e.b.a.r.e eVar2) {
        int i2;
        n nVar = ((e.b.a.h) eVar.f5974g).a.get(k.c.d.j.class);
        if (nVar == null) {
            return null;
        }
        try {
            i2 = Integer.parseInt(eVar2.name().substring(1));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 < 1 || i2 > 6) {
            return null;
        }
        q.f5993d.b(mVar, Integer.valueOf(i2));
        return nVar.a(eVar, mVar);
    }
}
