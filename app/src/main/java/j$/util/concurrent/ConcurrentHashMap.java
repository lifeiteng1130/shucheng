package j$.util.concurrent;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.umeng.analytics.pro.n;
import j$.C$r8$wrapper$java$util$function$Consumer$VWRP;
import j$.C0366i;
import j$.C0385t;
import j$.L;
import j$.Q0;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.Map;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.z;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import j$.w0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import org.mozilla.javascript.ES6Iterator;
import org.slf4j.helpers.MessageFormatter;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, j$.util.concurrent.b {
    static final int a = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Unsafe f7925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f7926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f7927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f7928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f7929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f7930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f7931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f7932i;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    volatile transient l[] f7933j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile transient l[] f7934k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile transient c[] f7935l;
    private transient i m;
    private transient u n;
    private transient e o;
    private volatile transient int sizeCtl;
    private volatile transient int transferIndex;

    static class a<K, V> extends p<K, V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final ConcurrentHashMap f7936i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        l f7937j;

        a(l[] lVarArr, int i2, int i3, int i4, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i2, i3, i4);
            this.f7936i = concurrentHashMap;
            a();
        }

        public final boolean hasMoreElements() {
            return this.f7950b != null;
        }

        public final boolean hasNext() {
            return this.f7950b != null;
        }

        public final void remove() {
            l lVar = this.f7937j;
            if (lVar == null) {
                throw new IllegalStateException();
            }
            this.f7937j = null;
            this.f7936i.i(lVar.f7944b, null, null);
        }
    }

    static final class c {
        volatile long value;

        c(long j2) {
            this.value = j2;
        }
    }

    static final class d<K, V> extends a<K, V> implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
        d(l[] lVarArr, int i2, int i3, int i4, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i2, i3, i4, concurrentHashMap);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Object next() {
            l lVar = this.f7950b;
            if (lVar == null) {
                throw new NoSuchElementException();
            }
            Object obj = lVar.f7944b;
            Object obj2 = lVar.f7945c;
            this.f7937j = lVar;
            a();
            return new k(obj, obj2, this.f7936i);
        }
    }

    static final class e<K, V> extends b<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>>, Serializable, j$.util.Set {
        e(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            return this.a.h(entry.getKey(), entry.getValue(), false) == null;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean addAll(Collection collection) {
            java.util.Iterator it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (add((Map.Entry) it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            Object value;
            return (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = this.a.get(key)) == null || (value = entry.getValue()) == null || (value != obj2 && !value.equals(obj2))) ? false : true;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            l[] lVarArr = this.a.f7933j;
            if (lVarArr == null) {
                return;
            }
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(new k(lVarA.f7944b, lVarA.f7945c, this.a));
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final int hashCode() {
            l[] lVarArr = this.a.f7933j;
            int iHashCode = 0;
            if (lVarArr != null) {
                p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
                while (true) {
                    l lVarA = pVar.a();
                    if (lVarA == null) {
                        break;
                    }
                    iHashCode += lVarA.hashCode();
                }
            }
            return iHashCode;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            l[] lVarArr = concurrentHashMap.f7933j;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new d(lVarArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && this.a.remove(key, value);
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            long jM = concurrentHashMap.m();
            l[] lVarArr = concurrentHashMap.f7933j;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new f(lVarArr, length, 0, length, jM >= 0 ? jM : 0L, concurrentHashMap);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public /* synthetic */ java.util.Spliterator spliterator() {
            return C0366i.a(spliterator());
        }
    }

    static final class f<K, V> extends p<K, V> implements Spliterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final ConcurrentHashMap f7938i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        long f7939j;

        f(l[] lVarArr, int i2, int i3, int i4, long j2, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i2, i3, i4);
            this.f7938i = concurrentHashMap;
            this.f7939j = j2;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l lVarA = a();
            if (lVarA == null) {
                return false;
            }
            consumer.accept(new k(lVarA.f7944b, lVarA.f7945c, this.f7938i));
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return n.a.f4935l;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.f7939j;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                l lVarA = a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(new k(lVarA.f7944b, lVarA.f7945c, this.f7938i));
                }
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i2) {
            return j$.time.a.h(this, i2);
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i2 = this.f7954f;
            int i3 = this.f7955g;
            int i4 = (i2 + i3) >>> 1;
            if (i4 <= i2) {
                return null;
            }
            l[] lVarArr = this.a;
            int i5 = this.f7956h;
            this.f7955g = i4;
            long j2 = this.f7939j >>> 1;
            this.f7939j = j2;
            return new f(lVarArr, i5, i4, i3, j2, this.f7938i);
        }
    }

    static final class g<K, V> extends l<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final l[] f7940e;

        g(l[] lVarArr) {
            super(-1, null, null, null);
            this.f7940e = lVarArr;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.l
        l a(int i2, Object obj) {
            int length;
            l lVarN;
            Object obj2;
            l[] lVarArr = this.f7940e;
            loop0: while (lVarArr != null && (length = lVarArr.length) != 0 && (lVarN = ConcurrentHashMap.n(lVarArr, (length - 1) & i2)) != null) {
                do {
                    int i3 = lVarN.a;
                    if (i3 == i2 && ((obj2 = lVarN.f7944b) == obj || (obj2 != null && obj.equals(obj2)))) {
                        return lVarN;
                    }
                    if (i3 >= 0) {
                        lVarN = lVarN.f7946d;
                    } else {
                        if (!(lVarN instanceof g)) {
                            return lVarN.a(i2, obj);
                        }
                        lVarArr = ((g) lVarN).f7940e;
                    }
                } while (lVarN != null);
            }
            return null;
        }
    }

    static final class h<K, V> extends a<K, V> implements java.util.Iterator<K>, Enumeration<K>, j$.util.Iterator {
        h(l[] lVarArr, int i2, int i3, int i4, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i2, i3, i4, concurrentHashMap);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public final Object next() {
            l lVar = this.f7950b;
            if (lVar == null) {
                throw new NoSuchElementException();
            }
            Object obj = lVar.f7944b;
            this.f7937j = lVar;
            a();
            return obj;
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            return next();
        }
    }

    public static class i<K, V> extends b<K, V, K> implements Set<K>, Serializable, j$.util.Set {
        i(ConcurrentHashMap concurrentHashMap, Object obj) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean contains(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            l[] lVarArr = this.a.f7933j;
            if (lVarArr == null) {
                return;
            }
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(lVarA.f7944b);
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public int hashCode() {
            Object it = iterator();
            int iHashCode = 0;
            while (((a) it).hasNext()) {
                iHashCode += ((h) it).next().hashCode();
            }
            return iHashCode;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            l[] lVarArr = concurrentHashMap.f7933j;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new h(lVarArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean remove(Object obj) {
            return this.a.remove(obj) != null;
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            long jM = concurrentHashMap.m();
            l[] lVarArr = concurrentHashMap.f7933j;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new j(lVarArr, length, 0, length, jM >= 0 ? jM : 0L);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public /* synthetic */ java.util.Spliterator spliterator() {
            return C0366i.a(spliterator());
        }
    }

    static final class j<K, V> extends p<K, V> implements Spliterator<K> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f7941i;

        j(l[] lVarArr, int i2, int i3, int i4, long j2) {
            super(lVarArr, i2, i3, i4);
            this.f7941i = j2;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l lVarA = a();
            if (lVarA == null) {
                return false;
            }
            consumer.accept(lVarA.f7944b);
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return n.a.f4935l;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.f7941i;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                l lVarA = a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(lVarA.f7944b);
                }
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i2) {
            return j$.time.a.h(this, i2);
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i2 = this.f7954f;
            int i3 = this.f7955g;
            int i4 = (i2 + i3) >>> 1;
            if (i4 <= i2) {
                return null;
            }
            l[] lVarArr = this.a;
            int i5 = this.f7956h;
            this.f7955g = i4;
            long j2 = this.f7941i >>> 1;
            this.f7941i = j2;
            return new j(lVarArr, i5, i4, i3, j2);
        }
    }

    static final class k<K, V> implements Map.Entry<K, V>, Map.Entry {
        final Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f7942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ConcurrentHashMap f7943c;

        k(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
            this.a = obj;
            this.f7942b = obj2;
            this.f7943c = concurrentHashMap;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            Object obj2;
            Object obj3;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.a) || key.equals(obj2)) && (value == (obj3 = this.f7942b) || value.equals(obj3));
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object getValue() {
            return this.f7942b;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.f7942b.hashCode();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object setValue(Object obj) {
            obj.getClass();
            Object obj2 = this.f7942b;
            this.f7942b = obj;
            this.f7943c.put(this.a, obj);
            return obj2;
        }

        public String toString() {
            return this.a + "=" + this.f7942b;
        }
    }

    static class l<K, V> implements Map.Entry<K, V>, Map.Entry {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f7944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile Object f7945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile l f7946d;

        l(int i2, Object obj, Object obj2, l lVar) {
            this.a = i2;
            this.f7944b = obj;
            this.f7945c = obj2;
            this.f7946d = lVar;
        }

        l a(int i2, Object obj) {
            Object obj2;
            l<K, V> lVar = this;
            do {
                if (lVar.a == i2 && ((obj2 = lVar.f7944b) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return lVar;
                }
                lVar = lVar.f7946d;
            } while (lVar != null);
            return null;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            Object obj2;
            Object obj3;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.f7944b) || key.equals(obj2)) && (value == (obj3 = this.f7945c) || value.equals(obj3));
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final Object getKey() {
            return this.f7944b;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final Object getValue() {
            return this.f7945c;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final int hashCode() {
            return this.f7944b.hashCode() ^ this.f7945c.hashCode();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final String toString() {
            return this.f7944b + "=" + this.f7945c;
        }
    }

    static final class m<K, V> extends l<K, V> {
        m() {
            super(-3, null, null, null);
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.l
        l a(int i2, Object obj) {
            return null;
        }
    }

    static class n<K, V> extends ReentrantLock implements Serializable {
        n(float f2) {
        }
    }

    static final class o<K, V> {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f7947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        l[] f7948c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        o f7949d;

        o() {
        }
    }

    static class p<K, V> {
        l[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        l f7950b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        o f7951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        o f7952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f7953e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f7954f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f7955g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final int f7956h;

        p(l[] lVarArr, int i2, int i3, int i4) {
            this.a = lVarArr;
            this.f7956h = i2;
            this.f7953e = i3;
            this.f7954f = i3;
            this.f7955g = i4;
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x0097 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x005f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final j$.util.concurrent.ConcurrentHashMap.l a() {
            /*
                r6 = this;
                j$.util.concurrent.ConcurrentHashMap$l r0 = r6.f7950b
                r1 = 0
                if (r0 == 0) goto L7
                j$.util.concurrent.ConcurrentHashMap$l r0 = r0.f7946d
            L7:
                if (r0 == 0) goto Lc
                r6.f7950b = r0
                return r0
            Lc:
                int r0 = r6.f7954f
                int r2 = r6.f7955g
                if (r0 >= r2) goto La8
                j$.util.concurrent.ConcurrentHashMap$l[] r0 = r6.a
                if (r0 == 0) goto La8
                int r2 = r0.length
                int r3 = r6.f7953e
                if (r2 <= r3) goto La8
                if (r3 >= 0) goto L1f
                goto La8
            L1f:
                j$.util.concurrent.ConcurrentHashMap$l r4 = j$.util.concurrent.ConcurrentHashMap.n(r0, r3)
                if (r4 == 0) goto L5a
                int r5 = r4.a
                if (r5 >= 0) goto L5a
                boolean r5 = r4 instanceof j$.util.concurrent.ConcurrentHashMap.g
                if (r5 == 0) goto L4f
                j$.util.concurrent.ConcurrentHashMap$g r4 = (j$.util.concurrent.ConcurrentHashMap.g) r4
                j$.util.concurrent.ConcurrentHashMap$l[] r4 = r4.f7940e
                r6.a = r4
                j$.util.concurrent.ConcurrentHashMap$o r4 = r6.f7952d
                if (r4 == 0) goto L3c
                j$.util.concurrent.ConcurrentHashMap$o r5 = r4.f7949d
                r6.f7952d = r5
                goto L41
            L3c:
                j$.util.concurrent.ConcurrentHashMap$o r4 = new j$.util.concurrent.ConcurrentHashMap$o
                r4.<init>()
            L41:
                r4.f7948c = r0
                r4.a = r2
                r4.f7947b = r3
                j$.util.concurrent.ConcurrentHashMap$o r0 = r6.f7951c
                r4.f7949d = r0
                r6.f7951c = r4
                r0 = r1
                goto L7
            L4f:
                boolean r0 = r4 instanceof j$.util.concurrent.ConcurrentHashMap.q
                if (r0 == 0) goto L58
                j$.util.concurrent.ConcurrentHashMap$q r4 = (j$.util.concurrent.ConcurrentHashMap.q) r4
                j$.util.concurrent.ConcurrentHashMap$r r0 = r4.f7960h
                goto L5b
            L58:
                r0 = r1
                goto L5b
            L5a:
                r0 = r4
            L5b:
                j$.util.concurrent.ConcurrentHashMap$o r4 = r6.f7951c
                if (r4 == 0) goto L97
            L5f:
                j$.util.concurrent.ConcurrentHashMap$o r3 = r6.f7951c
                if (r3 == 0) goto L82
                int r4 = r6.f7953e
                int r5 = r3.a
                int r4 = r4 + r5
                r6.f7953e = r4
                if (r4 < r2) goto L82
                int r2 = r3.f7947b
                r6.f7953e = r2
                j$.util.concurrent.ConcurrentHashMap$l[] r2 = r3.f7948c
                r6.a = r2
                r3.f7948c = r1
                j$.util.concurrent.ConcurrentHashMap$o r2 = r3.f7949d
                j$.util.concurrent.ConcurrentHashMap$o r4 = r6.f7952d
                r3.f7949d = r4
                r6.f7951c = r2
                r6.f7952d = r3
                r2 = r5
                goto L5f
            L82:
                if (r3 != 0) goto L7
                int r3 = r6.f7953e
                int r4 = r6.f7956h
                int r3 = r3 + r4
                r6.f7953e = r3
                if (r3 < r2) goto L7
                int r2 = r6.f7954f
                int r2 = r2 + 1
                r6.f7954f = r2
                r6.f7953e = r2
                goto L7
            L97:
                int r4 = r6.f7956h
                int r3 = r3 + r4
                r6.f7953e = r3
                if (r3 < r2) goto L7
                int r2 = r6.f7954f
                int r2 = r2 + 1
                r6.f7954f = r2
                r6.f7953e = r2
                goto L7
            La8:
                r6.f7950b = r1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.p.a():j$.util.concurrent.ConcurrentHashMap$l");
        }
    }

    static final class q<K, V> extends l<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Unsafe f7957e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final long f7958f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        r f7959g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile r f7960h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile Thread f7961i;
        volatile int lockState;

        static {
            try {
                Unsafe unsafeC = j$.util.concurrent.c.c();
                f7957e = unsafeC;
                f7958f = unsafeC.objectFieldOffset(q.class.getDeclaredField("lockState"));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        q(r rVar) {
            int iD;
            int iJ;
            super(-2, null, null, null);
            this.f7960h = rVar;
            r rVar2 = null;
            while (rVar != null) {
                r rVar3 = (r) rVar.f7946d;
                rVar.f7964g = null;
                rVar.f7963f = null;
                if (rVar2 == null) {
                    rVar.f7962e = null;
                    rVar.f7966i = false;
                } else {
                    Object obj = rVar.f7944b;
                    int i2 = rVar.a;
                    r rVar4 = rVar2;
                    Class clsC = null;
                    while (true) {
                        Object obj2 = rVar4.f7944b;
                        int i3 = rVar4.a;
                        iJ = i3 > i2 ? -1 : i3 < i2 ? 1 : ((clsC == null && (clsC = ConcurrentHashMap.c(obj)) == null) || (iD = ConcurrentHashMap.d(clsC, obj, obj2)) == 0) ? j(obj, obj2) : iD;
                        r rVar5 = iJ <= 0 ? rVar4.f7963f : rVar4.f7964g;
                        if (rVar5 == null) {
                            break;
                        } else {
                            rVar4 = rVar5;
                        }
                    }
                    rVar.f7962e = rVar4;
                    if (iJ <= 0) {
                        rVar4.f7963f = rVar;
                    } else {
                        rVar4.f7964g = rVar;
                    }
                    rVar = c(rVar2, rVar);
                }
                rVar2 = rVar;
                rVar = rVar3;
            }
            this.f7959g = rVar2;
        }

        static r b(r rVar, r rVar2) {
            while (rVar2 != null && rVar2 != rVar) {
                r rVar3 = rVar2.f7962e;
                if (rVar3 == null) {
                    rVar2.f7966i = false;
                    return rVar2;
                }
                if (rVar2.f7966i) {
                    rVar2.f7966i = false;
                    return rVar;
                }
                r rVar4 = rVar3.f7963f;
                r rVar5 = null;
                if (rVar4 == rVar2) {
                    rVar4 = rVar3.f7964g;
                    if (rVar4 != null && rVar4.f7966i) {
                        rVar4.f7966i = false;
                        rVar3.f7966i = true;
                        rVar = h(rVar, rVar3);
                        rVar3 = rVar2.f7962e;
                        rVar4 = rVar3 == null ? null : rVar3.f7964g;
                    }
                    if (rVar4 == null) {
                        rVar2 = rVar3;
                    } else {
                        r rVar6 = rVar4.f7963f;
                        r rVar7 = rVar4.f7964g;
                        if ((rVar7 == null || !rVar7.f7966i) && (rVar6 == null || !rVar6.f7966i)) {
                            rVar4.f7966i = true;
                            rVar2 = rVar3;
                        } else {
                            if (rVar7 == null || !rVar7.f7966i) {
                                if (rVar6 != null) {
                                    rVar6.f7966i = false;
                                }
                                rVar4.f7966i = true;
                                rVar = i(rVar, rVar4);
                                rVar3 = rVar2.f7962e;
                                if (rVar3 != null) {
                                    rVar5 = rVar3.f7964g;
                                }
                            } else {
                                rVar5 = rVar4;
                            }
                            if (rVar5 != null) {
                                rVar5.f7966i = rVar3 == null ? false : rVar3.f7966i;
                                r rVar8 = rVar5.f7964g;
                                if (rVar8 != null) {
                                    rVar8.f7966i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.f7966i = false;
                                rVar = h(rVar, rVar3);
                            }
                            rVar2 = rVar;
                            rVar = rVar2;
                        }
                    }
                } else {
                    if (rVar4 != null && rVar4.f7966i) {
                        rVar4.f7966i = false;
                        rVar3.f7966i = true;
                        rVar = i(rVar, rVar3);
                        rVar3 = rVar2.f7962e;
                        rVar4 = rVar3 == null ? null : rVar3.f7963f;
                    }
                    if (rVar4 == null) {
                        rVar2 = rVar3;
                    } else {
                        r rVar9 = rVar4.f7963f;
                        r rVar10 = rVar4.f7964g;
                        if ((rVar9 == null || !rVar9.f7966i) && (rVar10 == null || !rVar10.f7966i)) {
                            rVar4.f7966i = true;
                            rVar2 = rVar3;
                        } else {
                            if (rVar9 == null || !rVar9.f7966i) {
                                if (rVar10 != null) {
                                    rVar10.f7966i = false;
                                }
                                rVar4.f7966i = true;
                                rVar = h(rVar, rVar4);
                                rVar3 = rVar2.f7962e;
                                if (rVar3 != null) {
                                    rVar5 = rVar3.f7963f;
                                }
                            } else {
                                rVar5 = rVar4;
                            }
                            if (rVar5 != null) {
                                rVar5.f7966i = rVar3 == null ? false : rVar3.f7966i;
                                r rVar11 = rVar5.f7963f;
                                if (rVar11 != null) {
                                    rVar11.f7966i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.f7966i = false;
                                rVar = i(rVar, rVar3);
                            }
                            rVar2 = rVar;
                            rVar = rVar2;
                        }
                    }
                }
            }
            return rVar;
        }

        static r c(r rVar, r rVar2) {
            r rVar3;
            rVar2.f7966i = true;
            while (true) {
                r rVar4 = rVar2.f7962e;
                if (rVar4 == null) {
                    rVar2.f7966i = false;
                    return rVar2;
                }
                if (!rVar4.f7966i || (rVar3 = rVar4.f7962e) == null) {
                    break;
                }
                r rVar5 = rVar3.f7963f;
                if (rVar4 == rVar5) {
                    rVar5 = rVar3.f7964g;
                    if (rVar5 == null || !rVar5.f7966i) {
                        if (rVar2 == rVar4.f7964g) {
                            rVar = h(rVar, rVar4);
                            r rVar6 = rVar4.f7962e;
                            rVar3 = rVar6 == null ? null : rVar6.f7962e;
                            rVar4 = rVar6;
                            rVar2 = rVar4;
                        }
                        if (rVar4 != null) {
                            rVar4.f7966i = false;
                            if (rVar3 != null) {
                                rVar3.f7966i = true;
                                rVar = i(rVar, rVar3);
                            }
                        }
                    } else {
                        rVar5.f7966i = false;
                        rVar4.f7966i = false;
                        rVar3.f7966i = true;
                        rVar2 = rVar3;
                    }
                } else if (rVar5 == null || !rVar5.f7966i) {
                    if (rVar2 == rVar4.f7963f) {
                        rVar = i(rVar, rVar4);
                        r rVar7 = rVar4.f7962e;
                        rVar3 = rVar7 == null ? null : rVar7.f7962e;
                        rVar4 = rVar7;
                        rVar2 = rVar4;
                    }
                    if (rVar4 != null) {
                        rVar4.f7966i = false;
                        if (rVar3 != null) {
                            rVar3.f7966i = true;
                            rVar = h(rVar, rVar3);
                        }
                    }
                } else {
                    rVar5.f7966i = false;
                    rVar4.f7966i = false;
                    rVar3.f7966i = true;
                    rVar2 = rVar3;
                }
            }
            return rVar;
        }

        private final void d() {
            boolean z = false;
            while (true) {
                int i2 = this.lockState;
                if ((i2 & (-3)) == 0) {
                    if (f7957e.compareAndSwapInt(this, f7958f, i2, 1)) {
                        break;
                    }
                } else if ((i2 & 2) == 0) {
                    if (f7957e.compareAndSwapInt(this, f7958f, i2, i2 | 2)) {
                        z = true;
                        this.f7961i = Thread.currentThread();
                    }
                } else if (z) {
                    LockSupport.park(this);
                }
            }
            if (z) {
                this.f7961i = null;
            }
        }

        private final void e() {
            if (f7957e.compareAndSwapInt(this, f7958f, 0, 1)) {
                return;
            }
            d();
        }

        static r h(r rVar, r rVar2) {
            r rVar3 = rVar2.f7964g;
            if (rVar3 != null) {
                r rVar4 = rVar3.f7963f;
                rVar2.f7964g = rVar4;
                if (rVar4 != null) {
                    rVar4.f7962e = rVar2;
                }
                r rVar5 = rVar2.f7962e;
                rVar3.f7962e = rVar5;
                if (rVar5 == null) {
                    rVar3.f7966i = false;
                    rVar = rVar3;
                } else if (rVar5.f7963f == rVar2) {
                    rVar5.f7963f = rVar3;
                } else {
                    rVar5.f7964g = rVar3;
                }
                rVar3.f7963f = rVar2;
                rVar2.f7962e = rVar3;
            }
            return rVar;
        }

        static r i(r rVar, r rVar2) {
            r rVar3 = rVar2.f7963f;
            if (rVar3 != null) {
                r rVar4 = rVar3.f7964g;
                rVar2.f7963f = rVar4;
                if (rVar4 != null) {
                    rVar4.f7962e = rVar2;
                }
                r rVar5 = rVar2.f7962e;
                rVar3.f7962e = rVar5;
                if (rVar5 == null) {
                    rVar3.f7966i = false;
                    rVar = rVar3;
                } else if (rVar5.f7964g == rVar2) {
                    rVar5.f7964g = rVar3;
                } else {
                    rVar5.f7963f = rVar3;
                }
                rVar3.f7964g = rVar2;
                rVar2.f7962e = rVar3;
            }
            return rVar;
        }

        static int j(Object obj, Object obj2) {
            int iCompareTo;
            return (obj == null || obj2 == null || (iCompareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) ? System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1 : iCompareTo;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
        
            return r0;
         */
        @Override // j$.util.concurrent.ConcurrentHashMap.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final j$.util.concurrent.ConcurrentHashMap.l a(int r12, java.lang.Object r13) {
            /*
                r11 = this;
                j$.util.concurrent.ConcurrentHashMap$r r0 = r11.f7960h
            L2:
                r1 = 0
                if (r0 == 0) goto L5a
                int r6 = r11.lockState
                r2 = r6 & 3
                if (r2 == 0) goto L1f
                int r1 = r0.a
                if (r1 != r12) goto L1c
                java.lang.Object r1 = r0.f7944b
                if (r1 == r13) goto L1b
                if (r1 == 0) goto L1c
                boolean r1 = r13.equals(r1)
                if (r1 == 0) goto L1c
            L1b:
                return r0
            L1c:
                j$.util.concurrent.ConcurrentHashMap$l r0 = r0.f7946d
                goto L2
            L1f:
                sun.misc.Unsafe r8 = j$.util.concurrent.ConcurrentHashMap.q.f7957e
                long r9 = j$.util.concurrent.ConcurrentHashMap.q.f7958f
                int r7 = r6 + 4
                r2 = r8
                r3 = r11
                r4 = r9
                boolean r2 = r2.compareAndSwapInt(r3, r4, r6, r7)
                if (r2 == 0) goto L2
                r0 = 6
                r2 = -4
                j$.util.concurrent.ConcurrentHashMap$r r3 = r11.f7959g     // Catch: java.lang.Throwable -> L47
                if (r3 != 0) goto L35
                goto L39
            L35:
                j$.util.concurrent.ConcurrentHashMap$r r1 = r3.b(r12, r13, r1)     // Catch: java.lang.Throwable -> L47
            L39:
                int r12 = j$.util.concurrent.c.a(r8, r11, r9, r2)
                if (r12 != r0) goto L46
                java.lang.Thread r12 = r11.f7961i
                if (r12 == 0) goto L46
                java.util.concurrent.locks.LockSupport.unpark(r12)
            L46:
                return r1
            L47:
                r12 = move-exception
                sun.misc.Unsafe r13 = j$.util.concurrent.ConcurrentHashMap.q.f7957e
                long r3 = j$.util.concurrent.ConcurrentHashMap.q.f7958f
                int r13 = j$.util.concurrent.c.a(r13, r11, r3, r2)
                if (r13 != r0) goto L59
                java.lang.Thread r13 = r11.f7961i
                if (r13 == 0) goto L59
                java.util.concurrent.locks.LockSupport.unpark(r13)
            L59:
                throw r12
            L5a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.q.a(int, java.lang.Object):j$.util.concurrent.ConcurrentHashMap$l");
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        
            return r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
        
            return r10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final j$.util.concurrent.ConcurrentHashMap.r f(int r16, java.lang.Object r17, java.lang.Object r18) {
            /*
                r15 = this;
                r1 = r15
                r0 = r16
                r4 = r17
                j$.util.concurrent.ConcurrentHashMap$r r2 = r1.f7959g
                r8 = 0
                r9 = 0
                r10 = r2
                r2 = r8
                r3 = 0
            Lc:
                if (r10 != 0) goto L22
                j$.util.concurrent.ConcurrentHashMap$r r9 = new j$.util.concurrent.ConcurrentHashMap$r
                r6 = 0
                r7 = 0
                r2 = r9
                r3 = r16
                r4 = r17
                r5 = r18
                r2.<init>(r3, r4, r5, r6, r7)
                r1.f7959g = r9
                r1.f7960h = r9
                goto La3
            L22:
                int r5 = r10.a
                r11 = 1
                if (r5 <= r0) goto L2a
                r5 = -1
                r12 = -1
                goto L69
            L2a:
                if (r5 >= r0) goto L2e
                r12 = 1
                goto L69
            L2e:
                java.lang.Object r5 = r10.f7944b
                if (r5 == r4) goto Lab
                if (r5 == 0) goto L3c
                boolean r6 = r4.equals(r5)
                if (r6 == 0) goto L3c
                goto Lab
            L3c:
                if (r2 != 0) goto L44
                java.lang.Class r2 = j$.util.concurrent.ConcurrentHashMap.c(r17)
                if (r2 == 0) goto L4a
            L44:
                int r6 = j$.util.concurrent.ConcurrentHashMap.d(r2, r4, r5)
                if (r6 != 0) goto L68
            L4a:
                if (r3 != 0) goto L62
                j$.util.concurrent.ConcurrentHashMap$r r3 = r10.f7963f
                if (r3 == 0) goto L56
                j$.util.concurrent.ConcurrentHashMap$r r3 = r3.b(r0, r4, r2)
                if (r3 != 0) goto L60
            L56:
                j$.util.concurrent.ConcurrentHashMap$r r3 = r10.f7964g
                if (r3 == 0) goto L61
                j$.util.concurrent.ConcurrentHashMap$r r3 = r3.b(r0, r4, r2)
                if (r3 == 0) goto L61
            L60:
                return r3
            L61:
                r3 = 1
            L62:
                int r5 = j(r4, r5)
                r12 = r5
                goto L69
            L68:
                r12 = r6
            L69:
                if (r12 > 0) goto L6e
                j$.util.concurrent.ConcurrentHashMap$r r5 = r10.f7963f
                goto L70
            L6e:
                j$.util.concurrent.ConcurrentHashMap$r r5 = r10.f7964g
            L70:
                if (r5 != 0) goto La8
                j$.util.concurrent.ConcurrentHashMap$r r13 = r1.f7960h
                j$.util.concurrent.ConcurrentHashMap$r r14 = new j$.util.concurrent.ConcurrentHashMap$r
                r2 = r14
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r13
                r7 = r10
                r2.<init>(r3, r4, r5, r6, r7)
                r1.f7960h = r14
                if (r13 == 0) goto L88
                r13.f7965h = r14
            L88:
                if (r12 > 0) goto L8d
                r10.f7963f = r14
                goto L8f
            L8d:
                r10.f7964g = r14
            L8f:
                boolean r0 = r10.f7966i
                if (r0 != 0) goto L96
                r14.f7966i = r11
                goto La3
            L96:
                r15.e()
                j$.util.concurrent.ConcurrentHashMap$r r0 = r1.f7959g     // Catch: java.lang.Throwable -> La4
                j$.util.concurrent.ConcurrentHashMap$r r0 = c(r0, r14)     // Catch: java.lang.Throwable -> La4
                r1.f7959g = r0     // Catch: java.lang.Throwable -> La4
                r1.lockState = r9
            La3:
                return r8
            La4:
                r0 = move-exception
                r1.lockState = r9
                throw r0
            La8:
                r10 = r5
                goto Lc
            Lab:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.q.f(int, java.lang.Object, java.lang.Object):j$.util.concurrent.ConcurrentHashMap$r");
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x008b A[PHI: r0
  0x008b: PHI (r0v4 j$.util.concurrent.ConcurrentHashMap$r) = (r0v3 j$.util.concurrent.ConcurrentHashMap$r), (r0v12 j$.util.concurrent.ConcurrentHashMap$r) binds: [B:53:0x0087, B:49:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final boolean g(j$.util.concurrent.ConcurrentHashMap.r r11) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.q.g(j$.util.concurrent.ConcurrentHashMap$r):boolean");
        }
    }

    static final class r<K, V> extends l<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        r f7962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        r f7963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        r f7964g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        r f7965h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f7966i;

        r(int i2, Object obj, Object obj2, l lVar, r rVar) {
            super(i2, obj, obj2, lVar);
            this.f7962e = rVar;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.l
        l a(int i2, Object obj) {
            return b(i2, obj, null);
        }

        final r b(int i2, Object obj, Class cls) {
            int iD;
            if (obj == null) {
                return null;
            }
            r<K, V> rVar = this;
            do {
                r<K, V> rVar2 = rVar.f7963f;
                r<K, V> rVar3 = rVar.f7964g;
                int i3 = rVar.a;
                if (i3 <= i2) {
                    if (i3 >= i2) {
                        Object obj2 = rVar.f7944b;
                        if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                            return rVar;
                        }
                        if (rVar2 != null) {
                            if (rVar3 != null) {
                                if ((cls == null && (cls = ConcurrentHashMap.c(obj)) == null) || (iD = ConcurrentHashMap.d(cls, obj, obj2)) == 0) {
                                    r rVarB = rVar3.b(i2, obj, cls);
                                    if (rVarB != null) {
                                        return rVarB;
                                    }
                                } else if (iD < 0) {
                                }
                            }
                            rVar = rVar2;
                        }
                    }
                    rVar = rVar3;
                } else {
                    rVar = rVar2;
                }
            } while (rVar != null);
            return null;
        }
    }

    static final class s<K, V> extends a<K, V> implements java.util.Iterator<V>, Enumeration<V>, j$.util.Iterator {
        s(l[] lVarArr, int i2, int i3, int i4, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i2, i3, i4, concurrentHashMap);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public final Object next() {
            l lVar = this.f7950b;
            if (lVar == null) {
                throw new NoSuchElementException();
            }
            Object obj = lVar.f7945c;
            this.f7937j = lVar;
            a();
            return obj;
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            return next();
        }
    }

    static final class t<K, V> extends p<K, V> implements Spliterator<V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f7967i;

        t(l[] lVarArr, int i2, int i3, int i4, long j2) {
            super(lVarArr, i2, i3, i4);
            this.f7967i = j2;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l lVarA = a();
            if (lVarA == null) {
                return false;
            }
            consumer.accept(lVarA.f7945c);
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4352;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.f7967i;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                l lVarA = a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(lVarA.f7945c);
                }
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i2) {
            return j$.time.a.h(this, i2);
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i2 = this.f7954f;
            int i3 = this.f7955g;
            int i4 = (i2 + i3) >>> 1;
            if (i4 <= i2) {
                return null;
            }
            l[] lVarArr = this.a;
            int i5 = this.f7956h;
            this.f7955g = i4;
            long j2 = this.f7967i >>> 1;
            this.f7967i = j2;
            return new t(lVarArr, i5, i4, i3, j2);
        }
    }

    static final class u<K, V> extends b<K, V, V> implements Collection<V>, Serializable, j$.util.Collection {
        u(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean contains(Object obj) {
            return this.a.containsValue(obj);
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            l[] lVarArr = this.a.f7933j;
            if (lVarArr == null) {
                return;
            }
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(lVarA.f7945c);
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public final java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            l[] lVarArr = concurrentHashMap.f7933j;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new s(lVarArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean remove(Object obj) {
            a aVar;
            if (obj == null) {
                return false;
            }
            Object it = iterator();
            do {
                aVar = (a) it;
                if (!aVar.hasNext()) {
                    return false;
                }
            } while (!obj.equals(((s) it).next()));
            aVar.remove();
            return true;
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            long jM = concurrentHashMap.m();
            l[] lVarArr = concurrentHashMap.f7933j;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new t(lVarArr, length, 0, length, jM >= 0 ? jM : 0L);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public /* synthetic */ java.util.Spliterator spliterator() {
            return C0366i.a(spliterator());
        }
    }

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", n[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        try {
            Unsafe unsafeC = j$.util.concurrent.c.c();
            f7925b = unsafeC;
            f7926c = unsafeC.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("sizeCtl"));
            f7927d = unsafeC.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("transferIndex"));
            f7928e = unsafeC.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("baseCount"));
            f7929f = unsafeC.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("cellsBusy"));
            f7930g = unsafeC.objectFieldOffset(c.class.getDeclaredField(ES6Iterator.VALUE_PROPERTY));
            f7931h = unsafeC.arrayBaseOffset(l[].class);
            int iArrayIndexScale = unsafeC.arrayIndexScale(l[].class);
            if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
                throw new Error("data type scale not a power of two");
            }
            f7932i = 31 - Integer.numberOfLeadingZeros(iArrayIndexScale);
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.sizeCtl = i2 >= 536870912 ? BasicMeasure.EXACTLY : o(i2 + (i2 >>> 1) + 1);
    }

    public ConcurrentHashMap(int i2, float f2, int i3) {
        if (f2 <= 0.0f || i2 < 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        long j2 = (long) (((double) ((i2 < i3 ? i3 : i2) / f2)) + 1.0d);
        this.sizeCtl = j2 >= 1073741824 ? BasicMeasure.EXACTLY : o((int) j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(long r12, int r14) {
        /*
            r11 = this;
            j$.util.concurrent.ConcurrentHashMap$c[] r0 = r11.f7935l
            if (r0 != 0) goto L14
            sun.misc.Unsafe r1 = j$.util.concurrent.ConcurrentHashMap.f7925b
            long r3 = j$.util.concurrent.ConcurrentHashMap.f7928e
            long r5 = r11.baseCount
            long r9 = r5 + r12
            r2 = r11
            r7 = r9
            boolean r1 = r1.compareAndSwapLong(r2, r3, r5, r7)
            if (r1 != 0) goto L3b
        L14:
            r1 = 1
            if (r0 == 0) goto L94
            int r2 = r0.length
            int r2 = r2 - r1
            if (r2 < 0) goto L94
            int r3 = j$.util.concurrent.ThreadLocalRandom.b()
            r2 = r2 & r3
            r4 = r0[r2]
            if (r4 == 0) goto L94
            sun.misc.Unsafe r3 = j$.util.concurrent.ConcurrentHashMap.f7925b
            long r5 = j$.util.concurrent.ConcurrentHashMap.f7930g
            long r7 = r4.value
            long r9 = r7 + r12
            boolean r0 = r3.compareAndSwapLong(r4, r5, r7, r9)
            if (r0 != 0) goto L34
            r1 = r0
            goto L94
        L34:
            if (r14 > r1) goto L37
            return
        L37:
            long r9 = r11.m()
        L3b:
            if (r14 < 0) goto L93
        L3d:
            int r4 = r11.sizeCtl
            long r12 = (long) r4
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 < 0) goto L93
            j$.util.concurrent.ConcurrentHashMap$l[] r12 = r11.f7933j
            if (r12 == 0) goto L93
            int r13 = r12.length
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 >= r14) goto L93
            int r13 = j(r13)
            if (r4 >= 0) goto L7b
            int r14 = r4 >>> 16
            if (r14 != r13) goto L93
            int r14 = r13 + 1
            if (r4 == r14) goto L93
            r14 = 65535(0xffff, float:9.1834E-41)
            int r13 = r13 + r14
            if (r4 == r13) goto L93
            j$.util.concurrent.ConcurrentHashMap$l[] r13 = r11.f7934k
            if (r13 == 0) goto L93
            int r14 = r11.transferIndex
            if (r14 > 0) goto L6a
            goto L93
        L6a:
            sun.misc.Unsafe r0 = j$.util.concurrent.ConcurrentHashMap.f7925b
            long r2 = j$.util.concurrent.ConcurrentHashMap.f7926c
            int r5 = r4 + 1
            r1 = r11
            boolean r14 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r14 == 0) goto L8e
            r11.p(r12, r13)
            goto L8e
        L7b:
            sun.misc.Unsafe r0 = j$.util.concurrent.ConcurrentHashMap.f7925b
            long r2 = j$.util.concurrent.ConcurrentHashMap.f7926c
            int r13 = r13 << 16
            int r5 = r13 + 2
            r1 = r11
            boolean r13 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r13 == 0) goto L8e
            r13 = 0
            r11.p(r12, r13)
        L8e:
            long r9 = r11.m()
            goto L3d
        L93:
            return
        L94:
            r11.e(r12, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.a(long, int):void");
    }

    static final boolean b(l[] lVarArr, int i2, l lVar, l lVar2) {
        return f7925b.compareAndSwapObject(lVarArr, (((long) i2) << f7932i) + f7931h, (Object) null, lVar2);
    }

    static Class c(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls == String.class) {
            return cls;
        }
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null) {
            return null;
        }
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    return cls;
                }
            }
        }
        return null;
    }

    static int d(Class cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x009b, code lost:
    
        if (r24.f7935l != r7) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009d, code lost:
    
        r1 = new j$.util.concurrent.ConcurrentHashMap.c[r8 << 1];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        if (r2 >= r8) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a4, code lost:
    
        r1[r2] = r7[r2];
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
    
        r24.f7935l = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void e(long r25, boolean r27) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.e(long, boolean):void");
    }

    private final l[] g() {
        while (true) {
            l[] lVarArr = this.f7933j;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                Thread.yield();
            } else if (f7925b.compareAndSwapInt(this, f7926c, i2, -1)) {
                try {
                    l[] lVarArr2 = this.f7933j;
                    if (lVarArr2 == null || lVarArr2.length == 0) {
                        int i3 = i2 > 0 ? i2 : 16;
                        l[] lVarArr3 = new l[i3];
                        this.f7933j = lVarArr3;
                        i2 = i3 - (i3 >>> 2);
                        lVarArr2 = lVarArr3;
                    }
                    this.sizeCtl = i2;
                    return lVarArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i2;
                    throw th;
                }
            }
        }
    }

    static final int j(int i2) {
        return Integer.numberOfLeadingZeros(i2) | 32768;
    }

    static final void k(l[] lVarArr, int i2, l lVar) {
        f7925b.putObjectVolatile(lVarArr, (((long) i2) << f7932i) + f7931h, lVar);
    }

    static final int l(int i2) {
        return (i2 ^ (i2 >>> 16)) & Integer.MAX_VALUE;
    }

    static final l n(l[] lVarArr, int i2) {
        return (l) f7925b.getObjectVolatile(lVarArr, (((long) i2) << f7932i) + f7931h);
    }

    private static final int o(int i2) {
        int i3 = i2 - 1;
        int i4 = i3 | (i3 >>> 1);
        int i5 = i4 | (i4 >>> 2);
        int i6 = i5 | (i5 >>> 4);
        int i7 = i6 | (i6 >>> 8);
        int i8 = i7 | (i7 >>> 16);
        if (i8 < 0) {
            return 1;
        }
        return i8 >= 1073741824 ? BasicMeasure.EXACTLY : 1 + i8;
    }

    private final void p(l[] lVarArr, l[] lVarArr2) {
        l[] lVarArr3;
        ConcurrentHashMap<K, V> concurrentHashMap;
        l[] lVarArr4;
        int i2;
        int i3;
        g gVar;
        ConcurrentHashMap<K, V> concurrentHashMap2;
        int i4;
        int i5;
        l lVar;
        int i6;
        ConcurrentHashMap<K, V> concurrentHashMap3 = this;
        int length = lVarArr.length;
        int i7 = a;
        int i8 = i7 > 1 ? (length >>> 3) / i7 : length;
        int i9 = i8 < 16 ? 16 : i8;
        if (lVarArr2 == null) {
            try {
                l[] lVarArr5 = new l[length << 1];
                concurrentHashMap3.f7934k = lVarArr5;
                concurrentHashMap3.transferIndex = length;
                lVarArr3 = lVarArr5;
            } catch (Throwable unused) {
                concurrentHashMap3.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            lVarArr3 = lVarArr2;
        }
        int length2 = lVarArr3.length;
        g gVar2 = new g(lVarArr3);
        l[] lVarArr6 = lVarArr;
        ConcurrentHashMap<K, V> concurrentHashMap4 = concurrentHashMap3;
        int i10 = 0;
        int i11 = 0;
        boolean zB = true;
        boolean z = false;
        while (true) {
            if (zB) {
                int i12 = i10 - 1;
                if (i12 >= i11 || z) {
                    concurrentHashMap = concurrentHashMap4;
                    lVarArr4 = lVarArr6;
                    i10 = i12;
                    i11 = i11;
                    lVarArr6 = lVarArr4;
                    concurrentHashMap4 = concurrentHashMap;
                    zB = false;
                } else {
                    int i13 = concurrentHashMap4.transferIndex;
                    if (i13 <= 0) {
                        concurrentHashMap = concurrentHashMap4;
                        lVarArr4 = lVarArr6;
                        i10 = -1;
                    } else {
                        Unsafe unsafe = f7925b;
                        long j2 = f7927d;
                        int i14 = i13 > i9 ? i13 - i9 : 0;
                        concurrentHashMap = concurrentHashMap4;
                        lVarArr4 = lVarArr6;
                        int i15 = i11;
                        if (unsafe.compareAndSwapInt(this, j2, i13, i14)) {
                            i10 = i13 - 1;
                            i11 = i14;
                        } else {
                            lVarArr6 = lVarArr4;
                            i10 = i12;
                            i11 = i15;
                            concurrentHashMap4 = concurrentHashMap;
                        }
                    }
                    lVarArr6 = lVarArr4;
                    concurrentHashMap4 = concurrentHashMap;
                    zB = false;
                }
            } else {
                ConcurrentHashMap<K, V> concurrentHashMap5 = concurrentHashMap4;
                l[] lVarArr7 = lVarArr6;
                int i16 = i11;
                r rVar = null;
                l lVar2 = null;
                if (i10 < 0 || i10 >= length || (i5 = i10 + length) >= length2) {
                    i2 = i9;
                    i3 = length2;
                    gVar = gVar2;
                    if (z) {
                        this.f7934k = null;
                        this.f7933j = lVarArr3;
                        this.sizeCtl = (length << 1) - (length >>> 1);
                        return;
                    }
                    concurrentHashMap2 = this;
                    Unsafe unsafe2 = f7925b;
                    long j3 = f7926c;
                    int i17 = concurrentHashMap2.sizeCtl;
                    i4 = i10;
                    if (!unsafe2.compareAndSwapInt(this, j3, i17, i17 - 1)) {
                        lVarArr6 = lVarArr7;
                        concurrentHashMap4 = concurrentHashMap2;
                        i10 = i4;
                        gVar2 = gVar;
                        concurrentHashMap3 = concurrentHashMap2;
                        i11 = i16;
                        i9 = i2;
                        length2 = i3;
                    } else {
                        if (i17 - 2 != (j(length) << 16)) {
                            return;
                        }
                        i10 = length;
                        concurrentHashMap4 = concurrentHashMap2;
                        lVarArr6 = lVarArr7;
                        zB = true;
                        z = true;
                        gVar2 = gVar;
                        concurrentHashMap3 = concurrentHashMap2;
                        i11 = i16;
                        i9 = i2;
                        length2 = i3;
                    }
                } else {
                    l lVarN = n(lVarArr7, i10);
                    if (lVarN == null) {
                        zB = b(lVarArr7, i10, null, gVar2);
                        concurrentHashMap2 = concurrentHashMap3;
                        i2 = i9;
                        gVar = gVar2;
                        lVarArr6 = lVarArr7;
                        concurrentHashMap4 = concurrentHashMap5;
                    } else {
                        int i18 = lVarN.a;
                        if (i18 == -1) {
                            concurrentHashMap2 = concurrentHashMap3;
                            i2 = i9;
                            gVar = gVar2;
                            lVarArr6 = lVarArr7;
                            concurrentHashMap4 = concurrentHashMap5;
                            zB = true;
                        } else {
                            synchronized (lVarN) {
                                if (n(lVarArr7, i10) == lVarN) {
                                    if (i18 >= 0) {
                                        int i19 = i18 & length;
                                        l lVar3 = lVarN;
                                        for (l lVar4 = lVarN.f7946d; lVar4 != null; lVar4 = lVar4.f7946d) {
                                            int i20 = lVar4.a & length;
                                            if (i20 != i19) {
                                                lVar3 = lVar4;
                                                i19 = i20;
                                            }
                                        }
                                        if (i19 == 0) {
                                            lVar = lVar3;
                                        } else {
                                            lVar = null;
                                            lVar2 = lVar3;
                                        }
                                        l lVar5 = lVarN;
                                        while (lVar5 != lVar3) {
                                            int i21 = lVar5.a;
                                            l lVar6 = lVar3;
                                            Object obj = lVar5.f7944b;
                                            int i22 = i9;
                                            Object obj2 = lVar5.f7945c;
                                            if ((i21 & length) == 0) {
                                                i6 = length2;
                                                lVar = new l(i21, obj, obj2, lVar);
                                            } else {
                                                i6 = length2;
                                                lVar2 = new l(i21, obj, obj2, lVar2);
                                            }
                                            lVar5 = lVar5.f7946d;
                                            lVar3 = lVar6;
                                            i9 = i22;
                                            length2 = i6;
                                        }
                                        i2 = i9;
                                        i3 = length2;
                                        k(lVarArr3, i10, lVar);
                                        k(lVarArr3, i5, lVar2);
                                        k(lVarArr7, i10, gVar2);
                                        gVar = gVar2;
                                    } else {
                                        i2 = i9;
                                        i3 = length2;
                                        if (lVarN instanceof q) {
                                            q qVar = (q) lVarN;
                                            r rVar2 = null;
                                            r rVar3 = null;
                                            l lVar7 = qVar.f7960h;
                                            int i23 = 0;
                                            int i24 = 0;
                                            r rVar4 = null;
                                            while (lVar7 != null) {
                                                q qVar2 = qVar;
                                                int i25 = lVar7.a;
                                                g gVar3 = gVar2;
                                                r rVar5 = new r(i25, lVar7.f7944b, lVar7.f7945c, null, null);
                                                if ((i25 & length) == 0) {
                                                    rVar5.f7965h = rVar3;
                                                    if (rVar3 == null) {
                                                        rVar = rVar5;
                                                    } else {
                                                        rVar3.f7946d = rVar5;
                                                    }
                                                    i23++;
                                                    rVar3 = rVar5;
                                                } else {
                                                    rVar5.f7965h = rVar2;
                                                    if (rVar2 == null) {
                                                        rVar4 = rVar5;
                                                    } else {
                                                        rVar2.f7946d = rVar5;
                                                    }
                                                    i24++;
                                                    rVar2 = rVar5;
                                                }
                                                lVar7 = lVar7.f7946d;
                                                qVar = qVar2;
                                                gVar2 = gVar3;
                                            }
                                            q qVar3 = qVar;
                                            g gVar4 = gVar2;
                                            l lVarS = i23 <= 6 ? s(rVar) : i24 != 0 ? new q(rVar) : qVar3;
                                            l lVarS2 = i24 <= 6 ? s(rVar4) : i23 != 0 ? new q(rVar4) : qVar3;
                                            k(lVarArr3, i10, lVarS);
                                            k(lVarArr3, i5, lVarS2);
                                            gVar = gVar4;
                                            k(lVarArr, i10, gVar);
                                            lVarArr7 = lVarArr;
                                        }
                                    }
                                    zB = true;
                                } else {
                                    i2 = i9;
                                    i3 = length2;
                                }
                                gVar = gVar2;
                            }
                            i4 = i10;
                            lVarArr6 = lVarArr7;
                            concurrentHashMap2 = this;
                            concurrentHashMap4 = concurrentHashMap2;
                            i10 = i4;
                            gVar2 = gVar;
                            concurrentHashMap3 = concurrentHashMap2;
                            i11 = i16;
                            i9 = i2;
                            length2 = i3;
                        }
                    }
                    i3 = length2;
                    gVar2 = gVar;
                    concurrentHashMap3 = concurrentHashMap2;
                    i11 = i16;
                    i9 = i2;
                    length2 = i3;
                }
            }
        }
    }

    private final void q(l[] lVarArr, int i2) {
        int length = lVarArr.length;
        if (length < 64) {
            r(length << 1);
            return;
        }
        l lVarN = n(lVarArr, i2);
        if (lVarN == null || lVarN.a < 0) {
            return;
        }
        synchronized (lVarN) {
            if (n(lVarArr, i2) == lVarN) {
                r rVar = null;
                l lVar = lVarN;
                r rVar2 = null;
                while (lVar != null) {
                    r rVar3 = new r(lVar.a, lVar.f7944b, lVar.f7945c, null, null);
                    rVar3.f7965h = rVar2;
                    if (rVar2 == null) {
                        rVar = rVar3;
                    } else {
                        rVar2.f7946d = rVar3;
                    }
                    lVar = lVar.f7946d;
                    rVar2 = rVar3;
                }
                k(lVarArr, i2, new q(rVar));
            }
        }
    }

    private final void r(int i2) {
        int length;
        l[] lVarArr;
        int iO = i2 >= 536870912 ? BasicMeasure.EXACTLY : o(i2 + (i2 >>> 1) + 1);
        while (true) {
            int i3 = this.sizeCtl;
            if (i3 < 0) {
                return;
            }
            l[] lVarArr2 = this.f7933j;
            if (lVarArr2 == null || (length = lVarArr2.length) == 0) {
                int i4 = i3 > iO ? i3 : iO;
                if (f7925b.compareAndSwapInt(this, f7926c, i3, -1)) {
                    try {
                        if (this.f7933j == lVarArr2) {
                            this.f7933j = new l[i4];
                            i3 = i4 - (i4 >>> 2);
                        }
                    } finally {
                        this.sizeCtl = i3;
                    }
                } else {
                    continue;
                }
            } else {
                if (iO <= i3 || length >= 1073741824) {
                    return;
                }
                if (lVarArr2 == this.f7933j) {
                    int iJ = j(length);
                    if (i3 < 0) {
                        if ((i3 >>> 16) != iJ || i3 == iJ + 1 || i3 == iJ + 65535 || (lVarArr = this.f7934k) == null || this.transferIndex <= 0) {
                            return;
                        }
                        if (f7925b.compareAndSwapInt(this, f7926c, i3, i3 + 1)) {
                            p(lVarArr2, lVarArr);
                        }
                    } else if (f7925b.compareAndSwapInt(this, f7926c, i3, (iJ << 16) + 2)) {
                        p(lVarArr2, null);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        long j2;
        int iO;
        boolean z;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j3 = 0;
        long j4 = 0;
        l lVar = null;
        while (true) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            j2 = 1;
            if (object == null || object2 == null) {
                break;
            }
            j4++;
            lVar = new l(l(object.hashCode()), object, object2, lVar);
        }
        if (j4 == 0) {
            this.sizeCtl = 0;
            return;
        }
        if (j4 >= 536870912) {
            iO = BasicMeasure.EXACTLY;
        } else {
            int i2 = (int) j4;
            iO = o(i2 + (i2 >>> 1) + 1);
        }
        l[] lVarArr = new l[iO];
        int i3 = iO - 1;
        while (lVar != null) {
            l lVar2 = lVar.f7946d;
            int i4 = lVar.a;
            int i5 = i4 & i3;
            l lVarN = n(lVarArr, i5);
            if (lVarN == null) {
                z = true;
            } else {
                Object obj2 = lVar.f7944b;
                if (lVarN.a >= 0) {
                    int i6 = 0;
                    for (l lVar3 = lVarN; lVar3 != null; lVar3 = lVar3.f7946d) {
                        if (lVar3.a == i4 && ((obj = lVar3.f7944b) == obj2 || (obj != null && obj2.equals(obj)))) {
                            z = false;
                            break;
                        }
                        i6++;
                    }
                    z = true;
                    if (z && i6 >= 8) {
                        j3++;
                        lVar.f7946d = lVarN;
                        l lVar4 = lVar;
                        r rVar = null;
                        r rVar2 = null;
                        while (lVar4 != null) {
                            long j5 = j3;
                            r rVar3 = new r(lVar4.a, lVar4.f7944b, lVar4.f7945c, null, null);
                            rVar3.f7965h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.f7946d = rVar3;
                            }
                            lVar4 = lVar4.f7946d;
                            rVar2 = rVar3;
                            j3 = j5;
                        }
                        k(lVarArr, i5, new q(rVar));
                    }
                } else if (((q) lVarN).f(i4, obj2, lVar.f7945c) == null) {
                    j3 += j2;
                }
                z = false;
            }
            if (z) {
                j3++;
                lVar.f7946d = lVarN;
                k(lVarArr, i5, lVar);
            }
            j2 = 1;
            lVar = lVar2;
        }
        this.f7933j = lVarArr;
        this.sizeCtl = iO - (iO >>> 2);
        this.baseCount = j3;
    }

    static l s(l lVar) {
        l lVar2 = null;
        l lVar3 = null;
        while (lVar != null) {
            l lVar4 = new l(lVar.a, lVar.f7944b, lVar.f7945c, null);
            if (lVar3 == null) {
                lVar2 = lVar4;
            } else {
                lVar3.f7946d = lVar4;
            }
            lVar = lVar.f7946d;
            lVar3 = lVar4;
        }
        return lVar2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int i2 = 1;
        int i3 = 0;
        while (i2 < 16) {
            i3++;
            i2 <<= 1;
        }
        int i4 = 32 - i3;
        int i5 = i2 - 1;
        n[] nVarArr = new n[16];
        for (int i6 = 0; i6 < 16; i6++) {
            nVarArr[i6] = new n(0.75f);
        }
        objectOutputStream.putFields().put("segments", nVarArr);
        objectOutputStream.putFields().put("segmentShift", i4);
        objectOutputStream.putFields().put("segmentMask", i5);
        objectOutputStream.writeFields();
        l[] lVarArr = this.f7933j;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                objectOutputStream.writeObject(lVarA.f7944b);
                objectOutputStream.writeObject(lVarA.f7945c);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public void clear() {
        l lVarN;
        l[] lVarArrF = this.f7933j;
        long j2 = 0;
        loop0: while (true) {
            int i2 = 0;
            while (lVarArrF != null && i2 < lVarArrF.length) {
                lVarN = n(lVarArrF, i2);
                if (lVarN == null) {
                    i2++;
                } else {
                    int i3 = lVarN.a;
                    if (i3 == -1) {
                        break;
                    }
                    synchronized (lVarN) {
                        if (n(lVarArrF, i2) == lVarN) {
                            for (l lVar = i3 >= 0 ? lVarN : lVarN instanceof q ? ((q) lVarN).f7960h : null; lVar != null; lVar = lVar.f7946d) {
                                j2--;
                            }
                            k(lVarArrF, i2, null);
                            i2++;
                        }
                    }
                }
            }
            lVarArrF = f(lVarArrF, lVarN);
        }
        if (j2 != 0) {
            a(j2, -1);
        }
    }

    @Override // j$.util.Map
    public Object compute(Object obj, BiFunction biFunction) {
        int i2;
        l lVar;
        Object objApply;
        int i3;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int iL = l(obj.hashCode());
        l[] lVarArrG = this.f7933j;
        int i4 = 0;
        Object obj3 = null;
        int i5 = 0;
        while (true) {
            if (lVarArrG != null) {
                int length = lVarArrG.length;
                if (length != 0) {
                    int i6 = (length - 1) & iL;
                    l lVarN = n(lVarArrG, i6);
                    int i7 = 1;
                    if (lVarN == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            if (b(lVarArrG, i6, null, mVar)) {
                                try {
                                    Object objApply2 = biFunction.apply(obj, null);
                                    if (objApply2 != null) {
                                        lVar = new l(iL, obj, objApply2, null);
                                        i2 = 1;
                                    } else {
                                        i2 = i4;
                                        lVar = null;
                                    }
                                    k(lVarArrG, i6, lVar);
                                    i4 = i2;
                                    obj3 = objApply2;
                                    i5 = 1;
                                } catch (Throwable th) {
                                    k(lVarArrG, i6, null);
                                    throw th;
                                }
                            }
                        }
                        if (i5 != 0) {
                            break;
                        }
                    } else {
                        int i8 = lVarN.a;
                        if (i8 == -1) {
                            lVarArrG = f(lVarArrG, lVarN);
                        } else {
                            synchronized (lVarN) {
                                if (n(lVarArrG, i6) == lVarN) {
                                    if (i8 >= 0) {
                                        l lVar2 = null;
                                        l lVar3 = lVarN;
                                        i3 = 1;
                                        while (true) {
                                            if (lVar3.a == iL && ((obj2 = lVar3.f7944b) == obj || (obj2 != null && obj.equals(obj2)))) {
                                                break;
                                            }
                                            l lVar4 = lVar3.f7946d;
                                            if (lVar4 == null) {
                                                objApply = biFunction.apply(obj, null);
                                                if (objApply != null) {
                                                    lVar3.f7946d = new l(iL, obj, objApply, null);
                                                } else {
                                                    i5 = i3;
                                                    obj3 = objApply;
                                                }
                                            } else {
                                                i3++;
                                                lVar2 = lVar3;
                                                lVar3 = lVar4;
                                            }
                                        }
                                        Object objApply3 = biFunction.apply(obj, lVar3.f7945c);
                                        if (objApply3 != null) {
                                            lVar3.f7945c = objApply3;
                                            i5 = i3;
                                            obj3 = objApply3;
                                        } else {
                                            l lVar5 = lVar3.f7946d;
                                            if (lVar2 != null) {
                                                lVar2.f7946d = lVar5;
                                            } else {
                                                k(lVarArrG, i6, lVar5);
                                            }
                                            objApply = objApply3;
                                            i7 = i3;
                                            i5 = i7;
                                            obj3 = objApply;
                                            i4 = -1;
                                        }
                                    } else if (lVarN instanceof q) {
                                        q qVar = (q) lVarN;
                                        r rVar = qVar.f7959g;
                                        r rVarB = rVar != null ? rVar.b(iL, obj, null) : null;
                                        objApply = biFunction.apply(obj, rVarB == null ? null : rVarB.f7945c);
                                        if (objApply != null) {
                                            if (rVarB != null) {
                                                rVarB.f7945c = objApply;
                                            } else {
                                                qVar.f(iL, obj, objApply);
                                                i3 = 1;
                                                i5 = i3;
                                                obj3 = objApply;
                                                i4 = 1;
                                            }
                                        } else if (rVarB != null) {
                                            if (qVar.g(rVarB)) {
                                                k(lVarArrG, i6, s(qVar.f7960h));
                                            }
                                            i5 = i7;
                                            obj3 = objApply;
                                            i4 = -1;
                                        }
                                        obj3 = objApply;
                                        i5 = 1;
                                    }
                                }
                            }
                            if (i5 != 0) {
                                if (i5 >= 8) {
                                    q(lVarArrG, i6);
                                }
                            }
                        }
                    }
                }
            }
            lVarArrG = g();
        }
        if (i4 != 0) {
            a(i4, i5);
        }
        return obj3;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, C0385t.a(biFunction));
    }

    @Override // j$.util.Map
    public Object computeIfAbsent(Object obj, Function function) {
        r rVarB;
        Object obj2;
        if (obj == null || function == null) {
            throw null;
        }
        int iL = l(obj.hashCode());
        l[] lVarArrG = this.f7933j;
        Object objApply = null;
        int i2 = 0;
        while (true) {
            if (lVarArrG != null) {
                int length = lVarArrG.length;
                if (length != 0) {
                    int i3 = (length - 1) & iL;
                    l lVarN = n(lVarArrG, i3);
                    boolean z = true;
                    if (lVarN == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            if (b(lVarArrG, i3, null, mVar)) {
                                try {
                                    Object objApply2 = function.apply(obj);
                                    k(lVarArrG, i3, objApply2 != null ? new l(iL, obj, objApply2, null) : null);
                                    objApply = objApply2;
                                    i2 = 1;
                                } catch (Throwable th) {
                                    k(lVarArrG, i3, null);
                                    throw th;
                                }
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                    } else {
                        int i4 = lVarN.a;
                        if (i4 == -1) {
                            lVarArrG = f(lVarArrG, lVarN);
                        } else {
                            synchronized (lVarN) {
                                if (n(lVarArrG, i3) == lVarN) {
                                    if (i4 >= 0) {
                                        l lVar = lVarN;
                                        i2 = 1;
                                        while (true) {
                                            if (lVar.a == iL && ((obj2 = lVar.f7944b) == obj || (obj2 != null && obj.equals(obj2)))) {
                                                break;
                                            }
                                            l lVar2 = lVar.f7946d;
                                            if (lVar2 == null) {
                                                Object objApply3 = function.apply(obj);
                                                if (objApply3 != null) {
                                                    lVar.f7946d = new l(iL, obj, objApply3, null);
                                                    objApply = objApply3;
                                                } else {
                                                    objApply = objApply3;
                                                }
                                            } else {
                                                i2++;
                                                lVar = lVar2;
                                            }
                                        }
                                        objApply = lVar.f7945c;
                                    } else if (lVarN instanceof q) {
                                        q qVar = (q) lVarN;
                                        r rVar = qVar.f7959g;
                                        if (rVar == null || (rVarB = rVar.b(iL, obj, null)) == null) {
                                            objApply = function.apply(obj);
                                            if (objApply != null) {
                                                qVar.f(iL, obj, objApply);
                                                i2 = 2;
                                            }
                                        } else {
                                            objApply = rVarB.f7945c;
                                        }
                                        i2 = 2;
                                    }
                                }
                                z = false;
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    q(lVarArrG, i3);
                                }
                                if (!z) {
                                    return objApply;
                                }
                            }
                        }
                    }
                }
            }
            lVarArrG = g();
        }
        if (objApply != null) {
            a(1L, i2);
        }
        return objApply;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, L.a(function));
    }

    @Override // j$.util.Map
    public Object computeIfPresent(Object obj, BiFunction biFunction) {
        r rVarB;
        l lVarS;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int iL = l(obj.hashCode());
        l[] lVarArrG = this.f7933j;
        int i2 = 0;
        Object objApply = null;
        int i3 = 0;
        while (true) {
            if (lVarArrG != null) {
                int length = lVarArrG.length;
                if (length != 0) {
                    int i4 = (length - 1) & iL;
                    l lVarN = n(lVarArrG, i4);
                    if (lVarN == null) {
                        break;
                    }
                    int i5 = lVarN.a;
                    if (i5 == -1) {
                        lVarArrG = f(lVarArrG, lVarN);
                    } else {
                        synchronized (lVarN) {
                            if (n(lVarArrG, i4) == lVarN) {
                                if (i5 >= 0) {
                                    i3 = 1;
                                    l lVar = null;
                                    l lVar2 = lVarN;
                                    while (true) {
                                        if (lVar2.a == iL && ((obj2 = lVar2.f7944b) == obj || (obj2 != null && obj.equals(obj2)))) {
                                            break;
                                        }
                                        l lVar3 = lVar2.f7946d;
                                        if (lVar3 == null) {
                                            break;
                                        }
                                        i3++;
                                        lVar = lVar2;
                                        lVar2 = lVar3;
                                    }
                                    objApply = biFunction.apply(obj, lVar2.f7945c);
                                    if (objApply != null) {
                                        lVar2.f7945c = objApply;
                                    } else {
                                        lVarS = lVar2.f7946d;
                                        if (lVar != null) {
                                            lVar.f7946d = lVarS;
                                        } else {
                                            k(lVarArrG, i4, lVarS);
                                        }
                                        i2 = -1;
                                    }
                                } else if (lVarN instanceof q) {
                                    i3 = 2;
                                    q qVar = (q) lVarN;
                                    r rVar = qVar.f7959g;
                                    if (rVar != null && (rVarB = rVar.b(iL, obj, null)) != null) {
                                        objApply = biFunction.apply(obj, rVarB.f7945c);
                                        if (objApply != null) {
                                            rVarB.f7945c = objApply;
                                        } else {
                                            if (qVar.g(rVarB)) {
                                                lVarS = s(qVar.f7960h);
                                                k(lVarArrG, i4, lVarS);
                                            }
                                            i2 = -1;
                                        }
                                    }
                                }
                            }
                        }
                        if (i3 != 0) {
                            break;
                        }
                    }
                }
            }
            lVarArrG = g();
        }
        if (i2 != 0) {
            a(i2, i3);
        }
        return objApply;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, C0385t.a(biFunction));
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean containsValue(Object obj) {
        obj.getClass();
        l[] lVarArr = this.f7933j;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                Object obj2 = lVarA.f7945c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Set entrySet() {
        e eVar = this.o;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.o = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean equals(Object obj) {
        V value;
        Object obj2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof java.util.Map)) {
            return false;
        }
        java.util.Map map = (java.util.Map) obj;
        l[] lVarArr = this.f7933j;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (obj2 = get(key)) == null || (value != obj2 && !value.equals(obj2))) {
                        return false;
                    }
                }
                return true;
            }
            Object obj3 = lVarA.f7945c;
            Object obj4 = map.get(lVarA.f7944b);
            if (obj4 == null || (obj4 != obj3 && !obj4.equals(obj3))) {
                break;
            }
        }
        return false;
    }

    final l[] f(l[] lVarArr, l lVar) {
        l[] lVarArr2;
        int i2;
        if (!(lVar instanceof g) || (lVarArr2 = ((g) lVar).f7940e) == null) {
            return this.f7933j;
        }
        int iJ = j(lVarArr.length);
        while (true) {
            if (lVarArr2 != this.f7934k || this.f7933j != lVarArr || (i2 = this.sizeCtl) >= 0 || (i2 >>> 16) != iJ || i2 == iJ + 1 || i2 == 65535 + iJ || this.transferIndex <= 0) {
                break;
            }
            if (f7925b.compareAndSwapInt(this, f7926c, i2, i2 + 1)) {
                p(lVarArr, lVarArr2);
                break;
            }
        }
        return lVarArr2;
    }

    @Override // j$.util.concurrent.b, j$.util.Map
    public void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] lVarArr = this.f7933j;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                return;
            } else {
                biConsumer.accept(lVarA.f7944b, lVarA.f7945c);
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(j$.r.b(biConsumer));
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Object get(Object obj) {
        int length;
        l lVarN;
        Object obj2;
        int iL = l(obj.hashCode());
        l[] lVarArr = this.f7933j;
        if (lVarArr != null && (length = lVarArr.length) > 0 && (lVarN = n(lVarArr, (length - 1) & iL)) != null) {
            int i2 = lVarN.a;
            if (i2 == iL) {
                Object obj3 = lVarN.f7944b;
                if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                    return lVarN.f7945c;
                }
            } else if (i2 < 0) {
                l lVarA = lVarN.a(iL, obj);
                if (lVarA != null) {
                    return lVarA.f7945c;
                }
                return null;
            }
            while (true) {
                lVarN = lVarN.f7946d;
                if (lVarN == null) {
                    break;
                }
                if (lVarN.a == iL && ((obj2 = lVarN.f7944b) == obj || (obj2 != null && obj.equals(obj2)))) {
                    break;
                }
            }
            return lVarN.f7945c;
        }
        return null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? obj2 : obj3;
    }

    final Object h(Object obj, Object obj2, boolean z) {
        Object obj3;
        l lVarF;
        Object obj4;
        if (obj == null || obj2 == null) {
            throw null;
        }
        int iL = l(obj.hashCode());
        int i2 = 0;
        l[] lVarArrG = this.f7933j;
        while (true) {
            if (lVarArrG != null) {
                int length = lVarArrG.length;
                if (length != 0) {
                    int i3 = (length - 1) & iL;
                    l lVarN = n(lVarArrG, i3);
                    if (lVarN != null) {
                        int i4 = lVarN.a;
                        if (i4 == -1) {
                            lVarArrG = f(lVarArrG, lVarN);
                        } else {
                            synchronized (lVarN) {
                                if (n(lVarArrG, i3) == lVarN) {
                                    if (i4 >= 0) {
                                        i2 = 1;
                                        lVarF = lVarN;
                                        while (true) {
                                            if (lVarF.a == iL && ((obj4 = lVarF.f7944b) == obj || (obj4 != null && obj.equals(obj4)))) {
                                                break;
                                            }
                                            l lVar = lVarF.f7946d;
                                            if (lVar == null) {
                                                lVarF.f7946d = new l(iL, obj, obj2, null);
                                                break;
                                            }
                                            i2++;
                                            lVarF = lVar;
                                        }
                                        obj3 = lVarF.f7945c;
                                        if (!z) {
                                            lVarF.f7945c = obj2;
                                        }
                                    } else if (lVarN instanceof q) {
                                        i2 = 2;
                                        lVarF = ((q) lVarN).f(iL, obj, obj2);
                                        if (lVarF != null) {
                                            obj3 = lVarF.f7945c;
                                            if (!z) {
                                                lVarF.f7945c = obj2;
                                            }
                                        }
                                    }
                                }
                                obj3 = null;
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    q(lVarArrG, i3);
                                }
                                if (obj3 != null) {
                                    return obj3;
                                }
                            }
                        }
                    } else if (b(lVarArrG, i3, null, new l(iL, obj, obj2, null))) {
                        break;
                    }
                }
            }
            lVarArrG = g();
        }
        a(1L, i2);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public int hashCode() {
        l[] lVarArr = this.f7933j;
        int iHashCode = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                iHashCode += lVarA.f7945c.hashCode() ^ lVarA.f7944b.hashCode();
            }
        }
        return iHashCode;
    }

    final Object i(Object obj, Object obj2, Object obj3) {
        int length;
        int i2;
        l lVarN;
        boolean z;
        Object obj4;
        r rVarB;
        l lVarS;
        Object obj5;
        int iL = l(obj.hashCode());
        l[] lVarArrF = this.f7933j;
        while (true) {
            if (lVarArrF == null || (length = lVarArrF.length) == 0 || (lVarN = n(lVarArrF, (i2 = (length - 1) & iL))) == null) {
                break;
            }
            int i3 = lVarN.a;
            if (i3 == -1) {
                lVarArrF = f(lVarArrF, lVarN);
            } else {
                boolean z2 = false;
                synchronized (lVarN) {
                    z = true;
                    if (n(lVarArrF, i2) == lVarN) {
                        if (i3 >= 0) {
                            l lVar = null;
                            l lVar2 = lVarN;
                            while (true) {
                                if (lVar2.a == iL && ((obj5 = lVar2.f7944b) == obj || (obj5 != null && obj.equals(obj5)))) {
                                    break;
                                }
                                l lVar3 = lVar2.f7946d;
                                if (lVar3 == null) {
                                    break;
                                }
                                lVar = lVar2;
                                lVar2 = lVar3;
                            }
                            obj4 = lVar2.f7945c;
                            if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                if (obj2 != null) {
                                    lVar2.f7945c = obj2;
                                } else if (lVar != null) {
                                    lVar.f7946d = lVar2.f7946d;
                                } else {
                                    lVarS = lVar2.f7946d;
                                    k(lVarArrF, i2, lVarS);
                                }
                            }
                            z2 = true;
                        } else if (lVarN instanceof q) {
                            q qVar = (q) lVarN;
                            r rVar = qVar.f7959g;
                            if (rVar != null && (rVarB = rVar.b(iL, obj, null)) != null) {
                                obj4 = rVarB.f7945c;
                                if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                    if (obj2 != null) {
                                        rVarB.f7945c = obj2;
                                    } else if (qVar.g(rVarB)) {
                                        lVarS = s(qVar.f7960h);
                                        k(lVarArrF, i2, lVarS);
                                    }
                                }
                            }
                            z2 = true;
                        }
                    }
                    obj4 = null;
                    z = z2;
                }
                if (z) {
                    if (obj4 != null) {
                        if (obj2 == null) {
                            a(-1L, -1);
                        }
                        return obj4;
                    }
                }
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean isEmpty() {
        return m() <= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Set keySet() {
        i iVar = this.m;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this, null);
        this.m = iVar2;
        return iVar2;
    }

    final long m() {
        c[] cVarArr = this.f7935l;
        long j2 = this.baseCount;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j2 += cVar.value;
                }
            }
        }
        return j2;
    }

    @Override // j$.util.Map
    public Object merge(Object obj, Object obj2, BiFunction biFunction) {
        int i2;
        Object obj3;
        Object obj4 = obj2;
        if (obj == null || obj4 == null || biFunction == null) {
            throw null;
        }
        int iL = l(obj.hashCode());
        l[] lVarArrG = this.f7933j;
        int i3 = 0;
        Object obj5 = null;
        int i4 = 0;
        while (true) {
            if (lVarArrG != null) {
                int length = lVarArrG.length;
                if (length != 0) {
                    int i5 = (length - 1) & iL;
                    l lVarN = n(lVarArrG, i5);
                    i2 = 1;
                    if (lVarN != null) {
                        int i6 = lVarN.a;
                        if (i6 == -1) {
                            lVarArrG = f(lVarArrG, lVarN);
                        } else {
                            synchronized (lVarN) {
                                if (n(lVarArrG, i5) == lVarN) {
                                    if (i6 >= 0) {
                                        l lVar = null;
                                        l lVar2 = lVarN;
                                        int i7 = 1;
                                        while (true) {
                                            if (lVar2.a == iL && ((obj3 = lVar2.f7944b) == obj || (obj3 != null && obj.equals(obj3)))) {
                                                break;
                                            }
                                            l lVar3 = lVar2.f7946d;
                                            if (lVar3 == null) {
                                                lVar2.f7946d = new l(iL, obj, obj4, null);
                                                i3 = i7;
                                                i4 = 1;
                                                obj5 = obj4;
                                                break;
                                            }
                                            i7++;
                                            lVar = lVar2;
                                            lVar2 = lVar3;
                                        }
                                        Object objApply = biFunction.apply(lVar2.f7945c, obj4);
                                        if (objApply != null) {
                                            lVar2.f7945c = objApply;
                                            i3 = i7;
                                            obj5 = objApply;
                                        } else {
                                            l lVar4 = lVar2.f7946d;
                                            if (lVar != null) {
                                                lVar.f7946d = lVar4;
                                            } else {
                                                k(lVarArrG, i5, lVar4);
                                            }
                                            i3 = i7;
                                            obj5 = objApply;
                                            i4 = -1;
                                        }
                                    } else if (lVarN instanceof q) {
                                        i3 = 2;
                                        q qVar = (q) lVarN;
                                        r rVar = qVar.f7959g;
                                        r rVarB = rVar == null ? null : rVar.b(iL, obj, null);
                                        Object objApply2 = rVarB == null ? obj4 : biFunction.apply(rVarB.f7945c, obj4);
                                        if (objApply2 != null) {
                                            if (rVarB != null) {
                                                rVarB.f7945c = objApply2;
                                            } else {
                                                qVar.f(iL, obj, objApply2);
                                                obj5 = objApply2;
                                                i4 = 1;
                                            }
                                        } else if (rVarB != null) {
                                            if (qVar.g(rVarB)) {
                                                k(lVarArrG, i5, s(qVar.f7960h));
                                            }
                                            obj5 = objApply2;
                                            i4 = -1;
                                        }
                                        obj5 = objApply2;
                                    }
                                }
                            }
                            if (i3 != 0) {
                                if (i3 >= 8) {
                                    q(lVarArrG, i5);
                                }
                                i2 = i4;
                                obj4 = obj5;
                            }
                        }
                    } else if (b(lVarArrG, i5, null, new l(iL, obj, obj4, null))) {
                        break;
                    }
                }
            }
            lVarArrG = g();
        }
        if (i2 != 0) {
            a(i2, i3);
        }
        return obj4;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, C0385t.a(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Object put(Object obj, Object obj2) {
        return h(obj, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public void putAll(java.util.Map map) {
        r(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            h(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public Object putIfAbsent(Object obj, Object obj2) {
        return h(obj, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Object remove(Object obj) {
        return i(obj, null, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || i(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public Object replace(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw null;
        }
        return i(obj, obj2, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj == null || obj2 == null || obj3 == null) {
            throw null;
        }
        return i(obj, obj3, obj2) != null;
    }

    @Override // j$.util.Map
    public void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        l[] lVarArr = this.f7933j;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                return;
            }
            Object obj = lVarA.f7945c;
            Object obj2 = lVarA.f7944b;
            do {
                Object objApply = biFunction.apply(obj2, obj);
                objApply.getClass();
                if (i(obj2, objApply, obj) == null) {
                    obj = get(obj2);
                }
            } while (obj != null);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(C0385t.a(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public int size() {
        long jM = m();
        if (jM < 0) {
            return 0;
        }
        if (jM > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jM;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        l[] lVarArr = this.f7933j;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder();
        sb.append(MessageFormatter.DELIM_START);
        l lVarA = pVar.a();
        if (lVarA != null) {
            while (true) {
                Object obj = lVarA.f7944b;
                Object obj2 = lVarA.f7945c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                sb.append(',');
                sb.append(' ');
            }
        }
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Collection values() {
        u uVar = this.n;
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(this);
        this.n = uVar2;
        return uVar2;
    }

    static abstract class b<K, V, E> implements Collection<E>, Serializable, j$.util.Collection {
        final ConcurrentHashMap a;

        b(ConcurrentHashMap concurrentHashMap) {
            this.a = concurrentHashMap;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final void clear() {
            this.a.clear();
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public abstract boolean contains(Object obj);

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean containsAll(Collection collection) {
            if (collection == this) {
                return true;
            }
            for (E e2 : collection) {
                if (e2 == null || !contains(e2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public abstract java.util.Iterator iterator();

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Q1.v(j$.time.a.A(this), true);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream parallelStream() {
            return Q0.m0(Q1.v(j$.time.a.A(this), true));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean removeAll(Collection collection) {
            collection.getClass();
            java.util.Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // java.util.Collection
        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return Collection.CC.$default$removeIf(this, w0.c(predicate));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean retainAll(java.util.Collection collection) {
            collection.getClass();
            java.util.Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final int size() {
            return this.a.size();
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Q1.v(j$.time.a.A(this), false);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream stream() {
            return Q0.m0(Q1.v(j$.time.a.A(this), false));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final Object[] toArray() {
            long jM = this.a.m();
            if (jM < 0) {
                jM = 0;
            }
            if (jM > 2147483639) {
                throw new OutOfMemoryError("Required array size too large");
            }
            int i2 = (int) jM;
            Object[] objArrCopyOf = new Object[i2];
            int i3 = 0;
            for (Object obj : this) {
                if (i3 == i2) {
                    if (i2 >= 2147483639) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    int i4 = i2 < 1073741819 ? (i2 >>> 1) + 1 + i2 : 2147483639;
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                    i2 = i4;
                }
                objArrCopyOf[i3] = obj;
                i3++;
            }
            return i3 == i2 ? objArrCopyOf : Arrays.copyOf(objArrCopyOf, i3);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            java.util.Iterator it = iterator();
            if (it.hasNext()) {
                while (true) {
                    Object next = it.next();
                    if (next == this) {
                        next = "(this Collection)";
                    }
                    sb.append(next);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(',');
                    sb.append(' ');
                }
            }
            sb.append(']');
            return sb.toString();
        }

        @Override // j$.util.Collection
        public Object[] toArray(z zVar) {
            return toArray((Object[]) zVar.apply(0));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final Object[] toArray(Object[] objArr) {
            long jM = this.a.m();
            if (jM < 0) {
                jM = 0;
            }
            if (jM > 2147483639) {
                throw new OutOfMemoryError("Required array size too large");
            }
            int i2 = (int) jM;
            Object[] objArrCopyOf = objArr.length >= i2 ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
            int length = objArrCopyOf.length;
            int i3 = 0;
            for (Object obj : this) {
                if (i3 == length) {
                    if (length >= 2147483639) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    int i4 = length < 1073741819 ? (length >>> 1) + 1 + length : 2147483639;
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                    length = i4;
                }
                objArrCopyOf[i3] = obj;
                i3++;
            }
            if (objArr != objArrCopyOf || i3 >= length) {
                return i3 == length ? objArrCopyOf : Arrays.copyOf(objArrCopyOf, i3);
            }
            objArrCopyOf[i3] = null;
            return objArrCopyOf;
        }
    }
}
