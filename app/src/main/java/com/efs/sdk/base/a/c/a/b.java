package com.efs.sdk.base.a.c.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public int a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1786b = "https://";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1787c = "errlog.umeng.com";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Boolean f1790f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Double> f1788d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f1789e = new HashMap();

    private b() {
    }

    public static b a() {
        b bVar = new b();
        if (com.efs.sdk.base.a.d.a.a().f1782i) {
            bVar.f1787c = "errlogos.umeng.com";
        } else {
            bVar.f1787c = "errlog.umeng.com";
        }
        return bVar;
    }

    public final void a(@NonNull Map<String, String> map) {
        if (map.containsKey("gate_way")) {
            String str = map.get("gate_way");
            if (!TextUtils.isEmpty(str)) {
                this.f1787c = str;
            }
        }
        if (map.containsKey("gate_way_https")) {
            String str2 = map.get("gate_way_https");
            if (!TextUtils.isEmpty(str2)) {
                this.f1786b = Boolean.parseBoolean(str2) ? "https://" : "http://";
            }
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("data_sampling_rate_") || key.startsWith("file_sampling_rate_")) {
                String strReplace = key.replace("data_sampling_rate_", "").replace("file_sampling_rate_", "");
                double d2 = 100.0d;
                try {
                    d2 = Double.parseDouble(entry.getValue());
                } catch (Throwable unused) {
                }
                map2.put(strReplace, Double.valueOf(d2));
            }
        }
        this.f1788d = map2;
        this.f1789e = map;
    }
}
