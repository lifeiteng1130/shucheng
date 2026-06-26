package com.jayway.jsonpath.internal.function.json;

import com.jayway.jsonpath.internal.EvaluationContext;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.function.Parameter;
import com.jayway.jsonpath.internal.function.PathFunction;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KeySetFunction implements PathFunction {
    @Override // com.jayway.jsonpath.internal.function.PathFunction
    public Object invoke(String str, PathRef pathRef, Object obj, EvaluationContext evaluationContext, List<Parameter> list) {
        if (evaluationContext.configuration().jsonProvider().isMap(obj)) {
            return evaluationContext.configuration().jsonProvider().getPropertyKeys(obj);
        }
        return null;
    }
}
