package e.a.a.h;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: RealPathUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    @Nullable
    public static Uri a;

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ab A[Catch: all -> 0x00cd, TRY_ENTER, TryCatch #8 {all -> 0x00cd, blocks: (B:5:0x0018, B:7:0x001e, B:18:0x0036, B:33:0x0087, B:51:0x00ab, B:54:0x00b1, B:63:0x00c3, B:67:0x00cc, B:66:0x00c9), top: B:76:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b1 A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #8 {all -> 0x00cd, blocks: (B:5:0x0018, B:7:0x001e, B:18:0x0036, B:33:0x0087, B:51:0x00ab, B:54:0x00b1, B:63:0x00c3, B:67:0x00cc, B:66:0x00c9), top: B:76:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b7 A[PHI: r10
  0x00b7: PHI (r10v4 android.database.Cursor) = (r10v3 android.database.Cursor), (r10v5 android.database.Cursor) binds: [B:55:0x00b4, B:12:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c3 A[Catch: all -> 0x00cd, TRY_ENTER, TryCatch #8 {all -> 0x00cd, blocks: (B:5:0x0018, B:7:0x001e, B:18:0x0036, B:33:0x0087, B:51:0x00ab, B:54:0x00b1, B:63:0x00c3, B:67:0x00cc, B:66:0x00c9), top: B:76:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c9 A[Catch: all -> 0x00cd, TryCatch #8 {all -> 0x00cd, blocks: (B:5:0x0018, B:7:0x001e, B:18:0x0036, B:33:0x0087, B:51:0x00ab, B:54:0x00b1, B:63:0x00c3, B:67:0x00cc, B:66:0x00c9), top: B:76:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String a(android.content.Context r9, android.net.Uri r10, java.lang.String r11, java.lang.String[] r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.h.a0.a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    @Nullable
    public static final String b(@NotNull Context context, @NotNull Uri uri) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(uri, "uri");
        a = uri;
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (f.c0.c.j.a("com.android.externalstorage.documents", uri.getAuthority())) {
                String documentId = DocumentsContract.getDocumentId(uri);
                f.c0.c.j.d(documentId, "docId");
                Object[] array = f.h0.k.F(documentId, new String[]{":"}, false, 0, 6).toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr = (String[]) array;
                if (f.h0.k.i("primary", strArr[0], true)) {
                    return Environment.getExternalStorageDirectory().toString() + Attributes.InternalPrefix + strArr[1];
                }
            } else {
                if (f.c0.c.j.a("com.android.providers.downloads.documents", uri.getAuthority())) {
                    String documentId2 = DocumentsContract.getDocumentId(uri);
                    Uri uri3 = Uri.parse("content://downloads/public_downloads");
                    Long lValueOf = Long.valueOf(documentId2);
                    f.c0.c.j.d(lValueOf, "valueOf(id)");
                    Uri uriWithAppendedId = ContentUris.withAppendedId(uri3, lValueOf.longValue());
                    f.c0.c.j.d(uriWithAppendedId, "withAppendedId(\n                    Uri.parse(\"content://downloads/public_downloads\"),\n                    java.lang.Long.valueOf(id)\n                )");
                    return a(context, uriWithAppendedId, null, null);
                }
                if (f.c0.c.j.a("com.android.providers.media.documents", uri.getAuthority())) {
                    String documentId3 = DocumentsContract.getDocumentId(uri);
                    f.c0.c.j.d(documentId3, "docId");
                    Object[] array2 = f.h0.k.F(documentId3, new String[]{":"}, false, 0, 6).toArray(new String[0]);
                    Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                    String[] strArr2 = (String[]) array2;
                    String str = strArr2[0];
                    int iHashCode = str.hashCode();
                    if (iHashCode != 93166550) {
                        if (iHashCode != 100313435) {
                            if (iHashCode == 112202875 && str.equals("video")) {
                                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                            }
                        } else if (str.equals("image")) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        }
                    } else if (str.equals("audio")) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return a(context, uri2, "_id=?", new String[]{strArr2[1]});
                }
            }
        } else {
            if (f.h0.k.i("content", uri.getScheme(), true)) {
                return f.c0.c.j.a("com.google.android.apps.photos.content", uri.getAuthority()) ? uri.getLastPathSegment() : a(context, uri, null, null);
            }
            if (f.h0.k.i("file", uri.getScheme(), true)) {
                return uri.getPath();
            }
        }
        return null;
    }
}
