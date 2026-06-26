package com.ss.android.downloadlib.c;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: compiled from: ApkModifyNameManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements m {
    private boolean c(DownloadInfo downloadInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(downloadInfo.getSavePath());
        String str = File.separator;
        sb.append(str);
        sb.append(downloadInfo.getName());
        String string = sb.toString();
        File file = new File(string);
        String strA = com.ss.android.socialbase.appdownloader.f.a.e.a(j.getContext(), com.ss.android.socialbase.appdownloader.c.a(downloadInfo, file), string);
        boolean zRenameTo = false;
        if (!TextUtils.isEmpty(strA)) {
            String strI = c.a.a.a.a.i(strA, ".apk");
            if (strI.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                zRenameTo = file.renameTo(new File(downloadInfo.getSavePath() + str + strI));
                if (zRenameTo) {
                    downloadInfo.setName(strI);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return zRenameTo;
    }

    @Override // com.ss.android.socialbase.downloader.depend.m
    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !c(downloadInfo)) {
            return;
        }
        a(j.getContext(), downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.m
    public boolean b(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.downloadlib.g.e.b(com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()));
        }
        return false;
    }

    private void a(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{AdBaseConstants.MIME_APK}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.c.a.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData("file_content_uri", uri.toString());
                        com.ss.android.socialbase.downloader.downloader.c.x().a(downloadInfo);
                    }
                }
            });
        }
        com.ss.android.socialbase.downloader.i.f.a(cursorQuery);
    }
}
