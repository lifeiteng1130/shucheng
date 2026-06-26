package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: CustomJumpDevicePlan.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JSONObject f3300d;

    public c(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str, JSONObject jSONObject) {
        super(context, aVar, str);
        this.f3300d = jSONObject;
    }

    private static void a(@NonNull Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (itKeys = jSONObject.keys()) == null) {
            return;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject2.optString(next);
            if (strOptString != null) {
                a(jSONObject, next, strOptString, intent);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String strOptString = this.f3300d.optString("action");
        String strOptString2 = this.f3300d.optString("category");
        int iOptInt = this.f3300d.optInt("flags", 1342210048);
        String strOptString3 = this.f3300d.optString("path_extra_key");
        String strOptString4 = this.f3300d.optString("path_data_key");
        JSONObject jSONObjectOptJSONObject = this.f3300d.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
        JSONObject jSONObjectOptJSONObject2 = this.f3300d.optJSONObject("extra_type");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        Intent intent = new Intent(strOptString);
        if (!TextUtils.isEmpty(strOptString2)) {
            intent.addCategory(strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            try {
                intent.setData(Uri.parse(String.format(strOptString4, this.f3299c)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(iOptInt);
        if (!TextUtils.isEmpty(strOptString3)) {
            intent.putExtra(strOptString3, this.f3299c);
        }
        a(intent, jSONObjectOptJSONObject, jSONObjectOptJSONObject2);
        return intent;
    }

    private static void a(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.hashCode();
        switch (str2) {
            case "double":
                intent.putExtra(str, jSONObject.optDouble(str));
                break;
            case "string":
                intent.putExtra(str, jSONObject.optString(str));
                break;
            case "int":
                intent.putExtra(str, jSONObject.optInt(str));
                break;
            case "long":
                intent.putExtra(str, jSONObject.optLong(str));
                break;
            case "boolean":
                intent.putExtra(str, jSONObject.optBoolean(str));
                break;
        }
    }
}
