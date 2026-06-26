package org.mozilla.javascript;

/* JADX INFO: loaded from: classes3.dex */
public class WrappedException extends EvaluatorException {
    private static final long serialVersionUID = -1551979216966520648L;
    private Throwable exception;

    public WrappedException(Throwable th) {
        super("Wrapped " + th);
        this.exception = th;
        initCause(th);
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        int i2 = iArr[0];
        if (sourcePositionFromStack != null) {
            initSourceName(sourcePositionFromStack);
        }
        if (i2 != 0) {
            initLineNumber(i2);
        }
    }

    public Throwable getWrappedException() {
        return this.exception;
    }

    @Deprecated
    public Object unwrap() {
        return getWrappedException();
    }
}
