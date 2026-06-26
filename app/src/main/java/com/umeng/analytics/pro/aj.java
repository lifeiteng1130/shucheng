package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: UMEnvelope.java */
/* JADX INFO: loaded from: classes.dex */
public class aj implements aq<aj, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<e, bc> f4659k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f4660l = 420342210744516016L;
    private static final bu m = new bu("UMEnvelope");
    private static final bk n = new bk("version", (byte) 11, 1);
    private static final bk o = new bk("address", (byte) 11, 2);
    private static final bk p = new bk("signature", (byte) 11, 3);
    private static final bk q = new bk("serial_num", (byte) 8, 4);
    private static final bk r = new bk("ts_secs", (byte) 8, 5);
    private static final bk s = new bk("length", (byte) 8, 6);
    private static final bk t = new bk("entity", (byte) 11, 7);
    private static final bk u = new bk("guid", (byte) 11, 8);
    private static final bk v = new bk("checksum", (byte) 11, 9);
    private static final bk w = new bk("codex", (byte) 8, 10);
    private static final Map<Class<? extends bx>, by> x;
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f4666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4669j;

    /* JADX INFO: compiled from: UMEnvelope.java */
    public static class a extends bz<aj> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bp bpVar, aj ajVar) throws bq {
            bpVar.j();
            while (true) {
                bk bkVarL = bpVar.l();
                byte b2 = bkVarL.f4761b;
                if (b2 == 0) {
                    bpVar.k();
                    if (!ajVar.m()) {
                        StringBuilder sbR = c.a.a.a.a.r("Required field 'serial_num' was not found in serialized data! Struct: ");
                        sbR.append(toString());
                        throw new bq(sbR.toString());
                    }
                    if (!ajVar.p()) {
                        StringBuilder sbR2 = c.a.a.a.a.r("Required field 'ts_secs' was not found in serialized data! Struct: ");
                        sbR2.append(toString());
                        throw new bq(sbR2.toString());
                    }
                    if (ajVar.s()) {
                        ajVar.G();
                        return;
                    } else {
                        StringBuilder sbR3 = c.a.a.a.a.r("Required field 'length' was not found in serialized data! Struct: ");
                        sbR3.append(toString());
                        throw new bq(sbR3.toString());
                    }
                }
                switch (bkVarL.f4762c) {
                    case 1:
                        if (b2 != 11) {
                            bs.a(bpVar, b2);
                        } else {
                            ajVar.a = bpVar.z();
                            ajVar.a(true);
                        }
                        break;
                    case 2:
                        if (b2 != 11) {
                            bs.a(bpVar, b2);
                        } else {
                            ajVar.f4661b = bpVar.z();
                            ajVar.b(true);
                        }
                        break;
                    case 3:
                        if (b2 != 11) {
                            bs.a(bpVar, b2);
                        } else {
                            ajVar.f4662c = bpVar.z();
                            ajVar.c(true);
                        }
                        break;
                    case 4:
                        if (b2 != 8) {
                            bs.a(bpVar, b2);
                        } else {
                            ajVar.f4663d = bpVar.w();
                            ajVar.d(true);
                        }
                        break;
                    case 5:
                        if (b2 != 8) {
                            bs.a(bpVar, b2);
                        } else {
                            ajVar.f4664e = bpVar.w();
                            ajVar.e(true);
                        }
                        break;
                    case 6:
                        if (b2 != 8) {
                            bs.a(bpVar, b2);
                        } else {
                            ajVar.f4665f = bpVar.w();
                            ajVar.f(true);
                        }
                        break;
                    case 7:
                        if (b2 != 11) {
                            bs.a(bpVar, b2);
                        } else {
                            ajVar.f4666g = bpVar.A();
                            ajVar.g(true);
                        }
                        break;
                    case 8:
                        if (b2 != 11) {
                            bs.a(bpVar, b2);
                        } else {
                            ajVar.f4667h = bpVar.z();
                            ajVar.h(true);
                        }
                        break;
                    case 9:
                        if (b2 != 11) {
                            bs.a(bpVar, b2);
                        } else {
                            ajVar.f4668i = bpVar.z();
                            ajVar.i(true);
                        }
                        break;
                    case 10:
                        if (b2 != 8) {
                            bs.a(bpVar, b2);
                        } else {
                            ajVar.f4669j = bpVar.w();
                            ajVar.j(true);
                        }
                        break;
                    default:
                        bs.a(bpVar, b2);
                        break;
                }
                bpVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bp bpVar, aj ajVar) throws bq {
            ajVar.G();
            bpVar.a(aj.m);
            if (ajVar.a != null) {
                bpVar.a(aj.n);
                bpVar.a(ajVar.a);
                bpVar.c();
            }
            if (ajVar.f4661b != null) {
                bpVar.a(aj.o);
                bpVar.a(ajVar.f4661b);
                bpVar.c();
            }
            if (ajVar.f4662c != null) {
                bpVar.a(aj.p);
                bpVar.a(ajVar.f4662c);
                bpVar.c();
            }
            bpVar.a(aj.q);
            bpVar.a(ajVar.f4663d);
            bpVar.c();
            bpVar.a(aj.r);
            bpVar.a(ajVar.f4664e);
            bpVar.c();
            bpVar.a(aj.s);
            bpVar.a(ajVar.f4665f);
            bpVar.c();
            if (ajVar.f4666g != null) {
                bpVar.a(aj.t);
                bpVar.a(ajVar.f4666g);
                bpVar.c();
            }
            if (ajVar.f4667h != null) {
                bpVar.a(aj.u);
                bpVar.a(ajVar.f4667h);
                bpVar.c();
            }
            if (ajVar.f4668i != null) {
                bpVar.a(aj.v);
                bpVar.a(ajVar.f4668i);
                bpVar.c();
            }
            if (ajVar.F()) {
                bpVar.a(aj.w);
                bpVar.a(ajVar.f4669j);
                bpVar.c();
            }
            bpVar.d();
            bpVar.b();
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    public static class b implements by {
        private b() {
        }

        @Override // com.umeng.analytics.pro.by
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    public static class c extends ca<aj> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.bx
        public void a(bp bpVar, aj ajVar) {
            bv bvVar = (bv) bpVar;
            bvVar.a(ajVar.a);
            bvVar.a(ajVar.f4661b);
            bvVar.a(ajVar.f4662c);
            bvVar.a(ajVar.f4663d);
            bvVar.a(ajVar.f4664e);
            bvVar.a(ajVar.f4665f);
            bvVar.a(ajVar.f4666g);
            bvVar.a(ajVar.f4667h);
            bvVar.a(ajVar.f4668i);
            BitSet bitSet = new BitSet();
            if (ajVar.F()) {
                bitSet.set(0);
            }
            bvVar.a(bitSet, 1);
            if (ajVar.F()) {
                bvVar.a(ajVar.f4669j);
            }
        }

        @Override // com.umeng.analytics.pro.bx
        public void b(bp bpVar, aj ajVar) {
            bv bvVar = (bv) bpVar;
            ajVar.a = bvVar.z();
            ajVar.a(true);
            ajVar.f4661b = bvVar.z();
            ajVar.b(true);
            ajVar.f4662c = bvVar.z();
            ajVar.c(true);
            ajVar.f4663d = bvVar.w();
            ajVar.d(true);
            ajVar.f4664e = bvVar.w();
            ajVar.e(true);
            ajVar.f4665f = bvVar.w();
            ajVar.f(true);
            ajVar.f4666g = bvVar.A();
            ajVar.g(true);
            ajVar.f4667h = bvVar.z();
            ajVar.h(true);
            ajVar.f4668i = bvVar.z();
            ajVar.i(true);
            if (bvVar.b(1).get(0)) {
                ajVar.f4669j = bvVar.w();
                ajVar.j(true);
            }
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
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
        x = map;
        map.put(bz.class, new b());
        map.put(ca.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.VERSION, new bc("version", (byte) 1, new bd((byte) 11)));
        enumMap.put(e.ADDRESS, new bc("address", (byte) 1, new bd((byte) 11)));
        enumMap.put(e.SIGNATURE, new bc("signature", (byte) 1, new bd((byte) 11)));
        enumMap.put(e.SERIAL_NUM, new bc("serial_num", (byte) 1, new bd((byte) 8)));
        enumMap.put(e.TS_SECS, new bc("ts_secs", (byte) 1, new bd((byte) 8)));
        enumMap.put(e.LENGTH, new bc("length", (byte) 1, new bd((byte) 8)));
        enumMap.put(e.ENTITY, new bc("entity", (byte) 1, new bd((byte) 11, true)));
        enumMap.put(e.GUID, new bc("guid", (byte) 1, new bd((byte) 11)));
        enumMap.put(e.CHECKSUM, new bc("checksum", (byte) 1, new bd((byte) 11)));
        enumMap.put(e.CODEX, new bc("codex", (byte) 2, new bd((byte) 8)));
        Map<e, bc> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        f4659k = mapUnmodifiableMap;
        bc.a(aj.class, mapUnmodifiableMap);
    }

    public aj() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.f4668i;
    }

    public void B() {
        this.f4668i = null;
    }

    public boolean C() {
        return this.f4668i != null;
    }

    public int D() {
        return this.f4669j;
    }

    public void E() {
        this.C = an.b(this.C, 3);
    }

    public boolean F() {
        return an.a(this.C, 3);
    }

    public void G() throws bq {
        if (this.a == null) {
            StringBuilder sbR = c.a.a.a.a.r("Required field 'version' was not present! Struct: ");
            sbR.append(toString());
            throw new bq(sbR.toString());
        }
        if (this.f4661b == null) {
            StringBuilder sbR2 = c.a.a.a.a.r("Required field 'address' was not present! Struct: ");
            sbR2.append(toString());
            throw new bq(sbR2.toString());
        }
        if (this.f4662c == null) {
            StringBuilder sbR3 = c.a.a.a.a.r("Required field 'signature' was not present! Struct: ");
            sbR3.append(toString());
            throw new bq(sbR3.toString());
        }
        if (this.f4666g == null) {
            StringBuilder sbR4 = c.a.a.a.a.r("Required field 'entity' was not present! Struct: ");
            sbR4.append(toString());
            throw new bq(sbR4.toString());
        }
        if (this.f4667h == null) {
            StringBuilder sbR5 = c.a.a.a.a.r("Required field 'guid' was not present! Struct: ");
            sbR5.append(toString());
            throw new bq(sbR5.toString());
        }
        if (this.f4668i != null) {
            return;
        }
        StringBuilder sbR6 = c.a.a.a.a.r("Required field 'checksum' was not present! Struct: ");
        sbR6.append(toString());
        throw new bq(sbR6.toString());
    }

    @Override // com.umeng.analytics.pro.aq
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public aj deepCopy() {
        return new aj(this);
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
        this.f4661b = null;
        this.f4662c = null;
        d(false);
        this.f4663d = 0;
        e(false);
        this.f4664e = 0;
        f(false);
        this.f4665f = 0;
        this.f4666g = null;
        this.f4667h = null;
        this.f4668i = null;
        j(false);
        this.f4669j = 0;
    }

    public boolean d() {
        return this.a != null;
    }

    public String e() {
        return this.f4661b;
    }

    public void f() {
        this.f4661b = null;
    }

    public boolean g() {
        return this.f4661b != null;
    }

    public String h() {
        return this.f4662c;
    }

    public void i() {
        this.f4662c = null;
    }

    public boolean j() {
        return this.f4662c != null;
    }

    public int k() {
        return this.f4663d;
    }

    public void l() {
        this.C = an.b(this.C, 0);
    }

    public boolean m() {
        return an.a(this.C, 0);
    }

    public int n() {
        return this.f4664e;
    }

    public void o() {
        this.C = an.b(this.C, 1);
    }

    public boolean p() {
        return an.a(this.C, 1);
    }

    public int q() {
        return this.f4665f;
    }

    public void r() {
        this.C = an.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.aq
    public void read(bp bpVar) {
        x.get(bpVar.D()).b().b(bpVar, this);
    }

    public boolean s() {
        return an.a(this.C, 2);
    }

    public byte[] t() {
        a(ar.c(this.f4666g));
        ByteBuffer byteBuffer = this.f4666g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f4661b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f4662c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f4663d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f4664e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f4665f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f4666g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            ar.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f4667h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f4668i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f4669j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.f4666g;
    }

    public void v() {
        this.f4666g = null;
    }

    public boolean w() {
        return this.f4666g != null;
    }

    @Override // com.umeng.analytics.pro.aq
    public void write(bp bpVar) {
        x.get(bpVar.D()).b().a(bpVar, this);
    }

    public String x() {
        return this.f4667h;
    }

    public void y() {
        this.f4667h = null;
    }

    public boolean z() {
        return this.f4667h != null;
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    public enum e implements ax {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");


        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final Map<String, e> f4679k = new HashMap();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final short f4680l;
        private final String m;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f4679k.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f4680l = s;
            this.m = str;
        }

        public static e a(int i2) {
            switch (i2) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.m;
        }

        public static e a(String str) {
            return f4679k.get(str);
        }

        @Override // com.umeng.analytics.pro.ax
        public short a() {
            return this.f4680l;
        }
    }

    public aj a(String str) {
        this.a = str;
        return this;
    }

    public aj b(String str) {
        this.f4661b = str;
        return this;
    }

    public aj c(String str) {
        this.f4662c = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = an.a(this.C, 0, z2);
    }

    public void e(boolean z2) {
        this.C = an.a(this.C, 1, z2);
    }

    public void f(boolean z2) {
        this.C = an.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.f4666g = null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.f4667h = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.f4668i = null;
    }

    public void j(boolean z2) {
        this.C = an.a(this.C, 3, z2);
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.a = null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.f4661b = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f4662c = null;
    }

    public aj d(String str) {
        this.f4667h = str;
        return this;
    }

    public aj e(String str) {
        this.f4668i = str;
        return this;
    }

    public aj(String str, String str2, String str3, int i2, int i3, int i4, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.a = str;
        this.f4661b = str2;
        this.f4662c = str3;
        this.f4663d = i2;
        d(true);
        this.f4664e = i3;
        e(true);
        this.f4665f = i4;
        f(true);
        this.f4666g = byteBuffer;
        this.f4667h = str4;
        this.f4668i = str5;
    }

    public aj a(int i2) {
        this.f4663d = i2;
        d(true);
        return this;
    }

    public aj b(int i2) {
        this.f4664e = i2;
        e(true);
        return this;
    }

    public aj c(int i2) {
        this.f4665f = i2;
        f(true);
        return this;
    }

    public aj d(int i2) {
        this.f4669j = i2;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.aq
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public aj a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public aj a(ByteBuffer byteBuffer) {
        this.f4666g = byteBuffer;
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
            this.C = (byte) 0;
            read(new bj(new cb(objectInputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public aj(aj ajVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = ajVar.C;
        if (ajVar.d()) {
            this.a = ajVar.a;
        }
        if (ajVar.g()) {
            this.f4661b = ajVar.f4661b;
        }
        if (ajVar.j()) {
            this.f4662c = ajVar.f4662c;
        }
        this.f4663d = ajVar.f4663d;
        this.f4664e = ajVar.f4664e;
        this.f4665f = ajVar.f4665f;
        if (ajVar.w()) {
            this.f4666g = ar.d(ajVar.f4666g);
        }
        if (ajVar.z()) {
            this.f4667h = ajVar.f4667h;
        }
        if (ajVar.C()) {
            this.f4668i = ajVar.f4668i;
        }
        this.f4669j = ajVar.f4669j;
    }
}
