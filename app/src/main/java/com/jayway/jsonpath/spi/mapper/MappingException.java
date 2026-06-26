package com.jayway.jsonpath.spi.mapper;

import com.jayway.jsonpath.JsonPathException;

/* JADX INFO: loaded from: classes.dex */
public class MappingException extends JsonPathException {
    public MappingException(Throwable th) {
        super(th);
    }

    public MappingException(String str) {
        super(str);
    }
}
