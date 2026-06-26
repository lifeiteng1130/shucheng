package c.b.a.m;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: HttpException.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public e(int i2) {
        this("Http request failed", i2);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    @Deprecated
    public e(String str) {
        this(str, -1);
    }

    public e(String str, int i2) {
        this(str, i2, null);
    }

    public e(String str, int i2, @Nullable Throwable th) {
        super(str + ", status code: " + i2, th);
        this.statusCode = i2;
    }
}
