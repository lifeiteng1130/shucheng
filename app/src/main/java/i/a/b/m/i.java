package i.a.b.m;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: DefaultMapperOrdered.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends k<i.a.b.c> {
    public i(j jVar) {
        super(jVar);
    }

    @Override // i.a.b.m.k
    public void addValue(Object obj, Object obj2) {
        ((i.a.b.a) obj).add(obj2);
    }

    @Override // i.a.b.m.k
    public Object createArray() {
        return new i.a.b.a();
    }

    @Override // i.a.b.m.k
    public Object createObject() {
        return new LinkedHashMap();
    }

    @Override // i.a.b.m.k
    public void setValue(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    @Override // i.a.b.m.k
    public k<i.a.b.c> startArray(String str) {
        return this.base.f6423c;
    }

    @Override // i.a.b.m.k
    public k<i.a.b.c> startObject(String str) {
        return this.base.f6423c;
    }
}
