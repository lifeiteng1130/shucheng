package com.jayway.jsonpath.internal.function.text;

import com.jayway.jsonpath.internal.EvaluationContext;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.function.Parameter;
import com.jayway.jsonpath.internal.function.PathFunction;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Concatenate implements PathFunction {
    @Override // com.jayway.jsonpath.internal.function.PathFunction
    public Object invoke(String str, PathRef pathRef, Object obj, EvaluationContext evaluationContext, List<Parameter> list) {
        StringBuilder sb = new StringBuilder();
        if (evaluationContext.configuration().jsonProvider().isArray(obj)) {
            for (Object obj2 : evaluationContext.configuration().jsonProvider().toIterable(obj)) {
                if (obj2 instanceof String) {
                    sb.append(obj2.toString());
                }
            }
        }
        if (list != null) {
            Iterator it = Parameter.toList(String.class, evaluationContext, list).iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
        }
        return sb.toString();
    }
}
