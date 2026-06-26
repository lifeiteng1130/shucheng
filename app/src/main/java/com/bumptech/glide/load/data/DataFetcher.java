package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.f;
import c.b.a.m.a;

/* JADX INFO: loaded from: classes.dex */
public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void onDataReady(@Nullable T t);

        void onLoadFailed(@NonNull Exception exc);
    }

    void cancel();

    void cleanup();

    @NonNull
    Class<T> getDataClass();

    @NonNull
    a getDataSource();

    void loadData(@NonNull f fVar, @NonNull DataCallback<? super T> dataCallback);
}
