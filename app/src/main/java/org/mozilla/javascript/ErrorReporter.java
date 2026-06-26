package org.mozilla.javascript;

/* JADX INFO: loaded from: classes3.dex */
public interface ErrorReporter {
    void error(String str, String str2, int i2, String str3, int i3);

    EvaluatorException runtimeError(String str, String str2, int i2, String str3, int i3);

    void warning(String str, String str2, int i2, String str3, int i3);
}
