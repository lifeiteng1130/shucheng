package javax.script;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleBindings implements Bindings {
    private Map<String, Object> map;

    public SimpleBindings(Map<String, Object> map) {
        Objects.requireNonNull(map);
        this.map = map;
    }

    private void checkKey(Object obj) {
        Objects.requireNonNull(obj, "key can not be null");
        if (!(obj instanceof String)) {
            throw new ClassCastException("key should be a String");
        }
        if (obj.equals("")) {
            throw new IllegalArgumentException("key can not be empty");
        }
    }

    @Override // java.util.Map, j$.util.Map
    public void clear() {
        this.map.clear();
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

    @Override // javax.script.Bindings, java.util.Map, j$.util.Map, java.util.AbstractMap
    public boolean containsKey(Object obj) {
        checkKey(obj);
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map, j$.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map, j$.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // javax.script.Bindings, java.util.Map, j$.util.Map
    public Object get(Object obj) {
        checkKey(obj);
        return this.map.get(obj);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map, j$.util.Map
    public Set<String> keySet() {
        return this.map.keySet();
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // javax.script.Bindings, java.util.Map, j$.util.Map
    public void putAll(java.util.Map<? extends String, ? extends Object> map) {
        Objects.requireNonNull(map, "toMerge map is null");
        for (Map.Entry<? extends String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            checkKey(key);
            put(key, entry.getValue());
        }
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Override // javax.script.Bindings, java.util.Map, j$.util.Map, java.util.AbstractMap
    public Object remove(Object obj) {
        checkKey(obj);
        return this.map.remove(obj);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.CC.$default$replace(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map, j$.util.Map
    public Collection<Object> values() {
        return this.map.values();
    }

    @Override // java.util.Map, j$.util.Map
    public Object put(String str, Object obj) {
        checkKey(str);
        return this.map.put(str, obj);
    }

    public SimpleBindings() {
        this(new HashMap());
    }
}
