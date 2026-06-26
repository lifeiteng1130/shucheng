package com.jayway.jsonpath.internal.path;

import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.internal.PathRef;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class WildcardPathToken extends PathToken {
    @Override // com.jayway.jsonpath.internal.path.PathToken
    public void evaluate(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        if (evaluationContextImpl.jsonProvider().isMap(obj)) {
            Iterator<String> it = evaluationContextImpl.jsonProvider().getPropertyKeys(obj).iterator();
            while (it.hasNext()) {
                handleObjectProperty(str, obj, evaluationContextImpl, Collections.singletonList(it.next()));
            }
        } else if (evaluationContextImpl.jsonProvider().isArray(obj)) {
            for (int i2 = 0; i2 < evaluationContextImpl.jsonProvider().length(obj); i2++) {
                try {
                    handleArrayIndex(i2, str, obj, evaluationContextImpl);
                } catch (PathNotFoundException e2) {
                    if (evaluationContextImpl.options().contains(Option.REQUIRE_PROPERTIES)) {
                        throw e2;
                    }
                }
            }
        }
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public String getPathFragment() {
        return "[*]";
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public boolean isTokenDefinite() {
        return false;
    }
}
