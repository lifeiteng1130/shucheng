package k.a.a.a.m0;

/* JADX INFO: compiled from: ObjectEqualityComparator.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends a<Object> {
    public static final j a = new j();

    @Override // k.a.a.a.m0.a
    public boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // k.a.a.a.m0.a
    public int b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
