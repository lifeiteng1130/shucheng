package com.jayway.jsonpath;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public abstract class TypeRef<T> implements Comparable<TypeRef<T>> {
    public final Type type;

    public TypeRef() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new IllegalArgumentException("No type info in TypeRef");
        }
        this.type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }

    @Override // java.lang.Comparable
    public int compareTo(TypeRef<T> typeRef) {
        return 0;
    }

    public Type getType() {
        return this.type;
    }
}
