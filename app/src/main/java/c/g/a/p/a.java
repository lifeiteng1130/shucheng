package c.g.a.p;

/* JADX INFO: compiled from: LogUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
        String className = stackTraceElement.getClassName();
        return c.a.a.a.a.k("ZXingLite", "|", String.format("%s.%s(L:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
    }
}
