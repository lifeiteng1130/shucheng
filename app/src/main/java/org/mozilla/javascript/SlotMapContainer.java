package org.mozilla.javascript;

import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.v;
import java.util.Iterator;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: loaded from: classes3.dex */
public class SlotMapContainer implements SlotMap {
    private static final int LARGE_HASH_SIZE = 2000;
    public SlotMap map;

    public SlotMapContainer(int i2) {
        if (i2 > 2000) {
            this.map = new HashSlotMap();
        } else {
            this.map = new EmbeddedSlotMap();
        }
    }

    @Override // org.mozilla.javascript.SlotMap
    public void addSlot(ScriptableObject.Slot slot) {
        checkMapSize();
        this.map.addSlot(slot);
    }

    public void checkMapSize() {
        SlotMap slotMap = this.map;
        if (!(slotMap instanceof EmbeddedSlotMap) || slotMap.size() < 2000) {
            return;
        }
        HashSlotMap hashSlotMap = new HashSlotMap();
        Iterator<ScriptableObject.Slot> it = this.map.iterator();
        while (it.hasNext()) {
            hashSlotMap.addSlot(it.next());
        }
        this.map = hashSlotMap;
    }

    public int dirtySize() {
        return this.map.size();
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // org.mozilla.javascript.SlotMap
    public ScriptableObject.Slot get(Object obj, int i2, ScriptableObject.SlotAccess slotAccess) {
        if (slotAccess != ScriptableObject.SlotAccess.QUERY) {
            checkMapSize();
        }
        return this.map.get(obj, i2, slotAccess);
    }

    @Override // org.mozilla.javascript.SlotMap
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public Iterator<ScriptableObject.Slot> iterator() {
        return this.map.iterator();
    }

    @Override // org.mozilla.javascript.SlotMap
    public ScriptableObject.Slot query(Object obj, int i2) {
        return this.map.query(obj, i2);
    }

    public long readLock() {
        return 0L;
    }

    @Override // org.mozilla.javascript.SlotMap
    public void remove(Object obj, int i2) {
        this.map.remove(obj, i2);
    }

    @Override // org.mozilla.javascript.SlotMap
    public int size() {
        return this.map.size();
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return v.o(iterator(), 0);
    }

    public void unlockRead(long j2) {
    }
}
