package com.jayway.jsonpath.internal.path;

import com.jayway.jsonpath.internal.PathRef;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ArrayIndexToken extends ArrayPathToken {
    private final ArrayIndexOperation arrayIndexOperation;

    public ArrayIndexToken(ArrayIndexOperation arrayIndexOperation) {
        this.arrayIndexOperation = arrayIndexOperation;
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public void evaluate(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        if (checkArrayModel(str, obj, evaluationContextImpl)) {
            if (this.arrayIndexOperation.isSingleIndexOperation()) {
                handleArrayIndex(this.arrayIndexOperation.indexes().get(0).intValue(), str, obj, evaluationContextImpl);
                return;
            }
            Iterator<Integer> it = this.arrayIndexOperation.indexes().iterator();
            while (it.hasNext()) {
                handleArrayIndex(it.next().intValue(), str, obj, evaluationContextImpl);
            }
        }
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public String getPathFragment() {
        return this.arrayIndexOperation.toString();
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public boolean isTokenDefinite() {
        return this.arrayIndexOperation.isSingleIndexOperation();
    }
}
