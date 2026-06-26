package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.k;
import j$.time.temporal.m;
import j$.time.temporal.n;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements n {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // j$.time.temporal.n
    public final Object a(k kVar) {
        int i2 = c.a;
        int i3 = m.a;
        ZoneId zoneId = (ZoneId) kVar.n(j$.time.temporal.d.a);
        if (zoneId == null || (zoneId instanceof j$.time.j)) {
            return null;
        }
        return zoneId;
    }
}
