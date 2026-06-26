package org.jsoup.nodes;

import j$.lang.Iterable;
import j$.time.a;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.Map;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import j$.util.v;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;

/* JADX INFO: loaded from: classes3.dex */
public class Attributes implements Iterable<Attribute>, Cloneable, Iterable {
    private static final String[] Empty = new String[0];
    private static final String EmptyString = "";
    private static final int GrowthFactor = 2;
    private static final int InitialCapacity = 2;
    public static final char InternalPrefix = '/';
    public static final int NotFound = -1;
    public static final String dataPrefix = "data-";
    public String[] keys;
    private int size = 0;
    public String[] vals;

    /* JADX INFO: renamed from: org.jsoup.nodes.Attributes$1, reason: invalid class name */
    public class AnonymousClass1 implements Iterator<Attribute>, j$.util.Iterator {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8938i = 0;

        public AnonymousClass1() {
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            while (this.f8938i < Attributes.this.size) {
                Attributes attributes = Attributes.this;
                if (!attributes.isInternalKey(attributes.keys[this.f8938i])) {
                    break;
                }
                this.f8938i++;
            }
            return this.f8938i < Attributes.this.size;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            Attributes attributes = Attributes.this;
            int i2 = this.f8938i - 1;
            this.f8938i = i2;
            attributes.remove(i2);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Attribute next() {
            Attributes attributes = Attributes.this;
            String[] strArr = attributes.keys;
            int i2 = this.f8938i;
            Attribute attribute = new Attribute(strArr[i2], attributes.vals[i2], attributes);
            this.f8938i++;
            return attribute;
        }
    }

    public static class Dataset extends AbstractMap<String, String> implements Map {
        private final Attributes attributes;

        public class DatasetIterator implements java.util.Iterator<Map.Entry<String, String>>, j$.util.Iterator {
            private Attribute attr;
            private java.util.Iterator<Attribute> attrIter;

            private DatasetIterator() {
                this.attrIter = Dataset.this.attributes.iterator();
            }

            @Override // j$.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                while (this.attrIter.hasNext()) {
                    Attribute next = this.attrIter.next();
                    this.attr = next;
                    if (next.isDataAttribute()) {
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public void remove() {
                Dataset.this.attributes.remove(this.attr.getKey());
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public Map.Entry<String, String> next() {
                return new Attribute(this.attr.getKey().substring(5), this.attr.getValue());
            }

            public /* synthetic */ DatasetIterator(Dataset dataset, AnonymousClass1 anonymousClass1) {
                this();
            }
        }

        public class EntrySet extends AbstractSet<Map.Entry<String, String>> implements Set {
            private EntrySet() {
            }

            @Override // j$.util.Collection, j$.lang.Iterable
            public /* synthetic */ void forEach(Consumer consumer) {
                Iterable.CC.$default$forEach(this, consumer);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Set, j$.util.Collection, j$.lang.Iterable
            public java.util.Iterator<Map.Entry<String, String>> iterator() {
                return new DatasetIterator(Dataset.this, null);
            }

            @Override // java.util.Collection, j$.util.Collection
            public /* synthetic */ Stream parallelStream() {
                return Q1.v(a.A(this), true);
            }

            @Override // j$.util.Collection
            public /* synthetic */ boolean removeIf(Predicate predicate) {
                return Collection.CC.$default$removeIf(this, predicate);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, j$.util.Set, j$.util.Collection
            public int size() {
                int i2 = 0;
                while (new DatasetIterator(Dataset.this, null).hasNext()) {
                    i2++;
                }
                return i2;
            }

            @Override // java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Set, j$.util.Collection, j$.lang.Iterable
            public /* synthetic */ Spliterator spliterator() {
                return Set.CC.$default$spliterator(this);
            }

            @Override // java.util.Collection, j$.util.Collection
            public /* synthetic */ Stream stream() {
                return Q1.v(a.A(this), false);
            }

            public /* synthetic */ EntrySet(Dataset dataset, AnonymousClass1 anonymousClass1) {
                this();
            }
        }

        public /* synthetic */ Dataset(Attributes attributes, AnonymousClass1 anonymousClass1) {
            this(attributes);
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

        @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
        public java.util.Set<Map.Entry<String, String>> entrySet() {
            return new EntrySet(this, null);
        }

        @Override // j$.util.Map
        public /* synthetic */ void forEach(BiConsumer biConsumer) {
            Map.CC.$default$forEach(this, biConsumer);
        }

        @Override // java.util.Map, j$.util.Map
        public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return Map.CC.$default$getOrDefault(this, obj, obj2);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
            return Map.CC.$default$merge(this, obj, obj2, biFunction);
        }

        @Override // java.util.Map, j$.util.Map
        public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
            return Map.CC.$default$putIfAbsent(this, obj, obj2);
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

        private Dataset(Attributes attributes) {
            this.attributes = attributes;
        }

        @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
        public String put(String str, String str2) {
            String strDataKey = Attributes.dataKey(str);
            String str3 = this.attributes.hasKey(strDataKey) ? this.attributes.get(strDataKey) : null;
            this.attributes.put(strDataKey, str2);
            return str3;
        }
    }

    public Attributes() {
        String[] strArr = Empty;
        this.keys = strArr;
        this.vals = strArr;
    }

    private void checkCapacity(int i2) {
        Validate.isTrue(i2 >= this.size);
        String[] strArr = this.keys;
        int length = strArr.length;
        if (length >= i2) {
            return;
        }
        int i3 = length >= 2 ? this.size * 2 : 2;
        if (i2 <= i3) {
            i2 = i3;
        }
        this.keys = copyOf(strArr, i2);
        this.vals = copyOf(this.vals, i2);
    }

    public static String checkNotNull(String str) {
        return str == null ? "" : str;
    }

    private static String[] copyOf(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i2));
        return strArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String dataKey(String str) {
        return c.a.a.a.a.i(dataPrefix, str);
    }

    private int indexOfKeyIgnoreCase(String str) {
        Validate.notNull(str);
        for (int i2 = 0; i2 < this.size; i2++) {
            if (str.equalsIgnoreCase(this.keys[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public static String internalKey(String str) {
        return InternalPrefix + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalKey(String str) {
        return str != null && str.length() > 1 && str.charAt(0) == '/';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remove(int i2) {
        Validate.isFalse(i2 >= this.size);
        int i3 = (this.size - i2) - 1;
        if (i3 > 0) {
            String[] strArr = this.keys;
            int i4 = i2 + 1;
            System.arraycopy(strArr, i4, strArr, i2, i3);
            String[] strArr2 = this.vals;
            System.arraycopy(strArr2, i4, strArr2, i2, i3);
        }
        int i5 = this.size - 1;
        this.size = i5;
        this.keys[i5] = null;
        this.vals[i5] = null;
    }

    public Attributes add(String str, String str2) {
        checkCapacity(this.size + 1);
        String[] strArr = this.keys;
        int i2 = this.size;
        strArr[i2] = str;
        this.vals[i2] = str2;
        this.size = i2 + 1;
        return this;
    }

    public void addAll(Attributes attributes) {
        if (attributes.size() == 0) {
            return;
        }
        checkCapacity(this.size + attributes.size);
        java.util.Iterator<Attribute> it = attributes.iterator();
        while (it.hasNext()) {
            put(it.next());
        }
    }

    public List<Attribute> asList() {
        ArrayList arrayList = new ArrayList(this.size);
        for (int i2 = 0; i2 < this.size; i2++) {
            if (!isInternalKey(this.keys[i2])) {
                arrayList.add(new Attribute(this.keys[i2], this.vals[i2], this));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public java.util.Map<String, String> dataset() {
        return new Dataset(this, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int deduplicate(org.jsoup.parser.ParseSettings r7) {
        /*
            r6 = this;
            boolean r0 = r6.isEmpty()
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            boolean r7 = r7.preserveAttributeCase()
            r0 = 0
        Ld:
            java.lang.String[] r2 = r6.keys
            int r2 = r2.length
            if (r1 >= r2) goto L45
            int r2 = r1 + 1
            r3 = r2
        L15:
            java.lang.String[] r4 = r6.keys
            int r5 = r4.length
            if (r3 >= r5) goto L43
            r5 = r4[r3]
            if (r5 != 0) goto L1f
            goto L43
        L1f:
            if (r7 == 0) goto L2b
            r5 = r4[r1]
            r4 = r4[r3]
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L39
        L2b:
            if (r7 != 0) goto L40
            java.lang.String[] r4 = r6.keys
            r5 = r4[r1]
            r4 = r4[r3]
            boolean r4 = r5.equalsIgnoreCase(r4)
            if (r4 == 0) goto L40
        L39:
            int r0 = r0 + 1
            r6.remove(r3)
            int r3 = r3 + (-1)
        L40:
            int r3 = r3 + 1
            goto L15
        L43:
            r1 = r2
            goto Ld
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Attributes.deduplicate(org.jsoup.parser.ParseSettings):int");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.size == attributes.size && Arrays.equals(this.keys, attributes.keys)) {
            return Arrays.equals(this.vals, attributes.vals);
        }
        return false;
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public String get(String str) {
        int iIndexOfKey = indexOfKey(str);
        return iIndexOfKey == -1 ? "" : checkNotNull(this.vals[iIndexOfKey]);
    }

    public String getIgnoreCase(String str) {
        int iIndexOfKeyIgnoreCase = indexOfKeyIgnoreCase(str);
        return iIndexOfKeyIgnoreCase == -1 ? "" : checkNotNull(this.vals[iIndexOfKeyIgnoreCase]);
    }

    public boolean hasDeclaredValueForKey(String str) {
        int iIndexOfKey = indexOfKey(str);
        return (iIndexOfKey == -1 || this.vals[iIndexOfKey] == null) ? false : true;
    }

    public boolean hasDeclaredValueForKeyIgnoreCase(String str) {
        int iIndexOfKeyIgnoreCase = indexOfKeyIgnoreCase(str);
        return (iIndexOfKeyIgnoreCase == -1 || this.vals[iIndexOfKeyIgnoreCase] == null) ? false : true;
    }

    public boolean hasKey(String str) {
        return indexOfKey(str) != -1;
    }

    public boolean hasKeyIgnoreCase(String str) {
        return indexOfKeyIgnoreCase(str) != -1;
    }

    public int hashCode() {
        return (((this.size * 31) + Arrays.hashCode(this.keys)) * 31) + Arrays.hashCode(this.vals);
    }

    public String html() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        try {
            html(sbBorrowBuilder, new Document("").outputSettings());
            return StringUtil.releaseBuilder(sbBorrowBuilder);
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    public int indexOfKey(String str) {
        Validate.notNull(str);
        for (int i2 = 0; i2 < this.size; i2++) {
            if (str.equals(this.keys[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public java.util.Iterator<Attribute> iterator() {
        return new AnonymousClass1();
    }

    public void normalize() {
        for (int i2 = 0; i2 < this.size; i2++) {
            String[] strArr = this.keys;
            strArr[i2] = Normalizer.lowerCase(strArr[i2]);
        }
    }

    public Attributes put(String str, String str2) {
        Validate.notNull(str);
        int iIndexOfKey = indexOfKey(str);
        if (iIndexOfKey != -1) {
            this.vals[iIndexOfKey] = str2;
        } else {
            add(str, str2);
        }
        return this;
    }

    public void putIgnoreCase(String str, String str2) {
        int iIndexOfKeyIgnoreCase = indexOfKeyIgnoreCase(str);
        if (iIndexOfKeyIgnoreCase == -1) {
            add(str, str2);
            return;
        }
        this.vals[iIndexOfKeyIgnoreCase] = str2;
        if (this.keys[iIndexOfKeyIgnoreCase].equals(str)) {
            return;
        }
        this.keys[iIndexOfKeyIgnoreCase] = str;
    }

    public void removeIgnoreCase(String str) {
        int iIndexOfKeyIgnoreCase = indexOfKeyIgnoreCase(str);
        if (iIndexOfKeyIgnoreCase != -1) {
            remove(iIndexOfKeyIgnoreCase);
        }
    }

    public int size() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.size; i3++) {
            if (!isInternalKey(this.keys[i3])) {
                i2++;
            }
        }
        return i2;
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return v.o(iterator(), 0);
    }

    public String toString() {
        return html();
    }

    public Attributes clone() {
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.size = this.size;
            this.keys = copyOf(this.keys, this.size);
            this.vals = copyOf(this.vals, this.size);
            return attributes;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void html(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        int i2 = this.size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (!isInternalKey(this.keys[i3])) {
                String str = this.keys[i3];
                String str2 = this.vals[i3];
                appendable.append(' ').append(str);
                if (!Attribute.shouldCollapseAttribute(str, str2, outputSettings)) {
                    appendable.append("=\"");
                    if (str2 == null) {
                        str2 = "";
                    }
                    Entities.escape(appendable, str2, outputSettings, true, false, false);
                    appendable.append('\"');
                }
            }
        }
    }

    public Attributes put(String str, boolean z) {
        if (z) {
            putIgnoreCase(str, null);
        } else {
            remove(str);
        }
        return this;
    }

    public Attributes put(Attribute attribute) {
        Validate.notNull(attribute);
        put(attribute.getKey(), attribute.getValue());
        attribute.parent = this;
        return this;
    }

    public void remove(String str) {
        int iIndexOfKey = indexOfKey(str);
        if (iIndexOfKey != -1) {
            remove(iIndexOfKey);
        }
    }
}
