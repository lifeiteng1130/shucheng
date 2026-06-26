package c.b.a.s.j;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import c.b.a.s.j.d;

/* JADX INFO: compiled from: FactoryPools.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final e<Object> a = new C0028a();

    /* JADX INFO: renamed from: c.b.a.s.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FactoryPools.java */
    public class C0028a implements e<Object> {
        @Override // c.b.a.s.j.a.e
        public void a(@NonNull Object obj) {
        }
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface b<T> {
        T a();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public static final class c<T> implements Pools.Pool<T> {
        public final b<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e<T> f681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Pools.Pool<T> f682c;

        public c(@NonNull Pools.Pool<T> pool, @NonNull b<T> bVar, @NonNull e<T> eVar) {
            this.f682c = pool;
            this.a = bVar;
            this.f681b = eVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T tAcquire = this.f682c.acquire();
            if (tAcquire == null) {
                tAcquire = this.a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder sbR = c.a.a.a.a.r("Created new ");
                    sbR.append(tAcquire.getClass());
                    sbR.toString();
                }
            }
            if (tAcquire instanceof d) {
                ((d.b) ((d) tAcquire).b()).a = false;
            }
            return tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof d) {
                ((d.b) ((d) t).b()).a = true;
            }
            this.f681b.a(t);
            return this.f682c.release(t);
        }
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface d {
        @NonNull
        c.b.a.s.j.d b();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface e<T> {
        void a(@NonNull T t);
    }

    @NonNull
    public static <T extends d> Pools.Pool<T> a(int i2, @NonNull b<T> bVar) {
        return new c(new Pools.SynchronizedPool(i2), bVar, a);
    }
}
