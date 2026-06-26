package c.b.a.m.r.h;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TranscoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public final List<a<?, ?>> a = new ArrayList();

    /* JADX INFO: compiled from: TranscoderRegistry.java */
    public static final class a<Z, R> {
        public final Class<Z> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<R> f593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e<Z, R> f594c;

        public a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.a = cls;
            this.f593b = cls2;
            this.f594c = eVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f593b);
        }
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<a<?, ?>> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }
}
