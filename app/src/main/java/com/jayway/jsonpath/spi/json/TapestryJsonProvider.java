package com.jayway.jsonpath.spi.json;

import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONCollection;
import org.apache.tapestry5.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TapestryJsonProvider extends AbstractJsonProvider {
    public static final TapestryJsonProvider INSTANCE = new TapestryJsonProvider();

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object createArray() {
        return new JSONArray();
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object createMap() {
        return new JSONObject();
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Object getArrayIndex(Object obj, int i2) {
        return ((JSONArray) obj).get(i2);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Object getMapValue(Object obj, String str) {
        JSONObject jSONObject = (JSONObject) obj;
        return !jSONObject.has(str) ? JsonProvider.UNDEFINED : jSONObject.get(str);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Collection<String> getPropertyKeys(Object obj) {
        return ((JSONObject) obj).keys();
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public boolean isArray(Object obj) {
        return obj instanceof JSONArray;
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public boolean isMap(Object obj) {
        return obj instanceof JSONObject;
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public int length(Object obj) {
        if (obj instanceof JSONArray) {
            return ((JSONArray) obj).length();
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).length();
        }
        throw new IllegalArgumentException("Cannot determine length of " + obj + ", unsupported type.");
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(String str) {
        return new JSONObject(str);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public void setArrayIndex(Object obj, int i2, Object obj2) {
        if (obj2 == null) {
            obj2 = JSONObject.NULL;
        }
        ((JSONArray) obj).put(i2, obj2);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public void setProperty(Object obj, Object obj2, Object obj3) {
        if (obj3 == null) {
            obj3 = JSONObject.NULL;
        }
        if (isMap(obj)) {
            ((JSONObject) obj).put(obj2.toString(), obj3);
        }
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public String toJson(Object obj) {
        return ((JSONCollection) obj).toCompactString();
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(InputStream inputStream, String str) throws Throwable {
        Scanner scanner = null;
        try {
            Scanner scanner2 = new Scanner(inputStream, str);
            try {
                Object obj = parse(scanner2.useDelimiter("\\A").next());
                scanner2.close();
                return obj;
            } catch (Throwable th) {
                th = th;
                scanner = scanner2;
                if (scanner != null) {
                    scanner.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
