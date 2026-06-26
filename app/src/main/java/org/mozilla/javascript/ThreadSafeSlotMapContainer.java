package org.mozilla.javascript;

import java.util.Iterator;
import java.util.concurrent.locks.StampedLock;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadSafeSlotMapContainer extends SlotMapContainer {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final StampedLock lock;

    public ThreadSafeSlotMapContainer(int i2) {
        super(i2);
        this.lock = new StampedLock();
    }

    @Override // org.mozilla.javascript.SlotMapContainer, org.mozilla.javascript.SlotMap
    public void addSlot(ScriptableObject.Slot slot) {
        long jWriteLock = this.lock.writeLock();
        try {
            checkMapSize();
            this.map.addSlot(slot);
        } finally {
            this.lock.unlockWrite(jWriteLock);
        }
    }

    @Override // org.mozilla.javascript.SlotMapContainer
    public void checkMapSize() {
        super.checkMapSize();
    }

    @Override // org.mozilla.javascript.SlotMapContainer
    public int dirtySize() {
        return this.map.size();
    }

    @Override // org.mozilla.javascript.SlotMapContainer, org.mozilla.javascript.SlotMap
    public ScriptableObject.Slot get(Object obj, int i2, ScriptableObject.SlotAccess slotAccess) {
        long jWriteLock = this.lock.writeLock();
        try {
            if (slotAccess != ScriptableObject.SlotAccess.QUERY) {
                checkMapSize();
            }
            return this.map.get(obj, i2, slotAccess);
        } finally {
            this.lock.unlockWrite(jWriteLock);
        }
    }

    @Override // org.mozilla.javascript.SlotMapContainer, org.mozilla.javascript.SlotMap
    public boolean isEmpty() {
        long jTryOptimisticRead = this.lock.tryOptimisticRead();
        boolean zIsEmpty = this.map.isEmpty();
        if (this.lock.validate(jTryOptimisticRead)) {
            return zIsEmpty;
        }
        long lock = this.lock.readLock();
        try {
            return this.map.isEmpty();
        } finally {
            this.lock.unlockRead(lock);
        }
    }

    @Override // org.mozilla.javascript.SlotMapContainer, java.lang.Iterable, j$.lang.Iterable
    public Iterator<ScriptableObject.Slot> iterator() {
        return this.map.iterator();
    }

    @Override // org.mozilla.javascript.SlotMapContainer, org.mozilla.javascript.SlotMap
    public ScriptableObject.Slot query(Object obj, int i2) {
        long jTryOptimisticRead = this.lock.tryOptimisticRead();
        ScriptableObject.Slot slotQuery = this.map.query(obj, i2);
        if (this.lock.validate(jTryOptimisticRead)) {
            return slotQuery;
        }
        long lock = this.lock.readLock();
        try {
            return this.map.query(obj, i2);
        } finally {
            this.lock.unlockRead(lock);
        }
    }

    @Override // org.mozilla.javascript.SlotMapContainer
    public long readLock() {
        return this.lock.readLock();
    }

    @Override // org.mozilla.javascript.SlotMapContainer, org.mozilla.javascript.SlotMap
    public void remove(Object obj, int i2) {
        long jWriteLock = this.lock.writeLock();
        try {
            this.map.remove(obj, i2);
        } finally {
            this.lock.unlockWrite(jWriteLock);
        }
    }

    @Override // org.mozilla.javascript.SlotMapContainer, org.mozilla.javascript.SlotMap
    public int size() {
        long jTryOptimisticRead = this.lock.tryOptimisticRead();
        int size = this.map.size();
        if (this.lock.validate(jTryOptimisticRead)) {
            return size;
        }
        long lock = this.lock.readLock();
        try {
            return this.map.size();
        } finally {
            this.lock.unlockRead(lock);
        }
    }

    @Override // org.mozilla.javascript.SlotMapContainer
    public void unlockRead(long j2) {
        this.lock.unlockRead(j2);
    }
}
