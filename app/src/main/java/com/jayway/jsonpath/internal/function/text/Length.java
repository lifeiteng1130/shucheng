package com.jayway.jsonpath.internal.function.text;

import com.jayway.jsonpath.internal.EvaluationContext;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.function.Parameter;
import com.jayway.jsonpath.internal.function.PathFunction;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Length implements PathFunction {
    @Override // com.jayway.jsonpath.internal.function.PathFunction
    public Object invoke(String str, PathRef pathRef, Object obj, EvaluationContext evaluationContext, List<Parameter> list) {
        if (evaluationContext.configuration().jsonProvider().isArray(obj)) {
            return Integer.valueOf(evaluationContext.configuration().jsonProvider().length(obj));
        }
        if (evaluationContext.configuration().jsonProvider().isMap(obj)) {
            return Integer.valueOf(evaluationContext.configuration().jsonProvider().length(obj));
        }
        return null;
    }
}
