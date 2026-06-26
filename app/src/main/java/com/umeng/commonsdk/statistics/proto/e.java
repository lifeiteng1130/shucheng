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
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: ImprintValue.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements aq<e, EnumC0139e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<EnumC0139e, bc> f5394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f5395e = 7501688097813630241L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final bu f5396f = new bu("ImprintValue");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final bk f5397g = new bk(ES6Iterator.VALUE_PROPERTY, (byte) 11, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bk f5398h = new bk("ts", (byte) 10, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final bk f5399i = new bk("guid", (byte) 11, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Class<? extends bx>, by> f5400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f5401k = 0;
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5403c;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte f5404l;
    private EnumC0139e[] m;

    /* JADX INFO: compiled from: ImprintValue.java */
    public static class a extends bz<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bp bpVar, e eVar) throws bq {
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
                            eVar.f5403c = bpVar.z();
                            eVar.c(true);
                        } else {
                            bs.a(bpVar, b2);
                        }
                    } else if (b2 == 10) {
                        eVar.f5402b = bpVar.x();
                        eVar.b(true);
                    } else {
                        bs.a(bpVar, b2);
                    }
                } else if (b2 == 11) {
                    eVar.a = bpVar.z();
                    eVar.a(true);
                } else {
                    bs.a(bpVar, b2);
                }
                bpVar.m();
            }
            bpVar.k();
            if (eVar.g()) {
                eVar.k();
            } else {
                StringBuilder sbR = c.a.a.a.a.r("Required field 'ts' was not found in serialized data! Struct: ");
                sbR.append(toString());
                throw new bq(sbR.toString());
            }
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bp bpVar, e eVar) throws bq {
            eVar.k();
            bpVar.a(e.f5396f);
            if (eVar.a != null && eVar.d()) {
                bpVar.a(e.f5397g);
                bpVar.a(eVar.a);
                bpVar.c();
            }
            bpVar.a(e.f5398h);
            bpVar.a(eVar.f5402b);
            bpVar.c();
            if (eVar.f5403c != null) {
                bpVar.a(e.f5399i);
                bpVar.a(eVar.f5403c);
                bpVar.c();
            }
            bpVar.d();
            bpVar.b();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    public static class b implements by {
        private b() {
        }

        @Override // com.umeng.analytics.pro.by
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    public static class c extends ca<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.bx
        public void a(bp bpVar, e eVar) {
            bv bvVar = (bv) bpVar;
            bvVar.a(eVar.f5402b);
            bvVar.a(eVar.f5403c);
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            bvVar.a(bitSet, 1);
            if (eVar.d()) {
                bvVar.a(eVar.a);
            }
        }

        @Override // com.umeng.analytics.pro.bx
        public void b(bp bpVar, e eVar) {
            bv bvVar = (bv) bpVar;
            eVar.f5402b = bvVar.x();
            eVar.b(true);
            eVar.f5403c = bvVar.z();
            eVar.c(true);
            if (bvVar.b(1).get(0)) {
                eVar.a = bvVar.z();
                eVar.a(true);
            }
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
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
        f5400j = map;
        map.put(bz.class, new b());
        map.put(ca.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0139e.class);
        enumMap.put(EnumC0139e.VALUE, new bc(ES6Iterator.VALUE_PROPERTY, (byte) 2, new bd((byte) 11)));
        enumMap.put(EnumC0139e.TS, new bc("ts", (byte) 1, new bd((byte) 10)));
        enumMap.put(EnumC0139e.GUID, new bc("guid", (byte) 1, new bd((byte) 11)));
        Map<EnumC0139e, bc> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f5394d = mapUnmodifiableMap;
        bc.a(e.class, mapUnmodifiableMap);
    }

    public e() {
        this.f5404l = (byte) 0;
        this.m = new EnumC0139e[]{EnumC0139e.VALUE};
    }

    @Override // com.umeng.analytics.pro.aq
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
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
        this.f5402b = 0L;
        this.f5403c = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.f5402b;
    }

    public void f() {
        this.f5404l = an.b(this.f5404l, 0);
    }

    public boolean g() {
        return an.a(this.f5404l, 0);
    }

    public String h() {
        return this.f5403c;
    }

    public void i() {
        this.f5403c = null;
    }

    public boolean j() {
        return this.f5403c != null;
    }

    public void k() throws bq {
        if (this.f5403c != null) {
            return;
        }
        StringBuilder sbR = c.a.a.a.a.r("Required field 'guid' was not present! Struct: ");
        sbR.append(toString());
        throw new bq(sbR.toString());
    }

    @Override // com.umeng.analytics.pro.aq
    public void read(bp bpVar) {
        f5400j.get(bpVar.D()).b().b(bpVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f5402b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f5403c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.aq
    public void write(bp bpVar) {
        f5400j.get(bpVar.D()).b().a(bpVar, this);
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImprintValue.java */
    public enum EnumC0139e implements ax {
        VALUE(1, ES6Iterator.VALUE_PROPERTY),
        TS(2, "ts"),
        GUID(3, "guid");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, EnumC0139e> f5407d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f5409e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f5410f;

        static {
            for (EnumC0139e enumC0139e : EnumSet.allOf(EnumC0139e.class)) {
                f5407d.put(enumC0139e.b(), enumC0139e);
            }
        }

        EnumC0139e(short s, String str) {
            this.f5409e = s;
            this.f5410f = str;
        }

        public static EnumC0139e a(int i2) {
            if (i2 == 1) {
                return VALUE;
            }
            if (i2 == 2) {
                return TS;
            }
            if (i2 != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0139e b(int i2) {
            EnumC0139e enumC0139eA = a(i2);
            if (enumC0139eA != null) {
                return enumC0139eA;
            }
            throw new IllegalArgumentException(c.a.a.a.a.d("Field ", i2, " doesn't exist!"));
        }

        @Override // com.umeng.analytics.pro.ax
        public String b() {
            return this.f5410f;
        }

        public static EnumC0139e a(String str) {
            return f5407d.get(str);
        }

        @Override // com.umeng.analytics.pro.ax
        public short a() {
            return this.f5409e;
        }
    }

    public e a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z) {
        this.f5404l = an.a(this.f5404l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f5403c = null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public e b(String str) {
        this.f5403c = str;
        return this;
    }

    public e(long j2, String str) {
        this();
        this.f5402b = j2;
        b(true);
        this.f5403c = str;
    }

    public e a(long j2) {
        this.f5402b = j2;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.aq
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0139e fieldForId(int i2) {
        return EnumC0139e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bj(new cb(objectOutputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public e(e eVar) {
        this.f5404l = (byte) 0;
        this.m = new EnumC0139e[]{EnumC0139e.VALUE};
        this.f5404l = eVar.f5404l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.f5402b = eVar.f5402b;
        if (eVar.j()) {
            this.f5403c = eVar.f5403c;
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException {
        try {
            this.f5404l = (byte) 0;
            read(new bj(new cb(objectInputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
