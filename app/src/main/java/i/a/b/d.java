package i.a.b;

import i.a.b.l.l;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: JSONObject.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends HashMap<String, Object> implements b, c, f, Map {
    private static final long serialVersionUID = -503443796854799292L;

    public d() {
    }

    public static String escape(String str) {
        g gVar = i.a;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        gVar.f6359i.a(str, sb);
        return sb.toString();
    }

    public static String toJSONString(java.util.Map<String, ? extends Object> map) {
        return toJSONString(map, i.a);
    }

    public static void writeJSON(java.util.Map<String, ? extends Object> map, Appendable appendable) throws IOException {
        writeJSON(map, appendable, i.a);
    }

    public static void writeJSONKV(String str, Object obj, Appendable appendable, g gVar) throws IOException {
        if (str == null) {
            appendable.append("null");
        } else if (gVar.f6357g.a(str)) {
            appendable.append('\"');
            i.a(str, appendable, gVar);
            appendable.append('\"');
        } else {
            appendable.append(str);
        }
        appendable.append(':');
        if (obj instanceof String) {
            gVar.a(appendable, (String) obj);
        } else {
            i.b(obj, appendable, gVar);
        }
    }

    public d appendField(String str, Object obj) {
        put(str, obj);
        return this;
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

    public Number getAsNumber(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj instanceof Number ? (Number) obj : Long.valueOf(obj.toString());
    }

    public String getAsString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    public void merge(Object obj) {
        merge(this, obj);
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

    public String toString(g gVar) {
        return toJSONString(this, gVar);
    }

    @Override // i.a.b.e
    public void writeJSONString(Appendable appendable) throws IOException {
        writeJSON(this, appendable, i.a);
    }

    public d(java.util.Map<String, ?> map) {
        super(map);
    }

    public static d merge(d dVar, Object obj) {
        if (obj == null) {
            return dVar;
        }
        if (!(obj instanceof d)) {
            throw new RuntimeException("JSON megre can not merge JSONObject with " + obj.getClass());
        }
        d dVar2 = (d) obj;
        for (String str : dVar.keySet()) {
            Object obj2 = dVar.get(str);
            Object obj3 = dVar2.get(str);
            if (obj3 != null) {
                if (obj2 instanceof a) {
                    dVar.put(str, merge((a) obj2, obj3));
                } else if (obj2 instanceof d) {
                    dVar.put(str, merge((d) obj2, obj3));
                } else if (!obj2.equals(obj3)) {
                    if (obj2.getClass().equals(obj3.getClass())) {
                        throw new RuntimeException("JSON merge can not merge two " + obj2.getClass().getName() + " Object together");
                    }
                    throw new RuntimeException("JSON merge can not merge " + obj2.getClass().getName() + " with " + obj3.getClass().getName());
                }
            }
        }
        for (String str2 : dVar2.keySet()) {
            if (!dVar.containsKey(str2)) {
                dVar.put(str2, dVar2.get(str2));
            }
        }
        return dVar;
    }

    public static String toJSONString(java.util.Map<String, ? extends Object> map, g gVar) {
        StringBuilder sb = new StringBuilder();
        try {
            writeJSON(map, sb, gVar);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public static void writeJSON(java.util.Map<String, ? extends Object> map, Appendable appendable, g gVar) throws IOException {
        if (map == null) {
            appendable.append("null");
            return;
        }
        Objects.requireNonNull(gVar);
        appendable.append(MessageFormatter.DELIM_START);
        boolean z = true;
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null || !gVar.f6356f) {
                if (z) {
                    z = false;
                } else {
                    appendable.append(',');
                }
                l.b(entry.getKey().toString(), value, appendable, gVar);
            }
        }
        appendable.append(MessageFormatter.DELIM_STOP);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return toJSONString(this, i.a);
    }

    @Override // i.a.b.f
    public void writeJSONString(Appendable appendable, g gVar) throws IOException {
        writeJSON(this, appendable, gVar);
    }

    @Override // i.a.b.b
    public String toJSONString() {
        return toJSONString(this, i.a);
    }

    @Override // i.a.b.c
    public String toJSONString(g gVar) {
        return toJSONString(this, gVar);
    }

    public static a merge(a aVar, Object obj) {
        if (obj == null) {
            return aVar;
        }
        if (aVar instanceof a) {
            aVar.addAll((a) obj);
            return aVar;
        }
        aVar.add(obj);
        return aVar;
    }
}
