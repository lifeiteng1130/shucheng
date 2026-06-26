package c.b.a.m.q.c0;

import androidx.annotation.Nullable;
import c.b.a.m.q.c0.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: GroupedLinkedMap.java */
/* JADX INFO: loaded from: classes.dex */
public class g<K extends l, V> {
    public final a<K, V> a = new a<>(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<K, a<K, V>> f326b = new HashMap();

    /* JADX INFO: compiled from: GroupedLinkedMap.java */
    public static class a<K, V> {
        public final K a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<V> f327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a<K, V> f328c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a<K, V> f329d;

        public a() {
            this(null);
        }

        @Nullable
        public V a() {
            List<V> list = this.f327b;
            int size = list != null ? list.size() : 0;
            if (size > 0) {
                return this.f327b.remove(size - 1);
            }
            return null;
        }

        public a(K k2) {
            this.f329d = this;
            this.f328c = this;
            this.a = k2;
        }
    }

    @Nullable
    public V a(K k2) {
        a<K, V> aVar = this.f326b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            this.f326b.put(k2, aVar);
        } else {
            k2.a();
        }
        a<K, V> aVar2 = aVar.f329d;
        aVar2.f328c = aVar.f328c;
        aVar.f328c.f329d = aVar2;
        a<K, V> aVar3 = this.a;
        aVar.f329d = aVar3;
        a<K, V> aVar4 = aVar3.f328c;
        aVar.f328c = aVar4;
        aVar4.f329d = aVar;
        aVar.f329d.f328c = aVar;
        return aVar.a();
    }

    public void b(K k2, V v) {
        a<K, V> aVar = this.f326b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            a<K, V> aVar2 = aVar.f329d;
            aVar2.f328c = aVar.f328c;
            aVar.f328c.f329d = aVar2;
            a<K, V> aVar3 = this.a;
            aVar.f329d = aVar3.f329d;
            aVar.f328c = aVar3;
            aVar3.f329d = aVar;
            aVar.f329d.f328c = aVar;
            this.f326b.put(k2, aVar);
        } else {
            k2.a();
        }
        if (aVar.f327b == null) {
            aVar.f327b = new ArrayList();
        }
        aVar.f327b.add(v);
    }

    @Nullable
    public V c() {
        for (a aVar = this.a.f329d; !aVar.equals(this.a); aVar = aVar.f329d) {
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            a<K, V> aVar2 = aVar.f329d;
            aVar2.f328c = aVar.f328c;
            aVar.f328c.f329d = aVar2;
            this.f326b.remove(aVar.a);
            ((l) aVar.a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.a.f328c; !aVar.equals(this.a); aVar = aVar.f328c) {
            z = true;
            sb.append(MessageFormatter.DELIM_START);
            sb.append(aVar.a);
            sb.append(':');
            List<V> list = aVar.f327b;
            sb.append(list != null ? list.size() : 0);
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
