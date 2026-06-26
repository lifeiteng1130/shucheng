package c.e.c.z.d;

import c.e.c.k;
import c.e.c.r;

/* JADX INFO: compiled from: BoundingBox.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final c.e.c.v.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f1528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f1529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f1530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f1531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1535i;

    public c(c.e.c.v.b bVar, r rVar, r rVar2, r rVar3, r rVar4) throws k {
        boolean z = rVar == null || rVar2 == null;
        boolean z2 = rVar3 == null || rVar4 == null;
        if (z && z2) {
            throw k.getNotFoundInstance();
        }
        if (z) {
            rVar = new r(0.0f, rVar3.f1359b);
            rVar2 = new r(0.0f, rVar4.f1359b);
        } else if (z2) {
            int i2 = bVar.a;
            rVar3 = new r(i2 - 1, rVar.f1359b);
            rVar4 = new r(i2 - 1, rVar2.f1359b);
        }
        this.a = bVar;
        this.f1528b = rVar;
        this.f1529c = rVar2;
        this.f1530d = rVar3;
        this.f1531e = rVar4;
        this.f1532f = (int) Math.min(rVar.a, rVar2.a);
        this.f1533g = (int) Math.max(rVar3.a, rVar4.a);
        this.f1534h = (int) Math.min(rVar.f1359b, rVar3.f1359b);
        this.f1535i = (int) Math.max(rVar2.f1359b, rVar4.f1359b);
    }

    public c(c cVar) {
        this.a = cVar.a;
        this.f1528b = cVar.f1528b;
        this.f1529c = cVar.f1529c;
        this.f1530d = cVar.f1530d;
        this.f1531e = cVar.f1531e;
        this.f1532f = cVar.f1532f;
        this.f1533g = cVar.f1533g;
        this.f1534h = cVar.f1534h;
        this.f1535i = cVar.f1535i;
    }
}
