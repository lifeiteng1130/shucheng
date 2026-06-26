package com.ss.android.downloadlib.g;

import org.json.JSONObject;

/* JADX INFO: compiled from: TLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    public static void a(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.j jVarP = com.ss.android.downloadlib.addownload.j.p();
        if (jVarP != null) {
            jVarP.a(2, str, str2, jSONObject);
        }
    }

    public static void b(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.j jVarP = com.ss.android.downloadlib.addownload.j.p();
        if (jVarP != null) {
            jVarP.a(3, str, str2, jSONObject);
        }
    }

    public static void c(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.j jVarP = com.ss.android.downloadlib.addownload.j.p();
        if (jVarP != null) {
            jVarP.a(6, str, str2, jSONObject);
        }
    }

    public static void a(String str, String str2) {
        c(str, str2, null);
    }
}
