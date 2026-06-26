package javax.script;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface Bindings extends Map<String, Object>, j$.util.Map {
    @Override // java.util.Map, j$.util.Map, java.util.AbstractMap
    boolean containsKey(Object obj);

    @Override // java.util.Map, j$.util.Map
    Object get(Object obj);

    Object put(String str, Object obj);

    @Override // java.util.Map, j$.util.Map
    void putAll(Map<? extends String, ? extends Object> map);

    @Override // java.util.Map, j$.util.Map, java.util.AbstractMap
    Object remove(Object obj);
}
