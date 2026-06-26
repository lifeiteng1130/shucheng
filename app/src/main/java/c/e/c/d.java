package c.e.c;

/* JADX INFO: compiled from: ChecksumException.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends o {
    public static final d a;

    static {
        d dVar = new d();
        a = dVar;
        dVar.setStackTrace(o.NO_TRACE);
    }

    public d() {
    }

    public static d getChecksumInstance() {
        return o.isStackTrace ? new d() : a;
    }

    public d(Throwable th) {
        super(th);
    }

    public static d getChecksumInstance(Throwable th) {
        return o.isStackTrace ? new d(th) : a;
    }
}
