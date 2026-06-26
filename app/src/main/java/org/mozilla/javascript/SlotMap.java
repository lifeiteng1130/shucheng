package org.mozilla.javascript;

import j$.lang.Iterable;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: loaded from: classes3.dex */
public interface SlotMap extends Iterable<ScriptableObject.Slot>, Iterable {
    void addSlot(ScriptableObject.Slot slot);

    ScriptableObject.Slot get(Object obj, int i2, ScriptableObject.SlotAccess slotAccess);

    boolean isEmpty();

    ScriptableObject.Slot query(Object obj, int i2);

    void remove(Object obj, int i2);

    int size();
}
