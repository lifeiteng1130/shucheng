package e.b.a.p.t;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.m;
import e.b.a.n;
import e.b.a.p.q;

/* JADX INFO: compiled from: ListItemSpanFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements n {
    @Override // e.b.a.n
    @Nullable
    public Object a(@NonNull e.b.a.e eVar, @NonNull m mVar) {
        if (q.a.BULLET == q.a.a(mVar)) {
            return new e.b.a.p.u.b(eVar.a, q.f5991b.a(mVar).intValue());
        }
        return new e.b.a.p.u.h(eVar.a, String.valueOf(q.f5992c.a(mVar)) + ". ");
    }
}
