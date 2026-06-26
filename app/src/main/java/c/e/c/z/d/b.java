package c.e.c.z.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BarcodeValue.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final Map<Integer, Integer> a = new HashMap();

    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry<Integer, Integer> entry : this.a.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return c.e.c.z.a.b(arrayList);
    }

    public void b(int i2) {
        Integer num = this.a.get(Integer.valueOf(i2));
        if (num == null) {
            num = 0;
        }
        this.a.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
    }
}
