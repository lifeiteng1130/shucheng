package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.e.b.a.a.a;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface Observable<T> {

    public interface Observer<T> {
        void onError(@NonNull Throwable th);

        void onNewData(@Nullable T t);
    }

    void addObserver(@NonNull Executor executor, @NonNull Observer<T> observer);

    @NonNull
    a<T> fetchData();

    void removeObserver(@NonNull Observer<T> observer);
}
