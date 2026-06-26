package c.b.a;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import c.b.a.m.n;
import c.b.a.m.o;
import c.b.a.m.r.h.f;
import c.b.a.p.a;
import c.b.a.p.e;
import c.b.a.p.f;
import c.b.a.s.j.a;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Registry.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public final ModelLoaderRegistry a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b.a.p.a f225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b.a.p.e f226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.b.a.p.f f227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataRewinderRegistry f228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c.b.a.m.r.h.f f229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c.b.a.p.b f230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c.b.a.p.d f231h = new c.b.a.p.d();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c.b.a.p.c f232i = new c.b.a.p.c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f233j;

    /* JADX INFO: compiled from: Registry.java */
    public static class a extends RuntimeException {
        public a(@NonNull String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class c extends a {
        /* JADX WARN: Illegal instructions before constructor call */
        public c(@NonNull Object obj) {
            StringBuilder sbR = c.a.a.a.a.r("Failed to find any ModelLoaders registered for model class: ");
            sbR.append(obj.getClass());
            super(sbR.toString());
        }

        public <M> c(@NonNull M m, @NonNull List<ModelLoader<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public c(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class d extends a {
        public d(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class e extends a {
        public e(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public g() {
        a.c cVar = new a.c(new Pools.SynchronizedPool(20), new c.b.a.s.j.b(), new c.b.a.s.j.c());
        this.f233j = cVar;
        this.a = new ModelLoaderRegistry(cVar);
        this.f225b = new c.b.a.p.a();
        this.f226c = new c.b.a.p.e();
        this.f227d = new c.b.a.p.f();
        this.f228e = new DataRewinderRegistry();
        this.f229f = new c.b.a.m.r.h.f();
        this.f230g = new c.b.a.p.b();
        List listAsList = Arrays.asList("Gif", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(listAsList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        c.b.a.p.e eVar = this.f226c;
        synchronized (eVar) {
            ArrayList<String> arrayList2 = new ArrayList(eVar.a);
            eVar.a.clear();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                eVar.a.add((String) it2.next());
            }
            for (String str : arrayList2) {
                if (!arrayList.contains(str)) {
                    eVar.a.add(str);
                }
            }
        }
    }

    @NonNull
    public <Data> g a(@NonNull Class<Data> cls, @NonNull c.b.a.m.d<Data> dVar) {
        c.b.a.p.a aVar = this.f225b;
        synchronized (aVar) {
            aVar.a.add(new a.C0025a<>(cls, dVar));
        }
        return this;
    }

    @NonNull
    public <TResource> g b(@NonNull Class<TResource> cls, @NonNull o<TResource> oVar) {
        c.b.a.p.f fVar = this.f227d;
        synchronized (fVar) {
            fVar.a.add(new f.a<>(cls, oVar));
        }
        return this;
    }

    @NonNull
    public <Data, TResource> g c(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull n<Data, TResource> nVar) {
        c.b.a.p.e eVar = this.f226c;
        synchronized (eVar) {
            eVar.a(str).add(new e.a<>(cls, cls2, nVar));
        }
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> d() {
        List<ImageHeaderParser> list;
        c.b.a.p.b bVar = this.f230g;
        synchronized (bVar) {
            list = bVar.a;
        }
        if (list.isEmpty()) {
            throw new b();
        }
        return list;
    }

    @NonNull
    public <TResource, Transcode> g e(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull c.b.a.m.r.h.e<TResource, Transcode> eVar) {
        c.b.a.m.r.h.f fVar = this.f229f;
        synchronized (fVar) {
            fVar.a.add(new f.a<>(cls, cls2, eVar));
        }
        return this;
    }
}
