package com.jayway.jsonpath;

/* JADX INFO: loaded from: classes.dex */
public class PathNotFoundException extends InvalidPathException {
    public PathNotFoundException() {
    }

    public PathNotFoundException(String str) {
        super(str);
    }

    public PathNotFoundException(String str, Throwable th) {
        super(str, th);
    }

    public PathNotFoundException(Throwable th) {
        super(th);
    }
}
