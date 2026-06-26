package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.j;
import c.b.a.m.l;
import com.bumptech.glide.load.data.DataFetcher;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public interface ModelLoader<Model, Data> {

    public static class LoadData<Data> {
        public final List<j> alternateKeys;
        public final DataFetcher<Data> fetcher;
        public final j sourceKey;

        public LoadData(@NonNull j jVar, @NonNull DataFetcher<Data> dataFetcher) {
            this(jVar, Collections.emptyList(), dataFetcher);
        }

        public LoadData(@NonNull j jVar, @NonNull List<j> list, @NonNull DataFetcher<Data> dataFetcher) {
            Objects.requireNonNull(jVar, "Argument must not be null");
            this.sourceKey = jVar;
            Objects.requireNonNull(list, "Argument must not be null");
            this.alternateKeys = list;
            Objects.requireNonNull(dataFetcher, "Argument must not be null");
            this.fetcher = dataFetcher;
        }
    }

    @Nullable
    LoadData<Data> buildLoadData(@NonNull Model model, int i2, int i3, @NonNull l lVar);

    boolean handles(@NonNull Model model);
}
