package e.b.a.r.n;

import java.io.IOException;

/* JADX INFO: compiled from: UncheckedIOException.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends RuntimeException {
    public a(IOException iOException) {
        super(iOException);
    }

    public IOException ioException() {
        return (IOException) getCause();
    }
}
