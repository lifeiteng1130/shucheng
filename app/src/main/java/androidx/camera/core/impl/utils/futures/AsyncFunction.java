package androidx.camera.core.impl.utils.futures;

import androidx.annotation.Nullable;
import c.e.b.a.a.a;

/* JADX INFO: loaded from: classes.dex */
@FunctionalInterface
public interface AsyncFunction<I, O> {
    a<O> apply(@Nullable I i2);
}
