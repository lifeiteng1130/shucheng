package c.b.a.m.q;

import androidx.annotation.NonNull;
import c.b.a.m.q.g;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ResourceCacheGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class x implements g, DataFetcher.DataCallback<Object> {
    public final g.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<?> f478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f480d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c.b.a.m.j f481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<ModelLoader<File, ?>> f482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile ModelLoader.LoadData<?> f484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y f486j;

    public x(h<?> hVar, g.a aVar) {
        this.f478b = hVar;
        this.a = aVar;
    }

    @Override // c.b.a.m.q.g
    public boolean b() {
        List<Class<?>> list;
        List<c.b.a.m.j> listA = this.f478b.a();
        if (listA.isEmpty()) {
            return false;
        }
        h<?> hVar = this.f478b;
        c.b.a.g gVar = hVar.f390c.f216c;
        Class<?> cls = hVar.f391d.getClass();
        Class<?> cls2 = hVar.f394g;
        Class<?> cls3 = hVar.f398k;
        c.b.a.p.d dVar = gVar.f231h;
        c.b.a.s.h andSet = dVar.a.getAndSet(null);
        if (andSet == null) {
            andSet = new c.b.a.s.h(cls, cls2, cls3);
        } else {
            andSet.a = cls;
            andSet.f677b = cls2;
            andSet.f678c = cls3;
        }
        synchronized (dVar.f617b) {
            list = dVar.f617b.get(andSet);
        }
        dVar.a.set(andSet);
        List list2 = list;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Class<?>> it = gVar.a.getDataClasses(cls).iterator();
            while (it.hasNext()) {
                for (Class cls4 : (ArrayList) gVar.f226c.b(it.next(), cls2)) {
                    if (!((ArrayList) gVar.f229f.a(cls4, cls3)).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            c.b.a.p.d dVar2 = gVar.f231h;
            List<Class<?>> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            synchronized (dVar2.f617b) {
                dVar2.f617b.put(new c.b.a.s.h(cls, cls2, cls3), listUnmodifiableList);
            }
            list2 = arrayList;
        }
        if (list2.isEmpty()) {
            if (File.class.equals(this.f478b.f398k)) {
                return false;
            }
            StringBuilder sbR = c.a.a.a.a.r("Failed to find any load path from ");
            sbR.append(this.f478b.f391d.getClass());
            sbR.append(" to ");
            sbR.append(this.f478b.f398k);
            throw new IllegalStateException(sbR.toString());
        }
        while (true) {
            List<ModelLoader<File, ?>> list3 = this.f482f;
            if (list3 != null) {
                if (this.f483g < list3.size()) {
                    this.f484h = null;
                    boolean z = false;
                    while (!z) {
                        if (!(this.f483g < this.f482f.size())) {
                            break;
                        }
                        List<ModelLoader<File, ?>> list4 = this.f482f;
                        int i2 = this.f483g;
                        this.f483g = i2 + 1;
                        ModelLoader<File, ?> modelLoader = list4.get(i2);
                        File file = this.f485i;
                        h<?> hVar2 = this.f478b;
                        this.f484h = modelLoader.buildLoadData(file, hVar2.f392e, hVar2.f393f, hVar2.f396i);
                        if (this.f484h != null && this.f478b.g(this.f484h.fetcher.getDataClass())) {
                            this.f484h.fetcher.loadData(this.f478b.o, this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
            int i3 = this.f480d + 1;
            this.f480d = i3;
            if (i3 >= list2.size()) {
                int i4 = this.f479c + 1;
                this.f479c = i4;
                if (i4 >= listA.size()) {
                    return false;
                }
                this.f480d = 0;
            }
            c.b.a.m.j jVar = listA.get(this.f479c);
            Class cls5 = (Class) list2.get(this.f480d);
            c.b.a.m.p<Z> pVarF = this.f478b.f(cls5);
            h<?> hVar3 = this.f478b;
            this.f486j = new y(hVar3.f390c.f215b, jVar, hVar3.n, hVar3.f392e, hVar3.f393f, pVarF, cls5, hVar3.f396i);
            File fileB = hVar3.b().b(this.f486j);
            this.f485i = fileB;
            if (fileB != null) {
                this.f481e = jVar;
                this.f482f = this.f478b.f390c.f216c.a.getModelLoaders(fileB);
                this.f483g = 0;
            }
        }
    }

    @Override // c.b.a.m.q.g
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f484h;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        this.a.d(this.f481e, obj, this.f484h.fetcher, c.b.a.m.a.RESOURCE_DISK_CACHE, this.f486j);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        this.a.a(this.f486j, exc, this.f484h.fetcher, c.b.a.m.a.RESOURCE_DISK_CACHE);
    }
}
