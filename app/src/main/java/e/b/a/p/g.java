package e.b.a.p;

import androidx.annotation.NonNull;
import e.b.a.i;
import e.b.a.p.p;
import java.util.Iterator;
import k.c.d.x;

/* JADX INFO: compiled from: CorePlugin.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements i.c<x> {
    public final /* synthetic */ p a;

    public g(p pVar) {
        this.a = pVar;
    }

    @Override // e.b.a.i.c
    public void a(@NonNull e.b.a.i iVar, @NonNull k.c.d.s sVar) {
        String str = ((x) sVar).f8738f;
        e.b.a.j jVar = (e.b.a.j) iVar;
        jVar.f5982c.a.append(str);
        if (this.a.a.isEmpty()) {
            return;
        }
        int iC = jVar.c() - str.length();
        Iterator<p.a> it = this.a.a.iterator();
        while (it.hasNext()) {
            it.next().a(iVar, str, iC);
        }
    }
}
