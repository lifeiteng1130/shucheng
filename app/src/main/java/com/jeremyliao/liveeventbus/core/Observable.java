package com.jeremyliao.liveeventbus.core;

import androidx.annotation.NonNull;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;

/* JADX INFO: loaded from: classes.dex */
public interface Observable<T> {
    void broadcast(T t);

    void broadcast(T t, boolean z);

    void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<T> observer);

    void observeForever(@NonNull Observer<T> observer);

    void observeSticky(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<T> observer);

    void observeStickyForever(@NonNull Observer<T> observer);

    void post(T t);

    void postDelay(LifecycleOwner lifecycleOwner, T t, long j2);

    void postDelay(T t, long j2);

    void postOrderly(T t);

    void removeObserver(@NonNull Observer<T> observer);
}
