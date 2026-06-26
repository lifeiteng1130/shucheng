package k.a.a.a.k0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SemanticContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h1 {
    public static final h1 a = new e();

    /* JADX INFO: compiled from: SemanticContext.java */
    public static class a extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h1[] f8426b;

        public a(h1 h1Var, h1 h1Var2) {
            HashSet hashSet = new HashSet();
            if (h1Var instanceof a) {
                hashSet.addAll(Arrays.asList(((a) h1Var).f8426b));
            } else {
                hashSet.add(h1Var);
            }
            if (h1Var2 instanceof a) {
                hashSet.addAll(Arrays.asList(((a) h1Var2).f8426b));
            } else {
                hashSet.add(h1Var2);
            }
            List listA = h1.a(hashSet);
            if (!listA.isEmpty()) {
                hashSet.add((d) Collections.min(listA));
            }
            this.f8426b = (h1[]) hashSet.toArray(new h1[hashSet.size()]);
        }

        @Override // k.a.a.a.k0.h1
        public boolean c(k.a.a.a.b0<?, ?> b0Var, k.a.a.a.c0 c0Var) {
            for (h1 h1Var : this.f8426b) {
                if (!h1Var.c(b0Var, c0Var)) {
                    return false;
                }
            }
            return true;
        }

        @Override // k.a.a.a.k0.h1
        public h1 d(k.a.a.a.b0<?, ?> b0Var, k.a.a.a.c0 c0Var) {
            ArrayList arrayList = new ArrayList();
            h1[] h1VarArr = this.f8426b;
            int length = h1VarArr.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= length) {
                    if (i3 == 0) {
                        return this;
                    }
                    if (arrayList.isEmpty()) {
                        return h1.a;
                    }
                    h1 h1VarB = (h1) arrayList.get(0);
                    while (i < arrayList.size()) {
                        h1VarB = h1.b(h1VarB, (h1) arrayList.get(i));
                        i++;
                    }
                    return h1VarB;
                }
                h1 h1Var = h1VarArr[i2];
                h1 h1VarD = h1Var.d(b0Var, c0Var);
                i3 |= h1VarD == h1Var ? 0 : 1;
                if (h1VarD == null) {
                    return null;
                }
                if (h1VarD != h1.a) {
                    arrayList.add(h1VarD);
                }
                i2++;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return Arrays.equals(this.f8426b, ((a) obj).f8426b);
            }
            return false;
        }

        public int hashCode() {
            return c.b.a.m.f.g3(this.f8426b, a.class.hashCode());
        }

        public String toString() {
            return c.b.a.m.f.J3(Arrays.asList(this.f8426b).iterator(), "&&");
        }
    }

    /* JADX INFO: compiled from: SemanticContext.java */
    public static class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h1[] f8427b;

        public b(h1 h1Var, h1 h1Var2) {
            HashSet hashSet = new HashSet();
            if (h1Var instanceof b) {
                hashSet.addAll(Arrays.asList(((b) h1Var).f8427b));
            } else {
                hashSet.add(h1Var);
            }
            if (h1Var2 instanceof b) {
                hashSet.addAll(Arrays.asList(((b) h1Var2).f8427b));
            } else {
                hashSet.add(h1Var2);
            }
            List listA = h1.a(hashSet);
            if (!listA.isEmpty()) {
                hashSet.add((d) Collections.max(listA));
            }
            this.f8427b = (h1[]) hashSet.toArray(new h1[hashSet.size()]);
        }

        @Override // k.a.a.a.k0.h1
        public boolean c(k.a.a.a.b0<?, ?> b0Var, k.a.a.a.c0 c0Var) {
            for (h1 h1Var : this.f8427b) {
                if (h1Var.c(b0Var, c0Var)) {
                    return true;
                }
            }
            return false;
        }

        @Override // k.a.a.a.k0.h1
        public h1 d(k.a.a.a.b0<?, ?> b0Var, k.a.a.a.c0 c0Var) {
            ArrayList arrayList = new ArrayList();
            h1[] h1VarArr = this.f8427b;
            int length = h1VarArr.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= length) {
                    if (i3 == 0) {
                        return this;
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    h1 h1VarE = (h1) arrayList.get(0);
                    while (i < arrayList.size()) {
                        h1VarE = h1.e(h1VarE, (h1) arrayList.get(i));
                        i++;
                    }
                    return h1VarE;
                }
                h1 h1Var = h1VarArr[i2];
                h1 h1VarD = h1Var.d(b0Var, c0Var);
                i3 |= h1VarD == h1Var ? 0 : 1;
                h1 h1Var2 = h1.a;
                if (h1VarD == h1Var2) {
                    return h1Var2;
                }
                if (h1VarD != null) {
                    arrayList.add(h1VarD);
                }
                i2++;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return Arrays.equals(this.f8427b, ((b) obj).f8427b);
            }
            return false;
        }

        public int hashCode() {
            return c.b.a.m.f.g3(this.f8427b, b.class.hashCode());
        }

        public String toString() {
            return c.b.a.m.f.J3(Arrays.asList(this.f8427b).iterator(), "||");
        }
    }

    /* JADX INFO: compiled from: SemanticContext.java */
    public static abstract class c extends h1 {
    }

    public static List a(Collection collection) {
        Iterator it = collection.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            h1 h1Var = (h1) it.next();
            if (h1Var instanceof d) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((d) h1Var);
                it.remove();
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    public static h1 b(h1 h1Var, h1 h1Var2) {
        h1 h1Var3;
        if (h1Var == null || h1Var == (h1Var3 = a)) {
            return h1Var2;
        }
        if (h1Var2 == null || h1Var2 == h1Var3) {
            return h1Var;
        }
        a aVar = new a(h1Var, h1Var2);
        h1[] h1VarArr = aVar.f8426b;
        return h1VarArr.length == 1 ? h1VarArr[0] : aVar;
    }

    public static h1 e(h1 h1Var, h1 h1Var2) {
        if (h1Var == null) {
            return h1Var2;
        }
        if (h1Var2 == null) {
            return h1Var;
        }
        h1 h1Var3 = a;
        h1 h1Var4 = h1Var3;
        h1Var4 = h1Var3;
        if (h1Var != h1Var3 && h1Var2 != h1Var3) {
            b bVar = new b(h1Var, h1Var2);
            h1[] h1VarArr = bVar.f8427b;
            h1Var4 = bVar;
            if (h1VarArr.length == 1) {
                return h1VarArr[0];
            }
        }
        return h1Var4;
    }

    public abstract boolean c(k.a.a.a.b0<?, ?> b0Var, k.a.a.a.c0 c0Var);

    public h1 d(k.a.a.a.b0<?, ?> b0Var, k.a.a.a.c0 c0Var) {
        return this;
    }

    /* JADX INFO: compiled from: SemanticContext.java */
    public static class d extends h1 implements Comparable<d> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8428b;

        public d() {
            this.f8428b = 0;
        }

        @Override // k.a.a.a.k0.h1
        public boolean c(k.a.a.a.b0<?, ?> b0Var, k.a.a.a.c0 c0Var) {
            return b0Var.precpred(c0Var, this.f8428b);
        }

        @Override // java.lang.Comparable
        public int compareTo(d dVar) {
            return this.f8428b - dVar.f8428b;
        }

        @Override // k.a.a.a.k0.h1
        public h1 d(k.a.a.a.b0<?, ?> b0Var, k.a.a.a.c0 c0Var) {
            if (b0Var.precpred(c0Var, this.f8428b)) {
                return h1.a;
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this == obj || this.f8428b == ((d) obj).f8428b;
            }
            return false;
        }

        public int hashCode() {
            return 31 + this.f8428b;
        }

        public String toString() {
            return c.a.a.a.a.o(c.a.a.a.a.r("{"), this.f8428b, ">=prec}?");
        }

        public d(int i2) {
            this.f8428b = i2;
        }
    }

    /* JADX INFO: compiled from: SemanticContext.java */
    public static class e extends h1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8430c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f8431d;

        public e() {
            this.f8429b = -1;
            this.f8430c = -1;
            this.f8431d = false;
        }

        @Override // k.a.a.a.k0.h1
        public boolean c(k.a.a.a.b0<?, ?> b0Var, k.a.a.a.c0 c0Var) {
            if (!this.f8431d) {
                c0Var = null;
            }
            return b0Var.sempred(c0Var, this.f8429b, this.f8430c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            e eVar = (e) obj;
            return this.f8429b == eVar.f8429b && this.f8430c == eVar.f8430c && this.f8431d == eVar.f8431d;
        }

        public int hashCode() {
            return c.b.a.m.f.I1(c.b.a.m.f.X5(c.b.a.m.f.X5(c.b.a.m.f.X5(0, this.f8429b), this.f8430c), this.f8431d ? 1 : 0), 3);
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("{");
            sbR.append(this.f8429b);
            sbR.append(":");
            return c.a.a.a.a.o(sbR, this.f8430c, "}?");
        }

        public e(int i2, int i3, boolean z) {
            this.f8429b = i2;
            this.f8430c = i3;
            this.f8431d = z;
        }
    }
}
