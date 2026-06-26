package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface GifDecoder {

    @Retention(RetentionPolicy.SOURCE)
    public @interface GifDecodeStatus {
    }

    public interface a {
    }

    @Nullable
    Bitmap a();

    void b();

    int c();

    void clear();

    int d();

    int e();

    int f();

    @NonNull
    ByteBuffer getData();
}
