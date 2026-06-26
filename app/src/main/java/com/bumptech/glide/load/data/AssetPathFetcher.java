package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import c.b.a.f;
import c.b.a.m.a;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "AssetPathFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.assetManager = assetManager;
        this.assetPath = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T t = this.data;
        if (t == null) {
            return;
        }
        try {
            close(t);
        } catch (IOException unused) {
        }
    }

    public abstract void close(T t);

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public a getDataSource() {
        return a.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull f fVar, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T tLoadResource = loadResource(this.assetManager, this.assetPath);
            this.data = tLoadResource;
            dataCallback.onDataReady(tLoadResource);
        } catch (IOException e2) {
            Log.isLoggable(TAG, 3);
            dataCallback.onLoadFailed(e2);
        }
    }

    public abstract T loadResource(AssetManager assetManager, String str);
}
