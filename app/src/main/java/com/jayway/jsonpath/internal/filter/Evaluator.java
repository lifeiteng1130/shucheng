package com.jayway.jsonpath.internal.filter;

import com.jayway.jsonpath.Predicate;

/* JADX INFO: loaded from: classes.dex */
public interface Evaluator {
    boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext);
}
