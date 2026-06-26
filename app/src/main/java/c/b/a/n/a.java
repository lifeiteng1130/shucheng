package c.b.a.n;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ActivityFragmentLifecycle.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements l {
    public final Set<m> a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f596c;

    @Override // c.b.a.n.l
    public void a(@NonNull m mVar) {
        this.a.add(mVar);
        if (this.f596c) {
            mVar.onDestroy();
        } else if (this.f595b) {
            mVar.onStart();
        } else {
            mVar.onStop();
        }
    }

    @Override // c.b.a.n.l
    public void b(@NonNull m mVar) {
        this.a.remove(mVar);
    }

    public void c() {
        this.f596c = true;
        Iterator it = ((ArrayList) c.b.a.s.i.e(this.a)).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onDestroy();
        }
    }

    public void d() {
        this.f595b = true;
        Iterator it = ((ArrayList) c.b.a.s.i.e(this.a)).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStart();
        }
    }

    public void e() {
        this.f595b = false;
        Iterator it = ((ArrayList) c.b.a.s.i.e(this.a)).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStop();
        }
    }
}
