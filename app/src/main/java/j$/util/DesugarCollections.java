package j$.util;

import com.umeng.analytics.pro.ai;
import j$.C0385t;
import j$.L;
import j$.util.Collection;
import j$.util.List;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0387a;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public class DesugarCollections {
    public static final Class a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Class f7915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Field f7916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Field f7917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Constructor f7918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Constructor f7919f;

    static {
        Field declaredField;
        Field declaredField2;
        Constructor<?> declaredConstructor;
        Class<?> cls = Collections.synchronizedCollection(new ArrayList()).getClass();
        a = cls;
        f7915b = Collections.synchronizedList(new LinkedList()).getClass();
        Constructor<?> declaredConstructor2 = null;
        try {
            declaredField = cls.getDeclaredField("mutex");
        } catch (NoSuchFieldException unused) {
            declaredField = null;
        }
        f7916c = declaredField;
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        try {
            declaredField2 = cls.getDeclaredField(ai.aD);
        } catch (NoSuchFieldException unused2) {
            declaredField2 = null;
        }
        f7917d = declaredField2;
        if (declaredField2 != null) {
            declaredField2.setAccessible(true);
        }
        try {
            declaredConstructor = Collections.synchronizedSet(new HashSet()).getClass().getDeclaredConstructor(java.util.Set.class, Object.class);
        } catch (NoSuchMethodException unused3) {
            declaredConstructor = null;
        }
        f7919f = declaredConstructor;
        if (declaredConstructor != null) {
            declaredConstructor.setAccessible(true);
        }
        try {
            declaredConstructor2 = cls.getDeclaredConstructor(java.util.Collection.class, Object.class);
        } catch (NoSuchMethodException unused4) {
        }
        f7918e = declaredConstructor2;
        if (declaredConstructor2 != null) {
            declaredConstructor2.setAccessible(true);
        }
    }

    private DesugarCollections() {
    }

    public static void c(Iterable iterable, Consumer consumer) {
        Field field = f7916c;
        if (field == null) {
            try {
                j$.time.a.v((java.util.Collection) f7917d.get(iterable), consumer);
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized collection forEach fall-back.", e2);
            }
        } else {
            try {
                synchronized (field.get(iterable)) {
                    j$.time.a.v((java.util.Collection) f7917d.get(iterable), consumer);
                }
            } catch (IllegalAccessException e3) {
                throw new Error("Runtime illegal access in synchronized collection forEach.", e3);
            }
        }
    }

    static boolean d(java.util.Collection collection, Predicate predicate) {
        boolean zRemoveIf;
        Field field = f7916c;
        if (field == null) {
            try {
                java.util.Collection collection2 = (java.util.Collection) f7917d.get(collection);
                return collection2 instanceof Collection ? ((Collection) collection2).removeIf(predicate) : Collection.CC.$default$removeIf(collection2, predicate);
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized collection removeIf fall-back.", e2);
            }
        }
        try {
            synchronized (field.get(collection)) {
                java.util.Collection collection3 = (java.util.Collection) f7917d.get(collection);
                zRemoveIf = collection3 instanceof Collection ? ((Collection) collection3).removeIf(predicate) : Collection.CC.$default$removeIf(collection3, predicate);
            }
            return zRemoveIf;
        } catch (IllegalAccessException e3) {
            throw new Error("Runtime illegal access in synchronized collection removeIf.", e3);
        }
    }

    static void e(java.util.List list, UnaryOperator unaryOperator) {
        Field field = f7916c;
        if (field == null) {
            try {
                java.util.List list2 = (java.util.List) f7917d.get(list);
                if (list2 instanceof List) {
                    ((List) list2).replaceAll(unaryOperator);
                    return;
                } else {
                    List.CC.$default$replaceAll(list2, unaryOperator);
                    return;
                }
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized list replaceAll fall-back.", e2);
            }
        }
        try {
            synchronized (field.get(list)) {
                java.util.List list3 = (java.util.List) f7917d.get(list);
                if (list3 instanceof List) {
                    ((List) list3).replaceAll(unaryOperator);
                } else {
                    List.CC.$default$replaceAll(list3, unaryOperator);
                }
            }
        } catch (IllegalAccessException e3) {
            throw new Error("Runtime illegal access in synchronized list replaceAll.", e3);
        }
    }

    static void f(java.util.List list, java.util.Comparator comparator) {
        Field field = f7916c;
        if (field == null) {
            try {
                List.EL.sort((java.util.List) f7917d.get(list), comparator);
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized collection sort fall-back.", e2);
            }
        } else {
            try {
                synchronized (field.get(list)) {
                    List.EL.sort((java.util.List) f7917d.get(list), comparator);
                }
            } catch (IllegalAccessException e3) {
                throw new Error("Runtime illegal access in synchronized list sort.", e3);
            }
        }
    }

    public static java.util.Map synchronizedMap(java.util.Map map) {
        return new a(map);
    }

    private static class a<K, V> implements java.util.Map<K, V>, Serializable, Map {
        private final java.util.Map a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f7920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private transient java.util.Set f7921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private transient java.util.Set f7922d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private transient java.util.Collection f7923e;

        a(java.util.Map map) {
            Objects.requireNonNull(map);
            this.a = map;
            this.f7920b = this;
        }

        private java.util.Set a(java.util.Set set, Object obj) {
            if (DesugarCollections.f7919f == null) {
                return Collections.synchronizedSet(set);
            }
            try {
                return (java.util.Set) DesugarCollections.f7919f.newInstance(set, obj);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
                throw new Error("Unable to instantiate a synchronized list.", e2);
            }
        }

        @Override // java.util.Map, j$.util.Map
        public void clear() {
            synchronized (this.f7920b) {
                this.a.clear();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.Map
        public Object compute(Object obj, BiFunction biFunction) {
            Object obj$default$compute;
            Object objApply;
            synchronized (this.f7920b) {
                try {
                    java.util.Map map = this.a;
                    if (map instanceof Map) {
                        obj$default$compute = ((Map) map).compute(obj, biFunction);
                    } else if (map instanceof ConcurrentMap) {
                        ConcurrentMap concurrentMap = (ConcurrentMap) map;
                        Objects.requireNonNull(biFunction);
                        loop0: while (true) {
                            Object objPutIfAbsent = concurrentMap.get(obj);
                            while (true) {
                                objApply = biFunction.apply(obj, objPutIfAbsent);
                                if (objApply == null) {
                                    objApply = null;
                                    if (objPutIfAbsent == null && !concurrentMap.containsKey(obj)) {
                                        break;
                                    }
                                    if (concurrentMap.remove(obj, objPutIfAbsent)) {
                                        break;
                                    }
                                } else if (objPutIfAbsent == null) {
                                    objPutIfAbsent = concurrentMap.putIfAbsent(obj, objApply);
                                    if (objPutIfAbsent == null) {
                                        break loop0;
                                    }
                                } else if (concurrentMap.replace(obj, objPutIfAbsent, objApply)) {
                                    break;
                                }
                            }
                        }
                        obj$default$compute = objApply;
                    } else {
                        obj$default$compute = Map.CC.$default$compute(map, obj, biFunction);
                    }
                } finally {
                }
            }
            return obj$default$compute;
        }

        @Override // java.util.Map
        public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
            return compute(obj, C0385t.a(biFunction));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.Map
        public Object computeIfAbsent(Object obj, Function function) {
            Object obj$default$computeIfAbsent;
            Object objApply;
            synchronized (this.f7920b) {
                try {
                    java.util.Map map = this.a;
                    if (map instanceof Map) {
                        obj$default$computeIfAbsent = ((Map) map).computeIfAbsent(obj, function);
                    } else if (map instanceof ConcurrentMap) {
                        ConcurrentMap concurrentMap = (ConcurrentMap) map;
                        Objects.requireNonNull(function);
                        Object obj2 = concurrentMap.get(obj);
                        if (obj2 != null || (objApply = function.apply(obj)) == null) {
                            obj$default$computeIfAbsent = obj2;
                        } else {
                            obj$default$computeIfAbsent = concurrentMap.putIfAbsent(obj, objApply);
                            if (obj$default$computeIfAbsent == null) {
                                obj$default$computeIfAbsent = objApply;
                            }
                        }
                    } else {
                        obj$default$computeIfAbsent = Map.CC.$default$computeIfAbsent(map, obj, function);
                    }
                } finally {
                }
            }
            return obj$default$computeIfAbsent;
        }

        @Override // java.util.Map
        public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
            return computeIfAbsent(obj, L.a(function));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.Map
        public Object computeIfPresent(Object obj, BiFunction biFunction) {
            Object obj$default$computeIfPresent;
            synchronized (this.f7920b) {
                try {
                    java.util.Map map = this.a;
                    if (map instanceof Map) {
                        obj$default$computeIfPresent = ((Map) map).computeIfPresent(obj, biFunction);
                    } else if (map instanceof ConcurrentMap) {
                        ConcurrentMap concurrentMap = (ConcurrentMap) map;
                        Objects.requireNonNull(biFunction);
                        while (true) {
                            Object obj2 = concurrentMap.get(obj);
                            if (obj2 == null) {
                                obj$default$computeIfPresent = obj2;
                                break;
                            }
                            Object objApply = biFunction.apply(obj, obj2);
                            if (objApply != null) {
                                if (concurrentMap.replace(obj, obj2, objApply)) {
                                    obj$default$computeIfPresent = objApply;
                                    break;
                                }
                            } else if (concurrentMap.remove(obj, obj2)) {
                                obj$default$computeIfPresent = null;
                                break;
                            }
                        }
                    } else {
                        obj$default$computeIfPresent = Map.CC.$default$computeIfPresent(map, obj, biFunction);
                    }
                } finally {
                }
            }
            return obj$default$computeIfPresent;
        }

        @Override // java.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
            return computeIfPresent(obj, C0385t.a(biFunction));
        }

        @Override // java.util.Map, j$.util.Map, java.util.AbstractMap
        public boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.f7920b) {
                zContainsKey = this.a.containsKey(obj);
            }
            return zContainsKey;
        }

        @Override // java.util.Map, j$.util.Map
        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.f7920b) {
                zContainsValue = this.a.containsValue(obj);
            }
            return zContainsValue;
        }

        @Override // java.util.Map, j$.util.Map
        public java.util.Set entrySet() {
            java.util.Set set;
            synchronized (this.f7920b) {
                if (this.f7922d == null) {
                    this.f7922d = a(this.a.entrySet(), this.f7920b);
                }
                set = this.f7922d;
            }
            return set;
        }

        @Override // java.util.Map, j$.util.Map
        public boolean equals(Object obj) {
            boolean zEquals;
            if (this == obj) {
                return true;
            }
            synchronized (this.f7920b) {
                zEquals = this.a.equals(obj);
            }
            return zEquals;
        }

        @Override // j$.util.Map
        public void forEach(BiConsumer biConsumer) {
            synchronized (this.f7920b) {
                try {
                    java.util.Map map = this.a;
                    if (map instanceof Map) {
                        ((Map) map).forEach(biConsumer);
                    } else if (map instanceof ConcurrentMap) {
                        j$.time.a.e((ConcurrentMap) map, biConsumer);
                    } else {
                        Map.CC.$default$forEach(map, biConsumer);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.Map
        public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
            forEach(j$.r.b(biConsumer));
        }

        @Override // java.util.Map, j$.util.Map
        public Object get(Object obj) {
            Object obj2;
            synchronized (this.f7920b) {
                obj2 = this.a.get(obj);
            }
            return obj2;
        }

        @Override // java.util.Map, j$.util.Map
        public Object getOrDefault(Object obj, Object obj2) {
            Object orDefault;
            synchronized (this.f7920b) {
                orDefault = Map.EL.getOrDefault(this.a, obj, obj2);
            }
            return orDefault;
        }

        @Override // java.util.Map, j$.util.Map
        public int hashCode() {
            int iHashCode;
            synchronized (this.f7920b) {
                iHashCode = this.a.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map, j$.util.Map
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.f7920b) {
                zIsEmpty = this.a.isEmpty();
            }
            return zIsEmpty;
        }

        @Override // java.util.Map, j$.util.Map
        public java.util.Set keySet() {
            java.util.Set set;
            synchronized (this.f7920b) {
                if (this.f7921c == null) {
                    this.f7921c = a(this.a.keySet(), this.f7920b);
                }
                set = this.f7921c;
            }
            return set;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        
            r3 = r7.apply(r2, r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        
            if (r3 == null) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        
            if (r1.replace(r5, r2, r3) == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        
            r6 = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
        
            if (r1.remove(r5, r2) == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
        
            r6 = null;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.Map
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object merge(java.lang.Object r5, java.lang.Object r6, j$.util.function.BiFunction r7) {
            /*
                r4 = this;
                java.lang.Object r0 = r4.f7920b
                monitor-enter(r0)
                java.util.Map r1 = r4.a     // Catch: java.lang.Throwable -> L30
                boolean r2 = r1 instanceof j$.util.Map     // Catch: java.lang.Throwable -> L30
                if (r2 == 0) goto L10
                j$.util.Map r1 = (j$.util.Map) r1     // Catch: java.lang.Throwable -> L30
                java.lang.Object r5 = r1.merge(r5, r6, r7)     // Catch: java.lang.Throwable -> L30
                goto L46
            L10:
                boolean r2 = r1 instanceof java.util.concurrent.ConcurrentMap     // Catch: java.lang.Throwable -> L30
                if (r2 == 0) goto L42
                java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1     // Catch: java.lang.Throwable -> L30
                java.util.Objects.requireNonNull(r7)     // Catch: java.lang.Throwable -> L30
                java.util.Objects.requireNonNull(r6)     // Catch: java.lang.Throwable -> L30
            L1c:
                java.lang.Object r2 = r1.get(r5)     // Catch: java.lang.Throwable -> L30
            L20:
                if (r2 == 0) goto L3a
                java.lang.Object r3 = r7.apply(r2, r6)     // Catch: java.lang.Throwable -> L30
                if (r3 == 0) goto L32
                boolean r2 = r1.replace(r5, r2, r3)     // Catch: java.lang.Throwable -> L30
                if (r2 == 0) goto L1c
                r6 = r3
                goto L40
            L30:
                r5 = move-exception
                goto L48
            L32:
                boolean r2 = r1.remove(r5, r2)     // Catch: java.lang.Throwable -> L30
                if (r2 == 0) goto L1c
                r6 = 0
                goto L40
            L3a:
                java.lang.Object r2 = r1.putIfAbsent(r5, r6)     // Catch: java.lang.Throwable -> L30
                if (r2 != 0) goto L20
            L40:
                r5 = r6
                goto L46
            L42:
                java.lang.Object r5 = j$.util.Map.CC.$default$merge(r1, r5, r6, r7)     // Catch: java.lang.Throwable -> L30
            L46:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L30
                return r5
            L48:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L30
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.DesugarCollections.a.merge(java.lang.Object, java.lang.Object, j$.util.function.BiFunction):java.lang.Object");
        }

        @Override // java.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
            return merge(obj, obj2, C0385t.a(biFunction));
        }

        @Override // java.util.Map, j$.util.Map
        public Object put(Object obj, Object obj2) {
            Object objPut;
            synchronized (this.f7920b) {
                objPut = this.a.put(obj, obj2);
            }
            return objPut;
        }

        @Override // java.util.Map, j$.util.Map
        public void putAll(java.util.Map map) {
            synchronized (this.f7920b) {
                this.a.putAll(map);
            }
        }

        @Override // java.util.Map, j$.util.Map
        public Object putIfAbsent(Object obj, Object obj2) {
            Object objPutIfAbsent;
            synchronized (this.f7920b) {
                objPutIfAbsent = Map.EL.putIfAbsent(this.a, obj, obj2);
            }
            return objPutIfAbsent;
        }

        @Override // java.util.Map, j$.util.Map, java.util.AbstractMap
        public Object remove(Object obj) {
            Object objRemove;
            synchronized (this.f7920b) {
                objRemove = this.a.remove(obj);
            }
            return objRemove;
        }

        @Override // java.util.Map, j$.util.Map
        public boolean remove(Object obj, Object obj2) {
            boolean zRemove;
            synchronized (this.f7920b) {
                try {
                    java.util.Map map = this.a;
                    zRemove = map instanceof Map ? ((Map) map).remove(obj, obj2) : Map.CC.$default$remove(map, obj, obj2);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zRemove;
        }

        @Override // java.util.Map, j$.util.Map
        public Object replace(Object obj, Object obj2) {
            Object objReplace;
            synchronized (this.f7920b) {
                try {
                    java.util.Map map = this.a;
                    objReplace = map instanceof Map ? ((Map) map).replace(obj, obj2) : Map.CC.$default$replace(map, obj, obj2);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return objReplace;
        }

        @Override // j$.util.Map
        public void replaceAll(final BiFunction biFunction) {
            synchronized (this.f7920b) {
                try {
                    java.util.Map map = this.a;
                    if (map instanceof Map) {
                        ((Map) map).replaceAll(biFunction);
                    } else if (map instanceof ConcurrentMap) {
                        final ConcurrentMap concurrentMap = (ConcurrentMap) map;
                        Objects.requireNonNull(biFunction);
                        BiConsumer biConsumer = new BiConsumer() { // from class: j$.util.concurrent.a
                            @Override // j$.util.function.BiConsumer
                            public BiConsumer a(BiConsumer biConsumer2) {
                                Objects.requireNonNull(biConsumer2);
                                return new C0387a(this, biConsumer2);
                            }

                            @Override // j$.util.function.BiConsumer
                            public final void accept(Object obj, Object obj2) {
                                ConcurrentMap concurrentMap2 = concurrentMap;
                                BiFunction biFunction2 = biFunction;
                                while (!concurrentMap2.replace(obj, obj2, biFunction2.apply(obj, obj2)) && (obj2 = concurrentMap2.get(obj)) != null) {
                                }
                            }
                        };
                        if (concurrentMap instanceof j$.util.concurrent.b) {
                            ((j$.util.concurrent.b) concurrentMap).forEach(biConsumer);
                        } else {
                            j$.time.a.e(concurrentMap, biConsumer);
                        }
                    } else {
                        Map.CC.$default$replaceAll(map, biFunction);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.Map
        public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
            replaceAll(C0385t.a(biFunction));
        }

        @Override // java.util.Map, j$.util.Map
        public int size() {
            int size;
            synchronized (this.f7920b) {
                size = this.a.size();
            }
            return size;
        }

        public String toString() {
            String string;
            synchronized (this.f7920b) {
                string = this.a.toString();
            }
            return string;
        }

        @Override // java.util.Map, j$.util.Map
        public java.util.Collection values() {
            java.util.Collection collection;
            java.util.Collection collectionSynchronizedCollection;
            synchronized (this.f7920b) {
                try {
                    if (this.f7923e == null) {
                        java.util.Collection<V> collectionValues = this.a.values();
                        Object obj = this.f7920b;
                        if (DesugarCollections.f7918e == null) {
                            collectionSynchronizedCollection = Collections.synchronizedCollection(collectionValues);
                        } else {
                            try {
                                collectionSynchronizedCollection = (java.util.Collection) DesugarCollections.f7918e.newInstance(collectionValues, obj);
                            } catch (IllegalAccessException e2) {
                                e = e2;
                                throw new Error("Unable to instantiate a synchronized list.", e);
                            } catch (InstantiationException e3) {
                                e = e3;
                                throw new Error("Unable to instantiate a synchronized list.", e);
                            } catch (InvocationTargetException e4) {
                                e = e4;
                                throw new Error("Unable to instantiate a synchronized list.", e);
                            }
                        }
                        this.f7923e = collectionSynchronizedCollection;
                    }
                    collection = this.f7923e;
                } finally {
                }
            }
            return collection;
        }

        @Override // java.util.Map, j$.util.Map
        public boolean replace(Object obj, Object obj2, Object obj3) {
            boolean zReplace;
            synchronized (this.f7920b) {
                try {
                    java.util.Map map = this.a;
                    zReplace = map instanceof Map ? ((Map) map).replace(obj, obj2, obj3) : Map.CC.$default$replace(map, obj, obj2, obj3);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zReplace;
        }
    }
}
