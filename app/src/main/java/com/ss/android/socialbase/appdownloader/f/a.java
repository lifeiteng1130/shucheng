package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.g;
import com.umeng.analytics.pro.ai;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AnUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final HashMap<String, g.a> a = new HashMap<>();

    public static boolean a(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("type")) && a(jSONObjectOptJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i2 = Build.VERSION.SDK_INT;
        String strOptString = jSONObject.optString("allow_os_api_range");
        int iOptInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(strOptString)) {
            return iOptInt <= 0 || i2 >= iOptInt;
        }
        try {
            String[] strArrSplit = strOptString.split("[-,]");
            for (int i3 = 0; i3 < strArrSplit.length; i3 += 2) {
                int i4 = Integer.parseInt(strArrSplit[i3]);
                int i5 = Integer.parseInt(strArrSplit[i3 + 1]);
                if (i2 >= i4 && i2 <= i5) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean c(JSONObject jSONObject) {
        return jSONObject == null || e.a() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return b(jSONObject) && a(jSONObject.optJSONArray("device_requirements")) && c(jSONObject);
    }

    public static boolean a(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean zA = false;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("package_names");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("version_allow");
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("version_block");
                String strOptString2 = jSONObjectOptJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                for (String strI : strOptString.split(",")) {
                    if (BaseConstants.SCHEME_MARKET.equals(strI)) {
                        strI = d.i();
                    }
                    g.a aVarB = b(strI);
                    if (aVarB != null && !(zA = a(jSONArrayOptJSONArray, jSONArrayOptJSONArray2, strOptString2, aVarB))) {
                        return false;
                    }
                }
            }
        }
        return zA;
    }

    private static boolean b(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i2).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static g.a b(String str) {
        HashMap<String, g.a> map = a;
        if (map.containsKey(str)) {
            g.a aVar = map.get(str);
            if (aVar != null) {
                return aVar;
            }
            return null;
        }
        g.a aVarB = g.b(str);
        map.put(str, aVarB);
        if (aVarB != null) {
            return aVarB;
        }
        return null;
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull g.a aVar) {
        String strG = aVar.g();
        int iF = aVar.f();
        String str2 = iF + "_" + strG;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("[-,]");
                for (int i2 = 0; i2 < strArrSplit.length; i2 += 2) {
                    int i3 = Integer.parseInt(strArrSplit[i2]);
                    int i4 = Integer.parseInt(strArrSplit[i2 + 1]);
                    if (iF >= i3 && iF <= i4) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (b(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !b(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static g.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                g.a aVarB = b(str);
                if (aVarB != null) {
                    return aVarB;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean a(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String strOptString = jSONObject.optString(ai.az);
            try {
                String strA = c.a(jSONObject.optString("az"), strOptString);
                String strA2 = c.a(jSONObject.optString("ba"), strOptString);
                Field declaredField = ContextWrapper.class.getDeclaredField(strA);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(strA2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
