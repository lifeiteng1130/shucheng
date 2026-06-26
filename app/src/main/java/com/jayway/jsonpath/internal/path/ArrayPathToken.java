package com.jayway.jsonpath.internal.path;

import c.a.a.a.a;
import com.jayway.jsonpath.PathNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public abstract class ArrayPathToken extends PathToken {
    public boolean checkArrayModel(String str, Object obj, EvaluationContextImpl evaluationContextImpl) {
        if (obj == null) {
            if (isUpstreamDefinite()) {
                throw new PathNotFoundException(a.k("The path ", str, " is null"));
            }
            return false;
        }
        if (evaluationContextImpl.jsonProvider().isArray(obj)) {
            return true;
        }
        if (isUpstreamDefinite()) {
            throw new PathNotFoundException(String.format("Filter: %s can only be applied to arrays. Current context is: %s", toString(), obj));
        }
        return false;
    }
}
