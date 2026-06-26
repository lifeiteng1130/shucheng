package c.b.a.m.q;

import android.os.SystemClock;
import android.util.Log;
import c.b.a.m.q.g;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SourceGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class b0 implements g, g.a {
    public final h<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g.a f320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile ModelLoader.LoadData<?> f324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f325g;

    public b0(h<?> hVar, g.a aVar) {
        this.a = hVar;
        this.f320b = aVar;
    }

    @Override // c.b.a.m.q.g.a
    public void a(c.b.a.m.j jVar, Exception exc, DataFetcher<?> dataFetcher, c.b.a.m.a aVar) {
        this.f320b.a(jVar, exc, dataFetcher, this.f324f.fetcher.getDataSource());
    }

    @Override // c.b.a.m.q.g
    public boolean b() {
        Object obj = this.f323e;
        if (obj != null) {
            this.f323e = null;
            int i2 = c.b.a.s.e.f675b;
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            try {
                c.b.a.m.d<X> dVarE = this.a.e(obj);
                f fVar = new f(dVarE, obj, this.a.f396i);
                c.b.a.m.j jVar = this.f324f.sourceKey;
                h<?> hVar = this.a;
                this.f325g = new e(jVar, hVar.n);
                hVar.b().a(this.f325g, fVar);
                if (Log.isLoggable("SourceGenerator", 2)) {
                    String str = "Finished encoding source to cache, key: " + this.f325g + ", data: " + obj + ", encoder: " + dVarE + ", duration: " + c.b.a.s.e.a(jElapsedRealtimeNanos);
                }
                this.f324f.fetcher.cleanup();
                this.f322d = new d(Collections.singletonList(this.f324f.sourceKey), this.a, this);
            } catch (Throwable th) {
                this.f324f.fetcher.cleanup();
                throw th;
            }
        }
        d dVar = this.f322d;
        if (dVar != null && dVar.b()) {
            return true;
        }
        this.f322d = null;
        this.f324f = null;
        boolean z = false;
        while (!z) {
            if (!(this.f321c < this.a.c().size())) {
                break;
            }
            List<ModelLoader.LoadData<?>> listC = this.a.c();
            int i3 = this.f321c;
            this.f321c = i3 + 1;
            this.f324f = listC.get(i3);
            if (this.f324f != null && (this.a.p.c(this.f324f.fetcher.getDataSource()) || this.a.g(this.f324f.fetcher.getDataClass()))) {
                this.f324f.fetcher.loadData(this.a.o, new a0(this, this.f324f));
                z = true;
            }
        }
        return z;
    }

    @Override // c.b.a.m.q.g.a
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // c.b.a.m.q.g
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f324f;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // c.b.a.m.q.g.a
    public void d(c.b.a.m.j jVar, Object obj, DataFetcher<?> dataFetcher, c.b.a.m.a aVar, c.b.a.m.j jVar2) {
        this.f320b.d(jVar, obj, dataFetcher, this.f324f.fetcher.getDataSource(), jVar);
    }
}
