package i.a.b.m;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: JsonReaderI.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k<T> {
    private static String ERR_MSG = "Invalid or non Implemented status";
    public final j base;

    public k(j jVar) {
        this.base = jVar;
    }

    public void addValue(Object obj, Object obj2) {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " addValue(Object current, Object value) in " + getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T convert(Object obj) {
        return obj;
    }

    public Object createArray() {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " createArray() in " + getClass());
    }

    public Object createObject() {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " createObject() in " + getClass());
    }

    public Type getType(String str) {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " getType(String key) in " + getClass() + " key=" + str);
    }

    public Object getValue(Object obj, String str) {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " getValue(Object current, String key) in " + getClass() + " key=" + str);
    }

    public void setValue(Object obj, String str, Object obj2) {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " setValue in " + getClass() + " key=" + str);
    }

    public k<?> startArray(String str) {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " startArray in " + getClass() + " key=" + str);
    }

    public k<?> startObject(String str) {
        throw new RuntimeException(String.valueOf(ERR_MSG) + " startObject(String key) in " + getClass() + " key=" + str);
    }
}
