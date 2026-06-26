package i.a.b.m;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DefaultMapperCollection.java */
/* JADX INFO: loaded from: classes3.dex */
public class h<T> extends k<T> {
    public Class<T> a;

    public h(j jVar, Class<T> cls) {
        super(jVar);
        this.a = cls;
    }

    @Override // i.a.b.m.k
    public void addValue(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }

    @Override // i.a.b.m.k
    public Object createArray() {
        try {
            return this.a.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // i.a.b.m.k
    public Object createObject() {
        try {
            return this.a.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // i.a.b.m.k
    public void setValue(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    @Override // i.a.b.m.k
    public k<T> startArray(String str) {
        return this;
    }

    @Override // i.a.b.m.k
    public k<T> startObject(String str) {
        return this;
    }
}
