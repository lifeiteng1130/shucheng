package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import c.b.a.m.q.c0.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    @NonNull
    ImageType a(@NonNull ByteBuffer byteBuffer);

    @NonNull
    ImageType b(@NonNull InputStream inputStream);

    int c(@NonNull InputStream inputStream, @NonNull b bVar);
}
