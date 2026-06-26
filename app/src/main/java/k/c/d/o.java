package k.c.d;

/* JADX INFO: compiled from: Link.java */
/* JADX INFO: loaded from: classes3.dex */
public class o extends s {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8727g;

    public o() {
    }

    @Override // k.c.d.s
    public void a(z zVar) {
        ((e.b.a.j) zVar).f(this);
    }

    @Override // k.c.d.s
    public String e() {
        StringBuilder sbR = c.a.a.a.a.r("destination=");
        sbR.append(this.f8726f);
        sbR.append(", title=");
        sbR.append(this.f8727g);
        return sbR.toString();
    }

    public o(String str, String str2) {
        this.f8726f = str;
        this.f8727g = str2;
    }
}
