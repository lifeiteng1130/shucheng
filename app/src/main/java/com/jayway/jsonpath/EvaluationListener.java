package com.jayway.jsonpath;

/* JADX INFO: loaded from: classes.dex */
public interface EvaluationListener {

    public enum EvaluationContinuation {
        CONTINUE,
        ABORT
    }

    public interface FoundResult {
        int index();

        String path();

        Object result();
    }

    EvaluationContinuation resultFound(FoundResult foundResult);
}
