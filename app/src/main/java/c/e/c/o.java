package c.e.c;

/* JADX INFO: compiled from: ReaderException.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class o extends Exception {
    public static final StackTraceElement[] NO_TRACE;
    public static final boolean isStackTrace;

    static {
        isStackTrace = System.getProperty("surefire.test.class.path") != null;
        NO_TRACE = new StackTraceElement[0];
    }

    public o() {
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    public o(Throwable th) {
        super(th);
    }
}
