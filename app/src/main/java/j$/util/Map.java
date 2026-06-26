package j$.util;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public interface Map<K, V> {

    /* JADX INFO: renamed from: j$.util.Map$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$compute(java.util.Map map, Object obj, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            Object obj2 = map.get(obj);
            Object objApply = biFunction.apply(obj, obj2);
            if (objApply != null) {
                map.put(obj, objApply);
                return objApply;
            }
            if (obj2 == null && !map.containsKey(obj)) {
                return null;
            }
            map.remove(obj);
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$computeIfAbsent(java.util.Map map, Object obj, Function function) {
            Object objApply;
            Objects.requireNonNull(function);
            Object obj2 = map.get(obj);
            if (obj2 != null || (objApply = function.apply(obj)) == null) {
                return obj2;
            }
            map.put(obj, objApply);
            return objApply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$computeIfPresent(java.util.Map map, Object obj, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            Object obj2 = map.get(obj);
            if (obj2 != null) {
                Object objApply = biFunction.apply(obj, obj2);
                if (objApply != null) {
                    map.put(obj, objApply);
                    return objApply;
                }
                map.remove(obj);
            }
            return null;
        }

        public static void $default$forEach(java.util.Map map, BiConsumer biConsumer) {
            Objects.requireNonNull(biConsumer);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                try {
                    biConsumer.accept(entry.getKey(), entry.getValue());
                } catch (IllegalStateException e2) {
                    throw new ConcurrentModificationException(e2);
                }
            }
        }

        public static Object $default$getOrDefault(java.util.Map map, Object obj, Object obj2) {
            Object obj3 = map.get(obj);
            return (obj3 != null || map.containsKey(obj)) ? obj3 : obj2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$merge(java.util.Map map, Object obj, Object obj2, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            Objects.requireNonNull(obj2);
            Object obj3 = map.get(obj);
            if (obj3 != null) {
                obj2 = biFunction.apply(obj3, obj2);
            }
            if (obj2 == null) {
                map.remove(obj);
            } else {
                map.put(obj, obj2);
            }
            return obj2;
        }

        public static Object $default$putIfAbsent(java.util.Map map, Object obj, Object obj2) {
            Object obj3 = map.get(obj);
            return obj3 == null ? map.put(obj, obj2) : obj3;
        }

        public static boolean $default$remove(java.util.Map map, Object obj, Object obj2) {
            Object obj3 = map.get(obj);
            if (!j$.time.a.u(obj3, obj2)) {
                return false;
            }
            if (obj3 == null && !map.containsKey(obj)) {
                return false;
            }
            map.remove(obj);
            return true;
        }

        public static Object $default$replace(java.util.Map map, Object obj, Object obj2) {
            Object obj3 = map.get(obj);
            return (obj3 != null || map.containsKey(obj)) ? map.put(obj, obj2) : obj3;
        }

        public static boolean $default$replace(java.util.Map map, Object obj, Object obj2, Object obj3) {
            Object obj4 = map.get(obj);
            if (!j$.time.a.u(obj4, obj2)) {
                return false;
            }
            if (obj4 == null && !map.containsKey(obj)) {
                return false;
            }
            map.put(obj, obj3);
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void $default$replaceAll(java.util.Map map, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                try {
                    try {
                        entry.setValue(biFunction.apply(entry.getKey(), entry.getValue()));
                    } catch (IllegalStateException e2) {
                        throw new ConcurrentModificationException(e2);
                    }
                } catch (IllegalStateException e3) {
                    throw new ConcurrentModificationException(e3);
                }
            }
        }
    }

    /* JADX INFO: renamed from: j$.util.Map$-EL, reason: invalid class name */
    public final /* synthetic */ class EL {
        public static Object getOrDefault(java.util.Map map, Object obj, Object obj2) {
            if (map instanceof Map) {
                return ((Map) map).getOrDefault(obj, obj2);
            }
            if (!(map instanceof ConcurrentMap)) {
                return CC.$default$getOrDefault(map, obj, obj2);
            }
            Object obj3 = ((ConcurrentMap) map).get(obj);
            return obj3 != null ? obj3 : obj2;
        }

        public static /* synthetic */ Object putIfAbsent(java.util.Map map, Object obj, Object obj2) {
            return map instanceof Map ? ((Map) map).putIfAbsent(obj, obj2) : CC.$default$putIfAbsent(map, obj, obj2);
        }
    }

    public interface Entry<K, V> {
        boolean equals(Object obj);

        Object getKey();

        Object getValue();

        int hashCode();

        Object setValue(Object obj);
    }

    void clear();

    Object compute(Object obj, BiFunction biFunction);

    Object computeIfAbsent(Object obj, Function function);

    Object computeIfPresent(Object obj, BiFunction biFunction);

    boolean containsKey(Object obj);

    boolean containsValue(Object obj);

    java.util.Set entrySet();

    boolean equals(Object obj);

    void forEach(BiConsumer biConsumer);

    Object get(Object obj);

    Object getOrDefault(Object obj, Object obj2);

    int hashCode();

    boolean isEmpty();

    java.util.Set keySet();

    Object merge(Object obj, Object obj2, BiFunction biFunction);

    Object put(Object obj, Object obj2);

    void putAll(java.util.Map map);

    Object putIfAbsent(Object obj, Object obj2);

    Object remove(Object obj);

    boolean remove(Object obj, Object obj2);

    Object replace(Object obj, Object obj2);

    boolean replace(Object obj, Object obj2, Object obj3);

    void replaceAll(BiFunction biFunction);

    int size();

    java.util.Collection values();
}
