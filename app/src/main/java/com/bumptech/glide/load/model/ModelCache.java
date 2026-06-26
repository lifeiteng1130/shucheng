package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import c.b.a.s.f;
import c.b.a.s.i;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final f<ModelKey<A>, B> cache;

    @VisibleForTesting
    public static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE;
        private int height;
        private A model;
        private int width;

        static {
            char[] cArr = i.a;
            KEY_QUEUE = new ArrayDeque(0);
        }

        private ModelKey() {
        }

        public static <A> ModelKey<A> get(A a, int i2, int i3) {
            ModelKey<A> modelKey;
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                modelKey = (ModelKey) queue.poll();
            }
            if (modelKey == null) {
                modelKey = new ModelKey<>();
            }
            modelKey.init(a, i2, i3);
            return modelKey;
        }

        private void init(A a, int i2, int i3) {
            this.model = a;
            this.width = i2;
            this.height = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            return this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model);
        }

        public int hashCode() {
            return this.model.hashCode() + (((this.height * 31) + this.width) * 31);
        }

        public void release() {
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                queue.offer(this);
            }
        }
    }

    public ModelCache() {
        this(250L);
    }

    public void clear() {
        this.cache.clearMemory();
    }

    @Nullable
    public B get(A a, int i2, int i3) {
        ModelKey<A> modelKey = ModelKey.get(a, i2, i3);
        B b2 = this.cache.get(modelKey);
        modelKey.release();
        return b2;
    }

    public void put(A a, int i2, int i3, B b2) {
        this.cache.put(ModelKey.get(a, i2, i3), b2);
    }

    public ModelCache(long j2) {
        this.cache = new f<ModelKey<A>, B>(j2) { // from class: com.bumptech.glide.load.model.ModelCache.1
            @Override // c.b.a.s.f
            public void onItemEvicted(@NonNull ModelKey<A> modelKey, @Nullable B b2) {
                modelKey.release();
            }
        };
    }
}
