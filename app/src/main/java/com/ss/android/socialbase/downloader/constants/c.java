package com.ss.android.socialbase.downloader.constants;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.constant.BaseConstants;

/* JADX INFO: compiled from: DBDefinition.java */
/* JADX INFO: loaded from: classes.dex */
public interface c {
    public static final String[] a = {"_id", "url", "savePath", "tempPath", "name", "chunkCount", NotificationCompat.CATEGORY_STATUS, "curBytes", "totalBytes", "eTag", "onlyWifi", TTDownloadField.TT_FORCE, "retryCount", BaseConstants.EVENT_LABEL_EXTRA, "mimeType", "title", "notificationEnable", "notificationVisibility", "isFirstDownload", "isFirstSuccess", "needHttpsToHttpRetry", "downloadTime", "packageName", "md5", "retryDelay", "curRetryTime", "retryDelayStatus", "defaultHttpServiceBackUp", "chunkRunnableReuse", "retryDelayTimeArray", "chunkDowngradeRetry", "backUpUrlsStr", "backUpUrlRetryCount", "realDownloadTime", "retryScheduleMinutes", "independentProcess", "auxiliaryJsonobjectString", "iconUrl", "appVersionCode", "taskId"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f3495b = {"_id"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f3496c = {"_id", "chunkIndex", "startOffset", "curOffset", "endOffset", "chunkContentLen", "hostChunkIndex"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f3497d = {"_id"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f3498e = {"_id", "info"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f3499f = {"_id"};
}
