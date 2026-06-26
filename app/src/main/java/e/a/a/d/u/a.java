package e.a.a.d.u;

import f.c0.c.j;
import java.util.HashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompositeCoroutine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    @Nullable
    public HashSet<b<?>> a;

    public boolean a(@NotNull b<?> bVar) {
        boolean zAdd;
        j.e(bVar, "coroutine");
        synchronized (this) {
            HashSet<b<?>> hashSet = this.a;
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.a = hashSet;
            }
            j.c(hashSet);
            zAdd = hashSet.add(bVar);
        }
        return zAdd;
    }

    public void b() {
        HashSet<b<?>> hashSet;
        synchronized (this) {
            hashSet = this.a;
            this.a = null;
        }
        if (hashSet == null) {
            return;
        }
        int i2 = 0;
        for (Object obj : hashSet) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                f.x.e.D();
                throw null;
            }
            b.a((b) obj, null, 1);
            i2 = i3;
        }
    }
}
