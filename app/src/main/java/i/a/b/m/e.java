package i.a.b.m;

import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: compiled from: CollectionMapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class e<T> extends k<T> {
    public final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f6413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i.a.a.b<?> f6414c;

    public e(j jVar, Class<?> cls) {
        super(jVar);
        this.a = cls;
        if (cls.isInterface()) {
            this.f6413b = i.a.b.d.class;
        } else {
            this.f6413b = cls;
        }
        this.f6414c = i.a.a.b.c(this.f6413b, i.a.b.h.a);
    }

    @Override // i.a.b.m.k
    public Object createObject() {
        return this.f6414c.d();
    }

    @Override // i.a.b.m.k
    public Type getType(String str) {
        return this.a;
    }

    @Override // i.a.b.m.k
    public Object getValue(Object obj, String str) {
        return ((Map) obj).get(str);
    }

    @Override // i.a.b.m.k
    public void setValue(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
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
