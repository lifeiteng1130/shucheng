package c.b.a.n;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: TargetTracker.java */
/* JADX INFO: loaded from: classes.dex */
public final class s implements m {
    public final Set<c.b.a.q.j.h<?>> a = Collections.newSetFromMap(new WeakHashMap());

    @Override // c.b.a.n.m
    public void onDestroy() {
        Iterator it = ((ArrayList) c.b.a.s.i.e(this.a)).iterator();
        while (it.hasNext()) {
            ((c.b.a.q.j.h) it.next()).onDestroy();
        }
    }

    @Override // c.b.a.n.m
    public void onStart() {
        Iterator it = ((ArrayList) c.b.a.s.i.e(this.a)).iterator();
        while (it.hasNext()) {
            ((c.b.a.q.j.h) it.next()).onStart();
        }
    }

    @Override // c.b.a.n.m
    public void onStop() {
        Iterator it = ((ArrayList) c.b.a.s.i.e(this.a)).iterator();
        while (it.hasNext()) {
            ((c.b.a.q.j.h) it.next()).onStop();
        }
    }
}
