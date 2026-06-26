package com.jayway.jsonpath;

/* JADX INFO: loaded from: classes.dex */
public interface WriteContext {
    DocumentContext add(JsonPath jsonPath, Object obj);

    DocumentContext add(String str, Object obj, Predicate... predicateArr);

    Configuration configuration();

    DocumentContext delete(JsonPath jsonPath);

    DocumentContext delete(String str, Predicate... predicateArr);

    <T> T json();

    String jsonString();

    DocumentContext map(JsonPath jsonPath, MapFunction mapFunction);

    DocumentContext map(String str, MapFunction mapFunction, Predicate... predicateArr);

    DocumentContext put(JsonPath jsonPath, String str, Object obj);

    DocumentContext put(String str, String str2, Object obj, Predicate... predicateArr);

    DocumentContext renameKey(JsonPath jsonPath, String str, String str2);

    DocumentContext renameKey(String str, String str2, String str3, Predicate... predicateArr);

    DocumentContext set(JsonPath jsonPath, Object obj);

    DocumentContext set(String str, Object obj, Predicate... predicateArr);
}
