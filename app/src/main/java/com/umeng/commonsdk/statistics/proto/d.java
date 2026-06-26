package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bs;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
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

/* JADX INFO: compiled from: Imprint.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements aq<d, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bc> f5377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f5378e = 2846460275012375038L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final bu f5379f = new bu("Imprint");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bk f5380g = new bk("property", bw.f4789k, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bk f5381h = new bk("version", (byte) 8, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bk f5382i = new bk("checksum", (byte) 11, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends bx>, by> f5383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f5384k = 0;
    public Map<String, com.umeng.commonsdk.statistics.proto.e> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5386c;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte f5387l;

    /* JADX INFO: compiled from: Imprint.java */
    public static class a extends bz<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bp bpVar, d dVar) throws bq {
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
                        } else if (b2 == 11) {
                            dVar.f5386c = bpVar.z();
                            dVar.c(true);
                        } else {
                            bs.a(bpVar, b2);
                        }
                    } else if (b2 == 8) {
                        dVar.f5385b = bpVar.w();
                        dVar.b(true);
                    } else {
                        bs.a(bpVar, b2);
                    }
                } else if (b2 == 13) {
                    bm bmVarN = bpVar.n();
                    dVar.a = new HashMap(bmVarN.f4765c * 2);
                    for (int i2 = 0; i2 < bmVarN.f4765c; i2++) {
                        String strZ = bpVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(bpVar);
                        dVar.a.put(strZ, eVar);
                    }
                    bpVar.o();
                    dVar.a(true);
                } else {
                    bs.a(bpVar, b2);
                }
                bpVar.m();
            }
            bpVar.k();
            if (!dVar.h()) {
                StringBuilder sbR = c.a.a.a.a.r("Required field 'version' was not found in serialized data! Struct: ");
                sbR.append(toString());
                throw new bq(sbR.toString());
            }
            dVar.l();
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bp bpVar, d dVar) throws bq {
            dVar.l();
            bpVar.a(d.f5379f);
            if (dVar.a != null) {
                bpVar.a(d.f5380g);
                bpVar.a(new bm((byte) 11, (byte) 12, dVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                    bpVar.a(entry.getKey());
                    entry.getValue().write(bpVar);
                }
                bpVar.e();
                bpVar.c();
            }
            bpVar.a(d.f5381h);
            bpVar.a(dVar.f5385b);
            bpVar.c();
            if (dVar.f5386c != null) {
                bpVar.a(d.f5382i);
                bpVar.a(dVar.f5386c);
                bpVar.c();
            }
            bpVar.d();
            bpVar.b();
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    public static class b implements by {
        private b() {
        }

        @Override // com.umeng.analytics.pro.by
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    public static class c extends ca<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.bx
        public void a(bp bpVar, d dVar) {
            bv bvVar = (bv) bpVar;
            bvVar.a(dVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                bvVar.a(entry.getKey());
                entry.getValue().write(bvVar);
            }
            bvVar.a(dVar.f5385b);
            bvVar.a(dVar.f5386c);
        }

        @Override // com.umeng.analytics.pro.bx
        public void b(bp bpVar, d dVar) {
            bv bvVar = (bv) bpVar;
            bm bmVar = new bm((byte) 11, (byte) 12, bvVar.w());
            dVar.a = new HashMap(bmVar.f4765c * 2);
            for (int i2 = 0; i2 < bmVar.f4765c; i2++) {
                String strZ = bvVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(bvVar);
                dVar.a.put(strZ, eVar);
            }
            dVar.a(true);
            dVar.f5385b = bvVar.w();
            dVar.b(true);
            dVar.f5386c = bvVar.z();
            dVar.c(true);
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Imprint.java */
    public static class C0138d implements by {
        private C0138d() {
        }

        @Override // com.umeng.analytics.pro.by
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap map = new HashMap();
        f5383j = map;
        map.put(bz.class, new b());
        map.put(ca.class, new C0138d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.PROPERTY, new bc("property", (byte) 1, new bf(bw.f4789k, new bd((byte) 11), new bh((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put(e.VERSION, new bc("version", (byte) 1, new bd((byte) 8)));
        enumMap.put(e.CHECKSUM, new bc("checksum", (byte) 1, new bd((byte) 11)));
        Map<e, bc> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f5377d = mapUnmodifiableMap;
        bc.a(d.class, mapUnmodifiableMap);
    }

    public d() {
        this.f5387l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.aq
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.aq
    public void clear() {
        this.a = null;
        b(false);
        this.f5385b = 0;
        this.f5386c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.f5385b;
    }

    public void g() {
        this.f5387l = an.b(this.f5387l, 0);
    }

    public boolean h() {
        return an.a(this.f5387l, 0);
    }

    public String i() {
        return this.f5386c;
    }

    public void j() {
        this.f5386c = null;
    }

    public boolean k() {
        return this.f5386c != null;
    }

    public void l() throws bq {
        if (this.a == null) {
            StringBuilder sbR = c.a.a.a.a.r("Required field 'property' was not present! Struct: ");
            sbR.append(toString());
            throw new bq(sbR.toString());
        }
        if (this.f5386c != null) {
            return;
        }
        StringBuilder sbR2 = c.a.a.a.a.r("Required field 'checksum' was not present! Struct: ");
        sbR2.append(toString());
        throw new bq(sbR2.toString());
    }

    @Override // com.umeng.analytics.pro.aq
    public void read(bp bpVar) {
        f5383j.get(bpVar.D()).b().b(bpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f5385b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f5386c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.aq
    public void write(bp bpVar) {
        f5383j.get(bpVar.D()).b().a(bpVar, this);
    }

    /* JADX INFO: compiled from: Imprint.java */
    public enum e implements ax {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f5390d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f5392e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f5393f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f5390d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f5392e = s;
            this.f5393f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return PROPERTY;
            }
            if (i2 == 2) {
                return VERSION;
            }
            if (i2 != 3) {
                return null;
            }
            return CHECKSUM;
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
            return this.f5393f;
        }

        public static e a(String str) {
            return f5390d.get(str);
        }

        @Override // com.umeng.analytics.pro.ax
        public short a() {
            return this.f5392e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, eVar);
    }

    public void b(boolean z) {
        this.f5387l = an.a(this.f5387l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f5386c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.a = map;
        this.f5385b = i2;
        b(true);
        this.f5386c = str;
    }

    @Override // com.umeng.analytics.pro.aq
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public d a(int i2) {
        this.f5385b = i2;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.f5387l = (byte) 0;
        this.f5387l = dVar.f5387l;
        if (dVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.a = map;
        }
        this.f5385b = dVar.f5385b;
        if (dVar.k()) {
            this.f5386c = dVar.f5386c;
        }
    }

    public d a(String str) {
        this.f5386c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bj(new cb(objectOutputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException {
        try {
            this.f5387l = (byte) 0;
            read(new bj(new cb(objectInputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
