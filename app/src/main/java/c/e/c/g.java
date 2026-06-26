package c.e.c;

/* JADX INFO: compiled from: FormatException.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends o {
    public static final g a;

    static {
        g gVar = new g();
        a = gVar;
        gVar.setStackTrace(o.NO_TRACE);
    }

    public g() {
    }

    public static g getFormatInstance() {
        return o.isStackTrace ? new g() : a;
    }

    public g(Throwable th) {
        super(th);
    }

    public static g getFormatInstance(Throwable th) {
        return o.isStackTrace ? new g(th) : a;
    }
}
