package i.a.b.m;

import i.a.b.m.a;
import i.a.b.m.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: JsonReader.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    public final ConcurrentHashMap<Type, k<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k<i.a.b.c> f6422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k<i.a.b.c> f6423c;

    public j() {
        ConcurrentHashMap<Type, k<?>> concurrentHashMap = new ConcurrentHashMap<>(100);
        this.a = concurrentHashMap;
        concurrentHashMap.put(Date.class, b.a);
        concurrentHashMap.put(int[].class, a.a);
        concurrentHashMap.put(Integer[].class, a.f6393b);
        concurrentHashMap.put(short[].class, a.a);
        concurrentHashMap.put(Short[].class, a.f6393b);
        concurrentHashMap.put(long[].class, a.f6398g);
        concurrentHashMap.put(Long[].class, a.f6399h);
        concurrentHashMap.put(byte[].class, a.f6394c);
        concurrentHashMap.put(Byte[].class, a.f6395d);
        concurrentHashMap.put(char[].class, a.f6396e);
        concurrentHashMap.put(Character[].class, a.f6397f);
        concurrentHashMap.put(float[].class, a.f6400i);
        concurrentHashMap.put(Float[].class, a.f6401j);
        concurrentHashMap.put(double[].class, a.f6402k);
        concurrentHashMap.put(Double[].class, a.f6403l);
        concurrentHashMap.put(boolean[].class, a.m);
        concurrentHashMap.put(Boolean[].class, a.n);
        this.f6422b = new g(this);
        this.f6423c = new i(this);
        concurrentHashMap.put(i.a.b.c.class, this.f6422b);
        concurrentHashMap.put(i.a.b.b.class, this.f6422b);
        concurrentHashMap.put(i.a.b.a.class, this.f6422b);
        concurrentHashMap.put(i.a.b.d.class, this.f6422b);
    }

    public <T> k<T> a(Class<T> cls) {
        k<T> hVar = (k) this.a.get(cls);
        if (hVar != null) {
            return hVar;
        }
        if (cls instanceof Class) {
            if (Map.class.isAssignableFrom(cls) || List.class.isAssignableFrom(cls)) {
                hVar = new h<>(this, cls);
            }
            if (hVar != null) {
                this.a.put(cls, hVar);
                return hVar;
            }
        }
        k<T> qVar = cls.isArray() ? new a.q<>(this, cls) : List.class.isAssignableFrom(cls) ? new c<>(this, cls) : Map.class.isAssignableFrom(cls) ? new e<>(this, cls) : new b.C0187b<>(this, cls);
        this.a.putIfAbsent(cls, qVar);
        return qVar;
    }

    public <T> k<T> b(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return a((Class) type);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        k<T> fVar = (k) this.a.get(parameterizedType);
        if (fVar == null) {
            Class cls = (Class) parameterizedType.getRawType();
            if (List.class.isAssignableFrom(cls)) {
                fVar = new d<>(this, parameterizedType);
            } else if (Map.class.isAssignableFrom(cls)) {
                fVar = new f<>(this, parameterizedType);
            }
            this.a.putIfAbsent(parameterizedType, fVar);
        }
        return fVar;
    }
}
