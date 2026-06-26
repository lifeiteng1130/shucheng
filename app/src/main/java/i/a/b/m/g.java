package i.a.b.m;

/* JADX INFO: compiled from: DefaultMapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class g<T> extends k<T> {
    public g(j jVar) {
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
        return new i.a.b.d();
    }

    @Override // i.a.b.m.k
    public void setValue(Object obj, String str, Object obj2) {
        ((i.a.b.d) obj).put(str, obj2);
    }

    @Override // i.a.b.m.k
    public k<i.a.b.c> startArray(String str) {
        return this.base.f6422b;
    }

    @Override // i.a.b.m.k
    public k<i.a.b.c> startObject(String str) {
        return this.base.f6422b;
    }
}
