package com.umeng.commonsdk.statistics.proto;

import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bh;
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

/* JADX INFO: loaded from: classes3.dex */
public class Response implements aq<Response, e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, bc> metaDataMap;
    private static final Map<Class<? extends bx>, by> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public com.umeng.commonsdk.statistics.proto.d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;
    private static final bu STRUCT_DESC = new bu("Response");
    private static final bk RESP_CODE_FIELD_DESC = new bk("resp_code", (byte) 8, 1);
    private static final bk MSG_FIELD_DESC = new bk(NotificationCompat.CATEGORY_MESSAGE, (byte) 11, 2);
    private static final bk IMPRINT_FIELD_DESC = new bk(ai.X, (byte) 12, 3);

    public static class a extends bz<Response> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bp bpVar, Response response) throws bq {
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
                        } else if (b2 == 12) {
                            com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                            response.imprint = dVar;
                            dVar.read(bpVar);
                            response.setImprintIsSet(true);
                        } else {
                            bs.a(bpVar, b2);
                        }
                    } else if (b2 == 11) {
                        response.msg = bpVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        bs.a(bpVar, b2);
                    }
                } else if (b2 == 8) {
                    response.resp_code = bpVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    bs.a(bpVar, b2);
                }
                bpVar.m();
            }
            bpVar.k();
            if (response.isSetResp_code()) {
                response.validate();
            } else {
                StringBuilder sbR = c.a.a.a.a.r("Required field 'resp_code' was not found in serialized data! Struct: ");
                sbR.append(toString());
                throw new bq(sbR.toString());
            }
        }

        @Override // com.umeng.analytics.pro.bx
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bp bpVar, Response response) throws bq {
            response.validate();
            bpVar.a(Response.STRUCT_DESC);
            bpVar.a(Response.RESP_CODE_FIELD_DESC);
            bpVar.a(response.resp_code);
            bpVar.c();
            if (response.msg != null && response.isSetMsg()) {
                bpVar.a(Response.MSG_FIELD_DESC);
                bpVar.a(response.msg);
                bpVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                bpVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(bpVar);
                bpVar.c();
            }
            bpVar.d();
            bpVar.b();
        }
    }

    public static class b implements by {
        private b() {
        }

        @Override // com.umeng.analytics.pro.by
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    public static class c extends ca<Response> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.bx
        public void a(bp bpVar, Response response) {
            bv bvVar = (bv) bpVar;
            bvVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            bvVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                bvVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(bvVar);
            }
        }

        @Override // com.umeng.analytics.pro.bx
        public void b(bp bpVar, Response response) {
            bv bvVar = (bv) bpVar;
            response.resp_code = bvVar.w();
            response.setResp_codeIsSet(true);
            BitSet bitSetB = bvVar.b(2);
            if (bitSetB.get(0)) {
                response.msg = bvVar.z();
                response.setMsgIsSet(true);
            }
            if (bitSetB.get(1)) {
                com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                response.imprint = dVar;
                dVar.read(bvVar);
                response.setImprintIsSet(true);
            }
        }
    }

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
        schemes = map;
        map.put(bz.class, new b());
        map.put(ca.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.RESP_CODE, new bc("resp_code", (byte) 1, new bd((byte) 8)));
        enumMap.put(e.MSG, new bc(NotificationCompat.CATEGORY_MESSAGE, (byte) 2, new bd((byte) 11)));
        enumMap.put(e.IMPRINT, new bc(ai.X, (byte) 2, new bh((byte) 12, com.umeng.commonsdk.statistics.proto.d.class)));
        Map<e, bc> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = mapUnmodifiableMap;
        bc.a(Response.class, mapUnmodifiableMap);
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new bj(new cb(objectInputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bj(new cb(objectOutputStream)));
        } catch (aw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.aq
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public com.umeng.commonsdk.statistics.proto.d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return an.a(this.__isset_bitfield, 0);
    }

    @Override // com.umeng.analytics.pro.aq
    public void read(bp bpVar) {
        schemes.get(bpVar.D()).b().b(bpVar, this);
    }

    public Response setImprint(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (z) {
            return;
        }
        this.imprint = null;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (z) {
            return;
        }
        this.msg = null;
    }

    public Response setResp_code(int i2) {
        this.resp_code = i2;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = an.a(this.__isset_bitfield, 0, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
            if (dVar == null) {
                sb.append("null");
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = an.b(this.__isset_bitfield, 0);
    }

    public void validate() throws bq {
        com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    @Override // com.umeng.analytics.pro.aq
    public void write(bp bpVar) {
        schemes.get(bpVar.D()).b().a(bpVar, this);
    }

    public enum e implements ax {
        RESP_CODE(1, "resp_code"),
        MSG(2, NotificationCompat.CATEGORY_MESSAGE),
        IMPRINT(3, ai.X);


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f5322d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f5324e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f5325f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f5322d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f5324e = s;
            this.f5325f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return RESP_CODE;
            }
            if (i2 == 2) {
                return MSG;
            }
            if (i2 != 3) {
                return null;
            }
            return IMPRINT;
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
            return this.f5325f;
        }

        public static e a(String str) {
            return f5322d.get(str);
        }

        @Override // com.umeng.analytics.pro.ax
        public short a() {
            return this.f5324e;
        }
    }

    @Override // com.umeng.analytics.pro.aq
    public Response deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.aq
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public Response(int i2) {
        this();
        this.resp_code = i2;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new com.umeng.commonsdk.statistics.proto.d(response.imprint);
        }
    }
}
