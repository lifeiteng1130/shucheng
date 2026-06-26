package com.jayway.jsonpath.spi.mapper;

import c.a.a.a.a;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.TypeRef;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TapestryMappingProvider implements MappingProvider {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.ArrayList] */
    @Override // com.jayway.jsonpath.spi.mapper.MappingProvider
    public <T> T map(Object obj, Class<T> cls, Configuration configuration) {
        if (obj == 0) {
            return null;
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        try {
            if (cls.isAssignableFrom(ArrayList.class) && configuration.jsonProvider().isArray(obj)) {
                ?? r1 = (T) new ArrayList(configuration.jsonProvider().length(obj));
                Iterator<?> it = configuration.jsonProvider().toIterable(obj).iterator();
                while (it.hasNext()) {
                    r1.add(it.next());
                }
                return r1;
            }
        } catch (Exception unused) {
        }
        StringBuilder sbR = a.r("Cannot convert a ");
        sbR.append(obj.getClass().getName());
        sbR.append(" to a ");
        sbR.append(cls);
        sbR.append(" use Tapestry's TypeCoercer instead.");
        throw new MappingException(sbR.toString());
    }

    @Override // com.jayway.jsonpath.spi.mapper.MappingProvider
    public <T> T map(Object obj, TypeRef<T> typeRef, Configuration configuration) {
        throw new UnsupportedOperationException("Tapestry JSON provider does not support TypeRef! Use a Jackson or Gson based provider");
    }
}
