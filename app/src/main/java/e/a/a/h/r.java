package e.a.a.h;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: GsonExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements JsonDeserializer<Integer> {
    @Override // com.google.gson.JsonDeserializer
    public Integer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        f.c0.c.j.e(jsonElement, "json");
        if (jsonElement.isJsonPrimitive()) {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                return Integer.valueOf(asJsonPrimitive.getAsNumber().intValue());
            }
        }
        return null;
    }
}
