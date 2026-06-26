package org.mozilla.javascript;

import com.umeng.analytics.pro.ai;
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
import j$.util.function.Predicate;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class NativeObject extends IdScriptableObject implements Map, j$.util.Map {
    private static final int ConstructorId_assign = -15;
    private static final int ConstructorId_create = -9;
    private static final int ConstructorId_defineProperties = -8;
    private static final int ConstructorId_defineProperty = -5;
    private static final int ConstructorId_freeze = -13;
    private static final int ConstructorId_getOwnPropertyDescriptor = -4;
    private static final int ConstructorId_getOwnPropertyNames = -3;
    private static final int ConstructorId_getOwnPropertySymbols = -14;
    private static final int ConstructorId_getPrototypeOf = -1;
    private static final int ConstructorId_is = -16;
    private static final int ConstructorId_isExtensible = -6;
    private static final int ConstructorId_isFrozen = -11;
    private static final int ConstructorId_isSealed = -10;
    private static final int ConstructorId_keys = -2;
    private static final int ConstructorId_preventExtensions = -7;
    private static final int ConstructorId_seal = -12;
    private static final int ConstructorId_setPrototypeOf = -17;
    private static final int Id___defineGetter__ = 9;
    private static final int Id___defineSetter__ = 10;
    private static final int Id___lookupGetter__ = 11;
    private static final int Id___lookupSetter__ = 12;
    private static final int Id_constructor = 1;
    private static final int Id_hasOwnProperty = 5;
    private static final int Id_isPrototypeOf = 7;
    private static final int Id_propertyIsEnumerable = 6;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toSource = 8;
    private static final int Id_toString = 2;
    private static final int Id_valueOf = 4;
    private static final int MAX_PROTOTYPE_ID = 12;
    private static final Object OBJECT_TAG = "Object";
    private static final long serialVersionUID = -6345305608474346996L;

    public class EntrySet extends AbstractSet<Map.Entry<Object, Object>> implements Set {

        /* JADX INFO: renamed from: org.mozilla.javascript.NativeObject$EntrySet$1, reason: invalid class name */
        public class AnonymousClass1 implements Iterator<Map.Entry<Object, Object>>, j$.util.Iterator {
            public Object[] ids;
            public Object key = null;
            public int index = 0;

            /* JADX INFO: renamed from: org.mozilla.javascript.NativeObject$EntrySet$1$1, reason: invalid class name and collision with other inner class name */
            public class C02351 implements Map.Entry<Object, Object>, Map.Entry {
                public final /* synthetic */ Object val$ekey;
                public final /* synthetic */ Object val$value;

                public C02351(Object obj, Object obj2) {
                    this.val$ekey = obj;
                    this.val$value = obj2;
                }

                @Override // java.util.Map.Entry, j$.util.Map.Entry
                public boolean equals(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object obj2 = this.val$ekey;
                    if (obj2 == null) {
                        if (entry.getKey() != null) {
                            return false;
                        }
                    } else if (!obj2.equals(entry.getKey())) {
                        return false;
                    }
                    Object obj3 = this.val$value;
                    if (obj3 == null) {
                        if (entry.getValue() != null) {
                            return false;
                        }
                    } else if (!obj3.equals(entry.getValue())) {
                        return false;
                    }
                    return true;
                }

                @Override // java.util.Map.Entry, j$.util.Map.Entry
                public Object getKey() {
                    return this.val$ekey;
                }

                @Override // java.util.Map.Entry, j$.util.Map.Entry
                public Object getValue() {
                    return this.val$value;
                }

                @Override // java.util.Map.Entry, j$.util.Map.Entry
                public int hashCode() {
                    Object obj = this.val$ekey;
                    int iHashCode = obj == null ? 0 : obj.hashCode();
                    Object obj2 = this.val$value;
                    return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
                }

                @Override // java.util.Map.Entry, j$.util.Map.Entry
                public Object setValue(Object obj) {
                    throw new UnsupportedOperationException();
                }

                public String toString() {
                    return this.val$ekey + "=" + this.val$value;
                }
            }

            public AnonymousClass1() {
                this.ids = NativeObject.this.getIds();
            }

            @Override // j$.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                return this.index < this.ids.length;
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public void remove() {
                Object obj = this.key;
                if (obj == null) {
                    throw new IllegalStateException();
                }
                NativeObject.this.remove(obj);
                this.key = null;
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public Map.Entry<Object, Object> next() {
                Object[] objArr = this.ids;
                int i2 = this.index;
                this.index = i2 + 1;
                Object obj = objArr[i2];
                this.key = obj;
                return new C02351(obj, NativeObject.this.get(obj));
            }
        }

        public EntrySet() {
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Set, j$.util.Collection, j$.lang.Iterable
        public java.util.Iterator<Map.Entry<Object, Object>> iterator() {
            return new AnonymousClass1();
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
            return NativeObject.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Set, j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return Set.CC.$default$spliterator(this);
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Q1.v(a.A(this), false);
        }
    }

    public class KeySet extends AbstractSet<Object> implements Set {

        /* JADX INFO: renamed from: org.mozilla.javascript.NativeObject$KeySet$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.Iterator<Object>, j$.util.Iterator {
            public Object[] ids;
            public int index = 0;
            public Object key;

            public AnonymousClass1() {
                this.ids = NativeObject.this.getIds();
            }

            @Override // j$.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                return this.index < this.ids.length;
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public Object next() {
                try {
                    Object[] objArr = this.ids;
                    int i2 = this.index;
                    this.index = i2 + 1;
                    Object obj = objArr[i2];
                    this.key = obj;
                    return obj;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    this.key = null;
                    throw new NoSuchElementException();
                }
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public void remove() {
                Object obj = this.key;
                if (obj == null) {
                    throw new IllegalStateException();
                }
                NativeObject.this.remove(obj);
                this.key = null;
            }
        }

        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, j$.util.Set, j$.util.Collection
        public boolean contains(Object obj) {
            return NativeObject.this.containsKey(obj);
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Set, j$.util.Collection, j$.lang.Iterable
        public java.util.Iterator<Object> iterator() {
            return new AnonymousClass1();
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
            return NativeObject.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Set, j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return Set.CC.$default$spliterator(this);
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Q1.v(a.A(this), false);
        }
    }

    public class ValueCollection extends AbstractCollection<Object> implements Collection {

        /* JADX INFO: renamed from: org.mozilla.javascript.NativeObject$ValueCollection$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.Iterator<Object>, j$.util.Iterator {
            public Object[] ids;
            public int index = 0;
            public Object key;

            public AnonymousClass1() {
                this.ids = NativeObject.this.getIds();
            }

            @Override // j$.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                return this.index < this.ids.length;
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public Object next() {
                NativeObject nativeObject = NativeObject.this;
                Object[] objArr = this.ids;
                int i2 = this.index;
                this.index = i2 + 1;
                Object obj = objArr[i2];
                this.key = obj;
                return nativeObject.get(obj);
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public void remove() {
                Object obj = this.key;
                if (obj == null) {
                    throw new IllegalStateException();
                }
                NativeObject.this.remove(obj);
                this.key = null;
            }
        }

        public ValueCollection() {
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public java.util.Iterator<Object> iterator() {
            return new AnonymousClass1();
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Q1.v(a.A(this), true);
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public int size() {
            return NativeObject.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return Collection.CC.$default$spliterator(this);
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Q1.v(a.A(this), false);
        }
    }

    private static Scriptable getCompatibleObject(Context context, Scriptable scriptable, Object obj) {
        return context.getLanguageVersion() >= 200 ? ScriptableObject.ensureScriptable(ScriptRuntime.toObject(context, scriptable, obj)) : ScriptableObject.ensureScriptable(obj);
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeObject().exportAsJSClass(12, scriptable, z);
    }

    @Override // java.util.Map, j$.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, j$.util.function.Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // java.util.Map, j$.util.Map, java.util.AbstractMap
    public boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return has((String) obj, this);
        }
        if (obj instanceof Number) {
            return has(((Number) obj).intValue(), this);
        }
        return false;
    }

    @Override // java.util.Map, j$.util.Map
    public boolean containsValue(Object obj) {
        for (Object obj2 : values()) {
            if (obj == obj2) {
                return true;
            }
            if (obj != null && obj.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map, j$.util.Map
    public java.util.Set<Map.Entry<Object, Object>> entrySet() {
        return new EntrySet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0159, code lost:
    
        if (r11 == 0) goto L132;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015c A[PHI: r11 r12
  0x015c: PHI (r11v178 ??) = (r11v244 ??), (r11v245 ??), (r11v246 ??), (r11v247 ??), (r11v248 ??), (r11v249 ??) binds: [B:126:0x0183, B:128:0x0187, B:119:0x016c, B:121:0x0170, B:108:0x014b, B:110:0x014f] A[DONT_GENERATE, DONT_INLINE]
  0x015c: PHI (r12v22 boolean) = (r12v17 boolean), (r12v17 boolean), (r12v20 boolean), (r12v20 boolean), (r12v26 boolean), (r12v26 boolean) binds: [B:126:0x0183, B:128:0x0187, B:119:0x016c, B:121:0x0170, B:108:0x014b, B:110:0x014f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r11v178 */
    /* JADX WARN: Type inference failed for: r11v244 */
    /* JADX WARN: Type inference failed for: r11v245 */
    /* JADX WARN: Type inference failed for: r11v246 */
    /* JADX WARN: Type inference failed for: r11v247 */
    /* JADX WARN: Type inference failed for: r11v248 */
    /* JADX WARN: Type inference failed for: r11v249 */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execIdCall(org.mozilla.javascript.IdFunctionObject r11, org.mozilla.javascript.Context r12, org.mozilla.javascript.Scriptable r13, org.mozilla.javascript.Scriptable r14, java.lang.Object[] r15) {
        /*
            Method dump skipped, instruction units count: 1640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeObject.execIdCall(org.mozilla.javascript.IdFunctionObject, org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = OBJECT_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -1, "getPrototypeOf", 1);
        if (Context.getCurrentContext().version >= 200) {
            addIdFunctionProperty(idFunctionObject, obj, -17, "setPrototypeOf", 2);
        }
        addIdFunctionProperty(idFunctionObject, obj, -2, "keys", 1);
        addIdFunctionProperty(idFunctionObject, obj, -3, "getOwnPropertyNames", 1);
        addIdFunctionProperty(idFunctionObject, obj, -14, "getOwnPropertySymbols", 1);
        addIdFunctionProperty(idFunctionObject, obj, -4, "getOwnPropertyDescriptor", 2);
        addIdFunctionProperty(idFunctionObject, obj, -5, "defineProperty", 3);
        addIdFunctionProperty(idFunctionObject, obj, -6, "isExtensible", 1);
        addIdFunctionProperty(idFunctionObject, obj, -7, "preventExtensions", 1);
        addIdFunctionProperty(idFunctionObject, obj, -8, "defineProperties", 2);
        addIdFunctionProperty(idFunctionObject, obj, -9, "create", 2);
        addIdFunctionProperty(idFunctionObject, obj, -10, "isSealed", 1);
        addIdFunctionProperty(idFunctionObject, obj, -11, "isFrozen", 1);
        addIdFunctionProperty(idFunctionObject, obj, -12, "seal", 1);
        addIdFunctionProperty(idFunctionObject, obj, -13, "freeze", 1);
        addIdFunctionProperty(idFunctionObject, obj, -15, "assign", 2);
        addIdFunctionProperty(idFunctionObject, obj, -16, ai.ae, 2);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r10) {
        /*
            r9 = this;
            int r0 = r10.length()
            r1 = 2
            r2 = 3
            r3 = 11
            r4 = 7
            r5 = 0
            r6 = 8
            if (r0 == r4) goto L8e
            r7 = 116(0x74, float:1.63E-43)
            if (r0 == r6) goto L79
            if (r0 == r3) goto L75
            r8 = 16
            if (r0 == r8) goto L41
            r1 = 20
            if (r0 == r1) goto L3d
            r1 = 13
            if (r0 == r1) goto L39
            r1 = 14
            if (r0 == r1) goto L26
            goto L8b
        L26:
            char r0 = r10.charAt(r5)
            r1 = 104(0x68, float:1.46E-43)
            if (r0 != r1) goto L33
            r1 = 5
            java.lang.String r0 = "hasOwnProperty"
            goto L91
        L33:
            if (r0 != r7) goto L8b
            java.lang.String r0 = "toLocaleString"
            r1 = 3
            goto L91
        L39:
            java.lang.String r0 = "isPrototypeOf"
            r1 = 7
            goto L91
        L3d:
            r1 = 6
            java.lang.String r0 = "propertyIsEnumerable"
            goto L91
        L41:
            char r0 = r10.charAt(r1)
            r1 = 100
            r2 = 83
            r4 = 71
            if (r0 != r1) goto L5f
            char r0 = r10.charAt(r6)
            if (r0 != r4) goto L58
            r1 = 9
            java.lang.String r0 = "__defineGetter__"
            goto L91
        L58:
            if (r0 != r2) goto L8b
            r1 = 10
            java.lang.String r0 = "__defineSetter__"
            goto L91
        L5f:
            r1 = 108(0x6c, float:1.51E-43)
            if (r0 != r1) goto L8b
            char r0 = r10.charAt(r6)
            if (r0 != r4) goto L6e
            java.lang.String r0 = "__lookupGetter__"
            r1 = 11
            goto L91
        L6e:
            if (r0 != r2) goto L8b
            r1 = 12
            java.lang.String r0 = "__lookupSetter__"
            goto L91
        L75:
            r1 = 1
            java.lang.String r0 = "constructor"
            goto L91
        L79:
            char r0 = r10.charAt(r2)
            r2 = 111(0x6f, float:1.56E-43)
            if (r0 != r2) goto L86
            java.lang.String r0 = "toSource"
            r1 = 8
            goto L91
        L86:
            if (r0 != r7) goto L8b
            java.lang.String r0 = "toString"
            goto L91
        L8b:
            r0 = 0
            r1 = 0
            goto L91
        L8e:
            r1 = 4
            java.lang.String r0 = "valueOf"
        L91:
            if (r0 == 0) goto L9c
            if (r0 == r10) goto L9c
            boolean r10 = r0.equals(r10)
            if (r10 != 0) goto L9c
            goto L9d
        L9c:
            r5 = r1
        L9d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeObject.findPrototypeId(java.lang.String):int");
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Object";
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        String str2;
        int i3 = 1;
        switch (i2) {
            case 1:
                str = "constructor";
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            case 2:
                str = "toString";
                i3 = 0;
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            case 3:
                str = "toLocaleString";
                i3 = 0;
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            case 4:
                str = "valueOf";
                i3 = 0;
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            case 5:
                str = "hasOwnProperty";
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            case 6:
                str = "propertyIsEnumerable";
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            case 7:
                str = "isPrototypeOf";
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            case 8:
                str = "toSource";
                i3 = 0;
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            case 9:
                str2 = "__defineGetter__";
                str = str2;
                i3 = 2;
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            case 10:
                str2 = "__defineSetter__";
                str = str2;
                i3 = 2;
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            case 11:
                str = "__lookupGetter__";
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            case 12:
                str = "__lookupSetter__";
                initPrototypeMethod(OBJECT_TAG, i2, str, i3);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i2));
        }
    }

    @Override // java.util.Map, j$.util.Map
    public java.util.Set<Object> keySet() {
        return new KeySet();
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public void putAll(java.util.Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map, java.util.AbstractMap
    public Object remove(Object obj) {
        Object obj2 = get(obj);
        if (obj instanceof String) {
            delete((String) obj);
        } else if (obj instanceof Number) {
            delete(((Number) obj).intValue());
        }
        return obj2;
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

    public String toString() {
        return ScriptRuntime.defaultObjectToString(this);
    }

    @Override // java.util.Map, j$.util.Map
    public java.util.Collection<Object> values() {
        return new ValueCollection();
    }
}
