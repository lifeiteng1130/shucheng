package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import c.b.a.f;
import c.b.a.m.a;
import c.b.a.m.j;
import c.b.a.m.l;
import c.b.a.m.q.r;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes.dex */
public class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
    private final Pools.Pool<List<Throwable>> exceptionListPool;
    private final List<ModelLoader<Model, Data>> modelLoaders;

    public static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {
        private DataFetcher.DataCallback<? super Data> callback;
        private int currentIndex;

        @Nullable
        private List<Throwable> exceptions;
        private final List<DataFetcher<Data>> fetchers;
        private boolean isCancelled;
        private f priority;
        private final Pools.Pool<List<Throwable>> throwableListPool;

        public MultiFetcher(@NonNull List<DataFetcher<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.throwableListPool = pool;
            if (list.isEmpty()) {
                throw new IllegalArgumentException("Must not be empty.");
            }
            this.fetchers = list;
            this.currentIndex = 0;
        }

        private void startNextOrFail() {
            if (this.isCancelled) {
                return;
            }
            if (this.currentIndex < this.fetchers.size() - 1) {
                this.currentIndex++;
                loadData(this.priority, this.callback);
            } else {
                Objects.requireNonNull(this.exceptions, "Argument must not be null");
                this.callback.onLoadFailed(new r("Fetch failed", new ArrayList(this.exceptions)));
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            Iterator<DataFetcher<Data>> it = this.fetchers.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            List<Throwable> list = this.exceptions;
            if (list != null) {
                this.throwableListPool.release(list);
            }
            this.exceptions = null;
            Iterator<DataFetcher<Data>> it = this.fetchers.iterator();
            while (it.hasNext()) {
                it.next().cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Data> getDataClass() {
            return this.fetchers.get(0).getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public a getDataSource() {
            return this.fetchers.get(0).getDataSource();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull f fVar, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            this.priority = fVar;
            this.callback = dataCallback;
            this.exceptions = this.throwableListPool.acquire();
            this.fetchers.get(this.currentIndex).loadData(fVar, this);
            if (this.isCancelled) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onDataReady(@Nullable Data data) {
            if (data != null) {
                this.callback.onDataReady(data);
            } else {
                startNextOrFail();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onLoadFailed(@NonNull Exception exc) {
            List<Throwable> list = this.exceptions;
            Objects.requireNonNull(list, "Argument must not be null");
            list.add(exc);
            startNextOrFail();
        }
    }

    public MultiModelLoader(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.modelLoaders = list;
        this.exceptionListPool = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Model model, int i2, int i3, @NonNull l lVar) {
        ModelLoader.LoadData<Data> loadDataBuildLoadData;
        int size = this.modelLoaders.size();
        ArrayList arrayList = new ArrayList(size);
        j jVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            ModelLoader<Model, Data> modelLoader = this.modelLoaders.get(i4);
            if (modelLoader.handles(model) && (loadDataBuildLoadData = modelLoader.buildLoadData(model, i2, i3, lVar)) != null) {
                jVar = loadDataBuildLoadData.sourceKey;
                arrayList.add(loadDataBuildLoadData.fetcher);
            }
        }
        if (arrayList.isEmpty() || jVar == null) {
            return null;
        }
        return new ModelLoader.LoadData<>(jVar, new MultiFetcher(arrayList, this.exceptionListPool));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Model model) {
        Iterator<ModelLoader<Model, Data>> it = this.modelLoaders.iterator();
        while (it.hasNext()) {
            if (it.next().handles(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("MultiModelLoader{modelLoaders=");
        sbR.append(Arrays.toString(this.modelLoaders.toArray()));
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }
}
