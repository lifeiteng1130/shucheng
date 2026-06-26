package c.b.a.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class f<T, Y> {
    private final Map<T, a<Y>> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    /* JADX INFO: compiled from: LruCache.java */
    public static final class a<Y> {
        public final Y a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f676b;

        public a(Y y, int i2) {
            this.a = y;
            this.f676b = i2;
        }
    }

    public f(long j2) {
        this.initialMaxSize = j2;
        this.maxSize = j2;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    public synchronized boolean contains(@NonNull T t) {
        return this.cache.containsKey(t);
    }

    @Nullable
    public synchronized Y get(@NonNull T t) {
        a<Y> aVar;
        aVar = this.cache.get(t);
        return aVar != null ? aVar.a : null;
    }

    public synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public int getSize(@Nullable Y y) {
        return 1;
    }

    public void onItemEvicted(@NonNull T t, @Nullable Y y) {
    }

    @Nullable
    public synchronized Y put(@NonNull T t, @Nullable Y y) {
        int size = getSize(y);
        long j2 = size;
        if (j2 >= this.maxSize) {
            onItemEvicted(t, y);
            return null;
        }
        if (y != null) {
            this.currentSize += j2;
        }
        a<Y> aVarPut = this.cache.put(t, y == null ? null : new a<>(y, size));
        if (aVarPut != null) {
            this.currentSize -= (long) aVarPut.f676b;
            if (!aVarPut.a.equals(y)) {
                onItemEvicted(t, aVarPut.a);
            }
        }
        evict();
        return aVarPut != null ? aVarPut.a : null;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t) {
        a<Y> aVarRemove = this.cache.remove(t);
        if (aVarRemove == null) {
            return null;
        }
        this.currentSize -= (long) aVarRemove.f676b;
        return aVarRemove.a;
    }

    public synchronized void setSizeMultiplier(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(this.initialMaxSize * f2);
        evict();
    }

    public synchronized void trimToSize(long j2) {
        while (this.currentSize > j2) {
            Iterator<Map.Entry<T, a<Y>>> it = this.cache.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.currentSize -= (long) value.f676b;
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value.a);
        }
    }
}
