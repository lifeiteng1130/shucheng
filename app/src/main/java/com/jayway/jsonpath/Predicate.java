package com.jayway.jsonpath;

/* JADX INFO: loaded from: classes.dex */
public interface Predicate {

    public interface PredicateContext {
        Configuration configuration();

        Object item();

        <T> T item(Class<T> cls);

        Object root();
    }

    boolean apply(PredicateContext predicateContext);
}
