package c.b.a.m.q.d0;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: DiskCacheWriteLocker.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final Map<String, a> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f363b = new b();

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    public static class a {
        public final Lock a = new ReentrantLock();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f364b;
    }

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    public static class b {
        public final Queue<a> a = new ArrayDeque();
    }

    public void a(String str) {
        a aVar;
        synchronized (this) {
            a aVar2 = this.a.get(str);
            Objects.requireNonNull(aVar2, "Argument must not be null");
            aVar = aVar2;
            int i2 = aVar.f364b;
            if (i2 < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f364b);
            }
            int i3 = i2 - 1;
            aVar.f364b = i3;
            if (i3 == 0) {
                a aVarRemove = this.a.remove(str);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                }
                b bVar = this.f363b;
                synchronized (bVar.a) {
                    if (bVar.a.size() < 10) {
                        bVar.a.offer(aVarRemove);
                    }
                }
            }
        }
        aVar.a.unlock();
    }
}
