package i.a.b.m;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ArraysMapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class a<T> extends i.a.b.m.k<T> {
    public static i.a.b.m.k<int[]> a = new h(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static i.a.b.m.k<Integer[]> f6393b = new i(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static i.a.b.m.k<byte[]> f6394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static i.a.b.m.k<Byte[]> f6395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static i.a.b.m.k<char[]> f6396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static i.a.b.m.k<Character[]> f6397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static i.a.b.m.k<long[]> f6398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static i.a.b.m.k<Long[]> f6399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static i.a.b.m.k<float[]> f6400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static i.a.b.m.k<Float[]> f6401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static i.a.b.m.k<double[]> f6402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static i.a.b.m.k<Double[]> f6403l;
    public static i.a.b.m.k<boolean[]> m;
    public static i.a.b.m.k<Boolean[]> n;

    /* JADX INFO: renamed from: i.a.b.m.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArraysMapper.java */
    public class C0186a extends a<Long[]> {
        public C0186a(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            Long[] lArr = new Long[list.size()];
            int i2 = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Float) {
                        lArr[i2] = (Long) obj2;
                    } else {
                        lArr[i2] = Long.valueOf(((Number) obj2).longValue());
                    }
                    i2++;
                }
            }
            return lArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class b extends a<float[]> {
        public b(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            float[] fArr = new float[list.size()];
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                fArr[i2] = ((Number) it.next()).floatValue();
                i2++;
            }
            return fArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class c extends a<Float[]> {
        public c(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            Float[] fArr = new Float[list.size()];
            int i2 = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Float) {
                        fArr[i2] = (Float) obj2;
                    } else {
                        fArr[i2] = Float.valueOf(((Number) obj2).floatValue());
                    }
                    i2++;
                }
            }
            return fArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class d extends a<double[]> {
        public d(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            double[] dArr = new double[list.size()];
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                dArr[i2] = ((Number) it.next()).doubleValue();
                i2++;
            }
            return dArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class e extends a<Double[]> {
        public e(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            Double[] dArr = new Double[list.size()];
            int i2 = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Double) {
                        dArr[i2] = (Double) obj2;
                    } else {
                        dArr[i2] = Double.valueOf(((Number) obj2).doubleValue());
                    }
                    i2++;
                }
            }
            return dArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class f extends a<boolean[]> {
        public f(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            boolean[] zArr = new boolean[list.size()];
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                zArr[i2] = ((Boolean) it.next()).booleanValue();
                i2++;
            }
            return zArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class g extends a<Boolean[]> {
        public g(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            Boolean[] boolArr = new Boolean[list.size()];
            int i2 = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Boolean) {
                        boolArr[i2] = Boolean.valueOf(((Boolean) obj2).booleanValue());
                    } else {
                        if (!(obj2 instanceof Number)) {
                            throw new RuntimeException("can not convert " + obj2 + " toBoolean");
                        }
                        boolArr[i2] = Boolean.valueOf(((Number) obj2).intValue() != 0);
                    }
                    i2++;
                }
            }
            return boolArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class h extends a<int[]> {
        public h(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            int[] iArr = new int[list.size()];
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = ((Number) it.next()).intValue();
                i2++;
            }
            return iArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class i extends a<Integer[]> {
        public i(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            Integer[] numArr = new Integer[list.size()];
            int i2 = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Integer) {
                        numArr[i2] = (Integer) obj2;
                    } else {
                        numArr[i2] = Integer.valueOf(((Number) obj2).intValue());
                    }
                    i2++;
                }
            }
            return numArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class j extends a<short[]> {
        public j(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            short[] sArr = new short[list.size()];
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                sArr[i2] = ((Number) it.next()).shortValue();
                i2++;
            }
            return sArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class k extends a<Short[]> {
        public k(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            Short[] shArr = new Short[list.size()];
            int i2 = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Short) {
                        shArr[i2] = (Short) obj2;
                    } else {
                        shArr[i2] = Short.valueOf(((Number) obj2).shortValue());
                    }
                    i2++;
                }
            }
            return shArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class l extends a<byte[]> {
        public l(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            byte[] bArr = new byte[list.size()];
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                bArr[i2] = ((Number) it.next()).byteValue();
                i2++;
            }
            return bArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class m extends a<Byte[]> {
        public m(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            Byte[] bArr = new Byte[list.size()];
            int i2 = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Byte) {
                        bArr[i2] = (Byte) obj2;
                    } else {
                        bArr[i2] = Byte.valueOf(((Number) obj2).byteValue());
                    }
                    i2++;
                }
            }
            return bArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class n extends a<char[]> {
        public n(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            char[] cArr = new char[list.size()];
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                cArr[i2] = it.next().toString().charAt(0);
                i2++;
            }
            return cArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class o extends a<Character[]> {
        public o(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            Character[] chArr = new Character[list.size()];
            int i2 = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    chArr[i2] = Character.valueOf(obj2.toString().charAt(0));
                    i2++;
                }
            }
            return chArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public class p extends a<long[]> {
        public p(i.a.b.m.j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            List list = (List) obj;
            long[] jArr = new long[list.size()];
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                jArr[i2] = ((Number) it.next()).intValue();
                i2++;
            }
            return jArr;
        }
    }

    /* JADX INFO: compiled from: ArraysMapper.java */
    public static class q<T> extends a<T> {
        public final Class<?> o;
        public i.a.b.m.k<?> p;

        public q(i.a.b.m.j jVar, Class<T> cls) {
            super(jVar);
            this.o = cls.getComponentType();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object[]] */
        @Override // i.a.b.m.k
        public T convert(Object obj) {
            List list = (List) obj;
            ?? r0 = (T) ((Object[]) Array.newInstance(this.o, list.size()));
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r0[i2] = it.next();
                i2++;
            }
            return r0;
        }

        @Override // i.a.b.m.k
        public i.a.b.m.k<?> startArray(String str) {
            if (this.p == null) {
                this.p = this.base.a(this.o);
            }
            return this.p;
        }

        @Override // i.a.b.m.k
        public i.a.b.m.k<?> startObject(String str) {
            if (this.p == null) {
                this.p = this.base.a(this.o);
            }
            return this.p;
        }
    }

    static {
        new j(null);
        new k(null);
        f6394c = new l(null);
        f6395d = new m(null);
        f6396e = new n(null);
        f6397f = new o(null);
        f6398g = new p(null);
        f6399h = new C0186a(null);
        f6400i = new b(null);
        f6401j = new c(null);
        f6402k = new d(null);
        f6403l = new e(null);
        m = new f(null);
        n = new g(null);
    }

    public a(i.a.b.m.j jVar) {
        super(jVar);
    }

    @Override // i.a.b.m.k
    public void addValue(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }

    @Override // i.a.b.m.k
    public Object createArray() {
        return new ArrayList();
    }
}
