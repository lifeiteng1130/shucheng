package com.jayway.jsonpath.spi.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.TypeRef;

/* JADX INFO: loaded from: classes.dex */
public class JacksonMappingProvider implements MappingProvider {
    private final ObjectMapper objectMapper;

    public JacksonMappingProvider() {
        this(new ObjectMapper());
    }

    @Override // com.jayway.jsonpath.spi.mapper.MappingProvider
    public <T> T map(Object obj, Class<T> cls, Configuration configuration) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) this.objectMapper.convertValue(obj, cls);
        } catch (Exception e2) {
            throw new MappingException(e2);
        }
    }

    public JacksonMappingProvider(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override // com.jayway.jsonpath.spi.mapper.MappingProvider
    public <T> T map(Object obj, TypeRef<T> typeRef, Configuration configuration) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) this.objectMapper.convertValue(obj, this.objectMapper.getTypeFactory().constructType(typeRef.getType()));
        } catch (Exception e2) {
            throw new MappingException(e2);
        }
    }
}
