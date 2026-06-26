package j$.time.temporal;

import j$.time.ZoneId;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements n {
    public static final /* synthetic */ g a = new g();

    private /* synthetic */ g() {
    }

    @Override // j$.time.temporal.n
    public final Object a(k kVar) {
        int i2 = m.a;
        ZoneId zoneId = (ZoneId) kVar.n(d.a);
        return zoneId != null ? zoneId : (ZoneId) kVar.n(c.a);
    }
}
