package com.qq.e.comm.managers.setting;

import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {
    public a() {
    }

    public a(String str) {
        super(str);
    }

    public Object a(String str, String str2) {
        JSONObject jSONObjectOptJSONObject = this.a.optJSONObject(Constants.KEYS.PLACEMENTS);
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(str2) : null;
        if (jSONObjectOptJSONObject2 != null) {
            return jSONObjectOptJSONObject2.opt(str);
        }
        return null;
    }
}
