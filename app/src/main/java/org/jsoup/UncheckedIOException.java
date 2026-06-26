package org.jsoup;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class UncheckedIOException extends RuntimeException {
    public UncheckedIOException(IOException iOException) {
        super(iOException);
    }

    public IOException ioException() {
        return (IOException) getCause();
    }

    public UncheckedIOException(String str) {
        super(new IOException(str));
    }
}
