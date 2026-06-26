package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTDownloadEventModel {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f1744c;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.f1744c;
    }

    public String getLabel() {
        return this.f1743b;
    }

    public String getTag() {
        return this.a;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.f1744c = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.f1743b = str;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.a = str;
        return this;
    }
}
