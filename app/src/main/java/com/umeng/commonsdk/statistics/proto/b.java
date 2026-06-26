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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdSnapshot.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements aq<b, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bc> f5344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f5345e = -6496538196005191531L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final bu f5346f = new bu("IdSnapshot");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bk f5347g = new bk("identity", (byte) 11, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bk f5348h = new bk("ts", (byte) 10, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bk f5349i = new bk("version", (byte) 8, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends bx>, by> f5350j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f5351k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f5352l = 1;
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5354c;
    private byte m;

    /* JADX INFO: compiled from: IdSnapshot.java */
    public static class a extends bz<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bp bpVar, b bVar) throws bq {
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
                            bs.a(bpVar, b2);
                        } else if (b2 == 8) {
                            bVar.f5354c = bpVar.w();
                            bVar.c(true);
                        } else {
                            bs.a(bpVar, b2);
                        }
                    } else if (b2 == 10) {
                        bVar.f5353b = bpVar.x();
                        bVar.b(true);
                    } else {
                        bs.a(bpVar, b2);
                    }
                } else if (b2 == 11) {
                    bVar.a = bpVar.z();
                    bVar.a(true);
                } else {
                    bs.a(bpVar, b2);
                }
                bpVar.m();
            }
            bpVar.k();
            if (!bVar.g()) {
                StringBuilder sbR = c.a.a.a.a.r("Required field 'ts' was not found in serialized data! Struct: ");
                sbR.append(toString());
                throw new bq(sbR.toString());
            }
            if (bVar.j()) {
                bVar.k();
            } else {
                StringBuilder sbR2 = c.a.a.a.a.r("Required field 'version' was not found in serialized data! Struct: ");
                sbR2.append(toString());
                throw new bq(sbR2.toString());
            }
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bp bpVar, b bVar) throws bq {
            bVar.k();
            bpVar.a(b.f5346f);
            if (bVar.a != null) {
                bpVar.a(b.f5347g);
                bpVar.a(bVar.a);
                bpVar.c();
            }
            bpVar.a(b.f5348h);
            bpVar.a(bVar.f5353b);
            bpVar.c();
            bpVar.a(b.f5349i);
            bpVar.a(bVar.f5354c);
            bpVar.c();
            bpVar.d();
            bpVar.b();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdSnapshot.java */
    public static class C0136b implements by {
        private C0136b() {
        }

        @Override // com.umeng.analytics.pro.by
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    public static class c extends ca<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.bx
        public void a(bp bpVar, b bVar) {
            bv bvVar = (bv) bpVar;
            bvVar.a(bVar.a);
            bvVar.a(bVar.f5353b);
            bvVar.a(bVar.f5354c);
        }

        @Override // com.umeng.analytics.pro.bx
        public void b(bp bpVar, b bVar) {
            bv bvVar = (bv) bpVar;
            bVar.a = bvVar.z();
            bVar.a(true);
            bVar.f5353b = bvVar.x();
            bVar.b(true);
            bVar.f5354c = bvVar.w();
            bVar.c(true);
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
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
        f5350j = map;
        map.put(bz.class, new C0136b());
        map.put(ca.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new bc("identity", (byte) 1, new bd((byte) 11)));
        enumMap.put(e.TS, new bc("ts", (byte) 1, new bd((byte) 10)));
        enumMap.put(e.VERSION, new bc("version", (byte) 1, new bd((byte) 8)));
        Map<e, bc> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f5344d = mapUnmodifiableMap;
        bc.a(b.class, mapUnmodifiableMap);
    }

    public b() {
        this.m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.aq
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
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
        b(false);
        this.f5353b = 0L;
        c(false);
        this.f5354c = 0;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.f5353b;
    }

    public void f() {
        this.m = an.b(this.m, 0);
    }

    public boolean g() {
        return an.a(this.m, 0);
    }

    public int h() {
        return this.f5354c;
    }

    public void i() {
        this.m = an.b(this.m, 1);
    }

    public boolean j() {
        return an.a(this.m, 1);
    }

    public void k() throws bq {
        if (this.a != null) {
            return;
        }
        StringBuilder sbR = c.a.a.a.a.r("Required field 'identity' was not present! Struct: ");
        sbR.append(toString());
        throw new bq(sbR.toString());
    }

    @Override // com.umeng.analytics.pro.aq
    public void read(bp bpVar) {
        f5350j.get(bpVar.D()).b().b(bpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f5353b);
        sb.append(", ");
        sb.append("version:");
        return c.a.a.a.a.o(sb, this.f5354c, ")");
    }

    @Override // com.umeng.analytics.pro.aq
    public void write(bp bpVar) {
        f5350j.get(bpVar.D()).b().a(bpVar, this);
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    public enum e implements ax {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f5357d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f5359e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f5360f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f5357d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f5359e = s;
            this.f5360f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return IDENTITY;
            }
            if (i2 == 2) {
                return TS;
            }
            if (i2 != 3) {
                return null;
            }
            return VERSION;
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
            return this.f5360f;
        }

        public static e a(String str) {
            return f5357d.get(str);
        }

        @Override // com.umeng.analytics.pro.ax
        public short a() {
            return this.f5359e;
        }
    }

    public b a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z) {
        this.m = an.a(this.m, 0, z);
    }

    public void c(boolean z) {
        this.m = an.a(this.m, 1, z);
    }

    public b(String str, long j2, int i2) {
        this();
        this.a = str;
        this.f5353b = j2;
        b(true);
        this.f5354c = i2;
        c(true);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.aq
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public b a(long j2) {
        this.f5353b = j2;
        b(true);
        return this;
    }

    public b a(int i2) {
        this.f5354c = i2;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bj(new cb(objectOutputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.a = bVar.a;
        }
        this.f5353b = bVar.f5353b;
        this.f5354c = bVar.f5354c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException {
        try {
            this.m = (byte) 0;
            read(new bj(new cb(objectInputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
