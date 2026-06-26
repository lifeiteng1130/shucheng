package c.b.a.m.q.c0;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: LruArrayPool.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements c.b.a.m.q.c0.b {
    public final g<a, Object> a = new g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f330b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, NavigableMap<Integer, Integer>> f331c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, c.b.a.m.q.c0.a<?>> f332d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f334f;

    /* JADX INFO: compiled from: LruArrayPool.java */
    public static final class a implements l {
        public final b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Class<?> f336c;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // c.b.a.m.q.c0.l
        public void a() {
            this.a.c(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f335b == aVar.f335b && this.f336c == aVar.f336c;
        }

        public int hashCode() {
            int i2 = this.f335b * 31;
            Class<?> cls = this.f336c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("Key{size=");
            sbR.append(this.f335b);
            sbR.append("array=");
            sbR.append(this.f336c);
            sbR.append(MessageFormatter.DELIM_STOP);
            return sbR.toString();
        }
    }

    /* JADX INFO: compiled from: LruArrayPool.java */
    public static final class b extends c<a> {
        @Override // c.b.a.m.q.c0.c
        public l a() {
            return new a(this);
        }

        public a d(int i2, Class<?> cls) {
            a aVarB = b();
            aVarB.f335b = i2;
            aVarB.f336c = cls;
            return aVarB;
        }
    }

    public i(int i2) {
        this.f333e = i2;
    }

    @Override // c.b.a.m.q.c0.b
    public synchronized void a(int i2) {
        if (i2 >= 40) {
            synchronized (this) {
                g(0);
            }
        } else if (i2 >= 20 || i2 == 15) {
            g(this.f333e / 2);
        }
    }

    @Override // c.b.a.m.q.c0.b
    public synchronized void b() {
        g(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.a.m.q.c0.b
    public synchronized <T> T c(int i2, Class<T> cls) {
        a aVarB;
        aVarB = this.f330b.b();
        aVarB.f335b = i2;
        aVarB.f336c = cls;
        return (T) i(aVarB, cls);
    }

    @Override // c.b.a.m.q.c0.b
    public synchronized <T> void d(T t) {
        Class<?> cls = t.getClass();
        c.b.a.m.q.c0.a<T> aVarH = h(cls);
        int iB = aVarH.b(t);
        int iA = aVarH.a() * iB;
        int iIntValue = 1;
        if (iA <= this.f333e / 2) {
            a aVarD = this.f330b.d(iB, cls);
            this.a.b(aVarD, t);
            NavigableMap<Integer, Integer> navigableMapJ = j(cls);
            Integer num = (Integer) navigableMapJ.get(Integer.valueOf(aVarD.f335b));
            Integer numValueOf = Integer.valueOf(aVarD.f335b);
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapJ.put(numValueOf, Integer.valueOf(iIntValue));
            this.f334f += iA;
            g(this.f333e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[Catch: all -> 0x004d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0017, B:13:0x0023, B:18:0x002f, B:20:0x0047, B:19:0x003a), top: B:26:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[Catch: all -> 0x004d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0017, B:13:0x0023, B:18:0x002f, B:20:0x0047, B:19:0x003a), top: B:26:0x0001 }] */
    @Override // c.b.a.m.q.c0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized <T> T e(int r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.NavigableMap r0 = r5.j(r7)     // Catch: java.lang.Throwable -> L4d
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r0 = r0.ceilingKey(r1)     // Catch: java.lang.Throwable -> L4d
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L4d
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2c
            int r3 = r5.f334f     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L20
            int r4 = r5.f333e     // Catch: java.lang.Throwable -> L4d
            int r4 = r4 / r3
            r3 = 2
            if (r4 < r3) goto L1e
            goto L20
        L1e:
            r3 = 0
            goto L21
        L20:
            r3 = 1
        L21:
            if (r3 != 0) goto L2d
            int r3 = r0.intValue()     // Catch: java.lang.Throwable -> L4d
            int r4 = r6 * 8
            if (r3 > r4) goto L2c
            goto L2d
        L2c:
            r1 = 0
        L2d:
            if (r1 == 0) goto L3a
            c.b.a.m.q.c0.i$b r6 = r5.f330b     // Catch: java.lang.Throwable -> L4d
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L4d
            c.b.a.m.q.c0.i$a r6 = r6.d(r0, r7)     // Catch: java.lang.Throwable -> L4d
            goto L47
        L3a:
            c.b.a.m.q.c0.i$b r0 = r5.f330b     // Catch: java.lang.Throwable -> L4d
            c.b.a.m.q.c0.l r0 = r0.b()     // Catch: java.lang.Throwable -> L4d
            c.b.a.m.q.c0.i$a r0 = (c.b.a.m.q.c0.i.a) r0     // Catch: java.lang.Throwable -> L4d
            r0.f335b = r6     // Catch: java.lang.Throwable -> L4d
            r0.f336c = r7     // Catch: java.lang.Throwable -> L4d
            r6 = r0
        L47:
            java.lang.Object r6 = r5.i(r6, r7)     // Catch: java.lang.Throwable -> L4d
            monitor-exit(r5)
            return r6
        L4d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.q.c0.i.e(int, java.lang.Class):java.lang.Object");
    }

    public final void f(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapJ = j(cls);
        Integer num = (Integer) navigableMapJ.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapJ.remove(Integer.valueOf(i2));
                return;
            } else {
                navigableMapJ.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    public final void g(int i2) {
        while (this.f334f > i2) {
            Object objC = this.a.c();
            Objects.requireNonNull(objC, "Argument must not be null");
            c.b.a.m.q.c0.a aVarH = h(objC.getClass());
            this.f334f -= aVarH.a() * aVarH.b(objC);
            f(aVarH.b(objC), objC.getClass());
            if (Log.isLoggable(aVarH.getTag(), 2)) {
                aVarH.getTag();
                aVarH.b(objC);
            }
        }
    }

    public final <T> c.b.a.m.q.c0.a<T> h(Class<T> cls) {
        c.b.a.m.q.c0.a<T> fVar = (c.b.a.m.q.c0.a) this.f332d.get(cls);
        if (fVar == null) {
            if (cls.equals(int[].class)) {
                fVar = new h();
            } else {
                if (!cls.equals(byte[].class)) {
                    StringBuilder sbR = c.a.a.a.a.r("No array pool found for: ");
                    sbR.append(cls.getSimpleName());
                    throw new IllegalArgumentException(sbR.toString());
                }
                fVar = new f();
            }
            this.f332d.put(cls, fVar);
        }
        return fVar;
    }

    public final <T> T i(a aVar, Class<T> cls) {
        c.b.a.m.q.c0.a<T> aVarH = h(cls);
        T t = (T) this.a.a(aVar);
        if (t != null) {
            this.f334f -= aVarH.a() * aVarH.b(t);
            f(aVarH.b(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(aVarH.getTag(), 2)) {
            aVarH.getTag();
        }
        return aVarH.newArray(aVar.f335b);
    }

    public final NavigableMap<Integer, Integer> j(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f331c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f331c.put(cls, treeMap);
        return treeMap;
    }
}
