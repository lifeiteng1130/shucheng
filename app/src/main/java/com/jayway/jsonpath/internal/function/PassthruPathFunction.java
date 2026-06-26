package com.jayway.jsonpath.internal.function;

import com.jayway.jsonpath.internal.EvaluationContext;
import com.jayway.jsonpath.internal.PathRef;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PassthruPathFunction implements PathFunction {
    @Override // com.jayway.jsonpath.internal.function.PathFunction
    public Object invoke(String str, PathRef pathRef, Object obj, EvaluationContext evaluationContext, List<Parameter> list) {
        return obj;
    }
}
