package c.b.a.m.q;

import androidx.annotation.NonNull;
import c.b.a.m.q.g;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: DataCacheGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements g, DataFetcher.DataCallback<Object> {
    public final List<c.b.a.m.j> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<?> f355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g.a f356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c.b.a.m.j f358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<ModelLoader<File, ?>> f359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile ModelLoader.LoadData<?> f361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f362i;

    public d(h<?> hVar, g.a aVar) {
        List<c.b.a.m.j> listA = hVar.a();
        this.f357d = -1;
        this.a = listA;
        this.f355b = hVar;
        this.f356c = aVar;
    }

    @Override // c.b.a.m.q.g
    public boolean b() {
        while (true) {
            List<ModelLoader<File, ?>> list = this.f359f;
            if (list != null) {
                if (this.f360g < list.size()) {
                    this.f361h = null;
                    boolean z = false;
                    while (!z) {
                        if (!(this.f360g < this.f359f.size())) {
                            break;
                        }
                        List<ModelLoader<File, ?>> list2 = this.f359f;
                        int i2 = this.f360g;
                        this.f360g = i2 + 1;
                        ModelLoader<File, ?> modelLoader = list2.get(i2);
                        File file = this.f362i;
                        h<?> hVar = this.f355b;
                        this.f361h = modelLoader.buildLoadData(file, hVar.f392e, hVar.f393f, hVar.f396i);
                        if (this.f361h != null && this.f355b.g(this.f361h.fetcher.getDataClass())) {
                            this.f361h.fetcher.loadData(this.f355b.o, this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
            int i3 = this.f357d + 1;
            this.f357d = i3;
            if (i3 >= this.a.size()) {
                return false;
            }
            c.b.a.m.j jVar = this.a.get(this.f357d);
            h<?> hVar2 = this.f355b;
            File fileB = hVar2.b().b(new e(jVar, hVar2.n));
            this.f362i = fileB;
            if (fileB != null) {
                this.f358e = jVar;
                this.f359f = this.f355b.f390c.f216c.a.getModelLoaders(fileB);
                this.f360g = 0;
            }
        }
    }

    @Override // c.b.a.m.q.g
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f361h;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        this.f356c.d(this.f358e, obj, this.f361h.fetcher, c.b.a.m.a.DATA_DISK_CACHE, this.f358e);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        this.f356c.a(this.f358e, exc, this.f361h.fetcher, c.b.a.m.a.DATA_DISK_CACHE);
    }

    public d(List<c.b.a.m.j> list, h<?> hVar, g.a aVar) {
        this.f357d = -1;
        this.a = list;
        this.f355b = hVar;
        this.f356c = aVar;
    }
}
