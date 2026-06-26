package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public JSONObject a;

    public b() {
        this(null);
    }

    public b(String str) {
        String simpleName = getClass().getSimpleName();
        GDTLogger.d("Initialize " + simpleName + ",Json=" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.a = new JSONObject(str);
            } catch (JSONException unused) {
                GDTLogger.d("JsonException While build" + simpleName + " Instance from JSON");
            }
        }
        if (this.a == null) {
            this.a = new JSONObject();
        }
    }
}
