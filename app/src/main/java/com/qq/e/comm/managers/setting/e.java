package com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class e extends b {
    public e() {
    }

    public e(String str) {
        super(str);
    }

    public void a(String str, Object obj) {
        try {
            this.a.putOpt(str, obj);
        } catch (JSONException unused) {
            GDTLogger.d("Exception while update setting");
        }
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("GDTSDKSetting[");
        sbR.append(this.a.toString());
        sbR.append("]");
        return sbR.toString();
    }
}
