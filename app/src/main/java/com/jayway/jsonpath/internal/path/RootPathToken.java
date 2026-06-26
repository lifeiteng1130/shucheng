package com.jayway.jsonpath.internal.path;

import com.jayway.jsonpath.internal.PathRef;

/* JADX INFO: loaded from: classes.dex */
public class RootPathToken extends PathToken {
    private final String rootToken;
    private PathToken tail = this;
    private int tokenCount = 1;

    public RootPathToken(char c2) {
        this.rootToken = Character.toString(c2);
    }

    public RootPathToken append(PathToken pathToken) {
        this.tail = this.tail.appendTailToken(pathToken);
        this.tokenCount++;
        return this;
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public void evaluate(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        if (!isLeaf()) {
            next().evaluate(this.rootToken, pathRef, obj, evaluationContextImpl);
            return;
        }
        if (!evaluationContextImpl.forUpdate()) {
            pathRef = PathRef.NO_OP;
        }
        evaluationContextImpl.addResult(this.rootToken, pathRef, obj);
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public String getPathFragment() {
        return this.rootToken;
    }

    public PathTokenAppender getPathTokenAppender() {
        return new PathTokenAppender() { // from class: com.jayway.jsonpath.internal.path.RootPathToken.1
            @Override // com.jayway.jsonpath.internal.path.PathTokenAppender
            public PathTokenAppender appendPathToken(PathToken pathToken) {
                RootPathToken.this.append(pathToken);
                return this;
            }
        };
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public int getTokenCount() {
        return this.tokenCount;
    }

    public boolean isFunctionPath() {
        return this.tail instanceof FunctionPathToken;
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public boolean isTokenDefinite() {
        return true;
    }

    public void setTail(PathToken pathToken) {
        this.tail = pathToken;
    }
}
