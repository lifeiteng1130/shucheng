package com.jayway.jsonpath.internal.function.numeric;

import com.jayway.jsonpath.JsonPathException;
import com.jayway.jsonpath.internal.EvaluationContext;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.function.Parameter;
import com.jayway.jsonpath.internal.function.PathFunction;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractAggregation implements PathFunction {
    public abstract Number getValue();

    @Override // com.jayway.jsonpath.internal.function.PathFunction
    public Object invoke(String str, PathRef pathRef, Object obj, EvaluationContext evaluationContext, List<Parameter> list) {
        int i2 = 0;
        if (evaluationContext.configuration().jsonProvider().isArray(obj)) {
            for (Object obj2 : evaluationContext.configuration().jsonProvider().toIterable(obj)) {
                if (obj2 instanceof Number) {
                    i2++;
                    next((Number) obj2);
                }
            }
        }
        if (list != null) {
            Iterator it = Parameter.toList(Number.class, evaluationContext, list).iterator();
            while (it.hasNext()) {
                i2++;
                next((Number) it.next());
            }
        }
        if (i2 != 0) {
            return getValue();
        }
        throw new JsonPathException("Aggregation function attempted to calculate value using empty array");
    }

    public abstract void next(Number number);
}
