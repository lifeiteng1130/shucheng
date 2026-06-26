package c.b.a.m.q;

import c.b.a.m.q.a;
import java.util.Objects;

/* JADX INFO: compiled from: ActiveResources.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {
    public final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.a;
        Objects.requireNonNull(aVar);
        while (true) {
            try {
                aVar.b((a.b) aVar.f315c.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
