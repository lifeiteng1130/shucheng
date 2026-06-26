package javax.script;

/* JADX INFO: loaded from: classes3.dex */
public interface Invocable {
    <T> T getInterface(Class<T> cls);

    <T> T getInterface(Object obj, Class<T> cls);

    Object invokeFunction(String str, Object... objArr);

    Object invokeMethod(Object obj, String str, Object... objArr);
}
