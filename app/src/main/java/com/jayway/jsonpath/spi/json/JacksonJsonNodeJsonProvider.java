package com.jayway.jsonpath.spi.json;

import c.a.a.a.a;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPathException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JacksonJsonNodeJsonProvider extends AbstractJsonProvider {
    private static final ObjectMapper defaultObjectMapper = new ObjectMapper();
    public ObjectMapper objectMapper;

    public JacksonJsonNodeJsonProvider() {
        this(defaultObjectMapper);
    }

    private JsonNode createJsonElement(Object obj) {
        if (obj != null) {
            return obj instanceof JsonNode ? (JsonNode) obj : this.objectMapper.valueToTree(obj);
        }
        return null;
    }

    private void setValueInObjectNode(ObjectNode objectNode, Object obj, Object obj2) {
        if (obj2 instanceof JsonNode) {
            objectNode.set(obj.toString(), (JsonNode) obj2);
            return;
        }
        if (obj2 instanceof String) {
            objectNode.put(obj.toString(), (String) obj2);
            return;
        }
        if (obj2 instanceof Integer) {
            objectNode.put(obj.toString(), (Integer) obj2);
            return;
        }
        if (obj2 instanceof Long) {
            objectNode.put(obj.toString(), (Long) obj2);
            return;
        }
        if (obj2 instanceof Short) {
            objectNode.put(obj.toString(), (Short) obj2);
            return;
        }
        if (obj2 instanceof BigInteger) {
            objectNode.put(obj.toString(), (BigInteger) obj2);
            return;
        }
        if (obj2 instanceof Double) {
            objectNode.put(obj.toString(), (Double) obj2);
            return;
        }
        if (obj2 instanceof Float) {
            objectNode.put(obj.toString(), (Float) obj2);
            return;
        }
        if (obj2 instanceof BigDecimal) {
            objectNode.put(obj.toString(), (BigDecimal) obj2);
            return;
        }
        if (obj2 instanceof Boolean) {
            objectNode.put(obj.toString(), (Boolean) obj2);
            return;
        }
        if (obj2 instanceof byte[]) {
            objectNode.put(obj.toString(), (byte[]) obj2);
        } else if (obj2 == null) {
            objectNode.set(obj.toString(), (JsonNode) null);
        } else {
            objectNode.set(obj.toString(), createJsonElement(obj2));
        }
    }

    private ArrayNode toJsonArray(Object obj) {
        return (ArrayNode) obj;
    }

    private ObjectNode toJsonObject(Object obj) {
        return (ObjectNode) obj;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object createArray() {
        return JsonNodeFactory.instance.arrayNode();
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object createMap() {
        return JsonNodeFactory.instance.objectNode();
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Object getArrayIndex(Object obj, int i2) {
        return toJsonArray(obj).get(i2);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Object getMapValue(Object obj, String str) {
        ObjectNode jsonObject = toJsonObject(obj);
        return !jsonObject.has(str) ? JsonProvider.UNDEFINED : unwrap(jsonObject.get(str));
    }

    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Collection<String> getPropertyKeys(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator itFieldNames = toJsonObject(obj).fieldNames();
        while (itFieldNames.hasNext()) {
            arrayList.add(itFieldNames.next());
        }
        return arrayList;
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public boolean isArray(Object obj) {
        return (obj instanceof ArrayNode) || (obj instanceof List);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public boolean isMap(Object obj) {
        return obj instanceof ObjectNode;
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public int length(Object obj) {
        if (isArray(obj)) {
            return toJsonArray(obj).size();
        }
        if (isMap(obj)) {
            return toJsonObject(obj).size();
        }
        if (obj instanceof TextNode) {
            return ((TextNode) obj).size();
        }
        StringBuilder sbR = a.r("length operation can not applied to ");
        sbR.append(obj != null ? obj.getClass().getName() : "null");
        throw new JsonPathException(sbR.toString());
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(String str) {
        try {
            return this.objectMapper.readTree(str);
        } catch (IOException e2) {
            throw new InvalidJsonException(e2, str);
        }
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
        ArrayNode jsonArray = toJsonArray(obj);
        if (i2 == jsonArray.size()) {
            jsonArray.add(createJsonElement(obj2));
        } else {
            jsonArray.set(i2, createJsonElement(obj2));
        }
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public void setProperty(Object obj, Object obj2, Object obj3) {
        if (isMap(obj)) {
            setValueInObjectNode((ObjectNode) obj, obj2, obj3);
            return;
        }
        ArrayNode arrayNode = (ArrayNode) obj;
        int iIntValue = obj2 != null ? obj2 instanceof Integer ? ((Integer) obj2).intValue() : Integer.parseInt(obj2.toString()) : arrayNode.size();
        if (iIntValue == arrayNode.size()) {
            arrayNode.add(createJsonElement(obj3));
        } else {
            arrayNode.set(iIntValue, createJsonElement(obj3));
        }
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Iterable<?> toIterable(Object obj) {
        ArrayNode jsonArray = toJsonArray(obj);
        ArrayList arrayList = new ArrayList(jsonArray.size());
        Iterator it = jsonArray.iterator();
        while (it.hasNext()) {
            arrayList.add(unwrap(it.next()));
        }
        return arrayList;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public String toJson(Object obj) {
        if (obj instanceof JsonNode) {
            return obj.toString();
        }
        throw new JsonPathException("Not a JSON Node");
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Object unwrap(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JsonNode)) {
            return obj;
        }
        JsonNode jsonNode = (JsonNode) obj;
        if (jsonNode.isValueNode()) {
            if (jsonNode.isTextual()) {
                return jsonNode.asText();
            }
            if (jsonNode.isBoolean()) {
                return Boolean.valueOf(jsonNode.asBoolean());
            }
            if (jsonNode.isInt()) {
                return Integer.valueOf(jsonNode.asInt());
            }
            if (jsonNode.isLong()) {
                return Long.valueOf(jsonNode.asLong());
            }
            if (jsonNode.isBigInteger()) {
                return jsonNode.bigIntegerValue();
            }
            if (jsonNode.isDouble()) {
                return Double.valueOf(jsonNode.doubleValue());
            }
            if (jsonNode.isFloat()) {
                return Float.valueOf(jsonNode.floatValue());
            }
            if (jsonNode.isBigDecimal()) {
                return jsonNode.decimalValue();
            }
            if (jsonNode.isNull()) {
                return null;
            }
        }
        return obj;
    }

    public JacksonJsonNodeJsonProvider(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(InputStream inputStream, String str) {
        try {
            return this.objectMapper.readTree(new InputStreamReader(inputStream, str));
        } catch (IOException e2) {
            throw new InvalidJsonException(e2);
        }
    }
}
