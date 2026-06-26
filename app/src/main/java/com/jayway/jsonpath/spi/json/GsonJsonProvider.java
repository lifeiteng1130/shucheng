package com.jayway.jsonpath.spi.json;

import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.jayway.jsonpath.JsonPathException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GsonJsonProvider extends AbstractJsonProvider {
    private static final JsonParser PARSER = new JsonParser();
    private final Gson gson;

    public GsonJsonProvider() {
        this(new Gson());
    }

    private JsonElement createJsonElement(Object obj) {
        return this.gson.toJsonTree(obj);
    }

    private static boolean isPrimitiveNumber(Number number) {
        return (number instanceof Integer) || (number instanceof Float) || (number instanceof Double) || (number instanceof Long) || (number instanceof BigDecimal) || (number instanceof BigInteger);
    }

    private JsonArray toJsonArray(Object obj) {
        return (JsonArray) obj;
    }

    private JsonElement toJsonElement(Object obj) {
        return (JsonElement) obj;
    }

    private JsonObject toJsonObject(Object obj) {
        return (JsonObject) obj;
    }

    private static Number unwrapNumber(Number number) {
        if (isPrimitiveNumber(number)) {
            return number;
        }
        BigDecimal bigDecimal = new BigDecimal(number.toString());
        if (bigDecimal.scale() > 0) {
            double dDoubleValue = bigDecimal.doubleValue();
            if (BigDecimal.valueOf(dDoubleValue).compareTo(bigDecimal) == 0) {
                return Double.valueOf(dDoubleValue);
            }
        } else {
            if (bigDecimal.abs().compareTo(new BigDecimal(Integer.MAX_VALUE)) <= 0) {
                return Integer.valueOf(bigDecimal.intValue());
            }
            if (bigDecimal.abs().compareTo(new BigDecimal(RecyclerView.FOREVER_NS)) <= 0) {
                return Long.valueOf(bigDecimal.longValue());
            }
        }
        return bigDecimal;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object createArray() {
        return new JsonArray();
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object createMap() {
        return new JsonObject();
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Object getArrayIndex(Object obj, int i2) {
        return toJsonArray(obj).get(i2);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Object getMapValue(Object obj, String str) {
        JsonObject jsonObject = toJsonObject(obj);
        return !jsonObject.has(str) ? JsonProvider.UNDEFINED : unwrap(jsonObject.get(str));
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Collection<String> getPropertyKeys(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, JsonElement>> it = toJsonObject(obj).entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public boolean isArray(Object obj) {
        return (obj instanceof JsonArray) || (obj instanceof List);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public boolean isMap(Object obj) {
        return obj instanceof JsonObject;
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public int length(Object obj) {
        if (isArray(obj)) {
            return toJsonArray(obj).size();
        }
        if (isMap(obj)) {
            return toJsonObject(obj).entrySet().size();
        }
        if (obj instanceof JsonElement) {
            JsonElement jsonElement = toJsonElement(obj);
            if (jsonElement.isJsonPrimitive()) {
                return jsonElement.toString().length();
            }
        }
        StringBuilder sbR = a.r("length operation can not applied to ");
        sbR.append(obj != null ? obj.getClass().getName() : "null");
        throw new JsonPathException(sbR.toString());
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(String str) {
        return PARSER.parse(str);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public void removeProperty(Object obj, Object obj2) {
        if (isMap(obj)) {
            toJsonObject(obj).remove(obj2.toString());
        } else {
            toJsonArray(obj).remove(obj2 instanceof Integer ? ((Integer) obj2).intValue() : Integer.parseInt(obj2.toString()));
        }
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public void setArrayIndex(Object obj, int i2, Object obj2) {
        if (!isArray(obj)) {
            throw new UnsupportedOperationException();
        }
        JsonArray jsonArray = toJsonArray(obj);
        if (i2 == jsonArray.size()) {
            jsonArray.add(createJsonElement(obj2));
        } else {
            jsonArray.set(i2, createJsonElement(obj2));
        }
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public void setProperty(Object obj, Object obj2, Object obj3) {
        if (isMap(obj)) {
            toJsonObject(obj).add(obj2.toString(), createJsonElement(obj3));
            return;
        }
        JsonArray jsonArray = toJsonArray(obj);
        int iIntValue = obj2 != null ? obj2 instanceof Integer ? ((Integer) obj2).intValue() : Integer.parseInt(obj2.toString()) : jsonArray.size();
        if (iIntValue == jsonArray.size()) {
            jsonArray.add(createJsonElement(obj3));
        } else {
            jsonArray.set(iIntValue, createJsonElement(obj3));
        }
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Iterable<?> toIterable(Object obj) {
        JsonArray jsonArray = toJsonArray(obj);
        ArrayList arrayList = new ArrayList(jsonArray.size());
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            arrayList.add(unwrap(it.next()));
        }
        return arrayList;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public String toJson(Object obj) {
        return this.gson.toJson(obj);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Object unwrap(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JsonElement)) {
            return obj;
        }
        JsonElement jsonElement = (JsonElement) obj;
        if (jsonElement.isJsonNull()) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            return obj;
        }
        JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
        return asJsonPrimitive.isString() ? asJsonPrimitive.getAsString() : asJsonPrimitive.isBoolean() ? Boolean.valueOf(asJsonPrimitive.getAsBoolean()) : asJsonPrimitive.isNumber() ? unwrapNumber(asJsonPrimitive.getAsNumber()) : obj;
    }

    public GsonJsonProvider(Gson gson) {
        this.gson = gson;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(InputStream inputStream, String str) {
        try {
            return PARSER.parse(new InputStreamReader(inputStream, str));
        } catch (UnsupportedEncodingException e2) {
            throw new JsonPathException(e2);
        }
    }
}
