package androidx.media2.common;

import androidx.annotation.NonNull;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public abstract class DataSourceCallback implements Closeable {
    public abstract long getSize();

    public abstract int readAt(long j2, @NonNull byte[] bArr, int i2, int i3);
}
