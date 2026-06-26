package e.a.a.h;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: GsonExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements JsonDeserializer<Map<String, ? extends Object>> {
    @Nullable
    public final Object a(@NotNull JsonElement jsonElement) {
        f.c0.c.j.e(jsonElement, "json");
        if (jsonElement.isJsonArray()) {
            ArrayList arrayList = new ArrayList();
            for (JsonElement jsonElement2 : jsonElement.getAsJsonArray()) {
                f.c0.c.j.d(jsonElement2, "anArr");
                arrayList.add(a(jsonElement2));
            }
            return arrayList;
        }
        if (jsonElement.isJsonObject()) {
            LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                f.c0.c.j.d(entry, "entitySet");
                String key = entry.getKey();
                JsonElement value = entry.getValue();
                f.c0.c.j.d(key, "key");
                f.c0.c.j.d(value, ES6Iterator.VALUE_PROPERTY);
                linkedTreeMap.put(key, a(value));
            }
            return linkedTreeMap;
        }
        if (!jsonElement.isJsonPrimitive()) {
            return null;
        }
        JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
        if (asJsonPrimitive.isBoolean()) {
            return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
        }
        if (asJsonPrimitive.isString()) {
            return asJsonPrimitive.getAsString();
        }
        if (!asJsonPrimitive.isNumber()) {
            return null;
        }
        Number asNumber = asJsonPrimitive.getAsNumber();
        f.c0.c.j.d(asNumber, "prim.asNumber");
        return (Math.ceil(asNumber.doubleValue()) > ((double) asNumber.longValue()) ? 1 : (Math.ceil(asNumber.doubleValue()) == ((double) asNumber.longValue()) ? 0 : -1)) == 0 ? Long.valueOf(asNumber.longValue()) : Double.valueOf(asNumber.doubleValue());
    }

    @Override // com.google.gson.JsonDeserializer
    public Map<String, ? extends Object> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        f.c0.c.j.e(jsonElement, "jsonElement");
        f.c0.c.j.e(type, "type");
        f.c0.c.j.e(jsonDeserializationContext, "jsonDeserializationContext");
        Object objA = a(jsonElement);
        if (objA instanceof Map) {
            return (Map) objA;
        }
        return null;
    }
}
