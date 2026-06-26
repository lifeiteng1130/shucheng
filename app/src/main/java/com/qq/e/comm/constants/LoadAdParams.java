package com.qq.e.comm.constants;

import c.a.a.a.a;
import java.util.Map;
import org.json.JSONObject;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes.dex */
public class LoadAdParams {
    private LoginType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f2776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f2777f;

    public Map getDevExtra() {
        return this.f2776e;
    }

    public String getDevExtraJsonString() {
        try {
            Map<String, String> map = this.f2776e;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.f2776e).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f2777f;
    }

    public String getLoginAppId() {
        return this.f2773b;
    }

    public String getLoginOpenid() {
        return this.f2774c;
    }

    public LoginType getLoginType() {
        return this.a;
    }

    public String getUin() {
        return this.f2775d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.f2776e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f2777f = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.f2773b = str;
    }

    public void setLoginOpenid(String str) {
        this.f2774c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.a = loginType;
    }

    public void setUin(String str) {
        this.f2775d = str;
    }

    public String toString() {
        StringBuilder sbR = a.r("LoadAdParams{, loginType=");
        sbR.append(this.a);
        sbR.append(", loginAppId=");
        sbR.append(this.f2773b);
        sbR.append(", loginOpenid=");
        sbR.append(this.f2774c);
        sbR.append(", uin=");
        sbR.append(this.f2775d);
        sbR.append(", passThroughInfo=");
        sbR.append(this.f2776e);
        sbR.append(", extraInfo=");
        sbR.append(this.f2777f);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }
}
