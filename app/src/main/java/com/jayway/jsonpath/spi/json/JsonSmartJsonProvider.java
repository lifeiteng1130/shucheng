package com.jayway.jsonpath.spi.json;

import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPathException;
import i.a.b.d;
import i.a.b.i;
import i.a.b.k.a;
import i.a.b.k.g;
import i.a.b.m.k;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class JsonSmartJsonProvider extends AbstractJsonProvider {
    private final k<?> mapper;
    private final int parseMode;

    public JsonSmartJsonProvider() {
        this(-1, i.f6361c.f6423c);
    }

    private a createParser() {
        return new a(this.parseMode);
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object createArray() {
        return this.mapper.createArray();
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object createMap() {
        return this.mapper.createObject();
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(String str) {
        try {
            return createParser().c(str, this.mapper);
        } catch (g e2) {
            throw new InvalidJsonException(e2);
        }
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public String toJson(Object obj) {
        if (obj instanceof Map) {
            return d.toJSONString((Map) obj, i.a.b.g.f6352b);
        }
        if (obj instanceof List) {
            return i.a.b.a.toJSONString((List) obj, i.a.b.g.f6352b);
        }
        throw new UnsupportedOperationException(obj.getClass().getName() + " can not be converted to JSON");
    }

    public JsonSmartJsonProvider(int i2) {
        this(i2, i.f6361c.f6423c);
    }

    public JsonSmartJsonProvider(int i2, k<?> kVar) {
        this.parseMode = i2;
        this.mapper = kVar;
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(InputStream inputStream, String str) {
        try {
            return createParser().a(new InputStreamReader(inputStream, str), this.mapper);
        } catch (g e2) {
            throw new InvalidJsonException(e2);
        } catch (UnsupportedEncodingException e3) {
            throw new JsonPathException(e3);
        }
    }
}
