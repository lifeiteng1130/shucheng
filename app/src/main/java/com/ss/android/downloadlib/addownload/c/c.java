package com.ss.android.downloadlib.addownload.c;

import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: ClearSpaceUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a() {
        List<DownloadInfo> listA = com.ss.android.socialbase.appdownloader.d.j().a(j.getContext());
        if (listA == null || listA.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < listA.size(); i2++) {
            DownloadInfo downloadInfo = listA.get(i2);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long jLastModified = file.lastModified();
            long jA = ((long) com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_file_expire_hours", 0)) * 3600000;
            if (jA <= 0) {
                jA = 604800000;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - jLastModified >= jA) {
                a(file);
                Downloader.getInstance(j.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void b() {
        List successedDownloadInfosWithMimeType = Downloader.getInstance(j.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < successedDownloadInfosWithMimeType.size(); i2++) {
            DownloadInfo downloadInfo = (DownloadInfo) successedDownloadInfosWithMimeType.get(i2);
            if (downloadInfo != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long jA = ((long) com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_complete_file_expire_hours", 0)) * 3600000;
                    if (jA <= 0) {
                        jA = 604800000;
                    }
                    boolean z = true;
                    if (jCurrentTimeMillis < jA && !l.e(j.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        a(file);
                    }
                }
            }
        }
    }

    public static void a(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            a(externalCacheDir.getPath());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.File r3) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            java.lang.String r0 = "1"
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            r1.write(r0)     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            r1.close()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            goto L28
        L13:
            r0 = move-exception
            goto L1b
        L15:
            r3 = move-exception
            goto L2e
        L17:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L1b:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L28
            r1.close()     // Catch: java.lang.Exception -> L24
            goto L28
        L24:
            r0 = move-exception
            r0.printStackTrace()
        L28:
            r3.delete()
            return
        L2c:
            r3 = move-exception
            r0 = r1
        L2e:
            if (r0 == 0) goto L38
            r0.close()     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r0 = move-exception
            r0.printStackTrace()
        L38:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.c.c.a(java.io.File):void");
    }

    private static void a(String str) {
        String strK;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str2 : list) {
                if (str2 != null) {
                    String str3 = File.separator;
                    if (str.endsWith(str3)) {
                        strK = c.a.a.a.a.i(str, str2);
                    } else {
                        strK = c.a.a.a.a.k(str, str3, str2);
                    }
                    File file2 = new File(strK);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        a(strK);
                    }
                }
            }
            file.delete();
        }
    }
}
