package com.jayway.jsonpath.internal.function.latebinding;

import com.jayway.jsonpath.internal.function.Parameter;
import com.jayway.jsonpath.spi.json.JsonProvider;

/* JADX INFO: loaded from: classes.dex */
public class JsonLateBindingValue implements ILateBindingValue {
    private final Parameter jsonParameter;
    private final JsonProvider jsonProvider;

    public JsonLateBindingValue(JsonProvider jsonProvider, Parameter parameter) {
        this.jsonProvider = jsonProvider;
        this.jsonParameter = parameter;
    }

    @Override // com.jayway.jsonpath.internal.function.latebinding.ILateBindingValue
    public Object get() {
        return this.jsonProvider.parse(this.jsonParameter.getJson());
    }
}
