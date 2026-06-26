package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.g.l;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f3028h;

    public a() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.a);
            jSONObject.put("mAdId", this.f3022b);
            jSONObject.put("mExtValue", this.f3023c);
            jSONObject.put("mPackageName", this.f3024d);
            jSONObject.put("mAppName", this.f3025e);
            jSONObject.put("mLogExtra", this.f3026f);
            jSONObject.put("mFileName", this.f3027g);
            jSONObject.put("mTimeStamp", this.f3028h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        this.a = j2;
        this.f3022b = j3;
        this.f3023c = j4;
        this.f3024d = str;
        this.f3025e = str2;
        this.f3026f = str3;
        this.f3027g = str4;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = l.a(jSONObject, "mDownloadId");
            aVar.f3022b = l.a(jSONObject, "mAdId");
            aVar.f3023c = l.a(jSONObject, "mExtValue");
            aVar.f3024d = jSONObject.optString("mPackageName");
            aVar.f3025e = jSONObject.optString("mAppName");
            aVar.f3026f = jSONObject.optString("mLogExtra");
            aVar.f3027g = jSONObject.optString("mFileName");
            aVar.f3028h = l.a(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
