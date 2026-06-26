package com.jayway.jsonpath.spi.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.jayway.jsonpath.InvalidJsonException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JacksonJsonProvider extends AbstractJsonProvider {
    private static final ObjectMapper defaultObjectMapper;
    private static final ObjectReader defaultObjectReader;
    public ObjectMapper objectMapper;
    public ObjectReader objectReader;

    static {
        ObjectMapper objectMapper = new ObjectMapper();
        defaultObjectMapper = objectMapper;
        defaultObjectReader = objectMapper.reader().forType(Object.class);
    }

    public JacksonJsonProvider() {
        this(defaultObjectMapper, defaultObjectReader);
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object createMap() {
        return new LinkedHashMap();
    }

    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(String str) {
        try {
            return this.objectReader.readValue(str);
        } catch (IOException e2) {
            throw new InvalidJsonException(e2, str);
        }
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public String toJson(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            JsonGenerator jsonGeneratorCreateGenerator = this.objectMapper.getFactory().createGenerator(stringWriter);
            this.objectMapper.writeValue(jsonGeneratorCreateGenerator, obj);
            stringWriter.flush();
            stringWriter.close();
            jsonGeneratorCreateGenerator.close();
            return stringWriter.getBuffer().toString();
        } catch (IOException e2) {
            throw new InvalidJsonException(e2);
        }
    }

    public JacksonJsonProvider(ObjectMapper objectMapper) {
        this(objectMapper, objectMapper.reader().forType(Object.class));
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public List<Object> createArray() {
        return new LinkedList();
    }

    public JacksonJsonProvider(ObjectMapper objectMapper, ObjectReader objectReader) {
        this.objectMapper = objectMapper;
        this.objectReader = objectReader;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(InputStream inputStream, String str) {
        try {
            return this.objectReader.readValue(new InputStreamReader(inputStream, str));
        } catch (IOException e2) {
            throw new InvalidJsonException(e2);
        }
    }
}
