package c.b.a.p;

import androidx.annotation.NonNull;
import c.b.a.m.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ResourceDecoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public final List<String> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<a<?, ?>>> f618b = new HashMap();

    /* JADX INFO: compiled from: ResourceDecoderRegistry.java */
    public static class a<T, R> {
        public final Class<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<R> f619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n<T, R> f620c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, n<T, R> nVar) {
            this.a = cls;
            this.f619b = cls2;
            this.f620c = nVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f619b);
        }
    }

    @NonNull
    public final synchronized List<a<?, ?>> a(@NonNull String str) {
        List<a<?, ?>> arrayList;
        if (!this.a.contains(str)) {
            this.a.add(str);
        }
        arrayList = this.f618b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f618b.put(str, arrayList);
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f618b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f619b)) {
                        arrayList.add(aVar.f619b);
                    }
                }
            }
        }
        return arrayList;
    }
}
