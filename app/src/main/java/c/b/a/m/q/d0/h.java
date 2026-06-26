package c.b.a.m.q.d0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.q.d0.i;
import c.b.a.m.q.l;
import c.b.a.m.q.w;

/* JADX INFO: compiled from: LruResourceCache.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends c.b.a.s.f<c.b.a.m.j, w<?>> implements i {
    public i.a a;

    public h(long j2) {
        super(j2);
    }

    @Nullable
    public /* bridge */ /* synthetic */ w a(@NonNull c.b.a.m.j jVar, @Nullable w wVar) {
        return (w) super.put(jVar, wVar);
    }

    @Nullable
    public /* bridge */ /* synthetic */ w b(@NonNull c.b.a.m.j jVar) {
        return (w) super.remove(jVar);
    }

    @Override // c.b.a.s.f
    public int getSize(@Nullable w<?> wVar) {
        w<?> wVar2 = wVar;
        return wVar2 == null ? super.getSize(null) : wVar2.getSize();
    }

    @Override // c.b.a.s.f
    public void onItemEvicted(@NonNull c.b.a.m.j jVar, @Nullable w<?> wVar) {
        w<?> wVar2 = wVar;
        i.a aVar = this.a;
        if (aVar == null || wVar2 == null) {
            return;
        }
        ((l) aVar).f426f.a(wVar2, true);
    }
}
