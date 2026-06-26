package c.b.a.m.q;

/* JADX INFO: compiled from: CallbackException.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    public c(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
