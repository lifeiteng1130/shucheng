package i.a.b.m;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: CollectionMapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class d<T> extends k<T> {
    public final ParameterizedType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f6407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<?> f6408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i.a.a.b<?> f6409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Type f6410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<?> f6411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k<?> f6412g;

    public d(j jVar, ParameterizedType parameterizedType) {
        super(jVar);
        this.a = parameterizedType;
        Class<?> cls = (Class) parameterizedType.getRawType();
        this.f6407b = cls;
        if (cls.isInterface()) {
            this.f6408c = i.a.b.a.class;
        } else {
            this.f6408c = cls;
        }
        this.f6409d = i.a.a.b.c(this.f6408c, i.a.b.h.a);
        Type type = parameterizedType.getActualTypeArguments()[0];
        this.f6410e = type;
        if (type instanceof Class) {
            this.f6411f = (Class) type;
        } else {
            this.f6411f = (Class) ((ParameterizedType) type).getRawType();
        }
    }

    @Override // i.a.b.m.k
    public void addValue(Object obj, Object obj2) {
        ((List) obj).add(i.a.b.h.a(obj2, this.f6411f));
    }

    @Override // i.a.b.m.k
    public Object createArray() {
        return this.f6409d.d();
    }

    @Override // i.a.b.m.k
    public k<?> startArray(String str) {
        if (this.f6412g == null) {
            this.f6412g = this.base.b(this.a.getActualTypeArguments()[0]);
        }
        return this.f6412g;
    }

    @Override // i.a.b.m.k
    public k<?> startObject(String str) {
        if (this.f6412g == null) {
            this.f6412g = this.base.b(this.a.getActualTypeArguments()[0]);
        }
        return this.f6412g;
    }
}
