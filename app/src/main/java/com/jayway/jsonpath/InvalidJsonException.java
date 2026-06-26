package com.jayway.jsonpath;

/* JADX INFO: loaded from: classes.dex */
public class InvalidJsonException extends JsonPathException {
    private final String json;

    public InvalidJsonException() {
        this.json = null;
    }

    public String getJson() {
        return this.json;
    }

    public InvalidJsonException(String str) {
        super(str);
        this.json = null;
    }

    public InvalidJsonException(String str, Throwable th) {
        super(str, th);
        this.json = null;
    }

    public InvalidJsonException(Throwable th) {
        super(th);
        this.json = null;
    }

    public InvalidJsonException(Throwable th, String str) {
        super(th);
        this.json = str;
    }
}
