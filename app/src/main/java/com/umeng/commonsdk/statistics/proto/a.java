package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bs;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cb;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdJournal.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements aq<a, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<e, bc> f5326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f5327f = 9132678615281394583L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bu f5328g = new bu("IdJournal");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bk f5329h = new bk("domain", (byte) 11, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bk f5330i = new bk("old_id", (byte) 11, 2);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final bk f5331j = new bk("new_id", (byte) 11, 3);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final bk f5332k = new bk("ts", (byte) 10, 4);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map<Class<? extends bx>, by> f5333l;
    private static final int m = 0;
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5336d;
    private byte n;
    private e[] o;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdJournal.java */
    public static class C0135a extends bz<a> {
        private C0135a() {
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bp bpVar, a aVar) throws bq {
            bpVar.j();
            while (true) {
                bk bkVarL = bpVar.l();
                byte b2 = bkVarL.f4761b;
                if (b2 == 0) {
                    break;
                }
                short s = bkVarL.f4762c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            if (s != 4) {
                                bs.a(bpVar, b2);
                            } else if (b2 == 10) {
                                aVar.f5336d = bpVar.x();
                                aVar.d(true);
                            } else {
                                bs.a(bpVar, b2);
                            }
                        } else if (b2 == 11) {
                            aVar.f5335c = bpVar.z();
                            aVar.c(true);
                        } else {
                            bs.a(bpVar, b2);
                        }
                    } else if (b2 == 11) {
                        aVar.f5334b = bpVar.z();
                        aVar.b(true);
                    } else {
                        bs.a(bpVar, b2);
                    }
                } else if (b2 == 11) {
                    aVar.a = bpVar.z();
                    aVar.a(true);
                } else {
                    bs.a(bpVar, b2);
                }
                bpVar.m();
            }
            bpVar.k();
            if (aVar.m()) {
                aVar.n();
            } else {
                StringBuilder sbR = c.a.a.a.a.r("Required field 'ts' was not found in serialized data! Struct: ");
                sbR.append(toString());
                throw new bq(sbR.toString());
            }
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bp bpVar, a aVar) throws bq {
            aVar.n();
            bpVar.a(a.f5328g);
            if (aVar.a != null) {
                bpVar.a(a.f5329h);
                bpVar.a(aVar.a);
                bpVar.c();
            }
            if (aVar.f5334b != null && aVar.g()) {
                bpVar.a(a.f5330i);
                bpVar.a(aVar.f5334b);
                bpVar.c();
            }
            if (aVar.f5335c != null) {
                bpVar.a(a.f5331j);
                bpVar.a(aVar.f5335c);
                bpVar.c();
            }
            bpVar.a(a.f5332k);
            bpVar.a(aVar.f5336d);
            bpVar.c();
            bpVar.d();
            bpVar.b();
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    public static class b implements by {
        private b() {
        }

        @Override // com.umeng.analytics.pro.by
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0135a b() {
            return new C0135a();
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    public static class c extends ca<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.bx
        public void a(bp bpVar, a aVar) {
            bv bvVar = (bv) bpVar;
            bvVar.a(aVar.a);
            bvVar.a(aVar.f5335c);
            bvVar.a(aVar.f5336d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            bvVar.a(bitSet, 1);
            if (aVar.g()) {
                bvVar.a(aVar.f5334b);
            }
        }

        @Override // com.umeng.analytics.pro.bx
        public void b(bp bpVar, a aVar) {
            bv bvVar = (bv) bpVar;
            aVar.a = bvVar.z();
            aVar.a(true);
            aVar.f5335c = bvVar.z();
            aVar.c(true);
            aVar.f5336d = bvVar.x();
            aVar.d(true);
            if (bvVar.b(1).get(0)) {
                aVar.f5334b = bvVar.z();
                aVar.b(true);
            }
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
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
        f5333l = map;
        map.put(bz.class, new b());
        map.put(ca.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.DOMAIN, new bc("domain", (byte) 1, new bd((byte) 11)));
        enumMap.put(e.OLD_ID, new bc("old_id", (byte) 2, new bd((byte) 11)));
        enumMap.put(e.NEW_ID, new bc("new_id", (byte) 1, new bd((byte) 11)));
        enumMap.put(e.TS, new bc("ts", (byte) 1, new bd((byte) 10)));
        Map<e, bc> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f5326e = mapUnmodifiableMap;
        bc.a(a.class, mapUnmodifiableMap);
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.aq
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.a;
    }

    public void c() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.aq
    public void clear() {
        this.a = null;
        this.f5334b = null;
        this.f5335c = null;
        d(false);
        this.f5336d = 0L;
    }

    public boolean d() {
        return this.a != null;
    }

    public String e() {
        return this.f5334b;
    }

    public void f() {
        this.f5334b = null;
    }

    public boolean g() {
        return this.f5334b != null;
    }

    public String h() {
        return this.f5335c;
    }

    public void i() {
        this.f5335c = null;
    }

    public boolean j() {
        return this.f5335c != null;
    }

    public long k() {
        return this.f5336d;
    }

    public void l() {
        this.n = an.b(this.n, 0);
    }

    public boolean m() {
        return an.a(this.n, 0);
    }

    public void n() throws bq {
        if (this.a == null) {
            StringBuilder sbR = c.a.a.a.a.r("Required field 'domain' was not present! Struct: ");
            sbR.append(toString());
            throw new bq(sbR.toString());
        }
        if (this.f5335c != null) {
            return;
        }
        StringBuilder sbR2 = c.a.a.a.a.r("Required field 'new_id' was not present! Struct: ");
        sbR2.append(toString());
        throw new bq(sbR2.toString());
    }

    @Override // com.umeng.analytics.pro.aq
    public void read(bp bpVar) {
        f5333l.get(bpVar.D()).b().b(bpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f5334b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f5335c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f5336d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.aq
    public void write(bp bpVar) {
        f5333l.get(bpVar.D()).b().a(bpVar, this);
    }

    /* JADX INFO: compiled from: IdJournal.java */
    public enum e implements ax {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Map<String, e> f5340e = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final short f5342f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f5343g;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f5340e.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f5342f = s;
            this.f5343g = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return DOMAIN;
            }
            if (i2 == 2) {
                return OLD_ID;
            }
            if (i2 == 3) {
                return NEW_ID;
            }
            if (i2 != 4) {
                return null;
            }
            return TS;
        }

        public static e b(int i2) {
            e eVarA = a(i2);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException(c.a.a.a.a.d("Field ", i2, " doesn't exist!"));
        }

        @Override // com.umeng.analytics.pro.ax
        public String b() {
            return this.f5343g;
        }

        public static e a(String str) {
            return f5340e.get(str);
        }

        @Override // com.umeng.analytics.pro.ax
        public short a() {
            return this.f5342f;
        }
    }

    public a a(String str) {
        this.a = str;
        return this;
    }

    public a b(String str) {
        this.f5334b = str;
        return this;
    }

    public a c(String str) {
        this.f5335c = str;
        return this;
    }

    public void d(boolean z) {
        this.n = an.a(this.n, 0, z);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f5334b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f5335c = null;
    }

    public a(String str, String str2, long j2) {
        this();
        this.a = str;
        this.f5335c = str2;
        this.f5336d = j2;
        d(true);
    }

    public a a(long j2) {
        this.f5336d = j2;
        d(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.aq
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bj(new cb(objectOutputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.a = aVar.a;
        }
        if (aVar.g()) {
            this.f5334b = aVar.f5334b;
        }
        if (aVar.j()) {
            this.f5335c = aVar.f5335c;
        }
        this.f5336d = aVar.f5336d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException {
        try {
            this.n = (byte) 0;
            read(new bj(new cb(objectInputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
