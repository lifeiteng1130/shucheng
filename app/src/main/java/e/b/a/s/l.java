package e.b.a.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.m;
import e.b.a.n;
import e.b.a.p.r;

/* JADX INFO: compiled from: ImageSpanFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class l implements n {
    @Override // e.b.a.n
    @Nullable
    public Object a(@NonNull e.b.a.e eVar, @NonNull m mVar) {
        r rVar = eVar.a;
        a aVar = new a(h.a.a(mVar), eVar.f5969b, eVar.f5973f, (i) mVar.a.get(h.f6115c));
        e.b.a.k<Boolean> kVar = h.f6114b;
        Object obj = Boolean.FALSE;
        Object obj2 = mVar.a.get(kVar);
        if (obj2 != null) {
            obj = obj2;
        }
        return new g(rVar, aVar, 0, ((Boolean) obj).booleanValue());
    }
}
