package f.x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: _Arrays.kt */
/* JADX INFO: loaded from: classes3.dex */
public class e extends d {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: _Collections.kt */
    public static final class a<T> extends f.c0.c.k implements f.c0.b.l<Integer, T> {
        public final /* synthetic */ int $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(1);
            this.$index = i2;
        }

        public final T invoke(int i2) {
            throw new IndexOutOfBoundsException(c.a.a.a.a.n(c.a.a.a.a.r("Collection doesn't contain element at index "), this.$index, '.'));
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    public static final <T> void A(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        f.c0.c.j.e(tArr, "$this$sortWith");
        f.c0.c.j.e(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> B(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        f.c0.c.j.e(iterable, "$this$sortedWith");
        f.c0.c.j.e(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> listH = H(iterable);
            c.b.a.m.f.m5(listH, comparator);
            return listH;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return F(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        A(array, comparator);
        return b(array);
    }

    @NotNull
    public static final <T> List<T> C(@NotNull Iterable<? extends T> iterable, int i2) {
        f.c0.c.j.e(iterable, "$this$take");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(c.a.a.a.a.d("Requested element count ", i2, " is less than zero.").toString());
        }
        if (i2 == 0) {
            return i.INSTANCE;
        }
        if (i2 >= ((Collection) iterable).size()) {
            return F(iterable);
        }
        if (i2 == 1) {
            return c.b.a.m.f.P3(j(iterable));
        }
        ArrayList arrayList = new ArrayList(i2);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return w(arrayList);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void D() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C E(@NotNull Iterable<? extends T> iterable, @NotNull C c2) {
        f.c0.c.j.e(iterable, "$this$toCollection");
        f.c0.c.j.e(c2, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    @NotNull
    public static final <T> List<T> F(@NotNull Iterable<? extends T> iterable) {
        f.c0.c.j.e(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return w(H(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return i.INSTANCE;
        }
        if (size != 1) {
            return I(collection);
        }
        return c.b.a.m.f.P3(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M G(@NotNull Iterable<? extends f.g<? extends K, ? extends V>> iterable, @NotNull M m) {
        f.c0.c.j.e(iterable, "$this$toMap");
        f.c0.c.j.e(m, "destination");
        f.c0.c.j.e(m, "$this$putAll");
        f.c0.c.j.e(iterable, "pairs");
        for (f.g<? extends K, ? extends V> gVar : iterable) {
            m.put(gVar.component1(), gVar.component2());
        }
        return m;
    }

    @NotNull
    public static final <T> List<T> H(@NotNull Iterable<? extends T> iterable) {
        f.c0.c.j.e(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return I((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        E(iterable, arrayList);
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> I(@NotNull Collection<? extends T> collection) {
        f.c0.c.j.e(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V> Map<K, V> J(@NotNull Map<? extends K, ? extends V> map) {
        f.c0.c.j.e(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    @NotNull
    public static final <T> Set<T> K(@NotNull Iterable<? extends T> iterable) {
        f.c0.c.j.e(iterable, "$this$toSet");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return k.INSTANCE;
            }
            if (size != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(c.b.a.m.f.T3(collection.size()));
                E(iterable, linkedHashSet);
                return linkedHashSet;
            }
            Set<T> setSingleton = Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            f.c0.c.j.d(setSingleton, "java.util.Collections.singleton(element)");
            return setSingleton;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        E(iterable, linkedHashSet2);
        f.c0.c.j.e(linkedHashSet2, "$this$optimizeReadOnlySet");
        int size2 = linkedHashSet2.size();
        if (size2 == 0) {
            return k.INSTANCE;
        }
        if (size2 != 1) {
            return linkedHashSet2;
        }
        Set<T> setSingleton2 = Collections.singleton(linkedHashSet2.iterator().next());
        f.c0.c.j.d(setSingleton2, "java.util.Collections.singleton(element)");
        return setSingleton2;
    }

    @NotNull
    public static final <T> ArrayList<T> a(@NotNull T... tArr) {
        f.c0.c.j.e(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new c(tArr, true));
    }

    @NotNull
    public static final <T> List<T> b(@NotNull T[] tArr) {
        f.c0.c.j.e(tArr, "$this$asList");
        List<T> listAsList = Arrays.asList(tArr);
        f.c0.c.j.d(listAsList, "ArraysUtilJVM.asList(this)");
        return listAsList;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final byte[] c(@NotNull byte[] bArr, @NotNull byte[] bArr2, int i2, int i3, int i4) {
        f.c0.c.j.e(bArr, "$this$copyInto");
        f.c0.c.j.e(bArr2, "destination");
        System.arraycopy(bArr, i3, bArr2, i2, i4 - i3);
        return bArr2;
    }

    public static /* synthetic */ byte[] d(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = bArr.length;
        }
        c(bArr, bArr2, i2, i3, i4);
        return bArr2;
    }

    public static Object[] e(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        f.c0.c.j.e(objArr, "$this$copyInto");
        f.c0.c.j.e(objArr2, "destination");
        System.arraycopy(objArr, i3, objArr2, i2, i4 - i3);
        return objArr2;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final byte[] f(@NotNull byte[] bArr, int i2, int i3) {
        f.c0.c.j.e(bArr, "$this$copyOfRangeImpl");
        c.b.a.m.f.f1(i3, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i3);
        f.c0.c.j.d(bArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final <T> T[] g(@NotNull T[] tArr, int i2, int i3) {
        f.c0.c.j.e(tArr, "$this$copyOfRangeImpl");
        c.b.a.m.f.f1(i3, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i2, i3);
        f.c0.c.j.d(tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr2;
    }

    public static final <T> T h(@NotNull Iterable<? extends T> iterable, int i2) {
        f.c0.c.j.e(iterable, "$this$elementAt");
        boolean z = iterable instanceof List;
        if (z) {
            return (T) ((List) iterable).get(i2);
        }
        a aVar = new a(i2);
        f.c0.c.j.e(iterable, "$this$elementAtOrElse");
        f.c0.c.j.e(aVar, "defaultValue");
        if (z) {
            List list = (List) iterable;
            return (i2 < 0 || i2 > m(list)) ? aVar.invoke(Integer.valueOf(i2)) : (T) list.get(i2);
        }
        if (i2 < 0) {
            return aVar.invoke(Integer.valueOf(i2));
        }
        int i3 = 0;
        for (T t : iterable) {
            int i4 = i3 + 1;
            if (i2 == i3) {
                return t;
            }
            i3 = i4;
        }
        return aVar.invoke(Integer.valueOf(i2));
    }

    @NotNull
    public static final <K, V> Map<K, V> i() {
        j jVar = j.INSTANCE;
        Objects.requireNonNull(jVar, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        return jVar;
    }

    public static final <T> T j(@NotNull Iterable<? extends T> iterable) {
        f.c0.c.j.e(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) k((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T k(@NotNull List<? extends T> list) {
        f.c0.c.j.e(list, "$this$first");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    @Nullable
    public static final <T> T l(@NotNull List<? extends T> list) {
        f.c0.c.j.e(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> int m(@NotNull List<? extends T> list) {
        f.c0.c.j.e(list, "$this$lastIndex");
        return list.size() - 1;
    }

    @Nullable
    public static final <T> T n(@NotNull List<? extends T> list, int i2) {
        f.c0.c.j.e(list, "$this$getOrNull");
        if (i2 < 0 || i2 > m(list)) {
            return null;
        }
        return list.get(i2);
    }

    @NotNull
    public static final <T, A extends Appendable> A o(@NotNull Iterable<? extends T> iterable, @NotNull A a2, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable f.c0.b.l<? super T, ? extends CharSequence> lVar) throws IOException {
        f.c0.c.j.e(iterable, "$this$joinTo");
        f.c0.c.j.e(a2, "buffer");
        f.c0.c.j.e(charSequence, "separator");
        f.c0.c.j.e(charSequence2, "prefix");
        f.c0.c.j.e(charSequence3, "postfix");
        f.c0.c.j.e(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (T t : iterable) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            c.b.a.m.f.k0(a2, t, lVar);
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ Appendable p(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, f.c0.b.l lVar, int i3) throws IOException {
        int i4 = i3 & 64;
        o(iterable, appendable, (i3 & 2) != 0 ? ", " : charSequence, (i3 & 4) != 0 ? "" : null, (i3 & 8) != 0 ? "" : null, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : null, null);
        return appendable;
    }

    public static String q(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, f.c0.b.l lVar, int i3) throws IOException {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence7 = (i3 & 4) != 0 ? "" : charSequence3;
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        CharSequence charSequence8 = (i3 & 16) != 0 ? "..." : null;
        f.c0.b.l lVar2 = (i3 & 32) != 0 ? null : lVar;
        f.c0.c.j.e(iterable, "$this$joinToString");
        f.c0.c.j.e(charSequence5, "separator");
        f.c0.c.j.e(charSequence6, "prefix");
        f.c0.c.j.e(charSequence7, "postfix");
        f.c0.c.j.e(charSequence8, "truncated");
        StringBuilder sb = new StringBuilder();
        o(iterable, sb, charSequence5, charSequence6, charSequence7, i4, charSequence8, lVar2);
        String string = sb.toString();
        f.c0.c.j.d(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static final <T> T r(@NotNull List<? extends T> list) {
        f.c0.c.j.e(list, "$this$last");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(m(list));
    }

    @Nullable
    public static final <T> T s(@NotNull List<? extends T> list) {
        f.c0.c.j.e(list, "$this$lastOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    @NotNull
    public static final <K, V> LinkedHashMap<K, V> t(@NotNull f.g<? extends K, ? extends V>... gVarArr) {
        f.c0.c.j.e(gVarArr, "pairs");
        LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<>(c.b.a.m.f.T3(gVarArr.length));
        f.c0.c.j.e(gVarArr, "$this$toMap");
        f.c0.c.j.e(linkedHashMap, "destination");
        y(linkedHashMap, gVarArr);
        return linkedHashMap;
    }

    @NotNull
    public static final <T> List<T> u(@NotNull T... tArr) {
        f.c0.c.j.e(tArr, "elements");
        return tArr.length > 0 ? b(tArr) : i.INSTANCE;
    }

    @NotNull
    public static final <T> List<T> v(@NotNull T... tArr) {
        f.c0.c.j.e(tArr, "elements");
        f.c0.c.j.e(tArr, "$this$filterNotNull");
        ArrayList arrayList = new ArrayList();
        f.c0.c.j.e(tArr, "$this$filterNotNullTo");
        f.c0.c.j.e(arrayList, "destination");
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> w(@NotNull List<? extends T> list) {
        f.c0.c.j.e(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        return size != 0 ? size != 1 ? list : c.b.a.m.f.P3(list.get(0)) : i.INSTANCE;
    }

    @NotNull
    public static final <T> List<T> x(@NotNull Collection<? extends T> collection, @NotNull Iterable<? extends T> iterable) {
        f.c0.c.j.e(collection, "$this$plus");
        f.c0.c.j.e(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            c.b.a.m.f.S(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static final <K, V> void y(@NotNull Map<? super K, ? super V> map, @NotNull f.g<? extends K, ? extends V>[] gVarArr) {
        f.c0.c.j.e(map, "$this$putAll");
        f.c0.c.j.e(gVarArr, "pairs");
        for (f.g<? extends K, ? extends V> gVar : gVarArr) {
            map.put(gVar.component1(), gVar.component2());
        }
    }

    @NotNull
    public static final <T> List<T> z(@NotNull Iterable<? extends T> iterable) {
        f.c0.c.j.e(iterable, "$this$reversed");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return F(iterable);
        }
        List<T> listH = H(iterable);
        c.b.a.m.f.P4(listH);
        return listH;
    }
}
