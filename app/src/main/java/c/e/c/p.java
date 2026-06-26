package c.e.c;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: Result.java */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f1355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r[] f1356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f1357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<q, Object> f1358e;

    public p(String str, byte[] bArr, r[] rVarArr, a aVar) {
        System.currentTimeMillis();
        this.a = str;
        this.f1355b = bArr;
        this.f1356c = rVarArr;
        this.f1357d = aVar;
        this.f1358e = null;
    }

    public void a(Map<q, Object> map) {
        if (map != null) {
            Map<q, Object> map2 = this.f1358e;
            if (map2 == null) {
                this.f1358e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void b(q qVar, Object obj) {
        if (this.f1358e == null) {
            this.f1358e = new EnumMap(q.class);
        }
        this.f1358e.put(qVar, obj);
    }

    public String toString() {
        return this.a;
    }

    public p(String str, byte[] bArr, int i2, r[] rVarArr, a aVar, long j2) {
        this.a = str;
        this.f1355b = bArr;
        this.f1356c = rVarArr;
        this.f1357d = aVar;
        this.f1358e = null;
    }
}
