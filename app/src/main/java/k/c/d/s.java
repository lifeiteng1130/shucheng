package k.c.d;

/* JADX INFO: compiled from: Node.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public s a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f8732b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f8733c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s f8734d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f8735e = null;

    public abstract void a(z zVar);

    public void b(s sVar) {
        sVar.f();
        sVar.d(this);
        s sVar2 = this.f8733c;
        if (sVar2 == null) {
            this.f8732b = sVar;
            this.f8733c = sVar;
        } else {
            sVar2.f8735e = sVar;
            sVar.f8734d = sVar2;
            this.f8733c = sVar;
        }
    }

    public s c() {
        return this.a;
    }

    public void d(s sVar) {
        this.a = sVar;
    }

    public String e() {
        return "";
    }

    public void f() {
        s sVar = this.f8734d;
        if (sVar != null) {
            sVar.f8735e = this.f8735e;
        } else {
            s sVar2 = this.a;
            if (sVar2 != null) {
                sVar2.f8732b = this.f8735e;
            }
        }
        s sVar3 = this.f8735e;
        if (sVar3 != null) {
            sVar3.f8734d = sVar;
        } else {
            s sVar4 = this.a;
            if (sVar4 != null) {
                sVar4.f8733c = sVar;
            }
        }
        this.a = null;
        this.f8735e = null;
        this.f8734d = null;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + e() + "}";
    }
}
