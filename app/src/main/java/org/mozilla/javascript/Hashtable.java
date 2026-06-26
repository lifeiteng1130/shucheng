package org.mozilla.javascript;

import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.Map;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.v;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mozilla.javascript.Hashtable;

/* JADX INFO: loaded from: classes3.dex */
public class Hashtable implements Serializable, Iterable<Entry>, Iterable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -7151554912419543747L;
    private final HashMap<Object, Entry> map = new HashMap<>();
    private Entry first = null;
    private Entry last = null;

    public static final class Iter implements Iterator<Entry>, j$.util.Iterator {
        private Entry pos;

        public Iter(Entry entry) {
            Entry entryMakeDummy = Hashtable.makeDummy();
            entryMakeDummy.next = entry;
            this.pos = entryMakeDummy;
        }

        private void skipDeleted() {
            while (true) {
                Entry entry = this.pos.next;
                if (entry == null || !entry.deleted) {
                    return;
                } else {
                    this.pos = entry;
                }
            }
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            skipDeleted();
            Entry entry = this.pos;
            return (entry == null || entry.next == null) ? false : true;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Entry next() {
            Entry entry;
            skipDeleted();
            Entry entry2 = this.pos;
            if (entry2 == null || (entry = entry2.next) == null) {
                throw new NoSuchElementException();
            }
            this.pos = entry;
            return entry;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Entry makeDummy() {
        Entry entry = new Entry();
        entry.clear();
        return entry;
    }

    public void clear() {
        Iterator.EL.forEachRemaining(iterator(), new Consumer() { // from class: k.d.b.c
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                ((Hashtable.Entry) obj).clear();
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        });
        if (this.first != null) {
            Entry entryMakeDummy = makeDummy();
            this.last.next = entryMakeDummy;
            this.last = entryMakeDummy;
            this.first = entryMakeDummy;
        }
        this.map.clear();
    }

    public Object delete(Object obj) {
        Entry entryRemove = this.map.remove(new Entry(obj, null));
        if (entryRemove == null) {
            return null;
        }
        if (entryRemove != this.first) {
            Entry entry = entryRemove.prev;
            entry.next = entryRemove.next;
            entryRemove.prev = null;
            Entry entry2 = entryRemove.next;
            if (entry2 != null) {
                entry2.prev = entry;
            } else {
                this.last = entry;
            }
        } else if (entryRemove == this.last) {
            entryRemove.clear();
            entryRemove.prev = null;
        } else {
            Entry entry3 = entryRemove.next;
            this.first = entry3;
            entry3.prev = null;
            Entry entry4 = entry3.next;
            if (entry4 != null) {
                entry4.prev = entry3;
            }
        }
        return entryRemove.clear();
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public Object get(Object obj) {
        Entry entry = this.map.get(new Entry(obj, null));
        if (entry == null) {
            return null;
        }
        return entry.value;
    }

    public boolean has(Object obj) {
        return this.map.containsKey(new Entry(obj, null));
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public java.util.Iterator<Entry> iterator() {
        return new Iter(this.first);
    }

    public void put(Object obj, Object obj2) {
        Entry entry = new Entry(obj, obj2);
        Entry entry2 = (Entry) Map.EL.putIfAbsent(this.map, entry, entry);
        if (entry2 != null) {
            entry2.value = obj2;
            return;
        }
        if (this.first == null) {
            this.last = entry;
            this.first = entry;
        } else {
            Entry entry3 = this.last;
            entry3.next = entry;
            entry.prev = entry3;
            this.last = entry;
        }
    }

    public int size() {
        return this.map.size();
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return v.o(iterator(), 0);
    }

    public static final class Entry implements Serializable {
        private static final long serialVersionUID = 4086572107122965503L;
        public boolean deleted;
        private final int hashCode;
        public Object key;
        public Entry next;
        public Entry prev;
        public Object value;

        public Entry() {
            this.hashCode = 0;
        }

        public Object clear() {
            Object obj = this.value;
            Object obj2 = Undefined.instance;
            this.key = obj2;
            this.value = obj2;
            this.deleted = true;
            return obj;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ScriptRuntime.sameZero(this.key, ((Entry) obj).key);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        public int hashCode() {
            return this.hashCode;
        }

        public Object key() {
            return this.key;
        }

        public Object value() {
            return this.value;
        }

        public Entry(Object obj, Object obj2) {
            if ((obj instanceof Number) && !(obj instanceof Double)) {
                this.key = Double.valueOf(((Number) obj).doubleValue());
            } else if (obj instanceof ConsString) {
                this.key = obj.toString();
            } else {
                this.key = obj;
            }
            if (this.key == null || obj.equals(ScriptRuntime.negativeZeroObj)) {
                this.hashCode = 0;
            } else {
                this.hashCode = this.key.hashCode();
            }
            this.value = obj2;
        }
    }
}
