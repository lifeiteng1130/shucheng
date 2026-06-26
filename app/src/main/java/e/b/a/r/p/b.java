package e.b.a.r.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ai;
import e.b.a.n;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: EmphasisHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends h {
    @Override // e.b.a.r.l
    @NonNull
    public Collection<String> b() {
        return Arrays.asList(ai.aA, "em", "cite", "dfn");
    }

    @Override // e.b.a.r.p.h
    @Nullable
    public Object d(@NonNull e.b.a.e eVar, @NonNull e.b.a.m mVar, @NonNull e.b.a.r.e eVar2) {
        n nVar = ((e.b.a.h) eVar.f5974g).a.get(k.c.d.g.class);
        if (nVar == null) {
            return null;
        }
        return nVar.a(eVar, mVar);
    }
}
