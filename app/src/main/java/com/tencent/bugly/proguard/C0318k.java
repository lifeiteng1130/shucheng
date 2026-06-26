package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.bw;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class C0318k {
    private ByteBuffer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4383b = "GBK";

    /* JADX INFO: renamed from: com.tencent.bugly.proguard.k$a */
    /* JADX INFO: compiled from: BUGLY */
    public static class a {
        public byte a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4384b;
    }

    public C0318k() {
    }

    private int b(a aVar) {
        return a(aVar, this.a.duplicate());
    }

    public void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.a = ByteBuffer.wrap(bArr);
    }

    private void b(int i2) {
        ByteBuffer byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + i2);
    }

    public C0318k(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
    }

    private void b() {
        a(c.a.a.a.a.D(this).a);
    }

    public static int a(a aVar, ByteBuffer byteBuffer) {
        byte b2 = byteBuffer.get();
        aVar.a = (byte) (b2 & bw.m);
        int i2 = (b2 & 240) >> 4;
        aVar.f4384b = i2;
        if (i2 != 15) {
            return 1;
        }
        aVar.f4384b = byteBuffer.get();
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return null;
        }
        if (c.a.a.a.a.D(this).a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), iA));
                for (int i3 = 0; i3 < iA; i3++) {
                    tArr[i3] = a((Object) t, 0, true);
                }
                return tArr;
            }
            throw new C0315h(c.a.a.a.a.G("size invalid: ", iA));
        }
        throw new C0315h("type mismatch.");
    }

    public C0318k(byte[] bArr, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.a = byteBufferWrap;
        byteBufferWrap.position(i2);
    }

    public void a(a aVar) {
        a(aVar, this.a);
    }

    public boolean a(int i2) {
        int i3;
        try {
            a aVar = new a();
            while (true) {
                int iB = b(aVar);
                i3 = aVar.f4384b;
                if (i2 <= i3 || aVar.a == 11) {
                    break;
                }
                b(iB);
                a(aVar.a);
            }
            return i2 == i3;
        } catch (C0315h | BufferUnderflowException unused) {
            return false;
        }
    }

    public void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.a);
        } while (aVar.a != 11);
    }

    private void a(byte b2) {
        int i2 = 0;
        switch (b2) {
            case 0:
                b(1);
                return;
            case 1:
                b(2);
                return;
            case 2:
                b(4);
                return;
            case 3:
                b(8);
                return;
            case 4:
                b(4);
                return;
            case 5:
                b(8);
                return;
            case 6:
                int i3 = this.a.get();
                if (i3 < 0) {
                    i3 += 256;
                }
                b(i3);
                return;
            case 7:
                b(this.a.getInt());
                return;
            case 8:
                int iA = a(0, 0, true);
                while (i2 < iA * 2) {
                    b();
                    i2++;
                }
                return;
            case 9:
                int iA2 = a(0, 0, true);
                while (i2 < iA2) {
                    b();
                    i2++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVarD = c.a.a.a.a.D(this);
                if (aVarD.a == 0) {
                    b(a(0, 0, true));
                    return;
                } else {
                    StringBuilder sbS = c.a.a.a.a.s("skipField with invalid type, type value: ", b2, ", ");
                    sbS.append((int) aVarD.a);
                    throw new C0315h(sbS.toString());
                }
            default:
                throw new C0315h("invalid type.");
        }
    }

    public boolean a(boolean z, int i2, boolean z2) {
        return a((byte) 0, i2, z2) != 0;
    }

    public byte a(byte b2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return b2;
        }
        byte b3 = c.a.a.a.a.D(this).a;
        if (b3 == 0) {
            return this.a.get();
        }
        if (b3 == 12) {
            return (byte) 0;
        }
        throw new C0315h("type mismatch.");
    }

    public short a(short s, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return s;
        }
        byte b2 = c.a.a.a.a.D(this).a;
        if (b2 == 0) {
            return this.a.get();
        }
        if (b2 == 1) {
            return this.a.getShort();
        }
        if (b2 == 12) {
            return (short) 0;
        }
        throw new C0315h("type mismatch.");
    }

    public int a(int i2, int i3, boolean z) {
        if (!a(i3)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return i2;
        }
        byte b2 = c.a.a.a.a.D(this).a;
        if (b2 == 0) {
            return this.a.get();
        }
        if (b2 == 1) {
            return this.a.getShort();
        }
        if (b2 == 2) {
            return this.a.getInt();
        }
        if (b2 == 12) {
            return 0;
        }
        throw new C0315h("type mismatch.");
    }

    public long a(long j2, int i2, boolean z) {
        int i3;
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return j2;
        }
        byte b2 = c.a.a.a.a.D(this).a;
        if (b2 == 12) {
            return 0L;
        }
        if (b2 == 0) {
            i3 = this.a.get();
        } else if (b2 == 1) {
            i3 = this.a.getShort();
        } else {
            if (b2 != 2) {
                if (b2 == 3) {
                    return this.a.getLong();
                }
                throw new C0315h("type mismatch.");
            }
            i3 = this.a.getInt();
        }
        return i3;
    }

    public float a(float f2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return f2;
        }
        byte b2 = c.a.a.a.a.D(this).a;
        if (b2 == 4) {
            return this.a.getFloat();
        }
        if (b2 == 12) {
            return 0.0f;
        }
        throw new C0315h("type mismatch.");
    }

    public double a(double d2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return d2;
        }
        byte b2 = c.a.a.a.a.D(this).a;
        if (b2 == 4) {
            return this.a.getFloat();
        }
        if (b2 == 5) {
            return this.a.getDouble();
        }
        if (b2 == 12) {
            return 0.0d;
        }
        throw new C0315h("type mismatch.");
    }

    public String a(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return null;
        }
        byte b2 = c.a.a.a.a.D(this).a;
        if (b2 == 6) {
            int i3 = this.a.get();
            if (i3 < 0) {
                i3 += 256;
            }
            byte[] bArr = new byte[i3];
            this.a.get(bArr);
            try {
                return new String(bArr, this.f4383b);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b2 == 7) {
            int i4 = this.a.getInt();
            if (i4 <= 104857600 && i4 >= 0) {
                byte[] bArr2 = new byte[i4];
                this.a.get(bArr2);
                try {
                    return new String(bArr2, this.f4383b);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new C0315h(c.a.a.a.a.G("String too long: ", i4));
        }
        throw new C0315h("type mismatch.");
    }

    public <K, V> HashMap<K, V> a(Map<K, V> map, int i2, boolean z) {
        return (HashMap) a(new HashMap(), map, i2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i2, boolean z) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (a(i2)) {
                if (c.a.a.a.a.D(this).a == 8) {
                    int iA = a(0, 0, true);
                    if (iA < 0) {
                        throw new C0315h(c.a.a.a.a.G("size invalid: ", iA));
                    }
                    for (int i3 = 0; i3 < iA; i3++) {
                        map.put(a(key, 0, true), a(value, 1, true));
                    }
                } else {
                    throw new C0315h("type mismatch.");
                }
            } else if (z) {
                throw new C0315h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    public boolean[] a(boolean[] zArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return null;
        }
        if (c.a.a.a.a.D(this).a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                boolean[] zArr2 = new boolean[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    zArr2[i3] = a(zArr2[0], 0, true);
                }
                return zArr2;
            }
            throw new C0315h(c.a.a.a.a.G("size invalid: ", iA));
        }
        throw new C0315h("type mismatch.");
    }

    public byte[] a(byte[] bArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return null;
        }
        a aVarD = c.a.a.a.a.D(this);
        byte b2 = aVarD.a;
        if (b2 == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                byte[] bArr2 = new byte[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    bArr2[i3] = a(bArr2[0], 0, true);
                }
                return bArr2;
            }
            throw new C0315h(c.a.a.a.a.G("size invalid: ", iA));
        }
        if (b2 == 13) {
            a aVarD2 = c.a.a.a.a.D(this);
            if (aVarD2.a == 0) {
                int iA2 = a(0, 0, true);
                if (iA2 >= 0) {
                    byte[] bArr3 = new byte[iA2];
                    this.a.get(bArr3);
                    return bArr3;
                }
                StringBuilder sbS = c.a.a.a.a.s("invalid size, tag: ", i2, ", type: ");
                sbS.append((int) aVarD.a);
                sbS.append(", ");
                sbS.append((int) aVarD2.a);
                sbS.append(", size: ");
                sbS.append(iA2);
                throw new C0315h(sbS.toString());
            }
            StringBuilder sbS2 = c.a.a.a.a.s("type mismatch, tag: ", i2, ", type: ");
            sbS2.append((int) aVarD.a);
            sbS2.append(", ");
            sbS2.append((int) aVarD2.a);
            throw new C0315h(sbS2.toString());
        }
        throw new C0315h("type mismatch.");
    }

    public short[] a(short[] sArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return null;
        }
        if (c.a.a.a.a.D(this).a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                short[] sArr2 = new short[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    sArr2[i3] = a(sArr2[0], 0, true);
                }
                return sArr2;
            }
            throw new C0315h(c.a.a.a.a.G("size invalid: ", iA));
        }
        throw new C0315h("type mismatch.");
    }

    public int[] a(int[] iArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return null;
        }
        if (c.a.a.a.a.D(this).a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                int[] iArr2 = new int[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    iArr2[i3] = a(iArr2[0], 0, true);
                }
                return iArr2;
            }
            throw new C0315h(c.a.a.a.a.G("size invalid: ", iA));
        }
        throw new C0315h("type mismatch.");
    }

    public long[] a(long[] jArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return null;
        }
        if (c.a.a.a.a.D(this).a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                long[] jArr2 = new long[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    jArr2[i3] = a(jArr2[0], 0, true);
                }
                return jArr2;
            }
            throw new C0315h(c.a.a.a.a.G("size invalid: ", iA));
        }
        throw new C0315h("type mismatch.");
    }

    public float[] a(float[] fArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return null;
        }
        if (c.a.a.a.a.D(this).a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                float[] fArr2 = new float[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    fArr2[i3] = a(fArr2[0], 0, true);
                }
                return fArr2;
            }
            throw new C0315h(c.a.a.a.a.G("size invalid: ", iA));
        }
        throw new C0315h("type mismatch.");
    }

    public double[] a(double[] dArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return null;
        }
        if (c.a.a.a.a.D(this).a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                double[] dArr2 = new double[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    dArr2[i3] = a(dArr2[0], 0, true);
                }
                return dArr2;
            }
            throw new C0315h(c.a.a.a.a.G("size invalid: ", iA));
        }
        throw new C0315h("type mismatch.");
    }

    public <T> T[] a(T[] tArr, int i2, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i2, z);
        }
        throw new C0315h("unable to get type of key and value.");
    }

    public <T> List<T> a(List<T> list, int i2, boolean z) {
        if (list != null && !list.isEmpty()) {
            Object[] objArrB = b(list.get(0), i2, z);
            if (objArrB == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : objArrB) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public AbstractC0320m a(AbstractC0320m abstractC0320m, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0315h("require field not exist.");
            }
            return null;
        }
        try {
            AbstractC0320m abstractC0320m2 = (AbstractC0320m) abstractC0320m.getClass().newInstance();
            if (c.a.a.a.a.D(this).a == 10) {
                abstractC0320m2.a(this);
                a();
                return abstractC0320m2;
            }
            throw new C0315h("type mismatch.");
        } catch (Exception e2) {
            throw new C0315h(e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(T t, int i2, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i2, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(false, i2, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i2, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i2, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0L, i2, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a(0.0f, i2, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a(0.0d, i2, z));
        }
        if (t instanceof String) {
            return String.valueOf(a(i2, z));
        }
        if (t instanceof Map) {
            return a((Map) t, i2, z);
        }
        if (t instanceof List) {
            return a((List) t, i2, z);
        }
        if (t instanceof AbstractC0320m) {
            return a((AbstractC0320m) t, i2, z);
        }
        if (t.getClass().isArray()) {
            if (!(t instanceof byte[]) && !(t instanceof Byte[])) {
                if (t instanceof boolean[]) {
                    return a((boolean[]) null, i2, z);
                }
                if (t instanceof short[]) {
                    return a((short[]) null, i2, z);
                }
                if (t instanceof int[]) {
                    return a((int[]) null, i2, z);
                }
                if (t instanceof long[]) {
                    return a((long[]) null, i2, z);
                }
                if (t instanceof float[]) {
                    return a((float[]) null, i2, z);
                }
                if (t instanceof double[]) {
                    return a((double[]) null, i2, z);
                }
                return a((Object[]) t, i2, z);
            }
            return a((byte[]) null, i2, z);
        }
        throw new C0315h("read object error: unsupport type.");
    }

    public int a(String str) {
        this.f4383b = str;
        return 0;
    }
}
