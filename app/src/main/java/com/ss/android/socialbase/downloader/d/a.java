package com.ss.android.socialbase.downloader.d;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.i;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DownloadMonitorHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(DownloadTask downloadTask, BaseException baseException, int i2) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            x monitorDepend = downloadTask.getMonitorDepend();
            boolean zIsMonitorStatus = DownloadStatus.isMonitorStatus(i2);
            if (!zIsMonitorStatus && !(zIsMonitorStatus = a(downloadInfo.getExtraMonitorStatus(), i2)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.c)) {
                zIsMonitorStatus = a(((com.ss.android.socialbase.downloader.depend.c) monitorDepend).a(), i2);
            }
            if (zIsMonitorStatus) {
                try {
                    n depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.a(downloadInfo, baseException, i2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                a(monitorDepend, downloadInfo, baseException, i2);
                a(com.ss.android.socialbase.downloader.downloader.c.g(), downloadInfo, baseException, i2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static boolean a(int[] iArr, int i2) {
        if (iArr != null && iArr.length > 0) {
            for (int i3 : iArr) {
                if (i2 == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(x xVar, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        if (xVar == null) {
            return;
        }
        try {
            String strB = xVar.b();
            if (TextUtils.isEmpty(strB)) {
                strB = "default";
            }
            JSONObject jSONObjectA = a(strB, downloadInfo, baseException, i2);
            if (jSONObjectA == null) {
                jSONObjectA = new JSONObject();
            }
            xVar.a(jSONObjectA);
        } catch (Throwable unused) {
        }
    }

    public static void a(b bVar, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        if (bVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject jSONObjectA = a(downloadInfo.getMonitorScene(), downloadInfo, baseException, i2);
            if (jSONObjectA == null) {
                jSONObjectA = new JSONObject();
            }
            if (i2 == -1) {
                jSONObjectA.put(NotificationCompat.CATEGORY_STATUS, baseException.getErrorCode());
                bVar.a("download_failed", jSONObjectA, null, null);
            } else {
                a(i2, jSONObjectA, downloadInfo);
                bVar.a("download_common", jSONObjectA, null, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(int i2, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i2 == -5) {
            str = "download_uncomplete";
        } else if (i2 == -4) {
            str = "download_cancel";
        } else if (i2 != -3) {
            str = i2 != -2 ? i2 != 0 ? i2 != 2 ? i2 != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put(NotificationCompat.CATEGORY_STATUS, str);
    }

    public static String a(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static JSONObject a(String str, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        String strB;
        String strA;
        String strA2;
        int iC;
        String lastPathSegment;
        String host;
        String path;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                q qVarK = com.ss.android.socialbase.downloader.downloader.c.k();
                if (qVarK != null) {
                    strB = qVarK.b();
                    strA = a(strB);
                    strA2 = qVarK.a();
                    iC = qVarK.c();
                } else {
                    strB = "";
                    strA = strB;
                    strA2 = strA;
                    iC = 0;
                }
                String strA3 = (baseException == null || !(baseException instanceof g)) ? "" : ((g) baseException).a();
                jSONObject2.put("event_page", str);
                jSONObject2.put(PluginConstants.KEY_APP_ID, strA2);
                jSONObject2.put("device_id", strB);
                jSONObject2.put("device_id_postfix", strA);
                jSONObject2.put("update_version", iC);
                jSONObject2.put("download_status", i2);
                if (downloadInfo != null) {
                    jSONObject2.put("setting_tag", com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).c("setting_tag"));
                    jSONObject2.put("download_id", downloadInfo.getId());
                    jSONObject2.put("name", downloadInfo.getName());
                    jSONObject2.put("url", downloadInfo.getUrl());
                    jSONObject2.put("save_path", downloadInfo.getSavePath());
                    jSONObject2.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject2.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject2.put("total_bytes", downloadInfo.getTotalBytes());
                    jSONObject2.put("network_quality", downloadInfo.getNetworkQuality());
                    int i3 = 1;
                    jSONObject2.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject2.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject2.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject2.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                    jSONObject2.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject2.put("is_force", downloadInfo.isForce() ? 1 : 0);
                    jSONObject2.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject2.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject2.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject2.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject2.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject2.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject2.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject2.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject2.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject2.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject2.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject2.put(BaseConstants.EVENT_LABEL_EXTRA, downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                    if (!downloadInfo.isAddListenerToSameTask()) {
                        i3 = 0;
                    }
                    jSONObject2.put("add_listener_to_same_task", i3);
                    jSONObject2.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject2.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject2.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                    jSONObject2.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                    try {
                        String url = downloadInfo.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            lastPathSegment = "";
                            host = lastPathSegment;
                            path = host;
                        } else {
                            Uri uri = Uri.parse(url);
                            host = uri.getHost();
                            path = uri.getPath();
                            lastPathSegment = uri.getLastPathSegment();
                            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                                try {
                                    path = path.substring(0, path.length() - lastPathSegment.length());
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }
                        jSONObject2.put("url_host", host);
                        jSONObject2.put("url_path", path);
                        jSONObject2.put("url_last_path_segment", lastPathSegment);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                jSONObject2.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
                jSONObject2.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
                jSONObject2.put("request_log", strA3);
                return jSONObject2;
            } catch (JSONException e2) {
                e = e2;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003c A[PHI: r7
  0x003c: PHI (r7v9 int) = (r7v0 int), (r7v2 int) binds: [B:12:0x0023, B:19:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007e A[PHI: r7
  0x007e: PHI (r7v8 int) = (r7v4 int), (r7v4 int), (r7v6 int), (r7v4 int) binds: [B:32:0x0056, B:36:0x0065, B:35:0x0062, B:25:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.network.g r14, java.lang.String r15, java.lang.String r16, long r17, java.lang.String r19, int r20, java.io.IOException r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.a.a(com.ss.android.socialbase.downloader.network.g, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, i iVar, boolean z, boolean z2, BaseException baseException, long j2, long j3, boolean z3, long j4, long j5, long j6, JSONObject jSONObject) {
        a("download_io", aVar.b("monitor_download_io"), aVar, downloadInfo, str, null, null, iVar, z, z2, baseException, j2, j3, z3, j4, j5, j6, null);
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, i iVar, BaseException baseException, long j2, long j3) {
        a("segment_io", aVar.b("monitor_segment_io"), aVar, downloadInfo, str, str2, str3, iVar, z, false, baseException, j2, j3, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0108 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012b A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0134 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016e A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0174 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017b  */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.ss.android.socialbase.downloader.d.c] */
    /* JADX WARN: Type inference failed for: r11v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.ss.android.socialbase.downloader.network.a] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.ss.android.socialbase.downloader.d.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r19, int r20, com.ss.android.socialbase.downloader.g.a r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.ss.android.socialbase.downloader.network.i r26, boolean r27, boolean r28, com.ss.android.socialbase.downloader.exception.BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, org.json.JSONObject r41) {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.a.a(java.lang.String, int, com.ss.android.socialbase.downloader.g.a, com.ss.android.socialbase.downloader.model.DownloadInfo, java.lang.String, java.lang.String, java.lang.String, com.ss.android.socialbase.downloader.network.i, boolean, boolean, com.ss.android.socialbase.downloader.exception.BaseException, long, long, boolean, long, long, long, org.json.JSONObject):void");
    }

    public static void a(DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.f.i> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.f.i.a(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            c cVarP = com.ss.android.socialbase.downloader.downloader.c.P();
            if (cVarP != null) {
                cVarP.a(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
