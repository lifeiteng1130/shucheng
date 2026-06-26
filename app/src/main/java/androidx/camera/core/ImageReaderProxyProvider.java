package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.ImageReaderProxy;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ImageReaderProxyProvider {
    @NonNull
    ImageReaderProxy newInstance(int i2, int i3, int i4, int i5, long j2);
}
