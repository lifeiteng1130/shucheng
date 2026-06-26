package k.a.a.a.k0;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: ATNConfigSet.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements Set<k.a.a.a.k0.b>, j$.util.Set {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f8389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<k.a.a.a.k0.b> f8390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitSet f8392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8396i;

    /* JADX INFO: compiled from: ATNConfigSet.java */
    public static abstract class a extends k.a.a.a.m0.b<k.a.a.a.k0.b> {
        public a(k.a.a.a.m0.a<? super k.a.a.a.k0.b> aVar) {
            super(aVar, 16, 2);
        }

        @Override // k.a.a.a.m0.b
        public k.a.a.a.k0.b a(Object obj) {
            if (obj instanceof k.a.a.a.k0.b) {
                return (k.a.a.a.k0.b) obj;
            }
            return null;
        }

        @Override // k.a.a.a.m0.b
        public k.a.a.a.k0.b[] c(int i2) {
            return new k.a.a.a.k0.b[i2];
        }

        @Override // k.a.a.a.m0.b
        public k.a.a.a.k0.b[][] d(int i2) {
            return new k.a.a.a.k0.b[i2][];
        }
    }

    /* JADX INFO: compiled from: ATNConfigSet.java */
    public static final class b extends k.a.a.a.m0.a<k.a.a.a.k0.b> {
        public static final b a = new b();

        @Override // k.a.a.a.m0.a
        public boolean a(k.a.a.a.k0.b bVar, k.a.a.a.k0.b bVar2) {
            k.a.a.a.k0.b bVar3 = bVar;
            k.a.a.a.k0.b bVar4 = bVar2;
            if (bVar3 == bVar4) {
                return true;
            }
            return bVar3 != null && bVar4 != null && bVar3.a.f8432b == bVar4.a.f8432b && bVar3.f8383b == bVar4.f8383b && bVar3.f8386e.equals(bVar4.f8386e);
        }

        @Override // k.a.a.a.m0.a
        public int b(k.a.a.a.k0.b bVar) {
            k.a.a.a.k0.b bVar2 = bVar;
            return bVar2.f8386e.hashCode() + ((((bVar2.a.f8432b + 217) * 31) + bVar2.f8383b) * 31);
        }
    }

    /* JADX INFO: renamed from: k.a.a.a.k0.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ATNConfigSet.java */
    public static class C0225c extends a {
        public C0225c() {
            super(b.a);
        }
    }

    public c(boolean z) {
        this.a = false;
        this.f8390c = new ArrayList<>(7);
        this.f8396i = -1;
        this.f8389b = new C0225c();
        this.f8395h = z;
    }

    public boolean a(k.a.a.a.k0.b bVar) {
        b(bVar, null);
        return true;
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        a((k.a.a.a.k0.b) obj);
        return true;
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean addAll(Collection<? extends k.a.a.a.k0.b> collection) {
        Iterator<? extends k.a.a.a.k0.b> it = collection.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        return false;
    }

    public boolean b(k.a.a.a.k0.b bVar, k.a.a.a.m0.c<z0, z0, z0> cVar) {
        if (this.a) {
            throw new IllegalStateException("This set is readonly");
        }
        if (bVar.f8386e != h1.a) {
            this.f8393f = true;
        }
        if (bVar.b() > 0) {
            this.f8394g = true;
        }
        k.a.a.a.k0.b bVarF = this.f8389b.f(bVar);
        if (bVarF == bVar) {
            this.f8396i = -1;
            this.f8390c.add(bVar);
            return true;
        }
        z0 z0VarG = z0.g(bVarF.f8384c, bVar.f8384c, !this.f8395h, cVar);
        bVarF.f8385d = Math.max(bVarF.f8385d, bVar.f8385d);
        if (bVar.c()) {
            bVarF.d(true);
        }
        bVarF.f8384c = z0VarG;
        return true;
    }

    public BitSet c() {
        BitSet bitSet = new BitSet();
        Iterator<k.a.a.a.k0.b> it = this.f8390c.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().f8383b);
        }
        return bitSet;
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public void clear() {
        if (this.a) {
            throw new IllegalStateException("This set is readonly");
        }
        this.f8390c.clear();
        this.f8396i = -1;
        this.f8389b.clear();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean contains(Object obj) {
        a aVar = this.f8389b;
        if (aVar != null) {
            return aVar.b(aVar.a(obj));
        }
        throw new UnsupportedOperationException("This method is not implemented for readonly sets.");
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public void d(h hVar) {
        if (this.a) {
            throw new IllegalStateException("This set is readonly");
        }
        if (this.f8389b.isEmpty()) {
            return;
        }
        for (k.a.a.a.k0.b bVar : this.f8390c) {
            z0 z0VarB = bVar.f8384c;
            a1 a1Var = hVar.f8424c;
            if (a1Var != null) {
                synchronized (a1Var) {
                    z0VarB = z0.b(z0VarB, hVar.f8424c, new IdentityHashMap());
                }
            }
            bVar.f8384c = z0VarB;
        }
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        ArrayList<k.a.a.a.k0.b> arrayList = this.f8390c;
        return arrayList != null && arrayList.equals(cVar.f8390c) && this.f8395h == cVar.f8395h && this.f8391d == cVar.f8391d && this.f8392e == cVar.f8392e && this.f8393f == cVar.f8393f && this.f8394g == cVar.f8394g;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public int hashCode() {
        if (!this.a) {
            return this.f8390c.hashCode();
        }
        if (this.f8396i == -1) {
            this.f8396i = this.f8390c.hashCode();
        }
        return this.f8396i;
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean isEmpty() {
        return this.f8390c.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
    public Iterator<k.a.a.a.k0.b> iterator() {
        return this.f8390c.iterator();
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Q1.v(j$.time.a.A(this), true);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean retainAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public int size() {
        return this.f8390c.size();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Set.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return Q1.v(j$.time.a.A(this), false);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public Object[] toArray() {
        return this.f8389b.toArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8390c.toString());
        if (this.f8393f) {
            sb.append(",hasSemanticContext=");
            sb.append(this.f8393f);
        }
        if (this.f8391d != 0) {
            sb.append(",uniqueAlt=");
            sb.append(this.f8391d);
        }
        if (this.f8392e != null) {
            sb.append(",conflictingAlts=");
            sb.append(this.f8392e);
        }
        if (this.f8394g) {
            sb.append(",dipsIntoOuterContext");
        }
        return sb.toString();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f8389b.toArray(tArr);
    }

    public c() {
        this(true);
    }
}
