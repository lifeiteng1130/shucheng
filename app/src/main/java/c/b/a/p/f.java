package c.b.a.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ResourceEncoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public final List<a<?>> a = new ArrayList();

    /* JADX INFO: compiled from: ResourceEncoderRegistry.java */
    public static final class a<T> {
        public final Class<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o<T> f621b;

        public a(@NonNull Class<T> cls, @NonNull o<T> oVar) {
            this.a = cls;
            this.f621b = oVar;
        }
    }

    @Nullable
    public synchronized <Z> o<Z> a(@NonNull Class<Z> cls) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a<?> aVar = this.a.get(i2);
            if (aVar.a.isAssignableFrom(cls)) {
                return (o<Z>) aVar.f621b;
            }
        }
        return null;
    }
}
