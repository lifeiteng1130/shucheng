package k.b.a.a.g;

/* JADX INFO: compiled from: ToStringBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static volatile c a = c.DEFAULT_STYLE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuffer f8546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f8547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f8548d;

    public b(Object obj) {
        c cVar = a;
        StringBuffer stringBuffer = new StringBuffer(512);
        this.f8546b = stringBuffer;
        this.f8548d = cVar;
        this.f8547c = obj;
        cVar.appendStart(stringBuffer, obj);
    }

    public String toString() {
        Object obj = this.f8547c;
        if (obj == null) {
            this.f8546b.append(this.f8548d.getNullText());
        } else {
            this.f8548d.appendEnd(this.f8546b, obj);
        }
        return this.f8546b.toString();
    }
}
