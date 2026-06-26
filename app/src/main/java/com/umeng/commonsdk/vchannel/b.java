package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5438b;
    private String a = "_$unknown";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5439c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f5440d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5441e = a.f5437j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f5442f = null;

    public b(Context context) {
        this.f5438b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.f5439c;
    }

    public Map<String, Object> c() {
        return this.f5442f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.a);
            jSONObject.put("pn", this.f5438b);
            jSONObject.put("ds", this.f5440d);
            jSONObject.put("ts", this.f5439c);
            Map<String, Object> map = this.f5442f;
            if (map != null && map.size() > 0) {
                for (String str : this.f5442f.keySet()) {
                    jSONObject.put(str, this.f5442f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f5441e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder("[");
        StringBuilder sbR = c.a.a.a.a.r("id:");
        sbR.append(this.a);
        sbR.append(",");
        sb.append(sbR.toString());
        sb.append("pn:" + this.f5438b + ",");
        sb.append("ts:" + this.f5439c + ",");
        Map<String, Object> map = this.f5442f;
        if (map != null && map.size() > 0) {
            for (String str : this.f5442f.keySet()) {
                Object obj = this.f5442f.get(str);
                if (obj == null) {
                    string = c.a.a.a.a.k(str, ": null", ",");
                } else {
                    StringBuilder sbT = c.a.a.a.a.t(str, ": ");
                    sbT.append(obj.toString());
                    sbT.append(",");
                    string = sbT.toString();
                }
                sb.append(string);
            }
        }
        StringBuilder sbR2 = c.a.a.a.a.r("ds:");
        sbR2.append(this.f5440d);
        sbR2.append("]");
        sb.append(sbR2.toString());
        return sb.toString();
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(long j2) {
        this.f5439c = j2;
    }

    public void a(Map<String, Object> map) {
        this.f5442f = map;
    }
}
