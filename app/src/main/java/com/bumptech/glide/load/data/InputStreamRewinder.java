package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import c.b.a.m.q.c0.b;
import c.b.a.m.r.c.w;
import com.bumptech.glide.load.data.DataRewinder;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class InputStreamRewinder implements DataRewinder<InputStream> {
    private static final int MARK_READ_LIMIT = 5242880;
    private final w bufferedStream;

    public static final class Factory implements DataRewinder.Factory<InputStream> {
        private final b byteArrayPool;

        public Factory(b bVar) {
            this.byteArrayPool = bVar;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public DataRewinder<InputStream> build(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.byteArrayPool);
        }
    }

    public InputStreamRewinder(InputStream inputStream, b bVar) {
        w wVar = new w(inputStream, bVar);
        this.bufferedStream = wVar;
        wVar.mark(MARK_READ_LIMIT);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
        this.bufferedStream.b();
    }

    public void fixMarkLimits() {
        w wVar = this.bufferedStream;
        synchronized (wVar) {
            wVar.f554c = wVar.a.length;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    public InputStream rewindAndGet() {
        this.bufferedStream.reset();
        return this.bufferedStream;
    }
}
