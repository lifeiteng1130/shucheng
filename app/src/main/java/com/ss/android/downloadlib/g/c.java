package com.ss.android.downloadlib.g;

import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: Chain.java */
/* JADX INFO: loaded from: classes.dex */
public class c<P, R> implements Runnable {
    private P a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private R f3264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SoftReference<a<P, R>> f3266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c<?, P> f3267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c<R, ?> f3268f;

    /* JADX INFO: compiled from: Chain.java */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    private c(int i2, a<P, R> aVar, P p) {
        this.f3265c = i2;
        this.f3266d = new SoftReference<>(aVar);
        this.a = p;
    }

    public static <P, R> c<P, R> a(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    private R b() {
        return this.f3264b;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.f3265c == 0 && !l.a()) {
            com.ss.android.downloadlib.f.a().b().post(this);
            return;
        }
        if (this.f3265c == 1 && l.a()) {
            com.ss.android.downloadlib.d.a().a(this);
            return;
        }
        if (this.f3265c == 2 && l.a()) {
            com.ss.android.downloadlib.d.a().b(this);
            return;
        }
        if (this.a == null && (cVar = this.f3267e) != null) {
            this.a = cVar.b();
        }
        a<P, R> aVar = this.f3266d.get();
        if (aVar == null) {
            return;
        }
        this.f3264b = aVar.a(this.a);
        c<R, ?> cVar2 = this.f3268f;
        if (cVar2 != null) {
            cVar2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i2, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i2, aVar, null);
        this.f3268f = cVar;
        cVar.f3267e = this;
        return cVar;
    }

    public <NR> c<R, NR> a(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void a() {
        c<?, P> cVar = this.f3267e;
        if (cVar != null) {
            cVar.a();
        } else {
            run();
        }
    }
}
