package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.ba;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: TUnion.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ba<T extends ba<?, ?>, F extends ax> implements aq<T, F> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends bx>, by> f4719c;
    public Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public F f4720b;

    /* JADX INFO: compiled from: TUnion.java */
    public static class a extends bz<ba> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bp bpVar, ba baVar) {
            baVar.f4720b = null;
            baVar.a = null;
            bpVar.j();
            bk bkVarL = bpVar.l();
            Object objA = baVar.a(bpVar, bkVarL);
            baVar.a = objA;
            if (objA != null) {
                baVar.f4720b = (F) baVar.a(bkVarL.f4762c);
            }
            bpVar.m();
            bpVar.l();
            bpVar.k();
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bp bpVar, ba baVar) throws bq {
            if (baVar.a() == null || baVar.b() == null) {
                throw new bq("Cannot write a TUnion with no set value!");
            }
            bpVar.a(baVar.d());
            bpVar.a(baVar.c(baVar.f4720b));
            baVar.a(bpVar);
            bpVar.c();
            bpVar.d();
            bpVar.b();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    public static class b implements by {
        private b() {
        }

        @Override // com.umeng.analytics.pro.by
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    public static class c extends ca<ba> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bp bpVar, ba baVar) {
            baVar.f4720b = null;
            baVar.a = null;
            short sV = bpVar.v();
            Object objA = baVar.a(bpVar, sV);
            baVar.a = objA;
            if (objA != null) {
                baVar.f4720b = (F) baVar.a(sV);
            }
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bp bpVar, ba baVar) throws bq {
            if (baVar.a() == null || baVar.b() == null) {
                throw new bq("Cannot write a TUnion with no set value!");
            }
            bpVar.a(baVar.f4720b.a());
            baVar.b(bpVar);
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    public static class d implements by {
        private d() {
        }

        @Override // com.umeng.analytics.pro.by
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap map = new HashMap();
        f4719c = map;
        map.put(bz.class, new b());
        map.put(ca.class, new d());
    }

    public ba() {
        this.f4720b = null;
        this.a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof aq ? ((aq) obj).deepCopy() : obj instanceof ByteBuffer ? ar.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    public abstract F a(short s);

    public abstract Object a(bp bpVar, bk bkVar);

    public abstract Object a(bp bpVar, short s);

    public abstract void a(bp bpVar);

    public Object b() {
        return this.a;
    }

    public abstract void b(F f2, Object obj);

    public abstract void b(bp bpVar);

    public abstract bk c(F f2);

    public boolean c() {
        return this.f4720b != null;
    }

    @Override // com.umeng.analytics.pro.aq
    public final void clear() {
        this.f4720b = null;
        this.a = null;
    }

    public abstract bu d();

    @Override // com.umeng.analytics.pro.aq
    public void read(bp bpVar) {
        f4719c.get(bpVar.D()).b().b(bpVar, this);
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("<");
        sbR.append(getClass().getSimpleName());
        sbR.append(" ");
        if (a() != null) {
            Object objB = b();
            sbR.append(c(a()).a);
            sbR.append(":");
            if (objB instanceof ByteBuffer) {
                ar.a((ByteBuffer) objB, sbR);
            } else {
                sbR.append(objB.toString());
            }
        }
        sbR.append(">");
        return sbR.toString();
    }

    @Override // com.umeng.analytics.pro.aq
    public void write(bp bpVar) {
        f4719c.get(bpVar.D()).b().a(bpVar, this);
    }

    public boolean b(F f2) {
        return this.f4720b == f2;
    }

    public boolean b(int i2) {
        return b(a((short) i2));
    }

    public ba(F f2, Object obj) {
        a(f2, obj);
    }

    public ba(ba<T, F> baVar) {
        if (baVar.getClass().equals(getClass())) {
            this.f4720b = baVar.f4720b;
            this.a = a(baVar.a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            map2.put(a(entry.getKey()), a(entry.getValue()));
        }
        return map2;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.f4720b;
    }

    public Object a(F f2) {
        if (f2 == this.f4720b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f2 + " because union's set field is " + this.f4720b);
    }

    public Object a(int i2) {
        return a(a((short) i2));
    }

    public void a(F f2, Object obj) {
        b(f2, obj);
        this.f4720b = f2;
        this.a = obj;
    }

    public void a(int i2, Object obj) {
        a(a((short) i2), obj);
    }
}
