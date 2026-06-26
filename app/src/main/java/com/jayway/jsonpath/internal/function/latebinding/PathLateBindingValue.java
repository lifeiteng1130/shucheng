package com.jayway.jsonpath.internal.function.latebinding;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.internal.Path;

/* JADX INFO: loaded from: classes.dex */
public class PathLateBindingValue implements ILateBindingValue {
    private final Configuration configuration;
    private final Path path;
    private final Object rootDocument;

    public PathLateBindingValue(Path path, Object obj, Configuration configuration) {
        this.path = path;
        this.rootDocument = obj;
        this.configuration = configuration;
    }

    @Override // com.jayway.jsonpath.internal.function.latebinding.ILateBindingValue
    public Object get() {
        Path path = this.path;
        Object obj = this.rootDocument;
        return path.evaluate(obj, obj, this.configuration).getValue();
    }
}
