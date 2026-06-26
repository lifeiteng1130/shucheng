package k.a.a.a.m0;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: DoubleKeyMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class c<Key1, Key2, Value> {
    public Map<Key1, Map<Key2, Value>> a = new LinkedHashMap();

    public Value a(Key1 key1, Key2 key2) {
        Map<Key2, Value> map = this.a.get(key1);
        if (map == null) {
            return null;
        }
        return map.get(key2);
    }

    public Value b(Key1 key1, Key2 key2, Value value) {
        Value value2;
        Map<Key2, Value> linkedHashMap = this.a.get(key1);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            this.a.put(key1, linkedHashMap);
            value2 = null;
        } else {
            value2 = linkedHashMap.get(key2);
        }
        linkedHashMap.put(key2, value);
        return value2;
    }
}
