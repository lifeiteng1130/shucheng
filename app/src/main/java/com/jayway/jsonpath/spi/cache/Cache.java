package com.jayway.jsonpath.spi.cache;

import com.jayway.jsonpath.JsonPath;

/* JADX INFO: loaded from: classes.dex */
public interface Cache {
    JsonPath get(String str);

    void put(String str, JsonPath jsonPath);
}
