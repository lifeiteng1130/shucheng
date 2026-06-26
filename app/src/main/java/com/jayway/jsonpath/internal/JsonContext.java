package com.jayway.jsonpath.internal;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.EvaluationListener;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.MapFunction;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.ReadContext;
import com.jayway.jsonpath.TypeRef;
import com.jayway.jsonpath.spi.cache.Cache;
import com.jayway.jsonpath.spi.cache.CacheProvider;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class JsonContext implements DocumentContext {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) JsonContext.class);
    private final Configuration configuration;
    private final Object json;

    public static final class LimitingEvaluationListener implements EvaluationListener {
        public final int limit;

        @Override // com.jayway.jsonpath.EvaluationListener
        public EvaluationListener.EvaluationContinuation resultFound(EvaluationListener.FoundResult foundResult) {
            return foundResult.index() == this.limit + (-1) ? EvaluationListener.EvaluationContinuation.ABORT : EvaluationListener.EvaluationContinuation.CONTINUE;
        }

        private LimitingEvaluationListener(int i2) {
            this.limit = i2;
        }
    }

    public JsonContext(Object obj, Configuration configuration) {
        Utils.notNull(obj, "json can not be null", new Object[0]);
        Utils.notNull(configuration, "configuration can not be null", new Object[0]);
        this.configuration = configuration;
        this.json = obj;
    }

    private <T> T convert(Object obj, Class<T> cls, Configuration configuration) {
        return (T) configuration.mappingProvider().map(obj, cls, configuration);
    }

    private JsonPath pathFromCache(String str, Predicate[] predicateArr) {
        Cache cache = CacheProvider.getCache();
        String strConcat = Utils.concat(str, new LinkedList(Arrays.asList(predicateArr)).toString());
        JsonPath jsonPath = cache.get(strConcat);
        if (jsonPath != null) {
            return jsonPath;
        }
        JsonPath jsonPathCompile = JsonPath.compile(str, predicateArr);
        cache.put(strConcat, jsonPathCompile);
        return jsonPathCompile;
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext add(String str, Object obj, Predicate... predicateArr) {
        return add(pathFromCache(str, predicateArr), obj);
    }

    @Override // com.jayway.jsonpath.ReadContext, com.jayway.jsonpath.WriteContext
    public Configuration configuration() {
        return this.configuration;
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext delete(String str, Predicate... predicateArr) {
        return delete(pathFromCache(str, predicateArr));
    }

    @Override // com.jayway.jsonpath.ReadContext, com.jayway.jsonpath.WriteContext
    public Object json() {
        return this.json;
    }

    @Override // com.jayway.jsonpath.ReadContext, com.jayway.jsonpath.WriteContext
    public String jsonString() {
        return this.configuration.jsonProvider().toJson(this.json);
    }

    @Override // com.jayway.jsonpath.ReadContext
    public ReadContext limit(int i2) {
        return withListeners(new LimitingEvaluationListener(i2));
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext map(String str, MapFunction mapFunction, Predicate... predicateArr) {
        map(pathFromCache(str, predicateArr), mapFunction);
        return this;
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext put(String str, String str2, Object obj, Predicate... predicateArr) {
        return put(pathFromCache(str, predicateArr), str2, obj);
    }

    @Override // com.jayway.jsonpath.ReadContext
    public <T> T read(String str, Predicate... predicateArr) {
        Utils.notEmpty(str, "path can not be null or empty", new Object[0]);
        return (T) read(pathFromCache(str, predicateArr));
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext renameKey(String str, String str2, String str3, Predicate... predicateArr) {
        return renameKey(pathFromCache(str, predicateArr), str2, str3);
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext set(String str, Object obj, Predicate... predicateArr) {
        return set(pathFromCache(str, predicateArr), obj);
    }

    @Override // com.jayway.jsonpath.ReadContext
    public ReadContext withListeners(EvaluationListener... evaluationListenerArr) {
        return new JsonContext(this.json, this.configuration.setEvaluationListeners(evaluationListenerArr));
    }

    private <T> T convert(Object obj, TypeRef<T> typeRef, Configuration configuration) {
        return (T) configuration.mappingProvider().map(obj, typeRef, configuration);
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext add(JsonPath jsonPath, Object obj) {
        List list = (List) jsonPath.add(this.json, obj, this.configuration.addOptions(Option.AS_PATH_LIST));
        if (logger.isDebugEnabled()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                logger.debug("Add path {} new value {}", (String) it.next(), obj);
            }
        }
        return this;
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext delete(JsonPath jsonPath) {
        List list = (List) jsonPath.delete(this.json, this.configuration.addOptions(Option.AS_PATH_LIST));
        if (logger.isDebugEnabled()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                logger.debug("Delete path {}", (String) it.next());
            }
        }
        return this;
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext map(JsonPath jsonPath, MapFunction mapFunction) {
        jsonPath.map(this.json, mapFunction, this.configuration);
        return this;
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext put(JsonPath jsonPath, String str, Object obj) {
        List list = (List) jsonPath.put(this.json, str, obj, this.configuration.addOptions(Option.AS_PATH_LIST));
        if (logger.isDebugEnabled()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                logger.debug("Put path {} key {} value {}", (String) it.next(), str, obj);
            }
        }
        return this;
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext renameKey(JsonPath jsonPath, String str, String str2) {
        List list = (List) jsonPath.renameKey(this.json, str, str2, this.configuration.addOptions(Option.AS_PATH_LIST));
        if (logger.isDebugEnabled()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                logger.debug("Rename path {} new value {}", (String) it.next(), str2);
            }
        }
        return this;
    }

    @Override // com.jayway.jsonpath.WriteContext
    public DocumentContext set(JsonPath jsonPath, Object obj) {
        List list = (List) jsonPath.set(this.json, obj, this.configuration.addOptions(Option.AS_PATH_LIST));
        if (logger.isDebugEnabled()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                logger.debug("Set path {} new value {}", (String) it.next(), obj);
            }
        }
        return this;
    }

    @Override // com.jayway.jsonpath.ReadContext
    public <T> T read(String str, Class<T> cls, Predicate... predicateArr) {
        return (T) convert(read(str, predicateArr), cls, this.configuration);
    }

    @Override // com.jayway.jsonpath.ReadContext
    public <T> T read(JsonPath jsonPath) {
        Utils.notNull(jsonPath, "path can not be null", new Object[0]);
        return (T) jsonPath.read(this.json, this.configuration);
    }

    @Override // com.jayway.jsonpath.ReadContext
    public <T> T read(JsonPath jsonPath, Class<T> cls) {
        return (T) convert(read(jsonPath), cls, this.configuration);
    }

    @Override // com.jayway.jsonpath.ReadContext
    public <T> T read(JsonPath jsonPath, TypeRef<T> typeRef) {
        return (T) convert(read(jsonPath), typeRef, this.configuration);
    }

    @Override // com.jayway.jsonpath.ReadContext
    public <T> T read(String str, TypeRef<T> typeRef) {
        return (T) convert(read(str, new Predicate[0]), typeRef, this.configuration);
    }
}
