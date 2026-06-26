package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.be;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bl;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IdTracking.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements aq<c, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bc> f5361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f5362e = -5764118265293965743L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final bu f5363f = new bu("IdTracking");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bk f5364g = new bk("snapshots", bw.f4789k, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bk f5365h = new bk("journals", bw.m, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bk f5366i = new bk("checksum", (byte) 11, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends bx>, by> f5367j;
    public Map<String, com.umeng.commonsdk.statistics.proto.b> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<com.umeng.commonsdk.statistics.proto.a> f5368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5369c;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private e[] f5370k;

    /* JADX INFO: compiled from: IdTracking.java */
    public static class a extends bz<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bp bpVar, c cVar) throws bq {
            bpVar.j();
            while (true) {
                bk bkVarL = bpVar.l();
                byte b2 = bkVarL.f4761b;
                if (b2 == 0) {
                    bpVar.k();
                    cVar.n();
                    return;
                }
                short s = bkVarL.f4762c;
                int i2 = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            bs.a(bpVar, b2);
                        } else if (b2 == 11) {
                            cVar.f5369c = bpVar.z();
                            cVar.c(true);
                        } else {
                            bs.a(bpVar, b2);
                        }
                    } else if (b2 == 15) {
                        bl blVarP = bpVar.p();
                        cVar.f5368b = new ArrayList(blVarP.f4763b);
                        while (i2 < blVarP.f4763b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(bpVar);
                            cVar.f5368b.add(aVar);
                            i2++;
                        }
                        bpVar.q();
                        cVar.b(true);
                    } else {
                        bs.a(bpVar, b2);
                    }
                } else if (b2 == 13) {
                    bm bmVarN = bpVar.n();
                    cVar.a = new HashMap(bmVarN.f4765c * 2);
                    while (i2 < bmVarN.f4765c) {
                        String strZ = bpVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(bpVar);
                        cVar.a.put(strZ, bVar);
                        i2++;
                    }
                    bpVar.o();
                    cVar.a(true);
                } else {
                    bs.a(bpVar, b2);
                }
                bpVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bp bpVar, c cVar) throws bq {
            cVar.n();
            bpVar.a(c.f5363f);
            if (cVar.a != null) {
                bpVar.a(c.f5364g);
                bpVar.a(new bm((byte) 11, (byte) 12, cVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                    bpVar.a(entry.getKey());
                    entry.getValue().write(bpVar);
                }
                bpVar.e();
                bpVar.c();
            }
            if (cVar.f5368b != null && cVar.j()) {
                bpVar.a(c.f5365h);
                bpVar.a(new bl((byte) 12, cVar.f5368b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f5368b.iterator();
                while (it.hasNext()) {
                    it.next().write(bpVar);
                }
                bpVar.f();
                bpVar.c();
            }
            if (cVar.f5369c != null && cVar.m()) {
                bpVar.a(c.f5366i);
                bpVar.a(cVar.f5369c);
                bpVar.c();
            }
            bpVar.d();
            bpVar.b();
        }
    }

    /* JADX INFO: compiled from: IdTracking.java */
    public static class b implements by {
        private b() {
        }

        @Override // com.umeng.analytics.pro.by
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdTracking.java */
    public static class C0137c extends ca<c> {
        private C0137c() {
        }

        @Override // com.umeng.analytics.pro.bx
        public void a(bp bpVar, c cVar) {
            bv bvVar = (bv) bpVar;
            bvVar.a(cVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                bvVar.a(entry.getKey());
                entry.getValue().write(bvVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            bvVar.a(bitSet, 2);
            if (cVar.j()) {
                bvVar.a(cVar.f5368b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f5368b.iterator();
                while (it.hasNext()) {
                    it.next().write(bvVar);
                }
            }
            if (cVar.m()) {
                bvVar.a(cVar.f5369c);
            }
        }

        @Override // com.umeng.analytics.pro.bx
        public void b(bp bpVar, c cVar) {
            bv bvVar = (bv) bpVar;
            bm bmVar = new bm((byte) 11, (byte) 12, bvVar.w());
            cVar.a = new HashMap(bmVar.f4765c * 2);
            for (int i2 = 0; i2 < bmVar.f4765c; i2++) {
                String strZ = bvVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(bvVar);
                cVar.a.put(strZ, bVar);
            }
            cVar.a(true);
            BitSet bitSetB = bvVar.b(2);
            if (bitSetB.get(0)) {
                bl blVar = new bl((byte) 12, bvVar.w());
                cVar.f5368b = new ArrayList(blVar.f4763b);
                for (int i3 = 0; i3 < blVar.f4763b; i3++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(bvVar);
                    cVar.f5368b.add(aVar);
                }
                cVar.b(true);
            }
            if (bitSetB.get(1)) {
                cVar.f5369c = bvVar.z();
                cVar.c(true);
            }
        }
    }

    /* JADX INFO: compiled from: IdTracking.java */
    public static class d implements by {
        private d() {
        }

        @Override // com.umeng.analytics.pro.by
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0137c b() {
            return new C0137c();
        }
    }

    static {
        HashMap map = new HashMap();
        f5367j = map;
        map.put(bz.class, new b());
        map.put(ca.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.SNAPSHOTS, new bc("snapshots", (byte) 1, new bf(bw.f4789k, new bd((byte) 11), new bh((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put(e.JOURNALS, new bc("journals", (byte) 2, new be(bw.m, new bh((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put(e.CHECKSUM, new bc("checksum", (byte) 2, new bd((byte) 11)));
        Map<e, bc> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f5361d = mapUnmodifiableMap;
        bc.a(c.class, mapUnmodifiableMap);
    }

    public c() {
        this.f5370k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.aq
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.aq
    public void clear() {
        this.a = null;
        this.f5368b = null;
        this.f5369c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f5368b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f5368b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f5368b;
    }

    public void i() {
        this.f5368b = null;
    }

    public boolean j() {
        return this.f5368b != null;
    }

    public String k() {
        return this.f5369c;
    }

    public void l() {
        this.f5369c = null;
    }

    public boolean m() {
        return this.f5369c != null;
    }

    public void n() throws bq {
        if (this.a != null) {
            return;
        }
        StringBuilder sbR = c.a.a.a.a.r("Required field 'snapshots' was not present! Struct: ");
        sbR.append(toString());
        throw new bq(sbR.toString());
    }

    @Override // com.umeng.analytics.pro.aq
    public void read(bp bpVar) {
        f5367j.get(bpVar.D()).b().b(bpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f5368b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f5369c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.aq
    public void write(bp bpVar) {
        f5367j.get(bpVar.D()).b().a(bpVar, this);
    }

    /* JADX INFO: compiled from: IdTracking.java */
    public enum e implements ax {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f5373d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f5375e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f5376f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f5373d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f5375e = s;
            this.f5376f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return SNAPSHOTS;
            }
            if (i2 == 2) {
                return JOURNALS;
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
            return this.f5376f;
        }

        public static e a(String str) {
            return f5373d.get(str);
        }

        @Override // com.umeng.analytics.pro.ax
        public short a() {
            return this.f5375e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, bVar);
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f5368b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f5369c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.a = map;
    }

    public c(c cVar) {
        this.f5370k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.a = map;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f5368b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.f5368b = arrayList;
        }
        if (cVar.m()) {
            this.f5369c = cVar.f5369c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f5368b == null) {
            this.f5368b = new ArrayList();
        }
        this.f5368b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f5368b = list;
        return this;
    }

    public c a(String str) {
        this.f5369c = str;
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

    private void a(ObjectInputStream objectInputStream) throws IOException {
        try {
            read(new bj(new cb(objectInputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
