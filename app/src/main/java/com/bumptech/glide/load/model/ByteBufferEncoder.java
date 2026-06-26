package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import c.b.a.m.d;
import c.b.a.m.l;
import c.b.a.s.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferEncoder implements d<ByteBuffer> {
    private static final String TAG = "ByteBufferEncoder";

    @Override // c.b.a.m.d
    public boolean encode(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull l lVar) throws Throwable {
        try {
            a.b(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable(TAG, 3);
            return false;
        }
    }
}
