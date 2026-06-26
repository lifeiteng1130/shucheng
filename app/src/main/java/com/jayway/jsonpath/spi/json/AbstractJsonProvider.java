package com.jayway.jsonpath.spi.json;

import c.a.a.a.a;
import com.jayway.jsonpath.JsonPathException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractJsonProvider implements JsonProvider {
    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object getArrayIndex(Object obj, int i2) {
        return ((List) obj).get(i2);
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object getMapValue(Object obj, String str) {
        Map map = (Map) obj;
        return !map.containsKey(str) ? JsonProvider.UNDEFINED : map.get(str);
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Collection<String> getPropertyKeys(Object obj) {
        if (isArray(obj)) {
            throw new UnsupportedOperationException();
        }
        return ((Map) obj).keySet();
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public boolean isArray(Object obj) {
        return obj instanceof List;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public boolean isMap(Object obj) {
        return obj instanceof Map;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public int length(Object obj) {
        if (isArray(obj)) {
            return ((List) obj).size();
        }
        if (isMap(obj)) {
            return getPropertyKeys(obj).size();
        }
        if (obj instanceof String) {
            return ((String) obj).length();
        }
        StringBuilder sbR = a.r("length operation cannot be applied to ");
        sbR.append(obj != null ? obj.getClass().getName() : "null");
        throw new JsonPathException(sbR.toString());
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public void removeProperty(Object obj, Object obj2) {
        if (isMap(obj)) {
            ((Map) obj).remove(obj2.toString());
        } else {
            ((List) obj).remove(obj2 instanceof Integer ? ((Integer) obj2).intValue() : Integer.parseInt(obj2.toString()));
        }
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public void setArrayIndex(Object obj, int i2, Object obj2) {
        if (!isArray(obj)) {
            throw new UnsupportedOperationException();
        }
        List list = (List) obj;
        if (i2 == list.size()) {
            list.add(obj2);
        } else {
            list.set(i2, obj2);
        }
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public void setProperty(Object obj, Object obj2, Object obj3) {
        if (isMap(obj)) {
            ((Map) obj).put(obj2.toString(), obj3);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("setProperty operation cannot be used with ");
        sb.append(obj);
        throw new JsonPathException(sb.toString() != null ? obj.getClass().getName() : "null");
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Iterable<?> toIterable(Object obj) {
        if (isArray(obj)) {
            return (Iterable) obj;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot iterate over ");
        sb.append(obj);
        throw new JsonPathException(sb.toString() != null ? obj.getClass().getName() : "null");
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object unwrap(Object obj) {
        return obj;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    @Deprecated
    public final Object getArrayIndex(Object obj, int i2, boolean z) {
        return getArrayIndex(obj, i2);
    }
}
