package k.c.d;

/* JADX INFO: compiled from: Image.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends s {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8724g;

    public m() {
    }

    @Override // k.c.d.s
    public void a(z zVar) {
        ((e.b.a.j) zVar).f(this);
    }

    @Override // k.c.d.s
    public String e() {
        StringBuilder sbR = c.a.a.a.a.r("destination=");
        sbR.append(this.f8723f);
        sbR.append(", title=");
        sbR.append(this.f8724g);
        return sbR.toString();
    }

    public m(String str, String str2) {
        this.f8723f = str;
        this.f8724g = str2;
    }
}
