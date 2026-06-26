package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import c.b.a.m.f;
import c.b.a.m.q.c0.b;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ThumbnailStreamOpener {
    private static final FileService DEFAULT_SERVICE = new FileService();
    private static final String TAG = "ThumbStreamOpener";
    private final b byteArrayPool;
    private final ContentResolver contentResolver;
    private final List<ImageHeaderParser> parsers;
    private final ThumbnailQuery query;
    private final FileService service;

    public ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, b bVar, ContentResolver contentResolver) {
        this(list, DEFAULT_SERVICE, thumbnailQuery, bVar, contentResolver);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0041: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:23:0x0041 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getPath(@androidx.annotation.NonNull android.net.Uri r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            com.bumptech.glide.load.data.mediastore.ThumbnailQuery r1 = r4.query     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L20
            android.database.Cursor r1 = r1.query(r5)     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L20
            if (r1 == 0) goto L18
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.SecurityException -> L21 java.lang.Throwable -> L40
            if (r2 == 0) goto L18
            r2 = 0
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.SecurityException -> L21 java.lang.Throwable -> L40
            r1.close()
            return r5
        L18:
            if (r1 == 0) goto L1d
            r1.close()
        L1d:
            return r0
        L1e:
            r5 = move-exception
            goto L42
        L20:
            r1 = r0
        L21:
            java.lang.String r2 = "ThumbStreamOpener"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L3a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r2.<init>()     // Catch: java.lang.Throwable -> L40
            java.lang.String r3 = "Failed to query for thumbnail for Uri: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L40
            r2.append(r5)     // Catch: java.lang.Throwable -> L40
            r2.toString()     // Catch: java.lang.Throwable -> L40
        L3a:
            if (r1 == 0) goto L3f
            r1.close()
        L3f:
            return r0
        L40:
            r5 = move-exception
            r0 = r1
        L42:
            if (r0 == 0) goto L47
            r0.close()
        L47:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener.getPath(android.net.Uri):java.lang.String");
    }

    private boolean isValid(File file) {
        return this.service.exists(file) && 0 < this.service.length(file);
    }

    public int getOrientation(Uri uri) {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.contentResolver.openInputStream(uri);
                int iF2 = f.F2(this.parsers, inputStreamOpenInputStream, this.byteArrayPool);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iF2;
            } catch (IOException | NullPointerException unused2) {
                if (Log.isLoggable(TAG, 3)) {
                    String str = "Failed to open uri: " + uri;
                }
                if (inputStreamOpenInputStream == null) {
                    return -1;
                }
                try {
                    inputStreamOpenInputStream.close();
                    return -1;
                } catch (IOException unused3) {
                    return -1;
                }
            }
        } catch (Throwable th) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public InputStream open(Uri uri) throws Throwable {
        String path = getPath(uri);
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        File file = this.service.get(path);
        if (!isValid(file)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(file);
        try {
            return this.contentResolver.openInputStream(uriFromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e2));
        }
    }

    public ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, b bVar, ContentResolver contentResolver) {
        this.service = fileService;
        this.query = thumbnailQuery;
        this.byteArrayPool = bVar;
        this.contentResolver = contentResolver;
        this.parsers = list;
    }
}
