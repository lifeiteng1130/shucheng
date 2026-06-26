package k.e.a;

/* JADX INFO: loaded from: classes3.dex */
public class l {
    public n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f8869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f8870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l f8873f;

    public static l a(l lVar, n nVar, n nVar2) {
        if (lVar == null) {
            return null;
        }
        l lVarA = a(lVar.f8873f, nVar, nVar2);
        lVar.f8873f = lVarA;
        int i2 = lVar.a.f8883c;
        n nVar3 = lVar.f8869b;
        int i3 = nVar3.f8883c;
        int i4 = nVar.f8883c;
        int i5 = nVar2 == null ? Integer.MAX_VALUE : nVar2.f8883c;
        if (i4 >= i3 || i5 <= i2) {
            return lVar;
        }
        if (i4 <= i2) {
            if (i5 >= i3) {
                return lVarA;
            }
            lVar.a = nVar2;
            return lVar;
        }
        if (i5 >= i3) {
            lVar.f8869b = nVar;
            return lVar;
        }
        l lVar2 = new l();
        lVar2.a = nVar2;
        lVar2.f8869b = nVar3;
        lVar2.f8870c = lVar.f8870c;
        lVar2.f8871d = lVar.f8871d;
        lVar2.f8872e = lVar.f8872e;
        lVar2.f8873f = lVarA;
        lVar.f8869b = nVar;
        lVar.f8873f = lVar2;
        return lVar;
    }
}
