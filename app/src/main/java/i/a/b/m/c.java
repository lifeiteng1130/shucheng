package i.a.b.m;

import java.util.List;

/* JADX INFO: compiled from: CollectionMapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class c<T> extends k<T> {
    public final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i.a.a.b<?> f6406b;

    public c(j jVar, Class<?> cls) {
        super(jVar);
        if (cls.isInterface()) {
            this.a = i.a.b.a.class;
        } else {
            this.a = cls;
        }
        this.f6406b = i.a.a.b.c(this.a, i.a.b.h.a);
    }

    @Override // i.a.b.m.k
    public void addValue(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }

    @Override // i.a.b.m.k
    public Object createArray() {
        return this.f6406b.d();
    }

    @Override // i.a.b.m.k
    public k<?> startArray(String str) {
        return this.base.f6422b;
    }

    @Override // i.a.b.m.k
    public k<?> startObject(String str) {
        return this.base.f6422b;
    }
}
