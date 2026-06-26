package k.a.a.a.k0;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: Transition.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o1 {
    public static final Map<Class<? extends o1>, Integer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f8448b;

    /* JADX INFO: compiled from: Transition.java */
    public static class a extends HashMap<Class<? extends o1>, Integer> implements j$.util.Map {
        public a() {
            put(y.class, 1);
            put(d1.class, 2);
            put(g1.class, 3);
            put(y0.class, 4);
            put(o.class, 5);
            put(l.class, 6);
            put(i1.class, 7);
            put(q0.class, 8);
            put(p1.class, 9);
            put(w0.class, 10);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
            return Map.CC.$default$compute(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
            return Map.CC.$default$computeIfAbsent(this, obj, function);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
            return Map.CC.$default$computeIfPresent(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ void forEach(BiConsumer biConsumer) {
            Map.CC.$default$forEach(this, biConsumer);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return Map.CC.$default$getOrDefault(this, obj, obj2);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
            return Map.CC.$default$merge(this, obj, obj2, biFunction);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
            return Map.CC.$default$putIfAbsent(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean remove(Object obj, Object obj2) {
            return Map.CC.$default$remove(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object replace(Object obj, Object obj2) {
            return Map.CC.$default$replace(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
            return Map.CC.$default$replace(this, obj, obj2, obj3);
        }

        @Override // j$.util.Map
        public /* synthetic */ void replaceAll(BiFunction biFunction) {
            Map.CC.$default$replaceAll(this, biFunction);
        }
    }

    static {
        Collections.unmodifiableList(Arrays.asList("INVALID", "EPSILON", "RANGE", "RULE", "PREDICATE", "ATOM", "ACTION", "SET", "NOT_SET", "WILDCARD", "PRECEDENCE"));
        a = Collections.unmodifiableMap(new a());
    }

    public o1(i iVar) {
        Objects.requireNonNull(iVar, "target cannot be null.");
        this.f8448b = iVar;
    }

    public abstract int a();

    public boolean b() {
        return this instanceof l;
    }

    public k.a.a.a.m0.i c() {
        return null;
    }

    public abstract boolean d(int i2, int i3, int i4);
}
