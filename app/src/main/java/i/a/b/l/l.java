package i.a.b.l;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class l {
    public static final n<i.a.b.f> a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n<i.a.b.f> f6381b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n<i.a.b.c> f6382c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n<i.a.b.b> f6383d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n<Iterable<? extends Object>> f6384e = new e();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n<Enum<?>> f6385f = new f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n<Map<String, ? extends Object>> f6386g = new g();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n<Object> f6387h = new i.a.b.l.b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final n<Object> f6388i = new i.a.b.l.a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final n<Object> f6389j = new h();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, n<?>> f6390k = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinkedList<i> f6391l = new LinkedList<>();

    /* JADX INFO: compiled from: JsonWriter.java */
    public class a implements n<i.a.b.f> {
        @Override // i.a.b.l.n
        public void a(Object obj, Appendable appendable, i.a.b.g gVar) {
            ((i.a.b.f) obj).writeJSONString(appendable);
        }
    }

    /* JADX INFO: compiled from: JsonWriter.java */
    public class b implements n<i.a.b.f> {
        @Override // i.a.b.l.n
        public void a(Object obj, Appendable appendable, i.a.b.g gVar) {
            ((i.a.b.f) obj).writeJSONString(appendable, gVar);
        }
    }

    /* JADX INFO: compiled from: JsonWriter.java */
    public class c implements n<i.a.b.c> {
        @Override // i.a.b.l.n
        public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
            appendable.append(((i.a.b.c) obj).toJSONString(gVar));
        }
    }

    /* JADX INFO: compiled from: JsonWriter.java */
    public class d implements n<i.a.b.b> {
        @Override // i.a.b.l.n
        public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
            appendable.append(((i.a.b.b) obj).toJSONString());
        }
    }

    /* JADX INFO: compiled from: JsonWriter.java */
    public class e implements n<Iterable<? extends Object>> {
        @Override // i.a.b.l.n
        public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
            Objects.requireNonNull(gVar);
            appendable.append('[');
            boolean z = true;
            for (Object obj2 : (Iterable) obj) {
                if (z) {
                    z = false;
                } else {
                    appendable.append(',');
                }
                if (obj2 == null) {
                    appendable.append("null");
                } else {
                    i.a.b.i.b(obj2, appendable, gVar);
                }
            }
            appendable.append(']');
        }
    }

    /* JADX INFO: compiled from: JsonWriter.java */
    public class f implements n<Enum<?>> {
        @Override // i.a.b.l.n
        public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
            gVar.a(appendable, ((Enum) obj).name());
        }
    }

    /* JADX INFO: compiled from: JsonWriter.java */
    public class g implements n<Map<String, ? extends Object>> {
        @Override // i.a.b.l.n
        public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
            Objects.requireNonNull(gVar);
            appendable.append(MessageFormatter.DELIM_START);
            boolean z = true;
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object value = entry.getValue();
                if (value != null || !gVar.f6356f) {
                    if (z) {
                        z = false;
                    } else {
                        appendable.append(',');
                    }
                    l.b(entry.getKey().toString(), value, appendable, gVar);
                }
            }
            appendable.append(MessageFormatter.DELIM_STOP);
        }
    }

    /* JADX INFO: compiled from: JsonWriter.java */
    public class h implements n<Object> {
        @Override // i.a.b.l.n
        public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
            appendable.append(obj.toString());
        }
    }

    /* JADX INFO: compiled from: JsonWriter.java */
    public static class i {
        public Class<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public n<?> f6392b;

        public i(Class<?> cls, n<?> nVar) {
            this.a = cls;
            this.f6392b = nVar;
        }
    }

    public l() {
        a(new m(this), String.class);
        a(new i.a.b.l.c(this), Double.class);
        a(new i.a.b.l.d(this), Date.class);
        a(new i.a.b.l.e(this), Float.class);
        n<Object> nVar = f6389j;
        a(nVar, Integer.class, Long.class, Byte.class, Short.class, BigInteger.class, BigDecimal.class);
        a(nVar, Boolean.class);
        a(new i.a.b.l.f(this), int[].class);
        a(new i.a.b.l.g(this), short[].class);
        a(new i.a.b.l.h(this), long[].class);
        a(new i.a.b.l.i(this), float[].class);
        a(new j(this), double[].class);
        a(new k(this), boolean[].class);
        this.f6391l.addLast(new i(i.a.b.f.class, f6381b));
        this.f6391l.addLast(new i(i.a.b.e.class, a));
        this.f6391l.addLast(new i(i.a.b.c.class, f6382c));
        this.f6391l.addLast(new i(i.a.b.b.class, f6383d));
        this.f6391l.addLast(new i(Map.class, f6386g));
        this.f6391l.addLast(new i(Iterable.class, f6384e));
        this.f6391l.addLast(new i(Enum.class, f6385f));
        this.f6391l.addLast(new i(Number.class, nVar));
    }

    public static void b(String str, Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
        if (str == null) {
            appendable.append("null");
        } else if (gVar.f6357g.a(str)) {
            appendable.append('\"');
            i.a.b.i.a(str, appendable, gVar);
            appendable.append('\"');
        } else {
            appendable.append(str);
        }
        appendable.append(':');
        if (obj instanceof String) {
            gVar.a(appendable, (String) obj);
        } else {
            i.a.b.i.b(obj, appendable, gVar);
        }
    }

    public <T> void a(n<T> nVar, Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.f6390k.put(cls, nVar);
        }
    }
}
