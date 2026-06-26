package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: DownloadConstants.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static volatile String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f3503b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f3504c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f3505d = 512000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f3506e = 50;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f3507f = 5242880;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f3508g = 31457280;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f3509h = 10485760;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final JSONObject f3510i = new JSONObject();

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a = str;
    }
}
