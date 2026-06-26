package i.a.b.m;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: compiled from: CollectionMapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class f<T> extends k<T> {
    public final ParameterizedType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f6415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<?> f6416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Type f6417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Type f6418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<?> f6419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class<?> f6420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k<?> f6421h;

    public f(j jVar, ParameterizedType parameterizedType) {
        super(jVar);
        this.a = parameterizedType;
        Class<?> cls = (Class) parameterizedType.getRawType();
        this.f6415b = cls;
        if (cls.isInterface()) {
            this.f6416c = i.a.b.d.class;
        } else {
            this.f6416c = cls;
        }
        i.a.a.b.c(this.f6416c, i.a.b.h.a);
        Type type = parameterizedType.getActualTypeArguments()[0];
        this.f6417d = type;
        Type type2 = parameterizedType.getActualTypeArguments()[1];
        this.f6418e = type2;
        if (type instanceof Class) {
            this.f6419f = (Class) type;
        } else {
            this.f6419f = (Class) ((ParameterizedType) type).getRawType();
        }
        if (type2 instanceof Class) {
            this.f6420g = (Class) type2;
        } else {
            this.f6420g = (Class) ((ParameterizedType) type2).getRawType();
        }
    }

    @Override // i.a.b.m.k
    public Object createObject() {
        try {
            return this.f6416c.newInstance();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // i.a.b.m.k
    public Type getType(String str) {
        return this.a;
    }

    @Override // i.a.b.m.k
    public Object getValue(Object obj, String str) {
        return ((Map) obj).get(i.a.b.h.a(str, this.f6419f));
    }

    @Override // i.a.b.m.k
    public void setValue(Object obj, String str, Object obj2) {
        ((Map) obj).put(i.a.b.h.a(str, this.f6419f), i.a.b.h.a(obj2, this.f6420g));
    }

    @Override // i.a.b.m.k
    public k<?> startArray(String str) {
        if (this.f6421h == null) {
            this.f6421h = this.base.b(this.f6418e);
        }
        return this.f6421h;
    }

    @Override // i.a.b.m.k
    public k<?> startObject(String str) {
        if (this.f6421h == null) {
            this.f6421h = this.base.b(this.f6418e);
        }
        return this.f6421h;
    }
}
