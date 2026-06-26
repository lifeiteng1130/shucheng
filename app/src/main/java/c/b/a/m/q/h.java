package c.b.a.m.q;

import c.b.a.m.q.i;
import c.b.a.m.q.l;
import c.b.a.m.r.h.f;
import c.b.a.p.e;
import com.bumptech.glide.load.model.ModelLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: DecodeHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class h<Transcode> {
    public final List<ModelLoader.LoadData<?>> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c.b.a.m.j> f389b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.b.a.d f390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Class<?> f394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i.d f395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c.b.a.m.l f396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<Class<?>, c.b.a.m.p<?>> f397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Class<Transcode> f398k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f399l;
    public boolean m;
    public c.b.a.m.j n;
    public c.b.a.f o;
    public k p;
    public boolean q;
    public boolean r;

    public List<c.b.a.m.j> a() {
        if (!this.m) {
            this.m = true;
            this.f389b.clear();
            List<ModelLoader.LoadData<?>> listC = c();
            int size = listC.size();
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader.LoadData<?> loadData = listC.get(i2);
                if (!this.f389b.contains(loadData.sourceKey)) {
                    this.f389b.add(loadData.sourceKey);
                }
                for (int i3 = 0; i3 < loadData.alternateKeys.size(); i3++) {
                    if (!this.f389b.contains(loadData.alternateKeys.get(i3))) {
                        this.f389b.add(loadData.alternateKeys.get(i3));
                    }
                }
            }
        }
        return this.f389b;
    }

    public c.b.a.m.q.d0.a b() {
        return ((l.c) this.f395h).a();
    }

    public List<ModelLoader.LoadData<?>> c() {
        if (!this.f399l) {
            this.f399l = true;
            this.a.clear();
            c.b.a.g gVar = this.f390c.f216c;
            List modelLoaders = gVar.a.getModelLoaders(this.f391d);
            int size = modelLoaders.size();
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader.LoadData<?> loadDataBuildLoadData = ((ModelLoader) modelLoaders.get(i2)).buildLoadData(this.f391d, this.f392e, this.f393f, this.f396i);
                if (loadDataBuildLoadData != null) {
                    this.a.add(loadDataBuildLoadData);
                }
            }
        }
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <Data> u<Data, ?, Transcode> d(Class<Data> cls) {
        u<Data, ?, Transcode> uVar;
        ArrayList arrayList;
        c.b.a.m.r.h.e eVar;
        c.b.a.g gVar = this.f390c.f216c;
        Class<?> cls2 = this.f394g;
        Class<Transcode> cls3 = this.f398k;
        c.b.a.p.c cVar = gVar.f232i;
        c.b.a.s.h andSet = cVar.f616c.getAndSet(null);
        if (andSet == null) {
            andSet = new c.b.a.s.h();
        }
        andSet.a = cls;
        andSet.f677b = cls2;
        andSet.f678c = cls3;
        synchronized (cVar.f615b) {
            uVar = (u) cVar.f615b.get(andSet);
        }
        cVar.f616c.set(andSet);
        Objects.requireNonNull(gVar.f232i);
        if (c.b.a.p.c.a.equals(uVar)) {
            return null;
        }
        if (uVar != null) {
            return uVar;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Class<?> cls4 : (ArrayList) gVar.f226c.b(cls, cls2)) {
            for (Class<?> cls5 : (ArrayList) gVar.f229f.a(cls4, cls3)) {
                c.b.a.p.e eVar2 = gVar.f226c;
                synchronized (eVar2) {
                    arrayList = new ArrayList();
                    Iterator<String> it = eVar2.a.iterator();
                    while (it.hasNext()) {
                        List<e.a<?, ?>> list = eVar2.f618b.get(it.next());
                        if (list != null) {
                            for (e.a<?, ?> aVar : list) {
                                if (aVar.a(cls, cls4)) {
                                    arrayList.add(aVar.f620c);
                                }
                            }
                        }
                    }
                }
                c.b.a.m.r.h.f fVar = gVar.f229f;
                synchronized (fVar) {
                    if (!cls5.isAssignableFrom(cls4)) {
                        for (f.a<?, ?> aVar2 : fVar.a) {
                            if (aVar2.a(cls4, cls5)) {
                                eVar = aVar2.f594c;
                            }
                        }
                        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls4 + " to " + cls5);
                    }
                    eVar = c.b.a.m.r.h.g.a;
                }
                arrayList2.add(new j(cls, cls4, cls5, arrayList, eVar, gVar.f233j));
            }
        }
        u<Data, ?, Transcode> uVar2 = arrayList2.isEmpty() ? null : new u<>(cls, cls2, cls3, arrayList2, gVar.f233j);
        c.b.a.p.c cVar2 = gVar.f232i;
        synchronized (cVar2.f615b) {
            cVar2.f615b.put(new c.b.a.s.h(cls, cls2, cls3), uVar2 != null ? uVar2 : c.b.a.p.c.a);
        }
        return uVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
    
        r1 = (c.b.a.m.d<X>) r3.f614b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <X> c.b.a.m.d<X> e(X r6) {
        /*
            r5 = this;
            c.b.a.d r0 = r5.f390c
            c.b.a.g r0 = r0.f216c
            c.b.a.p.a r0 = r0.f225b
            java.lang.Class r1 = r6.getClass()
            monitor-enter(r0)
            java.util.List<c.b.a.p.a$a<?>> r2 = r0.a     // Catch: java.lang.Throwable -> L38
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L38
        L11:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L38
            if (r3 == 0) goto L29
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L38
            c.b.a.p.a$a r3 = (c.b.a.p.a.C0025a) r3     // Catch: java.lang.Throwable -> L38
            java.lang.Class<T> r4 = r3.a     // Catch: java.lang.Throwable -> L38
            boolean r4 = r4.isAssignableFrom(r1)     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L11
            c.b.a.m.d<T> r1 = r3.f614b     // Catch: java.lang.Throwable -> L38
            monitor-exit(r0)
            goto L2b
        L29:
            r1 = 0
            monitor-exit(r0)
        L2b:
            if (r1 == 0) goto L2e
            return r1
        L2e:
            c.b.a.g$e r0 = new c.b.a.g$e
            java.lang.Class r6 = r6.getClass()
            r0.<init>(r6)
            throw r0
        L38:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.q.h.e(java.lang.Object):c.b.a.m.d");
    }

    public <Z> c.b.a.m.p<Z> f(Class<Z> cls) {
        c.b.a.m.p<Z> pVar = (c.b.a.m.p) this.f397j.get(cls);
        if (pVar == null) {
            Iterator<Map.Entry<Class<?>, c.b.a.m.p<?>>> it = this.f397j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, c.b.a.m.p<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    pVar = (c.b.a.m.p) next.getValue();
                    break;
                }
            }
        }
        if (pVar != null) {
            return pVar;
        }
        if (!this.f397j.isEmpty() || !this.q) {
            return (c.b.a.m.r.b) c.b.a.m.r.b.f503b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(Class<?> cls) {
        return d(cls) != null;
    }
}
