package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.b.a.f;
import c.b.a.m.a;
import c.b.a.m.l;
import c.b.a.r.b;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
    private final Context context;

    public static final class Factory implements ModelLoaderFactory<Uri, File> {
        private final Context context;

        public Factory(Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Uri, File> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.context);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class FilePathFetcher implements DataFetcher<File> {
        private static final String[] PROJECTION = {"_data"};
        private final Context context;
        private final Uri uri;

        public FilePathFetcher(Context context, Uri uri) {
            this.context = context;
            this.uri = uri;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<File> getDataClass() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public a getDataSource() {
            return a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull f fVar, @NonNull DataFetcher.DataCallback<? super File> dataCallback) {
            Cursor cursorQuery = this.context.getContentResolver().query(this.uri, PROJECTION, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                dataCallback.onDataReady(new File(string));
                return;
            }
            StringBuilder sbR = c.a.a.a.a.r("Failed to find file path for: ");
            sbR.append(this.uri);
            dataCallback.onLoadFailed(new FileNotFoundException(sbR.toString()));
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.context = context;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<File> buildLoadData(@NonNull Uri uri, int i2, int i3, @NonNull l lVar) {
        return new ModelLoader.LoadData<>(new b(uri), new FilePathFetcher(this.context, uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Uri uri) {
        return MediaStoreUtil.isMediaStoreUri(uri);
    }
}
