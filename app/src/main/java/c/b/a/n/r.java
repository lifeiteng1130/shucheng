package c.b.a.n;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: RequestTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class r {
    public final Set<c.b.a.q.c> a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c.b.a.q.c> f612b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f613c;

    public boolean a(@Nullable c.b.a.q.c cVar) {
        boolean z = true;
        if (cVar == null) {
            return true;
        }
        boolean zRemove = this.a.remove(cVar);
        if (!this.f612b.remove(cVar) && !zRemove) {
            z = false;
        }
        if (z) {
            cVar.clear();
        }
        return z;
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.f613c + "}";
    }
}
