package c.e.a.b.l;

/* JADX INFO: compiled from: DateFormatTextWatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {
    public final /* synthetic */ long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f1025b;

    public d(c cVar, long j2) {
        this.f1025b = cVar;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.f1025b;
        cVar.a.setError(String.format(cVar.f1021d, c.b.a.m.f.g2(this.a)));
        this.f1025b.a();
    }
}
