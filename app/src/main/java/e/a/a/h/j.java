package e.a.a.h;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.documentfile.provider.DocumentFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DocumentUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    @NotNull
    public static final j a = new j();

    public static DocumentFile a(j jVar, DocumentFile documentFile, String str, String str2, String[] strArr, int i2) {
        String str3 = (i2 & 4) != 0 ? "" : null;
        f.c0.c.j.e(documentFile, "root");
        f.c0.c.j.e(str, "fileName");
        f.c0.c.j.e(str3, "mimeType");
        f.c0.c.j.e(strArr, "subDirs");
        DocumentFile documentFileB = jVar.b(documentFile, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (documentFileB == null) {
            return null;
        }
        return documentFileB.createFile(str3, str);
    }

    @JvmStatic
    @Nullable
    public static final byte[] e(@NotNull Context context, @NotNull Uri uri) throws IOException {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(uri, "uri");
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        byte[] bArr = new byte[inputStreamOpenInputStream.available()];
        inputStreamOpenInputStream.read(bArr);
        inputStreamOpenInputStream.close();
        return bArr;
    }

    @JvmStatic
    @Nullable
    public static final String f(@NotNull Context context, @NotNull Uri uri) throws IOException {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(uri, "uri");
        byte[] bArrE = e(context, uri);
        if (bArrE == null) {
            return null;
        }
        return new String(bArrE, f.h0.a.a);
    }

    @JvmStatic
    public static final boolean g(@NotNull Context context, @NotNull byte[] bArr, @NotNull Uri uri) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(bArr, "data");
        f.c0.c.j.e(uri, "fileUri");
        OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uri);
        if (outputStreamOpenOutputStream == null) {
            return false;
        }
        outputStreamOpenOutputStream.write(bArr);
        outputStreamOpenOutputStream.close();
        return true;
    }

    @Nullable
    public final DocumentFile b(@NotNull DocumentFile documentFile, @NotNull String... strArr) {
        f.c0.c.j.e(documentFile, "root");
        f.c0.c.j.e(strArr, "subDirs");
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            DocumentFile documentFileFindFile = documentFile == null ? null : documentFile.findFile(str);
            documentFile = documentFileFindFile == null ? documentFile == null ? null : documentFile.createDirectory(str) : documentFileFindFile;
        }
        return documentFile;
    }

    public final void c(@NotNull DocumentFile documentFile, @NotNull String str, @NotNull String... strArr) {
        DocumentFile documentFileFindFile;
        f.c0.c.j.e(documentFile, "root");
        f.c0.c.j.e(str, "fileName");
        f.c0.c.j.e(strArr, "subDirs");
        DocumentFile documentFileB = b(documentFile, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (documentFileB == null || (documentFileFindFile = documentFileB.findFile(str)) == null) {
            return;
        }
        documentFileFindFile.delete();
    }

    @NotNull
    public final ArrayList<i> d(@NotNull Context context, @NotNull Uri uri) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(uri, "uri");
        ArrayList<i> arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri)), new String[]{"document_id", "_display_name", "last_modified", "_size", "mime_type"}, null, null, "_display_name");
                if (cursorQuery != null) {
                    int columnIndex = cursorQuery.getColumnIndex("document_id");
                    int columnIndex2 = cursorQuery.getColumnIndex("_display_name");
                    int columnIndex3 = cursorQuery.getColumnIndex("_size");
                    int columnIndex4 = cursorQuery.getColumnIndex("mime_type");
                    int columnIndex5 = cursorQuery.getColumnIndex("last_modified");
                    if (cursorQuery.moveToFirst()) {
                        while (true) {
                            String string = cursorQuery.getString(columnIndex2);
                            f.c0.c.j.d(string, "c.getString(nci)");
                            String string2 = cursorQuery.getString(columnIndex4);
                            f.c0.c.j.d(string2, "c.getString(mci)");
                            long j2 = cursorQuery.getLong(columnIndex3);
                            int i2 = columnIndex4;
                            int i3 = columnIndex3;
                            Date date = new Date(cursorQuery.getLong(columnIndex5));
                            Uri uriBuildDocumentUriUsingTree = DocumentsContract.buildDocumentUriUsingTree(uri, cursorQuery.getString(columnIndex));
                            f.c0.c.j.d(uriBuildDocumentUriUsingTree, "buildDocumentUriUsingTree(uri, c.getString(ici))");
                            arrayList.add(new i(string, string2, j2, date, uriBuildDocumentUriUsingTree));
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            columnIndex3 = i3;
                            columnIndex4 = i2;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
