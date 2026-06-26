package com.jayway.jsonpath.spi.mapper;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.TypeRef;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonOrgMappingProvider implements MappingProvider {
    private Object mapToObject(Object obj) {
        if (obj instanceof JSONArray) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = (JSONArray) obj;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(mapToObject(jSONArray.get(i2)));
            }
            return arrayList;
        }
        if (!(obj instanceof JSONObject)) {
            if (obj == JSONObject.NULL) {
                return null;
            }
            return obj;
        }
        HashMap map = new HashMap();
        JSONObject jSONObject = (JSONObject) obj;
        Iterator it = jSONObject.keySet().iterator();
        while (it.hasNext()) {
            String string = it.next().toString();
            map.put(string, mapToObject(jSONObject.get(string)));
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jayway.jsonpath.spi.mapper.MappingProvider
    public <T> T map(Object obj, Class<T> cls, Configuration configuration) {
        if (obj == 0) {
            return null;
        }
        return (cls.equals(Object.class) || cls.equals(List.class) || cls.equals(Map.class)) ? (T) mapToObject(obj) : obj;
    }

    @Override // com.jayway.jsonpath.spi.mapper.MappingProvider
    public <T> T map(Object obj, TypeRef<T> typeRef, Configuration configuration) {
        throw new UnsupportedOperationException("JsonOrg provider does not support TypeRef! Use a Jackson or Gson based provider");
    }
}
