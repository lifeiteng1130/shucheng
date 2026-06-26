package com.jayway.jsonpath.internal.path;

import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.spi.json.JsonProvider;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ScanPathToken extends PathToken {
    private static final Predicate FALSE_PREDICATE = new Predicate() { // from class: com.jayway.jsonpath.internal.path.ScanPathToken.1
        @Override // com.jayway.jsonpath.internal.path.ScanPathToken.Predicate
        public boolean matches(Object obj) {
            return false;
        }
    };

    public static final class ArrayPathTokenPredicate implements Predicate {
        private final EvaluationContextImpl ctx;

        @Override // com.jayway.jsonpath.internal.path.ScanPathToken.Predicate
        public boolean matches(Object obj) {
            return this.ctx.jsonProvider().isArray(obj);
        }

        private ArrayPathTokenPredicate(EvaluationContextImpl evaluationContextImpl) {
            this.ctx = evaluationContextImpl;
        }
    }

    public static final class FilterPathTokenPredicate implements Predicate {
        private final EvaluationContextImpl ctx;
        private PredicatePathToken predicatePathToken;

        @Override // com.jayway.jsonpath.internal.path.ScanPathToken.Predicate
        public boolean matches(Object obj) {
            return this.predicatePathToken.accept(obj, this.ctx.rootDocument(), this.ctx.configuration(), this.ctx);
        }

        private FilterPathTokenPredicate(PathToken pathToken, EvaluationContextImpl evaluationContextImpl) {
            this.ctx = evaluationContextImpl;
            this.predicatePathToken = (PredicatePathToken) pathToken;
        }
    }

    public interface Predicate {
        boolean matches(Object obj);
    }

    public static final class PropertyPathTokenPredicate implements Predicate {
        private final EvaluationContextImpl ctx;
        private PropertyPathToken propertyPathToken;

        @Override // com.jayway.jsonpath.internal.path.ScanPathToken.Predicate
        public boolean matches(Object obj) {
            if (!this.ctx.jsonProvider().isMap(obj)) {
                return false;
            }
            if (!this.propertyPathToken.isTokenDefinite()) {
                return true;
            }
            if (this.propertyPathToken.isLeaf() && this.ctx.options().contains(Option.DEFAULT_PATH_LEAF_TO_NULL)) {
                return true;
            }
            return this.ctx.jsonProvider().getPropertyKeys(obj).containsAll(this.propertyPathToken.getProperties());
        }

        private PropertyPathTokenPredicate(PathToken pathToken, EvaluationContextImpl evaluationContextImpl) {
            this.ctx = evaluationContextImpl;
            this.propertyPathToken = (PropertyPathToken) pathToken;
        }
    }

    public static final class WildcardPathTokenPredicate implements Predicate {
        private WildcardPathTokenPredicate() {
        }

        @Override // com.jayway.jsonpath.internal.path.ScanPathToken.Predicate
        public boolean matches(Object obj) {
            return true;
        }
    }

    private static Predicate createScanPredicate(PathToken pathToken, EvaluationContextImpl evaluationContextImpl) {
        return pathToken instanceof PropertyPathToken ? new PropertyPathTokenPredicate(pathToken, evaluationContextImpl) : pathToken instanceof ArrayPathToken ? new ArrayPathTokenPredicate(evaluationContextImpl) : pathToken instanceof WildcardPathToken ? new WildcardPathTokenPredicate() : pathToken instanceof PredicatePathToken ? new FilterPathTokenPredicate(pathToken, evaluationContextImpl) : FALSE_PREDICATE;
    }

    public static void walk(PathToken pathToken, String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl, Predicate predicate) {
        if (evaluationContextImpl.jsonProvider().isMap(obj)) {
            walkObject(pathToken, str, pathRef, obj, evaluationContextImpl, predicate);
        } else if (evaluationContextImpl.jsonProvider().isArray(obj)) {
            walkArray(pathToken, str, pathRef, obj, evaluationContextImpl, predicate);
        }
    }

    public static void walkArray(PathToken pathToken, String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl, Predicate predicate) {
        int i2 = 0;
        if (predicate.matches(obj)) {
            if (pathToken.isLeaf()) {
                pathToken.evaluate(str, pathRef, obj, evaluationContextImpl);
            } else {
                PathToken next = pathToken.next();
                Iterator<?> it = evaluationContextImpl.jsonProvider().toIterable(obj).iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    next.evaluate(str + "[" + i3 + "]", pathRef, it.next(), evaluationContextImpl);
                    i3++;
                }
            }
        }
        Iterator<?> it2 = evaluationContextImpl.jsonProvider().toIterable(obj).iterator();
        while (it2.hasNext()) {
            walk(pathToken, str + "[" + i2 + "]", PathRef.create(obj, i2), it2.next(), evaluationContextImpl, predicate);
            i2++;
        }
    }

    public static void walkObject(PathToken pathToken, String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl, Predicate predicate) {
        if (predicate.matches(obj)) {
            pathToken.evaluate(str, pathRef, obj, evaluationContextImpl);
        }
        for (String str2 : evaluationContextImpl.jsonProvider().getPropertyKeys(obj)) {
            String str3 = str + "['" + str2 + "']";
            Object mapValue = evaluationContextImpl.jsonProvider().getMapValue(obj, str2);
            if (mapValue != JsonProvider.UNDEFINED) {
                walk(pathToken, str3, PathRef.create(obj, str2), mapValue, evaluationContextImpl, predicate);
            }
        }
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public void evaluate(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        PathToken next = next();
        walk(next, str, pathRef, obj, evaluationContextImpl, createScanPredicate(next, evaluationContextImpl));
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public String getPathFragment() {
        return "..";
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public boolean isTokenDefinite() {
        return false;
    }
}
