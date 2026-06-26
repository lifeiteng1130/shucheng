package k.a.a.a.m0;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: FlexibleHashMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class d<K, V> implements Map<K, V>, j$.util.Map {
    public final k.a.a.a.m0.a<? super K> a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8504c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8505d = 12;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8506e = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedList<a<K, V>>[] f8503b = new LinkedList[8];

    /* JADX INFO: compiled from: FlexibleHashMap.java */
    public static class a<K, V> {
        public final K a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f8507b;

        public a(K k2, V v) {
            this.a = k2;
            this.f8507b = v;
        }

        public String toString() {
            return this.a.toString() + ":" + this.f8507b.toString();
        }
    }

    public d(k.a.a.a.m0.a<? super K> aVar) {
        this.a = aVar;
    }

    @Override // java.util.Map, j$.util.Map
    public void clear() {
        this.f8503b = new LinkedList[16];
        this.f8504c = 0;
    }

    @Override // j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // java.util.Map, j$.util.Map, java.util.AbstractMap
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map, j$.util.Map
    public boolean containsValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map, j$.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iB = this.a.b(obj);
        LinkedList<a<K, V>> linkedList = this.f8503b[iB & (r2.length - 1)];
        if (linkedList == null) {
            return null;
        }
        for (a<K, V> aVar : linkedList) {
            if (this.a.a(aVar.a, obj)) {
                return aVar.f8507b;
            }
        }
        return null;
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public int hashCode() {
        a<K, V> next;
        int iX5 = 0;
        for (LinkedList<a<K, V>> linkedList : this.f8503b) {
            if (linkedList != null) {
                Iterator<a<K, V>> it = linkedList.iterator();
                while (it.hasNext() && (next = it.next()) != null) {
                    iX5 = c.b.a.m.f.X5(iX5, this.a.b(next.a));
                }
            }
        }
        return c.b.a.m.f.I1(iX5, this.f8504c);
    }

    @Override // java.util.Map, j$.util.Map
    public boolean isEmpty() {
        return this.f8504c == 0;
    }

    @Override // java.util.Map, j$.util.Map
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public V put(K k2, V v) {
        a<K, V> next;
        if (k2 == null) {
            return null;
        }
        int i2 = this.f8504c;
        if (i2 > this.f8505d) {
            LinkedList<a<K, V>>[] linkedListArr = this.f8503b;
            this.f8506e += 4;
            int length = linkedListArr.length * 2;
            this.f8503b = new LinkedList[length];
            this.f8505d = (int) (((double) length) * 0.75d);
            for (LinkedList<a<K, V>> linkedList : linkedListArr) {
                if (linkedList != null) {
                    Iterator<a<K, V>> it = linkedList.iterator();
                    while (it.hasNext() && (next = it.next()) != null) {
                        put(next.a, next.f8507b);
                    }
                }
            }
            this.f8504c = i2;
        }
        int iB = this.a.b(k2);
        LinkedList<a<K, V>>[] linkedListArr2 = this.f8503b;
        int length2 = iB & (linkedListArr2.length - 1);
        LinkedList<a<K, V>> linkedList2 = linkedListArr2[length2];
        if (linkedList2 == null) {
            linkedList2 = new LinkedList<>();
            linkedListArr2[length2] = linkedList2;
        }
        for (a<K, V> aVar : linkedList2) {
            if (this.a.a(aVar.a, k2)) {
                V v2 = aVar.f8507b;
                aVar.f8507b = v;
                this.f8504c++;
                return v2;
            }
        }
        linkedList2.add(new a<>(k2, v));
        this.f8504c++;
        return null;
    }

    @Override // java.util.Map, j$.util.Map
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map, java.util.AbstractMap
    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.CC.$default$replace(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public int size() {
        return this.f8504c;
    }

    public String toString() {
        a<K, V> next;
        if (this.f8504c == 0) {
            return MessageFormatter.DELIM_STR;
        }
        StringBuilder sbQ = c.a.a.a.a.q(MessageFormatter.DELIM_START);
        boolean z = true;
        for (LinkedList<a<K, V>> linkedList : this.f8503b) {
            if (linkedList != null) {
                Iterator<a<K, V>> it = linkedList.iterator();
                while (it.hasNext() && (next = it.next()) != null) {
                    if (z) {
                        z = false;
                    } else {
                        sbQ.append(", ");
                    }
                    sbQ.append(next.toString());
                }
            }
        }
        sbQ.append(MessageFormatter.DELIM_STOP);
        return sbQ.toString();
    }

    @Override // java.util.Map, j$.util.Map
    public Collection<V> values() {
        ArrayList arrayList = new ArrayList(this.f8504c);
        for (LinkedList<a<K, V>> linkedList : this.f8503b) {
            if (linkedList != null) {
                Iterator<a<K, V>> it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().f8507b);
                }
            }
        }
        return arrayList;
    }
}
