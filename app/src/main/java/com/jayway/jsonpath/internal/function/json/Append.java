package com.jayway.jsonpath.internal.function.json;

import com.jayway.jsonpath.internal.EvaluationContext;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.function.Parameter;
import com.jayway.jsonpath.internal.function.PathFunction;
import com.jayway.jsonpath.spi.json.JsonProvider;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Append implements PathFunction {
    @Override // com.jayway.jsonpath.internal.function.PathFunction
    public Object invoke(String str, PathRef pathRef, Object obj, EvaluationContext evaluationContext, List<Parameter> list) {
        JsonProvider jsonProvider = evaluationContext.configuration().jsonProvider();
        if (list != null && list.size() > 0) {
            for (Parameter parameter : list) {
                if (jsonProvider.isArray(obj)) {
                    jsonProvider.setArrayIndex(obj, jsonProvider.length(obj), parameter.getValue());
                }
            }
        }
        return obj;
    }
}
