package f.c0.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ClassReference.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements f.f0.c<Object>, c {
    public static final Map<Class<?>, Integer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, String> f6122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, String> f6123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, String> f6124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final Class<?> f6125e;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Map<Class<?>, Integer> mapI;
        List listU = f.x.e.u(f.c0.b.a.class, f.c0.b.l.class, f.c0.b.p.class, f.c0.b.q.class, f.c0.b.r.class, f.c0.b.s.class, f.c0.b.t.class, f.c0.b.u.class, f.c0.b.v.class, f.c0.b.w.class, f.c0.b.b.class, f.c0.b.c.class, f.c0.b.d.class, f.c0.b.e.class, f.c0.b.f.class, f.c0.b.g.class, f.c0.b.h.class, f.c0.b.i.class, f.c0.b.j.class, f.c0.b.k.class, f.c0.b.m.class, f.c0.b.n.class, f.c0.b.o.class);
        ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(listU, 10));
        int i2 = 0;
        for (Object obj : listU) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                f.x.e.D();
                throw null;
            }
            arrayList.add(new f.g((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        j.e(arrayList, "$this$toMap");
        int size = arrayList.size();
        if (size == 0) {
            mapI = f.x.e.i();
        } else if (size != 1) {
            mapI = new LinkedHashMap<>(c.b.a.m.f.T3(arrayList.size()));
            f.x.e.G(arrayList, mapI);
        } else {
            mapI = c.b.a.m.f.U3((f.g) arrayList.get(0));
        }
        a = mapI;
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f6122b = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f6123c = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        j.d(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            j.d(str, "kotlinName");
            sb.append(f.h0.k.N(str, '.', str));
            sb.append("CompanionObject");
            f.g gVar = new f.g(sb.toString(), c.a.a.a.a.i(str, ".Companion"));
            map3.put(gVar.getFirst(), gVar.getSecond());
        }
        for (Map.Entry<Class<?>, Integer> entry : a.entrySet()) {
            Class<?> key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            map3.put(key.getName(), "kotlin.Function" + iIntValue);
        }
        f6124d = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(c.b.a.m.f.T3(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            Object key2 = entry2.getKey();
            String str2 = (String) entry2.getValue();
            linkedHashMap.put(key2, f.h0.k.N(str2, '.', str2));
        }
    }

    public d(@NotNull Class<?> cls) {
        j.e(cls, "jClass");
        this.f6125e = cls;
    }

    @Override // f.c0.c.c
    @NotNull
    public Class<?> a() {
        return this.f6125e;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof d) && j.a(c.b.a.m.f.y2(this), c.b.a.m.f.y2((f.f0.c) obj));
    }

    public int hashCode() {
        return c.b.a.m.f.y2(this).hashCode();
    }

    @NotNull
    public String toString() {
        return this.f6125e.toString() + " (Kotlin reflection is not available)";
    }
}
