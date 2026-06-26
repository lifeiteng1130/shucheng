package com.jayway.jsonpath.internal.path;

import c.a.a.a.a;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.internal.PathRef;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class PredicatePathToken extends PathToken {
    private final Collection<Predicate> predicates;

    public PredicatePathToken(Predicate predicate) {
        this.predicates = Collections.singletonList(predicate);
    }

    public boolean accept(Object obj, Object obj2, Configuration configuration, EvaluationContextImpl evaluationContextImpl) {
        PredicateContextImpl predicateContextImpl = new PredicateContextImpl(obj, obj2, configuration, evaluationContextImpl.documentEvalCache());
        Iterator<Predicate> it = this.predicates.iterator();
        while (it.hasNext()) {
            if (!it.next().apply(predicateContextImpl)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public void evaluate(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        if (evaluationContextImpl.jsonProvider().isMap(obj)) {
            if (accept(obj, evaluationContextImpl.rootDocument(), evaluationContextImpl.configuration(), evaluationContextImpl)) {
                if (!evaluationContextImpl.forUpdate()) {
                    pathRef = PathRef.NO_OP;
                }
                if (isLeaf()) {
                    evaluationContextImpl.addResult(str, pathRef, obj);
                    return;
                } else {
                    next().evaluate(str, pathRef, obj, evaluationContextImpl);
                    return;
                }
            }
            return;
        }
        int i2 = 0;
        if (!evaluationContextImpl.jsonProvider().isArray(obj)) {
            if (isUpstreamDefinite()) {
                throw new InvalidPathException(String.format("Filter: %s can not be applied to primitives. Current context is: %s", toString(), obj));
            }
            return;
        }
        Iterator<?> it = evaluationContextImpl.jsonProvider().toIterable(obj).iterator();
        while (it.hasNext()) {
            if (accept(it.next(), evaluationContextImpl.rootDocument(), evaluationContextImpl.configuration(), evaluationContextImpl)) {
                handleArrayIndex(i2, str, obj, evaluationContextImpl);
            }
            i2++;
        }
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public String getPathFragment() {
        StringBuilder sbR = a.r("[");
        for (int i2 = 0; i2 < this.predicates.size(); i2++) {
            if (i2 != 0) {
                sbR.append(",");
            }
            sbR.append("?");
        }
        sbR.append("]");
        return sbR.toString();
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public boolean isTokenDefinite() {
        return false;
    }

    public PredicatePathToken(Collection<Predicate> collection) {
        this.predicates = collection;
    }
}
