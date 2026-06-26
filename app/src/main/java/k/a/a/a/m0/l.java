package k.a.a.a.m0;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: ParseCancellationException.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends CancellationException {
    public l() {
    }

    public l(String str) {
        super(str);
    }

    public l(Throwable th) {
        initCause(th);
    }

    public l(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
